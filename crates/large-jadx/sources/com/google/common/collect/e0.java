package com.google.common.collect;

import com.google.common.base.b;
import com.google.common.base.e;
import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class e0 {

    boolean a;
    int b = -1;
    int c = -1;
    com.google.common.collect.f0.p d;
    com.google.common.collect.f0.p e;
    e<Object> f;
    public e0() {
        super();
        final int i = -1;
    }

    public com.google.common.collect.e0 a(int i) {
        int i3;
        int i2;
        final int i4 = this.c;
        final int i5 = 0;
        i2 = i4 == -1 ? i3 : i5;
        n.w(i2, "concurrency level was already set to %s", i4);
        if (i > 0) {
        } else {
            i3 = i5;
        }
        n.d(i3);
        this.c = i;
        return this;
    }

    int b() {
        int i;
        if (this.c == -1) {
            i = 4;
        }
        return i;
    }

    int c() {
        int i;
        if (this.b == -1) {
            i = 16;
        }
        return i;
    }

    e<Object> d() {
        return (e)j.a(this.f, e().defaultEquivalence());
    }

    com.google.common.collect.f0.p e() {
        return (f0.p)j.a(this.d, f0.p.STRONG);
    }

    com.google.common.collect.f0.p f() {
        return (f0.p)j.a(this.e, f0.p.STRONG);
    }

    public com.google.common.collect.e0 g(int i) {
        int i2;
        int i3;
        final int i4 = this.b;
        final int i5 = 0;
        i3 = i4 == -1 ? i2 : i5;
        n.w(i3, "initial capacity was already set to %s", i4);
        if (i >= 0) {
        } else {
            i2 = i5;
        }
        n.d(i2);
        this.b = i;
        return this;
    }

    com.google.common.collect.e0 h(e<Object> e) {
        int i;
        final e eVar = this.f;
        final int i2 = 1;
        i = eVar == null ? i2 : 0;
        n.x(i, "key equivalence was already set to %s", eVar);
        n.o(e);
        this.f = (e)e;
        this.a = i2;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        if (!this.a) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(c(), 1061158912, b());
            return concurrentHashMap;
        }
        return f0.c(this);
    }

    com.google.common.collect.e0 j(com.google.common.collect.f0.p f0$p) {
        int i;
        com.google.common.collect.f0.p pVar = this.d;
        final int i2 = 1;
        i = pVar == null ? i2 : 0;
        n.x(i, "Key strength was already set to %s", pVar);
        n.o(p);
        this.d = (f0.p)p;
        if (p != f0.p.STRONG) {
            this.a = i2;
        }
        return this;
    }

    com.google.common.collect.e0 k(com.google.common.collect.f0.p f0$p) {
        int i;
        com.google.common.collect.f0.p pVar = this.e;
        final int i2 = 1;
        i = pVar == null ? i2 : 0;
        n.x(i, "Value strength was already set to %s", pVar);
        n.o(p);
        this.e = (f0.p)p;
        if (p != f0.p.STRONG) {
            this.a = i2;
        }
        return this;
    }

    public com.google.common.collect.e0 l() {
        j(f0.p.WEAK);
        return this;
    }

    public String toString() {
        Object pVar2;
        Object pVar;
        Object str;
        int str2;
        String str3;
        j.b bVar = j.c(this);
        int i = this.b;
        str2 = -1;
        if (i != str2) {
            bVar.b("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != str2) {
            bVar.b("concurrencyLevel", i2);
        }
        pVar2 = this.d;
        if (pVar2 != null) {
            bVar.d("keyStrength", b.c(pVar2.toString()));
        }
        pVar = this.e;
        if (pVar != null) {
            bVar.d("valueStrength", b.c(pVar.toString()));
        }
        if (this.f != null) {
            bVar.i("keyEquivalence");
        }
        return bVar.toString();
    }
}
