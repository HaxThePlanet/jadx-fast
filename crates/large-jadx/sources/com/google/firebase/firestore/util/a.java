package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class a implements c {

    public final k a;
    public a(k k) {
        super();
        this.a = k;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return AsyncQueue.a(this.a, j);
    }
}
