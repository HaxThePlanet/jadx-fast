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

/* compiled from: CellLibraryTrickVideoStepBinding.java */
/* loaded from: classes.dex */
public abstract class k3 extends ViewDataBinding {

    public final TextView O;
    public final PlayerView P;
    protected TrickItem.VideoStep Q;
    protected k3(Object object, View view, int i, TextView textView, Guideline guideline, Guideline guideline2, PlayerView playerView) {
        super(object, view, i);
        this.O = textView;
        this.P = playerView;
    }

    public static k3 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return k3.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static k3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (k3)ViewDataBinding.z(layoutInflater, 2131558503, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem.VideoStep videoStep);
}
