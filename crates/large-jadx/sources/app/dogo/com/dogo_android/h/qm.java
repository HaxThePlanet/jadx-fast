package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;

/* compiled from: LayoutSpecialProgramExerciseBaseBinding.java */
/* loaded from: classes.dex */
public abstract class qm extends ViewDataBinding {

    public final AppCompatImageView O;
    public final SegmentedProgressBar P;
    public final AppCompatImageView Q;
    public final TextView R;
    protected TrickItem S;
    protected qm(Object object, View view, int i, AppCompatImageView appCompatImageView, SegmentedProgressBar segmentedProgressBar, AppCompatImageView appCompatImageView2, TextView textView) {
        super(object, view, i);
        this.O = appCompatImageView;
        this.P = segmentedProgressBar;
        this.Q = appCompatImageView2;
        this.R = textView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(TrickItem trickItem);
}
