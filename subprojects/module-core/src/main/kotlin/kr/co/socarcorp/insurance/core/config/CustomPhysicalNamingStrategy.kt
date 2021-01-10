package kr.co.socarcorp.insurance.core.config

import java.io.Serializable
import kr.co.socarcorp.insurance.core.extension.camel2snake
import kr.co.socarcorp.insurance.core.extension.isCamelcase
import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategy
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment

class CustomPhysicalNamingStrategy : PhysicalNamingStrategy, Serializable {
    override fun toPhysicalCatalogName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return this.apply(name)
    }

    override fun toPhysicalSchemaName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return this.apply(name)
    }

    override fun toPhysicalTableName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return this.apply(name)
    }

    override fun toPhysicalSequenceName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return this.apply(name)
    }

    override fun toPhysicalColumnName(name: Identifier?, jdbcEnvironment: JdbcEnvironment?): Identifier? {
        return this.apply(name)
    }

    private fun apply(name: Identifier?): Identifier? {
        if (name == null) {
            return null
        }

        return if (name.text.isCamelcase()) Identifier.toIdentifier(name.text.camel2snake(), name.isQuoted) else name
    }
}
