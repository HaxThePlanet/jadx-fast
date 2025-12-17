package app.dogo.com.dogo_android.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u000cH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/alarms/CouponNotificationBroadcaster;", "Landroid/content/BroadcastReceiver;", "()V", "couponNotificationHelper", "Lapp/dogo/com/dogo_android/alarms/CouponNotificationBroadcaster$Companion$CouponNotificationHelper;", "getCouponNotificationHelper", "()Lapp/dogo/com/dogo_android/alarms/CouponNotificationBroadcaster$Companion$CouponNotificationHelper;", "couponNotificationHelper$delegate", "Lkotlin/Lazy;", "isAlarm", "", "intent", "Landroid/content/Intent;", "onReceive", "", "context", "Landroid/content/Context;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CouponNotificationBroadcaster extends BroadcastReceiver {

    public static final app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.a Companion;
    private final h a;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/alarms/CouponNotificationBroadcaster$Companion;", "", "()V", "CouponNotificationHelper", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/alarms/CouponNotificationBroadcaster$Companion$CouponNotificationHelper;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.a.a> {

        public static final app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.b a;
        static {
            CouponNotificationBroadcaster.b bVar = new CouponNotificationBroadcaster.b();
            CouponNotificationBroadcaster.b.a = bVar;
        }

        b() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.a.a a() {
            CouponNotificationBroadcaster.a.a aVar = new CouponNotificationBroadcaster.a.a();
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        CouponNotificationBroadcaster.a aVar = new CouponNotificationBroadcaster.a(0);
        CouponNotificationBroadcaster.Companion = aVar;
    }

    public CouponNotificationBroadcaster() {
        super();
        this.a = j.b(CouponNotificationBroadcaster.b.a);
    }

    private final app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.a.a a() {
        return (CouponNotificationBroadcaster.a.a)this.a.getValue();
    }

    private final boolean b(Intent intent) {
        int i;
        String str;
        Bundle obj4;
        obj4 = intent.getExtras();
        i = 0;
        final int i2 = 1;
        if (obj4 == null) {
        } else {
            if (obj4.containsKey("special_offer_notification") == i2) {
                i = i2;
            }
        }
        return i;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent2) {
        String action;
        boolean str;
        Object obj3;
        Object obj4;
        n.f(context, "context");
        n.f(intent2, "intent");
        action = intent2.getAction();
        if (n.b(action, "android.intent.action.BOOT_COMPLETED")) {
            a().j();
        } else {
            if (n.b(action, "android.intent.action.PACKAGE_REPLACED")) {
                a().j();
            } else {
                if (b(intent2)) {
                    a().h(context);
                }
            }
        }
    }
}
