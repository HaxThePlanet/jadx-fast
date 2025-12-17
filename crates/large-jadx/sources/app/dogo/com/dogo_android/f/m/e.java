package app.dogo.com.dogo_android.f.m;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickListData;
import app.dogo.com.dogo_android.s.a.l3;
import app.dogo.com.dogo_android.s.a.q2;
import app.dogo.com.dogo_android.s.a.r3;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.d0;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import e.a.a.a.b.b.w;
import f.d.a.a;
import i.b.a0;
import i.b.b;
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
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020&J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0002R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u00160\u00150\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/simpleTricks/SimpleTrickListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "getLibraryTrickListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "shouldShowWorkoutUnlockedInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "onError", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnError", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "shouldShowWorkoutUnlocked", "", "getShouldShowWorkoutUnlocked", "getWorkoutUnlockSourceBlocking", "dogId", "loadList", "", "retry", "trackTrickTapped", "trickId", "triggerWorkoutUnlockIfNeeded", "trickListData", "Lapp/dogo/com/dogo_android/repository/domain/TrickListData;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private final q2 a;
    private final l3 b;
    private final r3 c;
    private final p1 d;
    private final o3 e;
    private final w f;
    private final j2 g;
    private final h0 h;
    private final x<y<List<TrickItem>>> i;
    private final LiveData<y<List<TrickItem>>> j;
    private final a<String> k;
    private final CoroutineExceptionHandler l;
    private final a<Throwable> m;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.f.m.e a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.f.m.e e2) {
            this.a = e2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            this.a.p().postValue(throwable2);
            y.a aVar = new y.a(throwable2);
            e.n(this.a).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dailyworkout.simpleTricks.SimpleTrickListViewModel$loadList$1", f = "SimpleTrickListViewModel.kt", l = {57, 58}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        Object L$0;
        int label;
        final app.dogo.com.dogo_android.f.m.e this$0;
        a(app.dogo.com.dogo_android.f.m.e e, d<? super app.dogo.com.dogo_android.f.m.e.a> d2) {
            this.this$0 = e;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (e.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            e.a obj2 = new e.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            y aVar;
            y.b label;
            Object unknownHostException;
            int i3;
            Object i4;
            boolean booleanValue;
            int i;
            int i2;
            TrickListData trickListData;
            Object obj9;
            l$0 = b.d();
            label = this.label;
            i3 = 2;
            i4 = 1;
            if (label != 0) {
                if (label != i4) {
                    if (label != i3) {
                    } else {
                        q.b(object);
                        i4 = l$0;
                        e.m(this.this$0).O().e();
                        obj9 = e.j(this.this$0).d().blockingGet();
                        n.e(obj9, "shouldShowWorkoutUnlocked");
                        super((String)obj9, 0, i4, obj9.booleanValue(), 2, 0);
                        unknownHostException = trickListData.getTrickList();
                        n.d(unknownHostException);
                        aVar = new y.c(unknownHostException);
                        e.n(this.this$0).postValue(aVar);
                        e.o(this.this$0, trickListData);
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                q.b(object);
                this.L$0 = (List)obj9;
                this.label = i3;
                label = e.l(this.this$0).u(this);
                if (label == l$0) {
                    return l$0;
                }
                i4 = obj9;
                obj9 = label;
            } else {
                q.b(object);
                e.n(this.this$0).postValue(y.b.a);
                if (!e.h(this.this$0).a()) {
                    e.k(this.this$0).s("simple_trick_list");
                    UnknownHostException unknownHostException2 = new UnknownHostException();
                    this.this$0.p().postValue(unknownHostException2);
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    e.n(this.this$0).postValue(aVar);
                } else {
                    this.label = i4;
                    if (e.i(this.this$0).k(this) == l$0) {
                        return l$0;
                    }
                }
            }
            return w.a;
        }
    }
    public e(q2 q2, l3 l32, r3 r33, p1 p14, o3 o35, w w6, j2 j27, h0 h08) {
        n.f(q2, "getLibraryTrickListInteractor");
        n.f(l32, "shouldShowWorkoutUnlockedInteractor");
        n.f(r33, "workoutSessionInteractor");
        n.f(p14, "userRepository");
        n.f(o35, "tracker");
        n.f(w6, "dogLocalEntityDao");
        n.f(j27, "connectivityService");
        n.f(h08, "dispatcher");
        super();
        this.a = q2;
        this.b = l32;
        this.c = r33;
        this.d = p14;
        this.e = o35;
        this.f = w6;
        this.g = j27;
        this.h = h08;
        x obj2 = new x();
        this.i = obj2;
        this.j = obj2;
        obj2 = new a();
        this.k = obj2;
        e.b obj3 = new e.b(CoroutineExceptionHandler.r, this);
        this.l = obj3;
        obj2 = new a();
        this.m = obj2;
    }

    public e(q2 q2, l3 l32, r3 r33, p1 p14, o3 o35, w w6, j2 j27, h0 h08, int i9, g g10) {
        h0 i;
        h0 h0Var;
        if (i2 &= 128 != 0) {
            h0Var = i;
        } else {
            h0Var = h08;
        }
        super(q2, l32, r33, p14, o35, w6, j27, h0Var);
    }

    public static final j2 h(app.dogo.com.dogo_android.f.m.e e) {
        return e.g;
    }

    public static final q2 i(app.dogo.com.dogo_android.f.m.e e) {
        return e.a;
    }

    public static final l3 j(app.dogo.com.dogo_android.f.m.e e) {
        return e.b;
    }

    public static final o3 k(app.dogo.com.dogo_android.f.m.e e) {
        return e.e;
    }

    public static final p1 l(app.dogo.com.dogo_android.f.m.e e) {
        return e.d;
    }

    public static final r3 m(app.dogo.com.dogo_android.f.m.e e) {
        return e.c;
    }

    public static final x n(app.dogo.com.dogo_android.f.m.e e) {
        return e.i;
    }

    public static final void o(app.dogo.com.dogo_android.f.m.e e, TrickListData trickListData2) {
        e.v(trickListData2);
    }

    private final void v(TrickListData trickListData) {
        boolean shouldShowWorkoutUnlocked;
        String obj2;
        if (trickListData.getShouldShowWorkoutUnlocked()) {
            this.k.postValue(trickListData.getDogId());
        }
    }

    public final LiveData<y<List<TrickItem>>> getResult() {
        return this.j;
    }

    public final a<Throwable> p() {
        return this.m;
    }

    public final a<String> q() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String r(String string) {
        Object obj2;
        n.f(string, "dogId");
        obj2 = this.f.g(string).blockingGet();
        n.e((String)obj2, "source");
        if (z ^= 1 != 0) {
        } else {
            obj2 = "dashboard";
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        int i = 0;
        e.a aVar = new e.a(this, i);
        k.d(f0.a(this), this.l.plus(this.h), i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        s();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String string) {
        n.f(string, "trickId");
        n2 n2Var = new n2();
        this.e.d(d0.d.c(n2Var, string));
    }
}
