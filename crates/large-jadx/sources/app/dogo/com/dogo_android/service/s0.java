package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;
import kotlinx.coroutines.channels.q;

/* loaded from: classes.dex */
public final class s0 implements f {

    public final q a;
    public s0(q q) {
        super();
        this.a = q;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        l2.d.o(this.a, exception);
    }
}
