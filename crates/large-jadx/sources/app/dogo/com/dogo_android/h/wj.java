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

/* loaded from: classes.dex */
public abstract class wj extends ViewDataBinding {

    public final MaterialButton O;
    protected o P;
    protected wj(Object object, View view2, int i3, TextView textView4, ShimmerFrameLayout shimmerFrameLayout5, MaterialButton materialButton6, TextView textView7) {
        super(object, view2, i3);
        this.O = materialButton6;
    }

    public static app.dogo.com.dogo_android.h.wj T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return wj.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.wj U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (wj)ViewDataBinding.z(layoutInflater, 2131558766, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o o);
}
