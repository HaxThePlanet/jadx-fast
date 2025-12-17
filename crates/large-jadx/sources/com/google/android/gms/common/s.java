package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class s implements Callable {

    private final boolean a;
    private final String b;
    private final com.google.android.gms.common.x c;
    s(boolean z, String string2, com.google.android.gms.common.x x3) {
        super();
        this.a = z;
        this.b = string2;
        this.c = x3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return b0.e(this.a, this.b, this.c);
    }
}
