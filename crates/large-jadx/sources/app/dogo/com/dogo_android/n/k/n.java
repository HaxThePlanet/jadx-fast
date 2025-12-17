package app.dogo.com.dogo_android.n.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.a3;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001b\u001c\u001dB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "(Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "articles", "getArticles", "()Ljava/util/List;", "setArticles", "(Ljava/util/List;)V", "articles$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ArticleItem", "ArticleListCallback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends RecyclerView.h<app.dogo.com.dogo_android.n.k.n.c> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.n.k.n.b a;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        public abstract void a(Article article);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public c(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleItem;", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryArticleItemBinding;", "(Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter;Lapp/dogo/com/dogo_android/databinding/CellLibraryArticleItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryArticleItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends app.dogo.com.dogo_android.n.k.n.c {

        private final a3 b;
        final app.dogo.com.dogo_android.n.k.n c;
        public a(app.dogo.com.dogo_android.n.k.n n, a3 a32) {
            n.f(n, "this$0");
            n.f(a32, "binding");
            this.c = n;
            super(a32);
            this.b = a32;
            d dVar = new d(n, this);
            a32.w().setOnClickListener(dVar);
        }

        private static final void b(app.dogo.com.dogo_android.n.k.n n, app.dogo.com.dogo_android.n.k.n.a n$a2, View view3) {
            Object obj0;
            Object obj1;
            n.f(n, "this$0");
            n.f(a2, "this$1");
            app.dogo.com.dogo_android.n.k.n.b obj2 = n.f(n);
            if (obj2 == null) {
            } else {
                obj2.a((Article)n.g().get(a2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.n.k.n n, app.dogo.com.dogo_android.n.k.n.a n$a2, View view3) {
            n.a.b(n, a2, view3);
        }

        @Override // app.dogo.com.dogo_android.n.k.n$c
        public final a3 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends b<List<? extends Article>> {

        final Object a;
        final app.dogo.com.dogo_android.n.k.n b;
        public e(Object object, Object object2, app.dogo.com.dogo_android.n.k.n n3) {
            this.a = object;
            this.b = n3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends Article> list2, List<? extends Article> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.n.k.n obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, n.d.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements p<Article, Article, Boolean> {

        public static final app.dogo.com.dogo_android.n.k.n.d a;
        static {
            n.d dVar = new n.d();
            n.d.a = dVar;
        }

        d() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(Article article, Article article2) {
            n.f(article, "o");
            n.f(article2, "n");
            return n.b(article.getArticleId(), article2.getArticleId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((Article)object, (Article)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(n.class), "articles", "getArticles()Ljava/util/List;");
        n.c = arr;
    }

    public n() {
        final int i = 0;
        super(i, 1, i);
    }

    public n(app.dogo.com.dogo_android.n.k.n.b n$b) {
        super();
        this.a = b;
        a obj2 = a.a;
        obj2 = p.g();
        n.e eVar = new n.e(obj2, obj2, this);
        this.b = eVar;
    }

    public n(app.dogo.com.dogo_android.n.k.n.b n$b, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final app.dogo.com.dogo_android.n.k.n.b f(app.dogo.com.dogo_android.n.k.n n) {
        return n.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<Article> g() {
        return (List)this.b.getValue(this, n.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.n.k.n.c n$c, int i2) {
        boolean z;
        List list;
        int obj4;
        n.f(c, "holder");
        if (c instanceof n.a) {
            (n.a)c.c().V((Article)g().get(i2));
        }
        c.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.n.k.n.c i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final a3 obj3 = a3.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        n.a aVar = new n.a(this, obj3);
        return aVar;
    }

    public final void j(List<Article> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, n.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((n.c)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
