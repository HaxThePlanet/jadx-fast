package net.time4j.calendar.t;

import net.time4j.engine.q;
import net.time4j.engine.u;

/* compiled from: StdIntegerDateElement.java */
/* loaded from: classes3.dex */
public class f<T extends q<T>> extends d<Integer, T> {

    private static final long serialVersionUID = -4975173343610190782L;
    private final transient int c;
    private final transient int v;
    private final transient u<T> w;
    private final transient u<T> x;
    public f(String str, Class<T> cls, int i, int i2, char c) {
        super(str, cls, c, str.startsWith("DAY_OF_"));
        this.c = i;
        this.v = i2;
    }

    @Override // net.time4j.calendar.t.d
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override // net.time4j.calendar.t.d
    public Integer l() {
        return Integer.valueOf(this.v);
    }

    @Override // net.time4j.calendar.t.d
    public Integer n() {
        return Integer.valueOf(this.c);
    }

    public f(String str, Class<T> cls, int i, int i2, char c, u<T> uVar, u<T> uVar2) {
        super(str, cls, c, false);
        this.c = i;
        this.v = i2;
        this.w = uVar;
        this.x = uVar2;
    }
}
