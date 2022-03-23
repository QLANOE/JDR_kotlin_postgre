package com.dd_kotlin.blog

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne


@Entity
class Acteur(
        var login: String,
        var firstname: String,
        var lastname: String,
        var description: String? = null,
        @Id @GeneratedValue var id: Long? = null)

@Entity
class Dice(
        var face: Int,
        @Id @GeneratedValue var id: Long? = null)

@Entity
class Jet(
        @OneToOne
        var dice: Dice,
        var nombreDe: Int,
        var bonus: Int,
        @Id @GeneratedValue var id: Long? = null)