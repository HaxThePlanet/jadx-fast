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
    protected yg(Object object, View view2, int i3, ConstraintLayout constraintLayout4, ClickerSoundMaterialButton clickerSoundMaterialButton5, ViewPagerCustomDuration viewPagerCustomDuration6, View view7, SegmentedProgressBar segmentedProgressBar8, Guideline guideline9, MaterialToolbar materialToolbar10, View view11) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = clickerSoundMaterialButton5;
        this.Q = viewPagerCustomDuration6;
        this.R = view7;
        this.S = segmentedProgressBar8;
        this.T = materialToolbar10;
        this.U = view11;
    }

    public static app.dogo.com.dogo_android.h.yg T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return yg.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.yg U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (yg)ViewDataBinding.z(layoutInflater, 2131558719, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i.b i$b);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l l);
}
