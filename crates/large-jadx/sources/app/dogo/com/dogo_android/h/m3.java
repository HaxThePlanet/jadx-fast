package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;
import com.google.android.exoplayer2.ui.PlayerView;

/* compiled from: CellLoadingVideoBinding.java */
/* loaded from: classes.dex */
public abstract class m3 extends ViewDataBinding {

    public final PlayerView O;
    protected GoodTrickExample P;
    protected m3(Object object, View view, int i, CardView cardView, PlayerView playerView) {
        super(object, view, i);
        this.O = playerView;
    }

    public static m3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m3.V(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static m3 V(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (m3)ViewDataBinding.z(layoutInflater, 2131558504, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public GoodTrickExample T() {
        return this.P;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(GoodTrickExample goodTrickExample);
}
