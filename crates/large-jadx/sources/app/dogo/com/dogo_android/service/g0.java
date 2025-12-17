package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class g0 implements c {

    public final String a;
    public g0(String string) {
        super();
        this.a = string;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return i2.f(this.a, j);
    }
}
