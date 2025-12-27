package com.iterable.iterableapi;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.core.app.j.a.a;
import androidx.core.app.j.b;
import androidx.core.app.j.c;
import androidx.core.app.j.e;
import androidx.core.app.o.a;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: IterableNotificationBuilder.java */
/* loaded from: classes2.dex */
public class l0 extends j.e {

    final Context W;
    private boolean X;
    private String Y;
    private String Z;
    int a0;
    m0 b0;
    protected l0(Context context, String str) {
        super(context, str);
        this.W = context;
    }

    private PendingIntent G(Context context, m0.a aVar, Bundle bundle) {
        PendingIntent broadcast;
        final Intent intent = new Intent("com.iterable.push.ACTION_PUSH_ACTION");
        intent.putExtras(bundle);
        intent.putExtra("requestCode", this.a0);
        String str3 = "actionIdentifier";
        intent.putExtra(str3, aVar.a);
        intent.putExtra(str3, aVar.a);
        int i3 = 201326592;
        String str4 = "IterableNotification";
        if (aVar.d) {
            j0.a(str4, "Go through TrampolineActivity");
            intent.setClass(context, IterableTrampolineActivity.class);
            broadcast = PendingIntent.getActivity(context, intent.hashCode(), intent, i3);
        } else {
            j0.a(str4, "Go through IterablePushActionReceiver");
            intent.setClass(context, IterablePushActionReceiver.class);
            broadcast = PendingIntent.getBroadcast(context, intent.hashCode(), intent, i3);
        }
        return broadcast;
    }

    @Override // androidx.core.app.j$e
    public void F(Context context, m0.a aVar, Bundle bundle) {
        final j.a.a aVar4 = new j.a.a(0, aVar.b, G(context, aVar, bundle));
        str = "textInput";
        if (aVar.c.equals(str)) {
            str = "userInput";
            o.a aVar3 = new o.a(str);
            aVar3.b(aVar.e);
            aVar4.a(aVar3.a());
        }
        b(aVar4.b());
    }

    @Override // androidx.core.app.j$e
    public boolean H() {
        return this.X;
    }

    @Override // androidx.core.app.j$e
    public void I(String str) {
        this.Z = str;
    }

    @Override // androidx.core.app.j$e
    public void J(String str) {
        this.Y = str;
    }

    @Override // androidx.core.app.j$e
    public void K(boolean z) {
        this.X = z;
    }

    @Override // androidx.core.app.j$e
    public Notification c() {
        Throwable malformedURLException;
        android.graphics.Bitmap bitmap = null;
        Object obj2;
        str = "IterableNotification";
        bitmap = null;
        if (this.Y != null) {
            try {
                Object instrument = FirebasePerfUrlConnection.instrument(new URL(this.Y).openConnection());
                instrument.setDoInput(true);
                instrument.connect();
                android.graphics.Bitmap decodeStream = BitmapFactory.decodeStream(instrument.getInputStream());
                j.b bVar = new j.b();
                bVar.i(decodeStream);
                bVar.h(null);
                bVar.j(this.Z);
            } catch (java.io.IOException ioException) {
            } catch (java.net.MalformedURLException malformedURL1) {
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                String str7 = "Notification image could not be loaded from url: ";
                str2 = str7 + this.Y;
                j0.c("IterableNotification", str2);
            } catch (java.io.IOException ioException) {
            } catch (java.net.MalformedURLException malformedURL1) {
            }
            malformedURL1 = malformedURL1.toString();
            j0.c(str5, malformedURL1);
        }
        if (bitmap == null) {
            new j.c().h(this.Z);
        }
        A(obj2);
        return super.c();
    }
}
