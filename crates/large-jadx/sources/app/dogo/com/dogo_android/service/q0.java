package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class q0 implements f {

    public static final /* synthetic */ q0 a = new q0();

    private /* synthetic */ q0() {
        super();
    }

    public final void onFailure(Exception exc) {
        FireBaseStorageService.e(exc);
    }
}
