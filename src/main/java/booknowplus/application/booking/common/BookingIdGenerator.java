package booknowplus.application.booking.common;

import booknowplus.application.common.IdGenerator;

import java.util.concurrent.atomic.AtomicLong;

public class BookingIdGenerator implements IdGenerator {

    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public Long generateId() {
        return counter.getAndIncrement();
    }

}
