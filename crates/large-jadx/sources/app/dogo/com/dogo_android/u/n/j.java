package app.dogo.com.dogo_android.u.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.s3;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;
import app.dogo.com.dogo_android.util.d0.a;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.t;
import kotlin.f0.a;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u001b\u001cB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends RecyclerView.h<app.dogo.com.dogo_android.u.n.j.b> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.u.n.j.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$Callback;", "", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void i1(ArticleWithStatus articleWithStatus);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewArticleBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter;Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewArticleBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewArticleBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final s3 a;
        final app.dogo.com.dogo_android.u.n.j b;
        public b(app.dogo.com.dogo_android.u.n.j j, s3 s32) {
            n.f(j, "this$0");
            n.f(s32, "binding");
            this.b = j;
            super(s32.w());
            this.a = s32;
            a aVar = new a(j, this);
            s32.w().setOnClickListener(aVar);
        }

        private static final void a(app.dogo.com.dogo_android.u.n.j j, app.dogo.com.dogo_android.u.n.j.b j$b2, View view3) {
            n.f(j, "this$0");
            n.f(b2, "this$1");
            j.f(j).i1((ArticleWithStatus)j.g().get(b2.getAdapterPosition()));
        }

        public static void c(app.dogo.com.dogo_android.u.n.j j, app.dogo.com.dogo_android.u.n.j.b j$b2, View view3) {
            j.b.a(j, b2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final s3 b() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends ArticleWithStatus>> {

        final Object a;
        final app.dogo.com.dogo_android.u.n.j b;
        public d(Object object, Object object2, app.dogo.com.dogo_android.u.n.j j3) {
            this.a = object;
            this.b = j3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends ArticleWithStatus> list2, List<? extends ArticleWithStatus> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.u.n.j obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, j.c.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements p<ArticleWithStatus, ArticleWithStatus, Boolean> {

        public static final app.dogo.com.dogo_android.u.n.j.c a;
        static {
            j.c cVar = new j.c();
            j.c.a = cVar;
        }

        c() {
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(ArticleWithStatus articleWithStatus, ArticleWithStatus articleWithStatus2) {
            n.f(articleWithStatus, "o");
            n.f(articleWithStatus2, "n");
            return n.b(articleWithStatus.getArticle().getArticleId(), articleWithStatus2.getArticle().getArticleId());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            return Boolean.valueOf(a((ArticleWithStatus)object, (ArticleWithStatus)object2));
        }
    }
    static {
        l[] arr = new l[1];
        t tVar = new t(c0.b(j.class), "items", "getItems()Ljava/util/List;");
        j.c = arr;
    }

    public j(app.dogo.com.dogo_android.u.n.j.a j$a) {
        n.f(a, "callback");
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        j.d dVar = new j.d(obj2, obj2, this);
        this.b = dVar;
    }

    public static final app.dogo.com.dogo_android.u.n.j.a f(app.dogo.com.dogo_android.u.n.j j) {
        return j.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<ArticleWithStatus> g() {
        return (List)this.b.getValue(this, j.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.u.n.j.b j$b, int i2) {
        n.f(b, "holder");
        b.b().V((ArticleWithStatus)g().get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.u.n.j.b i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final s3 obj3 = s3.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        j.b bVar = new j.b(this, obj3);
        return bVar;
    }

    public final void j(List<ArticleWithStatus> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, j.c[0], list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((j.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
