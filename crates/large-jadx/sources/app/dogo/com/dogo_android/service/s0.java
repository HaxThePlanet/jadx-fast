package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;
import kotlinx.coroutines.channels.q;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class s0 implements f {

    public final /* synthetic */ q a;
    public /* synthetic */ s0(q qVar) {
        super();
        this.a = qVar;
    }

    public final void onFailure(Exception exc) {
        l2.d.f(this.a, exc);
    }
}
