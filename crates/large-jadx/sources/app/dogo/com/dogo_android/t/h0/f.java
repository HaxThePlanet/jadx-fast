package app.dogo.com.dogo_android.t.h0;

import com.google.android.play.core.tasks.b;

/* loaded from: classes.dex */
public final class f implements b {

    public final app.dogo.com.dogo_android.t.h0.l a;
    public f(app.dogo.com.dogo_android.t.h0.l l) {
        super();
        this.a = l;
    }

    @Override // com.google.android.play.core.tasks.b
    public final void onFailure(Exception exception) {
        l.z(this.a, exception);
    }
}
