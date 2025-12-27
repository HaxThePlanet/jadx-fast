package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.DogLog;

/* compiled from: CellDogLogSelectionBinding.java */
/* loaded from: classes.dex */
public abstract class q1 extends ViewDataBinding {

    public final FrameLayout O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    protected DogLog S;
    protected q1(Object object, View view, int i, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = textView;
        this.Q = textView2;
        this.R = textView3;
    }

    public static q1 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q1.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q1)ViewDataBinding.z(layoutInflater, 2131558479, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(DogLog dogLog);
}
