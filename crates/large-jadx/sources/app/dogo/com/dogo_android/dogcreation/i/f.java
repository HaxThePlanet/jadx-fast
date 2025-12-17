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
import f.d.a.a;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0003J\u001d\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0008\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010.R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR \u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u0013\"\u0004\u0008\u001f\u0010\u0015R\u001d\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001a0!0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010\u0013\"\u0004\u0008%\u0010\u0015¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/birthday/DogCreationBirthdayViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogBirthDay", "", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Ljava/lang/Long;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "cal", "Ljava/util/Calendar;", "dayField", "Landroidx/lifecycle/MutableLiveData;", "", "getDayField", "()Landroidx/lifecycle/MutableLiveData;", "setDayField", "(Landroidx/lifecycle/MutableLiveData;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "monthField", "getMonthField", "setMonthField", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "yearField", "getYearField", "setYearField", "getCurrentlySelectedTimeInMillis", "isBirthdaySet", "isBirthdayValid", "birthDayTimeMs", "saveBirthday", "", "dogId", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends s {

    private final v2 a;
    private final g2 b;
    private final j2 c;
    private final o3 d;
    private final x<y<Boolean>> e;
    private final a<Boolean> f;
    private x<Integer> g;
    private x<Integer> h;
    private x<Integer> i;
    private final Calendar j;
    private final CoroutineExceptionHandler k;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.dogcreation.i.f a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.dogcreation.i.f f2) {
            this.a = f2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.o().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.birthday.DogCreationBirthdayViewModel$saveBirthday$1", f = "DogCreationBirthdayViewModel.kt", l = 51, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final Long $birthDayTimeMs;
        final String $dogId;
        int label;
        final app.dogo.com.dogo_android.dogcreation.i.f this$0;
        a(app.dogo.com.dogo_android.dogcreation.i.f f, Long long2, String string3, d<? super app.dogo.com.dogo_android.dogcreation.i.f.a> d4) {
            this.this$0 = f;
            this.$birthDayTimeMs = long2;
            this.$dogId = string3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (f.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            f.a obj4 = new f.a(this.this$0, this.$birthDayTimeMs, this.$dogId, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            Boolean unknownHostException;
            g2 g2Var;
            String longValue;
            String $dogId;
            int i;
            int i3;
            Object obj;
            int i2;
            int i4;
            a obj11;
            aVar = b.d();
            unknownHostException = this.label;
            final int i5 = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i5) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c(b.a(i5));
                    this.this$0.o().postValue(cVar);
                    this.this$0.m().postValue(b.a(i5));
                    return w.a;
                }
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
            }
            q.b(object);
            if (!obj11 instanceof y.b) {
                this.this$0.o().postValue(y.b.a);
                if (!f.h(this.this$0).a()) {
                    f.j(this.this$0).s("dog_creation_birthday");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.o().postValue(aVar);
                } else {
                    obj11 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    if (this.$birthDayTimeMs != null) {
                        unknownHostException = new Date(this.$birthDayTimeMs.longValue(), obj4);
                        obj11 = obj11.format(unknownHostException);
                    } else {
                        obj11 = 0;
                    }
                    this.label = i5;
                    if (g2.f(f.i(this.this$0), this.$dogId, obj11, 0, this, 4, 0) == aVar) {
                        return aVar;
                    }
                }
            }
        }
    }
    public f(Long long, v2 v22, g2 g23, j2 j24, o3 o35) {
        String str;
        int obj3;
        Object obj5;
        app.dogo.com.dogo_android.dogcreation.i.f.b obj6;
        n.f(v22, "utilities");
        n.f(g23, "dogUpdateInteractor");
        n.f(j24, "connectivityService");
        n.f(o35, "tracker");
        super();
        this.a = v22;
        this.b = g23;
        this.c = j24;
        this.d = o35;
        obj5 = new x();
        this.e = obj5;
        obj5 = new a();
        this.f = obj5;
        obj5 = new x();
        this.g = obj5;
        obj5 = new x();
        this.h = obj5;
        obj5 = new x();
        this.i = obj5;
        Calendar obj4 = v22.f();
        this.j = obj4;
        obj6 = new f.b(CoroutineExceptionHandler.r, this);
        this.k = obj6;
        if (long != 0) {
            obj5 = new Date(obj6 *= str, o35);
            obj4.setTime(obj5);
        }
        this.i.setValue(Integer.valueOf(obj4.get(1)));
        this.h.setValue(Integer.valueOf(obj4.get(2)));
        this.g.setValue(Integer.valueOf(obj4.get(5)));
    }

    public static final j2 h(app.dogo.com.dogo_android.dogcreation.i.f f) {
        return f.c;
    }

    public static final g2 i(app.dogo.com.dogo_android.dogcreation.i.f f) {
        return f.b;
    }

    public static final o3 j(app.dogo.com.dogo_android.dogcreation.i.f f) {
        return f.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long k() {
        Object value2;
        Object valueOf;
        Object value;
        valueOf = 0;
        if ((Integer)this.i.getValue() == null) {
            value2 = valueOf;
        }
        if ((Integer)this.h.getValue() == null) {
            value = valueOf;
        }
        Object value3 = this.g.getValue();
        if ((Integer)value3 == null) {
        } else {
            valueOf = value3;
        }
        this.j.set(value2.intValue(), value.intValue(), valueOf.intValue());
        return this.j.getTime().getTime();
    }

    public final x<Integer> l() {
        return this.g;
    }

    public final a<Boolean> m() {
        return this.f;
    }

    public final x<Integer> n() {
        return this.h;
    }

    public final x<y<Boolean>> o() {
        return this.e;
    }

    public final x<Integer> p() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        Calendar instance;
        int i;
        int intValue;
        int intValue2;
        instance = Calendar.getInstance();
        intValue2 = this.i.getValue();
        if ((Integer)intValue2 == null) {
        } else {
            if (instance.get(1) == (Integer)intValue2.intValue()) {
                intValue2 = this.h.getValue();
                if ((Integer)intValue2 == null) {
                } else {
                    if (instance.get(2) == (Integer)intValue2.intValue()) {
                        intValue = this.g.getValue();
                        if ((Integer)intValue == null) {
                        } else {
                            if (instance.get(5) != (Integer)intValue.intValue()) {
                            } else {
                                i = 0;
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r(long l) {
        int obj3;
        obj3 = Long.compare(l2, l) > 0 ? 1 : 0;
        return obj3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(String string, Long long2) {
        n.f(string, "dogId");
        f.a aVar = new f.a(this, long2, string, 0);
        k.d(f0.a(this), this.k, 0, aVar, 2, 0);
    }
}
