package com.google.firebase.inappmessaging;

import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import i.b.h;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class FirebaseInAppMessaging {

    private boolean areMessagesSuppressed = false;
    private final DataCollectionHelper dataCollectionHelper;
    private final DeveloperListenerManager developerListenerManager;
    private final DisplayCallbacksFactory displayCallbacksFactory;
    private com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay fiamDisplay;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final InAppMessageStreamManager inAppMessageStreamManager;
    private final ProgramaticContextualTriggers programaticContextualTriggers;
    FirebaseInAppMessaging(InAppMessageStreamManager inAppMessageStreamManager, ProgramaticContextualTriggers programaticContextualTriggers2, DataCollectionHelper dataCollectionHelper3, FirebaseInstallationsApi firebaseInstallationsApi4, DisplayCallbacksFactory displayCallbacksFactory5, DeveloperListenerManager developerListenerManager6) {
        super();
        this.inAppMessageStreamManager = inAppMessageStreamManager;
        this.programaticContextualTriggers = programaticContextualTriggers2;
        this.dataCollectionHelper = dataCollectionHelper3;
        this.firebaseInstallations = firebaseInstallationsApi4;
        int obj2 = 0;
        this.displayCallbacksFactory = displayCallbacksFactory5;
        this.developerListenerManager = developerListenerManager6;
        firebaseInstallationsApi4.getId().addOnSuccessListener(b.a);
        obj2 = new a(this);
        inAppMessageStreamManager.createFirebaseInAppMessageStream().Y(obj2);
    }

    public static void a(com.google.firebase.inappmessaging.FirebaseInAppMessaging firebaseInAppMessaging, TriggeredInAppMessage triggeredInAppMessage2) {
        firebaseInAppMessaging.triggerInAppMessage(triggeredInAppMessage2);
    }

    static void b(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Starting InAppMessaging runtime with Installation ID ");
        stringBuilder.append(string);
        Logging.logi(stringBuilder.toString());
    }

    public static com.google.firebase.inappmessaging.FirebaseInAppMessaging getInstance() {
        return (FirebaseInAppMessaging)FirebaseApp.getInstance().get(FirebaseInAppMessaging.class);
    }

    private void triggerInAppMessage(TriggeredInAppMessage triggeredInAppMessage) {
        com.google.firebase.inappmessaging.model.InAppMessage inAppMessage;
        DisplayCallbacksFactory displayCallbacksFactory;
        com.google.firebase.inappmessaging.model.InAppMessage inAppMessage2;
        com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks obj5;
        final com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay fiamDisplay = this.fiamDisplay;
        if (fiamDisplay != null) {
            fiamDisplay.displayMessage(triggeredInAppMessage.getInAppMessage(), this.displayCallbacksFactory.generateDisplayCallback(triggeredInAppMessage.getInAppMessage(), triggeredInAppMessage.getTriggeringEvent()));
        }
    }

    public void addClickListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.developerListenerManager.addClickListener(firebaseInAppMessagingClickListener);
    }

    public void addClickListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor2) {
        this.developerListenerManager.addClickListener(firebaseInAppMessagingClickListener, executor2);
    }

    public void addDismissListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.developerListenerManager.addDismissListener(firebaseInAppMessagingDismissListener);
    }

    public void addDismissListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor2) {
        this.developerListenerManager.addDismissListener(firebaseInAppMessagingDismissListener, executor2);
    }

    public void addDisplayErrorListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.developerListenerManager.addDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener);
    }

    public void addDisplayErrorListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor2) {
        this.developerListenerManager.addDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener, executor2);
    }

    public void addImpressionListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.developerListenerManager.addImpressionListener(firebaseInAppMessagingImpressionListener);
    }

    public void addImpressionListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor2) {
        this.developerListenerManager.addImpressionListener(firebaseInAppMessagingImpressionListener, executor2);
    }

    public boolean areMessagesSuppressed() {
        return this.areMessagesSuppressed;
    }

    public void clearDisplayListener() {
        Logging.logi("Removing display event component");
        this.fiamDisplay = 0;
    }

    public boolean isAutomaticDataCollectionEnabled() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    public void removeAllListeners() {
        this.developerListenerManager.removeAllListeners();
    }

    public void removeClickListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.developerListenerManager.removeClickListener(firebaseInAppMessagingClickListener);
    }

    public void removeDisplayErrorListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.developerListenerManager.removeDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeImpressionListener(com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.developerListenerManager.removeImpressionListener(firebaseInAppMessagingImpressionListener);
    }

    public void setAutomaticDataCollectionEnabled(Boolean boolean) {
        this.dataCollectionHelper.setAutomaticDataCollectionEnabled(boolean);
    }

    public void setAutomaticDataCollectionEnabled(boolean z) {
        this.dataCollectionHelper.setAutomaticDataCollectionEnabled(z);
    }

    public void setMessageDisplayComponent(com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        Logging.logi("Setting display event component");
        this.fiamDisplay = firebaseInAppMessagingDisplay;
    }

    public void setMessagesSuppressed(Boolean boolean) {
        this.areMessagesSuppressed = boolean.booleanValue();
    }

    public void triggerEvent(String string) {
        this.programaticContextualTriggers.triggerEvent(string);
    }
}
