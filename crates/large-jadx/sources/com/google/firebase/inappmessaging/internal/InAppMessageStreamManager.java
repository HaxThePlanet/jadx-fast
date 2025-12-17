package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.j;
import com.google.firebase.inappmessaging.CommonTypesProto.Event;
import com.google.firebase.inappmessaging.CommonTypesProto.Priority;
import com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition;
import com.google.firebase.inappmessaging.MessagesProto.Content;
import com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ProtoMarshallerClient;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.protobuf.z.a;
import f.c.f.a.a.a.b;
import f.c.f.a.a.a.c;
import f.c.f.a.a.a.c.c;
import f.c.f.a.a.a.d;
import f.c.f.a.a.a.e.b;
import f.c.f.a.a.a.e.e;
import f.c.f.a.a.a.e.e.b;
import i.b.a0;
import i.b.b;
import i.b.f;
import i.b.h;
import i.b.k0.a;
import i.b.l;
import i.b.l0.n;
import i.b.m;
import i.b.p;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import m.c.a;

/* loaded from: classes2.dex */
public class InAppMessageStreamManager {

    public static final String ON_FOREGROUND = "ON_FOREGROUND";
    private final com.google.firebase.inappmessaging.internal.AbtIntegrationHelper abtIntegrationHelper;
    private final com.google.firebase.inappmessaging.internal.AnalyticsEventsManager analyticsEventsManager;
    private final com.google.firebase.inappmessaging.internal.ApiClient apiClient;
    private final a<String> appForegroundEventFlowable;
    private final RateLimit appForegroundRateLimit;
    private final com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient;
    private final a<String> programmaticTriggerEventFlowable;
    private final com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient;
    private final com.google.firebase.inappmessaging.internal.Schedulers schedulers;
    private final com.google.firebase.inappmessaging.internal.TestDeviceHelper testDeviceHelper;
    public InAppMessageStreamManager(a<String> a, a<String> a2, com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient3, Clock clock4, com.google.firebase.inappmessaging.internal.ApiClient apiClient5, com.google.firebase.inappmessaging.internal.AnalyticsEventsManager analyticsEventsManager6, com.google.firebase.inappmessaging.internal.Schedulers schedulers7, com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient8, com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient9, RateLimit rateLimit10, com.google.firebase.inappmessaging.internal.TestDeviceHelper testDeviceHelper11, FirebaseInstallationsApi firebaseInstallationsApi12, com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper13, com.google.firebase.inappmessaging.internal.AbtIntegrationHelper abtIntegrationHelper14) {
        super();
        this.appForegroundEventFlowable = a;
        this.programmaticTriggerEventFlowable = a2;
        this.campaignCacheClient = campaignCacheClient3;
        this.clock = clock4;
        this.apiClient = apiClient5;
        this.analyticsEventsManager = analyticsEventsManager6;
        this.schedulers = schedulers7;
        this.impressionStorageClient = impressionStorageClient8;
        this.rateLimiterClient = rateLimiterClient9;
        this.appForegroundRateLimit = rateLimit10;
        this.testDeviceHelper = testDeviceHelper11;
        this.dataCollectionHelper = dataCollectionHelper13;
        this.firebaseInstallations = firebaseInstallationsApi12;
        this.abtIntegrationHelper = abtIntegrationHelper14;
    }

    static f A(Throwable throwable) {
        return b.f();
    }

    private void B(e e) {
        this.campaignCacheClient.put(e).j(h1.a).k(a1.a).t(k1.a).u();
    }

    static void D(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Impression store read fail: ");
        stringBuilder.append(throwable.getMessage());
        Logging.logw(stringBuilder.toString());
    }

    static void E(c c, Boolean boolean2) {
        InAppMessageStreamManager.logImpressionStatus(c, boolean2);
    }

    static boolean F(Boolean boolean) {
        return obj0 ^= 1;
    }

    static void G(Boolean boolean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("App foreground rate limited ? : ");
        stringBuilder.append(boolean);
        Logging.logi(stringBuilder.toString());
    }

    static boolean H(Boolean boolean) {
        return obj0 ^= 1;
    }

    static c I(c c, Boolean boolean2) {
        return c;
    }

    private boolean J(c c) {
        Clock deviceInTestMode;
        int obj2;
        if (!this.testDeviceHelper.isDeviceInTestMode()) {
            if (InAppMessageStreamManager.isActive(this.clock, c)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    static boolean L(String string, c c2) {
        return InAppMessageStreamManager.containsTriggeringCondition(string, c2);
    }

    private p M(String string, c c2) {
        return triggeredInAppMessage(c2, string);
    }

    static void O(m m, Object object2) {
        m.onSuccess(object2);
        m.onComplete();
    }

    static void P(m m, Exception exception2) {
        m.onError(exception2);
        m.onComplete();
    }

    static void Q(j j, m m2) {
        l1 l1Var = new l1(m2);
        j.addOnSuccessListener(l1Var);
        y0 y0Var = new y0(m2);
        j.addOnFailureListener(y0Var);
    }

    public static boolean a(com.google.firebase.inappmessaging.internal.InstallationIdResult installationIdResult) {
        return InAppMessageStreamManager.validIID(installationIdResult);
    }

    public static int b(c c, c c2) {
        return InAppMessageStreamManager.compareByPriority(c, c2);
    }

    static void c(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event Triggered: ");
        stringBuilder.append(string);
        Logging.logd(stringBuilder.toString());
    }

    static e cacheExpiringResponse() {
        e.b bVar = e.g();
        bVar.b(1);
        return (e)bVar.build();
    }

    private static int compareByPriority(c c, c c2) {
        boolean z2;
        boolean z;
        if (c.e() && !c2.e()) {
            if (!c2.e()) {
                return -1;
            }
        }
        if (c2.e() && !c.e()) {
            if (!c.e()) {
                return 1;
            }
        }
        return Integer.compare(c.g().getValue(), c2.g().getValue());
    }

    private static boolean containsTriggeringCondition(String string, c c2) {
        boolean appForegroundEvent;
        int i;
        boolean fiamTrigger;
        final int i2 = 1;
        if (InAppMessageStreamManager.isAppForegroundEvent(string) && c2.e()) {
            if (c2.e()) {
                return i2;
            }
        }
        Iterator obj5 = c2.h().iterator();
        i = 0;
        for (CommonTypesProto.TriggeringCondition appForegroundEvent : obj5) {
            i = 0;
        }
        return i;
    }

    static void d(e e) {
        Logging.logd("Fetched from cache");
    }

    static c e(c c, Boolean boolean2) {
        return c;
    }

    private l f(c c) {
        boolean filter;
        com.google.firebase.inappmessaging.internal.h0 h0Var;
        l obj3;
        if (c.e()) {
            obj3 = l.p(c);
        } else {
            z0 z0Var = new z0(c);
            h0Var = new h0(c);
            obj3 = this.impressionStorageClient.isImpressed(c).doOnError(b1.a).onErrorResumeNext(a0.just(Boolean.FALSE)).doOnSuccess(z0Var).filter(i1.a).q(h0Var);
        }
        return obj3;
    }

    private l<c> getContentIfNotRateLimited(String string, c c2) {
        String obj2;
        if (!c2.e() && InAppMessageStreamManager.isAppForegroundEvent(string)) {
            if (InAppMessageStreamManager.isAppForegroundEvent(string)) {
                j0 j0Var = new j0(c2);
                return this.rateLimiterClient.isRateLimited(this.appForegroundRateLimit).doOnSuccess(d1.a).onErrorResumeNext(a0.just(Boolean.FALSE)).filter(e1.a).q(j0Var);
            }
        }
        return l.p(c2);
    }

    private l<TriggeredInAppMessage> getTriggeredInAppMessageMaybe(String string, n<c, l<c>> n2, n<c, l<c>> n3, n<c, l<c>> n4, e e5) {
        f0 f0Var = new f0(this);
        p0 p0Var = new p0(string);
        g1 obj4 = new g1(this, string);
        return h.A(e5.f()).m(f0Var).m(p0Var).t(n2).t(n3).t(n4).X(v0.a).n().k(obj4);
    }

    private l h(String string, c c2) {
        return getContentIfNotRateLimited(string, c2);
    }

    private static boolean hasAnalyticsTrigger(CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition, String string2) {
        return triggeringCondition.getEvent().getName().equals(string2);
    }

    private static boolean hasFiamTrigger(CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition, String string2) {
        return triggeringCondition.getFiamTrigger().toString().equals(string2);
    }

    private static boolean isActive(Clock clock, c c2) {
        boolean equals;
        com.google.protobuf.z bVar;
        int i;
        c.c eXPERIMENTAL_PAYLOAD;
        long l;
        long obj6;
        com.google.protobuf.z obj7;
        i = 0;
        if (c2.f().equals(c.c.VANILLA_PAYLOAD)) {
            eXPERIMENTAL_PAYLOAD = c2.i().e();
            l = c2.i().c();
            obj6 = clock.now();
            if (Long.compare(obj6, eXPERIMENTAL_PAYLOAD) > 0 && Long.compare(obj6, l) < 0) {
                if (Long.compare(obj6, l) < 0) {
                    i = 1;
                }
            }
        } else {
            if (c2.f().equals(c.c.EXPERIMENTAL_PAYLOAD)) {
                eXPERIMENTAL_PAYLOAD = c2.d().e();
                l = c2.d().c();
            }
        }
        return i;
    }

    public static boolean isAppForegroundEvent(CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition) {
        return triggeringCondition.getFiamTrigger().toString().equals("ON_FOREGROUND");
    }

    public static boolean isAppForegroundEvent(String string) {
        return string.equals("ON_FOREGROUND");
    }

    static l j(c c) {
        int i;
        int i2 = InAppMessageStreamManager.1.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[c.getContent().getMessageDetailsCase().ordinal()];
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        Logging.logd("Filtering non-displayable message");
                        return l.i();
                    }
                }
            }
        }
        return l.p(c);
    }

    private l k(String string, n n2, n n3, n n4, e e5) {
        return getTriggeredInAppMessageMaybe(string, n2, n3, n4, e5);
    }

    private static void logImpressionStatus(c c, Boolean boolean2) {
        Object[] equals;
        c.c eXPERIMENTAL_PAYLOAD;
        String obj5;
        int i = 1;
        final int i2 = 0;
        final int i3 = 2;
        if (c.f().equals(c.c.VANILLA_PAYLOAD)) {
            equals = new Object[i3];
            equals[i2] = c.i().d();
            equals[i] = boolean2;
            Logging.logi(String.format("Already impressed campaign %s ? : %s", equals));
        } else {
            if (c.f().equals(c.c.EXPERIMENTAL_PAYLOAD)) {
                equals = new Object[i3];
                equals[i2] = c.d().d();
                equals[i] = boolean2;
                Logging.logi(String.format("Already impressed experiment %s ? : %s", equals));
            }
        }
    }

    static void m(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Impressions store read fail: ");
        stringBuilder.append(throwable.getMessage());
        Logging.logw(stringBuilder.toString());
    }

    private e n(b b, com.google.firebase.inappmessaging.internal.InstallationIdResult installationIdResult2) {
        return this.apiClient.getFiams(installationIdResult2, b);
    }

    static void p(e e) {
        Object[] arr = new Object[1];
        Logging.logi(String.format(Locale.US, "Successfully fetched %d messages from backend", Integer.valueOf(e.f().size())));
    }

    private void q(e e) {
        this.impressionStorageClient.clearImpressions(e).u();
    }

    static void s(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Service fetch error: ");
        stringBuilder.append(throwable.getMessage());
        Logging.logw(stringBuilder.toString());
    }

    private boolean shouldIgnoreCache(String string) {
        if (this.testDeviceHelper.isAppInstallFresh()) {
            return InAppMessageStreamManager.isAppForegroundEvent(string);
        }
        return this.testDeviceHelper.isDeviceInTestMode();
    }

    static void t(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cache read error: ");
        stringBuilder.append(throwable.getMessage());
        Logging.logw(stringBuilder.toString());
    }

    private static <T> l<T> taskToMaybe(j<T> j) {
        j1 j1Var = new j1(j);
        return l.e(j1Var);
    }

    private l<TriggeredInAppMessage> triggeredInAppMessage(c c, String string2) {
        String campaignId;
        String str;
        boolean abtIntegrationHelper;
        com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayload;
        if (c.f().equals(c.c.VANILLA_PAYLOAD)) {
            campaignId = c.i().getCampaignId();
            str = c.i().d();
            InAppMessage obj5 = ProtoMarshallerClient.decode(c.getContent(), campaignId, str, c.e(), c.c());
            if (obj5.getMessageType().equals(MessageType.UNSUPPORTED)) {
                return l.i();
            }
            TriggeredInAppMessage triggeredInAppMessage = new TriggeredInAppMessage(obj5, string2);
            return l.p(triggeredInAppMessage);
        } else {
            campaignId = c.d().getCampaignId();
            str = c.d().d();
            if (c.f().equals(c.c.EXPERIMENTAL_PAYLOAD) && !c.e()) {
                campaignId = c.d().getCampaignId();
                str = c.d().d();
                if (!c.e()) {
                    this.abtIntegrationHelper.setExperimentActive(c.d().g());
                }
            }
        }
        return l.i();
    }

    private l u(l l, b b2) {
        if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logi("Automatic data collection is disabled, not attempting campaign fetch from service.");
            return l.p(InAppMessageStreamManager.cacheExpiringResponse());
        }
        x0 x0Var = new x0(this, b2);
        k0 obj3 = new k0(this);
        obj3 = this.analyticsEventsManager;
        Objects.requireNonNull(obj3);
        i2 i2Var = new i2(obj3);
        obj3 = this.testDeviceHelper;
        Objects.requireNonNull(obj3);
        m1 m1Var = new m1(obj3);
        return l.j(i0.a).q(x0Var).z(l.p(InAppMessageStreamManager.cacheExpiringResponse())).h(l0.a).h(obj3).h(i2Var).h(m1Var).g(c1.a).s(l.i());
    }

    private static boolean validIID(com.google.firebase.inappmessaging.internal.InstallationIdResult installationIdResult) {
        boolean obj1;
        if (!TextUtils.isEmpty(installationIdResult.installationId()) && !TextUtils.isEmpty(installationIdResult.installationTokenResult().getToken())) {
            obj1 = !TextUtils.isEmpty(installationIdResult.installationTokenResult().getToken()) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private a w(String string) {
        q0 q0Var = new q0(this);
        f1 f1Var = new f1(this);
        g0 g0Var = new g0(this, string);
        super(this, string, f1Var, g0Var, r0.a);
        l lVar8 = this.impressionStorageClient.getAllImpressions().g(u0.a).f(b.g()).s(l.p(b.g()));
        int i2 = 0;
        s0 s0Var = new s0(this, l.B(InAppMessageStreamManager.taskToMaybe(this.firebaseInstallations.getId()), InAppMessageStreamManager.taskToMaybe(this.firebaseInstallations.getToken(i2)), g2.a).r(this.schedulers.io()));
        if (shouldIgnoreCache(string)) {
            Object[] obj10 = new Object[2];
            obj10[i2] = Boolean.valueOf(this.testDeviceHelper.isDeviceInTestMode());
            obj10[1] = Boolean.valueOf(this.testDeviceHelper.isAppInstallFresh());
            Logging.logi(String.format("Forcing fetch from service rather than cache. Test Device: %s | App Fresh Install: %s", obj10));
            return lVar8.k(s0Var).k(m0Var2).A();
        }
        Logging.logd("Attempting to fetch campaigns using cache");
        return this.campaignCacheClient.get().h(w0.a).g(o0.a).s(l.i()).z(lVar8.k(s0Var).h(q0Var)).k(m0Var2).A();
    }

    static void y() {
        Logging.logd("Wrote to cache");
    }

    static void z(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cache write error: ");
        stringBuilder.append(throwable.getMessage());
        Logging.logw(stringBuilder.toString());
    }

    public void C(e e) {
        B(e);
    }

    public boolean K(c c) {
        return J(c);
    }

    public p N(String string, c c2) {
        return M(string, c2);
    }

    public h<TriggeredInAppMessage> createFirebaseInAppMessageStream() {
        t0 t0Var = new t0(this);
        return h.E(this.appForegroundEventFlowable, this.analyticsEventsManager.getAnalyticsEventsFlowable(), this.programmaticTriggerEventFlowable).j(n0.a).F(this.schedulers.io()).d(t0Var).F(this.schedulers.mainThread());
    }

    public l g(c c) {
        return f(c);
    }

    public l i(String string, c c2) {
        return h(string, c2);
    }

    public l l(String string, n n2, n n3, n n4, e e5) {
        return k(string, n2, n3, n4, e5);
    }

    public e o(b b, com.google.firebase.inappmessaging.internal.InstallationIdResult installationIdResult2) {
        return n(b, installationIdResult2);
    }

    public void r(e e) {
        q(e);
    }

    public l v(l l, b b2) {
        return u(l, b2);
    }

    public a x(String string) {
        return w(string);
    }
}
