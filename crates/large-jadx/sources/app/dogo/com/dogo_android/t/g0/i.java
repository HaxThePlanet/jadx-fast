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
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.m1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import i.b.a0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bR \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\n0\t0\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "articlesRepository", "Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "loadList", "", "logFaq", "article", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends s {

    private final y0 a;
    private final o3 b;
    private final x<y<List<Article>>> c;
    private final LiveData<y<List<Article>>> d;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.t.g0.i this$0;
        a(app.dogo.com.dogo_android.t.g0.i i) {
            this.this$0 = i;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            i.h(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<List<? extends Article>, w> {

        final app.dogo.com.dogo_android.t.g0.i this$0;
        b(app.dogo.com.dogo_android.t.g0.i i) {
            this.this$0 = i;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((List)object);
            return w.a;
        }

        public final void invoke(List<Article> list) {
            y.c cVar = new y.c(list);
            i.h(this.this$0).postValue(cVar);
        }
    }
    public i(y0 y0, o3 o32) {
        n.f(y0, "articlesRepository");
        n.f(o32, "tracker");
        super();
        this.a = y0;
        this.b = o32;
        x obj2 = new x();
        this.c = obj2;
        this.d = obj2;
        i();
    }

    public static final x h(app.dogo.com.dogo_android.t.g0.i i) {
        return i.c;
    }

    public final LiveData<y<List<Article>>> getResult() {
        return this.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i() {
        this.c.postValue(y.b.a);
        a0 subscribeOn = this.a.j().observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "articlesRepository.getFaqListData()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        i.a aVar = new i.a(this);
        i.b bVar3 = new i.b(this);
        getDisposable().b(a.g(subscribeOn, aVar, bVar3));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j(Article article) {
        n.f(article, "article");
        m1 m1Var = new m1();
        this.b.d(a0.a.c(m1Var, article.getArticleId()));
    }
}
