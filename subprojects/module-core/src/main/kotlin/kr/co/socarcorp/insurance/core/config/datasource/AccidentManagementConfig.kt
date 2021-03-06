package kr.co.socarcorp.insurance.core.config.datasource

import javax.persistence.EntityManagerFactory
import javax.sql.DataSource
import kr.co.socarcorp.insurance.core.config.CustomJpaConfig
import kr.co.socarcorp.insurance.core.config.CustomJpaProperties
import kr.co.socarcorp.insurance.core.config.datasource.AccidentManagementConfig.Companion.ENTITY_MANAGER_FACTORY_BEAN_NAME
import kr.co.socarcorp.insurance.core.config.datasource.AccidentManagementConfig.Companion.PACKAGE_NAME
import kr.co.socarcorp.insurance.core.config.datasource.AccidentManagementConfig.Companion.TRANSACTION_MANAGER_BEAN_NAME
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EnableJpaRepositories(
    basePackages = [PACKAGE_NAME],
    entityManagerFactoryRef = ENTITY_MANAGER_FACTORY_BEAN_NAME,
    transactionManagerRef = TRANSACTION_MANAGER_BEAN_NAME
)
class AccidentManagementConfig : CustomJpaConfig() {

    companion object {
        private const val UNIT_NAME = "accidentmanagement"
        private const val JPA_PROPERTIES_BEAN_NAME = "${UNIT_NAME}JpaProperties"
        private const val DATA_SOURCE_PROPERTIES = "$UNIT_NAME.datasource"
        private const val DATA_SOURCE_PROPERTIES_BEAN_NAME = "${UNIT_NAME}DataSourceProperties"
        private const val DATA_SOURCE_BEAN_NAME = "${UNIT_NAME}DataSource"
        const val PACKAGE_NAME = "kr.co.socarcorp.insurance.domain.$UNIT_NAME"
        const val ENTITY_MANAGER_FACTORY_BEAN_NAME = "${UNIT_NAME}EntityManagerFactory"
        const val TRANSACTION_MANAGER_BEAN_NAME = "${UNIT_NAME}TransactionManager"
    }

    @Bean(JPA_PROPERTIES_BEAN_NAME)
    @ConfigurationProperties(UNIT_NAME)
    override fun jpaProperties(): CustomJpaProperties {
        return super.jpaProperties()
    }

    @Bean(DATA_SOURCE_PROPERTIES_BEAN_NAME)
    @ConfigurationProperties(DATA_SOURCE_PROPERTIES)
    override fun dataSourceProperties(): DataSourceProperties {
        return super.dataSourceProperties()
    }

    @Bean(DATA_SOURCE_BEAN_NAME)
    override fun dataSource(
        @Qualifier(DATA_SOURCE_PROPERTIES_BEAN_NAME)
        dataSourceProperties: DataSourceProperties
    ): DataSource {
        return super.dataSource(dataSourceProperties)
    }

    @Bean(ENTITY_MANAGER_FACTORY_BEAN_NAME)
    override fun entityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier(DATA_SOURCE_BEAN_NAME) dataSource: DataSource,
        @Qualifier(JPA_PROPERTIES_BEAN_NAME) jpaProperties: CustomJpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        return super.entityManagerFactory(builder, dataSource, jpaProperties)
    }

    @Bean(TRANSACTION_MANAGER_BEAN_NAME)
    override fun transactionManager(
        @Qualifier(ENTITY_MANAGER_FACTORY_BEAN_NAME)
        entityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return super.transactionManager(entityManagerFactory)
    }
}
