package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.s.b.y0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;
import kotlin.z.a;

/* compiled from: GetLibraryArticleListInteractor.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u000c2\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\u00020\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;", "", "articlesRepository", "Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "(Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;)V", "getArticles", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "articleTag", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSectionData", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "getSectionDataForLibraryList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o2, reason: from kotlin metadata */
public final class GetLibraryArticleListInteractor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final o2.a INSTANCE = new o2$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final y0 articlesRepository;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor$Companion;", "", "()V", "DISPLAYABLE_ARTICLES_IN_LIBRARY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(t.getName(), t2.getName());
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(t.getName(), t2.getName());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryArticleListInteractor", f = "GetLibraryArticleListInteractor.kt", l = 11, m = "getSectionData")
    static final class c extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super o2.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return o2.this.c(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryArticleListInteractor", f = "GetLibraryArticleListInteractor.kt", l = 24, m = "getSectionDataForLibraryList")
    static final class e extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super o2.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return o2.this.getArticles(this);
        }
    }
    public o2(y0 y0Var) {
        n.f(y0Var, "articlesRepository");
        super();
        this.articlesRepository = y0Var;
    }

    public static /* synthetic */ Object b(o2 o2Var, String str, kotlin.b0.d dVar, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        return o2Var.a(str, dVar);
    }

    public final Object a(String str, kotlin.b0.d<? super List<Article>> dVar) {
        return this.articlesRepository.g(str, dVar);
    }

    public final Object c(String str, kotlin.b0.d<? super LibrarySection> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.o2.c;
        if (dVar instanceof kotlinx.coroutines.o2.c) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.o2.c cVar = new kotlinx.coroutines.o2.c(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                List list = result2;
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    p.y(arrayList2, (Article)it2.next().getDisplayTags());
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                }
                LibrarySection str2 = new LibrarySection(list, null, null, "", "", LibrarySection_SectionType.ARTICLE, p.D0(arrayList, new kotlinx.coroutines.o2.b()), 6, null);
                return str2;
            }
        }
        q.b(dVar22.result);
        dVar22.label = i3;
        if (a(str, dVar22) == obj) {
            return obj;
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    /* suspend */ public final Object getArticles(kotlin.b0.d<? super LibrarySection> articleTag) {
        Object articleTag2;
        int label2;
        int i = -2147483648;
        int i2;
        Iterable iterable;
        z = articleTag instanceof kotlinx.coroutines.o2.e;
        if (articleTag instanceof kotlinx.coroutines.o2.e) {
            articleTag2 = articleTag;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                articleTag2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.o2.e eVar = new kotlinx.coroutines.o2.e(this, articleTag);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (articleTag2.label != 0 && articleTag2.label == i3) {
            q.b(articleTag2.result);
            List list = p.F0((Iterable)iterable, 3);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                p.y(arrayList2, (Article)it.next().getDisplayTags());
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Object item = it2.next();
            }
            LibrarySection articleTag3 = new LibrarySection(list, null, null, "", "", LibrarySection_SectionType.ARTICLE, p.D0(arrayList, new kotlinx.coroutines.o2.d()), 6, null);
            return articleTag3;
        }
        q.b(articleTag2.result);
        articleTag2.label = i3;
        String str4 = null;
        if (GetLibraryArticleListInteractor.b(this, str4, articleTag2, i3, str4) == obj) {
            return obj;
        }
    }

}
