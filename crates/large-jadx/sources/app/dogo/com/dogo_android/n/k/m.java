package app.dogo.com.dogo_android.n.k;

import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.d0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w0;
import f.d.a.a;
import i.b.b;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00190\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "isSpecialProgramArticle", "", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/Article;ZLapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "getArticle", "()Lapp/dogo/com/dogo_android/repository/domain/Article;", "goBack", "Lcom/hadilq/liveevent/LiveEvent;", "getGoBack", "()Lcom/hadilq/liveevent/LiveEvent;", "saveReadArticleId", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSaveReadArticleId", "()Landroidx/lifecycle/MutableLiveData;", "saveArticleAsReadAndGoBack", "", "articleId", "", "trackFinishReadingTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends s {

    private final Article a;
    private final boolean b;
    private final k1 c;
    private final o3 d;
    private final p1 e;
    private final j1 f;
    private final j2 g;
    private final x<y<Boolean>> h;
    private final a<Boolean> i;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.n.k.m this$0;
        a(app.dogo.com.dogo_android.n.k.m m) {
            this.this$0 = m;
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
            this.this$0.l().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.n.k.m this$0;
        b(app.dogo.com.dogo_android.n.k.m m) {
            this.this$0 = m;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            boolean z;
            if (m.i(this.this$0)) {
                m.h(this.this$0).w();
            }
            final Boolean tRUE = Boolean.TRUE;
            y.c cVar = new y.c(tRUE);
            this.this$0.l().postValue(cVar);
            this.this$0.k().postValue(tRUE);
        }
    }
    public m(Article article, boolean z2, k1 k13, o3 o34, p1 p15, j1 j16, j2 j27) {
        n.f(article, "article");
        n.f(k13, "rateRepository");
        n.f(o34, "tracker");
        n.f(p15, "userRepository");
        n.f(j16, "programRepository");
        n.f(j27, "connectivityService");
        super();
        this.a = article;
        this.b = z2;
        this.c = k13;
        this.d = o34;
        this.e = p15;
        this.f = j16;
        this.g = j27;
        x obj2 = new x();
        this.h = obj2;
        obj2 = new a();
        this.i = obj2;
        k13.c();
    }

    public static final j1 h(app.dogo.com.dogo_android.n.k.m m) {
        return m.f;
    }

    public static final boolean i(app.dogo.com.dogo_android.n.k.m m) {
        return m.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Article j() {
        return this.a;
    }

    public final a<Boolean> k() {
        return this.i;
    }

    public final x<y<Boolean>> l() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m(String string) {
        Object disposable;
        Object unknownHostException;
        app.dogo.com.dogo_android.n.k.m.b bVar;
        Object obj4;
        n.f(string, "articleId");
        this.h.postValue(y.b.a);
        if (!this.g.a()) {
            this.d.s("article_details");
            unknownHostException = new UnknownHostException();
            disposable = new y.a(unknownHostException);
            this.h.postValue(disposable);
        } else {
            obj4 = this.e.j0(string).q(a.b()).y(a.b());
            n.e(obj4, "userRepository.saveArticleRead(articleId)\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())");
            unknownHostException = new m.a(this);
            bVar = new m.b(this);
            getDisposable().b(a.d(obj4, unknownHostException, bVar));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String string) {
        n.f(string, "articleId");
        w0 w0Var = new w0();
        this.d.d(d0.l.c(w0Var, string));
    }
}
