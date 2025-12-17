package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.legacy.widget.Space;
import app.dogo.com.dogo_android.n.m.s.i;
import app.dogo.com.dogo_android.util.customview.ArcProgressBar;
import app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
public abstract class wd extends ViewDataBinding {

    public final ArcProgressBar O;
    public final ConstraintLayout P;
    public final View Q;
    public final ClickerSoundMaterialButton R;
    public final Space S;
    public final Button T;
    public final Button U;
    public final Chip V;
    public final Chip W;
    public final TextView X;
    public final TextView Y;
    public final ConstraintLayout Z;
    public final MaterialToolbar a0;
    public final TextView b0;
    public final ConstraintLayout c0;
    public final TextView d0;
    protected i e0;
    protected wd(Object object, View view2, int i3, ArcProgressBar arcProgressBar4, ConstraintLayout constraintLayout5, View view6, Barrier barrier7, Guideline guideline8, Barrier barrier9, ClickerSoundMaterialButton clickerSoundMaterialButton10, View view11, Guideline guideline12, Guideline guideline13, Space space14, Button button15, Button button16, Chip chip17, Chip chip18, TextView textView19, Guideline guideline20, TextView textView21, ConstraintLayout constraintLayout22, MaterialToolbar materialToolbar23, TextView textView24, ConstraintLayout constraintLayout25, TextView textView26, View view27) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = arcProgressBar4;
        obj.P = constraintLayout5;
        obj.Q = view6;
        obj.R = clickerSoundMaterialButton10;
        obj.S = space14;
        obj.T = button15;
        obj.U = button16;
        obj.V = chip17;
        obj.W = chip18;
        obj.X = textView19;
        obj.Y = textView21;
        obj.Z = constraintLayout22;
        obj.a0 = materialToolbar23;
        obj.b0 = textView24;
        obj.c0 = constraintLayout25;
        obj.d0 = textView26;
    }

    public static app.dogo.com.dogo_android.h.wd T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return wd.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.wd U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (wd)ViewDataBinding.z(layoutInflater, 2131558678, viewGroup2, z3, object4);
    }
}
