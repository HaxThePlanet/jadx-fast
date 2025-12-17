package net.time4j;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class k implements Serializable {

    private static final long serialVersionUID = -4124961309622141228L;
    private final long days;
    private final net.time4j.h0 time;
    k(long l, net.time4j.h0 h02) {
        super();
        this.days = l;
        this.time = obj3;
    }

    @Override // java.io.Serializable
    public long a() {
        return this.days;
    }

    @Override // java.io.Serializable
    public net.time4j.h0 b() {
        return this.time;
    }
}
