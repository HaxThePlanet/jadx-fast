package com.google.firebase.storage;

import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class c implements g {

    public final k a;
    public c(k k) {
        super();
        this.a = k;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.c(object);
    }
}
