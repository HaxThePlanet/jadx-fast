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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;
import kotlin.z.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u000c2\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\u00020\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor;", "", "articlesRepository", "Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "(Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;)V", "getArticles", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "articleTag", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSectionData", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "getSectionDataForLibraryList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o2 {

    public static final app.dogo.com.dogo_android.s.a.o2.a Companion;
    private final y0 a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryArticleListInteractor$Companion;", "", "()V", "DISPLAYABLE_ARTICLES_IN_LIBRARY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {
        public final int compare(T t, T t2) {
            return a.c((LibraryTag)t.getName(), (LibraryTag)t2.getName());
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class d implements Comparator {
        public final int compare(T t, T t2) {
            return a.c((LibraryTag)t.getName(), (LibraryTag)t2.getName());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryArticleListInteractor", f = "GetLibraryArticleListInteractor.kt", l = 11, m = "getSectionData")
    static final class c extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.o2 this$0;
        c(app.dogo.com.dogo_android.s.a.o2 o2, d<? super app.dogo.com.dogo_android.s.a.o2.c> d2) {
            this.this$0 = o2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.c(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryArticleListInteractor", f = "GetLibraryArticleListInteractor.kt", l = 24, m = "getSectionDataForLibraryList")
    static final class e extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.o2 this$0;
        e(app.dogo.com.dogo_android.s.a.o2 o2, d<? super app.dogo.com.dogo_android.s.a.o2.e> d2) {
            this.this$0 = o2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.d(this);
        }
    }
    static {
        o2.a aVar = new o2.a(0);
        o2.Companion = aVar;
    }

    public o2(y0 y0) {
        n.f(y0, "articlesRepository");
        super();
        this.a = y0;
    }

    public static Object b(app.dogo.com.dogo_android.s.a.o2 o2, String string2, d d3, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        return o2.a(obj1, d3);
    }

    public final Object a(String string, d<? super List<Article>> d2) {
        return this.a.g(string, d2);
    }

    public final Object c(String string, d<? super LibrarySection> d2) {
        boolean displayTags;
        int label2;
        int i2;
        int label;
        int i;
        int i3;
        Object obj12;
        displayTags = d2;
        label2 = displayTags.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof o2.c && label2 & i2 != 0) {
            displayTags = d2;
            label2 = displayTags.label;
            i2 = Integer.MIN_VALUE;
            if (label2 & i2 != 0) {
                displayTags.label = label2 -= i2;
            } else {
                displayTags = new o2.c(this, d2);
            }
        } else {
        }
        obj12 = displayTags.result;
        Object obj = b.d();
        label = displayTags.label;
        i3 = 1;
        if (label != 0) {
            if (label != i3) {
            } else {
                q.b(obj12);
                Object obj2 = obj12;
                ArrayList obj11 = new ArrayList();
                obj12 = (List)obj2.iterator();
                for (Article next2 : obj12) {
                    p.y(obj11, next2.getDisplayTags());
                }
                obj12 = new HashSet();
                ArrayList arrayList = new ArrayList();
                obj11 = obj11.iterator();
                while (obj11.hasNext()) {
                    label = obj11.next();
                    if (obj12.add((LibraryTag)label.getId()) != 0) {
                    }
                    arrayList.add(label);
                }
                obj11 = new o2.b();
                super(obj2, 0, 0, "", "", LibrarySection.SectionType.ARTICLE, p.D0(arrayList, obj11), 6, 0);
                return obj11;
            }
            obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj11;
        }
        q.b(obj12);
        displayTags.label = i3;
        if (a(string, displayTags) == obj) {
            return obj;
        }
    }

    public final Object d(d<? super LibrarySection> d) {
        boolean eVar;
        int label;
        Object displayTags;
        int i2;
        int i;
        int next;
        boolean z;
        Object obj12;
        eVar = d;
        label = eVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof o2.e && label & i2 != 0) {
            eVar = d;
            label = eVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                eVar.label = label -= i2;
            } else {
                eVar = new o2.e(this, d);
            }
        } else {
        }
        obj12 = eVar.result;
        displayTags = b.d();
        int label2 = eVar.label;
        next = 1;
        if (label2 != 0) {
            if (label2 != next) {
            } else {
                q.b(obj12);
                List list = p.F0((Iterable)obj12, 3);
                obj12 = new ArrayList();
                Iterator iterator = list.iterator();
                for (Article next3 : iterator) {
                    p.y(obj12, next3.getDisplayTags());
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                obj12 = obj12.iterator();
                while (obj12.hasNext()) {
                    next = obj12.next();
                    if (hashSet.add((LibraryTag)next.getId())) {
                    }
                    arrayList.add(next);
                }
                obj12 = new o2.d();
                super(list, 0, 0, "", "", LibrarySection.SectionType.ARTICLE, p.D0(arrayList, obj12), 6, 0);
                return obj12;
            }
            obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj12;
        }
        q.b(obj12);
        eVar.label = next;
        obj12 = 0;
        if (o2.b(this, obj12, eVar, next, obj12) == displayTags) {
            return displayTags;
        }
    }
}
