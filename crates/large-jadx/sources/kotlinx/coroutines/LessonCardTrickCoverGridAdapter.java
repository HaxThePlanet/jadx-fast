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

/* compiled from: LessonCardTrickCoverGridAdapter.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B!\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u000c\u001a\u00020\u00082\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/dashboard/LessonCardTrickCoverGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/dashboard/LessonCardTrickCoverGridAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "callback", "Lkotlin/Function0;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u, reason: from kotlin metadata */
public final class LessonCardTrickCoverGridAdapter extends RecyclerView.h<u.a> {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<TrickItem> callback;
    /* renamed from: b, reason: from kotlin metadata */
    private final a<w> list;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dashboard/LessonCardTrickCoverGridAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;", "(Lapp/dogo/com/dogo_android/dashboard/LessonCardTrickCoverGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends RecyclerView.e0 {

        private final y2 a;
        final /* synthetic */ u b;
        public a(y2 y2Var) {
            n.f(uVar, "this$0");
            n.f(y2Var, "binding");
            this.b = uVar;
            super(y2Var.w());
            this.a = y2Var;
            y2Var.w().setOnClickListener(new kotlinx.coroutines.k(uVar));
        }

        private static final void a(u uVar, View view) {
            n.f(uVar, "this$0");
            uVar.list.invoke();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final y2 b() {
            return this.a;
        }

        public static /* synthetic */ void c(u uVar, View view) {
            LessonCardTrickCoverGridAdapter_Holder.a(uVar, view);
        }
    }
    public u(List<TrickItem> list, a<w> aVar) {
        n.f(list, "list");
        n.f(aVar, "callback");
        super();
        this.callback = list;
        this.list = aVar;
    }

    public static final /* synthetic */ a f(u uVar) {
        return uVar.list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public void onBindViewHolder(u.a holder, int position) {
        n.f(holder, "holder");
        holder.b().V((TrickItem)this.callback.get(position));
        holder.b().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callback.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public u.a onCreateViewHolder(ViewGroup parent, int viewType) {
        n.f(parent, "parent");
        final y2 y2Var = y2.T(LayoutInflater.from(parent.getContext()), parent, false);
        n.e(y2Var, "inflate(inflater, parent, false)");
        return new LessonCardTrickCoverGridAdapter_Holder(this, y2Var);
    }
}
