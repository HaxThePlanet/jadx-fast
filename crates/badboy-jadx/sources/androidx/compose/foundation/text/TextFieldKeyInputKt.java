package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001al\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"textFieldKeyInput", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "editable", "", "singleLine", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "textFieldKeyInput-2WJ9YEU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;ZZLandroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldKeyInputKt {
    public static final Modifier textFieldKeyInput-2WJ9YEU(Modifier $this$textFieldKeyInput_u2d2WJ9YEU, androidx.compose.foundation.text.LegacyTextFieldState state, TextFieldSelectionManager manager, TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, boolean editable, boolean singleLine, OffsetMapping offsetMapping, androidx.compose.foundation.text.UndoManager undoManager, int imeAction) {
        TextFieldKeyInputKt.textFieldKeyInput.2 anon = new TextFieldKeyInputKt.textFieldKeyInput.2(state, manager, value, editable, singleLine, offsetMapping, undoManager, onValueChange, imeAction);
        int i2 = 0;
        return ComposedModifierKt.composed$default($this$textFieldKeyInput_u2d2WJ9YEU, i2, (Function3)anon, 1, i2);
    }

    public static Modifier textFieldKeyInput-2WJ9YEU$default(Modifier modifier, androidx.compose.foundation.text.LegacyTextFieldState legacyTextFieldState2, TextFieldSelectionManager textFieldSelectionManager3, TextFieldValue textFieldValue4, Function1 function15, boolean z6, boolean z7, OffsetMapping offsetMapping8, androidx.compose.foundation.text.UndoManager undoManager9, int i10, int i11, Object object12) {
        androidx.compose.foundation.text.TextFieldKeyInputKt.textFieldKeyInput.1 field;
        androidx.compose.foundation.text.TextFieldKeyInputKt.textFieldKeyInput.1 obj14;
        if (i11 & 8 != 0) {
            field = obj14;
        } else {
            field = function15;
        }
        return TextFieldKeyInputKt.textFieldKeyInput-2WJ9YEU(modifier, legacyTextFieldState2, textFieldSelectionManager3, textFieldValue4, field, z6, z7, offsetMapping8, undoManager9, i10);
    }
}
