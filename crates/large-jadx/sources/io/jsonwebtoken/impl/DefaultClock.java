package io.jsonwebtoken.impl;

import io.jsonwebtoken.Clock;
import java.util.Date;

/* loaded from: classes3.dex */
public class DefaultClock implements Clock {

    public static final Clock INSTANCE;
    static {
        DefaultClock defaultClock = new DefaultClock();
        DefaultClock.INSTANCE = defaultClock;
    }

    @Override // io.jsonwebtoken.Clock
    public Date now() {
        Date date = new Date();
        return date;
    }
}
