package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class y0 implements g {

    public final /* synthetic */ m2 a;
    public /* synthetic */ y0(m2 m2Var) {
        super();
        this.a = m2Var;
    }

    public final void onSuccess(Object object) {
        FirestoreService.j0(this.a, object);
    }
}
