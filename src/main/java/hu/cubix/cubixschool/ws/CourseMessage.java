package hu.cubix.cubixschool.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.messaging.core.MessagePostProcessor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor

public class CourseMessage {

    private String sender;
    private String message;


}
