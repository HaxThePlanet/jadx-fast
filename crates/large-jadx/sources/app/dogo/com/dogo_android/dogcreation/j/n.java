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
import f.d.a.a;
import java.net.UnknownHostException;
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
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ!\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "getPreferenceService", "()Lapp/dogo/com/dogo_android/service/PreferenceService;", "savingState", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "()Landroidx/lifecycle/MutableLiveData;", "saveDogBreed", "", "dogId", "", "dogBreed", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "saveSelectedBreed", "(Lapp/dogo/com/dogo_android/repository/domain/DogBreed;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends s {

    private final g2 a;
    private final o3 b;
    private final j2 c;
    private final x<y<Boolean>> d;
    private final a<Boolean> e;
    private final CoroutineExceptionHandler f;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.dogcreation.j.n a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.dogcreation.j.n n2) {
            this.a = n2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.l().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.breed.DogCreationBreedViewModel$saveDogBreed$1", f = "DogCreationBreedViewModel.kt", l = 39, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final DogBreed $dogBreed;
        final String $dogId;
        int label;
        final app.dogo.com.dogo_android.dogcreation.j.n this$0;
        a(app.dogo.com.dogo_android.dogcreation.j.n n, DogBreed dogBreed2, String string3, d<? super app.dogo.com.dogo_android.dogcreation.j.n.a> d4) {
            this.this$0 = n;
            this.$dogBreed = dogBreed2;
            this.$dogId = string3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (n.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            n.a obj4 = new n.a(this.this$0, this.$dogBreed, this.$dogId, d2);
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
            String $dogId;
            a obj5;
            aVar = b.d();
            unknownHostException = this.label;
            final int i = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c(b.a(i));
                    this.this$0.l().postValue(cVar);
                    this.this$0.k().postValue(b.a(i));
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            if (!obj5 instanceof y.b) {
                this.this$0.l().postValue(y.b.a);
                if (!n.h(this.this$0).a()) {
                    n.i(this.this$0).s("dog_preview_breed");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.l().postValue(aVar);
                } else {
                    this.label = i;
                    if (n.j(this.this$0, this.$dogBreed, this.$dogId, this) == aVar) {
                        return aVar;
                    }
                }
            }
        }
    }
    public n(p2 p2, g2 g22, o3 o33, j2 j24) {
        n.f(p2, "preferenceService");
        n.f(g22, "dogUpdateInteractor");
        n.f(o33, "tracker");
        n.f(j24, "connectivityService");
        super();
        this.a = g22;
        this.b = o33;
        this.c = j24;
        x obj2 = new x();
        this.d = obj2;
        obj2 = new a();
        this.e = obj2;
        n.b obj3 = new n.b(CoroutineExceptionHandler.r, this);
        this.f = obj3;
    }

    public static final j2 h(app.dogo.com.dogo_android.dogcreation.j.n n) {
        return n.c;
    }

    public static final o3 i(app.dogo.com.dogo_android.dogcreation.j.n n) {
        return n.b;
    }

    public static final Object j(app.dogo.com.dogo_android.dogcreation.j.n n, DogBreed dogBreed2, String string3, d d4) {
        return n.n(dogBreed2, string3, d4);
    }

    private final Object n(DogBreed dogBreed, String string2, d<? super w> d3) {
        Object obj2 = this.a.h(string2, dogBreed.getName(), d3);
        if (dogBreed.isCustom() && obj2 == b.d()) {
            obj2 = this.a.h(string2, dogBreed.getName(), d3);
            if (obj2 == b.d()) {
                return obj2;
            }
            return w.a;
        }
        obj2 = this.a.g(string2, dogBreed.getId(), d3);
        if (obj2 == b.d()) {
            return obj2;
        }
        return w.a;
    }

    public final a<Boolean> k() {
        return this.e;
    }

    public final x<y<Boolean>> l() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m(String string, DogBreed dogBreed2) {
        n.f(string, "dogId");
        n.f(dogBreed2, "dogBreed");
        n.a aVar = new n.a(this, dogBreed2, string, 0);
        k.d(f0.a(this), this.f, 0, aVar, 2, 0);
    }
}
