package app.dogo.com.dogo_android.a0;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.w.j0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.play.core.review.ReviewInfo;
import f.d.a.a;
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
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0018R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/RatePromptViewModelV2;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "source", "", "inAppRateRepository", "Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "remote", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getCoroutineExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "onDismiss", "Lcom/hadilq/liveevent/LiveEvent;", "getOnDismiss", "()Lcom/hadilq/liveevent/LiveEvent;", "onReviewInfo", "Lcom/google/android/play/core/review/ReviewInfo;", "getOnReviewInfo", "onShowPlayStore", "getOnShowPlayStore", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "getSource", "()Ljava/lang/String;", "cancel", "", "rateIt", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends s {

    private final String a;
    private final app.dogo.com.dogo_android.a0.c b;
    private final o3 c;
    private final k1 d;
    private final r2 e;
    private final a<Boolean> f;
    private final a<ReviewInfo> g;
    private final a<Boolean> h;
    private final x<y<Boolean>> i;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a) {
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            a.d(throwable2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.RatePromptViewModelV2$rateIt$1", f = "RatePromptViewModelV2.kt", l = 47, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        Object L$0;
        int label;
        final app.dogo.com.dogo_android.a0.d this$0;
        a(app.dogo.com.dogo_android.a0.d d, d<? super app.dogo.com.dogo_android.a0.d.a> d2) {
            this.this$0 = d;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (d.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            d.a obj2 = new d.a(this.this$0, d2);
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
            Object obj4;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    l$0 = this.L$0;
                    q.b(object);
                    l$0.postValue(obj4);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            obj4 = this.this$0.l();
            this.L$0 = obj4;
            this.label = i;
            label = d.h(this.this$0).g(this);
            if (label == obj) {
                return obj;
            }
            l$0 = obj4;
            obj4 = label;
        }
    }
    public d(String string, app.dogo.com.dogo_android.a0.c c2, o3 o33, k1 k14, r2 r25) {
        n.f(string, "source");
        n.f(c2, "inAppRateRepository");
        n.f(o33, "tracker");
        n.f(k14, "rateRepository");
        n.f(r25, "remote");
        super();
        this.a = string;
        this.b = c2;
        this.c = o33;
        this.d = k14;
        this.e = r25;
        a obj3 = new a();
        this.f = obj3;
        obj3 = new a();
        this.g = obj3;
        obj3 = new a();
        this.h = obj3;
        r2 obj6 = new r2();
        o33.d(j0.d.c(obj6, string));
        k14.d(string);
        x obj2 = new x();
        this.i = obj2;
    }

    public static final app.dogo.com.dogo_android.a0.c h(app.dogo.com.dogo_android.a0.d d) {
        return d.b;
    }

    private final CoroutineExceptionHandler j() {
        d.b bVar = new d.b(CoroutineExceptionHandler.r);
        return bVar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        r2 r2Var = new r2();
        this.c.d(j0.c.c(r2Var, this.a));
        this.f.postValue(Boolean.TRUE);
    }

    public final a<Boolean> k() {
        return this.f;
    }

    public final a<ReviewInfo> l() {
        return this.g;
    }

    public final a<Boolean> m() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        int i2;
        Object tRUE;
        Object r2Var;
        int str;
        app.dogo.com.dogo_android.a0.d.a aVar;
        int i3;
        int i;
        r2Var = new r2();
        this.c.d(j0.b.c(r2Var, this.a));
        this.d.g();
        if (this.e.C()) {
            aVar = new d.a(this, 0);
            k.d(f0.a(this), j(), 0, aVar, 2, 0);
        } else {
            this.h.postValue(Boolean.TRUE);
        }
    }
}
