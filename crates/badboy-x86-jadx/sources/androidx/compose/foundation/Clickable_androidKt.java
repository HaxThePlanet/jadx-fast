package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEventType.Companion;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\r\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\u000c\u0010\u000f\u001a\u00020\u0005*\u00020\u0010H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008\"\u0018\u0010\u000b\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0008¨\u0006\u0011", d2 = {"TapIndicationDelay", "", "getTapIndicationDelay", "()J", "isClick", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnter", "isEnter-ZmokQxo", "isPress", "isPress-ZmokQxo", "isComposeRootInScrollableContainer", "Landroidx/compose/ui/node/DelegatableNode;", "isInScrollableViewGroup", "Landroid/view/View;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Clickable_androidKt {

    private static final long TapIndicationDelay;
    static {
        Clickable_androidKt.TapIndicationDelay = (long)tapTimeout;
    }

    public static final long getTapIndicationDelay() {
        return Clickable_androidKt.TapIndicationDelay;
    }

    public static final boolean isClick-ZmokQxo(KeyEvent $this$isClick) {
        boolean enter-ZmokQxo;
        int i;
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo($this$isClick), KeyEventType.Companion.getKeyUp-CS__XNY()) && Clickable_androidKt.isEnter-ZmokQxo($this$isClick)) {
            i = Clickable_androidKt.isEnter-ZmokQxo($this$isClick) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final boolean isComposeRootInScrollableContainer(DelegatableNode $this$isComposeRootInScrollableContainer) {
        return Clickable_androidKt.isInScrollableViewGroup(DelegatableNode_androidKt.requireView($this$isComposeRootInScrollableContainer));
    }

    private static final boolean isEnter-ZmokQxo(KeyEvent $this$isEnter) {
        int i;
        i = /* condition */ ? 1 : 0;
        return i;
    }

    private static final boolean isInScrollableViewGroup(View $this$isInScrollableViewGroup) {
        android.view.ViewParent p;
        android.view.ViewParent view;
        p = $this$isInScrollableViewGroup.getParent();
        while (p != null) {
            p = (ViewGroup)p.getParent();
        }
        return 0;
    }

    public static final boolean isPress-ZmokQxo(KeyEvent $this$isPress) {
        boolean enter-ZmokQxo;
        int i;
        if (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo($this$isPress), KeyEventType.Companion.getKeyDown-CS__XNY()) && Clickable_androidKt.isEnter-ZmokQxo($this$isPress)) {
            i = Clickable_androidKt.isEnter-ZmokQxo($this$isPress) ? 1 : 0;
        } else {
        }
        return i;
    }
}
