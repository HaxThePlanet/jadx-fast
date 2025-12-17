package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.q.s.b.b;
import app.dogo.com.dogo_android.q.s.f;

/* loaded from: classes.dex */
public abstract class y8 extends ViewDataBinding {

    public final Button O;
    public final Button P;
    public final RecyclerView Q;
    public final SwipeRefreshLayout R;
    protected f S;
    protected b.b T;
    protected y8(Object object, View view2, int i3, Button button4, Button button5, ImageView imageView6, ImageView imageView7, RecyclerView recyclerView8, SwipeRefreshLayout swipeRefreshLayout9, TextView textView10) {
        super(object, view2, i3);
        this.O = button4;
        this.P = button5;
        this.Q = recyclerView8;
        this.R = swipeRefreshLayout9;
    }

    public static app.dogo.com.dogo_android.h.y8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return y8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (y8)ViewDataBinding.z(layoutInflater, 2131558600, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b.b b$b);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(f f);
}
