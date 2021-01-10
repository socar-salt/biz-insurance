package kr.co.socarcorp.insurance.client

import kr.co.socarcorp.insurance.client.request.TestRequest
import kr.co.socarcorp.insurance.client.response.CommonResponse

interface ClientServiceTemplate {
    fun test(body: TestRequest): CommonResponse
}
