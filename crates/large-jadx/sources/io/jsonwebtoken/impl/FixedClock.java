package io.jsonwebtoken.impl;

import io.jsonwebtoken.Clock;
import java.util.Date;

/* compiled from: FixedClock.java */
/* loaded from: classes3.dex */
public class FixedClock implements Clock {

    private final Date now;
    public FixedClock() {
        this(new Date());
    }

    public Date now() {
        return this.now;
    }

    public FixedClock(Date date) {
        super();
        this.now = date;
    }
}
