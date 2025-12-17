package app.dogo.com.dogo_android.j;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;
import m.a.c.l.a;

/* loaded from: classes.dex */
public final class a implements IdTokenListener {

    public final a a;
    public a(a a) {
        super();
        this.a = a;
    }

    @Override // com.google.firebase.auth.internal.IdTokenListener
    public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
        d.a.t.g(this.a, internalTokenResult);
    }
}
