package net.time4j.calendar.t;

import net.time4j.engine.u;

/* loaded from: classes3.dex */
public class f<T extends net.time4j.engine.q<T>>  extends net.time4j.calendar.t.d<Integer, T> {

    private static final long serialVersionUID = -4975173343610190782L;
    private final transient int c;
    private final transient int v;
    private final transient u<T> w;
    private final transient u<T> x;
    public f(String string, Class<T> class2, int i3, int i4, char c5) {
        super(string, class2, c5, string.startsWith("DAY_OF_"));
        this.c = i3;
        this.v = i4;
    }

    public f(String string, Class<T> class2, int i3, int i4, char c5, u<T> u6, u<T> u7) {
        super(string, class2, c5, 0);
        this.c = i3;
        this.v = i4;
        this.w = u6;
        this.x = u7;
    }

    @Override // net.time4j.calendar.t.d
    public Object getDefaultMaximum() {
        return l();
    }

    @Override // net.time4j.calendar.t.d
    public Object getDefaultMinimum() {
        return n();
    }

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
}
