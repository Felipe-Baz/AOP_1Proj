package br.com.baz.annotation

import io.micronaut.aop.Around
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.*

@MustBeDocumented
@Retention(RUNTIME)
@Target(
    CLASS,
    FILE,
    FUNCTION,
    PROPERTY_GETTER,
    PROPERTY_SETTER
)
@Around
annotation class ErrorHandler