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
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.o;
import kotlin.y.h0;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/util/ReminderHelper;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x {

    public static final app.dogo.com.dogo_android.util.x.a Companion;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0004J\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\u0005J\"\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00042\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/util/ReminderHelper$Companion;", "", "()V", "getActiveWeekdayShortNameArray", "", "", "calendar", "Ljava/util/Calendar;", "activeDayList", "", "getWeekdayShortNameArray", "parseTimeToInts", "Lkotlin/Pair;", "", "timeString", "rotateDayListFromLocaleToMondayBased", "dayList", "rotateDayListFromMondayToLocaleBased", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final List<String> a(Calendar calendar, List<Boolean> list2) {
            int i2;
            boolean booleanValue;
            int i;
            int i3;
            n.f(calendar, "calendar");
            n.f(list2, "activeDayList");
            final List obj6 = b(calendar);
            ArrayList arrayList = new ArrayList();
            final Iterator obj7 = list2.iterator();
            i2 = 0;
            for (Object next2 : obj7) {
                if ((Boolean)next2.booleanValue() && i2 <= p.i(obj6)) {
                }
                if (i3 != 0) {
                }
                i2 = i;
                arrayList.add(i3);
                if (i2 <= p.i(obj6)) {
                }
                i3 = i2;
            }
            return arrayList;
        }

        public final List<String> b(Calendar calendar) {
            int format;
            n.f(calendar, "calendar");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.getDefault());
            final int i2 = 7;
            kotlin.h0.f fVar = g.l(0, i2);
            ArrayList arrayList = new ArrayList(p.r(fVar, 10));
            Iterator iterator = fVar.iterator();
            while (iterator.hasNext()) {
                calendar.set(i2, i4 += firstDayOfWeek);
                arrayList.add(simpleDateFormat.format(calendar.getTime()));
            }
            return arrayList;
        }

        public final o<Integer, Integer> c(String string) {
            int i;
            Integer valueOf;
            String str;
            n.f(string, "timeString");
            h hVar = new h(":");
            int i2 = 0;
            Object[] obj7 = hVar.f(string, i2).toArray(new String[i2]);
            Objects.requireNonNull(obj7, "null cannot be cast to non-null type kotlin.Array<T>");
            ArrayList arrayList = new ArrayList(obj7.length);
            i = i2;
            while (i < obj7.length) {
                Object obj3 = obj7[i];
                Objects.requireNonNull((String)obj3, "null cannot be cast to non-null type kotlin.CharSequence");
                arrayList.add(Integer.valueOf(Integer.parseInt(l.a1(obj3).toString())));
                i++;
            }
            obj7 = new o(arrayList.get(i2), arrayList.get(1));
            return obj7;
        }

        public final List<Boolean> d(List<Boolean> list, Calendar calendar2) {
            n.f(list, "dayList");
            n.f(calendar2, "calendar");
            Collections.rotate(list, obj3 += -2);
            return list;
        }

        public final List<Boolean> e(List<Boolean> list, Calendar calendar2) {
            n.f(list, "dayList");
            n.f(calendar2, "calendar");
            Collections.rotate(list, obj3 - 2);
            return list;
        }
    }
    static {
        x.a aVar = new x.a(0);
        x.Companion = aVar;
    }
}
