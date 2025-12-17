package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.c0.f;
import app.dogo.com.dogo_android.y.c0.g;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ag extends ViewDataBinding {

    public final MaterialToolbar O;
    protected f P;
    protected g Q;
    protected ag(Object object, View view2, int i3, CardView cardView4, TextView textView5, ImageView imageView6, TextView textView7, MaterialToolbar materialToolbar8) {
        super(object, view2, i3);
        this.O = materialToolbar8;
    }

    public static app.dogo.com.dogo_android.h.ag T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ag.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ag U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ag)ViewDataBinding.z(layoutInflater, 2131558707, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(f f);
}
