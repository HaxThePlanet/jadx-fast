package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class j0 implements Callable {

    public final /* synthetic */ d a;
    public final /* synthetic */ h b;
    public final /* synthetic */ i c;
    public /* synthetic */ j0(d dVar, h hVar, i iVar) {
        super();
        this.a = dVar;
        this.b = hVar;
        this.c = iVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.a.I(this.b, this.c);
        return null;
    }
}
