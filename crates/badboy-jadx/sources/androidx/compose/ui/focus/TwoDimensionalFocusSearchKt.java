package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u001a2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a2\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u000c\u001a\u000c\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0002\u001a\u000c\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0019H\u0002\u001a.\u0010\u001a\u001a\u0004\u0018\u00010\u0013*\u0008\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a2\u0010\u001e\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0000ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\u001a:\u0010#\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0002ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001a:\u0010'\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0002ø\u0001\u0000¢\u0006\u0004\u0008(\u0010&\u001a\u000c\u0010)\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a>\u0010*\u001a\u0004\u0018\u00010\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0008\u0010+\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0000ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006.", d2 = {"InvalidFocusDirection", "", "NoActiveChild", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "bottomRight", "collectAccessibleChildren", "", "Landroidx/compose/ui/node/DelegatableNode;", "accessibleChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findBestCandidate", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetNode;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/geometry/Rect;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "previouslyFocusedRect", "twoDimensionalFocusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TwoDimensionalFocusSearchKt {

    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
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
            TwoDimensionalFocusSearchKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final boolean access$searchChildren-4C6V_qg(androidx.compose.ui.focus.FocusTargetNode $receiver, Rect focusedItem, int direction, Function1 onFound) {
        return TwoDimensionalFocusSearchKt.searchChildren-4C6V_qg($receiver, focusedItem, direction, onFound);
    }

    private static final androidx.compose.ui.focus.FocusTargetNode activeNode(androidx.compose.ui.focus.FocusTargetNode $this$activeNode) {
        int i;
        i = $this$activeNode.getFocusState() == FocusStateImpl.ActiveParent ? 1 : 0;
        if (i == 0) {
        } else {
            androidx.compose.ui.focus.FocusTargetNode activeFocusNode = FocusTraversalKt.findActiveFocusNode($this$activeNode);
            if (activeFocusNode == null) {
            } else {
                return activeFocusNode;
            }
            IllegalStateException illegalStateException = new IllegalStateException("ActiveParent must have a focusedChild".toString());
            throw illegalStateException;
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckTwoDimensionalFocusSearchKt$activeNode$1 = new IllegalStateException("Searching for active node in inactive hierarchy".toString());
        throw $i$a$CheckTwoDimensionalFocusSearchKt$activeNode$1;
    }

    private static final boolean beamBeats-I7lrPNg(Rect source, Rect rect1, Rect rect2, int direction) {
        boolean beamBeats_I7lrPNg$inSourceBeam;
        int i2;
        int i;
        float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge;
        i2 = 0;
        if (!TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$inSourceBeam(rect2, direction, source)) {
            if (!TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$inSourceBeam(rect1, direction, source)) {
            } else {
                i = 1;
                if (!TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$isInDirectionOfSearch(rect2, direction, source)) {
                    i2 = i;
                } else {
                    if (!FocusDirection.equals-impl0(direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
                        if (FocusDirection.equals-impl0(direction, FocusDirection.Companion.getRight-dhqQ-8s())) {
                            i2 = i;
                        } else {
                            if (Float.compare(beamBeats_I7lrPNg$majorAxisDistance$6, beamBeats_I7lrPNg$majorAxisDistanceToFarEdge) < 0) {
                                i2 = i;
                            }
                        }
                    } else {
                    }
                }
            }
        }
        return i2;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect $this$beamBeats_I7lrPNg_u24inSourceBeam, int $direction, Rect $source) {
        int equals-impl0;
        int cmp;
        int equals-impl02;
        int i;
        float bottom;
        i = 1;
        if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            equals-impl0 = i;
        } else {
            equals-impl0 = FocusDirection.equals-impl0($direction, FocusDirection.Companion.getRight-dhqQ-8s());
        }
        final int i2 = 0;
        if (equals-impl0 != 0) {
            if (Float.compare(bottom2, bottom) > 0 && Float.compare(top, bottom) < 0) {
                if (Float.compare(top, bottom) < 0) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        } else {
            if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getUp-dhqQ-8s())) {
                equals-impl02 = i;
            } else {
                equals-impl02 = FocusDirection.equals-impl0($direction, FocusDirection.Companion.getDown-dhqQ-8s());
            }
            if (equals-impl02 == 0) {
            } else {
                if (Float.compare(right, bottom) > 0 && Float.compare(left, bottom) < 0) {
                    if (Float.compare(left, bottom) < 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw illegalStateException;
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch, int $direction, Rect $source) {
        int cmp;
        int i;
        float bottom;
        i = 1;
        final int i2 = 0;
        if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            if (Float.compare(left, bottom) >= 0) {
            } else {
                i = i2;
            }
            return i;
        } else {
            if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getRight-dhqQ-8s())) {
                if (Float.compare(right, bottom) <= 0) {
                } else {
                    i = i2;
                }
            } else {
                if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    if (Float.compare(top, bottom) >= 0) {
                    } else {
                        i = i2;
                    }
                } else {
                    if (!FocusDirection.equals-impl0($direction, FocusDirection.Companion.getDown-dhqQ-8s())) {
                    } else {
                        if (Float.compare(bottom2, bottom) <= 0) {
                        } else {
                            i = i2;
                        }
                    }
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw illegalStateException;
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance$6(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246, int $direction, Rect $source) {
        int i;
        float bottom;
        if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            left2 -= bottom;
            return Math.max(0, i);
        } else {
            if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getRight-dhqQ-8s())) {
                left -= bottom;
            } else {
                if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    top2 -= bottom;
                } else {
                    if (!FocusDirection.equals-impl0($direction, FocusDirection.Companion.getDown-dhqQ-8s())) {
                    } else {
                        top -= bottom;
                    }
                }
            }
        }
        IllegalStateException majorAxisDistance = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw majorAxisDistance;
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge, int $direction, Rect $source) {
        int i;
        float bottom;
        if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            left -= bottom;
            return Math.max(1065353216, i);
        } else {
            if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getRight-dhqQ-8s())) {
                right -= bottom;
            } else {
                if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    top -= bottom;
                } else {
                    if (!FocusDirection.equals-impl0($direction, FocusDirection.Companion.getDown-dhqQ-8s())) {
                    } else {
                        bottom2 -= bottom;
                    }
                }
            }
        }
        IllegalStateException majorAxisDistance = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw majorAxisDistance;
    }

    private static final Rect bottomRight(Rect $this$bottomRight) {
        Rect rect = new Rect($this$bottomRight.getRight(), $this$bottomRight.getBottom(), $this$bottomRight.getRight(), $this$bottomRight.getBottom());
        return rect;
    }

    private static final void collectAccessibleChildren(DelegatableNode $this$collectAccessibleChildren, MutableVector<androidx.compose.ui.focus.FocusTargetNode> accessibleChildren) {
        MutableVector mutableVector;
        Modifier.Node next$iv$iv;
        int capacity$iv$iv$iv$iv;
        int i6;
        int $i$f$getFocusTargetOLwlOKw;
        int count$iv$iv;
        Object $this$visitChildren_u2d6rFNWt0$iv;
        int node2;
        int node$iv$iv2;
        Modifier.Node[] arr;
        int i7;
        Object node$iv$iv3;
        int i;
        int i9;
        int i5;
        Object obj;
        int i11;
        int i10;
        Object node$iv$iv;
        int i4;
        int type$iv;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i3;
        int this_$iv$iv$iv;
        int i8;
        int count$iv$iv2;
        Object $this$visitChildren_u2d6rFNWt0$iv2;
        int i2;
        mutableVector = accessibleChildren;
        int i16 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        final int i18 = 0;
        final int i19 = $i$f$getFocusTargetOLwlOKw;
        final Object obj2 = $this$visitChildren_u2d6rFNWt0$iv;
        final int i20 = 0;
        if (!obj2.getNode().isAttached()) {
        } else {
            int i21 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = obj2.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector3, obj2.getNode());
            } else {
                mutableVector3.add(child$ui_release);
            }
            while (mutableVector3.isNotEmpty()) {
                int i22 = 0;
                i = 1;
                node2 = mutableVector3.removeAt(size -= i);
                if (aggregateChildKindSet$ui_release &= i19 == 0) {
                } else {
                }
                node$iv$iv2 = node2;
                while (node$iv$iv2 != null) {
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    int i15 = i;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    i7 = 0;
                    mutableVector = accessibleChildren;
                }
                type$iv = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                mutableVector = accessibleChildren;
                i7 = 0;
                if (kindSet$ui_release &= i19 != 0) {
                } else {
                }
                type$iv = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                i15 = i;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                i7 = 0;
                mutableVector = accessibleChildren;
                i5 = 0;
                i11 = 0;
                i10 = 0;
                int i23 = 0;
                node$iv$iv3 = node$iv$iv;
                while (node$iv$iv3 != null) {
                    if (node$iv$iv3 instanceof FocusTargetNode) {
                    } else {
                    }
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    i9 = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    $i$f$getFocusTargetOLwlOKw = 0;
                    if ($i$f$getFocusTargetOLwlOKw != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    i6 = 1;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i10);
                    i = i6;
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                    mutableVector = accessibleChildren;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $i$f$getFocusTargetOLwlOKw = 0;
                    i4 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i3 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        mutableVector = accessibleChildren;
                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                        $i$f$getFocusTargetOLwlOKw++;
                        if ($i$f$getFocusTargetOLwlOKw == 1) {
                        } else {
                        }
                        if (i10 == 0) {
                        } else {
                        }
                        count$iv$iv2 = $i$f$getFocusTargetOLwlOKw;
                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                        capacity$iv$iv$iv$iv = 0;
                        count$iv$iv = i10;
                        $this$visitChildren_u2d6rFNWt0$iv = node$iv$iv3;
                        if ($this$visitChildren_u2d6rFNWt0$iv != null && count$iv$iv != 0) {
                        }
                        if (count$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = node;
                        i10 = count$iv$iv;
                        $i$f$getFocusTargetOLwlOKw = count$iv$iv2;
                        count$iv$iv.add(node);
                        if (count$iv$iv != 0) {
                        }
                        node$iv$iv3 = 0;
                        count$iv$iv.add($this$visitChildren_u2d6rFNWt0$iv);
                        this_$iv$iv$iv = i14;
                        int $i$f$mutableVectorOf = 16;
                        i8 = 0;
                        count$iv$iv2 = $i$f$getFocusTargetOLwlOKw;
                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                        i2 = $i$f$mutableVectorOf;
                        count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv3 = node;
                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                        next$iv$iv = node;
                        this_$iv$iv$iv = 1;
                    }
                    i6 = 1;
                    if ($i$f$getFocusTargetOLwlOKw == i6) {
                    } else {
                    }
                    i = i6;
                    $i$f$getFocusTargetOLwlOKw = type$iv;
                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                    mutableVector = accessibleChildren;
                    node = node$iv$iv$iv;
                    i3 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    mutableVector = accessibleChildren;
                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                    $i$f$getFocusTargetOLwlOKw++;
                    if ($i$f$getFocusTargetOLwlOKw == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv = i10;
                    $this$visitChildren_u2d6rFNWt0$iv = node$iv$iv3;
                    if ($this$visitChildren_u2d6rFNWt0$iv != null && count$iv$iv != 0) {
                    }
                    if (count$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    i10 = count$iv$iv;
                    $i$f$getFocusTargetOLwlOKw = count$iv$iv2;
                    count$iv$iv.add(node);
                    if (count$iv$iv != 0) {
                    }
                    node$iv$iv3 = 0;
                    count$iv$iv.add($this$visitChildren_u2d6rFNWt0$iv);
                    this_$iv$iv$iv = i14;
                    $i$f$mutableVectorOf = 16;
                    i8 = 0;
                    count$iv$iv2 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    i2 = $i$f$mutableVectorOf;
                    count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    next$iv$iv = node;
                    this_$iv$iv$iv = 1;
                    $i$f$getFocusTargetOLwlOKw = 1;
                    i9 = node$iv$iv3;
                    i4 = 0;
                    if ((FocusTargetNode)i9.isAttached()) {
                    } else {
                    }
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    i6 = 1;
                    if (DelegatableNodeKt.requireLayoutNode((DelegatableNode)i9).isDeactivated()) {
                    } else {
                    }
                    if (i9.fetchFocusProperties$ui_release().getCanFocus()) {
                    } else {
                    }
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    TwoDimensionalFocusSearchKt.collectAccessibleChildren((DelegatableNode)i9, mutableVector);
                    mutableVector.add(i9);
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                    type$iv = $i$f$getFocusTargetOLwlOKw;
                }
                type$iv = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                mutableVector = accessibleChildren;
                i7 = 0;
                if (node$iv$iv3 instanceof FocusTargetNode) {
                } else {
                }
                type$iv = $i$f$getFocusTargetOLwlOKw;
                i9 = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                $i$f$getFocusTargetOLwlOKw = 0;
                if ($i$f$getFocusTargetOLwlOKw != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                i6 = 1;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i10);
                i = i6;
                $i$f$getFocusTargetOLwlOKw = type$iv;
                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                mutableVector = accessibleChildren;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $i$f$getFocusTargetOLwlOKw = 0;
                i4 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i3 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    mutableVector = accessibleChildren;
                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                    $i$f$getFocusTargetOLwlOKw++;
                    if ($i$f$getFocusTargetOLwlOKw == 1) {
                    } else {
                    }
                    if (i10 == 0) {
                    } else {
                    }
                    count$iv$iv2 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    capacity$iv$iv$iv$iv = 0;
                    count$iv$iv = i10;
                    $this$visitChildren_u2d6rFNWt0$iv = node$iv$iv3;
                    if ($this$visitChildren_u2d6rFNWt0$iv != null && count$iv$iv != 0) {
                    }
                    if (count$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    i10 = count$iv$iv;
                    $i$f$getFocusTargetOLwlOKw = count$iv$iv2;
                    count$iv$iv.add(node);
                    if (count$iv$iv != 0) {
                    }
                    node$iv$iv3 = 0;
                    count$iv$iv.add($this$visitChildren_u2d6rFNWt0$iv);
                    this_$iv$iv$iv = i14;
                    $i$f$mutableVectorOf = 16;
                    i8 = 0;
                    count$iv$iv2 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    i2 = $i$f$mutableVectorOf;
                    count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = node;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                    next$iv$iv = node;
                    this_$iv$iv$iv = 1;
                }
                i6 = 1;
                if ($i$f$getFocusTargetOLwlOKw == i6) {
                } else {
                }
                i = i6;
                $i$f$getFocusTargetOLwlOKw = type$iv;
                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                mutableVector = accessibleChildren;
                node = node$iv$iv$iv;
                i3 = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                next$iv$iv = node;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                mutableVector = accessibleChildren;
                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                $i$f$getFocusTargetOLwlOKw++;
                if ($i$f$getFocusTargetOLwlOKw == 1) {
                } else {
                }
                if (i10 == 0) {
                } else {
                }
                count$iv$iv2 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                capacity$iv$iv$iv$iv = 0;
                count$iv$iv = i10;
                $this$visitChildren_u2d6rFNWt0$iv = node$iv$iv3;
                if ($this$visitChildren_u2d6rFNWt0$iv != null && count$iv$iv != 0) {
                }
                if (count$iv$iv != 0) {
                } else {
                }
                next$iv$iv = node;
                i10 = count$iv$iv;
                $i$f$getFocusTargetOLwlOKw = count$iv$iv2;
                count$iv$iv.add(node);
                if (count$iv$iv != 0) {
                }
                node$iv$iv3 = 0;
                count$iv$iv.add($this$visitChildren_u2d6rFNWt0$iv);
                this_$iv$iv$iv = i14;
                $i$f$mutableVectorOf = 16;
                i8 = 0;
                count$iv$iv2 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                i2 = $i$f$mutableVectorOf;
                count$iv$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = node;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                next$iv$iv = node;
                this_$iv$iv$iv = 1;
                $i$f$getFocusTargetOLwlOKw = 1;
                i9 = node$iv$iv3;
                i4 = 0;
                if ((FocusTargetNode)i9.isAttached()) {
                } else {
                }
                type$iv = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                i6 = 1;
                if (DelegatableNodeKt.requireLayoutNode((DelegatableNode)i9).isDeactivated()) {
                } else {
                }
                if (i9.fetchFocusProperties$ui_release().getCanFocus()) {
                } else {
                }
                type$iv = $i$f$getFocusTargetOLwlOKw;
                TwoDimensionalFocusSearchKt.collectAccessibleChildren((DelegatableNode)i9, mutableVector);
                mutableVector.add(i9);
                type$iv = $i$f$getFocusTargetOLwlOKw;
                type$iv = $i$f$getFocusTargetOLwlOKw;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector3, node2);
            }
        }
        int i24 = $i$f$getFocusTargetOLwlOKw;
        int i12 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    private static final androidx.compose.ui.focus.FocusTargetNode findBestCandidate-4WY_MpI(MutableVector<androidx.compose.ui.focus.FocusTargetNode> $this$findBestCandidate_u2d4WY_MpI, Rect focusRect, int direction) {
        int bestCandidate;
        Rect bestCandidate2;
        float f;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean eligibleForFocusSearch;
        boolean betterCandidate-I7lrPNg;
        int i2 = 0;
        int i9 = 0;
        int i10 = 1;
        if (FocusDirection.equals-impl0(direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            bestCandidate2 = focusRect.translate(width += f, i9);
            bestCandidate = 0;
            Object obj2 = $this$findBestCandidate_u2d4WY_MpI;
            int i11 = 0;
            final int size = obj2.getSize();
            if (size > 0) {
                i$iv = 0;
                obj = obj2.getContent()[i$iv];
                i = 0;
                do {
                    obj = content[i$iv];
                    i = 0;
                    if (i$iv++ < size) {
                    }
                    eligibleForFocusSearch = FocusTraversalKt.focusRect(obj);
                    if (TwoDimensionalFocusSearchKt.isBetterCandidate-I7lrPNg(eligibleForFocusSearch, bestCandidate2, focusRect, direction)) {
                    }
                    bestCandidate2 = eligibleForFocusSearch;
                    bestCandidate = obj;
                } while (FocusTraversalKt.isEligibleForFocusSearch((FocusTargetNode)obj));
            }
            return bestCandidate;
        } else {
            if (FocusDirection.equals-impl0(direction, FocusDirection.Companion.getRight-dhqQ-8s())) {
                bestCandidate2 = focusRect.translate(-i4, i9);
            } else {
                if (FocusDirection.equals-impl0(direction, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    bestCandidate2 = focusRect.translate(i9, height2 += f);
                } else {
                    if (!FocusDirection.equals-impl0(direction, FocusDirection.Companion.getDown-dhqQ-8s())) {
                    } else {
                        bestCandidate2 = focusRect.translate(i9, -i6);
                    }
                }
            }
        }
        IllegalStateException bestCandidate3 = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw bestCandidate3;
    }

    public static final boolean findChildCorrespondingToFocusEnter--OM-vw8(androidx.compose.ui.focus.FocusTargetNode $this$findChildCorrespondingToFocusEnter_u2d_u2dOM_u2dvw8, int direction, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        MutableVector mutableVector;
        int right-dhqQ-8s;
        int invoke2;
        Rect bottomRight;
        boolean equals-impl0;
        Object index$iv$iv;
        int equals-impl02;
        int it;
        MutableVector mutableVector2;
        int invoke;
        Object obj;
        int i2 = 0;
        MutableVector mutableVector3 = new MutableVector(new FocusTargetNode[16], 0);
        TwoDimensionalFocusSearchKt.collectAccessibleChildren((DelegatableNode)$this$findChildCorrespondingToFocusEnter_u2d_u2dOM_u2dvw8, mutableVector3);
        equals-impl0 = 1;
        if (mutableVector3.getSize() <= equals-impl0) {
            mutableVector = mutableVector3;
            invoke2 = 0;
            if (mutableVector.isEmpty()) {
                index$iv$iv = 0;
            } else {
                invoke = 0;
                index$iv$iv = obj;
            }
            if ((FocusTargetNode)index$iv$iv != null) {
                mutableVector = 0;
                it = (Boolean)onFound.invoke((FocusTargetNode)index$iv$iv).booleanValue();
            }
            return it;
        }
        if (FocusDirection.equals-impl0(direction, FocusDirection.Companion.getEnter-dhqQ-8s())) {
            right-dhqQ-8s = FocusDirection.Companion.getRight-dhqQ-8s();
        } else {
            right-dhqQ-8s = direction;
        }
        if (FocusDirection.equals-impl0(right-dhqQ-8s, FocusDirection.Companion.getRight-dhqQ-8s())) {
            equals-impl02 = equals-impl0;
        } else {
            equals-impl02 = FocusDirection.equals-impl0(right-dhqQ-8s, FocusDirection.Companion.getDown-dhqQ-8s());
        }
        if (equals-impl02 != 0) {
            bottomRight = TwoDimensionalFocusSearchKt.topLeft(FocusTraversalKt.focusRect($this$findChildCorrespondingToFocusEnter_u2d_u2dOM_u2dvw8));
            androidx.compose.ui.focus.FocusTargetNode bestCandidate-4WY_MpI = TwoDimensionalFocusSearchKt.findBestCandidate-4WY_MpI(mutableVector3, bottomRight, right-dhqQ-8s);
            if (bestCandidate-4WY_MpI != null) {
                mutableVector2 = 0;
                it = (Boolean)onFound.invoke(bestCandidate-4WY_MpI).booleanValue();
            }
            return it;
        } else {
            if (FocusDirection.equals-impl0(right-dhqQ-8s, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            } else {
                equals-impl0 = FocusDirection.equals-impl0(right-dhqQ-8s, FocusDirection.Companion.getUp-dhqQ-8s());
            }
            if (!equals-impl0) {
            } else {
                bottomRight = TwoDimensionalFocusSearchKt.bottomRight(FocusTraversalKt.focusRect($this$findChildCorrespondingToFocusEnter_u2d_u2dOM_u2dvw8));
            }
        }
        IllegalStateException initialFocusRect = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw initialFocusRect;
    }

    private static final boolean generateAndSearchChildren-4C6V_qg(androidx.compose.ui.focus.FocusTargetNode $this$generateAndSearchChildren_u2d4C6V_qg, Rect focusedItem, int direction, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        boolean booleanValue;
        if (TwoDimensionalFocusSearchKt.searchChildren-4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound)) {
            return 1;
        }
        TwoDimensionalFocusSearchKt.generateAndSearchChildren.1 anon = new TwoDimensionalFocusSearchKt.generateAndSearchChildren.1($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound);
        Object searchBeyondBounds--OM-vw8 = BeyondBoundsLayoutKt.searchBeyondBounds--OM-vw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, (Function1)anon);
        if ((Boolean)searchBeyondBounds--OM-vw8 != null) {
            booleanValue = (Boolean)searchBeyondBounds--OM-vw8.booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }

    private static final boolean isBetterCandidate-I7lrPNg(Rect proposedCandidate, Rect currentCandidate, Rect focusedRect, int direction) {
        boolean betterCandidate_I7lrPNg$isCandidate;
        int i;
        int i2;
        long betterCandidate_I7lrPNg$weightedDistance2;
        long betterCandidate_I7lrPNg$weightedDistance;
        i = 0;
        if (!TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$isCandidate(proposedCandidate, direction, focusedRect)) {
        } else {
            i2 = 1;
            if (!TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$isCandidate(currentCandidate, direction, focusedRect)) {
                i = i2;
            } else {
                if (TwoDimensionalFocusSearchKt.beamBeats-I7lrPNg(focusedRect, proposedCandidate, currentCandidate, direction)) {
                    i = i2;
                } else {
                    if (TwoDimensionalFocusSearchKt.beamBeats-I7lrPNg(focusedRect, currentCandidate, proposedCandidate, direction)) {
                    } else {
                        if (Long.compare(betterCandidate_I7lrPNg$weightedDistance2, betterCandidate_I7lrPNg$weightedDistance) < 0) {
                            i = i2;
                        }
                    }
                }
            }
        }
        return i;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect $this$isBetterCandidate_I7lrPNg_u24isCandidate, int $direction, Rect $focusedRect) {
        int cmp;
        int i;
        float bottom;
        i = 1;
        final int i2 = 0;
        if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            if (Float.compare(right3, bottom) <= 0) {
                if (Float.compare(left3, bottom) >= 0 && Float.compare(left2, bottom) > 0) {
                    if (Float.compare(left2, bottom) > 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        } else {
            if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getRight-dhqQ-8s())) {
                if (Float.compare(left, bottom) >= 0) {
                    if (Float.compare(right2, bottom) <= 0 && Float.compare(right, bottom) < 0) {
                        if (Float.compare(right, bottom) < 0) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
                if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    if (Float.compare(bottom4, bottom) <= 0) {
                        if (Float.compare(top2, bottom) >= 0 && Float.compare(top3, bottom) > 0) {
                            if (Float.compare(top3, bottom) > 0) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    if (!FocusDirection.equals-impl0($direction, FocusDirection.Companion.getDown-dhqQ-8s())) {
                    } else {
                        if (Float.compare(top, bottom) >= 0) {
                            if (Float.compare(bottom2, bottom) <= 0 && Float.compare(bottom3, bottom) < 0) {
                                if (Float.compare(bottom3, bottom) < 0) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw illegalStateException;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance, int $direction, Rect $focusedRect) {
        int i;
        float bottom;
        if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            left2 -= bottom;
            return Math.max(0, i);
        } else {
            if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getRight-dhqQ-8s())) {
                left -= bottom;
            } else {
                if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    top2 -= bottom;
                } else {
                    if (!FocusDirection.equals-impl0($direction, FocusDirection.Companion.getDown-dhqQ-8s())) {
                    } else {
                        top -= bottom;
                    }
                }
            }
        }
        IllegalStateException majorAxisDistance = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw majorAxisDistance;
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24minorAxisDistance, int $direction, Rect $focusedRect) {
        boolean equals-impl02;
        int i;
        int down-dhqQ-8s;
        int i2;
        boolean equals-impl0;
        float f;
        int i3;
        if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            equals-impl02 = equals-impl0;
        } else {
            equals-impl02 = FocusDirection.equals-impl0($direction, FocusDirection.Companion.getRight-dhqQ-8s());
        }
        int i8 = 2;
        if (equals-impl02) {
            f = (float)i8;
            i5 -= i2;
            return i;
        } else {
            if (FocusDirection.equals-impl0($direction, FocusDirection.Companion.getUp-dhqQ-8s())) {
            } else {
                equals-impl0 = FocusDirection.equals-impl0($direction, FocusDirection.Companion.getDown-dhqQ-8s());
            }
            if (!equals-impl0) {
            } else {
                f = (float)i8;
                i4 -= i2;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("This function should only be used for 2-D focus search".toString());
        throw illegalStateException;
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int $direction, Rect $focusedRect, Rect candidate) {
        long l = (long)f;
        long l2 = (long)f2;
        return i3 += i5;
    }

    private static final boolean searchChildren-4C6V_qg(androidx.compose.ui.focus.FocusTargetNode $this$searchChildren_u2d4C6V_qg, Rect focusedItem, int direction, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        MutableVector capacity$iv;
        MutableVector $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
        Modifier.Node child$iv$iv2;
        Modifier.Node child$iv$iv;
        int i6;
        Object node$iv$iv2;
        int node2;
        int count$iv$iv;
        int this_$iv$iv$iv;
        int node$iv$iv3;
        int size;
        int i2;
        Object obj2;
        int i7;
        int i4;
        Object node$iv$iv;
        int i;
        Object obj;
        int attached;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i5;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u243;
        int this_$iv$iv$iv2;
        int i8;
        int i9;
        MutableVector branches$iv$iv;
        Modifier.Node node;
        int i3;
        final Rect rect = focusedItem;
        final int i10 = direction;
        final Function1 function1 = onFound;
        int i13 = 0;
        i6 = 0;
        MutableVector mutableVector2 = new MutableVector(new FocusTargetNode[16], i6);
        int i14 = 0;
        int i15 = 0;
        int $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        int i17 = 0;
        final int i18 = $i$f$getFocusTargetOLwlOKw;
        final DelegatableNode delegatableNode2 = delegatableNode;
        final int i19 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node2 = 0;
            node$iv$iv3 = 0;
            int i22 = i14;
            $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = new MutableVector(new Modifier.Node[16], i6);
            child$iv$iv2 = delegatableNode2.getNode().getChild$ui_release();
            if (child$iv$iv2 == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1, delegatableNode2.getNode());
            } else {
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(child$iv$iv2);
            }
            count$iv$iv = 1;
            while ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.isNotEmpty()) {
                int i20 = 0;
                node2 = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.removeAt(size + -1);
                if (aggregateChildKindSet$ui_release &= i18 == 0) {
                } else {
                }
                node$iv$iv3 = node2;
                while (node$iv$iv3 != null) {
                    $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    i6 = 0;
                    count$iv$iv = 1;
                }
                $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                i6 = 0;
                count$iv$iv = 1;
                if (kindSet$ui_release &= i18 != 0) {
                } else {
                }
                $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                i6 = 0;
                count$iv$iv = 1;
                i2 = 0;
                i7 = 0;
                i4 = 0;
                int i23 = 0;
                node$iv$iv2 = node$iv$iv;
                while (node$iv$iv2 != null) {
                    if (node$iv$iv2 instanceof FocusTargetNode) {
                    } else {
                    }
                    obj = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(i4);
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u243;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = branches$iv$iv;
                    child$iv$iv2 = node;
                    count$iv$iv = 1;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    attached = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i5 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                        branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                        node = child$iv$iv2;
                        child$iv$iv = node3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u243;
                        $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = branches$iv$iv;
                        child$iv$iv2 = node;
                        $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                        if (this_$iv$iv$iv++ == 1) {
                        } else {
                        }
                        if (i4 == 0) {
                        } else {
                        }
                        branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                        node = child$iv$iv2;
                        $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = i4;
                        capacity$iv = node$iv$iv2;
                        if (capacity$iv != null && $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                        }
                        if ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                        } else {
                        }
                        child$iv$iv = node3;
                        i4 = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                        $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(node3);
                        if ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                        }
                        node$iv$iv2 = child$iv$iv2;
                        $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(capacity$iv);
                        i8 = i12;
                        int $i$f$mutableVectorOf = 16;
                        i9 = 0;
                        branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                        node = child$iv$iv2;
                        i3 = $i$f$mutableVectorOf;
                        $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv2 = node3;
                        branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                        node = child$iv$iv2;
                        child$iv$iv = node3;
                        this_$iv$iv$iv2 = 1;
                    }
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u243;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = branches$iv$iv;
                    child$iv$iv2 = node;
                    count$iv$iv = 1;
                    node3 = node$iv$iv$iv;
                    i5 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    child$iv$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u243;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = branches$iv$iv;
                    child$iv$iv2 = node;
                    $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                    if (this_$iv$iv$iv++ == 1) {
                    } else {
                    }
                    if (i4 == 0) {
                    } else {
                    }
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = i4;
                    capacity$iv = node$iv$iv2;
                    if (capacity$iv != null && $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                    }
                    if ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                    } else {
                    }
                    child$iv$iv = node3;
                    i4 = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(node3);
                    if ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                    }
                    node$iv$iv2 = child$iv$iv2;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(capacity$iv);
                    i8 = i12;
                    $i$f$mutableVectorOf = 16;
                    i9 = 0;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    i3 = $i$f$mutableVectorOf;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv2 = node3;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    child$iv$iv = node3;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv = node$iv$iv2;
                    obj = 0;
                    if ((FocusTargetNode)this_$iv$iv$iv.isAttached()) {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    capacity$iv.add(this_$iv$iv$iv);
                }
                $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                i6 = 0;
                if (node$iv$iv2 instanceof FocusTargetNode) {
                } else {
                }
                obj = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                node$iv$iv2 = DelegatableNodeKt.access$pop(i4);
                capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u243;
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = branches$iv$iv;
                child$iv$iv2 = node;
                count$iv$iv = 1;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv = 0;
                attached = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i5 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    child$iv$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u243;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = branches$iv$iv;
                    child$iv$iv2 = node;
                    $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                    if (this_$iv$iv$iv++ == 1) {
                    } else {
                    }
                    if (i4 == 0) {
                    } else {
                    }
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = i4;
                    capacity$iv = node$iv$iv2;
                    if (capacity$iv != null && $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                    }
                    if ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                    } else {
                    }
                    child$iv$iv = node3;
                    i4 = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(node3);
                    if ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                    }
                    node$iv$iv2 = child$iv$iv2;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(capacity$iv);
                    i8 = i12;
                    $i$f$mutableVectorOf = 16;
                    i9 = 0;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    i3 = $i$f$mutableVectorOf;
                    $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv2 = node3;
                    branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                    node = child$iv$iv2;
                    child$iv$iv = node3;
                    this_$iv$iv$iv2 = 1;
                }
                if (this_$iv$iv$iv == 1) {
                } else {
                }
                capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u243;
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = branches$iv$iv;
                child$iv$iv2 = node;
                count$iv$iv = 1;
                node3 = node$iv$iv$iv;
                i5 = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                child$iv$iv = node3;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                capacity$iv = $this$searchChildren_4C6V_qg_u24lambda_u243;
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = branches$iv$iv;
                child$iv$iv2 = node;
                $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                if (this_$iv$iv$iv++ == 1) {
                } else {
                }
                if (i4 == 0) {
                } else {
                }
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = i4;
                capacity$iv = node$iv$iv2;
                if (capacity$iv != null && $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                }
                if ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                } else {
                }
                child$iv$iv = node3;
                i4 = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(node3);
                if ($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 != 0) {
                }
                node$iv$iv2 = child$iv$iv2;
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1.add(capacity$iv);
                i8 = i12;
                $i$f$mutableVectorOf = 16;
                i9 = 0;
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                i3 = $i$f$mutableVectorOf;
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv2 = node3;
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                child$iv$iv = node3;
                this_$iv$iv$iv2 = 1;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv = node$iv$iv2;
                obj = 0;
                if ((FocusTargetNode)this_$iv$iv$iv.isAttached()) {
                }
                $this$searchChildren_4C6V_qg_u24lambda_u243 = capacity$iv;
                branches$iv$iv = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
                node = child$iv$iv2;
                capacity$iv.add(this_$iv$iv$iv);
                DelegatableNodeKt.access$addLayoutNodeChildren($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1, node2);
            }
            MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2433 = capacity$iv;
            MutableVector mutableVector6 = $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1;
            Modifier.Node node7 = child$iv$iv2;
            MutableVector mutableVector = mutableVector4;
            while (mutableVector.isNotEmpty()) {
                $i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1 = TwoDimensionalFocusSearchKt.findBestCandidate-4WY_MpI(mutableVector, rect, i10);
                i = 1;
                mutableVector.remove($i$a$ApplyTwoDimensionalFocusSearchKt$searchChildren$children$1);
            }
            return 0;
        }
        MutableVector mutableVector5 = capacity$iv;
        int i21 = i14;
        int $this$searchChildren_4C6V_qg_u24lambda_u2432 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    private static final Rect topLeft(Rect $this$topLeft) {
        Rect rect = new Rect($this$topLeft.getLeft(), $this$topLeft.getTop(), $this$topLeft.getLeft(), $this$topLeft.getTop());
        return rect;
    }

    public static final Boolean twoDimensionalFocusSearch-sMXa3k8(androidx.compose.ui.focus.FocusTargetNode $this$twoDimensionalFocusSearch_u2dsMXa3k8, int direction, Rect previouslyFocusedRect, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        Object valueOf;
        Rect focusRect;
        Rect focusRect2;
        switch (i2) {
            case 1:
                androidx.compose.ui.focus.FocusTargetNode activeChild = FocusTraversalKt.getActiveChild($this$twoDimensionalFocusSearch_u2dsMXa3k8);
                String str = "ActiveParent must have a focusedChild";
                NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException2;
                IllegalStateException illegalStateException = new IllegalStateException(str.toString());
                throw illegalStateException;
                focusRect = FocusTraversalKt.focusRect(activeChild);
                focusRect = previouslyFocusedRect;
                return Boolean.valueOf(TwoDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg($this$twoDimensionalFocusSearch_u2dsMXa3k8, focusRect, direction, onFound));
                Boolean twoDimensionalFocusSearch-sMXa3k8 = TwoDimensionalFocusSearchKt.twoDimensionalFocusSearch-sMXa3k8(activeChild, direction, previouslyFocusedRect, onFound);
                return twoDimensionalFocusSearch-sMXa3k8;
                focusRect2 = FocusTraversalKt.focusRect(TwoDimensionalFocusSearchKt.activeNode(activeChild));
                focusRect2 = previouslyFocusedRect;
                return Boolean.valueOf(TwoDimensionalFocusSearchKt.generateAndSearchChildren-4C6V_qg($this$twoDimensionalFocusSearch_u2dsMXa3k8, focusRect2, direction, onFound));
                IllegalStateException focusedChild = new IllegalStateException(str.toString());
                throw focusedChild;
            case 2:
                return Boolean.valueOf(TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8($this$twoDimensionalFocusSearch_u2dsMXa3k8, direction, onFound));
            case 3:
                valueOf = onFound.invoke($this$twoDimensionalFocusSearch_u2dsMXa3k8);
                valueOf = Boolean.valueOf(TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8($this$twoDimensionalFocusSearch_u2dsMXa3k8, direction, onFound));
                valueOf = Boolean.valueOf(TwoDimensionalFocusSearchKt.searchChildren-4C6V_qg($this$twoDimensionalFocusSearch_u2dsMXa3k8, previouslyFocusedRect, direction, onFound));
                return valueOf;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
    }
}
