package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.firebase.storage.StorageReference;

/* loaded from: classes.dex */
public final class m0 implements c {

    public final StorageReference a;
    public m0(StorageReference storageReference) {
        super();
        this.a = storageReference;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return l2.j(this.a, j);
    }
}
