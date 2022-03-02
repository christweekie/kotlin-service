package org.lucidant.kotlinservice.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.lucidant.kotlinservice.configuration.SampleProperties
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@Api(value = "Ping")
@RestController
class PingController(val sampleProperties: SampleProperties) {


  @ApiOperation(value = "Endpoint to test status of server")
  @CrossOrigin
  @RequestMapping(value = ["/ping"], method = [RequestMethod.GET], produces = ["text/plain"])
  fun ping(): String {
    val sam = sampleProperties.title
    return "pong $sam"
  }
}
