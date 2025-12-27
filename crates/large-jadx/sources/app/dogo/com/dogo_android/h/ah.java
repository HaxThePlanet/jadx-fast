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

/* compiled from: FragmentTrainingMetricsStreakCompletedBinding.java */
/* loaded from: classes.dex */
public abstract class ah extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    protected TrainingTimeMetrics S;
    protected String T;
    protected ah(Object object, View view, int i, AppCompatImageView appCompatImageView, Button button, AppCompatImageView appCompatImageView2, Barrier barrier, Space space, Barrier barrier2, Space space2, LottieAnimationView lottieAnimationView, TextView textView, FrameLayout frameLayout, TextView textView2, AppCompatImageView appCompatImageView3, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = button;
        object2.P = textView;
        object2.Q = textView3;
        object2.R = textView5;
    }

    public static ah T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ah.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ah U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ah)ViewDataBinding.z(layoutInflater, 2131558720, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrainingTimeMetrics trainingTimeMetrics);
}
