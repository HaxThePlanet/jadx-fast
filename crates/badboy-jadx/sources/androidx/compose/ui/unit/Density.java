package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008g\u0018\u00002\u00020\u0001J\u0016\u0010\u0008\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0016\u0010\u0008\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u000c\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006&À\u0006\u0003", d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Density extends androidx.compose.ui.unit.FontScaling {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void getDensity$annotations() {
        }

        @Deprecated
        public static int roundToPx--R2X_6o(androidx.compose.ui.unit.Density $this, long $receiver) {
            return Density.access$roundToPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static int roundToPx-0680j_4(androidx.compose.ui.unit.Density $this, float $receiver) {
            return Density.access$roundToPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-GaN1DYA(androidx.compose.ui.unit.Density $this, long $receiver) {
            return Density.access$toDp-GaN1DYA$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.unit.Density $this, float $receiver) {
            return Density.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.unit.Density $this, int $receiver) {
            return Density.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static long toDpSize-k-rfVVM(androidx.compose.ui.unit.Density $this, long $receiver) {
            return Density.access$toDpSize-k-rfVVM$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx--R2X_6o(androidx.compose.ui.unit.Density $this, long $receiver) {
            return Density.access$toPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx-0680j_4(androidx.compose.ui.unit.Density $this, float $receiver) {
            return Density.access$toPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(androidx.compose.ui.unit.Density $this, androidx.compose.ui.unit.DpRect $receiver) {
            return Density.access$toRect$jd($this, $receiver);
        }

        @Deprecated
        public static long toSize-XkaWNTQ(androidx.compose.ui.unit.Density $this, long $receiver) {
            return Density.access$toSize-XkaWNTQ$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-0xMU5do(androidx.compose.ui.unit.Density $this, float $receiver) {
            return Density.access$toSp-0xMU5do$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.unit.Density $this, float $receiver) {
            return Density.access$toSp-kPz2Gy4$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.unit.Density $this, int $receiver) {
            return Density.access$toSp-kPz2Gy4$jd($this, $receiver);
        }
    }
    public static int access$roundToPx--R2X_6o$jd(androidx.compose.ui.unit.Density $this, long $receiver) {
        return super.roundToPx--R2X_6o($receiver);
    }

    public static int access$roundToPx-0680j_4$jd(androidx.compose.ui.unit.Density $this, float $receiver) {
        return super.roundToPx-0680j_4($receiver);
    }

    public static float access$toDp-GaN1DYA$jd(androidx.compose.ui.unit.Density $this, long $receiver) {
        return super.toDp-GaN1DYA($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.unit.Density $this, float $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.unit.Density $this, int $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static long access$toDpSize-k-rfVVM$jd(androidx.compose.ui.unit.Density $this, long $receiver) {
        return super.toDpSize-k-rfVVM($receiver);
    }

    public static float access$toPx--R2X_6o$jd(androidx.compose.ui.unit.Density $this, long $receiver) {
        return super.toPx--R2X_6o($receiver);
    }

    public static float access$toPx-0680j_4$jd(androidx.compose.ui.unit.Density $this, float $receiver) {
        return super.toPx-0680j_4($receiver);
    }

    public static Rect access$toRect$jd(androidx.compose.ui.unit.Density $this, androidx.compose.ui.unit.DpRect $receiver) {
        return super.toRect($receiver);
    }

    public static long access$toSize-XkaWNTQ$jd(androidx.compose.ui.unit.Density $this, long $receiver) {
        return super.toSize-XkaWNTQ($receiver);
    }

    public static long access$toSp-0xMU5do$jd(androidx.compose.ui.unit.Density $this, float $receiver) {
        return super.toSp-0xMU5do($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.unit.Density $this, float $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.unit.Density $this, int $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public abstract float getDensity();

    @Override // androidx.compose.ui.unit.FontScaling
    public int roundToPx--R2X_6o(long $this$roundToPx_u2d_u2dR2X_6o) {
        final int i = 0;
        return Math.round(toPx--R2X_6o($this$roundToPx_u2d_u2dR2X_6o));
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public int roundToPx-0680j_4(float $this$roundToPx_u2d0680j_4) {
        int $this$fastRoundToInt$iv;
        int i;
        int round;
        final float px-0680j_4 = toPx-0680j_4($this$roundToPx_u2d0680j_4);
        if (Float.isInfinite(px-0680j_4)) {
            $this$fastRoundToInt$iv = Integer.MAX_VALUE;
        } else {
            i = 0;
            $this$fastRoundToInt$iv = round;
        }
        return $this$fastRoundToInt$iv;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float toDp-u2uoSUM(float $this$toDp_u2du2uoSUM) {
        final int i2 = 0;
        return Dp.constructor-impl($this$toDp_u2du2uoSUM / density);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float toDp-u2uoSUM(int $this$toDp_u2du2uoSUM) {
        int i2 = 0;
        return Dp.constructor-impl(f /= density);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long toDpSize-k-rfVVM(long $this$toDpSize_u2dk_u2drfVVM) {
        long unspecified-MYxV2XQ;
        float dp-u2uoSUM;
        int i;
        final int i2 = 0;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        if (i != 0) {
            unspecified-MYxV2XQ = DpKt.DpSize-YgX7TsA(toDp-u2uoSUM(Size.getWidth-impl($this$toDpSize_u2dk_u2drfVVM)), toDp-u2uoSUM(Size.getHeight-impl($this$toDpSize_u2dk_u2drfVVM)));
        } else {
            unspecified-MYxV2XQ = DpSize.Companion.getUnspecified-MYxV2XQ();
        }
        return unspecified-MYxV2XQ;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float toPx--R2X_6o(long $this$toPx_u2d_u2dR2X_6o) {
        if (!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA($this$toPx_u2d_u2dR2X_6o), obj1)) {
        } else {
            return toPx-0680j_4(toDp-GaN1DYA($this$toPx_u2d_u2dR2X_6o));
        }
        int i = 0;
        IllegalStateException $i$a$CheckDensity$toPx$1 = new IllegalStateException("Only Sp can convert to Px".toString());
        throw $i$a$CheckDensity$toPx$1;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float toPx-0680j_4(float $this$toPx_u2d0680j_4) {
        return density *= $this$toPx_u2d0680j_4;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public Rect toRect(androidx.compose.ui.unit.DpRect $this$toRect) {
        Rect rect = new Rect(toPx-0680j_4($this$toRect.getLeft-D9Ej5fM()), toPx-0680j_4($this$toRect.getTop-D9Ej5fM()), toPx-0680j_4($this$toRect.getRight-D9Ej5fM()), toPx-0680j_4($this$toRect.getBottom-D9Ej5fM()));
        return rect;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long toSize-XkaWNTQ(long $this$toSize_u2dXkaWNTQ) {
        long unspecified-NH-jbRc;
        float px-0680j_4;
        int i;
        final int i2 = 0;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        if (i != 0) {
            unspecified-NH-jbRc = SizeKt.Size(toPx-0680j_4(DpSize.getWidth-D9Ej5fM($this$toSize_u2dXkaWNTQ)), toPx-0680j_4(DpSize.getHeight-D9Ej5fM($this$toSize_u2dXkaWNTQ)));
        } else {
            unspecified-NH-jbRc = Size.Companion.getUnspecified-NH-jbRc();
        }
        return unspecified-NH-jbRc;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long toSp-kPz2Gy4(float $this$toSp_u2dkPz2Gy4) {
        return toSp-0xMU5do(toDp-u2uoSUM($this$toSp_u2dkPz2Gy4));
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long toSp-kPz2Gy4(int $this$toSp_u2dkPz2Gy4) {
        return toSp-0xMU5do(toDp-u2uoSUM($this$toSp_u2dkPz2Gy4));
    }
}
