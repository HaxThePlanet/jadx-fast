package app.dogo.com.dogo_android.u.n.q;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.x;
import app.dogo.com.dogo_android.util.x.a;
import app.dogo.com.dogo_android.w.h0;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.f;
import kotlin.o;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u0000 @2\u00020\u0001:\u0001@B7\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010/\u001a\u00020\u0012J\u0012\u00100\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u000202H\u0002J\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011J\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u00020#0\u0011J(\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u001aH\u0002J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u0012J\u0006\u0010>\u001a\u00020;J\u0006\u0010?\u001a\u00020;R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0014R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0014R\u0017\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0017\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0014R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120'0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u0014R\u0017\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010!R\u0017\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u0014R\u0017\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "presetReminderData", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;)V", "activeDayLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "", "getActiveDayLiveData", "()Landroidx/lifecycle/MutableLiveData;", "activeDays", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "fromHourLiveData", "", "getFromHourLiveData", "fromMinuteLiveData", "getFromMinuteLiveData", "goToNext", "Lcom/hadilq/liveevent/LiveEvent;", "getGoToNext", "()Lcom/hadilq/liveevent/LiveEvent;", "intervalLiveData", "", "getIntervalLiveData", "lastClickTime", "reminderSaveLoad", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getReminderSaveLoad", "shouldShowWrongTimeError", "getShouldShowWrongTimeError", "toHourLiveData", "getToHourLiveData", "toMinuteLiveData", "getToMinuteLiveData", "atLeastOneDaySelected", "buildReminder", "dogId", "", "getActiveDays", "getIntervalList", "isTimeValid", "fromHours", "fromMinutes", "toHours", "toMinutes", "onDayButtonToggle", "", "dayPosition", "newState", "saveReminder", "trackPottyRemindersSet", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends s {

    public static final app.dogo.com.dogo_android.u.n.q.l.a Companion;
    private final PottyRemindersItem a;
    private final o3 b;
    private final l1 c;
    private final v2 d;
    private final p1 e;
    private final h2 f;
    private long g;
    private final x<y<Boolean>> h;
    private final a<Boolean> i;
    private final a<Boolean> j;
    private final x<Integer> k;
    private final x<Integer> l;
    private final x<Integer> m;
    private final x<Integer> n;
    private final x<Long> o;
    private final List<Boolean> p;
    private final x<List<Boolean>> q;
    private final CoroutineExceptionHandler r;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderViewModel$Companion;", "", "()V", "CLICK_TIMEOUT", "", "INTERVAL_TYPE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.u.n.q.l a;
        public c(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.u.n.q.l l2) {
            this.a = l2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.v().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.reminders.PottyProgramReminderViewModel$saveReminder$1", f = "PottyProgramReminderViewModel.kt", l = {}, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.u.n.q.l this$0;
        b(app.dogo.com.dogo_android.u.n.q.l l, d<? super app.dogo.com.dogo_android.u.n.q.l.b> d2) {
            this.this$0 = l;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.b obj2 = new l.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object cVar;
            Object cVar2;
            l1 l1Var;
            Boolean bool;
            String str;
            Object obj4;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                this.this$0.v().postValue(y.b.a);
                obj4 = l.l(this.this$0).v().blockingGet();
                n.e((String)obj4, "dogId");
                obj4 = l.h(this.this$0, obj4);
                int i = 1;
                if (obj4 != null) {
                    if (l.j(this.this$0) != null) {
                        l.k(this.this$0).S(l.i(this.this$0).v(), obj4).e();
                    } else {
                        l.k(this.this$0).G(l.i(this.this$0).v(), obj4).e();
                    }
                    cVar2 = new y.c(b.a(i));
                    this.this$0.v().postValue(cVar2);
                    this.this$0.s().postValue(b.a(i));
                } else {
                    this.this$0.w().postValue(b.a(i));
                    cVar = new y.c(b.a(false));
                    this.this$0.v().postValue(cVar);
                }
                return w.a;
            }
            obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
    }
    static {
        l.a aVar = new l.a(0);
        l.Companion = aVar;
    }

    public l(PottyRemindersItem pottyRemindersItem, o3 o32, l1 l13, v2 v24, p1 p15, h2 h26) {
        Object repeatIntervalMs;
        int intValue2;
        String endTime;
        int intValue;
        x xVar;
        List obj5;
        Object obj6;
        int obj7;
        int obj8;
        int obj9;
        Object obj10;
        n.f(o32, "tracker");
        n.f(l13, "reminderRepository");
        n.f(v24, "utilities");
        n.f(p15, "userRepository");
        n.f(h26, "authService");
        super();
        this.a = pottyRemindersItem;
        this.b = o32;
        this.c = l13;
        this.d = v24;
        this.e = p15;
        this.f = h26;
        obj6 = new x();
        this.h = obj6;
        obj6 = new a();
        this.i = obj6;
        obj6 = new a();
        this.j = obj6;
        obj7 = 2;
        if (pottyRemindersItem != null) {
            obj9 = x.Companion;
            obj10 = obj9.c(pottyRemindersItem.getStartTime());
            endTime = pottyRemindersItem.getEndTime() == null ? "20:00" : endTime;
            o oVar = obj9.c(endTime);
            xVar = new x(Integer.valueOf((Number)obj10.a().intValue()));
            this.k = xVar;
            x xVar2 = new x(Integer.valueOf((Number)obj10.b().intValue()));
            this.l = xVar2;
            obj10 = new x(Integer.valueOf((Number)oVar.a().intValue()));
            this.m = obj10;
            obj10 = new x(Integer.valueOf((Number)oVar.b().intValue()));
            this.n = obj10;
            repeatIntervalMs = pottyRemindersItem.getRepeatIntervalMs();
            if (repeatIntervalMs == null) {
            } else {
                obj6 = repeatIntervalMs.longValue();
            }
            obj10 = new x(Long.valueOf(obj6));
            this.o = obj10;
            obj5 = pottyRemindersItem.getDays();
            obj9.e(obj5, v24.f());
            this.p = p.N0(obj5);
        } else {
            obj8 = 10;
            obj5 = new x(Integer.valueOf(obj8));
            this.k = obj5;
            obj9 = 0;
            obj5 = new x(Integer.valueOf(obj9));
            this.l = obj5;
            obj5 = new x(20);
            this.m = obj5;
            obj5 = new x(Integer.valueOf(obj9));
            this.n = obj5;
            obj5 = new x(Long.valueOf((Number)t().get(obj7).longValue()));
            this.o = obj5;
            obj5 = new f(obj9, 6);
            obj6 = new ArrayList(p.r(obj5, obj8));
            obj5 = obj5.iterator();
            while (obj5.hasNext()) {
                (h0)obj5.d();
                obj6.add(Boolean.TRUE);
            }
            this.p = p.N0(obj6);
        }
        obj5 = new x(this.p);
        this.q = obj5;
        obj6 = new l.c(CoroutineExceptionHandler.r, this);
        this.r = obj6;
    }

    public static final PottyRemindersItem h(app.dogo.com.dogo_android.u.n.q.l l, String string2) {
        return l.n(string2);
    }

    public static final h2 i(app.dogo.com.dogo_android.u.n.q.l l) {
        return l.f;
    }

    public static final PottyRemindersItem j(app.dogo.com.dogo_android.u.n.q.l l) {
        return l.a;
    }

    public static final l1 k(app.dogo.com.dogo_android.u.n.q.l l) {
        return l.c;
    }

    public static final p1 l(app.dogo.com.dogo_android.u.n.q.l l) {
        return l.e;
    }

    private final PottyRemindersItem n(String string) {
        int pottyRemindersItem;
        int intValue;
        int intValue2;
        boolean str;
        PottyRemindersItem reminderId;
        int i2;
        Object[] arr;
        int i3;
        PottyRemindersItem pottyRemindersItem2;
        Object pottyRemindersItem3;
        String str2;
        List list;
        String format;
        String str3;
        Long valueOf;
        int i;
        final Object obj = this;
        Object value = obj.k.getValue();
        n.d(value);
        n.e(value, "fromHourLiveData.value!!");
        int intValue3 = (Number)value.intValue();
        Object value2 = obj.l.getValue();
        n.d(value2);
        n.e(value2, "fromMinuteLiveData.value!!");
        intValue = (Number)value2.intValue();
        Object value3 = obj.m.getValue();
        n.d(value3);
        n.e(value3, "toHourLiveData.value!!");
        intValue2 = (Number)value3.intValue();
        Object value4 = obj.n.getValue();
        n.d(value4);
        n.e(value4, "toMinuteLiveData.value!!");
        int intValue4 = (Number)value4.intValue();
        Object value5 = obj.o.getValue();
        n.d(value5);
        final String str9 = "intervalLiveData.value!!";
        n.e(value5, str9);
        if (obj.z(intValue3, intValue, intValue2, intValue4)) {
            str = "%02d:%02d";
            List list2 = obj.p;
            x.Companion.d(list2, obj.d.f());
            reminderId = obj.a;
            if (reminderId == null) {
                pottyRemindersItem3 = str10;
            } else {
            }
            f0 f0Var = f0.a;
            i2 = 2;
            Object[] arr2 = new Object[i2];
            i3 = 0;
            arr2[i3] = Integer.valueOf(intValue3);
            int i4 = 1;
            arr2[i4] = Integer.valueOf(intValue);
            format = String.format(str, Arrays.copyOf(arr2, i2));
            String str4 = "java.lang.String.format(format, *args)";
            n.e(format, str4);
            arr = new Object[i2];
            arr[i3] = Integer.valueOf(intValue2);
            arr[i4] = Integer.valueOf(intValue4);
            intValue = String.format(str, Arrays.copyOf(arr, i2));
            n.e(intValue, str4);
            super(pottyRemindersItem3, string, p.N0(list2), format, intValue, Long.valueOf((Number)value5.longValue()), 1);
        } else {
            pottyRemindersItem = 0;
        }
        return pottyRemindersItem;
    }

    private final boolean z(int i, int i2, int i3, int i4) {
        int i5;
        i5 = 0;
        if (i < i3) {
            i5 = i6;
        } else {
        }
        return i5;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A(int i, boolean z2) {
        this.p.set(i, Boolean.valueOf(z2));
        this.q.postValue(this.p);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B() {
        long l;
        CoroutineExceptionHandler exc;
        boolean cmp;
        m0 m0Var;
        int plus;
        int i;
        app.dogo.com.dogo_android.u.n.q.l.b bVar;
        int i2;
        int i3;
        l = this.d.g();
        if (!value instanceof y.b && Long.compare(i4, plus) > 0) {
            if (Long.compare(i4, plus) > 0) {
                this.g = l;
                bVar = new l.b(this, 0);
                k.d(f0.a(this), c1.b().plus(this.r), 0, bVar, 2, 0);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        o2 o2Var = new o2();
        this.b.d(h0.a.d(u.a(o2Var, "interval")));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m() {
        return this.p.contains(Boolean.TRUE);
    }

    public final x<List<Boolean>> o() {
        return this.q;
    }

    public final List<Boolean> p() {
        return p.L0(this.p);
    }

    public final x<Integer> q() {
        return this.k;
    }

    public final x<Integer> r() {
        return this.l;
    }

    public final a<Boolean> s() {
        return this.i;
    }

    public final List<Long> t() {
        Long[] arr = new Long[10];
        TimeUnit mINUTES = TimeUnit.MINUTES;
        int i14 = 0;
        arr[i14] = Long.valueOf(mINUTES.toMillis(15));
        int i3 = 30;
        arr[1] = Long.valueOf(mINUTES.toMillis(i3));
        TimeUnit hOURS = TimeUnit.HOURS;
        int i15 = 2;
        arr[i15] = Long.valueOf(hOURS.toMillis(1));
        int i16 = 3;
        arr[i16] = Long.valueOf(hOURS.toMillis(2));
        int i17 = 4;
        arr[i17] = Long.valueOf(hOURS.toMillis(3));
        int i18 = 5;
        arr[i18] = Long.valueOf(hOURS.toMillis(4));
        int i19 = 6;
        arr[i19] = Long.valueOf(hOURS.toMillis(5));
        int i20 = 7;
        arr[i20] = Long.valueOf(hOURS.toMillis(6));
        int i21 = 8;
        arr[i21] = Long.valueOf(hOURS.toMillis(7));
        int i12 = 8;
        arr[9] = Long.valueOf(hOURS.toMillis(i12));
        return p.j(arr);
    }

    public final x<Long> u() {
        return this.o;
    }

    public final x<y<Boolean>> v() {
        return this.h;
    }

    public final a<Boolean> w() {
        return this.j;
    }

    public final x<Integer> x() {
        return this.m;
    }

    public final x<Integer> y() {
        return this.n;
    }
}
