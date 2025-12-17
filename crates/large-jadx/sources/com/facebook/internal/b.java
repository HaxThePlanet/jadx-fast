package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.e0.m;
import com.facebook.internal.g0.i.a;
import d.q.a.a;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.h;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\u0008\u001a\u00020\u0007J\u001c\u0010\t\u001a\u00020\u00072\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\u0007H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "close", "", "finalize", "onReceive", "intent", "Landroid/content/Intent;", "open", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b extends BroadcastReceiver {

    private static com.facebook.internal.b b = null;
    private static final String c = "com.parse.bolts.measurement_event";
    public static final com.facebook.internal.b.a d;
    private final Context a;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0008\u0010\u0002\u001a\u0004\u0008\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener$Companion;", "", "()V", "BOLTS_MEASUREMENT_EVENT_PREFIX", "", "MEASUREMENT_EVENT_ARGS_KEY", "MEASUREMENT_EVENT_NAME_KEY", "MEASUREMENT_EVENT_NOTIFICATION_NAME", "getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release$annotations", "getMEASUREMENT_EVENT_NOTIFICATION_NAME$facebook_core_release", "()Ljava/lang/String;", "singleton", "Lcom/facebook/internal/BoltsMeasurementEventListener;", "getInstance", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final com.facebook.internal.b a(Context context) {
            n.f(context, "context");
            if (b.a() != null) {
                return b.a();
            }
            b bVar2 = new b(context, 0);
            b.b(bVar2);
            b.c(bVar2);
            return b.a();
        }
    }
    static {
        b.a aVar = new b.a(0);
        b.d = aVar;
    }

    private b(Context context) {
        super();
        final Context obj2 = context.getApplicationContext();
        n.e(obj2, "context.applicationContext");
        this.a = obj2;
    }

    public b(Context context, g g2) {
        super(context);
    }

    public static final com.facebook.internal.b a() {
        if (a.d(b.class)) {
            return null;
        }
        return b.b;
    }

    public static final void b(com.facebook.internal.b b) {
        if (a.d(b.class)) {
        }
        b.e();
    }

    public static final void c(com.facebook.internal.b b) {
        if (a.d(b.class)) {
        }
        b.b = b;
    }

    private final void d() {
        if (a.d(this)) {
        }
        a aVar = a.b(this.a);
        n.e(aVar, "LocalBroadcastManager.ge…tance(applicationContext)");
        aVar.e(this);
    }

    private final void e() {
        if (a.d(this)) {
        }
        a aVar = a.b(this.a);
        n.e(aVar, "LocalBroadcastManager.ge…tance(applicationContext)");
        IntentFilter intentFilter = new IntentFilter(b.c);
        aVar.c(this, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public final void finalize() {
        if (a.d(this)) {
        }
        d();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent2) {
        int keySet;
        String stringExtra;
        Object next;
        String str;
        String str2;
        h hVar;
        Bundle obj10;
        final String str3 = "";
        if (a.d(this)) {
        }
        m mVar = new m(context);
        StringBuilder obj9 = new StringBuilder();
        obj9.append("bf_");
        keySet = 0;
        if (intent2 != null) {
            stringExtra = intent2.getStringExtra("event_name");
        } else {
            stringExtra = keySet;
        }
        obj9.append(stringExtra);
        if (intent2 != null) {
            obj10 = intent2.getBundleExtra("event_args");
        } else {
            obj10 = keySet;
        }
        Bundle bundle = new Bundle();
        if (obj10 != null) {
            try {
                keySet = obj10.keySet();
                if (keySet != null) {
                }
                keySet = keySet.iterator();
                for (String next2 : keySet) {
                    n.e(next2, "key");
                    h hVar2 = new h("[^0-9a-zA-Z _-]");
                    h hVar3 = new h("^[ -]*");
                    hVar = new h("[ -]*$");
                    bundle.putString(hVar.e(hVar3.e(hVar2.e(next2, "-"), str3), str3), (String)obj10.get(next2));
                }
                Object next2 = keySet.next();
                n.e((String)next2, "key");
                hVar2 = new h("[^0-9a-zA-Z _-]");
                hVar3 = new h("^[ -]*");
                hVar = new h("[ -]*$");
                bundle.putString(hVar.e(hVar3.e(hVar2.e(next2, "-"), str3), str3), (String)obj10.get(next2));
                mVar.d(obj9.toString(), bundle);
                a.b(context, this);
            }
        }
    }
}
