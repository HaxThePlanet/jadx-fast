package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;
import i.b.c;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class t implements f {

    public final /* synthetic */ c a;
    public /* synthetic */ t(c cVar) {
        super();
        this.a = cVar;
    }

    public final void onFailure(Exception exc) {
        AuthService.k0(this.a, exc);
    }
}
