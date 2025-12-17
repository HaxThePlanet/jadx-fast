package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep;
import com.google.android.exoplayer2.ui.PlayerView;

/* loaded from: classes.dex */
public abstract class k3 extends ViewDataBinding {

    public final TextView O;
    public final PlayerView P;
    protected TrickItem.VideoStep Q;
    protected k3(Object object, View view2, int i3, TextView textView4, Guideline guideline5, Guideline guideline6, PlayerView playerView7) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = playerView7;
    }

    public static app.dogo.com.dogo_android.h.k3 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return k3.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.k3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (k3)ViewDataBinding.z(layoutInflater, 2131558503, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem.VideoStep trickItem$VideoStep);
}
