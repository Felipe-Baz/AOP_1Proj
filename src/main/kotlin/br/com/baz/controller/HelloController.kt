package br.com.baz.controller

import br.com.baz.Request
import br.com.baz.annotation.ErrorHandler
import br.com.baz.annotation.Log
import io.micronaut.http.HttpRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller
@ErrorHandler
@Log
class HelloController {

    @Get
    fun hello(
        httpRequest: HttpRequest<*>
    ) = "hello"

    @Post
    fun helloPost(
        httpRequest: HttpRequest<*>,
        @Body request: Request
    ) = "hello"

    @Post("/error")
    fun testError(
        httpRequest: HttpRequest<*>,
        @Body request: Request
    ) {
        throw IllegalArgumentException("Error Test")
    }

}