package kr.co.socarcorp.insurance.domain.common

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null

    @LastModifiedBy
    var updatedAt: LocalDateTime? = null
}
