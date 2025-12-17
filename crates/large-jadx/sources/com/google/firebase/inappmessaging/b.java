package com.google.firebase.inappmessaging;

import com.google.android.gms.tasks.g;

/* loaded from: classes2.dex */
public final class b implements g {

    public static final com.google.firebase.inappmessaging.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        FirebaseInAppMessaging.b((String)object);
    }
}
