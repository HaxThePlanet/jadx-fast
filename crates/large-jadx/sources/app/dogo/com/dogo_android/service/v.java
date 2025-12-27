package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;
import i.b.c;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class v implements g {

    public final /* synthetic */ c a;
    public /* synthetic */ v(c cVar) {
        super();
        this.a = cVar;
    }

    public final void onSuccess(Object object) {
        AuthService.j0(this.a, object);
    }
}
