package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;
import i.b.c0;

/* loaded from: classes.dex */
public final class l0 implements g {

    public final c0 a;
    public l0(c0 c0) {
        super();
        this.a = c0;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        l2.i(this.a, (Uri)object);
    }
}
