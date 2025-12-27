package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.f.l.i.b;
import app.dogo.com.dogo_android.f.l.l;
import app.dogo.com.dogo_android.util.ViewPagerCustomDuration;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentTodaysWorkoutBinding.java */
/* loaded from: classes.dex */
public abstract class yg extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ClickerSoundMaterialButton P;
    public final ViewPagerCustomDuration Q;
    public final View R;
    public final SegmentedProgressBar S;
    public final MaterialToolbar T;
    public final View U;
    protected l V;
    protected i.b W;
    protected yg(Object object, View view, int i, ConstraintLayout constraintLayout, ClickerSoundMaterialButton clickerSoundMaterialButton, ViewPagerCustomDuration viewPagerCustomDuration, View view2, SegmentedProgressBar segmentedProgressBar, Guideline guideline, MaterialToolbar materialToolbar, View view3) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = clickerSoundMaterialButton;
        this.Q = viewPagerCustomDuration;
        this.R = view2;
        this.S = segmentedProgressBar;
        this.T = materialToolbar;
        this.U = view3;
    }

    public static yg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return yg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static yg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (yg)ViewDataBinding.z(layoutInflater, 2131558719, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i.b bVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l lVar);
}
