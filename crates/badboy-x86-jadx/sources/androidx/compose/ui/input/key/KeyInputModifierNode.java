package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007J\u001a\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\u0007ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "onKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface KeyInputModifierNode extends DelegatableNode {
    @Override // androidx.compose.ui.node.DelegatableNode
    public abstract boolean onKeyEvent-ZmokQxo(KeyEvent keyEvent);

    @Override // androidx.compose.ui.node.DelegatableNode
    public abstract boolean onPreKeyEvent-ZmokQxo(KeyEvent keyEvent);
}
