package br.com.baz.utils

import jakarta.inject.Singleton

@Singleton
class JsonHandler {
    fun objToJsonString(obj: Any): String {
        val objString = obj.toString().substringAfter("(").substringBefore(")")
        println(objString)
        return objString
    }
}