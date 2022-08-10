package br.com.baz.interceptor

import br.com.baz.annotation.Log
import br.com.baz.utils.JsonHandler
import com.google.gson.Gson
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import io.micronaut.http.HttpRequest
import jakarta.inject.Inject
import jakarta.inject.Singleton


// Define como Singleton
@Singleton
// Gera o bean do interceptor Log atravez da classe
@InterceptorBean(Log::class)
// Intercepta chamadas do tipo <Any, Any>
class LogInterceptor: MethodInterceptor<Any, Any> {

    @Inject
    lateinit var jsonHandler: JsonHandler

    // Intercept fun
    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        // Entre os parametros imprime os headers
        for (param in context.parameterValues) {
            if (param is HttpRequest<*>) {
                println("_________HEADERS_________")
                param.headers.forEach{
                    println("${it.key} ==> ${it.value}")
                }
                println("_________URI_________")
                println(param.uri)
                println("_________METHOD_________")
                println(param.method)
            } else {
                println("_________BODY_________")
            }
        }
        println("_________END_________")
        return context.proceed()

    }

}