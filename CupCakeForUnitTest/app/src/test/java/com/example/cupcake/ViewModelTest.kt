package com.example.cupcake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ViewModelTest {

        // To specify that LiveData objects should not call the main thread we need to
    // provide a specific test rule any time we are testing a LiveData object.
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        // To add observeForever for observing changes of values of LiveData object.
        // observeForever method requires a lambda expression, but that can be left empty.
        viewModel.quantity.observeForever {}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {}
        viewModel.setQuantity(12)
        assertEquals("$27.00", viewModel.price.value)
    }
}