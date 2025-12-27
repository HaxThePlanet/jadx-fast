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

/* compiled from: DialogProgramLessonIntroductionBinding.java */
/* loaded from: classes.dex */
public abstract class o9 extends ViewDataBinding {

    public final ViewPager2 O;
    public final Button P;
    public final TabLayout Q;
    public final e5 R;
    protected e S;
    protected d.a T;
    protected o9(Object object, View view, int i, ViewPager2 viewPager2, Button button, TabLayout tabLayout, e5 e5Var) {
        super(object, view, i);
        this.O = viewPager2;
        this.P = button;
        this.Q = tabLayout;
        this.R = e5Var;
    }

    public static o9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return o9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static o9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (o9)ViewDataBinding.z(layoutInflater, 2131558610, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e eVar);
}
