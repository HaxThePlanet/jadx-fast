package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class u0 implements f {

    public static final /* synthetic */ u0 a = new u0();

    private /* synthetic */ u0() {
        super();
    }

    public final void onFailure(Exception exc) {
        FirestoreService.k0(exc);
    }
}
