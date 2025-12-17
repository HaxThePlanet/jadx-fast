package app.dogo.com.dogo_android.t.h0;

import com.google.android.play.core.tasks.c;

/* loaded from: classes.dex */
public final class d implements c {

    public final app.dogo.com.dogo_android.t.h0.l a;
    public d(app.dogo.com.dogo_android.t.h0.l l) {
        super();
        this.a = l;
    }

    @Override // com.google.android.play.core.tasks.c
    public final void onSuccess(Object object) {
        l.x(this.a, (Integer)object);
    }
}
