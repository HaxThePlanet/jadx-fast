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

/* compiled from: FragmentClickerIntroductionDetailsBinding.java */
/* loaded from: classes.dex */
public abstract class oa extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TabLayout P;
    public final MaterialToolbar Q;
    public final ViewPager2 R;
    protected d S;
    protected k T;
    protected oa(Object object, View view, int i, Guideline guideline, ConstraintLayout constraintLayout, TabLayout tabLayout, MaterialToolbar materialToolbar, ConstraintLayout constraintLayout2, ViewPager2 viewPager2) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = tabLayout;
        this.Q = materialToolbar;
        this.R = viewPager2;
    }

    public static oa T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return oa.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static oa U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (oa)ViewDataBinding.z(layoutInflater, 2131558635, viewGroup, z, object);
    }
}
