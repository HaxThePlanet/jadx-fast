package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.CampaignMetadata;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.protobuf.z.a;
import f.c.f.a.a.a.e.a;
import f.c.f.a.a.a.e.a.b;
import i.b.b;
import i.b.l;
import i.b.p;
import i.b.z;

/* loaded from: classes2.dex */
public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {

    private static final String MESSAGE_CLICK = "message click to metrics logger";
    private static boolean wasImpressed;
    private final RateLimit appForegroundRateLimit;
    private final com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper;
    private final com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient;
    private final InAppMessage inAppMessage;
    private final com.google.firebase.inappmessaging.internal.MetricsLoggerClient metricsLoggerClient;
    private final com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient;
    private final com.google.firebase.inappmessaging.internal.Schedulers schedulers;
    private final String triggeringEvent;
    DisplayCallbacksImpl(com.google.firebase.inappmessaging.internal.ImpressionStorageClient impressionStorageClient, Clock clock2, com.google.firebase.inappmessaging.internal.Schedulers schedulers3, com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient4, com.google.firebase.inappmessaging.internal.CampaignCacheClient campaignCacheClient5, RateLimit rateLimit6, com.google.firebase.inappmessaging.internal.MetricsLoggerClient metricsLoggerClient7, com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper8, InAppMessage inAppMessage9, String string10) {
        super();
        this.impressionStorageClient = impressionStorageClient;
        this.clock = clock2;
        this.schedulers = schedulers3;
        this.rateLimiterClient = rateLimiterClient4;
        this.campaignCacheClient = campaignCacheClient5;
        this.appForegroundRateLimit = rateLimit6;
        this.metricsLoggerClient = metricsLoggerClient7;
        this.dataCollectionHelper = dataCollectionHelper8;
        this.inAppMessage = inAppMessage9;
        this.triggeringEvent = string10;
        DisplayCallbacksImpl.wasImpressed = false;
    }

    private void a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason) {
        this.metricsLoggerClient.logRenderError(this.inAppMessage, inAppMessagingErrorReason);
    }

    private boolean actionMatches(Action action, Action action2) {
        int obj1;
        if (!action) {
            if (action2 != null) {
                if (TextUtils.isEmpty(action2.getActionUrl())) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
            return obj1;
        }
        return action.getActionUrl().equals(action2.getActionUrl());
    }

    private void c() {
        this.metricsLoggerClient.logImpression(this.inAppMessage);
    }

    private void e(Action action) {
        this.metricsLoggerClient.logMessageClick(this.inAppMessage, action);
    }

    static void g(Throwable throwable) {
        Logging.loge("Impression store write failure");
    }

    static void h() {
        Logging.logd("Impression store write success");
    }

    static void i(Throwable throwable) {
        Logging.loge("Rate limiter client write failure");
    }

    static void j() {
        Logging.logd("Rate limiter client write success");
    }

    static p k(k k, Throwable throwable2) {
        boolean runtimeException;
        if (throwable2 instanceof Exception != null) {
            k.b((Exception)throwable2);
        } else {
            runtimeException = new RuntimeException(throwable2);
            k.b(runtimeException);
        }
        return l.i();
    }

    static Object l(k k) {
        final int i = 0;
        k.c(i);
        return i;
    }

    private void logActionNotTaken(String string) {
        logActionNotTaken(string, 0);
    }

    private void logActionNotTaken(String string, l<String> l2) {
        Object[] arr;
        String obj4;
        Object[] obj5;
        final int i = 1;
        final int i2 = 0;
        if (l2 != null) {
            arr = new Object[2];
            arr[i2] = string;
            arr[i] = l2;
            Logging.logd(String.format("Not recording: %s. Reason: %s", arr));
        } else {
            if (this.inAppMessage.getCampaignMetadata().getIsTestMessage()) {
                obj5 = new Object[i];
                obj5[i2] = string;
                Logging.logd(String.format("Not recording: %s. Reason: Message is test message", obj5));
            } else {
                if (!this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
                    obj5 = new Object[i];
                    obj5[i2] = string;
                    Logging.logd(String.format("Not recording: %s. Reason: Data collection is disabled", obj5));
                } else {
                    obj5 = new Object[i];
                    obj5[i2] = string;
                    Logging.logd(String.format("Not recording: %s", obj5));
                }
            }
        }
    }

    private j<Void> logImpressionIfNeeded(b b) {
        if (!DisplayCallbacksImpl.wasImpressed) {
            impressionDetected();
        }
        return DisplayCallbacksImpl.maybeToTask(b.z(), this.schedulers.io());
    }

    private j<Void> logMessageClick(Action action) {
        Logging.logd("Attempting to record: message click to metrics logger");
        w wVar = new w(this, action);
        return logImpressionIfNeeded(b.n(wVar));
    }

    private b logToImpressionStore() {
        b bVar;
        boolean appForegroundEvent;
        Object bVar2;
        String campaignId = this.inAppMessage.getCampaignMetadata().getCampaignId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempting to record message impression in impression store for id: ");
        stringBuilder.append(campaignId);
        Logging.logd(stringBuilder.toString());
        bVar2 = a.e();
        bVar2.c(this.clock.now());
        bVar2.b(campaignId);
        if (InAppMessageStreamManager.isAppForegroundEvent(this.triggeringEvent)) {
            bVar = this.rateLimiterClient.increment(this.appForegroundRateLimit).k(q.a).j(t.a).r().c(this.impressionStorageClient.storeImpression((a)bVar2.build()).k(o.a).j(x.a));
        }
        return bVar;
    }

    private void m(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType) {
        this.metricsLoggerClient.logDismiss(this.inAppMessage, inAppMessagingDismissType);
    }

    private static <T> j<T> maybeToTask(l<T> l, z z2) {
        k kVar = new k();
        h2 h2Var = new h2(kVar);
        n nVar = new n(kVar);
        p pVar = new p(kVar);
        l.h(h2Var).z(l.n(nVar)).t(pVar).x(z2).u();
        return kVar.a();
    }

    static void o() {
        DisplayCallbacksImpl.wasImpressed = true;
    }

    private boolean shouldLog() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    private b updateWasImpressed() {
        return b.n(r.a);
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public void b(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason) {
        a(inAppMessagingErrorReason);
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public void d() {
        c();
    }

    public j<Void> displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason) {
        final String str = "render error to metrics logger";
        if (shouldLog()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempting to record: ");
            stringBuilder.append(str);
            Logging.logd(stringBuilder.toString());
            s sVar = new s(this, inAppMessagingErrorReason);
            return DisplayCallbacksImpl.maybeToTask(logToImpressionStore().c(b.n(sVar)).c(updateWasImpressed()).z(), this.schedulers.io());
        }
        logActionNotTaken(str);
        k obj4 = new k();
        return obj4.a();
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public void f(Action action) {
        e(action);
    }

    public j<Void> impressionDetected() {
        boolean wasImpressed;
        String str = "message impression to metrics logger";
        if (shouldLog() && !DisplayCallbacksImpl.wasImpressed) {
            if (!DisplayCallbacksImpl.wasImpressed) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Attempting to record: ");
                stringBuilder.append(str);
                Logging.logd(stringBuilder.toString());
                u uVar = new u(this);
                return DisplayCallbacksImpl.maybeToTask(logToImpressionStore().c(b.n(uVar)).c(updateWasImpressed()).z(), this.schedulers.io());
            }
        }
        logActionNotTaken(str);
        k kVar = new k();
        return kVar.a();
    }

    @Deprecated
    public j<Void> messageClicked() {
        return messageClicked(this.inAppMessage.getAction());
    }

    public j<Void> messageClicked(Action action) {
        if (shouldLog() && action.getActionUrl() == null) {
            if (action.getActionUrl() == null) {
                return messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
            }
            return logMessageClick(action);
        }
        logActionNotTaken("message click to metrics logger");
        k obj2 = new k();
        return obj2.a();
    }

    public j<Void> messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType) {
        final String str = "message dismissal to metrics logger";
        if (shouldLog()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempting to record: ");
            stringBuilder.append(str);
            Logging.logd(stringBuilder.toString());
            v vVar = new v(this, inAppMessagingDismissType);
            return logImpressionIfNeeded(b.n(vVar));
        }
        logActionNotTaken(str);
        k obj4 = new k();
        return obj4.a();
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public void n(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType) {
        m(inAppMessagingDismissType);
    }
}
