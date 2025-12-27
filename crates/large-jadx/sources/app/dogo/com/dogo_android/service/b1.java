package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b1 implements f {

    public static final /* synthetic */ b1 a = new b1();

    private /* synthetic */ b1() {
        super();
    }

    public final void onFailure(Exception exc) {
        FirestoreService.n0(exc);
    }
}
