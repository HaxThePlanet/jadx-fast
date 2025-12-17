package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a&\u0010\u0007\u001a\u00020\u0008*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\u000c\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001aF\u0010\u0013\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0016H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", "", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "previouslyFocusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-0X8WOeE", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusTraversalKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;
        static {
            int i;
            int ordinal5;
            int ordinal4;
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            i = 1;
            iArr[LayoutDirection.Ltr.ordinal()] = i;
            int i2 = 2;
            iArr[LayoutDirection.Rtl.ordinal()] = i2;
            FocusTraversalKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[FocusStateImpl.Active.ordinal()] = i;
            iArr2[FocusStateImpl.ActiveParent.ordinal()] = i2;
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
                FocusTraversalKt.WhenMappings.$EnumSwitchMapping$1 = iArr2;
            } catch (java.lang.NoSuchFieldError e) {
            }
        }
    }
    public static final androidx.compose.ui.focus.FocusRequester customFocusSearch--OM-vw8(androidx.compose.ui.focus.FocusTargetNode $this$customFocusSearch_u2d_u2dOM_u2dvw8, int focusDirection, LayoutDirection layoutDirection) {
        androidx.compose.ui.focus.FocusRequester previous;
        int box-impl;
        int i3;
        int i;
        androidx.compose.ui.focus.FocusRequester request;
        int i2;
        androidx.compose.ui.focus.FocusRequester default;
        final androidx.compose.ui.focus.FocusProperties focusProperties$ui_release = $this$customFocusSearch_u2d_u2dOM_u2dvw8.fetchFocusProperties$ui_release();
        if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getNext-dhqQ-8s())) {
            previous = focusProperties$ui_release.getNext();
            return previous;
        } else {
            if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
                previous = focusProperties$ui_release.getPrevious();
            } else {
                if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getUp-dhqQ-8s())) {
                    previous = focusProperties$ui_release.getUp();
                } else {
                    if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getDown-dhqQ-8s())) {
                        previous = focusProperties$ui_release.getDown();
                    } else {
                        box-impl = 0;
                        i3 = 1;
                        i = 0;
                        if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getLeft-dhqQ-8s())) {
                            switch (i4) {
                                case 1:
                                    previous = focusProperties$ui_release.getStart();
                                    break;
                                case 2:
                                    previous = focusProperties$ui_release.getEnd();
                                    break;
                                default:
                                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                                    throw noWhenBranchMatchedException;
                            }
                            i2 = 0;
                            if (previous == FocusRequester.Companion.getDefault()) {
                            } else {
                                i3 = i;
                            }
                            if (i3 == 0) {
                            } else {
                                previous = box-impl;
                            }
                            if (previous == 0) {
                                previous = focusProperties$ui_release.getLeft();
                            }
                        }
                        if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getRight-dhqQ-8s())) {
                            switch (i5) {
                                case 1:
                                    previous = focusProperties$ui_release.getEnd();
                                    break;
                                case 2:
                                    previous = focusProperties$ui_release.getStart();
                                    break;
                                default:
                                    NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                                    throw noWhenBranchMatchedException2;
                            }
                            i2 = 0;
                            if (previous == FocusRequester.Companion.getDefault()) {
                            } else {
                                i3 = i;
                            }
                            if (i3 == 0) {
                            } else {
                                previous = box-impl;
                            }
                            if (previous == 0) {
                                previous = focusProperties$ui_release.getRight();
                            }
                        }
                        if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getEnter-dhqQ-8s())) {
                            previous = focusProperties$ui_release.getEnter().invoke(FocusDirection.box-impl(focusDirection));
                        } else {
                            if (!FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getExit-dhqQ-8s())) {
                            } else {
                                previous = focusProperties$ui_release.getExit().invoke(FocusDirection.box-impl(focusDirection));
                            }
                        }
                    }
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("invalid FocusDirection".toString());
        throw illegalStateException;
    }

    public static final androidx.compose.ui.focus.FocusTargetNode findActiveFocusNode(androidx.compose.ui.focus.FocusTargetNode $this$findActiveFocusNode) {
        int $this$visitChildren_u2d6rFNWt0$iv;
        int $this$visitChildren_u2d6rFNWt0$iv2;
        int i4;
        Modifier.Node[] node$iv$iv4;
        int $i$f$getFocusTargetOLwlOKw;
        int type$iv;
        int type$iv2;
        int node2;
        int node$iv$iv3;
        Modifier.Node[] arr;
        int count$iv$iv2;
        Modifier.Node[] count$iv$iv;
        int i5;
        Modifier.Node next$iv$iv;
        int i3;
        Modifier.Node[] objArr2;
        int i8;
        int i;
        int node$iv$iv;
        int i10;
        androidx.compose.ui.focus.FocusTargetNode activeFocusNode;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i6;
        int this_$iv$iv$iv;
        int i2;
        int i9;
        int $this$visitChildren_u2d6rFNWt0$iv3;
        Modifier.Node[] node$iv$iv2;
        int i7;
        Modifier.Node[] objArr;
        switch (i12) {
            case 1:
                return $this$findActiveFocusNode;
            case 2:
                $this$visitChildren_u2d6rFNWt0$iv = $this$findActiveFocusNode;
                int i14 = 0;
                int i16 = 0;
                final int i17 = $i$f$getFocusTargetOLwlOKw;
                final int i18 = $this$visitChildren_u2d6rFNWt0$iv;
                final int i19 = 0;
                int i25 = $this$visitChildren_u2d6rFNWt0$iv;
                int $this$visitChildren_u2d6rFNWt0$iv5 = 0;
                IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
                throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
            case 3:
                return null;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        int i20 = 0;
        node$iv$iv3 = 0;
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = i18.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i18.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            int i21 = 0;
            i5 = 1;
            node2 = mutableVector2.removeAt(size -= i5);
            if (aggregateChildKindSet$ui_release &= i17 == 0) {
            } else {
            }
            node$iv$iv3 = node2;
            while (node$iv$iv3 != 0) {
                node$iv$iv = i4;
                int type$iv3 = count$iv$iv2;
                int $this$visitChildren_u2d6rFNWt0$iv4 = i5;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                $i$f$getFocusTargetOLwlOKw = i7;
            }
            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
            node$iv$iv = i4;
            int type$iv5 = count$iv$iv2;
            $i$f$getFocusTargetOLwlOKw = i7;
            if (kindSet$ui_release &= i17 != null) {
            } else {
            }
            node$iv$iv = i4;
            type$iv3 = count$iv$iv2;
            $this$visitChildren_u2d6rFNWt0$iv4 = i5;
            node$iv$iv3 = node$iv$iv3.getChild$ui_release();
            $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i7;
            i3 = 0;
            i8 = 0;
            i = 0;
            int i24 = 0;
            node$iv$iv4 = objArr;
            while (node$iv$iv4 != null) {
                i10 = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv4 instanceof DelegatingNode) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = i5;
                type$iv = 0;
                node$iv$iv4 = DelegatableNodeKt.access$pop(i);
                i5 = $this$visitChildren_u2d6rFNWt0$iv2;
                count$iv$iv2 = type$iv;
                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                $i$f$getFocusTargetOLwlOKw = i7;
                if (node$iv$iv4 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                activeFocusNode = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i6 = 0;
                    i2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                    node$iv$iv2 = node$iv$iv4;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    next$iv$iv = node;
                    type$iv2 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                    $i$f$getFocusTargetOLwlOKw = i7;
                    i5 = 1;
                    if (count$iv$iv++ == i5) {
                    } else {
                    }
                    if (i == 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                    node$iv$iv2 = node$iv$iv4;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    type$iv2 = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = i;
                    Modifier.Node[] objArr3 = node$iv$iv2;
                    if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                    } else {
                    }
                    next$iv$iv = node;
                    i = $this$visitChildren_u2d6rFNWt0$iv;
                    node$iv$iv4 = node$iv$iv2;
                    $this$visitChildren_u2d6rFNWt0$iv.add(node);
                    if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                    }
                    node$iv$iv2 = i5;
                    $this$visitChildren_u2d6rFNWt0$iv.add(objArr3);
                    this_$iv$iv$iv = 0;
                    i9 = 0;
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                    node$iv$iv2 = node$iv$iv4;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv4 = node;
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                    i7 = $i$f$getFocusTargetOLwlOKw;
                    next$iv$iv = node;
                    type$iv2 = 0;
                    this_$iv$iv$iv = i5;
                }
                node$iv$iv2 = node$iv$iv4;
                $this$visitChildren_u2d6rFNWt0$iv2 = 1;
                if (count$iv$iv == $this$visitChildren_u2d6rFNWt0$iv2) {
                } else {
                }
                node$iv$iv4 = node$iv$iv2;
                i5 = $this$visitChildren_u2d6rFNWt0$iv2;
                count$iv$iv2 = type$iv;
                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                node$iv$iv4 = node$iv$iv2;
                $i$f$getFocusTargetOLwlOKw = i7;
                node = node$iv$iv$iv;
                i6 = 0;
                i2 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv2 = node$iv$iv4;
                i7 = $i$f$getFocusTargetOLwlOKw;
                next$iv$iv = node;
                type$iv2 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                $i$f$getFocusTargetOLwlOKw = i7;
                i5 = 1;
                if (count$iv$iv++ == i5) {
                } else {
                }
                if (i == 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv2 = node$iv$iv4;
                i7 = $i$f$getFocusTargetOLwlOKw;
                type$iv2 = 0;
                $this$visitChildren_u2d6rFNWt0$iv = i;
                objArr3 = node$iv$iv2;
                if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
                }
                if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                } else {
                }
                next$iv$iv = node;
                i = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv4 = node$iv$iv2;
                $this$visitChildren_u2d6rFNWt0$iv.add(node);
                if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                }
                node$iv$iv2 = i5;
                $this$visitChildren_u2d6rFNWt0$iv.add(objArr3);
                this_$iv$iv$iv = 0;
                i9 = 0;
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv2 = node$iv$iv4;
                i7 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv4 = node;
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                next$iv$iv = node;
                type$iv2 = 0;
                this_$iv$iv$iv = i5;
                count$iv$iv = i5;
                i10 = 0;
                activeFocusNode = FocusTraversalKt.findActiveFocusNode((FocusTargetNode)node$iv$iv4);
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv2 = i5;
                type$iv = 0;
            }
            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
            int type$iv4 = count$iv$iv2;
            i4 = node$iv$iv;
            $i$f$getFocusTargetOLwlOKw = i7;
            i10 = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv = 0;
            if (count$iv$iv != 0 && node$iv$iv4 instanceof DelegatingNode) {
            } else {
            }
            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
            i7 = $i$f$getFocusTargetOLwlOKw;
            $this$visitChildren_u2d6rFNWt0$iv2 = i5;
            type$iv = 0;
            node$iv$iv4 = DelegatableNodeKt.access$pop(i);
            i5 = $this$visitChildren_u2d6rFNWt0$iv2;
            count$iv$iv2 = type$iv;
            $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i7;
            if (node$iv$iv4 instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv = 0;
            activeFocusNode = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                node = node$iv$iv$iv;
                i6 = 0;
                i2 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv2 = node$iv$iv4;
                i7 = $i$f$getFocusTargetOLwlOKw;
                next$iv$iv = node;
                type$iv2 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                $i$f$getFocusTargetOLwlOKw = i7;
                i5 = 1;
                if (count$iv$iv++ == i5) {
                } else {
                }
                if (i == 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv2 = node$iv$iv4;
                i7 = $i$f$getFocusTargetOLwlOKw;
                type$iv2 = 0;
                $this$visitChildren_u2d6rFNWt0$iv = i;
                objArr3 = node$iv$iv2;
                if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
                }
                if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                } else {
                }
                next$iv$iv = node;
                i = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv4 = node$iv$iv2;
                $this$visitChildren_u2d6rFNWt0$iv.add(node);
                if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
                }
                node$iv$iv2 = i5;
                $this$visitChildren_u2d6rFNWt0$iv.add(objArr3);
                this_$iv$iv$iv = 0;
                i9 = 0;
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv2 = node$iv$iv4;
                i7 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv4 = node;
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                i7 = $i$f$getFocusTargetOLwlOKw;
                next$iv$iv = node;
                type$iv2 = 0;
                this_$iv$iv$iv = i5;
            }
            node$iv$iv2 = node$iv$iv4;
            $this$visitChildren_u2d6rFNWt0$iv2 = 1;
            if (count$iv$iv == $this$visitChildren_u2d6rFNWt0$iv2) {
            } else {
            }
            node$iv$iv4 = node$iv$iv2;
            i5 = $this$visitChildren_u2d6rFNWt0$iv2;
            count$iv$iv2 = type$iv;
            $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
            node$iv$iv4 = node$iv$iv2;
            $i$f$getFocusTargetOLwlOKw = i7;
            node = node$iv$iv$iv;
            i6 = 0;
            i2 = 0;
            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            this_$iv$iv$iv = 0;
            if (this_$iv$iv$iv != 0) {
            } else {
            }
            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
            node$iv$iv2 = node$iv$iv4;
            i7 = $i$f$getFocusTargetOLwlOKw;
            next$iv$iv = node;
            type$iv2 = 0;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i7;
            i5 = 1;
            if (count$iv$iv++ == i5) {
            } else {
            }
            if (i == 0) {
            } else {
            }
            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
            node$iv$iv2 = node$iv$iv4;
            i7 = $i$f$getFocusTargetOLwlOKw;
            type$iv2 = 0;
            $this$visitChildren_u2d6rFNWt0$iv = i;
            objArr3 = node$iv$iv2;
            if (objArr3 != null && $this$visitChildren_u2d6rFNWt0$iv != 0) {
            }
            if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
            } else {
            }
            next$iv$iv = node;
            i = $this$visitChildren_u2d6rFNWt0$iv;
            node$iv$iv4 = node$iv$iv2;
            $this$visitChildren_u2d6rFNWt0$iv.add(node);
            if ($this$visitChildren_u2d6rFNWt0$iv != 0) {
            }
            node$iv$iv2 = i5;
            $this$visitChildren_u2d6rFNWt0$iv.add(objArr3);
            this_$iv$iv$iv = 0;
            i9 = 0;
            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
            node$iv$iv2 = node$iv$iv4;
            i7 = $i$f$getFocusTargetOLwlOKw;
            $this$visitChildren_u2d6rFNWt0$iv = new MutableVector(new Modifier.Node[16], 0);
            node$iv$iv4 = node;
            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
            i7 = $i$f$getFocusTargetOLwlOKw;
            next$iv$iv = node;
            type$iv2 = 0;
            this_$iv$iv$iv = i5;
            count$iv$iv = i5;
            i10 = 0;
            activeFocusNode = FocusTraversalKt.findActiveFocusNode((FocusTargetNode)node$iv$iv4);
            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
            i7 = $i$f$getFocusTargetOLwlOKw;
            $this$visitChildren_u2d6rFNWt0$iv2 = i5;
            type$iv = 0;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
        }
        return i4;
    }

    private static final androidx.compose.ui.focus.FocusTargetNode findNonDeactivatedParent(androidx.compose.ui.focus.FocusTargetNode $this$findNonDeactivatedParent) {
        DelegatableNode count$iv$iv;
        Modifier.Node count$iv$iv3;
        int $i$f$getFocusTargetOLwlOKw;
        Modifier.Node type$iv;
        int $i$f$mutableVectorOf;
        int includeSelf$iv;
        int i6;
        int $i$f$visitAncestorsYYKmho;
        Modifier.Node node$iv$iv3;
        LayoutNode layout$iv$iv;
        int node$iv$iv;
        Modifier.Node head$ui_release;
        int i;
        int i2;
        Modifier.Node node;
        int i3;
        int stack$iv$iv;
        int node$iv$iv2;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int $i$f$isKindH91voCI$ui_release;
        Modifier.Node canFocus;
        Modifier.Node node2;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i7;
        int type$iv2;
        int this_$iv$iv$iv;
        int count$iv$iv2;
        int i5;
        int i8;
        int i4;
        int i9;
        count$iv$iv = $this$findNonDeactivatedParent;
        int i10 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        includeSelf$iv = 0;
        i6 = 0;
        final int i13 = $i$f$getFocusTargetOLwlOKw;
        final DelegatableNode delegatableNode = count$iv$iv;
        final int i14 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv3 = delegatableNode.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i13 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv2 = $i$f$getFocusTargetOLwlOKw;
                i4 = includeSelf$iv;
                i9 = i6;
                node$iv$iv2 = 0;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                count$iv$iv = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && count$iv$iv != null) {
                } else {
                }
                node$iv$iv = node$iv$iv2;
                node$iv$iv3 = node$iv$iv;
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $i$f$getFocusTargetOLwlOKw = type$iv2;
                includeSelf$iv = i4;
                i6 = i9;
                count$iv$iv = layout$iv$iv.getNodes$ui_release();
                if (count$iv$iv != null) {
                } else {
                }
                node$iv$iv = count$iv$iv.getTail$ui_release();
                while (node$iv$iv3 != null) {
                    if (kindSet$ui_release &= i13 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    node$iv$iv2 = 0;
                    node$iv$iv3 = node$iv$iv3.getParent$ui_release();
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv2;
                    includeSelf$iv = i4;
                    i6 = i9;
                    i2 = 0;
                    i3 = 0;
                    stack$iv$iv = 0;
                    int i15 = 0;
                    node$iv$iv = node$iv$iv4;
                    node$iv$iv2 = 0;
                    while (node$iv$iv != null) {
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                        count$iv$iv3 = node$iv$iv;
                        int i17 = 0;
                        node2 = count$iv$iv3;
                        if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        $i$f$isKindH91voCI$ui_release = 0;
                        if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        type$iv2 = $i$f$getFocusTargetOLwlOKw;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        $i$f$getFocusTargetOLwlOKw = type$iv2;
                        includeSelf$iv = i4;
                        i6 = i9;
                        if (node$iv$iv instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv3 = 0;
                        node2 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node3 = node$iv$iv$iv;
                            i7 = 0;
                            count$iv$iv2 = 0;
                            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            type$iv2 = $i$f$getFocusTargetOLwlOKw;
                            i4 = includeSelf$iv;
                            i9 = i6;
                            type$iv = node3;
                            $i$f$visitAncestorsYYKmho = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            $i$f$getFocusTargetOLwlOKw = type$iv2;
                            includeSelf$iv = i4;
                            i6 = i9;
                            count$iv$iv3++;
                            type$iv2 = $i$f$getFocusTargetOLwlOKw;
                            if (count$iv$iv3 == 1) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv2 = count$iv$iv3;
                            i4 = includeSelf$iv;
                            i9 = i6;
                            $i$f$visitAncestorsYYKmho = 0;
                            $i$f$mutableVectorOf = stack$iv$iv;
                            stack$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node4 = node$iv$iv;
                            if (node4 != null && stack$iv$iv != 0) {
                            }
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            type$iv = node3;
                            count$iv$iv3 = count$iv$iv2;
                            stack$iv$iv.add(node3);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv = $i$f$mutableVectorOf;
                            stack$iv$iv.add(node4);
                            count$iv$iv2 = count$iv$iv3;
                            i5 = 0;
                            i8 = i11;
                            i4 = includeSelf$iv;
                            i9 = i6;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv = node3;
                            i4 = includeSelf$iv;
                            i9 = i6;
                            type$iv = node3;
                            $i$f$visitAncestorsYYKmho = 0;
                            this_$iv$iv$iv = 1;
                        }
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        $i$f$getFocusTargetOLwlOKw = type$iv2;
                        includeSelf$iv = i4;
                        i6 = i9;
                        node3 = node$iv$iv$iv;
                        i7 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = $i$f$getFocusTargetOLwlOKw;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        type$iv = node3;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusTargetOLwlOKw = type$iv2;
                        includeSelf$iv = i4;
                        i6 = i9;
                        count$iv$iv3++;
                        type$iv2 = $i$f$getFocusTargetOLwlOKw;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv3;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        type$iv = node3;
                        count$iv$iv3 = count$iv$iv2;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv2 = count$iv$iv3;
                        i5 = 0;
                        i8 = i11;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node3;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        type$iv = node3;
                        $i$f$visitAncestorsYYKmho = 0;
                        this_$iv$iv$iv = 1;
                        $i$f$isKindH91voCI$ui_release = 1;
                        count$iv$iv3 = node$iv$iv;
                        $i$f$isKindH91voCI$ui_release = 0;
                        type$iv2 = $i$f$getFocusTargetOLwlOKw;
                        i4 = includeSelf$iv;
                        i9 = i6;
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    count$iv$iv3 = node$iv$iv;
                    i17 = 0;
                    node2 = count$iv$iv3;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv2;
                    includeSelf$iv = i4;
                    i6 = i9;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    node2 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i7 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = $i$f$getFocusTargetOLwlOKw;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        type$iv = node3;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusTargetOLwlOKw = type$iv2;
                        includeSelf$iv = i4;
                        i6 = i9;
                        count$iv$iv3++;
                        type$iv2 = $i$f$getFocusTargetOLwlOKw;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv3;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        type$iv = node3;
                        count$iv$iv3 = count$iv$iv2;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv2 = count$iv$iv3;
                        i5 = 0;
                        i8 = i11;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node3;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        type$iv = node3;
                        $i$f$visitAncestorsYYKmho = 0;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv2;
                    includeSelf$iv = i4;
                    i6 = i9;
                    node3 = node$iv$iv$iv;
                    i7 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    type$iv = node3;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusTargetOLwlOKw = type$iv2;
                    includeSelf$iv = i4;
                    i6 = i9;
                    count$iv$iv3++;
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv3;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    type$iv = node3;
                    count$iv$iv3 = count$iv$iv2;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv2 = count$iv$iv3;
                    i5 = 0;
                    i8 = i11;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node3;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    type$iv = node3;
                    $i$f$visitAncestorsYYKmho = 0;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    count$iv$iv3 = node$iv$iv;
                    $i$f$isKindH91voCI$ui_release = 0;
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv2 = $i$f$getFocusTargetOLwlOKw;
                i4 = includeSelf$iv;
                i9 = i6;
                node$iv$iv2 = 0;
                if (kindSet$ui_release &= i13 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv2 = $i$f$getFocusTargetOLwlOKw;
                i4 = includeSelf$iv;
                i9 = i6;
                node$iv$iv2 = 0;
                node$iv$iv3 = node$iv$iv3.getParent$ui_release();
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $i$f$getFocusTargetOLwlOKw = type$iv2;
                includeSelf$iv = i4;
                i6 = i9;
                i2 = 0;
                i3 = 0;
                stack$iv$iv = 0;
                i15 = 0;
                node$iv$iv = node$iv$iv4;
                node$iv$iv2 = 0;
                while (node$iv$iv != null) {
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    count$iv$iv3 = node$iv$iv;
                    i17 = 0;
                    node2 = count$iv$iv3;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    $i$f$isKindH91voCI$ui_release = 0;
                    if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv2;
                    includeSelf$iv = i4;
                    i6 = i9;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    node2 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i7 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = $i$f$getFocusTargetOLwlOKw;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        type$iv = node3;
                        $i$f$visitAncestorsYYKmho = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusTargetOLwlOKw = type$iv2;
                        includeSelf$iv = i4;
                        i6 = i9;
                        count$iv$iv3++;
                        type$iv2 = $i$f$getFocusTargetOLwlOKw;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv3;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        $i$f$visitAncestorsYYKmho = 0;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        type$iv = node3;
                        count$iv$iv3 = count$iv$iv2;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv2 = count$iv$iv3;
                        i5 = 0;
                        i8 = i11;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv = node3;
                        i4 = includeSelf$iv;
                        i9 = i6;
                        type$iv = node3;
                        $i$f$visitAncestorsYYKmho = 0;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    $i$f$getFocusTargetOLwlOKw = type$iv2;
                    includeSelf$iv = i4;
                    i6 = i9;
                    node3 = node$iv$iv$iv;
                    i7 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    type$iv = node3;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusTargetOLwlOKw = type$iv2;
                    includeSelf$iv = i4;
                    i6 = i9;
                    count$iv$iv3++;
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv3;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    type$iv = node3;
                    count$iv$iv3 = count$iv$iv2;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv2 = count$iv$iv3;
                    i5 = 0;
                    i8 = i11;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node3;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    type$iv = node3;
                    $i$f$visitAncestorsYYKmho = 0;
                    this_$iv$iv$iv = 1;
                    $i$f$isKindH91voCI$ui_release = 1;
                    count$iv$iv3 = node$iv$iv;
                    $i$f$isKindH91voCI$ui_release = 0;
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                type$iv2 = $i$f$getFocusTargetOLwlOKw;
                i4 = includeSelf$iv;
                i9 = i6;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                count$iv$iv3 = node$iv$iv;
                i17 = 0;
                node2 = count$iv$iv3;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                $i$f$isKindH91voCI$ui_release = 0;
                if ($i$f$isKindH91voCI$ui_release != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                type$iv2 = $i$f$getFocusTargetOLwlOKw;
                i4 = includeSelf$iv;
                i9 = i6;
                node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $i$f$getFocusTargetOLwlOKw = type$iv2;
                includeSelf$iv = i4;
                i6 = i9;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv3 = 0;
                node2 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i7 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    type$iv = node3;
                    $i$f$visitAncestorsYYKmho = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusTargetOLwlOKw = type$iv2;
                    includeSelf$iv = i4;
                    i6 = i9;
                    count$iv$iv3++;
                    type$iv2 = $i$f$getFocusTargetOLwlOKw;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv3;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    $i$f$visitAncestorsYYKmho = 0;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    type$iv = node3;
                    count$iv$iv3 = count$iv$iv2;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv2 = count$iv$iv3;
                    i5 = 0;
                    i8 = i11;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv = node3;
                    i4 = includeSelf$iv;
                    i9 = i6;
                    type$iv = node3;
                    $i$f$visitAncestorsYYKmho = 0;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv3 == 1) {
                } else {
                }
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                $i$f$getFocusTargetOLwlOKw = type$iv2;
                includeSelf$iv = i4;
                i6 = i9;
                node3 = node$iv$iv$iv;
                i7 = 0;
                count$iv$iv2 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                type$iv2 = $i$f$getFocusTargetOLwlOKw;
                i4 = includeSelf$iv;
                i9 = i6;
                type$iv = node3;
                $i$f$visitAncestorsYYKmho = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$getFocusTargetOLwlOKw = type$iv2;
                includeSelf$iv = i4;
                i6 = i9;
                count$iv$iv3++;
                type$iv2 = $i$f$getFocusTargetOLwlOKw;
                if (count$iv$iv3 == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                count$iv$iv2 = count$iv$iv3;
                i4 = includeSelf$iv;
                i9 = i6;
                $i$f$visitAncestorsYYKmho = 0;
                $i$f$mutableVectorOf = stack$iv$iv;
                stack$iv$iv = $i$f$mutableVectorOf;
                node4 = node$iv$iv;
                if (node4 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                type$iv = node3;
                count$iv$iv3 = count$iv$iv2;
                stack$iv$iv.add(node3);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv = $i$f$mutableVectorOf;
                stack$iv$iv.add(node4);
                count$iv$iv2 = count$iv$iv3;
                i5 = 0;
                i8 = i11;
                i4 = includeSelf$iv;
                i9 = i6;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv = node3;
                i4 = includeSelf$iv;
                i9 = i6;
                type$iv = node3;
                $i$f$visitAncestorsYYKmho = 0;
                this_$iv$iv$iv = 1;
                $i$f$isKindH91voCI$ui_release = 1;
                count$iv$iv3 = node$iv$iv;
                $i$f$isKindH91voCI$ui_release = 0;
                type$iv2 = $i$f$getFocusTargetOLwlOKw;
                i4 = includeSelf$iv;
                i9 = i6;
            }
            return null;
        }
        DelegatableNode delegatableNode2 = count$iv$iv;
        int i18 = $i$f$getFocusTargetOLwlOKw;
        int $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }

    public static final Rect focusRect(androidx.compose.ui.focus.FocusTargetNode $this$focusRect) {
        Rect it;
        int i2;
        LayoutCoordinates rootCoordinates;
        NodeCoordinator nodeCoordinator;
        int i;
        it = $this$focusRect.getCoordinator$ui_release();
        if (it != null) {
            i2 = 0;
            if (LayoutCoordinatesKt.findRootCoordinates((LayoutCoordinates)it).localBoundingBoxOf((LayoutCoordinates)it, false) == null) {
                it = Rect.Companion.getZero();
            }
        } else {
        }
        return it;
    }

    public static final Boolean focusSearch-0X8WOeE(androidx.compose.ui.focus.FocusTargetNode $this$focusSearch_u2d0X8WOeE, int focusDirection, LayoutDirection layoutDirection, Rect previouslyFocusedRect, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        boolean equals-impl0;
        int equals-impl02;
        int down-dhqQ-8s;
        int right-dhqQ-8s;
        Boolean direction;
        int nonDeactivatedParent;
        boolean activeFocusNode;
        nonDeactivatedParent = 1;
        if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getNext-dhqQ-8s())) {
            equals-impl0 = nonDeactivatedParent;
        } else {
            equals-impl0 = FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getPrevious-dhqQ-8s());
        }
        if (equals-impl0) {
            direction = Boolean.valueOf(OneDimensionalFocusSearchKt.oneDimensionalFocusSearch--OM-vw8($this$focusSearch_u2d0X8WOeE, focusDirection, onFound));
            return direction;
        } else {
            if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getLeft-dhqQ-8s())) {
                equals-impl02 = nonDeactivatedParent;
            } else {
                equals-impl02 = FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getRight-dhqQ-8s());
            }
            if (equals-impl02 != 0) {
                down-dhqQ-8s = nonDeactivatedParent;
            } else {
                down-dhqQ-8s = FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getUp-dhqQ-8s());
            }
            if (down-dhqQ-8s != 0) {
            } else {
                nonDeactivatedParent = FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getDown-dhqQ-8s());
            }
            if (nonDeactivatedParent != 0) {
                direction = TwoDimensionalFocusSearchKt.twoDimensionalFocusSearch-sMXa3k8($this$focusSearch_u2d0X8WOeE, focusDirection, previouslyFocusedRect, onFound);
            } else {
                if (FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getEnter-dhqQ-8s())) {
                    switch (i2) {
                        case 1:
                            right-dhqQ-8s = FocusDirection.Companion.getRight-dhqQ-8s();
                            break;
                        case 2:
                            right-dhqQ-8s = FocusDirection.Companion.getLeft-dhqQ-8s();
                            break;
                        default:
                            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException;
                    }
                    activeFocusNode = FocusTraversalKt.findActiveFocusNode($this$focusSearch_u2d0X8WOeE);
                    if (activeFocusNode != null) {
                        direction = nonDeactivatedParent;
                    } else {
                        direction = nonDeactivatedParent;
                    }
                }
                if (!FocusDirection.equals-impl0(focusDirection, FocusDirection.Companion.getExit-dhqQ-8s())) {
                } else {
                    androidx.compose.ui.focus.FocusTargetNode activeFocusNode2 = FocusTraversalKt.findActiveFocusNode($this$focusSearch_u2d0X8WOeE);
                    if (activeFocusNode2 != null) {
                        nonDeactivatedParent = FocusTraversalKt.findNonDeactivatedParent(activeFocusNode2);
                    }
                    int i = 0;
                    if (nonDeactivatedParent != 0) {
                        if (Intrinsics.areEqual(nonDeactivatedParent, $this$focusSearch_u2d0X8WOeE)) {
                            activeFocusNode = 0;
                        } else {
                            activeFocusNode = (Boolean)onFound.invoke(nonDeactivatedParent).booleanValue();
                        }
                    } else {
                    }
                    direction = Boolean.valueOf(activeFocusNode);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Focus search invoked with invalid FocusDirection ").append(FocusDirection.toString-impl(focusDirection)).toString().toString());
        throw illegalStateException;
    }

    public static final androidx.compose.ui.focus.FocusTargetNode getActiveChild(androidx.compose.ui.focus.FocusTargetNode $this$activeChild) {
        int $this$visitChildren_u2d6rFNWt0$iv3;
        int $this$visitChildren_u2d6rFNWt0$iv;
        int i7;
        Object node$iv$iv4;
        int $i$f$getFocusTargetOLwlOKw;
        int type$iv;
        int type$iv2;
        int node;
        int node$iv$iv2;
        Modifier.Node[] arr;
        int count$iv$iv;
        int count$iv$iv2;
        int i;
        Modifier.Node next$iv$iv;
        int i2;
        Object obj3;
        int i3;
        int i9;
        int node$iv$iv;
        Object obj2;
        int attached;
        int[] node$iv$iv$iv;
        Modifier.Node node2;
        int i5;
        int this_$iv$iv$iv;
        int i6;
        int i4;
        int $this$visitChildren_u2d6rFNWt0$iv2;
        Object node$iv$iv3;
        int i8;
        Object obj;
        if (!$this$activeChild.getNode().isAttached()) {
            return null;
        }
        $this$visitChildren_u2d6rFNWt0$iv3 = $this$activeChild;
        int i10 = 0;
        int i12 = 0;
        final int i13 = $i$f$getFocusTargetOLwlOKw;
        final int i14 = $this$visitChildren_u2d6rFNWt0$iv3;
        final int i15 = 0;
        if (!i14.getNode().isAttached()) {
        } else {
            int i16 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = i14.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i14.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i17 = 0;
                i = 1;
                node = mutableVector2.removeAt(size -= i);
                if (aggregateChildKindSet$ui_release &= i13 == 0) {
                } else {
                }
                node$iv$iv2 = node;
                while (node$iv$iv2 != null) {
                    node$iv$iv = i7;
                    int type$iv4 = count$iv$iv;
                    int $this$visitChildren_u2d6rFNWt0$iv5 = i;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                    $i$f$getFocusTargetOLwlOKw = i8;
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                node$iv$iv = i7;
                int type$iv5 = count$iv$iv;
                $i$f$getFocusTargetOLwlOKw = i8;
                if (kindSet$ui_release &= i13 != 0) {
                } else {
                }
                node$iv$iv = i7;
                type$iv4 = count$iv$iv;
                $this$visitChildren_u2d6rFNWt0$iv5 = i;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                $i$f$getFocusTargetOLwlOKw = i8;
                i2 = 0;
                i3 = 0;
                i9 = 0;
                int i19 = 0;
                node$iv$iv4 = obj;
                while (node$iv$iv4 != null) {
                    obj2 = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    if (count$iv$iv2 != 0 && node$iv$iv4 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv = i;
                    type$iv2 = 0;
                    node$iv$iv4 = DelegatableNodeKt.access$pop(i9);
                    i = $this$visitChildren_u2d6rFNWt0$iv;
                    count$iv$iv = type$iv2;
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                    $i$f$getFocusTargetOLwlOKw = i8;
                    if (node$iv$iv4 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv2 = 0;
                    attached = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i5 = 0;
                        i6 = 0;
                        if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                        node$iv$iv3 = node$iv$iv4;
                        i8 = $i$f$getFocusTargetOLwlOKw;
                        next$iv$iv = node2;
                        type$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                        $i$f$getFocusTargetOLwlOKw = i8;
                        i = 1;
                        if (count$iv$iv2++ == i) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                        node$iv$iv3 = node$iv$iv4;
                        i8 = $i$f$getFocusTargetOLwlOKw;
                        type$iv = 0;
                        $this$visitChildren_u2d6rFNWt0$iv3 = i9;
                        Object obj5 = node$iv$iv3;
                        if (obj5 != null && $this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                        }
                        if ($this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                        } else {
                        }
                        next$iv$iv = node2;
                        i9 = $this$visitChildren_u2d6rFNWt0$iv3;
                        node$iv$iv4 = node$iv$iv3;
                        $this$visitChildren_u2d6rFNWt0$iv3.add(node2);
                        if ($this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                        }
                        node$iv$iv3 = i;
                        $this$visitChildren_u2d6rFNWt0$iv3.add(obj5);
                        this_$iv$iv$iv = 0;
                        i4 = 0;
                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                        node$iv$iv3 = node$iv$iv4;
                        i8 = $i$f$getFocusTargetOLwlOKw;
                        $this$visitChildren_u2d6rFNWt0$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv4 = node2;
                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                        i8 = $i$f$getFocusTargetOLwlOKw;
                        next$iv$iv = node2;
                        type$iv = 0;
                        this_$iv$iv$iv = i;
                    }
                    node$iv$iv3 = node$iv$iv4;
                    $this$visitChildren_u2d6rFNWt0$iv = 1;
                    if (count$iv$iv2 == $this$visitChildren_u2d6rFNWt0$iv) {
                    } else {
                    }
                    node$iv$iv4 = node$iv$iv3;
                    i = $this$visitChildren_u2d6rFNWt0$iv;
                    count$iv$iv = type$iv2;
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                    node$iv$iv4 = node$iv$iv3;
                    $i$f$getFocusTargetOLwlOKw = i8;
                    node2 = node$iv$iv$iv;
                    i5 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    node$iv$iv3 = node$iv$iv4;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    next$iv$iv = node2;
                    type$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                    $i$f$getFocusTargetOLwlOKw = i8;
                    i = 1;
                    if (count$iv$iv2++ == i) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    node$iv$iv3 = node$iv$iv4;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    type$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv3 = i9;
                    obj5 = node$iv$iv3;
                    if (obj5 != null && $this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i9 = $this$visitChildren_u2d6rFNWt0$iv3;
                    node$iv$iv4 = node$iv$iv3;
                    $this$visitChildren_u2d6rFNWt0$iv3.add(node2);
                    if ($this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                    }
                    node$iv$iv3 = i;
                    $this$visitChildren_u2d6rFNWt0$iv3.add(obj5);
                    this_$iv$iv$iv = 0;
                    i4 = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    node$iv$iv3 = node$iv$iv4;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv4 = node2;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    next$iv$iv = node2;
                    type$iv = 0;
                    this_$iv$iv$iv = i;
                    count$iv$iv2 = i;
                    count$iv$iv2 = node$iv$iv4;
                    obj2 = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv = i;
                    type$iv2 = 0;
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                int type$iv3 = count$iv$iv;
                i7 = node$iv$iv;
                $i$f$getFocusTargetOLwlOKw = i8;
                obj2 = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                count$iv$iv2 = 0;
                if (count$iv$iv2 != 0 && node$iv$iv4 instanceof DelegatingNode) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                i8 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv = i;
                type$iv2 = 0;
                node$iv$iv4 = DelegatableNodeKt.access$pop(i9);
                i = $this$visitChildren_u2d6rFNWt0$iv;
                count$iv$iv = type$iv2;
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                $i$f$getFocusTargetOLwlOKw = i8;
                if (node$iv$iv4 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv2 = 0;
                attached = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv4.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i5 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    node$iv$iv3 = node$iv$iv4;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    next$iv$iv = node2;
                    type$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                    $i$f$getFocusTargetOLwlOKw = i8;
                    i = 1;
                    if (count$iv$iv2++ == i) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    node$iv$iv3 = node$iv$iv4;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    type$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv3 = i9;
                    obj5 = node$iv$iv3;
                    if (obj5 != null && $this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                    }
                    if ($this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                    } else {
                    }
                    next$iv$iv = node2;
                    i9 = $this$visitChildren_u2d6rFNWt0$iv3;
                    node$iv$iv4 = node$iv$iv3;
                    $this$visitChildren_u2d6rFNWt0$iv3.add(node2);
                    if ($this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                    }
                    node$iv$iv3 = i;
                    $this$visitChildren_u2d6rFNWt0$iv3.add(obj5);
                    this_$iv$iv$iv = 0;
                    i4 = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    node$iv$iv3 = node$iv$iv4;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    $this$visitChildren_u2d6rFNWt0$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv4 = node2;
                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                    i8 = $i$f$getFocusTargetOLwlOKw;
                    next$iv$iv = node2;
                    type$iv = 0;
                    this_$iv$iv$iv = i;
                }
                node$iv$iv3 = node$iv$iv4;
                $this$visitChildren_u2d6rFNWt0$iv = 1;
                if (count$iv$iv2 == $this$visitChildren_u2d6rFNWt0$iv) {
                } else {
                }
                node$iv$iv4 = node$iv$iv3;
                i = $this$visitChildren_u2d6rFNWt0$iv;
                count$iv$iv = type$iv2;
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                node$iv$iv4 = node$iv$iv3;
                $i$f$getFocusTargetOLwlOKw = i8;
                node2 = node$iv$iv$iv;
                i5 = 0;
                i6 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                node$iv$iv3 = node$iv$iv4;
                i8 = $i$f$getFocusTargetOLwlOKw;
                next$iv$iv = node2;
                type$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                $i$f$getFocusTargetOLwlOKw = i8;
                i = 1;
                if (count$iv$iv2++ == i) {
                } else {
                }
                if (i9 == 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                node$iv$iv3 = node$iv$iv4;
                i8 = $i$f$getFocusTargetOLwlOKw;
                type$iv = 0;
                $this$visitChildren_u2d6rFNWt0$iv3 = i9;
                obj5 = node$iv$iv3;
                if (obj5 != null && $this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                }
                if ($this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                } else {
                }
                next$iv$iv = node2;
                i9 = $this$visitChildren_u2d6rFNWt0$iv3;
                node$iv$iv4 = node$iv$iv3;
                $this$visitChildren_u2d6rFNWt0$iv3.add(node2);
                if ($this$visitChildren_u2d6rFNWt0$iv3 != 0) {
                }
                node$iv$iv3 = i;
                $this$visitChildren_u2d6rFNWt0$iv3.add(obj5);
                this_$iv$iv$iv = 0;
                i4 = 0;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                node$iv$iv3 = node$iv$iv4;
                i8 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv3 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv4 = node2;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                i8 = $i$f$getFocusTargetOLwlOKw;
                next$iv$iv = node2;
                type$iv = 0;
                this_$iv$iv$iv = i;
                count$iv$iv2 = i;
                count$iv$iv2 = node$iv$iv4;
                obj2 = 0;
                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                i8 = $i$f$getFocusTargetOLwlOKw;
                $this$visitChildren_u2d6rFNWt0$iv = i;
                type$iv2 = 0;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
            return i7;
        }
        int i20 = $this$visitChildren_u2d6rFNWt0$iv3;
        int $this$visitChildren_u2d6rFNWt0$iv4 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final boolean isEligibleForFocusSearch(androidx.compose.ui.focus.FocusTargetNode $this$isEligibleForFocusSearch) {
        NodeCoordinator coordinator$ui_release;
        int i2;
        NodeCoordinator coordinator$ui_release2;
        int i;
        coordinator$ui_release = $this$isEligibleForFocusSearch.getCoordinator$ui_release();
        i = 1;
        final int i3 = 0;
        coordinator$ui_release = coordinator$ui_release.getLayoutNode();
        if (coordinator$ui_release != null && coordinator$ui_release != null && coordinator$ui_release.isPlaced() == i) {
            coordinator$ui_release = coordinator$ui_release.getLayoutNode();
            if (coordinator$ui_release != null) {
                i2 = coordinator$ui_release.isPlaced() == i ? i : i3;
            } else {
            }
        } else {
        }
        if (i2 != 0) {
            coordinator$ui_release2 = $this$isEligibleForFocusSearch.getCoordinator$ui_release();
            coordinator$ui_release2 = coordinator$ui_release2.getLayoutNode();
            if (coordinator$ui_release2 != null && coordinator$ui_release2 != null && coordinator$ui_release2.isAttached() == i) {
                coordinator$ui_release2 = coordinator$ui_release2.getLayoutNode();
                if (coordinator$ui_release2 != null) {
                    i2 = coordinator$ui_release2.isAttached() == i ? i : i3;
                } else {
                }
            } else {
            }
            if (i2 != 0) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }
}
