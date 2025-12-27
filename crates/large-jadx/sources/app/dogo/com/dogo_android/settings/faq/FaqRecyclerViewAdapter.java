package app.dogo.com.dogo_android.t.g0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.q2;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: FaqRecyclerViewAdapter.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001b\u001c\u001dB\u000f\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "faqList", "getFaqList", "()Ljava/util/List;", "setFaqList", "(Ljava/util/List;)V", "faqList$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callbacks", "Holder", "QuestionHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class FaqRecyclerViewAdapter extends RecyclerView.h<j.b> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final j.a callback;
    private final c b = new j$e();

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Callbacks;", "", "onArticleSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: a, reason: from kotlin metadata */
        void onArticleSelected(Article item);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class b extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public b(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$QuestionHolder;", "Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellFaqListRowBinding;", "(Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter;Lapp/dogo/com/dogo_android/databinding/CellFaqListRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellFaqListRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends j.b {

        private final q2 b;
        final /* synthetic */ j c;
        public c(q2 q2Var) {
            n.f(jVar, "this$0");
            n.f(q2Var, "binding");
            this.c = jVar;
            super(q2Var);
            this.b = q2Var;
            q2Var.w().setOnClickListener(new app.dogo.com.dogo_android.settings.faq.d(jVar, this));
        }

        private static final void b(j jVar, j.c cVar, View view) {
            n.f(jVar, "this$0");
            n.f(cVar, "this$1");
            app.dogo.com.dogo_android.t.g0.j.a aVar = jVar.callback;
            if (aVar != null) {
                aVar.onArticleSelected((Article)jVar.getItemCount().get(cVar.getAdapterPosition()));
            }
        }

        @Override // app.dogo.com.dogo_android.t.g0.j$b
        public final q2 c() {
            return this.b;
        }

        public static /* synthetic */ void d(j jVar, j.c cVar, View view) {
            FaqRecyclerViewAdapter_QuestionHolder.b(jVar, cVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends b<List<? extends Article>> {

        final /* synthetic */ Object a;
        final /* synthetic */ j b;
        public e(Object object, Object object2, j jVar) {
            this.a = object;
            this.b = jVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends Article> oldValue, List<? extends Article> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.settings.faq.j.d.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.p<Article, Article, Boolean> {

        public static final j.d a = new j$d();
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
        FaqRecyclerViewAdapter.c = new l[] { c0.f(new t(c0.b(FaqRecyclerViewAdapter.class), "faqList", "getFaqList()Ljava/util/List;")) };
    }

    public j(j.a aVar) {
        super();
        this.callback = aVar;
        List list = p.g();
        final app.dogo.com.dogo_android.t.g0.j.e delegates_observable_1 = new Delegates_observable_1(list, list, this);
    }

    public static final /* synthetic */ j.a f(j jVar) {
        return jVar.callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<Article> getItemCount() {
        return (List)this.b.getValue(this, FaqRecyclerViewAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(j.b holder, int position) {
        n.f(holder, "holder");
        z = holder instanceof FaqRecyclerViewAdapter_QuestionHolder;
        if (holder instanceof FaqRecyclerViewAdapter_QuestionHolder) {
            (FaqRecyclerViewAdapter_QuestionHolder)holder.c().V((Article)getItemCount().get(position));
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public j.b onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final q2 q2Var = q2.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(q2Var, "inflate(inflater, parent, false)");
        return new FaqRecyclerViewAdapter_QuestionHolder(this, q2Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<Article> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, FaqRecyclerViewAdapter.c[0], list);
    }
}
