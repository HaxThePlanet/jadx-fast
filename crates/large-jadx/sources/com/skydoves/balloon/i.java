package com.skydoves.balloon;

import kotlin.d;
import kotlin.d0.c.a;
import kotlin.d0.d.h;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
final class i implements com.skydoves.balloon.p, h {

    private final a a;
    i(a a) {
        super();
        this.a = a;
    }

    @Override // com.skydoves.balloon.p
    public d a() {
        return this.a;
    }

    @Override // com.skydoves.balloon.p
    public final void b() {
        n.e(this.a.invoke(), "invoke(...)");
    }

    @Override // com.skydoves.balloon.p
    public boolean equals(Object object) {
        a aVar;
        int obj2;
        if (object instanceof p && object instanceof h && n.b(this.a, (h)object.a())) {
            if (object instanceof h) {
                obj2 = n.b(this.a, (h)object.a()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // com.skydoves.balloon.p
    public int hashCode() {
        return this.a.hashCode();
    }
}
