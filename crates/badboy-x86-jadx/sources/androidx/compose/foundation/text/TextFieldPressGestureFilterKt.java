package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007H\u0000¨\u0006\n", d2 = {"tapPressTextFieldModifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onTap", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldPressGestureFilterKt {
    public static final Modifier tapPressTextFieldModifier(Modifier $this$tapPressTextFieldModifier, MutableInteractionSource interactionSource, boolean enabled, Function1<? super Offset, Unit> onTap) {
        Modifier composed$default;
        int i2;
        int i;
        if (enabled) {
            TextFieldPressGestureFilterKt.tapPressTextFieldModifier.1 anon = new TextFieldPressGestureFilterKt.tapPressTextFieldModifier.1(onTap, interactionSource);
            i = 0;
            composed$default = ComposedModifierKt.composed$default($this$tapPressTextFieldModifier, i, (Function3)anon, 1, i);
        } else {
            composed$default = $this$tapPressTextFieldModifier;
        }
        return composed$default;
    }

    public static Modifier tapPressTextFieldModifier$default(Modifier modifier, MutableInteractionSource mutableInteractionSource2, boolean z3, Function1 function14, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 1;
        }
        return TextFieldPressGestureFilterKt.tapPressTextFieldModifier(modifier, mutableInteractionSource2, obj2, function14);
    }
}
