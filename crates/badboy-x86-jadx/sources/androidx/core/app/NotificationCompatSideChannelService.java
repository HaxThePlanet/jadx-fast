package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel.Stub;

/* loaded from: classes5.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    private class NotificationSideChannelStub extends INotificationSideChannel.Stub {

        final androidx.core.app.NotificationCompatSideChannelService this$0;
        NotificationSideChannelStub(androidx.core.app.NotificationCompatSideChannelService notificationCompatSideChannelService) {
            this.this$0 = notificationCompatSideChannelService;
            super();
        }

        public void cancel(String packageName, int id, String tag) throws RemoteException {
            final int callingUid = NotificationCompatSideChannelService.NotificationSideChannelStub.getCallingUid();
            this.this$0.checkPermission(callingUid, packageName);
            this.this$0.cancel(packageName, id, tag);
            NotificationCompatSideChannelService.NotificationSideChannelStub.restoreCallingIdentity(NotificationCompatSideChannelService.NotificationSideChannelStub.clearCallingIdentity());
        }

        @Override // android.support.v4.app.INotificationSideChannel$Stub
        public void cancelAll(String packageName) {
            final int callingUid = NotificationCompatSideChannelService.NotificationSideChannelStub.getCallingUid();
            this.this$0.checkPermission(callingUid, packageName);
            this.this$0.cancelAll(packageName);
            NotificationCompatSideChannelService.NotificationSideChannelStub.restoreCallingIdentity(NotificationCompatSideChannelService.NotificationSideChannelStub.clearCallingIdentity());
        }

        public void notify(String packageName, int id, String tag, Notification notification) throws RemoteException {
            final int callingUid = NotificationCompatSideChannelService.NotificationSideChannelStub.getCallingUid();
            this.this$0.checkPermission(callingUid, packageName);
            this.this$0.notify(packageName, id, tag, notification);
            NotificationCompatSideChannelService.NotificationSideChannelStub.restoreCallingIdentity(NotificationCompatSideChannelService.NotificationSideChannelStub.clearCallingIdentity());
        }
    }
    @Override // android.app.Service
    public abstract void cancel(String string, int i2, String string3);

    @Override // android.app.Service
    public abstract void cancelAll(String string);

    @Override // android.app.Service
    void checkPermission(int callingUid, String packageName) {
        int i;
        String str;
        boolean equals;
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        i = 0;
        while (i < packagesForUid.length) {
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        SecurityException securityException = new SecurityException(stringBuilder.append("NotificationSideChannelService: Uid ").append(callingUid).append(" is not authorized for package ").append(packageName).toString());
        throw securityException;
    }

    @Override // android.app.Service
    public abstract void notify(String string, int i2, String string3, Notification notification4);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        int i = 0;
        if (intent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")) {
            return i;
        }
        return i;
    }
}
