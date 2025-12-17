package net.time4j.tz.model;

import java.io.Serializable;
import net.time4j.c0;
import net.time4j.engine.i0;
import net.time4j.f;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.g0;
import net.time4j.g1.c;
import net.time4j.h0;

/* loaded from: classes3.dex */
@c("iso8601")
public class g extends net.time4j.tz.model.d implements Serializable {

    private static final long serialVersionUID = 1L;
    private final transient byte w;
    protected g(c0 c0, int i2, net.time4j.tz.model.i i3, int i4) {
        super(i2, i3, i4);
        this.w = (byte)obj1;
    }

    @Override // net.time4j.tz.model.d
    protected String a() {
        return "iso8601";
    }

    @Override // net.time4j.tz.model.d
    public final g0 b(int i) {
        return (g0)j(i).M(c(), obj1);
    }

    @Override // net.time4j.tz.model.d
    protected int h(long l) {
        return b.i(b.l(l));
    }

    @Override // net.time4j.tz.model.d
    protected int i(a a) {
        return a.m();
    }

    @Override // net.time4j.tz.model.d
    protected g0 j(int i) {
        throw 0;
    }

    @Override // net.time4j.tz.model.d
    byte k() {
        return this.w;
    }

    @Override // net.time4j.tz.model.d
    protected boolean l(net.time4j.tz.model.g g) {
        boolean equals;
        h0 h0Var;
        long l;
        int obj5;
        if (f().equals(g.f()) && Long.compare(l2, l) == 0 && d() == g.d() && e() == g.e() && this.w == g.w) {
            if (Long.compare(l2, l) == 0) {
                if (d() == g.d()) {
                    if (e() == g.e()) {
                        obj5 = this.w == g.w ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj5;
    }
}
