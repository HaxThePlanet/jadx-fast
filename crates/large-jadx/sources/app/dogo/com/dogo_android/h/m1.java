package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.u.n.p.g.a;
import app.dogo.com.dogo_android.util.customview.DogLogView;

/* compiled from: CellDogLogCalendarDayBinding.java */
/* loaded from: classes.dex */
public abstract class m1 extends ViewDataBinding {

    public final DogLogView O;
    public final TextView P;
    public final TextView Q;
    protected g.a R;
    protected m1(Object object, View view, int i, DogLogView dogLogView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = dogLogView;
        this.P = textView;
        this.Q = textView2;
    }

    public static m1 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m1.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static m1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (m1)ViewDataBinding.z(layoutInflater, 2131558477, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g.a aVar);
}
