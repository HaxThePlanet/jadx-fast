package io.jsonwebtoken.impl;

import io.jsonwebtoken.Clock;
import java.util.Date;

/* loaded from: classes3.dex */
public class FixedClock implements Clock {

    private final Date now;
    public FixedClock() {
        Date date = new Date();
        super(date);
    }

    public FixedClock(Date date) {
        super();
        this.now = date;
    }

    @Override // io.jsonwebtoken.Clock
    public Date now() {
        return this.now;
    }
}
