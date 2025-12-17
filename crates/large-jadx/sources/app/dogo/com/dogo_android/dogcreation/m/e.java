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
import f.d.a.a;
import i.b.a0;
import i.b.b;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
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
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u001aJ\u0006\u0010#\u001a\u00020\u0015J\u0018\u0010$\u001a\u00020%2\u0008\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u001aJ\u0008\u0010'\u001a\u00020(H\u0002J#\u0010)\u001a\u00020\u001f2\u0008\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0\u001e0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006+", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/name/DogCreationNameViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "nameField", "Landroidx/lifecycle/MutableLiveData;", "", "getNameField", "()Landroidx/lifecycle/MutableLiveData;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getSavingState", "isNameValid", "name", "isUserSignedIn", "saveDogName", "", "dogId", "signInUserIfNeeded", "Lio/reactivex/Completable;", "updateOrCreateDog", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private final p1 a;
    private final h2 b;
    private final p2 c;
    private final g2 d;
    private final o3 e;
    private final j2 f;
    private final h0 g;
    private final x<y<DogProfile>> h;
    private final a<Boolean> i;
    private final x<String> j;
    private final CoroutineExceptionHandler k;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.dogcreation.m.e a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.dogcreation.m.e e2) {
            this.a = e2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.q().postValue(aVar);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.name.DogCreationNameViewModel", f = "DogCreationNameViewModel.kt", l = 59, m = "updateOrCreateDog")
    static final class c extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.dogcreation.m.e this$0;
        c(app.dogo.com.dogo_android.dogcreation.m.e e, d<? super app.dogo.com.dogo_android.dogcreation.m.e.c> d2) {
            this.this$0 = e;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return e.n(this.this$0, i2, i2, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.name.DogCreationNameViewModel$saveDogName$1", f = "DogCreationNameViewModel.kt", l = 49, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final String $dogId;
        final String $name;
        int label;
        final app.dogo.com.dogo_android.dogcreation.m.e this$0;
        a(app.dogo.com.dogo_android.dogcreation.m.e e, String string2, String string3, d<? super app.dogo.com.dogo_android.dogcreation.m.e.a> d4) {
            this.this$0 = e;
            this.$dogId = string2;
            this.$name = string3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (e.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            e.a obj4 = new e.a(this.this$0, this.$dogId, this.$name, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            y.c unknownHostException;
            String $name;
            a obj5;
            aVar = b.d();
            unknownHostException = this.label;
            final int i2 = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i2) {
                } else {
                    q.b(object);
                    e.j(this.this$0).U0(false);
                    unknownHostException = new y.c((DogProfile)obj5);
                    this.this$0.q().postValue(unknownHostException);
                    this.this$0.o().postValue(b.a(i2));
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            if (!obj5 instanceof y.b) {
                this.this$0.q().postValue(y.b.a);
                if (!e.h(this.this$0).a()) {
                    e.k(this.this$0).s("dog_creation_name");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.q().postValue(aVar);
                } else {
                    this.label = i2;
                    if (e.n(this.this$0, this.$dogId, this.$name, this) == aVar) {
                        return aVar;
                    }
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.name.DogCreationNameViewModel$updateOrCreateDog$2", f = "DogCreationNameViewModel.kt", l = 62, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super DogProfile>, Object> {

        final String $dogId;
        final String $name;
        int label;
        final app.dogo.com.dogo_android.dogcreation.m.e this$0;
        d(app.dogo.com.dogo_android.dogcreation.m.e e, String string2, String string3, d<? super app.dogo.com.dogo_android.dogcreation.m.e.d> d4) {
            this.this$0 = e;
            this.$dogId = string2;
            this.$name = string3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super DogProfile> d2) {
            return (e.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            e.d obj4 = new e.d(this.this$0, this.$dogId, this.$name, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String $dogId2;
            int $dogId;
            String $name;
            Object obj5;
            Object obj = b.d();
            $dogId = this.label;
            final int i = 1;
            if ($dogId != 0) {
                if ($dogId != i) {
                } else {
                    q.b(object);
                    n.d(e.l(this.this$0).H().k(this.$dogId));
                    return obj5;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            e.m(this.this$0).e();
            if (this.$dogId != null) {
                this.label = i;
                if (e.i(this.this$0).k(this.$dogId, this.$name, this) == obj) {
                    return obj;
                }
            } else {
                obj5 = e.l(this.this$0).c(this.$name).blockingGet();
            }
        }
    }
    public e(p1 p1, h2 h22, p2 p23, g2 g24, o3 o35, j2 j26, h0 h07) {
        n.f(p1, "userRepository");
        n.f(h22, "authService");
        n.f(p23, "preferenceService");
        n.f(g24, "dogUpdateInteractor");
        n.f(o35, "tracker");
        n.f(j26, "connectivityService");
        n.f(h07, "dispatcher");
        super();
        this.a = p1;
        this.b = h22;
        this.c = p23;
        this.d = g24;
        this.e = o35;
        this.f = j26;
        this.g = h07;
        x obj2 = new x();
        this.h = obj2;
        obj2 = new a();
        this.i = obj2;
        obj2 = new x("");
        this.j = obj2;
        e.b obj3 = new e.b(CoroutineExceptionHandler.r, this);
        this.k = obj3;
    }

    public e(p1 p1, h2 h22, p2 p23, g2 g24, o3 o35, j2 j26, h0 h07, int i8, g g9) {
        h0 i;
        h0 h0Var;
        if (i8 & 64 != 0) {
            h0Var = i;
        } else {
            h0Var = h07;
        }
        super(p1, h22, p23, g24, o35, j26, h0Var);
    }

    public static final j2 h(app.dogo.com.dogo_android.dogcreation.m.e e) {
        return e.f;
    }

    public static final g2 i(app.dogo.com.dogo_android.dogcreation.m.e e) {
        return e.d;
    }

    public static final p2 j(app.dogo.com.dogo_android.dogcreation.m.e e) {
        return e.c;
    }

    public static final o3 k(app.dogo.com.dogo_android.dogcreation.m.e e) {
        return e.e;
    }

    public static final p1 l(app.dogo.com.dogo_android.dogcreation.m.e e) {
        return e.a;
    }

    public static final b m(app.dogo.com.dogo_android.dogcreation.m.e e) {
        return e.t();
    }

    public static final Object n(app.dogo.com.dogo_android.dogcreation.m.e e, String string2, String string3, d d4) {
        return e.u(string2, string3, d4);
    }

    private final b t() {
        int i;
        b ignoreElement;
        String str;
        int i2 = 0;
        i = this.b.v().length() == 0 ? 1 : i2;
        if (i != 0) {
            n.e(this.b.c(i2).ignoreElement(), "{\n            authService.anonymousSignInSingle(false).ignoreElement()\n        }");
        } else {
            n.e(b.f(), "{\n            Completable.complete()\n        }");
        }
        return ignoreElement;
    }

    private final Object u(String string, String string2, d<? super DogProfile> d3) {
        boolean cVar;
        int label;
        int i3;
        int dVar;
        int i2;
        int i;
        Object obj8;
        cVar = d3;
        label = cVar.label;
        i3 = Integer.MIN_VALUE;
        if (d3 instanceof e.c && label & i3 != 0) {
            cVar = d3;
            label = cVar.label;
            i3 = Integer.MIN_VALUE;
            if (label & i3 != 0) {
                cVar.label = label -= i3;
            } else {
                cVar = new e.c(this, d3);
            }
        } else {
        }
        obj8 = cVar.result;
        Object obj = b.d();
        dVar = cVar.label;
        int i4 = 1;
        if (dVar != 0) {
            if (dVar != i4) {
            } else {
                q.b(obj8);
                n.e(obj8, "private suspend fun updateOrCreateDog(dogId: String?, name: String): DogProfile {\n        return withContext(dispatcher) {\n            signInUserIfNeeded().blockingAwait()\n            if (dogId != null) {\n                dogUpdateInteractor.updateName(dogId, name)\n                userRepository.tempUserCache.getDogProfile(dogId)!!\n            } else {\n                userRepository.addNewDog(name).blockingGet()\n            }\n        }\n    }");
                return obj8;
            }
            IllegalStateException obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj8);
        dVar = new e.d(this, string, string2, 0);
        cVar.label = i4;
        if (k.e(this.g, dVar, cVar) == obj) {
            return obj;
        }
    }

    public final a<Boolean> o() {
        return this.i;
    }

    public final x<String> p() {
        return this.j;
    }

    public final x<y<DogProfile>> q() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r(String string) {
        int i2;
        int i;
        Object obj4;
        n.f(string, "name");
        final int i3 = 0;
        i2 = string.length() > 0 ? i : i3;
        if (i2 != 0 && string.length() <= 21) {
            if (string.length() <= 21) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(String string, String string2) {
        n.f(string2, "name");
        e.a aVar = new e.a(this, string, string2, 0);
        k.d(f0.a(this), this.k, 0, aVar, 2, 0);
    }
}
