package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\u0008\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\u0008", d2 = {"contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldSelectionState_androidKt {
    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this$contextMenuBuilder, ContextMenuState state) {
        TextFieldSelectionState_androidKt.contextMenuBuilder.1 anon = new TextFieldSelectionState_androidKt.contextMenuBuilder.1(state, $this$contextMenuBuilder);
        return (Function1)anon;
    }
}
