package com.skydoves.balloon;

import kotlin.d;
import kotlin.d0.c.a;
import kotlin.d0.d.h;
import kotlin.d0.d.n;

/* compiled from: Balloon.kt */
/* loaded from: classes2.dex */
final class i implements p, h {

    private final /* synthetic */ a a;
    i(a aVar) {
        super();
        this.a = aVar;
    }

    public d a() {
        return this.a;
    }

    public final /* synthetic */ void b() {
        n.e(this.a.invoke(), "invoke(...)");
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z;
        boolean z3 = true;
        z = object instanceof p;
        if (object instanceof p) {
            z = object instanceof h;
            if (object instanceof h) {
                object = n.b(this.a, object.a()) ? 1 : 0;
            }
        }
        return (n.b(this.a, object.a()) ? 1 : 0);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }
}
