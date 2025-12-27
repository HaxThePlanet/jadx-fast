package app.dogo.com.dogo_android.dogcreation.j;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import java.net.UnknownHostException;
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

/* compiled from: DogCreationBreedViewModel.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ!\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "getPreferenceService", "()Lapp/dogo/com/dogo_android/service/PreferenceService;", "savingState", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "()Landroidx/lifecycle/MutableLiveData;", "saveDogBreed", "", "dogId", "", "dogBreed", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "saveSelectedBreed", "(Lapp/dogo/com/dogo_android/repository/domain/DogBreed;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class DogCreationBreedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final g2 connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 dogUpdateInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final j2 exceptionHandler;
    private final x<y<Boolean>> d = new x<>();
    private final f.d.a.a<Boolean> e = new a<>();
    private final CoroutineExceptionHandler f = new n$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ n a;
        public b(CoroutineExceptionHandler.a exc, n nVar) {
            this.a = nVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.l().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.breed.DogCreationBreedViewModel$saveDogBreed$1", f = "DogCreationBreedViewModel.kt", l = 39, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

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
                    n.this.l().postValue(new LoadResult_Success(b.a(true)));
                    n.this.k().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            if (!(n.this.l().getValue() instanceof LoadResult_Loading)) {
                n.this.l().postValue(LoadResult_Loading.a);
                if (n.this.exceptionHandler.getActiveNetworkType()) {
                    this.label = i;
                    if (n.this.n(this.$dogBreed, this.$dogId, this) == obj2) {
                        return obj2;
                    }
                } else {
                    n.this.dogUpdateInteractor.setTrainingReminderUserProperties("dog_preview_breed");
                    n.this.l().postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
        }

        a(DogBreed dogBreed, String str, d<? super n.a> dVar) {
            this.$dogBreed = dogBreed;
            this.$dogId = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.dogcreation.breed.n.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.dogcreation.breed.n.a(n.this, this.$dogBreed, this.$dogId, dVar);
        }
    }
    public n(p2 p2Var, g2 g2Var, o3 o3Var, j2 j2Var) {
        n.f(p2Var, "preferenceService");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.connectivityService = g2Var;
        this.dogUpdateInteractor = o3Var;
        this.exceptionHandler = j2Var;
        x xVar = new x();
        f.d.a.a aVar = new a();
        final app.dogo.com.dogo_android.dogcreation.j.n.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    public static final /* synthetic */ j2 h(n nVar) {
        return nVar.exceptionHandler;
    }

    public static final /* synthetic */ o3 i(n nVar) {
        return nVar.dogUpdateInteractor;
    }

    public static final /* synthetic */ Object j(n nVar, DogBreed dogBreed, String str, d dVar) {
        return nVar.n(dogBreed, str, dVar);
    }

    private final Object n(DogBreed dogBreed, String str, d<? super w> dVar) {
        if (dogBreed.isCustom()) {
            Object obj = this.connectivityService.h(str, dogBreed.getName(), dVar);
            if (obj == b.d()) {
                return obj;
            }
            return w.a;
        }
        Object obj2 = this.connectivityService.g(str, dogBreed.getId(), dVar);
        if (obj2 == b.d()) {
            return obj2;
        }
        return w.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> k() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> l() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: m, reason: from kotlin metadata */
    public final void saveDogBreed(String dogId, DogBreed dogBreed) {
        n.f(dogId, "dogId");
        n.f(dogBreed, "dogBreed");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.f, null, new app.dogo.com.dogo_android.dogcreation.breed.n.a(this, dogBreed, dogId, null), 2, null);
    }
}
