package androidx.compose.foundation;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000c\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"Landroidx/compose/foundation/NoIndicationInstance;", "Landroidx/compose/foundation/IndicationInstance;", "()V", "drawIndication", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class NoIndicationInstance implements androidx.compose.foundation.IndicationInstance {

    public static final androidx.compose.foundation.NoIndicationInstance INSTANCE;
    static {
        NoIndicationInstance noIndicationInstance = new NoIndicationInstance();
        NoIndicationInstance.INSTANCE = noIndicationInstance;
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(ContentDrawScope $this$drawIndication) {
        $this$drawIndication.drawContent();
    }
}
