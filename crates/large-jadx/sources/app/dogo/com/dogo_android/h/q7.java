package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;

/* compiled from: CellSpecialProgramVariationsBinding.java */
/* loaded from: classes.dex */
public abstract class q7 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final SegmentedProgressBar P;
    public final TextView Q;
    public final TextView R;
    protected TrickItem S;
    protected q7(Object object, View view, int i, AppCompatImageView appCompatImageView, SegmentedProgressBar segmentedProgressBar, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = appCompatImageView;
        this.P = segmentedProgressBar;
        this.Q = textView;
        this.R = textView2;
    }

    public static q7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q7)ViewDataBinding.z(layoutInflater, 2131558558, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
