package app.dogo.com.dogo_android.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.y2;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B!\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u000c\u001a\u00020\u00082\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/dashboard/LessonCardTrickCoverGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/dashboard/LessonCardTrickCoverGridAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "callback", "Lkotlin/Function0;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class u extends RecyclerView.h<app.dogo.com.dogo_android.g.u.a> {

    private final List<TrickItem> a;
    private final a<w> b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dashboard/LessonCardTrickCoverGridAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;", "(Lapp/dogo/com/dogo_android/dashboard/LessonCardTrickCoverGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends RecyclerView.e0 {

        private final y2 a;
        final app.dogo.com.dogo_android.g.u b;
        public a(app.dogo.com.dogo_android.g.u u, y2 y22) {
            n.f(u, "this$0");
            n.f(y22, "binding");
            this.b = u;
            super(y22.w());
            this.a = y22;
            k kVar = new k(u);
            y22.w().setOnClickListener(kVar);
        }

        private static final void a(app.dogo.com.dogo_android.g.u u, View view2) {
            n.f(u, "this$0");
            u.f(u).invoke();
        }

        public static void c(app.dogo.com.dogo_android.g.u u, View view2) {
            u.a.a(u, view2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final y2 b() {
            return this.a;
        }
    }
    public u(List<TrickItem> list, a<w> a2) {
        n.f(list, "list");
        n.f(a2, "callback");
        super();
        this.a = list;
        this.b = a2;
    }

    public static final a f(app.dogo.com.dogo_android.g.u u) {
        return u.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void g(app.dogo.com.dogo_android.g.u.a u$a, int i2) {
        n.f(a, "holder");
        a.b().V((TrickItem)this.a.get(i2));
        a.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.g.u.a h(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final y2 obj3 = y2.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        u.a aVar = new u.a(this, obj3);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        g((u.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return h(viewGroup, i2);
    }
}
