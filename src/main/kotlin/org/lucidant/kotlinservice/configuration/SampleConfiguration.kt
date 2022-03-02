package org.lucidant.kotlinservice.configuration

import org.lucidant.kotlinservice.model.jpa.Article
import org.lucidant.kotlinservice.model.jpa.User
import org.lucidant.kotlinservice.repo.ArticleRepository
import org.lucidant.kotlinservice.repo.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SampleConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository) = ApplicationRunner {

        val smaldini = userRepository.save(User("smaldini", "Stéphane", "Maldini"))
        articleRepository.save(
            Article(
            title = "Reactor Bismuth is out",
            headline = "Lorem ipsum",
            content = "dolor sit amet",
            author = smaldini
        )
        )
        articleRepository.save(Article(
            title = "Reactor Aluminium has landed",
            headline = "Lorem ipsum",
            content = "dolor sit amet",
            author = smaldini
        ))
    }
}
