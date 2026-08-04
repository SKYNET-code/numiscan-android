package com.numiscan.app.viewmodel

import androidx.lifecycle.ViewModel
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.FilterType
import com.numiscan.app.data.model.SortType
import com.numiscan.app.utils.NumberExtractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _inputText = MutableStateFlow("")
    val inputText = _inputText.asStateFlow()

    private val _allResults =
        MutableStateFlow<List<ExtractedNumber>>(emptyList())

    private val _results =
        MutableStateFlow<List<ExtractedNumber>>(emptyList())

    val results = _results.asStateFlow()

    private var currentFilter = FilterType.ALL
    private var searchQuery = ""

    fun updateText(value: String) {
        _inputText.value = value
    }

    fun extractNumbers(removeDuplicates: Boolean = true) {

        var list = NumberExtractor.extract(_inputText.value)

        if (removeDuplicates) {
            list = list.distinctBy { it.value }
        }

        _allResults.value = list

        applyFilters()
    }

    fun search(value: String) {
        searchQuery = value
        applyFilters()
    }

    fun setFilter(filter: FilterType) {
        currentFilter = filter
        applyFilters()
    }

    fun sort(type: SortType) {

        _results.value =
            when (type) {

                SortType.ASCENDING ->
                    _results.value.sortedBy { it.value }

                SortType.DESCENDING ->
                    _results.value.sortedByDescending { it.value }

                SortType.NEWEST ->
                    _results.value

                SortType.OLDEST ->
                    _results.value
            }
    }

    private fun applyFilters() {

        var list = _allResults.value

        if (currentFilter != FilterType.ALL) {
            list =
                list.filter {
                    it.type.name == currentFilter.name
                }
        }

        if (searchQuery.isNotBlank()) {
            list =
                list.filter {
                    it.value.contains(
                        searchQuery,
                        ignoreCase = true
                    )
                }
        }

        _results.value = list
    }

    fun toggleSelection(item: ExtractedNumber) {

        _allResults.value =
            _allResults.value.map {

                if (it.value == item.value)
                    it.copy(selected = !it.selected)
                else
                    it
            }

        applyFilters()
    }

    fun selectAll() {

        _allResults.value =
            _allResults.value.map {
                it.copy(selected = true)
            }

        applyFilters()
    }

    fun clearSelection() {

        _allResults.value =
            _allResults.value.map {
                it.copy(selected = false)
            }

        applyFilters()
    }

    fun clearText() {
        _inputText.value = ""
    }

    fun clearResults() {

        _allResults.value = emptyList()
        _results.value = emptyList()
    }
}
