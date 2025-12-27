package app.dogo.com.dogo_android.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.u7;
import app.dogo.com.dogo_android.h.y2;
import app.dogo.com.dogo_android.repository.domain.TrickCover;
import app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: WorkoutCardTrickCoverGridAdapter.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 \u00142\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004\u0014\u0015\u0016\u0017B!\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00082\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickCover;", "callback", "Lkotlin/Function0;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "Holder", "TrickCountHolder", "TrickCoverHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f0, reason: from kotlin metadata */
public final class WorkoutCardTrickCoverGridAdapter extends RecyclerView.h<f0.b> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final f0.a INSTANCE = new f0$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final List<TrickCover> callback;
    /* renamed from: b, reason: from kotlin metadata */
    private final a<w> list;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Companion;", "", "()V", "MAX_DISPLAYED_TRICKS_IN_DASHBOARD", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class e {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[TrickCover_CoverType.values().length];
            iArr[TrickCover_CoverType.TRICK.ordinal()] = 1;
            iArr[TrickCover_CoverType.UNDISPLAYED_TRICK.ordinal()] = 2;
            kotlinx.coroutines.f0.e.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public class b extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public b(ViewDataBinding viewDataBinding) {
            n.f(f0Var, "this$0");
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$TrickCountHolder;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Holder;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellTrickNumberBubbleBinding;", "(Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellTrickNumberBubbleBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellTrickNumberBubbleBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends f0.b {

        private final u7 b;
        final /* synthetic */ f0 c;
        public c(u7 u7Var) {
            n.f(f0Var, "this$0");
            n.f(u7Var, "binding");
            this.c = f0Var;
            super(f0Var, u7Var);
            this.b = u7Var;
            u7Var.w().setOnClickListener(new kotlinx.coroutines.l(f0Var));
        }

        private static final void b(f0 f0Var, View view) {
            n.f(f0Var, "this$0");
            f0Var.list.invoke();
        }

        @Override // app.dogo.com.dogo_android.g.f0$b
        public final u7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(f0 f0Var, View view) {
            WorkoutCardTrickCoverGridAdapter_TrickCountHolder.b(f0Var, view);
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$TrickCoverHolder;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Holder;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;", "(Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends f0.b {

        private final y2 b;
        final /* synthetic */ f0 c;
        public d(y2 y2Var) {
            n.f(f0Var, "this$0");
            n.f(y2Var, "binding");
            this.c = f0Var;
            super(f0Var, y2Var);
            this.b = y2Var;
            y2Var.w().setOnClickListener(new kotlinx.coroutines.m(f0Var));
        }

        private static final void b(f0 f0Var, View view) {
            n.f(f0Var, "this$0");
            f0Var.list.invoke();
        }

        @Override // app.dogo.com.dogo_android.g.f0$b
        public final y2 c() {
            return this.b;
        }

        public static /* synthetic */ void d(f0 f0Var, View view) {
            WorkoutCardTrickCoverGridAdapter_TrickCoverHolder.b(f0Var, view);
        }
    }
    public f0(List<TrickCover> list, a<w> aVar) {
        n.f(list, "list");
        n.f(aVar, "callback");
        super();
        this.callback = list;
        this.list = aVar;
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ a getItemViewType(f0 position) {
        return position.list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public void onBindViewHolder(f0.b holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof WorkoutCardTrickCoverGridAdapter_TrickCoverHolder) {
            (WorkoutCardTrickCoverGridAdapter_TrickCoverHolder)holder.c().V((TrickCover)this.callback.get(position).getTrickItem());
        } else {
            if (holder instanceof WorkoutCardTrickCoverGridAdapter_TrickCountHolder) {
                (WorkoutCardTrickCoverGridAdapter_TrickCountHolder)holder.c().V(String.valueOf((TrickCover)this.callback.get(position).getUndisplayedTrickCount()));
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callback.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (TrickCover)this.callback.get(i).getCoverType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public f0.b onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.g.f0.c workoutCardTrickCoverGridAdapter_TrickCountHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = kotlinx.coroutines.f0.e.a[TrickCover_CoverType.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                u7 u7Var = u7.T(from, parent, z);
                n.e(u7Var, str2);
                workoutCardTrickCoverGridAdapter_TrickCountHolder = new WorkoutCardTrickCoverGridAdapter_TrickCountHolder(this, u7Var);
                return workoutCardTrickCoverGridAdapter_TrickCountHolder;
            }
        }
        y2 y2Var = y2.T(from, parent, z);
        n.e(y2Var, str2);
        app.dogo.com.dogo_android.g.f0.d workoutCardTrickCoverGridAdapter_TrickCoverHolder = new WorkoutCardTrickCoverGridAdapter_TrickCoverHolder(this, y2Var);
    }

}
