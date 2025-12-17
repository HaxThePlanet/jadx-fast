package app.dogo.com.dogo_android.d.b.z;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class c implements e {

    public final String a;
    public final app.dogo.com.dogo_android.d.b.z.j b;
    public c(String string, app.dogo.com.dogo_android.d.b.z.j j2) {
        super();
        this.a = string;
        this.b = j2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        j.m(this.a, this.b, j);
    }
}
