package org.lucidant.kotlinservice.model.jpa

import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

@Table("employee")
data class Employee(@Id val id: Long?,
                    @Column("first_name") val firstName: String,
                    @Column("last_name") val lastName: String) {
}
