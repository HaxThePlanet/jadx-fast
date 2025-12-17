package androidx.compose.ui.unit.fontscaling;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\r\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u0011", d2 = {"Landroidx/compose/ui/unit/fontscaling/MathUtils;", "", "()V", "constrainedMap", "", "rangeMin", "rangeMax", "valueMin", "valueMax", "value", "lerp", "start", "stop", "amount", "lerpInv", "a", "b", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MathUtils {

    public static final int $stable;
    public static final androidx.compose.ui.unit.fontscaling.MathUtils INSTANCE;
    static {
        MathUtils mathUtils = new MathUtils();
        MathUtils.INSTANCE = mathUtils;
    }

    public final float constrainedMap(float rangeMin, float rangeMax, float valueMin, float valueMax, float value) {
        return lerp(rangeMin, rangeMax, Math.max(0, Math.min(1065353216, lerpInv(valueMin, valueMax, value))));
    }

    public final float lerp(float start, float stop, float amount) {
        return i2 += start;
    }

    public final float lerpInv(float a, float b, float value) {
        int i;
        int i2;
        int i3;
        i = Float.compare(a, b) == 0 ? 1 : 0;
        if (i == 0) {
            i4 /= i3;
        } else {
            i2 = 0;
        }
        return i2;
    }
}
