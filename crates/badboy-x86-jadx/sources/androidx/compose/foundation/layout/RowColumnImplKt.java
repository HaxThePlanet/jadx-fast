package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001ae\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00172\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0008\u001a2\u001d\u0010\u001b\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0008\u001a2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0082\u0008\u001aF\u0010\u001e\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00172\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0008\u001a2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015H\u0082\u0008\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\"\u001a\u0010\t\u001a\u00020\u0006*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0008\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0002*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0002*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000f\"\u001a\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006 ", d2 = {"crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "fill", "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "isRelative", "rowColumnParentData", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getRowColumnParentData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/ui/layout/Placeable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "intrinsicCrossAxisSize", "", "children", "", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "intrinsicMainAxisSize", "crossAxisAvailable", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RowColumnImplKt {
    public static final androidx.compose.foundation.layout.CrossAxisAlignment getCrossAxisAlignment(androidx.compose.foundation.layout.RowColumnParentData $this$crossAxisAlignment) {
        androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment;
        if ($this$crossAxisAlignment != null) {
            crossAxisAlignment = $this$crossAxisAlignment.getCrossAxisAlignment();
        } else {
            crossAxisAlignment = 0;
        }
        return crossAxisAlignment;
    }

    public static final boolean getFill(androidx.compose.foundation.layout.RowColumnParentData $this$fill) {
        boolean fill;
        if ($this$fill != null) {
            fill = $this$fill.getFill();
        } else {
            fill = 1;
        }
        return fill;
    }

    public static final androidx.compose.foundation.layout.RowColumnParentData getRowColumnParentData(IntrinsicMeasurable $this$rowColumnParentData) {
        Object parentData;
        if (parentData instanceof RowColumnParentData != null) {
        } else {
            parentData = 0;
        }
        return parentData;
    }

    public static final androidx.compose.foundation.layout.RowColumnParentData getRowColumnParentData(Placeable $this$rowColumnParentData) {
        Object parentData;
        if (parentData instanceof RowColumnParentData != null) {
        } else {
            parentData = 0;
        }
        return parentData;
    }

    public static final float getWeight(androidx.compose.foundation.layout.RowColumnParentData $this$weight) {
        float weight;
        if ($this$weight != null) {
            weight = $this$weight.getWeight();
        } else {
            weight = 0;
        }
        return weight;
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> children, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> mainAxisSize, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> crossAxisSize, int mainAxisAvailable, int mainAxisSpacing) {
        int fixedSpace;
        int i;
        int $this$fastRoundToInt$iv2;
        int cmp2;
        int crossAxisMax;
        int i2;
        Object obj5;
        int totalWeight;
        int i4;
        int round;
        int index$iv2;
        int index$iv;
        int intValue;
        int $this$fastRoundToInt$iv;
        int i3;
        Object obj2;
        Object obj;
        int i7;
        float weight;
        int i5;
        int cmp;
        int i6;
        final Object obj3 = crossAxisSize;
        final int i8 = mainAxisAvailable;
        final int i9 = 0;
        if (children.isEmpty()) {
            return 0;
        }
        int i10 = 0;
        fixedSpace = Math.min(i14 *= mainAxisSpacing, i8);
        crossAxisMax = 0;
        totalWeight = 0;
        i4 = children;
        round = 0;
        index$iv2 = 0;
        intValue = 0;
        i3 = Integer.MAX_VALUE;
        while (index$iv2 < i4.size()) {
            obj = obj2;
            i7 = 0;
            weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj));
            if (Float.compare(weight, intValue) == 0) {
            } else {
            }
            i5 = i;
            if (i5 != 0) {
            } else {
            }
            obj5 = mainAxisSize;
            if (Float.compare(weight, intValue) > 0) {
            }
            index$iv2++;
            i = 0;
            i2 = 1;
            intValue = 0;
            i3 = Integer.MAX_VALUE;
            totalWeight += weight;
            if (i8 == i3) {
            } else {
            }
            intValue = i8 - fixedSpace;
            i3 = Math.min((Number)mainAxisSize.invoke(obj, Integer.valueOf(i3)).intValue(), intValue);
            fixedSpace += i3;
            crossAxisMax = cmp2;
            intValue = i3;
            i5 = i2;
        }
        Object obj4 = mainAxisSize;
        cmp = Float.compare(totalWeight, intValue) == 0 ? 1 : 0;
        if (cmp != 0) {
            $this$fastRoundToInt$iv2 = 0;
        } else {
            if (i8 == i3) {
                $this$fastRoundToInt$iv2 = i3;
            } else {
                i4 = 0;
                $this$fastRoundToInt$iv2 = round;
            }
        }
        int i17 = children;
        int i18 = 0;
        index$iv = 0;
        while (index$iv < i17.size()) {
            obj = obj2;
            i7 = 0;
            weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj));
            if (Float.compare(weight, intValue) > 0) {
            }
            index$iv++;
            intValue = 0;
            if ($this$fastRoundToInt$iv2 != i3) {
            } else {
            }
            $this$fastRoundToInt$iv = i3;
            crossAxisMax = Math.max(crossAxisMax, (Number)obj3.invoke(obj, Integer.valueOf($this$fastRoundToInt$iv)).intValue());
            i6 = 0;
            $this$fastRoundToInt$iv = Math.round(f2 *= weight);
        }
        return crossAxisMax;
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> children, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> mainAxisSize, int crossAxisAvailable, int mainAxisSpacing) {
        int weightUnitSpace;
        int fixedSpace;
        int totalWeight;
        int index$iv;
        int $this$fastRoundToInt$iv;
        Object obj;
        Object obj2;
        int i2;
        float weight;
        int intValue;
        Object obj4;
        int i;
        int cmp;
        final int i3 = 0;
        int i4 = 0;
        if (children.isEmpty()) {
            return i4;
        }
        weightUnitSpace = 0;
        fixedSpace = 0;
        totalWeight = 0;
        Object obj3 = children;
        final int i10 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            obj2 = obj;
            i2 = 0;
            weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)obj2));
            intValue = (Number)mainAxisSize.invoke(obj2, Integer.valueOf(crossAxisAvailable)).intValue();
            i = 0;
            if (Float.compare(weight, i) == 0) {
            } else {
            }
            $this$fastRoundToInt$iv = i4;
            if ($this$fastRoundToInt$iv != 0) {
            } else {
            }
            if (Float.compare(weight, i) > 0) {
            }
            index$iv++;
            totalWeight += weight;
            i = 0;
            weightUnitSpace = Math.max(weightUnitSpace, Math.round(f2 /= weight));
            fixedSpace += intValue;
        }
        Object obj5 = mainAxisSize;
        int i7 = 0;
        return $this$fastRoundToInt$iv3 += i9;
    }

    public static final boolean isRelative(androidx.compose.foundation.layout.RowColumnParentData $this$isRelative) {
        boolean relative$foundation_layout_release;
        androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment($this$isRelative);
        if (crossAxisAlignment != null) {
            relative$foundation_layout_release = crossAxisAlignment.isRelative$foundation_layout_release();
        } else {
            relative$foundation_layout_release = 0;
        }
        return relative$foundation_layout_release;
    }
}
