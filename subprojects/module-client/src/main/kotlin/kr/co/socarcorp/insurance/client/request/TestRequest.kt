package kr.co.socarcorp.insurance.client.request

import kr.co.socarcorp.insurance.client.param
import org.springframework.util.LinkedMultiValueMap

data class TestRequest(
    val param1: Int,
    val param2: String
) {

    fun toRequestBody(): LinkedMultiValueMap<String, Any> {
        return param().apply {
            add("param1", param1.toString())
            add("param2", param2)
        }
    }
}
