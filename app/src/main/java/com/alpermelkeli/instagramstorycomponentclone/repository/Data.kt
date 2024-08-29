package com.alpermelkeli.instagramstorycomponentclone.repository

const val user1Id = "user1"
const val user2Id = "user2"
const val test_image_1 = "https://raw.githubusercontent.com/alpermelkeli/InstagramStoryComponentClone/master/tulips.png"
const val test_image_2 = "https://raw.githubusercontent.com/alpermelkeli/InstagramStoryComponentClone/master/HappyFish.jpg"
const val test_image_3 = "https://raw.githubusercontent.com/alpermelkeli/InstagramStoryComponentClone/master/sampleImage.jpg"
// stories list : List<Pair<String,List<Story>>>
val storiesList = listOf(
    Pair(user1Id, listOf(Story(test_image_1,"user1", test_image_1),
        Story(test_image_1,"user1", test_image_3)
    )),
    Pair(
        user2Id, listOf(Story(test_image_2,"user2", test_image_3),
        Story(test_image_2,"user2",test_image_1)
    )),
)