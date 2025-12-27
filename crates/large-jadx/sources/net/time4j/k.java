package net.time4j;

import java.io.Serializable;

/* compiled from: DayCycles.java */
/* loaded from: classes3.dex */
public final class k implements Serializable {

    private static final long serialVersionUID = -4124961309622141228L;
    private final long days;
    private final h0 time;
    k(long j, h0 h0Var) {
        super();
        this.days = j;
        this.time = h0Var;
    }

    public long a() {
        return this.days;
    }

    public h0 b() {
        return this.time;
    }
}
