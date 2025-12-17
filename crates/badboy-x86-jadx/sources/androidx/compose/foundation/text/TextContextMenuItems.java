package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/text/TextContextMenuItems;", "", "stringId", "", "(Ljava/lang/String;II)V", "resolvedString", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Cut", "Copy", "Paste", "SelectAll", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum TextContextMenuItems {

    Cut(17039363),
    Cut(17039363),
    Cut(17039363),
    Cut(17039363),
    Cut(17039363);

    private final int stringId;
    private static final androidx.compose.foundation.text.TextContextMenuItems[] $values() {
        return /* result */;
    }

    @Override // java.lang.Enum
    public final String resolvedString(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -309609081;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(resolvedString)89@3128L24:ContextMenu.android.kt#423gt5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.text.TextContextMenuItems.resolvedString (ContextMenu.android.kt:89)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return StringResources_androidKt.stringResource(this.stringId, $composer, 0);
    }
}
