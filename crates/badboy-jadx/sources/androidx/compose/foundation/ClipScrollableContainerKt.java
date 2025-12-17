package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0008\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0004\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"HorizontalScrollableClipModifier", "Landroidx/compose/ui/Modifier;", "MaxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "getMaxSupportedElevation", "()F", "F", "VerticalScrollableClipModifier", "clipScrollableContainer", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ClipScrollableContainerKt {

    private static final Modifier HorizontalScrollableClipModifier;
    private static final float MaxSupportedElevation;
    private static final Modifier VerticalScrollableClipModifier;
    static {
        int i2 = 0;
        ClipScrollableContainerKt.MaxSupportedElevation = Dp.constructor-impl((float)i);
        ClipScrollableContainerKt.HorizontalScrollableClipModifier.1 anon = new ClipScrollableContainerKt.HorizontalScrollableClipModifier.1();
        ClipScrollableContainerKt.HorizontalScrollableClipModifier = ClipKt.clip((Modifier)Modifier.Companion, (Shape)anon);
        ClipScrollableContainerKt.VerticalScrollableClipModifier.1 anon2 = new ClipScrollableContainerKt.VerticalScrollableClipModifier.1();
        ClipScrollableContainerKt.VerticalScrollableClipModifier = ClipKt.clip((Modifier)Modifier.Companion, (Shape)anon2);
    }

    public static final Modifier clipScrollableContainer(Modifier $this$clipScrollableContainer, Orientation orientation) {
        Modifier verticalScrollableClipModifier;
        verticalScrollableClipModifier = orientation == Orientation.Vertical ? ClipScrollableContainerKt.VerticalScrollableClipModifier : ClipScrollableContainerKt.HorizontalScrollableClipModifier;
        return $this$clipScrollableContainer.then(verticalScrollableClipModifier);
    }

    public static final float getMaxSupportedElevation() {
        return ClipScrollableContainerKt.MaxSupportedElevation;
    }
}
