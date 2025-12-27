package com.skydoves.balloon;

import android.view.View;
import kotlin.d;
import kotlin.d0.c.l;
import kotlin.d0.d.h;
import kotlin.d0.d.n;

/* compiled from: Balloon.kt */
/* loaded from: classes2.dex */
final class j implements q, h {

    private final /* synthetic */ l a;
    j(l lVar) {
        super();
        this.a = lVar;
    }

    public d a() {
        return this.a;
    }

    public final /* synthetic */ void b(View view) {
        n.f(view, "contentView");
        n.e(this.a.invoke(view), "invoke(...)");
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z;
        boolean z3 = true;
        z = object instanceof q;
        if (object instanceof q) {
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
