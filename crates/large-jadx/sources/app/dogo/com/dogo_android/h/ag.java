package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.y.c0.g;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentProgramTaskBinding.java */
/* loaded from: classes.dex */
public abstract class ag extends ViewDataBinding {

    public final MaterialToolbar O;
    protected app.dogo.com.dogo_android.y.c0.f P;
    protected g Q;
    protected ag(Object object, View view, int i, CardView cardView, TextView textView, ImageView imageView, TextView textView2, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = materialToolbar;
    }

    public static ag T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ag.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ag U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ag)ViewDataBinding.z(layoutInflater, 2131558707, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(app.dogo.com.dogo_android.y.c0.f fVar);
}
