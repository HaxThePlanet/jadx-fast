package androidx.compose.foundation.text;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\u0008\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "getDefaultCursorThickness", "()F", "F", "cursorAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "cursor", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldCursorKt {

    private static final float DefaultCursorThickness;
    private static final AnimationSpec<Float> cursorAnimationSpec;
    static {
        TextFieldCursorKt.cursorAnimationSpec = (AnimationSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)AnimationSpecKt.keyframes((Function1)TextFieldCursorKt.cursorAnimationSpec.1.INSTANCE), 0, 0, obj4, 6);
        int i2 = 0;
        TextFieldCursorKt.DefaultCursorThickness = Dp.constructor-impl((float)i);
    }

    public static final Modifier cursor(Modifier $this$cursor, androidx.compose.foundation.text.LegacyTextFieldState state, TextFieldValue value, OffsetMapping offsetMapping, Brush cursorBrush, boolean enabled) {
        Modifier composed$default;
        int i;
        int i2;
        if (enabled) {
            TextFieldCursorKt.cursor.1 anon = new TextFieldCursorKt.cursor.1(cursorBrush, state, value, offsetMapping);
            i2 = 0;
            composed$default = ComposedModifierKt.composed$default($this$cursor, i2, (Function3)anon, 1, i2);
        } else {
            composed$default = $this$cursor;
        }
        return composed$default;
    }

    public static final float getDefaultCursorThickness() {
        return TextFieldCursorKt.DefaultCursorThickness;
    }
}
