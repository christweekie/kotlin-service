package org.lucidant.kotlinservice.configuration

import org.springframework.stereotype.Component

@Component
class ApplicationConfiguration {
//    @Bean
//    fun runner(employeeRepository: EmployeeRepository, db: DatabaseClient) = ApplicationRunner {
//        val initDb = db.execute {
//            """ CREATE TABLE employee (
//                    id SERIAL PRIMARY KEY,
//                    first_name VARCHAR(255) NOT NULL,
//                    last_name VARCHAR(255) NOT NULL
//                );
//            """
//        }
//
//        val stream = Stream.of(
//            Employee(null, "Petros", "S")
//        )
//
//        val saveAll = employeeRepository.saveAll(Flux.fromStream(stream))
//
//        initDb // initialize the database
//            .then()
//            .thenMany(saveAll) // then save our Sample Employees
//            .subscribe() // execute
//    }
}
