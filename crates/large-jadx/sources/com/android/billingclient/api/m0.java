package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public final class m0 implements Callable {

    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;
    public final /* synthetic */ m v;
    public /* synthetic */ m0(d dVar, String str, List list, String str2, m mVar) {
        super();
        this.a = dVar;
        this.b = str;
        this.c = list;
        this.v = mVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final String str2 = null;
        this.a.J(this.b, this.c, str2, this.v);
        return str2;
    }
}
