package com.dd_kotlin.blog

import com.dd_kotlin.blog.models.Acteur
import com.dd_kotlin.blog.repositories.ActeurRepository
import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val acteurRepository: ActeurRepository
) {


    @Test
    fun `When findByLogin then return User`() {
        val acteur = Acteur()
        acteur.mail = "mail"
        acteur.password = "password"
        acteur.firstname = "firstname"
        acteur.login = "login"
        acteur.lastname = "lastname"
        entityManager.persist(acteur)
        entityManager.flush()
        val user = acteurRepository.findByLogin(acteur.login)
        Assert.assertEquals(user, acteur)
    }
}