package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.c.i;

/* loaded from: classes.dex */
public abstract class ig extends ViewDataBinding {
    protected ig(Object object, View view2, int i3, ImageButton imageButton4, View view5, SurfaceView surfaceView6) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.ig T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ig.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ig U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ig)ViewDataBinding.z(layoutInflater, 2131558711, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i i);
}
