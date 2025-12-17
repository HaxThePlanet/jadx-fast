package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Element;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\u0008\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J&\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0014À\u0006\u0003", d2 = {"Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/Modifier$Element;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LayoutModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(androidx.compose.ui.layout.LayoutModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return LayoutModifier.access$all$jd($this, predicate);
        }

        @Deprecated
        public static boolean any(androidx.compose.ui.layout.LayoutModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return LayoutModifier.access$any$jd($this, predicate);
        }

        @Deprecated
        public static <R> R foldIn(androidx.compose.ui.layout.LayoutModifier $this, R initial, Function2<? super R, ? super Modifier.Element, ? extends R> operation) {
            return LayoutModifier.access$foldIn$jd($this, initial, operation);
        }

        @Deprecated
        public static <R> R foldOut(androidx.compose.ui.layout.LayoutModifier $this, R initial, Function2<? super Modifier.Element, ? super R, ? extends R> operation) {
            return LayoutModifier.access$foldOut$jd($this, initial, operation);
        }

        @Deprecated
        public static int maxIntrinsicHeight(androidx.compose.ui.layout.LayoutModifier $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int width) {
            return LayoutModifier.access$maxIntrinsicHeight$jd($this, $receiver, measurable, width);
        }

        @Deprecated
        public static int maxIntrinsicWidth(androidx.compose.ui.layout.LayoutModifier $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int height) {
            return LayoutModifier.access$maxIntrinsicWidth$jd($this, $receiver, measurable, height);
        }

        @Deprecated
        public static int minIntrinsicHeight(androidx.compose.ui.layout.LayoutModifier $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int width) {
            return LayoutModifier.access$minIntrinsicHeight$jd($this, $receiver, measurable, width);
        }

        @Deprecated
        public static int minIntrinsicWidth(androidx.compose.ui.layout.LayoutModifier $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int height) {
            return LayoutModifier.access$minIntrinsicWidth$jd($this, $receiver, measurable, height);
        }

        @Deprecated
        public static Modifier then(androidx.compose.ui.layout.LayoutModifier $this, Modifier other) {
            return LayoutModifier.access$then$jd($this, other);
        }
    }
    public static boolean access$all$jd(androidx.compose.ui.layout.LayoutModifier $this, Function1 predicate) {
        return super.all(predicate);
    }

    public static boolean access$any$jd(androidx.compose.ui.layout.LayoutModifier $this, Function1 predicate) {
        return super.any(predicate);
    }

    public static Object access$foldIn$jd(androidx.compose.ui.layout.LayoutModifier $this, Object initial, Function2 operation) {
        return super.foldIn(initial, operation);
    }

    public static Object access$foldOut$jd(androidx.compose.ui.layout.LayoutModifier $this, Object initial, Function2 operation) {
        return super.foldOut(initial, operation);
    }

    public static int access$maxIntrinsicHeight$jd(androidx.compose.ui.layout.LayoutModifier $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int width) {
        return super.maxIntrinsicHeight($receiver, measurable, width);
    }

    public static int access$maxIntrinsicWidth$jd(androidx.compose.ui.layout.LayoutModifier $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int height) {
        return super.maxIntrinsicWidth($receiver, measurable, height);
    }

    public static int access$minIntrinsicHeight$jd(androidx.compose.ui.layout.LayoutModifier $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int width) {
        return super.minIntrinsicHeight($receiver, measurable, width);
    }

    public static int access$minIntrinsicWidth$jd(androidx.compose.ui.layout.LayoutModifier $this, androidx.compose.ui.layout.IntrinsicMeasureScope $receiver, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int height) {
        return super.minIntrinsicWidth($receiver, measurable, height);
    }

    public static Modifier access$then$jd(androidx.compose.ui.layout.LayoutModifier $this, Modifier other) {
        return super.then(other);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public int maxIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope $this$maxIntrinsicHeight, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int width) {
        return MeasuringIntrinsics.INSTANCE.maxHeight(this, $this$maxIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public int maxIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope $this$maxIntrinsicWidth, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int height) {
        return MeasuringIntrinsics.INSTANCE.maxWidth(this, $this$maxIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public abstract androidx.compose.ui.layout.MeasureResult measure-3p2s80s(androidx.compose.ui.layout.MeasureScope measureScope, androidx.compose.ui.layout.Measurable measurable2, long l3);

    @Override // androidx.compose.ui.Modifier$Element
    public int minIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope $this$minIntrinsicHeight, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int width) {
        return MeasuringIntrinsics.INSTANCE.minHeight(this, $this$minIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public int minIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope $this$minIntrinsicWidth, androidx.compose.ui.layout.IntrinsicMeasurable measurable, int height) {
        return MeasuringIntrinsics.INSTANCE.minWidth(this, $this$minIntrinsicWidth, measurable, height);
    }
}
