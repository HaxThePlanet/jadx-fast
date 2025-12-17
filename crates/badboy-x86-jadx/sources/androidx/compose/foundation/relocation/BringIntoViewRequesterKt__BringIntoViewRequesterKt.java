package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0004", d2 = {"BringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "bringIntoViewRequester", "Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/foundation/relocation/BringIntoViewRequesterKt")
final class BringIntoViewRequesterKt__BringIntoViewRequesterKt {
    public static final androidx.compose.foundation.relocation.BringIntoViewRequester BringIntoViewRequester() {
        BringIntoViewRequesterImpl bringIntoViewRequesterImpl = new BringIntoViewRequesterImpl();
        return (BringIntoViewRequester)bringIntoViewRequesterImpl;
    }

    public static final Modifier bringIntoViewRequester(Modifier $this$bringIntoViewRequester, androidx.compose.foundation.relocation.BringIntoViewRequester bringIntoViewRequester) {
        BringIntoViewRequesterElement bringIntoViewRequesterElement = new BringIntoViewRequesterElement(bringIntoViewRequester);
        return $this$bringIntoViewRequester.then((Modifier)bringIntoViewRequesterElement);
    }
}
