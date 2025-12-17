package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Vertical;
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
@Metadata(d1 = "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0080\u0008\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0008\u001a\u00020\u0004HÂ\u0003J\t\u0010\t\u001a\u00020\u0006HÂ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J=\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00132\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J*\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\t\u0010 \u001a\u00020\u000eHÖ\u0001Jg\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0008\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010.J(\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020\u000e2\u0006\u00101\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&H\u0016J\t\u00102\u001a\u000203HÖ\u0001J\u000c\u00104\u001a\u00020\u000e*\u00020\u001bH\u0016J\u000c\u00105\u001a\u00020\u000e*\u00020\u001bH\u0016J\"\u00106\u001a\u00020\u000e*\u0002072\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020:092\u0006\u0010;\u001a\u00020\u000eH\u0016J\"\u0010<\u001a\u00020\u000e*\u0002072\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020:092\u0006\u0010=\u001a\u00020\u000eH\u0016J,\u0010>\u001a\u00020\"*\u00020&2\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020?092\u0006\u0010@\u001a\u00020\u000cH\u0016ø\u0001\u0001¢\u0006\u0004\u0008A\u0010BJ\"\u0010C\u001a\u00020\u000e*\u0002072\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020:092\u0006\u0010;\u001a\u00020\u000eH\u0016J\"\u0010D\u001a\u00020\u000e*\u0002072\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020:092\u0006\u0010=\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006E", d2 = {"Landroidx/compose/foundation/layout/RowMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;)V", "component1", "component2", "copy", "createConstraints", "Landroidx/compose/ui/unit/Constraints;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "isPrioritizing", "", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "equals", "other", "", "getCrossAxisPosition", "placeable", "Landroidx/compose/ui/layout/Placeable;", "parentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "crossAxisLayoutSize", "beforeCrossAxisAlignmentLine", "hashCode", "placeHelper", "Landroidx/compose/ui/layout/MeasureResult;", "placeables", "", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "mainAxisPositions", "", "mainAxisLayoutSize", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "populateMainAxisPositions", "", "childrenMainAxisSize", "toString", "", "crossAxisSize", "mainAxisSize", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RowMeasurePolicy implements MeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy {

    public static final int $stable;
    private final androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement;
    private final Alignment.Vertical verticalAlignment;
    static {
    }

    public RowMeasurePolicy(androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment) {
        super();
        this.horizontalArrangement = horizontalArrangement;
        this.verticalAlignment = verticalAlignment;
    }

    public static final int access$getCrossAxisPosition(androidx.compose.foundation.layout.RowMeasurePolicy $this, Placeable placeable, androidx.compose.foundation.layout.RowColumnParentData parentData, int crossAxisLayoutSize, int beforeCrossAxisAlignmentLine) {
        return $this.getCrossAxisPosition(placeable, parentData, crossAxisLayoutSize, beforeCrossAxisAlignmentLine);
    }

    private final androidx.compose.foundation.layout.Arrangement.Horizontal component1() {
        return this.horizontalArrangement;
    }

    private final Alignment.Vertical component2() {
        return this.verticalAlignment;
    }

    public static androidx.compose.foundation.layout.RowMeasurePolicy copy$default(androidx.compose.foundation.layout.RowMeasurePolicy rowMeasurePolicy, androidx.compose.foundation.layout.Arrangement.Horizontal arrangement$Horizontal2, Alignment.Vertical alignment$Vertical3, int i4, Object object5) {
        androidx.compose.foundation.layout.Arrangement.Horizontal obj1;
        Alignment.Vertical obj2;
        if (i4 & 1 != 0) {
            obj1 = rowMeasurePolicy.horizontalArrangement;
        }
        if (i4 &= 2 != 0) {
            obj2 = rowMeasurePolicy.verticalAlignment;
        }
        return rowMeasurePolicy.copy(obj1, obj2);
    }

    private final int getCrossAxisPosition(Placeable placeable, androidx.compose.foundation.layout.RowColumnParentData parentData, int crossAxisLayoutSize, int beforeCrossAxisAlignmentLine) {
        androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment;
        int align$foundation_layout_release;
        int ltr;
        int i;
        if (parentData != null) {
            crossAxisAlignment = parentData.getCrossAxisAlignment();
        } else {
            crossAxisAlignment = 0;
        }
        if (crossAxisAlignment != null) {
            align$foundation_layout_release = crossAxisAlignment.align$foundation_layout_release(crossAxisLayoutSize - height, LayoutDirection.Ltr, placeable, beforeCrossAxisAlignmentLine);
        } else {
            align$foundation_layout_release = this.verticalAlignment.align(0, crossAxisLayoutSize - height2);
        }
        return align$foundation_layout_release;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final androidx.compose.foundation.layout.RowMeasurePolicy copy(androidx.compose.foundation.layout.Arrangement.Horizontal arrangement$Horizontal, Alignment.Vertical alignment$Vertical2) {
        RowMeasurePolicy rowMeasurePolicy = new RowMeasurePolicy(horizontal, vertical2);
        return rowMeasurePolicy;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public long createConstraints-xF2OJ5Q(int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, boolean isPrioritizing) {
        return RowKt.createRowConstraints(isPrioritizing, mainAxisMin, crossAxisMin, mainAxisMax, crossAxisMax);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int crossAxisSize(Placeable $this$crossAxisSize) {
        return $this$crossAxisSize.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof RowMeasurePolicy) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.horizontalArrangement, obj.horizontalArrangement)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.verticalAlignment, obj.verticalAlignment)) {
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
        return $this$mainAxisSize.getWidth();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxHeight(measurables, width, $this$maxIntrinsicHeight.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMaxWidth(measurables, height, $this$maxIntrinsicWidth.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()));
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        final Object obj = this;
        final MeasureScope measureScope = $this$measure_u2d3p2s80s;
        return RowColumnMeasurePolicyKt.measure$default((RowColumnMeasurePolicy)obj, Constraints.getMinWidth-impl(constraints), Constraints.getMinHeight-impl(constraints), Constraints.getMaxWidth-impl(constraints), Constraints.getMaxHeight-impl(constraints), measureScope.roundToPx-0680j_4(obj.horizontalArrangement.getSpacing-D9Ej5fM()), measureScope, measurables, new Placeable[measurables.size()], 0, measurables.size(), 0, 0, 3072, 0);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinHeight(measurables, width, $this$minIntrinsicHeight.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()));
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return IntrinsicMeasureBlocks.INSTANCE.HorizontalMinWidth(measurables, height, $this$minIntrinsicWidth.roundToPx-0680j_4(this.horizontalArrangement.getSpacing-D9Ej5fM()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public MeasureResult placeHelper(Placeable[] placeables, MeasureScope measureScope, int beforeCrossAxisAlignmentLine, int[] mainAxisPositions, int mainAxisLayoutSize, int crossAxisLayoutSize, int[] crossAxisOffset, int currentLineIndex, int startIndex, int endIndex) {
        final int i8 = 0;
        RowMeasurePolicy.placeHelper.1.1 anon = new RowMeasurePolicy.placeHelper.1.1(placeables, this, crossAxisLayoutSize, beforeCrossAxisAlignmentLine, mainAxisPositions);
        return MeasureScope.layout$default(measureScope, mainAxisLayoutSize, crossAxisLayoutSize, 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public void populateMainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        final int i2 = 0;
        this.horizontalArrangement.arrange((Density)measureScope, mainAxisLayoutSize, childrenMainAxisSize, measureScope.getLayoutDirection(), mainAxisPositions);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("RowMeasurePolicy(horizontalArrangement=").append(this.horizontalArrangement).append(", verticalAlignment=").append(this.verticalAlignment).append(')').toString();
    }
}
