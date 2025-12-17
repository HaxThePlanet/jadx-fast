package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0010\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000f\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/text/TextLayoutResult;)V", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "shouldClip", "", "getShouldClip", "()Z", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "copy", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "", "end", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class StaticTextSelectionParams {

    public static final int $stable = 8;
    public static final androidx.compose.foundation.text.modifiers.StaticTextSelectionParams.Companion Companion;
    private static final androidx.compose.foundation.text.modifiers.StaticTextSelectionParams Empty;
    private final LayoutCoordinates layoutCoordinates;
    private final TextLayoutResult textLayoutResult;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams$Companion;", "", "()V", "Empty", "Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "getEmpty", "()Landroidx/compose/foundation/text/modifiers/StaticTextSelectionParams;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.foundation.text.modifiers.StaticTextSelectionParams getEmpty() {
            return StaticTextSelectionParams.access$getEmpty$cp();
        }
    }
    static {
        final int i2 = 0;
        StaticTextSelectionParams.Companion companion = new StaticTextSelectionParams.Companion(i2);
        StaticTextSelectionParams.Companion = companion;
        int i = 8;
        StaticTextSelectionParams staticTextSelectionParams = new StaticTextSelectionParams(i2, i2);
        StaticTextSelectionParams.Empty = staticTextSelectionParams;
    }

    public StaticTextSelectionParams(LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult) {
        super();
        this.layoutCoordinates = layoutCoordinates;
        this.textLayoutResult = textLayoutResult;
    }

    public static final androidx.compose.foundation.text.modifiers.StaticTextSelectionParams access$getEmpty$cp() {
        return StaticTextSelectionParams.Empty;
    }

    public static androidx.compose.foundation.text.modifiers.StaticTextSelectionParams copy$default(androidx.compose.foundation.text.modifiers.StaticTextSelectionParams staticTextSelectionParams, LayoutCoordinates layoutCoordinates2, TextLayoutResult textLayoutResult3, int i4, Object object5) {
        LayoutCoordinates obj1;
        TextLayoutResult obj2;
        if (object5 != null) {
        } else {
            if (i4 & 1 != 0) {
                obj1 = staticTextSelectionParams.layoutCoordinates;
            }
            if (i4 &= 2 != 0) {
                obj2 = staticTextSelectionParams.textLayoutResult;
            }
            return staticTextSelectionParams.copy(obj1, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        throw obj0;
    }

    public final androidx.compose.foundation.text.modifiers.StaticTextSelectionParams copy(LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult) {
        StaticTextSelectionParams staticTextSelectionParams = new StaticTextSelectionParams(layoutCoordinates, textLayoutResult);
        return staticTextSelectionParams;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public Path getPathForRange(int start, int end) {
        Path pathForRange;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            pathForRange = textLayoutResult.getPathForRange(start, end);
        } else {
            pathForRange = 0;
        }
        return pathForRange;
    }

    public boolean getShouldClip() {
        int i;
        int i2;
        boolean hasVisualOverflow;
        int visible-gIe3tQ8;
        final TextLayoutResult textLayoutResult = this.textLayoutResult;
        i = 0;
        if (textLayoutResult != null) {
            i2 = 0;
            if (!TextOverflow.equals-impl0(textLayoutResult.getLayoutInput().getOverflow-gIe3tQ8(), TextOverflow.Companion.getVisible-gIe3tQ8()) && textLayoutResult.getHasVisualOverflow()) {
                if (textLayoutResult.getHasVisualOverflow()) {
                    i = 1;
                }
            }
        } else {
        }
        return i;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }
}
