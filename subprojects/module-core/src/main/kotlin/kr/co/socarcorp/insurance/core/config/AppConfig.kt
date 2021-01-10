package kr.co.socarcorp.insurance.core.config

import kr.co.socarcorp.insurance.core.config.configurationProperties.ExternalProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(
    ExternalProperties::class
)
class AppConfig
