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
import i.b.a0;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: SimpleTrickListViewModel.kt */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020&J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0002R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u00160\u00150\"¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/simpleTricks/SimpleTrickListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "getLibraryTrickListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "shouldShowWorkoutUnlockedInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "onError", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnError", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "shouldShowWorkoutUnlocked", "", "getShouldShowWorkoutUnlocked", "getWorkoutUnlockSourceBlocking", "dogId", "loadList", "", "retry", "trackTrickTapped", "trickId", "triggerWorkoutUnlockIfNeeded", "trickListData", "Lapp/dogo/com/dogo_android/repository/domain/TrickListData;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class SimpleTrickListViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final q2 connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final l3 dispatcher;
    /* renamed from: c, reason: from kotlin metadata */
    private final r3 dogLocalEntityDao;
    /* renamed from: d, reason: from kotlin metadata */
    private final p1 getLibraryTrickListInteractor;
    private final o3 e;
    private final e.a.a.a.b.b.w f;
    private final j2 g;
    private final h0 h;
    /* renamed from: i, reason: from kotlin metadata */
    private final x<y<List<TrickItem>>> shouldShowWorkoutUnlockedInteractor;
    /* renamed from: j, reason: from kotlin metadata */
    private final LiveData<y<List<TrickItem>>> tracker;
    /* renamed from: k, reason: from kotlin metadata */
    private final f.d.a.a<String> userRepository;
    /* renamed from: l, reason: from kotlin metadata */
    private final CoroutineExceptionHandler workoutSessionInteractor;
    private final f.d.a.a<Throwable> m;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ e a;
        public b(CoroutineExceptionHandler.a exc, e eVar) {
            this.a = eVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.loadList().postValue(exception);
            this.a.shouldShowWorkoutUnlockedInteractor.postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dailyworkout.simpleTricks.SimpleTrickListViewModel$loadList$1", f = "SimpleTrickListViewModel.kt", l = {57, 58}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super kotlin.w>, Object> {

        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            List list;
            Object object2;
            Object obj2;
            Object blockingGet;
            Object obj = b.d();
            int i = 2;
            int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    if (this.label != i) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(object);
                        try {
                            e.this.dogLocalEntityDao.O().e();
                            blockingGet = e.this.dispatcher.d().blockingGet();
                        } catch (Exception e) {
                            a.d(e);
                            e = null;
                            e = b.a(e);
                        }
                        n.e(blockingGet, "shouldShowWorkoutUnlocked");
                        int i3 = 2;
                        kotlin.d0.d.g gVar = null;
                        TrickListData trickListData = new TrickListData((String)obj2, null, list, blockingGet.booleanValue(), i3, gVar);
                        List trickList = trickListData.getTrickList();
                        n.d(trickList);
                        e.this.shouldShowWorkoutUnlockedInteractor.postValue(new LoadResult_Success(trickList));
                        e.this.v(trickListData);
                    }
                }
                q.b(e);
                this.L$0 = object2;
                this.label = i;
                obj2 = e.this.getLibraryTrickListInteractor.u(this);
                if (obj2 == obj) {
                    return obj;
                }
            } else {
                q.b(e);
                e.this.shouldShowWorkoutUnlockedInteractor.postValue(LoadResult_Loading.a);
                if (e.this.g.a()) {
                    this.label = i2;
                    if (e.this.connectivityService.k(this) == obj) {
                        return obj;
                    }
                } else {
                    e.this.e.s("simple_trick_list");
                    e.this.loadList().postValue(new UnknownHostException());
                    e.this.shouldShowWorkoutUnlockedInteractor.postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
            return w.a;
        }

        a(d<? super e.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super kotlin.w> dVar) {
            return (kotlinx.coroutines.e.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<kotlin.w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.e.a(e.this, dVar);
        }
    }
    public /* synthetic */ e(q2 q2Var, l3 l3Var, r3 r3Var, p1 p1Var, o3 o3Var, e.a.a.a.b.b.w wVar, j2 j2Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var82;
        h0Var82 = i & 128 != 0 ? h0Var82 : h0Var;
        this(q2Var, l3Var, r3Var, p1Var, o3Var, wVar, j2Var, h0Var82);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 getWorkoutUnlockSourceBlocking(e dogId) {
        return dogId.g;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ q2 trackTrickTapped(e trickId) {
        return trickId.connectivityService;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ l3 triggerWorkoutUnlockIfNeeded(e trickListData) {
        return trickListData.dispatcher;
    }

    public static final /* synthetic */ o3 k(e eVar) {
        return eVar.e;
    }

    public static final /* synthetic */ p1 l(e eVar) {
        return eVar.getLibraryTrickListInteractor;
    }

    public static final /* synthetic */ r3 m(e eVar) {
        return eVar.dogLocalEntityDao;
    }

    public static final /* synthetic */ x n(e eVar) {
        return eVar.shouldShowWorkoutUnlockedInteractor;
    }

    public static final /* synthetic */ void o(e eVar, TrickListData list) {
        eVar.v(list);
    }

    private final void v(TrickListData list) {
        if (list.getShouldShowWorkoutUnlocked()) {
            this.userRepository.postValue(list.getDogId());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<List<TrickItem>>> getResult() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: p, reason: from kotlin metadata */
    public final f.d.a.a<Throwable> loadList() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<String> q() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String r(String str) {
        Object blockingGet;
        n.f(str, "dogId");
        blockingGet = this.f.getDogLocalEntityOrEmpty(str).blockingGet();
        n.e(blockingGet, "source");
        if (!l.z(blockingGet) == 0) {
            String str4 = "dashboard";
        }
        return blockingGet;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.workoutSessionInteractor.plus(this.h), dVar, new kotlinx.coroutines.e.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        s();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String str) {
        n.f(str, "trickId");
        this.e.logEvent(E_Library.d.c(new EP_TrickId(), str));
    }

    public e(q2 q2Var, l3 l3Var, r3 r3Var, p1 p1Var, o3 o3Var, e.a.a.a.b.b.w wVar, j2 j2Var, h0 h0Var) {
        n.f(q2Var, "getLibraryTrickListInteractor");
        n.f(l3Var, "shouldShowWorkoutUnlockedInteractor");
        n.f(r3Var, "workoutSessionInteractor");
        n.f(p1Var, "userRepository");
        n.f(o3Var, "tracker");
        n.f(wVar, "dogLocalEntityDao");
        n.f(j2Var, "connectivityService");
        n.f(h0Var, "dispatcher");
        super();
        this.connectivityService = q2Var;
        this.dispatcher = l3Var;
        this.dogLocalEntityDao = r3Var;
        this.getLibraryTrickListInteractor = p1Var;
        this.e = o3Var;
        this.f = wVar;
        this.g = j2Var;
        this.h = h0Var;
        x xVar = new x();
        this.shouldShowWorkoutUnlockedInteractor = xVar;
        this.tracker = xVar;
        this.userRepository = new a();
        this.workoutSessionInteractor = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
        this.m = new a();
    }
}
