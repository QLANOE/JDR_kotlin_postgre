package com.dd_kotlin.blog.services

import com.dd_kotlin.blog.Jet
import com.dd_kotlin.blog.dtos.JetDTO
import com.dd_kotlin.blog.repositories.JetRepository
import org.springframework.stereotype.Service

@Service
class JetService(private val jetRepository: JetRepository, private val acteurService: ActeurService) {

    fun save(body: JetDTO): Jet {

        val jet = Jet()
        jet.dice = body.dice
        jet.nombreDe = body.nbDe
        jet.bonus = body.bonus

        jet.acteur = acteurService.findByEmail(body.user)!!
        makeJet(jet)
        return this.jetRepository.save(jet)
    }

    fun makeJet(jet: Jet): Jet {
        for (i in 1..jet.nombreDe) {
            val resultatDe = (jet.dice * Math.random()).toInt() + 1
            jet.resultatsDice.add(resultatDe)
        }
        jet.resultatFinal = jet.bonus + jet.resultatsDice.sum()

        return jet
    }
}