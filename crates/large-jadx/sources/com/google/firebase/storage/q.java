package com.google.firebase.storage;

import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.k;

/* loaded from: classes2.dex */
public final class q implements f {

    public final k a;
    public q(k k) {
        super();
        this.a = k;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        this.a.b(exception);
    }
}
