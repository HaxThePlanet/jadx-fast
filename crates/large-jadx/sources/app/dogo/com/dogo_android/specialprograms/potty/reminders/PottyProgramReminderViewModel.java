package app.dogo.com.dogo_android.u.n.q;

import androidx.lifecycle.LiveData;
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
import app.dogo.com.dogo_android.util.x.a;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import i.b.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.m0;

/* compiled from: PottyProgramReminderViewModel.kt */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u0000 @2\u00020\u0001:\u0001@B7\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010/\u001a\u00020\u0012J\u0012\u00100\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u000202H\u0002J\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011J\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u00020#0\u0011J(\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u001aH\u0002J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u0012J\u0006\u0010>\u001a\u00020;J\u0006\u0010?\u001a\u00020;R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0014R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0014R\u0017\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0017\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0014R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120'0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u0014R\u0017\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010!R\u0017\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u0014R\u0017\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "presetReminderData", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;)V", "activeDayLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "", "getActiveDayLiveData", "()Landroidx/lifecycle/MutableLiveData;", "activeDays", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "fromHourLiveData", "", "getFromHourLiveData", "fromMinuteLiveData", "getFromMinuteLiveData", "goToNext", "Lcom/hadilq/liveevent/LiveEvent;", "getGoToNext", "()Lcom/hadilq/liveevent/LiveEvent;", "intervalLiveData", "", "getIntervalLiveData", "lastClickTime", "reminderSaveLoad", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getReminderSaveLoad", "shouldShowWrongTimeError", "getShouldShowWrongTimeError", "toHourLiveData", "getToHourLiveData", "toMinuteLiveData", "getToMinuteLiveData", "atLeastOneDaySelected", "buildReminder", "dogId", "", "getActiveDays", "getIntervalList", "isTimeValid", "fromHours", "fromMinutes", "toHours", "toMinutes", "onDayButtonToggle", "", "dayPosition", "newState", "saveReminder", "trackPottyRemindersSet", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class PottyProgramReminderViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final l.a INSTANCE = new l$a(0);
    private final PottyRemindersItem a;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 activeDays;
    /* renamed from: c, reason: from kotlin metadata */
    private final l1 authService;
    /* renamed from: d, reason: from kotlin metadata */
    private final v2 exceptionHandler;
    private final p1 e;
    private final h2 f;
    private long g;
    private final androidx.lifecycle.x<y<Boolean>> h = new x<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> lastClickTime = new a<>();
    /* renamed from: j, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> presetReminderData = new a<>();
    /* renamed from: k, reason: from kotlin metadata */
    private final androidx.lifecycle.x<Integer> reminderRepository;
    private final androidx.lifecycle.x<Integer> l;
    private final androidx.lifecycle.x<Integer> m;
    private final androidx.lifecycle.x<Integer> n;
    private final androidx.lifecycle.x<Long> o;
    /* renamed from: p, reason: from kotlin metadata */
    private final List<Boolean> tracker;
    /* renamed from: q, reason: from kotlin metadata */
    private final androidx.lifecycle.x<List<Boolean>> userRepository = new x<>();
    /* renamed from: r, reason: from kotlin metadata */
    private final CoroutineExceptionHandler utilities = new l$c();

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderViewModel$Companion;", "", "()V", "CLICK_TIMEOUT", "", "INTERVAL_TYPE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ l a;
        public c(CoroutineExceptionHandler.a exc, l lVar) {
            this.a = lVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.v().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.reminders.PottyProgramReminderViewModel$saveReminder$1", f = "PottyProgramReminderViewModel.kt", l = {}, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                l.this.v().postValue(LoadResult_Loading.a);
                Object blockingGet = l.this.e.v().blockingGet();
                n.e(blockingGet, "dogId");
                PottyRemindersItem onDayButtonToggle = l.this.n(blockingGet);
                boolean z = true;
                if (onDayButtonToggle != null) {
                    if (l.this.a != null) {
                        l.this.authService.S(l.this.f.v(), onDayButtonToggle).e();
                    } else {
                        l.this.authService.G(l.this.f.v(), onDayButtonToggle).e();
                    }
                    l.this.v().postValue(new LoadResult_Success(b.a(z)));
                    l.this.s().postValue(b.a(z));
                } else {
                    l.this.w().postValue(b.a(z));
                    l.this.v().postValue(new LoadResult_Success(b.a(false)));
                }
                return w.a;
            }
        }

        b(d<? super l.b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.specialprograms.potty.reminders.l.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.specialprograms.potty.reminders.l.b(l.this, dVar);
        }
    }
    public l(PottyRemindersItem pottyRemindersItem, o3 o3Var, l1 l1Var, v2 v2Var, p1 p1Var, h2 h2Var) {
        String endTime;
        long longValue;
        n.f(o3Var, "tracker");
        n.f(l1Var, "reminderRepository");
        n.f(v2Var, "utilities");
        n.f(p1Var, "userRepository");
        str = "authService";
        n.f(h2Var, str);
        super();
        this.a = pottyRemindersItem;
        this.activeDays = o3Var;
        this.authService = l1Var;
        this.exceptionHandler = v2Var;
        this.e = p1Var;
        this.f = h2Var;
        androidx.lifecycle.x xVar9 = new x();
        f.d.a.a aVar2 = new a();
        f.d.a.a aVar3 = new a();
        int i5 = 2;
        if (pottyRemindersItem != null) {
            x.a companion2 = ReminderHelper.Companion;
            o oVar2 = companion2.c(pottyRemindersItem.getStartTime());
            endTime = pottyRemindersItem.getEndTime() == null ? "20:00" : endTime;
            o oVar = ReminderHelper.Companion.c(endTime);
            this.reminderRepository = new x(Integer.valueOf((Number)oVar2.a().intValue()));
            this.l = new x(Integer.valueOf((Number)oVar2.b().intValue()));
            this.m = new x(Integer.valueOf((Number)oVar.a().intValue()));
            this.n = new x(Integer.valueOf((Number)oVar.b().intValue()));
            Long repeatIntervalMs = pottyRemindersItem.getRepeatIntervalMs();
            if (repeatIntervalMs != null) {
                longValue = repeatIntervalMs.longValue();
            }
            x xVar12 = new x(Long.valueOf(longValue));
            this.o = xVar12;
            List days = pottyRemindersItem.getDays();
            ReminderHelper.Companion.e(days, v2Var.f());
            this.tracker = p.N0(days);
        } else {
            int i2 = 10;
            this.reminderRepository = new x(Integer.valueOf(i2));
            int i3 = 0;
            this.l = new x(Integer.valueOf(i3));
            this.m = new x(20);
            this.n = new x(Integer.valueOf(i3));
            this.o = new x(Long.valueOf((Number)t().get(i5).longValue()));
            kotlin.h0.f intRange = new IntRange(i3, 6);
            ArrayList arrayList = new ArrayList(p.r(intRange, i2));
            Iterator pottyRemindersItem2 = intRange.iterator();
            while (pottyRemindersItem2.hasNext()) {
                (IntIterator)pottyRemindersItem2.d();
                arrayList.add(Boolean.TRUE);
            }
            this.tracker = p.N0(arrayList);
        }
        androidx.lifecycle.x xVar8 = new x(this.tracker);
        app.dogo.com.dogo_android.u.n.q.l.c coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ PottyRemindersItem onDayButtonToggle(l dayPosition, String newState) {
        return dayPosition.n(newState);
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ h2 buildReminder(l dogId) {
        return dogId.f;
    }

    public static final /* synthetic */ PottyRemindersItem j(l lVar) {
        return lVar.a;
    }

    public static final /* synthetic */ l1 k(l lVar) {
        return lVar.authService;
    }

    public static final /* synthetic */ p1 l(l lVar) {
        return lVar.e;
    }

    private final PottyRemindersItem n(String str) {
        int i = 0;
        PottyRemindersItem pottyRemindersItem2;
        String str2;
        final Object str4 = this;
        Object value = str4.reminderRepository.getValue();
        n.d(value);
        n.e(value, "fromHourLiveData.value!!");
        int intValue3 = value.intValue();
        Object value2 = str4.l.getValue();
        n.d(value2);
        n.e(value2, "fromMinuteLiveData.value!!");
        int intValue = value2.intValue();
        Object value3 = str4.m.getValue();
        n.d(value3);
        n.e(value3, "toHourLiveData.value!!");
        int intValue2 = value3.intValue();
        Object value4 = str4.n.getValue();
        n.d(value4);
        n.e(value4, "toMinuteLiveData.value!!");
        int intValue4 = value4.intValue();
        Object value5 = str4.o.getValue();
        n.d(value5);
        final String str10 = "intervalLiveData.value!!";
        n.e(value5, str10);
        if (str4.isTimeValid(intValue3, intValue, intValue2, intValue4)) {
            String str11 = "%02d:%02d";
            ReminderHelper.Companion.d(str4.tracker, str4.exceptionHandler.f());
            String r12 = str4.a == null ? "" : str2;
            int i2 = 2;
            Object[] arr2 = new Object[i2];
            int i3 = 0;
            int i4 = 1;
            String formatted2 = String.format(str11, Arrays.copyOf(str4.tracker, i2));
            String str5 = "java.lang.String.format(format, *args)";
            n.e(formatted2, str5);
            Object[] arr = new Object[i2];
            String formatted = String.format(str11, Arrays.copyOf(str4.tracker, i2));
            n.e(formatted, str5);
            boolean z = true;
            PottyRemindersItem pottyRemindersItem = new PottyRemindersItem((str4.a == null ? "" : str2), str, p.N0(str4.tracker), formatted2, formatted, Long.valueOf(value5.longValue(), "intervalLiveData.value!!"), true);
        } else {
            i = 0;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A(int i, boolean z) {
        this.tracker.set(i, Boolean.valueOf(z));
        this.userRepository.postValue(this.tracker);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: B, reason: from kotlin metadata */
    public final void atLeastOneDaySelected() {
        long l = this.exceptionHandler.g();
        z = this.h.getValue() instanceof LoadResult_Loading;
        if (!(this.h.getValue() instanceof oadResult_Loading)) {
            long l4 = l - this.g;
            long l2 = 500L;
            if (this.g > l2) {
                this.g = l;
                kotlinx.coroutines.o0 o0Var = null;
                int i = 2;
                Object obj = null;
                kotlinx.coroutines.internal.k.d(f0.a(this), Dispatchers.b().plus(this.utilities), o0Var, new app.dogo.com.dogo_android.specialprograms.potty.reminders.l.b(this, null), i, obj);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        this.activeDays.logEvent(E_PottyProgram.a.withParameters(u.a(new EP_Type(), "interval")));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m() {
        return this.tracker.contains(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<List<Boolean>> o() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<Boolean> p() {
        return p.L0(this.tracker);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<Integer> q() {
        return this.reminderRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<Integer> r() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> s() {
        return this.lastClickTime;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<Long> t() {
        Long[] arr = new Long[10];
        TimeUnit mINUTES2 = TimeUnit.MINUTES;
        int i12 = 0;
        arr[i12] = Long.valueOf(mINUTES2.toMillis(15L));
        long l = 30L;
        arr[1] = Long.valueOf(mINUTES2.toMillis(l));
        TimeUnit hOURS2 = TimeUnit.HOURS;
        int i13 = 2;
        arr[i13] = Long.valueOf(hOURS2.toMillis(1L));
        int i14 = 3;
        arr[i14] = Long.valueOf(hOURS2.toMillis(2L));
        int i15 = 4;
        arr[i15] = Long.valueOf(hOURS2.toMillis(3L));
        int i16 = 5;
        arr[i16] = Long.valueOf(hOURS2.toMillis(4L));
        int i17 = 6;
        arr[i17] = Long.valueOf(hOURS2.toMillis(5L));
        int i18 = 7;
        arr[i18] = Long.valueOf(hOURS2.toMillis(6L));
        int i19 = 8;
        arr[i19] = Long.valueOf(hOURS2.toMillis(7L));
        long l2 = 8L;
        arr[9] = Long.valueOf(hOURS2.toMillis(l2));
        return p.j(arr);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<Long> u() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<y<Boolean>> v() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> w() {
        return this.presetReminderData;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<Integer> x() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<Integer> y() {
        return this.n;
    }


    /* renamed from: z, reason: from kotlin metadata */
    private final boolean isTimeValid(int fromHours, int fromMinutes, int toHours, int toMinutes) {
        boolean z = false;
        int i = 0;
        int r0 = 1;
        return true;
    }
}
