package com.google.firebase.storage;

import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class k implements e {

    public final com.google.firebase.storage.StorageTask a;
    public final c b;
    public final k c;
    public final b d;
    public k(com.google.firebase.storage.StorageTask storageTask, c c2, k k3, b b4) {
        super();
        this.a = storageTask;
        this.b = c2;
        this.c = k3;
        this.d = b4;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        this.a.d(this.b, this.c, this.d, j);
    }
}
