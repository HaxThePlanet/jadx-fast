package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.y.v.d.a;
import app.dogo.com.dogo_android.y.v.e;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public abstract class o9 extends ViewDataBinding {

    public final ViewPager2 O;
    public final Button P;
    public final TabLayout Q;
    public final app.dogo.com.dogo_android.h.e5 R;
    protected e S;
    protected d.a T;
    protected o9(Object object, View view2, int i3, ViewPager2 viewPager24, Button button5, TabLayout tabLayout6, app.dogo.com.dogo_android.h.e5 e57) {
        super(object, view2, i3);
        this.O = viewPager24;
        this.P = button5;
        this.Q = tabLayout6;
        this.R = e57;
    }

    public static app.dogo.com.dogo_android.h.o9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return o9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.o9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (o9)ViewDataBinding.z(layoutInflater, 2131558610, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d.a d$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e e);
}
