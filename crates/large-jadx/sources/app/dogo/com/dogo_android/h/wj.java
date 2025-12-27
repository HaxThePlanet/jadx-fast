package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.util.customview.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;

/* compiled from: LayoutDashboardSubscribeBinding.java */
/* loaded from: classes.dex */
public abstract class wj extends ViewDataBinding {

    public final MaterialButton O;
    protected o P;
    protected wj(Object object, View view, int i, TextView textView, ShimmerFrameLayout shimmerFrameLayout, MaterialButton materialButton, TextView textView2) {
        super(object, view, i);
        this.O = materialButton;
    }

    public static wj T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wj.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wj U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wj)ViewDataBinding.z(layoutInflater, 2131558766, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o oVar);
}
