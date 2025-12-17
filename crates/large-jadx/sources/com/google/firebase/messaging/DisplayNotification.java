package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.j.b;
import androidx.core.app.j.e;
import com.google.android.gms.common.util.l;
import com.google.android.gms.tasks.m;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class DisplayNotification {

    private final Context context;
    private final Executor networkIoExecutor;
    private final com.google.firebase.messaging.NotificationParams params;
    public DisplayNotification(Context context, com.google.firebase.messaging.NotificationParams notificationParams2, Executor executor3) {
        super();
        this.networkIoExecutor = executor3;
        this.context = context;
        this.params = notificationParams2;
    }

    private boolean isAppForeground() {
        int myPid;
        int i;
        List runningAppProcesses;
        String next;
        int pid;
        int i3 = 0;
        if ((KeyguardManager)this.context.getSystemService("keyguard").inKeyguardRestrictedInputMode()) {
            return i3;
        }
        if (!l.f()) {
            SystemClock.sleep(10);
        }
        runningAppProcesses = (ActivityManager)this.context.getSystemService("activity").getRunningAppProcesses();
        if (runningAppProcesses != null) {
            runningAppProcesses = runningAppProcesses.iterator();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            }
        }
        return i3;
    }

    private void showNotification(com.google.firebase.messaging.CommonNotificationBuilder.DisplayNotificationInfo commonNotificationBuilder$DisplayNotificationInfo) {
        boolean loggable;
        String str = "FirebaseMessaging";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Showing notification");
        }
        (NotificationManager)this.context.getSystemService("notification").notify(displayNotificationInfo.tag, displayNotificationInfo.id, displayNotificationInfo.notificationBuilder.c());
    }

    private com.google.firebase.messaging.ImageDownload startImageDownloadInBackground() {
        Object networkIoExecutor;
        com.google.firebase.messaging.ImageDownload create = ImageDownload.create(this.params.getString("gcm.n.image"));
        if (create != null) {
            create.start(this.networkIoExecutor);
        }
        return create;
    }

    private void waitForAndApplyImageDownload(j.e j$e, com.google.firebase.messaging.ImageDownload imageDownload2) {
        final String str = "FirebaseMessaging";
        if (imageDownload2 == null) {
        }
        Object obj = m.b(imageDownload2.getTask(), 5, obj3);
        e.q((Bitmap)obj);
        j.b bVar = new j.b();
        bVar.i(obj);
        bVar.h(0);
        e.A(bVar);
    }

    boolean handleNotification() {
        int i2 = 1;
        if (this.params.getBoolean("gcm.n.noui")) {
            return i2;
        }
        if (isAppForeground()) {
            return 0;
        }
        com.google.firebase.messaging.CommonNotificationBuilder.DisplayNotificationInfo notificationInfo = CommonNotificationBuilder.createNotificationInfo(this.context, this.params);
        waitForAndApplyImageDownload(notificationInfo.notificationBuilder, startImageDownloadInBackground());
        showNotification(notificationInfo);
        return i2;
    }
}
