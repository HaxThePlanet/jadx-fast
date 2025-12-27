package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.y.s.i.a;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentProgramLessonBinding.java */
/* loaded from: classes.dex */
public abstract class if extends ViewDataBinding {

    public final SwipeRefreshLayout O;
    public final MaterialToolbar P;
    protected app.dogo.com.dogo_android.y.s.l Q;
    protected i.a R;
    protected if(Object object, View view, int i, SwipeRefreshLayout swipeRefreshLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = swipeRefreshLayout;
        this.P = materialToolbar;
    }

    public static if T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return if.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static if U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (if)ViewDataBinding.z(layoutInflater, 2131558698, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(app.dogo.com.dogo_android.view.dailytraining.l lVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(app.dogo.com.dogo_android.y.s.l lVar);
}
