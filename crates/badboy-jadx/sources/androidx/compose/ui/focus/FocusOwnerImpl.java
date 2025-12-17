package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEventType.Companion;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u0001Bª\u0001\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012:\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u000c¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0004\u0012\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000eH\u0016J2\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0008H\u0016ø\u0001\u0000¢\u0006\u0004\u0008/\u00100J\u001a\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\u00084\u00105J(\u00106\u001a\u00020\u000e2\u0006\u00102\u001a\u0002032\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u00088\u00109J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<H\u0016J:\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\u00082\u0008\u0010>\u001a\u0004\u0018\u00010\u000c2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e0\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\u0008@\u0010AJ\n\u0010B\u001a\u0004\u0018\u00010\u000cH\u0016J\u0008\u0010C\u001a\u00020\u0005H\u0002J\u001a\u0010D\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0008H\u0016ø\u0001\u0000¢\u0006\u0004\u0008E\u0010FJ\u0008\u0010G\u001a\u00020\u0005H\u0016J$\u0010H\u001a\u00020\u000e2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u00082\u0008\u0010\r\u001a\u0004\u0018\u00010\u000cH\u0016ø\u0001\u0000¢\u0006\u0002\u0008IJ\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020MH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\"H\u0016J$\u0010N\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00082\u0008\u0010\r\u001a\u0004\u0018\u00010\u000cH\u0016ø\u0001\u0000¢\u0006\u0004\u0008O\u0010PJ\u001a\u0010Q\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\u0008R\u00105J\u000e\u0010S\u001a\u0004\u0018\u00010T*\u00020UH\u0002J3\u0010V\u001a\u0004\u0018\u0001HW\"\n\u0008\u0000\u0010W\u0018\u0001*\u00020X*\u00020U2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u0002HW0ZH\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u0008[\u0010\\Jg\u0010]\u001a\u00020\u0005\"\n\u0008\u0000\u0010W\u0018\u0001*\u00020U*\u00020U2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u0002HW0Z2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u00032\u000c\u0010_\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\u0008ø\u0001\u0000¢\u0006\u0004\u0008a\u0010bR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u000c¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010*\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006c", d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "onRequestFocusForOwner", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusDirection;", "Lkotlin/ParameterName;", "name", "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "", "onMoveFocusInterop", "onClearFocusForOwner", "onFocusRectInterop", "onLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "clearFocus", "force", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "focusSearch", "focusedRect", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "getFocusRect", "invalidateOwnerFocusState", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "requestFocusForOwner", "requestFocusForOwner-7o62pno", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "nearestAncestorIncludingSelf", "T", "", "type", "Landroidx/compose/ui/node/NodeKind;", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "traverseAncestorsIncludingSelf", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusOwnerImpl implements androidx.compose.ui.focus.FocusOwner {

    public static final int $stable = 8;
    private final androidx.compose.ui.focus.FocusInvalidationManager focusInvalidationManager;
    private final androidx.compose.ui.focus.FocusTransactionManager focusTransactionManager;
    private MutableLongSet keysCurrentlyDown;
    private final Modifier modifier;
    private final Function0<Unit> onClearFocusForOwner;
    private final Function0<Rect> onFocusRectInterop;
    private final Function0<LayoutDirection> onLayoutDirection;
    private final Function1<androidx.compose.ui.focus.FocusDirection, Boolean> onMoveFocusInterop;
    private final Function2<androidx.compose.ui.focus.FocusDirection, Rect, Boolean> onRequestFocusForOwner;
    private androidx.compose.ui.focus.FocusTargetNode rootFocusNode;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal;
            int ordinal2;
            int ordinal4;
            int[] iArr = new int[values.length];
            iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            iArr[CustomDestinationResult.None.ordinal()] = 4;
            FocusOwnerImpl.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> onRequestApplyChangesListener, Function2<? super androidx.compose.ui.focus.FocusDirection, ? super Rect, Boolean> onRequestFocusForOwner, Function1<? super androidx.compose.ui.focus.FocusDirection, Boolean> onMoveFocusInterop, Function0<Unit> onClearFocusForOwner, Function0<Rect> onFocusRectInterop, Function0<? extends LayoutDirection> onLayoutDirection) {
        super();
        this.onRequestFocusForOwner = onRequestFocusForOwner;
        this.onMoveFocusInterop = onMoveFocusInterop;
        this.onClearFocusForOwner = onClearFocusForOwner;
        this.onFocusRectInterop = onFocusRectInterop;
        this.onLayoutDirection = onLayoutDirection;
        FocusTargetNode focusTargetNode = new FocusTargetNode();
        this.rootFocusNode = focusTargetNode;
        FocusOwnerImpl.focusInvalidationManager.1 anon = new FocusOwnerImpl.focusInvalidationManager.1(this);
        FocusInvalidationManager focusInvalidationManager = new FocusInvalidationManager(onRequestApplyChangesListener, (Function0)anon);
        this.focusInvalidationManager = focusInvalidationManager;
        FocusTransactionManager focusTransactionManager = new FocusTransactionManager();
        this.focusTransactionManager = focusTransactionManager;
        FocusOwnerImpl.modifier.2 anon2 = new FocusOwnerImpl.modifier.2(this);
        this.modifier = FocusPropertiesKt.focusProperties((Modifier)Modifier.Companion, (Function1)FocusOwnerImpl.modifier.1.INSTANCE).then((Modifier)anon2);
    }

    public static final void access$invalidateOwnerFocusState(androidx.compose.ui.focus.FocusOwnerImpl $this) {
        $this.invalidateOwnerFocusState();
    }

    private final void invalidateOwnerFocusState() {
        Object onClearFocusForOwner;
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.onClearFocusForOwner.invoke();
        }
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode $this$lastLocalKeyInputNode) {
        int focusedKeyInputNode;
        Modifier.Node next$iv$iv;
        String $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv$iv;
        int i3;
        int $i$f$getFocusTargetOLwlOKw;
        Modifier.Node node;
        int i;
        int i2;
        focusedKeyInputNode = 0;
        int i4 = 0;
        final int i5 = 1024;
        int i6 = 0;
        int i8 = 0;
        $i$f$getFocusTargetOLwlOKw2 |= $i$f$getKeyInputOLwlOKw;
        int i9 = 0;
        final Object obj2 = obj;
        final int i10 = 0;
        final int i11 = i10;
        final int i12 = 0;
        int i13 = 0;
        if (!obj2.getNode().isAttached()) {
            int i14 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node3 = obj2.getNode();
        if (aggregateChildKindSet$ui_release &= arg0$iv != 0) {
            next$iv$iv = node3.getChild$ui_release();
            while (next$iv$iv != null) {
                next$iv$iv = next$iv$iv.getChild$ui_release();
                $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv$iv = next$iv$iv;
                i3 = 0;
                int i15 = 0;
                i = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                i2 = i10;
                focusedKeyInputNode = $i$a$CheckPreconditionDelegatableNodeKt$visitLocalDescendants$1$iv$iv;
                i2 = 1;
            }
        }
        return focusedKeyInputNode;
    }

    private final <T> T nearestAncestorIncludingSelf-64DMado(DelegatableNode $this$nearestAncestorIncludingSelf_u2d64DMado, int type) {
        int nodes$ui_release;
        Modifier.Node it;
        int count$iv$iv;
        int $i$f$isKindH91voCI$ui_release;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho$iv;
        int $i$f$mutableVectorOf;
        int $i$f$visitAncestorsYYKmho;
        Object obj;
        int mask$iv$iv;
        Modifier.Node node$iv$iv2;
        LayoutNode layout$iv$iv;
        int node$iv$iv3;
        Modifier.Node head$ui_release;
        int i5;
        int i7;
        Modifier.Node node;
        int i3;
        int stack$iv$iv;
        int node$iv$iv;
        int $i$f$nearestAncestorIncludingSelf64DMado;
        int i6;
        Modifier.Node node2;
        int i;
        Modifier.Node node$iv$iv$iv;
        int i9;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho$iv2;
        int this_$iv$iv$iv;
        int count$iv$iv2;
        int i4;
        int i8;
        int i2;
        Object obj2;
        $i$f$visitAncestorsYYKmho = 0;
        obj = type;
        final DelegatableNode delegatableNode = $this$visitAncestors_u2dY_u2dYKmho$iv;
        final int i15 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv2 = delegatableNode.getNode();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= obj != 0) {
                } else {
                }
                $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                i6 = count$iv$iv;
                $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                node$iv$iv = 0;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                nodes$ui_release = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && nodes$ui_release != null) {
                } else {
                }
                node$iv$iv3 = node$iv$iv;
                node$iv$iv2 = node$iv$iv3;
                nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                count$iv$iv = i6;
                $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                $i$f$visitAncestorsYYKmho = i2;
                obj = obj2;
                nodes$ui_release = layout$iv$iv.getNodes$ui_release();
                if (nodes$ui_release != null) {
                } else {
                }
                node$iv$iv3 = nodes$ui_release.getTail$ui_release();
                while (node$iv$iv2 != null) {
                    if (kindSet$ui_release &= obj == 0) {
                        break loop_4;
                    } else {
                    }
                    $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                    i6 = count$iv$iv;
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    node$iv$iv = 0;
                    node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                    nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                    count$iv$iv = i6;
                    $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                    $i$f$visitAncestorsYYKmho = i2;
                    obj = obj2;
                    i7 = 0;
                    i3 = 0;
                    stack$iv$iv = 0;
                    int i16 = 0;
                    node$iv$iv3 = node$iv$iv4;
                    node$iv$iv = 0;
                    while (node$iv$iv3 != null) {
                        $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                        i6 = count$iv$iv;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        it = node$iv$iv3;
                        int i12 = 0;
                        i = it;
                        if (kindSet$ui_release2 &= type != 0) {
                        } else {
                        }
                        $i$f$isKindH91voCI$ui_release = 0;
                        if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        node$iv$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                        nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                        count$iv$iv = i6;
                        $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                        $i$f$visitAncestorsYYKmho = i2;
                        obj = obj2;
                        if (node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        $i$f$isKindH91voCI$ui_release = 0;
                        i = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            it = node$iv$iv$iv;
                            i9 = 0;
                            count$iv$iv2 = 0;
                            if (kindSet$ui_release3 &= type != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                            i2 = $i$f$visitAncestorsYYKmho;
                            obj2 = obj;
                            mask$iv$iv = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                            $i$f$visitAncestorsYYKmho = i2;
                            obj = obj2;
                            $i$f$isKindH91voCI$ui_release++;
                            $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                            if ($i$f$isKindH91voCI$ui_release == 1) {
                            } else {
                            }
                            if ((MutableVector)stack$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                            i2 = $i$f$visitAncestorsYYKmho;
                            obj2 = obj;
                            mask$iv$iv = 0;
                            stack$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node4 = node$iv$iv3;
                            int i14 = stack$iv$iv;
                            if ((Modifier.Node)node4 != null && (MutableVector)i14 != 0) {
                            }
                            $this$visitAncestors_u2dY_u2dYKmho$iv = stack$iv$iv;
                            if ((MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv != 0) {
                            }
                            $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                            (MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv.add(it);
                            i14 = stack$iv$iv;
                            if ((MutableVector)(MutableVector)i14 != 0) {
                            }
                            node$iv$iv3 = $i$f$mutableVectorOf;
                            (MutableVector)(MutableVector)i14.add((Modifier.Node)node4);
                            count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                            i4 = 0;
                            i8 = i13;
                            i2 = $i$f$visitAncestorsYYKmho;
                            obj2 = obj;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                            $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                            node$iv$iv3 = it;
                            i2 = $i$f$visitAncestorsYYKmho;
                            obj2 = obj;
                            mask$iv$iv = 0;
                            this_$iv$iv$iv = 1;
                        }
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                        count$iv$iv = i6;
                        $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                        $i$f$visitAncestorsYYKmho = i2;
                        obj = obj2;
                        it = node$iv$iv$iv;
                        i9 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                        $i$f$visitAncestorsYYKmho = i2;
                        obj = obj2;
                        $i$f$isKindH91voCI$ui_release++;
                        $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv3;
                        i14 = stack$iv$iv;
                        if ((Modifier.Node)node4 != null && (MutableVector)i14 != 0) {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho$iv = stack$iv$iv;
                        if ((MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv != 0) {
                        }
                        $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                        (MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv.add(it);
                        i14 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)i14 != 0) {
                        }
                        node$iv$iv3 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i14.add((Modifier.Node)node4);
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i4 = 0;
                        i8 = i13;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                        node$iv$iv3 = it;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        this_$iv$iv$iv = 1;
                        $i$f$isKindH91voCI$ui_release = 1;
                    }
                    $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                    i6 = count$iv$iv;
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                    i6 = count$iv$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    it = node$iv$iv3;
                    i12 = 0;
                    i = it;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    node$iv$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                    count$iv$iv = i6;
                    $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                    $i$f$visitAncestorsYYKmho = i2;
                    obj = obj2;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    i = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        it = node$iv$iv$iv;
                        i9 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                        $i$f$visitAncestorsYYKmho = i2;
                        obj = obj2;
                        $i$f$isKindH91voCI$ui_release++;
                        $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv3;
                        i14 = stack$iv$iv;
                        if ((Modifier.Node)node4 != null && (MutableVector)i14 != 0) {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho$iv = stack$iv$iv;
                        if ((MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv != 0) {
                        }
                        $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                        (MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv.add(it);
                        i14 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)i14 != 0) {
                        }
                        node$iv$iv3 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i14.add((Modifier.Node)node4);
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i4 = 0;
                        i8 = i13;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                        node$iv$iv3 = it;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        this_$iv$iv$iv = 1;
                    }
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                    count$iv$iv = i6;
                    $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                    $i$f$visitAncestorsYYKmho = i2;
                    obj = obj2;
                    it = node$iv$iv$iv;
                    i9 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                    $i$f$visitAncestorsYYKmho = i2;
                    obj = obj2;
                    $i$f$isKindH91voCI$ui_release++;
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv3;
                    i14 = stack$iv$iv;
                    if ((Modifier.Node)node4 != null && (MutableVector)i14 != 0) {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho$iv = stack$iv$iv;
                    if ((MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv != 0) {
                    }
                    $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                    (MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv.add(it);
                    i14 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)i14 != 0) {
                    }
                    node$iv$iv3 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i14.add((Modifier.Node)node4);
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i4 = 0;
                    i8 = i13;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                    node$iv$iv3 = it;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                i6 = count$iv$iv;
                $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                node$iv$iv = 0;
                if (kindSet$ui_release &= obj != 0) {
                } else {
                }
                $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                i6 = count$iv$iv;
                $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                node$iv$iv = 0;
                node$iv$iv2 = node$iv$iv2.getParent$ui_release();
                nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                count$iv$iv = i6;
                $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                $i$f$visitAncestorsYYKmho = i2;
                obj = obj2;
                i7 = 0;
                i3 = 0;
                stack$iv$iv = 0;
                i16 = 0;
                node$iv$iv3 = node$iv$iv4;
                node$iv$iv = 0;
                while (node$iv$iv3 != null) {
                    $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                    i6 = count$iv$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    it = node$iv$iv3;
                    i12 = 0;
                    i = it;
                    if (kindSet$ui_release2 &= type != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    node$iv$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                    nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                    count$iv$iv = i6;
                    $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                    $i$f$visitAncestorsYYKmho = i2;
                    obj = obj2;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    i = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        it = node$iv$iv$iv;
                        i9 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                        $i$f$visitAncestorsYYKmho = i2;
                        obj = obj2;
                        $i$f$isKindH91voCI$ui_release++;
                        $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                        if ($i$f$isKindH91voCI$ui_release == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv3;
                        i14 = stack$iv$iv;
                        if ((Modifier.Node)node4 != null && (MutableVector)i14 != 0) {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho$iv = stack$iv$iv;
                        if ((MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv != 0) {
                        }
                        $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                        (MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv.add(it);
                        i14 = stack$iv$iv;
                        if ((MutableVector)(MutableVector)i14 != 0) {
                        }
                        node$iv$iv3 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i14.add((Modifier.Node)node4);
                        count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                        i4 = 0;
                        i8 = i13;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                        node$iv$iv3 = it;
                        i2 = $i$f$visitAncestorsYYKmho;
                        obj2 = obj;
                        mask$iv$iv = 0;
                        this_$iv$iv$iv = 1;
                    }
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                    count$iv$iv = i6;
                    $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                    $i$f$visitAncestorsYYKmho = i2;
                    obj = obj2;
                    it = node$iv$iv$iv;
                    i9 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                    $i$f$visitAncestorsYYKmho = i2;
                    obj = obj2;
                    $i$f$isKindH91voCI$ui_release++;
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv3;
                    i14 = stack$iv$iv;
                    if ((Modifier.Node)node4 != null && (MutableVector)i14 != 0) {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho$iv = stack$iv$iv;
                    if ((MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv != 0) {
                    }
                    $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                    (MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv.add(it);
                    i14 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)i14 != 0) {
                    }
                    node$iv$iv3 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i14.add((Modifier.Node)node4);
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i4 = 0;
                    i8 = i13;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                    node$iv$iv3 = it;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                }
                $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                i6 = count$iv$iv;
                $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                $i$f$nearestAncestorIncludingSelf64DMado = nodes$ui_release;
                i6 = count$iv$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                it = node$iv$iv3;
                i12 = 0;
                i = it;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                node$iv$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv);
                nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                count$iv$iv = i6;
                $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                $i$f$visitAncestorsYYKmho = i2;
                obj = obj2;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                i = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    it = node$iv$iv$iv;
                    i9 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                    $i$f$visitAncestorsYYKmho = i2;
                    obj = obj2;
                    $i$f$isKindH91voCI$ui_release++;
                    $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                    if ($i$f$isKindH91voCI$ui_release == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv3;
                    i14 = stack$iv$iv;
                    if ((Modifier.Node)node4 != null && (MutableVector)i14 != 0) {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho$iv = stack$iv$iv;
                    if ((MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv != 0) {
                    }
                    $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                    (MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv.add(it);
                    i14 = stack$iv$iv;
                    if ((MutableVector)(MutableVector)i14 != 0) {
                    }
                    node$iv$iv3 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i14.add((Modifier.Node)node4);
                    count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                    i4 = 0;
                    i8 = i13;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                    node$iv$iv3 = it;
                    i2 = $i$f$visitAncestorsYYKmho;
                    obj2 = obj;
                    mask$iv$iv = 0;
                    this_$iv$iv$iv = 1;
                }
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                nodes$ui_release = $i$f$nearestAncestorIncludingSelf64DMado;
                count$iv$iv = i6;
                $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                $i$f$visitAncestorsYYKmho = i2;
                obj = obj2;
                it = node$iv$iv$iv;
                i9 = 0;
                count$iv$iv2 = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                mask$iv$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitAncestors_u2dY_u2dYKmho$iv = $this$visitAncestors_u2dY_u2dYKmho$iv2;
                $i$f$visitAncestorsYYKmho = i2;
                obj = obj2;
                $i$f$isKindH91voCI$ui_release++;
                $this$visitAncestors_u2dY_u2dYKmho$iv2 = $this$visitAncestors_u2dY_u2dYKmho$iv;
                if ($i$f$isKindH91voCI$ui_release == 1) {
                } else {
                }
                if ((MutableVector)stack$iv$iv == 0) {
                } else {
                }
                count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                mask$iv$iv = 0;
                stack$iv$iv = $i$f$mutableVectorOf;
                node4 = node$iv$iv3;
                i14 = stack$iv$iv;
                if ((Modifier.Node)node4 != null && (MutableVector)i14 != 0) {
                }
                $this$visitAncestors_u2dY_u2dYKmho$iv = stack$iv$iv;
                if ((MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv != 0) {
                }
                $i$f$isKindH91voCI$ui_release = count$iv$iv2;
                (MutableVector)$this$visitAncestors_u2dY_u2dYKmho$iv.add(it);
                i14 = stack$iv$iv;
                if ((MutableVector)(MutableVector)i14 != 0) {
                }
                node$iv$iv3 = $i$f$mutableVectorOf;
                (MutableVector)(MutableVector)i14.add((Modifier.Node)node4);
                count$iv$iv2 = $i$f$isKindH91voCI$ui_release;
                i4 = 0;
                i8 = i13;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                $i$f$isKindH91voCI$ui_release = $i$f$mutableVectorOf;
                node$iv$iv3 = it;
                i2 = $i$f$visitAncestorsYYKmho;
                obj2 = obj;
                mask$iv$iv = 0;
                this_$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
            }
            return 0;
        }
        int i18 = nodes$ui_release;
        int i19 = count$iv$iv;
        int $i$f$nearestAncestorIncludingSelf64DMado2 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    private final <T extends DelegatableNode> void traverseAncestorsIncludingSelf-QFhIj7k(DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k, int type, Function1<? super T, Unit> onPreVisit, Function0<Unit> onVisit, Function1<? super T, Unit> onPostVisit) {
        Modifier.Node mutableVector;
        Modifier.Node node2;
        int count$iv$iv$iv2;
        int tail$ui_release;
        int count$iv$iv$iv;
        int i7;
        int i10;
        int $i$f$dispatchForKind6rFNWt02;
        int $i$f$dispatchForKind6rFNWt0;
        int delegatableNode2;
        Modifier.Node $this$ancestors_u2d64DMado$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int index$iv;
        int $i$f$ancestors64DMado;
        int $i$f$mutableVectorOf;
        Modifier.Node node$iv;
        int result$iv;
        int count$iv;
        int delegatableNode;
        Modifier.Node node$iv2;
        int this_$iv$iv;
        int i2;
        int node$iv$iv2;
        DelegatableNode node$iv$iv;
        int i3;
        Modifier.Node node$iv$iv$iv2;
        LayoutNode layout$iv$iv$iv;
        String str;
        Modifier.Node node$iv$iv$iv3;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2;
        int ancestors;
        int i6;
        Modifier.Node node;
        Modifier.Node node3;
        int i8;
        int stack$iv$iv$iv;
        Modifier.Node node$iv$iv$iv;
        int $i$f$traverseAncestorsIncludingSelfQFhIj7k;
        int i4;
        int $this$ancestors_u2d64DMado$iv2;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node this_$iv$iv$iv$iv2;
        int i9;
        int $i$f$ancestors64DMado2;
        int this_$iv$iv$iv$iv;
        int count$iv$iv$iv3;
        int i12;
        int i;
        int i5;
        int i11;
        final Object obj = onPostVisit;
        $i$f$ancestors64DMado = 0;
        result$iv = 0;
        this_$iv$iv = 0;
        i2 = 0;
        node$iv$iv2 = type;
        node$iv$iv = delegatableNode;
        i3 = 0;
        if (!node$iv$iv.getNode().isAttached()) {
        } else {
            node$iv$iv$iv2 = node$iv$iv.getNode().getParent$ui_release();
            layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(node$iv$iv);
            str = "T";
            while (layout$iv$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= node$iv$iv2 != 0) {
                } else {
                }
                $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                count$iv$iv$iv2 = layout$iv$iv$iv.getNodes$ui_release();
                if (layout$iv$iv$iv != null && count$iv$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv$iv2 = tail$ui_release;
                count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                str = "T";
                count$iv$iv$iv2 = layout$iv$iv$iv.getNodes$ui_release();
                if (count$iv$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = count$iv$iv$iv2.getTail$ui_release();
                while (node$iv$iv$iv2 != null) {
                    if (kindSet$ui_release5 &= node$iv$iv2 != 0) {
                    } else {
                    }
                    $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                    $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getParent$ui_release();
                    count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                    delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    i6 = 0;
                    i8 = 0;
                    stack$iv$iv$iv = 0;
                    int i27 = 0;
                    node$iv$iv$iv3 = node$iv$iv$iv;
                    while (node$iv$iv$iv3 != null) {
                        $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                        Intrinsics.reifiedOperationMarker(3, str);
                        if (node$iv$iv$iv3 instanceof Object != null) {
                        } else {
                        }
                        $this$ancestors_u2d64DMado$iv = 0;
                        if (kindSet$ui_release6 &= type != 0) {
                        } else {
                        }
                        count$iv$iv$iv = 0;
                        if (count$iv$iv$iv != 0 && node$iv$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                        result$iv = i5;
                        node$iv$iv$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv$iv);
                        count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                        delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                        $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                        if (node$iv$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv$iv = 0;
                        i4 = 0;
                        node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv3.getDelegate$ui_release();
                        while (node$iv$iv$iv$iv != null) {
                            Modifier.Node this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                            i9 = 0;
                            count$iv$iv$iv3 = 0;
                            if (kindSet$ui_release7 &= type != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv = 0;
                            if (this_$iv$iv$iv$iv != 0) {
                            } else {
                            }
                            $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                            i5 = result$iv;
                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                            $this$ancestors_u2d64DMado$iv = this_$iv$iv$iv$iv2;
                            $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                            result$iv = i5;
                            count$iv$iv$iv++;
                            $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                            if (count$iv$iv$iv == 1) {
                            } else {
                            }
                            if ((MutableVector)stack$iv$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv$iv3 = count$iv$iv$iv;
                            i5 = result$iv;
                            stack$iv$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node5 = node$iv$iv$iv3;
                            int i17 = stack$iv$iv$iv;
                            if ((Modifier.Node)node5 != null && (MutableVector)i17 != 0) {
                            }
                            $i$f$ancestors64DMado = stack$iv$iv$iv;
                            if ((MutableVector)$i$f$ancestors64DMado != 0) {
                            }
                            count$iv$iv$iv = count$iv$iv$iv3;
                            (MutableVector)$i$f$ancestors64DMado.add(this_$iv$iv$iv$iv3);
                            i17 = stack$iv$iv$iv;
                            if ((MutableVector)(MutableVector)i17 != 0) {
                            }
                            node$iv$iv$iv3 = $i$f$mutableVectorOf;
                            (MutableVector)(MutableVector)i17.add((Modifier.Node)node5);
                            count$iv$iv$iv3 = count$iv$iv$iv;
                            int count$iv$iv$iv4 = 16;
                            i12 = 0;
                            i = i18;
                            i5 = result$iv;
                            i11 = count$iv$iv$iv4;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv$iv4], 0);
                            count$iv$iv$iv = $i$f$mutableVectorOf;
                            node$iv$iv$iv3 = this_$iv$iv$iv$iv3;
                            i5 = result$iv;
                            this_$iv$iv$iv$iv = 1;
                        }
                        this_$iv$iv$iv$iv2 = $this$ancestors_u2d64DMado$iv;
                        i5 = result$iv;
                        if (count$iv$iv$iv == 1) {
                        } else {
                        }
                        result$iv = i5;
                        count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                        delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                        $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                        result$iv = i5;
                        this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                        i9 = 0;
                        count$iv$iv$iv3 = 0;
                        if (kindSet$ui_release7 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                        i5 = result$iv;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$ancestors_u2d64DMado$iv = this_$iv$iv$iv$iv2;
                        $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                        result$iv = i5;
                        count$iv$iv$iv++;
                        $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                        if (count$iv$iv$iv == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        i5 = result$iv;
                        stack$iv$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv$iv3;
                        i17 = stack$iv$iv$iv;
                        if ((Modifier.Node)node5 != null && (MutableVector)i17 != 0) {
                        }
                        $i$f$ancestors64DMado = stack$iv$iv$iv;
                        if ((MutableVector)$i$f$ancestors64DMado != 0) {
                        }
                        count$iv$iv$iv = count$iv$iv$iv3;
                        (MutableVector)$i$f$ancestors64DMado.add(this_$iv$iv$iv$iv3);
                        i17 = stack$iv$iv$iv;
                        if ((MutableVector)(MutableVector)i17 != 0) {
                        }
                        node$iv$iv$iv3 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i17.add((Modifier.Node)node5);
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        count$iv$iv$iv4 = 16;
                        i12 = 0;
                        i = i18;
                        i5 = result$iv;
                        i11 = count$iv$iv$iv4;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv$iv4], 0);
                        count$iv$iv$iv = $i$f$mutableVectorOf;
                        node$iv$iv$iv3 = this_$iv$iv$iv$iv3;
                        i5 = result$iv;
                        this_$iv$iv$iv$iv = 1;
                        count$iv$iv$iv = 1;
                        i4 = 0;
                        if (result$iv == 0) {
                        }
                        $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                        (List)result$iv.add(node$iv$iv$iv3);
                        $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                        $this$ancestors_u2d64DMado$iv2 = new ArrayList();
                        result$iv = $this$ancestors_u2d64DMado$iv2;
                    }
                    $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                    $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    i5 = result$iv;
                    $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                    Intrinsics.reifiedOperationMarker(3, str);
                    if (node$iv$iv$iv3 instanceof Object != null) {
                    } else {
                    }
                    $this$ancestors_u2d64DMado$iv = 0;
                    if (kindSet$ui_release6 &= type != 0) {
                    } else {
                    }
                    count$iv$iv$iv = 0;
                    if (count$iv$iv$iv != 0 && node$iv$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    result$iv = i5;
                    node$iv$iv$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv$iv);
                    count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                    delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    if (node$iv$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv$iv = 0;
                    i4 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                        i9 = 0;
                        count$iv$iv$iv3 = 0;
                        if (kindSet$ui_release7 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                        i5 = result$iv;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$ancestors_u2d64DMado$iv = this_$iv$iv$iv$iv2;
                        $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                        result$iv = i5;
                        count$iv$iv$iv++;
                        $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                        if (count$iv$iv$iv == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        i5 = result$iv;
                        stack$iv$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv$iv3;
                        i17 = stack$iv$iv$iv;
                        if ((Modifier.Node)node5 != null && (MutableVector)i17 != 0) {
                        }
                        $i$f$ancestors64DMado = stack$iv$iv$iv;
                        if ((MutableVector)$i$f$ancestors64DMado != 0) {
                        }
                        count$iv$iv$iv = count$iv$iv$iv3;
                        (MutableVector)$i$f$ancestors64DMado.add(this_$iv$iv$iv$iv3);
                        i17 = stack$iv$iv$iv;
                        if ((MutableVector)(MutableVector)i17 != 0) {
                        }
                        node$iv$iv$iv3 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i17.add((Modifier.Node)node5);
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        count$iv$iv$iv4 = 16;
                        i12 = 0;
                        i = i18;
                        i5 = result$iv;
                        i11 = count$iv$iv$iv4;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv$iv4], 0);
                        count$iv$iv$iv = $i$f$mutableVectorOf;
                        node$iv$iv$iv3 = this_$iv$iv$iv$iv3;
                        i5 = result$iv;
                        this_$iv$iv$iv$iv = 1;
                    }
                    this_$iv$iv$iv$iv2 = $this$ancestors_u2d64DMado$iv;
                    i5 = result$iv;
                    if (count$iv$iv$iv == 1) {
                    } else {
                    }
                    result$iv = i5;
                    count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                    delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    result$iv = i5;
                    this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                    i9 = 0;
                    count$iv$iv$iv3 = 0;
                    if (kindSet$ui_release7 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    i5 = result$iv;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$ancestors_u2d64DMado$iv = this_$iv$iv$iv$iv2;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    result$iv = i5;
                    count$iv$iv$iv++;
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    if (count$iv$iv$iv == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    i5 = result$iv;
                    stack$iv$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv$iv3;
                    i17 = stack$iv$iv$iv;
                    if ((Modifier.Node)node5 != null && (MutableVector)i17 != 0) {
                    }
                    $i$f$ancestors64DMado = stack$iv$iv$iv;
                    if ((MutableVector)$i$f$ancestors64DMado != 0) {
                    }
                    count$iv$iv$iv = count$iv$iv$iv3;
                    (MutableVector)$i$f$ancestors64DMado.add(this_$iv$iv$iv$iv3);
                    i17 = stack$iv$iv$iv;
                    if ((MutableVector)(MutableVector)i17 != 0) {
                    }
                    node$iv$iv$iv3 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i17.add((Modifier.Node)node5);
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    count$iv$iv$iv4 = 16;
                    i12 = 0;
                    i = i18;
                    i5 = result$iv;
                    i11 = count$iv$iv$iv4;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv$iv4], 0);
                    count$iv$iv$iv = $i$f$mutableVectorOf;
                    node$iv$iv$iv3 = this_$iv$iv$iv$iv3;
                    i5 = result$iv;
                    this_$iv$iv$iv$iv = 1;
                    count$iv$iv$iv = 1;
                    i4 = 0;
                    if (result$iv == 0) {
                    }
                    $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                    (List)result$iv.add(node$iv$iv$iv3);
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    $this$ancestors_u2d64DMado$iv2 = new ArrayList();
                    result$iv = $this$ancestors_u2d64DMado$iv2;
                }
                $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                if (kindSet$ui_release5 &= node$iv$iv2 != 0) {
                } else {
                }
                $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                node$iv$iv$iv2 = node$iv$iv$iv2.getParent$ui_release();
                count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                i6 = 0;
                i8 = 0;
                stack$iv$iv$iv = 0;
                i27 = 0;
                node$iv$iv$iv3 = node$iv$iv$iv;
                while (node$iv$iv$iv3 != null) {
                    $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                    Intrinsics.reifiedOperationMarker(3, str);
                    if (node$iv$iv$iv3 instanceof Object != null) {
                    } else {
                    }
                    $this$ancestors_u2d64DMado$iv = 0;
                    if (kindSet$ui_release6 &= type != 0) {
                    } else {
                    }
                    count$iv$iv$iv = 0;
                    if (count$iv$iv$iv != 0 && node$iv$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    result$iv = i5;
                    node$iv$iv$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv$iv);
                    count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                    delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    if (node$iv$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv$iv = 0;
                    i4 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                        i9 = 0;
                        count$iv$iv$iv3 = 0;
                        if (kindSet$ui_release7 &= type != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                        i5 = result$iv;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$ancestors_u2d64DMado$iv = this_$iv$iv$iv$iv2;
                        $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                        result$iv = i5;
                        count$iv$iv$iv++;
                        $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                        if (count$iv$iv$iv == 1) {
                        } else {
                        }
                        if ((MutableVector)stack$iv$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        i5 = result$iv;
                        stack$iv$iv$iv = $i$f$mutableVectorOf;
                        node5 = node$iv$iv$iv3;
                        i17 = stack$iv$iv$iv;
                        if ((Modifier.Node)node5 != null && (MutableVector)i17 != 0) {
                        }
                        $i$f$ancestors64DMado = stack$iv$iv$iv;
                        if ((MutableVector)$i$f$ancestors64DMado != 0) {
                        }
                        count$iv$iv$iv = count$iv$iv$iv3;
                        (MutableVector)$i$f$ancestors64DMado.add(this_$iv$iv$iv$iv3);
                        i17 = stack$iv$iv$iv;
                        if ((MutableVector)(MutableVector)i17 != 0) {
                        }
                        node$iv$iv$iv3 = $i$f$mutableVectorOf;
                        (MutableVector)(MutableVector)i17.add((Modifier.Node)node5);
                        count$iv$iv$iv3 = count$iv$iv$iv;
                        count$iv$iv$iv4 = 16;
                        i12 = 0;
                        i = i18;
                        i5 = result$iv;
                        i11 = count$iv$iv$iv4;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv$iv4], 0);
                        count$iv$iv$iv = $i$f$mutableVectorOf;
                        node$iv$iv$iv3 = this_$iv$iv$iv$iv3;
                        i5 = result$iv;
                        this_$iv$iv$iv$iv = 1;
                    }
                    this_$iv$iv$iv$iv2 = $this$ancestors_u2d64DMado$iv;
                    i5 = result$iv;
                    if (count$iv$iv$iv == 1) {
                    } else {
                    }
                    result$iv = i5;
                    count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                    delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    result$iv = i5;
                    this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                    i9 = 0;
                    count$iv$iv$iv3 = 0;
                    if (kindSet$ui_release7 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    i5 = result$iv;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$ancestors_u2d64DMado$iv = this_$iv$iv$iv$iv2;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    result$iv = i5;
                    count$iv$iv$iv++;
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    if (count$iv$iv$iv == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    i5 = result$iv;
                    stack$iv$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv$iv3;
                    i17 = stack$iv$iv$iv;
                    if ((Modifier.Node)node5 != null && (MutableVector)i17 != 0) {
                    }
                    $i$f$ancestors64DMado = stack$iv$iv$iv;
                    if ((MutableVector)$i$f$ancestors64DMado != 0) {
                    }
                    count$iv$iv$iv = count$iv$iv$iv3;
                    (MutableVector)$i$f$ancestors64DMado.add(this_$iv$iv$iv$iv3);
                    i17 = stack$iv$iv$iv;
                    if ((MutableVector)(MutableVector)i17 != 0) {
                    }
                    node$iv$iv$iv3 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i17.add((Modifier.Node)node5);
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    count$iv$iv$iv4 = 16;
                    i12 = 0;
                    i = i18;
                    i5 = result$iv;
                    i11 = count$iv$iv$iv4;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv$iv4], 0);
                    count$iv$iv$iv = $i$f$mutableVectorOf;
                    node$iv$iv$iv3 = this_$iv$iv$iv$iv3;
                    i5 = result$iv;
                    this_$iv$iv$iv$iv = 1;
                    count$iv$iv$iv = 1;
                    i4 = 0;
                    if (result$iv == 0) {
                    }
                    $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                    (List)result$iv.add(node$iv$iv$iv3);
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    $this$ancestors_u2d64DMado$iv2 = new ArrayList();
                    result$iv = $this$ancestors_u2d64DMado$iv2;
                }
                $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                i5 = result$iv;
                $i$f$traverseAncestorsIncludingSelfQFhIj7k = count$iv$iv$iv2;
                Intrinsics.reifiedOperationMarker(3, str);
                if (node$iv$iv$iv3 instanceof Object != null) {
                } else {
                }
                $this$ancestors_u2d64DMado$iv = 0;
                if (kindSet$ui_release6 &= type != 0) {
                } else {
                }
                count$iv$iv$iv = 0;
                if (count$iv$iv$iv != 0 && node$iv$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                result$iv = i5;
                node$iv$iv$iv3 = DelegatableNodeKt.access$pop((MutableVector)stack$iv$iv$iv);
                count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                if (node$iv$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv$iv = 0;
                i4 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv$iv != null) {
                    this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                    i9 = 0;
                    count$iv$iv$iv3 = 0;
                    if (kindSet$ui_release7 &= type != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    i5 = result$iv;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$ancestors_u2d64DMado$iv = this_$iv$iv$iv$iv2;
                    $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                    result$iv = i5;
                    count$iv$iv$iv++;
                    $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                    if (count$iv$iv$iv == 1) {
                    } else {
                    }
                    if ((MutableVector)stack$iv$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    i5 = result$iv;
                    stack$iv$iv$iv = $i$f$mutableVectorOf;
                    node5 = node$iv$iv$iv3;
                    i17 = stack$iv$iv$iv;
                    if ((Modifier.Node)node5 != null && (MutableVector)i17 != 0) {
                    }
                    $i$f$ancestors64DMado = stack$iv$iv$iv;
                    if ((MutableVector)$i$f$ancestors64DMado != 0) {
                    }
                    count$iv$iv$iv = count$iv$iv$iv3;
                    (MutableVector)$i$f$ancestors64DMado.add(this_$iv$iv$iv$iv3);
                    i17 = stack$iv$iv$iv;
                    if ((MutableVector)(MutableVector)i17 != 0) {
                    }
                    node$iv$iv$iv3 = $i$f$mutableVectorOf;
                    (MutableVector)(MutableVector)i17.add((Modifier.Node)node5);
                    count$iv$iv$iv3 = count$iv$iv$iv;
                    count$iv$iv$iv4 = 16;
                    i12 = 0;
                    i = i18;
                    i5 = result$iv;
                    i11 = count$iv$iv$iv4;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv$iv4], 0);
                    count$iv$iv$iv = $i$f$mutableVectorOf;
                    node$iv$iv$iv3 = this_$iv$iv$iv$iv3;
                    i5 = result$iv;
                    this_$iv$iv$iv$iv = 1;
                }
                this_$iv$iv$iv$iv2 = $this$ancestors_u2d64DMado$iv;
                i5 = result$iv;
                if (count$iv$iv$iv == 1) {
                } else {
                }
                result$iv = i5;
                count$iv$iv$iv2 = $i$f$traverseAncestorsIncludingSelfQFhIj7k;
                delegatableNode2 = $this$ancestors_u2d64DMado$iv2;
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                result$iv = i5;
                this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                i9 = 0;
                count$iv$iv$iv3 = 0;
                if (kindSet$ui_release7 &= type != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                i5 = result$iv;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                $this$ancestors_u2d64DMado$iv = this_$iv$iv$iv$iv2;
                $i$f$ancestors64DMado = $i$f$ancestors64DMado2;
                result$iv = i5;
                count$iv$iv$iv++;
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                if (count$iv$iv$iv == 1) {
                } else {
                }
                if ((MutableVector)stack$iv$iv$iv == 0) {
                } else {
                }
                count$iv$iv$iv3 = count$iv$iv$iv;
                i5 = result$iv;
                stack$iv$iv$iv = $i$f$mutableVectorOf;
                node5 = node$iv$iv$iv3;
                i17 = stack$iv$iv$iv;
                if ((Modifier.Node)node5 != null && (MutableVector)i17 != 0) {
                }
                $i$f$ancestors64DMado = stack$iv$iv$iv;
                if ((MutableVector)$i$f$ancestors64DMado != 0) {
                }
                count$iv$iv$iv = count$iv$iv$iv3;
                (MutableVector)$i$f$ancestors64DMado.add(this_$iv$iv$iv$iv3);
                i17 = stack$iv$iv$iv;
                if ((MutableVector)(MutableVector)i17 != 0) {
                }
                node$iv$iv$iv3 = $i$f$mutableVectorOf;
                (MutableVector)(MutableVector)i17.add((Modifier.Node)node5);
                count$iv$iv$iv3 = count$iv$iv$iv;
                count$iv$iv$iv4 = 16;
                i12 = 0;
                i = i18;
                i5 = result$iv;
                i11 = count$iv$iv$iv4;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv$iv4], 0);
                count$iv$iv$iv = $i$f$mutableVectorOf;
                node$iv$iv$iv3 = this_$iv$iv$iv$iv3;
                i5 = result$iv;
                this_$iv$iv$iv$iv = 1;
                count$iv$iv$iv = 1;
                i4 = 0;
                if (result$iv == 0) {
                }
                $this$ancestors_u2d64DMado$iv2 = delegatableNode2;
                (List)result$iv.add(node$iv$iv$iv3);
                $i$f$ancestors64DMado2 = $i$f$ancestors64DMado;
                $this$ancestors_u2d64DMado$iv2 = new ArrayList();
                result$iv = $this$ancestors_u2d64DMado$iv2;
            }
            int $i$f$traverseAncestorsIncludingSelfQFhIj7k3 = count$iv$iv$iv2;
            int i28 = delegatableNode2;
            int i29 = $i$f$ancestors64DMado;
            i7 = result$iv;
            delegatableNode2 = i7;
            $i$f$ancestors64DMado = 0;
            if ((List)i7 != 0 && size-- >= 0) {
                delegatableNode2 = i7;
                $i$f$ancestors64DMado = 0;
                if (size-- >= 0) {
                }
            }
            int i19 = 0;
            count$iv = 0;
            int i21 = 0;
            node$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv;
            while (node$iv2 != null) {
                Intrinsics.reifiedOperationMarker(3, str);
                if (node$iv2 instanceof Object != null) {
                } else {
                }
                i2 = 0;
                if (kindSet$ui_release2 &= type != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0 && node$iv2 instanceof DelegatingNode) {
                } else {
                }
                ancestors = i7;
                i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                node$iv2 = DelegatableNodeKt.access$pop((MutableVector)count$iv);
                mutableVector = onPreVisit;
                i7 = ancestors;
                $this$dispatchForKind_u2d6rFNWt0$iv = i6;
                if (node$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv = 0;
                node$iv$iv2 = 0;
                node$iv$iv = (DelegatingNode)node$iv2.getDelegate$ui_release();
                while (node$iv$iv != null) {
                    i3 = node$iv$iv;
                    node$iv$iv$iv2 = null;
                    node$iv$iv$iv3 = 0;
                    if (kindSet$ui_release4 &= type != 0) {
                    } else {
                    }
                    layout$iv$iv$iv = 0;
                    if (layout$iv$iv$iv != 0) {
                    } else {
                    }
                    ancestors = i7;
                    i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    mutableVector = onPreVisit;
                    i7 = ancestors;
                    $this$dispatchForKind_u2d6rFNWt0$iv = i6;
                    if (this_$iv$iv++ == 1) {
                    } else {
                    }
                    if ((MutableVector)count$iv == 0) {
                    } else {
                    }
                    ancestors = i7;
                    i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                    count$iv = layout$iv$iv$iv;
                    mutableVector = node$iv2;
                    int i16 = count$iv;
                    if ((Modifier.Node)mutableVector != null && (MutableVector)i16 != 0) {
                    }
                    i7 = count$iv;
                    if ((MutableVector)i7 != 0) {
                    }
                    (MutableVector)i7.add(i3);
                    i16 = count$iv;
                    if ((MutableVector)(MutableVector)i16 != 0) {
                    }
                    node$iv2 = i7;
                    (MutableVector)(MutableVector)i16.add((Modifier.Node)mutableVector);
                    int i25 = 0;
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = 0;
                    ancestors = i7;
                    i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                    i7 = mutableVector;
                    layout$iv$iv$iv = mutableVector;
                    node$iv2 = i3;
                    ancestors = i7;
                    i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                    layout$iv$iv$iv = 1;
                }
                if (this_$iv$iv == 1) {
                } else {
                }
                mutableVector = onPreVisit;
                i7 = ancestors;
                $this$dispatchForKind_u2d6rFNWt0$iv = i6;
                i3 = node$iv$iv;
                node$iv$iv$iv2 = null;
                node$iv$iv$iv3 = 0;
                if (kindSet$ui_release4 &= type != 0) {
                } else {
                }
                layout$iv$iv$iv = 0;
                if (layout$iv$iv$iv != 0) {
                } else {
                }
                ancestors = i7;
                i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                mutableVector = onPreVisit;
                i7 = ancestors;
                $this$dispatchForKind_u2d6rFNWt0$iv = i6;
                if (this_$iv$iv++ == 1) {
                } else {
                }
                if ((MutableVector)count$iv == 0) {
                } else {
                }
                ancestors = i7;
                i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                count$iv = layout$iv$iv$iv;
                mutableVector = node$iv2;
                i16 = count$iv;
                if ((Modifier.Node)mutableVector != null && (MutableVector)i16 != 0) {
                }
                i7 = count$iv;
                if ((MutableVector)i7 != 0) {
                }
                (MutableVector)i7.add(i3);
                i16 = count$iv;
                if ((MutableVector)(MutableVector)i16 != 0) {
                }
                node$iv2 = i7;
                (MutableVector)(MutableVector)i16.add((Modifier.Node)mutableVector);
                i25 = 0;
                $this$dispatchForKind_u2d6rFNWt0$iv2 = 0;
                ancestors = i7;
                i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                i7 = mutableVector;
                layout$iv$iv$iv = mutableVector;
                node$iv2 = i3;
                ancestors = i7;
                i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                layout$iv$iv$iv = 1;
                this_$iv$iv = 1;
                mutableVector.invoke(node$iv2);
                ancestors = i7;
                i6 = $this$dispatchForKind_u2d6rFNWt0$iv;
            }
            int ancestors3 = i7;
            node = $this$dispatchForKind_u2d6rFNWt0$iv;
            onVisit.invoke();
            i10 = 0;
            index$iv = 0;
            int i20 = 0;
            node$iv = node2;
            while (node$iv != null) {
                Intrinsics.reifiedOperationMarker(3, str);
                if (node$iv instanceof Object != null) {
                } else {
                }
                node$iv2 = 0;
                if (kindSet$ui_release &= type != 0) {
                } else {
                }
                count$iv = 0;
                if (count$iv != 0 && node$iv instanceof DelegatingNode) {
                } else {
                }
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                node = i10;
                $i$f$dispatchForKind6rFNWt02 = 0;
                layout$iv$iv$iv = 1;
                node$iv = DelegatableNodeKt.access$pop((MutableVector)index$iv);
                node2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                i10 = node;
                if (node$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv = 0;
                i2 = 0;
                node$iv$iv2 = (DelegatingNode)node$iv.getDelegate$ui_release();
                while (node$iv$iv2 != 0) {
                    node$iv$iv = node$iv$iv2;
                    i3 = 0;
                    layout$iv$iv$iv = 0;
                    if (kindSet$ui_release3 &= type != 0) {
                    } else {
                    }
                    node$iv$iv$iv2 = 0;
                    if (node$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                    node = i10;
                    $i$f$dispatchForKind6rFNWt0 = 0;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    node2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                    i10 = node;
                    this_$iv$iv = 3;
                    if (count$iv++ == 1) {
                    } else {
                    }
                    if ((MutableVector)index$iv == 0) {
                    } else {
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                    node = i10;
                    $i$f$dispatchForKind6rFNWt0 = 0;
                    index$iv = node$iv$iv$iv2;
                    node2 = node$iv;
                    this_$iv$iv = index$iv;
                    if ((Modifier.Node)node2 != null && (MutableVector)this_$iv$iv != 0) {
                    }
                    this_$iv$iv = index$iv;
                    if ((MutableVector)this_$iv$iv != 0) {
                    }
                    (MutableVector)this_$iv$iv.add(node$iv$iv);
                    this_$iv$iv = index$iv;
                    if ((MutableVector)(MutableVector)this_$iv$iv != 0) {
                    }
                    node$iv = 0;
                    (MutableVector)(MutableVector)this_$iv$iv.add((Modifier.Node)node2);
                    int i23 = 0;
                    node$iv$iv$iv3 = 0;
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                    node = i10;
                    this_$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                    node2 = this_$iv$iv;
                    node$iv$iv$iv2 = this_$iv$iv;
                    node$iv = node$iv$iv;
                    $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                    node = i10;
                    $i$f$dispatchForKind6rFNWt0 = 0;
                    node$iv$iv$iv2 = 1;
                }
                $i$f$dispatchForKind6rFNWt02 = 0;
                if (count$iv == 1) {
                } else {
                }
                node2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                i10 = node;
                node$iv$iv = node$iv$iv2;
                i3 = 0;
                layout$iv$iv$iv = 0;
                if (kindSet$ui_release3 &= type != 0) {
                } else {
                }
                node$iv$iv$iv2 = 0;
                if (node$iv$iv$iv2 != 0) {
                } else {
                }
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                node = i10;
                $i$f$dispatchForKind6rFNWt0 = 0;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                node2 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                i10 = node;
                this_$iv$iv = 3;
                if (count$iv++ == 1) {
                } else {
                }
                if ((MutableVector)index$iv == 0) {
                } else {
                }
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                node = i10;
                $i$f$dispatchForKind6rFNWt0 = 0;
                index$iv = node$iv$iv$iv2;
                node2 = node$iv;
                this_$iv$iv = index$iv;
                if ((Modifier.Node)node2 != null && (MutableVector)this_$iv$iv != 0) {
                }
                this_$iv$iv = index$iv;
                if ((MutableVector)this_$iv$iv != 0) {
                }
                (MutableVector)this_$iv$iv.add(node$iv$iv);
                this_$iv$iv = index$iv;
                if ((MutableVector)(MutableVector)this_$iv$iv != 0) {
                }
                node$iv = 0;
                (MutableVector)(MutableVector)this_$iv$iv.add((Modifier.Node)node2);
                i23 = 0;
                node$iv$iv$iv3 = 0;
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                node = i10;
                this_$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                node2 = this_$iv$iv;
                node$iv$iv$iv2 = this_$iv$iv;
                node$iv = node$iv$iv;
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                node = i10;
                $i$f$dispatchForKind6rFNWt0 = 0;
                node$iv$iv$iv2 = 1;
                count$iv = 1;
                obj.invoke(node$iv);
                $this$dispatchForKind_u2d6rFNWt0$iv2 = node2;
                node = i10;
                $i$f$dispatchForKind6rFNWt02 = 0;
                layout$iv$iv$iv = 1;
            }
            Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv5 = node2;
            int i26 = i10;
            if (ancestors3 != 0) {
                node2 = ancestors3;
                i10 = 0;
                index$iv = 0;
                while (index$iv < node2.size()) {
                    obj.invoke(node2.get(index$iv));
                    index$iv++;
                }
            }
        }
        int $i$f$traverseAncestorsIncludingSelfQFhIj7k4 = count$iv$iv$iv2;
        int i14 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
    }

    private final boolean validateKeyEvent-ZmokQxo(KeyEvent keyEvent) {
        MutableLongSet keysCurrentlyDown2;
        int i;
        MutableLongSet keysCurrentlyDown;
        boolean keyUp-CS__XNY;
        int i2;
        final long key-ZmokQxo = KeyEvent_androidKt.getKey-ZmokQxo(keyEvent);
        int type-ZmokQxo = KeyEvent_androidKt.getType-ZmokQxo(keyEvent);
        final int i4 = 1;
        if (KeyEventType.equals-impl0(type-ZmokQxo, KeyEventType.Companion.getKeyDown-CS__XNY())) {
            if (this.keysCurrentlyDown == null) {
                keysCurrentlyDown2 = new MutableLongSet(3);
                i2 = 0;
                this.keysCurrentlyDown = keysCurrentlyDown2;
            }
            keysCurrentlyDown2.plusAssign(key-ZmokQxo);
        } else {
            if (KeyEventType.equals-impl0(type-ZmokQxo, KeyEventType.Companion.getKeyUp-CS__XNY())) {
                keysCurrentlyDown = this.keysCurrentlyDown;
                keyUp-CS__XNY = 0;
                if (keysCurrentlyDown != null && keysCurrentlyDown.contains(key-ZmokQxo) == i4) {
                    i = keysCurrentlyDown.contains(key-ZmokQxo) == i4 ? i4 : keyUp-CS__XNY;
                } else {
                }
                if (i == 0) {
                    return keyUp-CS__XNY;
                }
                keysCurrentlyDown2 = this.keysCurrentlyDown;
                if (keysCurrentlyDown2 != null) {
                    keysCurrentlyDown2.remove(key-ZmokQxo);
                }
            }
        }
        return i4;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearFocus(boolean force) {
        final int i = 1;
        clearFocus-I7lrPNg(force, i, i, FocusDirection.Companion.getExit-dhqQ-8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean clearFocus-I7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        Object focusTransactionManager;
        boolean z;
        int i2;
        int clearFocus;
        MutableVector $EnumSwitchMapping$0;
        int i;
        focusTransactionManager = getFocusTransactionManager();
        final androidx.compose.ui.focus.FocusOwnerImpl.clearFocus.clearedFocusSuccessfully.1 iNSTANCE = FocusOwnerImpl.clearFocus.clearedFocusSuccessfully.1.INSTANCE;
        final int i3 = 0;
        if (FocusTransactionManager.access$getOngoingTransaction$p(focusTransactionManager)) {
            FocusTransactionManager.access$cancelTransaction(focusTransactionManager);
        }
        FocusTransactionManager.access$beginTransaction(focusTransactionManager);
        if ((Function0)iNSTANCE != null) {
            i2 = 0;
            i = 0;
            FocusTransactionManager.access$getCancellationListener$p(focusTransactionManager).add((Function0)iNSTANCE);
        }
        int it$iv = 0;
        if (!force) {
            if (/* condition */) {
                clearFocus = 0;
            } else {
                clearFocus = FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents);
            }
        } else {
        }
        FocusTransactionManager.access$commitTransaction(focusTransactionManager);
        if (clearFocus != 0 && clearOwnerFocus) {
            try {
                if (clearOwnerFocus) {
                }
                this.onClearFocusForOwner.invoke();
                return clearFocus;
                FocusTransactionManager.access$commitTransaction(this_$iv);
                throw th;
                androidx.compose.ui.focus.FocusTransactionManager onCancelled$iv = this_$iv;
                androidx.compose.ui.focus.FocusTransactionManager this_$iv = this_$iv;
                this_$iv = this_$iv;
                this_$iv = this_$iv;
            }
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchInterceptedSoftKeyboardEvent-ZmokQxo(KeyEvent keyEvent) {
        Object capacity$iv$iv$iv$iv2;
        int count$iv$iv$iv$iv3;
        int count$iv$iv$iv$iv;
        int tail$ui_release;
        Modifier.Node capacity$iv$iv$iv$iv;
        int tail$ui_release2;
        androidx.compose.ui.focus.FocusTargetNode $i$f$dispatchForKind6rFNWt02;
        int $i$f$getSoftKeyboardKeyInputOLwlOKw;
        int $i$f$dispatchForKind6rFNWt0;
        Modifier.Node node$iv$iv$iv$iv2;
        Modifier.Node node$iv$iv$iv$iv;
        int stack$iv$iv;
        int index$iv$iv;
        int node$iv$iv$iv;
        int i5;
        int count$iv$iv$iv;
        int node$iv$iv$iv$iv4;
        Modifier.Node node$iv$iv;
        int i4;
        Modifier.Node next$iv$iv$iv;
        int count$iv$iv;
        Object obj;
        int result$iv$iv;
        int onInterceptKeyBeforeSoftKeyboard-ZmokQxo;
        androidx.compose.ui.focus.FocusTargetNode node$iv$iv$iv2;
        int i2;
        int i7;
        androidx.compose.ui.focus.FocusTargetNode this_$iv$iv$iv;
        int $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        int $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        Modifier.Node layout$iv$iv$iv$iv;
        LayoutNode layout$iv$iv$iv;
        int i10;
        Modifier.Node head$ui_release;
        Modifier.Node node4;
        int i;
        Modifier.Node node3;
        int i8;
        int node$iv$iv$iv$iv3;
        int $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
        int i6;
        int arrayList;
        Modifier.Node node$iv$iv$iv$iv$iv;
        Modifier.Node node2;
        int i9;
        int type$iv;
        int this_$iv$iv$iv$iv$iv;
        int i3;
        int count$iv$iv$iv$iv2;
        androidx.compose.ui.focus.FocusTargetNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
        int i11;
        Modifier.Node node5;
        int i12;
        Modifier.Node node;
        capacity$iv$iv$iv$iv2 = this;
        final KeyEvent keyEvent2 = keyEvent;
        if (capacity$iv$iv$iv$iv2.focusInvalidationManager.hasPendingInvalidation()) {
        } else {
            $i$f$dispatchForKind6rFNWt02 = FocusTraversalKt.findActiveFocusNode(capacity$iv$iv$iv$iv2.rootFocusNode);
            index$iv$iv = "visitAncestors called on an unattached node";
            node$iv$iv$iv = 131072;
            node$iv$iv$iv$iv4 = 0;
            i4 = 1;
            if ($i$f$dispatchForKind6rFNWt02 != null) {
                int i19 = 0;
                count$iv$iv = NodeKind.constructor-impl(node$iv$iv$iv);
                obj = this;
                result$iv$iv = 0;
                onInterceptKeyBeforeSoftKeyboard-ZmokQxo = 1;
                i2 = 0;
                i7 = count$iv$iv;
                this_$iv$iv$iv = node$iv$iv$iv2;
                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = 0;
                if (!this_$iv$iv$iv.getNode().isAttached()) {
                } else {
                    layout$iv$iv$iv$iv = this_$iv$iv$iv.getNode();
                    layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(this_$iv$iv$iv);
                    while (layout$iv$iv$iv != null) {
                        if (aggregateChildKindSet$ui_release2 &= i7 == 0) {
                            break;
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv;
                        layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                        capacity$iv$iv$iv$iv2 = layout$iv$iv$iv.getNodes$ui_release();
                        if (layout$iv$iv$iv != null && capacity$iv$iv$iv$iv2 != null) {
                        } else {
                        }
                        tail$ui_release2 = 0;
                        layout$iv$iv$iv$iv = tail$ui_release2;
                        i4 = 1;
                        capacity$iv$iv$iv$iv2 = this;
                        node$iv$iv$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        capacity$iv$iv$iv$iv2 = layout$iv$iv$iv.getNodes$ui_release();
                        if (capacity$iv$iv$iv$iv2 != null) {
                        } else {
                        }
                        tail$ui_release2 = capacity$iv$iv$iv$iv2.getTail$ui_release();
                        while (layout$iv$iv$iv$iv != null) {
                            if (kindSet$ui_release6 &= i7 == 0) {
                                break loop_6;
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv;
                            layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                            i4 = 1;
                            capacity$iv$iv$iv$iv2 = this;
                            node$iv$iv$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i = 0;
                            i8 = 0;
                            node$iv$iv$iv$iv3 = 0;
                            int i27 = 0;
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv;
                            node$iv$iv$iv = node;
                            while (node$iv$iv$iv != null) {
                                i6 = 0;
                                if (kindSet$ui_release8 &= count$iv$iv != 0) {
                                } else {
                                }
                                count$iv$iv$iv = node$iv$iv$iv$iv4;
                                if (count$iv$iv$iv != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                node$iv$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv3);
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i4 = 1;
                                if (node$iv$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv$iv = 0;
                                arrayList = 0;
                                node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv$iv != null) {
                                    node2 = node$iv$iv$iv$iv$iv;
                                    i9 = 0;
                                    i3 = 0;
                                    if (kindSet$ui_release9 &= count$iv$iv != 0) {
                                    } else {
                                    }
                                    type$iv = node$iv$iv$iv$iv4;
                                    if (type$iv != 0) {
                                    } else {
                                    }
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                    next$iv$iv$iv = node2;
                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                    capacity$iv$iv$iv$iv2 = this;
                                    $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                    i4 = 1;
                                    if (count$iv$iv$iv++ == i4) {
                                    } else {
                                    }
                                    if (node$iv$iv$iv$iv3 == 0) {
                                    } else {
                                    }
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                    capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                                    $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                                    if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                                    }
                                    if (capacity$iv$iv$iv$iv2 != 0) {
                                    } else {
                                    }
                                    next$iv$iv$iv = node2;
                                    node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv2.add(node2);
                                    if (capacity$iv$iv$iv$iv2 != 0) {
                                    }
                                    node$iv$iv$iv = 0;
                                    capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                                    type$iv = 0;
                                    count$iv$iv$iv$iv2 = 0;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                    capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv4);
                                    node$iv$iv$iv = node2;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                    next$iv$iv$iv = node2;
                                    type$iv = i4;
                                }
                                if (count$iv$iv$iv == 1) {
                                } else {
                                }
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i4 = 1;
                                node2 = node$iv$iv$iv$iv$iv;
                                i9 = 0;
                                i3 = 0;
                                if (kindSet$ui_release9 &= count$iv$iv != 0) {
                                } else {
                                }
                                type$iv = node$iv$iv$iv$iv4;
                                if (type$iv != 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node2;
                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i4 = 1;
                                if (count$iv$iv$iv++ == i4) {
                                } else {
                                }
                                if (node$iv$iv$iv$iv3 == 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                                $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                                if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                                }
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                } else {
                                }
                                next$iv$iv$iv = node2;
                                node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv2.add(node2);
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                }
                                node$iv$iv$iv = 0;
                                capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                                type$iv = 0;
                                count$iv$iv$iv$iv2 = 0;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv4);
                                node$iv$iv$iv = node2;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node2;
                                type$iv = i4;
                                count$iv$iv$iv = i4;
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            i6 = 0;
                            if (kindSet$ui_release8 &= count$iv$iv != 0) {
                            } else {
                            }
                            count$iv$iv$iv = node$iv$iv$iv$iv4;
                            if (count$iv$iv$iv != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            node$iv$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv3);
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i4 = 1;
                            if (node$iv$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            count$iv$iv$iv = 0;
                            arrayList = 0;
                            node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                            while (node$iv$iv$iv$iv$iv != null) {
                                node2 = node$iv$iv$iv$iv$iv;
                                i9 = 0;
                                i3 = 0;
                                if (kindSet$ui_release9 &= count$iv$iv != 0) {
                                } else {
                                }
                                type$iv = node$iv$iv$iv$iv4;
                                if (type$iv != 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node2;
                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i4 = 1;
                                if (count$iv$iv$iv++ == i4) {
                                } else {
                                }
                                if (node$iv$iv$iv$iv3 == 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                                $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                                if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                                }
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                } else {
                                }
                                next$iv$iv$iv = node2;
                                node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv2.add(node2);
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                }
                                node$iv$iv$iv = 0;
                                capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                                type$iv = 0;
                                count$iv$iv$iv$iv2 = 0;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv4);
                                node$iv$iv$iv = node2;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node2;
                                type$iv = i4;
                            }
                            if (count$iv$iv$iv == 1) {
                            } else {
                            }
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i4 = 1;
                            node2 = node$iv$iv$iv$iv$iv;
                            i9 = 0;
                            i3 = 0;
                            if (kindSet$ui_release9 &= count$iv$iv != 0) {
                            } else {
                            }
                            type$iv = node$iv$iv$iv$iv4;
                            if (type$iv != 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node2;
                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i4 = 1;
                            if (count$iv$iv$iv++ == i4) {
                            } else {
                            }
                            if (node$iv$iv$iv$iv3 == 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                            if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                            }
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node2;
                            node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                            capacity$iv$iv$iv$iv2.add(node2);
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            }
                            node$iv$iv$iv = 0;
                            capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                            type$iv = 0;
                            count$iv$iv$iv$iv2 = 0;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv4);
                            node$iv$iv$iv = node2;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node2;
                            type$iv = i4;
                            count$iv$iv$iv = i4;
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv;
                        if (kindSet$ui_release6 &= i7 == 0) {
                            break;
                        } else {
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv;
                        layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                        i4 = 1;
                        capacity$iv$iv$iv$iv2 = this;
                        node$iv$iv$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        i = 0;
                        i8 = 0;
                        node$iv$iv$iv$iv3 = 0;
                        i27 = 0;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv;
                        node$iv$iv$iv = node;
                        while (node$iv$iv$iv != null) {
                            i6 = 0;
                            if (kindSet$ui_release8 &= count$iv$iv != 0) {
                            } else {
                            }
                            count$iv$iv$iv = node$iv$iv$iv$iv4;
                            if (count$iv$iv$iv != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            node$iv$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv3);
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i4 = 1;
                            if (node$iv$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            count$iv$iv$iv = 0;
                            arrayList = 0;
                            node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                            while (node$iv$iv$iv$iv$iv != null) {
                                node2 = node$iv$iv$iv$iv$iv;
                                i9 = 0;
                                i3 = 0;
                                if (kindSet$ui_release9 &= count$iv$iv != 0) {
                                } else {
                                }
                                type$iv = node$iv$iv$iv$iv4;
                                if (type$iv != 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node2;
                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i4 = 1;
                                if (count$iv$iv$iv++ == i4) {
                                } else {
                                }
                                if (node$iv$iv$iv$iv3 == 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                                $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                                if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                                }
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                } else {
                                }
                                next$iv$iv$iv = node2;
                                node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv2.add(node2);
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                }
                                node$iv$iv$iv = 0;
                                capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                                type$iv = 0;
                                count$iv$iv$iv$iv2 = 0;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv4);
                                node$iv$iv$iv = node2;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node2;
                                type$iv = i4;
                            }
                            if (count$iv$iv$iv == 1) {
                            } else {
                            }
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i4 = 1;
                            node2 = node$iv$iv$iv$iv$iv;
                            i9 = 0;
                            i3 = 0;
                            if (kindSet$ui_release9 &= count$iv$iv != 0) {
                            } else {
                            }
                            type$iv = node$iv$iv$iv$iv4;
                            if (type$iv != 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node2;
                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i4 = 1;
                            if (count$iv$iv$iv++ == i4) {
                            } else {
                            }
                            if (node$iv$iv$iv$iv3 == 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                            if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                            }
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node2;
                            node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                            capacity$iv$iv$iv$iv2.add(node2);
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            }
                            node$iv$iv$iv = 0;
                            capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                            type$iv = 0;
                            count$iv$iv$iv$iv2 = 0;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv4);
                            node$iv$iv$iv = node2;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node2;
                            type$iv = i4;
                            count$iv$iv$iv = i4;
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        i6 = 0;
                        if (kindSet$ui_release8 &= count$iv$iv != 0) {
                        } else {
                        }
                        count$iv$iv$iv = node$iv$iv$iv$iv4;
                        if (count$iv$iv$iv != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        node$iv$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv3);
                        capacity$iv$iv$iv$iv2 = this;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        i4 = 1;
                        if (node$iv$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv$iv = 0;
                        arrayList = 0;
                        node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv$iv$iv;
                            i9 = 0;
                            i3 = 0;
                            if (kindSet$ui_release9 &= count$iv$iv != 0) {
                            } else {
                            }
                            type$iv = node$iv$iv$iv$iv4;
                            if (type$iv != 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node2;
                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i4 = 1;
                            if (count$iv$iv$iv++ == i4) {
                            } else {
                            }
                            if (node$iv$iv$iv$iv3 == 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                            if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                            }
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node2;
                            node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                            capacity$iv$iv$iv$iv2.add(node2);
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            }
                            node$iv$iv$iv = 0;
                            capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                            type$iv = 0;
                            count$iv$iv$iv$iv2 = 0;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv4);
                            node$iv$iv$iv = node2;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node2;
                            type$iv = i4;
                        }
                        if (count$iv$iv$iv == 1) {
                        } else {
                        }
                        capacity$iv$iv$iv$iv2 = this;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        i4 = 1;
                        node2 = node$iv$iv$iv$iv$iv;
                        i9 = 0;
                        i3 = 0;
                        if (kindSet$ui_release9 &= count$iv$iv != 0) {
                        } else {
                        }
                        type$iv = node$iv$iv$iv$iv4;
                        if (type$iv != 0) {
                        } else {
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        next$iv$iv$iv = node2;
                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                        capacity$iv$iv$iv$iv2 = this;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        i4 = 1;
                        if (count$iv$iv$iv++ == i4) {
                        } else {
                        }
                        if (node$iv$iv$iv$iv3 == 0) {
                        } else {
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                        $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                        if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                        }
                        if (capacity$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node2;
                        node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                        capacity$iv$iv$iv$iv2.add(node2);
                        if (capacity$iv$iv$iv$iv2 != 0) {
                        }
                        node$iv$iv$iv = 0;
                        capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                        type$iv = 0;
                        count$iv$iv$iv$iv2 = 0;
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv4);
                        node$iv$iv$iv = node2;
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        next$iv$iv$iv = node2;
                        type$iv = i4;
                        count$iv$iv$iv = i4;
                    }
                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv;
                    i5 = 0;
                    if (i5 != 0) {
                        count$iv$iv$iv$iv3 = i5;
                        int i15 = 0;
                        $i$f$getSoftKeyboardKeyInputOLwlOKw = NodeKind.constructor-impl($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv);
                        node$iv$iv$iv = this;
                        i4 = 0;
                        obj = 0;
                        result$iv$iv = 0;
                        node$iv$iv$iv2 = 0;
                        i2 = 0;
                        i7 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                        this_$iv$iv$iv = onInterceptKeyBeforeSoftKeyboard-ZmokQxo;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = 0;
                        if (!this_$iv$iv$iv.getNode().isAttached()) {
                        } else {
                            node$iv$iv$iv$iv2 = this_$iv$iv$iv.getNode().getParent$ui_release();
                            layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(this_$iv$iv$iv);
                            while (layout$iv$iv$iv$iv != null) {
                                if (aggregateChildKindSet$ui_release &= i7 != 0) {
                                } else {
                                }
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                                count$iv$iv$iv$iv3 = layout$iv$iv$iv$iv.getNodes$ui_release();
                                if (layout$iv$iv$iv$iv != null && count$iv$iv$iv$iv3 != null) {
                                } else {
                                }
                                tail$ui_release = 0;
                                node$iv$iv$iv$iv2 = tail$ui_release;
                                count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv4 = 0;
                                count$iv$iv$iv$iv3 = layout$iv$iv$iv$iv.getNodes$ui_release();
                                if (count$iv$iv$iv$iv3 != null) {
                                } else {
                                }
                                tail$ui_release = count$iv$iv$iv$iv3.getTail$ui_release();
                                while (node$iv$iv$iv$iv2 != null) {
                                    if (kindSet$ui_release5 &= i7 != 0) {
                                    } else {
                                    }
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv2 = node5.getParent$ui_release();
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv4 = 0;
                                    node4 = 0;
                                    node3 = 0;
                                    i8 = 0;
                                    int i24 = 0;
                                    node$iv$iv$iv$iv4 = node$iv$iv$iv$iv3;
                                    while (node$iv$iv$iv$iv4 != null) {
                                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                        if (node$iv$iv$iv$iv4 instanceof SoftKeyboardInterceptionModifierNode) {
                                        } else {
                                        }
                                        i6 = 0;
                                        if (kindSet$ui_release7 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv = 0;
                                        if (count$iv$iv$iv$iv != 0 && node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                        } else {
                                        }
                                        type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        node5 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv4 = DelegatableNodeKt.access$pop(i8);
                                        count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv2 = node5;
                                        if (node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv = 0;
                                        arrayList = 0;
                                        node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv4.getDelegate$ui_release();
                                        while (node$iv$iv$iv$iv$iv != null) {
                                            node2 = node$iv$iv$iv$iv$iv;
                                            i9 = 0;
                                            count$iv$iv$iv$iv2 = 0;
                                            if (kindSet$ui_release10 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv$iv = 0;
                                            if (this_$iv$iv$iv$iv$iv != 0) {
                                            } else {
                                            }
                                            type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                            node5 = node$iv$iv$iv$iv2;
                                            node$iv$iv$iv$iv = node2;
                                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                            $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                            node$iv$iv$iv$iv2 = node5;
                                            count$iv$iv$iv$iv++;
                                            type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                            if (count$iv$iv$iv$iv == 1) {
                                            } else {
                                            }
                                            if (i8 == 0) {
                                            } else {
                                            }
                                            count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                            node5 = node$iv$iv$iv$iv2;
                                            $i$f$getSoftKeyboardKeyInputOLwlOKw = i8;
                                            Modifier.Node node7 = node$iv$iv$iv$iv4;
                                            if (node7 != null && $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                            }
                                            if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv$iv = node2;
                                            i8 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                            count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                            $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node2);
                                            if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                            }
                                            node$iv$iv$iv$iv4 = node$iv$iv$iv$iv2;
                                            $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node7);
                                            count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                            int count$iv$iv$iv$iv4 = 16;
                                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                            i11 = i16;
                                            node5 = node$iv$iv$iv$iv2;
                                            i12 = count$iv$iv$iv$iv4;
                                            $i$f$getSoftKeyboardKeyInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                            node$iv$iv$iv$iv4 = node2;
                                            node5 = node$iv$iv$iv$iv2;
                                            node$iv$iv$iv$iv = node2;
                                            this_$iv$iv$iv$iv$iv = 1;
                                        }
                                        if (count$iv$iv$iv$iv == 1) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv2 = node5;
                                        node2 = node$iv$iv$iv$iv$iv;
                                        i9 = 0;
                                        count$iv$iv$iv$iv2 = 0;
                                        if (kindSet$ui_release10 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv$iv = 0;
                                        if (this_$iv$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        node5 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv = node2;
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv2 = node5;
                                        count$iv$iv$iv$iv++;
                                        type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        if (count$iv$iv$iv$iv == 1) {
                                        } else {
                                        }
                                        if (i8 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        node5 = node$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = i8;
                                        node7 = node$iv$iv$iv$iv4;
                                        if (node7 != null && $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        }
                                        if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        node$iv$iv$iv$iv = node2;
                                        i8 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node2);
                                        if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        }
                                        node$iv$iv$iv$iv4 = node$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node7);
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        count$iv$iv$iv$iv4 = 16;
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                        i11 = i16;
                                        node5 = node$iv$iv$iv$iv2;
                                        i12 = count$iv$iv$iv$iv4;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                        node$iv$iv$iv$iv4 = node2;
                                        node5 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv = node2;
                                        this_$iv$iv$iv$iv$iv = 1;
                                        count$iv$iv$iv$iv = 1;
                                        i6 = 0;
                                        if (result$iv$iv == 0) {
                                        }
                                        result$iv$iv.add(node$iv$iv$iv$iv4);
                                        type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        node5 = node$iv$iv$iv$iv2;
                                        arrayList = new ArrayList();
                                        result$iv$iv = arrayList;
                                    }
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                    if (node$iv$iv$iv$iv4 instanceof SoftKeyboardInterceptionModifierNode) {
                                    } else {
                                    }
                                    i6 = 0;
                                    if (kindSet$ui_release7 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv = 0;
                                    if (count$iv$iv$iv$iv != 0 && node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv4 = DelegatableNodeKt.access$pop(i8);
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv2 = node5;
                                    if (node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv = 0;
                                    arrayList = 0;
                                    node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv4.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        node2 = node$iv$iv$iv$iv$iv;
                                        i9 = 0;
                                        count$iv$iv$iv$iv2 = 0;
                                        if (kindSet$ui_release10 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv$iv = 0;
                                        if (this_$iv$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        node5 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv = node2;
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv2 = node5;
                                        count$iv$iv$iv$iv++;
                                        type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        if (count$iv$iv$iv$iv == 1) {
                                        } else {
                                        }
                                        if (i8 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        node5 = node$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = i8;
                                        node7 = node$iv$iv$iv$iv4;
                                        if (node7 != null && $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        }
                                        if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        node$iv$iv$iv$iv = node2;
                                        i8 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node2);
                                        if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        }
                                        node$iv$iv$iv$iv4 = node$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node7);
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        count$iv$iv$iv$iv4 = 16;
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                        i11 = i16;
                                        node5 = node$iv$iv$iv$iv2;
                                        i12 = count$iv$iv$iv$iv4;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                        node$iv$iv$iv$iv4 = node2;
                                        node5 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv = node2;
                                        this_$iv$iv$iv$iv$iv = 1;
                                    }
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv2 = node5;
                                    node2 = node$iv$iv$iv$iv$iv;
                                    i9 = 0;
                                    count$iv$iv$iv$iv2 = 0;
                                    if (kindSet$ui_release10 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv = node2;
                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv2 = node5;
                                    count$iv$iv$iv$iv++;
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    if (i8 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    node5 = node$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = i8;
                                    node7 = node$iv$iv$iv$iv4;
                                    if (node7 != null && $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    }
                                    if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    node$iv$iv$iv$iv = node2;
                                    i8 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node2);
                                    if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    }
                                    node$iv$iv$iv$iv4 = node$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node7);
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    count$iv$iv$iv$iv4 = 16;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                    i11 = i16;
                                    node5 = node$iv$iv$iv$iv2;
                                    i12 = count$iv$iv$iv$iv4;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                    node$iv$iv$iv$iv4 = node2;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv = node2;
                                    this_$iv$iv$iv$iv$iv = 1;
                                    count$iv$iv$iv$iv = 1;
                                    i6 = 0;
                                    if (result$iv$iv == 0) {
                                    }
                                    result$iv$iv.add(node$iv$iv$iv$iv4);
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    arrayList = new ArrayList();
                                    result$iv$iv = arrayList;
                                }
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                node5 = node$iv$iv$iv$iv2;
                                if (kindSet$ui_release5 &= i7 != 0) {
                                } else {
                                }
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                node5 = node$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv2 = node5.getParent$ui_release();
                                count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv4 = 0;
                                node4 = 0;
                                node3 = 0;
                                i8 = 0;
                                i24 = 0;
                                node$iv$iv$iv$iv4 = node$iv$iv$iv$iv3;
                                while (node$iv$iv$iv$iv4 != null) {
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                    if (node$iv$iv$iv$iv4 instanceof SoftKeyboardInterceptionModifierNode) {
                                    } else {
                                    }
                                    i6 = 0;
                                    if (kindSet$ui_release7 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv = 0;
                                    if (count$iv$iv$iv$iv != 0 && node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv4 = DelegatableNodeKt.access$pop(i8);
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv2 = node5;
                                    if (node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv = 0;
                                    arrayList = 0;
                                    node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv4.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        node2 = node$iv$iv$iv$iv$iv;
                                        i9 = 0;
                                        count$iv$iv$iv$iv2 = 0;
                                        if (kindSet$ui_release10 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv$iv = 0;
                                        if (this_$iv$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        node5 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv = node2;
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv2 = node5;
                                        count$iv$iv$iv$iv++;
                                        type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        if (count$iv$iv$iv$iv == 1) {
                                        } else {
                                        }
                                        if (i8 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        node5 = node$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = i8;
                                        node7 = node$iv$iv$iv$iv4;
                                        if (node7 != null && $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        }
                                        if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        node$iv$iv$iv$iv = node2;
                                        i8 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                        count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node2);
                                        if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                        }
                                        node$iv$iv$iv$iv4 = node$iv$iv$iv$iv2;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node7);
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        count$iv$iv$iv$iv4 = 16;
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                        i11 = i16;
                                        node5 = node$iv$iv$iv$iv2;
                                        i12 = count$iv$iv$iv$iv4;
                                        $i$f$getSoftKeyboardKeyInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                        node$iv$iv$iv$iv4 = node2;
                                        node5 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv = node2;
                                        this_$iv$iv$iv$iv$iv = 1;
                                    }
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv2 = node5;
                                    node2 = node$iv$iv$iv$iv$iv;
                                    i9 = 0;
                                    count$iv$iv$iv$iv2 = 0;
                                    if (kindSet$ui_release10 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv = node2;
                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv2 = node5;
                                    count$iv$iv$iv$iv++;
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    if (i8 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    node5 = node$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = i8;
                                    node7 = node$iv$iv$iv$iv4;
                                    if (node7 != null && $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    }
                                    if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    node$iv$iv$iv$iv = node2;
                                    i8 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node2);
                                    if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    }
                                    node$iv$iv$iv$iv4 = node$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node7);
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    count$iv$iv$iv$iv4 = 16;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                    i11 = i16;
                                    node5 = node$iv$iv$iv$iv2;
                                    i12 = count$iv$iv$iv$iv4;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                    node$iv$iv$iv$iv4 = node2;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv = node2;
                                    this_$iv$iv$iv$iv$iv = 1;
                                    count$iv$iv$iv$iv = 1;
                                    i6 = 0;
                                    if (result$iv$iv == 0) {
                                    }
                                    result$iv$iv.add(node$iv$iv$iv$iv4);
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    arrayList = new ArrayList();
                                    result$iv$iv = arrayList;
                                }
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                node5 = node$iv$iv$iv$iv2;
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                if (node$iv$iv$iv$iv4 instanceof SoftKeyboardInterceptionModifierNode) {
                                } else {
                                }
                                i6 = 0;
                                if (kindSet$ui_release7 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv$iv$iv = 0;
                                if (count$iv$iv$iv$iv != 0 && node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                } else {
                                }
                                type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                node5 = node$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv4 = DelegatableNodeKt.access$pop(i8);
                                count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv2 = node5;
                                if (node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv$iv$iv = 0;
                                arrayList = 0;
                                node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv4.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv$iv != null) {
                                    node2 = node$iv$iv$iv$iv$iv;
                                    i9 = 0;
                                    count$iv$iv$iv$iv2 = 0;
                                    if (kindSet$ui_release10 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv = node2;
                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv2 = node5;
                                    count$iv$iv$iv$iv++;
                                    type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    if (i8 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    node5 = node$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = i8;
                                    node7 = node$iv$iv$iv$iv4;
                                    if (node7 != null && $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    }
                                    if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    node$iv$iv$iv$iv = node2;
                                    i8 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node2);
                                    if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                    }
                                    node$iv$iv$iv$iv4 = node$iv$iv$iv$iv2;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node7);
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    count$iv$iv$iv$iv4 = 16;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                    i11 = i16;
                                    node5 = node$iv$iv$iv$iv2;
                                    i12 = count$iv$iv$iv$iv4;
                                    $i$f$getSoftKeyboardKeyInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                    node$iv$iv$iv$iv4 = node2;
                                    node5 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv = node2;
                                    this_$iv$iv$iv$iv$iv = 1;
                                }
                                if (count$iv$iv$iv$iv == 1) {
                                } else {
                                }
                                count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv2 = node5;
                                node2 = node$iv$iv$iv$iv$iv;
                                i9 = 0;
                                count$iv$iv$iv$iv2 = 0;
                                if (kindSet$ui_release10 &= $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv$iv = 0;
                                if (this_$iv$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                node5 = node$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv = node2;
                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                $i$f$getSoftKeyboardKeyInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv2 = node5;
                                count$iv$iv$iv$iv++;
                                type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                if (count$iv$iv$iv$iv == 1) {
                                } else {
                                }
                                if (i8 == 0) {
                                } else {
                                }
                                count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                node5 = node$iv$iv$iv$iv2;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw = i8;
                                node7 = node$iv$iv$iv$iv4;
                                if (node7 != null && $i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                }
                                if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                } else {
                                }
                                node$iv$iv$iv$iv = node2;
                                i8 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node2);
                                if ($i$f$getSoftKeyboardKeyInputOLwlOKw != 0) {
                                }
                                node$iv$iv$iv$iv4 = node$iv$iv$iv$iv2;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw.add(node7);
                                count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                count$iv$iv$iv$iv4 = 16;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                i11 = i16;
                                node5 = node$iv$iv$iv$iv2;
                                i12 = count$iv$iv$iv$iv4;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                node$iv$iv$iv$iv4 = node2;
                                node5 = node$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv = node2;
                                this_$iv$iv$iv$iv$iv = 1;
                                count$iv$iv$iv$iv = 1;
                                i6 = 0;
                                if (result$iv$iv == 0) {
                                }
                                result$iv$iv.add(node$iv$iv$iv$iv4);
                                type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                                node5 = node$iv$iv$iv$iv2;
                                arrayList = new ArrayList();
                                result$iv$iv = arrayList;
                            }
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                            type$iv = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                            count$iv$iv$iv$iv3 = result$iv$iv;
                            $i$f$getSoftKeyboardKeyInputOLwlOKw = 0;
                            if (result$iv$iv != 0 && size-- >= 0) {
                                count$iv$iv$iv$iv3 = result$iv$iv;
                                $i$f$getSoftKeyboardKeyInputOLwlOKw = 0;
                                if (size-- >= 0) {
                                }
                            }
                            $i$f$dispatchForKind6rFNWt0 = 0;
                            stack$iv$iv = 0;
                            int i17 = 0;
                            node$iv$iv = capacity$iv$iv$iv$iv;
                            while (node$iv$iv != null) {
                                obj = 0;
                                if (kindSet$ui_release2 &= type$iv != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                                capacity$iv$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                $i$f$dispatchForKind6rFNWt0 = layout$iv$iv$iv;
                                if (node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv = 0;
                                onInterceptKeyBeforeSoftKeyboard-ZmokQxo = 0;
                                node$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv2 != 0) {
                                    i2 = node$iv$iv$iv2;
                                    i7 = 0;
                                    int i23 = 0;
                                    if (kindSet$ui_release4 &= type$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                    layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    head$ui_release = stack$iv$iv;
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                    capacity$iv$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                    $i$f$dispatchForKind6rFNWt0 = layout$iv$iv$iv;
                                    if (count$iv$iv++ == 1) {
                                    } else {
                                    }
                                    if (stack$iv$iv == 0) {
                                    } else {
                                    }
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                    layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    $i$f$dispatchForKind6rFNWt0 = head$ui_release;
                                    stack$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    capacity$iv$iv$iv$iv = node$iv$iv;
                                    if (capacity$iv$iv$iv$iv != null && stack$iv$iv != 0) {
                                    }
                                    if (stack$iv$iv != 0) {
                                    }
                                    stack$iv$iv.add(i2);
                                    if (stack$iv$iv != 0) {
                                    }
                                    node$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    stack$iv$iv.add(capacity$iv$iv$iv$iv);
                                    this_$iv$iv$iv = 0;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                    int $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = 16;
                                    layout$iv$iv$iv$iv = 0;
                                    layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    head$ui_release = stack$iv$iv;
                                    node4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[$this$dispatchForKind_u2d6rFNWt0$iv$iv6], 0);
                                    node$iv$iv = i2;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                    layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    this_$iv$iv$iv = 1;
                                }
                                head$ui_release = stack$iv$iv;
                                if (count$iv$iv == 1) {
                                } else {
                                }
                                stack$iv$iv = head$ui_release;
                                capacity$iv$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                $i$f$dispatchForKind6rFNWt0 = layout$iv$iv$iv;
                                stack$iv$iv = head$ui_release;
                                i2 = node$iv$iv$iv2;
                                i7 = 0;
                                i23 = 0;
                                if (kindSet$ui_release4 &= type$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv = 0;
                                if (this_$iv$iv$iv != 0) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                head$ui_release = stack$iv$iv;
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                capacity$iv$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                $i$f$dispatchForKind6rFNWt0 = layout$iv$iv$iv;
                                if (count$iv$iv++ == 1) {
                                } else {
                                }
                                if (stack$iv$iv == 0) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                $i$f$dispatchForKind6rFNWt0 = head$ui_release;
                                stack$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                capacity$iv$iv$iv$iv = node$iv$iv;
                                if (capacity$iv$iv$iv$iv != null && stack$iv$iv != 0) {
                                }
                                if (stack$iv$iv != 0) {
                                }
                                stack$iv$iv.add(i2);
                                if (stack$iv$iv != 0) {
                                }
                                node$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                stack$iv$iv.add(capacity$iv$iv$iv$iv);
                                this_$iv$iv$iv = 0;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = 16;
                                layout$iv$iv$iv$iv = 0;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                head$ui_release = stack$iv$iv;
                                node4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[$this$dispatchForKind_u2d6rFNWt0$iv$iv6], 0);
                                node$iv$iv = i2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                this_$iv$iv$iv = 1;
                                count$iv$iv = 1;
                                obj = 0;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                            }
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                            i10 = $i$f$dispatchForKind6rFNWt0;
                            int $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = 0;
                            $i$f$dispatchForKind6rFNWt02 = 0;
                            index$iv$iv = 0;
                            int i18 = 0;
                            node$iv$iv$iv$iv4 = capacity$iv$iv$iv$iv2;
                            while (node$iv$iv$iv$iv4 != null) {
                                obj = 0;
                                if (kindSet$ui_release &= type$iv != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0 && node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                i10 = $i$f$dispatchForKind6rFNWt02;
                                node$iv$iv$iv$iv4 = DelegatableNodeKt.access$pop(index$iv$iv);
                                capacity$iv$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                $i$f$dispatchForKind6rFNWt02 = i10;
                                if (node$iv$iv$iv$iv4 instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv = 0;
                                onInterceptKeyBeforeSoftKeyboard-ZmokQxo = 0;
                                node$iv$iv$iv2 = (DelegatingNode)node$iv$iv$iv$iv4.getDelegate$ui_release();
                                while (node$iv$iv$iv2 != 0) {
                                    i2 = node$iv$iv$iv2;
                                    i7 = 0;
                                    int i22 = 0;
                                    if (kindSet$ui_release3 &= type$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                    i10 = $i$f$dispatchForKind6rFNWt02;
                                    head$ui_release = index$iv$iv;
                                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                    capacity$iv$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                    $i$f$dispatchForKind6rFNWt02 = i10;
                                    if (count$iv$iv++ == 1) {
                                    } else {
                                    }
                                    if (index$iv$iv == 0) {
                                    } else {
                                    }
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                    i10 = $i$f$dispatchForKind6rFNWt02;
                                    $i$f$dispatchForKind6rFNWt02 = head$ui_release;
                                    index$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                    capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv4;
                                    if (capacity$iv$iv$iv$iv2 != null && index$iv$iv != 0) {
                                    }
                                    if (index$iv$iv != 0) {
                                    }
                                    index$iv$iv.add(i2);
                                    if (index$iv$iv != 0) {
                                    }
                                    node$iv$iv$iv$iv4 = $i$f$dispatchForKind6rFNWt02;
                                    index$iv$iv.add(capacity$iv$iv$iv$iv2);
                                    this_$iv$iv$iv = 0;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                    int $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = 16;
                                    layout$iv$iv$iv$iv = 0;
                                    i10 = $i$f$dispatchForKind6rFNWt02;
                                    head$ui_release = index$iv$iv;
                                    node4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                    $i$f$dispatchForKind6rFNWt02 = new MutableVector(new Modifier.Node[$this$dispatchForKind_u2d6rFNWt0$iv$iv5], 0);
                                    node$iv$iv$iv$iv4 = i2;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                    i10 = $i$f$dispatchForKind6rFNWt02;
                                    this_$iv$iv$iv = 1;
                                }
                                head$ui_release = index$iv$iv;
                                if (count$iv$iv == 1) {
                                } else {
                                }
                                index$iv$iv = head$ui_release;
                                capacity$iv$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                $i$f$dispatchForKind6rFNWt02 = i10;
                                index$iv$iv = head$ui_release;
                                i2 = node$iv$iv$iv2;
                                i7 = 0;
                                i22 = 0;
                                if (kindSet$ui_release3 &= type$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv = 0;
                                if (this_$iv$iv$iv != 0) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                i10 = $i$f$dispatchForKind6rFNWt02;
                                head$ui_release = index$iv$iv;
                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                                capacity$iv$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                $i$f$dispatchForKind6rFNWt02 = i10;
                                if (count$iv$iv++ == 1) {
                                } else {
                                }
                                if (index$iv$iv == 0) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                i10 = $i$f$dispatchForKind6rFNWt02;
                                $i$f$dispatchForKind6rFNWt02 = head$ui_release;
                                index$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv4;
                                if (capacity$iv$iv$iv$iv2 != null && index$iv$iv != 0) {
                                }
                                if (index$iv$iv != 0) {
                                }
                                index$iv$iv.add(i2);
                                if (index$iv$iv != 0) {
                                }
                                node$iv$iv$iv$iv4 = $i$f$dispatchForKind6rFNWt02;
                                index$iv$iv.add(capacity$iv$iv$iv$iv2);
                                this_$iv$iv$iv = 0;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = 16;
                                layout$iv$iv$iv$iv = 0;
                                i10 = $i$f$dispatchForKind6rFNWt02;
                                head$ui_release = index$iv$iv;
                                node4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                $i$f$dispatchForKind6rFNWt02 = new MutableVector(new Modifier.Node[$this$dispatchForKind_u2d6rFNWt0$iv$iv5], 0);
                                node$iv$iv$iv$iv4 = i2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                i10 = $i$f$dispatchForKind6rFNWt02;
                                this_$iv$iv$iv = 1;
                                count$iv$iv = 1;
                                obj = 0;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv2;
                                i10 = $i$f$dispatchForKind6rFNWt02;
                            }
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                            layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                            if (result$iv$iv != 0) {
                                capacity$iv$iv$iv$iv2 = result$iv$iv;
                                $i$f$dispatchForKind6rFNWt02 = 0;
                                index$iv$iv = 0;
                                while (index$iv$iv < capacity$iv$iv$iv$iv2.size()) {
                                    onInterceptKeyBeforeSoftKeyboard-ZmokQxo = 0;
                                    i3 = 1;
                                    index$iv$iv++;
                                }
                            }
                        }
                        int i26 = count$iv$iv$iv$iv3;
                        int i28 = $i$f$getSoftKeyboardKeyInputOLwlOKw;
                        int $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3 = 0;
                        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv$iv = new IllegalStateException(index$iv$iv.toString());
                        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv$iv;
                    }
                    return 0;
                }
                androidx.compose.ui.focus.FocusTargetNode focusTargetNode = $i$f$dispatchForKind6rFNWt02;
                int i14 = 0;
                IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException(index$iv$iv.toString());
                throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
            }
            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv;
            i5 = 0;
        }
        int i13 = 0;
        IllegalStateException $i$a$CheckFocusOwnerImpl$dispatchInterceptedSoftKeyboardEvent$1 = new IllegalStateException("Dispatching intercepted soft keyboard event while focus system is invalidated.".toString());
        throw $i$a$CheckFocusOwnerImpl$dispatchInterceptedSoftKeyboardEvent$1;
    }

    public boolean dispatchKeyEvent-YhN2O0w(KeyEvent keyEvent, Function0<Boolean> onFocusedItem) {
        Object count$iv$iv$iv;
        int $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
        int node$iv$iv$iv$iv4;
        int tail$ui_release3;
        Modifier.Node node3;
        Modifier.Node $this$fastForEach$iv$iv;
        int $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        int $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        int this_$iv$iv$iv$iv3;
        int tail$ui_release;
        androidx.compose.ui.focus.FocusTargetNode $i$f$dispatchForKind6rFNWt0;
        int $i$f$getKeyInputOLwlOKw;
        int count$iv$iv$iv$iv2;
        int count$iv$iv$iv$iv;
        int $i$f$dispatchForKind6rFNWt02;
        int tail$ui_release2;
        Modifier.Node index$iv$iv;
        Object this_$iv2;
        Modifier.Node next$iv$iv$iv$iv;
        int stack$iv$iv;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node node$iv$iv$iv5;
        int $i$f$getKeyInputOLwlOKw2;
        int node$iv$iv;
        int i6;
        Modifier.Node node$iv$iv2;
        Modifier.Node count$iv$iv;
        int result$iv$iv;
        Modifier.Node next$iv$iv$iv;
        int lastLocalKeyInputNode;
        int $i$f$getKeyInputOLwlOKw3;
        androidx.compose.ui.focus.FocusTargetNode onPreKeyEvent-ZmokQxo;
        int node$iv$iv$iv3;
        Modifier.Node node$iv$iv$iv4;
        Object layout$iv$iv$iv;
        int this_$iv$iv$iv;
        Modifier.Node node$iv$iv$iv$iv5;
        int layout$iv$iv$iv$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        int node$iv$iv$iv;
        int i7;
        int node$iv$iv$iv8;
        Modifier.Node node$iv$iv$iv6;
        Modifier.Node node$iv$iv$iv7;
        int i4;
        int i5;
        Modifier.Node node$iv$iv$iv$iv;
        int $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
        int type$iv;
        int node$iv$iv$iv9;
        int $this$nearestAncestor_u2d64DMado$iv;
        int this_$iv$iv$iv$iv2;
        int node$iv$iv$iv$iv$iv;
        Modifier.Node node$iv$iv$iv$iv2;
        Modifier.Node node2;
        int node$iv$iv$iv$iv3;
        int this_$iv$iv$iv$iv$iv;
        Modifier.Node node;
        int this_$iv$iv$iv$iv;
        int i;
        int i3;
        androidx.compose.ui.focus.FocusTargetNode activeFocusTarget;
        androidx.compose.ui.focus.FocusTargetNode activeFocusTarget2;
        String count$iv$iv$iv$iv3;
        String str;
        Object this_$iv;
        int i2;
        Modifier.Node node4;
        count$iv$iv$iv = this;
        final KeyEvent keyEvent2 = keyEvent;
        if (count$iv$iv$iv.focusInvalidationManager.hasPendingInvalidation()) {
        } else {
            index$iv$iv = 0;
            if (!validateKeyEvent-ZmokQxo(keyEvent)) {
                return index$iv$iv;
            }
            $i$f$dispatchForKind6rFNWt0 = FocusTraversalKt.findActiveFocusNode(count$iv$iv$iv.rootFocusNode);
            $i$f$getKeyInputOLwlOKw2 = "visitAncestors called on an unattached node";
            node$iv$iv = 8192;
            result$iv$iv = 1;
            if ($i$f$dispatchForKind6rFNWt0 != null) {
                if (count$iv$iv$iv.lastLocalKeyInputNode((DelegatableNode)$i$f$dispatchForKind6rFNWt0) == null) {
                    if ($i$f$dispatchForKind6rFNWt0 != null) {
                        int i19 = 0;
                        $i$f$getKeyInputOLwlOKw3 = NodeKind.constructor-impl(node$iv$iv);
                        onPreKeyEvent-ZmokQxo = this;
                        node$iv$iv$iv3 = 0;
                        node$iv$iv$iv4 = 1;
                        this_$iv$iv$iv = 0;
                        node$iv$iv$iv$iv5 = $i$f$getKeyInputOLwlOKw3;
                        layout$iv$iv$iv$iv = layout$iv$iv$iv;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = 0;
                        if (!layout$iv$iv$iv$iv.getNode().isAttached()) {
                        } else {
                            node$iv$iv$iv = layout$iv$iv$iv$iv.getNode();
                            node$iv$iv$iv8 = DelegatableNodeKt.requireLayoutNode(layout$iv$iv$iv$iv);
                            while (node$iv$iv$iv8 != null) {
                                if (aggregateChildKindSet$ui_release3 &= node$iv$iv$iv$iv5 == 0) {
                                    break;
                                }
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                node$iv$iv$iv9 = node$iv$iv;
                                node$iv$iv$iv8 = node$iv$iv$iv8.getParent$ui_release();
                                $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8.getNodes$ui_release();
                                if (node$iv$iv$iv8 != null && $i$f$dispatchForKind6rFNWt0 != null) {
                                } else {
                                }
                                tail$ui_release2 = 0;
                                node$iv$iv$iv = tail$ui_release2;
                                node$iv$iv = node$iv$iv$iv9;
                                $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                $i$f$getKeyInputOLwlOKw2 = str;
                                result$iv$iv = 1;
                                $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8.getNodes$ui_release();
                                if ($i$f$dispatchForKind6rFNWt0 != null) {
                                } else {
                                }
                                tail$ui_release2 = $i$f$dispatchForKind6rFNWt0.getTail$ui_release();
                                while (node$iv$iv$iv != null) {
                                    if (kindSet$ui_release7 &= node$iv$iv$iv$iv5 == 0) {
                                        break loop_12;
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    node$iv$iv$iv9 = node$iv$iv;
                                    node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                                    node$iv$iv = node$iv$iv$iv9;
                                    $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                    $i$f$getKeyInputOLwlOKw2 = str;
                                    result$iv$iv = 1;
                                    i5 = 0;
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = 0;
                                    type$iv = 0;
                                    int i27 = 0;
                                    node$iv$iv$iv9 = node$iv$iv;
                                    node$iv$iv = node4;
                                    while (node$iv$iv != null) {
                                        $this$nearestAncestor_u2d64DMado$iv = 0;
                                        if (kindSet$ui_release10 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                        } else {
                                        }
                                        count$iv$iv = index$iv$iv;
                                        if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                        } else {
                                        }
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        node$iv$iv = DelegatableNodeKt.access$pop(type$iv);
                                        $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                        $i$f$getKeyInputOLwlOKw2 = str;
                                        result$iv$iv = 1;
                                        if (node$iv$iv instanceof DelegatingNode) {
                                        } else {
                                        }
                                        count$iv$iv = 0;
                                        node$iv$iv$iv$iv$iv = 0;
                                        node$iv$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                        while (node$iv$iv$iv$iv2 != null) {
                                            node2 = node$iv$iv$iv$iv2;
                                            node$iv$iv$iv$iv3 = 0;
                                            i = 0;
                                            if (kindSet$ui_release13 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv = index$iv$iv;
                                            if (this_$iv$iv$iv$iv != 0) {
                                            } else {
                                            }
                                            activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                            str = $i$f$getKeyInputOLwlOKw2;
                                            next$iv$iv$iv = node2;
                                            node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                            $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                            $i$f$getKeyInputOLwlOKw2 = str;
                                            result$iv$iv = 1;
                                            if (count$iv$iv++ == result$iv$iv) {
                                            } else {
                                            }
                                            if (type$iv == 0) {
                                            } else {
                                            }
                                            activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                            str = $i$f$getKeyInputOLwlOKw2;
                                            $i$f$dispatchForKind6rFNWt0 = type$iv;
                                            $i$f$getKeyInputOLwlOKw2 = node$iv$iv;
                                            if ($i$f$getKeyInputOLwlOKw2 != null && $i$f$dispatchForKind6rFNWt0 != 0) {
                                            }
                                            if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                            } else {
                                            }
                                            next$iv$iv$iv = node2;
                                            type$iv = $i$f$dispatchForKind6rFNWt0;
                                            Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node2));
                                            if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                            }
                                            node$iv$iv = 0;
                                            Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($i$f$getKeyInputOLwlOKw2));
                                            this_$iv$iv$iv$iv = 0;
                                            i3 = 0;
                                            activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                            str = $i$f$getKeyInputOLwlOKw2;
                                            $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[16], index$iv$iv);
                                            node$iv$iv = node2;
                                            activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                            str = $i$f$getKeyInputOLwlOKw2;
                                            next$iv$iv$iv = node2;
                                            this_$iv$iv$iv$iv = result$iv$iv;
                                        }
                                        if (count$iv$iv == 1) {
                                        } else {
                                        }
                                        $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                        $i$f$getKeyInputOLwlOKw2 = str;
                                        result$iv$iv = 1;
                                        node2 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv3 = 0;
                                        i = 0;
                                        if (kindSet$ui_release13 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv = index$iv$iv;
                                        if (this_$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        next$iv$iv$iv = node2;
                                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                        $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                        $i$f$getKeyInputOLwlOKw2 = str;
                                        result$iv$iv = 1;
                                        if (count$iv$iv++ == result$iv$iv) {
                                        } else {
                                        }
                                        if (type$iv == 0) {
                                        } else {
                                        }
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        $i$f$dispatchForKind6rFNWt0 = type$iv;
                                        $i$f$getKeyInputOLwlOKw2 = node$iv$iv;
                                        if ($i$f$getKeyInputOLwlOKw2 != null && $i$f$dispatchForKind6rFNWt0 != 0) {
                                        }
                                        if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                        } else {
                                        }
                                        next$iv$iv$iv = node2;
                                        type$iv = $i$f$dispatchForKind6rFNWt0;
                                        Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node2));
                                        if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                        }
                                        node$iv$iv = 0;
                                        Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($i$f$getKeyInputOLwlOKw2));
                                        this_$iv$iv$iv$iv = 0;
                                        i3 = 0;
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[16], index$iv$iv);
                                        node$iv$iv = node2;
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        next$iv$iv$iv = node2;
                                        this_$iv$iv$iv$iv = result$iv$iv;
                                        count$iv$iv = result$iv$iv;
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    $this$nearestAncestor_u2d64DMado$iv = 0;
                                    if (kindSet$ui_release10 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                    } else {
                                    }
                                    count$iv$iv = index$iv$iv;
                                    if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    node$iv$iv = DelegatableNodeKt.access$pop(type$iv);
                                    $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                    $i$f$getKeyInputOLwlOKw2 = str;
                                    result$iv$iv = 1;
                                    if (node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    node$iv$iv$iv$iv$iv = 0;
                                    node$iv$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv2 != null) {
                                        node2 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv3 = 0;
                                        i = 0;
                                        if (kindSet$ui_release13 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv = index$iv$iv;
                                        if (this_$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        next$iv$iv$iv = node2;
                                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                        $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                        $i$f$getKeyInputOLwlOKw2 = str;
                                        result$iv$iv = 1;
                                        if (count$iv$iv++ == result$iv$iv) {
                                        } else {
                                        }
                                        if (type$iv == 0) {
                                        } else {
                                        }
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        $i$f$dispatchForKind6rFNWt0 = type$iv;
                                        $i$f$getKeyInputOLwlOKw2 = node$iv$iv;
                                        if ($i$f$getKeyInputOLwlOKw2 != null && $i$f$dispatchForKind6rFNWt0 != 0) {
                                        }
                                        if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                        } else {
                                        }
                                        next$iv$iv$iv = node2;
                                        type$iv = $i$f$dispatchForKind6rFNWt0;
                                        Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node2));
                                        if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                        }
                                        node$iv$iv = 0;
                                        Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($i$f$getKeyInputOLwlOKw2));
                                        this_$iv$iv$iv$iv = 0;
                                        i3 = 0;
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[16], index$iv$iv);
                                        node$iv$iv = node2;
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        next$iv$iv$iv = node2;
                                        this_$iv$iv$iv$iv = result$iv$iv;
                                    }
                                    if (count$iv$iv == 1) {
                                    } else {
                                    }
                                    $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                    $i$f$getKeyInputOLwlOKw2 = str;
                                    result$iv$iv = 1;
                                    node2 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv3 = 0;
                                    i = 0;
                                    if (kindSet$ui_release13 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = index$iv$iv;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    next$iv$iv$iv = node2;
                                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                    $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                    $i$f$getKeyInputOLwlOKw2 = str;
                                    result$iv$iv = 1;
                                    if (count$iv$iv++ == result$iv$iv) {
                                    } else {
                                    }
                                    if (type$iv == 0) {
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    $i$f$dispatchForKind6rFNWt0 = type$iv;
                                    $i$f$getKeyInputOLwlOKw2 = node$iv$iv;
                                    if ($i$f$getKeyInputOLwlOKw2 != null && $i$f$dispatchForKind6rFNWt0 != 0) {
                                    }
                                    if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                    } else {
                                    }
                                    next$iv$iv$iv = node2;
                                    type$iv = $i$f$dispatchForKind6rFNWt0;
                                    Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node2));
                                    if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                    }
                                    node$iv$iv = 0;
                                    Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($i$f$getKeyInputOLwlOKw2));
                                    this_$iv$iv$iv$iv = 0;
                                    i3 = 0;
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[16], index$iv$iv);
                                    node$iv$iv = node2;
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    next$iv$iv$iv = node2;
                                    this_$iv$iv$iv$iv = result$iv$iv;
                                    count$iv$iv = result$iv$iv;
                                }
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                node$iv$iv$iv9 = node$iv$iv;
                                if (kindSet$ui_release7 &= node$iv$iv$iv$iv5 == 0) {
                                    break;
                                } else {
                                }
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                node$iv$iv$iv9 = node$iv$iv;
                                node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                                node$iv$iv = node$iv$iv$iv9;
                                $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                $i$f$getKeyInputOLwlOKw2 = str;
                                result$iv$iv = 1;
                                i5 = 0;
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = 0;
                                type$iv = 0;
                                i27 = 0;
                                node$iv$iv$iv9 = node$iv$iv;
                                node$iv$iv = node4;
                                while (node$iv$iv != null) {
                                    $this$nearestAncestor_u2d64DMado$iv = 0;
                                    if (kindSet$ui_release10 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                    } else {
                                    }
                                    count$iv$iv = index$iv$iv;
                                    if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    node$iv$iv = DelegatableNodeKt.access$pop(type$iv);
                                    $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                    $i$f$getKeyInputOLwlOKw2 = str;
                                    result$iv$iv = 1;
                                    if (node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    node$iv$iv$iv$iv$iv = 0;
                                    node$iv$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv2 != null) {
                                        node2 = node$iv$iv$iv$iv2;
                                        node$iv$iv$iv$iv3 = 0;
                                        i = 0;
                                        if (kindSet$ui_release13 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv = index$iv$iv;
                                        if (this_$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        next$iv$iv$iv = node2;
                                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                        $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                        $i$f$getKeyInputOLwlOKw2 = str;
                                        result$iv$iv = 1;
                                        if (count$iv$iv++ == result$iv$iv) {
                                        } else {
                                        }
                                        if (type$iv == 0) {
                                        } else {
                                        }
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        $i$f$dispatchForKind6rFNWt0 = type$iv;
                                        $i$f$getKeyInputOLwlOKw2 = node$iv$iv;
                                        if ($i$f$getKeyInputOLwlOKw2 != null && $i$f$dispatchForKind6rFNWt0 != 0) {
                                        }
                                        if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                        } else {
                                        }
                                        next$iv$iv$iv = node2;
                                        type$iv = $i$f$dispatchForKind6rFNWt0;
                                        Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node2));
                                        if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                        }
                                        node$iv$iv = 0;
                                        Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($i$f$getKeyInputOLwlOKw2));
                                        this_$iv$iv$iv$iv = 0;
                                        i3 = 0;
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[16], index$iv$iv);
                                        node$iv$iv = node2;
                                        activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                        str = $i$f$getKeyInputOLwlOKw2;
                                        next$iv$iv$iv = node2;
                                        this_$iv$iv$iv$iv = result$iv$iv;
                                    }
                                    if (count$iv$iv == 1) {
                                    } else {
                                    }
                                    $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                    $i$f$getKeyInputOLwlOKw2 = str;
                                    result$iv$iv = 1;
                                    node2 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv3 = 0;
                                    i = 0;
                                    if (kindSet$ui_release13 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = index$iv$iv;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    next$iv$iv$iv = node2;
                                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                    $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                    $i$f$getKeyInputOLwlOKw2 = str;
                                    result$iv$iv = 1;
                                    if (count$iv$iv++ == result$iv$iv) {
                                    } else {
                                    }
                                    if (type$iv == 0) {
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    $i$f$dispatchForKind6rFNWt0 = type$iv;
                                    $i$f$getKeyInputOLwlOKw2 = node$iv$iv;
                                    if ($i$f$getKeyInputOLwlOKw2 != null && $i$f$dispatchForKind6rFNWt0 != 0) {
                                    }
                                    if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                    } else {
                                    }
                                    next$iv$iv$iv = node2;
                                    type$iv = $i$f$dispatchForKind6rFNWt0;
                                    Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node2));
                                    if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                    }
                                    node$iv$iv = 0;
                                    Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($i$f$getKeyInputOLwlOKw2));
                                    this_$iv$iv$iv$iv = 0;
                                    i3 = 0;
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[16], index$iv$iv);
                                    node$iv$iv = node2;
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    next$iv$iv$iv = node2;
                                    this_$iv$iv$iv$iv = result$iv$iv;
                                    count$iv$iv = result$iv$iv;
                                }
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                $this$nearestAncestor_u2d64DMado$iv = 0;
                                if (kindSet$ui_release10 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                } else {
                                }
                                count$iv$iv = index$iv$iv;
                                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                node$iv$iv = DelegatableNodeKt.access$pop(type$iv);
                                $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                $i$f$getKeyInputOLwlOKw2 = str;
                                result$iv$iv = 1;
                                if (node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv = 0;
                                node$iv$iv$iv$iv$iv = 0;
                                node$iv$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv2 != null) {
                                    node2 = node$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv3 = 0;
                                    i = 0;
                                    if (kindSet$ui_release13 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = index$iv$iv;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    next$iv$iv$iv = node2;
                                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                    $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                    $i$f$getKeyInputOLwlOKw2 = str;
                                    result$iv$iv = 1;
                                    if (count$iv$iv++ == result$iv$iv) {
                                    } else {
                                    }
                                    if (type$iv == 0) {
                                    } else {
                                    }
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    $i$f$dispatchForKind6rFNWt0 = type$iv;
                                    $i$f$getKeyInputOLwlOKw2 = node$iv$iv;
                                    if ($i$f$getKeyInputOLwlOKw2 != null && $i$f$dispatchForKind6rFNWt0 != 0) {
                                    }
                                    if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                    } else {
                                    }
                                    next$iv$iv$iv = node2;
                                    type$iv = $i$f$dispatchForKind6rFNWt0;
                                    Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node2));
                                    if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                    }
                                    node$iv$iv = 0;
                                    Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($i$f$getKeyInputOLwlOKw2));
                                    this_$iv$iv$iv$iv = 0;
                                    i3 = 0;
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[16], index$iv$iv);
                                    node$iv$iv = node2;
                                    activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                    str = $i$f$getKeyInputOLwlOKw2;
                                    next$iv$iv$iv = node2;
                                    this_$iv$iv$iv$iv = result$iv$iv;
                                }
                                if (count$iv$iv == 1) {
                                } else {
                                }
                                $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                $i$f$getKeyInputOLwlOKw2 = str;
                                result$iv$iv = 1;
                                node2 = node$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv3 = 0;
                                i = 0;
                                if (kindSet$ui_release13 &= $i$f$getKeyInputOLwlOKw3 != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = index$iv$iv;
                                if (this_$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                next$iv$iv$iv = node2;
                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                                $i$f$dispatchForKind6rFNWt0 = activeFocusTarget2;
                                $i$f$getKeyInputOLwlOKw2 = str;
                                result$iv$iv = 1;
                                if (count$iv$iv++ == result$iv$iv) {
                                } else {
                                }
                                if (type$iv == 0) {
                                } else {
                                }
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                $i$f$dispatchForKind6rFNWt0 = type$iv;
                                $i$f$getKeyInputOLwlOKw2 = node$iv$iv;
                                if ($i$f$getKeyInputOLwlOKw2 != null && $i$f$dispatchForKind6rFNWt0 != 0) {
                                }
                                if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                } else {
                                }
                                next$iv$iv$iv = node2;
                                type$iv = $i$f$dispatchForKind6rFNWt0;
                                Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node2));
                                if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                }
                                node$iv$iv = 0;
                                Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($i$f$getKeyInputOLwlOKw2));
                                this_$iv$iv$iv$iv = 0;
                                i3 = 0;
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[16], index$iv$iv);
                                node$iv$iv = node2;
                                activeFocusTarget2 = $i$f$dispatchForKind6rFNWt0;
                                str = $i$f$getKeyInputOLwlOKw2;
                                next$iv$iv$iv = node2;
                                this_$iv$iv$iv$iv = result$iv$iv;
                                count$iv$iv = result$iv$iv;
                            }
                            activeFocusTarget = $i$f$dispatchForKind6rFNWt0;
                            count$iv$iv$iv$iv3 = $i$f$getKeyInputOLwlOKw2;
                            node$iv$iv$iv9 = node$iv$iv;
                            count$iv$iv = 0;
                            if ((KeyInputModifierNode)count$iv$iv != null) {
                                lastLocalKeyInputNode = (KeyInputModifierNode)count$iv$iv.getNode();
                                if (lastLocalKeyInputNode != 0) {
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = lastLocalKeyInputNode;
                                    int i13 = 0;
                                    $i$f$getKeyInputOLwlOKw = NodeKind.constructor-impl(node$iv$iv$iv9);
                                    this_$iv2 = this;
                                    $i$f$getKeyInputOLwlOKw2 = 0;
                                    count$iv$iv = 0;
                                    result$iv$iv = 0;
                                    onPreKeyEvent-ZmokQxo = 0;
                                    node$iv$iv$iv3 = 0;
                                    node$iv$iv$iv4 = $i$f$getKeyInputOLwlOKw;
                                    layout$iv$iv$iv = $i$f$getKeyInputOLwlOKw3;
                                    this_$iv$iv$iv = 0;
                                    if (!layout$iv$iv$iv.getNode().isAttached()) {
                                    } else {
                                        node$iv$iv$iv$iv5 = layout$iv$iv$iv.getNode().getParent$ui_release();
                                        layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(layout$iv$iv$iv);
                                        while (layout$iv$iv$iv$iv != null) {
                                            if (aggregateChildKindSet$ui_release2 &= node$iv$iv$iv4 != 0) {
                                            } else {
                                            }
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                            type$iv = $i$f$getKeyInputOLwlOKw;
                                            this_$iv = this_$iv2;
                                            layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = layout$iv$iv$iv$iv.getNodes$ui_release();
                                            if (layout$iv$iv$iv$iv != null && $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 != null) {
                                            } else {
                                            }
                                            tail$ui_release3 = 0;
                                            node$iv$iv$iv$iv5 = tail$ui_release3;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                            $i$f$getKeyInputOLwlOKw = type$iv;
                                            this_$iv2 = this_$iv;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = layout$iv$iv$iv$iv.getNodes$ui_release();
                                            if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 != null) {
                                            } else {
                                            }
                                            tail$ui_release3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getTail$ui_release();
                                            while (node$iv$iv$iv$iv5 != null) {
                                                if (kindSet$ui_release6 &= node$iv$iv$iv4 != 0) {
                                                } else {
                                                }
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                type$iv = $i$f$getKeyInputOLwlOKw;
                                                this_$iv = this_$iv2;
                                                node$iv$iv$iv$iv5 = node$iv$iv$iv$iv5.getParent$ui_release();
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                $i$f$getKeyInputOLwlOKw = type$iv;
                                                this_$iv2 = this_$iv;
                                                node$iv$iv$iv8 = 0;
                                                i5 = 0;
                                                node$iv$iv$iv$iv = 0;
                                                int i24 = 0;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node4;
                                                while ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 != null) {
                                                    type$iv = $i$f$getKeyInputOLwlOKw;
                                                    if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof KeyInputModifierNode) {
                                                    } else {
                                                    }
                                                    node$iv$iv$iv9 = 0;
                                                    if (kindSet$ui_release9 &= type$iv != 0) {
                                                    } else {
                                                    }
                                                    count$iv$iv$iv$iv2 = 0;
                                                    if (count$iv$iv$iv$iv2 != 0 && $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof DelegatingNode) {
                                                    } else {
                                                    }
                                                    this_$iv = this_$iv2;
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                                                    $i$f$getKeyInputOLwlOKw = type$iv;
                                                    this_$iv2 = this_$iv;
                                                    if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof DelegatingNode) {
                                                    } else {
                                                    }
                                                    count$iv$iv$iv$iv2 = 0;
                                                    $this$nearestAncestor_u2d64DMado$iv = 0;
                                                    node$iv$iv$iv$iv$iv = (DelegatingNode)$this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getDelegate$ui_release();
                                                    while (node$iv$iv$iv$iv$iv != null) {
                                                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv$iv;
                                                        node2 = 0;
                                                        this_$iv$iv$iv$iv = 0;
                                                        if (kindSet$ui_release12 &= type$iv != 0) {
                                                        } else {
                                                        }
                                                        this_$iv$iv$iv$iv$iv = 0;
                                                        if (this_$iv$iv$iv$iv$iv != 0) {
                                                        } else {
                                                        }
                                                        node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                        this_$iv = this_$iv2;
                                                        next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                        this_$iv2 = this_$iv;
                                                        count$iv$iv$iv$iv2++;
                                                        if (count$iv$iv$iv$iv2 == 1) {
                                                        } else {
                                                        }
                                                        if (node$iv$iv$iv$iv == 0) {
                                                        } else {
                                                        }
                                                        count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                        this_$iv = this_$iv2;
                                                        count$iv$iv$iv$iv = node$iv$iv$iv$iv;
                                                        Modifier.Node node5 = node$iv$iv$iv$iv3;
                                                        if (node5 != null && count$iv$iv$iv$iv != 0) {
                                                        }
                                                        if (count$iv$iv$iv$iv != 0) {
                                                        } else {
                                                        }
                                                        next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                        node$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv3;
                                                        Boolean.valueOf(count$iv$iv$iv$iv.add(node$iv$iv$iv$iv2));
                                                        if (count$iv$iv$iv$iv != 0) {
                                                        }
                                                        node$iv$iv$iv$iv3 = this_$iv2;
                                                        Boolean.valueOf(count$iv$iv$iv$iv.add(node5));
                                                        this_$iv$iv$iv$iv = i9;
                                                        int $i$f$mutableVectorOf = 16;
                                                        i3 = 0;
                                                        count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                        this_$iv = this_$iv2;
                                                        i2 = $i$f$mutableVectorOf;
                                                        count$iv$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv2;
                                                        this_$iv = this_$iv2;
                                                        next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                        this_$iv$iv$iv$iv$iv = 1;
                                                    }
                                                    node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                    if (count$iv$iv$iv$iv2 == 1) {
                                                    } else {
                                                    }
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                    $i$f$getKeyInputOLwlOKw = type$iv;
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                    this_$iv2 = this_$iv;
                                                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv$iv;
                                                    node2 = 0;
                                                    this_$iv$iv$iv$iv = 0;
                                                    if (kindSet$ui_release12 &= type$iv != 0) {
                                                    } else {
                                                    }
                                                    this_$iv$iv$iv$iv$iv = 0;
                                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                                    } else {
                                                    }
                                                    node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                    this_$iv = this_$iv2;
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                    this_$iv2 = this_$iv;
                                                    count$iv$iv$iv$iv2++;
                                                    if (count$iv$iv$iv$iv2 == 1) {
                                                    } else {
                                                    }
                                                    if (node$iv$iv$iv$iv == 0) {
                                                    } else {
                                                    }
                                                    count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    count$iv$iv$iv$iv = node$iv$iv$iv$iv;
                                                    node5 = node$iv$iv$iv$iv3;
                                                    if (node5 != null && count$iv$iv$iv$iv != 0) {
                                                    }
                                                    if (count$iv$iv$iv$iv != 0) {
                                                    } else {
                                                    }
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    node$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv3;
                                                    Boolean.valueOf(count$iv$iv$iv$iv.add(node$iv$iv$iv$iv2));
                                                    if (count$iv$iv$iv$iv != 0) {
                                                    }
                                                    node$iv$iv$iv$iv3 = this_$iv2;
                                                    Boolean.valueOf(count$iv$iv$iv$iv.add(node5));
                                                    this_$iv$iv$iv$iv = i9;
                                                    $i$f$mutableVectorOf = 16;
                                                    i3 = 0;
                                                    count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    i2 = $i$f$mutableVectorOf;
                                                    count$iv$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    this_$iv$iv$iv$iv$iv = 1;
                                                    count$iv$iv$iv$iv2 = 1;
                                                    node$iv$iv$iv9 = 0;
                                                    if (result$iv$iv == 0) {
                                                    }
                                                    result$iv$iv.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2);
                                                    this_$iv = this_$iv2;
                                                    $this$nearestAncestor_u2d64DMado$iv = new ArrayList();
                                                    result$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                                                }
                                                type$iv = $i$f$getKeyInputOLwlOKw;
                                                this_$iv = this_$iv2;
                                                type$iv = $i$f$getKeyInputOLwlOKw;
                                                if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof KeyInputModifierNode) {
                                                } else {
                                                }
                                                node$iv$iv$iv9 = 0;
                                                if (kindSet$ui_release9 &= type$iv != 0) {
                                                } else {
                                                }
                                                count$iv$iv$iv$iv2 = 0;
                                                if (count$iv$iv$iv$iv2 != 0 && $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof DelegatingNode) {
                                                } else {
                                                }
                                                this_$iv = this_$iv2;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                                                $i$f$getKeyInputOLwlOKw = type$iv;
                                                this_$iv2 = this_$iv;
                                                if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof DelegatingNode) {
                                                } else {
                                                }
                                                count$iv$iv$iv$iv2 = 0;
                                                $this$nearestAncestor_u2d64DMado$iv = 0;
                                                node$iv$iv$iv$iv$iv = (DelegatingNode)$this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getDelegate$ui_release();
                                                while (node$iv$iv$iv$iv$iv != null) {
                                                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv$iv;
                                                    node2 = 0;
                                                    this_$iv$iv$iv$iv = 0;
                                                    if (kindSet$ui_release12 &= type$iv != 0) {
                                                    } else {
                                                    }
                                                    this_$iv$iv$iv$iv$iv = 0;
                                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                                    } else {
                                                    }
                                                    node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                    this_$iv = this_$iv2;
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                    this_$iv2 = this_$iv;
                                                    count$iv$iv$iv$iv2++;
                                                    if (count$iv$iv$iv$iv2 == 1) {
                                                    } else {
                                                    }
                                                    if (node$iv$iv$iv$iv == 0) {
                                                    } else {
                                                    }
                                                    count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    count$iv$iv$iv$iv = node$iv$iv$iv$iv;
                                                    node5 = node$iv$iv$iv$iv3;
                                                    if (node5 != null && count$iv$iv$iv$iv != 0) {
                                                    }
                                                    if (count$iv$iv$iv$iv != 0) {
                                                    } else {
                                                    }
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    node$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv3;
                                                    Boolean.valueOf(count$iv$iv$iv$iv.add(node$iv$iv$iv$iv2));
                                                    if (count$iv$iv$iv$iv != 0) {
                                                    }
                                                    node$iv$iv$iv$iv3 = this_$iv2;
                                                    Boolean.valueOf(count$iv$iv$iv$iv.add(node5));
                                                    this_$iv$iv$iv$iv = i9;
                                                    $i$f$mutableVectorOf = 16;
                                                    i3 = 0;
                                                    count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    i2 = $i$f$mutableVectorOf;
                                                    count$iv$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    this_$iv$iv$iv$iv$iv = 1;
                                                }
                                                node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                if (count$iv$iv$iv$iv2 == 1) {
                                                } else {
                                                }
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                $i$f$getKeyInputOLwlOKw = type$iv;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                this_$iv2 = this_$iv;
                                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv$iv;
                                                node2 = 0;
                                                this_$iv$iv$iv$iv = 0;
                                                if (kindSet$ui_release12 &= type$iv != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv$iv$iv = 0;
                                                if (this_$iv$iv$iv$iv$iv != 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                this_$iv = this_$iv2;
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                this_$iv2 = this_$iv;
                                                count$iv$iv$iv$iv2++;
                                                if (count$iv$iv$iv$iv2 == 1) {
                                                } else {
                                                }
                                                if (node$iv$iv$iv$iv == 0) {
                                                } else {
                                                }
                                                count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                count$iv$iv$iv$iv = node$iv$iv$iv$iv;
                                                node5 = node$iv$iv$iv$iv3;
                                                if (node5 != null && count$iv$iv$iv$iv != 0) {
                                                }
                                                if (count$iv$iv$iv$iv != 0) {
                                                } else {
                                                }
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                node$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                count$iv$iv$iv$iv2 = count$iv$iv$iv$iv3;
                                                Boolean.valueOf(count$iv$iv$iv$iv.add(node$iv$iv$iv$iv2));
                                                if (count$iv$iv$iv$iv != 0) {
                                                }
                                                node$iv$iv$iv$iv3 = this_$iv2;
                                                Boolean.valueOf(count$iv$iv$iv$iv.add(node5));
                                                this_$iv$iv$iv$iv = i9;
                                                $i$f$mutableVectorOf = 16;
                                                i3 = 0;
                                                count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                i2 = $i$f$mutableVectorOf;
                                                count$iv$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                this_$iv$iv$iv$iv$iv = 1;
                                                count$iv$iv$iv$iv2 = 1;
                                                node$iv$iv$iv9 = 0;
                                                if (result$iv$iv == 0) {
                                                }
                                                result$iv$iv.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2);
                                                this_$iv = this_$iv2;
                                                $this$nearestAncestor_u2d64DMado$iv = new ArrayList();
                                                result$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                                            }
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                            type$iv = $i$f$getKeyInputOLwlOKw;
                                            this_$iv = this_$iv2;
                                            if (kindSet$ui_release6 &= node$iv$iv$iv4 != 0) {
                                            } else {
                                            }
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                            type$iv = $i$f$getKeyInputOLwlOKw;
                                            this_$iv = this_$iv2;
                                            node$iv$iv$iv$iv5 = node$iv$iv$iv$iv5.getParent$ui_release();
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                            $i$f$getKeyInputOLwlOKw = type$iv;
                                            this_$iv2 = this_$iv;
                                            node$iv$iv$iv8 = 0;
                                            i5 = 0;
                                            node$iv$iv$iv$iv = 0;
                                            i24 = 0;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node4;
                                            while ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 != null) {
                                                type$iv = $i$f$getKeyInputOLwlOKw;
                                                if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof KeyInputModifierNode) {
                                                } else {
                                                }
                                                node$iv$iv$iv9 = 0;
                                                if (kindSet$ui_release9 &= type$iv != 0) {
                                                } else {
                                                }
                                                count$iv$iv$iv$iv2 = 0;
                                                if (count$iv$iv$iv$iv2 != 0 && $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof DelegatingNode) {
                                                } else {
                                                }
                                                this_$iv = this_$iv2;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                                                $i$f$getKeyInputOLwlOKw = type$iv;
                                                this_$iv2 = this_$iv;
                                                if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof DelegatingNode) {
                                                } else {
                                                }
                                                count$iv$iv$iv$iv2 = 0;
                                                $this$nearestAncestor_u2d64DMado$iv = 0;
                                                node$iv$iv$iv$iv$iv = (DelegatingNode)$this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getDelegate$ui_release();
                                                while (node$iv$iv$iv$iv$iv != null) {
                                                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv$iv;
                                                    node2 = 0;
                                                    this_$iv$iv$iv$iv = 0;
                                                    if (kindSet$ui_release12 &= type$iv != 0) {
                                                    } else {
                                                    }
                                                    this_$iv$iv$iv$iv$iv = 0;
                                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                                    } else {
                                                    }
                                                    node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                    this_$iv = this_$iv2;
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                    this_$iv2 = this_$iv;
                                                    count$iv$iv$iv$iv2++;
                                                    if (count$iv$iv$iv$iv2 == 1) {
                                                    } else {
                                                    }
                                                    if (node$iv$iv$iv$iv == 0) {
                                                    } else {
                                                    }
                                                    count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    count$iv$iv$iv$iv = node$iv$iv$iv$iv;
                                                    node5 = node$iv$iv$iv$iv3;
                                                    if (node5 != null && count$iv$iv$iv$iv != 0) {
                                                    }
                                                    if (count$iv$iv$iv$iv != 0) {
                                                    } else {
                                                    }
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    node$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv3;
                                                    Boolean.valueOf(count$iv$iv$iv$iv.add(node$iv$iv$iv$iv2));
                                                    if (count$iv$iv$iv$iv != 0) {
                                                    }
                                                    node$iv$iv$iv$iv3 = this_$iv2;
                                                    Boolean.valueOf(count$iv$iv$iv$iv.add(node5));
                                                    this_$iv$iv$iv$iv = i9;
                                                    $i$f$mutableVectorOf = 16;
                                                    i3 = 0;
                                                    count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    i2 = $i$f$mutableVectorOf;
                                                    count$iv$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv2;
                                                    this_$iv = this_$iv2;
                                                    next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                    this_$iv$iv$iv$iv$iv = 1;
                                                }
                                                node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                if (count$iv$iv$iv$iv2 == 1) {
                                                } else {
                                                }
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                $i$f$getKeyInputOLwlOKw = type$iv;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                this_$iv2 = this_$iv;
                                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv$iv;
                                                node2 = 0;
                                                this_$iv$iv$iv$iv = 0;
                                                if (kindSet$ui_release12 &= type$iv != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv$iv$iv = 0;
                                                if (this_$iv$iv$iv$iv$iv != 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                this_$iv = this_$iv2;
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                this_$iv2 = this_$iv;
                                                count$iv$iv$iv$iv2++;
                                                if (count$iv$iv$iv$iv2 == 1) {
                                                } else {
                                                }
                                                if (node$iv$iv$iv$iv == 0) {
                                                } else {
                                                }
                                                count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                count$iv$iv$iv$iv = node$iv$iv$iv$iv;
                                                node5 = node$iv$iv$iv$iv3;
                                                if (node5 != null && count$iv$iv$iv$iv != 0) {
                                                }
                                                if (count$iv$iv$iv$iv != 0) {
                                                } else {
                                                }
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                node$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                count$iv$iv$iv$iv2 = count$iv$iv$iv$iv3;
                                                Boolean.valueOf(count$iv$iv$iv$iv.add(node$iv$iv$iv$iv2));
                                                if (count$iv$iv$iv$iv != 0) {
                                                }
                                                node$iv$iv$iv$iv3 = this_$iv2;
                                                Boolean.valueOf(count$iv$iv$iv$iv.add(node5));
                                                this_$iv$iv$iv$iv = i9;
                                                $i$f$mutableVectorOf = 16;
                                                i3 = 0;
                                                count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                i2 = $i$f$mutableVectorOf;
                                                count$iv$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                this_$iv$iv$iv$iv$iv = 1;
                                                count$iv$iv$iv$iv2 = 1;
                                                node$iv$iv$iv9 = 0;
                                                if (result$iv$iv == 0) {
                                                }
                                                result$iv$iv.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2);
                                                this_$iv = this_$iv2;
                                                $this$nearestAncestor_u2d64DMado$iv = new ArrayList();
                                                result$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                                            }
                                            type$iv = $i$f$getKeyInputOLwlOKw;
                                            this_$iv = this_$iv2;
                                            type$iv = $i$f$getKeyInputOLwlOKw;
                                            if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof KeyInputModifierNode) {
                                            } else {
                                            }
                                            node$iv$iv$iv9 = 0;
                                            if (kindSet$ui_release9 &= type$iv != 0) {
                                            } else {
                                            }
                                            count$iv$iv$iv$iv2 = 0;
                                            if (count$iv$iv$iv$iv2 != 0 && $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof DelegatingNode) {
                                            } else {
                                            }
                                            this_$iv = this_$iv2;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                                            $i$f$getKeyInputOLwlOKw = type$iv;
                                            this_$iv2 = this_$iv;
                                            if ($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 instanceof DelegatingNode) {
                                            } else {
                                            }
                                            count$iv$iv$iv$iv2 = 0;
                                            $this$nearestAncestor_u2d64DMado$iv = 0;
                                            node$iv$iv$iv$iv$iv = (DelegatingNode)$this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2.getDelegate$ui_release();
                                            while (node$iv$iv$iv$iv$iv != null) {
                                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv$iv;
                                                node2 = 0;
                                                this_$iv$iv$iv$iv = 0;
                                                if (kindSet$ui_release12 &= type$iv != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv$iv$iv = 0;
                                                if (this_$iv$iv$iv$iv$iv != 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                                this_$iv = this_$iv2;
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                                this_$iv2 = this_$iv;
                                                count$iv$iv$iv$iv2++;
                                                if (count$iv$iv$iv$iv2 == 1) {
                                                } else {
                                                }
                                                if (node$iv$iv$iv$iv == 0) {
                                                } else {
                                                }
                                                count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                count$iv$iv$iv$iv = node$iv$iv$iv$iv;
                                                node5 = node$iv$iv$iv$iv3;
                                                if (node5 != null && count$iv$iv$iv$iv != 0) {
                                                }
                                                if (count$iv$iv$iv$iv != 0) {
                                                } else {
                                                }
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                node$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                                count$iv$iv$iv$iv2 = count$iv$iv$iv$iv3;
                                                Boolean.valueOf(count$iv$iv$iv$iv.add(node$iv$iv$iv$iv2));
                                                if (count$iv$iv$iv$iv != 0) {
                                                }
                                                node$iv$iv$iv$iv3 = this_$iv2;
                                                Boolean.valueOf(count$iv$iv$iv$iv.add(node5));
                                                this_$iv$iv$iv$iv = i9;
                                                $i$f$mutableVectorOf = 16;
                                                i3 = 0;
                                                count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                i2 = $i$f$mutableVectorOf;
                                                count$iv$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv2;
                                                this_$iv = this_$iv2;
                                                next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                                this_$iv$iv$iv$iv$iv = 1;
                                            }
                                            node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                            if (count$iv$iv$iv$iv2 == 1) {
                                            } else {
                                            }
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                            $i$f$getKeyInputOLwlOKw = type$iv;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                            this_$iv2 = this_$iv;
                                            node$iv$iv$iv$iv2 = node$iv$iv$iv$iv$iv;
                                            node2 = 0;
                                            this_$iv$iv$iv$iv = 0;
                                            if (kindSet$ui_release12 &= type$iv != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv$iv = 0;
                                            if (this_$iv$iv$iv$iv$iv != 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                            this_$iv = this_$iv2;
                                            next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                            this_$iv2 = this_$iv;
                                            count$iv$iv$iv$iv2++;
                                            if (count$iv$iv$iv$iv2 == 1) {
                                            } else {
                                            }
                                            if (node$iv$iv$iv$iv == 0) {
                                            } else {
                                            }
                                            count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                            this_$iv = this_$iv2;
                                            count$iv$iv$iv$iv = node$iv$iv$iv$iv;
                                            node5 = node$iv$iv$iv$iv3;
                                            if (node5 != null && count$iv$iv$iv$iv != 0) {
                                            }
                                            if (count$iv$iv$iv$iv != 0) {
                                            } else {
                                            }
                                            next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                            node$iv$iv$iv$iv = count$iv$iv$iv$iv;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv3;
                                            count$iv$iv$iv$iv2 = count$iv$iv$iv$iv3;
                                            Boolean.valueOf(count$iv$iv$iv$iv.add(node$iv$iv$iv$iv2));
                                            if (count$iv$iv$iv$iv != 0) {
                                            }
                                            node$iv$iv$iv$iv3 = this_$iv2;
                                            Boolean.valueOf(count$iv$iv$iv$iv.add(node5));
                                            this_$iv$iv$iv$iv = i9;
                                            $i$f$mutableVectorOf = 16;
                                            i3 = 0;
                                            count$iv$iv$iv$iv3 = count$iv$iv$iv$iv2;
                                            this_$iv = this_$iv2;
                                            i2 = $i$f$mutableVectorOf;
                                            count$iv$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = node$iv$iv$iv$iv2;
                                            this_$iv = this_$iv2;
                                            next$iv$iv$iv$iv = node$iv$iv$iv$iv2;
                                            this_$iv$iv$iv$iv$iv = 1;
                                            count$iv$iv$iv$iv2 = 1;
                                            node$iv$iv$iv9 = 0;
                                            if (result$iv$iv == 0) {
                                            }
                                            result$iv$iv.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2);
                                            this_$iv = this_$iv2;
                                            $this$nearestAncestor_u2d64DMado$iv = new ArrayList();
                                            result$iv$iv = $this$nearestAncestor_u2d64DMado$iv;
                                        }
                                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                        type$iv = $i$f$getKeyInputOLwlOKw;
                                        this_$iv = this_$iv2;
                                        int i10 = result$iv$iv;
                                        $i$f$getKeyInputOLwlOKw = 0;
                                        if (result$iv$iv != 0 && size-- >= 0) {
                                            i10 = result$iv$iv;
                                            $i$f$getKeyInputOLwlOKw = 0;
                                            if (size-- >= 0) {
                                            }
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = Unit.INSTANCE;
                                        }
                                        $i$f$dispatchForKind6rFNWt02 = 0;
                                        stack$iv$iv = 0;
                                        int i16 = 0;
                                        node$iv$iv2 = node3;
                                        while (node$iv$iv2 != null) {
                                            $i$f$getKeyInputOLwlOKw3 = 0;
                                            if (kindSet$ui_release2 &= type$iv != 0) {
                                            } else {
                                            }
                                            count$iv$iv = 0;
                                            if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                                            } else {
                                            }
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                            node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                            node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                                            node3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                                            if (node$iv$iv2 instanceof DelegatingNode) {
                                            } else {
                                            }
                                            count$iv$iv = 0;
                                            onPreKeyEvent-ZmokQxo = 0;
                                            node$iv$iv$iv3 = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                                            while (node$iv$iv$iv3 != 0) {
                                                node$iv$iv$iv4 = node$iv$iv$iv3;
                                                layout$iv$iv$iv = 0;
                                                node$iv$iv$iv$iv5 = 0;
                                                if (kindSet$ui_release5 &= type$iv != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv = 0;
                                                if (this_$iv$iv$iv != 0) {
                                                } else {
                                                }
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                                node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                                node$iv$iv$iv8 = stack$iv$iv;
                                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                                node3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                                $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                                                if (count$iv$iv++ == 1) {
                                                } else {
                                                }
                                                if (stack$iv$iv == 0) {
                                                } else {
                                                }
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                                node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = node$iv$iv$iv8;
                                                stack$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                                node3 = node$iv$iv2;
                                                if (node3 != null && stack$iv$iv != 0) {
                                                }
                                                if (stack$iv$iv != 0) {
                                                }
                                                Boolean.valueOf(stack$iv$iv.add(node$iv$iv$iv4));
                                                if (stack$iv$iv != 0) {
                                                }
                                                node$iv$iv2 = $i$f$dispatchForKind6rFNWt02;
                                                Boolean.valueOf(stack$iv$iv.add(node3));
                                                this_$iv$iv$iv = 0;
                                                layout$iv$iv$iv$iv = 0;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                                node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                                node$iv$iv$iv8 = stack$iv$iv;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                                node$iv$iv2 = node$iv$iv$iv4;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                                node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                                this_$iv$iv$iv = 1;
                                            }
                                            node$iv$iv$iv8 = stack$iv$iv;
                                            if (count$iv$iv == 1) {
                                            } else {
                                            }
                                            stack$iv$iv = node$iv$iv$iv8;
                                            node3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                                            stack$iv$iv = node$iv$iv$iv8;
                                            node$iv$iv$iv4 = node$iv$iv$iv3;
                                            layout$iv$iv$iv = 0;
                                            node$iv$iv$iv$iv5 = 0;
                                            if (kindSet$ui_release5 &= type$iv != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv = 0;
                                            if (this_$iv$iv$iv != 0) {
                                            } else {
                                            }
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                            node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                            node$iv$iv$iv8 = stack$iv$iv;
                                            node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                            node3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv;
                                            if (count$iv$iv++ == 1) {
                                            } else {
                                            }
                                            if (stack$iv$iv == 0) {
                                            } else {
                                            }
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                            node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv = node$iv$iv$iv8;
                                            stack$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                            node3 = node$iv$iv2;
                                            if (node3 != null && stack$iv$iv != 0) {
                                            }
                                            if (stack$iv$iv != 0) {
                                            }
                                            Boolean.valueOf(stack$iv$iv.add(node$iv$iv$iv4));
                                            if (stack$iv$iv != 0) {
                                            }
                                            node$iv$iv2 = $i$f$dispatchForKind6rFNWt02;
                                            Boolean.valueOf(stack$iv$iv.add(node3));
                                            this_$iv$iv$iv = 0;
                                            layout$iv$iv$iv$iv = 0;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                            node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                            node$iv$iv$iv8 = stack$iv$iv;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                            node$iv$iv2 = node$iv$iv$iv4;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                            node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                            this_$iv$iv$iv = 1;
                                            count$iv$iv = 1;
                                            $i$f$getKeyInputOLwlOKw3 = 0;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = node3;
                                            node$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                        }
                                        $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = node3;
                                        i7 = $i$f$dispatchForKind6rFNWt02;
                                        int $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = 0;
                                        if ((Boolean)onFocusedItem.invoke().booleanValue()) {
                                            return 1;
                                        }
                                        $i$f$dispatchForKind6rFNWt0 = 0;
                                        index$iv$iv = 0;
                                        int i17 = 0;
                                        node$iv$iv = $this$fastForEach$iv$iv;
                                        while (node$iv$iv != null) {
                                            $i$f$getKeyInputOLwlOKw3 = 0;
                                            if (kindSet$ui_release &= type$iv != 0) {
                                            } else {
                                            }
                                            count$iv$iv = 0;
                                            if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                            } else {
                                            }
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                            i7 = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv = DelegatableNodeKt.access$pop(index$iv$iv);
                                            $this$fastForEach$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                                            $i$f$dispatchForKind6rFNWt0 = i7;
                                            if (node$iv$iv instanceof DelegatingNode) {
                                            } else {
                                            }
                                            count$iv$iv = 0;
                                            onPreKeyEvent-ZmokQxo = 0;
                                            node$iv$iv$iv3 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                            while (node$iv$iv$iv3 != 0) {
                                                node$iv$iv$iv4 = node$iv$iv$iv3;
                                                layout$iv$iv$iv = 0;
                                                node$iv$iv$iv$iv5 = 0;
                                                if (kindSet$ui_release4 &= type$iv != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv = 0;
                                                if (this_$iv$iv$iv != 0) {
                                                } else {
                                                }
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                                i7 = $i$f$dispatchForKind6rFNWt0;
                                                node$iv$iv$iv8 = index$iv$iv;
                                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                                $this$fastForEach$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                                                $i$f$dispatchForKind6rFNWt0 = i7;
                                                if (count$iv$iv++ == 1) {
                                                } else {
                                                }
                                                if (index$iv$iv == 0) {
                                                } else {
                                                }
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                                i7 = $i$f$dispatchForKind6rFNWt0;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = node$iv$iv$iv8;
                                                index$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                                $this$fastForEach$iv$iv = node$iv$iv;
                                                if ($this$fastForEach$iv$iv != null && index$iv$iv != 0) {
                                                }
                                                if (index$iv$iv != 0) {
                                                }
                                                Boolean.valueOf(index$iv$iv.add(node$iv$iv$iv4));
                                                if (index$iv$iv != 0) {
                                                }
                                                node$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                                Boolean.valueOf(index$iv$iv.add($this$fastForEach$iv$iv));
                                                this_$iv$iv$iv = 0;
                                                layout$iv$iv$iv$iv = 0;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                                i7 = $i$f$dispatchForKind6rFNWt0;
                                                node$iv$iv$iv8 = index$iv$iv;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                                                node$iv$iv = node$iv$iv$iv4;
                                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                                i7 = $i$f$dispatchForKind6rFNWt0;
                                                this_$iv$iv$iv = 1;
                                            }
                                            node$iv$iv$iv8 = index$iv$iv;
                                            if (count$iv$iv == 1) {
                                            } else {
                                            }
                                            index$iv$iv = node$iv$iv$iv8;
                                            $this$fastForEach$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                                            $i$f$dispatchForKind6rFNWt0 = i7;
                                            index$iv$iv = node$iv$iv$iv8;
                                            node$iv$iv$iv4 = node$iv$iv$iv3;
                                            layout$iv$iv$iv = 0;
                                            node$iv$iv$iv$iv5 = 0;
                                            if (kindSet$ui_release4 &= type$iv != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv = 0;
                                            if (this_$iv$iv$iv != 0) {
                                            } else {
                                            }
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                            i7 = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv8 = index$iv$iv;
                                            node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                            $this$fastForEach$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                                            $i$f$dispatchForKind6rFNWt0 = i7;
                                            if (count$iv$iv++ == 1) {
                                            } else {
                                            }
                                            if (index$iv$iv == 0) {
                                            } else {
                                            }
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                            i7 = $i$f$dispatchForKind6rFNWt0;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = node$iv$iv$iv8;
                                            index$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                                            $this$fastForEach$iv$iv = node$iv$iv;
                                            if ($this$fastForEach$iv$iv != null && index$iv$iv != 0) {
                                            }
                                            if (index$iv$iv != 0) {
                                            }
                                            Boolean.valueOf(index$iv$iv.add(node$iv$iv$iv4));
                                            if (index$iv$iv != 0) {
                                            }
                                            node$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                            Boolean.valueOf(index$iv$iv.add($this$fastForEach$iv$iv));
                                            this_$iv$iv$iv = 0;
                                            layout$iv$iv$iv$iv = 0;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                            i7 = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv8 = index$iv$iv;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = new MutableVector(new Modifier.Node[16], 0);
                                            node$iv$iv = node$iv$iv$iv4;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                            i7 = $i$f$dispatchForKind6rFNWt0;
                                            this_$iv$iv$iv = 1;
                                            count$iv$iv = 1;
                                            $i$f$getKeyInputOLwlOKw3 = 0;
                                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$fastForEach$iv$iv;
                                            i7 = $i$f$dispatchForKind6rFNWt0;
                                        }
                                        $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$fastForEach$iv$iv;
                                        node$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                        if (result$iv$iv != 0) {
                                            int i11 = result$iv$iv;
                                            $i$f$dispatchForKind6rFNWt0 = 0;
                                            index$iv$iv = 0;
                                            while (index$iv$iv < i11.size()) {
                                                onPreKeyEvent-ZmokQxo = 0;
                                                i = 1;
                                                index$iv$iv++;
                                            }
                                            $this$fastForEach$iv$iv = Unit.INSTANCE;
                                        }
                                        count$iv$iv$iv = Unit.INSTANCE;
                                    }
                                    int i25 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                                    int i26 = $i$f$getKeyInputOLwlOKw;
                                    int $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3 = 0;
                                    IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv$iv = new IllegalStateException(count$iv$iv$iv$iv3.toString());
                                    throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv$iv;
                                }
                            } else {
                                $i$f$dispatchForKind6rFNWt0 = count$iv$iv$iv.rootFocusNode;
                                int i15 = 0;
                                $i$f$getKeyInputOLwlOKw2 = NodeKind.constructor-impl(node$iv$iv$iv9);
                                node$iv$iv = 0;
                                result$iv$iv = 0;
                                int i18 = 0;
                                $i$f$getKeyInputOLwlOKw3 = $i$f$getKeyInputOLwlOKw2;
                                onPreKeyEvent-ZmokQxo = count$iv$iv;
                                node$iv$iv$iv3 = 0;
                                if (!onPreKeyEvent-ZmokQxo.getNode().isAttached()) {
                                } else {
                                    node$iv$iv$iv4 = onPreKeyEvent-ZmokQxo.getNode().getParent$ui_release();
                                    layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(onPreKeyEvent-ZmokQxo);
                                    while (layout$iv$iv$iv != null) {
                                        if (aggregateChildKindSet$ui_release &= $i$f$getKeyInputOLwlOKw3 == 0) {
                                            break;
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                        layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                                        count$iv$iv$iv = layout$iv$iv$iv.getNodes$ui_release();
                                        if (layout$iv$iv$iv != null && count$iv$iv$iv != null) {
                                        } else {
                                        }
                                        tail$ui_release = 0;
                                        node$iv$iv$iv4 = tail$ui_release;
                                        count$iv$iv$iv = this;
                                        $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                        index$iv$iv = 0;
                                        count$iv$iv$iv = layout$iv$iv$iv.getNodes$ui_release();
                                        if (count$iv$iv$iv != null) {
                                        } else {
                                        }
                                        tail$ui_release = count$iv$iv$iv.getTail$ui_release();
                                        while (node$iv$iv$iv4 != null) {
                                            if (kindSet$ui_release3 &= $i$f$getKeyInputOLwlOKw3 == 0) {
                                                break loop_67;
                                            } else {
                                            }
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv4 = node$iv$iv$iv4.getParent$ui_release();
                                            count$iv$iv$iv = this;
                                            $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                            index$iv$iv = 0;
                                            layout$iv$iv$iv$iv = 0;
                                            node$iv$iv$iv = 0;
                                            node$iv$iv$iv8 = 0;
                                            int i23 = 0;
                                            index$iv$iv = node$iv$iv$iv7;
                                            while (index$iv$iv != null) {
                                                i4 = 0;
                                                if (kindSet$ui_release8 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv$iv3 = 0;
                                                if (this_$iv$iv$iv$iv3 != 0 && index$iv$iv instanceof DelegatingNode) {
                                                } else {
                                                }
                                                $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                index$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv8);
                                                count$iv$iv$iv = this;
                                                $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                                if (index$iv$iv instanceof DelegatingNode) {
                                                } else {
                                                }
                                                this_$iv$iv$iv$iv3 = 0;
                                                i5 = 0;
                                                node$iv$iv$iv$iv = (DelegatingNode)index$iv$iv.getDelegate$ui_release();
                                                while (node$iv$iv$iv$iv != null) {
                                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv$iv;
                                                    type$iv = 0;
                                                    node$iv$iv$iv$iv$iv = 0;
                                                    if (kindSet$ui_release11 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                                    } else {
                                                    }
                                                    this_$iv$iv$iv$iv2 = 0;
                                                    if (this_$iv$iv$iv$iv2 != 0) {
                                                    } else {
                                                    }
                                                    $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                    node$iv$iv$iv$iv3 = index$iv$iv;
                                                    node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                                    $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                                    index$iv$iv = node$iv$iv$iv$iv3;
                                                    this_$iv$iv$iv$iv3++;
                                                    $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                    if (this_$iv$iv$iv$iv3 == 1) {
                                                    } else {
                                                    }
                                                    if (node$iv$iv$iv8 == 0) {
                                                    } else {
                                                    }
                                                    node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                    node = index$iv$iv;
                                                    $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8;
                                                    Modifier.Node node6 = node;
                                                    if (node6 != null) {
                                                    } else {
                                                    }
                                                    node$iv$iv$iv5 = node;
                                                    if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                                    } else {
                                                    }
                                                    node$iv$iv$iv6 = node$iv$iv$iv5;
                                                    node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                    node$iv$iv$iv$iv3 = node$iv$iv$iv6;
                                                    this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv$iv;
                                                    node$iv$iv$iv8 = $i$f$dispatchForKind6rFNWt0;
                                                    node$iv$iv$iv6 = node$iv$iv$iv5;
                                                    Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv));
                                                    if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                                    }
                                                    node$iv$iv$iv5 = 0;
                                                    Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node6));
                                                    node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                    int count$iv$iv$iv2 = 16;
                                                    node$iv$iv$iv$iv2 = 0;
                                                    node2 = i14;
                                                    node = index$iv$iv;
                                                    this_$iv$iv$iv$iv = count$iv$iv$iv2;
                                                    $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[count$iv$iv$iv2], 0);
                                                    node$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                                    this_$iv$iv$iv$iv2 = 1;
                                                }
                                                node$iv$iv$iv$iv3 = index$iv$iv;
                                                if (this_$iv$iv$iv$iv3 == 1) {
                                                } else {
                                                }
                                                index$iv$iv = node$iv$iv$iv$iv3;
                                                count$iv$iv$iv = this;
                                                $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                                index$iv$iv = node$iv$iv$iv$iv3;
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv$iv;
                                                type$iv = 0;
                                                node$iv$iv$iv$iv$iv = 0;
                                                if (kindSet$ui_release11 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv$iv2 = 0;
                                                if (this_$iv$iv$iv$iv2 != 0) {
                                                } else {
                                                }
                                                $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                node$iv$iv$iv$iv3 = index$iv$iv;
                                                node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                                $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                                index$iv$iv = node$iv$iv$iv$iv3;
                                                this_$iv$iv$iv$iv3++;
                                                $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                if (this_$iv$iv$iv$iv3 == 1) {
                                                } else {
                                                }
                                                if (node$iv$iv$iv8 == 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                node = index$iv$iv;
                                                $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8;
                                                node6 = node;
                                                if (node6 != null) {
                                                } else {
                                                }
                                                node$iv$iv$iv5 = node;
                                                if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv6 = node$iv$iv$iv5;
                                                node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                node$iv$iv$iv$iv3 = node$iv$iv$iv6;
                                                this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv$iv;
                                                node$iv$iv$iv8 = $i$f$dispatchForKind6rFNWt0;
                                                node$iv$iv$iv6 = node$iv$iv$iv5;
                                                Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv));
                                                if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                                }
                                                node$iv$iv$iv5 = 0;
                                                Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node6));
                                                node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                count$iv$iv$iv2 = 16;
                                                node$iv$iv$iv$iv2 = 0;
                                                node2 = i14;
                                                node = index$iv$iv;
                                                this_$iv$iv$iv$iv = count$iv$iv$iv2;
                                                $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[count$iv$iv$iv2], 0);
                                                node$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                                this_$iv$iv$iv$iv2 = 1;
                                                this_$iv$iv$iv$iv3 = 1;
                                            }
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            i4 = 0;
                                            if (kindSet$ui_release8 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv3 = 0;
                                            if (this_$iv$iv$iv$iv3 != 0 && index$iv$iv instanceof DelegatingNode) {
                                            } else {
                                            }
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            index$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv8);
                                            count$iv$iv$iv = this;
                                            $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                            if (index$iv$iv instanceof DelegatingNode) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv3 = 0;
                                            i5 = 0;
                                            node$iv$iv$iv$iv = (DelegatingNode)index$iv$iv.getDelegate$ui_release();
                                            while (node$iv$iv$iv$iv != null) {
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv$iv;
                                                type$iv = 0;
                                                node$iv$iv$iv$iv$iv = 0;
                                                if (kindSet$ui_release11 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv$iv2 = 0;
                                                if (this_$iv$iv$iv$iv2 != 0) {
                                                } else {
                                                }
                                                $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                node$iv$iv$iv$iv3 = index$iv$iv;
                                                node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                                $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                                index$iv$iv = node$iv$iv$iv$iv3;
                                                this_$iv$iv$iv$iv3++;
                                                $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                if (this_$iv$iv$iv$iv3 == 1) {
                                                } else {
                                                }
                                                if (node$iv$iv$iv8 == 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                node = index$iv$iv;
                                                $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8;
                                                node6 = node;
                                                if (node6 != null) {
                                                } else {
                                                }
                                                node$iv$iv$iv5 = node;
                                                if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv6 = node$iv$iv$iv5;
                                                node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                node$iv$iv$iv$iv3 = node$iv$iv$iv6;
                                                this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv$iv;
                                                node$iv$iv$iv8 = $i$f$dispatchForKind6rFNWt0;
                                                node$iv$iv$iv6 = node$iv$iv$iv5;
                                                Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv));
                                                if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                                }
                                                node$iv$iv$iv5 = 0;
                                                Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node6));
                                                node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                count$iv$iv$iv2 = 16;
                                                node$iv$iv$iv$iv2 = 0;
                                                node2 = i14;
                                                node = index$iv$iv;
                                                this_$iv$iv$iv$iv = count$iv$iv$iv2;
                                                $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[count$iv$iv$iv2], 0);
                                                node$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                                this_$iv$iv$iv$iv2 = 1;
                                            }
                                            node$iv$iv$iv$iv3 = index$iv$iv;
                                            if (this_$iv$iv$iv$iv3 == 1) {
                                            } else {
                                            }
                                            index$iv$iv = node$iv$iv$iv$iv3;
                                            count$iv$iv$iv = this;
                                            $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                            index$iv$iv = node$iv$iv$iv$iv3;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv$iv;
                                            type$iv = 0;
                                            node$iv$iv$iv$iv$iv = 0;
                                            if (kindSet$ui_release11 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv2 = 0;
                                            if (this_$iv$iv$iv$iv2 != 0) {
                                            } else {
                                            }
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv$iv3 = index$iv$iv;
                                            node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                            $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                            index$iv$iv = node$iv$iv$iv$iv3;
                                            this_$iv$iv$iv$iv3++;
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            if (this_$iv$iv$iv$iv3 == 1) {
                                            } else {
                                            }
                                            if (node$iv$iv$iv8 == 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                            node = index$iv$iv;
                                            $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8;
                                            node6 = node;
                                            if (node6 != null) {
                                            } else {
                                            }
                                            node$iv$iv$iv5 = node;
                                            if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv6 = node$iv$iv$iv5;
                                            node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                            node$iv$iv$iv$iv3 = node$iv$iv$iv6;
                                            this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv$iv;
                                            node$iv$iv$iv8 = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv6 = node$iv$iv$iv5;
                                            Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv));
                                            if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                            }
                                            node$iv$iv$iv5 = 0;
                                            Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node6));
                                            node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                            count$iv$iv$iv2 = 16;
                                            node$iv$iv$iv$iv2 = 0;
                                            node2 = i14;
                                            node = index$iv$iv;
                                            this_$iv$iv$iv$iv = count$iv$iv$iv2;
                                            $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[count$iv$iv$iv2], 0);
                                            node$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                            this_$iv$iv$iv$iv2 = 1;
                                            this_$iv$iv$iv$iv3 = 1;
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                        if (kindSet$ui_release3 &= $i$f$getKeyInputOLwlOKw3 == 0) {
                                            break;
                                        } else {
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                        node$iv$iv$iv4 = node$iv$iv$iv4.getParent$ui_release();
                                        count$iv$iv$iv = this;
                                        $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                        index$iv$iv = 0;
                                        layout$iv$iv$iv$iv = 0;
                                        node$iv$iv$iv = 0;
                                        node$iv$iv$iv8 = 0;
                                        i23 = 0;
                                        index$iv$iv = node$iv$iv$iv7;
                                        while (index$iv$iv != null) {
                                            i4 = 0;
                                            if (kindSet$ui_release8 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv3 = 0;
                                            if (this_$iv$iv$iv$iv3 != 0 && index$iv$iv instanceof DelegatingNode) {
                                            } else {
                                            }
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            index$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv8);
                                            count$iv$iv$iv = this;
                                            $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                            if (index$iv$iv instanceof DelegatingNode) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv3 = 0;
                                            i5 = 0;
                                            node$iv$iv$iv$iv = (DelegatingNode)index$iv$iv.getDelegate$ui_release();
                                            while (node$iv$iv$iv$iv != null) {
                                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv$iv;
                                                type$iv = 0;
                                                node$iv$iv$iv$iv$iv = 0;
                                                if (kindSet$ui_release11 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                                } else {
                                                }
                                                this_$iv$iv$iv$iv2 = 0;
                                                if (this_$iv$iv$iv$iv2 != 0) {
                                                } else {
                                                }
                                                $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                node$iv$iv$iv$iv3 = index$iv$iv;
                                                node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                                $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                                index$iv$iv = node$iv$iv$iv$iv3;
                                                this_$iv$iv$iv$iv3++;
                                                $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                                if (this_$iv$iv$iv$iv3 == 1) {
                                                } else {
                                                }
                                                if (node$iv$iv$iv8 == 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                node = index$iv$iv;
                                                $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8;
                                                node6 = node;
                                                if (node6 != null) {
                                                } else {
                                                }
                                                node$iv$iv$iv5 = node;
                                                if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                                } else {
                                                }
                                                node$iv$iv$iv6 = node$iv$iv$iv5;
                                                node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                                node$iv$iv$iv$iv3 = node$iv$iv$iv6;
                                                this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv$iv;
                                                node$iv$iv$iv8 = $i$f$dispatchForKind6rFNWt0;
                                                node$iv$iv$iv6 = node$iv$iv$iv5;
                                                Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv));
                                                if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                                }
                                                node$iv$iv$iv5 = 0;
                                                Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node6));
                                                node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                                count$iv$iv$iv2 = 16;
                                                node$iv$iv$iv$iv2 = 0;
                                                node2 = i14;
                                                node = index$iv$iv;
                                                this_$iv$iv$iv$iv = count$iv$iv$iv2;
                                                $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[count$iv$iv$iv2], 0);
                                                node$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                                this_$iv$iv$iv$iv2 = 1;
                                            }
                                            node$iv$iv$iv$iv3 = index$iv$iv;
                                            if (this_$iv$iv$iv$iv3 == 1) {
                                            } else {
                                            }
                                            index$iv$iv = node$iv$iv$iv$iv3;
                                            count$iv$iv$iv = this;
                                            $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                            index$iv$iv = node$iv$iv$iv$iv3;
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv$iv;
                                            type$iv = 0;
                                            node$iv$iv$iv$iv$iv = 0;
                                            if (kindSet$ui_release11 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv2 = 0;
                                            if (this_$iv$iv$iv$iv2 != 0) {
                                            } else {
                                            }
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv$iv3 = index$iv$iv;
                                            node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                            $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                            index$iv$iv = node$iv$iv$iv$iv3;
                                            this_$iv$iv$iv$iv3++;
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            if (this_$iv$iv$iv$iv3 == 1) {
                                            } else {
                                            }
                                            if (node$iv$iv$iv8 == 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                            node = index$iv$iv;
                                            $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8;
                                            node6 = node;
                                            if (node6 != null) {
                                            } else {
                                            }
                                            node$iv$iv$iv5 = node;
                                            if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv6 = node$iv$iv$iv5;
                                            node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                            node$iv$iv$iv$iv3 = node$iv$iv$iv6;
                                            this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv$iv;
                                            node$iv$iv$iv8 = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv6 = node$iv$iv$iv5;
                                            Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv));
                                            if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                            }
                                            node$iv$iv$iv5 = 0;
                                            Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node6));
                                            node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                            count$iv$iv$iv2 = 16;
                                            node$iv$iv$iv$iv2 = 0;
                                            node2 = i14;
                                            node = index$iv$iv;
                                            this_$iv$iv$iv$iv = count$iv$iv$iv2;
                                            $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[count$iv$iv$iv2], 0);
                                            node$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                            this_$iv$iv$iv$iv2 = 1;
                                            this_$iv$iv$iv$iv3 = 1;
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                        i4 = 0;
                                        if (kindSet$ui_release8 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv3 = 0;
                                        if (this_$iv$iv$iv$iv3 != 0 && index$iv$iv instanceof DelegatingNode) {
                                        } else {
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                        index$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv$iv8);
                                        count$iv$iv$iv = this;
                                        $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                        if (index$iv$iv instanceof DelegatingNode) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv3 = 0;
                                        i5 = 0;
                                        node$iv$iv$iv$iv = (DelegatingNode)index$iv$iv.getDelegate$ui_release();
                                        while (node$iv$iv$iv$iv != null) {
                                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv$iv;
                                            type$iv = 0;
                                            node$iv$iv$iv$iv$iv = 0;
                                            if (kindSet$ui_release11 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv2 = 0;
                                            if (this_$iv$iv$iv$iv2 != 0) {
                                            } else {
                                            }
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv$iv3 = index$iv$iv;
                                            node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                            $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                            index$iv$iv = node$iv$iv$iv$iv3;
                                            this_$iv$iv$iv$iv3++;
                                            $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                            if (this_$iv$iv$iv$iv3 == 1) {
                                            } else {
                                            }
                                            if (node$iv$iv$iv8 == 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                            node = index$iv$iv;
                                            $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8;
                                            node6 = node;
                                            if (node6 != null) {
                                            } else {
                                            }
                                            node$iv$iv$iv5 = node;
                                            if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv6 = node$iv$iv$iv5;
                                            node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                            node$iv$iv$iv$iv3 = node$iv$iv$iv6;
                                            this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv$iv;
                                            node$iv$iv$iv8 = $i$f$dispatchForKind6rFNWt0;
                                            node$iv$iv$iv6 = node$iv$iv$iv5;
                                            Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv));
                                            if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                            }
                                            node$iv$iv$iv5 = 0;
                                            Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node6));
                                            node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                            count$iv$iv$iv2 = 16;
                                            node$iv$iv$iv$iv2 = 0;
                                            node2 = i14;
                                            node = index$iv$iv;
                                            this_$iv$iv$iv$iv = count$iv$iv$iv2;
                                            $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[count$iv$iv$iv2], 0);
                                            node$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                            this_$iv$iv$iv$iv2 = 1;
                                        }
                                        node$iv$iv$iv$iv3 = index$iv$iv;
                                        if (this_$iv$iv$iv$iv3 == 1) {
                                        } else {
                                        }
                                        index$iv$iv = node$iv$iv$iv$iv3;
                                        count$iv$iv$iv = this;
                                        $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                        index$iv$iv = node$iv$iv$iv$iv3;
                                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv$iv;
                                        type$iv = 0;
                                        node$iv$iv$iv$iv$iv = 0;
                                        if (kindSet$ui_release11 &= $i$f$getKeyInputOLwlOKw2 != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv2 = 0;
                                        if (this_$iv$iv$iv$iv2 != 0) {
                                        } else {
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                        node$iv$iv$iv$iv3 = index$iv$iv;
                                        node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                        $i$f$dispatchForKind6rFNWt0 = $this$nearestAncestor_u2d64DMado$iv;
                                        index$iv$iv = node$iv$iv$iv$iv3;
                                        this_$iv$iv$iv$iv3++;
                                        $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                        if (this_$iv$iv$iv$iv3 == 1) {
                                        } else {
                                        }
                                        if (node$iv$iv$iv8 == 0) {
                                        } else {
                                        }
                                        node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                        node = index$iv$iv;
                                        $i$f$dispatchForKind6rFNWt0 = node$iv$iv$iv8;
                                        node6 = node;
                                        if (node6 != null) {
                                        } else {
                                        }
                                        node$iv$iv$iv5 = node;
                                        if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                        } else {
                                        }
                                        node$iv$iv$iv6 = node$iv$iv$iv5;
                                        node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                        node$iv$iv$iv$iv3 = node$iv$iv$iv6;
                                        this_$iv$iv$iv$iv3 = node$iv$iv$iv$iv$iv;
                                        node$iv$iv$iv8 = $i$f$dispatchForKind6rFNWt0;
                                        node$iv$iv$iv6 = node$iv$iv$iv5;
                                        Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv));
                                        if ($i$f$dispatchForKind6rFNWt0 != 0) {
                                        }
                                        node$iv$iv$iv5 = 0;
                                        Boolean.valueOf($i$f$dispatchForKind6rFNWt0.add(node6));
                                        node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv3;
                                        count$iv$iv$iv2 = 16;
                                        node$iv$iv$iv$iv2 = 0;
                                        node2 = i14;
                                        node = index$iv$iv;
                                        this_$iv$iv$iv$iv = count$iv$iv$iv2;
                                        $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[count$iv$iv$iv2], 0);
                                        node$iv$iv$iv$iv3 = node$iv$iv$iv2;
                                        this_$iv$iv$iv$iv2 = 1;
                                        this_$iv$iv$iv$iv3 = 1;
                                    }
                                    $this$nearestAncestor_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt0;
                                    count$iv$iv$iv = 0;
                                    if ((KeyInputModifierNode)count$iv$iv$iv != null) {
                                        lastLocalKeyInputNode = (KeyInputModifierNode)count$iv$iv$iv.getNode();
                                    } else {
                                        lastLocalKeyInputNode = 0;
                                    }
                                }
                            }
                        }
                        androidx.compose.ui.focus.FocusTargetNode activeFocusTarget4 = $i$f$dispatchForKind6rFNWt0;
                        int activeFocusTarget3 = 0;
                        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv2 = new IllegalStateException($i$f$getKeyInputOLwlOKw2.toString());
                        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv2;
                    }
                    activeFocusTarget = $i$f$dispatchForKind6rFNWt0;
                    count$iv$iv$iv$iv3 = $i$f$getKeyInputOLwlOKw2;
                    node$iv$iv$iv9 = node$iv$iv;
                } else {
                    activeFocusTarget = $i$f$dispatchForKind6rFNWt0;
                    count$iv$iv$iv$iv3 = $i$f$getKeyInputOLwlOKw2;
                    node$iv$iv$iv9 = node$iv$iv;
                }
                return 0;
            } else {
            }
            androidx.compose.ui.focus.FocusTargetNode focusTargetNode2 = $i$f$dispatchForKind6rFNWt0;
            int i12 = 0;
            IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException(count$iv$iv$iv$iv3.toString());
            throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
        }
        int i8 = 0;
        IllegalStateException $i$a$CheckFocusOwnerImpl$dispatchKeyEvent$1 = new IllegalStateException("Dispatching key event while focus system is invalidated.".toString());
        throw $i$a$CheckFocusOwnerImpl$dispatchKeyEvent$1;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        Object capacity$iv$iv$iv$iv2;
        int count$iv$iv$iv$iv3;
        int count$iv$iv$iv$iv;
        int tail$ui_release2;
        Modifier.Node capacity$iv$iv$iv$iv;
        int tail$ui_release;
        androidx.compose.ui.focus.FocusTargetNode $i$f$dispatchForKind6rFNWt02;
        int $i$f$getRotaryInputOLwlOKw;
        int $i$f$dispatchForKind6rFNWt0;
        Modifier.Node node$iv$iv$iv$iv4;
        Modifier.Node node$iv$iv$iv$iv2;
        int stack$iv$iv;
        int index$iv$iv;
        int node$iv$iv$iv2;
        int i12;
        int count$iv$iv$iv;
        int node$iv$iv$iv$iv3;
        Modifier.Node node$iv$iv;
        int i6;
        Modifier.Node next$iv$iv$iv;
        int count$iv$iv;
        Object obj;
        int result$iv$iv;
        int onPreRotaryScrollEvent;
        androidx.compose.ui.focus.FocusTargetNode node$iv$iv$iv;
        int i4;
        int i8;
        androidx.compose.ui.focus.FocusTargetNode this_$iv$iv$iv;
        int $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        int $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        Modifier.Node layout$iv$iv$iv$iv;
        LayoutNode layout$iv$iv$iv;
        int i11;
        Modifier.Node head$ui_release;
        Modifier.Node node4;
        int i5;
        Modifier.Node node;
        int i3;
        int node$iv$iv$iv$iv;
        int $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
        int i7;
        int arrayList;
        Modifier.Node node$iv$iv$iv$iv$iv;
        Modifier.Node node3;
        int i10;
        int type$iv;
        int this_$iv$iv$iv$iv$iv;
        int i;
        int count$iv$iv$iv$iv2;
        androidx.compose.ui.focus.FocusTargetNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
        int i9;
        Modifier.Node node2;
        int i2;
        Modifier.Node node5;
        capacity$iv$iv$iv$iv2 = this;
        final RotaryScrollEvent rotaryScrollEvent = event;
        if (capacity$iv$iv$iv$iv2.focusInvalidationManager.hasPendingInvalidation()) {
        } else {
            $i$f$dispatchForKind6rFNWt02 = FocusTraversalKt.findActiveFocusNode(capacity$iv$iv$iv$iv2.rootFocusNode);
            index$iv$iv = "visitAncestors called on an unattached node";
            node$iv$iv$iv2 = 16384;
            node$iv$iv$iv$iv3 = 0;
            i6 = 1;
            if ($i$f$dispatchForKind6rFNWt02 != null) {
                int i19 = 0;
                count$iv$iv = NodeKind.constructor-impl(node$iv$iv$iv2);
                obj = this;
                result$iv$iv = 0;
                onPreRotaryScrollEvent = 1;
                i4 = 0;
                i8 = count$iv$iv;
                this_$iv$iv$iv = node$iv$iv$iv;
                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = 0;
                if (!this_$iv$iv$iv.getNode().isAttached()) {
                } else {
                    layout$iv$iv$iv$iv = this_$iv$iv$iv.getNode();
                    layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(this_$iv$iv$iv);
                    while (layout$iv$iv$iv != null) {
                        if (aggregateChildKindSet$ui_release2 &= i8 == 0) {
                            break;
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv2;
                        layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                        capacity$iv$iv$iv$iv2 = layout$iv$iv$iv.getNodes$ui_release();
                        if (layout$iv$iv$iv != null && capacity$iv$iv$iv$iv2 != null) {
                        } else {
                        }
                        tail$ui_release = 0;
                        layout$iv$iv$iv$iv = tail$ui_release;
                        i6 = 1;
                        capacity$iv$iv$iv$iv2 = this;
                        node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        capacity$iv$iv$iv$iv2 = layout$iv$iv$iv.getNodes$ui_release();
                        if (capacity$iv$iv$iv$iv2 != null) {
                        } else {
                        }
                        tail$ui_release = capacity$iv$iv$iv$iv2.getTail$ui_release();
                        while (layout$iv$iv$iv$iv != null) {
                            if (kindSet$ui_release6 &= i8 == 0) {
                                break loop_6;
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv2;
                            layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                            i6 = 1;
                            capacity$iv$iv$iv$iv2 = this;
                            node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i5 = 0;
                            i3 = 0;
                            node$iv$iv$iv$iv = 0;
                            int i27 = 0;
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv2;
                            node$iv$iv$iv2 = node5;
                            while (node$iv$iv$iv2 != null) {
                                i7 = 0;
                                if (kindSet$ui_release8 &= count$iv$iv != 0) {
                                } else {
                                }
                                count$iv$iv$iv = node$iv$iv$iv$iv3;
                                if (count$iv$iv$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                node$iv$iv$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i6 = 1;
                                if (node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv$iv = 0;
                                arrayList = 0;
                                node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv$iv != null) {
                                    node3 = node$iv$iv$iv$iv$iv;
                                    i10 = 0;
                                    i = 0;
                                    if (kindSet$ui_release9 &= count$iv$iv != 0) {
                                    } else {
                                    }
                                    type$iv = node$iv$iv$iv$iv3;
                                    if (type$iv != 0) {
                                    } else {
                                    }
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                    next$iv$iv$iv = node3;
                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                    capacity$iv$iv$iv$iv2 = this;
                                    $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                    i6 = 1;
                                    if (count$iv$iv$iv++ == i6) {
                                    } else {
                                    }
                                    if (node$iv$iv$iv$iv == 0) {
                                    } else {
                                    }
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                    capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv;
                                    $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv2;
                                    if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                                    }
                                    if (capacity$iv$iv$iv$iv2 != 0) {
                                    } else {
                                    }
                                    next$iv$iv$iv = node3;
                                    node$iv$iv$iv$iv = capacity$iv$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv2.add(node3);
                                    if (capacity$iv$iv$iv$iv2 != 0) {
                                    }
                                    node$iv$iv$iv2 = 0;
                                    capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                                    type$iv = 0;
                                    count$iv$iv$iv$iv2 = 0;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                    capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv3);
                                    node$iv$iv$iv2 = node3;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                    next$iv$iv$iv = node3;
                                    type$iv = i6;
                                }
                                if (count$iv$iv$iv == 1) {
                                } else {
                                }
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i6 = 1;
                                node3 = node$iv$iv$iv$iv$iv;
                                i10 = 0;
                                i = 0;
                                if (kindSet$ui_release9 &= count$iv$iv != 0) {
                                } else {
                                }
                                type$iv = node$iv$iv$iv$iv3;
                                if (type$iv != 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node3;
                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i6 = 1;
                                if (count$iv$iv$iv++ == i6) {
                                } else {
                                }
                                if (node$iv$iv$iv$iv == 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv;
                                $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv2;
                                if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                                }
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                } else {
                                }
                                next$iv$iv$iv = node3;
                                node$iv$iv$iv$iv = capacity$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv2.add(node3);
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                }
                                node$iv$iv$iv2 = 0;
                                capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                                type$iv = 0;
                                count$iv$iv$iv$iv2 = 0;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv3);
                                node$iv$iv$iv2 = node3;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node3;
                                type$iv = i6;
                                count$iv$iv$iv = i6;
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            i7 = 0;
                            if (kindSet$ui_release8 &= count$iv$iv != 0) {
                            } else {
                            }
                            count$iv$iv$iv = node$iv$iv$iv$iv3;
                            if (count$iv$iv$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            node$iv$iv$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i6 = 1;
                            if (node$iv$iv$iv2 instanceof DelegatingNode) {
                            } else {
                            }
                            count$iv$iv$iv = 0;
                            arrayList = 0;
                            node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                            while (node$iv$iv$iv$iv$iv != null) {
                                node3 = node$iv$iv$iv$iv$iv;
                                i10 = 0;
                                i = 0;
                                if (kindSet$ui_release9 &= count$iv$iv != 0) {
                                } else {
                                }
                                type$iv = node$iv$iv$iv$iv3;
                                if (type$iv != 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node3;
                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i6 = 1;
                                if (count$iv$iv$iv++ == i6) {
                                } else {
                                }
                                if (node$iv$iv$iv$iv == 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv;
                                $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv2;
                                if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                                }
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                } else {
                                }
                                next$iv$iv$iv = node3;
                                node$iv$iv$iv$iv = capacity$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv2.add(node3);
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                }
                                node$iv$iv$iv2 = 0;
                                capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                                type$iv = 0;
                                count$iv$iv$iv$iv2 = 0;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv3);
                                node$iv$iv$iv2 = node3;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node3;
                                type$iv = i6;
                            }
                            if (count$iv$iv$iv == 1) {
                            } else {
                            }
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i6 = 1;
                            node3 = node$iv$iv$iv$iv$iv;
                            i10 = 0;
                            i = 0;
                            if (kindSet$ui_release9 &= count$iv$iv != 0) {
                            } else {
                            }
                            type$iv = node$iv$iv$iv$iv3;
                            if (type$iv != 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node3;
                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i6 = 1;
                            if (count$iv$iv$iv++ == i6) {
                            } else {
                            }
                            if (node$iv$iv$iv$iv == 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv;
                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv2;
                            if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                            }
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node3;
                            node$iv$iv$iv$iv = capacity$iv$iv$iv$iv2;
                            capacity$iv$iv$iv$iv2.add(node3);
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            }
                            node$iv$iv$iv2 = 0;
                            capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                            type$iv = 0;
                            count$iv$iv$iv$iv2 = 0;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv3);
                            node$iv$iv$iv2 = node3;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node3;
                            type$iv = i6;
                            count$iv$iv$iv = i6;
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv2;
                        if (kindSet$ui_release6 &= i8 == 0) {
                            break;
                        } else {
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv2;
                        layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                        i6 = 1;
                        capacity$iv$iv$iv$iv2 = this;
                        node$iv$iv$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        i5 = 0;
                        i3 = 0;
                        node$iv$iv$iv$iv = 0;
                        i27 = 0;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv2;
                        node$iv$iv$iv2 = node5;
                        while (node$iv$iv$iv2 != null) {
                            i7 = 0;
                            if (kindSet$ui_release8 &= count$iv$iv != 0) {
                            } else {
                            }
                            count$iv$iv$iv = node$iv$iv$iv$iv3;
                            if (count$iv$iv$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            node$iv$iv$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i6 = 1;
                            if (node$iv$iv$iv2 instanceof DelegatingNode) {
                            } else {
                            }
                            count$iv$iv$iv = 0;
                            arrayList = 0;
                            node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                            while (node$iv$iv$iv$iv$iv != null) {
                                node3 = node$iv$iv$iv$iv$iv;
                                i10 = 0;
                                i = 0;
                                if (kindSet$ui_release9 &= count$iv$iv != 0) {
                                } else {
                                }
                                type$iv = node$iv$iv$iv$iv3;
                                if (type$iv != 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node3;
                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                capacity$iv$iv$iv$iv2 = this;
                                $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                                i6 = 1;
                                if (count$iv$iv$iv++ == i6) {
                                } else {
                                }
                                if (node$iv$iv$iv$iv == 0) {
                                } else {
                                }
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv;
                                $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv2;
                                if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                                }
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                } else {
                                }
                                next$iv$iv$iv = node3;
                                node$iv$iv$iv$iv = capacity$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv2.add(node3);
                                if (capacity$iv$iv$iv$iv2 != 0) {
                                }
                                node$iv$iv$iv2 = 0;
                                capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                                type$iv = 0;
                                count$iv$iv$iv$iv2 = 0;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv3);
                                node$iv$iv$iv2 = node3;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                                next$iv$iv$iv = node3;
                                type$iv = i6;
                            }
                            if (count$iv$iv$iv == 1) {
                            } else {
                            }
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i6 = 1;
                            node3 = node$iv$iv$iv$iv$iv;
                            i10 = 0;
                            i = 0;
                            if (kindSet$ui_release9 &= count$iv$iv != 0) {
                            } else {
                            }
                            type$iv = node$iv$iv$iv$iv3;
                            if (type$iv != 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node3;
                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i6 = 1;
                            if (count$iv$iv$iv++ == i6) {
                            } else {
                            }
                            if (node$iv$iv$iv$iv == 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv;
                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv2;
                            if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                            }
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node3;
                            node$iv$iv$iv$iv = capacity$iv$iv$iv$iv2;
                            capacity$iv$iv$iv$iv2.add(node3);
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            }
                            node$iv$iv$iv2 = 0;
                            capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                            type$iv = 0;
                            count$iv$iv$iv$iv2 = 0;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv3);
                            node$iv$iv$iv2 = node3;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node3;
                            type$iv = i6;
                            count$iv$iv$iv = i6;
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        i7 = 0;
                        if (kindSet$ui_release8 &= count$iv$iv != 0) {
                        } else {
                        }
                        count$iv$iv$iv = node$iv$iv$iv$iv3;
                        if (count$iv$iv$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        node$iv$iv$iv2 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                        capacity$iv$iv$iv$iv2 = this;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        i6 = 1;
                        if (node$iv$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv$iv = 0;
                        arrayList = 0;
                        node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv$iv$iv != null) {
                            node3 = node$iv$iv$iv$iv$iv;
                            i10 = 0;
                            i = 0;
                            if (kindSet$ui_release9 &= count$iv$iv != 0) {
                            } else {
                            }
                            type$iv = node$iv$iv$iv$iv3;
                            if (type$iv != 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node3;
                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                            capacity$iv$iv$iv$iv2 = this;
                            $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                            i6 = 1;
                            if (count$iv$iv$iv++ == i6) {
                            } else {
                            }
                            if (node$iv$iv$iv$iv == 0) {
                            } else {
                            }
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv;
                            $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv2;
                            if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                            }
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node3;
                            node$iv$iv$iv$iv = capacity$iv$iv$iv$iv2;
                            capacity$iv$iv$iv$iv2.add(node3);
                            if (capacity$iv$iv$iv$iv2 != 0) {
                            }
                            node$iv$iv$iv2 = 0;
                            capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                            type$iv = 0;
                            count$iv$iv$iv$iv2 = 0;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv3);
                            node$iv$iv$iv2 = node3;
                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                            next$iv$iv$iv = node3;
                            type$iv = i6;
                        }
                        if (count$iv$iv$iv == 1) {
                        } else {
                        }
                        capacity$iv$iv$iv$iv2 = this;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        i6 = 1;
                        node3 = node$iv$iv$iv$iv$iv;
                        i10 = 0;
                        i = 0;
                        if (kindSet$ui_release9 &= count$iv$iv != 0) {
                        } else {
                        }
                        type$iv = node$iv$iv$iv$iv3;
                        if (type$iv != 0) {
                        } else {
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        next$iv$iv$iv = node3;
                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                        capacity$iv$iv$iv$iv2 = this;
                        $i$f$dispatchForKind6rFNWt02 = $this$nearestAncestorIncludingSelf_u2d64DMado$iv;
                        i6 = 1;
                        if (count$iv$iv$iv++ == i6) {
                        } else {
                        }
                        if (node$iv$iv$iv$iv == 0) {
                        } else {
                        }
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv;
                        $i$f$dispatchForKind6rFNWt02 = node$iv$iv$iv2;
                        if ($i$f$dispatchForKind6rFNWt02 != null && capacity$iv$iv$iv$iv2 != 0) {
                        }
                        if (capacity$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node3;
                        node$iv$iv$iv$iv = capacity$iv$iv$iv$iv2;
                        capacity$iv$iv$iv$iv2.add(node3);
                        if (capacity$iv$iv$iv$iv2 != 0) {
                        }
                        node$iv$iv$iv2 = 0;
                        capacity$iv$iv$iv$iv2.add($i$f$dispatchForKind6rFNWt02);
                        type$iv = 0;
                        count$iv$iv$iv$iv2 = 0;
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        capacity$iv$iv$iv$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv$iv3);
                        node$iv$iv$iv2 = node3;
                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                        next$iv$iv$iv = node3;
                        type$iv = i6;
                        count$iv$iv$iv = i6;
                    }
                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = $i$f$dispatchForKind6rFNWt02;
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv2;
                    i12 = 0;
                    if (i12 != 0) {
                        count$iv$iv$iv$iv3 = i12;
                        int i15 = 0;
                        $i$f$getRotaryInputOLwlOKw = NodeKind.constructor-impl($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv);
                        node$iv$iv$iv2 = this;
                        i6 = 0;
                        obj = 0;
                        result$iv$iv = 0;
                        node$iv$iv$iv = 0;
                        i4 = 0;
                        i8 = $i$f$getRotaryInputOLwlOKw;
                        this_$iv$iv$iv = onPreRotaryScrollEvent;
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv = 0;
                        if (!this_$iv$iv$iv.getNode().isAttached()) {
                        } else {
                            node$iv$iv$iv$iv4 = this_$iv$iv$iv.getNode().getParent$ui_release();
                            layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(this_$iv$iv$iv);
                            while (layout$iv$iv$iv$iv != null) {
                                if (aggregateChildKindSet$ui_release &= i8 != 0) {
                                } else {
                                }
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                type$iv = $i$f$getRotaryInputOLwlOKw;
                                layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
                                count$iv$iv$iv$iv3 = layout$iv$iv$iv$iv.getNodes$ui_release();
                                if (layout$iv$iv$iv$iv != null && count$iv$iv$iv$iv3 != null) {
                                } else {
                                }
                                tail$ui_release2 = 0;
                                node$iv$iv$iv$iv4 = tail$ui_release2;
                                count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                $i$f$getRotaryInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv3 = 0;
                                count$iv$iv$iv$iv3 = layout$iv$iv$iv$iv.getNodes$ui_release();
                                if (count$iv$iv$iv$iv3 != null) {
                                } else {
                                }
                                tail$ui_release2 = count$iv$iv$iv$iv3.getTail$ui_release();
                                while (node$iv$iv$iv$iv4 != null) {
                                    if (kindSet$ui_release5 &= i8 != 0) {
                                    } else {
                                    }
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv4 = node2.getParent$ui_release();
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getRotaryInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv3 = 0;
                                    node4 = 0;
                                    node = 0;
                                    i3 = 0;
                                    int i24 = 0;
                                    node$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                                    while (node$iv$iv$iv$iv3 != null) {
                                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                        if (node$iv$iv$iv$iv3 instanceof RotaryInputModifierNode) {
                                        } else {
                                        }
                                        i7 = 0;
                                        if (kindSet$ui_release7 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv = 0;
                                        if (count$iv$iv$iv$iv != 0 && node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                        } else {
                                        }
                                        type$iv = $i$f$getRotaryInputOLwlOKw;
                                        node2 = node$iv$iv$iv$iv4;
                                        node$iv$iv$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                                        count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                        $i$f$getRotaryInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv4 = node2;
                                        if (node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv = 0;
                                        arrayList = 0;
                                        node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv3.getDelegate$ui_release();
                                        while (node$iv$iv$iv$iv$iv != null) {
                                            node3 = node$iv$iv$iv$iv$iv;
                                            i10 = 0;
                                            count$iv$iv$iv$iv2 = 0;
                                            if (kindSet$ui_release10 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                            } else {
                                            }
                                            this_$iv$iv$iv$iv$iv = 0;
                                            if (this_$iv$iv$iv$iv$iv != 0) {
                                            } else {
                                            }
                                            type$iv = $i$f$getRotaryInputOLwlOKw;
                                            node2 = node$iv$iv$iv$iv4;
                                            node$iv$iv$iv$iv2 = node3;
                                            node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                            $i$f$getRotaryInputOLwlOKw = type$iv;
                                            node$iv$iv$iv$iv4 = node2;
                                            count$iv$iv$iv$iv++;
                                            type$iv = $i$f$getRotaryInputOLwlOKw;
                                            if (count$iv$iv$iv$iv == 1) {
                                            } else {
                                            }
                                            if (i3 == 0) {
                                            } else {
                                            }
                                            count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                            node2 = node$iv$iv$iv$iv4;
                                            $i$f$getRotaryInputOLwlOKw = i3;
                                            Modifier.Node node7 = node$iv$iv$iv$iv3;
                                            if (node7 != null && $i$f$getRotaryInputOLwlOKw != 0) {
                                            }
                                            if ($i$f$getRotaryInputOLwlOKw != 0) {
                                            } else {
                                            }
                                            node$iv$iv$iv$iv2 = node3;
                                            i3 = $i$f$getRotaryInputOLwlOKw;
                                            count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                            $i$f$getRotaryInputOLwlOKw.add(node3);
                                            if ($i$f$getRotaryInputOLwlOKw != 0) {
                                            }
                                            node$iv$iv$iv$iv3 = node$iv$iv$iv$iv4;
                                            $i$f$getRotaryInputOLwlOKw.add(node7);
                                            count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                            int count$iv$iv$iv$iv4 = 16;
                                            $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                            i9 = i16;
                                            node2 = node$iv$iv$iv$iv4;
                                            i2 = count$iv$iv$iv$iv4;
                                            $i$f$getRotaryInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                            node$iv$iv$iv$iv3 = node3;
                                            node2 = node$iv$iv$iv$iv4;
                                            node$iv$iv$iv$iv2 = node3;
                                            this_$iv$iv$iv$iv$iv = 1;
                                        }
                                        if (count$iv$iv$iv$iv == 1) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                        $i$f$getRotaryInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv4 = node2;
                                        node3 = node$iv$iv$iv$iv$iv;
                                        i10 = 0;
                                        count$iv$iv$iv$iv2 = 0;
                                        if (kindSet$ui_release10 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv$iv = 0;
                                        if (this_$iv$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        type$iv = $i$f$getRotaryInputOLwlOKw;
                                        node2 = node$iv$iv$iv$iv4;
                                        node$iv$iv$iv$iv2 = node3;
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                        $i$f$getRotaryInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv4 = node2;
                                        count$iv$iv$iv$iv++;
                                        type$iv = $i$f$getRotaryInputOLwlOKw;
                                        if (count$iv$iv$iv$iv == 1) {
                                        } else {
                                        }
                                        if (i3 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        node2 = node$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw = i3;
                                        node7 = node$iv$iv$iv$iv3;
                                        if (node7 != null && $i$f$getRotaryInputOLwlOKw != 0) {
                                        }
                                        if ($i$f$getRotaryInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        node$iv$iv$iv$iv2 = node3;
                                        i3 = $i$f$getRotaryInputOLwlOKw;
                                        count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                        $i$f$getRotaryInputOLwlOKw.add(node3);
                                        if ($i$f$getRotaryInputOLwlOKw != 0) {
                                        }
                                        node$iv$iv$iv$iv3 = node$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw.add(node7);
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        count$iv$iv$iv$iv4 = 16;
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                        i9 = i16;
                                        node2 = node$iv$iv$iv$iv4;
                                        i2 = count$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                        node$iv$iv$iv$iv3 = node3;
                                        node2 = node$iv$iv$iv$iv4;
                                        node$iv$iv$iv$iv2 = node3;
                                        this_$iv$iv$iv$iv$iv = 1;
                                        count$iv$iv$iv$iv = 1;
                                        i7 = 0;
                                        if (result$iv$iv == 0) {
                                        }
                                        result$iv$iv.add(node$iv$iv$iv$iv3);
                                        type$iv = $i$f$getRotaryInputOLwlOKw;
                                        node2 = node$iv$iv$iv$iv4;
                                        arrayList = new ArrayList();
                                        result$iv$iv = arrayList;
                                    }
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                    if (node$iv$iv$iv$iv3 instanceof RotaryInputModifierNode) {
                                    } else {
                                    }
                                    i7 = 0;
                                    if (kindSet$ui_release7 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv = 0;
                                    if (count$iv$iv$iv$iv != 0 && node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getRotaryInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv4 = node2;
                                    if (node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv = 0;
                                    arrayList = 0;
                                    node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv3.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        node3 = node$iv$iv$iv$iv$iv;
                                        i10 = 0;
                                        count$iv$iv$iv$iv2 = 0;
                                        if (kindSet$ui_release10 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv$iv = 0;
                                        if (this_$iv$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        type$iv = $i$f$getRotaryInputOLwlOKw;
                                        node2 = node$iv$iv$iv$iv4;
                                        node$iv$iv$iv$iv2 = node3;
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                        $i$f$getRotaryInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv4 = node2;
                                        count$iv$iv$iv$iv++;
                                        type$iv = $i$f$getRotaryInputOLwlOKw;
                                        if (count$iv$iv$iv$iv == 1) {
                                        } else {
                                        }
                                        if (i3 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        node2 = node$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw = i3;
                                        node7 = node$iv$iv$iv$iv3;
                                        if (node7 != null && $i$f$getRotaryInputOLwlOKw != 0) {
                                        }
                                        if ($i$f$getRotaryInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        node$iv$iv$iv$iv2 = node3;
                                        i3 = $i$f$getRotaryInputOLwlOKw;
                                        count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                        $i$f$getRotaryInputOLwlOKw.add(node3);
                                        if ($i$f$getRotaryInputOLwlOKw != 0) {
                                        }
                                        node$iv$iv$iv$iv3 = node$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw.add(node7);
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        count$iv$iv$iv$iv4 = 16;
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                        i9 = i16;
                                        node2 = node$iv$iv$iv$iv4;
                                        i2 = count$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                        node$iv$iv$iv$iv3 = node3;
                                        node2 = node$iv$iv$iv$iv4;
                                        node$iv$iv$iv$iv2 = node3;
                                        this_$iv$iv$iv$iv$iv = 1;
                                    }
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getRotaryInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv4 = node2;
                                    node3 = node$iv$iv$iv$iv$iv;
                                    i10 = 0;
                                    count$iv$iv$iv$iv2 = 0;
                                    if (kindSet$ui_release10 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv2 = node3;
                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                    $i$f$getRotaryInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv4 = node2;
                                    count$iv$iv$iv$iv++;
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    if (i3 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    node2 = node$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw = i3;
                                    node7 = node$iv$iv$iv$iv3;
                                    if (node7 != null && $i$f$getRotaryInputOLwlOKw != 0) {
                                    }
                                    if ($i$f$getRotaryInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    node$iv$iv$iv$iv2 = node3;
                                    i3 = $i$f$getRotaryInputOLwlOKw;
                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                    $i$f$getRotaryInputOLwlOKw.add(node3);
                                    if ($i$f$getRotaryInputOLwlOKw != 0) {
                                    }
                                    node$iv$iv$iv$iv3 = node$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw.add(node7);
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    count$iv$iv$iv$iv4 = 16;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                    i9 = i16;
                                    node2 = node$iv$iv$iv$iv4;
                                    i2 = count$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                    node$iv$iv$iv$iv3 = node3;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv2 = node3;
                                    this_$iv$iv$iv$iv$iv = 1;
                                    count$iv$iv$iv$iv = 1;
                                    i7 = 0;
                                    if (result$iv$iv == 0) {
                                    }
                                    result$iv$iv.add(node$iv$iv$iv$iv3);
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    arrayList = new ArrayList();
                                    result$iv$iv = arrayList;
                                }
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                type$iv = $i$f$getRotaryInputOLwlOKw;
                                node2 = node$iv$iv$iv$iv4;
                                if (kindSet$ui_release5 &= i8 != 0) {
                                } else {
                                }
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                type$iv = $i$f$getRotaryInputOLwlOKw;
                                node2 = node$iv$iv$iv$iv4;
                                node$iv$iv$iv$iv4 = node2.getParent$ui_release();
                                count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                $i$f$getRotaryInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv3 = 0;
                                node4 = 0;
                                node = 0;
                                i3 = 0;
                                i24 = 0;
                                node$iv$iv$iv$iv3 = node$iv$iv$iv$iv;
                                while (node$iv$iv$iv$iv3 != null) {
                                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                    if (node$iv$iv$iv$iv3 instanceof RotaryInputModifierNode) {
                                    } else {
                                    }
                                    i7 = 0;
                                    if (kindSet$ui_release7 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv = 0;
                                    if (count$iv$iv$iv$iv != 0 && node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getRotaryInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv4 = node2;
                                    if (node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv = 0;
                                    arrayList = 0;
                                    node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv3.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        node3 = node$iv$iv$iv$iv$iv;
                                        i10 = 0;
                                        count$iv$iv$iv$iv2 = 0;
                                        if (kindSet$ui_release10 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv$iv = 0;
                                        if (this_$iv$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        type$iv = $i$f$getRotaryInputOLwlOKw;
                                        node2 = node$iv$iv$iv$iv4;
                                        node$iv$iv$iv$iv2 = node3;
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                        $i$f$getRotaryInputOLwlOKw = type$iv;
                                        node$iv$iv$iv$iv4 = node2;
                                        count$iv$iv$iv$iv++;
                                        type$iv = $i$f$getRotaryInputOLwlOKw;
                                        if (count$iv$iv$iv$iv == 1) {
                                        } else {
                                        }
                                        if (i3 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        node2 = node$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw = i3;
                                        node7 = node$iv$iv$iv$iv3;
                                        if (node7 != null && $i$f$getRotaryInputOLwlOKw != 0) {
                                        }
                                        if ($i$f$getRotaryInputOLwlOKw != 0) {
                                        } else {
                                        }
                                        node$iv$iv$iv$iv2 = node3;
                                        i3 = $i$f$getRotaryInputOLwlOKw;
                                        count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                        $i$f$getRotaryInputOLwlOKw.add(node3);
                                        if ($i$f$getRotaryInputOLwlOKw != 0) {
                                        }
                                        node$iv$iv$iv$iv3 = node$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw.add(node7);
                                        count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                        count$iv$iv$iv$iv4 = 16;
                                        $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                        i9 = i16;
                                        node2 = node$iv$iv$iv$iv4;
                                        i2 = count$iv$iv$iv$iv4;
                                        $i$f$getRotaryInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                        node$iv$iv$iv$iv3 = node3;
                                        node2 = node$iv$iv$iv$iv4;
                                        node$iv$iv$iv$iv2 = node3;
                                        this_$iv$iv$iv$iv$iv = 1;
                                    }
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                    $i$f$getRotaryInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv4 = node2;
                                    node3 = node$iv$iv$iv$iv$iv;
                                    i10 = 0;
                                    count$iv$iv$iv$iv2 = 0;
                                    if (kindSet$ui_release10 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv2 = node3;
                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                    $i$f$getRotaryInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv4 = node2;
                                    count$iv$iv$iv$iv++;
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    if (i3 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    node2 = node$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw = i3;
                                    node7 = node$iv$iv$iv$iv3;
                                    if (node7 != null && $i$f$getRotaryInputOLwlOKw != 0) {
                                    }
                                    if ($i$f$getRotaryInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    node$iv$iv$iv$iv2 = node3;
                                    i3 = $i$f$getRotaryInputOLwlOKw;
                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                    $i$f$getRotaryInputOLwlOKw.add(node3);
                                    if ($i$f$getRotaryInputOLwlOKw != 0) {
                                    }
                                    node$iv$iv$iv$iv3 = node$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw.add(node7);
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    count$iv$iv$iv$iv4 = 16;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                    i9 = i16;
                                    node2 = node$iv$iv$iv$iv4;
                                    i2 = count$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                    node$iv$iv$iv$iv3 = node3;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv2 = node3;
                                    this_$iv$iv$iv$iv$iv = 1;
                                    count$iv$iv$iv$iv = 1;
                                    i7 = 0;
                                    if (result$iv$iv == 0) {
                                    }
                                    result$iv$iv.add(node$iv$iv$iv$iv3);
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    arrayList = new ArrayList();
                                    result$iv$iv = arrayList;
                                }
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                type$iv = $i$f$getRotaryInputOLwlOKw;
                                node2 = node$iv$iv$iv$iv4;
                                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                                if (node$iv$iv$iv$iv3 instanceof RotaryInputModifierNode) {
                                } else {
                                }
                                i7 = 0;
                                if (kindSet$ui_release7 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                } else {
                                }
                                count$iv$iv$iv$iv = 0;
                                if (count$iv$iv$iv$iv != 0 && node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                } else {
                                }
                                type$iv = $i$f$getRotaryInputOLwlOKw;
                                node2 = node$iv$iv$iv$iv4;
                                node$iv$iv$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                                count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                $i$f$getRotaryInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv4 = node2;
                                if (node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv$iv$iv = 0;
                                arrayList = 0;
                                node$iv$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv3.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv$iv != null) {
                                    node3 = node$iv$iv$iv$iv$iv;
                                    i10 = 0;
                                    count$iv$iv$iv$iv2 = 0;
                                    if (kindSet$ui_release10 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv2 = node3;
                                    node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                    $i$f$getRotaryInputOLwlOKw = type$iv;
                                    node$iv$iv$iv$iv4 = node2;
                                    count$iv$iv$iv$iv++;
                                    type$iv = $i$f$getRotaryInputOLwlOKw;
                                    if (count$iv$iv$iv$iv == 1) {
                                    } else {
                                    }
                                    if (i3 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    node2 = node$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw = i3;
                                    node7 = node$iv$iv$iv$iv3;
                                    if (node7 != null && $i$f$getRotaryInputOLwlOKw != 0) {
                                    }
                                    if ($i$f$getRotaryInputOLwlOKw != 0) {
                                    } else {
                                    }
                                    node$iv$iv$iv$iv2 = node3;
                                    i3 = $i$f$getRotaryInputOLwlOKw;
                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                    $i$f$getRotaryInputOLwlOKw.add(node3);
                                    if ($i$f$getRotaryInputOLwlOKw != 0) {
                                    }
                                    node$iv$iv$iv$iv3 = node$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw.add(node7);
                                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                    count$iv$iv$iv$iv4 = 16;
                                    $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                    i9 = i16;
                                    node2 = node$iv$iv$iv$iv4;
                                    i2 = count$iv$iv$iv$iv4;
                                    $i$f$getRotaryInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                    node$iv$iv$iv$iv3 = node3;
                                    node2 = node$iv$iv$iv$iv4;
                                    node$iv$iv$iv$iv2 = node3;
                                    this_$iv$iv$iv$iv$iv = 1;
                                }
                                if (count$iv$iv$iv$iv == 1) {
                                } else {
                                }
                                count$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
                                $i$f$getRotaryInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv4 = node2;
                                node3 = node$iv$iv$iv$iv$iv;
                                i10 = 0;
                                count$iv$iv$iv$iv2 = 0;
                                if (kindSet$ui_release10 &= $i$f$getRotaryInputOLwlOKw != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv$iv = 0;
                                if (this_$iv$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                type$iv = $i$f$getRotaryInputOLwlOKw;
                                node2 = node$iv$iv$iv$iv4;
                                node$iv$iv$iv$iv2 = node3;
                                node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild$ui_release();
                                $i$f$getRotaryInputOLwlOKw = type$iv;
                                node$iv$iv$iv$iv4 = node2;
                                count$iv$iv$iv$iv++;
                                type$iv = $i$f$getRotaryInputOLwlOKw;
                                if (count$iv$iv$iv$iv == 1) {
                                } else {
                                }
                                if (i3 == 0) {
                                } else {
                                }
                                count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                node2 = node$iv$iv$iv$iv4;
                                $i$f$getRotaryInputOLwlOKw = i3;
                                node7 = node$iv$iv$iv$iv3;
                                if (node7 != null && $i$f$getRotaryInputOLwlOKw != 0) {
                                }
                                if ($i$f$getRotaryInputOLwlOKw != 0) {
                                } else {
                                }
                                node$iv$iv$iv$iv2 = node3;
                                i3 = $i$f$getRotaryInputOLwlOKw;
                                count$iv$iv$iv$iv = count$iv$iv$iv$iv2;
                                $i$f$getRotaryInputOLwlOKw.add(node3);
                                if ($i$f$getRotaryInputOLwlOKw != 0) {
                                }
                                node$iv$iv$iv$iv3 = node$iv$iv$iv$iv4;
                                $i$f$getRotaryInputOLwlOKw.add(node7);
                                count$iv$iv$iv$iv2 = count$iv$iv$iv$iv;
                                count$iv$iv$iv$iv4 = 16;
                                $this$nearestAncestorIncludingSelf_u2d64DMado$iv = 0;
                                i9 = i16;
                                node2 = node$iv$iv$iv$iv4;
                                i2 = count$iv$iv$iv$iv4;
                                $i$f$getRotaryInputOLwlOKw = new MutableVector(new Modifier.Node[count$iv$iv$iv$iv4], 0);
                                node$iv$iv$iv$iv3 = node3;
                                node2 = node$iv$iv$iv$iv4;
                                node$iv$iv$iv$iv2 = node3;
                                this_$iv$iv$iv$iv$iv = 1;
                                count$iv$iv$iv$iv = 1;
                                i7 = 0;
                                if (result$iv$iv == 0) {
                                }
                                result$iv$iv.add(node$iv$iv$iv$iv3);
                                type$iv = $i$f$getRotaryInputOLwlOKw;
                                node2 = node$iv$iv$iv$iv4;
                                arrayList = new ArrayList();
                                result$iv$iv = arrayList;
                            }
                            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = count$iv$iv$iv$iv3;
                            type$iv = $i$f$getRotaryInputOLwlOKw;
                            count$iv$iv$iv$iv3 = result$iv$iv;
                            $i$f$getRotaryInputOLwlOKw = 0;
                            if (result$iv$iv != 0 && size-- >= 0) {
                                count$iv$iv$iv$iv3 = result$iv$iv;
                                $i$f$getRotaryInputOLwlOKw = 0;
                                if (size-- >= 0) {
                                }
                            }
                            $i$f$dispatchForKind6rFNWt0 = 0;
                            stack$iv$iv = 0;
                            int i17 = 0;
                            node$iv$iv = capacity$iv$iv$iv$iv;
                            while (node$iv$iv != null) {
                                obj = 0;
                                if (kindSet$ui_release2 &= type$iv != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                                capacity$iv$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                $i$f$dispatchForKind6rFNWt0 = layout$iv$iv$iv;
                                if (node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv = 0;
                                onPreRotaryScrollEvent = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv != 0) {
                                    i4 = node$iv$iv$iv;
                                    i8 = 0;
                                    int i23 = 0;
                                    if (kindSet$ui_release4 &= type$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                    layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    head$ui_release = stack$iv$iv;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    capacity$iv$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                    $i$f$dispatchForKind6rFNWt0 = layout$iv$iv$iv;
                                    if (count$iv$iv++ == 1) {
                                    } else {
                                    }
                                    if (stack$iv$iv == 0) {
                                    } else {
                                    }
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                    layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    $i$f$dispatchForKind6rFNWt0 = head$ui_release;
                                    stack$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    capacity$iv$iv$iv$iv = node$iv$iv;
                                    if (capacity$iv$iv$iv$iv != null && stack$iv$iv != 0) {
                                    }
                                    if (stack$iv$iv != 0) {
                                    }
                                    stack$iv$iv.add(i4);
                                    if (stack$iv$iv != 0) {
                                    }
                                    node$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    stack$iv$iv.add(capacity$iv$iv$iv$iv);
                                    this_$iv$iv$iv = 0;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                    int $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = 16;
                                    layout$iv$iv$iv$iv = 0;
                                    layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    head$ui_release = stack$iv$iv;
                                    node4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[$this$dispatchForKind_u2d6rFNWt0$iv$iv6], 0);
                                    node$iv$iv = i4;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                    layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                    this_$iv$iv$iv = 1;
                                }
                                head$ui_release = stack$iv$iv;
                                if (count$iv$iv == 1) {
                                } else {
                                }
                                stack$iv$iv = head$ui_release;
                                capacity$iv$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                $i$f$dispatchForKind6rFNWt0 = layout$iv$iv$iv;
                                stack$iv$iv = head$ui_release;
                                i4 = node$iv$iv$iv;
                                i8 = 0;
                                i23 = 0;
                                if (kindSet$ui_release4 &= type$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv = 0;
                                if (this_$iv$iv$iv != 0) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                head$ui_release = stack$iv$iv;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                capacity$iv$iv$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                $i$f$dispatchForKind6rFNWt0 = layout$iv$iv$iv;
                                if (count$iv$iv++ == 1) {
                                } else {
                                }
                                if (stack$iv$iv == 0) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                $i$f$dispatchForKind6rFNWt0 = head$ui_release;
                                stack$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                capacity$iv$iv$iv$iv = node$iv$iv;
                                if (capacity$iv$iv$iv$iv != null && stack$iv$iv != 0) {
                                }
                                if (stack$iv$iv != 0) {
                                }
                                stack$iv$iv.add(i4);
                                if (stack$iv$iv != 0) {
                                }
                                node$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                stack$iv$iv.add(capacity$iv$iv$iv$iv);
                                this_$iv$iv$iv = 0;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = 16;
                                layout$iv$iv$iv$iv = 0;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                head$ui_release = stack$iv$iv;
                                node4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                $i$f$dispatchForKind6rFNWt0 = new MutableVector(new Modifier.Node[$this$dispatchForKind_u2d6rFNWt0$iv$iv6], 0);
                                node$iv$iv = i4;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                                this_$iv$iv$iv = 1;
                                count$iv$iv = 1;
                                obj = 0;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv = capacity$iv$iv$iv$iv;
                                layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt0;
                            }
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv;
                            i11 = $i$f$dispatchForKind6rFNWt0;
                            int $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = 0;
                            $i$f$dispatchForKind6rFNWt02 = 0;
                            index$iv$iv = 0;
                            int i18 = 0;
                            node$iv$iv$iv$iv3 = capacity$iv$iv$iv$iv2;
                            while (node$iv$iv$iv$iv3 != null) {
                                obj = 0;
                                if (kindSet$ui_release &= type$iv != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0 && node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                i11 = $i$f$dispatchForKind6rFNWt02;
                                node$iv$iv$iv$iv3 = DelegatableNodeKt.access$pop(index$iv$iv);
                                capacity$iv$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                $i$f$dispatchForKind6rFNWt02 = i11;
                                if (node$iv$iv$iv$iv3 instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv = 0;
                                onPreRotaryScrollEvent = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv$iv$iv3.getDelegate$ui_release();
                                while (node$iv$iv$iv != 0) {
                                    i4 = node$iv$iv$iv;
                                    i8 = 0;
                                    int i22 = 0;
                                    if (kindSet$ui_release3 &= type$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                    i11 = $i$f$dispatchForKind6rFNWt02;
                                    head$ui_release = index$iv$iv;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    capacity$iv$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                    $i$f$dispatchForKind6rFNWt02 = i11;
                                    if (count$iv$iv++ == 1) {
                                    } else {
                                    }
                                    if (index$iv$iv == 0) {
                                    } else {
                                    }
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                    i11 = $i$f$dispatchForKind6rFNWt02;
                                    $i$f$dispatchForKind6rFNWt02 = head$ui_release;
                                    index$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                    capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                                    if (capacity$iv$iv$iv$iv2 != null && index$iv$iv != 0) {
                                    }
                                    if (index$iv$iv != 0) {
                                    }
                                    index$iv$iv.add(i4);
                                    if (index$iv$iv != 0) {
                                    }
                                    node$iv$iv$iv$iv3 = $i$f$dispatchForKind6rFNWt02;
                                    index$iv$iv.add(capacity$iv$iv$iv$iv2);
                                    this_$iv$iv$iv = 0;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                    int $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = 16;
                                    layout$iv$iv$iv$iv = 0;
                                    i11 = $i$f$dispatchForKind6rFNWt02;
                                    head$ui_release = index$iv$iv;
                                    node4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                    $i$f$dispatchForKind6rFNWt02 = new MutableVector(new Modifier.Node[$this$dispatchForKind_u2d6rFNWt0$iv$iv5], 0);
                                    node$iv$iv$iv$iv3 = i4;
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                    i11 = $i$f$dispatchForKind6rFNWt02;
                                    this_$iv$iv$iv = 1;
                                }
                                head$ui_release = index$iv$iv;
                                if (count$iv$iv == 1) {
                                } else {
                                }
                                index$iv$iv = head$ui_release;
                                capacity$iv$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                $i$f$dispatchForKind6rFNWt02 = i11;
                                index$iv$iv = head$ui_release;
                                i4 = node$iv$iv$iv;
                                i8 = 0;
                                i22 = 0;
                                if (kindSet$ui_release3 &= type$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv = 0;
                                if (this_$iv$iv$iv != 0) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                i11 = $i$f$dispatchForKind6rFNWt02;
                                head$ui_release = index$iv$iv;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                capacity$iv$iv$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                                $i$f$dispatchForKind6rFNWt02 = i11;
                                if (count$iv$iv++ == 1) {
                                } else {
                                }
                                if (index$iv$iv == 0) {
                                } else {
                                }
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                i11 = $i$f$dispatchForKind6rFNWt02;
                                $i$f$dispatchForKind6rFNWt02 = head$ui_release;
                                index$iv$iv = $i$f$dispatchForKind6rFNWt02;
                                capacity$iv$iv$iv$iv2 = node$iv$iv$iv$iv3;
                                if (capacity$iv$iv$iv$iv2 != null && index$iv$iv != 0) {
                                }
                                if (index$iv$iv != 0) {
                                }
                                index$iv$iv.add(i4);
                                if (index$iv$iv != 0) {
                                }
                                node$iv$iv$iv$iv3 = $i$f$dispatchForKind6rFNWt02;
                                index$iv$iv.add(capacity$iv$iv$iv$iv2);
                                this_$iv$iv$iv = 0;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = 16;
                                layout$iv$iv$iv$iv = 0;
                                i11 = $i$f$dispatchForKind6rFNWt02;
                                head$ui_release = index$iv$iv;
                                node4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                $i$f$dispatchForKind6rFNWt02 = new MutableVector(new Modifier.Node[$this$dispatchForKind_u2d6rFNWt0$iv$iv5], 0);
                                node$iv$iv$iv$iv3 = i4;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                i11 = $i$f$dispatchForKind6rFNWt02;
                                this_$iv$iv$iv = 1;
                                count$iv$iv = 1;
                                obj = 0;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = capacity$iv$iv$iv$iv2;
                                i11 = $i$f$dispatchForKind6rFNWt02;
                            }
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = capacity$iv$iv$iv$iv2;
                            layout$iv$iv$iv = $i$f$dispatchForKind6rFNWt02;
                            if (result$iv$iv != 0) {
                                capacity$iv$iv$iv$iv2 = result$iv$iv;
                                $i$f$dispatchForKind6rFNWt02 = 0;
                                index$iv$iv = 0;
                                while (index$iv$iv < capacity$iv$iv$iv$iv2.size()) {
                                    onPreRotaryScrollEvent = 0;
                                    i = 1;
                                    index$iv$iv++;
                                }
                            }
                        }
                        int i26 = count$iv$iv$iv$iv3;
                        int i28 = $i$f$getRotaryInputOLwlOKw;
                        int $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3 = 0;
                        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv$iv = new IllegalStateException(index$iv$iv.toString());
                        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv$iv;
                    }
                    return 0;
                }
                androidx.compose.ui.focus.FocusTargetNode focusTargetNode = $i$f$dispatchForKind6rFNWt02;
                int i14 = 0;
                IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException(index$iv$iv.toString());
                throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
            }
            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = node$iv$iv$iv2;
            i12 = 0;
        }
        int i13 = 0;
        IllegalStateException $i$a$CheckFocusOwnerImpl$dispatchRotaryEvent$1 = new IllegalStateException("Dispatching rotary event while focus system is invalidated.".toString());
        throw $i$a$CheckFocusOwnerImpl$dispatchRotaryEvent$1;
    }

    public Boolean focusSearch-ULY8qGw(int focusDirection, Rect focusedRect, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        int activeFocusNode;
        int equal2;
        androidx.compose.ui.focus.FocusTargetNode focusTargetNode;
        int i;
        androidx.compose.ui.focus.FocusRequester customFocusSearch--OM-vw8;
        boolean equal;
        activeFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        equal2 = 0;
        if (activeFocusNode != null) {
            i = 0;
            customFocusSearch--OM-vw8 = FocusTraversalKt.customFocusSearch--OM-vw8(activeFocusNode, focusDirection, (LayoutDirection)this.onLayoutDirection.invoke());
            if (Intrinsics.areEqual(customFocusSearch--OM-vw8, FocusRequester.Companion.getCancel())) {
                return equal2;
            }
            if (!Intrinsics.areEqual(customFocusSearch--OM-vw8, FocusRequester.Companion.getDefault())) {
                return Boolean.valueOf(customFocusSearch--OM-vw8.findFocusTargetNode$ui_release(onFound));
            }
        } else {
            activeFocusNode = equal2;
        }
        FocusOwnerImpl.focusSearch.1 anon = new FocusOwnerImpl.focusSearch.1(activeFocusNode, this, onFound);
        return FocusTraversalKt.focusSearch-0X8WOeE(this.rootFocusNode, focusDirection, (LayoutDirection)this.onLayoutDirection.invoke(), focusedRect, (Function1)anon);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        Rect focusRect;
        androidx.compose.ui.focus.FocusTargetNode activeFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (activeFocusNode != null) {
            focusRect = FocusTraversalKt.focusRect(activeFocusNode);
        } else {
            focusRect = 0;
        }
        return focusRect;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public androidx.compose.ui.focus.FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final androidx.compose.ui.focus.FocusTargetNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public androidx.compose.ui.focus.FocusState getRootState() {
        return (FocusState)this.rootFocusNode.getFocusState();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean moveFocus-3ESFkO8(int focusDirection) {
        int i;
        Object element;
        boolean equal;
        Boolean takeFocus-aToIllA;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        i = 0;
        objectRef.element = Boolean.valueOf(i);
        element = new FocusOwnerImpl.moveFocus.focusSearchSuccess.1(objectRef, focusDirection);
        Boolean focusSearch-ULY8qGw = focusSearch-ULY8qGw(focusDirection, (Rect)this.onFocusRectInterop.invoke(), (Function1)element);
        if (focusSearch-ULY8qGw != null) {
            if (objectRef.element == null) {
            } else {
                int i2 = 1;
                if (Intrinsics.areEqual(focusSearch-ULY8qGw, Boolean.valueOf(i2)) && Intrinsics.areEqual(objectRef.element, Boolean.valueOf(i2))) {
                    if (Intrinsics.areEqual(objectRef.element, Boolean.valueOf(i2))) {
                        return i2;
                    }
                }
                if (FocusOwnerImplKt.is1dFocusSearch-3ESFkO8(focusDirection) && clearFocus-I7lrPNg(i, i2, i, focusDirection) && takeFocus-aToIllA(focusDirection, 0)) {
                    if (clearFocus-I7lrPNg(i, i2, i, focusDirection)) {
                        if (takeFocus-aToIllA(focusDirection, 0)) {
                            i = i2;
                        }
                    }
                    return i;
                }
            }
            return (Boolean)this.onMoveFocusInterop.invoke(FocusDirection.box-impl(focusDirection)).booleanValue();
        }
        return i;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        int i;
        androidx.compose.ui.focus.FocusTargetNode rootFocusNode;
        final androidx.compose.ui.focus.FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 1;
        if (FocusTransactionManager.access$getOngoingTransaction$p(focusTransactionManager)) {
            i = 0;
            FocusTransactionsKt.clearFocus(this.rootFocusNode, i4, i4);
        } else {
            FocusTransactionManager.access$beginTransaction(focusTransactionManager);
            i = 0;
            FocusTransactionsKt.clearFocus(this.rootFocusNode, i4, i4);
            FocusTransactionManager.access$commitTransaction(focusTransactionManager);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean requestFocusForOwner-7o62pno(androidx.compose.ui.focus.FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return (Boolean)this.onRequestFocusForOwner.invoke(focusDirection, previouslyFocusedRect).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(androidx.compose.ui.focus.FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(androidx.compose.ui.focus.FocusPropertiesModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(androidx.compose.ui.focus.FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final void setRootFocusNode$ui_release(androidx.compose.ui.focus.FocusTargetNode <set-?>) {
        this.rootFocusNode = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean takeFocus-aToIllA(int focusDirection, Rect previouslyFocusedRect) {
        boolean booleanValue;
        FocusOwnerImpl.takeFocus.1 anon = new FocusOwnerImpl.takeFocus.1(focusDirection);
        Boolean focusSearch-ULY8qGw = focusSearch-ULY8qGw(focusDirection, previouslyFocusedRect, (Function1)anon);
        if (focusSearch-ULY8qGw != null) {
            booleanValue = focusSearch-ULY8qGw.booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }
}
