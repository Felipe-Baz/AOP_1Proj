package br.com.baz.interceptor

import br.com.baz.annotation.ErrorHandler
import io.micronaut.aop.InterceptorBean
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import jakarta.inject.Singleton

@Singleton
@InterceptorBean(ErrorHandler::class)
class ExceptionHandlerInterceptor: MethodInterceptor<Any, Any> {

    override fun intercept(context: MethodInvocationContext<Any, Any>): Any? {
        return try {
            context.proceed()
        } catch (e: Exception) {
            println("Handling the exception '${e.javaClass.name}' while processing the call: ${context.targetMethod}")
            null
        }
    }

}