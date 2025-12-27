package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class i0 implements Callable {

    public final /* synthetic */ d a;
    public final /* synthetic */ a b;
    public final /* synthetic */ b c;
    public /* synthetic */ i0(d dVar, a aVar, b bVar) {
        super();
        this.a = dVar;
        this.b = aVar;
        this.c = bVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.a.H(this.b, this.c);
        return null;
    }
}
