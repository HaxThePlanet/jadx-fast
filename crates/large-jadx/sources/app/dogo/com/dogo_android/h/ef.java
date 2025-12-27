package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.u.n.r.h;
import app.dogo.com.dogo_android.util.l0.b;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

/* compiled from: FragmentPottyTrackerOverviewBinding.java */
/* loaded from: classes.dex */
public abstract class ef extends ViewDataBinding {

    public final MaterialButton O;
    public final ViewPager2 P;
    public final TabLayout Q;
    public final MaterialToolbar R;
    public final FrameLayout S;
    protected b T;
    protected h U;
    protected ef(Object object, View view, int i, MaterialButton materialButton, ViewPager2 viewPager2, TabLayout tabLayout, MaterialToolbar materialToolbar, FrameLayout frameLayout) {
        super(object, view, i);
        this.O = materialButton;
        this.P = viewPager2;
        this.Q = tabLayout;
        this.R = materialToolbar;
        this.S = frameLayout;
    }

    public static ef T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ef.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ef U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ef)ViewDataBinding.z(layoutInflater, 2131558696, viewGroup, z, object);
    }
}
