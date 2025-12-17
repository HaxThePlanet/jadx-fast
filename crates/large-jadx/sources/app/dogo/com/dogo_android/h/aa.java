package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.u.m.v.a;
import app.dogo.com.dogo_android.u.m.x;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class aa extends ViewDataBinding {

    public final ConstraintLayout O;
    public final MaterialButton P;
    public final RecyclerView Q;
    public final ImageView R;
    public final FrameLayout S;
    public final MaterialToolbar T;
    public final ImageView U;
    public final TextView V;
    protected x W;
    protected v.a X;
    protected aa(Object object, View view2, int i3, ConstraintLayout constraintLayout4, TextView textView5, ImageView imageView6, MaterialButton materialButton7, RecyclerView recyclerView8, NestedScrollView nestedScrollView9, ImageView imageView10, TextView textView11, FrameLayout frameLayout12, MaterialToolbar materialToolbar13, ImageView imageView14, TextView textView15, View view16) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = constraintLayout4;
        obj.P = materialButton7;
        obj.Q = recyclerView8;
        obj.R = imageView10;
        obj.S = frameLayout12;
        obj.T = materialToolbar13;
        obj.U = imageView14;
        obj.V = textView15;
    }

    public static app.dogo.com.dogo_android.h.aa T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return aa.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.aa U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (aa)ViewDataBinding.z(layoutInflater, 2131558628, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(v.a v$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(x x);
}
