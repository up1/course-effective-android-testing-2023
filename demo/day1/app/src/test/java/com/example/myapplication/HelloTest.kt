package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

internal class HelloTest {

    @Test
    fun divide() {
        var h = Hello()
        assertEquals(2, h.divide(4, 2));
    }
}