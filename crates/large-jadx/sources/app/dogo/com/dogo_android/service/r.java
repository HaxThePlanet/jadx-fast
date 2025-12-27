package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import i.b.c0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class r implements e {

    public final /* synthetic */ c0 a;
    public /* synthetic */ r(c0 c0Var) {
        super();
        this.a = c0Var;
    }

    public final void onComplete(j jVar) {
        AuthService.r0(this.a, jVar);
    }
}
