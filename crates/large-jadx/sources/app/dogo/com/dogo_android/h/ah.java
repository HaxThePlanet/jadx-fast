package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.legacy.widget.Space;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import com.airbnb.lottie.LottieAnimationView;

/* loaded from: classes.dex */
public abstract class ah extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    protected TrainingTimeMetrics S;
    protected String T;
    protected ah(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, Button button5, AppCompatImageView appCompatImageView6, Barrier barrier7, Space space8, Barrier barrier9, Space space10, LottieAnimationView lottieAnimationView11, TextView textView12, FrameLayout frameLayout13, TextView textView14, AppCompatImageView appCompatImageView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = button5;
        obj.P = textView12;
        obj.Q = textView16;
        obj.R = textView18;
    }

    public static app.dogo.com.dogo_android.h.ah T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ah.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ah U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ah)ViewDataBinding.z(layoutInflater, 2131558720, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrainingTimeMetrics trainingTimeMetrics);
}
