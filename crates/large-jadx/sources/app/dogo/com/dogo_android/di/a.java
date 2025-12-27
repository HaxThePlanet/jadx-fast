package app.dogo.com.dogo_android.j;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import m.a.c.l.a;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements IdTokenListener {

    public final /* synthetic */ a a;
    public /* synthetic */ a(a aVar) {
        super();
        this.a = aVar;
    }

    public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
        app.dogo.com.dogo_android.di.d.a.t.b(this.a, internalTokenResult);
    }
}
