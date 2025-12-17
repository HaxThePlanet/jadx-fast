package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u001c\u001a\u00020\u001dH\u0002J\u0008\u0010\u001e\u001a\u00020\u001dH\u0002J\u0008\u0010\u001f\u001a\u00020\u001dH\u0002J\u0008\u0010 \u001a\u00020\u001dH\u0002J\u0008\u0010!\u001a\u00020\u001dH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\u0000H\u0002J\n\u0010#\u001a\u0004\u0018\u00010\u0000H\u0002J\u0008\u0010$\u001a\u00020\u001dH\u0016J\u0008\u0010%\u001a\u00020\u001dH\u0016J\u0008\u0010&\u001a\u00020\u001dH\u0002J\u0008\u0010'\u001a\u00020\u001dH\u0002J*\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016ø\u0001\u0000¢\u0006\u0004\u0008/\u00100R\u000e\u0010\n\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR$\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u0008@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00061", d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", "cursorInBoundsOfNode", "value", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "setIcon", "(Landroidx/compose/ui/input/pointer/PointerIcon;)V", "getOverrideDescendants", "()Z", "setOverrideDescendants", "(Z)V", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "traverseKey", "", "getTraverseKey", "()Ljava/lang/String;", "displayDefaultIcon", "", "displayIcon", "displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon", "displayIconFromCurrentNodeOrDescendantsWithCursorInBounds", "displayIconIfDescendantsDoNotHavePriority", "findDescendantNodeWithCursorInBounds", "findOverridingAncestorNode", "onCancelPointerInput", "onDetach", "onEnter", "onExit", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerHoverIconModifierNode extends Modifier.Node implements TraversableNode, PointerInputModifierNode, CompositionLocalConsumerModifierNode {

    public static final int $stable = 8;
    private boolean cursorInBoundsOfNode;
    private androidx.compose.ui.input.pointer.PointerIcon icon;
    private boolean overrideDescendants;
    private final String traverseKey;
    static {
        final int i = 8;
    }

    public PointerHoverIconModifierNode(androidx.compose.ui.input.pointer.PointerIcon icon, boolean overrideDescendants) {
        super();
        this.traverseKey = "androidx.compose.ui.input.pointer.PointerHoverIcon";
        this.icon = icon;
        this.overrideDescendants = overrideDescendants;
    }

    public PointerHoverIconModifierNode(androidx.compose.ui.input.pointer.PointerIcon pointerIcon, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(pointerIcon, obj2);
    }

    public static final boolean access$getCursorInBoundsOfNode$p(androidx.compose.ui.input.pointer.PointerHoverIconModifierNode $this) {
        return $this.cursorInBoundsOfNode;
    }

    private final void displayDefaultIcon() {
        int i;
        final androidx.compose.ui.input.pointer.PointerIconService pointerIconService = getPointerIconService();
        if (pointerIconService != null) {
            pointerIconService.setIcon(0);
        }
    }

    private final void displayIcon() {
        androidx.compose.ui.input.pointer.PointerIcon overridingAncestorNode;
        overridingAncestorNode = findOverridingAncestorNode();
        if (overridingAncestorNode != null) {
            if (overridingAncestorNode.icon == null) {
                overridingAncestorNode = this.icon;
            }
        } else {
        }
        final androidx.compose.ui.input.pointer.PointerIconService pointerIconService = getPointerIconService();
        if (pointerIconService != null) {
            pointerIconService.setIcon(overridingAncestorNode);
        }
    }

    private final void displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon() {
        Unit iNSTANCE;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        PointerHoverIconModifierNode.displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon.1 anon = new PointerHoverIconModifierNode.displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon.1(objectRef);
        TraversableNodeKt.traverseAncestors((TraversableNode)this, (Function1)anon);
        Object element = objectRef.element;
        iNSTANCE = (PointerHoverIconModifierNode)element != null ? Unit.INSTANCE : 0;
        if (iNSTANCE == null) {
            displayDefaultIcon();
        }
    }

    private final void displayIconFromCurrentNodeOrDescendantsWithCursorInBounds() {
        Object pointerHoverIconModifierNode;
        boolean descendantNodeWithCursorInBounds;
        int i;
        if (!this.cursorInBoundsOfNode) {
        }
        int i2 = 0;
        pointerHoverIconModifierNode = this;
        descendantNodeWithCursorInBounds = findDescendantNodeWithCursorInBounds();
        if (!this.overrideDescendants && descendantNodeWithCursorInBounds != null) {
            descendantNodeWithCursorInBounds = findDescendantNodeWithCursorInBounds();
            if (descendantNodeWithCursorInBounds != null) {
                i = 0;
                pointerHoverIconModifierNode = descendantNodeWithCursorInBounds;
            }
        }
        (PointerHoverIconModifierNode)pointerHoverIconModifierNode.displayIcon();
    }

    private final void displayIconIfDescendantsDoNotHavePriority() {
        boolean overrideDescendants;
        androidx.compose.ui.input.pointer.PointerHoverIconModifierNode.displayIconIfDescendantsDoNotHavePriority.1 anon;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (!this.overrideDescendants) {
            anon = new PointerHoverIconModifierNode.displayIconIfDescendantsDoNotHavePriority.1(booleanRef);
            TraversableNodeKt.traverseDescendants((TraversableNode)this, (Function1)anon);
        }
        if (booleanRef.element) {
            displayIcon();
        }
    }

    private final androidx.compose.ui.input.pointer.PointerHoverIconModifierNode findDescendantNodeWithCursorInBounds() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        PointerHoverIconModifierNode.findDescendantNodeWithCursorInBounds.1 anon = new PointerHoverIconModifierNode.findDescendantNodeWithCursorInBounds.1(objectRef);
        TraversableNodeKt.traverseDescendants((TraversableNode)this, (Function1)anon);
        return (PointerHoverIconModifierNode)objectRef.element;
    }

    private final androidx.compose.ui.input.pointer.PointerHoverIconModifierNode findOverridingAncestorNode() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        PointerHoverIconModifierNode.findOverridingAncestorNode.1 anon = new PointerHoverIconModifierNode.findOverridingAncestorNode.1(objectRef);
        TraversableNodeKt.traverseAncestors((TraversableNode)this, (Function1)anon);
        return (PointerHoverIconModifierNode)objectRef.element;
    }

    private final androidx.compose.ui.input.pointer.PointerIconService getPointerIconService() {
        return (PointerIconService)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)CompositionLocalsKt.getLocalPointerIconService());
    }

    private final void onEnter() {
        this.cursorInBoundsOfNode = true;
        displayIconIfDescendantsDoNotHavePriority();
    }

    private final void onExit() {
        boolean cursorInBoundsOfNode;
        this.cursorInBoundsOfNode = false;
        if (this.cursorInBoundsOfNode && isAttached()) {
            this.cursorInBoundsOfNode = false;
            if (isAttached()) {
                displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.ui.input.pointer.PointerIcon getIcon() {
        return this.icon;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public Object getTraverseKey() {
        return getTraverseKey();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public String getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onCancelPointerInput() {
        onExit();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        onExit();
        super.onDetach();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onPointerEvent-H0pRuoY(androidx.compose.ui.input.pointer.PointerEvent pointerEvent, androidx.compose.ui.input.pointer.PointerEventPass pass, long bounds) {
        androidx.compose.ui.input.pointer.PointerEventPass main;
        int enter-7fucELk;
        if (pass == PointerEventPass.Main) {
            if (PointerEventType.equals-impl0(pointerEvent.getType-7fucELk(), PointerEventType.Companion.getEnter-7fucELk())) {
                onEnter();
            } else {
                if (PointerEventType.equals-impl0(pointerEvent.getType-7fucELk(), PointerEventType.Companion.getExit-7fucELk())) {
                    onExit();
                }
            }
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setIcon(androidx.compose.ui.input.pointer.PointerIcon value) {
        boolean cursorInBoundsOfNode;
        this.icon = value;
        if (!Intrinsics.areEqual(this.icon, value) && this.cursorInBoundsOfNode) {
            this.icon = value;
            if (this.cursorInBoundsOfNode) {
                displayIconIfDescendantsDoNotHavePriority();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setOverrideDescendants(boolean value) {
        boolean cursorInBoundsOfNode;
        if (this.overrideDescendants != value) {
            this.overrideDescendants = value;
            if (this.overrideDescendants) {
                if (this.cursorInBoundsOfNode) {
                    displayIcon();
                }
            } else {
                if (this.cursorInBoundsOfNode) {
                    displayIconFromCurrentNodeOrDescendantsWithCursorInBounds();
                }
            }
        }
    }
}
