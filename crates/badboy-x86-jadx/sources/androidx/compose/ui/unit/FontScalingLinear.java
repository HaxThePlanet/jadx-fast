package androidx.compose.ui.unit;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008g\u0018\u00002\u00020\u0001J\u0016\u0010\u0008\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0016\u0010\r\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0010À\u0006\u0003", d2 = {"Landroidx/compose/ui/unit/FontScalingLinear;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toSp", "toSp-0xMU5do", "(F)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FontScalingLinear {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void getFontScale$annotations() {
        }

        @Deprecated
        public static float toDp-GaN1DYA(androidx.compose.ui.unit.FontScalingLinear $this, long $receiver) {
            return FontScalingLinear.access$toDp-GaN1DYA$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-0xMU5do(androidx.compose.ui.unit.FontScalingLinear $this, float $receiver) {
            return FontScalingLinear.access$toSp-0xMU5do$jd($this, $receiver);
        }
    }
    public static float access$toDp-GaN1DYA$jd(androidx.compose.ui.unit.FontScalingLinear $this, long $receiver) {
        return super.toDp-GaN1DYA($receiver);
    }

    public static long access$toSp-0xMU5do$jd(androidx.compose.ui.unit.FontScalingLinear $this, float $receiver) {
        return super.toSp-0xMU5do($receiver);
    }

    public abstract float getFontScale();

    public float toDp-GaN1DYA(long $this$toDp_u2dGaN1DYA) {
        if (!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA($this$toDp_u2dGaN1DYA), obj1)) {
        } else {
            return Dp.constructor-impl(value-impl *= fontScale);
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Only Sp can convert to Px".toString());
        throw illegalStateException;
    }

    public long toSp-0xMU5do(float $this$toSp_u2d0xMU5do) {
        return TextUnitKt.getSp($this$toSp_u2d0xMU5do / fontScale);
    }
}
