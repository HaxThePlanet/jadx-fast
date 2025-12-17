package androidx.compose.ui;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¨\u0006\u0003", d2 = {"zIndex", "Landroidx/compose/ui/Modifier;", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ZIndexModifierKt {
    public static final androidx.compose.ui.Modifier zIndex(androidx.compose.ui.Modifier $this$zIndex, float zIndex) {
        ZIndexElement zIndexElement = new ZIndexElement(zIndex);
        return $this$zIndex.then((Modifier)zIndexElement);
    }
}
