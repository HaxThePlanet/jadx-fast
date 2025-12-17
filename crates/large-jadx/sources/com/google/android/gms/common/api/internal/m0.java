package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.c;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* loaded from: classes2.dex */
public final class m0<O extends com.google.android.gms.common.api.a.d>  extends com.google.android.gms.common.api.internal.a0 {

    @NotOnlyInitialized
    private final c<O> b;
    public m0(c<O> c) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.b = c;
    }

    public final <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.i, T extends com.google.android.gms.common.api.internal.e<R, A>> T a(T t) {
        return this.b.doRead(t);
    }

    public final <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e<? extends com.google.android.gms.common.api.i, A>> T b(T t) {
        return this.b.doWrite(t);
    }

    @Override // com.google.android.gms.common.api.internal.a0
    public final Looper d() {
        return this.b.getLooper();
    }
}
