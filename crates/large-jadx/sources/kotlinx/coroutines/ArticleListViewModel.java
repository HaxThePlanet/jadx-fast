package app.dogo.com.dogo_android.n.k;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.s.a.o2;
import app.dogo.com.dogo_android.s.b.h1;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.d0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: ArticleListViewModel.kt */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B1\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010)\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0003R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0016R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0016R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0016R\u0017\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u001d\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "articleTag", "", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;", "predefinedContentRepository", "Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "article", "Landroidx/lifecycle/LiveData;", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "getArticle", "()Landroidx/lifecycle/LiveData;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "rateUsPopUp", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateUsPopUp", "result", "getResult", "sharePopUp", "getSharePopUp", "tagSelection", "", "getTagSelection", "()Landroidx/lifecycle/MutableLiveData;", "tags", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "getTags", "getActiveTagId", "getFilteredArticles", "loadList", "", "trackArticleTapped", "articleId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q, reason: from kotlin metadata */
public final class ArticleListViewModel extends s {

    private final String a;
    /* renamed from: b, reason: from kotlin metadata */
    private final o2 articleTag;
    private final h1 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final o3 interactor;
    /* renamed from: e, reason: from kotlin metadata */
    private final k1 predefinedContentRepository;
    /* renamed from: f, reason: from kotlin metadata */
    private final x<y<LibrarySection>> rateRepository = new x<>();
    /* renamed from: g, reason: from kotlin metadata */
    private final LiveData<y<LibrarySection>> rateUsPopUp = new x<>();
    private final x<Integer> h = new x<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final LiveData<q2.a> sharePopUp;
    private final LiveData<q2.a> j;
    /* renamed from: k, reason: from kotlin metadata */
    private final LiveData<List<LibraryTag>> tags = new v<>();
    /* renamed from: l, reason: from kotlin metadata */
    private final LiveData<List<Article>> tracker = new v<>();
    private final CoroutineExceptionHandler m = new q$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final /* synthetic */ q a;
        public b(CoroutineExceptionHandler.a exc, q qVar) {
            this.a = qVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.rateRepository.postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.articles.ArticleListViewModel$loadList$1", f = "ArticleListViewModel.kt", l = 65, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    q.this.rateRepository.postValue(new LoadResult_Success((LibrarySection)obj));
                    return w.a;
                }
            }
            q.b(object);
            q.this.rateRepository.postValue(LoadResult_Loading.a);
            this.label = i;
            if (q.this.articleTag.c(q.this.a, this) == obj2) {
                return obj2;
            }
        }

        a(d<? super q.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.q.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.q.a(q.this, dVar);
        }
    }
    public q(String str, o2 o2Var, h1 h1Var, o3 o3Var, k1 k1Var) {
        n.f(o2Var, "interactor");
        n.f(h1Var, "predefinedContentRepository");
        n.f(o3Var, "tracker");
        n.f(k1Var, "rateRepository");
        super();
        this.a = str;
        this.articleTag = o2Var;
        this.c = h1Var;
        this.interactor = o3Var;
        this.predefinedContentRepository = k1Var;
        x xVar = new x(LoadResult_Loading.a);
        x xVar2 = new x();
        this.sharePopUp = k1Var.a();
        this.j = k1Var.b();
        v vVar = new v();
        vVar.b(getResult(), new kotlinx.coroutines.j(this, vVar));
        v vVar2 = new v();
        vVar2.b(r(), new kotlinx.coroutines.i(this, vVar2));
        vVar2.b(getResult(), new kotlinx.coroutines.h(this, vVar2));
        app.dogo.com.dogo_android.n.k.q.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ String trackArticleTapped(q articleId) {
        return articleId.a;
    }

    public static final /* synthetic */ o2 i(q qVar) {
        return qVar.articleTag;
    }

    public static final /* synthetic */ x j(q qVar) {
        return qVar.rateRepository;
    }

    private static final void k(q qVar, v vVar, Integer integer) {
        n.f(qVar, "this$0");
        n.f(vVar, "$this_apply");
        vVar.postValue(qVar.o());
    }

    private static final void l(q qVar, v vVar, y yVar) {
        n.f(qVar, "this$0");
        n.f(vVar, "$this_apply");
        vVar.postValue(qVar.o());
    }

    /* renamed from: m, reason: from kotlin metadata */
    private final String getActiveTagId() {
        Object value;
        String str;
        if ((Integer)this.h.getValue() == null) {
            Integer num = 0;
        }
        Object value2 = this.tags.getValue();
        str = "id_all";
        if (value2 != null) {
            Object obj = p.a0(value2, value.intValue());
            if (obj != null) {
                str = obj.getId();
                if (str != null) {
                }
            }
        }
        return str;
    }

    private final List<Article> o() {
        Object value;
        List articles;
        List articles2;
        int i = 0;
        boolean hasNext;
        Iterator it;
        boolean hasNext2;
        int i2;
        z = this.rateUsPopUp.getValue() instanceof LoadResult_Success;
        i = 0;
        LoadResult_Success r0 = this.rateUsPopUp.getValue() instanceof oadResult_Success ? (oadResult_Success)this.rateUsPopUp.getValue() : 0;
        if (this.rateUsPopUp != null) {
            value = value.component1();
            if (value != null) {
                String activeTagId = getActiveTagId();
                if (n.b(activeTagId, "id_all")) {
                    if (value.getArticles() == null) {
                        articles2 = p.g();
                    }
                }
            }
        }
        return i;
    }

    private static final void x(q qVar, v vVar, y yVar) {
        int i = 0;
        n.f(qVar, "this$0");
        n.f(vVar, "$this_apply");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                vVar.postValue(p.t0(p.b(qVar.c.a()), component1.getTags()));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<LibrarySection>> getResult() {
        return this.rateUsPopUp;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<List<Article>> n() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<q2.a> p() {
        return this.sharePopUp;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<q2.a> q() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> r() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<List<LibraryTag>> s() {
        return this.tags;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.m, dVar, new kotlinx.coroutines.q.a(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String str) {
        n.f(str, "articleId");
        this.interactor.logEvent(E_Library.e.c(new EP_ArticleId(), str));
    }

    public static /* synthetic */ void t(q qVar, v vVar, y yVar) {
        ArticleListViewModel.l(qVar, vVar, yVar);
    }

    public static /* synthetic */ void u(q qVar, v vVar, Integer integer) {
        ArticleListViewModel.k(qVar, vVar, integer);
    }

    public static /* synthetic */ void v(q qVar, v vVar, y yVar) {
        ArticleListViewModel.x(qVar, vVar, yVar);
    }
}
