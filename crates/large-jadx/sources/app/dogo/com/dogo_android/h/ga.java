package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.util.e0.a0;
import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;

/* compiled from: FragmentChallengeHomeBinding.java */
/* loaded from: classes.dex */
public abstract class ga extends ViewDataBinding {

    public final ImageView O;
    public final ci P;
    public final FrameLayout Q;
    public final FrameLayout R;
    public final ObservableRecyclerView S;
    public final ImageView T;
    public final SwipeRefreshLayout U;
    public final TextView V;
    protected g0 W;
    protected a0 X;
    protected ga(Object object, View view, int i, ImageView imageView, ci ciVar, FrameLayout frameLayout, FrameLayout frameLayout2, RelativeLayout relativeLayout, ObservableRecyclerView observableRecyclerView, ImageView imageView2, SwipeRefreshLayout swipeRefreshLayout, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = ciVar;
        this.Q = frameLayout;
        this.R = frameLayout2;
        this.S = observableRecyclerView;
        this.T = imageView2;
        this.U = swipeRefreshLayout;
        this.V = textView;
    }

    public static ga T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ga.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ga U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ga)ViewDataBinding.z(layoutInflater, 2131558631, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(g0 g0Var);
}
