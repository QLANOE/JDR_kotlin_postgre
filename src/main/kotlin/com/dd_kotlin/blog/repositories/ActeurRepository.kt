package com.dd_kotlin.blog.repositories

import com.dd_kotlin.blog.models.Acteur
import org.springframework.data.repository.CrudRepository

interface ActeurRepository : CrudRepository<Acteur, Long> {
    fun findByLogin(login: String): Acteur?
    fun findAllByOrderByLogin(): Iterable<Acteur>
    fun findByMail(mail: String): Acteur?
}