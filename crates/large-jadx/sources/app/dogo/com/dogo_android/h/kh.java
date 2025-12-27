package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: FragmentWorkoutCompletedBinding.java */
/* loaded from: classes.dex */
public abstract class kh extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    protected WorkoutStreakInfo S;
    protected kh(Object object, View view, int i, Button button, LottieAnimationView lottieAnimationView, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = button;
        this.P = textView;
        this.Q = imageView;
        this.R = textView2;
    }

    public static kh T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return kh.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static kh U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (kh)ViewDataBinding.z(layoutInflater, 2131558725, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(WorkoutStreakInfo workoutStreakInfo);
}
