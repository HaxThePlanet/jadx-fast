package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import nl.dionsegijn.konfetti.KonfettiView;

/* compiled from: FragmentProgramLessonExamUnlockedBinding.java */
/* loaded from: classes.dex */
public abstract class of extends ViewDataBinding {

    public final TextView O;
    public final KonfettiView P;
    public final TextView Q;
    public final ImageView R;
    public final Button S;
    public final Button T;
    protected app.dogo.com.dogo_android.y.u.f U;
    protected of(Object object, View view, int i, ImageView imageView, TextView textView, KonfettiView konfettiView, TextView textView2, ImageView imageView2, Button button, TextView textView3, Button button2) {
        super(object, view, i);
        this.O = textView;
        this.P = konfettiView;
        this.Q = textView2;
        this.R = imageView2;
        this.S = button;
        this.T = button2;
    }

    public static of T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return of.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static of U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (of)ViewDataBinding.z(layoutInflater, 2131558701, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(app.dogo.com.dogo_android.y.u.f fVar);
}
