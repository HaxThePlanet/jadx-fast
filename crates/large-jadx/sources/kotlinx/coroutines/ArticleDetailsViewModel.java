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
import i.b.b;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: ArticleDetailsViewModel.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00190\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleDetailsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "isSpecialProgramArticle", "", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/Article;ZLapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "getArticle", "()Lapp/dogo/com/dogo_android/repository/domain/Article;", "goBack", "Lcom/hadilq/liveevent/LiveEvent;", "getGoBack", "()Lcom/hadilq/liveevent/LiveEvent;", "saveReadArticleId", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSaveReadArticleId", "()Landroidx/lifecycle/MutableLiveData;", "saveArticleAsReadAndGoBack", "", "articleId", "", "trackFinishReadingTapped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class ArticleDetailsViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final Article article;
    /* renamed from: b, reason: from kotlin metadata */
    private final boolean connectivityService;
    private final k1 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final o3 isSpecialProgramArticle;
    /* renamed from: e, reason: from kotlin metadata */
    private final p1 programRepository;
    /* renamed from: f, reason: from kotlin metadata */
    private final j1 rateRepository;
    private final j2 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final x<y<Boolean>> tracker = new x<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> userRepository = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            m.this.l().postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            if (m.this.connectivityService != null) {
                m.this.rateRepository.w();
            }
            final Boolean tRUE2 = Boolean.TRUE;
            m.this.l().postValue(new LoadResult_Success(tRUE2));
            m.this.k().postValue(tRUE2);
        }

        b() {
            super(0);
        }
    }
    public m(Article article, boolean z, k1 k1Var, o3 o3Var, p1 p1Var, j1 j1Var, j2 j2Var) {
        n.f(article, "article");
        n.f(k1Var, "rateRepository");
        n.f(o3Var, "tracker");
        n.f(p1Var, "userRepository");
        n.f(j1Var, "programRepository");
        n.f(j2Var, "connectivityService");
        super();
        this.article = article;
        this.connectivityService = z;
        this.c = k1Var;
        this.isSpecialProgramArticle = o3Var;
        this.programRepository = p1Var;
        this.rateRepository = j1Var;
        this.g = j2Var;
        x xVar = new x();
        f.d.a.a aVar = new a();
        k1Var.c();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j1 saveArticleAsReadAndGoBack(m articleId) {
        return articleId.rateRepository;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ boolean trackFinishReadingTapped(m articleId) {
        return articleId.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Article j() {
        return this.article;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> k() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> l() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m(String str) {
        n.f(str, "articleId");
        this.tracker.postValue(LoadResult_Loading.a);
        if (!this.g.getActiveNetworkType()) {
            this.isSpecialProgramArticle.setTrainingReminderUserProperties("article_details");
            this.tracker.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            b bVar5 = this.programRepository.j0(str).q(a.b()).y(a.b());
            n.e(bVar5, "userRepository.saveArticleRead(articleId)\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())");
            getDisposable().b(a.d(bVar5, new kotlinx.coroutines.m.a(this), new kotlinx.coroutines.m.b(this)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String str) {
        n.f(str, "articleId");
        this.isSpecialProgramArticle.logEvent(E_Library.l.c(new EP_ArticleId(), str));
    }
}
