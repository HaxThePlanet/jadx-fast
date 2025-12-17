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
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "loadList", "", "trackComingSoonProgramOpened", "programId", "", "trackContactUsClicked", "trackProgramOpen", "trackRecommendedProgramOpened", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends s {

    private final w2 a;
    private final o3 b;
    private final j2 c;
    private final x<y<List<ProgramDescriptionItem>>> d;
    private final CoroutineExceptionHandler e;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.y.y.h a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.y.y.h h2) {
            this.a = h2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.k().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programList.ProgramListViewModel$loadList$1", f = "ProgramListViewModel.kt", l = 37, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.y.y.h this$0;
        a(app.dogo.com.dogo_android.y.y.h h, d<? super app.dogo.com.dogo_android.y.y.h.a> d2) {
            this.this$0 = h;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (h.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            h.a obj2 = new h.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            Object unknownHostException;
            int label;
            int i;
            Object obj5;
            Object obj = b.d();
            label = this.label;
            final int i2 = 1;
            if (label != 0) {
                if (label != i2) {
                } else {
                    q.b(object);
                    unknownHostException = new y.c((List)obj5);
                    this.this$0.k().postValue(unknownHostException);
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            this.this$0.k().postValue(y.b.a);
            if (!h.h(this.this$0).a()) {
                h.j(this.this$0).s("program_list");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                this.this$0.k().postValue(aVar);
            } else {
                this.label = i2;
                if (w2.f(h.i(this.this$0), false, this, i2, 0) == obj) {
                    return obj;
                }
            }
        }
    }
    public h(w2 w2, o3 o32, j2 j23) {
        n.f(w2, "interactor");
        n.f(o32, "tracker");
        n.f(j23, "connectivityService");
        super();
        this.a = w2;
        this.b = o32;
        this.c = j23;
        x obj2 = new x();
        this.d = obj2;
        h.b obj3 = new h.b(CoroutineExceptionHandler.r, this);
        this.e = obj3;
    }

    public static final j2 h(app.dogo.com.dogo_android.y.y.h h) {
        return h.c;
    }

    public static final w2 i(app.dogo.com.dogo_android.y.y.h h) {
        return h.a;
    }

    public static final o3 j(app.dogo.com.dogo_android.y.y.h h) {
        return h.b;
    }

    public final x<y<List<ProgramDescriptionItem>>> k() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void l() {
        final int i = 0;
        h.a aVar = new h.a(this, i);
        k.d(f0.a(this), this.e, i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m(String string) {
        n.f(string, "programId");
        e2 e2Var = new e2();
        this.b.d(q0.p.c(e2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String string) {
        n.f(string, "programId");
        e2 e2Var = new e2();
        this.b.d(q0.h.c(e2Var, string));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o(String string) {
        n.f(string, "programId");
        e2 e2Var = new e2();
        this.b.d(q0.o.c(e2Var, string));
    }
}
