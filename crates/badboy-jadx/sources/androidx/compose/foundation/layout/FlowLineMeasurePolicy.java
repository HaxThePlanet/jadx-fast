package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008`\u0018\u00002\u00020\u0001J=\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0019\u0010\u001aJ2\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0014H\u0016Jg\u0010$\u001a\u00020%2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0'2\u0006\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0008\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0014H\u0016¢\u0006\u0002\u00101J(\u00102\u001a\u0002032\u0006\u0010,\u001a\u00020\u00142\u0006\u00104\u001a\u00020+2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)H\u0016J\u000c\u00105\u001a\u00020\u0014*\u00020\u001dH\u0016J\u000c\u00106\u001a\u00020\u0014*\u00020\u001dH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000cR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010ø\u0001\u0002\u0082\u0002\u0011\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u00067À\u0006\u0001", d2 = {"Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "isHorizontal", "", "()Z", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "getCrossAxisPosition", "placeable", "Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "crossAxisLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeCrossAxisAlignmentLine", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "mainAxisPositions", "", "mainAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "populateMainAxisPositions", "", "childrenMainAxisSize", "crossAxisSize", "mainAxisSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlowLineMeasurePolicy extends androidx.compose.foundation.layout.RowColumnMeasurePolicy {
    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public long createConstraints-xF2OJ5Q(int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, boolean isPrioritizing) {
        long columnConstraints;
        if (isHorizontal()) {
            columnConstraints = RowKt.createRowConstraints(isPrioritizing, mainAxisMin, crossAxisMin, mainAxisMax, crossAxisMax);
        } else {
            columnConstraints = ColumnKt.createColumnConstraints(isPrioritizing, mainAxisMin, crossAxisMin, mainAxisMax, crossAxisMax);
        }
        return columnConstraints;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int crossAxisSize(Placeable $this$crossAxisSize) {
        int measuredHeight;
        if (isHorizontal()) {
            measuredHeight = $this$crossAxisSize.getMeasuredHeight();
        } else {
            measuredHeight = $this$crossAxisSize.getMeasuredWidth();
        }
        return measuredHeight;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public abstract androidx.compose.foundation.layout.CrossAxisAlignment getCrossAxisAlignment();

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int getCrossAxisPosition(Placeable placeable, androidx.compose.foundation.layout.RowColumnParentData rowColumnParentData, int crossAxisLayoutSize, LayoutDirection layoutDirection, int beforeCrossAxisAlignmentLine) {
        androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment;
        LayoutDirection ltr;
        if (rowColumnParentData != null) {
            if (rowColumnParentData.getCrossAxisAlignment() == null) {
                crossAxisAlignment = getCrossAxisAlignment();
            }
        } else {
        }
        ltr = isHorizontal() ? LayoutDirection.Ltr : layoutDirection;
        return crossAxisAlignment.align$foundation_layout_release(crossAxisLayoutSize - crossAxisSize, ltr, placeable, beforeCrossAxisAlignmentLine);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public abstract androidx.compose.foundation.layout.Arrangement.Horizontal getHorizontalArrangement();

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public abstract androidx.compose.foundation.layout.Arrangement.Vertical getVerticalArrangement();

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public abstract boolean isHorizontal();

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int mainAxisSize(Placeable $this$mainAxisSize) {
        int measuredHeight;
        if (isHorizontal()) {
            measuredHeight = $this$mainAxisSize.getMeasuredWidth();
        } else {
            measuredHeight = $this$mainAxisSize.getMeasuredHeight();
        }
        return measuredHeight;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public MeasureResult placeHelper(Placeable[] placeables, MeasureScope measureScope, int beforeCrossAxisAlignmentLine, int[] mainAxisPositions, int mainAxisLayoutSize, int crossAxisLayoutSize, int[] crossAxisOffset, int currentLineIndex, int startIndex, int endIndex) {
        int width;
        int height;
        int i;
        int i2;
        final MeasureScope measureScope3 = measureScope;
        final int i15 = 0;
        int i3 = 0;
        int i4 = 0;
        if (isHorizontal()) {
            i = width;
            i2 = height;
        } else {
            i = width;
            i2 = height;
        }
        FlowLineMeasurePolicy.placeHelper.1.1 width2 = new FlowLineMeasurePolicy.placeHelper.1.1(crossAxisOffset, currentLineIndex, startIndex, endIndex, placeables, this, crossAxisLayoutSize, measureScope3, beforeCrossAxisAlignmentLine, mainAxisPositions);
        return MeasureScope.layout$default(measureScope3, i, i2, 0, (Function1)width2, 4, 0);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public void populateMainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        int horizontal;
        androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement;
        androidx.compose.ui.unit.Density density;
        int mainAxisLayoutSize2;
        int[] iArr;
        LayoutDirection layoutDirection;
        int[] iArr2;
        androidx.compose.foundation.layout.Arrangement.Vertical obj8;
        int obj9;
        androidx.compose.ui.unit.Density obj10;
        if (isHorizontal()) {
            horizontal = 0;
            getHorizontalArrangement().arrange((Density)measureScope, mainAxisLayoutSize, childrenMainAxisSize, measureScope.getLayoutDirection(), mainAxisPositions);
        } else {
            obj9 = 0;
            getVerticalArrangement().arrange((Density)measureScope, mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions);
        }
    }
}
