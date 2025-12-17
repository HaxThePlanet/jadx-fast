package androidx.compose.foundation.relocation;

import android.graphics.Rect;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000c\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006", d2 = {"defaultBringIntoViewParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "Landroidx/compose/ui/node/DelegatableNode;", "toRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BringIntoViewResponder_androidKt {
    public static final Rect access$toRect(Rect $receiver) {
        return BringIntoViewResponder_androidKt.toRect($receiver);
    }

    public static final androidx.compose.foundation.relocation.BringIntoViewParent defaultBringIntoViewParent(DelegatableNode $this$defaultBringIntoViewParent) {
        BringIntoViewResponder_androidKt.defaultBringIntoViewParent.1 anon = new BringIntoViewResponder_androidKt.defaultBringIntoViewParent.1($this$defaultBringIntoViewParent);
        return (BringIntoViewParent)anon;
    }

    private static final Rect toRect(Rect $this$toRect) {
        Rect rect = new Rect((int)left, (int)top, (int)right, (int)bottom);
        return rect;
    }
}
