package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.a1;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
final class t extends i {

    final Collection b;
    final Collection c;
    final o v;
    final com.google.android.play.core.splitinstall.x w;
    t(com.google.android.play.core.splitinstall.x x, o o2, Collection collection3, Collection collection4, o o5) {
        this.w = x;
        this.b = collection3;
        this.c = collection4;
        this.v = o5;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        java.util.ArrayList list = x.f(this.b);
        list.addAll(x.e(this.c));
        v vVar = new v(this.w, this.v);
        (a1)xVar.b.e().e2(x.d(this.w), list, x.a(), vVar);
    }
}
