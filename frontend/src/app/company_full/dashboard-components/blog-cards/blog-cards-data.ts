export interface blogcard {
    title: string,
    subtitle: string,
    subtext: string,
    image: string,
    url:string
}

export const blogcards: blogcard[] = [

    {
        title: 'Infosys Foundation',
        subtitle: 'Supporting underprivileged sections of society, create opportunities and strive towards a more equitable society',
        subtext: 'Infosys Foundation was established to support the less privilaged sections of society,create opportunities and strive towards a more equitable society                ',
        image: 'assets/images/bg/infosys3.jpg',
        url:'https://www.infosys.com/infosys-foundation.html',
    },
    {
        title: 'ESG',
        subtitle: 'To amplify human potential and create the next opportunity for people, businesses and communities',
        subtext: 'In October 2020, we launched our ESG Vision & Ambitions for 2030. Our focus will be steadfast on battling climate change, conserving water and managing waste. On the social front, our emphasis will be on the development of people, especially around digital skilling, improving diversity and inclusion, delivering technology for good and energizing the communities we work in.',
        image: 'assets/images/bg/infosys2.png',
        url:'https://www.infosys.com/about/esg.html'
    },
    // {
    //     title: 'This is simple blog',
    //     subtitle: '2 comments, 1 Like',
    //     subtext: 'This is a wider card with supporting text below as a natural lead-in to additional content.',
    //     image: 'assets/images/bg/bg3.jpg'
    // },
    // {
    //     title: 'This is simple blog',
    //     subtitle: '2 comments, 1 Like',
    //     subtext: 'This is a wider card with supporting text below as a natural lead-in to additional content.',
    //     image: 'assets/images/bg/bg4.jpg'
    // },

] 