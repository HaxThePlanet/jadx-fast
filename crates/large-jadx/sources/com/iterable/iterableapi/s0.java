package com.iterable.iterableapi;

import android.content.Context;
import android.os.AsyncTask;

/* compiled from: IterablePushRegistrationTask.java */
/* loaded from: classes2.dex */
class s0 extends AsyncTask<r0, Void, Void> {

    r0 a;

    static class a {

        String a;
        a(String str) {
            super();
            this.a = str;
        }
    }

    static class b {

        static s0.b.a a;
        static {
            s0.b.a = new s0.b.a();
        }

        static String a() {
            return s0.b.a.a();
        }

        static String b(Context context) {
            return s0.b.a.b(context);
        }
    }
    s0() {
        super();
    }

    @Override // android.os.AsyncTask
    protected Void a(r0... r0VarArr) {
        Object obj = r0VarArr[0];
        this.a = obj;
        if (obj.c == null) {
            str7 = "IterablePush";
            str = "iterablePushRegistrationData has not been specified";
            j0.c(str7, str);
        } else {
            com.iterable.iterableapi.s0.a aVar2 = b();
            if (aVar2 != null) {
                if (this.a.e == r0.a.ENABLE) {
                    j.p.F(r0Var2.a, r0Var2.b, r0Var2.d, r0Var2.c, aVar2.a, j.s().o());
                } else {
                    if (this.a.e == r0.a.DISABLE) {
                        j.p.k(r0Var3.a, r0Var3.b, r0Var3.d, aVar2.a, null, null);
                    }
                }
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    s0.a b() {
        final String str2 = "IterablePushRegistration";
        final int i = 0;
        try {
            Context context = j.p.t();
            if (context == null) {
                j0.c(str2, "MainActivity Context is null");
                return i;
            }
            if (s0.b.b(context) == null) {
                j0.c(str2, "Could not find gcm_defaultSenderId, please check that Firebase SDK is set up properly");
                return i;
            }
        } catch (Exception e) {
            j0.d(str, "Exception while retrieving the device token: check that firebase is added to the build dependencies", e);
            return obj;
        }
        return new s0.a(s0.b.a());
    }
}
