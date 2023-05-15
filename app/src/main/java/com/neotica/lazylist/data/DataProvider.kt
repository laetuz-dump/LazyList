package com.neotica.lazylist.data

import com.neotica.lazylist.data.model.PersonEntity
import com.neotica.dicoding2.R

object DataProvider {

    val person =
        PersonEntity(
            id = 1,
            title = "Kanye",
            sex = "Male",
            age = 45,
            description = "Kanye is a musician, rapper, hiphop artist, and also a fashion designer.",
            personImageId = R.drawable.p1
        )

    val personList = listOf(
        person,
        PersonEntity(
            id = 2,
            title = "Jay Z",
            sex = "Male",
            age = 52,
            description = "Jay Z is a music mogul.",
            personImageId = R.drawable.p2
        ),
        PersonEntity(
            id = 3,
            title = "Drake",
            sex = "Male",
            age = 35,
            description = "Started his career as a child actor and rise to his success as a musician, rapper, and performer.",
            personImageId = R.drawable.p3
        ),
        PersonEntity(
            id = 4,
            title = "Donald Glover",
            sex = "Male",
            age = 39,
            description = "It is an alter ego of Donald Glover, a performer, stand up comedian, actor, " +
                    "and musician.",
            personImageId = R.drawable.p4
        ),
        PersonEntity(
            id = 5,
            title = "Ryo Fukui",
            sex = "Male",
            age = 67,
            description = "A japanese jazz pianist, most notable for his work on Scenery. He was 67 at the /" +
                    "time of his death in Sapporo.",
            personImageId = R.drawable.p5
        ),
        PersonEntity(
            id = 6,
            title = "Bill Evans",
            sex = "Male",
            age = 51,
            description = "A jazz pianist who popularized 'cool jazz', used to work with Miles " +
                    "Davis and released his notable work with Bill Evans Trio, " +
                    "he was 51 at the time of his death.",
            personImageId = R.drawable.p6
        ),
        PersonEntity(
            id = 7,
            title = "Aaliyah",
            sex = "Female",
            age = 22,
            description = "An RNB singer who found fame with her debut 'Age Ain't nothin but a Number' " +
                    "worked with singer R. Kelly. She was only 22 years old " +
                    "by the time she died in an airplane crash back in August 24, 2001.",
            personImageId = R.drawable.p7
        ),
        PersonEntity(
            id = 8,
            title = "The Weeknd",
            sex = "Male",
            age = 32,
            description = "First known from his Trilogy mixtape, had his commercial breaktrough when he " +
                    "released Beauty Behind the Madness",
            personImageId = R.drawable.p8
        ),
        PersonEntity(
            id = 9,
            title = "Mac Miller",
            sex = "Male",
            age = 26,
            description = "Malcolm James McCormick, known professionally as Mac Miller, was an American rapper and record producer. " +
                    "Miller began his career in Pittsburgh's hip hop scene in 2007, at the age of fifteen." +
                    "He was 26 at the time of his death.",
            personImageId = R.drawable.p10
        ),
        PersonEntity(
            id = 10,
            title = "Rihanna",
            sex = "Female",
            age = 34,
            description = "Robyn Rihanna Fenty NH is a Barbadian singer, actress, and businesswoman. Born in Saint Michael and raised in Bridgetown, Barbados, Rihanna auditioned for American record producer Evan Rogers who invited her to the United States to record demo tapes.",
                    personImageId = R.drawable.p9
        ),
        PersonEntity(
            id = 11,
            title = "David Bowie",
            sex = "Male",
            age = 69,
            description = "David Robert Jones, known professionally as David Bowie, " +
                    "was an English singer-songwriter and actor. A leading figure in the music industry, " +
                    "he is regarded as one of the most influential musicians of the 20th century. " +
                    "Bowie was acclaimed by critics and musicians, particularly for his innovative work " +
                    "during the 1970s. At age 69, he was found death at his Lafayette Street home in New York City, " +
                    "having suffered from liver cancer for 18 months. He died two days after the release of his twenty-sixth and final studio album, " +
                    "Blackstar, which coincided with his 69th birthday.",
            personImageId = R.drawable.p11
        ),
    )
}
