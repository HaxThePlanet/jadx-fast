package com.facebook.e0;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u000f", d2 = {"Lcom/facebook/appevents/FlushStatistics;", "", "()V", "numEvents", "", "getNumEvents", "()I", "setNumEvents", "(I)V", "result", "Lcom/facebook/appevents/FlushResult;", "getResult", "()Lcom/facebook/appevents/FlushResult;", "setResult", "(Lcom/facebook/appevents/FlushResult;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class l {

    private int a;
    private com.facebook.e0.k b;
    public l() {
        super();
        this.b = k.SUCCESS;
    }

    public final int a() {
        return this.a;
    }

    public final com.facebook.e0.k b() {
        return this.b;
    }

    public final void c(int i) {
        this.a = i;
    }

    public final void d(com.facebook.e0.k k) {
        n.f(k, "<set-?>");
        this.b = k;
    }
}
