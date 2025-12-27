package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a1 implements e {

    public final /* synthetic */ m2.b a;
    public final /* synthetic */ g b;
    public /* synthetic */ a1(m2.b bVar, g gVar) {
        super();
        this.a = bVar;
        this.b = gVar;
    }

    public final void onComplete(j jVar) {
        FirestoreService_FirestorePager.b(this.a, this.b, jVar);
    }
}
