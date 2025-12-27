package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.b0.e;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import nl.dionsegijn.konfetti.KonfettiView;

/* compiled from: FragmentProgramQuestionCorrectAnswerBinding.java */
/* loaded from: classes.dex */
public abstract class yf extends ViewDataBinding {

    public final TextView O;
    public final MaterialButton P;
    public final KonfettiView Q;
    public final ConstraintLayout R;
    public final WebView S;
    public final TextView T;
    public final MaterialToolbar U;
    protected e V;
    protected yf(Object object, View view, int i, TextView textView, CardView cardView, ImageView imageView, MaterialButton materialButton, KonfettiView konfettiView, ConstraintLayout constraintLayout, WebView webView, TextView textView2, TextView textView3, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = textView;
        this.P = materialButton;
        this.Q = konfettiView;
        this.R = constraintLayout;
        this.S = webView;
        this.T = textView2;
        this.U = materialToolbar;
    }

    public static yf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return yf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static yf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (yf)ViewDataBinding.z(layoutInflater, 2131558706, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);
}
