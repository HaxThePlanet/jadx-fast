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

/* loaded from: classes2.dex */
public class l0 extends j.e {

    final Context W;
    private boolean X;
    private String Y;
    private String Z;
    int a0;
    com.iterable.iterableapi.m0 b0;
    protected l0(Context context, String string2) {
        super(context, string2);
        this.W = context;
    }

    private PendingIntent G(Context context, com.iterable.iterableapi.m0.a m0$a2, Bundle bundle3) {
        PendingIntent obj3;
        int obj4;
        Intent intent = new Intent("com.iterable.push.ACTION_PUSH_ACTION");
        intent.putExtras(bundle3);
        intent.putExtra("requestCode", this.a0);
        String str3 = "actionIdentifier";
        intent.putExtra(str3, a2.a);
        intent.putExtra(str3, a2.a);
        int obj5 = 201326592;
        String str4 = "IterableNotification";
        if (a2.d) {
            j0.a(str4, "Go through TrampolineActivity");
            intent.setClass(context, IterableTrampolineActivity.class);
            obj3 = PendingIntent.getActivity(context, intent.hashCode(), intent, obj5);
        } else {
            j0.a(str4, "Go through IterablePushActionReceiver");
            intent.setClass(context, IterablePushActionReceiver.class);
            obj3 = PendingIntent.getBroadcast(context, intent.hashCode(), intent, obj5);
        }
        return obj3;
    }

    @Override // androidx.core.app.j$e
    public void F(Context context, com.iterable.iterableapi.m0.a m0$a2, Bundle bundle3) {
        String str;
        boolean obj3;
        Object obj4;
        j.a.a obj5 = new j.a.a(0, a2.b, G(context, a2, bundle3));
        if (a2.c.equals("textInput")) {
            obj3 = new o.a("userInput");
            obj3.b(a2.e);
            obj5.a(obj3.a());
        }
        b(obj5.b());
    }

    @Override // androidx.core.app.j$e
    public boolean H() {
        return this.X;
    }

    @Override // androidx.core.app.j$e
    public void I(String string) {
        this.Z = string;
    }

    @Override // androidx.core.app.j$e
    public void J(String string) {
        this.Y = string;
    }

    @Override // androidx.core.app.j$e
    public void K(boolean z) {
        this.X = z;
    }

    @Override // androidx.core.app.j$e
    public Notification c() {
        String str3;
        Throwable string;
        Object decodeStream;
        String str;
        int cVar;
        Object bVar;
        String str2;
        if (this.Y != null) {
            URL url = new URL(this.Y);
            Object instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
            (URLConnection)instrument.setDoInput(true);
            instrument.connect();
            decodeStream = BitmapFactory.decodeStream(instrument.getInputStream());
            if (decodeStream != null) {
                bVar = new j.b();
                bVar.i(decodeStream);
                bVar.h(0);
                bVar.j(this.Z);
                q(decodeStream);
                cVar = bVar;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Notification image could not be loaded from url: ");
                stringBuilder.append(this.Y);
                j0.c("IterableNotification", stringBuilder.toString());
            }
        }
        if (cVar == 0) {
            cVar = new j.c();
            cVar.h(this.Z);
        }
        A(cVar);
        return super.c();
    }
}
