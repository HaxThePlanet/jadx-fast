package app.dogo.com.dogo_android.q.p;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.s.b.z0;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.x0;
import app.dogo.com.dogo_android.w.y;
import f.d.a.a;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.o;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#J!\u0010$\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020#R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "breedRepository", "Lapp/dogo/com/dogo_android/repository/local/BreedRepository;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/local/BreedRepository;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "saveState", "getSaveState", "isUserSignedIn", "loadList", "", "saveBreed", "dogBreed", "dogId", "", "saveDogBreed", "(Lapp/dogo/com/dogo_android/repository/domain/DogBreed;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackBreedSelected", "id", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class u extends s {

    private final z0 a;
    private final g2 b;
    private final o3 c;
    private final h2 d;
    private final j2 e;
    private final x<y<List<DogBreed>>> f;
    private final x<y<Boolean>> g;
    private final a<Boolean> h;
    private final CoroutineExceptionHandler i;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.q.p.u this$0;
        a(app.dogo.com.dogo_android.q.p.u u) {
            this.this$0 = u;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            this.this$0.l().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<List<? extends DogBreed>, w> {

        final app.dogo.com.dogo_android.q.p.u this$0;
        b(app.dogo.com.dogo_android.q.p.u u) {
            this.this$0 = u;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((List)object);
            return w.a;
        }

        public final void invoke(List<DogBreed> list) {
            y.c cVar = new y.c(list);
            this.this$0.l().postValue(cVar);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.q.p.u a;
        public d(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.q.p.u u2) {
            this.a = u2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.m().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewBreedViewModel$saveBreed$1", f = "DogPreviewBreedViewModel.kt", l = 46, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        final DogBreed $dogBreed;
        final String $dogId;
        int label;
        final app.dogo.com.dogo_android.q.p.u this$0;
        c(app.dogo.com.dogo_android.q.p.u u, DogBreed dogBreed2, String string3, d<? super app.dogo.com.dogo_android.q.p.u.c> d4) {
            this.this$0 = u;
            this.$dogBreed = dogBreed2;
            this.$dogId = string3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (u.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            u.c obj4 = new u.c(this.this$0, this.$dogBreed, this.$dogId, d2);
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
            int $dogBreed;
            String $dogId;
            Object obj5;
            Object obj = b.d();
            $dogBreed = this.label;
            final int i = 1;
            if ($dogBreed != 0) {
                if ($dogBreed != i) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c(b.a(i));
                    this.this$0.m().postValue(cVar);
                    this.this$0.k().postValue(b.a(i));
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            this.this$0.m().postValue(y.b.a);
            if (!u.h(this.this$0).a()) {
                u.i(this.this$0).s("dog_preview_breed");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                this.this$0.m().postValue(aVar);
            } else {
                this.label = i;
                if (u.j(this.this$0, this.$dogBreed, this.$dogId, this) == obj) {
                    return obj;
                }
            }
        }
    }
    public u(z0 z0, g2 g22, o3 o33, h2 h24, j2 j25) {
        n.f(z0, "breedRepository");
        n.f(g22, "dogUpdateInteractor");
        n.f(o33, "tracker");
        n.f(h24, "authService");
        n.f(j25, "connectivityService");
        super();
        this.a = z0;
        this.b = g22;
        this.c = o33;
        this.d = h24;
        this.e = j25;
        x obj2 = new x();
        this.f = obj2;
        obj2 = new x();
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
        u.d obj3 = new u.d(CoroutineExceptionHandler.r, this);
        this.i = obj3;
        n();
    }

    public static final j2 h(app.dogo.com.dogo_android.q.p.u u) {
        return u.e;
    }

    public static final o3 i(app.dogo.com.dogo_android.q.p.u u) {
        return u.c;
    }

    public static final Object j(app.dogo.com.dogo_android.q.p.u u, DogBreed dogBreed2, String string3, d d4) {
        return u.p(dogBreed2, string3, d4);
    }

    private final Object p(DogBreed dogBreed, String string2, d<? super w> d3) {
        Object obj2 = this.b.h(string2, dogBreed.getName(), d3);
        if (dogBreed.isCustom() && obj2 == b.d()) {
            obj2 = this.b.h(string2, dogBreed.getName(), d3);
            if (obj2 == b.d()) {
                return obj2;
            }
            return w.a;
        }
        obj2 = this.b.g(string2, dogBreed.getId(), d3);
        if (obj2 == b.d()) {
            return obj2;
        }
        return w.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.d.D();
    }

    public final a<Boolean> k() {
        return this.h;
    }

    public final x<y<List<DogBreed>>> l() {
        return this.f;
    }

    public final x<y<Boolean>> m() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        this.f.postValue(y.b.a);
        a0 subscribeOn = this.a.a().observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "breedRepository.getAllBreeds()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        u.a aVar = new u.a(this);
        u.b bVar3 = new u.b(this);
        getDisposable().b(a.g(subscribeOn, aVar, bVar3));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o(DogBreed dogBreed, String string2) {
        n.f(dogBreed, "dogBreed");
        n.f(string2, "dogId");
        u.c cVar = new u.c(this, dogBreed, string2, 0);
        k.d(f0.a(this), this.i, 0, cVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q(String string) {
        n.f(string, "id");
        x0 x0Var = new x0();
        o oVar = new o(x0Var, string);
        this.c.d(y.a.d(oVar));
    }
}
