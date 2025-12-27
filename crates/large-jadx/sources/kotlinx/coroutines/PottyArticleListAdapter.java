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
import app.dogo.com.dogo_android.util.d0.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: PottyArticleListAdapter.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u001b\u001cB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$Callback;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$Callback;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "DefaultViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class PottyArticleListAdapter extends RecyclerView.h<j.b> implements app.dogo.com.dogo_android.util.d0.a {

    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final j.a callback;
    private final c b = new j$d();

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$Callback;", "", "onArticleSelected", "", "article", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: i1, reason: from kotlin metadata */
        void onArticleSelected(ArticleWithStatus article);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewArticleBinding;", "(Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter;Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewArticleBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellPottyOverviewArticleBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final s3 a;
        final /* synthetic */ j b;
        public b(s3 s3Var) {
            n.f(jVar, "this$0");
            n.f(s3Var, "binding");
            this.b = jVar;
            super(s3Var.w());
            this.a = s3Var;
            s3Var.w().setOnClickListener(new kotlinx.coroutines.a(jVar, this));
        }

        private static final void a(j jVar, j.b bVar, View view) {
            n.f(jVar, "this$0");
            n.f(bVar, "this$1");
            jVar.callback.onArticleSelected((ArticleWithStatus)jVar.getItemCount().get(bVar.getAdapterPosition()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final s3 b() {
            return this.a;
        }

        public static /* synthetic */ void c(j jVar, j.b bVar, View view) {
            PottyArticleListAdapter_DefaultViewHolder.a(jVar, bVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class d extends b<List<? extends ArticleWithStatus>> {

        final /* synthetic */ Object a;
        final /* synthetic */ j b;
        public d(Object object, Object object2, j jVar) {
            this.a = object;
            this.b = jVar;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends ArticleWithStatus> oldValue, List<? extends ArticleWithStatus> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, kotlinx.coroutines.j.c.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.p<ArticleWithStatus, ArticleWithStatus, Boolean> {

        public static final j.c a = new j$c();
        @Override // kotlin.d0.d.p
        public final boolean a(ArticleWithStatus articleWithStatus, ArticleWithStatus articleWithStatus2) {
            n.f(articleWithStatus, "o");
            n.f(articleWithStatus2, "n");
            return n.b(articleWithStatus.getArticle().getArticleId(), articleWithStatus2.getArticle().getArticleId());
        }


        c() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        PottyArticleListAdapter.c = new l[] { c0.f(new t(c0.b(PottyArticleListAdapter.class), "items", "getItems()Ljava/util/List;")) };
    }

    public j(j.a aVar) {
        n.f(aVar, "callback");
        super();
        this.callback = aVar;
        List list = p.g();
        app.dogo.com.dogo_android.u.n.j.d delegates_observable_1 = new Delegates_observable_1(list, list, this);
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
    public final List<ArticleWithStatus> getItemCount() {
        return (List)this.b.getValue(this, PottyArticleListAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(j.b holder, int position) {
        n.f(holder, "holder");
        holder.b().V((ArticleWithStatus)getItemCount().get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public j.b onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final s3 s3Var = s3.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(s3Var, "inflate(inflater, parent, false)");
        return new PottyArticleListAdapter_DefaultViewHolder(this, s3Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<ArticleWithStatus> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, PottyArticleListAdapter.c[0], list);
    }
}
