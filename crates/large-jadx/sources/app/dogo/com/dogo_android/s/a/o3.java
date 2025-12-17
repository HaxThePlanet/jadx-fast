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
import app.dogo.com.dogo_android.k.l;
import app.dogo.com.dogo_android.k.l.a;
import app.dogo.com.dogo_android.k.m;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.service.o2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.h0.j1;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.y.p;
import n.a.a;
import net.time4j.g1.v;
import net.time4j.h;
import net.time4j.k0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 22\u00020\u0001:\u00012B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000fJ\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0008\u0010 \u001a\u00020\u001dH\u0002J\u0016\u0010!\u001a\u00020\"2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\"0\u000eH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u001dH\u0002J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020'J\u0018\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/TrainingReminderNotificationInteractor;", "", "notificationService", "Lapp/dogo/com/dogo_android/service/NotificationService;", "packageManager", "Landroid/content/pm/PackageManager;", "alarmManager", "Landroid/app/AlarmManager;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "applicationContext", "Landroid/content/Context;", "(Lapp/dogo/com/dogo_android/service/NotificationService;Landroid/content/pm/PackageManager;Landroid/app/AlarmManager;Lapp/dogo/com/dogo_android/service/Utilities;Landroid/content/Context;)V", "trainingMessageResIds", "", "", "getTrainingMessageResIds", "()Ljava/util/List;", "cancelNotification", "", "cancelTrainingReminderNotificationAlarm", "requestCode", "delayReminderNotificationByMinutes", "delayMinutes", "getPendingIntent", "Landroid/app/PendingIntent;", "intent", "Landroid/content/Intent;", "getTrainingReminderDescription", "", "reminderNumber", "dogName", "getTrainingReminderTitle", "isDayCorrect", "", "dayFilter", "parseRemindersCalendar", "Ljava/util/Calendar;", "remindersModel", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "parseTrainingMessage", "fullMessage", "setTrainingReminderNotification", "reminder", "setupNotificationAlarm", "timeMs", "", "repeatFrequency", "Lapp/dogo/com/dogo_android/enums/NotificationRepeating;", "showTrainingReminderNotification", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o3 {

    public static final app.dogo.com.dogo_android.s.a.o3.a Companion;
    private static final Class<NotificationBroadcaster> f;
    private final o2 a;
    private final PackageManager b;
    private final AlarmManager c;
    private final v2 d;
    private final Context e;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/TrainingReminderNotificationInteractor$Companion;", "", "()V", "TRAINING_NOTIFICATION_SOURCE", "", "broadcasterClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/alarms/NotificationBroadcaster;", "getBroadcasterClass", "()Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        o3.a aVar = new o3.a(0);
        o3.Companion = aVar;
        o3.f = NotificationBroadcaster.class;
    }

    public o3(o2 o2, PackageManager packageManager2, AlarmManager alarmManager3, v2 v24, Context context5) {
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

    public static void c(app.dogo.com.dogo_android.s.a.o3 o3, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 10001000;
        }
        o3.b(obj1);
    }

    private final PendingIntent e(Intent intent, int i2) {
        final PendingIntent obj3 = PendingIntent.getBroadcast(this.e, i2, intent, 201326592);
        n.e(obj3, "getBroadcast(\n            applicationContext,\n            requestCode,\n            intent,\n            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE\n        )");
        return obj3;
    }

    static PendingIntent f(app.dogo.com.dogo_android.s.a.o3 o3, Intent intent2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 10001000;
        }
        return o3.e(intent2, obj2);
    }

    private final List<Integer> g() {
        Integer[] arr = new Integer[8];
        return p.j(2131887184, 2131887185, 2131887186, 2131887187, 2131887188, 2131887189, 2131887190, 2131887191);
    }

    private final String h(int i, String string2) {
        int i2;
        int obj5;
        String obj6;
        int i3 = 1;
        final int i4 = 0;
        i2 = string2.length() == 0 ? i3 : i4;
        if (i2 != 0) {
            obj6 = this.e.getString(2131887192);
        }
        n.e(obj6, "if (dogName.isEmpty()) {\n            applicationContext.getString(R.string.reminder_daily_training_your_dog)\n        } else {\n            dogName\n        }");
        obj5 = p.a0(g(), i);
        if ((Integer)obj5 == null) {
            obj5 = (Number)p.j0(g()).intValue();
        } else {
            obj5 = (Integer)obj5.intValue();
        }
        Object[] arr = new Object[i3];
        arr[i4] = obj6;
        obj5 = this.e.getString(obj5, arr);
        n.e(obj5, "applicationContext.getString(\n            trainingMessageResIds.getOrNull(reminderNumber)\n                ?: trainingMessageResIds.last(),\n            tempDogName\n        )");
        return l.r(j1.d(l(obj5)));
    }

    private final String i() {
        String string = this.e.getString(2131886080);
        n.e(string, "applicationContext.getString(R.string.CFBundleDisplayName)");
        return string;
    }

    private final boolean j(List<Boolean> list) {
        final int i4 = 7;
        return (Boolean)list.get(i2 %= i4).booleanValue();
    }

    private final Calendar k(RemindersModel remindersModel) {
        Object throwable;
        String str2;
        String str;
        int i;
        int i3;
        int i7;
        int i2;
        int i4;
        int i5;
        int i6;
        int i8;
        int i9;
        int i10;
        boolean obj12;
        Calendar calendar = this.d.f();
        if (remindersModel.getTime() == null) {
            throwable = new Throwable(n.o("remindersModel time is null ", remindersModel.getId()));
            a.d(throwable);
        }
        obj12 = remindersModel.getTime();
        n.d(obj12);
        h hVar = new h(":");
        int i13 = 0;
        obj12 = hVar.f(obj12, i13).toArray(new String[i13]);
        Objects.requireNonNull(obj12, "null cannot be cast to non-null type kotlin.Array<T>");
        Object obj = (String[])obj12[i13];
        final int i16 = 1;
        length2 -= i16;
        i5 = i2;
        i8 = 32;
        while (i2 <= i3) {
            if (i5 == 0) {
            } else {
            }
            i10 = i3;
            if (n.h(obj.charAt(i10), i8) <= 0) {
            } else {
            }
            i9 = i13;
            if (i5 != 0) {
                break;
            } else {
            }
            if (i9 == 0) {
                break;
            } else {
            }
            i3--;
            i8 = 32;
            if (i9 == 0) {
            } else {
            }
            i2++;
            i5 = i16;
            i9 = i16;
            i10 = i2;
        }
        calendar.set(11, Integer.parseInt(obj.subSequence(i2, i3 += i16).toString()));
        obj12 = obj12[i16];
        length -= i16;
        i4 = i7;
        while (i7 <= i) {
            if (i4 == 0) {
            } else {
            }
            i6 = i;
            if (n.h(obj12.charAt(i6), i8) <= 0) {
            } else {
            }
            i5 = i13;
            if (i4 != 0) {
                break;
            } else {
            }
            if (i5 == 0) {
                break;
            } else {
            }
            i--;
            if (i5 == 0) {
            } else {
            }
            i7++;
            i4 = i16;
            i5 = i16;
            i6 = i7;
        }
        calendar.set(12, Integer.parseInt(obj12.subSequence(i7, i += i16).toString()));
        calendar.set(13, i13);
        if (calendar.before(this.d.f())) {
            calendar.add(5, i16);
        }
        return calendar;
    }

    private final String l(String string) {
        boolean array;
        int nextInt;
        int length;
        int str;
        int i4;
        java.lang.CharSequence charSequence;
        String substring;
        Object obj;
        int i3;
        int i;
        int i2;
        Object obj12;
        nextInt = 0;
        length = 2;
        str = 0;
        if (l.R(string, "{", nextInt, length, str) && l.R(string, "}", nextInt, length, str)) {
            if (l.R(string, "}", nextInt, length, str)) {
                String str6 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(string, str6);
                String substring2 = string.substring(l.e0(string, "{", 0, false, 6, 0));
                n.e(substring2, "(this as java.lang.String).substring(startIndex)");
                i4 = 1;
                Objects.requireNonNull(substring2, str6);
                substring = substring2.substring(nextInt, i6 += i4);
                String str4 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                n.e(substring, str4);
                Objects.requireNonNull(substring, str6);
                String substring3 = substring.substring(i4, length2 -= i4);
                n.e(substring3, str4);
                h hVar = new h(",");
                array = hVar.f(substring3, nextInt).toArray(new String[nextInt]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                Random random = new Random();
                obj12 = l.G(string, substring, (String[])array[random.nextInt(array.length)], false, 4, 0);
            }
        }
        return obj12;
    }

    private final void n(long l, l l2) {
        l weekly;
        Object temp;
        String str;
        long l3;
        int i;
        Object obj14;
        final int i2 = 0;
        int i3 = 1;
        final int i5 = 0;
        o3.c(this, i2, i3, i5);
        Class cls = o3.f;
        ComponentName componentName = new ComponentName(this.e, cls);
        this.b.setComponentEnabledSetting(componentName, i3, i3);
        Intent intent = new Intent(this.e, cls);
        intent.putExtra("reminder_id", "training_reminder");
        if (obj14 == l.Temp) {
            intent.putExtra("temp_reminder", i3);
        }
        final PendingIntent intent2 = o3.f(this, intent, i2, 2, i5);
        if (obj14 != l.Daily) {
            if (obj14 == l.Weekly) {
                this.c.setRepeating(0, l, obj7, 86400000);
            } else {
                this.c.set(i2, l, l2);
            }
        } else {
        }
    }

    public final void a() {
        this.a.b("reminder_id");
    }

    public final void b(int i) {
        this.a.c(this.e, o3.f, i);
    }

    public final void d(int i) {
        Calendar calendar = this.d.f();
        final int i2 = 12;
        calendar.add(i2, i);
        n(calendar.getTimeInMillis(), i2);
    }

    public final void m(RemindersModel remindersModel) {
        int timeInMillis;
        int i;
        l.a companion;
        int obj4;
        n.f(remindersModel, "reminder");
        if (!remindersModel.isActive()) {
            o3.c(this, 0, 1, 0);
        } else {
            n(k(remindersModel).getTimeInMillis(), obj1);
        }
    }

    public final void o(RemindersModel remindersModel, String string2) {
        boolean active;
        boolean service;
        String tag;
        m training;
        int i3;
        int i4;
        String string;
        int i2;
        Object[] arr;
        String str;
        int i;
        h mINUTES;
        v wIDE;
        Object obj14;
        Object obj15;
        n.f(remindersModel, "remindersModel");
        n.f(string2, "dogName");
        Random random = new Random();
        int nextInt = random.nextInt(p.i(g()));
        Intent intent = new Intent(this.e, SplashActivity.class);
        intent.putExtra("source", "training_notification");
        intent.putExtra("notification_string_id", nextInt);
        obj15 = h(nextInt, string2);
        active = this.a.f(intent, i(), obj15, "reminders_id");
        training = m.Training;
        i3 = 0;
        if (remindersModel.isActive() && j(remindersModel.getDays()) && n.b(remindersModel.getType(), training.getTag())) {
            if (j(remindersModel.getDays())) {
                random = new Random();
                nextInt = random.nextInt(p.i(g()));
                intent = new Intent(this.e, SplashActivity.class);
                intent.putExtra("source", "training_notification");
                intent.putExtra("notification_string_id", nextInt);
                obj15 = h(nextInt, string2);
                active = this.a.f(intent, i(), obj15, "reminders_id");
                training = m.Training;
                i3 = 0;
                if (n.b(remindersModel.getType(), training.getTag())) {
                    Intent intent2 = new Intent(this.e, SnoozeAction.class);
                    intent2.putExtra("reminder_id", remindersModel.getId());
                    arr = new Object[1];
                    arr[i3] = k0.d(Locale.getDefault()).f(15, obj10, h.MINUTES);
                    active.a(2131231358, this.e.getString(2131887183, arr), PendingIntent.getService(this.e, i3, intent2, 335544320));
                }
                j.c cVar = new j.c();
                cVar.h(obj15);
                active.A(cVar);
                obj15 = m.c(this.e);
                n.e(obj15, "from(applicationContext)");
                if (n.b(remindersModel.getType(), training.getTag())) {
                    obj15.e("training_reminder", i3, active.c());
                }
            }
        }
    }
}
