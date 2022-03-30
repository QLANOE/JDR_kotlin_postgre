package com.dd_kotlin.blog.controller

import com.dd_kotlin.blog.dtos.JetDTO
import com.dd_kotlin.blog.dtos.Message
import com.dd_kotlin.blog.services.JetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/jet")
class JetController(private val jetService: JetService) {

    @PostMapping("save")
    fun save(@CookieValue("jwt") @RequestBody body: JetDTO): ResponseEntity<Any> {
        try {
            return ResponseEntity.ok(this.jetService.save(body))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(Message("Non Identifié"))
        }
    }
}