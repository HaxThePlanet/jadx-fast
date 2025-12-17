package app.dogo.com.dogo_android.s.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.core.app.j.c;
import androidx.core.app.j.e;
import androidx.core.app.m;
import app.dogo.com.dogo_android.alarms.NotificationBroadcaster;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.service.o2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.x;
import app.dogo.com.dogo_android.util.x.a;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 .2\u00020\u0001:\u0001.B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0008\u0010\u0018\u001a\u00020\u0016H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 J8\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001a0\"2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u001cJ\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J8\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001aH\u0002J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PottyReminderNotificationInteractor;", "", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "packageManager", "Landroid/content/pm/PackageManager;", "alarmManager", "Landroid/app/AlarmManager;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "applicationContext", "Landroid/content/Context;", "(Lapp/dogo/com/dogo_android/service/NotificationService;Landroid/content/pm/PackageManager;Landroid/app/AlarmManager;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/Context;)V", "cancelPottyReminderNotificationAlarm", "", "notificationId", "", "getPendingIntent", "Landroid/app/PendingIntent;", "intent", "Landroid/content/Intent;", "getPottyReminderDescription", "", "dogName", "getPottyReminderTitle", "isDayCorrect", "", "dayFilter", "", "isLastReminderNotificationForToday", "endTime", "interval", "", "parseReminderStartTimeMs", "Lkotlin/Pair;", "startTime", "setPottyReminderNotification", "reminder", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "setupNotificationAlarm", "startTimeMs", "reminderId", "dogId", "intervalFlag", "showPottyReminderNotification", "remindersModel", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h3 {

    public static final app.dogo.com.dogo_android.s.a.h3.a Companion;
    private static final Class<NotificationBroadcaster> f;
    private final o2 a;
    private final PackageManager b;
    private final AlarmManager c;
    private final v2 d;
    private final Context e;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PottyReminderNotificationInteractor$Companion;", "", "()V", "POTTY_NOTIFICATION_SOURCE", "", "broadcasterClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster;", "getBroadcasterClass", "()Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        h3.a aVar = new h3.a(0);
        h3.Companion = aVar;
        h3.f = NotificationBroadcaster.class;
    }

    public h3(o2 o2, PackageManager packageManager2, AlarmManager alarmManager3, v2 v24, Context context5) {
        n.f(o2, "notificationService");
        n.f(packageManager2, "packageManager");
        n.f(alarmManager3, "alarmManager");
        n.f(v24, "utilities");
        n.f(context5, "applicationContext");
        super();
        this.a = o2;
        this.b = packageManager2;
        this.c = alarmManager3;
        this.d = v24;
        this.e = context5;
    }

    private final PendingIntent b(Intent intent, int i2) {
        final PendingIntent obj3 = PendingIntent.getBroadcast(this.e, i2 += i, intent, 201326592);
        n.e(obj3, "getBroadcast(\n            applicationContext,\n            POTTY_REMINDER_REQUEST_CODE + notificationId,\n            intent,\n            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE\n        )");
        return obj3;
    }

    private final String c(String string) {
        int i;
        String obj5;
        int i2 = 1;
        final int i3 = 0;
        i = string.length() == 0 ? i2 : i3;
        if (i != 0) {
            obj5 = this.e.getString(2131887192);
        }
        n.e(obj5, "if (dogName.isEmpty()) {\n            applicationContext.getString(R.string.reminder_daily_training_your_dog)\n        } else {\n            dogName\n        }");
        Object[] arr = new Object[i2];
        arr[i3] = obj5;
        obj5 = this.e.getString(2131887095, arr);
        n.e(obj5, "applicationContext.getString(R.string.potty_training_notification, tempDogName)");
        return obj5;
    }

    private final String d() {
        String string = this.e.getString(2131886080);
        n.e(string, "applicationContext.getString(R.string.CFBundleDisplayName)");
        return string;
    }

    private final boolean e(List<Boolean> list) {
        final int i4 = 7;
        return (Boolean)list.get(i2 %= i4).booleanValue();
    }

    private final void i(long l, long l2, int i3, String string4, String string5, boolean z6) {
        AlarmManager alarmManager;
        int i;
        long l3;
        PendingIntent intent;
        final Object obj = this;
        final int i2 = string5;
        final boolean z = obj20;
        a(i2);
        Class cls = h3.f;
        ComponentName componentName = new ComponentName(obj.e, cls);
        int i4 = 1;
        obj.b.setComponentEnabledSetting(componentName, i4, i4);
        Intent intent2 = new Intent(obj.e, cls);
        intent2.putExtra("reminder_id", "potty_reminder");
        intent2.putExtra("potty_reminder_id_key", z6);
        intent2.putExtra("potty_notification_id_key", i2);
        intent2.putExtra("dog_id", obj19);
        intent2.putExtra("interval_alarm", z);
        final PendingIntent intent3 = b(intent2, i2);
        if (z) {
            obj.c.setRepeating(0, l, obj8, i3);
        } else {
            obj.c.setRepeating(0, l, obj8, 86400000);
        }
    }

    public final void a(int i) {
        this.a.c(this.e, h3.f, i += i2);
    }

    public final boolean f(String string, long l2) {
        int i;
        n.f(string, "endTime");
        Calendar calendar = this.d.f();
        o obj5 = x.Companion.c(string);
        calendar.set(11, (Number)obj5.a().intValue());
        calendar.set(12, (Number)obj5.b().intValue());
        calendar.set(13, 0);
        if (Long.compare(i4, obj5) > 0) {
            i = 1;
        }
        return i;
    }

    public final o<Long, Boolean> g(String string, String string2, long l3, List<Boolean> list4) {
        Calendar calendar;
        long l;
        long timeInMillis;
        int obj9;
        Object obj10;
        Object obj11;
        n.f(string, "startTime");
        n.f(string2, "endTime");
        n.f(obj13, "dayFilter");
        calendar = this.d.f();
        Calendar calendar2 = this.d.f();
        l = this.d.g();
        x.a companion = x.Companion;
        obj9 = companion.c(string);
        obj10 = companion.c(string2);
        final int i5 = 11;
        calendar.set(i5, (Number)obj9.a().intValue());
        int i4 = 12;
        calendar.set(i4, (Number)obj9.b().intValue());
        obj9 = 13;
        final int i6 = 0;
        calendar.set(obj9, i6);
        calendar2.set(i5, (Number)obj10.a().intValue());
        calendar2.set(i4, (Number)obj10.b().intValue());
        calendar2.set(obj9, i6);
        if (Long.compare(timeInMillis, l) <= 0) {
            if (!e(obj13)) {
                obj9 = new o(Long.valueOf(calendar.getTimeInMillis()), Boolean.FALSE);
            } else {
                if (Long.compare(obj9, l) < 0 && Long.compare(obj9, timeInMillis) < 0) {
                    if (Long.compare(obj9, timeInMillis) < 0) {
                        obj9 = new o(Long.valueOf(timeInMillis2 += l), Boolean.TRUE);
                    } else {
                        obj10 = 1;
                        calendar.add(5, obj10);
                        obj9 = w.a;
                        obj11 = new o(Long.valueOf(calendar.getTimeInMillis()), Boolean.FALSE);
                        obj9 = obj11;
                    }
                } else {
                }
            }
        } else {
        }
        return obj9;
    }

    public final void h(PottyRemindersItem pottyRemindersItem) {
        String repeatIntervalMs;
        Object obj;
        String startTime;
        long longValue;
        long longValue3;
        List longValue2;
        List days;
        int notificationId;
        String reminderId;
        String dogId;
        boolean booleanValue;
        Object obj12;
        n.f(pottyRemindersItem, "reminder");
        if (pottyRemindersItem.getEndTime() != null && pottyRemindersItem.getRepeatIntervalMs() != null) {
            if (pottyRemindersItem.getRepeatIntervalMs() != null) {
                String endTime = pottyRemindersItem.getEndTime();
                n.d(endTime);
                longValue3 = pottyRemindersItem.getRepeatIntervalMs().longValue();
                days = pottyRemindersItem.getDays();
                o oVar = this.g(pottyRemindersItem.getStartTime(), endTime, longValue3, obj5);
                if (!pottyRemindersItem.isActive()) {
                    a(pottyRemindersItem.getNotificationId());
                } else {
                    this.i((Number)oVar.a().longValue(), longValue3, pottyRemindersItem.getRepeatIntervalMs().longValue(), days, pottyRemindersItem.getNotificationId(), pottyRemindersItem.getReminderId());
                }
            }
        }
    }

    public final void j(PottyRemindersItem pottyRemindersItem, String string2) {
        boolean active;
        String str;
        o2 o2Var;
        String str2;
        Object obj5;
        Object obj6;
        n.f(pottyRemindersItem, "remindersModel");
        n.f(string2, "dogName");
        if (pottyRemindersItem.isActive() && e(pottyRemindersItem.getDays())) {
            if (e(pottyRemindersItem.getDays())) {
                Intent intent = new Intent(this.e, SplashActivity.class);
                intent.putExtra("source", "potty_notification");
                intent.putExtra("uri", n.o("dogoapp://dogo.app/calendar?dog=", pottyRemindersItem.getDogId()));
                obj6 = c(string2);
                j.e eVar = this.a.f(intent, d(), obj6, "reminders_id");
                j.c cVar = new j.c();
                cVar.h(obj6);
                eVar.A(cVar);
                obj6 = m.c(this.e);
                n.e(obj6, "from(applicationContext)");
                obj6.e("potty_reminder", pottyRemindersItem.getNotificationId(), eVar.c());
            }
        }
    }
}
