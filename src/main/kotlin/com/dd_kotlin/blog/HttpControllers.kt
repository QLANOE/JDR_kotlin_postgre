package com.dd_kotlin.blog

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@CrossOrigin
@RestController
@RequestMapping("/api/acteur")
class ActeurController(private val repository: ActeurRepository) {


    @GetMapping("/")
    fun findAll() = repository.findAll()

    @PostMapping("/addActeur")
    fun putActeur(@RequestBody acteur: Acteur) = repository.save(acteur)

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) =
            repository.findByLogin(login)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")
}

@CrossOrigin
@RestController
@RequestMapping("/api/dice")
class DeController(private val repository: DiceRepository) {


    @GetMapping("/")
    fun findAll() = repository.findAll()

    @PostMapping("/addDice")
    fun putDe(@RequestBody dice: Dice) = repository.save(dice)

    @GetMapping("/{face}")
    fun findOne(@PathVariable face: Int) =
            repository.findByFace(face)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This de does not exist")
}