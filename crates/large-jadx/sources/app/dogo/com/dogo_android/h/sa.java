package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.f.n.e;
import com.airbnb.lottie.LottieAnimationView;

/* compiled from: FragmentDailyWorkoutUnlockedBinding.java */
/* loaded from: classes.dex */
public abstract class sa extends ViewDataBinding {

    public final Button O;
    public final Button P;
    protected e Q;
    protected sa(Object object, View view, int i, TextView textView, LottieAnimationView lottieAnimationView, Button button, TextView textView2, Button button2) {
        super(object, view, i);
        this.O = button;
        this.P = button2;
    }

    public static sa T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sa.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sa U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sa)ViewDataBinding.z(layoutInflater, 2131558637, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);
}
