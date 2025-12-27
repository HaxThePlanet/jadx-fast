package app.dogo.com.dogo_android.n.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.a3;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: ArticleListAdapter.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001b\u001c\u001dB\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "(Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "articles", "getArticles", "()Ljava/util/List;", "setArticles", "(Ljava/util/List;)V", "articles$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ArticleItem", "ArticleListCallback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class ArticleListAdapter extends RecyclerView.h<n.c> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    private final n.b a;
    /* renamed from: b, reason: from kotlin metadata */
    private final c callbacks;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleListCallback;", "", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: a, reason: from kotlin metadata */
        void onArticleSelected(Article article);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public c(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$ArticleItem;", "Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryArticleItemBinding;", "(Lapp/dogo/com/dogo_android/library/articles/ArticleListAdapter;Lapp/dogo/com/dogo_android/databinding/CellLibraryArticleItemBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryArticleItemBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends n.c {

        private final a3 b;
        final /* synthetic */ n c;
        public a(a3 a3Var) {
            n.f(nVar, "this$0");
            n.f(a3Var, "binding");
            this.c = nVar;
            super(a3Var);
            this.b = a3Var;
            a3Var.w().setOnClickListener(new kotlinx.coroutines.d(nVar, this));
        }

        private static final void b(n nVar, n.a aVar, View view) {
            n.f(nVar, "this$0");
            n.f(aVar, "this$1");
            app.dogo.com.dogo_android.n.k.n.b bVar = nVar.a;
            if (bVar != null) {
                bVar.onArticleSelected((Article)nVar.getItemCount().get(aVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.n.k.n$c
        public final a3 c() {
            return this.b;
        }

        public static /* synthetic */ void d(n nVar, n.a aVar, View view) {
            ArticleListAdapter_ArticleItem.b(nVar, aVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends b<List<? extends Article>> {

        final /* synthetic */ Object a;
        final /* synthetic */ n b;
        public e(Object object, Object object2, n nVar) {
            this.a = object;
            this.b = nVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends Article> oldValue, List<? extends Article> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.n.d.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.p<Article, Article, Boolean> {

        public static final n.d a = new n$d();
        @Override // kotlin.d0.d.p
        public final boolean a(Article article, Article article2) {
            n.f(article, "o");
            n.f(article2, "n");
            return n.b(article.getArticleId(), article2.getArticleId());
        }


        d() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        ArticleListAdapter.c = new l[] { c0.f(new t(c0.b(ArticleListAdapter.class), "articles", "getArticles()Ljava/util/List;")) };
    }

    public /* synthetic */ n(n.b bVar, int i, g gVar) {
        app.dogo.com.dogo_android.n.k.n.b bVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(bVar2);
    }

    public static final /* synthetic */ n.b f(n nVar) {
        return nVar.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<Article> getItemCount() {
        return (List)this.callbacks.getValue(this, ArticleListAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(n.c holder, int position) {
        n.f(holder, "holder");
        z = holder instanceof ArticleListAdapter_ArticleItem;
        if (holder instanceof ArticleListAdapter_ArticleItem) {
            (ArticleListAdapter_ArticleItem)holder.c().V((Article)getItemCount().get(position));
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public n.c onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final a3 a3Var = a3.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(a3Var, "inflate(inflater, parent, false)");
        return new ArticleListAdapter_ArticleItem(this, a3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<Article> list) {
        n.f(list, "<set-?>");
        this.callbacks.setValue(this, ArticleListAdapter.c[0], list);
    }

    public n(n.b bVar) {
        super();
        this.a = bVar;
        List list = p.g();
        this.callbacks = new Delegates_observable_1(list, list, this);
    }

    public n() {
        final app.dogo.com.dogo_android.n.k.n.b bVar = null;
        this(bVar, 1, bVar);
    }
}
