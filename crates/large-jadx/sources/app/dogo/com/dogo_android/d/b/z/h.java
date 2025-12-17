package app.dogo.com.dogo_android.d.b.z;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class h implements e {

    public final String a;
    public final app.dogo.com.dogo_android.d.b.z.l b;
    public h(String string, app.dogo.com.dogo_android.d.b.z.l l2) {
        super();
        this.a = string;
        this.b = l2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        l.A(this.a, this.b, j);
    }
}
