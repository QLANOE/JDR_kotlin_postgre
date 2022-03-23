package com.dd_kotlin.blog.services

import com.dd_kotlin.blog.models.Acteur
import com.dd_kotlin.blog.repositories.ActeurRepository
import org.springframework.stereotype.Service

@Service
class ActeurService(private val acteurRepository: ActeurRepository) {

    fun save(acteur: Acteur): Acteur {
        return this.acteurRepository.save(acteur)
    }
}