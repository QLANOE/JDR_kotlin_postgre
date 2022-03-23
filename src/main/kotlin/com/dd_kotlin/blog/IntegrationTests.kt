package com.dd_kotlin.blog

import org.junit.Assert.*
import org.junit.Test
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `Assert blog page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/")
        assertEquals(entity.statusCode, HttpStatus.OK)
        entity.body?.contains("<h1>Blog</h1>")?.let { assert(it) }
    }

    @Test
    fun `Assert article page title, content and status code`() {
        println(">> Assert article page title, content and status code")
        val title = "Reactor Aluminium has landed"
        val entity = restTemplate.getForEntity<String>("/article/${title.toSlug()}")
        assertEquals(entity.statusCode, HttpStatus.OK)
        entity.body?.contains(title)?.let { assert(it) }
        entity.body?.contains(title)?.let { assert(it) }
        entity.body?.contains("dolor sit amet")?.let { assert(it) }
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }

}