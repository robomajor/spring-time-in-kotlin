package demo

import org.springframework.web.bind.annotation.*

@RestController
class MessageResource(val service: MessageService) {
    @GetMapping
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> = service.findMessagesById(id)

    @PostMapping
    fun post(@RequestBody message: Message) {
        service.post(message)
    }
}