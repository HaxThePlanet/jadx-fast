package com.facebook.e0.v;

import android.os.Bundle;
import android.util.Log;
import com.facebook.e0.g;
import com.facebook.e0.g.a;
import com.facebook.e0.m;
import com.facebook.e0.t.d;
import com.facebook.internal.c0;
import com.facebook.internal.o;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.o;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J.\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0007J\u0008\u0010\u0010\u001a\u00020\u0011H\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger;", "", "()V", "APP_EVENTS_IF_AUTO_LOG_SUBS", "", "TAG", "internalAppEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "getPurchaseLoggingParameters", "Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "purchase", "skuDetails", "extraParameter", "", "isImplicitPurchaseLoggingEnabled", "", "logActivateAppEvent", "", "logActivityTimeSpentEvent", "activityName", "timeSpentInSeconds", "", "logPurchase", "isSubscription", "PurchaseLoggingParameters", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    private static final String a = "com.facebook.e0.v.d";
    private static final m b;
    public static final com.facebook.e0.v.d c;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008\u0002\u0018\u00002\u00020\u0001B\u001f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006\u0015", d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "param", "Landroid/os/Bundle;", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;)V", "getCurrency", "()Ljava/util/Currency;", "setCurrency", "(Ljava/util/Currency;)V", "getParam", "()Landroid/os/Bundle;", "setParam", "(Landroid/os/Bundle;)V", "getPurchaseAmount", "()Ljava/math/BigDecimal;", "setPurchaseAmount", "(Ljava/math/BigDecimal;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class a {

        private BigDecimal a;
        private Currency b;
        private Bundle c;
        public a(BigDecimal bigDecimal, Currency currency2, Bundle bundle3) {
            n.f(bigDecimal, "purchaseAmount");
            n.f(currency2, "currency");
            n.f(bundle3, "param");
            super();
            this.a = bigDecimal;
            this.b = currency2;
            this.c = bundle3;
        }

        public final Currency a() {
            return this.b;
        }

        public final Bundle b() {
            return this.c;
        }

        public final BigDecimal c() {
            return this.a;
        }
    }
    static {
        d dVar = new d();
        d.c = dVar;
        m mVar = new m(o.f());
        d.b = mVar;
    }

    private final com.facebook.e0.v.d.a a(String string, String string2) {
        HashMap hashMap = new HashMap();
        return b(string, string2, hashMap);
    }

    private final com.facebook.e0.v.d.a b(String string, String string2, Map<String, String> map3) {
        String length;
        Object jSONObject;
        int optString2;
        boolean optString;
        String str;
        int i;
        Currency obj7;
        Bundle obj8;
        com.facebook.e0.v.d.a obj9;
        length = "introductoryPriceCycles";
        jSONObject = new JSONObject(string);
        obj7 = new JSONObject(string2);
        obj8 = new Bundle(1);
        obj8.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
        obj8.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
        obj8.putCharSequence("fb_iap_purchase_token", jSONObject.getString("purchaseToken"));
        obj8.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
        obj8.putCharSequence("fb_iap_product_title", obj7.optString("title"));
        obj8.putCharSequence("fb_iap_product_description", obj7.optString("description"));
        String optString3 = obj7.optString("type");
        obj8.putCharSequence("fb_iap_product_type", optString3);
        if (n.b(optString3, "subs")) {
            i = 0;
            obj8.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", i)));
            obj8.putCharSequence("fb_iap_subs_period", obj7.optString("subscriptionPeriod"));
            obj8.putCharSequence("fb_free_trial_period", obj7.optString("freeTrialPeriod"));
            jSONObject = obj7.optString(length);
            n.e(jSONObject, length);
            if (jSONObject.length() == 0) {
                try {
                    optString2 = i;
                    if (optString2 == 0) {
                    }
                    obj8.putCharSequence("fb_intro_price_amount_micros", obj7.optString("introductoryPriceAmountMicros"));
                    obj8.putCharSequence("fb_intro_price_cycles", jSONObject);
                    obj9 = map3.entrySet().iterator();
                    for (Map.Entry next2 : obj9) {
                        obj8.putCharSequence((String)next2.getKey(), (String)next2.getValue());
                    }
                    Object next2 = obj9.next();
                    obj8.putCharSequence((String)(Map.Entry)next2.getKey(), (String)next2.getValue());
                    BigDecimal bigDecimal = new BigDecimal(d /= l, optString2);
                    obj7 = Currency.getInstance(obj7.getString("price_currency_code"));
                    n.e(obj7, "Currency.getInstance(sku…g(\"price_currency_code\"))");
                    obj9 = new d.a(bigDecimal, obj7, obj8);
                    string2 = d.a;
                    map3 = "Error parsing in-app subscription data.";
                    Log.e(string2, map3, string);
                    map3 = null;
                    return obj9;
                }
            } else {
            }
        }
    }

    public static final boolean c() {
        int i;
        p pVar;
        boolean z;
        pVar = q.j(o.g());
        if (pVar != null && o.j() && pVar.e()) {
            if (o.j()) {
                i = pVar.e() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static final void d() {
        Object context;
        String str;
        boolean z;
        context = o.f();
        c0.j(context, "context");
        if (o.j()) {
            if (context instanceof Application) {
                g.b.a((Application)context, o.g());
            } else {
                Log.w(d.a, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    public static final void e(String string, long l2) {
        Object bundle;
        p mVar;
        int str;
        java.lang.CharSequence obj3;
        String obj5;
        bundle = o.f();
        c0.j(bundle, "context");
        mVar = q.o(o.g(), false);
        if (mVar != null && mVar.a() && Long.compare(l2, i) > 0) {
            if (mVar.a()) {
                if (Long.compare(l2, i) > 0) {
                    mVar = new m(bundle);
                    bundle = new Bundle(1);
                    bundle.putCharSequence("fb_aa_time_spent_view_name", string);
                    mVar.c("fb_aa_time_spent_on_view", (double)l2, l2);
                }
            }
        }
    }

    public static final void f(String string, String string2, boolean z3) {
        int i;
        Object dVar;
        String str;
        Object obj2;
        String obj3;
        boolean obj4;
        n.f(string, "purchase");
        n.f(string2, "skuDetails");
        if (!d.c()) {
        }
        obj2 = d.c.a(string, string2);
        if (obj2 != null && z3 && o.f("app_events_if_auto_log_subs", o.g(), false)) {
            if (z3) {
                if (o.f("app_events_if_auto_log_subs", o.g(), false)) {
                    i = 1;
                }
            }
            if (i != 0) {
                obj3 = d.f.m(string2) ? "StartTrial" : "Subscribe";
                d.b.i(obj3, obj2.c(), obj2.a(), obj2.b());
            } else {
                d.b.j(obj2.c(), obj2.a(), obj2.b());
            }
        }
    }
}
