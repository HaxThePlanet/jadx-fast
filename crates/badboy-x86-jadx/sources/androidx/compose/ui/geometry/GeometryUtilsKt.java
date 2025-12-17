package androidx.compose.ui.geometry;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005", d2 = {"toStringAsFixed", "", "", "digits", "", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GeometryUtilsKt {
    public static final String toStringAsFixed(float $this$toStringAsFixed, int digits) {
        String str;
        int i;
        String valueOf;
        if (Float.isNaN($this$toStringAsFixed)) {
            return "NaN";
        }
        if (Float.isInfinite($this$toStringAsFixed)) {
            str = Float.compare($this$toStringAsFixed, i4) < 0 ? "-Infinity" : "Infinity";
            return str;
        }
        int i3 = Math.max(digits, 0);
        float f = (float)d2;
        final int i6 = $this$toStringAsFixed * f;
        i = Float.compare(i8, i9) >= 0 ? i10 + 1 : (int)i6;
        f3 /= f;
        if (i3 > 0) {
            valueOf = String.valueOf(i11);
        } else {
            valueOf = String.valueOf((int)i11);
        }
        return valueOf;
    }
}
