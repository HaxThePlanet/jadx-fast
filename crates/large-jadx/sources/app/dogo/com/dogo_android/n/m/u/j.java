package app.dogo.com.dogo_android.n.m.u;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.i3;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep;
import app.dogo.com.dogo_android.util.d0.a;
import d.h.l.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0017\u0018B\u001f\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;", "trickSteps", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickStep;", "(Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setupTouchListener", "view", "Landroid/view/View;", "DefaultViewHolder", "TrickItemViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends RecyclerView.h<app.dogo.com.dogo_android.n.m.u.j.a> implements a {

    private final app.dogo.com.dogo_android.n.m.u.k a;
    private final List<TrickItem.TrickStep> b;

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$setupTouchListener$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends GestureDetector.SimpleOnGestureListener {

        final int a;
        final app.dogo.com.dogo_android.n.m.u.j b;
        c(int i, app.dogo.com.dogo_android.n.m.u.j j2) {
            this.a = i;
            this.b = j2;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int obj3;
            n.f(motionEvent, "e");
            final int i2 = 1;
            if (this.a != itemCount -= i2) {
                obj3 = j.f(this.b);
                if (obj3 == null) {
                } else {
                    obj3.t0();
                }
            }
            return i2;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a extends RecyclerView.e0 {

        private final ViewDataBinding a;
        public a(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.a = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$TrickItemViewHolder;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickStep2Binding;", "(Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter;Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickStep2Binding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickStep2Binding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends app.dogo.com.dogo_android.n.m.u.j.a {

        private final i3 b;
        public b(app.dogo.com.dogo_android.n.m.u.j j, i3 i32) {
            n.f(j, "this$0");
            n.f(i32, "binding");
            super(i32);
            this.b = i32;
        }

        @Override // app.dogo.com.dogo_android.n.m.u.j$a
        public final i3 b() {
            return this.b;
        }
    }
    public j(app.dogo.com.dogo_android.n.m.u.k k, List<TrickItem.TrickStep> list2) {
        n.f(list2, "trickSteps");
        super();
        this.a = k;
        this.b = list2;
    }

    public static final app.dogo.com.dogo_android.n.m.u.k f(app.dogo.com.dogo_android.n.m.u.j j) {
        return j.a;
    }

    public static boolean g(d d, View view2, MotionEvent motionEvent3) {
        return j.l(d, view2, motionEvent3);
    }

    private final void j(View view, int i2) {
        j.c cVar = new j.c(i2, this);
        d dVar = new d(view.getContext(), cVar);
        a obj5 = new a(dVar);
        view.setOnTouchListener(obj5);
    }

    private static final boolean l(d d, View view2, MotionEvent motionEvent3) {
        n.f(d, "$tapGestureDetector");
        n.f(view2, "touchView");
        d.a(motionEvent3);
        view2.performClick();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h(app.dogo.com.dogo_android.n.m.u.j.a j$a, int i2) {
        boolean z;
        String str;
        String str2;
        n.f(a, "holder");
        if (a instanceof j.b) {
            Object obj = a;
            (j.b)obj.b().V((TrickItem.TrickStep)this.b.get(i2));
            View view = obj.b().w();
            n.e(view, "holder.binding.root");
            j(view, i2);
            android.widget.ImageView view2 = i3Var4.P;
            n.e(view2, "holder.binding.image");
            j(view2, i2);
            z = i3Var.O;
            n.e(z, "holder.binding.description");
            j(z, i2);
        }
        a.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.n.m.u.j.a i(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final i3 obj3 = i3.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        j.b bVar = new j.b(this, obj3);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        h((j.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i(viewGroup, i2);
    }
}
