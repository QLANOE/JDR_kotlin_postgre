package com.dd_kotlin.blog

import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val acteurRepository: ActeurRepository) {


    @Test
    fun `When findByLogin then return User`() {
        val juergen = Acteur("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()
        val user = acteurRepository.findByLogin(juergen.login)
        Assert.assertEquals(user,  juergen)
    }
}