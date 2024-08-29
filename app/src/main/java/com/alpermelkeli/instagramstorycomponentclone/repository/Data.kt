package com.alpermelkeli.instagramstorycomponentclone.repository

const val user1Id = "user1"
const val user2Id = "user2"

val storiesList = listOf(
    Pair(user1Id, listOf(Story("profilePhoto","user1","image"),
        Story("profilePhoto","user1","image")
    )),
    Pair(
        user2Id, listOf(Story("profilePhoto","user1","image"),
        Story("profilePhoto","user1","image")
    )),
)