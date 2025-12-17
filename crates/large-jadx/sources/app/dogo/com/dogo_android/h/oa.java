package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.n.m.u.k;
import app.dogo.com.dogo_android.z.d;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public abstract class oa extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TabLayout P;
    public final MaterialToolbar Q;
    public final ViewPager2 R;
    protected d S;
    protected k T;
    protected oa(Object object, View view2, int i3, Guideline guideline4, ConstraintLayout constraintLayout5, TabLayout tabLayout6, MaterialToolbar materialToolbar7, ConstraintLayout constraintLayout8, ViewPager2 viewPager29) {
        super(object, view2, i3);
        this.O = constraintLayout5;
        this.P = tabLayout6;
        this.Q = materialToolbar7;
        this.R = viewPager29;
    }

    public static app.dogo.com.dogo_android.h.oa T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return oa.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.oa U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (oa)ViewDataBinding.z(layoutInflater, 2131558635, viewGroup2, z3, object4);
    }
}
