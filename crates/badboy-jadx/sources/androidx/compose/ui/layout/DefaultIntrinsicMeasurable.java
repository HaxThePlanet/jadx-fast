package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"Landroidx/compose/ui/layout/DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/layout/IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMinMax;Landroidx/compose/ui/layout/IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultIntrinsicMeasurable implements androidx.compose.ui.layout.Measurable {

    public static final int $stable = 8;
    private final androidx.compose.ui.layout.IntrinsicMeasurable measurable;
    private final androidx.compose.ui.layout.IntrinsicMinMax minMax;
    private final androidx.compose.ui.layout.IntrinsicWidthHeight widthHeight;
    static {
        final int i = 8;
    }

    public DefaultIntrinsicMeasurable(androidx.compose.ui.layout.IntrinsicMeasurable measurable, androidx.compose.ui.layout.IntrinsicMinMax minMax, androidx.compose.ui.layout.IntrinsicWidthHeight widthHeight) {
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
    public Object getParentData() {
        return this.measurable.getParentData();
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
        if (this.widthHeight == IntrinsicWidthHeight.Width) {
            if (this.minMax == IntrinsicMinMax.Max) {
                minIntrinsicWidth = this.measurable.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraints));
            } else {
                minIntrinsicWidth = this.measurable.minIntrinsicWidth(Constraints.getMaxHeight-impl(constraints));
            }
            if (Constraints.getHasBoundedHeight-impl(constraints)) {
                maxHeight-impl = Constraints.getMaxHeight-impl(constraints);
            }
            FixedSizeIntrinsicsPlaceable fixedSizeIntrinsicsPlaceable2 = new FixedSizeIntrinsicsPlaceable(minIntrinsicWidth, maxHeight-impl);
            return (Placeable)fixedSizeIntrinsicsPlaceable2;
        }
        if (this.minMax == IntrinsicMinMax.Max) {
            minIntrinsicHeight = this.measurable.maxIntrinsicHeight(Constraints.getMaxWidth-impl(constraints));
        } else {
            minIntrinsicHeight = this.measurable.minIntrinsicHeight(Constraints.getMaxWidth-impl(constraints));
        }
        if (Constraints.getHasBoundedWidth-impl(constraints)) {
            maxHeight-impl = Constraints.getMaxWidth-impl(constraints);
        }
        FixedSizeIntrinsicsPlaceable fixedSizeIntrinsicsPlaceable = new FixedSizeIntrinsicsPlaceable(maxHeight-impl, minIntrinsicHeight);
        return (Placeable)fixedSizeIntrinsicsPlaceable;
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
