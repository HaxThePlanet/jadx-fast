package app.dogo.com.dogo_android.y.y;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.s.a.w2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.u2;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: ProgramListViewModel.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "loadList", "", "trackComingSoonProgramOpened", "programId", "", "trackContactUsClicked", "trackProgramOpen", "trackRecommendedProgramOpened", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class ProgramListViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final w2 connectivityService;
    private final o3 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final j2 interactor;
    private final x<y<List<ProgramDescriptionItem>>> d = new x<>();
    /* renamed from: e, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new h$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final /* synthetic */ h a;
        public b(CoroutineExceptionHandler.a exc, h hVar) {
            this.a = hVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.loadList().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programList.ProgramListViewModel$loadList$1", f = "ProgramListViewModel.kt", l = 37, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj = null;
            Object obj2;
            Object obj3 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    h.this.loadList().postValue(new LoadResult_Success((List)obj2));
                    return w.a;
                }
            }
            q.b(object);
            h.this.loadList().postValue(LoadResult_Loading.a);
            if (h.this.interactor.getActiveNetworkType()) {
                obj = null;
                this.label = i;
                if (GetProgramListInteractor.f(h.this.connectivityService, false, this, i, obj) == obj3) {
                    return obj3;
                }
            } else {
                h.this.b.setTrainingReminderUserProperties("program_list");
                h.this.loadList().postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        a(d<? super h.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.h.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.h.a(h.this, dVar);
        }
    }
    public h(w2 w2Var, o3 o3Var, j2 j2Var) {
        n.f(w2Var, "interactor");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.connectivityService = w2Var;
        this.b = o3Var;
        this.interactor = j2Var;
        x xVar = new x();
        final app.dogo.com.dogo_android.y.y.h.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 trackComingSoonProgramOpened(h programId) {
        return programId.interactor;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ w2 trackProgramOpen(h programId) {
        return programId.connectivityService;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ o3 trackRecommendedProgramOpened(h programId) {
        return programId.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final x<y<List<ProgramDescriptionItem>>> loadList() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, dVar, new kotlinx.coroutines.h.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m(String str) {
        n.f(str, "programId");
        this.b.logEvent(E_TrainingProgram.p.c(new EP_ProgramId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String str) {
        n.f(str, "programId");
        this.b.logEvent(E_TrainingProgram.h.c(new EP_ProgramId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o(String str) {
        n.f(str, "programId");
        this.b.logEvent(E_TrainingProgram.o.c(new EP_ProgramId(), str));
    }
}
