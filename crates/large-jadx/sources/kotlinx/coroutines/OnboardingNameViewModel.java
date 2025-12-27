package app.dogo.com.dogo_android.welcome_v2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.exceptions.DogExceptions.NameIsTooLong;
import app.dogo.com.dogo_android.util.exceptions.DogExceptions.NameIsTooShort;
import app.dogo.com.dogo_android.w.o3;
import i.b.a0;
import java.net.UnknownHostException;
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

/* compiled from: OnboardingNameViewModel.kt */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J!\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "getOnboardingDogIdInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingDogIdInteractor;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingDogIdInteractor;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lkotlinx/coroutines/CoroutineDispatcher;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "result", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getResult", "()Lcom/hadilq/liveevent/LiveEvent;", "isNameTooLong", "", "dogName", "", "isNameTooShort", "isRequestValid", "name", "postExceptions", "", "saveDogName", "dogId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateAndSaveDogName", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g0, reason: from kotlin metadata */
public class OnboardingNameViewModel extends s {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final g0.a INSTANCE = new g0$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final p1 connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final j2 dispatcher;
    /* renamed from: c, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.a.r2 dogUpdateInteractor;
    /* renamed from: d, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.r2 exceptionHandler;
    /* renamed from: e, reason: from kotlin metadata */
    private final g2 getOnboardingDogIdInteractor;
    /* renamed from: f, reason: from kotlin metadata */
    private final o3 remoteConfigService;
    private final h0 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final f.d.a.a<y<DogProfile>> tracker;
    /* renamed from: i, reason: from kotlin metadata */
    private final CoroutineExceptionHandler userRepository;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingNameViewModel$Companion;", "", "()V", "NAME_MAX_LENGTH", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ g0 a;
        public b(CoroutineExceptionHandler.a exc, g0 g0Var) {
            this.a = g0Var;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.o().postValue(new LoadResult_Error(exception));
            if (exception instanceof TimeoutException) {
                this.a.remoteConfigService.c(E_Auth.e);
            } else {
                if (exception instanceof DogExceptions_NameIsTooLong) {
                    this.a.remoteConfigService.c(E_Auth.g);
                } else {
                    if (exception instanceof DogExceptions_NameIsTooShort) {
                        this.a.remoteConfigService.c(E_Auth.f);
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.welcome_v2.OnboardingNameViewModel$validateAndSaveDogName$1", f = "OnboardingNameViewModel.kt", l = 52, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ String $dogName;
        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object object2;
            String $dogName2;
            Object obj = b.d();
            final String str2 = "dogId";
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    n.e(object2, str2);
                    g0.this.o().postValue(new LoadResult_Success((DogProfile)g0.this.connectivityService.z(object2).blockingGet()));
                    return w.a;
                }
            }
            q.b(object);
            if (!(g0.this.o().getValue() instanceof LoadResult_Loading)) {
                if (g0.this.r(this.$dogName)) {
                    g0.this.o().postValue(LoadResult_Loading.a);
                    g0.this.exceptionHandler.m0().ignoreElement().e();
                    object2 = g0.this.dogUpdateInteractor.c().blockingGet();
                    n.e(object2, str2);
                    this.L$0 = object2;
                    this.label = i;
                    if (g0.this.t(object2, this.$dogName, this) == obj) {
                        return obj;
                    }
                } else {
                    g0.this.s(this.$dogName);
                }
            }
        }

        c(String str, d<? super g0.c> dVar) {
            this.$dogName = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.g0.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.g0.c(g0.this, this.$dogName, dVar);
        }
    }
    public /* synthetic */ g0(p1 p1Var, j2 j2Var, app.dogo.com.dogo_android.s.a.r2 r2Var, app.dogo.com.dogo_android.service.r2 r2Var2, g2 g2Var, o3 o3Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var72;
        h0Var72 = i & 64 != 0 ? h0Var72 : h0Var;
        this(p1Var, j2Var, r2Var, r2Var2, g2Var, o3Var, h0Var72);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.s.a.r2 isNameTooLong(g0 dogName) {
        return dogName.dogUpdateInteractor;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.service.r2 isNameTooShort(g0 dogName) {
        return dogName.exceptionHandler;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ o3 isRequestValid(g0 name) {
        return name.remoteConfigService;
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final /* synthetic */ p1 postExceptions(g0 name) {
        return name.connectivityService;
    }

    /* renamed from: l, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ boolean saveDogName(g0 dogId, String dogName) {
        return dogId.r(dogName);
    }

    public static final /* synthetic */ void m(g0 g0Var, String str) {
        g0Var.s(str);
    }

    public static final /* synthetic */ Object n(g0 g0Var, String str, String str2, d dVar) {
        return g0Var.t(str, str2, dVar);
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final boolean validateAndSaveDogName(String dogName) {
        boolean z = true;
        dogName = dogName.length() > 21 ? 1 : 0;
        return (dogName.length() > 21 ? 1 : 0);
    }

    private final boolean q(String str) {
        boolean z = true;
        str = str.length() == 0 ? 1 : 0;
        return (str.length() == 0 ? 1 : 0);
    }

    private final boolean r(String str) {
        boolean z2 = true;
        if (!q(str) && !this.validateAndSaveDogName(str)) {
            str = this.dispatcher.a() ? 1 : 0;
        }
        return (this.dispatcher.a() ? 1 : 0);
    }

    private final void s(String str) {
        DogExceptions.NameIsTooLong dogExceptions_NameIsTooLong;
        if (!this.dispatcher.a()) {
            UnknownHostException unknownHostException = new UnknownHostException();
        } else {
            if (validateAndSaveDogName(str)) {
                dogExceptions_NameIsTooLong = new DogExceptions_NameIsTooLong();
            } else {
                str = q(str) ? new DogExceptions_NameIsTooShort() : new Exception();
            }
        }
        this.tracker.postValue(new LoadResult_Error(dogExceptions_NameIsTooLong));
    }

    private final Object t(String str, String str2, d<? super w> dVar) {
        Object obj = this.getOnboardingDogIdInteractor.k(str, str2, dVar);
        if (obj == b.d()) {
            return obj;
        }
        return w.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<y<DogProfile>> o() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String str) {
        n.f(str, "dogName");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.g.plus(this.userRepository), null, new kotlinx.coroutines.g0.c(this, str, null), 2, null);
    }

    public g0(p1 p1Var, j2 j2Var, app.dogo.com.dogo_android.s.a.r2 r2Var, app.dogo.com.dogo_android.service.r2 r2Var2, g2 g2Var, o3 o3Var, h0 h0Var) {
        n.f(p1Var, "userRepository");
        n.f(j2Var, "connectivityService");
        n.f(r2Var, "getOnboardingDogIdInteractor");
        n.f(r2Var2, "remoteConfigService");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(o3Var, "tracker");
        n.f(h0Var, "dispatcher");
        super();
        this.connectivityService = p1Var;
        this.dispatcher = j2Var;
        this.dogUpdateInteractor = r2Var;
        this.exceptionHandler = r2Var2;
        this.getOnboardingDogIdInteractor = g2Var;
        this.remoteConfigService = o3Var;
        this.g = h0Var;
        this.tracker = new a();
        this.userRepository = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

}
