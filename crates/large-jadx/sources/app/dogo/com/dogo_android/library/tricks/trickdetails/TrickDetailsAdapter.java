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

/* compiled from: TrickDetailsAdapter.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0017\u0018B\u001f\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$DefaultViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;", "trickSteps", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickStep;", "(Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setupTouchListener", "view", "Landroid/view/View;", "DefaultViewHolder", "TrickItemViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class TrickDetailsAdapter extends RecyclerView.h<j.a> implements a {

    /* renamed from: a, reason: from kotlin metadata */
    private final k callbacks;
    /* renamed from: b, reason: from kotlin metadata */
    private final List<TrickItem.TrickStep> trickSteps;

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$setupTouchListener$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends GestureDetector.SimpleOnGestureListener {

        final /* synthetic */ int a;
        final /* synthetic */ j b;
        c(int i, j jVar) {
            this.a = i;
            this.b = jVar;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            n.f(e, "e");
            final int i3 = 1;
            if (this.a != this.b.getItemCount() - i3) {
                app.dogo.com.dogo_android.n.m.u.k kVar = this.b.callbacks;
                if (kVar != null) {
                    kVar.t0();
                }
            }
            return true;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$DefaultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public a(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$TrickItemViewHolder;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter$DefaultViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickStep2Binding;", "(Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapter;Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickStep2Binding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellLibraryTrickStep2Binding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends j.a {

        private final i3 b;
        public b(i3 i3Var) {
            n.f(jVar, "this$0");
            n.f(i3Var, "binding");
            super(i3Var);
            this.b = i3Var;
        }

        @Override // app.dogo.com.dogo_android.n.m.u.j$a
        public final i3 b() {
            return this.b;
        }
    }
    public j(k kVar, List<TrickItem.TrickStep> list) {
        n.f(list, "trickSteps");
        super();
        this.callbacks = kVar;
        this.trickSteps = list;
    }

    public static final /* synthetic */ k f(j jVar) {
        return jVar.callbacks;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final void onBindViewHolder(View holder, int position) {
        holder.setOnTouchListener(new app.dogo.com.dogo_android.library.tricks.trickdetails.a(new d(holder.getContext(), new TrickDetailsAdapter_setupTouchListener_tapGestureDetector_1(position, this))));
    }

    private static final boolean l(d dVar, View view, MotionEvent motionEvent) {
        n.f(dVar, "$tapGestureDetector");
        n.f(view, "touchView");
        dVar.a(motionEvent);
        view.performClick();
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.trickSteps.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onCreateViewHolder(j.a parent, int viewType) {
        n.f(parent, "holder");
        z = parent instanceof TrickDetailsAdapter_TrickItemViewHolder;
        if (parent instanceof TrickDetailsAdapter_TrickItemViewHolder) {
            Object parent2 = parent;
            parent2.b().V((TrickItem_TrickStep)this.trickSteps.get(viewType));
            View view = parent2.b().w();
            n.e(view, "holder.binding.root");
            onBindViewHolder(view, viewType);
            str2 = "holder.binding.image";
            n.e(imageView, str2);
            onBindViewHolder(imageView, viewType);
            str = "holder.binding.description";
            n.e(textView, str);
            onBindViewHolder(textView, viewType);
        }
        parent.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public j.a setupTouchListener(ViewGroup view, int position) {
        n.f(view, "parent");
        final i3 i3Var = i3.T(LayoutInflater.from(view.getContext()), view, false);
        n.e(i3Var, "inflate(inflater, parent, false)");
        return new TrickDetailsAdapter_TrickItemViewHolder(this, i3Var);
    }

    public static /* synthetic */ boolean g(d dVar, View view, MotionEvent motionEvent) {
        return TrickDetailsAdapter.l(dVar, view, motionEvent);
    }
}
