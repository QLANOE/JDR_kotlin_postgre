package com.dd_kotlin.blog

import com.dd_kotlin.blog.models.Acteur
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList


@Entity
class Jet {
    var dice: Int = 2
    var nombreDe: Int = 0
    var bonus: Int = 0
    var date: Date = Date()
    var resultatFinal: Int = 0

    @ElementCollection
    var resultatsDice: MutableCollection<Int> = ArrayList()

    @OneToOne
    var acteur: Acteur = Acteur()

    @Id
    @GeneratedValue
    var id: Long? = null
}