package com.iterable.iterableapi;

import android.content.Context;
import android.os.AsyncTask;

/* loaded from: classes2.dex */
class s0 extends AsyncTask<com.iterable.iterableapi.r0, Void, Void> {

    com.iterable.iterableapi.r0 a;

    static class a {

        String a;
        a(String string) {
            super();
            this.a = string;
        }
    }

    static class b {

        static com.iterable.iterableapi.s0.b.a a;
        static {
            s0.b.a aVar = new s0.b.a();
            s0.b.a = aVar;
        }

        static String a() {
            return s0.b.a.a();
        }

        static String b(Context context) {
            return s0.b.a.b(context);
        }
    }
    @Override // android.os.AsyncTask
    protected Void a(com.iterable.iterableapi.r0... r0Arr) {
        String str3;
        com.iterable.iterableapi.r0.a dISABLE;
        com.iterable.iterableapi.j jVar;
        String str6;
        String str2;
        String str4;
        String str5;
        String str;
        java.util.HashMap map;
        Object obj10;
        obj10 = r0Arr[0];
        this.a = obj10;
        if (obj10.c != null) {
            obj10 = b();
            if (obj10 != null) {
                str3 = r0Var.e;
                if (str3 == r0.a.ENABLE) {
                    str3 = this.a;
                    j.p.F(str3.a, str3.b, str3.d, str3.c, obj10.a, j.s().o());
                } else {
                    if (str3 == r0.a.DISABLE) {
                        str3 = this.a;
                        j.p.k(str3.a, str3.b, str3.d, obj10.a, 0, 0);
                    }
                }
            }
        } else {
            j0.c("IterablePush", "iterablePushRegistrationData has not been specified");
        }
        return null;
    }

    @Override // android.os.AsyncTask
    com.iterable.iterableapi.s0.a b() {
        final String str = "IterablePushRegistration";
        final int i = 0;
        Context context = j.p.t();
        if (context == null) {
            j0.c(str, "MainActivity Context is null");
            return i;
        }
        if (s0.b.b(context) == null) {
            try {
                j0.c(str, "Could not find gcm_defaultSenderId, please check that Firebase SDK is set up properly");
                return i;
                s0.a aVar = new s0.a(s0.b.a());
                return aVar;
                j0.d(obj0, "Exception while retrieving the device token: check that firebase is added to the build dependencies", th);
                return obj1;
            }
        }
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object[] objectArr) {
        return a((r0[])objectArr);
    }
}
