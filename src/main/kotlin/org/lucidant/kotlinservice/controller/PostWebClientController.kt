package org.lucidant.kotlinservice.controller

import org.lucidant.kotlinservice.model.Post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/webclient")
class PostWebClientController {

    @Autowired
    private lateinit var webClient: WebClient

    @GetMapping("/post/{id}")
    fun getPost(@PathVariable id: String): ResponseEntity<Mono<Post>> {
        val postMono = webClient.get()
            .uri("/posts/$id")
            .retrieve()
            .bodyToMono(Post::class.java)
        return ResponseEntity<Mono<Post>>(postMono, HttpStatus.OK)
    }

    @PostMapping(path = ["/post"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createPost(@RequestBody post: Post): Mono<Post> {
        return webClient.post()
            .uri("/posts")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(BodyInserters.fromValue(post))
            .retrieve()
            .bodyToMono(Post::class.java)
    }

    @PutMapping(path = ["/v1/post"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updatePost(@RequestBody post: Post): Mono<Post> {
        return webClient.put()
            .uri("/posts/1")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(BodyInserters.fromValue(post))
            .retrieve()
            .bodyToMono(Post::class.java)
    }

    @DeleteMapping(path = ["/v1/post/{id}"])
    fun deletePost(@PathVariable id: String): Mono<Post?>? {
        return webClient.delete()
            .uri("/posts/$id")
            .retrieve()
            .bodyToMono(Post::class.java)
    }

}
