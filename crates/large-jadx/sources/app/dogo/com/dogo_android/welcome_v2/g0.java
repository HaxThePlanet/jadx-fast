package app.dogo.com.dogo_android.welcome_v2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.s.a.r2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.exceptions.DogExceptions.NameIsTooLong;
import app.dogo.com.dogo_android.util.exceptions.DogExceptions.NameIsTooShort;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J!\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "getOnboardingDogIdInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingDogIdInteractor;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingDogIdInteractor;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lkotlinx/coroutines/CoroutineDispatcher;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "result", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getResult", "()Lcom/hadilq/liveevent/LiveEvent;", "isNameTooLong", "", "dogName", "", "isNameTooShort", "isRequestValid", "name", "postExceptions", "", "saveDogName", "dogId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateAndSaveDogName", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class g0 extends s {

    public static final app.dogo.com.dogo_android.welcome_v2.g0.a Companion;
    private final p1 a;
    private final j2 b;
    private final r2 c;
    private final r2 d;
    private final g2 e;
    private final o3 f;
    private final h0 g;
    private final a<y<DogProfile>> h;
    private final CoroutineExceptionHandler i;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameViewModel$Companion;", "", "()V", "NAME_MAX_LENGTH", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.welcome_v2.g0 a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.welcome_v2.g0 g02) {
            this.a = g02;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            o3 obj2;
            Object obj3;
            y.a aVar = new y.a(throwable2);
            this.a.o().postValue(aVar);
            if (throwable2 instanceof TimeoutException != null) {
                g0.j(this.a).c(p.e);
            } else {
                if (throwable2 instanceof DogExceptions.NameIsTooLong) {
                    g0.j(this.a).c(p.g);
                } else {
                    if (throwable2 instanceof DogExceptions.NameIsTooShort) {
                        g0.j(this.a).c(p.f);
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.welcome_v2.OnboardingNameViewModel$validateAndSaveDogName$1", f = "OnboardingNameViewModel.kt", l = 52, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        final String $dogName;
        Object L$0;
        int label;
        final app.dogo.com.dogo_android.welcome_v2.g0 this$0;
        c(app.dogo.com.dogo_android.welcome_v2.g0 g0, String string2, d<? super app.dogo.com.dogo_android.welcome_v2.g0.c> d3) {
            this.this$0 = g0;
            this.$dogName = string2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (g0.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g0.c obj3 = new g0.c(this.this$0, this.$dogName, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object $dogName3;
            Object l$0;
            y.c $dogName;
            String $dogName2;
            Object obj6;
            $dogName3 = b.d();
            $dogName = this.label;
            final String str2 = "dogId";
            final int i = 1;
            if ($dogName != 0) {
                if ($dogName != i) {
                } else {
                    l$0 = this.L$0;
                    q.b(object);
                    n.e(l$0, str2);
                    $dogName = new y.c((DogProfile)g0.k(this.this$0).z(l$0).blockingGet());
                    this.this$0.o().postValue($dogName);
                    return w.a;
                }
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
            }
            q.b(object);
            if (!obj6 instanceof y.b) {
                if (!g0.l(this.this$0, this.$dogName)) {
                    g0.m(this.this$0, this.$dogName);
                } else {
                    this.this$0.o().postValue(y.b.a);
                    g0.i(this.this$0).m0().ignoreElement().e();
                    obj6 = g0.h(this.this$0).c().blockingGet();
                    n.e((String)obj6, str2);
                    this.L$0 = obj6;
                    this.label = i;
                    if (g0.n(this.this$0, obj6, this.$dogName, this) == $dogName3) {
                        return $dogName3;
                    }
                    l$0 = obj6;
                }
            }
        }
    }
    static {
        g0.a aVar = new g0.a(0);
        g0.Companion = aVar;
    }

    public g0(p1 p1, j2 j22, r2 r23, r2 r24, g2 g25, o3 o36, h0 h07) {
        n.f(p1, "userRepository");
        n.f(j22, "connectivityService");
        n.f(r23, "getOnboardingDogIdInteractor");
        n.f(r24, "remoteConfigService");
        n.f(g25, "dogUpdateInteractor");
        n.f(o36, "tracker");
        n.f(h07, "dispatcher");
        super();
        this.a = p1;
        this.b = j22;
        this.c = r23;
        this.d = r24;
        this.e = g25;
        this.f = o36;
        this.g = h07;
        a obj2 = new a();
        this.h = obj2;
        g0.b obj3 = new g0.b(CoroutineExceptionHandler.r, this);
        this.i = obj3;
    }

    public g0(p1 p1, j2 j22, r2 r23, r2 r24, g2 g25, o3 o36, h0 h07, int i8, g g9) {
        h0 i;
        h0 h0Var;
        if (i8 & 64 != 0) {
            h0Var = i;
        } else {
            h0Var = h07;
        }
        super(p1, j22, r23, r24, g25, o36, h0Var);
    }

    public static final r2 h(app.dogo.com.dogo_android.welcome_v2.g0 g0) {
        return g0.c;
    }

    public static final r2 i(app.dogo.com.dogo_android.welcome_v2.g0 g0) {
        return g0.d;
    }

    public static final o3 j(app.dogo.com.dogo_android.welcome_v2.g0 g0) {
        return g0.f;
    }

    public static final p1 k(app.dogo.com.dogo_android.welcome_v2.g0 g0) {
        return g0.a;
    }

    public static final boolean l(app.dogo.com.dogo_android.welcome_v2.g0 g0, String string2) {
        return g0.r(string2);
    }

    public static final void m(app.dogo.com.dogo_android.welcome_v2.g0 g0, String string2) {
        g0.s(string2);
    }

    public static final Object n(app.dogo.com.dogo_android.welcome_v2.g0 g0, String string2, String string3, d d4) {
        return g0.t(string2, string3, d4);
    }

    private final boolean p(String string) {
        int obj2;
        obj2 = string.length() > 21 ? 1 : 0;
        return obj2;
    }

    private final boolean q(String string) {
        int obj1;
        obj1 = string.length() == 0 ? 1 : 0;
        return obj1;
    }

    private final boolean r(String string) {
        int obj2;
        if (!q(string) && !p(string) && this.b.a()) {
            if (!p(string)) {
                obj2 = this.b.a() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private final void s(String string) {
        boolean z;
        Object obj3;
        if (!this.b.a()) {
            obj3 = new UnknownHostException();
        } else {
            if (p(string)) {
                obj3 = new DogExceptions.NameIsTooLong();
            } else {
                if (q(string)) {
                    obj3 = new DogExceptions.NameIsTooShort();
                } else {
                    obj3 = new Exception();
                }
            }
        }
        y.a aVar2 = new y.a(obj3);
        this.h.postValue(aVar2);
    }

    private final Object t(String string, String string2, d<? super w> d3) {
        Object obj2 = this.e.k(string, string2, d3);
        if (obj2 == b.d()) {
            return obj2;
        }
        return w.a;
    }

    public final a<y<DogProfile>> o() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String string) {
        n.f(string, "dogName");
        g0.c cVar = new g0.c(this, string, 0);
        k.d(f0.a(this), this.g.plus(this.i), 0, cVar, 2, 0);
    }
}
