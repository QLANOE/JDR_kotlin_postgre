package com.dd_kotlin.blog.models

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Acteur {

    @Column
    var login: String = ""

    @Column
    var firstname: String = ""

    @Column
    var lastname: String = ""

    @Column
    var password: String = ""
        get() = field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    @Column(unique = true)
    var mail: String = ""

    @Id
    @GeneratedValue
    var id: Long? = null

}