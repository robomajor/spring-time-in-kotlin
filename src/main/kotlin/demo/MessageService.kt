package demo

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class MessageService(val db: JdbcTemplate) {

    fun findMessages(): List<Message> = db.query("select * from messages") { rs, _ ->
        Message(rs.getString("id"), rs.getString("text"))
    }

    fun findMessagesById(id: String): List<Message> = db.query("select * from messages where id = ?", { rs, _ ->
        Message(rs.getString("id"), rs.getString("text"))
    }, id)

    fun post(message: Message) {
        db.update("insert into messages values ( ?, ? )", message.id ?: message.text.uuid(), message.text)
    }
}