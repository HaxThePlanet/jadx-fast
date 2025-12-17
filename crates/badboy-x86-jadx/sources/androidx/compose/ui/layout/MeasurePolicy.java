package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008ç\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J%\u0010\u000b\u001a\u00020\u000c*\u00020\r2\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000J\"\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u0003H\u0016J\"\u0010\u0012\u001a\u00020\u0003*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0013À\u0006\u0003", d2 = {"Landroidx/compose/ui/layout/MeasurePolicy;", "", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MeasurePolicy {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static int maxIntrinsicHeight(androidx.compose.ui.layout.MeasurePolicy $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int width) {
            return MeasurePolicy.access$maxIntrinsicHeight$jd($this, $receiver, measurables, width);
        }

        @Deprecated
        public static int maxIntrinsicWidth(androidx.compose.ui.layout.MeasurePolicy $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int height) {
            return MeasurePolicy.access$maxIntrinsicWidth$jd($this, $receiver, measurables, height);
        }

        @Deprecated
        public static int minIntrinsicHeight(androidx.compose.ui.layout.MeasurePolicy $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int width) {
            return MeasurePolicy.access$minIntrinsicHeight$jd($this, $receiver, measurables, width);
        }

        @Deprecated
        public static int minIntrinsicWidth(androidx.compose.ui.layout.MeasurePolicy $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int height) {
            return MeasurePolicy.access$minIntrinsicWidth$jd($this, $receiver, measurables, height);
        }
    }
    public static int access$maxIntrinsicHeight$jd(androidx.compose.ui.layout.MeasurePolicy $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, List measurables, int width) {
        return super.maxIntrinsicHeight($receiver, measurables, width);
    }

    public static int access$maxIntrinsicWidth$jd(androidx.compose.ui.layout.MeasurePolicy $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, List measurables, int height) {
        return super.maxIntrinsicWidth($receiver, measurables, height);
    }

    public static int access$minIntrinsicHeight$jd(androidx.compose.ui.layout.MeasurePolicy $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, List measurables, int width) {
        return super.minIntrinsicHeight($receiver, measurables, width);
    }

    public static int access$minIntrinsicWidth$jd(androidx.compose.ui.layout.MeasurePolicy $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, List measurables, int height) {
        return super.minIntrinsicWidth($receiver, measurables, height);
    }

    public int maxIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int width) {
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i2;
        ArrayList list;
        Object obj3;
        int i;
        androidx.compose.ui.layout.DefaultIntrinsicMeasurable defaultIntrinsicMeasurable;
        androidx.compose.ui.layout.IntrinsicMinMax max;
        androidx.compose.ui.layout.IntrinsicWidthHeight height;
        Object obj4 = measurables;
        int i3 = 0;
        ArrayList arrayList = new ArrayList(obj4.size());
        Object obj5 = obj4;
        int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj5.size()) {
            i2 = 0;
            i = 0;
            defaultIntrinsicMeasurable = new DefaultIntrinsicMeasurable((IntrinsicMeasurable)obj5.get(index$iv$iv), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height);
            (Collection)arrayList.add(defaultIntrinsicMeasurable);
            index$iv$iv++;
        }
        int i8 = 0;
        IntrinsicsMeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope($this$maxIntrinsicHeight, $this$maxIntrinsicHeight.getLayoutDirection());
        return this.measure-3p2s80s((MeasureScope)intrinsicsMeasureScope, (List)arrayList, ConstraintsKt.Constraints$default(0, width, 0, i8, 13, 0)).getHeight();
    }

    public int maxIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int height) {
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i;
        ArrayList list;
        Object obj3;
        int i2;
        androidx.compose.ui.layout.DefaultIntrinsicMeasurable defaultIntrinsicMeasurable;
        androidx.compose.ui.layout.IntrinsicMinMax max;
        androidx.compose.ui.layout.IntrinsicWidthHeight width;
        Object obj4 = measurables;
        int i3 = 0;
        ArrayList arrayList = new ArrayList(obj4.size());
        Object obj5 = obj4;
        int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj5.size()) {
            i = 0;
            i2 = 0;
            defaultIntrinsicMeasurable = new DefaultIntrinsicMeasurable((IntrinsicMeasurable)obj5.get(index$iv$iv), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width);
            (Collection)arrayList.add(defaultIntrinsicMeasurable);
            index$iv$iv++;
        }
        int i5 = 0;
        IntrinsicsMeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope($this$maxIntrinsicWidth, $this$maxIntrinsicWidth.getLayoutDirection());
        return this.measure-3p2s80s((MeasureScope)intrinsicsMeasureScope, (List)arrayList, ConstraintsKt.Constraints$default(0, i5, 0, height, 7, 0)).getWidth();
    }

    public abstract androidx.compose.ui.layout.MeasureResult measure-3p2s80s(androidx.compose.ui.layout.MeasureScope measureScope, List<? extends androidx.compose.ui.layout.Measurable> list2, long l3);

    public int minIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int width) {
        int index$iv$iv;
        Object obj3;
        Object obj;
        int i2;
        ArrayList list;
        Object obj2;
        int i;
        androidx.compose.ui.layout.DefaultIntrinsicMeasurable defaultIntrinsicMeasurable;
        androidx.compose.ui.layout.IntrinsicMinMax min;
        androidx.compose.ui.layout.IntrinsicWidthHeight height;
        Object obj4 = measurables;
        int i3 = 0;
        ArrayList arrayList = new ArrayList(obj4.size());
        Object obj5 = obj4;
        int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj5.size()) {
            i2 = 0;
            i = 0;
            defaultIntrinsicMeasurable = new DefaultIntrinsicMeasurable((IntrinsicMeasurable)obj5.get(index$iv$iv), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height);
            (Collection)arrayList.add(defaultIntrinsicMeasurable);
            index$iv$iv++;
        }
        int i8 = 0;
        IntrinsicsMeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope($this$minIntrinsicHeight, $this$minIntrinsicHeight.getLayoutDirection());
        return this.measure-3p2s80s((MeasureScope)intrinsicsMeasureScope, (List)arrayList, ConstraintsKt.Constraints$default(0, width, 0, i8, 13, 0)).getHeight();
    }

    public int minIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int height) {
        int index$iv$iv;
        Object obj3;
        Object obj;
        int i2;
        ArrayList list;
        Object obj2;
        int i;
        androidx.compose.ui.layout.DefaultIntrinsicMeasurable defaultIntrinsicMeasurable;
        androidx.compose.ui.layout.IntrinsicMinMax min;
        androidx.compose.ui.layout.IntrinsicWidthHeight width;
        Object obj4 = measurables;
        int i3 = 0;
        ArrayList arrayList = new ArrayList(obj4.size());
        Object obj5 = obj4;
        int i7 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj5.size()) {
            i2 = 0;
            i = 0;
            defaultIntrinsicMeasurable = new DefaultIntrinsicMeasurable((IntrinsicMeasurable)obj5.get(index$iv$iv), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width);
            (Collection)arrayList.add(defaultIntrinsicMeasurable);
            index$iv$iv++;
        }
        int i5 = 0;
        IntrinsicsMeasureScope intrinsicsMeasureScope = new IntrinsicsMeasureScope($this$minIntrinsicWidth, $this$minIntrinsicWidth.getLayoutDirection());
        return this.measure-3p2s80s((MeasureScope)intrinsicsMeasureScope, (List)arrayList, ConstraintsKt.Constraints$default(0, i5, 0, height, 7, 0)).getWidth();
    }
}
