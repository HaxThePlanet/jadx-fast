package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0008*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\u000c\u0010\n\u001a\u00020\u000b*\u00020\u000bH\u0000\u001a\u000c\u0010\u000c\u001a\u00020\u0005*\u00020\rH\u0002¨\u0006\u000e", d2 = {"getCurrentlyFocusedRect", "Landroid/graphics/Rect;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "hostView", "Landroid/view/View;", "embeddedView", "containsDescendant", "", "other", "focusInteropModifier", "Landroidx/compose/ui/Modifier;", "getView", "Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusGroupNode_androidKt {
    public static final boolean access$containsDescendant(View $receiver, View other) {
        return FocusGroupNode_androidKt.containsDescendant($receiver, other);
    }

    public static final Rect access$getCurrentlyFocusedRect(FocusOwner focusOwner, View hostView, View embeddedView) {
        return FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, hostView, embeddedView);
    }

    public static final View access$getView(Modifier.Node $receiver) {
        return FocusGroupNode_androidKt.getView($receiver);
    }

    private static final boolean containsDescendant(View $this$containsDescendant, View other) {
        ViewParent viewParent;
        ViewParent parent;
        viewParent = other.getParent();
        while (viewParent != null) {
            viewParent = viewParent.getParent();
        }
        return 0;
    }

    public static final Modifier focusInteropModifier(Modifier $this$focusInteropModifier) {
        return FocusModifierKt.focusTarget(FocusModifierKt.focusTarget($this$focusInteropModifier.then((Modifier)FocusGroupPropertiesElement.INSTANCE)).then((Modifier)FocusTargetPropertiesElement.INSTANCE));
    }

    private static final Rect getCurrentlyFocusedRect(FocusOwner focusOwner, View hostView, View embeddedView) {
        int i = 2;
        final int[] iArr2 = new int[i];
        int i3 = 0;
        hostView.getLocationOnScreen(iArr2);
        int[] iArr = new int[i];
        int i4 = 0;
        embeddedView.getLocationOnScreen(iArr);
        Rect focusRect = focusOwner.getFocusRect();
        if (focusRect == null) {
            return null;
        }
        int i8 = 0;
        int i18 = 1;
        Rect rect = new Rect(i6 -= i14, i16 -= i21, i23 -= i9, i11 -= i19);
        return rect;
    }

    private static final View getView(Modifier.Node $this$getView) {
        View interopView = DelegatableNodeKt.requireLayoutNode((DelegatableNode)$this$getView.getNode()).getInteropView();
        if (interopView == null) {
        } else {
            return interopView;
        }
        int i = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Could not fetch interop view".toString());
        throw illegalStateException;
    }
}
