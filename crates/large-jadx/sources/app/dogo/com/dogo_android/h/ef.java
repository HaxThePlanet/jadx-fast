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

/* loaded from: classes.dex */
public abstract class ef extends ViewDataBinding {

    public final MaterialButton O;
    public final ViewPager2 P;
    public final TabLayout Q;
    public final MaterialToolbar R;
    public final FrameLayout S;
    protected b T;
    protected h U;
    protected ef(Object object, View view2, int i3, MaterialButton materialButton4, ViewPager2 viewPager25, TabLayout tabLayout6, MaterialToolbar materialToolbar7, FrameLayout frameLayout8) {
        super(object, view2, i3);
        this.O = materialButton4;
        this.P = viewPager25;
        this.Q = tabLayout6;
        this.R = materialToolbar7;
        this.S = frameLayout8;
    }

    public static app.dogo.com.dogo_android.h.ef T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ef.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ef U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ef)ViewDataBinding.z(layoutInflater, 2131558696, viewGroup2, z3, object4);
    }
}
