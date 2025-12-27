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

/* compiled from: CouponNotificationInteractor.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor;", "", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "alarmManager", "Landroid/app/AlarmManager;", "applicationContext", "Landroid/content/Context;", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "(Lapp/dogo/com/dogo_android/service/Utilities;Landroid/app/AlarmManager;Landroid/content/Context;Lapp/dogo/com/dogo_android/service/NotificationService;)V", "buildNotification", "Landroid/app/Notification;", "resources", "Landroid/content/res/Resources;", "dogName", "", "cancelPendingNotification", "", "scheduleNotification", "coupon", "Lapp/dogo/com/dogo_android/repository/domain/CouponDiscount;", "showNotification", "context", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b2, reason: from kotlin metadata */
public final class CouponNotificationInteractor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final b2.a INSTANCE = new b2$a(0);
    private static final Class<CouponNotificationBroadcaster> e = app.dogo.com.dogo_android.alarms.CouponNotificationBroadcaster.class;
    /* renamed from: a, reason: from kotlin metadata */
    private final v2 alarmManager;
    /* renamed from: b, reason: from kotlin metadata */
    private final AlarmManager applicationContext;
    /* renamed from: c, reason: from kotlin metadata */
    private final Context notificationService;
    /* renamed from: d, reason: from kotlin metadata */
    private final o2 utilities;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/CouponNotificationInteractor$Companion;", "", "()V", "SPECIAL_OFFER", "", "SPECIAL_OFFER_NOTIFICATION", "SPECIAL_OFFER_NOTIFICATION_QUERY", "broadcasterClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/alarms/CouponNotificationBroadcaster;", "getBroadcasterClass", "()Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public b2(v2 v2Var, AlarmManager alarmManager, Context context, o2 o2Var) {
        n.f(v2Var, "utilities");
        n.f(alarmManager, "alarmManager");
        n.f(context, "applicationContext");
        n.f(o2Var, "notificationService");
        super();
        this.alarmManager = v2Var;
        this.applicationContext = alarmManager;
        this.notificationService = context;
        this.utilities = o2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final Notification buildNotification(Resources resources, String dogName) throws android.content.res.Resources.NotFoundException {
        Intent intent = new Intent(this.notificationService, SplashActivity.class);
        intent.putExtra("source", "special_offer_notification");
        String string = resources.getString(2131887339);
        n.e(string, "resources.getString(R.string.special_offer_notification_ends_title)");
        int i2 = 1;
        Object[] arr = new Object[i2];
        final int i3 = 0;
        arr[i3] = dogName;
        String string2 = resources.getString(2131887338, arr);
        n.e(string2, "resources.getString(R.string.special_offer_notification_ends_body, dogName)");
        j.e eVar = new j.e(this.notificationService, "announcement_id");
        eVar.y(2131231341);
        eVar.m(string);
        eVar.l(string2);
        eVar.v(i3);
        eVar.h("reminder");
        eVar.D(i2);
        eVar.C(new long[] { 0, 500 });
        eVar.k(PendingIntent.getActivity(this.notificationService, 1000, intent, 335544320));
        eVar.z(RingtoneManager.getDefaultUri(2));
        eVar.g(true);
        n.e(eVar, "Builder(applicationContext, NotificationService.ANNOUNCEMENT_CHANNEL_ID)\n            .setSmallIcon(R.drawable.vector_dogo_icon)\n            .setContentTitle(title)\n            .setContentText(description)\n            .setPriority(NotificationCompat.PRIORITY_DEFAULT)\n            .setCategory(NotificationCompat.CATEGORY_REMINDER)\n            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)\n            .setVibrate(longArrayOf(0, 500))\n            .setContentIntent(pendingIntent)\n            .setSound(uri)\n            .setAutoCancel(true)");
        j.c cVar = new j.c();
        cVar.h(string2);
        eVar.A(cVar);
        Notification notification = eVar.c();
        n.e(notification, "builder.build()");
        return notification;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void cancelPendingNotification() {
        this.utilities.c(this.notificationService, CouponNotificationInteractor.e, 1010101);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final void scheduleNotification(CouponDiscount coupon) {
        n.f(coupon, "coupon");
        final Long notificationTimeMs = coupon.getNotificationTimeMs(this.alarmManager.g());
        if (notificationTimeMs != null) {
            Intent intent = new Intent(this.notificationService, CouponNotificationBroadcaster.class);
            intent.putExtra("special_offer_notification", true);
            int i = 0;
            this.applicationContext.set(i, notificationTimeMs.longValue(), PendingIntent.getBroadcast(this.notificationService, 1010101, intent, 201326592));
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void showNotification(Context context, String dogName) {
        String string;
        n.f(context, "context");
        n.f(dogName, "dogName");
        i = !l.z(dogName);
        if (!l.z(dogName) == 0) {
            n.e(context.getString(2131887168), "context.getString(R.string.rating_your_dog)");
        }
        m mVar = m.c(context);
        n.e(mVar, "from(context)");
        Resources resources = context.getResources();
        n.e(resources, "context.resources");
        mVar.e("special_offer", 0, buildNotification(resources, string));
    }
}
