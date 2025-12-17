package com.google.firebase.messaging;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
class FcmLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    private final Set<Intent> seenIntents;
    FcmLifecycleCallbacks() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.seenIntents = Collections.newSetFromMap(weakHashMap);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle2) {
        Object obj1;
        boolean obj2;
        obj1 = activity.getIntent();
        if (obj1 != null) {
            if (!this.seenIntents.add(obj1)) {
            } else {
                obj1 = obj1.getExtras();
                obj1 = obj1.getBundle("gcm.n.analytics_data");
                if (obj1 != null && MessagingAnalytics.shouldUploadScionMetrics(obj1)) {
                    obj1 = obj1.getBundle("gcm.n.analytics_data");
                    if (MessagingAnalytics.shouldUploadScionMetrics(obj1)) {
                        MessagingAnalytics.logNotificationOpen(obj1);
                    }
                }
            }
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        boolean seenIntents;
        Intent obj2;
        if (activity.isFinishing()) {
            this.seenIntents.remove(activity.getIntent());
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
