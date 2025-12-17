package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = {"androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewRequesterKt", "androidx/compose/foundation/relocation/BringIntoViewRequesterKt__BringIntoViewResponderKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class BringIntoViewRequesterKt {
    public static final androidx.compose.foundation.relocation.BringIntoViewRequester BringIntoViewRequester() {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.BringIntoViewRequester();
    }

    public static final Modifier bringIntoViewRequester(Modifier $this$bringIntoViewRequester, androidx.compose.foundation.relocation.BringIntoViewRequester bringIntoViewRequester) {
        return BringIntoViewRequesterKt__BringIntoViewRequesterKt.bringIntoViewRequester($this$bringIntoViewRequester, bringIntoViewRequester);
    }

    public static final Modifier bringIntoViewResponder(Modifier $this$bringIntoViewResponder, androidx.compose.foundation.relocation.BringIntoViewResponder responder) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.bringIntoViewResponder($this$bringIntoViewResponder, responder);
    }

    public static final androidx.compose.foundation.relocation.BringIntoViewParent findBringIntoViewParent(DelegatableNode $this$findBringIntoViewParent) {
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.findBringIntoViewParent($this$findBringIntoViewParent);
    }
}
