package kr.co.socarcorp.insurance.client

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kr.co.socarcorp.insurance.client.exception.DefaultException
import kr.co.socarcorp.insurance.client.request.TestRequest
import kr.co.socarcorp.insurance.client.response.CommonResponse
import org.springframework.web.client.HttpServerErrorException

class ClientService(
    private val requestUrl: String
) : ClientServiceTemplate {
    private val objectMapper = jacksonObjectMapper()

    override fun test(body: TestRequest): CommonResponse {
        val response: CommonResponse = try {
            doPost(
                path = "$requestUrl/test",
                objectMapper = objectMapper,
                body = body.toRequestBody()
            )
        } catch (e: HttpServerErrorException) {
            throw DefaultException("연동장애로 실패하였습니다.")
        }

        if (response.isFailed()) {
            throw DefaultException(response.resultMessage)
        }

        return response
    }
}
