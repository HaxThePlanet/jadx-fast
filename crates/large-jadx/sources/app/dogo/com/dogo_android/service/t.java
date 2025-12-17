package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.f;
import i.b.c;

/* loaded from: classes.dex */
public final class t implements f {

    public final c a;
    public t(c c) {
        super();
        this.a = c;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        h2.W(this.a, exception);
    }
}
