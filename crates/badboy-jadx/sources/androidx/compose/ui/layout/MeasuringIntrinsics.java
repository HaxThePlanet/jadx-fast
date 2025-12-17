package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008Â\u0002\u0018\u00002\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J&\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u0014", d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics;", "", "()V", "maxHeight", "", "modifier", "Landroidx/compose/ui/layout/LayoutModifier;", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "w", "maxWidth", "h", "minHeight", "minWidth", "DefaultIntrinsicMeasurable", "EmptyPlaceable", "IntrinsicMinMax", "IntrinsicWidthHeight", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MeasuringIntrinsics {

    public static final androidx.compose.ui.layout.MeasuringIntrinsics INSTANCE;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getMinMax", "()Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "getWidthHeight", "()Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DefaultIntrinsicMeasurable implements androidx.compose.ui.layout.Measurable {

        private final androidx.compose.ui.layout.IntrinsicMeasurable measurable;
        private final androidx.compose.ui.layout.MeasuringIntrinsics.IntrinsicMinMax minMax;
        private final androidx.compose.ui.layout.MeasuringIntrinsics.IntrinsicWidthHeight widthHeight;
        public DefaultIntrinsicMeasurable(androidx.compose.ui.layout.IntrinsicMeasurable measurable, androidx.compose.ui.layout.MeasuringIntrinsics.IntrinsicMinMax minMax, androidx.compose.ui.layout.MeasuringIntrinsics.IntrinsicWidthHeight widthHeight) {
            super();
            this.measurable = measurable;
            this.minMax = minMax;
            this.widthHeight = widthHeight;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final androidx.compose.ui.layout.IntrinsicMeasurable getMeasurable() {
            return this.measurable;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final androidx.compose.ui.layout.MeasuringIntrinsics.IntrinsicMinMax getMinMax() {
            return this.minMax;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public Object getParentData() {
            return this.measurable.getParentData();
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final androidx.compose.ui.layout.MeasuringIntrinsics.IntrinsicWidthHeight getWidthHeight() {
            return this.widthHeight;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public int maxIntrinsicHeight(int width) {
            return this.measurable.maxIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public int maxIntrinsicWidth(int height) {
            return this.measurable.maxIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public androidx.compose.ui.layout.Placeable measure-BRTryo0(long constraints) {
            int minIntrinsicHeight;
            int minIntrinsicWidth;
            int maxWidth-impl;
            int maxHeight-impl2;
            int maxHeight-impl;
            maxHeight-impl = 32767;
            if (this.widthHeight == MeasuringIntrinsics.IntrinsicWidthHeight.Width) {
                if (this.minMax == MeasuringIntrinsics.IntrinsicMinMax.Max) {
                    minIntrinsicWidth = this.measurable.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraints));
                } else {
                    minIntrinsicWidth = this.measurable.minIntrinsicWidth(Constraints.getMaxHeight-impl(constraints));
                }
                if (Constraints.getHasBoundedHeight-impl(constraints)) {
                    maxHeight-impl = Constraints.getMaxHeight-impl(constraints);
                }
                MeasuringIntrinsics.EmptyPlaceable emptyPlaceable2 = new MeasuringIntrinsics.EmptyPlaceable(minIntrinsicWidth, maxHeight-impl);
                return (Placeable)emptyPlaceable2;
            }
            if (this.minMax == MeasuringIntrinsics.IntrinsicMinMax.Max) {
                minIntrinsicHeight = this.measurable.maxIntrinsicHeight(Constraints.getMaxWidth-impl(constraints));
            } else {
                minIntrinsicHeight = this.measurable.minIntrinsicHeight(Constraints.getMaxWidth-impl(constraints));
            }
            if (Constraints.getHasBoundedWidth-impl(constraints)) {
                maxHeight-impl = Constraints.getMaxWidth-impl(constraints);
            }
            MeasuringIntrinsics.EmptyPlaceable emptyPlaceable = new MeasuringIntrinsics.EmptyPlaceable(maxHeight-impl, minIntrinsicHeight);
            return (Placeable)emptyPlaceable;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public int minIntrinsicHeight(int width) {
            return this.measurable.minIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public int minIntrinsicWidth(int height) {
            return this.measurable.minIntrinsicWidth(height);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0096\u0002J=\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0019\u0010\u000f\u001a\u0015\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010¢\u0006\u0002\u0008\u0012H\u0014ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$EmptyPlaceable;", "Landroidx/compose/ui/layout/Placeable;", "width", "", "height", "(II)V", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeAt", "", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class EmptyPlaceable extends androidx.compose.ui.layout.Placeable {
        public EmptyPlaceable(int width, int height) {
            super();
            setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(width, height));
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int get(androidx.compose.ui.layout.AlignmentLine alignmentLine) {
            return Integer.MIN_VALUE;
        }

        protected void placeAt-f8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicMinMax;", "", "(Ljava/lang/String;I)V", "Min", "Max", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static enum IntrinsicMinMax {

        Min,
        Max;
        private static final androidx.compose.ui.layout.MeasuringIntrinsics.IntrinsicMinMax[] $values() {
            return /* result */;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0082\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/ui/layout/MeasuringIntrinsics$IntrinsicWidthHeight;", "", "(Ljava/lang/String;I)V", "Width", "Height", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static enum IntrinsicWidthHeight {

        Width,
        Height;
        private static final androidx.compose.ui.layout.MeasuringIntrinsics.IntrinsicWidthHeight[] $values() {
            return /* result */;
        }
    }
    static {
        MeasuringIntrinsics measuringIntrinsics = new MeasuringIntrinsics();
        MeasuringIntrinsics.INSTANCE = measuringIntrinsics;
    }

    public final int maxHeight(androidx.compose.ui.layout.LayoutModifier modifier, androidx.compose.ui.layout.IntrinsicMeasureScope intrinsicMeasureScope, androidx.compose.ui.layout.IntrinsicMeasurable intrinsicMeasurable, int w) {
        MeasuringIntrinsics.DefaultIntrinsicMeasurable defaultIntrinsicMeasurable = new MeasuringIntrinsics.DefaultIntrinsicMeasurable(intrinsicMeasurable, MeasuringIntrinsics.IntrinsicMinMax.Max, MeasuringIntrinsics.IntrinsicWidthHeight.Height);
        final int i5 = 0;
        int i2 = 0;
        IntrinsicsMeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection());
        return modifier.measure-3p2s80s((MeasureScope)intrinsicsMeasureScope, (Measurable)defaultIntrinsicMeasurable, ConstraintsKt.Constraints$default(0, w, 0, i5, 13, 0)).getHeight();
    }

    public final int maxWidth(androidx.compose.ui.layout.LayoutModifier modifier, androidx.compose.ui.layout.IntrinsicMeasureScope intrinsicMeasureScope, androidx.compose.ui.layout.IntrinsicMeasurable intrinsicMeasurable, int h) {
        MeasuringIntrinsics.DefaultIntrinsicMeasurable defaultIntrinsicMeasurable = new MeasuringIntrinsics.DefaultIntrinsicMeasurable(intrinsicMeasurable, MeasuringIntrinsics.IntrinsicMinMax.Max, MeasuringIntrinsics.IntrinsicWidthHeight.Width);
        int i2 = 0;
        int i4 = 0;
        IntrinsicsMeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection());
        return modifier.measure-3p2s80s((MeasureScope)intrinsicsMeasureScope, (Measurable)defaultIntrinsicMeasurable, ConstraintsKt.Constraints$default(0, i2, 0, h, 7, 0)).getWidth();
    }

    public final int minHeight(androidx.compose.ui.layout.LayoutModifier modifier, androidx.compose.ui.layout.IntrinsicMeasureScope intrinsicMeasureScope, androidx.compose.ui.layout.IntrinsicMeasurable intrinsicMeasurable, int w) {
        MeasuringIntrinsics.DefaultIntrinsicMeasurable defaultIntrinsicMeasurable = new MeasuringIntrinsics.DefaultIntrinsicMeasurable(intrinsicMeasurable, MeasuringIntrinsics.IntrinsicMinMax.Min, MeasuringIntrinsics.IntrinsicWidthHeight.Height);
        final int i5 = 0;
        int i2 = 0;
        IntrinsicsMeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection());
        return modifier.measure-3p2s80s((MeasureScope)intrinsicsMeasureScope, (Measurable)defaultIntrinsicMeasurable, ConstraintsKt.Constraints$default(0, w, 0, i5, 13, 0)).getHeight();
    }

    public final int minWidth(androidx.compose.ui.layout.LayoutModifier modifier, androidx.compose.ui.layout.IntrinsicMeasureScope intrinsicMeasureScope, androidx.compose.ui.layout.IntrinsicMeasurable intrinsicMeasurable, int h) {
        MeasuringIntrinsics.DefaultIntrinsicMeasurable defaultIntrinsicMeasurable = new MeasuringIntrinsics.DefaultIntrinsicMeasurable(intrinsicMeasurable, MeasuringIntrinsics.IntrinsicMinMax.Min, MeasuringIntrinsics.IntrinsicWidthHeight.Width);
        int i2 = 0;
        int i4 = 0;
        IntrinsicsMeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection());
        return modifier.measure-3p2s80s((MeasureScope)intrinsicsMeasureScope, (Measurable)defaultIntrinsicMeasurable, ConstraintsKt.Constraints$default(0, i2, 0, h, 7, 0)).getWidth();
    }
}
