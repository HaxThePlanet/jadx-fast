package app.dogo.com.dogo_android.q.p;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.service.h2;
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
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020.2\u0006\u0010+\u001a\u00020)R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR \u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0015\"\u0004\u0008!\u0010\u0017R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0#0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010\u0015\"\u0004\u0008'\u0010\u0017¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBirthdayViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "cal", "Ljava/util/Calendar;", "dayField", "Landroidx/lifecycle/MutableLiveData;", "", "getDayField", "()Landroidx/lifecycle/MutableLiveData;", "setDayField", "(Landroidx/lifecycle/MutableLiveData;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "monthField", "getMonthField", "setMonthField", "saveState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSaveState", "yearField", "getYearField", "setYearField", "getCurrentlySelectedTimeInMillis", "", "isBirthdayValid", "unixMillis", "isUserSignedIn", "saveBirthday", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r extends s {

    private final DogProfile a;
    private final v2 b;
    private final g2 c;
    private final h2 d;
    private final o3 e;
    private final j2 f;
    private final x<y<Boolean>> g;
    private final a<Boolean> h;
    private x<Integer> i;
    private x<Integer> j;
    private x<Integer> k;
    private final Calendar l;
    private final CoroutineExceptionHandler m;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.q.p.r a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.q.p.r r2) {
            this.a = r2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.p().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewBirthdayViewModel$saveBirthday$1", f = "DogPreviewBirthdayViewModel.kt", l = 53, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final long $unixMillis;
        int label;
        final app.dogo.com.dogo_android.q.p.r this$0;
        a(app.dogo.com.dogo_android.q.p.r r, long l2, d<? super app.dogo.com.dogo_android.q.p.r.a> d3) {
            this.this$0 = r;
            this.$unixMillis = l2;
            super(2, obj4);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (r.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            r.a obj4 = new r.a(this.this$0, this.$unixMillis, obj2, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            Object unknownHostException;
            int label;
            g2 g2Var;
            long l;
            String format;
            int i2;
            Object obj;
            int i3;
            int i;
            Object obj11;
            Object obj2 = b.d();
            label = this.label;
            final int i4 = 1;
            if (label != 0) {
                if (label != i4) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c(b.a(i4));
                    this.this$0.p().postValue(cVar);
                    this.this$0.n().postValue(b.a(i4));
                    return w.a;
                }
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
            }
            q.b(object);
            this.this$0.p().postValue(y.b.a);
            if (!r.h(this.this$0).a()) {
                r.k(this.this$0).s("dog_preview_birthday");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                this.this$0.p().postValue(aVar);
            } else {
                obj11 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                this.label = i4;
                if (g2.f(r.j(this.this$0), r.i(this.this$0).getId(), obj11.format(b.d(this.$unixMillis)), 0, this, 4, 0) == obj2) {
                    return obj2;
                }
            }
        }
    }
    public r(DogProfile dogProfile, v2 v22, g2 g23, h2 h24, o3 o35, j2 j26) {
        Object obj2;
        Object obj4;
        app.dogo.com.dogo_android.q.p.r.b obj5;
        n.f(dogProfile, "dogProfile");
        n.f(v22, "utilities");
        n.f(g23, "dogUpdateInteractor");
        n.f(h24, "authService");
        n.f(o35, "tracker");
        n.f(j26, "connectivityService");
        super();
        this.a = dogProfile;
        this.b = v22;
        this.c = g23;
        this.d = h24;
        this.e = o35;
        this.f = j26;
        obj4 = new x();
        this.g = obj4;
        obj4 = new a();
        this.h = obj4;
        obj4 = new x();
        this.i = obj4;
        obj4 = new x();
        this.j = obj4;
        obj4 = new x();
        this.k = obj4;
        Calendar obj3 = v22.f();
        this.l = obj3;
        obj5 = new r.b(CoroutineExceptionHandler.r, this);
        this.m = obj5;
        if (dogProfile.getBirthday() != null) {
            obj4 = new Date(dogProfile.getBirthday().longValue(), o35);
            obj3.setTime(obj4);
        }
        this.k.setValue(Integer.valueOf(obj3.get(1)));
        this.j.setValue(Integer.valueOf(obj3.get(2)));
        this.i.setValue(Integer.valueOf(obj3.get(5)));
    }

    public static final j2 h(app.dogo.com.dogo_android.q.p.r r) {
        return r.f;
    }

    public static final DogProfile i(app.dogo.com.dogo_android.q.p.r r) {
        return r.a;
    }

    public static final g2 j(app.dogo.com.dogo_android.q.p.r r) {
        return r.c;
    }

    public static final o3 k(app.dogo.com.dogo_android.q.p.r r) {
        return r.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.d.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long l() {
        Object value;
        Object valueOf;
        Object value2;
        valueOf = 0;
        if ((Integer)this.k.getValue() == null) {
            value = valueOf;
        }
        if ((Integer)this.j.getValue() == null) {
            value2 = valueOf;
        }
        Object value3 = this.i.getValue();
        if ((Integer)value3 == null) {
        } else {
            valueOf = value3;
        }
        this.l.set(value.intValue(), value2.intValue(), valueOf.intValue());
        return this.l.getTime().getTime();
    }

    public final x<Integer> m() {
        return this.i;
    }

    public final a<Boolean> n() {
        return this.h;
    }

    public final x<Integer> o() {
        return this.j;
    }

    public final x<y<Boolean>> p() {
        return this.g;
    }

    public final x<Integer> q() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r(long l) {
        int obj3;
        obj3 = Long.compare(l2, l) > 0 ? 1 : 0;
        return obj3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(long l) {
        final int i = 0;
        r.a aVar = new r.a(this, l, obj8, i);
        k.d(f0.a(this), this.m, i, aVar, 2, 0);
    }
}
