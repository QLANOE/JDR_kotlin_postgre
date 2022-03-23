package com.dd_kotlin.blog.controller

import com.dd_kotlin.blog.dtos.RegisterDTO
import com.dd_kotlin.blog.models.Acteur
import com.dd_kotlin.blog.services.ActeurService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/acteur")
class ActeurController(private val acteurService: ActeurService) {

    @PostMapping("/register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<Acteur> {
        val acteur = Acteur()
        acteur.firstname = body.name
        acteur.password = body.password
        acteur.mail = body.email

        return ResponseEntity.ok(this.acteurService.save(acteur))
    }

}
