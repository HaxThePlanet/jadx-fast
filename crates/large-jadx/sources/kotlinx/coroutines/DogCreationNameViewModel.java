package app.dogo.com.dogo_android.dogcreation.m;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import i.b.a0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: DogCreationNameViewModel.kt */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001aJ\u0006\u0010#\u001a\u00020\u0015J\u0018\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u001aJ\u0008\u0010'\u001a\u00020(H\u0002J#\u0010)\u001a\u00020\u001f2\u0008\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0\u001e0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006+", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/name/DogCreationNameViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "nameField", "Landroidx/lifecycle/MutableLiveData;", "", "getNameField", "()Landroidx/lifecycle/MutableLiveData;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getSavingState", "isNameValid", "name", "isUserSignedIn", "saveDogName", "", "dogId", "signInUserIfNeeded", "Lio/reactivex/Completable;", "updateOrCreateDog", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class DogCreationNameViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final h2 connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final p2 dispatcher;
    /* renamed from: d, reason: from kotlin metadata */
    private final g2 dogUpdateInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final o3 exceptionHandler;
    private final j2 f;
    private final h0 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final x<y<DogProfile>> preferenceService;
    private final f.d.a.a<Boolean> i;
    /* renamed from: j, reason: from kotlin metadata */
    private final x<String> tracker;
    /* renamed from: k, reason: from kotlin metadata */
    private final CoroutineExceptionHandler userRepository;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ e a;
        public b(CoroutineExceptionHandler.a exc, e eVar) {
            this.a = eVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.q().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.name.DogCreationNameViewModel", f = "DogCreationNameViewModel.kt", l = 59, m = "updateOrCreateDog")
    static final class c extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super e.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return e.this.u(str, str, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.name.DogCreationNameViewModel$saveDogName$1", f = "DogCreationNameViewModel.kt", l = 49, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ String $dogId;
        final /* synthetic */ String $name;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String $name2;
            Object obj;
            Object obj2 = b.d();
            final int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    e.this.dispatcher.U0(false);
                    e.this.q().postValue(new LoadResult_Success((DogProfile)obj));
                    e.this.o().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            if (!(e.this.q().getValue() instanceof LoadResult_Loading)) {
                e.this.q().postValue(LoadResult_Loading.a);
                if (e.this.f.getActiveNetworkType()) {
                    this.label = i2;
                    if (e.this.u(this.$dogId, this.$name, this) == obj2) {
                        return obj2;
                    }
                } else {
                    e.this.exceptionHandler.setTrainingReminderUserProperties("dog_creation_name");
                    e.this.q().postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
        }

        a(String str, String str2, kotlin.b0.d<? super e.a> dVar) {
            this.$dogId = str;
            this.$name = str2;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.e.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.e.a(e.this, this.$dogId, this.$name, dVar);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.name.DogCreationNameViewModel$updateOrCreateDog$2", f = "DogCreationNameViewModel.kt", l = 62, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super DogProfile>, Object> {

        final /* synthetic */ String $dogId;
        final /* synthetic */ String $name;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label2;
            String $name2;
            DogProfile dogProfile;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    n.d(e.this.authService.H().getDogProfile(this.$dogId));
                    return dogProfile;
                }
            }
            q.b(object);
            e.this.isUserSignedIn().e();
            if (this.$dogId != null) {
                this.label = i;
                if (e.this.dogUpdateInteractor.k(this.$dogId, this.$name, this) == obj2) {
                    return obj2;
                }
            } else {
                Object blockingGet = e.this.authService.removeParticipatingChallenge(this.$name).blockingGet();
            }
        }

        d(String str, String str2, kotlin.b0.d<? super e.d> dVar) {
            this.$dogId = str;
            this.$name = str2;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super DogProfile> dVar) {
            return (kotlinx.coroutines.e.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.e.d(e.this, this.$dogId, this.$name, dVar);
        }
    }
    public /* synthetic */ e(p1 p1Var, h2 h2Var, p2 p2Var, g2 g2Var, o3 o3Var, j2 j2Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var72;
        h0Var72 = i & 64 != 0 ? h0Var72 : h0Var;
        this(p1Var, h2Var, p2Var, g2Var, o3Var, j2Var, h0Var72);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 isNameValid(e name) {
        return name.f;
    }

    public static final /* synthetic */ g2 i(e eVar) {
        return eVar.dogUpdateInteractor;
    }

    public static final /* synthetic */ p2 j(e eVar) {
        return eVar.dispatcher;
    }

    public static final /* synthetic */ o3 k(e eVar) {
        return eVar.exceptionHandler;
    }

    public static final /* synthetic */ p1 l(e eVar) {
        return eVar.authService;
    }

    public static final /* synthetic */ i.b.b m(e eVar) {
        return eVar.isUserSignedIn();
    }

    public static final /* synthetic */ Object n(e eVar, String str, String str2, kotlin.b0.d dVar) {
        return eVar.u(str, str2, dVar);
    }

    /* renamed from: t, reason: from kotlin metadata */
    private final i.b.b isUserSignedIn() {
        int i = 1;
        i.b.b ignoreElement;
        boolean z = false;
        int r0 = this.connectivityService.v().length() == 0 ? 1 : z;
        if (this.connectivityService != null) {
            str = "{\n            authService.anonymousSignInSingle(false).ignoreElement()\n        }";
            n.e(this.connectivityService.c(z).ignoreElement(), str);
        } else {
            str = "{\n            Completable.complete()\n        }";
            n.e(b.f(), str);
        }
        return ignoreElement;
    }

    private final Object u(String str, String str2, kotlin.b0.d<? super DogProfile> dVar) {
        Object dVar32;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.e.c;
        if (dVar instanceof kotlinx.coroutines.e.c) {
            dVar32 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.dogcreation.m.e.c cVar = new kotlinx.coroutines.e.c(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar32.label != 0 && dVar32.label == i3) {
            q.b(dVar32.result);
            n.e(result2, "private suspend fun updateOrCreateDog(dogId: String?, name: String): DogProfile {\n        return withContext(dispatcher) {\n            signInUserIfNeeded().blockingAwait()\n            if (dogId != null) {\n                dogUpdateInteractor.updateName(dogId, name)\n                userRepository.tempUserCache.getDogProfile(dogId)!!\n            } else {\n                userRepository.addNewDog(name).blockingGet()\n            }\n        }\n    }");
            return result2;
        }
        q.b(dVar32.result);
        dVar = null;
        dVar32.label = i3;
        if (kotlinx.coroutines.internal.k.e(this.g, new kotlinx.coroutines.e.d(this, str, str2, dVar), dVar32) == obj) {
            return obj;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> o() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> p() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<DogProfile>> q() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r(String str) {
        int i;
        boolean z = true;
        int length;
        n.f(str, "name");
        i = 0;
        int r0 = str.length() > 0 ? 1 : i;
        if (i != 0) {
            i = 21;
            if (str.length() > 21) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: s, reason: from kotlin metadata */
    public final void saveDogName(String dogId, String name) {
        n.f(name, "name");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.userRepository, null, new kotlinx.coroutines.e.a(this, dogId, name, null), 2, null);
    }

    public e(p1 p1Var, h2 h2Var, p2 p2Var, g2 g2Var, o3 o3Var, j2 j2Var, h0 h0Var) {
        n.f(p1Var, "userRepository");
        n.f(h2Var, "authService");
        n.f(p2Var, "preferenceService");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        n.f(h0Var, "dispatcher");
        super();
        this.authService = p1Var;
        this.connectivityService = h2Var;
        this.dispatcher = p2Var;
        this.dogUpdateInteractor = g2Var;
        this.exceptionHandler = o3Var;
        this.f = j2Var;
        this.g = h0Var;
        this.preferenceService = new x();
        this.i = new a();
        this.tracker = new x("");
        this.userRepository = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }
}
