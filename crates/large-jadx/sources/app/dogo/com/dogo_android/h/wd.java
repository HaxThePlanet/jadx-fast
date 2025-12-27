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

/* compiled from: FragmentLibraryTrickBigTimerBinding.java */
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
    protected wd(Object object, View view, int i, ArcProgressBar arcProgressBar, ConstraintLayout constraintLayout, View view2, Barrier barrier, Guideline guideline, Barrier barrier2, ClickerSoundMaterialButton clickerSoundMaterialButton, View view3, Guideline guideline2, Guideline guideline3, Space space, Button button, Button button2, Chip chip, Chip chip2, TextView textView, Guideline guideline4, TextView textView2, ConstraintLayout constraintLayout2, MaterialToolbar materialToolbar, TextView textView3, ConstraintLayout constraintLayout3, TextView textView4, View view4) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = arcProgressBar;
        object2.P = constraintLayout;
        object2.Q = view2;
        object2.R = clickerSoundMaterialButton;
        object2.S = space;
        object2.T = button;
        object2.U = button2;
        object2.V = chip;
        object2.W = chip2;
        object2.X = textView;
        object2.Y = textView2;
        object2.Z = constraintLayout2;
        object2.a0 = materialToolbar;
        object2.b0 = textView3;
        object2.c0 = constraintLayout3;
        object2.d0 = textView4;
    }

    public static wd T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wd.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wd U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wd)ViewDataBinding.z(layoutInflater, 2131558678, viewGroup, z, object);
    }
}
