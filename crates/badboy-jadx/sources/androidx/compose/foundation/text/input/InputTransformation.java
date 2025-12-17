package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008ç\u0080\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u000c\u0010\u0006\u001a\u00020\u0007*\u00020\u0008H\u0016J\u000c\u0010\t\u001a\u00020\u0007*\u00020\nH&R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000cÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/input/InputTransformation;", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InputTransformation {

    public static final androidx.compose.foundation.text.input.InputTransformation.Companion Companion;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000c\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"Landroidx/compose/foundation/text/input/InputTransformation$Companion;", "Landroidx/compose/foundation/text/input/InputTransformation;", "()V", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements androidx.compose.foundation.text.input.InputTransformation {

        static final androidx.compose.foundation.text.input.InputTransformation.Companion $$INSTANCE;
        static {
            InputTransformation.Companion companion = new InputTransformation.Companion();
            InputTransformation.Companion.$$INSTANCE = companion;
        }

        @Override // androidx.compose.foundation.text.input.InputTransformation
        public void transformInput(androidx.compose.foundation.text.input.TextFieldBuffer $this$transformInput) {
        }
    }
    static {
        InputTransformation.Companion = InputTransformation.Companion.$$INSTANCE;
    }

    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
    }

    public KeyboardOptions getKeyboardOptions() {
        return null;
    }

    public abstract void transformInput(androidx.compose.foundation.text.input.TextFieldBuffer textFieldBuffer);
}
