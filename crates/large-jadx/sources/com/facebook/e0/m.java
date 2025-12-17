package com.facebook.e0;

import android.content.Context;
import android.os.Bundle;
import com.facebook.a;
import com.facebook.o;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0006\u0010\u0008\u001a\u00020\u0006\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u000f\u0008\u0000\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0014\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0018\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013J.\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013J)\u0010\u001a\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u00020\u00102\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lcom/facebook/appevents/InternalAppEventsLogger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "activityName", "accessToken", "Lcom/facebook/AccessToken;", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "loggerImpl", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "(Lcom/facebook/appevents/AppEventsLoggerImpl;)V", "flush", "", "logChangedSettingsEvent", "parameters", "Landroid/os/Bundle;", "logEvent", "eventName", "valueToSum", "", "logEventFromSE", "buttonText", "logEventImplicitly", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "logPurchaseImplicitly", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class m {

    public static final com.facebook.e0.m.a b;
    private final com.facebook.e0.h a;

    @Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0007J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0008\u0010\u000c\u001a\u00020\rH\u0007J\u0008\u0010\u000e\u001a\u00020\u000fH\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0008H\u0007J\u001c\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u0014H\u0007J\u0012\u0010\u0015\u001a\u00020\u00122\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007¨\u0006\u0018", d2 = {"Lcom/facebook/appevents/InternalAppEventsLogger$Companion;", "", "()V", "createInstance", "Lcom/facebook/appevents/InternalAppEventsLogger;", "context", "Landroid/content/Context;", "applicationId", "", "activityName", "accessToken", "Lcom/facebook/AccessToken;", "getAnalyticsExecutor", "Ljava/util/concurrent/Executor;", "getFlushBehavior", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getPushNotificationsRegistrationId", "setInternalUserData", "", "ud", "", "setUserData", "userData", "Landroid/os/Bundle;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final Executor a() {
            return h.j.f();
        }

        public final com.facebook.e0.g.b b() {
            return h.j.h();
        }

        public final String c() {
            return h.j.j();
        }

        public final void d(Map<String, String> map) {
            n.f(map, "ud");
            p.i(map);
        }
    }
    static {
        m.a aVar = new m.a(0);
        m.b = aVar;
    }

    public m(Context context) {
        final int i = 0;
        h hVar = new h(context, i, i);
        super(hVar);
    }

    public m(Context context, String string2) {
        h hVar = new h(context, string2, 0);
        super(hVar);
    }

    public m(com.facebook.e0.h h) {
        n.f(h, "loggerImpl");
        super();
        this.a = h;
    }

    public m(String string, String string2, a a3) {
        n.f(string, "activityName");
        h hVar = new h(string, string2, a3);
        super(hVar);
    }

    public final void a() {
        this.a.j();
    }

    public final void b(Bundle bundle) {
        int i;
        int i2;
        String str;
        n.f(bundle, "parameters");
        i = int &= 2 != 0 ? 1 : 0;
        if (i == 0) {
            if (o.j()) {
                this.a.q("fb_sdk_settings_changed", 0, bundle);
            }
        } else {
        }
    }

    public final void c(String string, double d2, Bundle bundle3) {
        boolean z;
        if (o.j()) {
            this.a.m(string, d2, bundle3);
        }
    }

    public final void d(String string, Bundle bundle2) {
        boolean z;
        if (o.j()) {
            this.a.n(string, bundle2);
        }
    }

    public final void e(String string, String string2) {
        this.a.p(string, string2);
    }

    public final void f(String string) {
        boolean z;
        int i;
        if (o.j()) {
            i = 0;
            this.a.q(string, i, i);
        }
    }

    public final void g(String string, Bundle bundle2) {
        boolean z;
        int i;
        if (o.j()) {
            this.a.q(string, 0, bundle2);
        }
    }

    public final void h(String string, Double double2, Bundle bundle3) {
        boolean z;
        if (o.j()) {
            this.a.q(string, double2, bundle3);
        }
    }

    public final void i(String string, BigDecimal bigDecimal2, Currency currency3, Bundle bundle4) {
        boolean z;
        if (o.j()) {
            this.a.r(string, bigDecimal2, currency3, bundle4);
        }
    }

    public final void j(BigDecimal bigDecimal, Currency currency2, Bundle bundle3) {
        boolean z;
        if (o.j()) {
            this.a.t(bigDecimal, currency2, bundle3);
        }
    }
}
