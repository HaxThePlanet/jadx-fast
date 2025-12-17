package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002", d2 = {"handwritingHandler", "Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HandwritingHandler_androidKt {
    public static final Modifier handwritingHandler(Modifier $this$handwritingHandler) {
        Modifier then;
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            HandwritingHandlerElement handwritingHandlerElement = new HandwritingHandlerElement();
            then = $this$handwritingHandler.then((Modifier)handwritingHandlerElement);
        } else {
            then = $this$handwritingHandler;
        }
        return then;
    }
}
