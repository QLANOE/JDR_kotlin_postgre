package com.dd_kotlin.blog

import org.springframework.data.repository.CrudRepository




interface DiceRepository : CrudRepository<Dice, Long> {
    fun findByFace(face: Int): Dice?
    fun findAllByOrderByFace(): Iterable<Dice>
}

interface JetRepository : CrudRepository<Jet, Long> {
    fun findByDice(de: Long): Jet?
}
