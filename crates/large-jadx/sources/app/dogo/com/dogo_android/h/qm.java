package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;

/* loaded from: classes.dex */
public abstract class qm extends ViewDataBinding {

    public final AppCompatImageView O;
    public final SegmentedProgressBar P;
    public final AppCompatImageView Q;
    public final TextView R;
    protected TrickItem S;
    protected qm(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, SegmentedProgressBar segmentedProgressBar5, AppCompatImageView appCompatImageView6, TextView textView7) {
        super(object, view2, i3);
        this.O = appCompatImageView4;
        this.P = segmentedProgressBar5;
        this.Q = appCompatImageView6;
        this.R = textView7;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(TrickItem trickItem);
}
