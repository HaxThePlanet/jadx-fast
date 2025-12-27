package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;
import i.b.c0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class n0 implements f {

    public final /* synthetic */ c0 a;
    public /* synthetic */ n0(c0 c0Var) {
        super();
        this.a = c0Var;
    }

    public final void onFailure(Exception exc) {
        FireBaseStorageService.s(this.a, exc);
    }
}
