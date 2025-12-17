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
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B1\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010)\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0003R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0016R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0016R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0016R\u0017\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u001d\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "articleTag", "", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;", "predefinedContentRepository", "Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "article", "Landroidx/lifecycle/LiveData;", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "getArticle", "()Landroidx/lifecycle/LiveData;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "rateUsPopUp", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateUsPopUp", "result", "getResult", "sharePopUp", "getSharePopUp", "tagSelection", "", "getTagSelection", "()Landroidx/lifecycle/MutableLiveData;", "tags", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "getTags", "getActiveTagId", "getFilteredArticles", "loadList", "", "trackArticleTapped", "articleId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q extends s {

    private final String a;
    private final o2 b;
    private final h1 c;
    private final o3 d;
    private final k1 e;
    private final x<y<LibrarySection>> f;
    private final LiveData<y<LibrarySection>> g;
    private final x<Integer> h;
    private final LiveData<q2.a> i;
    private final LiveData<q2.a> j;
    private final LiveData<List<LibraryTag>> k;
    private final LiveData<List<Article>> l;
    private final CoroutineExceptionHandler m;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.n.k.q a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.n.k.q q2) {
            this.a = q2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            q.j(this.a).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.library.articles.ArticleListViewModel$loadList$1", f = "ArticleListViewModel.kt", l = 65, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.n.k.q this$0;
        a(app.dogo.com.dogo_android.n.k.q q, d<? super app.dogo.com.dogo_android.n.k.q.a> d2) {
            this.this$0 = q;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (q.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            q.a obj2 = new q.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            Object obj4;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c((LibrarySection)obj4);
                    q.j(this.this$0).postValue(cVar);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            q.j(this.this$0).postValue(y.b.a);
            this.label = i;
            if (q.i(this.this$0).c(q.h(this.this$0), this) == obj) {
                return obj;
            }
        }
    }
    public q(String string, o2 o22, h1 h13, o3 o34, k1 k15) {
        n.f(o22, "interactor");
        n.f(h13, "predefinedContentRepository");
        n.f(o34, "tracker");
        n.f(k15, "rateRepository");
        super();
        this.a = string;
        this.b = o22;
        this.c = h13;
        this.d = o34;
        this.e = k15;
        x obj2 = new x(y.b.a);
        this.f = obj2;
        this.g = obj2;
        obj2 = new x();
        this.h = obj2;
        this.i = k15.a();
        this.j = k15.b();
        obj2 = new v();
        j obj4 = new j(this, obj2);
        obj2.b(getResult(), obj4);
        w obj3 = w.a;
        this.k = obj2;
        obj2 = new v();
        obj4 = new i(this, obj2);
        obj2.b(r(), obj4);
        obj4 = new h(this, obj2);
        obj2.b(getResult(), obj4);
        this.l = obj2;
        obj3 = new q.b(CoroutineExceptionHandler.r, this);
        this.m = obj3;
    }

    public static final String h(app.dogo.com.dogo_android.n.k.q q) {
        return q.a;
    }

    public static final o2 i(app.dogo.com.dogo_android.n.k.q q) {
        return q.b;
    }

    public static final x j(app.dogo.com.dogo_android.n.k.q q) {
        return q.f;
    }

    private static final void k(app.dogo.com.dogo_android.n.k.q q, v v2, Integer integer3) {
        n.f(q, "this$0");
        n.f(v2, "$this_apply");
        v2.postValue(q.o());
    }

    private static final void l(app.dogo.com.dogo_android.n.k.q q, v v2, y y3) {
        n.f(q, "this$0");
        n.f(v2, "$this_apply");
        v2.postValue(q.o());
    }

    private final String m() {
        Object valueOf;
        int intValue;
        String str;
        if ((Integer)this.h.getValue() == null) {
            valueOf = 0;
        }
        Object value = this.k.getValue();
        str = "id_all";
        if ((List)value == null) {
        } else {
            intValue = p.a0((List)value, valueOf.intValue());
            if ((LibraryTag)intValue == null) {
            } else {
                intValue = (LibraryTag)intValue.getId();
                if (intValue == null) {
                } else {
                    str = intValue;
                }
            }
        }
        return str;
    }

    private final List<Article> o() {
        Object articles;
        boolean z;
        int arrayList;
        boolean next;
        Iterator iterator;
        boolean empty;
        int i;
        if (articles instanceof y.c) {
        } else {
            articles = arrayList;
        }
        if (articles == null) {
        } else {
            articles = articles.a();
            if ((LibrarySection)articles == null) {
            } else {
                z = m();
                if (n.b(z, "id_all")) {
                    if ((LibrarySection)articles.getArticles() == null) {
                        articles = p.g();
                    }
                    arrayList = articles;
                } else {
                }
            }
        }
        return arrayList;
    }

    public static void t(app.dogo.com.dogo_android.n.k.q q, v v2, y y3) {
        q.l(q, v2, y3);
    }

    public static void u(app.dogo.com.dogo_android.n.k.q q, v v2, Integer integer3) {
        q.k(q, v2, integer3);
    }

    public static void v(app.dogo.com.dogo_android.n.k.q q, v v2, y y3) {
        q.x(q, v2, y3);
    }

    private static final void x(app.dogo.com.dogo_android.n.k.q q, v v2, y y3) {
        Object obj1;
        int obj3;
        n.f(q, "this$0");
        n.f(v2, "$this_apply");
        if (y3 instanceof y.c) {
        } else {
            obj3 = 0;
        }
        if (obj3 == null) {
        } else {
            obj3 = obj3.a();
            if ((LibrarySection)obj3 == null) {
            } else {
                v2.postValue(p.t0(p.b(q.c.a()), (LibrarySection)obj3.getTags()));
            }
        }
    }

    public final LiveData<y<LibrarySection>> getResult() {
        return this.g;
    }

    public final LiveData<List<Article>> n() {
        return this.l;
    }

    public final LiveData<q2.a> p() {
        return this.i;
    }

    public final LiveData<q2.a> q() {
        return this.j;
    }

    public final x<Integer> r() {
        return this.h;
    }

    public final LiveData<List<LibraryTag>> s() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        final int i = 0;
        q.a aVar = new q.a(this, i);
        k.d(f0.a(this), this.m, i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String string) {
        n.f(string, "articleId");
        w0 w0Var = new w0();
        this.d.d(d0.e.c(w0Var, string));
    }
}
