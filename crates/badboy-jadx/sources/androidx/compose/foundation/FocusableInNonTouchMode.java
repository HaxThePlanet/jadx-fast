package androidx.compose.foundation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputMode.Companion;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/FocusableInNonTouchMode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "()V", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusableInNonTouchMode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode {

    public static final int $stable;
    private final boolean shouldAutoInvalidate;
    static {
    }

    private final InputModeManager getInputModeManager() {
        return (InputModeManager)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)CompositionLocalsKt.getLocalInputModeManager());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void applyFocusProperties(FocusProperties focusProperties) {
        final int i = 0;
        focusProperties.setCanFocus(equals-impl0 ^= 1);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }
}
