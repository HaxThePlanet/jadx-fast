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

/* loaded from: classes.dex */
public abstract class ga extends ViewDataBinding {

    public final ImageView O;
    public final app.dogo.com.dogo_android.h.ci P;
    public final FrameLayout Q;
    public final FrameLayout R;
    public final ObservableRecyclerView S;
    public final ImageView T;
    public final SwipeRefreshLayout U;
    public final TextView V;
    protected g0 W;
    protected a0 X;
    protected ga(Object object, View view2, int i3, ImageView imageView4, app.dogo.com.dogo_android.h.ci ci5, FrameLayout frameLayout6, FrameLayout frameLayout7, RelativeLayout relativeLayout8, ObservableRecyclerView observableRecyclerView9, ImageView imageView10, SwipeRefreshLayout swipeRefreshLayout11, TextView textView12) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = ci5;
        this.Q = frameLayout6;
        this.R = frameLayout7;
        this.S = observableRecyclerView9;
        this.T = imageView10;
        this.U = swipeRefreshLayout11;
        this.V = textView12;
    }

    public static app.dogo.com.dogo_android.h.ga T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ga.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ga U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ga)ViewDataBinding.z(layoutInflater, 2131558631, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(g0 g0);
}
