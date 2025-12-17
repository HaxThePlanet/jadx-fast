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
            int ordinal2;
            int ordinal3;
            int ordinal;
            int ordinal4;
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
        boolean andSearchChildren-4C6V_qg;
        boolean andSearchChildren-4C6V_qg2;
        int i;
        int[] $EnumSwitchMapping$0;
        andSearchChildren-4C6V_qg = 1;
        int i3 = 0;
        switch (pickChildForBackwardSearch) {
            case 1:
                pickChildForBackwardSearch = FocusTraversalKt.getActiveChild($this$backwardFocusSearch);
                andSearchChildren-4C6V_qg2 = "ActiveParent must have a focusedChild";
                NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException2;
                IllegalStateException illegalStateException2 = new IllegalStateException(andSearchChildren-4C6V_qg2.toString());
                throw illegalStateException2;
                andSearchChildren-4C6V_qg = OneDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg($this$backwardFocusSearch, pickChildForBackwardSearch, FocusDirection.Companion.getPrevious-dhqQ-8s(), onFound);
                andSearchChildren-4C6V_qg = i3;
                IllegalStateException illegalStateException = new IllegalStateException(andSearchChildren-4C6V_qg2.toString());
                throw illegalStateException;
            case 2:
                andSearchChildren-4C6V_qg = OneDimensionalFocusSearchKt.pickChildForBackwardSearch($this$backwardFocusSearch, onFound);
                break;
            case 3:
                pickChildForBackwardSearch = (Boolean)onFound.invoke($this$backwardFocusSearch).booleanValue();
                pickChildForBackwardSearch = i3;
                andSearchChildren-4C6V_qg = i3;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return andSearchChildren-4C6V_qg;
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
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int $this$nearestAncestor_u2d64DMado$iv5;
        int $this$nearestAncestor_u2d64DMado$iv4;
        int $this$nearestAncestor_u2d64DMado$iv3;
        int type$iv;
        int i8;
        int i10;
        int i2;
        int i14;
        int i4;
        Modifier.Node node$iv$iv$iv2;
        LayoutNode layout$iv$iv$iv;
        Modifier.Node node$iv$iv$iv3;
        Modifier.Node this_$iv$iv$iv$iv2;
        int i15;
        int i;
        Modifier.Node next$iv$iv$iv;
        Modifier.Node head$ui_release;
        Modifier.Node node4;
        int i6;
        Modifier.Node node2;
        int i3;
        int i9;
        int node$iv$iv$iv;
        Modifier.Node node3;
        int i12;
        Modifier.Node node$iv$iv$iv$iv;
        Modifier.Node node;
        int i5;
        int this_$iv$iv$iv$iv;
        int i16;
        int i13;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        int i7;
        int i11;
        $this$nearestAncestor_u2d64DMado$iv2 = $this$isRoot;
        int i17 = 0;
        type$iv = NodeKind.constructor-impl(1024);
        i8 = 0;
        final int i19 = 0;
        final int i20 = 0;
        final int i21 = type$iv;
        final DelegatableNode delegatableNode2 = delegatableNode;
        final int i22 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv$iv2 = delegatableNode2.getNode().getParent$ui_release();
            layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i21 == 0) {
                    break;
                }
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                $this$nearestAncestor_u2d64DMado$iv2 = layout$iv$iv$iv.getNodes$ui_release();
                if (layout$iv$iv$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != null) {
                } else {
                }
                node$iv$iv$iv3 = 0;
                node$iv$iv$iv2 = node$iv$iv$iv3;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv = i7;
                i8 = i11;
                $this$nearestAncestor_u2d64DMado$iv2 = layout$iv$iv$iv.getNodes$ui_release();
                if ($this$nearestAncestor_u2d64DMado$iv2 != null) {
                } else {
                }
                node$iv$iv$iv3 = $this$nearestAncestor_u2d64DMado$iv2.getTail$ui_release();
                while (node$iv$iv$iv2 != null) {
                    if (kindSet$ui_release &= i21 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    $this$nearestAncestor_u2d64DMado$iv4 = i;
                    i14 = 0;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getParent$ui_release();
                    i = $this$nearestAncestor_u2d64DMado$iv4;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv = i7;
                    i8 = i11;
                    i6 = 0;
                    i3 = 0;
                    i9 = 0;
                    int i23 = 0;
                    node$iv$iv$iv3 = node$iv$iv$iv;
                    while (node$iv$iv$iv3 != null) {
                        node3 = 0;
                        if (kindSet$ui_release2 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv$iv2 != 0 && node$iv$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        $this$nearestAncestor_u2d64DMado$iv5 = i;
                        i2 = 0;
                        node$iv$iv$iv3 = DelegatableNodeKt.access$pop(i9);
                        i = $this$nearestAncestor_u2d64DMado$iv5;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = i7;
                        i8 = i11;
                        if (node$iv$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        this_$iv$iv$iv$iv2 = 0;
                        i12 = 0;
                        node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv3.getDelegate$ui_release();
                        while (node$iv$iv$iv$iv != null) {
                            node = node$iv$iv$iv$iv;
                            i5 = 0;
                            i16 = 0;
                            if (kindSet$ui_release3 &= type$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv = 0;
                            if (this_$iv$iv$iv$iv != 0) {
                            } else {
                            }
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                            i7 = type$iv;
                            i11 = i8;
                            next$iv$iv$iv = node;
                            i10 = 0;
                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                            $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                            type$iv = i7;
                            i8 = i11;
                            i = 1;
                            if (this_$iv$iv$iv$iv2++ == i) {
                            } else {
                            }
                            if (i9 == 0) {
                            } else {
                            }
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                            i7 = type$iv;
                            i11 = i8;
                            i10 = 0;
                            $this$nearestAncestor_u2d64DMado$iv2 = i9;
                            type$iv = node$iv$iv$iv3;
                            if (type$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                            }
                            if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                            } else {
                            }
                            next$iv$iv$iv = node;
                            i9 = $this$nearestAncestor_u2d64DMado$iv2;
                            $this$nearestAncestor_u2d64DMado$iv2.add(node);
                            if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                            }
                            node$iv$iv$iv3 = 0;
                            $this$nearestAncestor_u2d64DMado$iv2.add(type$iv);
                            this_$iv$iv$iv$iv = 0;
                            i13 = 0;
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                            i7 = type$iv;
                            i11 = i8;
                            $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv$iv3 = node;
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                            i7 = type$iv;
                            i11 = i8;
                            next$iv$iv$iv = node;
                            i10 = 0;
                            this_$iv$iv$iv$iv = i;
                        }
                        i2 = 0;
                        $this$nearestAncestor_u2d64DMado$iv5 = 1;
                        if (this_$iv$iv$iv$iv2 == $this$nearestAncestor_u2d64DMado$iv5) {
                        } else {
                        }
                        i = $this$nearestAncestor_u2d64DMado$iv5;
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = i7;
                        i8 = i11;
                        node = node$iv$iv$iv$iv;
                        i5 = 0;
                        i16 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        next$iv$iv$iv = node;
                        i10 = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = i7;
                        i8 = i11;
                        i = 1;
                        if (this_$iv$iv$iv$iv2++ == i) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        i10 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2 = i9;
                        type$iv = node$iv$iv$iv3;
                        if (type$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node;
                        i9 = $this$nearestAncestor_u2d64DMado$iv2;
                        $this$nearestAncestor_u2d64DMado$iv2.add(node);
                        if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        }
                        node$iv$iv$iv3 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2.add(type$iv);
                        this_$iv$iv$iv$iv = 0;
                        i13 = 0;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv3 = node;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        next$iv$iv$iv = node;
                        i10 = 0;
                        this_$iv$iv$iv$iv = i;
                        this_$iv$iv$iv$iv2 = i;
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    $this$nearestAncestor_u2d64DMado$iv4 = i;
                    i14 = 0;
                    node3 = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv$iv2 != 0 && node$iv$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    $this$nearestAncestor_u2d64DMado$iv5 = i;
                    i2 = 0;
                    node$iv$iv$iv3 = DelegatableNodeKt.access$pop(i9);
                    i = $this$nearestAncestor_u2d64DMado$iv5;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv = i7;
                    i8 = i11;
                    if (node$iv$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    i12 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node = node$iv$iv$iv$iv;
                        i5 = 0;
                        i16 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        next$iv$iv$iv = node;
                        i10 = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = i7;
                        i8 = i11;
                        i = 1;
                        if (this_$iv$iv$iv$iv2++ == i) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        i10 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2 = i9;
                        type$iv = node$iv$iv$iv3;
                        if (type$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node;
                        i9 = $this$nearestAncestor_u2d64DMado$iv2;
                        $this$nearestAncestor_u2d64DMado$iv2.add(node);
                        if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        }
                        node$iv$iv$iv3 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2.add(type$iv);
                        this_$iv$iv$iv$iv = 0;
                        i13 = 0;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv3 = node;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        next$iv$iv$iv = node;
                        i10 = 0;
                        this_$iv$iv$iv$iv = i;
                    }
                    i2 = 0;
                    $this$nearestAncestor_u2d64DMado$iv5 = 1;
                    if (this_$iv$iv$iv$iv2 == $this$nearestAncestor_u2d64DMado$iv5) {
                    } else {
                    }
                    i = $this$nearestAncestor_u2d64DMado$iv5;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv = i7;
                    i8 = i11;
                    node = node$iv$iv$iv$iv;
                    i5 = 0;
                    i16 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    next$iv$iv$iv = node;
                    i10 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv = i7;
                    i8 = i11;
                    i = 1;
                    if (this_$iv$iv$iv$iv2++ == i) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    i10 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = i9;
                    type$iv = node$iv$iv$iv3;
                    if (type$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i9 = $this$nearestAncestor_u2d64DMado$iv2;
                    $this$nearestAncestor_u2d64DMado$iv2.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    node$iv$iv$iv3 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2.add(type$iv);
                    this_$iv$iv$iv$iv = 0;
                    i13 = 0;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv3 = node;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    next$iv$iv$iv = node;
                    i10 = 0;
                    this_$iv$iv$iv$iv = i;
                    this_$iv$iv$iv$iv2 = i;
                }
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                if (kindSet$ui_release &= i21 == 0) {
                    break;
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                $this$nearestAncestor_u2d64DMado$iv4 = i;
                i14 = 0;
                node$iv$iv$iv2 = node$iv$iv$iv2.getParent$ui_release();
                i = $this$nearestAncestor_u2d64DMado$iv4;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv = i7;
                i8 = i11;
                i6 = 0;
                i3 = 0;
                i9 = 0;
                i23 = 0;
                node$iv$iv$iv3 = node$iv$iv$iv;
                while (node$iv$iv$iv3 != null) {
                    node3 = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv$iv2 != 0 && node$iv$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    $this$nearestAncestor_u2d64DMado$iv5 = i;
                    i2 = 0;
                    node$iv$iv$iv3 = DelegatableNodeKt.access$pop(i9);
                    i = $this$nearestAncestor_u2d64DMado$iv5;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv = i7;
                    i8 = i11;
                    if (node$iv$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv$iv2 = 0;
                    i12 = 0;
                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv$iv != null) {
                        node = node$iv$iv$iv$iv;
                        i5 = 0;
                        i16 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv$iv = 0;
                        if (this_$iv$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        next$iv$iv$iv = node;
                        i10 = 0;
                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv = i7;
                        i8 = i11;
                        i = 1;
                        if (this_$iv$iv$iv$iv2++ == i) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        i10 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2 = i9;
                        type$iv = node$iv$iv$iv3;
                        if (type$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        }
                        if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv$iv = node;
                        i9 = $this$nearestAncestor_u2d64DMado$iv2;
                        $this$nearestAncestor_u2d64DMado$iv2.add(node);
                        if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                        }
                        node$iv$iv$iv3 = 0;
                        $this$nearestAncestor_u2d64DMado$iv2.add(type$iv);
                        this_$iv$iv$iv$iv = 0;
                        i13 = 0;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv$iv3 = node;
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                        i7 = type$iv;
                        i11 = i8;
                        next$iv$iv$iv = node;
                        i10 = 0;
                        this_$iv$iv$iv$iv = i;
                    }
                    i2 = 0;
                    $this$nearestAncestor_u2d64DMado$iv5 = 1;
                    if (this_$iv$iv$iv$iv2 == $this$nearestAncestor_u2d64DMado$iv5) {
                    } else {
                    }
                    i = $this$nearestAncestor_u2d64DMado$iv5;
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv = i7;
                    i8 = i11;
                    node = node$iv$iv$iv$iv;
                    i5 = 0;
                    i16 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    next$iv$iv$iv = node;
                    i10 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv = i7;
                    i8 = i11;
                    i = 1;
                    if (this_$iv$iv$iv$iv2++ == i) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    i10 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = i9;
                    type$iv = node$iv$iv$iv3;
                    if (type$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i9 = $this$nearestAncestor_u2d64DMado$iv2;
                    $this$nearestAncestor_u2d64DMado$iv2.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    node$iv$iv$iv3 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2.add(type$iv);
                    this_$iv$iv$iv$iv = 0;
                    i13 = 0;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv3 = node;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    next$iv$iv$iv = node;
                    i10 = 0;
                    this_$iv$iv$iv$iv = i;
                    this_$iv$iv$iv$iv2 = i;
                }
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                $this$nearestAncestor_u2d64DMado$iv4 = i;
                i14 = 0;
                node3 = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv$iv2 != 0 && node$iv$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                $this$nearestAncestor_u2d64DMado$iv5 = i;
                i2 = 0;
                node$iv$iv$iv3 = DelegatableNodeKt.access$pop(i9);
                i = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv = i7;
                i8 = i11;
                if (node$iv$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv$iv2 = 0;
                i12 = 0;
                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv$iv != null) {
                    node = node$iv$iv$iv$iv;
                    i5 = 0;
                    i16 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv$iv = 0;
                    if (this_$iv$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    next$iv$iv$iv = node;
                    i10 = 0;
                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv = i7;
                    i8 = i11;
                    i = 1;
                    if (this_$iv$iv$iv$iv2++ == i) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    i10 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2 = i9;
                    type$iv = node$iv$iv$iv3;
                    if (type$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv$iv = node;
                    i9 = $this$nearestAncestor_u2d64DMado$iv2;
                    $this$nearestAncestor_u2d64DMado$iv2.add(node);
                    if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                    }
                    node$iv$iv$iv3 = 0;
                    $this$nearestAncestor_u2d64DMado$iv2.add(type$iv);
                    this_$iv$iv$iv$iv = 0;
                    i13 = 0;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv$iv3 = node;
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                    i7 = type$iv;
                    i11 = i8;
                    next$iv$iv$iv = node;
                    i10 = 0;
                    this_$iv$iv$iv$iv = i;
                }
                i2 = 0;
                $this$nearestAncestor_u2d64DMado$iv5 = 1;
                if (this_$iv$iv$iv$iv2 == $this$nearestAncestor_u2d64DMado$iv5) {
                } else {
                }
                i = $this$nearestAncestor_u2d64DMado$iv5;
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv = i7;
                i8 = i11;
                node = node$iv$iv$iv$iv;
                i5 = 0;
                i16 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv$iv = 0;
                if (this_$iv$iv$iv$iv != 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                next$iv$iv$iv = node;
                i10 = 0;
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv;
                type$iv = i7;
                i8 = i11;
                i = 1;
                if (this_$iv$iv$iv$iv2++ == i) {
                } else {
                }
                if (i9 == 0) {
                } else {
                }
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                i10 = 0;
                $this$nearestAncestor_u2d64DMado$iv2 = i9;
                type$iv = node$iv$iv$iv3;
                if (type$iv != null && $this$nearestAncestor_u2d64DMado$iv2 != 0) {
                }
                if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                } else {
                }
                next$iv$iv$iv = node;
                i9 = $this$nearestAncestor_u2d64DMado$iv2;
                $this$nearestAncestor_u2d64DMado$iv2.add(node);
                if ($this$nearestAncestor_u2d64DMado$iv2 != 0) {
                }
                node$iv$iv$iv3 = 0;
                $this$nearestAncestor_u2d64DMado$iv2.add(type$iv);
                this_$iv$iv$iv$iv = 0;
                i13 = 0;
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                $this$nearestAncestor_u2d64DMado$iv2 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv$iv3 = node;
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
                i7 = type$iv;
                i11 = i8;
                next$iv$iv$iv = node;
                i10 = 0;
                this_$iv$iv$iv$iv = i;
                this_$iv$iv$iv$iv2 = i;
            }
            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv2;
            i7 = type$iv;
            i11 = i8;
            $this$nearestAncestor_u2d64DMado$iv3 = i;
            i4 = 0;
            node$iv$iv$iv3 = 0;
            i15 = node$iv$iv$iv3 == null ? $this$nearestAncestor_u2d64DMado$iv3 : i4;
            return i15;
        }
        DelegatableNode delegatableNode3 = $this$nearestAncestor_u2d64DMado$iv2;
        int i24 = type$iv;
        int $this$nearestAncestor_u2d64DMado$iv6 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw illegalStateException;
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
        int mutableVector;
        MutableVector mutableVector3;
        Modifier.Node next$iv$iv;
        int i$iv;
        Object node$iv$iv3;
        int constructor-impl;
        int i9;
        int i12;
        boolean eligibleForFocusSearch;
        Object child$ui_release;
        int node;
        int count$iv$iv;
        int count$iv$iv2;
        Modifier.Node[] node$iv$iv;
        int i2;
        int i7;
        Object obj;
        int i11;
        int i3;
        Object node$iv$iv2;
        int i6;
        Object obj2;
        int i10;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i8;
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u249;
        int this_$iv$iv$iv;
        int i;
        int i13;
        int i5;
        MutableVector mutableVector2;
        int i4;
        int i16 = 0;
        i$iv = 0;
        mutableVector3 = new MutableVector(new FocusTargetNode[16], i$iv);
        int i18 = 0;
        constructor-impl = NodeKind.constructor-impl(1024);
        i9 = 0;
        i12 = constructor-impl;
        eligibleForFocusSearch = z;
        final int i20 = 0;
        if (!eligibleForFocusSearch.getNode().isAttached()) {
        } else {
            int i21 = 0;
            count$iv$iv = 0;
            MutableVector mutableVector7 = new MutableVector(new Modifier.Node[16], i$iv);
            child$ui_release = eligibleForFocusSearch.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector7, eligibleForFocusSearch.getNode());
            } else {
                mutableVector7.add(child$ui_release);
            }
            while (mutableVector7.isNotEmpty()) {
                int i22 = 0;
                node = mutableVector7.removeAt(size2 -= count$iv$iv);
                if (aggregateChildKindSet$ui_release &= i12 == 0) {
                } else {
                }
                node$iv$iv = node;
                while (node$iv$iv != null) {
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    i$iv = 0;
                    count$iv$iv = 1;
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                i$iv = 0;
                if (kindSet$ui_release &= i12 != 0) {
                } else {
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                i$iv = 0;
                count$iv$iv = 1;
                i7 = 0;
                i11 = 0;
                i3 = 0;
                int i23 = 0;
                node$iv$iv3 = node$iv$iv2;
                while (node$iv$iv3 != null) {
                    if (node$iv$iv3 instanceof FocusTargetNode) {
                    } else {
                    }
                    obj2 = 0;
                    if (kindSet$ui_release2 &= constructor-impl != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                    capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                    mutableVector = i5;
                    mutableVector3 = mutableVector2;
                    count$iv$iv = 1;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    i10 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i8 = 0;
                        i = 0;
                        if (kindSet$ui_release3 &= constructor-impl != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                        i5 = mutableVector;
                        mutableVector2 = mutableVector3;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                        mutableVector = i5;
                        mutableVector3 = mutableVector2;
                        $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                        if (count$iv$iv2++ == 1) {
                        } else {
                        }
                        if (i3 == 0) {
                        } else {
                        }
                        i5 = mutableVector;
                        mutableVector2 = mutableVector3;
                        mutableVector = i3;
                        capacity$iv = node$iv$iv3;
                        if (capacity$iv != null && mutableVector != 0) {
                        }
                        if (mutableVector != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i3 = mutableVector;
                        mutableVector.add(node2);
                        if (mutableVector != 0) {
                        }
                        node$iv$iv3 = mutableVector3;
                        mutableVector.add(capacity$iv);
                        i = i15;
                        int $i$f$mutableVectorOf = 16;
                        i13 = 0;
                        i5 = mutableVector;
                        mutableVector2 = mutableVector3;
                        i4 = $i$f$mutableVectorOf;
                        mutableVector = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv3 = node2;
                        i5 = mutableVector;
                        mutableVector2 = mutableVector3;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv2 == 1) {
                    } else {
                    }
                    capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                    mutableVector = i5;
                    mutableVector3 = mutableVector2;
                    count$iv$iv = 1;
                    node2 = node$iv$iv$iv;
                    i8 = 0;
                    i = 0;
                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                    mutableVector = i5;
                    mutableVector3 = mutableVector2;
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    mutableVector = i3;
                    capacity$iv = node$iv$iv3;
                    if (capacity$iv != null && mutableVector != 0) {
                    }
                    if (mutableVector != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i3 = mutableVector;
                    mutableVector.add(node2);
                    if (mutableVector != 0) {
                    }
                    node$iv$iv3 = mutableVector3;
                    mutableVector.add(capacity$iv);
                    i = i15;
                    $i$f$mutableVectorOf = 16;
                    i13 = 0;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    i4 = $i$f$mutableVectorOf;
                    mutableVector = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node2;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv2 = 1;
                    obj2 = 0;
                    capacity$iv.add((FocusTargetNode)node$iv$iv3);
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                i$iv = 0;
                if (node$iv$iv3 instanceof FocusTargetNode) {
                } else {
                }
                obj2 = 0;
                if (kindSet$ui_release2 &= constructor-impl != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i3);
                capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                mutableVector = i5;
                mutableVector3 = mutableVector2;
                count$iv$iv = 1;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                i10 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i8 = 0;
                    i = 0;
                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                    mutableVector = i5;
                    mutableVector3 = mutableVector2;
                    $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (i3 == 0) {
                    } else {
                    }
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    mutableVector = i3;
                    capacity$iv = node$iv$iv3;
                    if (capacity$iv != null && mutableVector != 0) {
                    }
                    if (mutableVector != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i3 = mutableVector;
                    mutableVector.add(node2);
                    if (mutableVector != 0) {
                    }
                    node$iv$iv3 = mutableVector3;
                    mutableVector.add(capacity$iv);
                    i = i15;
                    $i$f$mutableVectorOf = 16;
                    i13 = 0;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    i4 = $i$f$mutableVectorOf;
                    mutableVector = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node2;
                    i5 = mutableVector;
                    mutableVector2 = mutableVector3;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv2 == 1) {
                } else {
                }
                capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                mutableVector = i5;
                mutableVector3 = mutableVector2;
                count$iv$iv = 1;
                node2 = node$iv$iv$iv;
                i8 = 0;
                i = 0;
                if (kindSet$ui_release3 &= constructor-impl != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                next$iv$iv = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                capacity$iv = $this$pickChildForBackwardSearch_u24lambda_u249;
                mutableVector = i5;
                mutableVector3 = mutableVector2;
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                if (count$iv$iv2++ == 1) {
                } else {
                }
                if (i3 == 0) {
                } else {
                }
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                mutableVector = i3;
                capacity$iv = node$iv$iv3;
                if (capacity$iv != null && mutableVector != 0) {
                }
                if (mutableVector != 0) {
                } else {
                }
                next$iv$iv = node2;
                i3 = mutableVector;
                mutableVector.add(node2);
                if (mutableVector != 0) {
                }
                node$iv$iv3 = mutableVector3;
                mutableVector.add(capacity$iv);
                i = i15;
                $i$f$mutableVectorOf = 16;
                i13 = 0;
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                i4 = $i$f$mutableVectorOf;
                mutableVector = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = node2;
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                next$iv$iv = node2;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                obj2 = 0;
                capacity$iv.add((FocusTargetNode)node$iv$iv3);
                $this$pickChildForBackwardSearch_u24lambda_u249 = capacity$iv;
                i5 = mutableVector;
                mutableVector2 = mutableVector3;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector7, node);
            }
            MutableVector $this$pickChildForBackwardSearch_u24lambda_u2493 = capacity$iv;
            int i26 = mutableVector;
            MutableVector mutableVector4 = mutableVector9;
            mutableVector4.sortWith((Comparator)FocusableChildrenComparator.INSTANCE);
            MutableVector mutableVector5 = mutableVector4;
            int i17 = 0;
            int size = mutableVector5.getSize();
            if (size > 0) {
                i$iv = size + -1;
                i9 = mutableVector5.getContent()[i$iv];
                i12 = 0;
                while (FocusTraversalKt.isEligibleForFocusSearch((FocusTargetNode)i9)) {
                    i6 = 1;
                    i9 = constructor-impl[i$iv];
                    i12 = 0;
                    child$ui_release = onFound;
                }
                return 1;
            }
            child$ui_release = onFound;
            return 0;
        }
        MutableVector mutableVector8 = capacity$iv;
        int i27 = mutableVector;
        int $this$pickChildForBackwardSearch_u24lambda_u2492 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw illegalStateException;
    }

    private static final boolean pickChildForForwardSearch(androidx.compose.ui.focus.FocusTargetNode $this$pickChildForForwardSearch, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        MutableVector capacity$iv;
        int $this$pickChildForForwardSearch_u24lambda_u246;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        int mutableVector;
        MutableVector mutableVector2;
        int i7;
        Object node$iv$iv3;
        int size$iv;
        int i$iv;
        Object[] content;
        int it;
        int i2;
        int eligibleForFocusSearch;
        Modifier.Node child$ui_release;
        int node;
        int count$iv$iv;
        int count$iv$iv2;
        Modifier.Node[] node$iv$iv2;
        int i11;
        int i;
        Object obj2;
        int i4;
        int i10;
        Object node$iv$iv;
        Object obj;
        int i8;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i12;
        MutableVector $this$pickChildForForwardSearch_u24lambda_u2462;
        int this_$iv$iv$iv;
        int i5;
        int i6;
        int i9;
        MutableVector mutableVector3;
        int i3;
        int i15 = 0;
        i7 = 0;
        mutableVector2 = new MutableVector(new FocusTargetNode[16], i7);
        int i18 = 0;
        i$iv = NodeKind.constructor-impl(1024);
        content = 0;
        it = i$iv;
        i2 = i16;
        eligibleForFocusSearch = 0;
        if (!i2.getNode().isAttached()) {
        } else {
            int i20 = 0;
            count$iv$iv = 0;
            MutableVector mutableVector7 = new MutableVector(new Modifier.Node[16], i7);
            child$ui_release = i2.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector7, i2.getNode());
            } else {
                mutableVector7.add(child$ui_release);
            }
            count$iv$iv = 1;
            while (mutableVector7.isNotEmpty()) {
                int i21 = 0;
                node = mutableVector7.removeAt(size2 -= count$iv$iv);
                if (aggregateChildKindSet$ui_release &= it == 0) {
                } else {
                }
                node$iv$iv2 = node;
                while (node$iv$iv2 != null) {
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    int $this$pickChildForForwardSearch_u24lambda_u2465 = count$iv$iv;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                    i7 = 0;
                }
                $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                i7 = 0;
                count$iv$iv = 1;
                if (kindSet$ui_release &= it != 0) {
                } else {
                }
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                $this$pickChildForForwardSearch_u24lambda_u2465 = count$iv$iv;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                i7 = 0;
                i = 0;
                i4 = 0;
                i10 = 0;
                int i22 = 0;
                node$iv$iv3 = node$iv$iv;
                while (node$iv$iv3 != null) {
                    if (node$iv$iv3 instanceof FocusTargetNode) {
                    } else {
                    }
                    obj = 0;
                    if (kindSet$ui_release2 &= i$iv != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    $this$pickChildForForwardSearch_u24lambda_u246 = 1;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i10);
                    count$iv$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                    mutableVector = i9;
                    mutableVector2 = mutableVector3;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    i8 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i12 = 0;
                        i5 = 0;
                        if (kindSet$ui_release3 &= i$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                        i9 = mutableVector;
                        mutableVector3 = mutableVector2;
                        next$iv$iv = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                        mutableVector = i9;
                        mutableVector2 = mutableVector3;
                        $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                        if (count$iv$iv2++ == 1) {
                        } else {
                        }
                        if (i10 == 0) {
                        } else {
                        }
                        i9 = mutableVector;
                        mutableVector3 = mutableVector2;
                        capacity$iv$iv$iv$iv = 0;
                        mutableVector = i10;
                        mutableVector2 = node$iv$iv3;
                        if (mutableVector2 != null && mutableVector != 0) {
                        }
                        if (mutableVector != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i10 = mutableVector;
                        mutableVector.add(node2);
                        if (mutableVector != 0) {
                        }
                        node$iv$iv3 = 0;
                        mutableVector.add(mutableVector2);
                        i5 = i14;
                        int $i$f$mutableVectorOf = 16;
                        i6 = 0;
                        i9 = mutableVector;
                        mutableVector3 = mutableVector2;
                        i3 = $i$f$mutableVectorOf;
                        mutableVector = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv3 = node2;
                        i9 = mutableVector;
                        mutableVector3 = mutableVector2;
                        next$iv$iv = node2;
                        this_$iv$iv$iv = 1;
                    }
                    $this$pickChildForForwardSearch_u24lambda_u246 = 1;
                    if (count$iv$iv2 == $this$pickChildForForwardSearch_u24lambda_u246) {
                    } else {
                    }
                    count$iv$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                    mutableVector = i9;
                    mutableVector2 = mutableVector3;
                    node2 = node$iv$iv$iv;
                    i12 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= i$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                    mutableVector = i9;
                    mutableVector2 = mutableVector3;
                    $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    capacity$iv$iv$iv$iv = 0;
                    mutableVector = i10;
                    mutableVector2 = node$iv$iv3;
                    if (mutableVector2 != null && mutableVector != 0) {
                    }
                    if (mutableVector != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i10 = mutableVector;
                    mutableVector.add(node2);
                    if (mutableVector != 0) {
                    }
                    node$iv$iv3 = 0;
                    mutableVector.add(mutableVector2);
                    i5 = i14;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    i3 = $i$f$mutableVectorOf;
                    mutableVector = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node2;
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                    count$iv$iv2 = 1;
                    obj = 0;
                    capacity$iv.add((FocusTargetNode)node$iv$iv3);
                    $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    $this$pickChildForForwardSearch_u24lambda_u246 = 1;
                }
                $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                i7 = 0;
                if (node$iv$iv3 instanceof FocusTargetNode) {
                } else {
                }
                obj = 0;
                if (kindSet$ui_release2 &= i$iv != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                $this$pickChildForForwardSearch_u24lambda_u246 = 1;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i10);
                count$iv$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                mutableVector = i9;
                mutableVector2 = mutableVector3;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                i8 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i12 = 0;
                    i5 = 0;
                    if (kindSet$ui_release3 &= i$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    next$iv$iv = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                    mutableVector = i9;
                    mutableVector2 = mutableVector3;
                    $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                    if (count$iv$iv2++ == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    capacity$iv$iv$iv$iv = 0;
                    mutableVector = i10;
                    mutableVector2 = node$iv$iv3;
                    if (mutableVector2 != null && mutableVector != 0) {
                    }
                    if (mutableVector != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i10 = mutableVector;
                    mutableVector.add(node2);
                    if (mutableVector != 0) {
                    }
                    node$iv$iv3 = 0;
                    mutableVector.add(mutableVector2);
                    i5 = i14;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    i3 = $i$f$mutableVectorOf;
                    mutableVector = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node2;
                    i9 = mutableVector;
                    mutableVector3 = mutableVector2;
                    next$iv$iv = node2;
                    this_$iv$iv$iv = 1;
                }
                $this$pickChildForForwardSearch_u24lambda_u246 = 1;
                if (count$iv$iv2 == $this$pickChildForForwardSearch_u24lambda_u246) {
                } else {
                }
                count$iv$iv = $this$pickChildForForwardSearch_u24lambda_u246;
                capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                mutableVector = i9;
                mutableVector2 = mutableVector3;
                node2 = node$iv$iv$iv;
                i12 = 0;
                i5 = 0;
                if (kindSet$ui_release3 &= i$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                next$iv$iv = node2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                capacity$iv = $this$pickChildForForwardSearch_u24lambda_u2462;
                mutableVector = i9;
                mutableVector2 = mutableVector3;
                $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                if (count$iv$iv2++ == 1) {
                } else {
                }
                if (i10 == 0) {
                } else {
                }
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                capacity$iv$iv$iv$iv = 0;
                mutableVector = i10;
                mutableVector2 = node$iv$iv3;
                if (mutableVector2 != null && mutableVector != 0) {
                }
                if (mutableVector != 0) {
                } else {
                }
                next$iv$iv = node2;
                i10 = mutableVector;
                mutableVector.add(node2);
                if (mutableVector != 0) {
                }
                node$iv$iv3 = 0;
                mutableVector.add(mutableVector2);
                i5 = i14;
                $i$f$mutableVectorOf = 16;
                i6 = 0;
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                i3 = $i$f$mutableVectorOf;
                mutableVector = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = node2;
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                next$iv$iv = node2;
                this_$iv$iv$iv = 1;
                count$iv$iv2 = 1;
                obj = 0;
                capacity$iv.add((FocusTargetNode)node$iv$iv3);
                $this$pickChildForForwardSearch_u24lambda_u2462 = capacity$iv;
                i9 = mutableVector;
                mutableVector3 = mutableVector2;
                $this$pickChildForForwardSearch_u24lambda_u246 = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector7, node);
            }
            MutableVector $this$pickChildForForwardSearch_u24lambda_u2467 = capacity$iv;
            int i24 = mutableVector;
            int $this$pickChildForForwardSearch_u24lambda_u2466 = count$iv$iv;
            MutableVector mutableVector4 = mutableVector9;
            mutableVector4.sortWith((Comparator)FocusableChildrenComparator.INSTANCE);
            MutableVector mutableVector5 = mutableVector4;
            int i17 = 0;
            int size = mutableVector5.getSize();
            if (size > 0) {
                i$iv = 0;
                Object obj3 = mutableVector5.getContent()[i$iv];
                i2 = 0;
                while (FocusTraversalKt.isEligibleForFocusSearch((FocusTargetNode)obj3)) {
                    if (OneDimensionalFocusSearchKt.forwardFocusSearch(obj3, onFound)) {
                    } else {
                    }
                    it = 0;
                    obj3 = content[i$iv];
                    i2 = 0;
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
        MutableVector mutableVector8 = capacity$iv;
        int i23 = mutableVector;
        int $this$pickChildForForwardSearch_u24lambda_u2463 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw illegalStateException;
    }

    private static final boolean searchChildren-4C6V_qg(androidx.compose.ui.focus.FocusTargetNode $this$searchChildren_u2d4C6V_qg, androidx.compose.ui.focus.FocusTargetNode focusedItem, int direction, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        int i2;
        MutableVector capacity$iv;
        Modifier.Node $this$searchChildren_4C6V_qg_u24lambda_u2423;
        int $this$searchChildren_4C6V_qg_u24lambda_u2422;
        MutableVector count$iv$iv;
        int count$iv$iv3;
        int count$iv$iv4;
        MutableVector mutableVector;
        boolean canFocus;
        int i;
        int node$iv$iv;
        int i14;
        int itemFound$iv;
        Modifier.Node node;
        int index$iv2;
        int index$iv;
        IntRange this_$iv$iv;
        int i11;
        int eligibleForFocusSearch;
        int node$iv$iv3;
        int i13;
        int i16;
        int size;
        int i4;
        int i5;
        int i3;
        int i15;
        int theNode$iv$iv;
        int node$iv$iv2;
        MutableVector mutableVector2;
        int i7;
        int i8;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i17;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u242;
        int this_$iv$iv$iv;
        int i12;
        int i9;
        int count$iv$iv2;
        int i6;
        int i10;
        final androidx.compose.ui.focus.FocusTargetNode focusTargetNode = $this$searchChildren_u2d4C6V_qg;
        final Object obj = focusedItem;
        final int i18 = direction;
        final Function1 function1 = onFound;
        i = 0;
        i2 = focusTargetNode.getFocusState() == FocusStateImpl.ActiveParent ? 1 : i;
        if (i2 == 0) {
        } else {
            int i23 = 0;
            MutableVector mutableVector4 = new MutableVector(new FocusTargetNode[16], i);
            int i24 = 0;
            int i29 = 0;
            int constructor-impl = NodeKind.constructor-impl(1024);
            int i31 = 0;
            int i34 = constructor-impl;
            final androidx.compose.ui.focus.FocusTargetNode focusTargetNode3 = focusTargetNode2;
            final int i35 = 0;
            if (!focusTargetNode3.getNode().isAttached()) {
            } else {
                node$iv$iv3 = 0;
                i13 = 1;
                size = 0;
                int i39 = i24;
                count$iv$iv = new MutableVector(new Modifier.Node[16], i);
                Modifier.Node child$ui_release = focusTargetNode3.getNode().getChild$ui_release();
                if (child$ui_release == null) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv, focusTargetNode3.getNode());
                } else {
                    count$iv$iv.add(child$ui_release);
                }
                while (count$iv$iv.isNotEmpty()) {
                    int i36 = 0;
                    node = count$iv$iv.removeAt(size + -1);
                    if (aggregateChildKindSet$ui_release &= i34 == 0) {
                    } else {
                    }
                    node$iv$iv3 = node;
                    while (node$iv$iv3 != 0) {
                        $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                        mutableVector2 = count$iv$iv;
                        node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                        i = 0;
                        i13 = 1;
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                    mutableVector2 = count$iv$iv;
                    i = 0;
                    i13 = 1;
                    if (kindSet$ui_release &= i34 != 0) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                    mutableVector2 = count$iv$iv;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    i = 0;
                    i13 = 1;
                    i4 = 0;
                    i3 = 0;
                    i15 = 0;
                    int i41 = 0;
                    node$iv$iv = node$iv$iv2;
                    while (node$iv$iv != 0) {
                        mutableVector2 = count$iv$iv;
                        if (node$iv$iv instanceof FocusTargetNode) {
                        } else {
                        }
                        i7 = 0;
                        if (kindSet$ui_release2 &= constructor-impl != 0) {
                        } else {
                        }
                        count$iv$iv3 = 0;
                        if (count$iv$iv3 != 0 && node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                        node$iv$iv = DelegatableNodeKt.access$pop(i15);
                        count$iv$iv = mutableVector2;
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u242;
                        i13 = 1;
                        if (node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv3 = 0;
                        i8 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i17 = 0;
                            i12 = 0;
                            if (kindSet$ui_release3 &= constructor-impl != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                            i6 = node$iv$iv;
                            $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u242;
                            i13 = 1;
                            count$iv$iv3++;
                            $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                            if (count$iv$iv3 == i13) {
                            } else {
                            }
                            if (i15 == 0) {
                            } else {
                            }
                            count$iv$iv2 = count$iv$iv3;
                            i6 = node$iv$iv;
                            count$iv$iv4 = i15;
                            int i21 = i6;
                            if (i21 != 0) {
                            } else {
                            }
                            node$iv$iv = i6;
                            if (count$iv$iv4 != 0) {
                            } else {
                            }
                            theNode$iv$iv = i21;
                            $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                            i15 = count$iv$iv4;
                            count$iv$iv3 = count$iv$iv2;
                            theNode$iv$iv = i21;
                            count$iv$iv4.add(node2);
                            if (count$iv$iv4 != 0) {
                            }
                            node$iv$iv = 0;
                            count$iv$iv4.add(i21);
                            i12 = i22;
                            int $i$f$mutableVectorOf = 16;
                            i9 = 0;
                            count$iv$iv2 = count$iv$iv3;
                            i6 = node$iv$iv;
                            i10 = $i$f$mutableVectorOf;
                            count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            node$iv$iv = node2;
                            $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                            this_$iv$iv$iv = i13;
                        }
                        i6 = node$iv$iv;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        node$iv$iv = i6;
                        count$iv$iv = mutableVector2;
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u242;
                        node$iv$iv = i6;
                        i13 = 1;
                        node2 = node$iv$iv$iv;
                        i17 = 0;
                        i12 = 0;
                        if (kindSet$ui_release3 &= constructor-impl != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                        i6 = node$iv$iv;
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u242;
                        i13 = 1;
                        count$iv$iv3++;
                        $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                        if (count$iv$iv3 == i13) {
                        } else {
                        }
                        if (i15 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv3;
                        i6 = node$iv$iv;
                        count$iv$iv4 = i15;
                        i21 = i6;
                        if (i21 != 0) {
                        } else {
                        }
                        node$iv$iv = i6;
                        if (count$iv$iv4 != 0) {
                        } else {
                        }
                        theNode$iv$iv = i21;
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                        i15 = count$iv$iv4;
                        count$iv$iv3 = count$iv$iv2;
                        theNode$iv$iv = i21;
                        count$iv$iv4.add(node2);
                        if (count$iv$iv4 != 0) {
                        }
                        node$iv$iv = 0;
                        count$iv$iv4.add(i21);
                        i12 = i22;
                        $i$f$mutableVectorOf = 16;
                        i9 = 0;
                        count$iv$iv2 = count$iv$iv3;
                        i6 = node$iv$iv;
                        i10 = $i$f$mutableVectorOf;
                        count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = node2;
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                        this_$iv$iv$iv = i13;
                        count$iv$iv3 = i13;
                        i7 = 0;
                        capacity$iv.add((FocusTargetNode)node$iv$iv);
                        $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                    mutableVector2 = count$iv$iv;
                    i = 0;
                    i13 = 1;
                    mutableVector2 = count$iv$iv;
                    if (node$iv$iv instanceof FocusTargetNode) {
                    } else {
                    }
                    i7 = 0;
                    if (kindSet$ui_release2 &= constructor-impl != 0) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    if (count$iv$iv3 != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                    node$iv$iv = DelegatableNodeKt.access$pop(i15);
                    count$iv$iv = mutableVector2;
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u242;
                    i13 = 1;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    i8 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i17 = 0;
                        i12 = 0;
                        if (kindSet$ui_release3 &= constructor-impl != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                        i6 = node$iv$iv;
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u242;
                        i13 = 1;
                        count$iv$iv3++;
                        $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                        if (count$iv$iv3 == i13) {
                        } else {
                        }
                        if (i15 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv3;
                        i6 = node$iv$iv;
                        count$iv$iv4 = i15;
                        i21 = i6;
                        if (i21 != 0) {
                        } else {
                        }
                        node$iv$iv = i6;
                        if (count$iv$iv4 != 0) {
                        } else {
                        }
                        theNode$iv$iv = i21;
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                        i15 = count$iv$iv4;
                        count$iv$iv3 = count$iv$iv2;
                        theNode$iv$iv = i21;
                        count$iv$iv4.add(node2);
                        if (count$iv$iv4 != 0) {
                        }
                        node$iv$iv = 0;
                        count$iv$iv4.add(i21);
                        i12 = i22;
                        $i$f$mutableVectorOf = 16;
                        i9 = 0;
                        count$iv$iv2 = count$iv$iv3;
                        i6 = node$iv$iv;
                        i10 = $i$f$mutableVectorOf;
                        count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = node2;
                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                        this_$iv$iv$iv = i13;
                    }
                    i6 = node$iv$iv;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    node$iv$iv = i6;
                    count$iv$iv = mutableVector2;
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u242;
                    node$iv$iv = i6;
                    i13 = 1;
                    node2 = node$iv$iv$iv;
                    i17 = 0;
                    i12 = 0;
                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                    i6 = node$iv$iv;
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u242;
                    i13 = 1;
                    count$iv$iv3++;
                    $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                    if (count$iv$iv3 == i13) {
                    } else {
                    }
                    if (i15 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv3;
                    i6 = node$iv$iv;
                    count$iv$iv4 = i15;
                    i21 = i6;
                    if (i21 != 0) {
                    } else {
                    }
                    node$iv$iv = i6;
                    if (count$iv$iv4 != 0) {
                    } else {
                    }
                    theNode$iv$iv = i21;
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                    i15 = count$iv$iv4;
                    count$iv$iv3 = count$iv$iv2;
                    theNode$iv$iv = i21;
                    count$iv$iv4.add(node2);
                    if (count$iv$iv4 != 0) {
                    }
                    node$iv$iv = 0;
                    count$iv$iv4.add(i21);
                    i12 = i22;
                    $i$f$mutableVectorOf = 16;
                    i9 = 0;
                    count$iv$iv2 = count$iv$iv3;
                    i6 = node$iv$iv;
                    i10 = $i$f$mutableVectorOf;
                    count$iv$iv4 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node2;
                    $this$searchChildren_4C6V_qg_u24lambda_u2423 = node2;
                    this_$iv$iv$iv = i13;
                    count$iv$iv3 = i13;
                    i7 = 0;
                    capacity$iv.add((FocusTargetNode)node$iv$iv);
                    $this$searchChildren_4C6V_qg_u24lambda_u242 = capacity$iv;
                    DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv, node);
                }
                MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2425 = capacity$iv;
                MutableVector mutableVector13 = count$iv$iv;
                MutableVector mutableVector3 = mutableVector12;
                mutableVector3.sortWith((Comparator)FocusableChildrenComparator.INSTANCE);
                if (FocusDirection.equals-impl0(i18, FocusDirection.Companion.getNext-dhqQ-8s())) {
                    mutableVector = mutableVector3;
                    i14 = 0;
                    itemFound$iv = 0;
                    int i27 = 0;
                    i16 = 1;
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
                        mutableVector = mutableVector3;
                        i14 = 0;
                        itemFound$iv = 0;
                        int i28 = 0;
                        i16 = 1;
                        this_$iv$iv = new IntRange(0, size3--);
                        index$iv2 = this_$iv$iv.getFirst();
                        if (index$iv2 <= this_$iv$iv.getLast()) {
                        }
                    }
                }
                IllegalStateException illegalStateException3 = new IllegalStateException("This function should only be used for 1-D focus search".toString());
                throw illegalStateException3;
            }
            MutableVector mutableVector14 = capacity$iv;
            int i40 = i24;
            int $this$searchChildren_4C6V_qg_u24lambda_u2424 = 0;
            IllegalStateException illegalStateException2 = new IllegalStateException("visitChildren called on an unattached node".toString());
            throw illegalStateException2;
        }
        int i19 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        throw illegalStateException;
    }
}
