package com.iterable.iterableapi;

import android.os.AsyncTask;

/* compiled from: IterableFirebaseMessagingService.java */
/* loaded from: classes2.dex */
class o0 extends AsyncTask<l0, Void, Void> {
    o0() {
        super();
    }

    @Override // android.os.AsyncTask
    protected Void a(l0... l0VarArr) {
        if (l0VarArr != null) {
            int i = 0;
            if (l0VarArr[i] != null) {
                Object obj2 = l0VarArr[i];
                n0.g(obj2.W, obj2);
            }
        }
        return null;
    }
}
