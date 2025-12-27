package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.y.o.u.b;
import app.dogo.com.dogo_android.y.o.x;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentProgramLessonExamListBinding.java */
/* loaded from: classes.dex */
public abstract class mf extends ViewDataBinding {

    public final RecyclerView O;
    public final SwipeRefreshLayout P;
    public final MaterialToolbar Q;
    protected x R;
    protected u.b S;
    protected mf(Object object, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = swipeRefreshLayout;
        this.Q = materialToolbar;
    }

    public static mf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return mf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static mf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (mf)ViewDataBinding.z(layoutInflater, 2131558700, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(u.b bVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(x xVar);
}
