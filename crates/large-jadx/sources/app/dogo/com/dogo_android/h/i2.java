package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

/* loaded from: classes.dex */
public abstract class i2 extends ViewDataBinding {

    public final ChipGroup O;
    public final Chip P;
    public final Chip Q;
    public final Chip R;
    public final Chip S;
    public final FrameLayout T;
    public final Chip U;
    public final Chip V;
    protected EntrySortingObservable W;
    protected i2(Object object, View view2, int i3, ChipGroup chipGroup4, Chip chip5, Chip chip6, Chip chip7, Chip chip8, FrameLayout frameLayout9, Chip chip10, HorizontalScrollView horizontalScrollView11, Chip chip12) {
        super(object, view2, i3);
        this.O = chipGroup4;
        this.P = chip5;
        this.Q = chip6;
        this.R = chip7;
        this.S = chip8;
        this.T = frameLayout9;
        this.U = chip10;
        this.V = chip12;
    }

    public static app.dogo.com.dogo_android.h.i2 T(View view) {
        return i2.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.i2 U(View view, Object object2) {
        return (i2)ViewDataBinding.k(object2, view, 2131558489);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(EntrySortingObservable entrySortingObservable);
}
