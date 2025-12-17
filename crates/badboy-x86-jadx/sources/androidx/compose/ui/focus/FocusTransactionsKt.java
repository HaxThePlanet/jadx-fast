package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u000c\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000c\u0010\u0008\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u000e\u001a\u001e\u0010\u0011\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u000e\u001a\u001e\u0010\u0013\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u000e\u001a\u000c\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000c\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0002\u001a\u000c\u0010\u001b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u000c\u0010\u001c\u001a\u00020\u0002*\u00020\u0002H\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "performCustomClearFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "performCustomClearFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "performCustomRequestFocus", "performCustomRequestFocus-Mxy_nc0", "performRequestFocus", "requestFocus", "requestFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Ljava/lang/Boolean;", "requestFocusForChild", "childNode", "requestFocusForOwner", "requireActiveChild", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusTransactionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        static {
            int i;
            int ordinal3;
            int ordinal2;
            int ordinal4;
            int ordinal6;
            int ordinal7;
            int ordinal;
            int ordinal5;
            int[] iArr = new int[values.length];
            i = 1;
            iArr[CustomDestinationResult.None.ordinal()] = i;
            int i2 = 2;
            iArr[CustomDestinationResult.Redirected.ordinal()] = i2;
            int i3 = 3;
            iArr[CustomDestinationResult.Cancelled.ordinal()] = i3;
            int i4 = 4;
            iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = i4;
            try {
                FocusTransactionsKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[values2.length];
                iArr2[FocusStateImpl.Active.ordinal()] = i;
                iArr2[FocusStateImpl.Captured.ordinal()] = i2;
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = i3;
                iArr2[FocusStateImpl.Inactive.ordinal()] = i4;
            } catch (java.lang.NoSuchFieldError e) {
            }
            FocusTransactionsKt.WhenMappings.$EnumSwitchMapping$1 = iArr2;
        }
    }
    public static final boolean captureFocus(androidx.compose.ui.focus.FocusTargetNode $this$captureFocus) {
        androidx.compose.ui.focus.FocusStateImpl captured;
        int i;
        final androidx.compose.ui.focus.FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager($this$captureFocus);
        final int i2 = 0;
        final int i3 = 0;
        if (FocusTransactionManager.access$getOngoingTransaction$p(requireTransactionManager)) {
            FocusTransactionManager.access$cancelTransaction(requireTransactionManager);
        }
        FocusTransactionManager.access$beginTransaction(requireTransactionManager);
        int i4 = 0;
        i = 1;
        switch (captured) {
            case 1:
                $this$captureFocus.setFocusState(FocusStateImpl.Captured);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$captureFocus);
                break;
            case 2:
                break;
            case 3:
                i = 0;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        FocusTransactionManager.access$commitTransaction(requireTransactionManager);
        return i;
    }

    private static final boolean clearChildFocus(androidx.compose.ui.focus.FocusTargetNode $this$clearChildFocus, boolean forced, boolean refreshFocusEvents) {
        boolean clearFocus;
        androidx.compose.ui.focus.FocusTargetNode activeChild = FocusTraversalKt.getActiveChild($this$clearChildFocus);
        if (activeChild != null) {
            clearFocus = FocusTransactionsKt.clearFocus(activeChild, forced, refreshFocusEvents);
        } else {
            clearFocus = 1;
        }
        return clearFocus;
    }

    static boolean clearChildFocus$default(androidx.compose.ui.focus.FocusTargetNode focusTargetNode, boolean z2, boolean z3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return FocusTransactionsKt.clearChildFocus(focusTargetNode, obj1, obj2);
    }

    public static final boolean clearFocus(androidx.compose.ui.focus.FocusTargetNode $this$clearFocus, boolean forced, boolean refreshFocusEvents) {
        androidx.compose.ui.focus.FocusStateImpl clearChildFocus;
        int i;
        i = 1;
        switch (clearChildFocus) {
            case 1:
                $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                break;
            case 2:
                $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                i = forced;
                break;
            case 3:
                $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                i = 0;
                break;
            case 4:
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i;
    }

    public static boolean clearFocus$default(androidx.compose.ui.focus.FocusTargetNode focusTargetNode, boolean z2, boolean z3, int i4, Object object5) {
        int obj1;
        if (i4 &= 1 != 0) {
            obj1 = 0;
        }
        return FocusTransactionsKt.clearFocus(focusTargetNode, obj1, z3);
    }

    public static final boolean freeFocus(androidx.compose.ui.focus.FocusTargetNode $this$freeFocus) {
        int active;
        int i;
        final androidx.compose.ui.focus.FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager($this$freeFocus);
        final int i2 = 0;
        final int i3 = 0;
        if (FocusTransactionManager.access$getOngoingTransaction$p(requireTransactionManager)) {
            FocusTransactionManager.access$cancelTransaction(requireTransactionManager);
        }
        FocusTransactionManager.access$beginTransaction(requireTransactionManager);
        int i4 = 0;
        i = 1;
        switch (active) {
            case 1:
                break;
            case 2:
                $this$freeFocus.setFocusState(FocusStateImpl.Active);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$freeFocus);
                break;
            case 3:
                i = 0;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        FocusTransactionManager.access$commitTransaction(requireTransactionManager);
        return i;
    }

    private static final boolean grantFocus(androidx.compose.ui.focus.FocusTargetNode $this$grantFocus) {
        int active;
        if (/* condition */) {
            $this$grantFocus.setFocusState(FocusStateImpl.Active);
        } else {
        }
        return 1;
    }

    public static final androidx.compose.ui.focus.CustomDestinationResult performCustomClearFocus-Mxy_nc0(androidx.compose.ui.focus.FocusTargetNode $this$performCustomClearFocus_u2dMxy_nc0, int focusDirection) {
        int cancelled;
        int[] $EnumSwitchMapping$1;
        int i2;
        int i;
        switch (i3) {
            case 1:
                cancelled = CustomDestinationResult.None;
                break;
            case 2:
                cancelled = CustomDestinationResult.Cancelled;
                break;
            case 3:
                i2 = 0;
                i = 1;
                i = 0;
                cancelled = 0;
                cancelled = FocusTransactionsKt.performCustomExit-Mxy_nc0($this$performCustomClearFocus_u2dMxy_nc0, focusDirection);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return cancelled;
    }

    private static final androidx.compose.ui.focus.CustomDestinationResult performCustomEnter-Mxy_nc0(androidx.compose.ui.focus.FocusTargetNode $this$performCustomEnter_u2dMxy_nc0, int focusDirection) {
        boolean z;
        Object invoke;
        int i;
        androidx.compose.ui.focus.FocusRequester default;
        androidx.compose.ui.focus.CustomDestinationResult redirectCancelled;
        androidx.compose.ui.focus.FocusTargetNode focusTargetNode = $this$performCustomEnter_u2dMxy_nc0;
        final int i2 = 0;
        FocusTargetNode.access$setProcessingCustomEnter$p(focusTargetNode, true);
        z = 0;
        invoke = focusTargetNode.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.box-impl(focusDirection));
        i = 0;
        if (!FocusTargetNode.access$isProcessingCustomEnter$p(focusTargetNode) && (FocusRequester)invoke != FocusRequester.Companion.getDefault()) {
            FocusTargetNode.access$setProcessingCustomEnter$p(focusTargetNode, true);
            z = 0;
            invoke = focusTargetNode.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.box-impl(focusDirection));
            i = 0;
            if ((FocusRequester)(FocusRequester)invoke != FocusRequester.Companion.getDefault()) {
                Object obj = invoke;
                final int i4 = 0;
                redirectCancelled = obj == FocusRequester.Companion.getCancel() ? CustomDestinationResult.Cancelled : focus$ui_release ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                FocusTargetNode.access$setProcessingCustomEnter$p(focusTargetNode, z);
                return redirectCancelled;
            }
            FocusTargetNode.access$setProcessingCustomEnter$p(focusTargetNode, z);
        }
        return CustomDestinationResult.None;
    }

    private static final androidx.compose.ui.focus.CustomDestinationResult performCustomExit-Mxy_nc0(androidx.compose.ui.focus.FocusTargetNode $this$performCustomExit_u2dMxy_nc0, int focusDirection) {
        boolean z;
        Object invoke;
        int i;
        androidx.compose.ui.focus.FocusRequester default;
        androidx.compose.ui.focus.CustomDestinationResult redirectCancelled;
        androidx.compose.ui.focus.FocusTargetNode focusTargetNode = $this$performCustomExit_u2dMxy_nc0;
        final int i2 = 0;
        FocusTargetNode.access$setProcessingCustomExit$p(focusTargetNode, true);
        z = 0;
        invoke = focusTargetNode.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.box-impl(focusDirection));
        i = 0;
        if (!FocusTargetNode.access$isProcessingCustomExit$p(focusTargetNode) && (FocusRequester)invoke != FocusRequester.Companion.getDefault()) {
            FocusTargetNode.access$setProcessingCustomExit$p(focusTargetNode, true);
            z = 0;
            invoke = focusTargetNode.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.box-impl(focusDirection));
            i = 0;
            if ((FocusRequester)(FocusRequester)invoke != FocusRequester.Companion.getDefault()) {
                Object obj = invoke;
                final int i4 = 0;
                redirectCancelled = obj == FocusRequester.Companion.getCancel() ? CustomDestinationResult.Cancelled : focus$ui_release ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                FocusTargetNode.access$setProcessingCustomExit$p(focusTargetNode, z);
                return redirectCancelled;
            }
            FocusTargetNode.access$setProcessingCustomExit$p(focusTargetNode, z);
        }
        return CustomDestinationResult.None;
    }

    public static final androidx.compose.ui.focus.CustomDestinationResult performCustomRequestFocus-Mxy_nc0(androidx.compose.ui.focus.FocusTargetNode $this$performCustomRequestFocus_u2dMxy_nc0, int focusDirection) {
        int i3;
        androidx.compose.ui.focus.FocusTargetNode $this$nearestAncestor_u2d64DMado$iv2;
        int $this$nearestAncestor_u2d64DMado$iv5;
        int $this$nearestAncestor_u2d64DMado$iv;
        int $this$nearestAncestor_u2d64DMado$iv4;
        int $i$f$getFocusTargetOLwlOKw;
        int customRequestFocus-Mxy_nc0;
        int i6;
        int $i$f$nearestAncestor64DMado2;
        int $i$f$nearestAncestor64DMado4;
        int $i$f$nearestAncestor64DMado;
        int $i$f$nearestAncestor64DMado3;
        int[] $EnumSwitchMapping$1;
        int i4;
        int none;
        Modifier.Node node$iv$iv$iv3;
        LayoutNode layout$iv$iv$iv;
        Modifier.Node node$iv$iv$iv;
        androidx.compose.ui.focus.CustomDestinationResult cancelled;
        int count$iv$iv$iv;
        Modifier.Node node4;
        int i15;
        Modifier.Node next$iv$iv$iv;
        Modifier.Node head$ui_release;
        Modifier.Node node2;
        int i11;
        Modifier.Node node3;
        int i12;
        int i7;
        Modifier.Node node$iv$iv$iv2;
        int i8;
        int i9;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node;
        int i;
        int this_$iv$iv$iv$iv;
        int i2;
        int i14;
        androidx.compose.ui.focus.FocusTargetNode $this$nearestAncestor_u2d64DMado$iv3;
        int i5;
        int i13;
        final int i16 = focusDirection;
        switch (i17) {
            case 1:
                return CustomDestinationResult.None;
            case 2:
                return FocusTransactionsKt.performCustomClearFocus-Mxy_nc0(FocusTransactionsKt.requireActiveChild($this$performCustomRequestFocus_u2dMxy_nc0), i16);
            case 3:
                $this$nearestAncestor_u2d64DMado$iv2 = $this$performCustomRequestFocus_u2dMxy_nc0;
                int i18 = 0;
                $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                i6 = 0;
                i4 = 0;
                none = 0;
                final int i20 = $i$f$getFocusTargetOLwlOKw;
                final DelegatableNode delegatableNode = focusTargetNode;
                final int i21 = 0;
                androidx.compose.ui.focus.FocusTargetNode focusTargetNode2 = $this$nearestAncestor_u2d64DMado$iv2;
                int i23 = $i$f$getFocusTargetOLwlOKw;
                int $this$nearestAncestor_u2d64DMado$iv6 = 0;
                IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
                throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException2;
        }
        node$iv$iv$iv3 = delegatableNode.getNode().getParent$ui_release();
        layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (layout$iv$iv$iv != null) {
            if (aggregateChildKindSet$ui_release &= i20 == 0) {
                break;
            }
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
            $this$nearestAncestor_u2d64DMado$iv2 = layout$iv$iv$iv.getNodes$ui_release();
            if (layout$iv$iv$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != null) {
            } else {
            }
            node$iv$iv$iv = 0;
            node$iv$iv$iv3 = node$iv$iv$iv;
            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
            $i$f$getFocusTargetOLwlOKw = i5;
            i6 = i13;
            $this$nearestAncestor_u2d64DMado$iv2 = layout$iv$iv$iv.getNodes$ui_release();
            if ($this$nearestAncestor_u2d64DMado$iv2 != null) {
            } else {
            }
            node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv2.getTail$ui_release();
            while (node$iv$iv$iv3 != null) {
                if (kindSet$ui_release &= i20 == 0) {
                    break loop_6;
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $this$nearestAncestor_u2d64DMado$iv5 = i15;
                $i$f$nearestAncestor64DMado2 = 0;
                node$iv$iv$iv3 = node$iv$iv$iv3.getParent$ui_release();
                i15 = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw = i5;
                i6 = i13;
                i11 = 0;
                i12 = 0;
                i7 = 0;
                int i22 = 0;
                node$iv$iv$iv = node$iv$iv$iv2;
                while (node$iv$iv$iv != null) {
                    i8 = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv$iv = 0;
                    if (count$iv$iv$iv != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    $this$nearestAncestor_u2d64DMado$iv = i15;
                    $i$f$nearestAncestor64DMado = 0;
                    node$iv$iv$iv = DelegatableNodeKt.access$pop(i7);
                    i15 = $this$nearestAncestor_u2d64DMado$iv;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw = i5;
                    i6 = i13;
                    if (node$iv$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv$iv = 0;
                    i9 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node = node$iv$iv$iv$iv;
                        i = 0;
                        i2 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                        i5 = $i$f$getFocusTargetOLwlOKw;
                        i13 = i6;
                        next$iv$iv$iv = node;
                        $i$f$nearestAncestor64DMado4 = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                        $i$f$getFocusTargetOLwlOKw = i5;
                        i6 = i13;
                        i15 = 1;
                        if (count$iv$iv$iv++ == i15) {
                        } else {
                        }
                        if (i7 == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                        i5 = $i$f$getFocusTargetOLwlOKw;
                        i13 = i6;
                        $i$f$nearestAncestor64DMado4 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2 = i7;
                        $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv;
                        if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node;
                        i7 = $this$nearestAncestor_u2d64DMado$iv2;
                        $this$nearestAncestor_u2d64DMado$iv2.add(node);
                        if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        }
                        node$iv$iv$iv = 0;
                        $this$nearestAncestor_u2d64DMado$iv2.add($i$f$getFocusTargetOLwlOKw);
                        this_$iv$iv$iv$iv = 0;
                        i14 = 0;
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                        i5 = $i$f$getFocusTargetOLwlOKw;
                        i13 = i6;
                        $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv = node;
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                        i5 = $i$f$getFocusTargetOLwlOKw;
                        i13 = i6;
                        next$iv$iv$iv = node;
                        $i$f$nearestAncestor64DMado4 = 0;
                        this_$iv$iv$iv$iv = i15;
                    }
                    $i$f$nearestAncestor64DMado = 0;
                    $this$nearestAncestor_u2d64DMado$iv = 1;
                    if (count$iv$iv$iv == $this$nearestAncestor_u2d64DMado$iv) {
                    } else {
                    }
                    i15 = $this$nearestAncestor_u2d64DMado$iv;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw = i5;
                    i6 = i13;
                    node = node$iv$iv$iv$iv;
                    i = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado4 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw = i5;
                    i6 = i13;
                    i15 = 1;
                    if (count$iv$iv$iv++ == i15) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    $i$f$nearestAncestor64DMado4 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = i7;
                    $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv;
                    if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i7 = $this$nearestAncestor_u2d64DMado$iv2;
                    $this$nearestAncestor_u2d64DMado$iv2.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    node$iv$iv$iv = 0;
                    $this$nearestAncestor_u2d64DMado$iv2.add($i$f$getFocusTargetOLwlOKw);
                    this_$iv$iv$iv$iv = 0;
                    i14 = 0;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv = node;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado4 = 0;
                    this_$iv$iv$iv$iv = i15;
                    count$iv$iv$iv = i15;
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $this$nearestAncestor_u2d64DMado$iv5 = i15;
                $i$f$nearestAncestor64DMado2 = 0;
                i8 = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv$iv = 0;
                if (count$iv$iv$iv != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $this$nearestAncestor_u2d64DMado$iv = i15;
                $i$f$nearestAncestor64DMado = 0;
                node$iv$iv$iv = DelegatableNodeKt.access$pop(i7);
                i15 = $this$nearestAncestor_u2d64DMado$iv;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw = i5;
                i6 = i13;
                if (node$iv$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv$iv = 0;
                i9 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv$iv != null) {
                    node = node$iv$iv$iv$iv;
                    i = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado4 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw = i5;
                    i6 = i13;
                    i15 = 1;
                    if (count$iv$iv$iv++ == i15) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    $i$f$nearestAncestor64DMado4 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = i7;
                    $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv;
                    if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i7 = $this$nearestAncestor_u2d64DMado$iv2;
                    $this$nearestAncestor_u2d64DMado$iv2.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    node$iv$iv$iv = 0;
                    $this$nearestAncestor_u2d64DMado$iv2.add($i$f$getFocusTargetOLwlOKw);
                    this_$iv$iv$iv$iv = 0;
                    i14 = 0;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv = node;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado4 = 0;
                    this_$iv$iv$iv$iv = i15;
                }
                $i$f$nearestAncestor64DMado = 0;
                $this$nearestAncestor_u2d64DMado$iv = 1;
                if (count$iv$iv$iv == $this$nearestAncestor_u2d64DMado$iv) {
                } else {
                }
                i15 = $this$nearestAncestor_u2d64DMado$iv;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw = i5;
                i6 = i13;
                node = node$iv$iv$iv$iv;
                i = 0;
                i2 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                next$iv$iv$iv = node;
                $i$f$nearestAncestor64DMado4 = 0;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw = i5;
                i6 = i13;
                i15 = 1;
                if (count$iv$iv$iv++ == i15) {
                } else {
                }
                if (i7 == 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $i$f$nearestAncestor64DMado4 = 0;
                $this$nearestAncestor_u2d64DMado$iv2 = i7;
                $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv;
                if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                }
                if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                } else {
                }
                next$iv$iv$iv = node;
                i7 = $this$nearestAncestor_u2d64DMado$iv2;
                $this$nearestAncestor_u2d64DMado$iv2.add(node);
                if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                }
                node$iv$iv$iv = 0;
                $this$nearestAncestor_u2d64DMado$iv2.add($i$f$getFocusTargetOLwlOKw);
                this_$iv$iv$iv$iv = 0;
                i14 = 0;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv$iv = node;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                next$iv$iv$iv = node;
                $i$f$nearestAncestor64DMado4 = 0;
                this_$iv$iv$iv$iv = i15;
                count$iv$iv$iv = i15;
            }
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            if (kindSet$ui_release &= i20 == 0) {
                break;
            } else {
            }
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            $this$nearestAncestor_u2d64DMado$iv5 = i15;
            $i$f$nearestAncestor64DMado2 = 0;
            node$iv$iv$iv3 = node$iv$iv$iv3.getParent$ui_release();
            i15 = $this$nearestAncestor_u2d64DMado$iv5;
            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
            $i$f$getFocusTargetOLwlOKw = i5;
            i6 = i13;
            i11 = 0;
            i12 = 0;
            i7 = 0;
            i22 = 0;
            node$iv$iv$iv = node$iv$iv$iv2;
            while (node$iv$iv$iv != null) {
                i8 = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv$iv = 0;
                if (count$iv$iv$iv != 0 && node$iv$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $this$nearestAncestor_u2d64DMado$iv = i15;
                $i$f$nearestAncestor64DMado = 0;
                node$iv$iv$iv = DelegatableNodeKt.access$pop(i7);
                i15 = $this$nearestAncestor_u2d64DMado$iv;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw = i5;
                i6 = i13;
                if (node$iv$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv$iv = 0;
                i9 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv$iv != null) {
                    node = node$iv$iv$iv$iv;
                    i = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado4 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw = i5;
                    i6 = i13;
                    i15 = 1;
                    if (count$iv$iv$iv++ == i15) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    $i$f$nearestAncestor64DMado4 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = i7;
                    $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv;
                    if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i7 = $this$nearestAncestor_u2d64DMado$iv2;
                    $this$nearestAncestor_u2d64DMado$iv2.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    node$iv$iv$iv = 0;
                    $this$nearestAncestor_u2d64DMado$iv2.add($i$f$getFocusTargetOLwlOKw);
                    this_$iv$iv$iv$iv = 0;
                    i14 = 0;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv = node;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                    i5 = $i$f$getFocusTargetOLwlOKw;
                    i13 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado4 = 0;
                    this_$iv$iv$iv$iv = i15;
                }
                $i$f$nearestAncestor64DMado = 0;
                $this$nearestAncestor_u2d64DMado$iv = 1;
                if (count$iv$iv$iv == $this$nearestAncestor_u2d64DMado$iv) {
                } else {
                }
                i15 = $this$nearestAncestor_u2d64DMado$iv;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw = i5;
                i6 = i13;
                node = node$iv$iv$iv$iv;
                i = 0;
                i2 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                next$iv$iv$iv = node;
                $i$f$nearestAncestor64DMado4 = 0;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw = i5;
                i6 = i13;
                i15 = 1;
                if (count$iv$iv$iv++ == i15) {
                } else {
                }
                if (i7 == 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $i$f$nearestAncestor64DMado4 = 0;
                $this$nearestAncestor_u2d64DMado$iv2 = i7;
                $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv;
                if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                }
                if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                } else {
                }
                next$iv$iv$iv = node;
                i7 = $this$nearestAncestor_u2d64DMado$iv2;
                $this$nearestAncestor_u2d64DMado$iv2.add(node);
                if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                }
                node$iv$iv$iv = 0;
                $this$nearestAncestor_u2d64DMado$iv2.add($i$f$getFocusTargetOLwlOKw);
                this_$iv$iv$iv$iv = 0;
                i14 = 0;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv$iv = node;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                next$iv$iv$iv = node;
                $i$f$nearestAncestor64DMado4 = 0;
                this_$iv$iv$iv$iv = i15;
                count$iv$iv$iv = i15;
            }
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            $this$nearestAncestor_u2d64DMado$iv5 = i15;
            $i$f$nearestAncestor64DMado2 = 0;
            i8 = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv$iv = 0;
            if (count$iv$iv$iv != 0 && node$iv$iv$iv instanceof DelegatingNode) {
            } else {
            }
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            $this$nearestAncestor_u2d64DMado$iv = i15;
            $i$f$nearestAncestor64DMado = 0;
            node$iv$iv$iv = DelegatableNodeKt.access$pop(i7);
            i15 = $this$nearestAncestor_u2d64DMado$iv;
            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
            $i$f$getFocusTargetOLwlOKw = i5;
            i6 = i13;
            if (node$iv$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv$iv = 0;
            i9 = 0;
            node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv$iv != null) {
                node = node$iv$iv$iv$iv;
                i = 0;
                i2 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                next$iv$iv$iv = node;
                $i$f$nearestAncestor64DMado4 = 0;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw = i5;
                i6 = i13;
                i15 = 1;
                if (count$iv$iv$iv++ == i15) {
                } else {
                }
                if (i7 == 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $i$f$nearestAncestor64DMado4 = 0;
                $this$nearestAncestor_u2d64DMado$iv2 = i7;
                $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv;
                if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                }
                if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                } else {
                }
                next$iv$iv$iv = node;
                i7 = $this$nearestAncestor_u2d64DMado$iv2;
                $this$nearestAncestor_u2d64DMado$iv2.add(node);
                if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                }
                node$iv$iv$iv = 0;
                $this$nearestAncestor_u2d64DMado$iv2.add($i$f$getFocusTargetOLwlOKw);
                this_$iv$iv$iv$iv = 0;
                i14 = 0;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv$iv = node;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
                i5 = $i$f$getFocusTargetOLwlOKw;
                i13 = i6;
                next$iv$iv$iv = node;
                $i$f$nearestAncestor64DMado4 = 0;
                this_$iv$iv$iv$iv = i15;
            }
            $i$f$nearestAncestor64DMado = 0;
            $this$nearestAncestor_u2d64DMado$iv = 1;
            if (count$iv$iv$iv == $this$nearestAncestor_u2d64DMado$iv) {
            } else {
            }
            i15 = $this$nearestAncestor_u2d64DMado$iv;
            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
            $i$f$getFocusTargetOLwlOKw = i5;
            i6 = i13;
            node = node$iv$iv$iv$iv;
            i = 0;
            i2 = 0;
            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            this_$iv$iv$iv$iv = 0;
            if (this_$iv$iv$iv$iv != 0) {
            } else {
            }
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            next$iv$iv$iv = node;
            $i$f$nearestAncestor64DMado4 = 0;
            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv3;
            $i$f$getFocusTargetOLwlOKw = i5;
            i6 = i13;
            i15 = 1;
            if (count$iv$iv$iv++ == i15) {
            } else {
            }
            if (i7 == 0) {
            } else {
            }
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            $i$f$nearestAncestor64DMado4 = 0;
            $this$nearestAncestor_u2d64DMado$iv2 = i7;
            $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv;
            if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
            }
            if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
            } else {
            }
            next$iv$iv$iv = node;
            i7 = $this$nearestAncestor_u2d64DMado$iv2;
            $this$nearestAncestor_u2d64DMado$iv2.add(node);
            if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
            }
            node$iv$iv$iv = 0;
            $this$nearestAncestor_u2d64DMado$iv2.add($i$f$getFocusTargetOLwlOKw);
            this_$iv$iv$iv$iv = 0;
            i14 = 0;
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
            node$iv$iv$iv = node;
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
            i5 = $i$f$getFocusTargetOLwlOKw;
            i13 = i6;
            next$iv$iv$iv = node;
            $i$f$nearestAncestor64DMado4 = 0;
            this_$iv$iv$iv$iv = i15;
            count$iv$iv$iv = i15;
        }
        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv2;
        i5 = $i$f$getFocusTargetOLwlOKw;
        i13 = i6;
        $this$nearestAncestor_u2d64DMado$iv4 = i15;
        $i$f$nearestAncestor64DMado3 = 0;
        node4 = 0;
        if ((FocusTargetNode)node4 == null) {
            return CustomDestinationResult.None;
        }
        switch (customRequestFocus-Mxy_nc0) {
            case 1:
                cancelled = FocusTransactionsKt.performCustomEnter-Mxy_nc0(node4, i16);
                break;
            case 2:
                cancelled = CustomDestinationResult.Cancelled;
                break;
            case 3:
                cancelled = FocusTransactionsKt.performCustomRequestFocus-Mxy_nc0(node4, i16);
                break;
            case 4:
                customRequestFocus-Mxy_nc0 = FocusTransactionsKt.performCustomRequestFocus-Mxy_nc0(node4, i16);
                i4 = 0;
                $this$nearestAncestor_u2d64DMado$iv4 = $i$f$nearestAncestor64DMado3;
                cancelled = customRequestFocus-Mxy_nc0;
                cancelled = 0;
                cancelled = FocusTransactionsKt.performCustomEnter-Mxy_nc0(node4, i16);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return cancelled;
    }

    public static final boolean performRequestFocus(androidx.compose.ui.focus.FocusTargetNode $this$performRequestFocus) {
        int $this$nearestAncestor_u2d64DMado$iv6;
        androidx.compose.ui.focus.FocusTargetNode $this$nearestAncestor_u2d64DMado$iv5;
        int $this$nearestAncestor_u2d64DMado$iv;
        int $this$nearestAncestor_u2d64DMado$iv2;
        int $this$nearestAncestor_u2d64DMado$iv4;
        int[] node$iv$iv$iv;
        int requestFocusForChild;
        Modifier.Node count$iv$iv$iv;
        boolean requestFocusForOwner;
        int focusState;
        Modifier.Node next$iv$iv$iv;
        int $i$f$getFocusTargetOLwlOKw;
        int i3;
        androidx.compose.ui.focus.FocusTargetNode focusTargetNode;
        int i9;
        int i10;
        int i6;
        DelegatableNode delegatableNode;
        int i4;
        Modifier.Node node$iv$iv$iv2;
        LayoutNode layout$iv$iv$iv;
        Modifier.Node head$ui_release;
        Modifier.Node node2;
        int i13;
        Modifier.Node node;
        int i11;
        int i7;
        int node$iv$iv$iv4;
        Modifier.Node node4;
        int i2;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node3;
        int i12;
        int this_$iv$iv$iv$iv;
        int i8;
        int i5;
        int $this$nearestAncestor_u2d64DMado$iv3;
        Modifier.Node node$iv$iv$iv3;
        int i;
        final androidx.compose.ui.focus.FocusTargetNode focusTargetNode2 = $this$performRequestFocus;
        focusState = 1;
        switch (i16) {
            case 1:
                requestFocusForChild = $this$nearestAncestor_u2d64DMado$iv6;
                break;
            case 2:
                focusState = 0;
                requestFocusForChild = $this$nearestAncestor_u2d64DMado$iv6;
                requestFocusForChild = focusState;
                break;
            case 3:
                $this$nearestAncestor_u2d64DMado$iv5 = focusTargetNode2;
                int i19 = 0;
                $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
                i3 = 0;
                i9 = 0;
                i10 = 0;
                i6 = $i$f$getFocusTargetOLwlOKw;
                delegatableNode = focusTargetNode;
                i4 = 0;
                node$iv$iv$iv2 = delegatableNode.getNode().getParent$ui_release();
                layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
                i13 = 0;
                i11 = 0;
                i7 = 0;
                int i21 = 0;
                node$iv$iv$iv = node$iv$iv$iv4;
                count$iv$iv$iv = node$iv$iv$iv;
                node$iv$iv$iv4 = 0;
                $this$nearestAncestor_u2d64DMado$iv6 = focusState;
                node4 = 0;
                count$iv$iv$iv = focusState;
                count$iv$iv$iv = 0;
                count$iv$iv$iv = 0;
                i2 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv.getDelegate$ui_release();
                node3 = node$iv$iv$iv$iv;
                i12 = 0;
                i8 = 0;
                this_$iv$iv$iv$iv = focusState;
                this_$iv$iv$iv$iv = 0;
                count$iv$iv$iv++;
                node$iv$iv$iv = node3;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                next$iv$iv$iv = node3;
                this_$iv$iv$iv$iv = 0;
                i5 = 0;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                node$iv$iv$iv3 = node$iv$iv$iv;
                i = count$iv$iv$iv;
                $this$nearestAncestor_u2d64DMado$iv5 = new MutableVector(new Modifier.Node[16], 0);
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                node$iv$iv$iv3 = node$iv$iv$iv;
                i = count$iv$iv$iv;
                $this$nearestAncestor_u2d64DMado$iv5 = i7;
                Modifier.Node node5 = node$iv$iv$iv3;
                $this$nearestAncestor_u2d64DMado$iv5.add(node5);
                node$iv$iv$iv3 = count$iv$iv$iv;
                $this$nearestAncestor_u2d64DMado$iv5.add(node3);
                next$iv$iv$iv = node3;
                i7 = $this$nearestAncestor_u2d64DMado$iv5;
                node$iv$iv$iv = node$iv$iv$iv3;
                count$iv$iv$iv = i;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                node$iv$iv$iv3 = node$iv$iv$iv;
                next$iv$iv$iv = node3;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                focusState = 1;
                node$iv$iv$iv3 = node$iv$iv$iv;
                $this$nearestAncestor_u2d64DMado$iv = 1;
                focusState = $this$nearestAncestor_u2d64DMado$iv;
                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                node$iv$iv$iv = node$iv$iv$iv3;
                node$iv$iv$iv = node$iv$iv$iv3;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv = focusState;
                node$iv$iv$iv = DelegatableNodeKt.access$pop(i7);
                focusState = $this$nearestAncestor_u2d64DMado$iv;
                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv2 = focusState;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv2 = focusState;
                node$iv$iv$iv2 = node$iv$iv$iv2.getParent$ui_release();
                focusState = $this$nearestAncestor_u2d64DMado$iv2;
                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv4 = focusState;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv4 = focusState;
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = layout$iv$iv$iv.getNodes$ui_release();
                node$iv$iv$iv = node$iv$iv$iv.getTail$ui_release();
                node$iv$iv$iv = 0;
                node$iv$iv$iv2 = node$iv$iv$iv;
                focusState = $this$nearestAncestor_u2d64DMado$iv4;
                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv3;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv6 = focusState;
                node$iv$iv$iv = 0;
                FocusEventModifierNodeKt.refreshFocusEventNodes(node$iv$iv$iv);
                requestFocusForChild = $this$nearestAncestor_u2d64DMado$iv6;
                requestFocusForChild = 0;
                androidx.compose.ui.focus.FocusTargetNode focusTargetNode3 = $this$nearestAncestor_u2d64DMado$iv5;
                int $this$nearestAncestor_u2d64DMado$iv7 = 0;
                IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
                throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        if (requestFocusForChild != 0) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
        }
        return requestFocusForChild;
    }

    public static final boolean requestFocus(androidx.compose.ui.focus.FocusTargetNode $this$requestFocus) {
        boolean booleanValue;
        Boolean requestFocus-Mxy_nc0 = FocusTransactionsKt.requestFocus-Mxy_nc0($this$requestFocus, FocusDirection.Companion.getEnter-dhqQ-8s());
        if (requestFocus-Mxy_nc0 != null) {
            booleanValue = requestFocus-Mxy_nc0.booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }

    public static final Boolean requestFocus-Mxy_nc0(androidx.compose.ui.focus.FocusTargetNode $this$requestFocus_u2dMxy_nc0, int focusDirection) {
        Boolean valueOf;
        final androidx.compose.ui.focus.FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager($this$requestFocus_u2dMxy_nc0);
        FocusTransactionsKt.requestFocus.1 anon = new FocusTransactionsKt.requestFocus.1($this$requestFocus_u2dMxy_nc0);
        final int i = 0;
        if (FocusTransactionManager.access$getOngoingTransaction$p(requireTransactionManager)) {
            FocusTransactionManager.access$cancelTransaction(requireTransactionManager);
        }
        FocusTransactionManager.access$beginTransaction(requireTransactionManager);
        int i2 = 0;
        final int i5 = 0;
        FocusTransactionManager.access$getCancellationListener$p(requireTransactionManager).add((Function0)anon);
        int it$iv = 0;
        switch (i3) {
            case 1:
                valueOf = Boolean.valueOf(FocusTransactionsKt.performRequestFocus($this$requestFocus_u2dMxy_nc0));
                break;
            case 2:
                valueOf = true;
                break;
            case 3:
                valueOf = 0;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        FocusTransactionManager.access$commitTransaction(requireTransactionManager);
        return valueOf;
    }

    private static final boolean requestFocusForChild(androidx.compose.ui.focus.FocusTargetNode $this$requestFocusForChild, androidx.compose.ui.focus.FocusTargetNode childNode) {
        androidx.compose.ui.focus.FocusTargetNode $this$nearestAncestor_u2d64DMado$iv4;
        boolean clearChildFocus$default;
        Object $this$nearestAncestor_u2d64DMado$iv;
        int node$iv$iv$iv3;
        int theNode$iv$iv$iv2;
        int tail$ui_release;
        int $i$f$getFocusTargetOLwlOKw2;
        int $i$f$getFocusTargetOLwlOKw;
        int count$iv$iv$iv2;
        int count$iv$iv$iv;
        int this_$iv$iv$iv$iv3;
        int $i$f$nearestAncestor64DMado6;
        int $i$f$nearestAncestor64DMado;
        int $i$f$nearestAncestor64DMado4;
        int $i$f$nearestAncestor64DMado3;
        Modifier.Node node$iv$iv$iv2;
        int $i$f$nearestAncestor64DMado2;
        int activeParent2;
        int i10;
        int focusState;
        int activeParent;
        int i11;
        DelegatableNode delegatableNode;
        int node$iv$iv$iv4;
        Modifier.Node node$iv$iv$iv6;
        String head$ui_release2;
        LayoutNode layout$iv$iv$iv;
        int node$iv$iv$iv5;
        int i8;
        Modifier.Node next$iv$iv$iv;
        int grantFocus;
        int i5;
        int i2;
        Modifier.Node head$ui_release;
        Modifier.Node theNode$iv$iv$iv;
        int $this$nearestAncestor_u2d64DMado$iv2;
        int type$iv;
        Modifier.Node node2;
        int i6;
        int node$iv$iv$iv$iv;
        Modifier.Node node$iv$iv$iv;
        int i7;
        int i;
        Modifier.Node node$iv$iv$iv$iv2;
        int this_$iv$iv$iv$iv;
        Modifier.Node node3;
        int i9;
        int this_$iv$iv$iv$iv2;
        int i3;
        int $i$f$nearestAncestor64DMado5;
        int $this$nearestAncestor_u2d64DMado$iv3;
        int i12;
        int i4;
        Modifier.Node node;
        final Object obj = $this$requestFocusForChild;
        $this$nearestAncestor_u2d64DMado$iv4 = childNode;
        int i17 = 0;
        $i$f$getFocusTargetOLwlOKw2 = NodeKind.constructor-impl(1024);
        activeParent2 = 0;
        focusState = 0;
        activeParent = 0;
        i11 = $i$f$getFocusTargetOLwlOKw2;
        delegatableNode = i10;
        node$iv$iv$iv4 = 0;
        head$ui_release2 = "visitAncestors called on an unattached node";
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv$iv6 = delegatableNode.getNode().getParent$ui_release();
            layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            i8 = 1;
            i2 = this_$iv$iv$iv$iv3;
            while (layout$iv$iv$iv != null) {
                if (aggregateChildKindSet$ui_release2 &= i11 == 0) {
                    break;
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                $this$nearestAncestor_u2d64DMado$iv4 = layout$iv$iv$iv.getNodes$ui_release();
                if (layout$iv$iv$iv != null && $this$nearestAncestor_u2d64DMado$iv4 != null) {
                } else {
                }
                node$iv$iv$iv5 = 0;
                node$iv$iv$iv6 = node$iv$iv$iv5;
                this_$iv$iv$iv$iv3 = i2;
                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw2 = i12;
                i8 = 1;
                i2 = this_$iv$iv$iv$iv3;
                $this$nearestAncestor_u2d64DMado$iv4 = layout$iv$iv$iv.getNodes$ui_release();
                if ($this$nearestAncestor_u2d64DMado$iv4 != null) {
                } else {
                }
                node$iv$iv$iv5 = $this$nearestAncestor_u2d64DMado$iv4.getTail$ui_release();
                while (node$iv$iv$iv6 != null) {
                    if (kindSet$ui_release2 &= i11 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    node$iv$iv$iv6 = node$iv$iv$iv6.getParent$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw2 = i12;
                    i8 = 1;
                    type$iv = 0;
                    i6 = 0;
                    node$iv$iv$iv$iv = 0;
                    int i22 = 0;
                    node$iv$iv$iv5 = node$iv$iv$iv;
                    while (node$iv$iv$iv5 != null) {
                        i7 = 0;
                        if (kindSet$ui_release4 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv3 = 0;
                        if (this_$iv$iv$iv$iv3 != 0 && node$iv$iv$iv5 instanceof DelegatingNode) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        node$iv$iv$iv5 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                        $i$f$getFocusTargetOLwlOKw2 = i12;
                        i8 = 1;
                        if (node$iv$iv$iv5 instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv$iv$iv3 = 0;
                        i = 0;
                        node$iv$iv$iv$iv2 = (DelegatingNode)node$iv$iv$iv5.getDelegate$ui_release();
                        while (node$iv$iv$iv$iv2 != null) {
                            node3 = node$iv$iv$iv$iv2;
                            i9 = 0;
                            i3 = 0;
                            if (kindSet$ui_release6 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv2 = 0;
                            if (this_$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                            i12 = $i$f$getFocusTargetOLwlOKw2;
                            next$iv$iv$iv = node3;
                            node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                            $i$f$getFocusTargetOLwlOKw2 = i12;
                            i8 = 1;
                            this_$iv$iv$iv$iv3++;
                            if (this_$iv$iv$iv$iv3 == i8) {
                            } else {
                            }
                            if (node$iv$iv$iv$iv == 0) {
                            } else {
                            }
                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                            i12 = $i$f$getFocusTargetOLwlOKw2;
                            i4 = this_$iv$iv$iv$iv3;
                            $this$nearestAncestor_u2d64DMado$iv4 = node$iv$iv$iv$iv;
                            $i$f$getFocusTargetOLwlOKw2 = node$iv$iv$iv5;
                            if ($i$f$getFocusTargetOLwlOKw2 != null && $this$nearestAncestor_u2d64DMado$iv4 != 0) {
                            }
                            if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node3;
                            node$iv$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4;
                            this_$iv$iv$iv$iv3 = i4;
                            $this$nearestAncestor_u2d64DMado$iv4.add(node3);
                            if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                            }
                            node$iv$iv$iv5 = this_$iv$iv$iv$iv3;
                            $this$nearestAncestor_u2d64DMado$iv4.add($i$f$getFocusTargetOLwlOKw2);
                            this_$iv$iv$iv$iv2 = 0;
                            $i$f$nearestAncestor64DMado5 = 0;
                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                            i12 = $i$f$getFocusTargetOLwlOKw2;
                            i4 = this_$iv$iv$iv$iv3;
                            $this$nearestAncestor_u2d64DMado$iv4 = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv$iv5 = node3;
                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                            i12 = $i$f$getFocusTargetOLwlOKw2;
                            next$iv$iv$iv = node3;
                            this_$iv$iv$iv$iv2 = i8;
                        }
                        if (this_$iv$iv$iv$iv3 == 1) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                        $i$f$getFocusTargetOLwlOKw2 = i12;
                        i8 = 1;
                        node3 = node$iv$iv$iv$iv2;
                        i9 = 0;
                        i3 = 0;
                        if (kindSet$ui_release6 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        next$iv$iv$iv = node3;
                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                        $i$f$getFocusTargetOLwlOKw2 = i12;
                        i8 = 1;
                        this_$iv$iv$iv$iv3++;
                        if (this_$iv$iv$iv$iv3 == i8) {
                        } else {
                        }
                        if (node$iv$iv$iv$iv == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        i4 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4 = node$iv$iv$iv$iv;
                        $i$f$getFocusTargetOLwlOKw2 = node$iv$iv$iv5;
                        if ($i$f$getFocusTargetOLwlOKw2 != null && $this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node3;
                        node$iv$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4;
                        this_$iv$iv$iv$iv3 = i4;
                        $this$nearestAncestor_u2d64DMado$iv4.add(node3);
                        if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        }
                        node$iv$iv$iv5 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4.add($i$f$getFocusTargetOLwlOKw2);
                        this_$iv$iv$iv$iv2 = 0;
                        $i$f$nearestAncestor64DMado5 = 0;
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        i4 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv5 = node3;
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        next$iv$iv$iv = node3;
                        this_$iv$iv$iv$iv2 = i8;
                        this_$iv$iv$iv$iv3 = i8;
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    i7 = 0;
                    if (kindSet$ui_release4 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv3 = 0;
                    if (this_$iv$iv$iv$iv3 != 0 && node$iv$iv$iv5 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    node$iv$iv$iv5 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw2 = i12;
                    i8 = 1;
                    if (node$iv$iv$iv5 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv$iv3 = 0;
                    i = 0;
                    node$iv$iv$iv$iv2 = (DelegatingNode)node$iv$iv$iv5.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv2 != null) {
                        node3 = node$iv$iv$iv$iv2;
                        i9 = 0;
                        i3 = 0;
                        if (kindSet$ui_release6 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        next$iv$iv$iv = node3;
                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                        $i$f$getFocusTargetOLwlOKw2 = i12;
                        i8 = 1;
                        this_$iv$iv$iv$iv3++;
                        if (this_$iv$iv$iv$iv3 == i8) {
                        } else {
                        }
                        if (node$iv$iv$iv$iv == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        i4 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4 = node$iv$iv$iv$iv;
                        $i$f$getFocusTargetOLwlOKw2 = node$iv$iv$iv5;
                        if ($i$f$getFocusTargetOLwlOKw2 != null && $this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node3;
                        node$iv$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4;
                        this_$iv$iv$iv$iv3 = i4;
                        $this$nearestAncestor_u2d64DMado$iv4.add(node3);
                        if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        }
                        node$iv$iv$iv5 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4.add($i$f$getFocusTargetOLwlOKw2);
                        this_$iv$iv$iv$iv2 = 0;
                        $i$f$nearestAncestor64DMado5 = 0;
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        i4 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv5 = node3;
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        next$iv$iv$iv = node3;
                        this_$iv$iv$iv$iv2 = i8;
                    }
                    if (this_$iv$iv$iv$iv3 == 1) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw2 = i12;
                    i8 = 1;
                    node3 = node$iv$iv$iv$iv2;
                    i9 = 0;
                    i3 = 0;
                    if (kindSet$ui_release6 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    next$iv$iv$iv = node3;
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw2 = i12;
                    i8 = 1;
                    this_$iv$iv$iv$iv3++;
                    if (this_$iv$iv$iv$iv3 == i8) {
                    } else {
                    }
                    if (node$iv$iv$iv$iv == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    i4 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4 = node$iv$iv$iv$iv;
                    $i$f$getFocusTargetOLwlOKw2 = node$iv$iv$iv5;
                    if ($i$f$getFocusTargetOLwlOKw2 != null && $this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node3;
                    node$iv$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4;
                    this_$iv$iv$iv$iv3 = i4;
                    $this$nearestAncestor_u2d64DMado$iv4.add(node3);
                    if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    }
                    node$iv$iv$iv5 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4.add($i$f$getFocusTargetOLwlOKw2);
                    this_$iv$iv$iv$iv2 = 0;
                    $i$f$nearestAncestor64DMado5 = 0;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    i4 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv5 = node3;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    next$iv$iv$iv = node3;
                    this_$iv$iv$iv$iv2 = i8;
                    this_$iv$iv$iv$iv3 = i8;
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                if (kindSet$ui_release2 &= i11 == 0) {
                    break;
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                node$iv$iv$iv6 = node$iv$iv$iv6.getParent$ui_release();
                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw2 = i12;
                i8 = 1;
                type$iv = 0;
                i6 = 0;
                node$iv$iv$iv$iv = 0;
                i22 = 0;
                node$iv$iv$iv5 = node$iv$iv$iv;
                while (node$iv$iv$iv5 != null) {
                    i7 = 0;
                    if (kindSet$ui_release4 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv3 = 0;
                    if (this_$iv$iv$iv$iv3 != 0 && node$iv$iv$iv5 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    node$iv$iv$iv5 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw2 = i12;
                    i8 = 1;
                    if (node$iv$iv$iv5 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv$iv3 = 0;
                    i = 0;
                    node$iv$iv$iv$iv2 = (DelegatingNode)node$iv$iv$iv5.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv2 != null) {
                        node3 = node$iv$iv$iv$iv2;
                        i9 = 0;
                        i3 = 0;
                        if (kindSet$ui_release6 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        next$iv$iv$iv = node3;
                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                        $i$f$getFocusTargetOLwlOKw2 = i12;
                        i8 = 1;
                        this_$iv$iv$iv$iv3++;
                        if (this_$iv$iv$iv$iv3 == i8) {
                        } else {
                        }
                        if (node$iv$iv$iv$iv == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        i4 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4 = node$iv$iv$iv$iv;
                        $i$f$getFocusTargetOLwlOKw2 = node$iv$iv$iv5;
                        if ($i$f$getFocusTargetOLwlOKw2 != null && $this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node3;
                        node$iv$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4;
                        this_$iv$iv$iv$iv3 = i4;
                        $this$nearestAncestor_u2d64DMado$iv4.add(node3);
                        if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                        }
                        node$iv$iv$iv5 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4.add($i$f$getFocusTargetOLwlOKw2);
                        this_$iv$iv$iv$iv2 = 0;
                        $i$f$nearestAncestor64DMado5 = 0;
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        i4 = this_$iv$iv$iv$iv3;
                        $this$nearestAncestor_u2d64DMado$iv4 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv5 = node3;
                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                        i12 = $i$f$getFocusTargetOLwlOKw2;
                        next$iv$iv$iv = node3;
                        this_$iv$iv$iv$iv2 = i8;
                    }
                    if (this_$iv$iv$iv$iv3 == 1) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw2 = i12;
                    i8 = 1;
                    node3 = node$iv$iv$iv$iv2;
                    i9 = 0;
                    i3 = 0;
                    if (kindSet$ui_release6 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    next$iv$iv$iv = node3;
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw2 = i12;
                    i8 = 1;
                    this_$iv$iv$iv$iv3++;
                    if (this_$iv$iv$iv$iv3 == i8) {
                    } else {
                    }
                    if (node$iv$iv$iv$iv == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    i4 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4 = node$iv$iv$iv$iv;
                    $i$f$getFocusTargetOLwlOKw2 = node$iv$iv$iv5;
                    if ($i$f$getFocusTargetOLwlOKw2 != null && $this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node3;
                    node$iv$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4;
                    this_$iv$iv$iv$iv3 = i4;
                    $this$nearestAncestor_u2d64DMado$iv4.add(node3);
                    if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    }
                    node$iv$iv$iv5 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4.add($i$f$getFocusTargetOLwlOKw2);
                    this_$iv$iv$iv$iv2 = 0;
                    $i$f$nearestAncestor64DMado5 = 0;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    i4 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv5 = node3;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    next$iv$iv$iv = node3;
                    this_$iv$iv$iv$iv2 = i8;
                    this_$iv$iv$iv$iv3 = i8;
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                i7 = 0;
                if (kindSet$ui_release4 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                } else {
                }
                this_$iv$iv$iv$iv3 = 0;
                if (this_$iv$iv$iv$iv3 != 0 && node$iv$iv$iv5 instanceof DelegatingNode) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                node$iv$iv$iv5 = DelegatableNodeKt.access$pop(node$iv$iv$iv$iv);
                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw2 = i12;
                i8 = 1;
                if (node$iv$iv$iv5 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv$iv3 = 0;
                i = 0;
                node$iv$iv$iv$iv2 = (DelegatingNode)node$iv$iv$iv5.getDelegate$ui_release();
                while (node$iv$iv$iv$iv2 != null) {
                    node3 = node$iv$iv$iv$iv2;
                    i9 = 0;
                    i3 = 0;
                    if (kindSet$ui_release6 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    next$iv$iv$iv = node3;
                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                    $i$f$getFocusTargetOLwlOKw2 = i12;
                    i8 = 1;
                    this_$iv$iv$iv$iv3++;
                    if (this_$iv$iv$iv$iv3 == i8) {
                    } else {
                    }
                    if (node$iv$iv$iv$iv == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    i4 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4 = node$iv$iv$iv$iv;
                    $i$f$getFocusTargetOLwlOKw2 = node$iv$iv$iv5;
                    if ($i$f$getFocusTargetOLwlOKw2 != null && $this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node3;
                    node$iv$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4;
                    this_$iv$iv$iv$iv3 = i4;
                    $this$nearestAncestor_u2d64DMado$iv4.add(node3);
                    if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                    }
                    node$iv$iv$iv5 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4.add($i$f$getFocusTargetOLwlOKw2);
                    this_$iv$iv$iv$iv2 = 0;
                    $i$f$nearestAncestor64DMado5 = 0;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    i4 = this_$iv$iv$iv$iv3;
                    $this$nearestAncestor_u2d64DMado$iv4 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv5 = node3;
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                    i12 = $i$f$getFocusTargetOLwlOKw2;
                    next$iv$iv$iv = node3;
                    this_$iv$iv$iv$iv2 = i8;
                }
                if (this_$iv$iv$iv$iv3 == 1) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw2 = i12;
                i8 = 1;
                node3 = node$iv$iv$iv$iv2;
                i9 = 0;
                i3 = 0;
                if (kindSet$ui_release6 &= $i$f$getFocusTargetOLwlOKw2 != 0) {
                } else {
                }
                this_$iv$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv$iv2 != 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                next$iv$iv$iv = node3;
                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild$ui_release();
                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                $i$f$getFocusTargetOLwlOKw2 = i12;
                i8 = 1;
                this_$iv$iv$iv$iv3++;
                if (this_$iv$iv$iv$iv3 == i8) {
                } else {
                }
                if (node$iv$iv$iv$iv == 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                i4 = this_$iv$iv$iv$iv3;
                $this$nearestAncestor_u2d64DMado$iv4 = node$iv$iv$iv$iv;
                $i$f$getFocusTargetOLwlOKw2 = node$iv$iv$iv5;
                if ($i$f$getFocusTargetOLwlOKw2 != null && $this$nearestAncestor_u2d64DMado$iv4 != 0) {
                }
                if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                } else {
                }
                next$iv$iv$iv = node3;
                node$iv$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4;
                this_$iv$iv$iv$iv3 = i4;
                $this$nearestAncestor_u2d64DMado$iv4.add(node3);
                if ($this$nearestAncestor_u2d64DMado$iv4 != 0) {
                }
                node$iv$iv$iv5 = this_$iv$iv$iv$iv3;
                $this$nearestAncestor_u2d64DMado$iv4.add($i$f$getFocusTargetOLwlOKw2);
                this_$iv$iv$iv$iv2 = 0;
                $i$f$nearestAncestor64DMado5 = 0;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                i4 = this_$iv$iv$iv$iv3;
                $this$nearestAncestor_u2d64DMado$iv4 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv$iv5 = node3;
                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                i12 = $i$f$getFocusTargetOLwlOKw2;
                next$iv$iv$iv = node3;
                this_$iv$iv$iv$iv2 = i8;
                this_$iv$iv$iv$iv3 = i8;
            }
            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
            i12 = $i$f$getFocusTargetOLwlOKw2;
            $i$f$nearestAncestor64DMado6 = 0;
            if (!Intrinsics.areEqual($i$f$nearestAncestor64DMado6, obj)) {
            } else {
                switch (clearChildFocus$default) {
                    case 1:
                        $i$f$getFocusTargetOLwlOKw = 0;
                        obj.setFocusState(FocusStateImpl.ActiveParent);
                        break;
                    case 2:
                        grantFocus = activeParent2;
                        break;
                    case 3:
                        FocusTransactionsKt.requireActiveChild(obj);
                        activeParent2 = 0;
                        grantFocus = $i$f$nearestAncestor64DMado6;
                        grantFocus = activeParent2;
                        break;
                    case 4:
                        $this$nearestAncestor_u2d64DMado$iv = obj;
                        int i18 = 0;
                        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(i2);
                        $i$f$nearestAncestor64DMado = 0;
                        i10 = 0;
                        focusState = 0;
                        activeParent = $i$f$getFocusTargetOLwlOKw;
                        i11 = activeParent2;
                        delegatableNode = 0;
                        node$iv$iv$iv4 = i11.getNode().getParent$ui_release();
                        node$iv$iv$iv6 = DelegatableNodeKt.requireLayoutNode(i11);
                        node$iv$iv$iv5 = 0;
                        i2 = 0;
                        head$ui_release = 0;
                        int i20 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        $this$nearestAncestor_u2d64DMado$iv = node;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        node2 = 0;
                        node$iv$iv$iv5 = $i$f$getFocusTargetOLwlOKw;
                        $i$f$nearestAncestor64DMado6 = 1;
                        node2 = 0;
                        count$iv$iv$iv2 = 1;
                        count$iv$iv$iv2 = 0;
                        count$iv$iv$iv2 = 0;
                        i6 = 0;
                        node$iv$iv$iv$iv = (DelegatingNode)$this$nearestAncestor_u2d64DMado$iv.getDelegate$ui_release();
                        i7 = node$iv$iv$iv$iv;
                        i = 0;
                        node3 = 0;
                        this_$iv$iv$iv$iv = 1;
                        this_$iv$iv$iv$iv = 0;
                        count$iv$iv$iv2++;
                        node$iv$iv$iv$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        node$iv$iv$iv2 = theNode$iv$iv$iv2;
                        node3 = i16;
                        int $i$f$mutableVectorOf = 16;
                        i9 = 0;
                        this_$iv$iv$iv$iv2 = count$iv$iv$iv2;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        $this$nearestAncestor_u2d64DMado$iv3 = $i$f$mutableVectorOf;
                        count$iv$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        this_$iv$iv$iv$iv2 = count$iv$iv$iv2;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        count$iv$iv$iv = head$ui_release;
                        Modifier.Node node4 = node$iv$iv$iv$iv2;
                        count$iv$iv$iv.add(node4);
                        node$iv$iv$iv2 = 0;
                        node$iv$iv$iv2 = node$iv$iv$iv$iv2;
                        theNode$iv$iv$iv = node4;
                        count$iv$iv$iv.add(i7);
                        theNode$iv$iv$iv = node4;
                        theNode$iv$iv$iv2 = i7;
                        head$ui_release = count$iv$iv$iv;
                        count$iv$iv$iv2 = this_$iv$iv$iv$iv2;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        theNode$iv$iv$iv2 = i7;
                        node$iv$iv$iv2 = node$iv$iv$iv$iv2;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv = node$iv$iv$iv2;
                        $i$f$nearestAncestor64DMado = $i$f$nearestAncestor64DMado5;
                        node$iv$iv$iv$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $this$nearestAncestor_u2d64DMado$iv = node$iv$iv$iv$iv2;
                        $i$f$nearestAncestor64DMado = $i$f$nearestAncestor64DMado5;
                        $this$nearestAncestor_u2d64DMado$iv = node$iv$iv$iv$iv2;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        $i$f$nearestAncestor64DMado3 = 1;
                        $this$nearestAncestor_u2d64DMado$iv = DelegatableNodeKt.access$pop(head$ui_release);
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $i$f$nearestAncestor64DMado = $i$f$nearestAncestor64DMado5;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        $i$f$nearestAncestor64DMado4 = 1;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        $i$f$nearestAncestor64DMado4 = 1;
                        node$iv$iv$iv4 = node$iv$iv$iv4.getParent$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $i$f$nearestAncestor64DMado = $i$f$nearestAncestor64DMado5;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        $i$f$nearestAncestor64DMado2 = 1;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        $i$f$nearestAncestor64DMado2 = 1;
                        node$iv$iv$iv6 = node$iv$iv$iv6.getParent$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv = node$iv$iv$iv6.getNodes$ui_release();
                        tail$ui_release = $this$nearestAncestor_u2d64DMado$iv.getTail$ui_release();
                        tail$ui_release = 0;
                        node$iv$iv$iv4 = tail$ui_release;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        $i$f$getFocusTargetOLwlOKw = type$iv;
                        $i$f$nearestAncestor64DMado = $i$f$nearestAncestor64DMado5;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = $i$f$getFocusTargetOLwlOKw;
                        $i$f$nearestAncestor64DMado5 = $i$f$nearestAncestor64DMado;
                        $i$f$nearestAncestor64DMado6 = 1;
                        node$iv$iv$iv5 = 0;
                        clearChildFocus$default = node$iv$iv$iv5;
                        $i$f$nearestAncestor64DMado6 = 0;
                        obj.setFocusState(FocusStateImpl.ActiveParent);
                        $i$f$getFocusTargetOLwlOKw = FocusTransactionsKt.requestFocusForChild($this$requestFocusForChild, childNode);
                        i10 = 0;
                        i5 = $i$f$nearestAncestor64DMado6;
                        i5 = 0;
                        FocusEventModifierNodeKt.refreshFocusEventNodes(clearChildFocus$default);
                        grantFocus = $i$f$getFocusTargetOLwlOKw;
                        int i19 = 0;
                        IllegalStateException $i$a$CheckFocusTransactionsKt$requestFocusForChild$3$1 = new IllegalStateException("Deactivated node is focused".toString());
                        throw $i$a$CheckFocusTransactionsKt$requestFocusForChild$3$1;
                        grantFocus = 0;
                        Object obj2 = $this$nearestAncestor_u2d64DMado$iv;
                        int i21 = $i$f$getFocusTargetOLwlOKw;
                        int $this$nearestAncestor_u2d64DMado$iv6 = 0;
                        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv2 = new IllegalStateException(head$ui_release2.toString());
                        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv2;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException;
                }
                return grantFocus;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Non child node cannot request focus.".toString());
            throw illegalStateException;
        }
        androidx.compose.ui.focus.FocusTargetNode focusTargetNode = $this$nearestAncestor_u2d64DMado$iv4;
        int i24 = $i$f$getFocusTargetOLwlOKw2;
        int $this$nearestAncestor_u2d64DMado$iv5 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException(head$ui_release2.toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
    }

    private static final boolean requestFocusForOwner(androidx.compose.ui.focus.FocusTargetNode $this$requestFocusForOwner) {
        final int i = 0;
        return DelegatableNodeKt.requireOwner((DelegatableNode)$this$requestFocusForOwner).getFocusOwner().requestFocusForOwner-7o62pno(i, i);
    }

    private static final androidx.compose.ui.focus.FocusTargetNode requireActiveChild(androidx.compose.ui.focus.FocusTargetNode $this$requireActiveChild) {
        androidx.compose.ui.focus.FocusTargetNode activeChild = FocusTraversalKt.getActiveChild($this$requireActiveChild);
        if (activeChild == null) {
        } else {
            return activeChild;
        }
        int i = 0;
        IllegalArgumentException $i$a$RequireNotNullFocusTransactionsKt$requireActiveChild$1 = new IllegalArgumentException("ActiveParent with no focused child".toString());
        throw $i$a$RequireNotNullFocusTransactionsKt$requireActiveChild$1;
    }
}
