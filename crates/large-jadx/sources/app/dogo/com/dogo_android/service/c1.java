package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c1 implements g {

    public final /* synthetic */ m2 a;
    public /* synthetic */ c1(m2 m2Var) {
        super();
        this.a = m2Var;
    }

    public final void onSuccess(Object object) {
        FirestoreService.m0(this.a, object);
    }
}
