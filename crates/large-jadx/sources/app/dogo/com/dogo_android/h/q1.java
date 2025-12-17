package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.DogLog;

/* loaded from: classes.dex */
public abstract class q1 extends ViewDataBinding {

    public final FrameLayout O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    protected DogLog S;
    protected q1(Object object, View view2, int i3, FrameLayout frameLayout4, TextView textView5, TextView textView6, TextView textView7) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = textView5;
        this.Q = textView6;
        this.R = textView7;
    }

    public static app.dogo.com.dogo_android.h.q1 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return q1.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.q1 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (q1)ViewDataBinding.z(layoutInflater, 2131558479, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(DogLog dogLog);
}
