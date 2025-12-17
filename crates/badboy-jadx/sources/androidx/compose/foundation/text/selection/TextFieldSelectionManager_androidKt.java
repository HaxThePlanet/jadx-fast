package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\u001a%\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0008\u0008*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0014\u0010\u000c\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0003¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002", d2 = {"isShiftPressed", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "contextMenuState", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "textFieldMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "foundation_release", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldSelectionManager_androidKt {
    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this$contextMenuBuilder, ContextMenuState contextMenuState) {
        TextFieldSelectionManager_androidKt.contextMenuBuilder.1 anon = new TextFieldSelectionManager_androidKt.contextMenuBuilder.1($this$contextMenuBuilder, contextMenuState);
        return (Function1)anon;
    }

    public static final boolean isShiftPressed(PointerEvent $this$isShiftPressed) {
        return 0;
    }

    public static final Modifier textFieldMagnifier(Modifier $this$textFieldMagnifier, androidx.compose.foundation.text.selection.TextFieldSelectionManager manager) {
        final int i2 = 1;
        final int i3 = 0;
        if (!Magnifier_androidKt.isPlatformMagnifierSupported$default(0, i2, i3)) {
            return $this$textFieldMagnifier;
        }
        TextFieldSelectionManager_androidKt.textFieldMagnifier.1 anon = new TextFieldSelectionManager_androidKt.textFieldMagnifier.1(manager);
        return ComposedModifierKt.composed$default($this$textFieldMagnifier, i3, (Function3)anon, i2, i3);
    }
}
