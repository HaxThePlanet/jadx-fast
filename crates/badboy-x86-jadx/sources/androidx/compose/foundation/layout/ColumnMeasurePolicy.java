package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0080\u0008\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0008\u001a\u00020\u0004HÂ\u0003J\t\u0010\t\u001a\u00020\u0006HÂ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J=\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00132\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J2\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0002J\t\u0010\"\u001a\u00020\u000eHÖ\u0001Jg\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0008\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0016¢\u0006\u0002\u00100J(\u00101\u001a\u0002022\u0006\u0010+\u001a\u00020\u000e2\u0006\u00103\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020(H\u0016J\t\u00104\u001a\u000205HÖ\u0001J\u000c\u00106\u001a\u00020\u000e*\u00020\u001bH\u0016J\u000c\u00107\u001a\u00020\u000e*\u00020\u001bH\u0016J\"\u00108\u001a\u00020\u000e*\u0002092\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020<0;2\u0006\u0010=\u001a\u00020\u000eH\u0016J\"\u0010>\u001a\u00020\u000e*\u0002092\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020<0;2\u0006\u0010?\u001a\u00020\u000eH\u0016J,\u0010@\u001a\u00020$*\u00020(2\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020A0;2\u0006\u0010B\u001a\u00020\u000cH\u0016ø\u0001\u0001¢\u0006\u0004\u0008C\u0010DJ\"\u0010E\u001a\u00020\u000e*\u0002092\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020<0;2\u0006\u0010=\u001a\u00020\u000eH\u0016J\"\u0010F\u001a\u00020\u000e*\u0002092\u000c\u0010:\u001a\u0008\u0012\u0004\u0012\u00020<0;2\u0006\u0010?\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006G", d2 = {"Landroidx/compose/foundation/layout/ColumnMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;)V", "component1", "component2", "copy", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "equals", "other", "", "getCrossAxisPosition", "placeable", "Landroidx/compose/ui/layout/Placeable;", "parentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "crossAxisLayoutSize", "beforeCrossAxisAlignmentLine", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "hashCode", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "mainAxisPositions", "", "mainAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "populateMainAxisPositions", "", "childrenMainAxisSize", "toString", "", "crossAxisSize", "mainAxisSize", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColumnMeasurePolicy implements MeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy {

    public static final int $stable;
    private final Alignment.Horizontal horizontalAlignment;
    private final androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement;
    static {
    }

    public ColumnMeasurePolicy(androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment) {
        super();
        this.verticalArrangement = verticalArrangement;
        this.horizontalAlignment = horizontalAlignment;
    }

    public static final int access$getCrossAxisPosition(androidx.compose.foundation.layout.ColumnMeasurePolicy $this, Placeable placeable, androidx.compose.foundation.layout.RowColumnParentData parentData, int crossAxisLayoutSize, int beforeCrossAxisAlignmentLine, LayoutDirection layoutDirection) {
        return $this.getCrossAxisPosition(placeable, parentData, crossAxisLayoutSize, beforeCrossAxisAlignmentLine, layoutDirection);
    }

    private final androidx.compose.foundation.layout.Arrangement.Vertical component1() {
        return this.verticalArrangement;
    }

    private final Alignment.Horizontal component2() {
        return this.horizontalAlignment;
    }

    public static androidx.compose.foundation.layout.ColumnMeasurePolicy copy$default(androidx.compose.foundation.layout.ColumnMeasurePolicy columnMeasurePolicy, androidx.compose.foundation.layout.Arrangement.Vertical arrangement$Vertical2, Alignment.Horizontal alignment$Horizontal3, int i4, Object object5) {
        androidx.compose.foundation.layout.Arrangement.Vertical obj1;
        Alignment.Horizontal obj2;
        if (i4 & 1 != 0) {
            obj1 = columnMeasurePolicy.verticalArrangement;
        }
        if (i4 &= 2 != 0) {
            obj2 = columnMeasurePolicy.horizontalAlignment;
        }
        return columnMeasurePolicy.copy(obj1, obj2);
    }

    private final int getCrossAxisPosition(Placeable placeable, androidx.compose.foundation.layout.RowColumnParentData parentData, int crossAxisLayoutSize, int beforeCrossAxisAlignmentLine, LayoutDirection layoutDirection) {
        androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment;
        int align$foundation_layout_release;
        int i2;
        int i;
        if (parentData != null) {
            crossAxisAlignment = parentData.getCrossAxisAlignment();
        } else {
            crossAxisAlignment = 0;
        }
        if (crossAxisAlignment != null) {
            align$foundation_layout_release = crossAxisAlignment.align$foundation_layout_release(crossAxisLayoutSize - width, layoutDirection, placeable, beforeCrossAxisAlignmentLine);
        } else {
            align$foundation_layout_release = this.horizontalAlignment.align(0, crossAxisLayoutSize - width2, layoutDirection);
        }
        return align$foundation_layout_release;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final androidx.compose.foundation.layout.ColumnMeasurePolicy copy(androidx.compose.foundation.layout.Arrangement.Vertical arrangement$Vertical, Alignment.Horizontal alignment$Horizontal2) {
        ColumnMeasurePolicy columnMeasurePolicy = new ColumnMeasurePolicy(vertical, horizontal2);
        return columnMeasurePolicy;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public long createConstraints-xF2OJ5Q(int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, boolean isPrioritizing) {
        return ColumnKt.createColumnConstraints(isPrioritizing, mainAxisMin, crossAxisMin, mainAxisMax, crossAxisMax);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int crossAxisSize(Placeable $this$crossAxisSize) {
        return $this$crossAxisSize.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ColumnMeasurePolicy) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.verticalArrangement, obj.verticalArrangement)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.horizontalAlignment, obj.horizontalAlignment)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int mainAxisSize(Placeable $this$mainAxisSize) {
        return $this$mainAxisSize.getHeight();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxHeight(measurables, width, $this$maxIntrinsicHeight.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxWidth(measurables, height, $this$maxIntrinsicWidth.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()));
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        final Object obj = this;
        final MeasureScope measureScope = $this$measure_u2d3p2s80s;
        return RowColumnMeasurePolicyKt.measure$default((RowColumnMeasurePolicy)obj, Constraints.getMinHeight-impl(constraints), Constraints.getMinWidth-impl(constraints), Constraints.getMaxHeight-impl(constraints), Constraints.getMaxWidth-impl(constraints), measureScope.roundToPx-0680j_4(obj.verticalArrangement.getSpacing-D9Ej5fM()), measureScope, measurables, new Placeable[measurables.size()], 0, measurables.size(), 0, 0, 3072, 0);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinHeight(measurables, width, $this$minIntrinsicHeight.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinWidth(measurables, height, $this$minIntrinsicWidth.roundToPx-0680j_4(this.verticalArrangement.getSpacing-D9Ej5fM()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public MeasureResult placeHelper(Placeable[] placeables, MeasureScope measureScope, int beforeCrossAxisAlignmentLine, int[] mainAxisPositions, int mainAxisLayoutSize, int crossAxisLayoutSize, int[] crossAxisOffset, int currentLineIndex, int startIndex, int endIndex) {
        final int i6 = 0;
        ColumnMeasurePolicy.placeHelper.1.1 anon2 = new ColumnMeasurePolicy.placeHelper.1.1(placeables, this, crossAxisLayoutSize, beforeCrossAxisAlignmentLine, measureScope, mainAxisPositions);
        return MeasureScope.layout$default(measureScope, crossAxisLayoutSize, mainAxisLayoutSize, 0, (Function1)anon2, 4, 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public void populateMainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        final int i = 0;
        this.verticalArrangement.arrange((Density)measureScope, mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ColumnMeasurePolicy(verticalArrangement=").append(this.verticalArrangement).append(", horizontalAlignment=").append(this.horizontalAlignment).append(')').toString();
    }
}
