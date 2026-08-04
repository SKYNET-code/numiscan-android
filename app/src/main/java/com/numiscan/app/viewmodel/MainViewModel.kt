package com.numiscan.app.viewmodel


import androidx.lifecycle.ViewModel
import com.numiscan.app.data.model.*
import com.numiscan.app.domain.DuplicateFilter
import com.numiscan.app.domain.NumberExtractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {


    private val extractor = NumberExtractor()

    private val duplicateFilter = DuplicateFilter()



    private val _inputText =
        MutableStateFlow("")


    val inputText =
        _inputText.asStateFlow()



    private val _allResults =
        MutableStateFlow<List<ExtractedNumber>>(emptyList())



    private val _results =
        MutableStateFlow<List<ExtractedNumber>>(emptyList())


    val results =
        _results.asStateFlow()



    private var currentFilter =
        FilterType.ALL



    private var searchQuery =
        ""



    fun updateText(value: String) {

        _inputText.value = value

    }



    fun extractNumbers(
        removeDuplicates: Boolean = true
    ) {


        var data =
            extractor.extract(
                _inputText.value
            )


        if(removeDuplicates){

            data =
                duplicateFilter.removeDuplicates(data)

        }


        _allResults.value = data


        applyFilters()

    }



    fun search(value:String){

        searchQuery = value

        applyFilters()

    }



    fun setFilter(
        filter: FilterType
    ){

        currentFilter = filter

        applyFilters()

    }



    fun sort(
        type: SortType
    ){


        _results.value =
            when(type){

                SortType.NEWEST ->
                    _results.value.sortedByDescending {
                        it.timestamp
                    }


                SortType.OLDEST ->
                    _results.value.sortedBy {
                        it.timestamp
                    }


                SortType.ASCENDING ->
                    _results.value.sortedBy {
                        it.value
                    }


                SortType.DESCENDING ->
                    _results.value.sortedByDescending {
                        it.value
                    }

            }

    }



    private fun applyFilters(){


        var filtered =
            _allResults.value



        if(currentFilter != FilterType.ALL){

            filtered =
                filtered.filter {

                    it.type.name ==
                            currentFilter.name

                }

        }



        if(searchQuery.isNotBlank()){

            filtered =
                filtered.filter {

                    it.value.contains(
                        searchQuery
                    )

                }

        }



        _results.value = filtered

    }



    fun toggleSelection(
        item: ExtractedNumber
    ){

        _results.value =
            _results.value.map {


                if(it.value == item.value){

                    it.copy(
                        selected = !it.selected
                    )

                }
                else {

                    it

                }

            }

    }



    fun selectAll(){

        _results.value =
            _results.value.map {

                it.copy(
                    selected = true
                )

            }

    }



    fun clearSelection(){

        _results.value =
            _results.value.map {

                it.copy(
                    selected = false
                )

            }

    }



    fun clearText(){

        _inputText.value = ""

    }



    fun clearResults(){

        _allResults.value = emptyList()

        _results.value = emptyList()

    }

}
