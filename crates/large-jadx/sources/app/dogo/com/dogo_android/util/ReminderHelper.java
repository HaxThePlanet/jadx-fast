package app.dogo.com.dogo_android.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.o;
import kotlin.y.h0;
import kotlin.y.p;

/* compiled from: ReminderHelper.kt */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/util/ReminderHelper;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x, reason: from kotlin metadata */
public final class ReminderHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final x.a INSTANCE = new x$a(0);

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0004J\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\u0005J\"\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/util/ReminderHelper$Companion;", "", "()V", "getActiveWeekdayShortNameArray", "", "", "calendar", "Ljava/util/Calendar;", "activeDayList", "", "getWeekdayShortNameArray", "parseTimeToInts", "Lkotlin/Pair;", "", "timeString", "rotateDayListFromLocaleToMondayBased", "dayList", "rotateDayListFromMondayToLocaleBased", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final List<String> getActiveWeekdayShortNameArray(Calendar calendar, List<Boolean> activeDayList) {
            int i = 0;
            boolean booleanValue;
            Object item = null;
            n.f(calendar, "calendar");
            n.f(activeDayList, "activeDayList");
            final List weekdayShortNameArray = getWeekdayShortNameArray(calendar);
            ArrayList arrayList = new ArrayList();
            final Iterator it = activeDayList.iterator();
            i = 0;
            while (it.hasNext()) {
                i = i + 1;
                if (i < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
            return arrayList;
        }

        /* renamed from: b, reason: from kotlin metadata */
        public final List<String> getWeekdayShortNameArray(Calendar calendar) {
            n.f(calendar, "calendar");
            final int i3 = 7;
            kotlin.h0.f fVar = g.l(0, i3);
            final ArrayList arrayList = new ArrayList(p.r(fVar, 10));
            Iterator it = fVar.iterator();
            while (it.hasNext()) {
                calendar.set(i3, (IntIterator)it.d() + calendar.getFirstDayOfWeek());
                arrayList.add(new SimpleDateFormat("EEE", Locale.getDefault()).format(calendar.getTime()));
            }
            return arrayList;
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final o<Integer, Integer> parseTimeToInts(String timeString) {
            int i;
            n.f(timeString, "timeString");
            i = 0;
            Object[] array = new Regex(":").f(timeString, i).toArray(new String[i]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ArrayList arrayList = new ArrayList(array.length);
            for (Object obj : array) {
                str = "null cannot be cast to non-null type kotlin.CharSequence";
                Objects.requireNonNull(obj, str);
                arrayList.add(Integer.valueOf(Integer.parseInt(l.a1(obj).toString())));
            }
            return new Pair(arrayList.get(i), arrayList.get(1));
        }

        /* renamed from: d, reason: from kotlin metadata */
        public final List<Boolean> rotateDayListFromLocaleToMondayBased(List<Boolean> dayList, Calendar calendar) {
            n.f(dayList, "dayList");
            n.f(calendar, "calendar");
            Collections.rotate(dayList, calendar.getFirstDayOfWeek() - 2);
            return dayList;
        }

        /* renamed from: e, reason: from kotlin metadata */
        public final List<Boolean> rotateDayListFromMondayToLocaleBased(List<Boolean> dayList, Calendar calendar) {
            n.f(dayList, "dayList");
            n.f(calendar, "calendar");
            Collections.rotate(dayList, calendar.getFirstDayOfWeek() - 2);
            return dayList;
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }
}
