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
            int ordinal;
            int ordinal4;
            int[] iArr = new int[values.length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            FocusEventModifierNodeKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final androidx.compose.ui.focus.FocusState getFocusState(androidx.compose.ui.focus.FocusEventModifierNode $this$getFocusState) {
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int mask$iv$iv2;
        int mask$iv$iv3;
        int $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
        int type$iv;
        int i9;
        int $this$visitChildren$iv$iv;
        int arr;
        Modifier.Node next$iv$iv;
        int stack$iv$iv;
        int node2;
        Modifier.Node node$iv$iv;
        int node$iv$iv2;
        Modifier.Node node;
        int i4;
        int i10;
        androidx.compose.ui.focus.FocusStateImpl count$iv$iv;
        Modifier.Node[] arr2;
        int i;
        int ordinal;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node stack$iv$iv2;
        int node$iv$iv3;
        int this_$iv$iv$iv2;
        int i3;
        int i12;
        Modifier.Node $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
        int i5;
        int focusState;
        int node$iv$iv$iv2;
        int ordinal2;
        int i8;
        int this_$iv$iv$iv;
        int mask$iv$iv;
        int i7;
        int i2;
        int i11;
        int i6;
        int i13 = 0;
        type$iv = NodeKind.constructor-impl(1024);
        arr = 0;
        int i16 = 0;
        stack$iv$iv = 0;
        int i18 = 0;
        node$iv$iv = node3;
        node = 0;
        while (node$iv$iv != null) {
            i = 0;
            if (kindSet$ui_release2 &= type$iv != 0) {
            } else {
            }
            count$iv$iv = node;
            if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i5 = type$iv;
            node$iv$iv = DelegatableNodeKt.access$pop(stack$iv$iv);
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            type$iv = i5;
            node = 0;
            if (node$iv$iv instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv = 0;
            ordinal = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                stack$iv$iv2 = node$iv$iv$iv;
                node$iv$iv3 = 0;
                i3 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv2 = node;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i5 = type$iv;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
                type$iv = i5;
                i10 = 1;
                if (count$iv$iv++ == i10) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i5 = type$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = stack$iv$iv;
                stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = node$iv$iv;
                if ($this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                }
                stack$iv$iv.add(stack$iv$iv2);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv = type$iv;
                stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv2);
                this_$iv$iv$iv2 = 0;
                i12 = 0;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i5 = type$iv;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = new MutableVector(new Modifier.Node[16], node);
                node$iv$iv = stack$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                i5 = type$iv;
                this_$iv$iv$iv2 = i10;
            }
            if (count$iv$iv == 1) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            type$iv = i5;
            stack$iv$iv2 = node$iv$iv$iv;
            node$iv$iv3 = 0;
            i3 = 0;
            if (kindSet$ui_release3 &= type$iv != 0) {
            } else {
            }
            this_$iv$iv$iv2 = node;
            if (this_$iv$iv$iv2 != 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i5 = type$iv;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv3;
            type$iv = i5;
            i10 = 1;
            if (count$iv$iv++ == i10) {
            } else {
            }
            if (stack$iv$iv == 0) {
            } else {
            }
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i5 = type$iv;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = stack$iv$iv;
            stack$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv4;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = node$iv$iv;
            if ($this$visitSelfAndChildren_u2d6rFNWt0$iv2 != null && stack$iv$iv != 0) {
            }
            if (stack$iv$iv != 0) {
            }
            stack$iv$iv.add(stack$iv$iv2);
            if (stack$iv$iv != 0) {
            }
            node$iv$iv = type$iv;
            stack$iv$iv.add($this$visitSelfAndChildren_u2d6rFNWt0$iv2);
            this_$iv$iv$iv2 = 0;
            i12 = 0;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i5 = type$iv;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv4 = new MutableVector(new Modifier.Node[16], node);
            node$iv$iv = stack$iv$iv2;
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i5 = type$iv;
            this_$iv$iv$iv2 = i10;
            count$iv$iv = i10;
            i10 = 0;
            count$iv$iv = (FocusTargetNode)node$iv$iv.getFocusState();
            $this$visitSelfAndChildren_u2d6rFNWt0$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
            i5 = type$iv;
        }
        int i24 = type$iv;
        i9 = $this$visitSelfAndChildren_u2d6rFNWt0$iv5;
        int i15 = 0;
        if (!i9.getNode().isAttached()) {
        } else {
            int i17 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], node);
            Modifier.Node child$ui_release = i9.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, i9.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i19 = 0;
                i3 = 1;
                node2 = mutableVector2.removeAt(size--);
                if (aggregateChildKindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv == 0) {
                } else {
                }
                node$iv$iv2 = node2;
                while (node$iv$iv2 != null) {
                    i2 = i9;
                    i11 = arr;
                    int i21 = 1;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    node = mask$iv$iv5;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                }
                i2 = i9;
                i11 = arr;
                int i20 = 1;
                node = mask$iv$iv4;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                if (kindSet$ui_release &= $this$visitSelfAndChildren_u2d6rFNWt0$iv != 0) {
                } else {
                }
                i2 = i9;
                i11 = arr;
                i21 = 1;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                node = mask$iv$iv5;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                i = 0;
                node$iv$iv$iv = 0;
                stack$iv$iv2 = 0;
                int i23 = 0;
                node$iv$iv3 = ordinal;
                while (node$iv$iv3 != null) {
                    i12 = 0;
                    if (kindSet$ui_release4 &= i24 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = node;
                    if (this_$iv$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i2 = i9;
                    i11 = arr;
                    mask$iv$iv3 = node;
                    i4 = 1;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv2);
                    node = mask$iv$iv3;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                    i9 = i2;
                    arr = i11;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    focusState = 0;
                    node$iv$iv$iv2 = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv2 != null) {
                        ordinal2 = node$iv$iv$iv2;
                        i8 = 0;
                        int i25 = 0;
                        if (kindSet$ui_release5 &= i24 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = node;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        i2 = i9;
                        i11 = arr;
                        mask$iv$iv2 = node;
                        next$iv$iv = ordinal2;
                        node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                        node = mask$iv$iv2;
                        $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                        i9 = i2;
                        arr = i11;
                        if (this_$iv$iv$iv2++ == 1) {
                        } else {
                        }
                        if (stack$iv$iv2 == 0) {
                        } else {
                        }
                        mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        i2 = i9;
                        i11 = arr;
                        mask$iv$iv2 = 0;
                        $this$visitChildren$iv$iv = stack$iv$iv2;
                        stack$iv$iv2 = $this$visitChildren$iv$iv;
                        i9 = node$iv$iv3;
                        if (i9 != null && stack$iv$iv2 != 0) {
                        }
                        if (stack$iv$iv2 != 0) {
                        } else {
                        }
                        next$iv$iv = ordinal2;
                        stack$iv$iv2.add(ordinal2);
                        if (stack$iv$iv2 != 0) {
                        }
                        node$iv$iv3 = arr;
                        stack$iv$iv2.add(i9);
                        node = 0;
                        mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        int mask$iv$iv6 = 16;
                        i7 = 0;
                        i2 = i9;
                        i11 = arr;
                        i6 = mask$iv$iv6;
                        $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                        node$iv$iv3 = ordinal2;
                        mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                        i2 = i9;
                        i11 = arr;
                        next$iv$iv = ordinal2;
                        mask$iv$iv2 = 0;
                        this_$iv$iv$iv = 1;
                    }
                    if (this_$iv$iv$iv2 == 1) {
                    } else {
                    }
                    node = mask$iv$iv3;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                    i9 = i2;
                    arr = i11;
                    ordinal2 = node$iv$iv$iv2;
                    i8 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i24 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = node;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i2 = i9;
                    i11 = arr;
                    mask$iv$iv2 = node;
                    next$iv$iv = ordinal2;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    node = mask$iv$iv2;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                    i9 = i2;
                    arr = i11;
                    if (this_$iv$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i2 = i9;
                    i11 = arr;
                    mask$iv$iv2 = 0;
                    $this$visitChildren$iv$iv = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv;
                    i9 = node$iv$iv3;
                    if (i9 != null && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = ordinal2;
                    stack$iv$iv2.add(ordinal2);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = arr;
                    stack$iv$iv2.add(i9);
                    node = 0;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    mask$iv$iv6 = 16;
                    i7 = 0;
                    i2 = i9;
                    i11 = arr;
                    i6 = mask$iv$iv6;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                    node$iv$iv3 = ordinal2;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i2 = i9;
                    i11 = arr;
                    next$iv$iv = ordinal2;
                    mask$iv$iv2 = 0;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv2 = 1;
                    i12 = 0;
                    focusState = (FocusTargetNode)node$iv$iv3.getFocusState();
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i2 = i9;
                    i11 = arr;
                    mask$iv$iv3 = node;
                    i4 = 1;
                }
                i2 = i9;
                i11 = arr;
                int i22 = 1;
                node = mask$iv$iv7;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                i12 = 0;
                if (kindSet$ui_release4 &= i24 != 0) {
                } else {
                }
                this_$iv$iv$iv2 = node;
                if (this_$iv$iv$iv2 != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = i9;
                i11 = arr;
                mask$iv$iv3 = node;
                i4 = 1;
                node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv2);
                node = mask$iv$iv3;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                i9 = i2;
                arr = i11;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                focusState = 0;
                node$iv$iv$iv2 = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv2 != null) {
                    ordinal2 = node$iv$iv$iv2;
                    i8 = 0;
                    i25 = 0;
                    if (kindSet$ui_release5 &= i24 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = node;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i2 = i9;
                    i11 = arr;
                    mask$iv$iv2 = node;
                    next$iv$iv = ordinal2;
                    node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                    node = mask$iv$iv2;
                    $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                    i9 = i2;
                    arr = i11;
                    if (this_$iv$iv$iv2++ == 1) {
                    } else {
                    }
                    if (stack$iv$iv2 == 0) {
                    } else {
                    }
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i2 = i9;
                    i11 = arr;
                    mask$iv$iv2 = 0;
                    $this$visitChildren$iv$iv = stack$iv$iv2;
                    stack$iv$iv2 = $this$visitChildren$iv$iv;
                    i9 = node$iv$iv3;
                    if (i9 != null && stack$iv$iv2 != 0) {
                    }
                    if (stack$iv$iv2 != 0) {
                    } else {
                    }
                    next$iv$iv = ordinal2;
                    stack$iv$iv2.add(ordinal2);
                    if (stack$iv$iv2 != 0) {
                    }
                    node$iv$iv3 = arr;
                    stack$iv$iv2.add(i9);
                    node = 0;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    mask$iv$iv6 = 16;
                    i7 = 0;
                    i2 = i9;
                    i11 = arr;
                    i6 = mask$iv$iv6;
                    $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                    node$iv$iv3 = ordinal2;
                    mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                    i2 = i9;
                    i11 = arr;
                    next$iv$iv = ordinal2;
                    mask$iv$iv2 = 0;
                    this_$iv$iv$iv = 1;
                }
                if (this_$iv$iv$iv2 == 1) {
                } else {
                }
                node = mask$iv$iv3;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                i9 = i2;
                arr = i11;
                ordinal2 = node$iv$iv$iv2;
                i8 = 0;
                i25 = 0;
                if (kindSet$ui_release5 &= i24 != 0) {
                } else {
                }
                this_$iv$iv$iv = node;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = i9;
                i11 = arr;
                mask$iv$iv2 = node;
                next$iv$iv = ordinal2;
                node$iv$iv$iv2 = node$iv$iv$iv2.getChild$ui_release();
                node = mask$iv$iv2;
                $this$visitSelfAndChildren_u2d6rFNWt0$iv = mask$iv$iv;
                i9 = i2;
                arr = i11;
                if (this_$iv$iv$iv2++ == 1) {
                } else {
                }
                if (stack$iv$iv2 == 0) {
                } else {
                }
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = i9;
                i11 = arr;
                mask$iv$iv2 = 0;
                $this$visitChildren$iv$iv = stack$iv$iv2;
                stack$iv$iv2 = $this$visitChildren$iv$iv;
                i9 = node$iv$iv3;
                if (i9 != null && stack$iv$iv2 != 0) {
                }
                if (stack$iv$iv2 != 0) {
                } else {
                }
                next$iv$iv = ordinal2;
                stack$iv$iv2.add(ordinal2);
                if (stack$iv$iv2 != 0) {
                }
                node$iv$iv3 = arr;
                stack$iv$iv2.add(i9);
                node = 0;
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                mask$iv$iv6 = 16;
                i7 = 0;
                i2 = i9;
                i11 = arr;
                i6 = mask$iv$iv6;
                $this$visitChildren$iv$iv = new MutableVector(new Modifier.Node[mask$iv$iv6], 0);
                node$iv$iv3 = ordinal2;
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = i9;
                i11 = arr;
                next$iv$iv = ordinal2;
                mask$iv$iv2 = 0;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv2 = 1;
                i12 = 0;
                focusState = (FocusTargetNode)node$iv$iv3.getFocusState();
                mask$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                i2 = i9;
                i11 = arr;
                mask$iv$iv3 = node;
                i4 = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
            }
            int mask$iv$iv9 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
            return (FocusState)FocusStateImpl.Inactive;
        }
        int i26 = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
        int i27 = i9;
        int mask$iv$iv8 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw illegalStateException;
    }

    public static final void invalidateFocusEvent(androidx.compose.ui.focus.FocusEventModifierNode $this$invalidateFocusEvent) {
        DelegatableNodeKt.requireOwner((DelegatableNode)$this$invalidateFocusEvent).getFocusOwner().scheduleInvalidation($this$invalidateFocusEvent);
    }

    public static final void refreshFocusEventNodes(androidx.compose.ui.focus.FocusTargetNode $this$refreshFocusEventNodes) {
        DelegatableNode count$iv$iv2;
        int tail$ui_release;
        androidx.compose.ui.focus.FocusState count$iv$iv3;
        int type$iv3;
        int type$iv;
        int untilType$iv2;
        Modifier.Node untilType$iv;
        int i10;
        int i2;
        int i6;
        Modifier.Node node$iv$iv3;
        LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        int i3;
        int i;
        Modifier.Node node$iv$iv2;
        Modifier.Node node;
        int this_$iv$iv;
        int i7;
        int i9;
        Modifier.Node node$iv$iv;
        int i13;
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i12;
        int type$iv2;
        int this_$iv$iv$iv;
        int count$iv$iv;
        int i11;
        int i8;
        int i4;
        int i5;
        count$iv$iv2 = $this$refreshFocusEventNodes;
        int i14 = 0;
        type$iv3 = NodeKind.constructor-impl(4096);
        int i17 = 0;
        i10 = 0;
        final int i19 = type$iv3 | untilType$iv2;
        final int i20 = 1;
        final DelegatableNode delegatableNode = count$iv$iv2;
        final int i21 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv3 = delegatableNode.getNode();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i19 == 0) {
                    break;
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = type$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                count$iv$iv2 = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && count$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv3 = tail$ui_release;
                count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv3 = type$iv2;
                untilType$iv2 = i4;
                i10 = i5;
                count$iv$iv2 = layout$iv$iv.getNodes$ui_release();
                if (count$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = count$iv$iv2.getTail$ui_release();
                while (node$iv$iv3 != null) {
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    node$iv$iv3 = node$iv$iv3.getParent$ui_release();
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv2;
                    untilType$iv2 = i4;
                    i10 = i5;
                    i3 = node$iv$iv3;
                    i = 0;
                    i7 = 0;
                    if (kindSet$ui_release2 &= type$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    i7 = 0;
                    i9 = 0;
                    int i22 = 0;
                    node$iv$iv2 = node$iv$iv;
                    while (node$iv$iv2 != null) {
                        if (node$iv$iv2 instanceof FocusEventModifierNode) {
                        } else {
                        }
                        node = 0;
                        if (kindSet$ui_release4 &= type$iv3 != 0) {
                        } else {
                        }
                        count$iv$iv3 = 0;
                        if (count$iv$iv3 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        type$iv2 = type$iv3;
                        i4 = untilType$iv2;
                        i5 = i10;
                        type$iv = 1;
                        i2 = 0;
                        node$iv$iv2 = DelegatableNodeKt.access$pop(i9);
                        count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                        type$iv3 = type$iv2;
                        untilType$iv2 = i4;
                        i10 = i5;
                        if (node$iv$iv2 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv3 = 0;
                        i13 = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i12 = 0;
                            count$iv$iv = 0;
                            if (kindSet$ui_release5 &= type$iv3 != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            type$iv2 = type$iv3;
                            i4 = untilType$iv2;
                            i5 = i10;
                            untilType$iv = node2;
                            i6 = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            type$iv3 = type$iv2;
                            untilType$iv2 = i4;
                            i10 = i5;
                            count$iv$iv3++;
                            type$iv2 = type$iv3;
                            if (count$iv$iv3 == 1) {
                            } else {
                            }
                            if (i9 == 0) {
                            } else {
                            }
                            count$iv$iv = count$iv$iv3;
                            i4 = untilType$iv2;
                            i5 = i10;
                            i6 = 0;
                            type$iv3 = i9;
                            Modifier.Node node3 = node$iv$iv2;
                            if (node3 != null && type$iv3 != 0) {
                            }
                            if (type$iv3 != 0) {
                            } else {
                            }
                            untilType$iv = node2;
                            i9 = type$iv3;
                            count$iv$iv3 = count$iv$iv;
                            type$iv3.add(node2);
                            if (type$iv3 != 0) {
                            }
                            node$iv$iv2 = untilType$iv2;
                            type$iv3.add(node3);
                            count$iv$iv = count$iv$iv3;
                            i11 = 0;
                            i8 = i15;
                            i4 = untilType$iv2;
                            i5 = i10;
                            type$iv3 = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv2 = node2;
                            i4 = untilType$iv2;
                            i5 = i10;
                            untilType$iv = node2;
                            i6 = 0;
                            this_$iv$iv$iv = 1;
                        }
                        i2 = 0;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                        type$iv3 = type$iv2;
                        untilType$iv2 = i4;
                        i10 = i5;
                        node2 = node$iv$iv$iv;
                        i12 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release5 &= type$iv3 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = type$iv3;
                        i4 = untilType$iv2;
                        i5 = i10;
                        untilType$iv = node2;
                        i6 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        type$iv3 = type$iv2;
                        untilType$iv2 = i4;
                        i10 = i5;
                        count$iv$iv3++;
                        type$iv2 = type$iv3;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        i4 = untilType$iv2;
                        i5 = i10;
                        i6 = 0;
                        type$iv3 = i9;
                        node3 = node$iv$iv2;
                        if (node3 != null && type$iv3 != 0) {
                        }
                        if (type$iv3 != 0) {
                        } else {
                        }
                        untilType$iv = node2;
                        i9 = type$iv3;
                        count$iv$iv3 = count$iv$iv;
                        type$iv3.add(node2);
                        if (type$iv3 != 0) {
                        }
                        node$iv$iv2 = untilType$iv2;
                        type$iv3.add(node3);
                        count$iv$iv = count$iv$iv3;
                        i11 = 0;
                        i8 = i15;
                        i4 = untilType$iv2;
                        i5 = i10;
                        type$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node2;
                        i4 = untilType$iv2;
                        i5 = i10;
                        untilType$iv = node2;
                        i6 = 0;
                        this_$iv$iv$iv = 1;
                        count$iv$iv3 = 1;
                        node = node$iv$iv2;
                        i13 = 0;
                        $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                        node.onFocusEvent(FocusEventModifierNodeKt.getFocusState((FocusEventModifierNode)node));
                        type$iv2 = type$iv3;
                        i4 = untilType$iv2;
                        i5 = i10;
                        type$iv = 1;
                        i2 = 0;
                    }
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    if (node$iv$iv2 instanceof FocusEventModifierNode) {
                    } else {
                    }
                    node = 0;
                    if (kindSet$ui_release4 &= type$iv3 != 0) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    if (count$iv$iv3 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    type$iv = 1;
                    i2 = 0;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(i9);
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv2;
                    untilType$iv2 = i4;
                    i10 = i5;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    i13 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i12 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release5 &= type$iv3 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = type$iv3;
                        i4 = untilType$iv2;
                        i5 = i10;
                        untilType$iv = node2;
                        i6 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        type$iv3 = type$iv2;
                        untilType$iv2 = i4;
                        i10 = i5;
                        count$iv$iv3++;
                        type$iv2 = type$iv3;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        i4 = untilType$iv2;
                        i5 = i10;
                        i6 = 0;
                        type$iv3 = i9;
                        node3 = node$iv$iv2;
                        if (node3 != null && type$iv3 != 0) {
                        }
                        if (type$iv3 != 0) {
                        } else {
                        }
                        untilType$iv = node2;
                        i9 = type$iv3;
                        count$iv$iv3 = count$iv$iv;
                        type$iv3.add(node2);
                        if (type$iv3 != 0) {
                        }
                        node$iv$iv2 = untilType$iv2;
                        type$iv3.add(node3);
                        count$iv$iv = count$iv$iv3;
                        i11 = 0;
                        i8 = i15;
                        i4 = untilType$iv2;
                        i5 = i10;
                        type$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node2;
                        i4 = untilType$iv2;
                        i5 = i10;
                        untilType$iv = node2;
                        i6 = 0;
                        this_$iv$iv$iv = 1;
                    }
                    i2 = 0;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv2;
                    untilType$iv2 = i4;
                    i10 = i5;
                    node2 = node$iv$iv$iv;
                    i12 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release5 &= type$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    untilType$iv = node2;
                    i6 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv3 = type$iv2;
                    untilType$iv2 = i4;
                    i10 = i5;
                    count$iv$iv3++;
                    type$iv2 = type$iv3;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    i6 = 0;
                    type$iv3 = i9;
                    node3 = node$iv$iv2;
                    if (node3 != null && type$iv3 != 0) {
                    }
                    if (type$iv3 != 0) {
                    } else {
                    }
                    untilType$iv = node2;
                    i9 = type$iv3;
                    count$iv$iv3 = count$iv$iv;
                    type$iv3.add(node2);
                    if (type$iv3 != 0) {
                    }
                    node$iv$iv2 = untilType$iv2;
                    type$iv3.add(node3);
                    count$iv$iv = count$iv$iv3;
                    i11 = 0;
                    i8 = i15;
                    i4 = untilType$iv2;
                    i5 = i10;
                    type$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node2;
                    i4 = untilType$iv2;
                    i5 = i10;
                    untilType$iv = node2;
                    i6 = 0;
                    this_$iv$iv$iv = 1;
                    count$iv$iv3 = 1;
                    node = node$iv$iv2;
                    i13 = 0;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    node.onFocusEvent(FocusEventModifierNodeKt.getFocusState((FocusEventModifierNode)node));
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    type$iv = 1;
                    i2 = 0;
                    this_$iv$iv = 1;
                    i7 = 0;
                    if (kindSet$ui_release3 &= untilType$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv == 0) {
                        break loop_4;
                    }
                    this_$iv$iv = 1;
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = type$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = type$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                node$iv$iv3 = node$iv$iv3.getParent$ui_release();
                count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv3 = type$iv2;
                untilType$iv2 = i4;
                i10 = i5;
                i3 = node$iv$iv3;
                i = 0;
                i7 = 0;
                if (kindSet$ui_release2 &= type$iv3 != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = type$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                i7 = 0;
                i9 = 0;
                i22 = 0;
                node$iv$iv2 = node$iv$iv;
                while (node$iv$iv2 != null) {
                    if (node$iv$iv2 instanceof FocusEventModifierNode) {
                    } else {
                    }
                    node = 0;
                    if (kindSet$ui_release4 &= type$iv3 != 0) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    if (count$iv$iv3 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    type$iv = 1;
                    i2 = 0;
                    node$iv$iv2 = DelegatableNodeKt.access$pop(i9);
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv2;
                    untilType$iv2 = i4;
                    i10 = i5;
                    if (node$iv$iv2 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv3 = 0;
                    i13 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i12 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release5 &= type$iv3 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        type$iv2 = type$iv3;
                        i4 = untilType$iv2;
                        i5 = i10;
                        untilType$iv = node2;
                        i6 = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        type$iv3 = type$iv2;
                        untilType$iv2 = i4;
                        i10 = i5;
                        count$iv$iv3++;
                        type$iv2 = type$iv3;
                        if (count$iv$iv3 == 1) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        count$iv$iv = count$iv$iv3;
                        i4 = untilType$iv2;
                        i5 = i10;
                        i6 = 0;
                        type$iv3 = i9;
                        node3 = node$iv$iv2;
                        if (node3 != null && type$iv3 != 0) {
                        }
                        if (type$iv3 != 0) {
                        } else {
                        }
                        untilType$iv = node2;
                        i9 = type$iv3;
                        count$iv$iv3 = count$iv$iv;
                        type$iv3.add(node2);
                        if (type$iv3 != 0) {
                        }
                        node$iv$iv2 = untilType$iv2;
                        type$iv3.add(node3);
                        count$iv$iv = count$iv$iv3;
                        i11 = 0;
                        i8 = i15;
                        i4 = untilType$iv2;
                        i5 = i10;
                        type$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv2 = node2;
                        i4 = untilType$iv2;
                        i5 = i10;
                        untilType$iv = node2;
                        i6 = 0;
                        this_$iv$iv$iv = 1;
                    }
                    i2 = 0;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv2;
                    untilType$iv2 = i4;
                    i10 = i5;
                    node2 = node$iv$iv$iv;
                    i12 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release5 &= type$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    untilType$iv = node2;
                    i6 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv3 = type$iv2;
                    untilType$iv2 = i4;
                    i10 = i5;
                    count$iv$iv3++;
                    type$iv2 = type$iv3;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    i6 = 0;
                    type$iv3 = i9;
                    node3 = node$iv$iv2;
                    if (node3 != null && type$iv3 != 0) {
                    }
                    if (type$iv3 != 0) {
                    } else {
                    }
                    untilType$iv = node2;
                    i9 = type$iv3;
                    count$iv$iv3 = count$iv$iv;
                    type$iv3.add(node2);
                    if (type$iv3 != 0) {
                    }
                    node$iv$iv2 = untilType$iv2;
                    type$iv3.add(node3);
                    count$iv$iv = count$iv$iv3;
                    i11 = 0;
                    i8 = i15;
                    i4 = untilType$iv2;
                    i5 = i10;
                    type$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node2;
                    i4 = untilType$iv2;
                    i5 = i10;
                    untilType$iv = node2;
                    i6 = 0;
                    this_$iv$iv$iv = 1;
                    count$iv$iv3 = 1;
                    node = node$iv$iv2;
                    i13 = 0;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                    node.onFocusEvent(FocusEventModifierNodeKt.getFocusState((FocusEventModifierNode)node));
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    type$iv = 1;
                    i2 = 0;
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                type$iv2 = type$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                if (node$iv$iv2 instanceof FocusEventModifierNode) {
                } else {
                }
                node = 0;
                if (kindSet$ui_release4 &= type$iv3 != 0) {
                } else {
                }
                count$iv$iv3 = 0;
                if (count$iv$iv3 != 0 && node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                type$iv2 = type$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                type$iv = 1;
                i2 = 0;
                node$iv$iv2 = DelegatableNodeKt.access$pop(i9);
                count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv3 = type$iv2;
                untilType$iv2 = i4;
                i10 = i5;
                if (node$iv$iv2 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv3 = 0;
                i13 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv2.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i12 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release5 &= type$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    type$iv2 = type$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    untilType$iv = node2;
                    i6 = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv3 = type$iv2;
                    untilType$iv2 = i4;
                    i10 = i5;
                    count$iv$iv3++;
                    type$iv2 = type$iv3;
                    if (count$iv$iv3 == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    count$iv$iv = count$iv$iv3;
                    i4 = untilType$iv2;
                    i5 = i10;
                    i6 = 0;
                    type$iv3 = i9;
                    node3 = node$iv$iv2;
                    if (node3 != null && type$iv3 != 0) {
                    }
                    if (type$iv3 != 0) {
                    } else {
                    }
                    untilType$iv = node2;
                    i9 = type$iv3;
                    count$iv$iv3 = count$iv$iv;
                    type$iv3.add(node2);
                    if (type$iv3 != 0) {
                    }
                    node$iv$iv2 = untilType$iv2;
                    type$iv3.add(node3);
                    count$iv$iv = count$iv$iv3;
                    i11 = 0;
                    i8 = i15;
                    i4 = untilType$iv2;
                    i5 = i10;
                    type$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv2 = node2;
                    i4 = untilType$iv2;
                    i5 = i10;
                    untilType$iv = node2;
                    i6 = 0;
                    this_$iv$iv$iv = 1;
                }
                i2 = 0;
                if (count$iv$iv3 == 1) {
                } else {
                }
                count$iv$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv3 = type$iv2;
                untilType$iv2 = i4;
                i10 = i5;
                node2 = node$iv$iv$iv;
                i12 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release5 &= type$iv3 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                type$iv2 = type$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                untilType$iv = node2;
                i6 = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                type$iv3 = type$iv2;
                untilType$iv2 = i4;
                i10 = i5;
                count$iv$iv3++;
                type$iv2 = type$iv3;
                if (count$iv$iv3 == 1) {
                } else {
                }
                if (i9 == 0) {
                } else {
                }
                count$iv$iv = count$iv$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                i6 = 0;
                type$iv3 = i9;
                node3 = node$iv$iv2;
                if (node3 != null && type$iv3 != 0) {
                }
                if (type$iv3 != 0) {
                } else {
                }
                untilType$iv = node2;
                i9 = type$iv3;
                count$iv$iv3 = count$iv$iv;
                type$iv3.add(node2);
                if (type$iv3 != 0) {
                }
                node$iv$iv2 = untilType$iv2;
                type$iv3.add(node3);
                count$iv$iv = count$iv$iv3;
                i11 = 0;
                i8 = i15;
                i4 = untilType$iv2;
                i5 = i10;
                type$iv3 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv2 = node2;
                i4 = untilType$iv2;
                i5 = i10;
                untilType$iv = node2;
                i6 = 0;
                this_$iv$iv$iv = 1;
                count$iv$iv3 = 1;
                node = node$iv$iv2;
                i13 = 0;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
                node.onFocusEvent(FocusEventModifierNodeKt.getFocusState((FocusEventModifierNode)node));
                type$iv2 = type$iv3;
                i4 = untilType$iv2;
                i5 = i10;
                type$iv = 1;
                i2 = 0;
                this_$iv$iv = 1;
                i7 = 0;
                if (kindSet$ui_release3 &= untilType$iv2 != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv == 0) {
                    break;
                }
                this_$iv$iv = 1;
            }
            $this$visitSelfAndAncestors_u2d5BbP62I$iv = count$iv$iv2;
            type$iv2 = type$iv3;
            i4 = untilType$iv2;
            i5 = i10;
        }
        DelegatableNode delegatableNode2 = count$iv$iv2;
        int i23 = type$iv3;
        int $this$visitSelfAndAncestors_u2d5BbP62I$iv3 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw illegalStateException;
    }
}
