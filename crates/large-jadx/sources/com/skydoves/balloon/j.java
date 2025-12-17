package com.skydoves.balloon;

import android.view.View;
import kotlin.d;
import kotlin.d0.c.l;
import kotlin.d0.d.h;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
final class j implements com.skydoves.balloon.q, h {

    private final l a;
    j(l l) {
        super();
        this.a = l;
    }

    @Override // com.skydoves.balloon.q
    public d a() {
        return this.a;
    }

    @Override // com.skydoves.balloon.q
    public final void b(View view) {
        n.f(view, "contentView");
        n.e(this.a.invoke(view), "invoke(...)");
    }

    @Override // com.skydoves.balloon.q
    public boolean equals(Object object) {
        l lVar;
        int obj2;
        if (object instanceof q && object instanceof h && n.b(this.a, (h)object.a())) {
            if (object instanceof h) {
                obj2 = n.b(this.a, (h)object.a()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // com.skydoves.balloon.q
    public int hashCode() {
        return this.a.hashCode();
    }
}
