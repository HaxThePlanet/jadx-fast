package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build.VERSION;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public final class ServiceCompat {

    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    static class Api24Impl {
        static void stopForeground(Service service, int flags) {
            service.stopForeground(flags);
        }
    }

    static class Api29Impl {
        static void startForeground(Service service, int id, Notification notification, int foregroundServiceType) {
            int i;
            if (foregroundServiceType != 0) {
                if (foregroundServiceType == -1) {
                    service.startForeground(id, notification, foregroundServiceType);
                } else {
                    service.startForeground(id, notification, foregroundServiceType & 255);
                }
            } else {
            }
        }
    }

    static class Api34Impl {
        static void startForeground(Service service, int id, Notification notification, int foregroundServiceType) {
            int i;
            if (foregroundServiceType != 0) {
                if (foregroundServiceType == -1) {
                    service.startForeground(id, notification, foregroundServiceType);
                } else {
                    service.startForeground(id, notification, i2 &= foregroundServiceType);
                }
            } else {
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }
    public static void startForeground(Service service, int id, Notification notification, int foregroundServiceType) {
        if (Build.VERSION.SDK_INT >= 34) {
            ServiceCompat.Api34Impl.startForeground(service, id, notification, foregroundServiceType);
        } else {
            ServiceCompat.Api29Impl.startForeground(service, id, notification, foregroundServiceType);
        }
    }

    public static void stopForeground(Service service, int flags) {
        ServiceCompat.Api24Impl.stopForeground(service, flags);
    }
}
