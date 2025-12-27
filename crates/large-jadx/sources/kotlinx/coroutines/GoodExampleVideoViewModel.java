package app.dogo.com.dogo_android.m;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;
import app.dogo.com.dogo_android.s.a.b3;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.c0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: GoodExampleVideoViewModel.kt */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020$R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R#\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/GoodExampleVideoViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trickId", "", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetTrickVideoGoodExamplesInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;Lapp/dogo/com/dogo_android/repository/interactor/GetTrickVideoGoodExamplesInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "emptyEvent", "Lcom/hadilq/liveevent/LiveEvent;", "", "onEmpty", "Landroidx/lifecycle/LiveData;", "getOnEmpty", "()Landroidx/lifecycle/LiveData;", "onError", "", "getOnError", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "getTrickId", "()Ljava/lang/String;", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "loadList", "", "retry", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class GoodExampleVideoViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final String connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final c0 emptyEvent;
    /* renamed from: c, reason: from kotlin metadata */
    private final b3 interactor;
    private final o3 d;
    private final j2 e;
    private final x<y<List<GoodTrickExample>>> f = new x<>();
    /* renamed from: g, reason: from kotlin metadata */
    private final f.d.a.a<Throwable> tracker = new a<>();
    private final f.d.a.a<Boolean> h = new a<>();
    private final LiveData<Boolean> i = new a<>();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ b a;
        public a(CoroutineExceptionHandler.a exc, b bVar) {
            this.a = bVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            a.d(exception);
            this.a.n().postValue(new LoadResult_Error(exception));
            this.a.m().postValue(exception);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.goodexamples.GoodExampleVideoViewModel$loadList$1", f = "GoodExampleVideoViewModel.kt", l = 52, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label2;
            Object obj;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    if (obj.isEmpty()) {
                        b.this.h.postValue(b.a(true));
                    } else {
                        b.this.n().postValue(new LoadResult_Success(obj));
                    }
                    return w.a;
                }
            }
            q.b(object);
            b.this.n().postValue(LoadResult_Loading.a);
            if (b.this.e.getActiveNetworkType()) {
                this.label = i;
                if (b.this.interactor.b(b.this.o(), this) == obj2) {
                    return obj2;
                }
            } else {
                b.this.d.setTrainingReminderUserProperties("good_example_video");
                b.this.n().postValue(new LoadResult_Error(new UnknownHostException()));
                b.this.m().postValue(new UnknownHostException());
            }
        }

        b(d<? super b.b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.b.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.b.b(b.this, dVar);
        }
    }
    public b(String str, c0 c0Var, b3 b3Var, o3 o3Var, j2 j2Var) {
        n.f(str, "trickId");
        n.f(c0Var, "videoPlayerFactory");
        n.f(b3Var, "interactor");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.connectivityService = str;
        this.emptyEvent = c0Var;
        this.interactor = b3Var;
        this.d = o3Var;
        this.e = j2Var;
        x xVar = new x();
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
        loadList();
    }

    public static final /* synthetic */ j2 h(b bVar) {
        return bVar.e;
    }

    public static final /* synthetic */ f.d.a.a i(b bVar) {
        return bVar.h;
    }

    public static final /* synthetic */ b3 j(b bVar) {
        return bVar.interactor;
    }

    public static final /* synthetic */ o3 k(b bVar) {
        return bVar.d;
    }

    /* renamed from: q, reason: from kotlin metadata */
    private final void loadList() {
        kotlinx.coroutines.internal.k.d(f0.a(this), new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this), null, new kotlinx.coroutines.b.b(this, null), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<Boolean> l() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Throwable> m() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<List<GoodTrickExample>>> n() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String o() {
        return this.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final c0 p() {
        return this.emptyEvent;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        loadList();
    }
}
