package app.dogo.com.dogo_android.u.m;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.v2;
import app.dogo.com.dogo_android.y.k.a;
import app.dogo.externalmodel.model.BitingProgressModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: VariationsUnlockedViewModel.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00160\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "dispatchers", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "getTrickItem", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "loadData", "", "trackVariationTapped", "variationId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x, reason: from kotlin metadata */
public final class VariationsUnlockedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final TrickItem dispatchers;
    private final o3 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final o1 programRepository;
    private final p1 d;
    /* renamed from: e, reason: from kotlin metadata */
    private final j1 tracker;
    private final h0 f;
    /* renamed from: g, reason: from kotlin metadata */
    private final x<y<List<TrickItem>>> tricksRepository;
    /* renamed from: h, reason: from kotlin metadata */
    private final CoroutineExceptionHandler userRepository;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final /* synthetic */ x a;
        public b(CoroutineExceptionHandler.a exc, x xVar) {
            this.a = xVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.loadData().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.biting.VariationsUnlockedViewModel$loadData$1", f = "VariationsUnlockedViewModel.kt", l = {38, 39, 40}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            java.util.Map object2;
            int label2;
            Object obj2;
            String str3;
            e.a.a.a.b.d.g gVar;
            Object obj3 = b.d();
            final int i2 = 3;
            int i = 2;
            final Integer num = null;
            final int i3 = 1;
            if (this.label != 0) {
                if (this.label != i3) {
                    if (this.label != i) {
                        if (this.label != i2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(object);
                            x.this.loadData().postValue(new LoadResult_Success(app.dogo.com.dogo_android.util.extensionfunction.m1.G((TrickFullEntity)gVar, num, object2, i3, num).getVariations()));
                            return w.a;
                        }
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    this.label = i;
                    if (x.this.tracker.q((String)str3, this) == obj3) {
                        return obj3;
                    }
                }
            } else {
                q.b(object);
                this.label = i3;
                if (x.this.d.u(this) == obj3) {
                    return obj3;
                }
            }
            BitingProgressModel bitingProgressModel = (DogoProgram_BitingProgram)obj2.c();
            if (bitingProgressModel == null) {
                int i4 = num;
            } else {
                object2 = bitingProgressModel.getTrickVariationKnowledgeMap(x.this.l().getId());
            }
            if (w.a == null) {
                object2 = j0.h();
            }
            this.L$0 = object2;
            this.label = i2;
            Object obj = x.this.programRepository.o(x.this.l().getId(), this);
            if (obj == obj3) {
                return obj3;
            }
        }

        a(d<? super x.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.specialprograms.biting.x.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.specialprograms.biting.x.a(x.this, dVar);
        }
    }
    public /* synthetic */ x(TrickItem trickItem, o3 o3Var, o1 o1Var, p1 p1Var, j1 j1Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var62;
        if (i & 32 != 0) {
            h0Var62 = Dispatchers.b();
        }
        this(trickItem, o3Var, o1Var, p1Var, j1Var, h0Var62);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j1 trackVariationTapped(x variationId) {
        return variationId.tracker;
    }

    public static final /* synthetic */ o1 i(x xVar) {
        return xVar.programRepository;
    }

    public static final /* synthetic */ p1 j(x xVar) {
        return xVar.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final x<y<List<TrickItem>>> loadData() {
        return this.tricksRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem l() {
        return this.dispatchers;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.f.plus(this.userRepository), dVar, new app.dogo.com.dogo_android.specialprograms.biting.x.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String str) {
        n.f(str, "variationId");
        this.b.logEvent(E_BitingProgram.c.withParameters(u.a(new EP_ViewSource(), "variations_unlocked"), u.a(new EP_TrickId(), str)));
    }

    public x(TrickItem trickItem, o3 o3Var, o1 o1Var, p1 p1Var, j1 j1Var, h0 h0Var) {
        n.f(trickItem, "trickItem");
        n.f(o3Var, "tracker");
        n.f(o1Var, "tricksRepository");
        n.f(p1Var, "userRepository");
        n.f(j1Var, "programRepository");
        n.f(h0Var, "dispatchers");
        super();
        this.dispatchers = trickItem;
        this.b = o3Var;
        this.programRepository = o1Var;
        this.d = p1Var;
        this.tracker = j1Var;
        this.f = h0Var;
        this.tricksRepository = new x();
        this.userRepository = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }
}
