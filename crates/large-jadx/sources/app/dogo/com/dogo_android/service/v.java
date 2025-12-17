package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;
import i.b.c;

/* loaded from: classes.dex */
public final class v implements g {

    public final c a;
    public v(c c) {
        super();
        this.a = c;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        h2.Y(this.a, (Void)object);
    }
}
