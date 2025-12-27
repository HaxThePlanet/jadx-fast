package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.util.customview.ArcProgressBar;
import app.dogo.com.dogo_android.x.b.d;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentTimeGoalNotAchievedScreenBinding.java */
/* loaded from: classes.dex */
public abstract class wg extends ViewDataBinding {

    public final ArcProgressBar O;
    public final TextView P;
    public final MaterialButton Q;
    public final ImageView R;
    public final TextView S;
    public final TextView T;
    protected d U;
    protected wg(Object object, View view, int i, ArcProgressBar arcProgressBar, TextView textView, TextView textView2, MaterialButton materialButton, ImageView imageView, TextView textView3, TextView textView4, ImageView imageView2) {
        super(object, view, i);
        this.O = arcProgressBar;
        this.P = textView2;
        this.Q = materialButton;
        this.R = imageView;
        this.S = textView3;
        this.T = textView4;
    }

    public static wg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wg)ViewDataBinding.z(layoutInflater, 2131558718, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d dVar);
}
