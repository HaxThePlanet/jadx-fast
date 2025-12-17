package com.google.firebase.inappmessaging.display.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public class FirebaseInAppMessagingDisplayImpl implements FirebaseInAppMessagingDisplay, Application.ActivityLifecycleCallbacks {
    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2) {
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void onActivityCreated(Activity activity, Bundle bundle2) {
        StringBuilder obj3 = new StringBuilder();
        obj3.append("Created activity: ");
        obj3.append(activity.getClass().getName());
        Logging.logd(obj3.toString());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void onActivityDestroyed(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Destroyed activity: ");
        stringBuilder.append(activity.getClass().getName());
        Logging.logd(stringBuilder.toString());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void onActivityPaused(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pausing activity: ");
        stringBuilder.append(activity.getClass().getName());
        Logging.logd(stringBuilder.toString());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void onActivityResumed(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resumed activity: ");
        stringBuilder.append(activity.getClass().getName());
        Logging.logd(stringBuilder.toString());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
        StringBuilder obj3 = new StringBuilder();
        obj3.append("SavedInstance activity: ");
        obj3.append(activity.getClass().getName());
        Logging.logd(obj3.toString());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void onActivityStarted(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Started activity: ");
        stringBuilder.append(activity.getClass().getName());
        Logging.logd(stringBuilder.toString());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void onActivityStopped(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stopped activity: ");
        stringBuilder.append(activity.getClass().getName());
        Logging.logd(stringBuilder.toString());
    }
}
