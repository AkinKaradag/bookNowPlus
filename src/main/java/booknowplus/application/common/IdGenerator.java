package booknowplus.application.common;

import org.springframework.stereotype.Component;

@Component
public interface IdGenerator {
    Long generateId();
}
