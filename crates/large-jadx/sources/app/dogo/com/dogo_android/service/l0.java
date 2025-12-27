package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;
import i.b.c0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l0 implements g {

    public final /* synthetic */ c0 a;
    public /* synthetic */ l0(c0 c0Var) {
        super();
        this.a = c0Var;
    }

    public final void onSuccess(Object object) {
        FireBaseStorageService.r(this.a, object);
    }
}
