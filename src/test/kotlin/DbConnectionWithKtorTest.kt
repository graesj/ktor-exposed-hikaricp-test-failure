import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.client.request.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.routing.*
import io.ktor.server.testing.*
import org.jetbrains.exposed.sql.Database
import org.junit.jupiter.api.Test

class DbConnectionWithKtorTest : MSSQLTestContainersBase() {
    @Test
    fun test1() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test2() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test3() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test4() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test5() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test6() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test7() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test8() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test9() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    @Test
    fun test10() = testApplication {
        environment {
            config = MapApplicationConfig("ktor.environment" to "test")
        }
        application {
            myModule()
        }
        repeat(100) {
            client.get("/")
        }
    }

    private fun Application.myModule() {
        val hikari = HikariDataSource(HikariConfig().apply {
            jdbcUrl = MSSQLTestContainersBase.dbJdbcUrl
            username = MSSQLTestContainersBase.dbUsername
            password = MSSQLTestContainersBase.dbPassword
        })
        val db = Database.connect(hikari)
        environment.monitor.subscribe(ApplicationStopPreparing) {
            hikari.close()
            db.asCloseable().close()
        }
        routing {
            get("/") {
                getDbEntities()
            }
        }
    }

}


