package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;
import com.google.android.exoplayer2.ui.PlayerView;

/* loaded from: classes.dex */
public abstract class m3 extends ViewDataBinding {

    public final PlayerView O;
    protected GoodTrickExample P;
    protected m3(Object object, View view2, int i3, CardView cardView4, PlayerView playerView5) {
        super(object, view2, i3);
        this.O = playerView5;
    }

    public static app.dogo.com.dogo_android.h.m3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return m3.V(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.m3 V(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (m3)ViewDataBinding.z(layoutInflater, 2131558504, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public GoodTrickExample T() {
        return this.P;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(GoodTrickExample goodTrickExample);
}
