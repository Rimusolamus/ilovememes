package cz.rimu.ilovememes.rest.model

data class HotChildrenData(
    val title: String,
    val thumbnail: String,
    val author_fullname: String,
    val created: Int,
    val permalink: String
)