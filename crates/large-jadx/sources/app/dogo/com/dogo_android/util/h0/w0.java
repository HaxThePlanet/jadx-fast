package app.dogo.com.dogo_android.util.h0;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.Query;
import i.b.c0;

/* loaded from: classes.dex */
public final class w0 implements e {

    public final Class a;
    public final c0 b;
    public final Query c;
    public w0(Class class, c0 c02, Query query3) {
        super();
        this.a = class;
        this.b = c02;
        this.c = query3;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        j1.c0(this.a, this.b, this.c, j);
    }
}
