package hu.cubix.cubixschool.web;

import hu.cubix.cubixschool.service.MessageService;
import hu.cubix.cubixschool.ws.CourseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    @RequestMapping("/api/message/{courseId}")
    @PutMapping
    public ResponseEntity<Void> courseChat(@PathVariable Long courseId,
                                           @RequestParam String message,
                                           @RequestParam String senderName) {

        messagingTemplate.convertAndSend("/topic/courseChat/" + courseId,
                new CourseMessage(senderName, message));

        return ResponseEntity.ok().build();
    }
}

