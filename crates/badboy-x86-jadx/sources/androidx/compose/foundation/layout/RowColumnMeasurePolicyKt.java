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
        int i20;
        int placeableCrossAxisSize;
        Integer valueOf;
        int i15;
        int i;
        int coerceIn;
        String str4;
        long l5;
        String str25;
        String str12;
        String str23;
        int weightedSize;
        int intValue5;
        Object child;
        Object childMainAxisSize2;
        int weightedSpace4;
        String weightedSpace2;
        String childConstraints;
        int childMainAxisSize;
        int constraints-xF2OJ5Q$default;
        int fixedSpace;
        int i13;
        int i17;
        String str19;
        int crossAxisSpace3;
        int afterCrossAxisAlignmentLine;
        int afterCrossAxisAlignmentLine2;
        int weightChildrenCount2;
        int i3;
        int anyAlignBy;
        int itemWeight;
        String i6;
        int[] targetSpace;
        int weightUnitSpace;
        int targetSpace2;
        int intValue2;
        long l7;
        int i12;
        int i24;
        int str8;
        int i2;
        int subSize2;
        int subSize;
        String weightChildrenCount;
        String fixedSpace2;
        int fixedSpace4;
        String str20;
        int i11;
        int i19;
        String str21;
        int crossAxisSpace2;
        int str2;
        int i4;
        int i7;
        int intValue;
        int i16;
        int anyAlignBy2;
        int i10;
        Throwable valueOf2;
        Object flowLayoutData2;
        int intValue3;
        int i21;
        int coerceAtLeast;
        int arrangementSpacingPx;
        int str22;
        int i22;
        String totalWeight2;
        int fixedSpace3;
        int totalWeight3;
        int totalWeight4;
        String crossAxisSpace;
        String relative;
        long rowColumnParentData;
        int intValue4;
        int[] iArr;
        int i9;
        int[] remaining;
        int remainder;
        int i5;
        String weightedSpace5;
        int weightedSpace3;
        int weightedSpace;
        String str6;
        String str14;
        String str3;
        String str18;
        String str13;
        float f3;
        float flowLayoutData;
        String str5;
        int i18;
        long l6;
        long l3;
        long l4;
        String str;
        int i8;
        float f;
        int i14;
        long l;
        String str11;
        int i23;
        String str9;
        float f4;
        float f2;
        String str17;
        String str16;
        String str15;
        String str10;
        String str7;
        String str24;
        long l2;
        final int i63 = mainAxisMin;
        final int i64 = mainAxisMax;
        i11 = crossAxisMax;
        str2 = arrangementSpacingInt;
        i24 = measurables;
        fixedSpace4 = endIndex;
        l5 = (long)str2;
        targetSpace = new int[fixedSpace4 - startIndex];
        intValue = 0;
        fixedSpace = i25;
        totalWeight = i73;
        anyAlignBy2 = i48;
        anyAlignBy = i42;
        weightChildrenCount2 = i41;
        crossAxisSpace3 = i74;
        i10 = intValue2;
        valueOf2 = 0;
        int i76 = 0;
        intValue2 = Integer.MAX_VALUE;
        long l13 = l5;
        while (totalWeight < fixedSpace4) {
            Object obj = i24.get(totalWeight);
            totalWeight2 = RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)(Measurable)obj);
            crossAxisSpace = RowColumnImplKt.getWeight(totalWeight2);
            if (anyAlignBy2 == 0) {
            }
            anyAlignBy2 = i21;
            if (Float.compare(crossAxisSpace, i76) > 0) {
            } else {
            }
            if (i11 == intValue2) {
            } else {
            }
            flowLayoutData2 = totalWeight2.getFlowLayoutData();
            if (totalWeight2 != null && flowLayoutData2 != null) {
            }
            constraints-xF2OJ5Q$default = i64 - crossAxisSpace3;
            if (placeables[totalWeight] == null) {
            } else {
            }
            i5 = totalWeight;
            totalWeight = obj;
            i21 = constraints-xF2OJ5Q$default;
            i24 = fixedSpace;
            i11 = weightChildrenCount2;
            remaining = targetSpace;
            relative = l13;
            child = $this$measure;
            str22 = crossAxisSpace3;
            arrangementSpacingPx = subSize2;
            subSize2 = anyAlignBy;
            childMainAxisSize2 = flowLayoutData2;
            int mainAxisSize = child.mainAxisSize(childMainAxisSize2);
            remaining[i5 - startIndex] = mainAxisSize;
            int i47 = Math.min(str2, RangesKt.coerceAtLeast(i21 - mainAxisSize, 0));
            placeables[i5] = childMainAxisSize2;
            i10 = i47;
            crossAxisSpace3 = i53;
            weightChildrenCount2 = targetSpace;
            fixedSpace = i24;
            anyAlignBy = subSize2;
            totalWeight = i5 + 1;
            i11 = crossAxisMax;
            i24 = measurables;
            subSize2 = arrangementSpacingPx;
            l5 = relative;
            targetSpace = remaining;
            valueOf2 = 0;
            i76 = 0;
            intValue2 = Integer.MAX_VALUE;
            l13 = l5;
            if (valueOf2 != 0) {
            } else {
            }
            intValue3 = 0;
            if (i64 == intValue2) {
            } else {
            }
            coerceAtLeast = RangesKt.coerceAtLeast(constraints-xF2OJ5Q$default, 0);
            if (valueOf2 != 0) {
            } else {
            }
            intValue4 = i11;
            i9 = i12;
            i5 = totalWeight;
            i24 = fixedSpace;
            i11 = weightChildrenCount2;
            fixedSpace = intValue3;
            str22 = crossAxisSpace3;
            arrangementSpacingPx = subSize2;
            i21 = i78;
            subSize2 = remainder;
            remaining = iArr;
            relative = l2;
            flowLayoutData2 = obj.measure-BRTryo0(RowColumnMeasurePolicy.createConstraints-xF2OJ5Q$default($this$measure, 0, fixedSpace, coerceAtLeast, intValue4, false, 16, 0));
            intValue4 = valueOf2.intValue();
            coerceAtLeast = intValue2;
            i12 = 0;
            intValue3 = valueOf2.intValue();
            flowLayoutData2 = totalWeight2.getFlowLayoutData();
            if (flowLayoutData2 != null) {
            }
            int i75 = 0;
            int i37 = 0;
            valueOf2 = Integer.valueOf(Math.round(fillCrossAxisFraction *= f6));
            fixedSpace += crossAxisSpace;
            anyAlignBy++;
            child = $this$measure;
            i5 = totalWeight;
            remaining = targetSpace;
            relative = l13;
            arrangementSpacingPx = subSize2;
            if (RowColumnImplKt.isRelative(totalWeight2)) {
            } else {
            }
            i21 = 0;
        }
        str25 = $this$measure;
        str8 = fixedSpace;
        i19 = weightChildrenCount2;
        int[] iArr5 = targetSpace;
        rowColumnParentData = l13;
        i22 = crossAxisSpace3;
        subSize = anyAlignBy;
        if (subSize == 0) {
            totalWeight4 = crossAxisSpace3;
            i23 = str8;
            weightedSpace = subSize;
            l3 = rowColumnParentData;
            coerceIn = weightedSpace4;
        } else {
            i20 = i64 != intValue2 ? i64 : i63;
            int i49 = subSize + -1;
            l7 = coerceAtLeast3;
            f7 /= fixedSpace3;
            remainder = l7;
            itemWeight = startIndex;
            weightedSpace2 = "remainingToTarget ";
            str6 = crossAxisSpace4;
            str21 = "arrangementSpacingTotal ";
            str14 = i3;
            weightChildrenCount2 = "fixedSpace ";
            str3 = str31;
            str2 = "weightChildrenCount ";
            str18 = str26;
            str12 = "arrangementSpacingPx ";
            str13 = l7;
            String remainingToTarget = "targetSpace ";
            str8 = "mainAxisMin ";
            while (itemWeight < fixedSpace4) {
                l6 = 0;
                remainder -= l9;
                itemWeight = i18 + 1;
                str25 = $this$measure;
                str2 = arrangementSpacingInt;
                fixedSpace4 = endIndex;
                i19 = crossAxisSpace;
                weightedSpace4 = weightedSpace5;
                i3 = str14;
                l7 = str13;
                weightedSpace2 = "remainingToTarget ";
                str6 = crossAxisSpace4;
                str21 = "arrangementSpacingTotal ";
                str14 = i3;
                weightChildrenCount2 = "fixedSpace ";
                str3 = str31;
                str2 = "weightChildrenCount ";
                str18 = str26;
                str12 = "arrangementSpacingPx ";
                str13 = l7;
                remainingToTarget = "targetSpace ";
                str8 = "mainAxisMin ";
            }
            i18 = itemWeight;
            fixedSpace4 = i22;
            l3 = rowColumnParentData;
            l4 = str13;
            anyAlignBy = startIndex;
            String str32 = str21;
            while (anyAlignBy < endIndex) {
                str7 = weightedSpace2;
                f = i13;
                str24 = weightChildrenCount2;
                iArr = anyAlignBy;
                childConstraints = str32;
                str11 = fixedSpace3;
                i6 = str6;
                str13 = l4;
                i22 = weightUnitSpace;
                weightedSpace3 = subSize;
                totalWeight3 = fixedSpace4;
                targetSpace2 = str14;
                weightChildrenCount = str12;
                str23 = $this$measure;
                placeableCrossAxisSize = crossAxisSpace5;
                crossAxisSpace = crossAxisSpace2;
                str21 = childConstraints;
                str6 = i6;
                str14 = targetSpace2;
                str12 = weightChildrenCount;
                weightUnitSpace = i22;
                fixedSpace4 = totalWeight3;
                subSize = weightedSpace3;
                l4 = str13;
                fixedSpace3 = str11;
                weightedSpace2 = str7;
                weightChildrenCount2 = str24;
                weightedSpace5 = placeableCrossAxisSize;
                anyAlignBy = i40;
                i13 = f;
                str32 = str21;
                iArr = anyAlignBy;
                Object i50 = obj3;
                rowColumnParentData = RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)(Measurable)i50);
                f3 = weight;
                int weight2 = crossAxisMax;
                if (weight2 == Integer.MAX_VALUE) {
                } else {
                }
                flowLayoutData = rowColumnParentData.getFlowLayoutData();
                if (rowColumnParentData != null && flowLayoutData != null) {
                } else {
                }
                valueOf = valueOf2;
                flowLayoutData = valueOf;
                if (Float.compare(f3, i76) > 0) {
                } else {
                }
                i15 = 0;
                int sign = MathKt.getSign(remainder);
                remainder -= l8;
                int i31 = str14 * f3;
                int i80 = 0;
                childMainAxisSize = Math.max(0, $this$fastRoundToInt$iv += sign);
                i8 = 0;
                if (RowColumnImplKt.getFill(rowColumnParentData)) {
                } else {
                }
                i = Integer.MAX_VALUE;
                i14 = i13;
                crossAxisSpace3 = childMainAxisSize;
                childMainAxisSize = 0;
                if (flowLayoutData != null) {
                } else {
                }
                i13 = 0;
                if (flowLayoutData != null) {
                } else {
                }
                intValue5 = crossAxisMax;
                str24 = weightChildrenCount2;
                str11 = fixedSpace3;
                f4 = f3;
                str17 = i18;
                f2 = l6;
                str7 = str;
                weightedSpace3 = subSize;
                totalWeight3 = fixedSpace4;
                weightChildrenCount = str5;
                str23 = $this$measure;
                weightChildrenCount2 = i50.measure-BRTryo0(str23.createConstraints-xF2OJ5Q(childMainAxisSize, i13, crossAxisSpace3, intValue5, true));
                int mainAxisSize2 = str23.mainAxisSize(weightChildrenCount2);
                iArr5[iArr - startIndex] = mainAxisSize2;
                placeables[iArr] = weightChildrenCount2;
                childConstraints = str32;
                str13 = l4;
                f = l;
                i6 = str16;
                str3 = str15;
                str18 = str10;
                i22 = weightUnitSpace;
                targetSpace2 = str9;
                placeableCrossAxisSize = weightedSpace6;
                crossAxisSpace = crossAxisSpace2;
                intValue5 = flowLayoutData.intValue();
                i13 = weightedSize;
                if (childMainAxisSize != Integer.MAX_VALUE) {
                } else {
                }
                i14 = i13;
                crossAxisSpace3 = childMainAxisSize;
                i15 = i21;
                flowLayoutData = rowColumnParentData.getFlowLayoutData();
                if (flowLayoutData != null) {
                } else {
                }
                str5 = 0;
                int i28 = 0;
                valueOf = Integer.valueOf(Math.round(fillCrossAxisFraction2 *= f5));
                valueOf = valueOf2;
            }
            str25 = $this$measure;
            iArr = anyAlignBy;
            i22 = weightUnitSpace;
            i23 = fixedSpace3;
            i19 = crossAxisSpace;
            targetSpace = str14;
            str13 = l4;
            weightedSpace = subSize;
            weightedSpace4 = coerceIn;
        }
        if (anyAlignBy2 != 0) {
            weightedSpace4 = startIndex;
            fixedSpace = intValue;
            afterCrossAxisAlignmentLine2 = i16;
            while (weightedSpace4 < endIndex) {
                weightChildrenCount2 = placeables[weightedSpace4];
                Intrinsics.checkNotNull(weightChildrenCount2);
                androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(weightChildrenCount2));
                if (crossAxisAlignment != null) {
                } else {
                }
                targetSpace = valueOf2;
                if (targetSpace != 0) {
                }
                weightedSpace4++;
                intValue2 = (Number)targetSpace.intValue();
                str8 = 0;
                subSize = str25.crossAxisSize(weightChildrenCount2);
                if (intValue2 != Integer.MIN_VALUE) {
                } else {
                }
                i4 = 0;
                fixedSpace = i70;
                if (intValue2 != Integer.MIN_VALUE) {
                } else {
                }
                i7 = subSize;
                afterCrossAxisAlignmentLine2 = str2;
                i7 = intValue2;
                i4 = intValue;
                targetSpace = crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(weightChildrenCount2);
            }
            i16 = afterCrossAxisAlignmentLine2;
            afterCrossAxisAlignmentLine = fixedSpace;
        } else {
            fixedSpace4 = endIndex;
            afterCrossAxisAlignmentLine = intValue;
        }
        int i51 = Math.max(RangesKt.coerceAtLeast(totalWeight4 + coerceIn, 0), i63);
        int i36 = arrangementSpacingPx2;
        int[] iArr2 = new int[i36];
        i17 = 0;
        while (i17 < i36) {
            iArr2[i17] = 0;
            i17++;
        }
        MeasureScope measureScope2 = measureScope;
        int[] iArr3 = iArr5;
        str25.populateMainAxisPositions(i51, iArr3, iArr2, measureScope2);
        int i77 = i36;
        int[] iArr4 = iArr3;
        return str25.placeHelper(placeables, measureScope2, afterCrossAxisAlignmentLine, iArr2, i51, Math.max(i19, Math.max(crossAxisMin, afterCrossAxisAlignmentLine + i16)), crossAxisOffset, currentLineIndex, startIndex, fixedSpace4);
    }

    public static MeasureResult measure$default(androidx.compose.foundation.layout.RowColumnMeasurePolicy rowColumnMeasurePolicy, int i2, int i3, int i4, int i5, int i6, MeasureScope measureScope7, List list8, Placeable[] placeable9Arr9, int i10, int i11, int[] i12Arr12, int i13, int i14, Object object15) {
        int i8;
        int i;
        int i7;
        int i9;
        int i12 = i14;
        i7 = i12 & 1024 != 0 ? i : i12Arr12;
        i9 = i12 &= 2048 != 0 ? i8 : i13;
        return RowColumnMeasurePolicyKt.measure(rowColumnMeasurePolicy, i2, i3, i4, i5, i6, measureScope7, list8, placeable9Arr9, i10, i11, i7, i9);
    }
}
