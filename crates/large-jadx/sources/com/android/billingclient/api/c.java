package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes.dex */
public abstract class c {

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static final class b {

        private volatile boolean a;
        private final Context b;
        private volatile k c;
        public c a() {
            if (this.b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            } else {
                if (this.c == null) {
                    throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                } else {
                    if (!this.a) {
                        throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
                    } else {
                        return new d(null, this.a, this.b, this.c);
                    }
                }
            }
        }

        /* synthetic */ b(Context context, g0 g0Var) {
            super();
            this.b = context;
        }

        public c.b b() {
            this.a = true;
            return this;
        }

        public c.b c(k kVar) {
            this.c = kVar;
            return this;
        }
    }
    public static c.b g(Context context) {
        return new c.b(context, null);
    }

    public abstract void a(a aVar, b bVar);

    public abstract void b(h hVar, i iVar);

    public abstract void c();

    public abstract g d(String str);

    public abstract boolean e();

    public abstract g f(Activity activity, f fVar);

    public abstract void h(String str, j jVar);

    @Deprecated
    public abstract Purchase.a i(String str);

    public abstract void j(l lVar, m mVar);

    public abstract void k(e eVar);
}
