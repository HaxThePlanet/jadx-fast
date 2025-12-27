package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingObservable;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

/* compiled from: CellEntrySortingChipItemBinding.java */
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
    protected i2(Object object, View view, int i, ChipGroup chipGroup, Chip chip, Chip chip2, Chip chip3, Chip chip4, FrameLayout frameLayout, Chip chip5, HorizontalScrollView horizontalScrollView, Chip chip6) {
        super(object, view, i);
        this.O = chipGroup;
        this.P = chip;
        this.Q = chip2;
        this.R = chip3;
        this.S = chip4;
        this.T = frameLayout;
        this.U = chip5;
        this.V = chip6;
    }

    public static i2 T(View view) {
        return i2.U(view, f.e());
    }

    @Deprecated
    public static i2 U(View view, Object object) {
        return (i2)ViewDataBinding.k(object, view, 2131558489);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(EntrySortingObservable entrySortingObservable);
}
