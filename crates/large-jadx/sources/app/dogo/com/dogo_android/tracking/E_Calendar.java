package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$Calendar;", "", "()V", "CalendarTapped", "Lapp/dogo/com/dogo_android/tracking/Event1;", "Lapp/dogo/com/dogo_android/tracking/EP$Streak;", "NewReminderTapped", "Lapp/dogo/com/dogo_android/tracking/EP$Type;", "PottyLogDeleted", "ScheduleEntrySaveTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r, reason: from kotlin metadata */
public final class E_Calendar {

    public static final u2<o2> a;
    public static final u2<o2> b;
    public static final u2<j2> c;
    public static final u2<o2> d;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_Calendar.a = companion2.a("schedule_entry_save_tapped").b(new EP_Type());
        E_Calendar.b = companion2.a("set_reminder_tapped").b(new EP_Type());
        E_Calendar.c = companion2.a("potty_calendar_tapped").b(new EP_Streak());
        E_Calendar.d = companion2.a("potty_log_deleted").b(new EP_Type());
    }
}
