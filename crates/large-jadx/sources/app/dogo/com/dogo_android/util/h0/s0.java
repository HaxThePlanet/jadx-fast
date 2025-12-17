package app.dogo.com.dogo_android.util.h0;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Source;
import i.b.c0;
import i.b.e0;

/* loaded from: classes.dex */
public final class s0 implements e0 {

    public final DocumentReference a;
    public final Source b;
    public final Class c;
    public s0(DocumentReference documentReference, Source source2, Class class3) {
        super();
        this.a = documentReference;
        this.b = source2;
        this.c = class3;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        j1.Y(this.a, this.b, this.c, c0);
    }
}
