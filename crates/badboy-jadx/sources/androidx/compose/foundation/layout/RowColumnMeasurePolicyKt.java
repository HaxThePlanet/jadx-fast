package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017", d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RowColumnMeasurePolicyKt {
    public static final MeasureResult measure(androidx.compose.foundation.layout.RowColumnMeasurePolicy $this$measure, int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, int arrangementSpacingInt, MeasureScope measureScope, List<? extends Measurable> measurables, Placeable[] placeables, int startIndex, int endIndex, int[] crossAxisOffset, int currentLineIndex) {
        int totalWeight;
        int i16;
        int placeableCrossAxisSize;
        Integer valueOf;
        int i12;
        int i11;
        int coerceIn;
        String str3;
        long l3;
        String str8;
        String str23;
        String str6;
        int weightedSize;
        int intValue5;
        Object child;
        Object childMainAxisSize2;
        int weightedSpace2;
        String weightedSpace;
        String childConstraints;
        int childMainAxisSize;
        int constraints-xF2OJ5Q$default;
        int fixedSpace2;
        int i20;
        int i22;
        String str21;
        int crossAxisSpace;
        int afterCrossAxisAlignmentLine2;
        int afterCrossAxisAlignmentLine;
        int weightChildrenCount;
        int i5;
        int anyAlignBy2;
        int itemWeight;
        String i;
        int[] targetSpace;
        int weightUnitSpace;
        int targetSpace2;
        int intValue;
        long l4;
        int i17;
        int i24;
        int str13;
        int i6;
        int subSize;
        int subSize2;
        String weightChildrenCount2;
        String fixedSpace3;
        int fixedSpace;
        String str19;
        int i15;
        int i4;
        String str14;
        int crossAxisSpace3;
        int str25;
        int i19;
        int i8;
        int intValue3;
        int i9;
        int anyAlignBy;
        int i10;
        Throwable valueOf2;
        Object flowLayoutData;
        int intValue2;
        int i21;
        int coerceAtLeast;
        int arrangementSpacingPx;
        int str4;
        int i18;
        String totalWeight3;
        int fixedSpace4;
        int totalWeight4;
        int totalWeight2;
        String crossAxisSpace2;
        String relative;
        long rowColumnParentData;
        int intValue4;
        int[] iArr;
        int i2;
        int[] remaining;
        int remainder;
        int i14;
        String weightedSpace5;
        int weightedSpace4;
        int weightedSpace3;
        String str16;
        String str5;
        String str18;
        String str20;
        String str7;
        float f3;
        float flowLayoutData2;
        String str9;
        int i7;
        long l6;
        long l2;
        long l7;
        String str15;
        int i23;
        float f2;
        int i13;
        long l;
        String str17;
        int i3;
        String str24;
        float f4;
        float f;
        String str10;
        String str22;
        String str2;
        String str12;
        String str;
        String str11;
        long l5;
        final int i63 = mainAxisMin;
        final int i64 = mainAxisMax;
        i15 = crossAxisMax;
        str25 = arrangementSpacingInt;
        i24 = measurables;
        fixedSpace = endIndex;
        l3 = (long)str25;
        targetSpace = new int[fixedSpace - startIndex];
        intValue3 = 0;
        fixedSpace2 = i25;
        totalWeight = i73;
        anyAlignBy = i48;
        anyAlignBy2 = i42;
        weightChildrenCount = i41;
        crossAxisSpace = i74;
        i10 = intValue;
        valueOf2 = 0;
        int i76 = 0;
        intValue = Integer.MAX_VALUE;
        long l13 = l3;
        while (totalWeight < fixedSpace) {
            Object obj = i24.get(totalWeight);
            totalWeight3 = RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)(Measurable)obj);
            crossAxisSpace2 = RowColumnImplKt.getWeight(totalWeight3);
            if (anyAlignBy == 0) {
            }
            anyAlignBy = i21;
            if (Float.compare(crossAxisSpace2, i76) > 0) {
            } else {
            }
            if (i15 == intValue) {
            } else {
            }
            flowLayoutData = totalWeight3.getFlowLayoutData();
            if (totalWeight3 != null && flowLayoutData != null) {
            }
            constraints-xF2OJ5Q$default = i64 - crossAxisSpace;
            if (placeables[totalWeight] == null) {
            } else {
            }
            i14 = totalWeight;
            totalWeight = obj;
            i21 = constraints-xF2OJ5Q$default;
            i24 = fixedSpace2;
            i15 = weightChildrenCount;
            remaining = targetSpace;
            relative = l13;
            child = $this$measure;
            str4 = crossAxisSpace;
            arrangementSpacingPx = subSize;
            subSize = anyAlignBy2;
            childMainAxisSize2 = flowLayoutData;
            int mainAxisSize = child.mainAxisSize(childMainAxisSize2);
            remaining[i14 - startIndex] = mainAxisSize;
            int i47 = Math.min(str25, RangesKt.coerceAtLeast(i21 - mainAxisSize, 0));
            placeables[i14] = childMainAxisSize2;
            i10 = i47;
            crossAxisSpace = i53;
            weightChildrenCount = targetSpace;
            fixedSpace2 = i24;
            anyAlignBy2 = subSize;
            totalWeight = i14 + 1;
            i15 = crossAxisMax;
            i24 = measurables;
            subSize = arrangementSpacingPx;
            l3 = relative;
            targetSpace = remaining;
            valueOf2 = 0;
            i76 = 0;
            intValue = Integer.MAX_VALUE;
            l13 = l3;
            if (valueOf2 != 0) {
            } else {
            }
            intValue2 = 0;
            if (i64 == intValue) {
            } else {
            }
            coerceAtLeast = RangesKt.coerceAtLeast(constraints-xF2OJ5Q$default, 0);
            if (valueOf2 != 0) {
            } else {
            }
            intValue4 = i15;
            i2 = i17;
            i14 = totalWeight;
            i24 = fixedSpace2;
            i15 = weightChildrenCount;
            fixedSpace2 = intValue2;
            str4 = crossAxisSpace;
            arrangementSpacingPx = subSize;
            i21 = i78;
            subSize = remainder;
            remaining = iArr;
            relative = l5;
            flowLayoutData = obj.measure-BRTryo0(RowColumnMeasurePolicy.createConstraints-xF2OJ5Q$default($this$measure, 0, fixedSpace2, coerceAtLeast, intValue4, false, 16, 0));
            intValue4 = valueOf2.intValue();
            coerceAtLeast = intValue;
            i17 = 0;
            intValue2 = valueOf2.intValue();
            flowLayoutData = totalWeight3.getFlowLayoutData();
            if (flowLayoutData != null) {
            }
            int i75 = 0;
            int i37 = 0;
            valueOf2 = Integer.valueOf(Math.round(fillCrossAxisFraction *= f6));
            fixedSpace2 += crossAxisSpace2;
            anyAlignBy2++;
            child = $this$measure;
            i14 = totalWeight;
            remaining = targetSpace;
            relative = l13;
            arrangementSpacingPx = subSize;
            if (RowColumnImplKt.isRelative(totalWeight3)) {
            } else {
            }
            i21 = 0;
        }
        str8 = $this$measure;
        str13 = fixedSpace2;
        i4 = weightChildrenCount;
        int[] iArr5 = targetSpace;
        rowColumnParentData = l13;
        i18 = crossAxisSpace;
        subSize2 = anyAlignBy2;
        if (subSize2 == 0) {
            totalWeight2 = crossAxisSpace;
            i3 = str13;
            weightedSpace3 = subSize2;
            l2 = rowColumnParentData;
            coerceIn = weightedSpace2;
        } else {
            i16 = i64 != intValue ? i64 : i63;
            int i49 = subSize2 + -1;
            l4 = coerceAtLeast3;
            f7 /= fixedSpace4;
            remainder = l4;
            itemWeight = startIndex;
            weightedSpace = "remainingToTarget ";
            str16 = crossAxisSpace4;
            str14 = "arrangementSpacingTotal ";
            str5 = i5;
            weightChildrenCount = "fixedSpace ";
            str18 = str31;
            str25 = "weightChildrenCount ";
            str20 = str26;
            str23 = "arrangementSpacingPx ";
            str7 = l4;
            String remainingToTarget = "targetSpace ";
            str13 = "mainAxisMin ";
            while (itemWeight < fixedSpace) {
                l6 = 0;
                remainder -= l9;
                itemWeight = i7 + 1;
                str8 = $this$measure;
                str25 = arrangementSpacingInt;
                fixedSpace = endIndex;
                i4 = crossAxisSpace2;
                weightedSpace2 = weightedSpace5;
                i5 = str5;
                l4 = str7;
                weightedSpace = "remainingToTarget ";
                str16 = crossAxisSpace4;
                str14 = "arrangementSpacingTotal ";
                str5 = i5;
                weightChildrenCount = "fixedSpace ";
                str18 = str31;
                str25 = "weightChildrenCount ";
                str20 = str26;
                str23 = "arrangementSpacingPx ";
                str7 = l4;
                remainingToTarget = "targetSpace ";
                str13 = "mainAxisMin ";
            }
            i7 = itemWeight;
            fixedSpace = i18;
            l2 = rowColumnParentData;
            l7 = str7;
            anyAlignBy2 = startIndex;
            String str32 = str14;
            while (anyAlignBy2 < endIndex) {
                str = weightedSpace;
                f2 = i20;
                str11 = weightChildrenCount;
                iArr = anyAlignBy2;
                childConstraints = str32;
                str17 = fixedSpace4;
                i = str16;
                str7 = l7;
                i18 = weightUnitSpace;
                weightedSpace4 = subSize2;
                totalWeight4 = fixedSpace;
                targetSpace2 = str5;
                weightChildrenCount2 = str23;
                str6 = $this$measure;
                placeableCrossAxisSize = crossAxisSpace5;
                crossAxisSpace2 = crossAxisSpace3;
                str14 = childConstraints;
                str16 = i;
                str5 = targetSpace2;
                str23 = weightChildrenCount2;
                weightUnitSpace = i18;
                fixedSpace = totalWeight4;
                subSize2 = weightedSpace4;
                l7 = str7;
                fixedSpace4 = str17;
                weightedSpace = str;
                weightChildrenCount = str11;
                weightedSpace5 = placeableCrossAxisSize;
                anyAlignBy2 = i40;
                i20 = f2;
                str32 = str14;
                iArr = anyAlignBy2;
                Object i50 = obj3;
                rowColumnParentData = RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)(Measurable)i50);
                f3 = weight;
                int weight2 = crossAxisMax;
                if (weight2 == Integer.MAX_VALUE) {
                } else {
                }
                flowLayoutData2 = rowColumnParentData.getFlowLayoutData();
                if (rowColumnParentData != null && flowLayoutData2 != null) {
                } else {
                }
                valueOf = valueOf2;
                flowLayoutData2 = valueOf;
                if (Float.compare(f3, i76) > 0) {
                } else {
                }
                i12 = 0;
                int sign = MathKt.getSign(remainder);
                remainder -= l8;
                int i31 = str5 * f3;
                int i80 = 0;
                childMainAxisSize = Math.max(0, $this$fastRoundToInt$iv += sign);
                i23 = 0;
                if (RowColumnImplKt.getFill(rowColumnParentData)) {
                } else {
                }
                i11 = Integer.MAX_VALUE;
                i13 = i20;
                crossAxisSpace = childMainAxisSize;
                childMainAxisSize = 0;
                if (flowLayoutData2 != null) {
                } else {
                }
                i20 = 0;
                if (flowLayoutData2 != null) {
                } else {
                }
                intValue5 = crossAxisMax;
                str11 = weightChildrenCount;
                str17 = fixedSpace4;
                f4 = f3;
                str10 = i7;
                f = l6;
                str = str15;
                weightedSpace4 = subSize2;
                totalWeight4 = fixedSpace;
                weightChildrenCount2 = str9;
                str6 = $this$measure;
                weightChildrenCount = i50.measure-BRTryo0(str6.createConstraints-xF2OJ5Q(childMainAxisSize, i20, crossAxisSpace, intValue5, true));
                int mainAxisSize2 = str6.mainAxisSize(weightChildrenCount);
                iArr5[iArr - startIndex] = mainAxisSize2;
                placeables[iArr] = weightChildrenCount;
                childConstraints = str32;
                str7 = l7;
                f2 = l;
                i = str22;
                str18 = str2;
                str20 = str12;
                i18 = weightUnitSpace;
                targetSpace2 = str24;
                placeableCrossAxisSize = weightedSpace6;
                crossAxisSpace2 = crossAxisSpace3;
                intValue5 = flowLayoutData2.intValue();
                i20 = weightedSize;
                if (childMainAxisSize != Integer.MAX_VALUE) {
                } else {
                }
                i13 = i20;
                crossAxisSpace = childMainAxisSize;
                i12 = i21;
                flowLayoutData2 = rowColumnParentData.getFlowLayoutData();
                if (flowLayoutData2 != null) {
                } else {
                }
                str9 = 0;
                int i28 = 0;
                valueOf = Integer.valueOf(Math.round(fillCrossAxisFraction2 *= f5));
                valueOf = valueOf2;
            }
            str8 = $this$measure;
            iArr = anyAlignBy2;
            i18 = weightUnitSpace;
            i3 = fixedSpace4;
            i4 = crossAxisSpace2;
            targetSpace = str5;
            str7 = l7;
            weightedSpace3 = subSize2;
            weightedSpace2 = coerceIn;
        }
        if (anyAlignBy != 0) {
            weightedSpace2 = startIndex;
            fixedSpace2 = intValue3;
            afterCrossAxisAlignmentLine = i9;
            while (weightedSpace2 < endIndex) {
                weightChildrenCount = placeables[weightedSpace2];
                Intrinsics.checkNotNull(weightChildrenCount);
                androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(weightChildrenCount));
                if (crossAxisAlignment != null) {
                } else {
                }
                targetSpace = valueOf2;
                if (targetSpace != 0) {
                }
                weightedSpace2++;
                intValue = (Number)targetSpace.intValue();
                str13 = 0;
                subSize2 = str8.crossAxisSize(weightChildrenCount);
                if (intValue != Integer.MIN_VALUE) {
                } else {
                }
                i19 = 0;
                fixedSpace2 = i70;
                if (intValue != Integer.MIN_VALUE) {
                } else {
                }
                i8 = subSize2;
                afterCrossAxisAlignmentLine = str25;
                i8 = intValue;
                i19 = intValue3;
                targetSpace = crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(weightChildrenCount);
            }
            i9 = afterCrossAxisAlignmentLine;
            afterCrossAxisAlignmentLine2 = fixedSpace2;
        } else {
            fixedSpace = endIndex;
            afterCrossAxisAlignmentLine2 = intValue3;
        }
        int i51 = Math.max(RangesKt.coerceAtLeast(totalWeight2 + coerceIn, 0), i63);
        int i36 = arrangementSpacingPx2;
        int[] iArr2 = new int[i36];
        i22 = 0;
        while (i22 < i36) {
            iArr2[i22] = 0;
            i22++;
        }
        MeasureScope measureScope2 = measureScope;
        int[] iArr3 = iArr5;
        str8.populateMainAxisPositions(i51, iArr3, iArr2, measureScope2);
        int i77 = i36;
        int[] iArr4 = iArr3;
        return str8.placeHelper(placeables, measureScope2, afterCrossAxisAlignmentLine2, iArr2, i51, Math.max(i4, Math.max(crossAxisMin, afterCrossAxisAlignmentLine2 + i9)), crossAxisOffset, currentLineIndex, startIndex, fixedSpace);
    }

    public static MeasureResult measure$default(androidx.compose.foundation.layout.RowColumnMeasurePolicy rowColumnMeasurePolicy, int i2, int i3, int i4, int i5, int i6, MeasureScope measureScope7, List list8, Placeable[] placeable9Arr9, int i10, int i11, int[] i12Arr12, int i13, int i14, Object object15) {
        int i8;
        int i;
        int i9;
        int i7;
        int i12 = i14;
        i9 = i12 & 1024 != 0 ? i : i12Arr12;
        i7 = i12 &= 2048 != 0 ? i8 : i13;
        return RowColumnMeasurePolicyKt.measure(rowColumnMeasurePolicy, i2, i3, i4, i5, i6, measureScope7, list8, placeable9Arr9, i10, i11, i9, i7);
    }
}
