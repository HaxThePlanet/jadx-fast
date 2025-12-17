package com.prototype.badboy;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0018\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\r", d2 = {"Lcom/prototype/badboy/BadDeviceAdmin;", "Landroid/app/admin/DeviceAdminReceiver;", "<init>", "()V", "onEnabled", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onDisabled", "onPasswordFailed", "onPasswordSucceeded", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BadDeviceAdmin extends DeviceAdminReceiver {

    public static final int $stable;
    static {
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onDisabled(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onDisabled(context, intent);
        Log.d("BadDeviceAdmin", "Device admin disabled");
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onEnabled(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onEnabled(context, intent);
        Log.d("BadDeviceAdmin", "Device admin enabled");
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onPasswordFailed(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onPasswordFailed(context, intent);
        Log.d("BadDeviceAdmin", "Password failed");
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onPasswordSucceeded(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onPasswordSucceeded(context, intent);
        Log.d("BadDeviceAdmin", "Password succeeded");
    }
}
