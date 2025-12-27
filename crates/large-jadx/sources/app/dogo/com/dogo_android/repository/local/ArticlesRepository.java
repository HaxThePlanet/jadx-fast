package app.dogo.com.dogo_android.s.b;

import app.dogo.android.persistencedb.room.entity.ArticleEntity;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.externalmodel.model.responses.UserReadArticlesResponse;
import app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus;
import e.a.a.a.b.b.g0;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: ArticlesRepository.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u000cJ#\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010R\u0014\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "questionDao", "Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "contentLocale", "", "getContentLocale", "()Ljava/lang/String;", "getArticlesByTag", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "tagId", "getArticlesListData", "articleTag", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBitingArticles", "getFaqListData", "getPottyArticles", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: y0, reason: from kotlin metadata */
public final class ArticlesRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final y0.a INSTANCE = new y0$a(0);
    private static final List<String> e;
    private final p2 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final g0 dispatcher;
    /* renamed from: c, reason: from kotlin metadata */
    private final p1 preferenceService;
    /* renamed from: d, reason: from kotlin metadata */
    private final h0 questionDao;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository$Companion;", "", "()V", "BITING_ARTICLE_TAG", "", "CATEGORY_ARTICLE", "CATEGORY_FAQ", "POTTY_ARTICLE_TAG", "articleBlackList", "", "getArticleBlackList", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public final List<String> a() {
            return ArticlesRepository.e;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(t.getSortOrder(), t2.getSortOrder());
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ArticlesRepository$getArticlesListData$2", f = "ArticlesRepository.kt", l = {}, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super List<? extends Article>>, Object> {

        final /* synthetic */ String $articleTag;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            boolean z2 = true;
            boolean booleanValue2 = false;
            Boolean bool;
            boolean contains;
            ArrayList arrayList;
            String articleId;
            boolean z;
            boolean contains2;
            Object str;
            boolean hasNext;
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                Object blockingGet2 = y0.this.dispatcher.i(y0.this.i()).blockingGet();
                n.e(blockingGet2, "articles");
                final int i5 = 10;
                arrayList = new ArrayList(p.r(blockingGet2, i5));
                Iterator it3 = blockingGet2.iterator();
                int i3 = 0;
                while (it3.hasNext()) {
                    Object item2 = it3.next();
                    Object value = (UserReadArticlesResponse)y0.this.preferenceService.I().blockingGet().getArticles().get(item2.a().getArticleId());
                    arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.e(item2, booleanValue2));
                }
                ArrayList arrayList4 = new ArrayList();
                Iterator it = arrayList.iterator();
                int i2 = 1;
                while (it.hasNext()) {
                    arrayList = it.next();
                    str = "article";
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    Object item = it4.next();
                }
                kotlin.d0.c.l[] arr = new l[2];
                return p.D0(arrayList2, a.b(new l[] { app.dogo.com.dogo_android.repository.local.y0.c.a.a, app.dogo.com.dogo_android.repository.local.y0.c.b.a }));
            }
        }

        c(String str, d<? super y0.c> dVar) {
            this.$articleTag = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super List<Article>> dVar) {
            return (app.dogo.com.dogo_android.repository.local.y0.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.repository.local.y0.c(y0.this, this.$articleTag, dVar);
        }
    }
    static {
        ArticlesRepository.e = p.b("id_test_article_with_image");
    }

    public y0(p2 p2Var, g0 g0Var, p1 p1Var, h0 h0Var) {
        n.f(p2Var, "preferenceService");
        n.f(g0Var, "questionDao");
        n.f(p1Var, "userRepository");
        n.f(h0Var, "dispatcher");
        super();
        this.a = p2Var;
        this.dispatcher = g0Var;
        this.preferenceService = p1Var;
        this.questionDao = h0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ List getBitingArticles() {
        return ArticlesRepository.e;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final /* synthetic */ String getArticlesByTag(y0 tagId) {
        return tagId.i();
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ g0 getArticlesListData(y0 articleTag) {
        return articleTag.dispatcher;
    }

    public static final /* synthetic */ p1 d(y0 y0Var) {
        return y0Var.preferenceService;
    }

    private static final List f(String str, List list) {
        Object obj = null;
        boolean hasNext2;
        n.f(str, "$tagId");
        n.f(list, "list");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it3 = list.iterator();
        int i2 = 1;
        boolean z = false;
        while (it3.hasNext()) {
            obj = null;
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.f((ArticleFullEntity)it3.next(), z, i2, obj));
            i2 = 1;
            z = false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            List tags = (Article)item.getTags();
            hasNext2 = tags instanceof Collection;
            boolean r4 = z;
        }
        return p.D0(arrayList2, new app.dogo.com.dogo_android.repository.local.y0.b());
    }

    private final String i() {
        return LocaleService.a.a(this.a.W());
    }

    private static final List k(List list) {
        boolean z = false;
        int i2 = 1;
        n.f(list, "list");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            z = false;
            i2 = 1;
            Object obj = null;
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.f((ArticleFullEntity)it2.next(), z, i2, obj));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList2;
    }

    public final a0<List<Article>> e(String str) {
        n.f(str, "tagId");
        final a0 map = this.dispatcher.i(i()).map(new app.dogo.com.dogo_android.repository.local.a(str));
        n.e(map, "questionDao.getAllLocalisedArticles(contentLocale).map { list ->\n            list.map { it.toArticle() }.filter { article -> article.tags.any { it.id == tagId } }.sortedBy { it.sortOrder }\n        }");
        return map;
    }

    public final Object g(String str, d<? super List<Article>> dVar) {
        return kotlinx.coroutines.internal.k.e(this.questionDao, new app.dogo.com.dogo_android.repository.local.y0.c(this, str, null), dVar);
    }

    public final a0<List<Article>> h() {
        return e("id_article_biting");
    }

    public final a0<List<Article>> j() {
        a0 map = this.dispatcher.i(i()).map(app.dogo.com.dogo_android.repository.local.b.a);
        n.e(map, "questionDao.getAllLocalisedArticles(contentLocale).map { list ->\n            list.map { it.toArticle() }.filter { it.category == CATEGORY_FAQ }\n        }");
        return map;
    }

    public final a0<List<Article>> l() {
        return e("id_article_potty");
    }

    public /* synthetic */ y0(p2 p2Var, g0 g0Var, p1 p1Var, h0 h0Var, int i, g gVar) {
        if (i & 8 != 0) {
            h0Var = Dispatchers.b();
        }
        this(p2Var, g0Var, p1Var, h0Var);
    }

    public static /* synthetic */ List m(String str, List list) {
        return ArticlesRepository.f(str, list);
    }

    public static /* synthetic */ List n(List list) {
        return ArticlesRepository.k(list);
    }
}
