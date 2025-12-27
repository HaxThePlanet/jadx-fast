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
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.m0;

/* compiled from: ClickerIntroductionViewModel.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0016\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/tutorials/ClickerIntroductionViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "videoPlayerFactory", "Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "(Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;)V", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "getVideoPlayerFactory", "()Lapp/dogo/com/dogo_android/util/VideoPlayerFactory;", "getTrickName", "", "trickItemResults", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class ClickerIntroductionViewModel extends s {

    private final c0 a;
    private final x<y<TrickItem>> b = new x<>();

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.tutorials.ClickerIntroductionViewModel$1", f = "ClickerIntroductionViewModel.kt", l = 29, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        final /* synthetic */ o1 $tricksRepository;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            e.a.a.a.b.d.g gVar;
            Object obj = b.d();
            int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    try {
                        q.b(object);
                    } catch (Exception e) {
                    }
                    d.this.h().postValue(new LoadResult_Success(app.dogo.com.dogo_android.util.extensionfunction.j1.T0(app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickItem((TrickFullEntity)gVar), b.c(0), null, false, 6, null)));
                    return w.a;
                }
            }
            q.b(e);
            try {
                str = "id_clicker";
                this.label = i;
                if (this.$tricksRepository.o(str, this) == obj) {
                    return obj;
                }
            } catch (Exception e) {
            }
            app.dogo.com.dogo_android.z.d dVar = d.this.h();
            d.this.postValue(new LoadResult_Error(e));
        }

        a(o1 o1Var, d dVar, d<? super d.a> dVar2) {
            this.$tricksRepository = o1Var;
            super(2, dVar2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.tutorials.d.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.tutorials.d.a(this.$tricksRepository, d.this, dVar);
        }
    }
    public d(c0 c0Var, p2 p2Var, o1 o1Var) {
        n.f(c0Var, "videoPlayerFactory");
        n.f(p2Var, "preferenceService");
        n.f(o1Var, "tricksRepository");
        super();
        this.a = c0Var;
        x xVar = new x();
        p2Var.z0(true);
        kotlinx.coroutines.internal.k.d(f0.a(this), null, null, new app.dogo.com.dogo_android.tutorials.d.a(o1Var, this, null), 3, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<TrickItem>> h() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final String getTrickName(y<TrickItem> trickItemResults) {
        int i = 0;
        Object trickItemResults2;
        String name;
        i = 0;
        if (trickItemResults == null) {
        } else {
            trickItemResults2 = app.dogo.com.dogo_android.util.base_classes.z.b(trickItemResults);
        }
        if (trickItemResults2 instanceof TrickItem) {
        }
        name = "";
        if (i != 0) {
            name = i.getName();
            if (name != null) {
            }
        }
        return name;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final c0 j() {
        return this.a;
    }
}
