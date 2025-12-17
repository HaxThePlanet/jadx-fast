package com.iterable.iterableapi;

import android.os.AsyncTask;

/* loaded from: classes2.dex */
class o0 extends AsyncTask<com.iterable.iterableapi.l0, Void, Void> {
    @Override // android.os.AsyncTask
    protected Void a(com.iterable.iterableapi.l0... l0Arr) {
        int i;
        Object obj;
        Object obj3;
        i = 0;
        if (l0Arr != null && l0Arr[i] != null) {
            i = 0;
            if (l0Arr[i] != null) {
                obj3 = l0Arr[i];
                n0.g(obj3.W, obj3);
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object[] objectArr) {
        return a((l0[])objectArr);
    }
}
