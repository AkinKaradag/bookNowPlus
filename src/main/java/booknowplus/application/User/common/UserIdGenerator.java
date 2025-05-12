package booknowplus.application.User.common;

import booknowplus.application.common.IdGenerator;

import java.util.concurrent.atomic.AtomicLong;

public class UserIdGenerator implements IdGenerator {
    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public Long generateId() {
        return counter.getAndIncrement();
    }
}
