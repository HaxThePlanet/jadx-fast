package io.jsonwebtoken.impl;

import io.jsonwebtoken.Clock;
import java.util.Date;

/* compiled from: DefaultClock.java */
/* loaded from: classes3.dex */
public class DefaultClock implements Clock {

    public static final Clock INSTANCE = new DefaultClock();

    public Date now() {
        return new Date();
    }
}
