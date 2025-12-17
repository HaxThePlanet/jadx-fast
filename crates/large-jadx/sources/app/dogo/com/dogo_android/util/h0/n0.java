package app.dogo.com.dogo_android.util.h0;

import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.Source;
import i.b.c0;
import i.b.e0;

/* loaded from: classes.dex */
public final class n0 implements e0 {

    public final Query a;
    public final Source b;
    public final Class c;
    public n0(Query query, Source source2, Class class3) {
        super();
        this.a = query;
        this.b = source2;
        this.c = class3;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        j1.T(this.a, this.b, this.c, c0);
    }
}
