package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import i.b.c0;

/* loaded from: classes.dex */
public final class f0 implements e {

    public final c0 a;
    public final String b;
    public f0(c0 c0, String string2) {
        super();
        this.a = c0;
        this.b = string2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        i2.e(this.a, this.b, j);
    }
}
