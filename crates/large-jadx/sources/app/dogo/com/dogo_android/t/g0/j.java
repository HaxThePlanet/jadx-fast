package app.dogo.com.dogo_android.t.g0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.q2;
import app.dogo.com.dogo_android.repository.domain.Article;
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
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001b\u001c\u001dB\u000f\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "faqList", "getFaqList", "()Ljava/util/List;", "setFaqList", "(Ljava/util/List;)V", "faqList$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Holder", "QuestionHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends RecyclerView.h<app.dogo.com.dogo_android.t.g0.j.b> implements a {

    static final l<Object>[] c;
    private final app.dogo.com.dogo_android.t.g0.j.a a;
    private final c b;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Callbacks;", "", "onArticleSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void a(Article article);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$QuestionHolder;", "Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellFaqListRowBinding;", "(Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter;Lapp/dogo/com/dogo_android/databinding/CellFaqListRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellFaqListRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.t.g0.j.b {

        private final q2 b;
        final app.dogo.com.dogo_android.t.g0.j c;
        public c(app.dogo.com.dogo_android.t.g0.j j, q2 q22) {
            n.f(j, "this$0");
            n.f(q22, "binding");
            this.c = j;
            super(q22);
            this.b = q22;
            d dVar = new d(j, this);
            q22.w().setOnClickListener(dVar);
        }

        private static final void b(app.dogo.com.dogo_android.t.g0.j j, app.dogo.com.dogo_android.t.g0.j.c j$c2, View view3) {
            Object obj0;
            Object obj1;
            n.f(j, "this$0");
            n.f(c2, "this$1");
            app.dogo.com.dogo_android.t.g0.j.a obj2 = j.f(j);
            if (obj2 == null) {
            } else {
                obj2.a((Article)j.g().get(c2.getAdapterPosition()));
            }
        }

        public static void d(app.dogo.com.dogo_android.t.g0.j j, app.dogo.com.dogo_android.t.g0.j.c j$c2, View view3) {
            j.c.b(j, c2, view3);
        }

        @Override // app.dogo.com.dogo_android.t.g0.j$b
        public final q2 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends b<List<? extends Article>> {

        final Object a;
        final app.dogo.com.dogo_android.t.g0.j b;
        public e(Object object, Object object2, app.dogo.com.dogo_android.t.g0.j j3) {
            this.a = object;
            this.b = j3;
            super(object2);
        }

        protected void afterChange(l<?> l, List<? extends Article> list2, List<? extends Article> list3) {
            n.f(l, "property");
            final app.dogo.com.dogo_android.t.g0.j obj2 = this.b;
            obj2.autoNotify(obj2, (List)list2, (List)list3, j.d.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements p<Article, Article, Boolean> {

        public static final app.dogo.com.dogo_android.t.g0.j.d a;
        static {
            j.d dVar = new j.d();
            j.d.a = dVar;
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
        t tVar = new t(c0.b(j.class), "faqList", "getFaqList()Ljava/util/List;");
        j.c = arr;
    }

    public j(app.dogo.com.dogo_android.t.g0.j.a j$a) {
        super();
        this.a = a;
        a obj2 = a.a;
        obj2 = p.g();
        j.e eVar = new j.e(obj2, obj2, this);
        this.b = eVar;
    }

    public static final app.dogo.com.dogo_android.t.g0.j.a f(app.dogo.com.dogo_android.t.g0.j j) {
        return j.a;
    }

    public <T> void autoNotify(RecyclerView.h<?> recyclerView$h, List<? extends T> list2, List<? extends T> list3, p<? super T, ? super T, Boolean> p4) {
        a.a.a(this, h, list2, list3, p4);
    }

    public final List<Article> g() {
        return (List)this.b.getValue(this, j.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return g().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.t.g0.j.b j$b, int i2) {
        boolean z;
        List list;
        int obj4;
        n.f(b, "holder");
        if (b instanceof j.c) {
            (j.c)b.c().V((Article)g().get(i2));
        }
        b.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.t.g0.j.b i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final q2 obj3 = q2.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        j.c cVar = new j.c(this, obj3);
        return cVar;
    }

    public final void j(List<Article> list) {
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
