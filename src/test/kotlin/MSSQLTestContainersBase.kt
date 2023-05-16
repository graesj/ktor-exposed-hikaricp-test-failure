import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.testcontainers.containers.MSSQLServerContainer
import org.testcontainers.utility.DockerImageName
import java.sql.DriverManager

abstract class MSSQLTestContainersBase {
    companion object {
        lateinit var dbUsername: String
        lateinit var dbPassword: String
        lateinit var dbJdbcUrl: String
        private val mssqlContainer: MSSQLServerContainer<*> = MSSQLServerContainer(
            DockerImageName.parse("mcr.microsoft.com/mssql/server:2019-latest")
        ).acceptLicense()

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            mssqlContainer.start()
            dbUsername = mssqlContainer.username
            dbPassword = mssqlContainer.password
            dbJdbcUrl = mssqlContainer.jdbcUrl
            val statement = DriverManager
                .getConnection(mssqlContainer.jdbcUrl, mssqlContainer.username, mssqlContainer.password)
                .createStatement()
            statement.execute("CREATE TABLE MyTable(name VARCHAR(255))")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            mssqlContainer.stop()
        }
    }
}




