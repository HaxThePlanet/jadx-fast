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
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.e0.g.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iterable.iterableapi.j;
import com.revenuecat.purchases.Purchases;
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
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Tracker.kt */
@Metadata(d1 = "\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u0000 Y2\u00020\u0001:\u0002YZB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020$J\u0016\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0012J\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u001e\u0010,\u001a\u00020\u001e2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020\u001e2\u0008\u00100\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u00101\u001a\u00020\u001e2\u0008\u00100\u001a\u0004\u0018\u00010\u001aH\u0016J\u001e\u00102\u001a\u00020\u001e2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000204\u0018\u00010.H\u0016J\u000e\u00105\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208J+\u00106\u001a\u00020\u001e2\u0008\u00109\u001a\u0004\u0018\u00010:2\u0008\u0010;\u001a\u0004\u0018\u00010<2\u0008\u0010=\u001a\u0004\u0018\u00010<H\u0002¢\u0006\u0002\u0010>J\u0006\u0010?\u001a\u00020\u001eJ\u0006\u0010@\u001a\u00020\u001eJ\u0006\u0010A\u001a\u00020\u001eJ\u000e\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020DJ\u0010\u0010E\u001a\u00020\u001e2\u0008\u0010F\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020I2\u0008\u0010J\u001a\u0004\u0018\u000104J\u000e\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020\u001aJ\u000e\u0010P\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020DJ\u001e\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020\u001aJ\u0010\u0010U\u001a\u00020\u001e2\u0008\u0010V\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006[", d2 = {"Lapp/dogo/com/dogo_android/tracking/Tracker;", "Lcom/appsflyer/AppsFlyerConversionListener;", "app", "Landroid/app/Application;", "firebaseTracker", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "amplitudeTracker", "Lcom/amplitude/api/AmplitudeClient;", "facebookTracker", "Lcom/facebook/appevents/AppEventsLogger;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "iterableTracker", "Lcom/iterable/iterableapi/IterableApi;", "appsFlyerTracker", "Lcom/appsflyer/AppsFlyerLib;", "(Landroid/app/Application;Lcom/google/firebase/analytics/FirebaseAnalytics;Lcom/amplitude/api/AmplitudeClient;Lcom/facebook/appevents/AppEventsLogger;Lcom/revenuecat/purchases/Purchases;Lcom/iterable/iterableapi/IterableApi;Lcom/appsflyer/AppsFlyerLib;)V", "currentScreen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "getCurrentScreen", "()Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "setCurrentScreen", "(Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;)V", "parameterMapJsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "isFirstOpenPropertiesSaved", "", "logAppOpen", "", "link", "Lapp/dogo/com/dogo_android/tracking/Tracker$MarketingDeeplink;", "logEvent", "event", "Lapp/dogo/com/dogo_android/tracking/Event0;", "Lapp/dogo/com/dogo_android/tracking/ParameterizedEvent;", "trackToAppsFlyer", "logFirstAppOpen", "logScreenView", "activity", "Landroid/app/Activity;", "screen", "Lapp/dogo/com/dogo_android/tracking/Screen;", "onAppOpenAttribution", "attributionData", "", "onAttributionFailure", "error", "onConversionDataFail", "onConversionDataSuccess", "conversionData", "", "saveFirstAppOpenProperties", "setCurrentDogBirthdayUserProperties", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "birthday", "", "ageInMonth", "", "initialAgeInMonths", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setFirstAppOpenUserProperties", "setFirstOpenBuild", "setFirstOpenVersion", "setTrainingReminderUserProperties", "reminder", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "setUserId", "userId", "setUserProperty", "property", "Lapp/dogo/com/dogo_android/tracking/UserProperty;", "value", "trackDeviceData", "deviceData", "Lapp/dogo/com/dogo_android/temp/Device;", "trackErrorMessage", "source", "trackSetReminder", "trackTrickRating", "trickId", "knowledge", "screenName", "trackUserLocale", "iso2Locale", "updateTimezoneUserProperties", "timezone", "Companion", "MarketingDeeplink", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o3, reason: from kotlin metadata */
public final class Tracker implements AppsFlyerConversionListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final o3.a INSTANCE = new o3$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final Application amplitudeTracker;
    /* renamed from: b, reason: from kotlin metadata */
    private final FirebaseAnalytics appsFlyerTracker;
    private final com.amplitude.api.f c;
    /* renamed from: d, reason: from kotlin metadata */
    private final com.facebook.e0.g facebookTracker;
    /* renamed from: e, reason: from kotlin metadata */
    private final Purchases firebaseTracker;
    /* renamed from: f, reason: from kotlin metadata */
    private final j iterableTracker;
    /* renamed from: g, reason: from kotlin metadata */
    private final AppsFlyerLib parameterMapJsonAdapter;
    /* renamed from: h, reason: from kotlin metadata */
    private com.squareup.moshi.f<Map<String, String>> purchases;
    private i3 i;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/tracking/Tracker$Companion;", "", "()V", "AMPLITUDE_UNIFIED_PROJECT_KEY", "", "APPSFLYER_CAMPAIGN_KEY", "APPSFLYER_MEDIA_SOURCE_KEY", "APP_FLYER_DEEPLINK_KEY", "MAX_FIREBASE_EVENT_KEY_LENGTH", "", "MAX_FIREBASE_EVENT_PARAM_KEY_LENGTH", "MAX_FIREBASE_EVENT_PARAM_VALUE_LENGTH", "MAX_FIREBASE_USER_PROPERTY_KEY_LENGTH", "MAX_FIREBASE_USER_PROPERTY_VALUE_LENGTH", "USER_PROPERTY_VALUE_PREMIUM", "USER_PROPERTY_VALUE_PREMIUM_DOG", "UTM_CAMPAIGN_KEY", "UTM_MEDIUM_KEY", "UTM_SOURCE_KEY", "logException", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final void logException(Exception exception) {
            n.f(exception, "exception");
            if (app.dogo.com.dogo_android.util.extensionfunction.j1.F0(exception)) {
                a.j(exception);
            } else {
                a.d(exception);
            }
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\n2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0008R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/tracking/Tracker$MarketingDeeplink;", "", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "campaign", "", "getCampaign", "()Ljava/lang/String;", "exists", "", "getExists", "()Z", "isAppFlyerLink", "medium", "getMedium", "source", "getSource", "getUri", "()Landroid/net/Uri;", "component1", "copy", "equals", "other", "getCorrectedQueryParameter", "key", "hashCode", "", "toString", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final o3.b.a INSTANCE = new o3$b$a(0);
        private final Uri a;
        /* renamed from: b, reason: from kotlin metadata */
        private final boolean exists;
        /* renamed from: c, reason: from kotlin metadata */
        private final String isAppFlyerLink;
        /* renamed from: d, reason: from kotlin metadata */
        private final String medium;
        /* renamed from: e, reason: from kotlin metadata */
        private final String source;
        private final boolean f = true;
        public b(Uri uri) {
            boolean booleanQueryParameter;
            String str;
            String str2;
            super();
            this.a = uri;
            boolean z = false;
            if (uri == null) {
                int i2 = z;
            } else {
                booleanQueryParameter = uri.getBooleanQueryParameter("af_deeplink", z);
            }
            this.exists = booleanQueryParameter;
            String r2 = booleanQueryParameter ? "media_source" : "utm_source";
            this.isAppFlyerLink = (booleanQueryParameter ? "media_source" : "utm_source");
            this.medium = (booleanQueryParameter ? "media_source" : "utm_source");
            String r1 = booleanQueryParameter ? "campaign" : "utm_medium";
            this.source = (booleanQueryParameter ? "campaign" : "utm_medium");
        }

        /* renamed from: b, reason: from kotlin metadata */
        private final String copy(String uri) {
            String uri2 = null;
            if (this.a == null) {
            } else {
                uri2 = this.a.getQueryParameter(uri);
            }
            if (!(n.b(uri2, "(not set)"))) {
            }
            return uri2;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final String component1() {
            return this.source;
        }

        public final boolean c() {
            return this.f;
        }

        public final String d() {
            return this.medium;
        }

        public final String e() {
            return this.isAppFlyerLink;
        }


        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof Tracker_MarketingDeeplink)) {
                return false;
            }
            return !n.b(this.a, other.a) ? z3 : z;
        }

        public int hashCode() {
            int i = 0;
            if (this.a == null) {
                i = 0;
            } else {
                i = this.a.hashCode();
            }
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "MarketingDeeplink(uri=";
            str = str2 + this.a + 41;
            return str;
        }
    }
    public o3(Application application, FirebaseAnalytics firebaseAnalytics, com.amplitude.api.f fVar, com.facebook.e0.g gVar, Purchases purchases, j jVar, AppsFlyerLib appsFlyerLib) {
        final Class<String> obj = String.class;
        n.f(application, "app");
        n.f(firebaseAnalytics, "firebaseTracker");
        n.f(fVar, "amplitudeTracker");
        n.f(gVar, "facebookTracker");
        n.f(purchases, "purchases");
        n.f(jVar, "iterableTracker");
        n.f(appsFlyerLib, "appsFlyerTracker");
        super();
        this.amplitudeTracker = application;
        this.appsFlyerTracker = firebaseAnalytics;
        this.c = fVar;
        this.facebookTracker = gVar;
        this.firebaseTracker = purchases;
        this.iterableTracker = jVar;
        this.parameterMapJsonAdapter = appsFlyerLib;
        java.lang.reflect.Type[] arr = new Type[2];
        com.squareup.moshi.f fVar2 = new r.a().b().d(t.j(Map.class, new Type[] { obj, obj }));
        n.e(fVar2, "moshi.adapter(parameterMapType)");
        this.purchases = fVar2;
        n();
        m();
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final void setCurrentDogBirthdayUserProperties(Long birthday, Integer ageInMonth, Integer initialAgeInMonths) {
        Integer num = null;
        int i;
        Integer num2;
        i = 0;
        if (birthday != null) {
            Calendar.getInstance().setTimeInMillis(birthday.longValue());
        } else {
        }
        App.a iNSTANCE2 = App.INSTANCE;
        iNSTANCE2.r().setUserProperty(UserProperty.CurrentDogAge, ageInMonth);
        iNSTANCE2.r().setUserProperty(UserProperty.CurrentDogAgeInitial, initialAgeInMonths);
        if (i == 0) {
        } else {
            num2 = Integer.valueOf(i.get(2) + 1);
        }
        iNSTANCE2.r().setUserProperty(UserProperty.CurrentDogBirthdayMonth, num2);
        if (i != 0) {
            num = Integer.valueOf(i.get(5));
        }
        App.INSTANCE.r().setUserProperty(UserProperty.CurrentDogBirthdayDay, num);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final i3 isFirstOpenPropertiesSaved() {
        return this.i;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void logAppOpen(o3.b link) {
        n.f(link, "link");
        String str2 = link.e();
        final String component1 = link.component1();
        String str3 = link.d();
        logEvent(E_General.g.withParameters(u.a(new EP_Campaign(), component1), u.a(new EP_MarketingSource(), str2), u.a(new EP_Medium(), str3)));
        if (str2 != null || str3 == null || component1 != null) {
            setUserProperty(UserProperty.AppOpenCampaign, component1);
            setUserProperty(UserProperty.AppOpenSource, str2);
            setUserProperty(UserProperty.AppOpenMedium, str3);
            this.firebaseTracker.setCampaign(component1);
            this.firebaseTracker.setMediaSource(str2);
        }
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final void logEvent(t2 event) {
        n.f(event, "event");
        logEvent(event.h());
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void logEvent(h3 event) {
        n.f(event, "event");
        logEvent(event, false);
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final void logEvent(h3 event, boolean trackToAppsFlyer) throws JSONException {
        int i3;
        String substring;
        String str;
        String str2;
        Object value;
        JSONObject jSONObject;
        int parsed = 100;
        int i4 = 1;
        int length;
        String str3;
        StringBuilder stringBuilder;
        Object key2;
        String str4;
        char c;
        boolean hasNext2;
        Object key3;
        final Object event3 = this;
        n.f(event, "event");
        Map map2 = event.c();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j0.d(map2.size()));
        Iterator it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Object item4 = it.next();
            linkedHashMap2.put((EventParameter)item4.getKey().a(), item4.getValue());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(linkedHashMap2.size()));
        Iterator it3 = linkedHashMap2.entrySet().iterator();
        i4 = 0;
        substring = "";
        while (it3.hasNext()) {
            Object item3 = it3.next();
            Object value2 = item3.getValue();
            parsed = 100;
            linkedHashMap.put(item3.getKey(), substring);
        }
        Map map = j0.y(linkedHashMap);
        if (!map.containsKey(new EP_CurrentScreen().a())) {
            String r4 = event3.i == null ? "" : substring;
            map.put(new EP_CurrentScreen().a(), (event3.i == null ? "" : substring));
        }
        Bundle bundle = new Bundle();
        Iterator it4 = map.entrySet().iterator();
        i4 = 1;
        while (it4.hasNext()) {
            value = it4.next();
        }
        event3.c.I(event.b(), new JSONObject(event3.purchases.h(map)));
        event3.appsFlyerTracker.logEvent(event.b(), bundle);
        app.dogo.com.dogo_android.util.extensionfunction.j1.k0(event3.facebookTracker, event.a());
        event3.iterableTracker.T(event.b(), new JSONObject(event3.purchases.h(map)));
        if (trackToAppsFlyer) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(j0.d(map.size()));
            Iterator it5 = map.entrySet().iterator();
            while (it5.hasNext()) {
                Object item = it5.next();
                linkedHashMap3.put(item.getKey(), item);
            }
            event3.parameterMapJsonAdapter.logEvent(event3.amplitudeTracker, event.b(), linkedHashMap3);
        }
        i = map.isEmpty() ^ 1;
        if (map.isEmpty() ^ i4) {
            ArrayList arrayList = new ArrayList(map.size());
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Object item2 = it2.next();
                Object stringBuilder3 = new StringBuilder();
                Object key6 = item2.getKey();
                substring = ": ";
                Object value3 = item2.getValue();
                str10 = key6 + substring + value3;
                arrayList.add(str10);
            }
            kotlin.d0.c.l lVar = null;
            int i5 = 60;
            Object obj = null;
            str3 = " with parameters ";
            substring = p.h0(arrayList, ", ", str3, null, 0, null, lVar, i5, obj);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String str11 = "Tracked event: ";
        String str7 = event.b();
        str6 = str11 + str7 + substring;
        a.f(str6, new Object[i4]);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final void logFirstAppOpen(o3.b link) {
        n.f(link, "link");
        String str2 = link.e();
        String str3 = link.d();
        String component1 = link.component1();
        setUserProperty(UserProperty.FirstAppOpenCampaign, component1);
        setUserProperty(UserProperty.FirstAppOpenSource, str2);
        setUserProperty(UserProperty.FirstAppOpenMedium, str3);
        this.firebaseTracker.setCampaign(component1);
        this.firebaseTracker.setMediaSource(str2);
        logEvent(E_General.f.withParameters(u.a(new EP_Campaign(), component1), u.a(new EP_MarketingSource(), str2), u.a(new EP_Medium(), str3)));
    }

    /* renamed from: g, reason: from kotlin metadata */
    public final void logScreenView(Activity activity, i3 screen) throws JSONException {
        boolean trackContentView;
        int i3;
        String str;
        String substring;
        Object value;
        JSONObject jSONObject;
        int i4 = 100;
        int length;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        char c;
        n.f(activity, "activity");
        n.f(screen, "screen");
        this.i = screen;
        Map map = screen.g();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j0.d(map.size()));
        Iterator it3 = map.entrySet().iterator();
        while (it3.hasNext()) {
            Object item3 = it3.next();
            linkedHashMap2.put((EventParameter)item3.getKey().a(), item3.getValue());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(linkedHashMap2.size()));
        Iterator it = linkedHashMap2.entrySet().iterator();
        int i8 = 0;
        substring = "";
        while (it.hasNext()) {
            Object item2 = it.next();
            Object value2 = item2.getValue();
            i4 = 100;
            linkedHashMap.put(item2.getKey(), substring);
        }
        Bundle bundle = new Bundle();
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            Object item4 = it2.next();
            bundle.putString((String)item4.getKey(), (String)item4.getValue());
        }
        String str18 = "view_";
        this.c.I(n.o(str18, screen.a()), new JSONObject(this.purchases.h(linkedHashMap)));
        this.appsFlyerTracker.logEvent(n.o(str18, screen.a()), bundle);
        this.iterableTracker.T(n.o(str18, screen.a()), new JSONObject(this.purchases.h(linkedHashMap)));
        iNSTANCE2 = FBEvent.INSTANCE;
        if (iNSTANCE2.shouldTrackContentView(screen)) {
            app.dogo.com.dogo_android.util.extensionfunction.j1.k0(this.facebookTracker, FBEvent.INSTANCE.viewedContent(screen.a()));
        }
        i = !linkedHashMap.isEmpty();
        if (!linkedHashMap.isEmpty()) {
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            Iterator it4 = linkedHashMap.entrySet().iterator();
            while (it4.hasNext()) {
                Object item = it4.next();
                StringBuilder stringBuilder3 = new StringBuilder();
                Object key3 = item.getKey();
                substring = ": ";
                Object value3 = item.getValue();
                str6 = key3 + substring + value3;
                arrayList.add(str6);
            }
            int i5 = 0;
            java.lang.CharSequence charSequence = null;
            kotlin.d0.c.l lVar = null;
            int i6 = 60;
            Object obj = null;
            str2 = ", ";
            substring = p.h0(arrayList, str2, " with parameters ", null, i5, charSequence, lVar, i6, obj);
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        String str5 = "Tracked event: ";
        String str24 = screen.a();
        str23 = str5 + str24 + substring;
        a.f(str23, new Object[i8]);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public final void logScreenView(Activity activity, k3 screen) {
        n.f(activity, "activity");
        n.f(screen, "screen");
        logScreenView(activity, screen.withoutParameters());
    }

    /* renamed from: i, reason: from kotlin metadata */
    public final void onAppOpenAttribution(o3.b attributionData) {
        n.f(attributionData, "link");
        iNSTANCE2 = App.INSTANCE;
        iNSTANCE2.l().P0(true);
        iNSTANCE2.l().R0(String.valueOf(System.currentTimeMillis()));
        iNSTANCE2.l().S0("7.22.1");
        iNSTANCE2.l().M0(70220100);
        if (attributionData.c()) {
            App.INSTANCE.l().N0(attributionData.component1());
            App.INSTANCE.l().O0(attributionData.d());
            App.INSTANCE.l().Q0(attributionData.e());
        }
    }

    /* renamed from: j, reason: from kotlin metadata */
    public final void onAttributionFailure(DogProfile error) {
        n.f(error, "dogProfile");
        setCurrentDogBirthdayUserProperties(error.getBirthday(), error.getAgeInMonths(), error.getInitialAgeInMonths());
    }

    public final void l() {
        iNSTANCE2 = App.INSTANCE;
        if (iNSTANCE2.l().C() != null) {
            if (App.INSTANCE.l().w() != null) {
                setUserProperty(UserProperty.FirstAppOpenVersion, App.INSTANCE.l().C());
                setUserProperty(UserProperty.FirstAppOpenBuild, App.INSTANCE.l().w());
                setUserProperty(UserProperty.FirstAppOpenCampaign, App.INSTANCE.l().x());
                setUserProperty(UserProperty.FirstAppOpenSource, App.INSTANCE.l().A());
                setUserProperty(UserProperty.FirstAppOpenMedium, App.INSTANCE.l().y());
                setUserProperty(UserProperty.FirstAppOpenTime, App.INSTANCE.l().B());
                setUserProperty(UserProperty.AppOpenCampaign, App.INSTANCE.l().x());
                setUserProperty(UserProperty.AppOpenSource, App.INSTANCE.l().A());
                setUserProperty(UserProperty.AppOpenMedium, App.INSTANCE.l().y());
            }
        }
    }

    public final void m() {
        iNSTANCE2 = App.INSTANCE;
        if (iNSTANCE2.l().w() == null) {
            App.INSTANCE.l().M0(70220100);
            setUserProperty(UserProperty.FirstAppOpenBuild, App.INSTANCE.l().w());
        }
    }

    public final void n() {
        iNSTANCE2 = App.INSTANCE;
        if (iNSTANCE2.l().C() == null) {
            str2 = "7.22.1";
            App.INSTANCE.l().S0(str2);
            setUserProperty(UserProperty.FirstAppOpenVersion, App.INSTANCE.l().C());
        }
    }

    /* renamed from: o, reason: from kotlin metadata */
    public final void onConversionDataFail(RemindersModel error) {
        n.f(error, "reminder");
        App.a iNSTANCE2 = App.INSTANCE;
        iNSTANCE2.r().setUserProperty(UserProperty.TrainingReminderWeekdays, error.getReminderWeekdayStrings());
        iNSTANCE2.r().setUserProperty(UserProperty.TrainingReminderTimeMin, error.getReminderTimeInMinutes());
        iNSTANCE2.r().setUserProperty(UserProperty.TrainingReminderEnabled, Boolean.valueOf(error.isActive()));
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        String str;
        if (map != null) {
            Object value = map.get("media_source");
            str = "campaign";
            Object value2 = map.get(str);
            if (value2 != null) {
                setUserProperty(UserProperty.AppOpenCampaign, value2);
            }
            if (value != null) {
                setUserProperty(UserProperty.AppOpenSource, value);
            }
        }
    }

    public void onAttributionFailure(String str) {
        a.c(n.o("AppsFlyer attribution failure: ", str), new Object[0]);
    }

    public void onConversionDataFail(String str) {
        a.c(n.o("AppsFlyer conversion data failure: ", str), new Object[0]);
    }

    public void onConversionDataSuccess(Map<String, Object> conversionData) {
        String str;
        if (conversionData != null) {
            Object value = conversionData.get("media_source");
            str = "campaign";
            Object value2 = conversionData.get(str);
            if (value2 != null) {
                setUserProperty(UserProperty.FirstAppOpenCampaign, value2);
            }
            if (value != null) {
                setUserProperty(UserProperty.FirstAppOpenSource, value);
            }
        }
    }

    /* renamed from: p, reason: from kotlin metadata */
    public final void saveFirstAppOpenProperties(String link) {
        String str;
        setUserProperty(UserProperty.UserId, link);
        this.c.c0(link);
        this.parameterMapJsonAdapter.setCustomerIdAndLogSession(link, this.amplitudeTracker);
        this.iterableTracker.Q(link);
        if (link == null) {
            str = "";
        }
        AppEventsLogger.b.h(str);
    }

    /* renamed from: q, reason: from kotlin metadata */
    public final void setUserProperty(q3 property, Object value) {
        String object;
        String substring;
        JSONObject jSONObject;
        boolean hasNext;
        String object2 = null;
        com.amplitude.api.l lVar;
        String str2;
        int i4 = 36;
        java.lang.CharSequence charSequence2 = null;
        int i5 = 0;
        int length2;
        java.lang.CharSequence charSequence3 = null;
        kotlin.d0.c.l lVar2 = null;
        int i6 = 62;
        Object obj = null;
        Iterator it;
        n.f(property, "property");
        int i2 = 0;
        if (property.getTrackAmplitude()) {
            if (value instanceof List) {
                Iterable iterable = value;
                ArrayList arrayList = new ArrayList(p.r(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    arrayList.add(String.valueOf(it2.next()));
                }
                Object[] array = arrayList.toArray(new String[i2]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                lVar = new l();
                lVar.d(property.getKey(), array);
                this.c.u(lVar);
            } else {
                z = value instanceof Map;
                if (value instanceof Map) {
                    JSONObject jSONObject3 = new JSONObject();
                    Iterator it3 = (Map)value.entrySet().iterator();
                    while (it3.hasNext()) {
                        Object item3 = it3.next();
                        jSONObject3.put(String.valueOf(item3.getKey()), String.valueOf(item3.getValue()));
                    }
                    lVar = new l();
                    lVar.c(property.getKey(), jSONObject3);
                    this.c.u(lVar);
                } else {
                    if (value != null) {
                        z = value instanceof String;
                        if (value instanceof String) {
                            if (l.z((CharSequence)value)) {
                                com.amplitude.api.l lVar3 = new l();
                                lVar3.f(property.getKey());
                                this.c.u(lVar3);
                            } else {
                                lVar = new l();
                                lVar.b(property.getKey(), value.toString());
                                this.c.u(lVar);
                            }
                        }
                    }
                }
            }
        }
        int i = 0;
        if (property.getTrackFirebase()) {
            if (value instanceof List) {
                java.lang.CharSequence charSequence = null;
                charSequence2 = null;
                i5 = 0;
                charSequence3 = null;
                lVar2 = null;
                i6 = 62;
                obj = null;
                str2 = ",";
                object = p.h0((Iterable)value, str2, charSequence, charSequence2, i5, charSequence3, lVar2, i6, obj);
            } else {
                if (value == null) {
                } else {
                    object = value.toString();
                }
            }
            int i7 = 24;
            i4 = 36;
            if (property.getKey().length() > i7) {
                StringBuilder stringBuilder = new StringBuilder();
                String str13 = "Firebase user property length can be at most ";
                String str14 = " chars, but tried to use ";
                String key8 = property.getKey();
                String str15 = " which is ";
                int length4 = property.getKey().length();
                String str16 = " chars length.Will shorten the length of the property key";
                str11 = str13 + i7 + str14 + key8 + str15 + length4 + str16;
                a.d(new IllegalArgumentException(str11));
            }
            String key6 = property.getKey();
            Objects.requireNonNull(key6, "null cannot be cast to non-null type java.lang.String");
            String substring2 = key6.substring(i2, g.e(property.getKey().length(), i7));
            str4 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            n.e(substring2, str4);
            if (this.c == null) {
            } else {
                n.e(object.substring(i2, g.e(object.length(), 36)), str4);
            }
            this.appsFlyerTracker.setUserProperty(substring2, substring);
        }
        if (property.getTrackIterable()) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                it = value.iterator();
                while (it.hasNext()) {
                    jSONArray.put(String.valueOf(it.next()));
                }
                jSONObject2.put(property.getKey(), jSONArray);
                jSONObject = new JSONObject();
                it = value.entrySet().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    jSONObject.put(String.valueOf(item.getKey()), String.valueOf(item.getValue()));
                }
                jSONObject2.put(property.getKey(), jSONObject);
                if (value != null) {
                    object2 = value.toString();
                }
                if (this.c == null) {
                    object2 = "";
                }
                jSONObject2.put(property.getKey(), object2);
            } catch (org.json.JSONException jSON) {
                a.d(jSON);
            }
            this.iterableTracker.e0(jSONObject2);
        }
    }

    /* renamed from: r, reason: from kotlin metadata */
    public final void setCurrentDogBirthdayUserProperties(app.dogo.com.dogo_android.v.a dogProfile) {
        n.f(dogProfile, "deviceData");
        App.a iNSTANCE2 = App.INSTANCE;
        iNSTANCE2.r().setUserProperty(UserProperty.Locale, dogProfile.e());
        iNSTANCE2.r().trackErrorMessage(dogProfile.f());
        iNSTANCE2.r().setUserProperty(UserProperty.FcmToken, dogProfile.d());
    }

    /* renamed from: s, reason: from kotlin metadata */
    public final void setTrainingReminderUserProperties(String reminder) {
        n.f(reminder, "source");
        logEvent(E_Error.a.c(new EP_Message(), "The Internet connection appears to be offline.", new EP_ViewSource(), reminder));
    }

    /* renamed from: t, reason: from kotlin metadata */
    public final void setUserId(RemindersModel userId) {
        n.f(userId, "reminder");
        logEvent(E_Reminders.b.withParameters(u.a(new EP_Time(), userId.getTime()), u.a(new EP_Day(), userId.getReminderShortWeekdayStrings())));
    }

    /* renamed from: u, reason: from kotlin metadata */
    public final void trackTrickRating(String trickId, int knowledge, String screenName) {
        int i = 0;
        app.dogo.com.dogo_android.w.r2 eP_ViewSource;
        n.f(trickId, "trickId");
        n.f(screenName, "screenName");
        logEvent(E_Training.a.c(new EP_ViewSource(), screenName, new EP_TrickId(), trickId, new EP_Knowledge(), Integer.valueOf(knowledge)));
        i = 0;
        i = 1;
        if (i <= knowledge && knowledge <= 3) {
        }
        if (i != 0) {
            logEvent(E_Training.b.c(new EP_ViewSource(), screenName, new EP_TrickId(), trickId, new EP_Knowledge(), Integer.valueOf(knowledge)));
        }
    }

    /* renamed from: v, reason: from kotlin metadata */
    public final void trackDeviceData(String deviceData) {
        App.INSTANCE.r().setUserProperty(UserProperty.Locale, LocaleService.a.a(deviceData));
    }

    /* renamed from: w, reason: from kotlin metadata */
    public final void trackErrorMessage(String source) {
        n.f(source, "timezone");
        App.a iNSTANCE2 = App.INSTANCE;
        iNSTANCE2.r().setUserProperty(UserProperty.Timezone, source);
        iNSTANCE2.r().setUserProperty(UserProperty.IterableTimezone, source);
    }

}
