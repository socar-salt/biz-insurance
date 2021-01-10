package kr.co.socarcorp.insurance.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

fun param(): LinkedMultiValueMap<String, Any> {
    return LinkedMultiValueMap<String, Any>()
}

@Throws(HttpServerErrorException::class)
inline fun <reified T> doPost(
    path: String,
    objectMapper: ObjectMapper,
    body: LinkedMultiValueMap<String, Any> = param(),
    token: String? = null,
    isMultipartFormData: Boolean = false
): T {
    val headers = HttpHeaders().apply {
        contentType = if (isMultipartFormData) MediaType.MULTIPART_FORM_DATA else MediaType.APPLICATION_FORM_URLENCODED
        accept = listOf(MediaType.APPLICATION_JSON)
        setBearerAuth(token ?: "")
    }

    val response = RestTemplate().postForEntity(
        path,
        HttpEntity(body, headers),
        String::class.java
    )

    return objectMapper.readValue(response.body!!)
}

@Throws(HttpServerErrorException::class)
inline fun <reified T> doGet(
    path: String,
    objectMapper: ObjectMapper,
    params: LinkedMultiValueMap<String, Any> = param(),
    token: String? = null
): T {
    val headers = HttpHeaders().apply {
        accept = listOf(MediaType.APPLICATION_JSON)
        setBearerAuth(token ?: "")
    }

    val queryString = UriComponentsBuilder
        .fromHttpUrl(path)
        .apply { params.entries.forEach { queryParam(it.key, it.value) } }
        .build()
        .toUriString()

    val response = RestTemplate().exchange(
        queryString,
        HttpMethod.GET,
        HttpEntity<String>(headers),
        String()::class.java
    )

    return objectMapper.readValue(response.body!!)
}
