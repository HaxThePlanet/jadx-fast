package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006", d2 = {"aspectRatio", "Landroidx/compose/ui/Modifier;", "ratio", "", "matchHeightConstraintsFirst", "", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AspectRatioKt {
    public static final Modifier aspectRatio(Modifier $this$aspectRatio, float ratio, boolean matchHeightConstraintsFirst) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new AspectRatioKt.aspectRatio$$inlined.debugInspectorInfo.1(ratio, matchHeightConstraintsFirst);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        AspectRatioElement aspectRatioElement = new AspectRatioElement(ratio, matchHeightConstraintsFirst, noInspectorInfo);
        return $this$aspectRatio.then((Modifier)aspectRatioElement);
    }

    public static Modifier aspectRatio$default(Modifier modifier, float f2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return AspectRatioKt.aspectRatio(modifier, f2, obj2);
    }
}
