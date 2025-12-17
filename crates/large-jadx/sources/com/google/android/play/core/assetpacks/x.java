package com.google.android.play.core.assetpacks;

import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.h1;
import com.google.android.play.core.internal.l2;
import com.google.android.play.core.internal.n2;

/* loaded from: classes2.dex */
final class x extends l2 {

    private final h a;
    private final Context b;
    private final com.google.android.play.core.assetpacks.f0 c;
    private final com.google.android.play.core.assetpacks.q3 d;
    private final com.google.android.play.core.assetpacks.e1 e;
    final NotificationManager f;
    x(Context context, com.google.android.play.core.assetpacks.f0 f02, com.google.android.play.core.assetpacks.q3 q33, com.google.android.play.core.assetpacks.e1 e14) {
        super();
        h hVar = new h("AssetPackExtractionService");
        this.a = hVar;
        this.b = context;
        this.c = f02;
        this.d = q33;
        this.e = e14;
        this.f = (NotificationManager)context.getSystemService("notification");
    }

    private final void m(Bundle bundle, n2 n22) {
        boolean z;
        Notification.Builder timeoutAfter;
        Object[] string3;
        String string2;
        String string;
        long long;
        Context context;
        String str;
        int obj12;
        int obj13;
        int i3 = 0;
        this.a.a("updateServiceState AIDL call", new Object[i3]);
        synchronized (this) {
            try {
                if (!h1.a(this.b)) {
                } else {
                }
                int int = bundle.getInt("action_type");
                this.e.c(n22);
                int i2 = 1;
                obj13 = Build.VERSION.SDK_INT;
                int i = 26;
                if (int == i2 && obj13 >= i) {
                }
                obj13 = Build.VERSION.SDK_INT;
                i = 26;
                if (obj13 >= i) {
                }
                x0(bundle.getString("notification_channel_name"));
                this.d.c(i2);
                final int i6 = 600000;
                android.os.Parcelable parcelable = bundle.getParcelable("notification_on_click_intent");
                if (obj13 >= i) {
                } else {
                }
                Notification.Builder builder = new Notification.Builder(this.b, "playcore-assetpacks-service-notification-channel");
                timeoutAfter = builder.setTimeoutAfter(bundle.getLong("notification_timeout", i6));
                Notification.Builder builder2 = new Notification.Builder(this.b);
                timeoutAfter = builder2.setPriority(-2);
                if (parcelable instanceof PendingIntent != null) {
                }
                timeoutAfter.setContentIntent((PendingIntent)parcelable);
                if (bundle.getString("notification_title") == null) {
                }
                string2 = "Downloading additional file";
                if (bundle.getString("notification_subtext") == null) {
                }
                string = "Transferring";
                timeoutAfter.setSmallIcon(17301633).setOngoing(i3).setContentTitle(string2).setSubText(string);
                obj12 = bundle.getInt("notification_color");
                if (obj13 >= 21 && obj12 != null) {
                }
                obj12 = bundle.getInt("notification_color");
                if (obj12 != null) {
                }
                timeoutAfter.setColor(obj12).setVisibility(-1);
                this.e.a(timeoutAfter.build());
                obj12 = new Intent(this.b, ExtractionForegroundService.class);
                this.b.bindService(obj12, this.e, i2);
                if (int == 2) {
                }
                this.d.c(i3);
                this.e.b();
                Object[] arr = new Object[i2];
                arr[i3] = Integer.valueOf(int);
                this.a.b("Unknown action type received: %d", arr);
                obj12 = new Bundle();
                n22.c(obj12);
                obj12 = new Bundle();
                n22.c(obj12);
                throw bundle;
            }
        }
    }

    private final void x0(String string) {
        Object obj4;
        synchronized (this) {
            obj4 = "File downloads by Play";
            NotificationChannel notificationChannel = new NotificationChannel("playcore-assetpacks-service-notification-channel", obj4, 2);
            this.f.createNotificationChannel(notificationChannel);
        }
    }

    @Override // com.google.android.play.core.internal.l2
    public final void h1(Bundle bundle, n2 n22) {
        boolean obj3;
        this.a.a("clearAssetPackStorage AIDL call", new Object[0]);
        if (h1.b(this.b) && !h1.a(this.b)) {
            if (!h1.a(this.b)) {
            }
            this.c.J();
            obj3 = new Bundle();
            n22.h(obj3);
        }
        obj3 = new Bundle();
        n22.c(obj3);
    }

    @Override // com.google.android.play.core.internal.l2
    public final void u1(Bundle bundle, n2 n22) {
        m(bundle, n22);
    }
}
