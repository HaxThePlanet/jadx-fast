package app.dogo.com.dogo_android.z;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.c0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.m1;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0016\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/tutorials/ClickerIntroductionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "(Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;)V", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "getTrickName", "", "trickItemResults", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends s {

    private final c0 a;
    private final x<y<TrickItem>> b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.tutorials.ClickerIntroductionViewModel$1", f = "ClickerIntroductionViewModel.kt", l = 29, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final o1 $tricksRepository;
        int label;
        final app.dogo.com.dogo_android.z.d this$0;
        a(o1 o1, app.dogo.com.dogo_android.z.d d2, d<? super app.dogo.com.dogo_android.z.d.a> d3) {
            this.$tricksRepository = o1;
            this.this$0 = d2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (d.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            d.a obj3 = new d.a(this.$tricksRepository, this.this$0, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            x xVar;
            String label;
            y.c cVar;
            Object obj7;
            Object obj = b.d();
            label = this.label;
            int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    cVar = new y.c(j1.T0(m1.H((g)obj7), b.c(0), 0, false, 6, 0));
                    this.this$0.h().postValue(cVar);
                    return w.a;
                }
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
            }
            q.b(object);
            this.label = i;
            if (this.$tricksRepository.o("id_clicker", this) == obj) {
                return obj;
            }
        }
    }
    public d(c0 c0, p2 p22, o1 o13) {
        n.f(c0, "videoPlayerFactory");
        n.f(p22, "preferenceService");
        n.f(o13, "tricksRepository");
        super();
        this.a = c0;
        x obj7 = new x();
        this.b = obj7;
        p22.z0(true);
        d.a aVar = new d.a(o13, this, 0);
        k.d(f0.a(this), 0, 0, aVar, 3, 0);
    }

    public final x<y<TrickItem>> h() {
        return this.b;
    }

    public final String i(y<TrickItem> y) {
        int name;
        Object obj3;
        if (y == null) {
            obj3 = name;
        } else {
            obj3 = z.b(y);
        }
        if (obj3 instanceof TrickItem) {
            name = obj3;
        }
        obj3 = "";
        if (name == null) {
        } else {
            name = name.getName();
            if (name == null) {
            } else {
                obj3 = name;
            }
        }
        return obj3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final c0 j() {
        return this.a;
    }
}
