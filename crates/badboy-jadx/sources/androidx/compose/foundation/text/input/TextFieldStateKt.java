package androidx.compose.foundation.text.input;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a\n\u0010\u000b\u001a\u00020\u000c*\u00020\u0001\u001a\u0012\u0010\r\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0006\u001a\u0012\u0010\u000f\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0010", d2 = {"TextFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "initialValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "rememberTextFieldState", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "rememberTextFieldState-Le-punE", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/text/input/TextFieldState;", "clearText", "", "setTextAndPlaceCursorAtEnd", "text", "setTextAndSelectAll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldStateKt {
    public static final androidx.compose.foundation.text.input.TextFieldState TextFieldState(TextFieldValue initialValue) {
        TextFieldState textFieldState = new TextFieldState(initialValue.getText(), initialValue.getSelection-d9O1mEE(), obj3, 0);
        return textFieldState;
    }

    public static final void clearText(androidx.compose.foundation.text.input.TextFieldState $this$clearText) {
        final Object obj = $this$clearText;
        final int i = 0;
        final androidx.compose.foundation.text.input.TextFieldBuffer edit = obj.startEdit();
        final androidx.compose.foundation.text.input.TextFieldBuffer field = edit;
        final int i2 = 0;
        TextFieldBufferKt.delete(field, 0, field.getLength());
        TextFieldBufferKt.placeCursorAtEnd(field);
        obj.commitEdit(edit);
        obj.finishEditing();
    }

    public static final androidx.compose.foundation.text.input.TextFieldState rememberTextFieldState-Le-punE(String initialText, long initialSelection, Composer $composer, int $changed, int i5) {
        int str;
        int i;
        boolean changed2;
        boolean changed;
        Object empty;
        Object anon;
        String obj8;
        long obj9;
        int obj13;
        int i2 = 1125389485;
        ComposerKt.sourceInformationMarkerStart($changed, i2, "C(rememberTextFieldState)P(1,0:c#ui.text.TextRange)620@26335L53,620@26288L100:TextFieldState.kt#hp9ohv");
        if (obj13 & 1 != 0) {
            obj8 = "";
        }
        if (obj13 &= 2 != 0) {
            obj9 = TextRangeKt.TextRange(obj8.length());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i5, -1, "androidx.compose.foundation.text.input.rememberTextFieldState (TextFieldState.kt:620)");
        }
        obj13 = 0;
        ComposerKt.sourceInformationMarkerStart($changed, 975793873, "CC(remember):TextFieldState.kt#9igjgp");
        int i7 = 4;
        int i10 = 1;
        if (i4 ^= 6 > i7) {
            if (!$changed.changed(obj8)) {
                i = i5 & 6 == i7 ? i10 : obj13;
            } else {
            }
        } else {
        }
        int i11 = 32;
        if (i8 ^= 48 > i11) {
            if (!$changed.changed(obj9)) {
                if (i5 & 48 == i11) {
                    obj13 = i10;
                }
            } else {
            }
        } else {
        }
        Composer composer = $changed;
        int i9 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (obj13 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new TextFieldStateKt.rememberTextFieldState.1.1(obj8, obj9, $composer);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        Composer composer2 = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (TextFieldState)RememberSaveableKt.rememberSaveable(new Object[obj13], (Saver)TextFieldState.Saver.INSTANCE, 0, (Function0)anon, composer2, 48, 4);
    }

    public static final void setTextAndPlaceCursorAtEnd(androidx.compose.foundation.text.input.TextFieldState $this$setTextAndPlaceCursorAtEnd, String text) {
        final Object obj = $this$setTextAndPlaceCursorAtEnd;
        final int i = 0;
        final androidx.compose.foundation.text.input.TextFieldBuffer edit = obj.startEdit();
        final androidx.compose.foundation.text.input.TextFieldBuffer field = edit;
        final int i2 = 0;
        field.replace(0, field.getLength(), (CharSequence)text);
        TextFieldBufferKt.placeCursorAtEnd(field);
        obj.commitEdit(edit);
        obj.finishEditing();
    }

    public static final void setTextAndSelectAll(androidx.compose.foundation.text.input.TextFieldState $this$setTextAndSelectAll, String text) {
        final Object obj = $this$setTextAndSelectAll;
        final int i = 0;
        final androidx.compose.foundation.text.input.TextFieldBuffer edit = obj.startEdit();
        final androidx.compose.foundation.text.input.TextFieldBuffer field = edit;
        final int i2 = 0;
        field.replace(0, field.getLength(), (CharSequence)text);
        TextFieldBufferKt.selectAll(field);
        obj.commitEdit(edit);
        obj.finishEditing();
    }
}
