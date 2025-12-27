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

/* compiled from: FragmentBitingProgramVariationsUnlockedBinding.java */
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
    protected aa(Object object, View view, int i, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, MaterialButton materialButton, RecyclerView recyclerView, NestedScrollView nestedScrollView, ImageView imageView2, TextView textView2, FrameLayout frameLayout, MaterialToolbar materialToolbar, ImageView imageView3, TextView textView3, View view2) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = constraintLayout;
        object2.P = materialButton;
        object2.Q = recyclerView;
        object2.R = imageView2;
        object2.S = frameLayout;
        object2.T = materialToolbar;
        object2.U = imageView3;
        object2.V = textView3;
    }

    public static aa T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return aa.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static aa U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (aa)ViewDataBinding.z(layoutInflater, 2131558628, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(v.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(x xVar);
}
