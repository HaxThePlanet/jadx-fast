package androidx.core.app;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent.OnFinished;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import java.io.Closeable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes5.dex */
public final class PendingIntentCompat {

    private static class Api23Impl {
        public static void send(PendingIntent pendingIntent, Context context, int code, Intent intent, PendingIntent.OnFinished onFinished, Handler handler, String requiredPermission, Bundle options) throws PendingIntent.CanceledException {
            pendingIntent.send(context, code, intent, onFinished, handler, requiredPermission, options);
        }
    }

    private static class Api26Impl {
        public static PendingIntent getForegroundService(Context context, int requestCode, Intent intent, int flags) {
            return PendingIntent.getForegroundService(context, requestCode, intent, flags);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static class GatedCallback implements Closeable {

        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete;
        private boolean mSuccess = false;
        public static void $r8$lambda$-_JLK_p2qvpYOAwGjpaXu2HJ864(androidx.core.app.PendingIntentCompat.GatedCallback pendingIntentCompat$GatedCallback, PendingIntent pendingIntent2, Intent intent3, int i4, String string5, Bundle bundle6) {
            gatedCallback.onSendFinished(pendingIntent2, intent3, i4, string5, bundle6);
        }

        GatedCallback(PendingIntent.OnFinished callback) {
            super();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mComplete = countDownLatch;
            this.mCallback = callback;
            int i = 0;
        }

        private void onSendFinished(PendingIntent pendingIntent, Intent intent, int resultCode, String resultData, Bundle resultExtras) {
            int i4;
            Object currentThread;
            int i;
            PendingIntent.OnFinished mCallback;
            Throwable th2;
            Object pendingIntent2;
            Thread thread2;
            Object thread;
            int i2;
            int i3;
            String str2;
            String str;
            Bundle bundle2;
            Bundle bundle;
            Throwable obj9;
            Thread obj10;
            int obj11;
            String obj12;
            Bundle obj13;
            i = i4;
            this.mComplete.await();
            if (i != 0) {
                try {
                    Thread.currentThread().interrupt();
                    if (this.mCallback != null) {
                    } else {
                    }
                    this.mCallback.onSendFinished(obj9, obj10, obj11, obj12, obj13);
                    this.mCallback = 0;
                    pendingIntent2 = obj9;
                    thread = obj10;
                    i3 = obj11;
                    str = obj12;
                    bundle = obj13;
                }
            }
        }

        @Override // java.io.Closeable
        public void close() {
            boolean mSuccess;
            if (!this.mSuccess) {
                this.mCallback = 0;
            }
            this.mComplete.countDown();
        }

        @Override // java.io.Closeable
        public void complete() {
            this.mSuccess = true;
        }

        @Override // java.io.Closeable
        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            PendingIntentCompat.GatedCallback$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new PendingIntentCompat.GatedCallback$$ExternalSyntheticLambda0(this);
            return externalSyntheticLambda0;
        }
    }
    static int addMutabilityFlags(boolean isMutable, int flags) {
        int sDK_INT;
        int i;
        int obj3;
        if (isMutable) {
            if (Build.VERSION.SDK_INT >= 31) {
                flags |= sDK_INT;
            }
        } else {
            flags |= sDK_INT;
        }
        return obj3;
    }

    public static PendingIntent getActivities(Context context, int requestCode, Intent[] intents, int flags, Bundle options, boolean isMutable) {
        return PendingIntent.getActivities(context, requestCode, intents, PendingIntentCompat.addMutabilityFlags(isMutable, flags), options);
    }

    public static PendingIntent getActivities(Context context, int requestCode, Intent[] intents, int flags, boolean isMutable) {
        return PendingIntent.getActivities(context, requestCode, intents, PendingIntentCompat.addMutabilityFlags(isMutable, flags));
    }

    public static PendingIntent getActivity(Context context, int requestCode, Intent intent, int flags, Bundle options, boolean isMutable) {
        return PendingIntent.getActivity(context, requestCode, intent, PendingIntentCompat.addMutabilityFlags(isMutable, flags), options);
    }

    public static PendingIntent getActivity(Context context, int requestCode, Intent intent, int flags, boolean isMutable) {
        return PendingIntent.getActivity(context, requestCode, intent, PendingIntentCompat.addMutabilityFlags(isMutable, flags));
    }

    public static PendingIntent getBroadcast(Context context, int requestCode, Intent intent, int flags, boolean isMutable) {
        return PendingIntent.getBroadcast(context, requestCode, intent, PendingIntentCompat.addMutabilityFlags(isMutable, flags));
    }

    public static PendingIntent getForegroundService(Context context, int requestCode, Intent intent, int flags, boolean isMutable) {
        return PendingIntentCompat.Api26Impl.getForegroundService(context, requestCode, intent, PendingIntentCompat.addMutabilityFlags(isMutable, flags));
    }

    public static PendingIntent getService(Context context, int requestCode, Intent intent, int flags, boolean isMutable) {
        return PendingIntent.getService(context, requestCode, intent, PendingIntentCompat.addMutabilityFlags(isMutable, flags));
    }

    public static void send(PendingIntent pendingIntent, int code, PendingIntent.OnFinished onFinished, Handler handler) throws PendingIntent.CanceledException {
        Throwable th2;
        Throwable th;
        PendingIntentCompat.GatedCallback gatedCallback = new PendingIntentCompat.GatedCallback(onFinished);
        pendingIntent.send(code, gatedCallback.getCallback(), handler);
        gatedCallback.complete();
        gatedCallback.close();
    }

    public static void send(PendingIntent pendingIntent, Context context, int code, Intent intent, PendingIntent.OnFinished onFinished, Handler handler) throws PendingIntent.CanceledException {
        PendingIntentCompat.send(pendingIntent, context, code, intent, onFinished, handler, 0, 0);
    }

    public static void send(PendingIntent pendingIntent, Context context, int code, Intent intent, PendingIntent.OnFinished onFinished, Handler handler, String requiredPermissions, Bundle options) throws PendingIntent.CanceledException {
        Throwable th2;
        PendingIntentCompat.GatedCallback gatedCallback = new PendingIntentCompat.GatedCallback(onFinished);
        final androidx.core.app.PendingIntentCompat.GatedCallback intent2 = gatedCallback;
        PendingIntentCompat.Api23Impl.send(pendingIntent, context, code, intent, onFinished, handler, requiredPermissions, options);
        intent2.complete();
        intent2.close();
    }
}
