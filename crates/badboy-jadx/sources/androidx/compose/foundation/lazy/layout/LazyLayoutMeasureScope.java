package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.DpSize.Companion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.unit.TextUnitType.Companion;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H&ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u000c*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\u000c*\u00020\u0010H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0019\u0010\u000b\u001a\u00020\u000c*\u00020\u0006H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0018J\u0016\u0010\u001b\u001a\u00020\r*\u00020\u000cH\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0019\u0010\u001b\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001dJ\u0019\u0010\u001b\u001a\u00020\r*\u00020\u0006H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u0082\u0001\u0001 ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006!À\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "measure", "", "Landroidx/compose/ui/layout/Placeable;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyLayoutMeasureScope extends MeasureScope {
    public abstract List<Placeable> measure-0kLqBqw(int i, long l2);

    @Override // androidx.compose.ui.layout.MeasureScope
    public float toDp-GaN1DYA(long $this$toDp_u2dGaN1DYA) {
        if (!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA($this$toDp_u2dGaN1DYA), obj1)) {
        } else {
            return Dp.constructor-impl(value-impl *= fontScale);
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckLazyLayoutMeasureScope$toDp$1 = new IllegalStateException("Only Sp can convert to Px".toString());
        throw $i$a$CheckLazyLayoutMeasureScope$toDp$1;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float toDp-u2uoSUM(float $this$toDp_u2du2uoSUM) {
        final int i2 = 0;
        return Dp.constructor-impl($this$toDp_u2du2uoSUM / density);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public float toDp-u2uoSUM(int $this$toDp_u2du2uoSUM) {
        int i2 = 0;
        return Dp.constructor-impl(f /= density);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
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

    @Override // androidx.compose.ui.layout.MeasureScope
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

    @Override // androidx.compose.ui.layout.MeasureScope
    public long toSp-0xMU5do(float $this$toSp_u2d0xMU5do) {
        return TextUnitKt.getSp($this$toSp_u2d0xMU5do / fontScale);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public long toSp-kPz2Gy4(float $this$toSp_u2dkPz2Gy4) {
        return TextUnitKt.getSp($this$toSp_u2dkPz2Gy4 / i);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public long toSp-kPz2Gy4(int $this$toSp_u2dkPz2Gy4) {
        return TextUnitKt.getSp(f /= i2);
    }
}
