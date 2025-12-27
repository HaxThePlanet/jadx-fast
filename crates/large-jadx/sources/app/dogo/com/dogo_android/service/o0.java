package app.dogo.com.dogo_android.service;

import android.net.Uri;
import app.dogo.com.dogo_android.k.p;
import i.b.c0;
import i.b.e0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class o0 implements e0 {

    public final /* synthetic */ l2 a;
    public final /* synthetic */ p b;
    public final /* synthetic */ Uri c;
    public /* synthetic */ o0(l2 l2Var, p pVar, Uri uri) {
        super();
        this.a = l2Var;
        this.b = pVar;
        this.c = uri;
    }

    public final void a(c0 c0Var) {
        FireBaseStorageService.q(this.a, this.b, this.c, c0Var);
    }
}
