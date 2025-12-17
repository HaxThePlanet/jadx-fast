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

/* loaded from: classes.dex */
public abstract class kh extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    protected WorkoutStreakInfo S;
    protected kh(Object object, View view2, int i3, Button button4, LottieAnimationView lottieAnimationView5, TextView textView6, ImageView imageView7, TextView textView8, TextView textView9) {
        super(object, view2, i3);
        this.O = button4;
        this.P = textView6;
        this.Q = imageView7;
        this.R = textView8;
    }

    public static app.dogo.com.dogo_android.h.kh T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return kh.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.kh U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (kh)ViewDataBinding.z(layoutInflater, 2131558725, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(WorkoutStreakInfo workoutStreakInfo);
}
