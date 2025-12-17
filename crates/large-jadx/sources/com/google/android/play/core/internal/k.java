package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.a;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
public final class k implements a {

    public final com.google.android.play.core.internal.t a;
    public final o b;
    public k(com.google.android.play.core.internal.t t, o o2) {
        super();
        this.a = t;
        this.b = o2;
    }

    @Override // com.google.android.play.core.tasks.a
    public final void a(d d) {
        this.a.r(this.b, d);
    }
}
