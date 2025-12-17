package app.dogo.com.dogo_android.d.d;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class g implements c {

    public final app.dogo.com.dogo_android.d.d.p a;
    public final String b;
    public g(app.dogo.com.dogo_android.d.d.p p, String string2) {
        super();
        this.a = p;
        this.b = string2;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return p.I(this.a, this.b, j);
    }
}
