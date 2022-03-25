package com.dd_kotlin.blog.services

import com.dd_kotlin.blog.models.Acteur
import com.dd_kotlin.blog.repositories.ActeurRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ActeurService(private val acteurRepository: ActeurRepository) {

    fun save(acteur: Acteur): Acteur {
        return this.acteurRepository.save(acteur)
    }

    fun findByEmail(email: String): Acteur? {
        return this.acteurRepository.findByMail(email)
    }

    fun getByID(id: Long): Optional<Acteur> {
        return this.acteurRepository.findById(id)
    }
}