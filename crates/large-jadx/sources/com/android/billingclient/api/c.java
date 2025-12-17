package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class c {

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static final class b {

        private volatile boolean a;
        private final Context b;
        private volatile com.android.billingclient.api.k c;
        b(Context context, com.android.billingclient.api.g0 g02) {
            super();
            this.b = context;
        }

        public com.android.billingclient.api.c a() {
            if (this.b == null) {
            } else {
                if (this.c == null) {
                } else {
                    if (!this.a) {
                    } else {
                        d dVar = new d(0, this.a, this.b, this.c);
                        return dVar;
                    }
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
                    throw illegalArgumentException2;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                throw illegalArgumentException;
            }
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Please provide a valid Context.");
            throw illegalArgumentException3;
        }

        public com.android.billingclient.api.c.b b() {
            this.a = true;
            return this;
        }

        public com.android.billingclient.api.c.b c(com.android.billingclient.api.k k) {
            this.c = k;
            return this;
        }
    }
    public static com.android.billingclient.api.c.b g(Context context) {
        c.b bVar = new c.b(context, 0);
        return bVar;
    }

    public abstract void a(com.android.billingclient.api.a a, com.android.billingclient.api.b b2);

    public abstract void b(com.android.billingclient.api.h h, com.android.billingclient.api.i i2);

    public abstract void c();

    public abstract com.android.billingclient.api.g d(String string);

    public abstract boolean e();

    public abstract com.android.billingclient.api.g f(Activity activity, com.android.billingclient.api.f f2);

    public abstract void h(String string, com.android.billingclient.api.j j2);

    @Deprecated
    public abstract com.android.billingclient.api.Purchase.a i(String string);

    public abstract void j(com.android.billingclient.api.l l, com.android.billingclient.api.m m2);

    public abstract void k(com.android.billingclient.api.e e);
}
