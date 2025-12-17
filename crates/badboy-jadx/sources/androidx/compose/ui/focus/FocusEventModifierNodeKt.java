package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u000c\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\u000c\u0010\u0005\u001a\u00020\u0004*\u00020\u0006H\u0000¨\u0006\u0007", d2 = {"getFocusState", "Landroidx/compose/ui/focus/FocusState;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "invalidateFocusEvent", "", "refreshFocusEventNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusEventModifierNodeKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal2;
            int ordinal4;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            FocusEventModifierNodeKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final androidx.compose.ui.focus.FocusState getFocusState(androidx.compose.ui.focus.FocusEventModifierNode $this$getFocusState) {
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int mask$iv$iv3;
        int mask$iv$iv;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int $i$f$getFocusTargetOLwlOKw;
        int i3;
        int $this$visitChildren$iv$iv;
        int $i$f$visitSelfAndChildren6rFNWt0;
        Modifier.Node next$iv$iv;
        int stack$iv$iv2;
        int node;
        Modifier.Node node$iv$iv;
        int node$iv$iv3;
        Modifier.Node node2;
        int i12;
        int i;
        androidx.compose.ui.focus.FocusStateImpl count$iv$iv;
        Modifier.Node[] arr;
        int i8;
        int ordinal;
        Modifier.Node node$iv$iv$iv2;
        Modifier.Node stack$iv$iv;
        int node$iv$iv2;
        int this_$iv$iv$iv;
        int i9;
        int i6;
        Modifier.Node $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int i2;
        int focusState;
        int node$iv$iv$iv;
        int ordinal2;
        int i4;
        int this_$iv$iv$iv2;
        int mask$iv$iv2;
        int i10;
        int i5;
        int i11;
        int i7;
        int i13 = 0;
        $i$f$getFocusTargetOLwlOKw = NodeKind.constructor-impl(1024);
        $i$f$visitSelfAndChildren6rFNWt0 = 0;
        int i16 = 0;
        stack$iv$iv2 = 0;
        int i18 = 0;
        node$iv$iv = node3;
        node2 = 0;
        while (node$iv$iv != null) {
            i8 = 0;
            if (kindSet$ui_release2 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            count$iv$iv = node2;
            if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv2);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i2;
            node2 = 0;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv = 0;
            ordinal = 0;
            node$iv$iv$iv2 = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv2 != null) {
                stack$iv$iv = node$iv$iv$iv2;
                node$iv$iv2 = 0;
                i9 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = node2;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = $i$f$getFocusTargetOLwlOKw;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                $i$f$getFocusTargetOLwlOKw = i2;
                i = 1;
                if (count$iv$iv++ == i) {
                } else {
                }
                if (stack$iv$iv2 == 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = stack$iv$iv2;
                stack$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = node$iv$iv;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv != null && stack$iv$iv2 != 0) {
                }
                if (stack$iv$iv2 != 0) {
                }
                stack$iv$iv2.add(stack$iv$iv);
                if (stack$iv$iv2 != 0) {
                }
                node$iv$iv = $i$f$getFocusTargetOLwlOKw;
                stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv);
                this_$iv$iv$iv = 0;
                i6 = 0;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = $i$f$getFocusTargetOLwlOKw;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], node2);
                node$iv$iv = stack$iv$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = $i$f$getFocusTargetOLwlOKw;
                this_$iv$iv$iv = i;
            }
            if (count$iv$iv == 1) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i2;
            stack$iv$iv = node$iv$iv$iv2;
            node$iv$iv2 = 0;
            i9 = 0;
            if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
            } else {
            }
            this_$iv$iv$iv = node2;
            if (this_$iv$iv$iv != 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            $i$f$getFocusTargetOLwlOKw = i2;
            i = 1;
            if (count$iv$iv++ == i) {
            } else {
            }
            if (stack$iv$iv2 == 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = stack$iv$iv2;
            stack$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv = node$iv$iv;
            if ($this$visitSelfAndChildren_u2d6rFNWt0$iv != null && stack$iv$iv2 != 0) {
            }
            if (stack$iv$iv2 != 0) {
            }
            stack$iv$iv2.add(stack$iv$iv);
            if (stack$iv$iv2 != 0) {
            }
            node$iv$iv = $i$f$getFocusTargetOLwlOKw;
            stack$iv$iv2.add($this$visitSelfAndChildren_u2d6rFNWt0$iv);
            this_$iv$iv$iv = 0;
            i6 = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = new MutableVector(new Modifier.Node[16], node2);
            node$iv$iv = stack$iv$iv;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
            this_$iv$iv$iv = i;
            count$iv$iv = i;
            i = 0;
            count$iv$iv = (FocusTargetNode)node$iv$iv.getFocusState();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            i2 = $i$f$getFocusTargetOLwlOKw;
        }
        int i24 = $i$f$getFocusTargetOLwlOKw;
        i3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv5;
        int i15 = 0;
        if (!i3.getNode().isAttached()) {
        } else {
            int i17 = 0;
            node$iv$iv3 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], node2);
            Modifier.Node child$ui_release = i3.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i3.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i19 = 0;
                i9 = 1;
                node = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv4 == 0) {
                } else {
                }
                node$iv$iv3 = node;
                while (node$iv$iv3 != null) {
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    int i21 = 1;
                    node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                    node2 = mask$iv$iv5;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                }
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                int i20 = 1;
                node2 = mask$iv$iv4;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                if (kindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv4 != 0) {
                } else {
                }
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                i21 = 1;
                node$iv$iv3 = node$iv$iv3.getChild$ui_release();
                node2 = mask$iv$iv5;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i8 = 0;
                node$iv$iv$iv2 = 0;
                stack$iv$iv = 0;
                int i23 = 0;
                node$iv$iv2 = ordinal;
                while (node$iv$iv2 != null) {
                    i6 = 0;
                    if (kindSet$ui_release4 &= i24 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = node2;
                    if (this_$iv$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = node2;
                    i12 = 1;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    node2 = mask$iv$iv;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i3 = i5;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    focusState = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        ordinal2 = node$iv$iv$iv;
                        i4 = 0;
                        int i25 = 0;
                        if (kindSet$ui_release5 &= i24 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = node2;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                        i5 = i3;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        mask$iv$iv3 = node2;
                        next$iv$iv = ordinal2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        node2 = mask$iv$iv3;
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                        i3 = i5;
                        $i$f$visitSelfAndChildren6rFNWt0 = i11;
                        if (this_$iv$iv$iv++ == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                        i5 = i3;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        mask$iv$iv3 = 0;
                        $this$visitChildren$iv$iv = stack$iv$iv;
                        stack$iv$iv = $this$visitChildren$iv$iv;
                        i3 = node$iv$iv2;
                        if (i3 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        next$iv$iv = ordinal2;
                        stack$iv$iv.add(ordinal2);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                        stack$iv$iv.add(i3);
                        node2 = 0;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                        int mask$iv$iv6 = 16;
                        i10 = 0;
                        i5 = i3;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        i7 = mask$iv$iv6;
                        $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                        node$iv$iv2 = ordinal2;
                        mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                        i5 = i3;
                        i11 = $i$f$visitSelfAndChildren6rFNWt0;
                        next$iv$iv = ordinal2;
                        mask$iv$iv3 = 0;
                        this_$iv$iv$iv2 = 1;
                    }
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    node2 = mask$iv$iv;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i3 = i5;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    ordinal2 = node$iv$iv$iv;
                    i4 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i24 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = node2;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv3 = node2;
                    next$iv$iv = ordinal2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node2 = mask$iv$iv3;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i3 = i5;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    if (this_$iv$iv$iv++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv3 = 0;
                    $this$visitChildren$iv$iv = stack$iv$iv;
                    stack$iv$iv = $this$visitChildren$iv$iv;
                    i3 = node$iv$iv2;
                    if (i3 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = ordinal2;
                    stack$iv$iv.add(ordinal2);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                    stack$iv$iv.add(i3);
                    node2 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    mask$iv$iv6 = 16;
                    i10 = 0;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    i7 = mask$iv$iv6;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                    node$iv$iv2 = ordinal2;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    next$iv$iv = ordinal2;
                    mask$iv$iv3 = 0;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    i6 = 0;
                    focusState = (FocusTargetNode)node$iv$iv2.getFocusState();
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv = node2;
                    i12 = 1;
                }
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                int i22 = 1;
                node2 = mask$iv$iv7;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i6 = 0;
                if (kindSet$ui_release4 &= i24 != 0) {
                } else {
                }
                this_$iv$iv$iv = node2;
                if (this_$iv$iv$iv != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = node2;
                i12 = 1;
                node$iv$iv2 = DelegatableNodeKt.access$pop(stack$iv$iv);
                node2 = mask$iv$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i3 = i5;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv = 0;
                focusState = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    ordinal2 = node$iv$iv$iv;
                    i4 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i24 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = node2;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv3 = node2;
                    next$iv$iv = ordinal2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node2 = mask$iv$iv3;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                    i3 = i5;
                    $i$f$visitSelfAndChildren6rFNWt0 = i11;
                    if (this_$iv$iv$iv++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    mask$iv$iv3 = 0;
                    $this$visitChildren$iv$iv = stack$iv$iv;
                    stack$iv$iv = $this$visitChildren$iv$iv;
                    i3 = node$iv$iv2;
                    if (i3 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    next$iv$iv = ordinal2;
                    stack$iv$iv.add(ordinal2);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                    stack$iv$iv.add(i3);
                    node2 = 0;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    mask$iv$iv6 = 16;
                    i10 = 0;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    i7 = mask$iv$iv6;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                    node$iv$iv2 = ordinal2;
                    mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                    i5 = i3;
                    i11 = $i$f$visitSelfAndChildren6rFNWt0;
                    next$iv$iv = ordinal2;
                    mask$iv$iv3 = 0;
                    this_$iv$iv$iv2 = 1;
                }
                if (this_$iv$iv$iv == 1) {
                } else {
                }
                node2 = mask$iv$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i3 = i5;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                ordinal2 = node$iv$iv$iv;
                i4 = 0;
                i25 = 0;
                if (kindSet$ui_release5 &= i24 != 0) {
                } else {
                }
                this_$iv$iv$iv2 = node2;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv3 = node2;
                next$iv$iv = ordinal2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                node2 = mask$iv$iv3;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = mask$iv$iv2;
                i3 = i5;
                $i$f$visitSelfAndChildren6rFNWt0 = i11;
                if (this_$iv$iv$iv++ == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv3 = 0;
                $this$visitChildren$iv$iv = stack$iv$iv;
                stack$iv$iv = $this$visitChildren$iv$iv;
                i3 = node$iv$iv2;
                if (i3 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                next$iv$iv = ordinal2;
                stack$iv$iv.add(ordinal2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv2 = $i$f$visitSelfAndChildren6rFNWt0;
                stack$iv$iv.add(i3);
                node2 = 0;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                mask$iv$iv6 = 16;
                i10 = 0;
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                i7 = mask$iv$iv6;
                $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                node$iv$iv2 = ordinal2;
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                next$iv$iv = ordinal2;
                mask$iv$iv3 = 0;
                this_$iv$iv$iv2 = 1;
                this_$iv$iv$iv = 1;
                i6 = 0;
                focusState = (FocusTargetNode)node$iv$iv2.getFocusState();
                mask$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                i5 = i3;
                i11 = $i$f$visitSelfAndChildren6rFNWt0;
                mask$iv$iv = node2;
                i12 = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
            int mask$iv$iv9 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            return (FocusState)FocusStateImpl.Inactive;
        }
        int i26 = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int i27 = i3;
        int mask$iv$iv8 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitChildren$1$iv$iv;
    }

    public static final void invalidateFocusEvent(androidx.compose.ui.focus.FocusEventModifierNode $this$invalidateFocusEvent) {
        DelegatableNodeKt.requireOwner((DelegatableNode)$this$invalidateFocusEvent).getFocusOwner().scheduleInvalidation($this$invalidateFocusEvent);
    }

    public static final void refreshFocusEventNodes(androidx.compose.ui.focus.FocusTargetNode $this$refreshFocusEventNodes) {
        DelegatableNode count$iv$iv2;
        int tail$ui_release;
        androidx.compose.ui.focus.FocusState count$iv$iv;
        int $i$f$getFocusEventOLwlOKw;
        int type$iv;
        int $i$f$getFocusTargetOLwlOKw;
        Modifier.Node untilType$iv;
        int i8;
        int $i$f$visitSelfAndAncestors5BbP62I2;
        int $i$f$visitSelfAndAncestors5BbP62I;
        Modifier.Node node$iv$iv;
        LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i2;
        int i7;
        Modifier.Node node$iv$iv3;
        Modifier.Node node;
        int this_$iv$iv;
        int i3;
        int i6;
        Modifier.Node node$iv$iv2;
        int i11;
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i5;
        int type$iv2;
        int this_$iv$iv$iv;
        int count$iv$iv3;
        int i9;
        int i4;
        int i10;
        int i;
        count$iv$iv2 = $this$refreshFocusEventNodes;
        int i12 = 0;
        $i$f$getFocusEventOLwlOKw = NodeKind.constructor-impl(4096);
        int i15 = 0;
        i8 = 0;
        final int i17 = $i$f$getFocusEventOLwlOKw | $i$f$getFocusTargetOLwlOKw;
        final int i18 = 1;
        final DelegatableNode delegatableNode = count$iv$iv2;
        final int i19 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode.getNode();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i17 == 0) {
                    break;
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                count$iv$iv2 = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && count$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv = tail$ui_release;
                count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                $i$f$getFocusEventOLwlOKw = type$iv2;
                $i$f$getFocusTargetOLwlOKw = i10;
                i8 = i;
                count$iv$iv2 = layout$iv$iv.getNodes$ui_release();
                if (count$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = count$iv$iv2.getTail$ui_release();
                while (node$iv$iv != null) {
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    $i$f$getFocusEventOLwlOKw = type$iv2;
                    $i$f$getFocusTargetOLwlOKw = i10;
                    i8 = i;
                    i2 = node$iv$iv;
                    i7 = 0;
                    i3 = 0;
                    if (kindSet$ui_release2 &= $i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    i3 = 0;
                    i6 = 0;
                    int i20 = 0;
                    node$iv$iv3 = node$iv$iv2;
                    while (node$iv$iv3 != null) {
                        if (node$iv$iv3 instanceof FocusEventModifierNode) {
                        } else {
                        }
                        node = 0;
                        if (kindSet$ui_release4 &= $i$f$getFocusEventOLwlOKw != 0) {
                        } else {
                        }
                        count$iv$iv = 0;
                        if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        type$iv2 = $i$f$getFocusEventOLwlOKw;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        type$iv = 1;
                        $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                        node$iv$iv3 = DelegatableNodeKt.access$pop(i6);
                        count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                        $i$f$getFocusEventOLwlOKw = type$iv2;
                        $i$f$getFocusTargetOLwlOKw = i10;
                        i8 = i;
                        if (node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv = 0;
                        i11 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i5 = 0;
                            count$iv$iv3 = 0;
                            if (kindSet$ui_release5 &= $i$f$getFocusEventOLwlOKw != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            type$iv2 = $i$f$getFocusEventOLwlOKw;
                            i10 = $i$f$getFocusTargetOLwlOKw;
                            i = i8;
                            untilType$iv = node2;
                            $i$f$visitSelfAndAncestors5BbP62I = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            $i$f$getFocusEventOLwlOKw = type$iv2;
                            $i$f$getFocusTargetOLwlOKw = i10;
                            i8 = i;
                            count$iv$iv++;
                            type$iv2 = $i$f$getFocusEventOLwlOKw;
                            if (count$iv$iv == 1) {
                            } else {
                            }
                            if (i6 == 0) {
                            } else {
                            }
                            count$iv$iv3 = count$iv$iv;
                            i10 = $i$f$getFocusTargetOLwlOKw;
                            i = i8;
                            $i$f$visitSelfAndAncestors5BbP62I = 0;
                            $i$f$getFocusEventOLwlOKw = i6;
                            Modifier.Node node3 = node$iv$iv3;
                            if (node3 != null && $i$f$getFocusEventOLwlOKw != 0) {
                            }
                            if ($i$f$getFocusEventOLwlOKw != 0) {
                            } else {
                            }
                            untilType$iv = node2;
                            i6 = $i$f$getFocusEventOLwlOKw;
                            count$iv$iv = count$iv$iv3;
                            $i$f$getFocusEventOLwlOKw.add(node2);
                            if ($i$f$getFocusEventOLwlOKw != 0) {
                            }
                            node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                            $i$f$getFocusEventOLwlOKw.add(node3);
                            count$iv$iv3 = count$iv$iv;
                            i9 = 0;
                            i4 = i13;
                            i10 = $i$f$getFocusTargetOLwlOKw;
                            i = i8;
                            $i$f$getFocusEventOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv3 = node2;
                            i10 = $i$f$getFocusTargetOLwlOKw;
                            i = i8;
                            untilType$iv = node2;
                            $i$f$visitSelfAndAncestors5BbP62I = 0;
                            this_$iv$iv$iv = 1;
                        }
                        $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                        $i$f$getFocusEventOLwlOKw = type$iv2;
                        $i$f$getFocusTargetOLwlOKw = i10;
                        i8 = i;
                        node2 = node$iv$iv$iv;
                        i5 = 0;
                        count$iv$iv3 = 0;
                        if (kindSet$ui_release5 &= $i$f$getFocusEventOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = $i$f$getFocusEventOLwlOKw;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        untilType$iv = node2;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusEventOLwlOKw = type$iv2;
                        $i$f$getFocusTargetOLwlOKw = i10;
                        i8 = i;
                        count$iv$iv++;
                        type$iv2 = $i$f$getFocusEventOLwlOKw;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i6 == 0) {
                        } else {
                        }
                        count$iv$iv3 = count$iv$iv;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        $i$f$getFocusEventOLwlOKw = i6;
                        node3 = node$iv$iv3;
                        if (node3 != null && $i$f$getFocusEventOLwlOKw != 0) {
                        }
                        if ($i$f$getFocusEventOLwlOKw != 0) {
                        } else {
                        }
                        untilType$iv = node2;
                        i6 = $i$f$getFocusEventOLwlOKw;
                        count$iv$iv = count$iv$iv3;
                        $i$f$getFocusEventOLwlOKw.add(node2);
                        if ($i$f$getFocusEventOLwlOKw != 0) {
                        }
                        node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                        $i$f$getFocusEventOLwlOKw.add(node3);
                        count$iv$iv3 = count$iv$iv;
                        i9 = 0;
                        i4 = i13;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        $i$f$getFocusEventOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv3 = node2;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        untilType$iv = node2;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        this_$iv$iv$iv = 1;
                        count$iv$iv = 1;
                        node = node$iv$iv3;
                        i11 = 0;
                        $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                        node.onFocusEvent(FocusEventModifierNodeKt.getFocusState((FocusEventModifierNode)node));
                        type$iv2 = $i$f$getFocusEventOLwlOKw;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        type$iv = 1;
                        $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                    }
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    if (node$iv$iv3 instanceof FocusEventModifierNode) {
                    } else {
                    }
                    node = 0;
                    if (kindSet$ui_release4 &= $i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    type$iv = 1;
                    $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i6);
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    $i$f$getFocusEventOLwlOKw = type$iv2;
                    $i$f$getFocusTargetOLwlOKw = i10;
                    i8 = i;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i11 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i5 = 0;
                        count$iv$iv3 = 0;
                        if (kindSet$ui_release5 &= $i$f$getFocusEventOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = $i$f$getFocusEventOLwlOKw;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        untilType$iv = node2;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusEventOLwlOKw = type$iv2;
                        $i$f$getFocusTargetOLwlOKw = i10;
                        i8 = i;
                        count$iv$iv++;
                        type$iv2 = $i$f$getFocusEventOLwlOKw;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i6 == 0) {
                        } else {
                        }
                        count$iv$iv3 = count$iv$iv;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        $i$f$getFocusEventOLwlOKw = i6;
                        node3 = node$iv$iv3;
                        if (node3 != null && $i$f$getFocusEventOLwlOKw != 0) {
                        }
                        if ($i$f$getFocusEventOLwlOKw != 0) {
                        } else {
                        }
                        untilType$iv = node2;
                        i6 = $i$f$getFocusEventOLwlOKw;
                        count$iv$iv = count$iv$iv3;
                        $i$f$getFocusEventOLwlOKw.add(node2);
                        if ($i$f$getFocusEventOLwlOKw != 0) {
                        }
                        node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                        $i$f$getFocusEventOLwlOKw.add(node3);
                        count$iv$iv3 = count$iv$iv;
                        i9 = 0;
                        i4 = i13;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        $i$f$getFocusEventOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv3 = node2;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        untilType$iv = node2;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        this_$iv$iv$iv = 1;
                    }
                    $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    $i$f$getFocusEventOLwlOKw = type$iv2;
                    $i$f$getFocusTargetOLwlOKw = i10;
                    i8 = i;
                    node2 = node$iv$iv$iv;
                    i5 = 0;
                    count$iv$iv3 = 0;
                    if (kindSet$ui_release5 &= $i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    untilType$iv = node2;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusEventOLwlOKw = type$iv2;
                    $i$f$getFocusTargetOLwlOKw = i10;
                    i8 = i;
                    count$iv$iv++;
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i6 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    $i$f$getFocusEventOLwlOKw = i6;
                    node3 = node$iv$iv3;
                    if (node3 != null && $i$f$getFocusEventOLwlOKw != 0) {
                    }
                    if ($i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    untilType$iv = node2;
                    i6 = $i$f$getFocusEventOLwlOKw;
                    count$iv$iv = count$iv$iv3;
                    $i$f$getFocusEventOLwlOKw.add(node2);
                    if ($i$f$getFocusEventOLwlOKw != 0) {
                    }
                    node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                    $i$f$getFocusEventOLwlOKw.add(node3);
                    count$iv$iv3 = count$iv$iv;
                    i9 = 0;
                    i4 = i13;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    $i$f$getFocusEventOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv3 = node2;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    untilType$iv = node2;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    node = node$iv$iv3;
                    i11 = 0;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    node.onFocusEvent(FocusEventModifierNodeKt.getFocusState((FocusEventModifierNode)node));
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    type$iv = 1;
                    $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                    this_$iv$iv = 1;
                    i3 = 0;
                    if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv == 0) {
                        break loop_4;
                    }
                    this_$iv$iv = 1;
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                $i$f$getFocusEventOLwlOKw = type$iv2;
                $i$f$getFocusTargetOLwlOKw = i10;
                i8 = i;
                i2 = node$iv$iv;
                i7 = 0;
                i3 = 0;
                if (kindSet$ui_release2 &= $i$f$getFocusEventOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                i3 = 0;
                i6 = 0;
                i20 = 0;
                node$iv$iv3 = node$iv$iv2;
                while (node$iv$iv3 != null) {
                    if (node$iv$iv3 instanceof FocusEventModifierNode) {
                    } else {
                    }
                    node = 0;
                    if (kindSet$ui_release4 &= $i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    type$iv = 1;
                    $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i6);
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    $i$f$getFocusEventOLwlOKw = type$iv2;
                    $i$f$getFocusTargetOLwlOKw = i10;
                    i8 = i;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i11 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i5 = 0;
                        count$iv$iv3 = 0;
                        if (kindSet$ui_release5 &= $i$f$getFocusEventOLwlOKw != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = $i$f$getFocusEventOLwlOKw;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        untilType$iv = node2;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        $i$f$getFocusEventOLwlOKw = type$iv2;
                        $i$f$getFocusTargetOLwlOKw = i10;
                        i8 = i;
                        count$iv$iv++;
                        type$iv2 = $i$f$getFocusEventOLwlOKw;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i6 == 0) {
                        } else {
                        }
                        count$iv$iv3 = count$iv$iv;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        $i$f$getFocusEventOLwlOKw = i6;
                        node3 = node$iv$iv3;
                        if (node3 != null && $i$f$getFocusEventOLwlOKw != 0) {
                        }
                        if ($i$f$getFocusEventOLwlOKw != 0) {
                        } else {
                        }
                        untilType$iv = node2;
                        i6 = $i$f$getFocusEventOLwlOKw;
                        count$iv$iv = count$iv$iv3;
                        $i$f$getFocusEventOLwlOKw.add(node2);
                        if ($i$f$getFocusEventOLwlOKw != 0) {
                        }
                        node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                        $i$f$getFocusEventOLwlOKw.add(node3);
                        count$iv$iv3 = count$iv$iv;
                        i9 = 0;
                        i4 = i13;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        $i$f$getFocusEventOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv3 = node2;
                        i10 = $i$f$getFocusTargetOLwlOKw;
                        i = i8;
                        untilType$iv = node2;
                        $i$f$visitSelfAndAncestors5BbP62I = 0;
                        this_$iv$iv$iv = 1;
                    }
                    $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    $i$f$getFocusEventOLwlOKw = type$iv2;
                    $i$f$getFocusTargetOLwlOKw = i10;
                    i8 = i;
                    node2 = node$iv$iv$iv;
                    i5 = 0;
                    count$iv$iv3 = 0;
                    if (kindSet$ui_release5 &= $i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    untilType$iv = node2;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusEventOLwlOKw = type$iv2;
                    $i$f$getFocusTargetOLwlOKw = i10;
                    i8 = i;
                    count$iv$iv++;
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i6 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    $i$f$getFocusEventOLwlOKw = i6;
                    node3 = node$iv$iv3;
                    if (node3 != null && $i$f$getFocusEventOLwlOKw != 0) {
                    }
                    if ($i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    untilType$iv = node2;
                    i6 = $i$f$getFocusEventOLwlOKw;
                    count$iv$iv = count$iv$iv3;
                    $i$f$getFocusEventOLwlOKw.add(node2);
                    if ($i$f$getFocusEventOLwlOKw != 0) {
                    }
                    node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                    $i$f$getFocusEventOLwlOKw.add(node3);
                    count$iv$iv3 = count$iv$iv;
                    i9 = 0;
                    i4 = i13;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    $i$f$getFocusEventOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv3 = node2;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    untilType$iv = node2;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    node = node$iv$iv3;
                    i11 = 0;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    node.onFocusEvent(FocusEventModifierNodeKt.getFocusState((FocusEventModifierNode)node));
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    type$iv = 1;
                    $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                if (node$iv$iv3 instanceof FocusEventModifierNode) {
                } else {
                }
                node = 0;
                if (kindSet$ui_release4 &= $i$f$getFocusEventOLwlOKw != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                type$iv = 1;
                $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i6);
                count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                $i$f$getFocusEventOLwlOKw = type$iv2;
                $i$f$getFocusTargetOLwlOKw = i10;
                i8 = i;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                i11 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i5 = 0;
                    count$iv$iv3 = 0;
                    if (kindSet$ui_release5 &= $i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    untilType$iv = node2;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    $i$f$getFocusEventOLwlOKw = type$iv2;
                    $i$f$getFocusTargetOLwlOKw = i10;
                    i8 = i;
                    count$iv$iv++;
                    type$iv2 = $i$f$getFocusEventOLwlOKw;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i6 == 0) {
                    } else {
                    }
                    count$iv$iv3 = count$iv$iv;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    $i$f$getFocusEventOLwlOKw = i6;
                    node3 = node$iv$iv3;
                    if (node3 != null && $i$f$getFocusEventOLwlOKw != 0) {
                    }
                    if ($i$f$getFocusEventOLwlOKw != 0) {
                    } else {
                    }
                    untilType$iv = node2;
                    i6 = $i$f$getFocusEventOLwlOKw;
                    count$iv$iv = count$iv$iv3;
                    $i$f$getFocusEventOLwlOKw.add(node2);
                    if ($i$f$getFocusEventOLwlOKw != 0) {
                    }
                    node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                    $i$f$getFocusEventOLwlOKw.add(node3);
                    count$iv$iv3 = count$iv$iv;
                    i9 = 0;
                    i4 = i13;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    $i$f$getFocusEventOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv3 = node2;
                    i10 = $i$f$getFocusTargetOLwlOKw;
                    i = i8;
                    untilType$iv = node2;
                    $i$f$visitSelfAndAncestors5BbP62I = 0;
                    this_$iv$iv$iv = 1;
                }
                $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                if (count$iv$iv == 1) {
                } else {
                }
                count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                $i$f$getFocusEventOLwlOKw = type$iv2;
                $i$f$getFocusTargetOLwlOKw = i10;
                i8 = i;
                node2 = node$iv$iv$iv;
                i5 = 0;
                count$iv$iv3 = 0;
                if (kindSet$ui_release5 &= $i$f$getFocusEventOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                untilType$iv = node2;
                $i$f$visitSelfAndAncestors5BbP62I = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $i$f$getFocusEventOLwlOKw = type$iv2;
                $i$f$getFocusTargetOLwlOKw = i10;
                i8 = i;
                count$iv$iv++;
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                if (count$iv$iv == 1) {
                } else {
                }
                if (i6 == 0) {
                } else {
                }
                count$iv$iv3 = count$iv$iv;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                $i$f$visitSelfAndAncestors5BbP62I = 0;
                $i$f$getFocusEventOLwlOKw = i6;
                node3 = node$iv$iv3;
                if (node3 != null && $i$f$getFocusEventOLwlOKw != 0) {
                }
                if ($i$f$getFocusEventOLwlOKw != 0) {
                } else {
                }
                untilType$iv = node2;
                i6 = $i$f$getFocusEventOLwlOKw;
                count$iv$iv = count$iv$iv3;
                $i$f$getFocusEventOLwlOKw.add(node2);
                if ($i$f$getFocusEventOLwlOKw != 0) {
                }
                node$iv$iv3 = $i$f$getFocusTargetOLwlOKw;
                $i$f$getFocusEventOLwlOKw.add(node3);
                count$iv$iv3 = count$iv$iv;
                i9 = 0;
                i4 = i13;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                $i$f$getFocusEventOLwlOKw = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv3 = node2;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                untilType$iv = node2;
                $i$f$visitSelfAndAncestors5BbP62I = 0;
                this_$iv$iv$iv = 1;
                count$iv$iv = 1;
                node = node$iv$iv3;
                i11 = 0;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                node.onFocusEvent(FocusEventModifierNodeKt.getFocusState((FocusEventModifierNode)node));
                type$iv2 = $i$f$getFocusEventOLwlOKw;
                i10 = $i$f$getFocusTargetOLwlOKw;
                i = i8;
                type$iv = 1;
                $i$f$visitSelfAndAncestors5BbP62I2 = 0;
                this_$iv$iv = 1;
                i3 = 0;
                if (kindSet$ui_release3 &= $i$f$getFocusTargetOLwlOKw != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv == 0) {
                    break;
                }
                this_$iv$iv = 1;
            }
            $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
            type$iv2 = $i$f$getFocusEventOLwlOKw;
            i10 = $i$f$getFocusTargetOLwlOKw;
            i = i8;
        }
        DelegatableNode delegatableNode2 = count$iv$iv2;
        int i21 = $i$f$getFocusEventOLwlOKw;
        int $this$visitSelfAndAncestors_u2d5BbP62I$iv3 = 0;
        IllegalStateException $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw $i$a$CheckDelegatableNodeKt$visitAncestors$1$iv$iv;
    }
}
