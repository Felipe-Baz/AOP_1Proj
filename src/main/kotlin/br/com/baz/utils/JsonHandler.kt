package br.com.baz.utils

import jakarta.inject.Singleton

@Singleton
class JsonHandler {
    fun objToJsonString(obj: Any): String {
        var objString = obj.toString().substringAfter("(").substringBefore(")")
        objString = "{ $objString }".replace("=", ": ")
        return objString
    }
}