package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0007", d2 = {"height", "Landroidx/compose/ui/Modifier;", "intrinsicSize", "Landroidx/compose/foundation/layout/IntrinsicSize;", "requiredHeight", "requiredWidth", "width", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntrinsicKt {
    public static final Modifier height(Modifier $this$height, androidx.compose.foundation.layout.IntrinsicSize intrinsicSize) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new IntrinsicKt.height$$inlined.debugInspectorInfo.1(intrinsicSize);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        IntrinsicHeightElement intrinsicHeightElement = new IntrinsicHeightElement(intrinsicSize, 1, noInspectorInfo);
        return $this$height.then((Modifier)intrinsicHeightElement);
    }

    public static final Modifier requiredHeight(Modifier $this$requiredHeight, androidx.compose.foundation.layout.IntrinsicSize intrinsicSize) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new IntrinsicKt.requiredHeight$$inlined.debugInspectorInfo.1(intrinsicSize);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        IntrinsicHeightElement intrinsicHeightElement = new IntrinsicHeightElement(intrinsicSize, 0, noInspectorInfo);
        return $this$requiredHeight.then((Modifier)intrinsicHeightElement);
    }

    public static final Modifier requiredWidth(Modifier $this$requiredWidth, androidx.compose.foundation.layout.IntrinsicSize intrinsicSize) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new IntrinsicKt.requiredWidth$$inlined.debugInspectorInfo.1(intrinsicSize);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        IntrinsicWidthElement intrinsicWidthElement = new IntrinsicWidthElement(intrinsicSize, 0, noInspectorInfo);
        return $this$requiredWidth.then((Modifier)intrinsicWidthElement);
    }

    public static final Modifier width(Modifier $this$width, androidx.compose.foundation.layout.IntrinsicSize intrinsicSize) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new IntrinsicKt.width$$inlined.debugInspectorInfo.1(intrinsicSize);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        IntrinsicWidthElement intrinsicWidthElement = new IntrinsicWidthElement(intrinsicSize, 1, noInspectorInfo);
        return $this$width.then((Modifier)intrinsicWidthElement);
    }
}
