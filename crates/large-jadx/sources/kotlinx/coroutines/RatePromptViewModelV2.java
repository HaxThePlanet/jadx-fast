package app.dogo.com.dogo_android.a0;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.w.j0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.play.core.review.ReviewInfo;
import kotlin.Metadata;
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

/* compiled from: RatePromptViewModelV2.kt */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0018R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u001f¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/RatePromptViewModelV2;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "source", "", "inAppRateRepository", "Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "remote", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getCoroutineExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "onDismiss", "Lcom/hadilq/liveevent/LiveEvent;", "getOnDismiss", "()Lcom/hadilq/liveevent/LiveEvent;", "onReviewInfo", "Lcom/google/android/play/core/review/ReviewInfo;", "getOnReviewInfo", "onShowPlayStore", "getOnShowPlayStore", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "getSource", "()Ljava/lang/String;", "cancel", "", "rateIt", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class RatePromptViewModelV2 extends s {

    private final String a;
    /* renamed from: b, reason: from kotlin metadata */
    private final c inAppRateRepository;
    private final o3 c;
    private final k1 d;
    private final app.dogo.com.dogo_android.service.r2 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> rateRepository = new a<>();
    /* renamed from: g, reason: from kotlin metadata */
    private final f.d.a.a<ReviewInfo> remote = new a<>();
    private final f.d.a.a<Boolean> h = new a<>();
    private final x<y<Boolean>> i = new x<>();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.a exc) {
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            a.d(exception);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.RatePromptViewModelV2$rateIt$1", f = "RatePromptViewModelV2.kt", l = 47, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            Object obj2;
            Object obj3 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    obj.postValue(obj2);
                    return w.a;
                }
            }
            q.b(object);
            f.d.a.a object2 = d.this.l();
            this.L$0 = object2;
            this.label = i;
            obj2 = d.this.inAppRateRepository.g(this);
            if (obj2 == obj3) {
                return obj3;
            }
        }

        a(d<? super d.a> dVar) {
            super(2, dVar2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.d.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.d.a(d.this, dVar);
        }
    }
    public d(String str, c cVar, o3 o3Var, k1 k1Var, app.dogo.com.dogo_android.service.r2 r2Var) {
        n.f(str, "source");
        n.f(cVar, "inAppRateRepository");
        n.f(o3Var, "tracker");
        n.f(k1Var, "rateRepository");
        n.f(r2Var, "remote");
        super();
        this.a = str;
        this.inAppRateRepository = cVar;
        this.c = o3Var;
        this.d = k1Var;
        this.e = r2Var;
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
        f.d.a.a aVar3 = new a();
        o3Var.logEvent(E_RateDialog.d.c(new EP_ViewSource(), str));
        k1Var.d(str);
        final x xVar = new x();
    }

    public static final /* synthetic */ c h(d dVar) {
        return dVar.inAppRateRepository;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final CoroutineExceptionHandler cancel() {
        return new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        this.c.logEvent(E_RateDialog.c.c(new EP_ViewSource(), this.a));
        this.rateRepository.postValue(Boolean.TRUE);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> k() {
        return this.rateRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<ReviewInfo> l() {
        return this.remote;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> m() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        this.c.logEvent(E_RateDialog.b.c(new EP_ViewSource(), this.a));
        this.d.g();
        if (this.e.C()) {
            kotlinx.coroutines.o0 o0Var = null;
            d dVar = null;
            int i = 2;
            Object obj = null;
            kotlinx.coroutines.internal.k.d(f0.a(this), cancel(), o0Var, new kotlinx.coroutines.d.a(this, dVar), i, obj);
        } else {
            this.h.postValue(Boolean.TRUE);
        }
    }
}
