package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.firebase.inappmessaging.CampaignAnalytics.Builder;
import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.firebase.inappmessaging.ClientAppInfo.Builder;
import com.google.firebase.inappmessaging.DismissType;
import com.google.firebase.inappmessaging.EventType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason;
import com.google.firebase.inappmessaging.RenderErrorReason;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CampaignMetadata;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.protobuf.a;
import com.google.protobuf.z.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MetricsLoggerClient {

    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType> dismissTransform;
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason> errorTransform;
    private final AnalyticsConnector analyticsConnector;
    private final Clock clock;
    private final com.google.firebase.inappmessaging.internal.DeveloperListenerManager developerListenerManager;
    private final com.google.firebase.inappmessaging.internal.MetricsLoggerClient.EngagementMetricsLoggerInterface engagementMetricsLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    public interface EngagementMetricsLoggerInterface {
        public abstract void logEvent(byte[] bArr);
    }
    static {
        HashMap hashMap = new HashMap();
        MetricsLoggerClient.errorTransform = hashMap;
        HashMap hashMap2 = new HashMap();
        MetricsLoggerClient.dismissTransform = hashMap2;
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR, RenderErrorReason.UNSPECIFIED_RENDER_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR, RenderErrorReason.IMAGE_FETCH_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_DISPLAY_ERROR, RenderErrorReason.IMAGE_DISPLAY_ERROR);
        hashMap.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT, RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO, DismissType.AUTO);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK, DismissType.CLICK);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.SWIPE, DismissType.SWIPE);
        hashMap2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE, DismissType.UNKNOWN_DISMISS_TYPE);
    }

    public MetricsLoggerClient(com.google.firebase.inappmessaging.internal.MetricsLoggerClient.EngagementMetricsLoggerInterface metricsLoggerClient$EngagementMetricsLoggerInterface, AnalyticsConnector analyticsConnector2, FirebaseApp firebaseApp3, FirebaseInstallationsApi firebaseInstallationsApi4, Clock clock5, com.google.firebase.inappmessaging.internal.DeveloperListenerManager developerListenerManager6) {
        super();
        this.engagementMetricsLogger = engagementMetricsLoggerInterface;
        this.analyticsConnector = analyticsConnector2;
        this.firebaseApp = firebaseApp3;
        this.firebaseInstallations = firebaseInstallationsApi4;
        this.clock = clock5;
        this.developerListenerManager = developerListenerManager6;
    }

    private void a(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType2, String string3) {
        this.engagementMetricsLogger.logEvent(createDismissEntry(inAppMessage, string3, (DismissType)MetricsLoggerClient.dismissTransform.get(inAppMessagingDismissType2)).toByteArray());
    }

    private void c(InAppMessage inAppMessage, String string2) {
        this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, string2, EventType.IMPRESSION_EVENT_TYPE).toByteArray());
    }

    private CampaignAnalytics.Builder createCampaignAnalyticsBuilder(InAppMessage inAppMessage, String string2) {
        String applicationId = this.firebaseApp.getOptions().getApplicationId();
        return CampaignAnalytics.newBuilder().setFiamSdkVersion("20.1.1").setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).setCampaignId(inAppMessage.getCampaignMetadata().getCampaignId()).setClientApp(ClientAppInfo.newBuilder().setGoogleAppId(applicationId).setFirebaseInstanceId(string2)).setClientTimestampMillis(this.clock.now());
    }

    private CampaignAnalytics createDismissEntry(InAppMessage inAppMessage, String string2, DismissType dismissType3) {
        return (CampaignAnalytics)createCampaignAnalyticsBuilder(inAppMessage, string2).setDismissType(dismissType3).build();
    }

    private CampaignAnalytics createEventEntry(InAppMessage inAppMessage, String string2, EventType eventType3) {
        return (CampaignAnalytics)createCampaignAnalyticsBuilder(inAppMessage, string2).setEventType(eventType3).build();
    }

    private CampaignAnalytics createRenderErrorEntry(InAppMessage inAppMessage, String string2, RenderErrorReason renderErrorReason3) {
        return (CampaignAnalytics)createCampaignAnalyticsBuilder(inAppMessage, string2).setRenderErrorReason(renderErrorReason3).build();
    }

    private void e(InAppMessage inAppMessage, String string2) {
        this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, string2, EventType.CLICK_EVENT_TYPE).toByteArray());
    }

    private void g(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason2, String string3) {
        this.engagementMetricsLogger.logEvent(createRenderErrorEntry(inAppMessage, string3, (RenderErrorReason)MetricsLoggerClient.errorTransform.get(inAppMessagingErrorReason2)).toByteArray());
    }

    private boolean impressionCountsAsConversion(InAppMessage inAppMessage) {
        int i;
        int i2 = MetricsLoggerClient.1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        final int i4 = 1;
        if (i2 != i4 && i2 != 2 && i2 != 3 && i2 != 4) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        Logging.loge("Unable to determine if impression should be counted as conversion.");
                        return 0;
                    }
                    return obj5 ^= i4;
                }
                return obj5 ^= i4;
            }
            return obj5 ^= i4;
        }
        if (validAction ^= i4 != 0 && obj5 ^= i4 != 0) {
            if (obj5 ^= i4 != 0) {
                i = i4;
            }
        }
        return i;
    }

    private boolean isTestCampaign(InAppMessage inAppMessage) {
        return inAppMessage.getCampaignMetadata().getIsTestMessage();
    }

    private boolean isValidAction(Action action) {
        String actionUrl;
        int obj2;
        if (action && action.getActionUrl() != null && !action.getActionUrl().isEmpty()) {
            if (action.getActionUrl() != null) {
                obj2 = !action.getActionUrl().isEmpty() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private void logEventAsync(InAppMessage inAppMessage, String string2, boolean z3) {
        String str;
        Object obj4;
        String obj5;
        String obj6;
        String campaignId = inAppMessage.getCampaignMetadata().getCampaignId();
        obj4 = collectAnalyticsParams(inAppMessage.getCampaignMetadata().getCampaignName(), campaignId);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending event=");
        stringBuilder.append(string2);
        stringBuilder.append(" params=");
        stringBuilder.append(obj4);
        Logging.logd(stringBuilder.toString());
        AnalyticsConnector analyticsConnector = this.analyticsConnector;
        if (analyticsConnector != null) {
            str = "fiam";
            analyticsConnector.logEvent(str, string2, obj4);
            if (z3 != null) {
                obj5 = new StringBuilder();
                obj5.append("fiam:");
                obj5.append(campaignId);
                this.analyticsConnector.setUserProperty(str, "_ln", obj5.toString());
            }
        } else {
            Logging.logw("Unable to log event: analytics library is missing");
        }
    }

    public void b(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType2, String string3) {
        a(inAppMessage, inAppMessagingDismissType2, string3);
    }

    Bundle collectAnalyticsParams(String string, String string2) {
        int i;
        int obj4;
        String obj5;
        Bundle bundle = new Bundle();
        bundle.putString("_nmid", string2);
        bundle.putString("_nmn", string);
        bundle.putInt("_ndt", (int)obj4);
        return bundle;
    }

    public void d(InAppMessage inAppMessage, String string2) {
        c(inAppMessage, string2);
    }

    public void f(InAppMessage inAppMessage, String string2) {
        e(inAppMessage, string2);
    }

    public void h(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason2, String string3) {
        g(inAppMessage, inAppMessagingErrorReason2, string3);
    }

    void logDismiss(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType2) {
        boolean testCampaign;
        com.google.firebase.inappmessaging.internal.q1 q1Var;
        FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType obj4;
        if (!isTestCampaign(inAppMessage)) {
            q1Var = new q1(this, inAppMessage, inAppMessagingDismissType2);
            this.firebaseInstallations.getId().addOnSuccessListener(q1Var);
            logEventAsync(inAppMessage, "fiam_dismiss", false);
        }
        this.developerListenerManager.messageDismissed(inAppMessage);
    }

    void logImpression(InAppMessage inAppMessage) {
        boolean impressionCountsAsConversion;
        String str;
        if (!isTestCampaign(inAppMessage)) {
            p1 p1Var = new p1(this, inAppMessage);
            this.firebaseInstallations.getId().addOnSuccessListener(p1Var);
            logEventAsync(inAppMessage, "fiam_impression", impressionCountsAsConversion(inAppMessage));
        }
        this.developerListenerManager.impressionDetected(inAppMessage);
    }

    void logMessageClick(InAppMessage inAppMessage, Action action2) {
        boolean testCampaign;
        String str;
        if (!isTestCampaign(inAppMessage)) {
            n1 n1Var = new n1(this, inAppMessage);
            this.firebaseInstallations.getId().addOnSuccessListener(n1Var);
            logEventAsync(inAppMessage, "fiam_action", true);
        }
        this.developerListenerManager.messageClicked(inAppMessage, action2);
    }

    void logRenderError(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason2) {
        boolean testCampaign;
        com.google.firebase.inappmessaging.internal.o1 o1Var;
        if (!isTestCampaign(inAppMessage)) {
            o1Var = new o1(this, inAppMessage, inAppMessagingErrorReason2);
            this.firebaseInstallations.getId().addOnSuccessListener(o1Var);
        }
        this.developerListenerManager.displayErrorEncountered(inAppMessage, inAppMessagingErrorReason2);
    }
}
