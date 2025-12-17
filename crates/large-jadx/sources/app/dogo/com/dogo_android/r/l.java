package app.dogo.com.dogo_android.r;

import android.widget.CompoundButton;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.l;
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
import f.d.a.a;
import i.b.a0;
import i.b.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010*\u001a\u00020\u0012J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020)H\u0002J\u0016\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0012J\u0014\u00101\u001a\u00020,2\u000c\u00102\u001a\u0008\u0012\u0004\u0012\u0002030\u0011J\u0018\u00104\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0016H\u0002J\u0006\u00106\u001a\u00020,J\u0006\u00107\u001a\u00020,J\u0010\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u001f\u0010\u001b\u001a\u0010\u0012\u000c\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0017\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010#\u001a\u0010\u0012\u000c\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120&0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069", d2 = {"Lapp/dogo/com/dogo_android/reminder/TrainingReminderViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "dayList", "Landroidx/lifecycle/MutableLiveData;", "", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "firstDayOfTheWeek", "", "goToNext", "Lcom/hadilq/liveevent/LiveEvent;", "getGoToNext", "()Lcom/hadilq/liveevent/LiveEvent;", "hoursField", "", "kotlin.jvm.PlatformType", "getHoursField", "()Landroidx/lifecycle/MutableLiveData;", "isReady", "lastClickTime", "", "minutesField", "getMinutesField", "reminderSaveLoad", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getReminderSaveLoad", "trainingReminder", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "atLeastOneDaySelected", "createReminder", "", "reminderModel", "dayButton", "day", "state", "fillWeekArrayText", "buttons", "Landroid/widget/CompoundButton;", "getCorrectedDay", "localisedDay", "saveReminder", "saveReminderTimeMs", "updateReminder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends s {

    private final p2 a;
    private final h2 b;
    private final o3 c;
    private final v2 d;
    private final l1 e;
    private final h0 f;
    private long g;
    private final x<String> h;
    private final x<String> i;
    private final x<List<Boolean>> j;
    private final x<RemindersModel> k;
    private final x<Boolean> l;
    private int m;
    private final a<Boolean> n;
    private final x<y<Boolean>> o;
    private final CoroutineExceptionHandler p;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.r.l a;
        public c(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.r.l l2) {
            this.a = l2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.u().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.reminder.TrainingReminderViewModel$1", f = "TrainingReminderViewModel.kt", l = {}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.r.l this$0;
        a(app.dogo.com.dogo_android.r.l l, d<? super app.dogo.com.dogo_android.r.l.a> d2) {
            this.this$0 = l;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.a obj2 = new l.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int i3;
            String string;
            int strArr;
            int i10;
            int i12;
            int i4;
            int i8;
            int i;
            String[] strArr2;
            int i5;
            int booleanValue2;
            int i9;
            int i2;
            int i13;
            int booleanValue;
            int i6;
            int i11;
            int i7;
            Object obj11;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                if ((RemindersModel)l.j(this.this$0).m(l.h(this.this$0).v()).blockingGet().isEmpty()) {
                    obj11 = strArr;
                }
                i3 = 0;
                final int i17 = 1;
                if (obj11 != null) {
                    l.i(this.this$0).postValue(p.L0(obj11.getDays()));
                    l.l(this.this$0).postValue(obj11);
                    String time = obj11.getTime();
                    if (time == null) {
                    } else {
                        obj11 = l.E0(time, /* result */, false, 0, 6, 0);
                        if (obj11 == null) {
                        } else {
                            obj11 = obj11.toArray(new String[i3]);
                            Objects.requireNonNull(obj11, "null cannot be cast to non-null type kotlin.Array<T>");
                            strArr = obj11;
                        }
                    }
                    if (strArr == null) {
                        strArr = new String[i3];
                    }
                    Object obj = strArr[i3];
                    length2 -= i17;
                    booleanValue2 = i5;
                    i13 = 32;
                    while (i5 <= i) {
                        if (booleanValue2 == 0) {
                        } else {
                        }
                        i6 = i;
                        if (n.h(b.b(obj.charAt(i6)).charValue(), i13) <= 0) {
                        } else {
                        }
                        i11 = i3;
                        booleanValue = b.a(i11).booleanValue();
                        if (booleanValue2 != 0) {
                            break;
                        } else {
                        }
                        if (booleanValue == 0) {
                            break;
                        } else {
                        }
                        i--;
                        i13 = 32;
                        if (booleanValue == 0) {
                        } else {
                        }
                        i5++;
                        booleanValue2 = i17;
                        i11 = i17;
                        i6 = i5;
                    }
                    this.this$0.s().postValue(obj.subSequence(i5, i += i17).toString());
                    i10 = strArr[i17];
                    length -= i17;
                    strArr2 = i8;
                    while (i8 <= i4) {
                        if (strArr2 == 0) {
                        } else {
                        }
                        i9 = i4;
                        if (n.h(b.b(i10.charAt(i9)).charValue(), i13) <= 0) {
                        } else {
                        }
                        i2 = i3;
                        booleanValue2 = b.a(i2).booleanValue();
                        if (strArr2 != 0) {
                            break;
                        } else {
                        }
                        if (booleanValue2 == 0) {
                            break;
                        } else {
                        }
                        i4--;
                        if (booleanValue2 == 0) {
                        } else {
                        }
                        i8++;
                        strArr2 = i17;
                        i2 = i17;
                        i9 = i8;
                    }
                    this.this$0.t().postValue(i10.subSequence(i8, i4 += i17).toString());
                } else {
                    obj11 = new ArrayList();
                    obj11.add(b.a(i17));
                    while (i3 += i17 > 6) {
                        obj11.add(b.a(i17));
                    }
                    Calendar instance = Calendar.getInstance();
                    l.i(this.this$0).postValue(p.L0(obj11));
                    i12 = 2;
                    i8 = 48;
                    this.this$0.s().postValue(l.o0(String.valueOf(instance.get(11)), i12, i8));
                    this.this$0.t().postValue(l.o0(String.valueOf(instance.get(12)), i12, i8));
                }
                this.this$0.v().postValue(b.a(i17));
                return w.a;
            }
            obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj11;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.reminder.TrainingReminderViewModel$createReminder$1", f = "TrainingReminderViewModel.kt", l = {}, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        final RemindersModel $reminderModel;
        int label;
        final app.dogo.com.dogo_android.r.l this$0;
        b(app.dogo.com.dogo_android.r.l l, RemindersModel remindersModel2, d<? super app.dogo.com.dogo_android.r.l.b> d3) {
            this.this$0 = l;
            this.$reminderModel = remindersModel2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.b obj3 = new l.b(this.this$0, this.$reminderModel, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                this.this$0.u().postValue(y.b.a);
                l.j(this.this$0).I(l.h(this.this$0).v(), this.$reminderModel).e();
                l.k(this.this$0).o(this.$reminderModel);
                int i = 1;
                y.c cVar = new y.c(b.a(i));
                this.this$0.u().postValue(cVar);
                this.this$0.r().postValue(b.a(i));
                return w.a;
            }
            IllegalStateException obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.reminder.TrainingReminderViewModel$updateReminder$1", f = "TrainingReminderViewModel.kt", l = {}, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super w>, Object> {

        final RemindersModel $reminderModel;
        int label;
        final app.dogo.com.dogo_android.r.l this$0;
        d(app.dogo.com.dogo_android.r.l l, RemindersModel remindersModel2, d<? super app.dogo.com.dogo_android.r.l.d> d3) {
            this.this$0 = l;
            this.$reminderModel = remindersModel2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (l.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            l.d obj3 = new l.d(this.this$0, this.$reminderModel, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                this.this$0.u().postValue(y.b.a);
                l.j(this.this$0).W(l.h(this.this$0).v(), this.$reminderModel).e();
                int i = 1;
                y.c cVar = new y.c(b.a(i));
                this.this$0.u().postValue(cVar);
                this.this$0.r().postValue(b.a(i));
                return w.a;
            }
            IllegalStateException obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
    }
    public l(p2 p2, h2 h22, o3 o33, v2 v24, l1 l15, h0 h06) {
        n.f(p2, "preferenceService");
        n.f(h22, "authService");
        n.f(o33, "tracker");
        n.f(v24, "utilities");
        n.f(l15, "reminderRepository");
        n.f(h06, "dispatcher");
        super();
        this.a = p2;
        this.b = h22;
        this.c = o33;
        this.d = v24;
        this.e = l15;
        this.f = h06;
        String obj8 = "";
        x obj7 = new x(obj8);
        this.h = obj7;
        obj7 = new x(obj8);
        this.i = obj7;
        obj7 = new x(p.g());
        this.j = obj7;
        obj7 = new x();
        this.k = obj7;
        obj7 = new x(Boolean.FALSE);
        this.l = obj7;
        obj7 = new a();
        this.n = obj7;
        obj7 = new x();
        this.o = obj7;
        l.a aVar = new l.a(this, 0);
        k.d(f0.a(this), h06, 0, aVar, 2, 0);
        obj8 = new l.c(CoroutineExceptionHandler.r, this);
        this.p = obj8;
    }

    public l(p2 p2, h2 h22, o3 o33, v2 v24, l1 l15, h0 h06, int i7, g g8) {
        h0 obj13;
        if (i7 &= 32 != 0) {
            obj13 = c1.b();
        }
        super(p2, h22, o33, v24, l15, obj13);
    }

    public static final h2 h(app.dogo.com.dogo_android.r.l l) {
        return l.b;
    }

    public static final x i(app.dogo.com.dogo_android.r.l l) {
        return l.j;
    }

    public static final l1 j(app.dogo.com.dogo_android.r.l l) {
        return l.e;
    }

    public static final o3 k(app.dogo.com.dogo_android.r.l l) {
        return l.c;
    }

    public static final x l(app.dogo.com.dogo_android.r.l l) {
        return l.k;
    }

    private final void n(RemindersModel remindersModel) {
        long l;
        CoroutineExceptionHandler exc;
        boolean cmp;
        m0 m0Var;
        int plus;
        int i2;
        app.dogo.com.dogo_android.r.l.b bVar;
        int i3;
        int i;
        l = this.d.g();
        if (!value instanceof y.b && Long.compare(i4, plus) > 0) {
            if (Long.compare(i4, plus) > 0) {
                this.g = l;
                bVar = new l.b(this, remindersModel, 0);
                k.d(f0.a(this), this.f.plus(this.p), 0, bVar, 2, 0);
            }
        }
    }

    private final int q(int i, int i2) {
        return obj2 %= 7;
    }

    private final void y(RemindersModel remindersModel) {
        long l;
        CoroutineExceptionHandler exc;
        boolean cmp;
        m0 m0Var;
        int plus;
        int i2;
        app.dogo.com.dogo_android.r.l.d dVar;
        int i3;
        int i;
        l = this.d.g();
        if (!value instanceof y.b && Long.compare(i4, plus) > 0) {
            if (Long.compare(i4, plus) > 0) {
                this.g = l;
                dVar = new l.d(this, remindersModel, 0);
                k.d(f0.a(this), this.f.plus(this.p), 0, dVar, 2, 0);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean m() {
        Object contains;
        int i;
        Boolean tRUE;
        contains = this.j.getValue();
        i = 0;
        final int i2 = 1;
        if ((List)contains == null) {
        } else {
            if ((List)contains.contains(Boolean.TRUE) == i2) {
                i = i2;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o(int i, boolean z2) {
        Object value = this.j.getValue();
        n.d(value);
        n.e(value, "dayList.value!!");
        List list = p.N0((Collection)value);
        list.set(q(i, this.m), Boolean.valueOf(z2));
        this.j.postValue(list);
    }

    public final void p(List<? extends CompoundButton> list) {
        int i;
        int i2;
        boolean booleanValue;
        Object obj;
        n.f(list, "buttons");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E", n2.b(this.a.W()));
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        Object value = this.j.getValue();
        n.d(value);
        n.e(value, "dayList.value!!");
        this.m = instance.getFirstDayOfWeek();
        i = 0;
        i2 = i + 1;
        int i11 = 7;
        instance.set(i11, i7++);
        (CompoundButton)list.get(i).setText(simpleDateFormat.format(instance.getTime()));
        (CompoundButton)list.get(i).refreshDrawableState();
        (CompoundButton)list.get(i).setChecked((Boolean)p.N0((Collection)value).get(q(this.m, i2)).booleanValue());
        while (i2 > 6) {
            i = i2;
            i2 = i + 1;
            i11 = 7;
            instance.set(i11, i7++);
            (CompoundButton)list.get(i).setText(simpleDateFormat.format(instance.getTime()));
            (CompoundButton)list.get(i).refreshDrawableState();
            (CompoundButton)list.get(i).setChecked((Boolean)list2.get(q(this.m, i2)).booleanValue());
        }
    }

    public final a<Boolean> r() {
        return this.n;
    }

    public final x<String> s() {
        return this.h;
    }

    public final x<String> t() {
        return this.i;
    }

    public final x<y<Boolean>> u() {
        return this.o;
    }

    public final x<Boolean> v() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        Object remindersModel;
        String intValue;
        int arrayList;
        int intValue2;
        Object value;
        Object value2;
        int intValue3;
        int intValue4;
        Object value3;
        int i;
        int i3;
        int i6;
        int i10;
        int i4;
        int i9;
        int i11;
        int i7;
        int i8;
        int i2;
        int i5;
        remindersModel = this.k.getValue();
        arrayList = 0;
        intValue3 = 0;
        if ((RemindersModel)remindersModel != null) {
            Object value5 = this.j.getValue();
            if ((List)value5 == null) {
            } else {
                arrayList = p.N0((List)value5);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            (RemindersModel)remindersModel.setDays(arrayList);
            value2 = this.h.getValue();
            if ((String)value2 == null) {
                intValue = intValue3;
            } else {
            }
            intValue4 = this.i.getValue();
            if ((String)intValue4 == null) {
            } else {
                intValue4 = j1.x0((String)intValue4);
                if (intValue4 == null) {
                } else {
                    intValue3 = intValue4.intValue();
                }
            }
            remindersModel.setTimeWithInt(intValue, intValue3);
            y(remindersModel);
        } else {
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, 0);
            Object value4 = this.j.getValue();
            if ((List)value4 == null) {
            } else {
                arrayList = p.N0((List)value4);
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            remindersModel.setDays(arrayList);
            value = s().getValue();
            if ((String)value == null) {
                intValue2 = intValue3;
            } else {
            }
            value3 = t().getValue();
            if ((String)value3 == null) {
                intValue4 = intValue3;
            } else {
            }
            remindersModel.setTimeWithInt(intValue2, intValue4);
            remindersModel.setName("Training Reminder");
            remindersModel.setType(m.Training.getTag());
            remindersModel.setRepeating(l.Weekly.getTag());
            remindersModel.setActive(true);
            remindersModel.addUsers(this.b.v(), intValue3);
            remindersModel.setId(UUID.randomUUID().toString());
            n(remindersModel);
        }
        this.c.t(remindersModel);
        this.c.c(k0.e);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.a.e1(this.d.g());
    }
}
