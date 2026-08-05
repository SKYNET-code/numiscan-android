package com.numiscan.app.viewmodel

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.data.model.FilterType
import com.numiscan.app.data.model.SortType
import com.numiscan.app.domain.DuplicateFilter
import com.numiscan.app.utils.NumberExtractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val duplicateFilter = DuplicateFilter()

    private val _inputText =
        MutableStateFlow(TextFieldValue(""))

    val inputText = _inputText.asStateFlow()

    private val _allResults =
        MutableStateFlow<List<ExtractedNumber>>(emptyList())

    private val _results =
        MutableStateFlow<List<ExtractedNumber>>(emptyList())

    val results = _results.asStateFlow()

    var currentFilter: FilterType = FilterType.ALL
        private set

    private var searchQuery = ""

    fun updateText(value: TextFieldValue) {

        _inputText.value = value

    }

    fun updateText(text: String) {

        _inputText.value = TextFieldValue(

            text = text,

            selection = TextRange(text.length)

        )

    }

    fun extractNumbers(removeDuplicates: Boolean = true) {

        var data = NumberExtractor.extract(

            _inputText.value.text

        )

        if (removeDuplicates) {

            data = duplicateFilter.removeDuplicates(data)

        }

        _allResults.value = data

        applyFilters()

    }

    fun search(query: String) {

        searchQuery = query

        applyFilters()

    }

    fun setFilter(filter: FilterType) {

        currentFilter = filter

        applyFilters()

    }

    fun sort(type: SortType) {

        _results.value = when (type) {

            SortType.NEWEST -> _results.value

            SortType.OLDEST -> _results.value

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

    private fun applyFilters() {

        var list = _allResults.value

        if (currentFilter != FilterType.ALL) {

            list = list.filter {

                it.type.name == currentFilter.name

            }

        }

        if (searchQuery.isNotBlank()) {

            list = list.filter {

                it.value.contains(

                    searchQuery,

                    ignoreCase = true

                )

            }

        }

        _results.value = list

    }

    fun toggleSelection(item: ExtractedNumber) {

        _results.value = _results.value.map {

            if (it.value == item.value) {

                it.copy(

                    selected = !it.selected

                )

            } else {

                it

            }

        }

    }

    fun selectAll() {

        _results.value =

            _results.value.map {

                it.copy(selected = true)

            }

    }

    fun clearSelection() {

        _results.value =

            _results.value.map {

                it.copy(selected = false)

            }

    }

    fun clearText() {

        _inputText.value = TextFieldValue("")

    }

    fun clearResults() {

        _allResults.value = emptyList()

        _results.value = emptyList()

    }

}
