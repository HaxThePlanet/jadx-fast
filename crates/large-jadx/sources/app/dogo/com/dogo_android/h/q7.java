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

/* loaded from: classes.dex */
public abstract class q7 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final SegmentedProgressBar P;
    public final TextView Q;
    public final TextView R;
    protected TrickItem S;
    protected q7(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, SegmentedProgressBar segmentedProgressBar5, TextView textView6, TextView textView7) {
        super(object, view2, i3);
        this.O = appCompatImageView4;
        this.P = segmentedProgressBar5;
        this.Q = textView6;
        this.R = textView7;
    }

    public static app.dogo.com.dogo_android.h.q7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return q7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.q7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (q7)ViewDataBinding.z(layoutInflater, 2131558558, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
