package kr.co.socarcorp.insurance.core.config.configurationProperties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("external")
@ConstructorBinding
class ExternalProperties(
    val okstra: String
)
