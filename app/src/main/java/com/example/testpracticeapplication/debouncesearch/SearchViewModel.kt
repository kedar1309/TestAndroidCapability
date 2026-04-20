package com.example.testpracticeapplication.debouncesearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state = _state

    private val _queryvalue = MutableStateFlow("")
    val queryvalue = _queryvalue

    init {
        observeSearch()
    }

    fun onQueryChanges(queryval : String){
        _state.update { it.copy(isLoadin = false, query =queryval ) }
        _queryvalue.value = queryval
    }

    fun observeSearch(){
        viewModelScope.launch {
            _state.debounce(300)
                .filter {it.query.length > 3}
                .distinctUntilChanged()
                .collectLatest{ query ->
                   if(!query.query.isBlank()){
                       search(query.query)
                   }
                }
        }
    }

    fun search(query : String){
        viewModelScope.launch {
            _state.update { it.copy(isLoadin = true, query ="", error =  "" ) }
            delay(1000L)
            if(query == "error"){
                _state.update { it.copy(isLoadin = false, query ="", error =  "Something went wrong" ) }
            }else{
                val fakeResults = List(5) { "$query Result $it" }
                _state.update { it.copy(isLoadin = false, query ="", error = null , list = fakeResults) }
            }
        }

    }

}