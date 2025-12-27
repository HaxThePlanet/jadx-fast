package app.dogo.com.dogo_android.t.g0;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.s.b.y0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.m1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: FaqListViewModel.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bR \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\n0\t0\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "articlesRepository", "Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "loadList", "", "logFaq", "article", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class FaqListViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final y0 articlesRepository;
    private final o3 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final x<y<List<Article>>> tracker = new x<>();
    private final LiveData<y<List<Article>>> d = new x<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            i.this.tracker.postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<List<? extends Article>, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(List<Article> list) {
            i.this.tracker.postValue(new LoadResult_Success(list));
        }

        b() {
            super(1);
        }
    }
    public i(y0 y0Var, o3 o3Var) {
        n.f(y0Var, "articlesRepository");
        n.f(o3Var, "tracker");
        super();
        this.articlesRepository = y0Var;
        this.b = o3Var;
        final x xVar = new x();
        loadList();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ x logFaq(i article) {
        return article.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<List<Article>>> getResult() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final void loadList() {
        this.tracker.postValue(LoadResult_Loading.a);
        i.b.a0 observable2 = this.articlesRepository.j().observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "articlesRepository.getFaqListData()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.settings.faq.i.a(this), new app.dogo.com.dogo_android.settings.faq.i.b(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j(Article article) {
        n.f(article, "article");
        this.b.logEvent(E_General.a.c(new EP_FaqId(), article.getArticleId()));
    }
}
