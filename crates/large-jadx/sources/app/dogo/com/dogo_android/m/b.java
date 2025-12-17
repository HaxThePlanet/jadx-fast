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
import f.d.a.a;
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
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020$R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R#\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/goodexamples/GoodExampleVideoViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "trickId", "", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetTrickVideoGoodExamplesInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;Lapp/dogo/com/dogo_android/repository/interactor/GetTrickVideoGoodExamplesInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "emptyEvent", "Lcom/hadilq/liveevent/LiveEvent;", "", "onEmpty", "Landroidx/lifecycle/LiveData;", "getOnEmpty", "()Landroidx/lifecycle/LiveData;", "onError", "", "getOnError", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "getTrickId", "()Ljava/lang/String;", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "loadList", "", "retry", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b extends s {

    private final String a;
    private final c0 b;
    private final b3 c;
    private final o3 d;
    private final j2 e;
    private final x<y<List<GoodTrickExample>>> f;
    private final a<Throwable> g;
    private final a<Boolean> h;
    private final LiveData<Boolean> i;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.m.b a;
        public a(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.m.b b2) {
            this.a = b2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            a.d(throwable2);
            y.a aVar = new y.a(throwable2);
            this.a.n().postValue(aVar);
            this.a.m().postValue(throwable2);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.goodexamples.GoodExampleVideoViewModel$loadList$1", f = "GoodExampleVideoViewModel.kt", l = 52, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.m.b this$0;
        b(app.dogo.com.dogo_android.m.b b, d<? super app.dogo.com.dogo_android.m.b.b> d2) {
            this.this$0 = b;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (b.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            b.b obj2 = new b.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object unknownHostException;
            y.c unknownHostException2;
            Object obj4;
            Object obj = b.d();
            unknownHostException2 = this.label;
            final int i = 1;
            if (unknownHostException2 != 0) {
                if (unknownHostException2 != i) {
                } else {
                    q.b(object);
                    if ((List)obj4.isEmpty()) {
                        b.i(this.this$0).postValue(b.a(i));
                    } else {
                        unknownHostException2 = new y.c(obj4);
                        this.this$0.n().postValue(unknownHostException2);
                    }
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            this.this$0.n().postValue(y.b.a);
            if (!b.h(this.this$0).a()) {
                b.k(this.this$0).s("good_example_video");
                unknownHostException2 = new UnknownHostException();
                y.a aVar = new y.a(unknownHostException2);
                this.this$0.n().postValue(aVar);
                unknownHostException = new UnknownHostException();
                this.this$0.m().postValue(unknownHostException);
            } else {
                this.label = i;
                if (b.j(this.this$0).b(this.this$0.o(), this) == obj) {
                    return obj;
                }
            }
        }
    }
    public b(String string, c0 c02, b3 b33, o3 o34, j2 j25) {
        n.f(string, "trickId");
        n.f(c02, "videoPlayerFactory");
        n.f(b33, "interactor");
        n.f(o34, "tracker");
        n.f(j25, "connectivityService");
        super();
        this.a = string;
        this.b = c02;
        this.c = b33;
        this.d = o34;
        this.e = j25;
        x obj2 = new x();
        this.f = obj2;
        obj2 = new a();
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
        this.i = obj2;
        q();
    }

    public static final j2 h(app.dogo.com.dogo_android.m.b b) {
        return b.e;
    }

    public static final a i(app.dogo.com.dogo_android.m.b b) {
        return b.h;
    }

    public static final b3 j(app.dogo.com.dogo_android.m.b b) {
        return b.c;
    }

    public static final o3 k(app.dogo.com.dogo_android.m.b b) {
        return b.d;
    }

    private final void q() {
        b.a aVar = new b.a(CoroutineExceptionHandler.r, this);
        b.b bVar = new b.b(this, 0);
        k.d(f0.a(this), aVar, 0, bVar, 2, 0);
    }

    public final LiveData<Boolean> l() {
        return this.i;
    }

    public final a<Throwable> m() {
        return this.g;
    }

    public final x<y<List<GoodTrickExample>>> n() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String o() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final c0 p() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        q();
    }
}
