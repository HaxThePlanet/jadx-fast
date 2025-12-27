package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.y.w.l.b;
import app.dogo.com.dogo_android.y.w.o;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentProgramLessonsListBinding.java */
/* loaded from: classes.dex */
public abstract class qf extends ViewDataBinding {

    public final gm O;
    public final MaterialButton P;
    public final FrameLayout Q;
    public final ConstraintLayout R;
    public final NestedScrollView S;
    public final TextView T;
    public final TextView U;
    public final RecyclerView V;
    public final ConstraintLayout W;
    public final SwipeRefreshLayout X;
    public final MaterialToolbar Y;
    public final Button Z;
    protected o a0;
    protected l.b b0;
    protected Boolean c0;
    protected qf(Object object, View view, int i, gm gmVar, MaterialButton materialButton, FrameLayout frameLayout, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, TextView textView, TextView textView2, RecyclerView recyclerView, ConstraintLayout constraintLayout2, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar, Button button) {
        super(object, view, i);
        this.O = gmVar;
        this.P = materialButton;
        this.Q = frameLayout;
        this.R = constraintLayout;
        this.S = nestedScrollView;
        this.T = textView;
        this.U = textView2;
        this.V = recyclerView;
        this.W = constraintLayout2;
        this.X = swipeRefreshLayout;
        this.Y = materialToolbar;
        this.Z = button;
    }

    public static qf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qf)ViewDataBinding.z(layoutInflater, 2131558702, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l.b bVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(o oVar);
}
