package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;
import kotlinx.coroutines.channels.q;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class t0 implements g {

    public final /* synthetic */ q a;
    public /* synthetic */ t0(q qVar) {
        super();
        this.a = qVar;
    }

    public final void onSuccess(Object object) {
        l2.d.m(this.a, object);
    }
}
