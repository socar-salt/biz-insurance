package kr.co.socarcorp.insurance.core.extension

import org.springframework.http.HttpHeaders

fun HttpHeaders.setBearerAuth(token: String?): HttpHeaders {
    if (token.isNullOrBlank()) return this
    setBearerAuth(token)
    return this
}
