package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier.Element;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u001a \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a#\u0010\u001f\u001a\u00020\u000c*\u00020\u00012\n\u0010 \u001a\u0006\u0012\u0002\u0008\u00030\rH\u0080\nø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\u001a#\u0010#\u001a\u00020\u0001*\u00020\u00012\n\u0010$\u001a\u0006\u0012\u0002\u0008\u00030\rH\u0080\u000cø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001a\u000c\u0010'\u001a\u00020\u0011*\u00020(H\u0002\u001a\u000c\u0010)\u001a\u00020\u000c*\u00020(H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0003\"\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u000b\u001a\u00020\u000c*\u0006\u0012\u0002\u0008\u00030\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006*", d2 = {"Inserted", "", "getInserted$annotations", "()V", "Removed", "getRemoved$annotations", "Updated", "getUpdated$annotations", "classToKindSetMap", "Landroidx/collection/MutableObjectIntMap;", "", "includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "autoInvalidateInsertedNode", "", "node", "Landroidx/compose/ui/Modifier$Node;", "autoInvalidateNodeIncludingDelegates", "remainingSet", "phase", "autoInvalidateNodeSelf", "selfKindSet", "autoInvalidateRemovedNode", "autoInvalidateUpdatedNode", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "calculateNodeKindSetFromIncludingDelegates", "contains", "value", "contains-64DMado", "(II)Z", "or", "other", "or-64DMado", "(II)I", "scheduleInvalidationOfAssociatedFocusTargets", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "specifiesCanFocusProperty", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NodeKindKt {

    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated;
    private static final MutableObjectIntMap<Object> classToKindSetMap;
    static {
        NodeKindKt.classToKindSetMap = ObjectIntMapKt.mutableObjectIntMapOf();
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        String str;
        int i = 0;
        if (!node.isAttached()) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
        }
        NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int remainingSet, int phase) {
        int i2;
        Object obj;
        int i3;
        Modifier.Node node$iv;
        Modifier.Node node2;
        int i;
        if (node instanceof DelegatingNode) {
            NodeKindKt.autoInvalidateNodeSelf(node, selfKindSet$ui_release &= remainingSet, phase);
            i3 = 0;
            node$iv = (DelegatingNode)node.getDelegate$ui_release();
            while (node$iv != null) {
                i = 0;
                NodeKindKt.autoInvalidateNodeIncludingDelegates(node$iv, i5 &= remainingSet, phase);
                node$iv = node$iv.getChild$ui_release();
            }
        } else {
            NodeKindKt.autoInvalidateNodeSelf(node, kindSet$ui_release &= remainingSet, phase);
        }
    }

    private static final void autoInvalidateNodeSelf(Modifier.Node node, int selfKindSet, int phase) {
        boolean shouldAutoInvalidate;
        int value$iv2;
        int value$iv3;
        int value$iv6;
        int value$iv;
        int value$iv7;
        int value$iv8;
        int value$iv5;
        int value$iv4;
        int constructor-impl2;
        int constructor-impl;
        int i;
        if (phase == 0 && !node.getShouldAutoInvalidate()) {
            if (!node.getShouldAutoInvalidate()) {
            }
        }
        int i2 = 0;
        int i10 = 2;
        int i29 = 0;
        i = 1;
        final int i46 = 0;
        value$iv2 = constructor-impl & constructor-impl3 != 0 ? i : i46;
        LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)node);
        if (value$iv2 != 0 && node instanceof LayoutModifierNode && phase == i10) {
            if (node instanceof LayoutModifierNode) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode)node);
                if (phase == i10) {
                    int i28 = 0;
                    DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)node, NodeKind.constructor-impl(i10)).onRelease();
                }
            }
        }
        int coordinator = 0;
        int i30 = 0;
        value$iv3 = i14 & constructor-impl4 != 0 ? i : i46;
        if (value$iv3 != 0 && node instanceof LayoutAwareModifierNode && phase != i10) {
            if (node instanceof LayoutAwareModifierNode) {
                if (phase != i10) {
                    DelegatableNodeKt.requireLayoutNode((DelegatableNode)node).invalidateMeasurements$ui_release();
                }
            }
        }
        int i3 = 0;
        int i31 = 0;
        value$iv6 = i16 & constructor-impl5 != 0 ? i : i46;
        if (value$iv6 != 0 && node instanceof GlobalPositionAwareModifierNode && phase != i10) {
            if (node instanceof GlobalPositionAwareModifierNode) {
                if (phase != i10) {
                    DelegatableNodeKt.requireLayoutNode((DelegatableNode)node).invalidateOnPositioned$ui_release();
                }
            }
        }
        int i4 = 0;
        int i32 = 0;
        value$iv = i18 & constructor-impl6 != 0 ? i : i46;
        if (value$iv != 0 && node instanceof DrawModifierNode) {
            if (node instanceof DrawModifierNode) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode)node);
            }
        }
        int i5 = 0;
        int i33 = 0;
        value$iv7 = i20 & constructor-impl7 != 0 ? i : i46;
        if (value$iv7 != 0 && node instanceof SemanticsModifierNode) {
            if (node instanceof SemanticsModifierNode) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)node);
            }
        }
        int i6 = 0;
        int i34 = 0;
        value$iv8 = i22 & constructor-impl8 != 0 ? i : i46;
        if (value$iv8 != 0 && node instanceof ParentDataModifierNode) {
            if (node instanceof ParentDataModifierNode) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode)node);
            }
        }
        int i7 = 0;
        int i35 = 0;
        value$iv5 = i24 & constructor-impl9 != 0 ? i : i46;
        if (value$iv5 != 0 && node instanceof FocusTargetNode && phase != i10) {
            if (node instanceof FocusTargetNode) {
                if (phase != i10) {
                    FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode)node);
                }
            }
        }
        int i8 = 0;
        int i36 = 0;
        value$iv4 = i26 & constructor-impl10 != 0 ? i : i46;
        if (value$iv4 != 0 && node instanceof FocusPropertiesModifierNode && NodeKindKt.specifiesCanFocusProperty((FocusPropertiesModifierNode)node)) {
            if (node instanceof FocusPropertiesModifierNode) {
                if (NodeKindKt.specifiesCanFocusProperty((FocusPropertiesModifierNode)node)) {
                    if (phase == i10) {
                        NodeKindKt.scheduleInvalidationOfAssociatedFocusTargets((FocusPropertiesModifierNode)node);
                    } else {
                        FocusPropertiesModifierNodeKt.invalidateFocusProperties((FocusPropertiesModifierNode)node);
                    }
                }
            }
        }
        int i9 = 0;
        int i27 = 0;
        if (i12 & constructor-impl2 != 0) {
        } else {
            i = i46;
        }
        if (i != 0 && node instanceof FocusEventModifierNode) {
            if (node instanceof FocusEventModifierNode) {
                FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode)node);
            }
        }
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        String str;
        int i = 0;
        if (!node.isAttached()) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
        }
        NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        String str;
        int i = 0;
        if (!node.isAttached()) {
            int i3 = 0;
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int mask;
        boolean other$iv7;
        boolean other$iv2;
        boolean other$iv3;
        boolean other$iv;
        boolean other$iv4;
        boolean other$iv10;
        boolean other$iv8;
        boolean other$iv6;
        boolean other$iv5;
        boolean other$iv9;
        int i2;
        int i;
        int i3 = 0;
        if (element instanceof LayoutModifier) {
            int i5 = 0;
            i = 0;
            mask = other$iv7;
        }
        if (element instanceof DrawModifier) {
            int i6 = 0;
            i = 0;
            mask = other$iv2;
        }
        if (element instanceof SemanticsModifier) {
            int i14 = 0;
            i = 0;
            mask = other$iv3;
        }
        if (element instanceof PointerInputModifier) {
            int i7 = 0;
            i = 0;
            mask = other$iv;
        }
        if (!element instanceof ModifierLocalConsumer) {
            if (element instanceof ModifierLocalProvider != null) {
                int i13 = 0;
                i = 0;
                mask = other$iv4;
            }
        } else {
        }
        if (element instanceof FocusEventModifier) {
            int i8 = 0;
            i = 0;
            mask = other$iv10;
        }
        if (element instanceof FocusOrderModifier) {
            int i9 = 0;
            i = 0;
            mask = other$iv8;
        }
        if (element instanceof OnGloballyPositionedModifier) {
            int i12 = 0;
            i = 0;
            mask = other$iv6;
        }
        if (element instanceof ParentDataModifier) {
            int i10 = 0;
            i = 0;
            mask = other$iv5;
        }
        if (!element instanceof OnPlacedModifier) {
            if (element instanceof OnRemeasuredModifier) {
                int i11 = 0;
                i = 0;
                mask = other$iv9;
            }
        } else {
        }
        return mask;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        int i2;
        int mask;
        boolean other$iv16;
        boolean other$iv11;
        boolean other$iv;
        boolean other$iv12;
        boolean other$iv2;
        boolean other$iv6;
        boolean other$iv17;
        boolean other$iv14;
        boolean other$iv7;
        boolean other$iv3;
        boolean other$iv15;
        boolean other$iv8;
        boolean other$iv10;
        boolean other$iv13;
        boolean other$iv9;
        boolean other$iv4;
        boolean other$iv5;
        int i;
        int i3;
        if (node.getKindSet$ui_release() != 0) {
            return node.getKindSet$ui_release();
        }
        MutableObjectIntMap classToKindSetMap = NodeKindKt.classToKindSetMap;
        final Object classKeyForObject = Actual_jvmKt.classKeyForObject(node);
        final int i4 = 0;
        final int keyIndex = classToKindSetMap.findKeyIndex(classKeyForObject);
        if (keyIndex >= 0) {
            i2 = classToKindSetMap.values[keyIndex];
        } else {
            int i5 = 0;
            int i6 = 0;
            if (node instanceof LayoutModifierNode) {
                int i24 = 0;
                i3 = 0;
                mask = other$iv11;
            }
            if (node instanceof DrawModifierNode) {
                int i23 = 0;
                i3 = 0;
                mask = other$iv;
            }
            if (node instanceof SemanticsModifierNode) {
                int i8 = 0;
                i3 = 0;
                mask = other$iv12;
            }
            if (node instanceof PointerInputModifierNode) {
                int i22 = 0;
                i3 = 0;
                mask = other$iv2;
            }
            if (node instanceof ModifierLocalModifierNode) {
                int i21 = 0;
                i3 = 0;
                mask = other$iv6;
            }
            if (node instanceof ParentDataModifierNode) {
                int i9 = 0;
                i3 = 0;
                mask = other$iv17;
            }
            if (node instanceof LayoutAwareModifierNode) {
                int i20 = 0;
                i3 = 0;
                mask = other$iv14;
            }
            if (node instanceof GlobalPositionAwareModifierNode) {
                int i19 = 0;
                i3 = 0;
                mask = other$iv7;
            }
            if (node instanceof ApproachLayoutModifierNode) {
                int i18 = 0;
                i3 = 0;
                mask = other$iv3;
            }
            if (node instanceof FocusTargetNode) {
                int i17 = 0;
                i3 = 0;
                mask = other$iv15;
            }
            if (node instanceof FocusPropertiesModifierNode) {
                int i10 = 0;
                i3 = 0;
                mask = other$iv8;
            }
            if (node instanceof FocusEventModifierNode) {
                int i16 = 0;
                i3 = 0;
                mask = other$iv10;
            }
            if (node instanceof KeyInputModifierNode) {
                int i15 = 0;
                i3 = 0;
                mask = other$iv13;
            }
            if (node instanceof RotaryInputModifierNode) {
                int i11 = 0;
                i3 = 0;
                mask = other$iv9;
            }
            if (node instanceof CompositionLocalConsumerModifierNode) {
                int i14 = 0;
                i3 = 0;
                mask = other$iv4;
            }
            if (node instanceof SoftKeyboardInterceptionModifierNode) {
                int i13 = 0;
                i3 = 0;
                mask = other$iv5;
            }
            if (node instanceof TraversableNode) {
                int i12 = 0;
                i3 = 0;
                mask = other$iv16;
            }
            classToKindSetMap.set(classKeyForObject, mask);
        }
        return i2;
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        int mask;
        Object obj;
        int i2;
        Modifier.Node node$iv;
        Modifier.Node node2;
        int i;
        int nodeKindSetFromIncludingDelegates;
        if (node instanceof DelegatingNode) {
            int i3 = 0;
            mask = (DelegatingNode)node.getSelfKindSet$ui_release();
            i2 = 0;
            node$iv = (DelegatingNode)node.getDelegate$ui_release();
            while (node$iv != null) {
                i = 0;
                mask |= nodeKindSetFromIncludingDelegates;
                node$iv = node$iv.getChild$ui_release();
            }
        } else {
            mask = NodeKindKt.calculateNodeKindSetFrom(node);
        }
        return mask;
    }

    public static final boolean contains-64DMado(int $this$contains_u2d64DMado, int value) {
        int i;
        final int i2 = 0;
        i = $this$contains_u2d64DMado & value != 0 ? 1 : 0;
        return i;
    }

    public static final boolean getIncludeSelfInTraversal-H91voCI(int $this$includeSelfInTraversal) {
        int i;
        int i2 = 0;
        i = constructor-impl &= $this$includeSelfInTraversal != 0 ? 1 : 0;
        return i;
    }

    private static void getInserted$annotations() {
    }

    private static void getRemoved$annotations() {
    }

    private static void getUpdated$annotations() {
    }

    public static final int or-64DMado(int $this$or_u2d64DMado, int other) {
        final int i = 0;
        return $this$or_u2d64DMado | other;
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode $this$scheduleInvalidationOfAssociatedFocusTargets) {
        androidx.compose.ui.node.DelegatableNode delegatableNode;
        int $this$visitChildren_u2d6rFNWt0$iv;
        int capacity$iv$iv$iv$iv;
        Modifier.Node next$iv$iv;
        int type$iv;
        int arr2;
        int node2;
        int node$iv$iv2;
        Modifier.Node[] arr;
        int i;
        Modifier.Node[] node$iv$iv;
        int count$iv$iv;
        int this_$iv$iv$iv;
        int i7;
        Modifier.Node[] objArr2;
        int i10;
        int i9;
        Modifier.Node[] node$iv$iv3;
        Modifier.Node[] objArr;
        int i3;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i2;
        Object $this$visitChildren_u2d6rFNWt0$iv2;
        int this_$iv$iv$iv2;
        int i8;
        int i6;
        int type$iv2;
        int i5;
        int i4;
        delegatableNode = $this$scheduleInvalidationOfAssociatedFocusTargets;
        int i12 = 0;
        type$iv = NodeKind.constructor-impl(1024);
        arr2 = 0;
        final int i14 = type$iv;
        final androidx.compose.ui.node.DelegatableNode delegatableNode2 = delegatableNode;
        final int i15 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            int i16 = 0;
            node$iv$iv2 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode2.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, delegatableNode2.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i17 = 0;
                count$iv$iv = 1;
                node2 = mutableVector2.removeAt(size -= count$iv$iv);
                if (aggregateChildKindSet$ui_release &= i14 == 0) {
                } else {
                }
                node$iv$iv2 = node2;
                while (node$iv$iv2 != 0) {
                    type$iv2 = type$iv;
                    i5 = arr2;
                    int $this$visitChildren_u2d6rFNWt0$iv3 = count$iv$iv;
                    node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                    delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                    i = 0;
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                type$iv2 = type$iv;
                i5 = arr2;
                i = 0;
                if (kindSet$ui_release &= i14 != null) {
                } else {
                }
                type$iv2 = type$iv;
                i5 = arr2;
                $this$visitChildren_u2d6rFNWt0$iv3 = count$iv$iv;
                node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                i = 0;
                i7 = 0;
                i10 = 0;
                i9 = 0;
                int i18 = 0;
                node$iv$iv = node$iv$iv3;
                while (node$iv$iv != null) {
                    if (node$iv$iv instanceof FocusTargetNode) {
                    } else {
                    }
                    objArr = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                    type$iv2 = type$iv;
                    i5 = arr2;
                    $this$visitChildren_u2d6rFNWt0$iv = 1;
                    node$iv$iv = DelegatableNodeKt.access$pop(i9);
                    count$iv$iv = $this$visitChildren_u2d6rFNWt0$iv;
                    delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                    type$iv = type$iv2;
                    arr2 = i5;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    i3 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i2 = 0;
                        i8 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                        type$iv2 = type$iv;
                        i5 = arr2;
                        next$iv$iv = node;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                        type$iv = type$iv2;
                        arr2 = i5;
                        $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                        if (this_$iv$iv$iv++ == 1) {
                        } else {
                        }
                        if (i9 == 0) {
                        } else {
                        }
                        type$iv2 = type$iv;
                        i5 = arr2;
                        capacity$iv$iv$iv$iv = 0;
                        type$iv = i9;
                        arr2 = node$iv$iv;
                        if (arr2 != null && type$iv != null) {
                        }
                        if (type$iv != null) {
                        } else {
                        }
                        next$iv$iv = node;
                        i9 = type$iv;
                        type$iv.add(node);
                        if (type$iv != null) {
                        }
                        node$iv$iv = 0;
                        type$iv.add(arr2);
                        i8 = i11;
                        int $i$f$mutableVectorOf = 16;
                        i6 = 0;
                        type$iv2 = type$iv;
                        i5 = arr2;
                        i4 = $i$f$mutableVectorOf;
                        type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv = node;
                        type$iv2 = type$iv;
                        i5 = arr2;
                        next$iv$iv = node;
                        this_$iv$iv$iv2 = 1;
                    }
                    $this$visitChildren_u2d6rFNWt0$iv = 1;
                    if (this_$iv$iv$iv == $this$visitChildren_u2d6rFNWt0$iv) {
                    } else {
                    }
                    count$iv$iv = $this$visitChildren_u2d6rFNWt0$iv;
                    delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                    type$iv = type$iv2;
                    arr2 = i5;
                    node = node$iv$iv$iv;
                    i2 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                    type$iv2 = type$iv;
                    i5 = arr2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                    type$iv = type$iv2;
                    arr2 = i5;
                    $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                    if (this_$iv$iv$iv++ == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    type$iv2 = type$iv;
                    i5 = arr2;
                    capacity$iv$iv$iv$iv = 0;
                    type$iv = i9;
                    arr2 = node$iv$iv;
                    if (arr2 != null && type$iv != null) {
                    }
                    if (type$iv != null) {
                    } else {
                    }
                    next$iv$iv = node;
                    i9 = type$iv;
                    type$iv.add(node);
                    if (type$iv != null) {
                    }
                    node$iv$iv = 0;
                    type$iv.add(arr2);
                    i8 = i11;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    type$iv2 = type$iv;
                    i5 = arr2;
                    i4 = $i$f$mutableVectorOf;
                    type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node;
                    type$iv2 = type$iv;
                    i5 = arr2;
                    next$iv$iv = node;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    objArr = 0;
                    FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode)node$iv$iv);
                    $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                    type$iv2 = type$iv;
                    i5 = arr2;
                    $this$visitChildren_u2d6rFNWt0$iv = 1;
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                type$iv2 = type$iv;
                i5 = arr2;
                i = 0;
                if (node$iv$iv instanceof FocusTargetNode) {
                } else {
                }
                objArr = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                type$iv2 = type$iv;
                i5 = arr2;
                $this$visitChildren_u2d6rFNWt0$iv = 1;
                node$iv$iv = DelegatableNodeKt.access$pop(i9);
                count$iv$iv = $this$visitChildren_u2d6rFNWt0$iv;
                delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                type$iv = type$iv2;
                arr2 = i5;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv = 0;
                i3 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i2 = 0;
                    i8 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                    type$iv2 = type$iv;
                    i5 = arr2;
                    next$iv$iv = node;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                    type$iv = type$iv2;
                    arr2 = i5;
                    $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                    if (this_$iv$iv$iv++ == 1) {
                    } else {
                    }
                    if (i9 == 0) {
                    } else {
                    }
                    type$iv2 = type$iv;
                    i5 = arr2;
                    capacity$iv$iv$iv$iv = 0;
                    type$iv = i9;
                    arr2 = node$iv$iv;
                    if (arr2 != null && type$iv != null) {
                    }
                    if (type$iv != null) {
                    } else {
                    }
                    next$iv$iv = node;
                    i9 = type$iv;
                    type$iv.add(node);
                    if (type$iv != null) {
                    }
                    node$iv$iv = 0;
                    type$iv.add(arr2);
                    i8 = i11;
                    $i$f$mutableVectorOf = 16;
                    i6 = 0;
                    type$iv2 = type$iv;
                    i5 = arr2;
                    i4 = $i$f$mutableVectorOf;
                    type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv = node;
                    type$iv2 = type$iv;
                    i5 = arr2;
                    next$iv$iv = node;
                    this_$iv$iv$iv2 = 1;
                }
                $this$visitChildren_u2d6rFNWt0$iv = 1;
                if (this_$iv$iv$iv == $this$visitChildren_u2d6rFNWt0$iv) {
                } else {
                }
                count$iv$iv = $this$visitChildren_u2d6rFNWt0$iv;
                delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                type$iv = type$iv2;
                arr2 = i5;
                node = node$iv$iv$iv;
                i2 = 0;
                i8 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                type$iv2 = type$iv;
                i5 = arr2;
                next$iv$iv = node;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                delegatableNode = $this$visitChildren_u2d6rFNWt0$iv2;
                type$iv = type$iv2;
                arr2 = i5;
                $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                if (this_$iv$iv$iv++ == 1) {
                } else {
                }
                if (i9 == 0) {
                } else {
                }
                type$iv2 = type$iv;
                i5 = arr2;
                capacity$iv$iv$iv$iv = 0;
                type$iv = i9;
                arr2 = node$iv$iv;
                if (arr2 != null && type$iv != null) {
                }
                if (type$iv != null) {
                } else {
                }
                next$iv$iv = node;
                i9 = type$iv;
                type$iv.add(node);
                if (type$iv != null) {
                }
                node$iv$iv = 0;
                type$iv.add(arr2);
                i8 = i11;
                $i$f$mutableVectorOf = 16;
                i6 = 0;
                type$iv2 = type$iv;
                i5 = arr2;
                i4 = $i$f$mutableVectorOf;
                type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv = node;
                type$iv2 = type$iv;
                i5 = arr2;
                next$iv$iv = node;
                this_$iv$iv$iv2 = 1;
                this_$iv$iv$iv = 1;
                objArr = 0;
                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode)node$iv$iv);
                $this$visitChildren_u2d6rFNWt0$iv2 = delegatableNode;
                type$iv2 = type$iv;
                i5 = arr2;
                $this$visitChildren_u2d6rFNWt0$iv = 1;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
            }
        }
        androidx.compose.ui.node.DelegatableNode delegatableNode3 = delegatableNode;
        int i19 = type$iv;
        int $this$visitChildren_u2d6rFNWt0$iv5 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw illegalStateException;
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode $this$specifiesCanFocusProperty) {
        CanFocusChecker.INSTANCE.reset();
        $this$specifiesCanFocusProperty.applyFocusProperties((FocusProperties)CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }
}
