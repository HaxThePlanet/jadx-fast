package com.google.firebase.storage;

import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class e implements g {

    public final i a;
    public final k b;
    public final b c;
    public e(i i, k k2, b b3) {
        super();
        this.a = i;
        this.b = k2;
        this.c = b3;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        StorageTask.o(this.a, this.b, this.c, (StorageTask.ProvideError)object);
    }
}
