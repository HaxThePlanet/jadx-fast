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
import e.a.a.a.b.d.a;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlin.z.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u000cJ#\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010R\u0014\u0010\u000b\u001a\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "questionDao", "Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "contentLocale", "", "getContentLocale", "()Ljava/lang/String;", "getArticlesByTag", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "tagId", "getArticlesListData", "articleTag", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBitingArticles", "getFaqListData", "getPottyArticles", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class y0 {

    public static final app.dogo.com.dogo_android.s.b.y0.a Companion;
    private static final List<String> e;
    private final p2 a;
    private final g0 b;
    private final app.dogo.com.dogo_android.s.b.p1 c;
    private final h0 d;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository$Companion;", "", "()V", "BITING_ARTICLE_TAG", "", "CATEGORY_ARTICLE", "CATEGORY_FAQ", "POTTY_ARTICLE_TAG", "articleBlackList", "", "getArticleBlackList", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final List<String> a() {
            return y0.a();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {
        public final int compare(T t, T t2) {
            return a.c((Article)t.getSortOrder(), (Article)t2.getSortOrder());
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ArticlesRepository$getArticlesListData$2", f = "ArticlesRepository.kt", l = {}, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super List<? extends Article>>, Object> {

        final String $articleTag;
        int label;
        final app.dogo.com.dogo_android.s.b.y0 this$0;
        c(app.dogo.com.dogo_android.s.b.y0 y0, String string2, d<? super app.dogo.com.dogo_android.s.b.y0.c> d3) {
            this.this$0 = y0;
            this.$articleTag = string2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super List<Article>> d2) {
            return (y0.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            y0.c obj3 = new y0.c(this.this$0, this.$articleTag, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            ArrayList arrayList;
            int i;
            boolean booleanValue3;
            int i2;
            int booleanValue;
            Boolean contains;
            String booleanValue2;
            int contains2;
            String arrayList2;
            boolean next;
            int i3;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                Object obj10 = y0.c(this.this$0).i(y0.b(this.this$0)).blockingGet();
                n.e((List)obj10, "articles");
                final int i4 = 10;
                arrayList = new ArrayList(p.r(obj10, i4));
                obj10 = obj10.iterator();
                booleanValue = 0;
                while (obj10.hasNext()) {
                    Object next3 = obj10.next();
                    contains = (UserReadArticlesResponse)y0.d(this.this$0).I().blockingGet().getArticles().get((a)next3.a().getArticleId());
                    if ((UserReadArticlesResponse.ArticleStatus)contains == null) {
                    } else {
                    }
                    contains = b.a((UserReadArticlesResponse.ArticleStatus)contains.isRead());
                    if (contains == null) {
                    } else {
                    }
                    booleanValue = contains.booleanValue();
                    arrayList.add(m1.e(next3, booleanValue));
                    booleanValue = 0;
                }
                obj10 = new ArrayList();
                Iterator iterator = arrayList.iterator();
                i2 = 1;
                while (iterator.hasNext()) {
                    arrayList = iterator.next();
                    contains = arrayList;
                    if (n.b((Article)contains.getCategory(), "article") && !y0.Companion.a().contains(contains.getArticleId())) {
                    } else {
                    }
                    i2 = booleanValue;
                    if (b.a(i2).booleanValue()) {
                    }
                    i2 = 1;
                    obj10.add(arrayList);
                    if (!y0.Companion.a().contains(contains.getArticleId())) {
                    } else {
                    }
                }
                String $articleTag = this.$articleTag;
                ArrayList arrayList3 = new ArrayList();
                obj10 = obj10.iterator();
                while (obj10.hasNext()) {
                    contains = obj10.next();
                    if ($articleTag != null) {
                    } else {
                    }
                    contains2 = i2;
                    if (b.a(contains2).booleanValue()) {
                    }
                    arrayList3.add(contains);
                    List tags = (Article)contains.getTags();
                    arrayList2 = new ArrayList(p.r(tags, i4));
                    Iterator iterator2 = tags.iterator();
                    for (LibraryTag next5 : iterator2) {
                        arrayList2.add(next5.getId());
                    }
                    contains2 = arrayList2.contains($articleTag);
                    arrayList2.add((LibraryTag)iterator2.next().getId());
                }
                obj10 = new l[2];
                obj10[booleanValue] = y0.c.a.a;
                obj10[i2] = y0.c.b.a;
                return p.D0(arrayList3, a.b(obj10));
            }
            obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj10;
        }
    }
    static {
        y0.a aVar = new y0.a(0);
        y0.Companion = aVar;
        y0.e = p.b("id_test_article_with_image");
    }

    public y0(p2 p2, g0 g02, app.dogo.com.dogo_android.s.b.p1 p13, h0 h04) {
        n.f(p2, "preferenceService");
        n.f(g02, "questionDao");
        n.f(p13, "userRepository");
        n.f(h04, "dispatcher");
        super();
        this.a = p2;
        this.b = g02;
        this.c = p13;
        this.d = h04;
    }

    public y0(p2 p2, g0 g02, app.dogo.com.dogo_android.s.b.p1 p13, h0 h04, int i5, g g6) {
        h0 obj4;
        if (i5 &= 8 != 0) {
            obj4 = c1.b();
        }
        super(p2, g02, p13, obj4);
    }

    public static final List a() {
        return y0.e;
    }

    public static final String b(app.dogo.com.dogo_android.s.b.y0 y0) {
        return y0.i();
    }

    public static final g0 c(app.dogo.com.dogo_android.s.b.y0 y0) {
        return y0.b;
    }

    public static final app.dogo.com.dogo_android.s.b.p1 d(app.dogo.com.dogo_android.s.b.y0 y0) {
        return y0.c;
    }

    private static final List f(String string, List list2) {
        int i;
        boolean next;
        int i2;
        int i3;
        int i4;
        List iterator;
        boolean empty;
        n.f(string, "$tagId");
        n.f(list2, "list");
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        Iterator obj7 = list2.iterator();
        i2 = 1;
        i3 = 0;
        for (a next3 : obj7) {
            arrayList.add(m1.f(next3, i3, i2, 0));
            i2 = 1;
            i3 = 0;
        }
        obj7 = new ArrayList();
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            iterator = (Article)next.getTags();
            if (iterator instanceof Collection != null && iterator.isEmpty()) {
            } else {
            }
            iterator = iterator.iterator();
            for (LibraryTag next4 : iterator) {
            }
            i4 = i3;
            if (i4 != 0) {
            }
            obj7.add(next);
            if (n.b((LibraryTag)iterator.next().getId(), string)) {
            } else {
            }
            i4 = i2;
            if (iterator.isEmpty()) {
            } else {
            }
        }
        y0.b obj6 = new y0.b();
        return p.D0(obj7, obj6);
    }

    private final String i() {
        return n2.a.a(this.a.W());
    }

    private static final List k(List list) {
        int i3;
        boolean next;
        int i2;
        int str;
        int i;
        n.f(list, "list");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator obj5 = list.iterator();
        for (a next3 : obj5) {
            arrayList.add(m1.f(next3, false, 1, 0));
        }
        obj5 = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (n.b((Article)next.getCategory(), "faq")) {
            }
            obj5.add(next);
        }
        return obj5;
    }

    public static List m(String string, List list2) {
        return y0.f(string, list2);
    }

    public static List n(List list) {
        return y0.k(list);
    }

    public final a0<List<Article>> e(String string) {
        n.f(string, "tagId");
        a aVar = new a(string);
        final a0 obj3 = this.b.i(i()).map(aVar);
        n.e(obj3, "questionDao.getAllLocalisedArticles(contentLocale).map { list ->\n            list.map { it.toArticle() }.filter { article -> article.tags.any { it.id == tagId } }.sortedBy { it.sortOrder }\n        }");
        return obj3;
    }

    public final Object g(String string, d<? super List<Article>> d2) {
        y0.c cVar = new y0.c(this, string, 0);
        return k.e(this.d, cVar, d2);
    }

    public final a0<List<Article>> h() {
        return e("id_article_biting");
    }

    public final a0<List<Article>> j() {
        a0 a0Var2 = this.b.i(i()).map(b.a);
        n.e(a0Var2, "questionDao.getAllLocalisedArticles(contentLocale).map { list ->\n            list.map { it.toArticle() }.filter { it.category == CATEGORY_FAQ }\n        }");
        return a0Var2;
    }

    public final a0<List<Article>> l() {
        return e("id_article_potty");
    }
}
