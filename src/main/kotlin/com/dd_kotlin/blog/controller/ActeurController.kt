package com.dd_kotlin.blog.controller

import com.dd_kotlin.blog.dtos.LoginDTO
import com.dd_kotlin.blog.dtos.Message
import com.dd_kotlin.blog.dtos.RegisterDTO
import com.dd_kotlin.blog.models.Acteur
import com.dd_kotlin.blog.services.ActeurService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@CrossOrigin
@RestController
@RequestMapping("/api/acteur")
class ActeurController(private val acteurService: ActeurService) {

    @PostMapping("register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<Acteur> {
        val acteur = Acteur()
        acteur.firstname = body.name
        acteur.password = body.password
        acteur.mail = body.email

        return ResponseEntity.ok(this.acteurService.save(acteur))
    }

    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        val user = this.acteurService.findByEmail(body.email)
            ?: return ResponseEntity.badRequest().body(Message("user not found"))

        if (!user.comparePassword(body.password)) {
            return ResponseEntity.badRequest().body(Message("invalid password"))
        }

        var issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 3600 * 1000 * 24))
            .signWith(SignatureAlgorithm.HS512, "poivre").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("sucess"))

    }

    @GetMapping("acteur")
    fun acteur(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {

        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body(Message("Non Identifié"))
            }

            val body = Jwts.parser().setSigningKey("poivre").parseClaimsJws(jwt).body

            return ResponseEntity.ok(this.acteurService.getByID(body.issuer.toLong()))

        } catch (e: Exception) {
            return ResponseEntity.status(401).body(Message("Non Identifié"))
        }

    }

    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0

        response.addCookie(cookie)

        return ResponseEntity.ok("success")
    }

}
