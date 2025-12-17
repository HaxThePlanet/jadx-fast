package app.dogo.com.dogo_android.s.a;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.RingtoneManager;
import androidx.core.app.j.c;
import androidx.core.app.j.e;
import androidx.core.app.m;
import app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster;
import app.dogo.com.dogo_android.repository.domain.CouponDiscount;
import app.dogo.com.dogo_android.service.o2;
import app.dogo.com.dogo_android.service.v2;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "alarmManager", "Landroid/app/AlarmManager;", "applicationContext", "Landroid/content/Context;", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "(Lapp/dogo/com/dogo_android/service/Utilities;Landroid/app/AlarmManager;Landroid/content/Context;Lapp/dogo/com/dogo_android/service/NotificationService;)V", "buildNotification", "Landroid/app/Notification;", "resources", "Landroid/content/res/Resources;", "dogName", "", "cancelPendingNotification", "", "scheduleNotification", "coupon", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "showNotification", "context", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b2 {

    public static final app.dogo.com.dogo_android.s.a.b2.a Companion;
    private static final Class<CouponNotificationBroadcaster> e;
    private final v2 a;
    private final AlarmManager b;
    private final Context c;
    private final o2 d;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor$Companion;", "", "()V", "SPECIAL_OFFER", "", "SPECIAL_OFFER_NOTIFICATION", "SPECIAL_OFFER_NOTIFICATION_QUERY", "broadcasterClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/alarms/CouponNotificationBroadcaster;", "getBroadcasterClass", "()Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        b2.a aVar = new b2.a(0);
        b2.Companion = aVar;
        b2.e = CouponNotificationBroadcaster.class;
    }

    public b2(v2 v2, AlarmManager alarmManager2, Context context3, o2 o24) {
        n.f(v2, "utilities");
        n.f(alarmManager2, "alarmManager");
        n.f(context3, "applicationContext");
        n.f(o24, "notificationService");
        super();
        this.a = v2;
        this.b = alarmManager2;
        this.c = context3;
        this.d = o24;
    }

    private final Notification a(Resources resources, String string2) {
        Intent intent = new Intent(this.c, SplashActivity.class);
        intent.putExtra("source", "special_offer_notification");
        String string = resources.getString(2131887339);
        n.e(string, "resources.getString(R.string.special_offer_notification_ends_title)");
        int i2 = 1;
        Object[] arr = new Object[i2];
        final int i3 = 0;
        arr[i3] = string2;
        String obj9 = resources.getString(2131887338, arr);
        n.e(obj9, "resources.getString(R.string.special_offer_notification_ends_body, dogName)");
        int obj10 = 2;
        j.e eVar = new j.e(this.c, "announcement_id");
        eVar.y(2131231341);
        eVar.m(string);
        eVar.l(obj9);
        eVar.v(i3);
        eVar.h("reminder");
        eVar.D(i2);
        obj10 = new long[obj10];
        obj10 = new long[]{0L, 500L};
        eVar.C(obj10);
        eVar.k(PendingIntent.getActivity(this.c, 1000, intent, 335544320));
        eVar.z(RingtoneManager.getDefaultUri(obj10));
        eVar.g(i2);
        n.e(eVar, "Builder(applicationContext, NotificationService.ANNOUNCEMENT_CHANNEL_ID)\n            .setSmallIcon(R.drawable.vector_dogo_icon)\n            .setContentTitle(title)\n            .setContentText(description)\n            .setPriority(NotificationCompat.PRIORITY_DEFAULT)\n            .setCategory(NotificationCompat.CATEGORY_REMINDER)\n            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)\n            .setVibrate(longArrayOf(0, 500))\n            .setContentIntent(pendingIntent)\n            .setSound(uri)\n            .setAutoCancel(true)");
        obj10 = new j.c();
        obj10.h(obj9);
        eVar.A(obj10);
        obj9 = eVar.c();
        n.e(obj9, "builder.build()");
        return obj9;
    }

    public final void b() {
        this.d.c(this.c, b2.e, 1010101);
    }

    public final void c(CouponDiscount couponDiscount) {
        long broadcast;
        AlarmManager alarmManager;
        int i;
        long longValue;
        n.f(couponDiscount, "coupon");
        final Long obj6 = couponDiscount.getNotificationTimeMs(this.a.g());
        if (obj6 != null) {
            Intent intent = new Intent(this.c, CouponNotificationBroadcaster.class);
            intent.putExtra("special_offer_notification", true);
            this.b.set(0, obj6.longValue(), obj4);
        }
    }

    public final void d(Context context, String string2) {
        int str;
        Object obj5;
        n.f(context, "context");
        n.f(string2, "dogName");
        if (z ^= 1 != 0) {
        } else {
            n.e(context.getString(2131887168), "context.getString(R.string.rating_your_dog)");
        }
        m mVar = m.c(context);
        n.e(mVar, "from(context)");
        Resources obj4 = context.getResources();
        n.e(obj4, "context.resources");
        mVar.e("special_offer", 0, a(obj4, obj5));
    }
}
