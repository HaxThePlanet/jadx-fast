package app.dogo.com.dogo_android.q.p;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.s.b.z0;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.x0;
import i.b.a0;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: DogPreviewBreedViewModel.kt */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#J!\u0010$\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020#R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "breedRepository", "Lapp/dogo/com/dogo_android/repository/local/BreedRepository;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/local/BreedRepository;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "saveState", "getSaveState", "isUserSignedIn", "loadList", "", "saveBreed", "dogBreed", "dogId", "", "saveDogBreed", "(Lapp/dogo/com/dogo_android/repository/domain/DogBreed;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackBreedSelected", "id", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u, reason: from kotlin metadata */
public final class DogPreviewBreedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final z0 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final g2 breedRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 connectivityService;
    /* renamed from: d, reason: from kotlin metadata */
    private final h2 dogUpdateInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final j2 exceptionHandler;
    private final x<app.dogo.com.dogo_android.util.e0.y<List<DogBreed>>> f = new x<>();
    private final x<app.dogo.com.dogo_android.util.e0.y<Boolean>> g = new x<>();
    private final f.d.a.a<Boolean> h = new a<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new u$d();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            u.this.l().postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements l<List<? extends DogBreed>, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(List<DogBreed> list) {
            u.this.l().postValue(new LoadResult_Success(list));
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ u a;
        public d(CoroutineExceptionHandler.a exc, u uVar) {
            this.a = uVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.m().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewBreedViewModel$saveBreed$1", f = "DogPreviewBreedViewModel.kt", l = 46, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ DogBreed $dogBreed;
        final /* synthetic */ String $dogId;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String $dogId2;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    u.this.m().postValue(new LoadResult_Success(b.a(true)));
                    u.this.loadList().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            u.this.m().postValue(LoadResult_Loading.a);
            if (u.this.exceptionHandler.getActiveNetworkType()) {
                this.label = i;
                if (u.this.p(this.$dogBreed, this.$dogId, this) == obj2) {
                    return obj2;
                }
            } else {
                u.this.connectivityService.setTrainingReminderUserProperties("dog_preview_breed");
                u.this.m().postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        c(DogBreed dogBreed, String str, d<? super u.c> dVar) {
            this.$dogBreed = dogBreed;
            this.$dogId = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.profile.dogprofile.u.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.profile.dogprofile.u.c(u.this, this.$dogBreed, this.$dogId, dVar);
        }
    }
    public u(z0 z0Var, g2 g2Var, o3 o3Var, h2 h2Var, j2 j2Var) {
        n.f(z0Var, "breedRepository");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(o3Var, "tracker");
        n.f(h2Var, "authService");
        n.f(j2Var, "connectivityService");
        super();
        this.authService = z0Var;
        this.breedRepository = g2Var;
        this.connectivityService = o3Var;
        this.dogUpdateInteractor = h2Var;
        this.exceptionHandler = j2Var;
        x xVar = new x();
        x xVar2 = new x();
        f.d.a.a aVar = new a();
        final app.dogo.com.dogo_android.q.p.u.d coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
        n();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 trackBreedSelected(u id) {
        return id.exceptionHandler;
    }

    public static final /* synthetic */ o3 i(u uVar) {
        return uVar.connectivityService;
    }

    public static final /* synthetic */ Object j(u uVar, DogBreed dogBreed, String str, d dVar) {
        return uVar.p(dogBreed, str, dVar);
    }

    private final Object p(DogBreed dogBreed, String str, d<? super w> dVar) {
        if (dogBreed.isCustom()) {
            Object obj = this.breedRepository.h(str, dogBreed.getName(), dVar);
            if (obj == b.d()) {
                return obj;
            }
            return w.a;
        }
        Object obj2 = this.breedRepository.g(str, dogBreed.getId(), dVar);
        if (obj2 == b.d()) {
            return obj2;
        }
        return w.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.dogUpdateInteractor.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final f.d.a.a<Boolean> loadList() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<app.dogo.com.dogo_android.util.e0.y<List<DogBreed>>> l() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<app.dogo.com.dogo_android.util.e0.y<Boolean>> m() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        this.f.postValue(LoadResult_Loading.a);
        a0 observable2 = this.authService.getAllBreeds().observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "breedRepository.getAllBreeds()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.profile.dogprofile.u.a(this), new app.dogo.com.dogo_android.profile.dogprofile.u.b(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: o, reason: from kotlin metadata */
    public final void saveBreed(DogBreed dogBreed, String dogId) {
        n.f(dogBreed, "dogBreed");
        n.f(dogId, "dogId");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, null, new app.dogo.com.dogo_android.profile.dogprofile.u.c(this, dogBreed, dogId, null), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q(String str) {
        n.f(str, "id");
        this.connectivityService.logEvent(E_DogProfile.a.withParameters(new Pair(new EP_BreedId(), str)));
    }
}
