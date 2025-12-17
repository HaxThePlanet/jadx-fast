package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"Landroidx/compose/ui/viewinterop/FocusTargetPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "()V", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FocusTargetPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    @Override // androidx.compose.ui.Modifier$Node
    public void applyFocusProperties(FocusProperties focusProperties) {
        boolean focusable;
        int i;
        if (getNode().isAttached() && FocusGroupNode_androidKt.access$getView((Modifier.Node)this).hasFocusable()) {
            i = FocusGroupNode_androidKt.access$getView((Modifier.Node)this).hasFocusable() ? 1 : 0;
        } else {
        }
        focusProperties.setCanFocus(i);
    }
}
