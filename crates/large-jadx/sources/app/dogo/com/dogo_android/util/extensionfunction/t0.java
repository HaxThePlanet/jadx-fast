package app.dogo.com.dogo_android.util.h0;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.DocumentReference;
import i.b.c0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class t0 implements e {

    public final /* synthetic */ Class a;
    public final /* synthetic */ c0 b;
    public final /* synthetic */ DocumentReference c;
    public /* synthetic */ t0(Class cls, c0 c0Var, DocumentReference documentReference) {
        super();
        this.a = cls;
        this.b = c0Var;
        this.c = documentReference;
    }

    public final void onComplete(j jVar) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.n(this.a, this.b, this.c, jVar);
    }
}
