package com.google.firebase.storage;

import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.d;

/* loaded from: classes2.dex */
public final class a implements d {

    public final b a;
    public a(b b) {
        super();
        this.a = b;
    }

    @Override // com.google.android.gms.tasks.d
    public final void onCanceled() {
        this.a.a();
    }
}
