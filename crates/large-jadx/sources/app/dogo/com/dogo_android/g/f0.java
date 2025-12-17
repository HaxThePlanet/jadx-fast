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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 \u00142\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004\u0014\u0015\u0016\u0017B!\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00082\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickCover;", "callback", "Lkotlin/Function0;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "Holder", "TrickCountHolder", "TrickCoverHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f0 extends RecyclerView.h<app.dogo.com.dogo_android.g.f0.b> {

    public static final app.dogo.com.dogo_android.g.f0.a Companion;
    private final List<TrickCover> a;
    private final a<w> b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Companion;", "", "()V", "MAX_DISPLAYED_TRICKS_IN_DASHBOARD", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class e {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[TrickCover.CoverType.TRICK.ordinal()] = 1;
            iArr[TrickCover.CoverType.UNDISPLAYED_TRICK.ordinal()] = 2;
            f0.e.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public class b extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public b(app.dogo.com.dogo_android.g.f0 f0, ViewDataBinding viewDataBinding2) {
            n.f(f0, "this$0");
            n.f(viewDataBinding2, "bind");
            super(viewDataBinding2.w());
            this.a = viewDataBinding2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$TrickCountHolder;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Holder;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellTrickNumberBubbleBinding;", "(Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellTrickNumberBubbleBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellTrickNumberBubbleBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c extends app.dogo.com.dogo_android.g.f0.b {

        private final u7 b;
        final app.dogo.com.dogo_android.g.f0 c;
        public c(app.dogo.com.dogo_android.g.f0 f0, u7 u72) {
            n.f(f0, "this$0");
            n.f(u72, "binding");
            this.c = f0;
            super(f0, u72);
            this.b = u72;
            l lVar = new l(f0);
            u72.w().setOnClickListener(lVar);
        }

        private static final void b(app.dogo.com.dogo_android.g.f0 f0, View view2) {
            n.f(f0, "this$0");
            f0.f(f0).invoke();
        }

        public static void d(app.dogo.com.dogo_android.g.f0 f0, View view2) {
            f0.c.b(f0, view2);
        }

        @Override // app.dogo.com.dogo_android.g.f0$b
        public final u7 c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$TrickCoverHolder;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter$Holder;", "Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;", "(Lapp/dogo/com/dogo_android/dashboard/WorkoutCardTrickCoverGridAdapter;Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLessonTrickBubbleBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.g.f0.b {

        private final y2 b;
        final app.dogo.com.dogo_android.g.f0 c;
        public d(app.dogo.com.dogo_android.g.f0 f0, y2 y22) {
            n.f(f0, "this$0");
            n.f(y22, "binding");
            this.c = f0;
            super(f0, y22);
            this.b = y22;
            m mVar = new m(f0);
            y22.w().setOnClickListener(mVar);
        }

        private static final void b(app.dogo.com.dogo_android.g.f0 f0, View view2) {
            n.f(f0, "this$0");
            f0.f(f0).invoke();
        }

        public static void d(app.dogo.com.dogo_android.g.f0 f0, View view2) {
            f0.d.b(f0, view2);
        }

        @Override // app.dogo.com.dogo_android.g.f0$b
        public final y2 c() {
            return this.b;
        }
    }
    static {
        f0.a aVar = new f0.a(0);
        f0.Companion = aVar;
    }

    public f0(List<TrickCover> list, a<w> a2) {
        n.f(list, "list");
        n.f(a2, "callback");
        super();
        this.a = list;
        this.b = a2;
    }

    public static final a f(app.dogo.com.dogo_android.g.f0 f0) {
        return f0.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void g(app.dogo.com.dogo_android.g.f0.b f0$b, int i2) {
        y2 y2Var;
        List list;
        app.dogo.com.dogo_android.repository.domain.TrickItem obj4;
        n.f(b, "holder");
        if (b instanceof f0.d) {
            (f0.d)b.c().V((TrickCover)this.a.get(i2).getTrickItem());
        } else {
            if (b instanceof f0.c) {
                (f0.c)b.c().V(String.valueOf((TrickCover)this.a.get(i2).getUndisplayedTrickCount()));
            }
        }
        b.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return (TrickCover)this.a.get(i).getCoverType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.g.f0.b h(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.g.f0.b obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = f0.e.a[TrickCover.CoverType.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
            } else {
                obj5 = u7.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new f0.c(this, obj5);
                return obj6;
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = y2.T(from, viewGroup, i3);
        n.e(obj5, str2);
        obj6 = new f0.d(this, obj5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        g((f0.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return h(viewGroup, i2);
    }
}
