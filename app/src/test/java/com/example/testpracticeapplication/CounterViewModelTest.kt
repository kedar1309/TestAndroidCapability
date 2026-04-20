package com.example.testpracticeapplication

import com.example.testpracticeapplication.counterpresentation.CounterViewModel
import com.example.testpracticeapplication.counterpresentation.UserIntent
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CounterViewModelTest {

    private lateinit var viewModel: CounterViewModel

    @Before
    fun setup() {
        viewModel = CounterViewModel()
    }

    @Test
    fun `when AddClicked count increases`() = runTest {
        viewModel.processIntent(UserIntent.AddClicked)

        assertEquals(1, viewModel.countval.value.countvalue)
    }

}