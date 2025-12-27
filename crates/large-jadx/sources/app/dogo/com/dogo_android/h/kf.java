package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.t.d;
import nl.dionsegijn.konfetti.KonfettiView;

/* compiled from: FragmentProgramLessonCompleteBinding.java */
/* loaded from: classes.dex */
public abstract class kf extends ViewDataBinding {

    public final Button O;
    public final ImageView P;
    public final TextView Q;
    public final KonfettiView R;
    protected d S;
    protected kf(Object object, View view, int i, ImageView imageView, Button button, ImageView imageView2, TextView textView, TextView textView2, KonfettiView konfettiView) {
        super(object, view, i);
        this.O = button;
        this.P = imageView2;
        this.Q = textView2;
        this.R = konfettiView;
    }

    public static kf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return kf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static kf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (kf)ViewDataBinding.z(layoutInflater, 2131558699, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d dVar);
}
