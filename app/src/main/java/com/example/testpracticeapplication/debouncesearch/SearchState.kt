package com.example.testpracticeapplication.debouncesearch

data class SearchState (val isLoadin: Boolean = false,
    val query : String = "",
    val list: List<String> = emptyList(),
    val error: String? = null
){
}