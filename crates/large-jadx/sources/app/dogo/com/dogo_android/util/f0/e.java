package app.dogo.com.dogo_android.util.f0;

import androidx.databinding.g;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.ChipGroup.d;

/* loaded from: classes.dex */
public final class e implements ChipGroup.d {

    public final ChipGroup.d a;
    public final g b;
    public e(ChipGroup.d chipGroup$d, g g2) {
        super();
        this.a = d;
        this.b = g2;
    }

    @Override // com.google.android.material.chip.ChipGroup$d
    public final void a(ChipGroup chipGroup, int i2) {
        n.a.a.a(this.a, this.b, chipGroup, i2);
    }
}
