package kr.co.socarcorp.insurance.client.response

import com.fasterxml.jackson.annotation.JsonProperty

data class CommonResponse(
    @JsonProperty("result_code")
    val resultCode: ResultCode,
    @JsonProperty("result_message")
    val resultMessage: String,
    val data: Data? = null
) {

    fun isFailed() = resultCode == ResultCode.FAIL

    enum class ResultCode {
        SUCCESS,
        FAIL
    }

    data class Data(
        @JsonProperty("data")
        val insurerReceiptNumber: Any
    )
}
