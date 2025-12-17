package com.facebook.e0;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.a;
import com.facebook.a.c;
import com.facebook.e0.v.a;
import com.facebook.e0.x.a;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.l;
import com.facebook.internal.l.b;
import com.facebook.internal.o;
import com.facebook.internal.s;
import com.facebook.internal.v;
import com.facebook.internal.v.a;
import com.facebook.o;
import com.facebook.v;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import org.json.JSONException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0001\u0018\u0000 :2\u00020\u0001:\u0001:B%\u0008\u0010\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008B#\u0008\u0000\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0014\u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0014\u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u0014\u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017J;\u0010\u0014\u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00132\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0005J.\u0010 \u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017J)\u0010 \u001a\u00020\u00112\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010%J\u0088\u0001\u0010&\u001a\u00020\u00112\u0008\u0010'\u001a\u0004\u0018\u00010\u00052\u0008\u0010(\u001a\u0004\u0018\u00010)2\u0008\u0010*\u001a\u0004\u0018\u00010+2\u0008\u0010,\u001a\u0004\u0018\u00010\u00052\u0008\u0010-\u001a\u0004\u0018\u00010\u00052\u0008\u0010.\u001a\u0004\u0018\u00010\u00052\u0008\u0010/\u001a\u0004\u0018\u00010\u00052\u0008\u00100\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u00101\u001a\u0004\u0018\u00010\u00052\u0008\u00102\u001a\u0004\u0018\u00010\u00052\u0008\u00103\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001a\u00104\u001a\u00020\u00112\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$J&\u00104\u001a\u00020\u00112\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J,\u00104\u001a\u00020\u00112\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0013J$\u00105\u001a\u00020\u00112\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00172\u0008\u00108\u001a\u0004\u0018\u00010\u0005J'\u00109\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010%R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;", d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl;", "", "context", "Landroid/content/Context;", "applicationId", "", "accessToken", "Lcom/facebook/AccessToken;", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "activityName", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "getApplicationId", "()Ljava/lang/String;", "contextName", "flush", "", "isValidForAccessToken", "", "logEvent", "eventName", "parameters", "Landroid/os/Bundle;", "valueToSum", "", "isImplicitlyLogged", "currentSessionId", "Ljava/util/UUID;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZLjava/util/UUID;)V", "logEventFromSE", "buttonText", "logEventImplicitly", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "logProductItem", "itemID", "availability", "Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "condition", "Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "description", "imageLink", "link", "title", "priceAmount", "gtin", "mpn", "brand", "logPurchase", "logPurchaseImplicitly", "logPushNotificationOpen", "payload", "action", "logSdkEvent", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class h {

    private static final String c;
    private static ScheduledThreadPoolExecutor d;
    private static com.facebook.e0.g.b e;
    private static final Object f;
    private static String g;
    private static boolean h;
    private static String i;
    public static final com.facebook.e0.h.a j;
    private final String a;
    private com.facebook.e0.a b;

    @Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u0006\u0010\"\u001a\u00020\u0019J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0008\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0007J\u0008\u0010(\u001a\u00020\u0013H\u0007J\n\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010+\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u0008\u0010,\u001a\u00020\u0019H\u0002J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0004H\u0002J\u0008\u00104\u001a\u00020\u0019H\u0007J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0013H\u0007J\u0012\u00107\u001a\u00020\u00192\u0008\u00108\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00109\u001a\u00020\u00192\u0008\u0010:\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;", d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl$Companion;", "", "()V", "ACCOUNT_KIT_EVENT_NAME_PREFIX", "", "APP_EVENTS_KILLSWITCH", "APP_EVENT_NAME_PUSH_OPENED", "APP_EVENT_PREFERENCES", "APP_EVENT_PUSH_PARAMETER_ACTION", "APP_EVENT_PUSH_PARAMETER_CAMPAIGN", "APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS", "", "PUSH_PAYLOAD_CAMPAIGN_KEY", "PUSH_PAYLOAD_KEY", "TAG", "anonymousAppDeviceGUID", "backgroundExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "flushBehaviorField", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "isActivateAppEventRequested", "", "pushNotificationsRegistrationIdField", "staticLock", "activateApp", "", "application", "Landroid/app/Application;", "applicationId", "augmentWebView", "webView", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "eagerFlush", "functionDEPRECATED", "extraMsg", "getAnalyticsExecutor", "Ljava/util/concurrent/Executor;", "getAnonymousAppDeviceGUID", "getFlushBehavior", "getInstallReferrer", "getPushNotificationsRegistrationId", "initializeLib", "initializeTimersIfNeeded", "logEvent", "event", "Lcom/facebook/appevents/AppEvent;", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "notifyDeveloperError", "message", "onContextStop", "setFlushBehavior", "flushBehavior", "setInstallReferrer", "referrer", "setPushNotificationsRegistrationId", "registrationId", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final void a(com.facebook.e0.h.a h$a) {
            a.l();
        }

        public static final void b(com.facebook.e0.h.a h$a, com.facebook.e0.c c2, com.facebook.e0.a a3) {
            a.m(c2, a3);
        }

        public static final void c(com.facebook.e0.h.a h$a, String string2) {
            a.n(string2);
        }

        private final void l() {
            Object obj = h.e();
            synchronized (obj) {
            }
            scheduledThreadPoolExecutor3.scheduleAtFixedRate(cVar, 0, obj5, (long)i);
        }

        private final void m(com.facebook.e0.c c, com.facebook.e0.a a2) {
            boolean str;
            String str2;
            com.facebook.e0.c obj3;
            Object obj4;
            e.h(a2, c);
            if (l.g(l.b.OnDevicePostInstallEventProcessing) && a.b()) {
                if (a.b()) {
                    a.c(a2.b(), c);
                }
            }
            if (!c.c() && !h.f()) {
                if (!h.f()) {
                    if (n.b(c.f(), "fb_mobile_activate_app")) {
                        h.g(true);
                    } else {
                        v.f.b(v.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
                    }
                }
            }
        }

        private final void n(String string) {
            v.f.b(v.DEVELOPER_ERRORS, "AppEvents", string);
        }

        public final void d(Application application, String string2) {
            String obj3;
            n.f(application, "application");
            if (!o.y()) {
            } else {
                b.g();
                p.g();
                if (string2 == null) {
                    obj3 = o.g();
                }
                o.D(application, obj3);
                a.x(application, obj3);
            }
            FacebookException obj2 = new FacebookException("The Facebook sdk must be initialized before calling activateApp");
            throw obj2;
        }

        public final void e() {
            Enum eAGER_FLUSHING_EVENT;
            if (h() != g.b.EXPLICIT_ONLY) {
                e.k(j.EAGER_FLUSHING_EVENT);
            }
        }

        public final Executor f() {
            if (h.b() == null) {
                l();
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = h.b();
            if (scheduledThreadPoolExecutor2 == null) {
            } else {
                return scheduledThreadPoolExecutor2;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
            throw illegalStateException;
        }

        public final String g(Context context) {
            Object str2;
            String str;
            int i;
            String string;
            int i2;
            Object obj6;
            n.f(context, "context");
            str2 = h.e();
            i = 0;
            h.h(context.getSharedPreferences("com.facebook.sdk.appEventPreferences", i).getString("anonymousAppDeviceGUID", 0));
            if (h.a() == null && h.a() == null && h.a() == null) {
                str2 = h.e();
                synchronized (str2) {
                    i = 0;
                    h.h(context.getSharedPreferences("com.facebook.sdk.appEventPreferences", i).getString("anonymousAppDeviceGUID", 0));
                    if (h.a() == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("XZ");
                        stringBuilder.append(UUID.randomUUID().toString());
                        h.h(stringBuilder.toString());
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", i).edit().putString("anonymousAppDeviceGUID", h.a()).apply();
                    }
                    obj6 = w.a;
                }
            }
            obj6 = h.a();
            if (obj6 == null) {
            } else {
                return obj6;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
            throw illegalStateException;
        }

        public final com.facebook.e0.g.b h() {
            final Object obj = h.e();
            return h.c();
            synchronized (obj) {
                obj = h.e();
                return h.c();
            }
        }

        public final String i() {
            h.a.a aVar = new h.a.a();
            s.d(aVar);
            return o.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("install_referrer", 0);
        }

        public final String j() {
            final Object obj = h.e();
            return h.d();
            synchronized (obj) {
                obj = h.e();
                return h.d();
            }
        }

        public final void k(Context context, String string2) {
            n.f(context, "context");
            if (!o.j()) {
            }
            h hVar = new h(context, string2, 0);
            ScheduledThreadPoolExecutor obj4 = h.b();
            if (obj4 == null) {
            } else {
                h.a.b bVar = new h.a.b(context, hVar);
                obj4.execute(bVar);
            }
            IllegalStateException obj3 = new IllegalStateException("Required value was null.".toString());
            throw obj3;
        }

        public final void o() {
            e.o();
        }

        public final void p(String string) {
            Object sharedPreferences;
            String str;
            Object obj4;
            if (string != null) {
                o.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("install_referrer", string).apply();
            }
        }
    }
    static {
        String canonicalName;
        h.a aVar = new h.a(0);
        h.j = aVar;
        if (h.class.getCanonicalName() != null) {
        } else {
            canonicalName = "com.facebook.appevents.AppEventsLoggerImpl";
        }
        n.e(canonicalName, "AppEventsLoggerImpl::cla…ents.AppEventsLoggerImpl\"");
        h.c = canonicalName;
        h.e = g.b.AUTO;
        Object object = new Object();
        h.f = object;
    }

    public h(Context context, String string2, a a3) {
        super(b0.s(context), string2, a3);
    }

    public h(String string, String string2, a a3) {
        Object obj2;
        Object obj3;
        a obj4;
        n.f(string, "activityName");
        super();
        c0.l();
        this.a = string;
        if (a3 == null) {
            obj4 = a.H.e();
        }
        if (obj4 != null && !obj4.p()) {
            if (!obj4.p()) {
                if (string2 != null) {
                    if (n.b(string2, obj4.c())) {
                        obj2 = new a(obj4);
                        this.b = obj2;
                    } else {
                        if (string2 == null) {
                            obj3 = b0.D(o.f());
                        }
                        if (obj3 == null) {
                        } else {
                            obj2 = new a(0, obj3);
                            this.b = obj2;
                        }
                    }
                } else {
                }
                h.a.a(h.j);
            } else {
            }
        } else {
        }
        obj2 = new IllegalStateException("Required value was null.".toString());
        throw obj2;
    }

    public static final String a() {
        if (a.d(h.class)) {
            return null;
        }
        return h.g;
    }

    public static final ScheduledThreadPoolExecutor b() {
        if (a.d(h.class)) {
            return null;
        }
        return h.d;
    }

    public static final com.facebook.e0.g.b c() {
        if (a.d(h.class)) {
            return null;
        }
        return h.e;
    }

    public static final String d() {
        if (a.d(h.class)) {
            return null;
        }
        return h.i;
    }

    public static final Object e() {
        if (a.d(h.class)) {
            return null;
        }
        return h.f;
    }

    public static final boolean f() {
        if (a.d(h.class)) {
            return 0;
        }
        return h.h;
    }

    public static final void g(boolean z) {
        if (a.d(h.class)) {
        }
        h.h = z;
    }

    public static final void h(String string) {
        if (a.d(h.class)) {
        }
        h.g = string;
    }

    public static final void i(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        if (a.d(h.class)) {
        }
        h.d = scheduledThreadPoolExecutor;
    }

    public final void j() {
        if (a.d(this)) {
        }
        e.k(j.EXPLICIT);
    }

    public final void k(String string) {
        if (a.d(this)) {
        }
        n(string, 0);
    }

    public final void l(String string, double d2) {
        if (a.d(this)) {
        }
        m(string, d2, obj4);
    }

    public final void m(String string, double d2, Bundle bundle3) {
        if (a.d(this)) {
        }
        this.o(string, Double.valueOf(d2), obj11, false, a.q());
    }

    public final void n(String string, Bundle bundle2) {
        if (a.d(this)) {
        }
        this.o(string, 0, bundle2, false, a.q());
    }

    public final void o(String string, Double double2, Bundle bundle3, boolean z4, UUID uUID5) {
        int z;
        com.facebook.e0.c cVar;
        com.facebook.e0.h.a aVar;
        com.facebook.e0.a aVar2;
        Object obj;
        Double num;
        int i2;
        int i;
        final Object obj2 = this;
        if (a.d(this)) {
        }
        if (string != null) {
            i2 = 1;
            i = 0;
            z = string.length() == 0 ? i2 : i;
            if (z != 0) {
            } else {
                if (o.f("app_events_killswitch", o.g(), i)) {
                    Object[] arr = new Object[i2];
                    arr[i] = string;
                    v.f.c(v.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", arr);
                }
                try {
                    super(obj2.a, string, double2, bundle3, z4, a.s(), uUID5);
                    h.a.b(h.j, cVar, obj2.b);
                    v.a aVar4 = v.f;
                    v aPP_EVENTS2 = v.APP_EVENTS;
                    String str5 = "Invalid app event: %s";
                    Object[] arr2 = new Object[obj10];
                    Throwable th = th.toString();
                    arr2[obj11] = th;
                    aVar4.c(aPP_EVENTS2, obj12, str5, arr2);
                    aVar4 = v.f;
                    aPP_EVENTS2 = v.APP_EVENTS;
                    str5 = "JSON encoding for app event failed: '%s'";
                    arr2 = new Object[obj10];
                    th = th.toString();
                    arr2[obj11] = th;
                    aVar4.c(aPP_EVENTS2, obj12, str5, arr2);
                    a.b(th, this);
                } catch (org.json.JSONException jSON) {
                } catch (com.facebook.FacebookException facebook1) {
                } catch (Throwable th2) {
                }
            }
        }
    }

    public final void p(String string, String string2) {
        if (a.d(this)) {
        }
        Bundle bundle = new Bundle();
        bundle.putString("_is_suggested_event", "1");
        bundle.putString("_button_text", string2);
        n(string, bundle);
    }

    public final void q(String string, Double double2, Bundle bundle3) {
        if (a.d(this)) {
        }
        this.o(string, double2, bundle3, true, a.q());
    }

    public final void r(String string, BigDecimal bigDecimal2, Currency currency3, Bundle bundle4) {
        Bundle obj10;
        if (a.d(this)) {
        }
        if (bigDecimal2 != null) {
            if (currency3 == null) {
            } else {
                if (bundle4 == null) {
                    obj10 = new Bundle();
                }
            }
            final Bundle bundle = obj10;
            final String obj9 = currency3.getCurrencyCode();
            bundle.putString("fb_currency", obj9);
            this.o(string, Double.valueOf(bigDecimal2.doubleValue()), bundle, true, a.q());
        }
        b0.d0(h.c, "purchaseAmount and currency cannot be null");
    }

    public final void s(BigDecimal bigDecimal, Currency currency2, Bundle bundle3, boolean z4) {
        Bundle obj9;
        if (a.d(this)) {
        }
        if (bigDecimal == null) {
            h.a.c(h.j, "purchaseAmount cannot be null");
        }
        if (currency2 == null) {
            h.a.c(h.j, "currency cannot be null");
        }
        if (bundle3 == null) {
            obj9 = new Bundle();
        }
        try {
            final Bundle bundle = obj9;
            String obj8 = currency2.getCurrencyCode();
            bundle.putString("fb_currency", obj8);
            this.o("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle, z4, a.q());
            h.j.e();
            a.b(bigDecimal, this);
        }
    }

    public final void t(BigDecimal bigDecimal, Currency currency2, Bundle bundle3) {
        if (a.d(this)) {
        }
        s(bigDecimal, currency2, bundle3, true);
    }
}
