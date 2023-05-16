import io.ktor.utils.io.core.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

fun Database.asCloseable() = Closeable {
    TransactionManager.closeAndUnregister(this)
}

object MyTable : Table(name = "MyTable") {
    val name = varchar("name", 255)
}

suspend fun getDbEntities() {
    newSuspendedTransaction(Dispatchers.IO) {
        MyTable.selectAll().map {
            it[MyTable.name]
        }
    }
}