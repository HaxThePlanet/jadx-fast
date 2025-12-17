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
        int totalWeight2;
        int i;
        int placeableCrossAxisSize;
        Integer valueOf;
        int i12;
        int i4;
        int coerceIn;
        String str8;
        long l;
        String str4;
        String str16;
        String str25;
        int weightedSize;
        int intValue4;
        Object child;
        Object childMainAxisSize;
        int weightedSpace;
        String weightedSpace5;
        String childConstraints;
        int childMainAxisSize2;
        int constraints-xF2OJ5Q$default;
        int fixedSpace2;
        int i16;
        int i2;
        String str2;
        int crossAxisSpace;
        int afterCrossAxisAlignmentLine2;
        int afterCrossAxisAlignmentLine;
        int weightChildrenCount;
        int i7;
        int anyAlignBy2;
        int itemWeight;
        String i19;
        int[] targetSpace2;
        int weightUnitSpace;
        int targetSpace;
        int intValue5;
        long l4;
        int i22;
        int i24;
        int str15;
        int i14;
        int subSize2;
        int subSize;
        String weightChildrenCount2;
        String fixedSpace4;
        int fixedSpace3;
        String str23;
        int i8;
        int i20;
        String str9;
        int crossAxisSpace3;
        int str11;
        int i9;
        int i11;
        int intValue;
        int i5;
        int anyAlignBy;
        int i21;
        Throwable valueOf2;
        Object flowLayoutData2;
        int intValue2;
        int i18;
        int coerceAtLeast;
        int arrangementSpacingPx;
        int str;
        int i15;
        String totalWeight3;
        int fixedSpace;
        int totalWeight;
        int totalWeight4;
        String crossAxisSpace2;
        String relative;
        long rowColumnParentData;
        int intValue3;
        int[] iArr;
        int i3;
        int[] remaining;
        int remainder;
        int i23;
        String weightedSpace4;
        int weightedSpace2;
        int weightedSpace3;
        String str18;
        String str5;
        String str3;
        String str21;
        String str13;
        float f4;
        float flowLayoutData;
        String str24;
        int i13;
        long l2;
        long l5;
        long l3;
        String str22;
        int i17;
        float f3;
        int i6;
        long l6;
        String str12;
        int i10;
        String str19;
        float f;
        float f2;
        String str10;
        String str6;
        String str17;
        String str20;
        String str7;
        String str14;
        long l7;
        final int i63 = mainAxisMin;
        final int i64 = mainAxisMax;
        i8 = crossAxisMax;
        str11 = arrangementSpacingInt;
        i24 = measurables;
        fixedSpace3 = endIndex;
        l = (long)str11;
        targetSpace2 = new int[fixedSpace3 - startIndex];
        intValue = 0;
        fixedSpace2 = i25;
        totalWeight2 = i73;
        anyAlignBy = i48;
        anyAlignBy2 = i42;
        weightChildrenCount = i41;
        crossAxisSpace = i74;
        i21 = intValue5;
        valueOf2 = 0;
        int i76 = 0;
        intValue5 = Integer.MAX_VALUE;
        long l13 = l;
        while (totalWeight2 < fixedSpace3) {
            Object obj = i24.get(totalWeight2);
            totalWeight3 = RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)(Measurable)obj);
            crossAxisSpace2 = RowColumnImplKt.getWeight(totalWeight3);
            if (anyAlignBy == 0) {
            }
            anyAlignBy = i18;
            if (Float.compare(crossAxisSpace2, i76) > 0) {
            } else {
            }
            if (i8 == intValue5) {
            } else {
            }
            flowLayoutData2 = totalWeight3.getFlowLayoutData();
            if (totalWeight3 != null && flowLayoutData2 != null) {
            }
            constraints-xF2OJ5Q$default = i64 - crossAxisSpace;
            if (placeables[totalWeight2] == null) {
            } else {
            }
            i23 = totalWeight2;
            totalWeight2 = obj;
            i18 = constraints-xF2OJ5Q$default;
            i24 = fixedSpace2;
            i8 = weightChildrenCount;
            remaining = targetSpace2;
            relative = l13;
            child = $this$measure;
            str = crossAxisSpace;
            arrangementSpacingPx = subSize2;
            subSize2 = anyAlignBy2;
            childMainAxisSize = flowLayoutData2;
            int mainAxisSize = child.mainAxisSize(childMainAxisSize);
            remaining[i23 - startIndex] = mainAxisSize;
            int i47 = Math.min(str11, RangesKt.coerceAtLeast(i18 - mainAxisSize, 0));
            placeables[i23] = childMainAxisSize;
            i21 = i47;
            crossAxisSpace = i53;
            weightChildrenCount = targetSpace2;
            fixedSpace2 = i24;
            anyAlignBy2 = subSize2;
            totalWeight2 = i23 + 1;
            i8 = crossAxisMax;
            i24 = measurables;
            subSize2 = arrangementSpacingPx;
            l = relative;
            targetSpace2 = remaining;
            valueOf2 = 0;
            i76 = 0;
            intValue5 = Integer.MAX_VALUE;
            l13 = l;
            if (valueOf2 != 0) {
            } else {
            }
            intValue2 = 0;
            if (i64 == intValue5) {
            } else {
            }
            coerceAtLeast = RangesKt.coerceAtLeast(constraints-xF2OJ5Q$default, 0);
            if (valueOf2 != 0) {
            } else {
            }
            intValue3 = i8;
            i3 = i22;
            i23 = totalWeight2;
            i24 = fixedSpace2;
            i8 = weightChildrenCount;
            fixedSpace2 = intValue2;
            str = crossAxisSpace;
            arrangementSpacingPx = subSize2;
            i18 = i78;
            subSize2 = remainder;
            remaining = iArr;
            relative = l7;
            flowLayoutData2 = obj.measure-BRTryo0(RowColumnMeasurePolicy.createConstraints-xF2OJ5Q$default($this$measure, 0, fixedSpace2, coerceAtLeast, intValue3, false, 16, 0));
            intValue3 = valueOf2.intValue();
            coerceAtLeast = intValue5;
            i22 = 0;
            intValue2 = valueOf2.intValue();
            flowLayoutData2 = totalWeight3.getFlowLayoutData();
            if (flowLayoutData2 != null) {
            }
            int i75 = 0;
            int i37 = 0;
            valueOf2 = Integer.valueOf(Math.round(fillCrossAxisFraction *= f6));
            fixedSpace2 += crossAxisSpace2;
            anyAlignBy2++;
            child = $this$measure;
            i23 = totalWeight2;
            remaining = targetSpace2;
            relative = l13;
            arrangementSpacingPx = subSize2;
            if (RowColumnImplKt.isRelative(totalWeight3)) {
            } else {
            }
            i18 = 0;
        }
        str4 = $this$measure;
        str15 = fixedSpace2;
        i20 = weightChildrenCount;
        int[] iArr5 = targetSpace2;
        rowColumnParentData = l13;
        i15 = crossAxisSpace;
        subSize = anyAlignBy2;
        if (subSize == 0) {
            totalWeight4 = crossAxisSpace;
            i10 = str15;
            weightedSpace3 = subSize;
            l5 = rowColumnParentData;
            coerceIn = weightedSpace;
        } else {
            i = i64 != intValue5 ? i64 : i63;
            int i49 = subSize + -1;
            l4 = coerceAtLeast3;
            f7 /= fixedSpace;
            remainder = l4;
            itemWeight = startIndex;
            weightedSpace5 = "remainingToTarget ";
            str18 = crossAxisSpace4;
            str9 = "arrangementSpacingTotal ";
            str5 = i7;
            weightChildrenCount = "fixedSpace ";
            str3 = str31;
            str11 = "weightChildrenCount ";
            str21 = str26;
            str16 = "arrangementSpacingPx ";
            str13 = l4;
            String remainingToTarget = "targetSpace ";
            str15 = "mainAxisMin ";
            while (itemWeight < fixedSpace3) {
                l2 = 0;
                remainder -= l9;
                itemWeight = i13 + 1;
                str4 = $this$measure;
                str11 = arrangementSpacingInt;
                fixedSpace3 = endIndex;
                i20 = crossAxisSpace2;
                weightedSpace = weightedSpace4;
                i7 = str5;
                l4 = str13;
                weightedSpace5 = "remainingToTarget ";
                str18 = crossAxisSpace4;
                str9 = "arrangementSpacingTotal ";
                str5 = i7;
                weightChildrenCount = "fixedSpace ";
                str3 = str31;
                str11 = "weightChildrenCount ";
                str21 = str26;
                str16 = "arrangementSpacingPx ";
                str13 = l4;
                remainingToTarget = "targetSpace ";
                str15 = "mainAxisMin ";
            }
            i13 = itemWeight;
            fixedSpace3 = i15;
            l5 = rowColumnParentData;
            l3 = str13;
            anyAlignBy2 = startIndex;
            String str32 = str9;
            while (anyAlignBy2 < endIndex) {
                str7 = weightedSpace5;
                f3 = i16;
                str14 = weightChildrenCount;
                iArr = anyAlignBy2;
                childConstraints = str32;
                str12 = fixedSpace;
                i19 = str18;
                str13 = l3;
                i15 = weightUnitSpace;
                weightedSpace2 = subSize;
                totalWeight = fixedSpace3;
                targetSpace = str5;
                weightChildrenCount2 = str16;
                str25 = $this$measure;
                placeableCrossAxisSize = crossAxisSpace5;
                crossAxisSpace2 = crossAxisSpace3;
                str9 = childConstraints;
                str18 = i19;
                str5 = targetSpace;
                str16 = weightChildrenCount2;
                weightUnitSpace = i15;
                fixedSpace3 = totalWeight;
                subSize = weightedSpace2;
                l3 = str13;
                fixedSpace = str12;
                weightedSpace5 = str7;
                weightChildrenCount = str14;
                weightedSpace4 = placeableCrossAxisSize;
                anyAlignBy2 = i40;
                i16 = f3;
                str32 = str9;
                iArr = anyAlignBy2;
                Object i50 = obj3;
                rowColumnParentData = RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)(Measurable)i50);
                f4 = weight;
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
                if (Float.compare(f4, i76) > 0) {
                } else {
                }
                i12 = 0;
                int sign = MathKt.getSign(remainder);
                remainder -= l8;
                int i31 = str5 * f4;
                int i80 = 0;
                childMainAxisSize2 = Math.max(0, $this$fastRoundToInt$iv += sign);
                i17 = 0;
                if (RowColumnImplKt.getFill(rowColumnParentData)) {
                } else {
                }
                i4 = Integer.MAX_VALUE;
                i6 = i16;
                crossAxisSpace = childMainAxisSize2;
                childMainAxisSize2 = 0;
                if (flowLayoutData != null) {
                } else {
                }
                i16 = 0;
                if (flowLayoutData != null) {
                } else {
                }
                intValue4 = crossAxisMax;
                str14 = weightChildrenCount;
                str12 = fixedSpace;
                f = f4;
                str10 = i13;
                f2 = l2;
                str7 = str22;
                weightedSpace2 = subSize;
                totalWeight = fixedSpace3;
                weightChildrenCount2 = str24;
                str25 = $this$measure;
                weightChildrenCount = i50.measure-BRTryo0(str25.createConstraints-xF2OJ5Q(childMainAxisSize2, i16, crossAxisSpace, intValue4, true));
                int mainAxisSize2 = str25.mainAxisSize(weightChildrenCount);
                iArr5[iArr - startIndex] = mainAxisSize2;
                placeables[iArr] = weightChildrenCount;
                childConstraints = str32;
                str13 = l3;
                f3 = l6;
                i19 = str6;
                str3 = str17;
                str21 = str20;
                i15 = weightUnitSpace;
                targetSpace = str19;
                placeableCrossAxisSize = weightedSpace6;
                crossAxisSpace2 = crossAxisSpace3;
                intValue4 = flowLayoutData.intValue();
                i16 = weightedSize;
                if (childMainAxisSize2 != Integer.MAX_VALUE) {
                } else {
                }
                i6 = i16;
                crossAxisSpace = childMainAxisSize2;
                i12 = i18;
                flowLayoutData = rowColumnParentData.getFlowLayoutData();
                if (flowLayoutData != null) {
                } else {
                }
                str24 = 0;
                int i28 = 0;
                valueOf = Integer.valueOf(Math.round(fillCrossAxisFraction2 *= f5));
                valueOf = valueOf2;
            }
            str4 = $this$measure;
            iArr = anyAlignBy2;
            i15 = weightUnitSpace;
            i10 = fixedSpace;
            i20 = crossAxisSpace2;
            targetSpace2 = str5;
            str13 = l3;
            weightedSpace3 = subSize;
            weightedSpace = coerceIn;
        }
        if (anyAlignBy != 0) {
            weightedSpace = startIndex;
            fixedSpace2 = intValue;
            afterCrossAxisAlignmentLine = i5;
            while (weightedSpace < endIndex) {
                weightChildrenCount = placeables[weightedSpace];
                Intrinsics.checkNotNull(weightChildrenCount);
                androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(weightChildrenCount));
                if (crossAxisAlignment != null) {
                } else {
                }
                targetSpace2 = valueOf2;
                if (targetSpace2 != 0) {
                }
                weightedSpace++;
                intValue5 = (Number)targetSpace2.intValue();
                str15 = 0;
                subSize = str4.crossAxisSize(weightChildrenCount);
                if (intValue5 != Integer.MIN_VALUE) {
                } else {
                }
                i9 = 0;
                fixedSpace2 = i70;
                if (intValue5 != Integer.MIN_VALUE) {
                } else {
                }
                i11 = subSize;
                afterCrossAxisAlignmentLine = str11;
                i11 = intValue5;
                i9 = intValue;
                targetSpace2 = crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(weightChildrenCount);
            }
            i5 = afterCrossAxisAlignmentLine;
            afterCrossAxisAlignmentLine2 = fixedSpace2;
        } else {
            fixedSpace3 = endIndex;
            afterCrossAxisAlignmentLine2 = intValue;
        }
        int i51 = Math.max(RangesKt.coerceAtLeast(totalWeight4 + coerceIn, 0), i63);
        int i36 = arrangementSpacingPx2;
        int[] iArr2 = new int[i36];
        i2 = 0;
        while (i2 < i36) {
            iArr2[i2] = 0;
            i2++;
        }
        MeasureScope measureScope2 = measureScope;
        int[] iArr3 = iArr5;
        str4.populateMainAxisPositions(i51, iArr3, iArr2, measureScope2);
        int i77 = i36;
        int[] iArr4 = iArr3;
        return str4.placeHelper(placeables, measureScope2, afterCrossAxisAlignmentLine2, iArr2, i51, Math.max(i20, Math.max(crossAxisMin, afterCrossAxisAlignmentLine2 + i5)), crossAxisOffset, currentLineIndex, startIndex, fixedSpace3);
    }

    public static MeasureResult measure$default(androidx.compose.foundation.layout.RowColumnMeasurePolicy rowColumnMeasurePolicy, int i2, int i3, int i4, int i5, int i6, MeasureScope measureScope7, List list8, Placeable[] placeable9Arr9, int i10, int i11, int[] i12Arr12, int i13, int i14, Object object15) {
        int i9;
        int i8;
        int i;
        int i7;
        int i12 = i14;
        i = i12 & 1024 != 0 ? i8 : i12Arr12;
        i7 = i12 &= 2048 != 0 ? i9 : i13;
        return RowColumnMeasurePolicyKt.measure(rowColumnMeasurePolicy, i2, i3, i4, i5, i6, measureScope7, list8, placeable9Arr9, i10, i11, i, i7);
    }
}
