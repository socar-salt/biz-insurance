package kr.co.socarcorp.insurance.client

import kr.co.socarcorp.insurance.client.request.TestRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ClientServiceTest {
    companion object {
        private const val HOST = "https://saltokstra.socar.me/external_accident_insurance"
    }

    private val client = ClientService(HOST)

    @Test
    @DisplayName("test 연동")
    @Disabled
    fun test() {
        val response = client.test(makeTestRequest())
        println(response)
    }

    private fun makeTestRequest(): TestRequest {
        return TestRequest(
            1,
            "test"
        )
    }
}
