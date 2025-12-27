package app.dogo.com.dogo_android.r;

import android.widget.CompoundButton;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.m;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.k0;
import app.dogo.com.dogo_android.w.o3;
import i.b.a0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: TrainingReminderViewModel.kt */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010*\u001a\u00020\u0012J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020)H\u0002J\u0016\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0012J\u0014\u00101\u001a\u00020,2\u000c\u00102\u001a\u0008\u0012\u0004\u0012\u0002030\u0011J\u0018\u00104\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0016H\u0002J\u0006\u00106\u001a\u00020,J\u0006\u00107\u001a\u00020,J\u0010\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u001f\u0010\u001b\u001a\u0010\u0012\u000c\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0017\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010#\u001a\u0010\u0012\u000c\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120&0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069", d2 = {"Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "dayList", "Landroidx/lifecycle/MutableLiveData;", "", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "firstDayOfTheWeek", "", "goToNext", "Lcom/hadilq/liveevent/LiveEvent;", "getGoToNext", "()Lcom/hadilq/liveevent/LiveEvent;", "hoursField", "", "kotlin.jvm.PlatformType", "getHoursField", "()Landroidx/lifecycle/MutableLiveData;", "isReady", "lastClickTime", "", "minutesField", "getMinutesField", "reminderSaveLoad", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getReminderSaveLoad", "trainingReminder", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "atLeastOneDaySelected", "createReminder", "", "reminderModel", "dayButton", "day", "state", "fillWeekArrayText", "buttons", "Landroid/widget/CompoundButton;", "getCorrectedDay", "localisedDay", "saveReminder", "saveReminderTimeMs", "updateReminder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class TrainingReminderViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final p2 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final h2 dayList;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 dispatcher;
    /* renamed from: d, reason: from kotlin metadata */
    private final v2 exceptionHandler;
    /* renamed from: e, reason: from kotlin metadata */
    private final l1 firstDayOfTheWeek;
    private final h0 f;
    private long g;
    private final x<String> h;
    /* renamed from: i, reason: from kotlin metadata */
    private final x<String> lastClickTime;
    private final x<List<Boolean>> j;
    /* renamed from: k, reason: from kotlin metadata */
    private final x<RemindersModel> preferenceService;
    /* renamed from: l, reason: from kotlin metadata */
    private final x<Boolean> reminderRepository;
    private int m;
    /* renamed from: n, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> tracker;
    /* renamed from: o, reason: from kotlin metadata */
    private final x<y<Boolean>> trainingReminder;
    /* renamed from: p, reason: from kotlin metadata */
    private final CoroutineExceptionHandler utilities;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ l a;
        public c(CoroutineExceptionHandler.a exc, l lVar) {
            this.a = lVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.u().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.reminder.TrainingReminderViewModel$1", f = "TrainingReminderViewModel.kt", l = {}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int i = 0;
            Object[] object3 = null;
            boolean z2;
            int i5 = 0;
            int i6 = 6;
            boolean z3;
            Object obj = null;
            Object blockingGet;
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                int i2 = 0;
                if ((RemindersModel)l.this.firstDayOfTheWeek.m(l.this.dayList.v()).blockingGet().isEmpty()) {
                }
                i = 0;
                i = 1;
                if (l.this.firstDayOfTheWeek != null) {
                    l.this.j.postValue(p.L0(blockingGet.getDays()));
                    l.this.preferenceService.postValue(blockingGet);
                    String time2 = blockingGet.getTime();
                    if (time2 != null) {
                        boolean z = false;
                        i5 = 0;
                        i6 = 6;
                        obj = null;
                        List list3 = l.E0(time2, new String[] { ":" }, z, i5, i6, obj);
                        if (list3 != null) {
                            object3 = list3.toArray(new String[i]);
                            Objects.requireNonNull(object3, "null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    if ("null cannot be cast to non-null type kotlin.Array<T>" == null) {
                        String[] strArr3 = new String[i];
                    }
                    Object obj3 = object3[i];
                    i = obj3.length() - i;
                    i5 = 32;
                    while (i <= i) {
                        int r8 = i;
                        r8 = i;
                        boolean booleanValue2 = i.booleanValue();
                        if (i != 0) {
                            break;
                        }
                    }
                    l.this.s().postValue(obj3.subSequence(i, i + i).toString());
                    Object obj2 = object3[i];
                    i = obj2.length() - i;
                    while (i <= l.this.j) {
                        int r6 = i;
                        r6 = i;
                        boolean booleanValue = i.booleanValue();
                        if (i != 0) {
                            break;
                        }
                    }
                    i4 = i + i;
                    l.this.t().postValue(obj2.subSequence(i, i4).toString());
                } else {
                    ArrayList arrayList = new ArrayList();
                    i = i + i;
                    arrayList.add(b.a(true));
                    i2 = 6;
                    while (i + i > 6) {
                        i = i + i;
                        arrayList.add(b.a(i));
                        i2 = 6;
                    }
                    Calendar time = Calendar.getInstance();
                    l.this.j.postValue(p.L0(arrayList));
                    int i4 = 2;
                    char c = '0';
                    l.this.s().postValue(l.o0(String.valueOf(time.get(11)), i4, c));
                    int i3 = 12;
                    l.this.t().postValue(l.o0(String.valueOf(time.get(i3)), i4, c));
                }
                l.this.v().postValue(b.a(true));
                return w.a;
            }
        }

        a(d<? super l.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.reminder.l.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.reminder.l.a(l.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.reminder.TrainingReminderViewModel$createReminder$1", f = "TrainingReminderViewModel.kt", l = {}, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ RemindersModel $reminderModel;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                l.this.u().postValue(LoadResult_Loading.a);
                l.this.firstDayOfTheWeek.I(l.this.dayList.v(), this.$reminderModel).e();
                l.this.dispatcher.onConversionDataFail(this.$reminderModel);
                boolean z = true;
                l.this.u().postValue(new LoadResult_Success(b.a(z)));
                l.this.r().postValue(b.a(z));
                return w.a;
            }
        }

        b(RemindersModel remindersModel, d<? super l.b> dVar) {
            this.$reminderModel = remindersModel;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.reminder.l.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.reminder.l.b(l.this, this.$reminderModel, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.reminder.TrainingReminderViewModel$updateReminder$1", f = "TrainingReminderViewModel.kt", l = {}, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ RemindersModel $reminderModel;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                l.this.u().postValue(LoadResult_Loading.a);
                l.this.firstDayOfTheWeek.W(l.this.dayList.v(), this.$reminderModel).e();
                boolean z = true;
                l.this.u().postValue(new LoadResult_Success(b.a(z)));
                l.this.r().postValue(b.a(z));
                return w.a;
            }
        }

        d(RemindersModel remindersModel, d<? super l.d> dVar) {
            this.$reminderModel = remindersModel;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.reminder.l.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.reminder.l.d(l.this, this.$reminderModel, dVar);
        }
    }
    public /* synthetic */ l(p2 p2Var, h2 h2Var, o3 o3Var, v2 v2Var, l1 l1Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var62;
        if (i & 32 != 0) {
            h0Var62 = Dispatchers.b();
        }
        this(p2Var, h2Var, o3Var, v2Var, l1Var, h0Var62);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ h2 createReminder(l reminderModel) {
        return reminderModel.dayList;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ x fillWeekArrayText(l buttons) {
        return buttons.j;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ l1 updateReminder(l reminderModel) {
        return reminderModel.firstDayOfTheWeek;
    }

    public static final /* synthetic */ o3 k(l lVar) {
        return lVar.dispatcher;
    }

    public static final /* synthetic */ x l(l lVar) {
        return lVar.preferenceService;
    }

    private final void n(RemindersModel remindersModel) {
        long l = this.exceptionHandler.g();
        z = this.trainingReminder.getValue() instanceof LoadResult_Loading;
        if (!(this.trainingReminder.getValue() instanceof oadResult_Loading)) {
            long l4 = l - this.g;
            long l2 = 500L;
            if (this.g > l2) {
                this.g = l;
                kotlinx.coroutines.o0 o0Var = null;
                int i = 2;
                Object obj = null;
                kotlinx.coroutines.internal.k.d(f0.a(this), this.f.plus(this.utilities), o0Var, new app.dogo.com.dogo_android.reminder.l.b(this, remindersModel, null), i, obj);
            }
        }
    }

    /* renamed from: q, reason: from kotlin metadata */
    private final int dayButton(int day, int state) {
        return (state + day) + 4 % 7;
    }

    private final void y(RemindersModel remindersModel) {
        long l = this.exceptionHandler.g();
        z = this.trainingReminder.getValue() instanceof LoadResult_Loading;
        if (!(this.trainingReminder.getValue() instanceof oadResult_Loading)) {
            long l4 = l - this.g;
            long l2 = 500L;
            if (this.g > l2) {
                this.g = l;
                kotlinx.coroutines.o0 o0Var = null;
                int i = 2;
                Object obj = null;
                kotlinx.coroutines.internal.k.d(f0.a(this), this.f.plus(this.utilities), o0Var, new app.dogo.com.dogo_android.reminder.l.d(this, remindersModel, null), i, obj);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: m, reason: from kotlin metadata */
    public final boolean atLeastOneDaySelected() {
        boolean z = false;
        Object value = this.j.getValue();
        int i2 = 0;
        final int i = 1;
        if (value != null) {
            if (value.contains(Boolean.TRUE)) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: o, reason: from kotlin metadata */
    public final void getCorrectedDay(int firstDayOfTheWeek, boolean localisedDay) {
        Object value = this.j.getValue();
        n.d(value);
        n.e(value, "dayList.value!!");
        List list = p.N0(value);
        list.set(dayButton(firstDayOfTheWeek, this.m), Boolean.valueOf(localisedDay));
        this.j.postValue(list);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p(List<? extends CompoundButton> list) {
        int i = 0;
        n.f(list, "buttons");
        Calendar time = Calendar.getInstance(Locale.getDefault());
        Object value = this.j.getValue();
        n.d(value);
        n.e(value, "dayList.value!!");
        this.m = time.getFirstDayOfWeek();
        i = 0;
        i = i + 1;
        int i9 = 7;
        time.set(i9, (this.m + i) - 1 % i9 + 1);
        (CompoundButton)list.get(i).setText(new SimpleDateFormat("E", LocaleService.b(this.authService.W())).format(time.getTime()));
        (CompoundButton)list.get(i).refreshDrawableState();
        (CompoundButton)list.get(i).setChecked((Boolean)p.N0(value).get(dayButton(this.m, i)).booleanValue());
        while (i > 6) {
            i = i + 1;
            i9 = 7;
            time.set(i9, this.m + i - 1 % i9 + 1);
            (CompoundButton)list.get("dayList.value!!").setText(simpleDateFormat.format(this.authService.getTime()));
            (CompoundButton)list.get("dayList.value!!").refreshDrawableState();
            (CompoundButton)list.get("dayList.value!!").setChecked(this.j.get(this.dayButton(this.m, i)).booleanValue());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> r() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> s() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> t() {
        return this.lastClickTime;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> u() {
        return this.trainingReminder;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> v() {
        return this.reminderRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        RemindersModel remindersModel;
        int i = 0;
        ArrayList arrayList;
        int value2;
        List list = null;
        Object value5;
        Object value6 = this.preferenceService.getValue();
        i = 0;
        value2 = 0;
        if (value6 != null) {
            Object value8 = this.j.getValue();
            if (value8 != null) {
                list = p.N0(value8);
            }
            if (list == null) {
                ArrayList arrayList2 = new ArrayList();
            }
            value6.setDays(list);
            Object value3 = this.h.getValue();
            int r1 = value2;
            value5 = this.lastClickTime.getValue();
            if (value5 != null) {
                Integer num4 = app.dogo.com.dogo_android.util.extensionfunction.j1.x0(value5);
                if (num4 != null) {
                    value2 = num4.intValue();
                }
            }
            value6.setTimeWithInt(value2, value2);
            y(value6);
        } else {
            List list2 = null;
            java.util.Map map = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            boolean z = false;
            java.util.Map map2 = null;
            int i2 = 511;
            kotlin.d0.d.g gVar = null;
            remindersModel = new RemindersModel(list2, map, str, str2, str3, str4, str5, z, map2, i2, gVar);
            Object value7 = this.j.getValue();
            if (value7 != null) {
                List list3 = p.N0(value7);
            }
            if (this.h == 0) {
                arrayList = new ArrayList();
            }
            remindersModel.setDays(arrayList);
            Object value = s().getValue();
            r1 = value2;
            Object value4 = this.t().getValue();
            int r3 = value2;
            remindersModel.setTimeWithInt(value2, value2);
            remindersModel.setName("Training Reminder");
            remindersModel.setType(NotificationType.Training.getTag());
            remindersModel.setRepeating(NotificationRepeating.Weekly.getTag());
            remindersModel.setActive(true);
            remindersModel.addUsers(this.dayList.v(), value2);
            remindersModel.setId(UUID.randomUUID().toString());
            n(remindersModel);
        }
        this.dispatcher.setUserId(remindersModel);
        this.dispatcher.logEvent(E_Reminders.e);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.authService.e1(this.exceptionHandler.g());
    }

    public l(p2 p2Var, h2 h2Var, o3 o3Var, v2 v2Var, l1 l1Var, h0 h0Var) {
        n.f(p2Var, "preferenceService");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(v2Var, "utilities");
        n.f(l1Var, "reminderRepository");
        n.f(h0Var, "dispatcher");
        super();
        this.authService = p2Var;
        this.dayList = h2Var;
        this.dispatcher = o3Var;
        this.exceptionHandler = v2Var;
        this.firstDayOfTheWeek = l1Var;
        this.f = h0Var;
        String str7 = "";
        this.h = new x(str7);
        this.lastClickTime = new x(str7);
        this.j = new x(p.g());
        this.preferenceService = new x();
        this.reminderRepository = new x(Boolean.FALSE);
        this.tracker = new a();
        this.trainingReminder = new x();
        kotlinx.coroutines.internal.k.d(f0.a(this), h0Var, null, new app.dogo.com.dogo_android.reminder.l.a(this, null), 2, null);
        this.utilities = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }
}
