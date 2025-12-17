package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a \u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001aE\u0010\u000b\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\r*\u0008\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000c0\nH\u0082\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0011\u001aE\u0010\u0012\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\r*\u0008\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000c0\nH\u0082\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0011\u001a \u0010\u0013\u001a\u00020\u0007*\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a:\u0010\u0014\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00070\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u000c\u0010\u001a\u001a\u00020\u0007*\u00020\u0008H\u0002\u001a2\u0010\u001b\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00070\nH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a \u0010\u001e\u001a\u00020\u0007*\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a \u0010\u001f\u001a\u00020\u0007*\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a:\u0010 \u001a\u00020\u0007*\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00070\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\u0019\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"InvalidFocusDirection", "", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OneDimensionalFocusSearchKt {

    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal;
            int ordinal4;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            iArr[FocusStateImpl.Active.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            OneDimensionalFocusSearchKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final boolean access$searchChildren-4C6V_qg(androidx.compose.ui.focus.FocusTargetNode $receiver, androidx.compose.ui.focus.FocusTargetNode focusedItem, int direction, Function1 onFound) {
        return OneDimensionalFocusSearchKt.searchChildren-4C6V_qg($receiver, focusedItem, direction, onFound);
    }

    private static final boolean backwardFocusSearch(androidx.compose.ui.focus.FocusTargetNode $this$backwardFocusSearch, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        androidx.compose.ui.focus.FocusTargetNode pickChildForBackwardSearch;
        boolean andSearchChildren-4C6V_qg2;
        boolean andSearchChildren-4C6V_qg;
        int i;
        int[] $EnumSwitchMapping$0;
        andSearchChildren-4C6V_qg2 = 1;
        int i3 = 0;
        switch (pickChildForBackwardSearch) {
            case 1:
                pickChildForBackwardSearch = FocusTraversalKt.getActiveChild($this$backwardFocusSearch);
                andSearchChildren-4C6V_qg = "ActiveParent must have a focusedChild";
                NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException2;
                IllegalStateException illegalStateException2 = new IllegalStateException(andSearchChildren-4C6V_qg.toString());
                throw illegalStateException2;
                andSearchChildren-4C6V_qg2 = OneDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg($this$backwardFocusSearch, pickChildForBackwardSearch, FocusDirection.Companion.getPrevious-dhqQ-8s(), onFound);
                andSearchChildren-4C6V_qg2 = i3;
                IllegalStateException illegalStateException = new IllegalStateException(andSearchChildren-4C6V_qg.toString());
                throw illegalStateException;
            case 2:
                andSearchChildren-4C6V_qg2 = OneDimensionalFocusSearchKt.pickChildForBackwardSearch($this$backwardFocusSearch, onFound);
                break;
            case 3:
                pickChildForBackwardSearch = (Boolean)onFound.invoke($this$backwardFocusSearch).booleanValue();
                pickChildForBackwardSearch = i3;
                andSearchChildren-4C6V_qg2 = i3;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return andSearchChildren-4C6V_qg2;
    }

    private static final <T> void forEachItemAfter(MutableVector<T> $this$forEachItemAfter, T item, Function1<? super T, Unit> action) {
        int itemFound;
        int index;
        IntRange this_$iv;
        int i;
        int content;
        final int i2 = 0;
        itemFound = 0;
        int i3 = 0;
        this_$iv = new IntRange(0, size--);
        int last = this_$iv.getLast();
        if (this_$iv.getFirst() <= last) {
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> $this$forEachItemBefore, T item, Function1<? super T, Unit> action) {
        int itemFound;
        int index;
        IntRange this_$iv;
        int i;
        int content;
        final int i2 = 0;
        itemFound = 0;
        int i3 = 0;
        this_$iv = new IntRange(0, size--);
        int first = this_$iv.getFirst();
        if (first <= this_$iv.getLast()) {
        }
    }

    private static final boolean forwardFocusSearch(androidx.compose.ui.focus.FocusTargetNode $this$forwardFocusSearch, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        int focusedChild;
        boolean andSearchChildren-4C6V_qg;
        switch (i) {
            case 1:
                androidx.compose.ui.focus.FocusTargetNode activeChild = FocusTraversalKt.getActiveChild($this$forwardFocusSearch);
                focusedChild = 0;
                focusedChild = andSearchChildren-4C6V_qg;
                IllegalStateException illegalStateException = new IllegalStateException("ActiveParent must have a focusedChild".toString());
                throw illegalStateException;
            case 2:
                focusedChild = OneDimensionalFocusSearchKt.pickChildForForwardSearch($this$forwardFocusSearch, onFound);
                break;
            case 3:
                focusedChild = (Boolean)onFound.invoke($this$forwardFocusSearch).booleanValue();
                focusedChild = OneDimensionalFocusSearchKt.pickChildForForwardSearch($this$forwardFocusSearch, onFound);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return focusedChild;
    }

    private static final boolean generateAndSearchChildren-4C6V_qg(androidx.compose.ui.focus.FocusTargetNode $this$generateAndSearchChildren_u2d4C6V_qg, androidx.compose.ui.focus.FocusTargetNode focusedItem, int direction, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        boolean booleanValue;
        if (OneDimensionalFocusSearchKt.searchChildren-4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound)) {
            return 1;
        }
        OneDimensionalFocusSearchKt.generateAndSearchChildren.1 anon = new OneDimensionalFocusSearchKt.generateAndSearchChildren.1($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound);
        Object searchBeyondBounds--OM-vw8 = BeyondBoundsLayoutKt.searchBeyondBounds--OM-vw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, (Function1)anon);
        if ((Boolean)searchBeyondBounds--OM-vw8 != null) {
            booleanValue = (Boolean)searchBeyondBounds--OM-vw8.booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }

    private static void getInvalidFocusDirection$annotations() {
    }

    private static void getNoActiveChild$annotations() {
    }

    private static final boolean isRoot(androidx.compose.ui.focus.FocusTargetNode $this$isRoot) {
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        int $this$nearestAncestor_u2d64DMado$iv3;
        int $this$nearestAncestor_u2d64DMado$iv5;
        int $this$nearestAncestor_u2d64DMado$iv4;
        int $i$f$getFocusTargetOLwlOKw;
        int i6;
        int $i$f$nearestAncestor64DMado2;
        int $i$f$nearestAncestor64DMado4;
        int $i$f$nearestAncestor64DMado;
        int $i$f$nearestAncestor64DMado3;
        Modifier.Node node$iv$iv$iv;
        LayoutNode layout$iv$iv$iv;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node this_$iv$iv$iv$iv;
        int i3;
        int i;
        Modifier.Node next$iv$iv$iv;
        Modifier.Node head$ui_release;
        Modifier.Node node3;
        int i9;
        Modifier.Node node4;
        int i4;
        int i10;
        int node$iv$iv$iv3;
        Modifier.Node node2;
        int i8;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node;
        int i5;
        int this_$iv$iv$iv$iv2;
        int i12;
        int i11;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int i7;
        int i2;
        $this$nearestAncestor_u2d64DMado$iv = $this$isRoot;
        int i13 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        i6 = 0;
        final int i15 = 0;
        final int i16 = 0;
        final int i17 = $i$f$getFocusTargetOLwlOKw;
        final DelegatableNode delegatableNode2 = delegatableNode;
        final int i18 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv$iv = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i17 == 0) {
                    break;
                }
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                $this$nearestAncestor_u2d64DMado$iv = layout$iv$iv$iv.getNodes$ui_release();
                if (layout$iv$iv$iv != null && $this$nearestAncestor_u2d64DMado$iv != null) {
                } else {
                }
                node$iv$iv$iv2 = 0;
                node$iv$iv$iv = node$iv$iv$iv2;
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                $i$f$getFocusTargetOLwlOKw = i7;
                i6 = i2;
                $this$nearestAncestor_u2d64DMado$iv = layout$iv$iv$iv.getNodes$ui_release();
                if ($this$nearestAncestor_u2d64DMado$iv != null) {
                } else {
                }
                node$iv$iv$iv2 = $this$nearestAncestor_u2d64DMado$iv.getTail$ui_release();
                while (node$iv$iv$iv != null) {
                    if (kindSet$ui_release &= i17 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $this$nearestAncestor_u2d64DMado$iv5 = i;
                    $i$f$nearestAncestor64DMado = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                    i = $this$nearestAncestor_u2d64DMado$iv5;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i6 = i2;
                    i9 = 0;
                    i4 = 0;
                    i10 = 0;
                    int i19 = 0;
                    node$iv$iv$iv2 = node$iv$iv$iv3;
                    while (node$iv$iv$iv2 != null) {
                        node2 = 0;
                        if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        $this$nearestAncestor_u2d64DMado$iv3 = i;
                        $i$f$nearestAncestor64DMado4 = 0;
                        node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                        i = $this$nearestAncestor_u2d64DMado$iv3;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        $i$f$getFocusTargetOLwlOKw = i7;
                        i6 = i2;
                        if (node$iv$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        i8 = 0;
                        node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv$iv != null) {
                            node = node$iv$iv$iv$iv;
                            i5 = 0;
                            i12 = 0;
                            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv2 = 0;
                            if (this_$iv$iv$iv$iv2 != 0) {
                            } else {
                            }
                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                            i7 = $i$f$getFocusTargetOLwlOKw;
                            i2 = i6;
                            next$iv$iv$iv = node;
                            $i$f$nearestAncestor64DMado2 = 0;
                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                            $i$f$getFocusTargetOLwlOKw = i7;
                            i6 = i2;
                            i = 1;
                            if (this_$iv$iv$iv$iv++ == i) {
                            } else {
                            }
                            if (i10 == 0) {
                            } else {
                            }
                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                            i7 = $i$f$getFocusTargetOLwlOKw;
                            i2 = i6;
                            $i$f$nearestAncestor64DMado2 = 0;
                            $this$nearestAncestor_u2d64DMado$iv = i10;
                            $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv2;
                            if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv != 0) {
                            }
                            if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node;
                            i10 = $this$nearestAncestor_u2d64DMado$iv;
                            $this$nearestAncestor_u2d64DMado$iv.add(node);
                            if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                            }
                            node$iv$iv$iv2 = 0;
                            $this$nearestAncestor_u2d64DMado$iv.add($i$f$getFocusTargetOLwlOKw);
                            this_$iv$iv$iv$iv2 = 0;
                            i11 = 0;
                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                            i7 = $i$f$getFocusTargetOLwlOKw;
                            i2 = i6;
                            $this$nearestAncestor_u2d64DMado$iv = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv$iv2 = node;
                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                            i7 = $i$f$getFocusTargetOLwlOKw;
                            i2 = i6;
                            next$iv$iv$iv = node;
                            $i$f$nearestAncestor64DMado2 = 0;
                            this_$iv$iv$iv$iv2 = i;
                        }
                        $i$f$nearestAncestor64DMado4 = 0;
                        $this$nearestAncestor_u2d64DMado$iv3 = 1;
                        if (this_$iv$iv$iv$iv == $this$nearestAncestor_u2d64DMado$iv3) {
                        } else {
                        }
                        i = $this$nearestAncestor_u2d64DMado$iv3;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        $i$f$getFocusTargetOLwlOKw = i7;
                        i6 = i2;
                        node = node$iv$iv$iv$iv;
                        i5 = 0;
                        i12 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        next$iv$iv$iv = node;
                        $i$f$nearestAncestor64DMado2 = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        $i$f$getFocusTargetOLwlOKw = i7;
                        i6 = i2;
                        i = 1;
                        if (this_$iv$iv$iv$iv++ == i) {
                        } else {
                        }
                        if (i10 == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        $i$f$nearestAncestor64DMado2 = 0;
                        $this$nearestAncestor_u2d64DMado$iv = i10;
                        $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv2;
                        if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node;
                        i10 = $this$nearestAncestor_u2d64DMado$iv;
                        $this$nearestAncestor_u2d64DMado$iv.add(node);
                        if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                        }
                        node$iv$iv$iv2 = 0;
                        $this$nearestAncestor_u2d64DMado$iv.add($i$f$getFocusTargetOLwlOKw);
                        this_$iv$iv$iv$iv2 = 0;
                        i11 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        $this$nearestAncestor_u2d64DMado$iv = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv2 = node;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        next$iv$iv$iv = node;
                        $i$f$nearestAncestor64DMado2 = 0;
                        this_$iv$iv$iv$iv2 = i;
                        this_$iv$iv$iv$iv = i;
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $this$nearestAncestor_u2d64DMado$iv5 = i;
                    $i$f$nearestAncestor64DMado = 0;
                    node2 = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $this$nearestAncestor_u2d64DMado$iv3 = i;
                    $i$f$nearestAncestor64DMado4 = 0;
                    node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                    i = $this$nearestAncestor_u2d64DMado$iv3;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i6 = i2;
                    if (node$iv$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    i8 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node = node$iv$iv$iv$iv;
                        i5 = 0;
                        i12 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        next$iv$iv$iv = node;
                        $i$f$nearestAncestor64DMado2 = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        $i$f$getFocusTargetOLwlOKw = i7;
                        i6 = i2;
                        i = 1;
                        if (this_$iv$iv$iv$iv++ == i) {
                        } else {
                        }
                        if (i10 == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        $i$f$nearestAncestor64DMado2 = 0;
                        $this$nearestAncestor_u2d64DMado$iv = i10;
                        $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv2;
                        if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node;
                        i10 = $this$nearestAncestor_u2d64DMado$iv;
                        $this$nearestAncestor_u2d64DMado$iv.add(node);
                        if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                        }
                        node$iv$iv$iv2 = 0;
                        $this$nearestAncestor_u2d64DMado$iv.add($i$f$getFocusTargetOLwlOKw);
                        this_$iv$iv$iv$iv2 = 0;
                        i11 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        $this$nearestAncestor_u2d64DMado$iv = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv2 = node;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        next$iv$iv$iv = node;
                        $i$f$nearestAncestor64DMado2 = 0;
                        this_$iv$iv$iv$iv2 = i;
                    }
                    $i$f$nearestAncestor64DMado4 = 0;
                    $this$nearestAncestor_u2d64DMado$iv3 = 1;
                    if (this_$iv$iv$iv$iv == $this$nearestAncestor_u2d64DMado$iv3) {
                    } else {
                    }
                    i = $this$nearestAncestor_u2d64DMado$iv3;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i6 = i2;
                    node = node$iv$iv$iv$iv;
                    i5 = 0;
                    i12 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado2 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i6 = i2;
                    i = 1;
                    if (this_$iv$iv$iv$iv++ == i) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $i$f$nearestAncestor64DMado2 = 0;
                    $this$nearestAncestor_u2d64DMado$iv = i10;
                    $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv2;
                    if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i10 = $this$nearestAncestor_u2d64DMado$iv;
                    $this$nearestAncestor_u2d64DMado$iv.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                    }
                    node$iv$iv$iv2 = 0;
                    $this$nearestAncestor_u2d64DMado$iv.add($i$f$getFocusTargetOLwlOKw);
                    this_$iv$iv$iv$iv2 = 0;
                    i11 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $this$nearestAncestor_u2d64DMado$iv = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv2 = node;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado2 = 0;
                    this_$iv$iv$iv$iv2 = i;
                    this_$iv$iv$iv$iv = i;
                }
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                if (kindSet$ui_release &= i17 == 0) {
                    break;
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                $this$nearestAncestor_u2d64DMado$iv5 = i;
                $i$f$nearestAncestor64DMado = 0;
                node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release();
                i = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                $i$f$getFocusTargetOLwlOKw = i7;
                i6 = i2;
                i9 = 0;
                i4 = 0;
                i10 = 0;
                i19 = 0;
                node$iv$iv$iv2 = node$iv$iv$iv3;
                while (node$iv$iv$iv2 != null) {
                    node2 = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $this$nearestAncestor_u2d64DMado$iv3 = i;
                    $i$f$nearestAncestor64DMado4 = 0;
                    node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                    i = $this$nearestAncestor_u2d64DMado$iv3;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i6 = i2;
                    if (node$iv$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    i8 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node = node$iv$iv$iv$iv;
                        i5 = 0;
                        i12 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv$iv2 != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        next$iv$iv$iv = node;
                        $i$f$nearestAncestor64DMado2 = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        $i$f$getFocusTargetOLwlOKw = i7;
                        i6 = i2;
                        i = 1;
                        if (this_$iv$iv$iv$iv++ == i) {
                        } else {
                        }
                        if (i10 == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        $i$f$nearestAncestor64DMado2 = 0;
                        $this$nearestAncestor_u2d64DMado$iv = i10;
                        $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv2;
                        if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node;
                        i10 = $this$nearestAncestor_u2d64DMado$iv;
                        $this$nearestAncestor_u2d64DMado$iv.add(node);
                        if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                        }
                        node$iv$iv$iv2 = 0;
                        $this$nearestAncestor_u2d64DMado$iv.add($i$f$getFocusTargetOLwlOKw);
                        this_$iv$iv$iv$iv2 = 0;
                        i11 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        $this$nearestAncestor_u2d64DMado$iv = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv2 = node;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        i7 = $i$f$getFocusTargetOLwlOKw;
                        i2 = i6;
                        next$iv$iv$iv = node;
                        $i$f$nearestAncestor64DMado2 = 0;
                        this_$iv$iv$iv$iv2 = i;
                    }
                    $i$f$nearestAncestor64DMado4 = 0;
                    $this$nearestAncestor_u2d64DMado$iv3 = 1;
                    if (this_$iv$iv$iv$iv == $this$nearestAncestor_u2d64DMado$iv3) {
                    } else {
                    }
                    i = $this$nearestAncestor_u2d64DMado$iv3;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i6 = i2;
                    node = node$iv$iv$iv$iv;
                    i5 = 0;
                    i12 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado2 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i6 = i2;
                    i = 1;
                    if (this_$iv$iv$iv$iv++ == i) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $i$f$nearestAncestor64DMado2 = 0;
                    $this$nearestAncestor_u2d64DMado$iv = i10;
                    $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv2;
                    if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i10 = $this$nearestAncestor_u2d64DMado$iv;
                    $this$nearestAncestor_u2d64DMado$iv.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                    }
                    node$iv$iv$iv2 = 0;
                    $this$nearestAncestor_u2d64DMado$iv.add($i$f$getFocusTargetOLwlOKw);
                    this_$iv$iv$iv$iv2 = 0;
                    i11 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $this$nearestAncestor_u2d64DMado$iv = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv2 = node;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado2 = 0;
                    this_$iv$iv$iv$iv2 = i;
                    this_$iv$iv$iv$iv = i;
                }
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                $this$nearestAncestor_u2d64DMado$iv5 = i;
                $i$f$nearestAncestor64DMado = 0;
                node2 = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                $this$nearestAncestor_u2d64DMado$iv3 = i;
                $i$f$nearestAncestor64DMado4 = 0;
                node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                i = $this$nearestAncestor_u2d64DMado$iv3;
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                $i$f$getFocusTargetOLwlOKw = i7;
                i6 = i2;
                if (node$iv$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                i8 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv$iv != null) {
                    node = node$iv$iv$iv$iv;
                    i5 = 0;
                    i12 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado2 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i6 = i2;
                    i = 1;
                    if (this_$iv$iv$iv$iv++ == i) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $i$f$nearestAncestor64DMado2 = 0;
                    $this$nearestAncestor_u2d64DMado$iv = i10;
                    $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv2;
                    if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i10 = $this$nearestAncestor_u2d64DMado$iv;
                    $this$nearestAncestor_u2d64DMado$iv.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                    }
                    node$iv$iv$iv2 = 0;
                    $this$nearestAncestor_u2d64DMado$iv.add($i$f$getFocusTargetOLwlOKw);
                    this_$iv$iv$iv$iv2 = 0;
                    i11 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    $this$nearestAncestor_u2d64DMado$iv = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv2 = node;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    i2 = i6;
                    next$iv$iv$iv = node;
                    $i$f$nearestAncestor64DMado2 = 0;
                    this_$iv$iv$iv$iv2 = i;
                }
                $i$f$nearestAncestor64DMado4 = 0;
                $this$nearestAncestor_u2d64DMado$iv3 = 1;
                if (this_$iv$iv$iv$iv == $this$nearestAncestor_u2d64DMado$iv3) {
                } else {
                }
                i = $this$nearestAncestor_u2d64DMado$iv3;
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                $i$f$getFocusTargetOLwlOKw = i7;
                i6 = i2;
                node = node$iv$iv$iv$iv;
                i5 = 0;
                i12 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv$iv2 != 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                next$iv$iv$iv = node;
                $i$f$nearestAncestor64DMado2 = 0;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                $i$f$getFocusTargetOLwlOKw = i7;
                i6 = i2;
                i = 1;
                if (this_$iv$iv$iv$iv++ == i) {
                } else {
                }
                if (i10 == 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                $i$f$nearestAncestor64DMado2 = 0;
                $this$nearestAncestor_u2d64DMado$iv = i10;
                $i$f$getFocusTargetOLwlOKw = node$iv$iv$iv2;
                if ($i$f$getFocusTargetOLwlOKw != null && $this$nearestAncestor_u2d64DMado$iv != 0) {
                }
                if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                } else {
                }
                next$iv$iv$iv = node;
                i10 = $this$nearestAncestor_u2d64DMado$iv;
                $this$nearestAncestor_u2d64DMado$iv.add(node);
                if ($this$nearestAncestor_u2d64DMado$iv != 0) {
                }
                node$iv$iv$iv2 = 0;
                $this$nearestAncestor_u2d64DMado$iv.add($i$f$getFocusTargetOLwlOKw);
                this_$iv$iv$iv$iv2 = 0;
                i11 = 0;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                $this$nearestAncestor_u2d64DMado$iv = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv$iv2 = node;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                i2 = i6;
                next$iv$iv$iv = node;
                $i$f$nearestAncestor64DMado2 = 0;
                this_$iv$iv$iv$iv2 = i;
                this_$iv$iv$iv$iv = i;
            }
            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
            i7 = $i$f$getFocusTargetOLwlOKw;
            i2 = i6;
            $this$nearestAncestor_u2d64DMado$iv4 = i;
            $i$f$nearestAncestor64DMado3 = 0;
            node$iv$iv$iv2 = 0;
            i3 = node$iv$iv$iv2 == null ? $this$nearestAncestor_u2d64DMado$iv4 : $i$f$nearestAncestor64DMado3;
            return i3;
        }
        DelegatableNode delegatableNode3 = $this$nearestAncestor_u2d64DMado$iv;
        int i20 = $i$f$getFocusTargetOLwlOKw;
        int $this$nearestAncestor_u2d64DMado$iv6 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv$iv;
    }

    public static final boolean oneDimensionalFocusSearch--OM-vw8(androidx.compose.ui.focus.FocusTargetNode $this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, int direction, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        boolean backwardFocusSearch;
        if (FocusDirection.equals-impl0(direction, FocusDirection.Companion.getNext-dhqQ-8s())) {
            backwardFocusSearch = OneDimensionalFocusSearchKt.forwardFocusSearch($this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, onFound);
            return backwardFocusSearch;
        } else {
            if (!FocusDirection.equals-impl0(direction, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
            } else {
                backwardFocusSearch = OneDimensionalFocusSearchKt.backwardFocusSearch($this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, onFound);
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("This function should only be used for 1-D focus search".toString());
        throw illegalStateException;
    }

    private static final boolean pickChildForBackwardSearch(androidx.compose.ui.focus.FocusTargetNode $this$pickChildForBackwardSearch, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        MutableVector capacity$iv;
        int $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
        MutableVector mutableVector;
        Modifier.Node next$iv$iv;
        int i$iv;
        Object node$iv$iv2;
        int $i$f$getFocusTargetOLwlOKw;
        int i4;
        int i8;
        boolean eligibleForFocusSearch;
        Object child$ui_release;
        int node;
        int count$iv$iv2;
        int count$iv$iv;
        Modifier.Node[] node$iv$iv3;
        int i12;
        int i9;
        Object obj;
        int i11;
        int i10;
        Object node$iv$iv;
        int i;
        Object obj2;
        int i6;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i2;
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u249;
        int this_$iv$iv$iv;
        int i7;
        int i5;
        int $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
        MutableVector mutableVector2;
        int i3;
        int i15 = 0;
        i$iv = 0;
        mutableVector = new MutableVector(new FocusTargetNode[16], i$iv);
        int i17 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        i4 = 0;
        i8 = $i$f$getFocusTargetOLwlOKw;
        eligibleForFocusSearch = z;
        final int i19 = 0;
        if (!eligibleForFocusSearch.getNode().isAttached()) {
        } else {
            int i20 = 0;
            count$iv$iv2 = 0;
            MutableVector mutableVector6 = new MutableVector(new Modifier.Node[16], i$iv);
            child$ui_release = eligibleForFocusSearch.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector6, eligibleForFocusSearch.getNode());
            } else {
                mutableVector6.add(child$ui_release);
            }
            while (mutableVector6.isNotEmpty()) {
                int i21 = 0;
                node = mutableVector6.removeAt(size2 -= count$iv$iv2);
                if (aggregateChildKindSet$ui_release &= i8 == 0) {
                } else {
                }
                node$iv$iv3 = node;
                while (node$iv$iv3 != null) {
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    i$iv = 0;
                    count$iv$iv2 = 1;
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                i$iv = 0;
                if (kindSet$ui_release &= i8 != 0) {
                } else {
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                i$iv = 0;
                count$iv$iv2 = 1;
                i9 = 0;
                i11 = 0;
                i10 = 0;
                int i22 = 0;
                node$iv$iv2 = node$iv$iv;
                while (node$iv$iv2 != null) {
                    if (node$iv$iv2 instanceof FocusTargetNode) {
                    } else {
                    }
                    obj2 = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                    capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
                    mutableVector = mutableVector2;
                    count$iv$iv2 = 1;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i6 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i2 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                        mutableVector2 = mutableVector;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
                        mutableVector = mutableVector2;
                        $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                        if (count$iv$iv++ == 1) {
                        } else {
                        }
                        if (i10 == 0) {
                        } else {
                        }
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                        mutableVector2 = mutableVector;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = i10;
                        capacity$iv = node$iv$iv2;
                        if (capacity$iv != null && $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                        }
                        if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i10 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1.add(node2);
                        if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                        }
                        node$iv$iv2 = mutableVector;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1.add(capacity$iv);
                        i7 = i14;
                        int $i$f$mutableVectorOf = 16;
                        i5 = 0;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                        mutableVector2 = mutableVector;
                        i3 = $i$f$mutableVectorOf;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv2 = node2;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                        mutableVector2 = mutableVector;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
                    mutableVector = mutableVector2;
                    count$iv$iv2 = 1;
                    node2 = node$iv$iv$iv;
                    i2 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
                    mutableVector = mutableVector2;
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = i10;
                    capacity$iv = node$iv$iv2;
                    if (capacity$iv != null && $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                    }
                    if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i10 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1.add(node2);
                    if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                    }
                    node$iv$iv2 = mutableVector;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1.add(capacity$iv);
                    i7 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    i3 = $i$f$mutableVectorOf;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv2 = node2;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    obj2 = 0;
                    capacity$iv.add((FocusTargetNode)node$iv$iv2);
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                i$iv = 0;
                if (node$iv$iv2 instanceof FocusTargetNode) {
                } else {
                }
                obj2 = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                node$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
                mutableVector = mutableVector2;
                count$iv$iv2 = 1;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                i6 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i2 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
                    mutableVector = mutableVector2;
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = i10;
                    capacity$iv = node$iv$iv2;
                    if (capacity$iv != null && $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                    }
                    if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i10 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1.add(node2);
                    if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                    }
                    node$iv$iv2 = mutableVector;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1.add(capacity$iv);
                    i7 = i14;
                    $i$f$mutableVectorOf = 16;
                    i5 = 0;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    i3 = $i$f$mutableVectorOf;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv2 = node2;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                    mutableVector2 = mutableVector;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
                mutableVector = mutableVector2;
                count$iv$iv2 = 1;
                node2 = node$iv$iv$iv;
                i2 = 0;
                i7 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                next$iv$iv = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12;
                mutableVector = mutableVector2;
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                if (count$iv$iv++ == 1) {
                } else {
                }
                if (i10 == 0) {
                } else {
                }
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = i10;
                capacity$iv = node$iv$iv2;
                if (capacity$iv != null && $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                }
                if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                } else {
                }
                next$iv$iv = node2;
                i10 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1.add(node2);
                if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 != 0) {
                }
                node$iv$iv2 = mutableVector;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1.add(capacity$iv);
                i7 = i14;
                $i$f$mutableVectorOf = 16;
                i5 = 0;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                i3 = $i$f$mutableVectorOf;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv2 = node2;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                next$iv$iv = node2;
                this_$iv$iv$iv = 1;
                count$iv$iv = 1;
                obj2 = 0;
                capacity$iv.add((FocusTargetNode)node$iv$iv2);
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
                mutableVector2 = mutableVector;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector6, node);
            }
            MutableVector $this$pickChildForBackwardSearch_u24lambda_u2493 = capacity$iv;
            int i25 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
            MutableVector mutableVector3 = mutableVector8;
            mutableVector3.sortWith((Comparator)FocusableChildrenComparator.INSTANCE);
            MutableVector mutableVector4 = mutableVector3;
            int i16 = 0;
            int size = mutableVector4.getSize();
            if (size > 0) {
                i$iv = size + -1;
                i4 = mutableVector4.getContent()[i$iv];
                i8 = 0;
                while (FocusTraversalKt.isEligibleForFocusSearch((FocusTargetNode)i4)) {
                    i = 1;
                    i4 = $i$f$getFocusTargetOLwlOKw[i$iv];
                    i8 = 0;
                    child$ui_release = onFound;
                }
                return 1;
            }
            child$ui_release = onFound;
            return 0;
        }
        MutableVector mutableVector7 = capacity$iv;
        int i26 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForBackwardSearch$children$1;
        int $this$pickChildForBackwardSearch_u24lambda_u2492 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    private static final boolean pickChildForForwardSearch(androidx.compose.ui.focus.FocusTargetNode $this$pickChildForForwardSearch, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        MutableVector capacity$iv;
        int $this$pickChildForForwardSearch_u24lambda_u2462;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        int $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
        MutableVector mutableVector;
        int i8;
        Object node$iv$iv;
        int size$iv;
        int $i$f$getFocusTargetOLwlOKw;
        Object[] content;
        int it;
        int i;
        int eligibleForFocusSearch;
        Modifier.Node child$ui_release;
        int node;
        int count$iv$iv;
        int count$iv$iv2;
        Modifier.Node[] node$iv$iv3;
        int i6;
        int i2;
        Object obj2;
        int i11;
        int i3;
        Object node$iv$iv2;
        Object obj;
        int i4;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i10;
        MutableVector $this$pickChildForForwardSearch_u24lambda_u246;
        int this_$iv$iv$iv;
        int i7;
        int i9;
        int $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
        MutableVector mutableVector2;
        int i5;
        int i14 = 0;
        i8 = 0;
        mutableVector = new MutableVector(new FocusTargetNode[16], i8);
        int i17 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        content = 0;
        it = $i$f$getFocusTargetOLwlOKw;
        i = i15;
        eligibleForFocusSearch = 0;
        if (!i.getNode().isAttached()) {
        } else {
            int i19 = 0;
            count$iv$iv = 0;
            MutableVector mutableVector6 = new MutableVector(new Modifier.Node[16], i8);
            child$ui_release = i.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector6, i.getNode());
            } else {
                mutableVector6.add(child$ui_release);
            }
            count$iv$iv = 1;
            while (mutableVector6.isNotEmpty()) {
                int i20 = 0;
                node = mutableVector6.removeAt(size2 -= count$iv$iv);
                if (aggregateChildKindSet$ui_release &= it == 0) {
                } else {
                }
                node$iv$iv3 = node;
                while (node$iv$iv3 != null) {
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    int $this$pickChildForForwardSearch_u24lambda_u2465 = count$iv$iv;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                    i8 = 0;
                }
                $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                i8 = 0;
                count$iv$iv = 1;
                if (kindSet$ui_release &= it != 0) {
                } else {
                }
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                $this$pickChildForForwardSearch_u24lambda_u2465 = count$iv$iv;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                i8 = 0;
                i2 = 0;
                i11 = 0;
                i3 = 0;
                int i21 = 0;
                node$iv$iv = node$iv$iv2;
                while (node$iv$iv != null) {
                    if (node$iv$iv instanceof FocusTargetNode) {
                    } else {
                    }
                    obj = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    $this$pickChildForForwardSearch_u24lambda_u2462 = 1;
                    node$iv$iv = DelegatableNodeKt.access$pop(i3);
                    count$iv$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
                    mutableVector = mutableVector2;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    i4 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i10 = 0;
                        i7 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                        mutableVector2 = mutableVector;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
                        mutableVector = mutableVector2;
                        $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                        if (count$iv$iv2++ == 1) {
                        } else {
                        }
                        if (i3 == 0) {
                        } else {
                        }
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                        mutableVector2 = mutableVector;
                        capacity$iv$iv$iv$iv = 0;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = i3;
                        mutableVector = node$iv$iv;
                        if (mutableVector != null && $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                        }
                        if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i3 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12.add(node2);
                        if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                        }
                        node$iv$iv = 0;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12.add(mutableVector);
                        i7 = i13;
                        int $i$f$mutableVectorOf = 16;
                        i9 = 0;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                        mutableVector2 = mutableVector;
                        i5 = $i$f$mutableVectorOf;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = node2;
                        $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                        mutableVector2 = mutableVector;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = 1;
                    }
                    $this$pickChildForForwardSearch_u24lambda_u2462 = 1;
                    if (count$iv$iv2 == $this$pickChildForForwardSearch_u24lambda_u2462) {
                    } else {
                    }
                    count$iv$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
                    mutableVector = mutableVector2;
                    node2 = node$iv$iv$iv;
                    i10 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
                    mutableVector = mutableVector2;
                    $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    capacity$iv$iv$iv$iv = 0;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = i3;
                    mutableVector = node$iv$iv;
                    if (mutableVector != null && $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                    }
                    if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i3 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12.add(node2);
                    if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                    }
                    node$iv$iv = 0;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12.add(mutableVector);
                    i7 = i13;
                    $i$f$mutableVectorOf = 16;
                    i9 = 0;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    i5 = $i$f$mutableVectorOf;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node2;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv2 = 1;
                    obj = 0;
                    capacity$iv.add((FocusTargetNode)node$iv$iv);
                    $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    $this$pickChildForForwardSearch_u24lambda_u2462 = 1;
                }
                $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                i8 = 0;
                if (node$iv$iv instanceof FocusTargetNode) {
                } else {
                }
                obj = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                $this$pickChildForForwardSearch_u24lambda_u2462 = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(i3);
                count$iv$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
                mutableVector = mutableVector2;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                i4 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i10 = 0;
                    i7 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
                    mutableVector = mutableVector2;
                    $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    capacity$iv$iv$iv$iv = 0;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = i3;
                    mutableVector = node$iv$iv;
                    if (mutableVector != null && $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                    }
                    if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i3 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12.add(node2);
                    if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                    }
                    node$iv$iv = 0;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12.add(mutableVector);
                    i7 = i13;
                    $i$f$mutableVectorOf = 16;
                    i9 = 0;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    i5 = $i$f$mutableVectorOf;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node2;
                    $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                    mutableVector2 = mutableVector;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                }
                $this$pickChildForForwardSearch_u24lambda_u2462 = 1;
                if (count$iv$iv2 == $this$pickChildForForwardSearch_u24lambda_u2462) {
                } else {
                }
                count$iv$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
                mutableVector = mutableVector2;
                node2 = node$iv$iv$iv;
                i10 = 0;
                i7 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                next$iv$iv = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                capacity$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1;
                mutableVector = mutableVector2;
                $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                if (count$iv$iv2++ == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                capacity$iv$iv$iv$iv = 0;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = i3;
                mutableVector = node$iv$iv;
                if (mutableVector != null && $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                }
                if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                } else {
                }
                next$iv$iv = node2;
                i3 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12.add(node2);
                if ($i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 != 0) {
                }
                node$iv$iv = 0;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12.add(mutableVector);
                i7 = i13;
                $i$f$mutableVectorOf = 16;
                i9 = 0;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                i5 = $i$f$mutableVectorOf;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = node2;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                next$iv$iv = node2;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                obj = 0;
                capacity$iv.add((FocusTargetNode)node$iv$iv);
                $this$pickChildForForwardSearch_u24lambda_u246 = capacity$iv;
                $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$1 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
                mutableVector2 = mutableVector;
                $this$pickChildForForwardSearch_u24lambda_u2462 = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector6, node);
            }
            MutableVector $this$pickChildForForwardSearch_u24lambda_u2467 = capacity$iv;
            int i23 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
            int $this$pickChildForForwardSearch_u24lambda_u2466 = count$iv$iv;
            MutableVector mutableVector3 = mutableVector8;
            mutableVector3.sortWith((Comparator)FocusableChildrenComparator.INSTANCE);
            MutableVector mutableVector4 = mutableVector3;
            int i16 = 0;
            int size = mutableVector4.getSize();
            if (size > 0) {
                $i$f$getFocusTargetOLwlOKw = 0;
                Object obj3 = mutableVector4.getContent()[$i$f$getFocusTargetOLwlOKw];
                i = 0;
                while (FocusTraversalKt.isEligibleForFocusSearch((FocusTargetNode)obj3)) {
                    if (OneDimensionalFocusSearchKt.forwardFocusSearch(obj3, onFound)) {
                    } else {
                    }
                    it = 0;
                    obj3 = content[$i$f$getFocusTargetOLwlOKw];
                    i = 0;
                    child$ui_release = onFound;
                    it = $this$pickChildForForwardSearch_u24lambda_u2466;
                }
                size$iv = $this$pickChildForForwardSearch_u24lambda_u2466;
            } else {
                child$ui_release = onFound;
                size$iv = 0;
            }
            return size$iv;
        }
        MutableVector mutableVector7 = capacity$iv;
        int i22 = $i$a$ApplyOneDimensionalFocusSearchKt$pickChildForForwardSearch$children$12;
        int $this$pickChildForForwardSearch_u24lambda_u2463 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    private static final boolean searchChildren-4C6V_qg(androidx.compose.ui.focus.FocusTargetNode $this$searchChildren_u2d4C6V_qg, androidx.compose.ui.focus.FocusTargetNode focusedItem, int direction, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        int i12;
        MutableVector capacity$iv;
        Modifier.Node $this$searchChildren_4C6V_qg_u24lambda_u2422;
        int $this$searchChildren_4C6V_qg_u24lambda_u242;
        MutableVector $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1;
        int count$iv$iv3;
        int count$iv$iv2;
        MutableVector mutableVector2;
        boolean canFocus;
        int i6;
        int node$iv$iv3;
        int i9;
        int itemFound$iv;
        Modifier.Node node;
        int index$iv2;
        int index$iv;
        IntRange this_$iv$iv;
        int i17;
        int eligibleForFocusSearch;
        int node$iv$iv;
        int i8;
        int i10;
        int size;
        int i;
        int i5;
        int i2;
        int i7;
        int theNode$iv$iv;
        int node$iv$iv2;
        MutableVector mutableVector;
        int i14;
        int i15;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i3;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2423;
        int this_$iv$iv$iv;
        int i11;
        int i4;
        int count$iv$iv;
        int i13;
        int i16;
        final androidx.compose.ui.focus.FocusTargetNode focusTargetNode = $this$searchChildren_u2d4C6V_qg;
        final Object obj = focusedItem;
        final int i18 = direction;
        final Function1 function1 = onFound;
        i6 = 0;
        i12 = focusTargetNode.getFocusState() == FocusStateImpl.ActiveParent ? 1 : i6;
        if (i12 == 0) {
        } else {
            int i23 = 0;
            MutableVector mutableVector4 = new MutableVector(new FocusTargetNode[16], i6);
            int i24 = 0;
            int i29 = 0;
            int $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
            int i31 = 0;
            int i34 = $i$f$getFocusTargetOLwlOKw;
            final androidx.compose.ui.focus.FocusTargetNode focusTargetNode3 = focusTargetNode2;
            final int i35 = 0;
            if (!focusTargetNode3.getNode().isAttached()) {
            } else {
                node$iv$iv = 0;
                i8 = 1;
                size = 0;
                int i39 = i24;
                $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1 = new MutableVector(new Modifier.Node[16], i6);
                Modifier.Node child$ui_release = focusTargetNode3.getNode().getChild$ui_release();
                if (child$ui_release == null) {
                    DelegatableNodeKt.access$addLayoutNodeChildren($i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1, focusTargetNode3.getNode());
                } else {
                    $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1.add(child$ui_release);
                }
                while ($i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1.isNotEmpty()) {
                    int i36 = 0;
                    node = $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1.removeAt(size + -1);
                    if (aggregateChildKindSet$ui_release &= i34 == 0) {
                    } else {
                    }
                    node$iv$iv = node;
                    while (node$iv$iv != 0) {
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                        mutableVector = $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1;
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        i6 = 0;
                        i8 = 1;
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                    mutableVector = $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1;
                    i6 = 0;
                    i8 = 1;
                    if (kindSet$ui_release &= i34 != 0) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                    mutableVector = $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    i6 = 0;
                    i8 = 1;
                    i = 0;
                    i2 = 0;
                    i7 = 0;
                    int i41 = 0;
                    node$iv$iv3 = node$iv$iv2;
                    while (node$iv$iv3 != 0) {
                        mutableVector = $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1;
                        if (node$iv$iv3 instanceof FocusTargetNode) {
                        } else {
                        }
                        i14 = 0;
                        if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        count$iv$iv3 = 0;
                        if (count$iv$iv3 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                        node$iv$iv3 = DelegatableNodeKt.access$pop(i7);
                        $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1 = mutableVector;
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                        i8 = 1;
                        if (node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv3 = 0;
                        i15 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i3 = 0;
                            i11 = 0;
                            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                            i13 = node$iv$iv3;
                            $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                            i8 = 1;
                            count$iv$iv3++;
                            $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                            if (count$iv$iv3 == i8) {
                            } else {
                            }
                            if (i7 == 0) {
                            } else {
                            }
                            count$iv$iv = count$iv$iv3;
                            i13 = node$iv$iv3;
                            count$iv$iv2 = i7;
                            int i21 = i13;
                            if (i21 != 0) {
                            } else {
                            }
                            node$iv$iv3 = i13;
                            if (count$iv$iv2 != 0) {
                            } else {
                            }
                            theNode$iv$iv = i21;
                            $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                            i7 = count$iv$iv2;
                            count$iv$iv3 = count$iv$iv;
                            theNode$iv$iv = i21;
                            count$iv$iv2.add(node2);
                            if (count$iv$iv2 != 0) {
                            }
                            node$iv$iv3 = 0;
                            count$iv$iv2.add(i21);
                            i11 = i22;
                            int $i$f$mutableVectorOf = 16;
                            i4 = 0;
                            count$iv$iv = count$iv$iv3;
                            i13 = node$iv$iv3;
                            i16 = $i$f$mutableVectorOf;
                            count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            node$iv$iv3 = node2;
                            $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                            this_$iv$iv$iv = i8;
                        }
                        i13 = node$iv$iv3;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        node$iv$iv3 = i13;
                        $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1 = mutableVector;
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                        node$iv$iv3 = i13;
                        i8 = 1;
                        node2 = node$iv$iv$iv;
                        i3 = 0;
                        i11 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                        i13 = node$iv$iv3;
                        $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                        i8 = 1;
                        count$iv$iv3++;
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                        if (count$iv$iv3 == i8) {
                        } else {
                        }
                        if (i7 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        i13 = node$iv$iv3;
                        count$iv$iv2 = i7;
                        i21 = i13;
                        if (i21 != 0) {
                        } else {
                        }
                        node$iv$iv3 = i13;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        theNode$iv$iv = i21;
                        $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                        i7 = count$iv$iv2;
                        count$iv$iv3 = count$iv$iv;
                        theNode$iv$iv = i21;
                        count$iv$iv2.add(node2);
                        if (count$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = 0;
                        count$iv$iv2.add(i21);
                        i11 = i22;
                        $i$f$mutableVectorOf = 16;
                        i4 = 0;
                        count$iv$iv = count$iv$iv3;
                        i13 = node$iv$iv3;
                        i16 = $i$f$mutableVectorOf;
                        count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv3 = node2;
                        $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                        this_$iv$iv$iv = i8;
                        count$iv$iv3 = i8;
                        i14 = 0;
                        capacity$iv.add((FocusTargetNode)node$iv$iv3);
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                    mutableVector = $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1;
                    i6 = 0;
                    i8 = 1;
                    mutableVector = $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1;
                    if (node$iv$iv3 instanceof FocusTargetNode) {
                    } else {
                    }
                    i14 = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    if (count$iv$iv3 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i7);
                    $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1 = mutableVector;
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                    i8 = 1;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    i15 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i3 = 0;
                        i11 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                        i13 = node$iv$iv3;
                        $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                        i8 = 1;
                        count$iv$iv3++;
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                        if (count$iv$iv3 == i8) {
                        } else {
                        }
                        if (i7 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        i13 = node$iv$iv3;
                        count$iv$iv2 = i7;
                        i21 = i13;
                        if (i21 != 0) {
                        } else {
                        }
                        node$iv$iv3 = i13;
                        if (count$iv$iv2 != 0) {
                        } else {
                        }
                        theNode$iv$iv = i21;
                        $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                        i7 = count$iv$iv2;
                        count$iv$iv3 = count$iv$iv;
                        theNode$iv$iv = i21;
                        count$iv$iv2.add(node2);
                        if (count$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = 0;
                        count$iv$iv2.add(i21);
                        i11 = i22;
                        $i$f$mutableVectorOf = 16;
                        i4 = 0;
                        count$iv$iv = count$iv$iv3;
                        i13 = node$iv$iv3;
                        i16 = $i$f$mutableVectorOf;
                        count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv3 = node2;
                        $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                        this_$iv$iv$iv = i8;
                    }
                    i13 = node$iv$iv3;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    node$iv$iv3 = i13;
                    $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1 = mutableVector;
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                    node$iv$iv3 = i13;
                    i8 = 1;
                    node2 = node$iv$iv$iv;
                    i3 = 0;
                    i11 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                    i13 = node$iv$iv3;
                    $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                    i8 = 1;
                    count$iv$iv3++;
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                    if (count$iv$iv3 == i8) {
                    } else {
                    }
                    if (i7 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    i13 = node$iv$iv3;
                    count$iv$iv2 = i7;
                    i21 = i13;
                    if (i21 != 0) {
                    } else {
                    }
                    node$iv$iv3 = i13;
                    if (count$iv$iv2 != 0) {
                    } else {
                    }
                    theNode$iv$iv = i21;
                    $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                    i7 = count$iv$iv2;
                    count$iv$iv3 = count$iv$iv;
                    theNode$iv$iv = i21;
                    count$iv$iv2.add(node2);
                    if (count$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = 0;
                    count$iv$iv2.add(i21);
                    i11 = i22;
                    $i$f$mutableVectorOf = 16;
                    i4 = 0;
                    count$iv$iv = count$iv$iv3;
                    i13 = node$iv$iv3;
                    i16 = $i$f$mutableVectorOf;
                    count$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node2;
                    $this$searchChildren_4C6V_qg_u24lambda_u2422 = node2;
                    this_$iv$iv$iv = i8;
                    count$iv$iv3 = i8;
                    i14 = 0;
                    capacity$iv.add((FocusTargetNode)node$iv$iv3);
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = capacity$iv;
                    DelegatableNodeKt.access$addLayoutNodeChildren($i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1, node);
                }
                MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2425 = capacity$iv;
                MutableVector mutableVector13 = $i$a$ApplyOneDimensionalFocusSearchKt$searchChildren$children$1;
                MutableVector mutableVector3 = mutableVector12;
                mutableVector3.sortWith((Comparator)FocusableChildrenComparator.INSTANCE);
                if (FocusDirection.equals-impl0(i18, FocusDirection.Companion.getNext-dhqQ-8s())) {
                    mutableVector2 = mutableVector3;
                    i9 = 0;
                    itemFound$iv = 0;
                    int i27 = 0;
                    i10 = 1;
                    this_$iv$iv = new IntRange(0, size2--);
                    index$iv = this_$iv$iv.getLast();
                    if (this_$iv$iv.getFirst() <= index$iv) {
                    }
                    if (!FocusDirection.equals-impl0(i18, FocusDirection.Companion.getNext-dhqQ-8s()) && focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() && OneDimensionalFocusSearchKt.isRoot(focusTargetNode)) {
                        if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                            if (OneDimensionalFocusSearchKt.isRoot(focusTargetNode)) {
                            }
                            return (Boolean)function1.invoke(focusTargetNode).booleanValue();
                        }
                    }
                    return 0;
                } else {
                    if (!FocusDirection.equals-impl0(i18, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
                    } else {
                        mutableVector2 = mutableVector3;
                        i9 = 0;
                        itemFound$iv = 0;
                        int i28 = 0;
                        i10 = 1;
                        this_$iv$iv = new IntRange(0, size3--);
                        index$iv2 = this_$iv$iv.getFirst();
                        if (index$iv2 <= this_$iv$iv.getLast()) {
                        }
                    }
                }
                IllegalStateException illegalStateException = new IllegalStateException("This function should only be used for 1-D focus search".toString());
                throw illegalStateException;
            }
            MutableVector mutableVector14 = capacity$iv;
            int i40 = i24;
            int $this$searchChildren_4C6V_qg_u24lambda_u2424 = 0;
            IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
            throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
        }
        int i19 = 0;
        IllegalStateException $i$a$CheckOneDimensionalFocusSearchKt$searchChildren$1 = new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        throw $i$a$CheckOneDimensionalFocusSearchKt$searchChildren$1;
    }
}
