package app.dogo.com.dogo_android.dogcreation.i;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: DogCreationBirthdayViewModel.kt */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0003J\u001d\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0008\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010.R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR \u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0013\"\u0004\u0008\u001f\u0010\u0015R\u001d\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0!0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010\u0013\"\u0004\u0008%\u0010\u0015¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/birthday/DogCreationBirthdayViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogBirthDay", "", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Ljava/lang/Long;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "cal", "Ljava/util/Calendar;", "dayField", "Landroidx/lifecycle/MutableLiveData;", "", "getDayField", "()Landroidx/lifecycle/MutableLiveData;", "setDayField", "(Landroidx/lifecycle/MutableLiveData;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "monthField", "getMonthField", "setMonthField", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "yearField", "getYearField", "setYearField", "getCurrentlySelectedTimeInMillis", "isBirthdaySet", "isBirthdayValid", "birthDayTimeMs", "saveBirthday", "", "dogId", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class DogCreationBirthdayViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final v2 connectivityService;
    private final g2 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final j2 dogUpdateInteractor;
    /* renamed from: d, reason: from kotlin metadata */
    private final o3 exceptionHandler;
    private final x<y<Boolean>> e = new x<>();
    private final f.d.a.a<Boolean> f = new a<>();
    private x<Integer> g = new x<>();
    /* renamed from: h, reason: from kotlin metadata */
    private x<Integer> tracker = new x<>();
    /* renamed from: i, reason: from kotlin metadata */
    private x<Integer> utilities = new x<>();
    private final Calendar j;
    private final CoroutineExceptionHandler k = new f$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ f a;
        public b(CoroutineExceptionHandler.a exc, f fVar) {
            this.a = fVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.o().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.birthday.DogCreationBirthdayViewModel$saveBirthday$1", f = "DogCreationBirthdayViewModel.kt", l = 51, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        final /* synthetic */ Long $birthDayTimeMs;
        final /* synthetic */ String $dogId;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Long $birthDayTimeMs2;
            g2 g2Var;
            String $dogId2;
            String object2;
            Boolean bool3 = null;
            d dVar;
            int i = 4;
            Object obj = null;
            int i2 = 0;
            Object obj3 = b.d();
            final int i3 = 1;
            if (this.label != 0) {
                if (this.label != i3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    f.this.o().postValue(new LoadResult_Success(b.a(true)));
                    f.this.m().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            if (!(f.this.o().getValue() instanceof LoadResult_Loading)) {
                f.this.o().postValue(LoadResult_Loading.a);
                if (f.this.dogUpdateInteractor.getActiveNetworkType()) {
                    str = "yyyy-MM-dd";
                    if (this.$birthDayTimeMs != null) {
                        String format = new SimpleDateFormat(str, Locale.getDefault()).format(new Date(this.$birthDayTimeMs.longValue(), r4));
                    } else {
                        i2 = 0;
                    }
                    bool3 = null;
                    i = 4;
                    obj = null;
                    this.label = i3;
                    if (DogUpdateInteractor.f(f.this.b, this.$dogId, i2, bool3, this, i, obj) == obj3) {
                        return obj3;
                    }
                } else {
                    f.this.exceptionHandler.setTrainingReminderUserProperties("dog_creation_birthday");
                    f.this.o().postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
        }

        a(Long long, String str, d<? super f.a> dVar) {
            this.$birthDayTimeMs = long;
            this.$dogId = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.f.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.f.a(f.this, this.$birthDayTimeMs, this.$dogId, dVar);
        }
    }
    public f(Long long, v2 v2Var, g2 g2Var, j2 j2Var, o3 o3Var) {
        n.f(v2Var, "utilities");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(j2Var, "connectivityService");
        str = "tracker";
        n.f(o3Var, str);
        super();
        this.connectivityService = v2Var;
        this.b = g2Var;
        this.dogUpdateInteractor = j2Var;
        this.exceptionHandler = o3Var;
        x xVar2 = new x();
        f.d.a.a aVar2 = new a();
        x xVar3 = new x();
        x xVar4 = new x();
        x xVar5 = new x();
        Calendar calendar = v2Var.f();
        this.j = calendar;
        app.dogo.com.dogo_android.dogcreation.i.f.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
        if (long != null) {
            int i = 1000;
            calendar.setTime(new Date(long.longValue() * (long)i, o3Var));
        }
        this.utilities.setValue(Integer.valueOf(calendar.get(1)));
        this.tracker.setValue(Integer.valueOf(calendar.get(2)));
        this.g.setValue(Integer.valueOf(calendar.get(5)));
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 isBirthdayValid(f birthDayTimeMs) {
        return birthDayTimeMs.dogUpdateInteractor;
    }

    public static final /* synthetic */ g2 i(f fVar) {
        return fVar.b;
    }

    public static final /* synthetic */ o3 j(f fVar) {
        return fVar.exceptionHandler;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final long getCurrentlySelectedTimeInMillis() {
        Object value;
        Object value2;
        Object value3;
        Integer num = 0;
        if ((Integer)this.utilities.getValue() == null) {
        }
        if ((Integer)this.tracker.getValue() == null) {
        }
        value2 = this.g.getValue();
        if (value2 != null) {
        }
        this.j.set(value.intValue(), value3.intValue(), value2.intValue());
        return this.j.getTime().getTime();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> l() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> m() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> n() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> o() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> p() {
        return this.utilities;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        boolean z = true;
        Calendar time = Calendar.getInstance();
        Object value4 = this.utilities.getValue();
        if (value4 != null) {
            if (time.get(1) == value4.intValue()) {
                Object value5 = this.tracker.getValue();
                if (value5 != null) {
                    if (time.get(2) == value5.intValue()) {
                        Object value3 = this.g.getValue();
                        if (value3 != null) {
                            if (time.get(5) == value3.intValue()) {
                                int i3 = 0;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r(long j) {
        boolean z = true;
        long l = this.connectivityService.g();
        j = l > j ? 1 : 0;
        return (l > j ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: s, reason: from kotlin metadata */
    public final void saveBirthday(String dogId, Long birthDayTimeMs) {
        n.f(dogId, "dogId");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.k, null, new kotlinx.coroutines.f.a(this, birthDayTimeMs, dogId, null), 2, null);
    }
}
