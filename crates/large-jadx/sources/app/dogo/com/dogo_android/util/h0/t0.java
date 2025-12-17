package app.dogo.com.dogo_android.util.h0;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.DocumentReference;
import i.b.c0;

/* loaded from: classes.dex */
public final class t0 implements e {

    public final Class a;
    public final c0 b;
    public final DocumentReference c;
    public t0(Class class, c0 c02, DocumentReference documentReference3) {
        super();
        this.a = class;
        this.b = c02;
        this.c = documentReference3;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        j1.Z(this.a, this.b, this.c, j);
    }
}
