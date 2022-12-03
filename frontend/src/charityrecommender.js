import { Corpus, Similarity } from "tiny-tfidf"
import { charity_names, charity_missions } from "./testfile.js"

// Replace these with db values
const names = charity_names
const keywords = charity_missions

const corpus = new Corpus(names, keywords)
const similarty = new Similarity(corpus)
const sim = similarty.getDistanceMatrix().matrix

// Returns [[index, score]] sorted by highest score
function getTopCharities(name, cos_sim, top = 5) {
    const index = corpus.getDocumentIdentifiers().findIndex((element) => element === name)
    const similarity_scores = cos_sim.map(
        (score, i) => [i, score[index]]
    )
    
    return similarity_scores.sort((a, b) => b[1] - a[1]).slice(0, top)
}

export function getRecommendations(charity_list_names) {
    const recommendations = charity_list_names.map(
        (res) => getTopCharities(res, sim).map(
            (scores) => scores[0]
        )
    )
    const flattenedRecs = recommendations.flat()
    const filteredRecs = flattenedRecs.filter((item, i) => flattenedRecs.indexOf(item) === i)
    return filteredRecs.map(
        (index) => corpus.getDocumentIdentifiers()[index]
    )
}

// // testing
// const charities = charity_names.map((res) => JSON.parse(JSON.stringify({"charity_name": res})))
// console.log(charities)
// console.log(getRecommendations(charities))