package com.dd_kotlin.blog.repositories

import com.dd_kotlin.blog.Jet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface JetRepository : CrudRepository<Jet, Long> {

}