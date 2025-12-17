package app.dogo.com.dogo_android.d.a;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class d implements e {

    public final app.dogo.com.dogo_android.d.a.l a;
    public d(app.dogo.com.dogo_android.d.a.l l) {
        super();
        this.a = l;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        l.h2(this.a, j);
    }
}
