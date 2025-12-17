package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"DefaultSelectionColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getDefaultTextSelectionColors$annotations", "()V", "LocalTextSelectionColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextSelectionColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextSelectionColorsKt {

    private static final long DefaultSelectionColor;
    private static final androidx.compose.foundation.text.selection.TextSelectionColors DefaultTextSelectionColors;
    private static final ProvidableCompositionLocal<androidx.compose.foundation.text.selection.TextSelectionColors> LocalTextSelectionColors;
    static {
        final int i = 1;
        int i2 = 0;
        TextSelectionColorsKt.LocalTextSelectionColors = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)TextSelectionColorsKt.LocalTextSelectionColors.1.INSTANCE, i, i2);
        TextSelectionColorsKt.DefaultSelectionColor = ColorKt.Color(4282550004L);
        TextSelectionColors textSelectionColors = new TextSelectionColors(TextSelectionColorsKt.DefaultSelectionColor, obj4, Color.copy-wmQWz5c$default(TextSelectionColorsKt.DefaultSelectionColor, obj6, 1053609165, 0, 0, 0, 14), obj6, 0);
        TextSelectionColorsKt.DefaultTextSelectionColors = textSelectionColors;
    }

    public static final androidx.compose.foundation.text.selection.TextSelectionColors access$getDefaultTextSelectionColors$p() {
        return TextSelectionColorsKt.DefaultTextSelectionColors;
    }

    private static void getDefaultTextSelectionColors$annotations() {
    }

    public static final ProvidableCompositionLocal<androidx.compose.foundation.text.selection.TextSelectionColors> getLocalTextSelectionColors() {
        return TextSelectionColorsKt.LocalTextSelectionColors;
    }
}
