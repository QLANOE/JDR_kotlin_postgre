package com.dd_kotlin.blog

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class HtmlController(private val acteurRepository: ActeurRepository) {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        model["acteurs"] = acteurRepository.findAllByOrderByLogin().map { it.render() }
        return "blog"
    }

    @GetMapping("/acteur/{login}")
    fun acteur(@PathVariable login: String, model: Model): String {
        val acteur = acteurRepository
                .findByLogin(login)
                ?.render()
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")
        model["title"] = acteur.login
        model["acteur"] = acteur
        return "acteur"
    }

    fun Acteur.render() = RenderedActeur(
            login,
            firstname,
            lastname,
            description
    )


    data class RenderedActeur(
            val login: String,
            val firstname: String,
            val lastname: String,
            val description: String?
    )

}