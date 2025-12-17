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
import app.dogo.com.dogo_android.w.q;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.v2;
import app.dogo.com.dogo_android.y.k.a;
import app.dogo.externalmodel.model.BitingProgressModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlin.y.j0;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00160\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "dispatchers", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "getTrickItem", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "loadData", "", "trackVariationTapped", "variationId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x extends s {

    private final TrickItem a;
    private final o3 b;
    private final o1 c;
    private final p1 d;
    private final j1 e;
    private final h0 f;
    private final x<y<List<TrickItem>>> g;
    private final CoroutineExceptionHandler h;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.u.m.x a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.u.m.x x2) {
            this.a = x2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.k().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.biting.VariationsUnlockedViewModel$loadData$1", f = "VariationsUnlockedViewModel.kt", l = {38, 39, 40}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        Object L$0;
        int label;
        final app.dogo.com.dogo_android.u.m.x this$0;
        a(app.dogo.com.dogo_android.u.m.x x, d<? super app.dogo.com.dogo_android.u.m.x.a> d2) {
            this.this$0 = x;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (x.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            x.a obj2 = new x.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            int label;
            int i;
            Object obj7;
            Object obj = b.d();
            label = this.label;
            final int i2 = 3;
            i = 2;
            final int i3 = 0;
            final int i4 = 1;
            if (label != 0) {
                if (label != i4) {
                    if (label != i) {
                        if (label != i2) {
                        } else {
                            l$0 = this.L$0;
                            q.b(object);
                            y.c cVar = new y.c(m1.G((g)obj7, i3, l$0, i4, i3).getVariations());
                            this.this$0.k().postValue(cVar);
                            return w.a;
                        }
                        obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj7;
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    this.label = i;
                    if (x.h(this.this$0).q((String)obj7, this) == obj) {
                        return obj;
                    }
                }
            } else {
                q.b(object);
                this.label = i4;
                if (x.j(this.this$0).u(this) == obj) {
                    return obj;
                }
            }
            obj7 = (k.a)obj7.c();
            if (obj7 == null) {
                obj7 = i3;
            } else {
                obj7 = obj7.getTrickVariationKnowledgeMap(this.this$0.l().getId());
            }
            if (obj7 != null) {
            } else {
                obj7 = j0.h();
            }
            this.L$0 = obj7;
            this.label = i2;
            label = x.i(this.this$0).o(this.this$0.l().getId(), this);
            if (label == obj) {
                return obj;
            }
            l$0 = obj7;
            obj7 = label;
        }
    }
    public x(TrickItem trickItem, o3 o32, o1 o13, p1 p14, j1 j15, h0 h06) {
        n.f(trickItem, "trickItem");
        n.f(o32, "tracker");
        n.f(o13, "tricksRepository");
        n.f(p14, "userRepository");
        n.f(j15, "programRepository");
        n.f(h06, "dispatchers");
        super();
        this.a = trickItem;
        this.b = o32;
        this.c = o13;
        this.d = p14;
        this.e = j15;
        this.f = h06;
        x obj2 = new x();
        this.g = obj2;
        x.b obj3 = new x.b(CoroutineExceptionHandler.r, this);
        this.h = obj3;
    }

    public x(TrickItem trickItem, o3 o32, o1 o13, p1 p14, j1 j15, h0 h06, int i7, g g8) {
        h0 obj13;
        if (i7 &= 32 != 0) {
            obj13 = c1.b();
        }
        super(trickItem, o32, o13, p14, j15, obj13);
    }

    public static final j1 h(app.dogo.com.dogo_android.u.m.x x) {
        return x.e;
    }

    public static final o1 i(app.dogo.com.dogo_android.u.m.x x) {
        return x.c;
    }

    public static final p1 j(app.dogo.com.dogo_android.u.m.x x) {
        return x.d;
    }

    public final x<y<List<TrickItem>>> k() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem l() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        int i = 0;
        x.a aVar = new x.a(this, i);
        k.d(f0.a(this), this.f.plus(this.h), i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String string) {
        n.f(string, "variationId");
        r2 r2Var = new r2();
        n2 n2Var = new n2();
        this.b.d(q.c.d(u.a(r2Var, "variations_unlocked"), u.a(n2Var, string)));
    }
}
