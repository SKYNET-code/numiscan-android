package com.numiscan.app.viewmodel

import androidx.lifecycle.ViewModel
import com.numiscan.app.data.model.ExtractedNumber
import com.numiscan.app.domain.DuplicateFilter
import com.numiscan.app.domain.NumberExtractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {


    private val extractor = NumberExtractor()

    private val duplicateFilter = DuplicateFilter()



    private val _results =
        MutableStateFlow<List<ExtractedNumber>>(emptyList())


    val results: StateFlow<List<ExtractedNumber>> =
        _results.asStateFlow()



    private val _inputText =
        MutableStateFlow("")


    val inputText: StateFlow<String> =
        _inputText.asStateFlow()



    fun updateText(value: String) {

        _inputText.value = value

    }



    fun extractNumbers(

        removeDuplicates: Boolean = true

    ) {


        var extracted =
            extractor.extract(
                _inputText.value
            )


        if (removeDuplicates) {

            extracted =
                duplicateFilter.removeDuplicates(
                    extracted
                )

        }


        _results.value = extracted

    }



    fun clearText() {

        _inputText.value = ""

    }



    fun clearResults() {

        _results.value = emptyList()

    }



    fun toggleSelection(

        item: ExtractedNumber

    ) {


        _results.value =
            _results.value.map {


                if (it == item) {

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

                it.copy(
                    selected = true
                )

            }

    }



    fun clearSelection() {


        _results.value =
            _results.value.map {

                it.copy(
                    selected = false
                )

            }

    }

}
