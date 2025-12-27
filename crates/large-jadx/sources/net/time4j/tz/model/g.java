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

/* compiled from: GregorianTimezoneRule.java */
@c("iso8601")
/* loaded from: classes3.dex */
public class g extends d implements Serializable {

    private static final long serialVersionUID = 1L;
    private final transient byte w;
    protected g(c0 c0Var, int i, i iVar, int i2) {
        super(i, iVar, i2);
        this.w = (byte)c0Var.getValue();
    }

    @Override // net.time4j.tz.model.d
    public final g0 b(int i) {
        return (g0)j(i).M(c(), f.DAYS);
    }

    @Override // net.time4j.tz.model.d
    protected int h(long j) {
        return b.i(b.l(j));
    }

    @Override // net.time4j.tz.model.d
    protected int i(a aVar) {
        return aVar.m();
    }

    @Override // net.time4j.tz.model.d
    byte k() {
        return this.w;
    }

    @Override // net.time4j.tz.model.d
    protected boolean l(g gVar) {
        boolean equals;
        h0 h0Var;
        long l;
        boolean z = false;
        if (f().equals(gVar.f())) {
            long l2 = c();
            l = gVar.c();
            if (l2 == l) {
                if (d() == gVar.d()) {
                    if (e() == gVar.e()) {
                        gVar = this.w == gVar.w ? 1 : 0;
                    }
                }
            }
        }
        return (this.w == gVar.w ? 1 : 0);
    }

    @Override // net.time4j.tz.model.d
    protected String a() {
        return "iso8601";
    }

    @Override // net.time4j.tz.model.d
    protected g0 j(int i) {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }
}
