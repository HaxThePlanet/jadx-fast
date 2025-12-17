package com.facebook.e0.t;

import android.content.Context;
import com.facebook.internal.g0.i.a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "()V", "BILLING_CLIENT_PURCHASE_NAME", "", "logPurchase", "", "startIapLogging", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    public static final com.facebook.e0.t.b a;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        public static final com.facebook.e0.t.b.a a;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            b.a(b.a);
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class b implements Runnable {

        public static final com.facebook.e0.t.b.b a;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            b.a(b.a);
        }
    }
    static {
        b bVar = new b();
        b.a = bVar;
    }

    public static final void a(com.facebook.e0.t.b b) {
        if (a.d(b.class)) {
        }
        b.b();
    }

    private final void b() {
        if (a.d(this)) {
        }
        com.facebook.e0.t.c.b bVar = c.x;
        e.e(bVar.d(), bVar.e());
        bVar.d().clear();
    }

    public static final void c(Context context) {
        com.facebook.e0.t.c.b bVar;
        String str;
        if (a.d(b.class)) {
        }
        n.f(context, "context");
        if (h.a("com.android.billingclient.api.Purchase") == null) {
        }
        bVar = c.x;
        final com.facebook.e0.t.c obj3 = bVar.c(context);
        if (obj3 != null && bVar.f().get()) {
            if (bVar.f().get()) {
                str = "inapp";
                if (e.d()) {
                    obj3.p(str, b.a.a);
                } else {
                    obj3.o(str, b.b.a);
                }
            }
        }
        try {
            a.b(context, obj0);
        }
    }
}
