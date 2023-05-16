import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.Database
import org.junit.jupiter.api.Test

class DbConnectionWithoutKtorTest : MSSQLTestContainersBase() {
    @Test
    fun test1() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test2() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test3() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test4() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test5() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test65() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test7() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test8() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test9() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    @Test
    fun test10() = runBlocking {
        val (hikari, db) = initDb()
        repeat(100) { execQuery() }
        shutdownDb(hikari, db)
    }

    private fun initDb(): Pair<HikariDataSource, Database> {
        val hikari = HikariDataSource(HikariConfig().apply {
            jdbcUrl = MSSQLTestContainersBase.dbJdbcUrl
            username = MSSQLTestContainersBase.dbUsername
            password = MSSQLTestContainersBase.dbPassword
        })
        val db = Database.connect(hikari)
        return hikari to db
    }

    private fun shutdownDb(hikari: HikariDataSource, db: Database) {
        hikari.close()
        db.asCloseable().close()
    }

    private suspend fun execQuery() = getDbEntities()
}