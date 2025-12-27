package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.q.s.b.b;

/* compiled from: DialogDogParentsBinding.java */
/* loaded from: classes.dex */
public abstract class y8 extends ViewDataBinding {

    public final Button O;
    public final Button P;
    public final RecyclerView Q;
    public final SwipeRefreshLayout R;
    protected app.dogo.com.dogo_android.q.s.f S;
    protected b.b T;
    protected y8(Object object, View view, int i, Button button, Button button2, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = button2;
        this.Q = recyclerView;
        this.R = swipeRefreshLayout;
    }

    public static y8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y8)ViewDataBinding.z(layoutInflater, 2131558600, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b.b bVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(app.dogo.com.dogo_android.q.s.f fVar);
}
