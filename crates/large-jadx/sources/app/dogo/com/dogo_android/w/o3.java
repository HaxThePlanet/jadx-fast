package app.dogo.com.dogo_android.w;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.v.a;
import com.amplitude.api.f;
import com.amplitude.api.l;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.e0.g;
import com.facebook.e0.g.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iterable.iterableapi.j;
import com.revenuecat.purchases.Purchases;
import com.squareup.moshi.f;
import com.squareup.moshi.r;
import com.squareup.moshi.r.a;
import com.squareup.moshi.t;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.k0.l;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import n.a.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u0000 Y2\u00020\u0001:\u0002YZB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020$J\u0016\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0012J\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u001e\u0010,\u001a\u00020\u001e2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020\u001e2\u0008\u00100\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u00101\u001a\u00020\u001e2\u0008\u00100\u001a\u0004\u0018\u00010\u001aH\u0016J\u001e\u00102\u001a\u00020\u001e2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000204\u0018\u00010.H\u0016J\u000e\u00105\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208J+\u00106\u001a\u00020\u001e2\u0008\u00109\u001a\u0004\u0018\u00010:2\u0008\u0010;\u001a\u0004\u0018\u00010<2\u0008\u0010=\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0002\u0010>J\u0006\u0010?\u001a\u00020\u001eJ\u0006\u0010@\u001a\u00020\u001eJ\u0006\u0010A\u001a\u00020\u001eJ\u000e\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020DJ\u0010\u0010E\u001a\u00020\u001e2\u0008\u0010F\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020I2\u0008\u0010J\u001a\u0004\u0018\u000104J\u000e\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020\u001aJ\u000e\u0010P\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020DJ\u001e\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020\u001aJ\u0010\u0010U\u001a\u00020\u001e2\u0008\u0010V\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006[", d2 = {"Lapp/dogo/com/dogo_android/tracking/Tracker;", "Lcom/appsflyer/AppsFlyerConversionListener;", "app", "Landroid/app/Application;", "firebaseTracker", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "amplitudeTracker", "Lcom/amplitude/api/AmplitudeClient;", "facebookTracker", "Lcom/facebook/appevents/AppEventsLogger;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "iterableTracker", "Lcom/iterable/iterableapi/IterableApi;", "appsFlyerTracker", "Lcom/appsflyer/AppsFlyerLib;", "(Landroid/app/Application;Lcom/google/firebase/analytics/FirebaseAnalytics;Lcom/amplitude/api/AmplitudeClient;Lcom/facebook/appevents/AppEventsLogger;Lcom/revenuecat/purchases/Purchases;Lcom/iterable/iterableapi/IterableApi;Lcom/appsflyer/AppsFlyerLib;)V", "currentScreen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "getCurrentScreen", "()Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "setCurrentScreen", "(Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;)V", "parameterMapJsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "isFirstOpenPropertiesSaved", "", "logAppOpen", "", "link", "Lapp/dogo/com/dogo_android/tracking/Tracker$MarketingDeeplink;", "logEvent", "event", "Lapp/dogo/com/dogo_android/tracking/Event0;", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "trackToAppsFlyer", "logFirstAppOpen", "logScreenView", "activity", "Landroid/app/Activity;", "screen", "Lapp/dogo/com/dogo_android/tracking/Screen;", "onAppOpenAttribution", "attributionData", "", "onAttributionFailure", "error", "onConversionDataFail", "onConversionDataSuccess", "conversionData", "", "saveFirstAppOpenProperties", "setCurrentDogBirthdayUserProperties", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "birthday", "", "ageInMonth", "", "initialAgeInMonths", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setFirstAppOpenUserProperties", "setFirstOpenBuild", "setFirstOpenVersion", "setTrainingReminderUserProperties", "reminder", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "setUserId", "userId", "setUserProperty", "property", "Lapp/dogo/com/dogo_android/tracking/UserProperty;", "value", "trackDeviceData", "deviceData", "Lapp/dogo/com/dogo_android/temp/Device;", "trackErrorMessage", "source", "trackSetReminder", "trackTrickRating", "trickId", "knowledge", "screenName", "trackUserLocale", "iso2Locale", "updateTimezoneUserProperties", "timezone", "Companion", "MarketingDeeplink", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o3 implements AppsFlyerConversionListener {

    public static final app.dogo.com.dogo_android.w.o3.a Companion;
    private final Application a;
    private final FirebaseAnalytics b;
    private final f c;
    private final g d;
    private final Purchases e;
    private final j f;
    private final AppsFlyerLib g;
    private f<Map<String, String>> h;
    private app.dogo.com.dogo_android.w.i3 i;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/tracking/Tracker$Companion;", "", "()V", "AMPLITUDE_UNIFIED_PROJECT_KEY", "", "APPSFLYER_CAMPAIGN_KEY", "APPSFLYER_MEDIA_SOURCE_KEY", "APP_FLYER_DEEPLINK_KEY", "MAX_FIREBASE_EVENT_KEY_LENGTH", "", "MAX_FIREBASE_EVENT_PARAM_KEY_LENGTH", "MAX_FIREBASE_EVENT_PARAM_VALUE_LENGTH", "MAX_FIREBASE_USER_PROPERTY_KEY_LENGTH", "MAX_FIREBASE_USER_PROPERTY_VALUE_LENGTH", "USER_PROPERTY_VALUE_PREMIUM", "USER_PROPERTY_VALUE_PREMIUM_DOG", "UTM_CAMPAIGN_KEY", "UTM_MEDIUM_KEY", "UTM_SOURCE_KEY", "logException", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final void a(Exception exception) {
            n.f(exception, "exception");
            if (j1.F0(exception)) {
                a.j(exception);
            } else {
                a.d(exception);
            }
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\n2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0008R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/tracking/Tracker$MarketingDeeplink;", "", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "campaign", "", "getCampaign", "()Ljava/lang/String;", "exists", "", "getExists", "()Z", "isAppFlyerLink", "medium", "getMedium", "source", "getSource", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "other", "getCorrectedQueryParameter", "key", "hashCode", "", "toString", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {

        public static final app.dogo.com.dogo_android.w.o3.b.a Companion;
        private final Uri a;
        private final boolean b;
        private final String c;
        private final String d;
        private final String e;
        private final boolean f = true;
        static {
            o3.b.a aVar = new o3.b.a(0);
            o3.b.Companion = aVar;
        }

        public b(Uri uri) {
            boolean booleanQueryParameter;
            String str;
            String str2;
            super();
            this.a = uri;
            int i = 0;
            if (uri == null) {
                booleanQueryParameter = i;
            } else {
                booleanQueryParameter = uri.getBooleanQueryParameter("af_deeplink", i);
            }
            this.b = booleanQueryParameter;
            str2 = booleanQueryParameter ? "media_source" : "utm_source";
            this.c = b(str2);
            this.d = b("utm_campaign");
            str = booleanQueryParameter ? "campaign" : "utm_medium";
            this.e = b(str);
            int i2 = 1;
        }

        private final String b(String string) {
            int i;
            int obj3;
            Uri uri = this.a;
            if (uri == null) {
                obj3 = i;
            } else {
                obj3 = uri.getQueryParameter(string);
            }
            if (n.b(obj3, "(not set)")) {
            } else {
                i = obj3;
            }
            return i;
        }

        public final String a() {
            return this.e;
        }

        public final boolean c() {
            return this.f;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.c;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof o3.b) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            return i;
        }

        public int hashCode() {
            int i;
            Uri uri = this.a;
            if (uri == null) {
                i = 0;
            } else {
                i = uri.hashCode();
            }
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MarketingDeeplink(uri=");
            stringBuilder.append(this.a);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    static {
        o3.a aVar = new o3.a(0);
        o3.Companion = aVar;
    }

    public o3(Application application, FirebaseAnalytics firebaseAnalytics2, f f3, g g4, Purchases purchases5, j j6, AppsFlyerLib appsFlyerLib7) {
        final Class<String> obj = String.class;
        n.f(application, "app");
        n.f(firebaseAnalytics2, "firebaseTracker");
        n.f(f3, "amplitudeTracker");
        n.f(g4, "facebookTracker");
        n.f(purchases5, "purchases");
        n.f(j6, "iterableTracker");
        n.f(appsFlyerLib7, "appsFlyerTracker");
        super();
        this.a = application;
        this.b = firebaseAnalytics2;
        this.c = f3;
        this.d = g4;
        this.e = purchases5;
        this.f = j6;
        this.g = appsFlyerLib7;
        r.a obj3 = new r.a();
        java.lang.reflect.Type[] obj5 = new Type[2];
        obj3 = obj3.b().d(t.j(Map.class, obj, obj));
        n.e(obj3, "moshi.adapter(parameterMapType)");
        this.h = obj3;
        n();
        m();
    }

    private final void k(Long long, Integer integer2, Integer integer3) {
        int valueOf2;
        int instance;
        long longValue;
        Integer valueOf;
        app.dogo.com.dogo_android.w.q3 obj7;
        valueOf2 = 0;
        if (long != null) {
            Calendar.getInstance().setTimeInMillis(long.longValue());
        } else {
            instance = valueOf2;
        }
        App.a obj5 = App.Companion;
        obj5.r().q(q3.CurrentDogAge, integer2);
        obj5.r().q(q3.CurrentDogAgeInitial, integer3);
        if (instance == null) {
            valueOf = valueOf2;
        } else {
            valueOf = Integer.valueOf(i2++);
        }
        obj5.r().q(q3.CurrentDogBirthdayMonth, valueOf);
        if (instance == null) {
        } else {
            valueOf2 = Integer.valueOf(instance.get(5));
        }
        obj5.r().q(q3.CurrentDogBirthdayDay, valueOf2);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final app.dogo.com.dogo_android.w.i3 a() {
        return this.i;
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void b(app.dogo.com.dogo_android.w.o3.b o3$b) {
        Object appOpenMedium;
        Object obj7;
        n.f(b, "link");
        String str2 = b.e();
        final String str3 = b.a();
        obj7 = b.d();
        y0 y0Var = new y0();
        y1 y1Var = new y1();
        z1 z1Var = new z1();
        d(a0.g.d(u.a(y0Var, str3), u.a(y1Var, str2), u.a(z1Var, obj7)));
        if (str2 == null && obj7 == null) {
            if (obj7 == null) {
                if (str3 != null) {
                    q(q3.AppOpenCampaign, str3);
                    q(q3.AppOpenSource, str2);
                    q(q3.AppOpenMedium, obj7);
                    this.e.setCampaign(str3);
                    this.e.setMediaSource(str2);
                }
            } else {
            }
        } else {
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void c(app.dogo.com.dogo_android.w.t2 t2) {
        n.f(t2, "event");
        d(t2.h());
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void d(app.dogo.com.dogo_android.w.h3 h3) {
        n.f(h3, "event");
        e(h3, false);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void e(app.dogo.com.dogo_android.w.h3 h3, boolean z2) {
        Object iterator;
        boolean key;
        Object jVar;
        int next2;
        int string2;
        int value2;
        int next3;
        app.dogo.com.dogo_android.w.i3 next;
        Object stringBuilder2;
        String str;
        String substring;
        Object value;
        Object jSONObject;
        Object double;
        Object string;
        int digit;
        int length;
        Object linkedHashMap;
        StringBuilder stringBuilder;
        Object iterator2;
        int next4;
        Object key2;
        int i2;
        int i;
        int i3;
        final Object obj = this;
        n.f(h3, "event");
        Map map = h3.c();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(j0.d(map.size()));
        Iterator iterator3 = map.entrySet().iterator();
        for (Map.Entry next7 : iterator3) {
            linkedHashMap3.put((z2)next7.getKey().a(), next7.getValue());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j0.d(linkedHashMap3.size()));
        Iterator iterator4 = linkedHashMap3.entrySet().iterator();
        str = 0;
        while (iterator4.hasNext()) {
            next3 = iterator4.next();
            string = next3.getValue();
            if (string == null) {
            } else {
            }
            string = string.toString();
            if (string == null) {
            } else {
            }
            substring = string;
            double = 100;
            if (substring.length() > double) {
            }
            linkedHashMap2.put((Map.Entry)next3.getKey(), substring);
            str = 0;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Too long event parameter value. Tried to set ");
            stringBuilder = new StringBuilder();
            stringBuilder.append(h3.b());
            stringBuilder.append('.');
            stringBuilder.append((String)next3.getKey());
            stringBuilder.append('=');
            stringBuilder.append(substring);
            stringBuilder.append(", length=");
            stringBuilder.append(substring.length());
            stringBuilder.append(", expected=");
            stringBuilder.append(double);
            stringBuilder4.append(stringBuilder.toString());
            a.i(stringBuilder4.toString(), new Object[str]);
            n.e(substring.substring(str, double), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        iterator = j0.y(linkedHashMap2);
        f1 f1Var = new f1();
        if (!iterator.containsKey(f1Var.a())) {
            f1 f1Var2 = new f1();
            next = obj.i;
            if (next == null) {
                next = substring;
            } else {
            }
            iterator.put(f1Var2.a(), next);
        }
        Bundle bundle = new Bundle();
        Iterator iterator5 = iterator.entrySet().iterator();
        while (iterator5.hasNext()) {
            value = iterator5.next();
            if ((CharSequence)(Map.Entry)value.getValue().length() > 0) {
            } else {
            }
            digit = str;
            if (digit != 0) {
            } else {
            }
            bundle.putString((String)value.getKey(), (String)value.getValue());
            if (!Character.isDigit(l.c1((CharSequence)value.getValue()))) {
            } else {
            }
            bundle.putDouble((String)value.getKey(), Double.parseDouble((String)value.getValue()));
            if (l.c1((CharSequence)value.getValue()) == 45) {
            } else {
            }
        }
        JSONObject jSONObject2 = new JSONObject(obj.h.h(iterator));
        obj.c.I(h3.b(), jSONObject2);
        obj.b.logEvent(h3.b(), bundle);
        j1.k0(obj.d, h3.a());
        jSONObject = new JSONObject(obj.h.h(iterator));
        obj.f.T(h3.b(), jSONObject);
        if (z2) {
            linkedHashMap = new LinkedHashMap(j0.d(iterator.size()));
            iterator2 = iterator.entrySet().iterator();
            for (Map.Entry next4 : iterator2) {
                linkedHashMap.put(next4.getKey(), next4);
            }
            obj.g.logEvent(obj.a, h3.b(), linkedHashMap);
        }
        if (empty ^= digit != 0) {
            jSONObject = new ArrayList(iterator.size());
            iterator = iterator.entrySet().iterator();
            for (Map.Entry next5 : iterator) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String)next5.getKey());
                stringBuilder2.append(": ");
                stringBuilder2.append((String)next5.getValue());
                jSONObject.add(stringBuilder2.toString());
            }
            substring = p.h0(jSONObject, ", ", " with parameters ", 0, 0, 0, 0, 60, 0);
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Tracked event: ");
        stringBuilder3.append(h3.b());
        stringBuilder3.append(substring);
        a.f(stringBuilder3.toString(), new Object[str]);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void f(app.dogo.com.dogo_android.w.o3.b o3$b) {
        n.f(b, "link");
        String str2 = b.e();
        String str3 = b.d();
        String obj5 = b.a();
        q(q3.FirstAppOpenCampaign, obj5);
        q(q3.FirstAppOpenSource, str2);
        q(q3.FirstAppOpenMedium, str3);
        this.e.setCampaign(obj5);
        this.e.setMediaSource(str2);
        y0 y0Var = new y0();
        y1 y1Var = new y1();
        z1 z1Var = new z1();
        d(a0.f.d(u.a(y0Var, obj5), u.a(y1Var, str2), u.a(z1Var, str3)));
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void g(Activity activity, app.dogo.com.dogo_android.w.i3 i32) {
        Object companion;
        int next;
        int string2;
        int value2;
        int next2;
        boolean stringBuilder;
        String str2;
        String substring;
        Object value;
        Object jSONObject;
        int key;
        String str;
        Object string;
        int illegalArgumentException;
        Object jSONObject2;
        StringBuilder stringBuilder2;
        String str3;
        StringBuilder stringBuilder3;
        int i;
        int i2;
        int i3;
        int i4;
        Object obj14;
        n.f(activity, "activity");
        n.f(i32, "screen");
        this.i = i32;
        obj14 = i32.g();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(obj14.size()));
        obj14 = obj14.entrySet().iterator();
        for (Map.Entry next6 : obj14) {
            linkedHashMap.put((z2)next6.getKey().a(), next6.getValue());
        }
        obj14 = new LinkedHashMap(j0.d(linkedHashMap.size()));
        Iterator iterator = linkedHashMap.entrySet().iterator();
        str2 = 0;
        substring = "";
        while (iterator.hasNext()) {
            next2 = iterator.next();
            string = next2.getValue();
            if (string == null) {
            } else {
            }
            string = string.toString();
            if (string == null) {
            } else {
            }
            substring = string;
            key = 100;
            if (substring.length() > key) {
            }
            obj14.put((Map.Entry)next2.getKey(), substring);
            str2 = 0;
            substring = "";
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Too long event parameter value. Tried to set ");
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(i32.a());
            stringBuilder3.append('.');
            stringBuilder3.append((String)next2.getKey());
            stringBuilder3.append('=');
            stringBuilder3.append(substring);
            stringBuilder3.append(", length=");
            stringBuilder3.append(substring.length());
            stringBuilder3.append(", expected=");
            stringBuilder3.append(key);
            stringBuilder2.append(stringBuilder3.toString());
            illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            a.d(illegalArgumentException);
            n.e(substring.substring(str2, key), "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        Bundle bundle = new Bundle();
        Iterator iterator2 = obj14.entrySet().iterator();
        for (Map.Entry next8 : iterator2) {
            bundle.putString((String)next8.getKey(), (String)next8.getValue());
        }
        String str14 = "view_";
        jSONObject2 = new JSONObject(this.h.h(obj14));
        this.c.I(n.o(str14, i32.a()), jSONObject2);
        this.b.logEvent(n.o(str14, i32.a()), bundle);
        jSONObject = new JSONObject(this.h.h(obj14));
        this.f.T(n.o(str14, i32.a()), jSONObject);
        companion = a3.Companion;
        if (companion.i(i32)) {
            j1.k0(this.d, companion.j(i32.a()));
        }
        if (empty ^= 1 != 0) {
            jSONObject = new ArrayList(obj14.size());
            obj14 = obj14.entrySet().iterator();
            for (Map.Entry next3 : obj14) {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)next3.getKey());
                stringBuilder.append(": ");
                stringBuilder.append((String)next3.getValue());
                jSONObject.add(stringBuilder.toString());
            }
            substring = p.h0(jSONObject, ", ", " with parameters ", 0, 0, 0, 0, 60, 0);
        }
        obj14 = new StringBuilder();
        obj14.append("Tracked event: ");
        obj14.append(i32.a());
        obj14.append(substring);
        a.f(obj14.toString(), new Object[str2]);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void h(Activity activity, app.dogo.com.dogo_android.w.k3 k32) {
        n.f(activity, "activity");
        n.f(k32, "screen");
        g(activity, k32.f());
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void i(app.dogo.com.dogo_android.w.o3.b o3$b) {
        Object companion;
        boolean z;
        Object valueOf;
        Object obj5;
        n.f(b, "link");
        companion = App.Companion;
        companion.l().P0(true);
        companion.l().R0(String.valueOf(System.currentTimeMillis()));
        companion.l().S0("7.22.1");
        companion.l().M0(70220100);
        if (b.c()) {
            companion.l().N0(b.a());
            companion.l().O0(b.d());
            companion.l().Q0(b.e());
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void j(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        k(dogProfile.getBirthday(), dogProfile.getAgeInMonths(), dogProfile.getInitialAgeInMonths());
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void l() {
        Object companion;
        Object appOpenMedium;
        String str;
        companion = App.Companion;
        if (companion.l().C() != null && companion.l().w() != null) {
            if (companion.l().w() != null) {
                q(q3.FirstAppOpenVersion, companion.l().C());
                q(q3.FirstAppOpenBuild, companion.l().w());
                q(q3.FirstAppOpenCampaign, companion.l().x());
                q(q3.FirstAppOpenSource, companion.l().A());
                q(q3.FirstAppOpenMedium, companion.l().y());
                q(q3.FirstAppOpenTime, companion.l().B());
                q(q3.AppOpenCampaign, companion.l().x());
                q(q3.AppOpenSource, companion.l().A());
                q(q3.AppOpenMedium, companion.l().y());
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void m() {
        Object companion;
        Object firstAppOpenBuild;
        Integer valueOf;
        companion = App.Companion;
        if (companion.l().w() == null) {
            companion.l().M0(70220100);
            q(q3.FirstAppOpenBuild, companion.l().w());
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void n() {
        Object companion;
        Object firstAppOpenVersion;
        String str;
        companion = App.Companion;
        if (companion.l().C() == null) {
            companion.l().S0("7.22.1");
            q(q3.FirstAppOpenVersion, companion.l().C());
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void o(RemindersModel remindersModel) {
        n.f(remindersModel, "reminder");
        App.a companion = App.Companion;
        companion.r().q(q3.TrainingReminderWeekdays, remindersModel.getReminderWeekdayStrings());
        companion.r().q(q3.TrainingReminderTimeMin, remindersModel.getReminderTimeInMinutes());
        companion.r().q(q3.TrainingReminderEnabled, Boolean.valueOf(remindersModel.isActive()));
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        Object obj;
        Object appOpenCampaign;
        Object obj3;
        if (map == null) {
        } else {
            obj = map.get("media_source");
            obj3 = map.get("campaign");
            if ((String)obj3 != null) {
                q(q3.AppOpenCampaign, (String)obj3);
            }
            if ((String)obj != null) {
                q(q3.AppOpenSource, (String)obj);
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public void onAttributionFailure(String string) {
        a.c(n.o("AppsFlyer attribution failure: ", string), new Object[0]);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public void onConversionDataFail(String string) {
        a.c(n.o("AppsFlyer conversion data failure: ", string), new Object[0]);
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        Object obj;
        Object firstAppOpenCampaign;
        Object obj3;
        obj = map.get("media_source");
        obj3 = map.get("campaign");
        if (map != null && obj3 != null) {
            obj = map.get("media_source");
            obj3 = map.get("campaign");
            if (obj3 != null) {
                q(q3.FirstAppOpenCampaign, obj3);
            }
            if (obj != null) {
                q(q3.FirstAppOpenSource, obj);
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void p(String string) {
        Object obj3;
        q(q3.UserId, string);
        this.c.c0(string);
        this.g.setCustomerIdAndLogSession(string, this.a);
        this.f.Q(string);
        if (string == null) {
            obj3 = "";
        }
        g.b.h(obj3);
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void q(app.dogo.com.dogo_android.w.q3 q3, Object object2) {
        boolean trackAmplitude;
        String string2;
        String trackFirebase;
        boolean trackIterable;
        boolean z;
        JSONArray jSONObject;
        Object lVar;
        boolean valueOf;
        Object valueOf4;
        int valueOf3;
        String valueOf2;
        int i3;
        int illegalArgumentException;
        int string;
        int length;
        int i2;
        int i4;
        int i;
        int i5;
        String obj13;
        Object obj14;
        n.f(q3, "property");
        jSONObject = 0;
        if (q3.getTrackAmplitude()) {
            if (object2 instanceof List != null) {
                Object obj2 = object2;
                ArrayList arrayList = new ArrayList(p.r((Iterable)obj2, 10));
                Iterator iterator = obj2.iterator();
                for (Object next6 : iterator) {
                    arrayList.add(String.valueOf(next6));
                }
                trackAmplitude = arrayList.toArray(new String[jSONObject]);
                Objects.requireNonNull(trackAmplitude, "null cannot be cast to non-null type kotlin.Array<T>");
                valueOf4 = new l();
                valueOf4.d(q3.getKey(), (String[])trackAmplitude);
                this.c.u(valueOf4);
            } else {
                if (object2 instanceof Map != null) {
                    trackAmplitude = new JSONObject();
                    Iterator iterator2 = (Map)object2.entrySet().iterator();
                    for (Map.Entry next4 : iterator2) {
                        trackAmplitude.put(String.valueOf(next4.getKey()), String.valueOf(next4.getValue()));
                    }
                    valueOf4 = new l();
                    valueOf4.c(q3.getKey(), trackAmplitude);
                    this.c.u(valueOf4);
                } else {
                    if (object2 != null) {
                        if (object2 instanceof String != null && l.z((CharSequence)object2)) {
                            if (l.z((CharSequence)object2)) {
                                lVar = new l();
                                lVar.f(q3.getKey());
                                this.c.u(lVar);
                            } else {
                                valueOf4 = new l();
                                valueOf4.b(q3.getKey(), object2.toString());
                                this.c.u(valueOf4);
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
        }
        valueOf = 0;
        if (q3.getTrackFirebase()) {
            if (object2 instanceof List != null) {
                string2 = p.h0((Iterable)object2, ",", 0, 0, 0, 0, 0, 62, 0);
            } else {
                if (object2 == null) {
                    string2 = valueOf;
                } else {
                    string2 = object2.toString();
                }
            }
            int i6 = 24;
            if (q3.getKey().length() > i6) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Firebase user property length can be at most ");
                stringBuilder.append(i6);
                stringBuilder.append(" chars, but tried to use ");
                stringBuilder.append(q3.getKey());
                stringBuilder.append(" which is ");
                stringBuilder.append(q3.getKey().length());
                stringBuilder.append(" chars length.Will shorten the length of the property key");
                illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                a.d(illegalArgumentException);
            }
            String key4 = q3.getKey();
            Objects.requireNonNull(key4, "null cannot be cast to non-null type java.lang.String");
            valueOf4 = key4.substring(jSONObject, g.e(q3.getKey().length(), i6));
            string = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            n.e(valueOf4, string);
            if (string2 == null) {
                trackFirebase = valueOf;
            } else {
                n.e(string2.substring(jSONObject, g.e(string2.length(), 36)), string);
            }
            this.b.setUserProperty(valueOf4, trackFirebase);
        }
        if (q3.getTrackIterable()) {
            trackIterable = new JSONObject();
            if (object2 instanceof List != null) {
                jSONObject = new JSONArray();
                obj14 = (Iterable)object2.iterator();
                for (Object next : obj14) {
                    jSONObject.put(String.valueOf(next));
                }
                trackIterable.put(q3.getKey(), jSONObject);
            } else {
                if (object2 instanceof Map != null) {
                    jSONObject = new JSONObject();
                    obj14 = (Map)object2.entrySet().iterator();
                    for (Map.Entry next2 : obj14) {
                        jSONObject.put(String.valueOf(next2.getKey()), String.valueOf(next2.getValue()));
                    }
                    trackIterable.put(q3.getKey(), jSONObject);
                } else {
                    if (object2 == null) {
                    } else {
                        valueOf = object2.toString();
                    }
                    if (valueOf == null) {
                        valueOf = "";
                    }
                    trackIterable.put(q3.getKey(), valueOf);
                }
            }
            this.f.e0(trackIterable);
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void r(a a) {
        n.f(a, "deviceData");
        App.a companion = App.Companion;
        companion.r().q(q3.Locale, a.e());
        companion.r().w(a.f());
        companion.r().q(q3.FcmToken, a.d());
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void s(String string) {
        n.f(string, "source");
        a2 a2Var = new a2();
        r2 r2Var = new r2();
        d(z.a.c(a2Var, "The Internet connection appears to be offline.", r2Var, string));
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void t(RemindersModel remindersModel) {
        n.f(remindersModel, "reminder");
        l2 l2Var = new l2();
        g1 g1Var = new g1();
        d(k0.b.d(u.a(l2Var, remindersModel.getTime()), u.a(g1Var, remindersModel.getReminderShortWeekdayStrings())));
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void u(String string, int i2, String string3) {
        int i3;
        int i;
        app.dogo.com.dogo_android.w.r2 r2Var;
        Object obj2;
        app.dogo.com.dogo_android.w.n2 n2Var;
        Object obj;
        app.dogo.com.dogo_android.w.v1 v1Var;
        Integer valueOf;
        Object obj9;
        n.f(string, "trickId");
        n.f(string3, "screenName");
        r2Var = new r2();
        n2Var = new n2();
        v1Var = new v1();
        d(p0.a.c(r2Var, string3, n2Var, string, v1Var, Integer.valueOf(i2)));
        i3 = 0;
        i = 1;
        if (i <= i2 && i2 <= 3) {
            if (i2 <= 3) {
                i3 = i;
            }
        }
        if (i3 != 0) {
            r2Var = new r2();
            n2Var = new n2();
            v1Var = new v1();
            d(p0.b.c(r2Var, string3, n2Var, string, v1Var, Integer.valueOf(i2)));
        }
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void v(String string) {
        App.Companion.r().q(q3.Locale, n2.a.a(string));
    }

    @Override // com.appsflyer.AppsFlyerConversionListener
    public final void w(String string) {
        n.f(string, "timezone");
        App.a companion = App.Companion;
        companion.r().q(q3.Timezone, string);
        companion.r().q(q3.IterableTimezone, string);
    }
}
