package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class v0 implements f {

    public static final /* synthetic */ v0 a = new v0();

    private /* synthetic */ v0() {
        super();
    }

    public final void onFailure(Exception exc) {
        FirestoreService.l(exc);
    }
}
