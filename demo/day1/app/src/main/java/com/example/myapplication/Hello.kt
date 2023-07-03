package com.example.myapplication

import java.lang.RuntimeException

class Hello {
    fun divide(a: Int, b: Int):Int {
        if(b == 0) {
            throw RuntimeException("Error :: Divide by zero")
        }
        return a/b
    }
}