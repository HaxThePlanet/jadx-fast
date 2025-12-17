package androidx.compose.foundation.text.selection;

import android.view.KeyEvent;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a%\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n*\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002", d2 = {"isCopyKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "isCopyKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/text/selection/SelectionManager;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "selectionMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "foundation_release", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionManager_androidKt {
    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(androidx.compose.foundation.text.selection.SelectionManager $this$contextMenuBuilder, ContextMenuState state) {
        SelectionManager_androidKt.contextMenuBuilder.1 anon = new SelectionManager_androidKt.contextMenuBuilder.1(state, $this$contextMenuBuilder);
        return (Function1)anon;
    }

    public static final boolean isCopyKeyEvent-ZmokQxo(KeyEvent keyEvent) {
        int i;
        i = KeyMapping_androidKt.getPlatformDefaultKeyMapping().map-ZmokQxo(keyEvent) == KeyCommand.COPY ? 1 : 0;
        return i;
    }

    public static final Modifier selectionMagnifier(Modifier $this$selectionMagnifier, androidx.compose.foundation.text.selection.SelectionManager manager) {
        final int i2 = 1;
        final int i3 = 0;
        if (!Magnifier_androidKt.isPlatformMagnifierSupported$default(0, i2, i3)) {
            return $this$selectionMagnifier;
        }
        SelectionManager_androidKt.selectionMagnifier.1 anon = new SelectionManager_androidKt.selectionMagnifier.1(manager);
        return ComposedModifierKt.composed$default($this$selectionMagnifier, i3, (Function3)anon, i2, i3);
    }
}
