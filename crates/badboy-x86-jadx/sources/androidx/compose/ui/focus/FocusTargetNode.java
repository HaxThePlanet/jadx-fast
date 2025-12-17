package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00015B\u0005¢\u0006\u0002\u0010\u0006J\r\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\u0008\"J/\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!0'H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*J/\u0010+\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!0'H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008,\u0010*J\r\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\u0008/J\u0008\u00100\u001a\u00020!H\u0002J\r\u00101\u001a\u00020!H\u0000¢\u0006\u0002\u00082J\u0008\u00103\u001a\u00020!H\u0016J\u0008\u00104\u001a\u00020!H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c8V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\u0008\u000f\u0010\u0006\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0015X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00066", d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "committedFocusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "focusState", "getFocusState$annotations", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "isProcessingCustomEnter", "", "isProcessingCustomExit", "previouslyFocusedChildHash", "", "getPreviouslyFocusedChildHash", "()I", "setPreviouslyFocusedChildHash", "(I)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "commitFocusState", "", "commitFocusState$ui_release", "fetchCustomEnter", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusRequester;", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "initializeFocusState", "invalidateFocus", "invalidateFocus$ui_release", "onDetach", "onObservedReadsChanged", "FocusTargetElement", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, androidx.compose.ui.focus.FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {

    public static final int $stable = 8;
    private androidx.compose.ui.focus.FocusStateImpl committedFocusState;
    private boolean isProcessingCustomEnter;
    private boolean isProcessingCustomExit;
    private int previouslyFocusedChildHash;
    private final boolean shouldAutoInvalidate;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008À\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u000c\u0010\u000e\u001a\u00020\u000c*\u00020\u000fH\u0016¨\u0006\u0010", d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FocusTargetElement extends ModifierNodeElement<androidx.compose.ui.focus.FocusTargetNode> {

        public static final int $stable;
        public static final androidx.compose.ui.focus.FocusTargetNode.FocusTargetElement INSTANCE;
        static {
            FocusTargetNode.FocusTargetElement focusTargetElement = new FocusTargetNode.FocusTargetElement();
            FocusTargetNode.FocusTargetElement.INSTANCE = focusTargetElement;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public Modifier.Node create() {
            return (Modifier.Node)create();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public androidx.compose.ui.focus.FocusTargetNode create() {
            FocusTargetNode focusTargetNode = new FocusTargetNode();
            return focusTargetNode;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            int i;
            i = other == this ? 1 : 0;
            return i;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return "focusTarget".hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            $this$inspectableProperties.setName("focusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(Modifier.Node node) {
            update((FocusTargetNode)node);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(androidx.compose.ui.focus.FocusTargetNode node) {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int ordinal4;
            int[] iArr = new int[values.length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            FocusTargetNode.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    public static final boolean access$isProcessingCustomEnter$p(androidx.compose.ui.focus.FocusTargetNode $this) {
        return $this.isProcessingCustomEnter;
    }

    public static final boolean access$isProcessingCustomExit$p(androidx.compose.ui.focus.FocusTargetNode $this) {
        return $this.isProcessingCustomExit;
    }

    public static final void access$setProcessingCustomEnter$p(androidx.compose.ui.focus.FocusTargetNode $this, boolean <set-?>) {
        $this.isProcessingCustomEnter = <set-?>;
    }

    public static final void access$setProcessingCustomExit$p(androidx.compose.ui.focus.FocusTargetNode $this, boolean <set-?>) {
        $this.isProcessingCustomExit = <set-?>;
    }

    public static void getFocusState$annotations() {
    }

    private final void initializeFocusState() {
        androidx.compose.ui.focus.FocusStateImpl activeParent;
        boolean initializeFocusState$isInActiveSubTree;
        if (FocusTargetNode.initializeFocusState$isInitialized(this)) {
        } else {
            androidx.compose.ui.focus.FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
            int i = 0;
            final int i2 = 0;
            if (FocusTransactionManager.access$getOngoingTransaction$p(requireTransactionManager)) {
                FocusTransactionManager.access$cancelTransaction(requireTransactionManager);
            }
            FocusTransactionManager.access$beginTransaction(requireTransactionManager);
            int i3 = 0;
            if (FocusTargetNode.initializeFocusState$isInActiveSubTree(this) && FocusTargetNode.initializeFocusState$hasActiveChild(this)) {
                activeParent = FocusTargetNode.initializeFocusState$hasActiveChild(this) ? FocusStateImpl.ActiveParent : FocusStateImpl.Inactive;
            } else {
            }
            setFocusState(activeParent);
            Unit iNSTANCE = Unit.INSTANCE;
            FocusTransactionManager.access$commitTransaction(requireTransactionManager);
        }
        int $this$iv = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Re-initializing focus target node.".toString());
        throw illegalStateException;
    }

    private static final boolean initializeFocusState$hasActiveChild(androidx.compose.ui.focus.FocusTargetNode this$0) {
        int diveDeeper$iv$iv;
        int type$iv;
        int arr;
        Modifier.Node next$iv$iv;
        int node;
        String str;
        int count$iv$iv2;
        int count$iv$iv;
        Modifier.Node[] node$iv$iv;
        int node$iv$iv3;
        Object obj3;
        int i5;
        Object obj2;
        int i9;
        int i11;
        Object node$iv$iv2;
        int i10;
        int i;
        Object obj;
        int i7;
        Modifier.Node node$iv$iv$iv;
        boolean initializeFocusState$isInitialized;
        int i6;
        int $this$visitSubtreeIf_u2d6rFNWt0$iv;
        int this_$iv$iv$iv;
        int i4;
        int i8;
        int type$iv2;
        int i2;
        int i3;
        int i13 = 0;
        arr = 0;
        final int i15 = type$iv;
        final int i16 = diveDeeper$iv$iv;
        final int i17 = 0;
        int i18 = 0;
        if (!i16.getNode().isAttached()) {
            int i20 = 0;
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        int value$iv$iv$iv = 0;
        count$iv$iv2 = 0;
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = i16.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, i16.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            node = mutableVector.removeAt(size -= count$iv$iv2);
            if (aggregateChildKindSet$ui_release &= i15 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
            type$iv2 = type$iv;
            i2 = arr;
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
            diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv = type$iv2;
            arr = i2;
            node$iv$iv3 = 0;
            node$iv$iv = node;
            while (node$iv$iv != null) {
                if (kindSet$ui_release &= i15 == 0) {
                    break loop_8;
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                type$iv2 = type$iv;
                i2 = arr;
                i = count$iv$iv2;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                count$iv$iv2 = i;
                diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = type$iv2;
                arr = i2;
                node$iv$iv3 = 0;
                i5 = 0;
                i9 = 0;
                i11 = 0;
                int i21 = 0;
                node$iv$iv3 = node$iv$iv2;
                while (node$iv$iv3 != null) {
                    obj = 0;
                    if (kindSet$ui_release2 &= type$iv != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                    type$iv2 = type$iv;
                    i2 = arr;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i11);
                    diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    type$iv = type$iv2;
                    arr = i2;
                    count$iv$iv2 = 1;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i7 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        initializeFocusState$isInitialized = node$iv$iv$iv;
                        i6 = 0;
                        i4 = 0;
                        if (kindSet$ui_release3 &= type$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                        type$iv2 = type$iv;
                        i2 = arr;
                        next$iv$iv = initializeFocusState$isInitialized;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                        type$iv = type$iv2;
                        arr = i2;
                        $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                        if (count$iv$iv++ == 1) {
                        } else {
                        }
                        if (i11 == 0) {
                        } else {
                        }
                        type$iv2 = type$iv;
                        i2 = arr;
                        type$iv = i11;
                        diveDeeper$iv$iv = node$iv$iv3;
                        if (diveDeeper$iv$iv != null && type$iv != 0) {
                        }
                        if (type$iv != 0) {
                        } else {
                        }
                        next$iv$iv = initializeFocusState$isInitialized;
                        i11 = type$iv;
                        type$iv.add(initializeFocusState$isInitialized);
                        if (type$iv != 0) {
                        }
                        node$iv$iv3 = arr;
                        type$iv.add(diveDeeper$iv$iv);
                        i4 = i12;
                        int $i$f$mutableVectorOf = 16;
                        i8 = 0;
                        type$iv2 = type$iv;
                        i2 = arr;
                        i3 = $i$f$mutableVectorOf;
                        type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                        node$iv$iv3 = initializeFocusState$isInitialized;
                        type$iv2 = type$iv;
                        i2 = arr;
                        next$iv$iv = initializeFocusState$isInitialized;
                        this_$iv$iv$iv = 1;
                    }
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    type$iv = type$iv2;
                    arr = i2;
                    count$iv$iv2 = 1;
                    initializeFocusState$isInitialized = node$iv$iv$iv;
                    i6 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                    type$iv2 = type$iv;
                    i2 = arr;
                    next$iv$iv = initializeFocusState$isInitialized;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    type$iv = type$iv2;
                    arr = i2;
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i11 == 0) {
                    } else {
                    }
                    type$iv2 = type$iv;
                    i2 = arr;
                    type$iv = i11;
                    diveDeeper$iv$iv = node$iv$iv3;
                    if (diveDeeper$iv$iv != null && type$iv != 0) {
                    }
                    if (type$iv != 0) {
                    } else {
                    }
                    next$iv$iv = initializeFocusState$isInitialized;
                    i11 = type$iv;
                    type$iv.add(initializeFocusState$isInitialized);
                    if (type$iv != 0) {
                    }
                    node$iv$iv3 = arr;
                    type$iv.add(diveDeeper$iv$iv);
                    i4 = i12;
                    $i$f$mutableVectorOf = 16;
                    i8 = 0;
                    type$iv2 = type$iv;
                    i2 = arr;
                    i3 = $i$f$mutableVectorOf;
                    type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = initializeFocusState$isInitialized;
                    type$iv2 = type$iv;
                    i2 = arr;
                    next$iv$iv = initializeFocusState$isInitialized;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    obj = 0;
                    i7 = count$iv$iv;
                    node$iv$iv$iv = 0;
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                    type$iv2 = type$iv;
                    i2 = arr;
                }
                obj = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                type$iv2 = type$iv;
                i2 = arr;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i11);
                diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = type$iv2;
                arr = i2;
                count$iv$iv2 = 1;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                i7 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    initializeFocusState$isInitialized = node$iv$iv$iv;
                    i6 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                    type$iv2 = type$iv;
                    i2 = arr;
                    next$iv$iv = initializeFocusState$isInitialized;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    type$iv = type$iv2;
                    arr = i2;
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i11 == 0) {
                    } else {
                    }
                    type$iv2 = type$iv;
                    i2 = arr;
                    type$iv = i11;
                    diveDeeper$iv$iv = node$iv$iv3;
                    if (diveDeeper$iv$iv != null && type$iv != 0) {
                    }
                    if (type$iv != 0) {
                    } else {
                    }
                    next$iv$iv = initializeFocusState$isInitialized;
                    i11 = type$iv;
                    type$iv.add(initializeFocusState$isInitialized);
                    if (type$iv != 0) {
                    }
                    node$iv$iv3 = arr;
                    type$iv.add(diveDeeper$iv$iv);
                    i4 = i12;
                    $i$f$mutableVectorOf = 16;
                    i8 = 0;
                    type$iv2 = type$iv;
                    i2 = arr;
                    i3 = $i$f$mutableVectorOf;
                    type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = initializeFocusState$isInitialized;
                    type$iv2 = type$iv;
                    i2 = arr;
                    next$iv$iv = initializeFocusState$isInitialized;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = type$iv2;
                arr = i2;
                count$iv$iv2 = 1;
                initializeFocusState$isInitialized = node$iv$iv$iv;
                i6 = 0;
                i4 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                type$iv2 = type$iv;
                i2 = arr;
                next$iv$iv = initializeFocusState$isInitialized;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = type$iv2;
                arr = i2;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                if (count$iv$iv++ == 1) {
                } else {
                }
                if (i11 == 0) {
                } else {
                }
                type$iv2 = type$iv;
                i2 = arr;
                type$iv = i11;
                diveDeeper$iv$iv = node$iv$iv3;
                if (diveDeeper$iv$iv != null && type$iv != 0) {
                }
                if (type$iv != 0) {
                } else {
                }
                next$iv$iv = initializeFocusState$isInitialized;
                i11 = type$iv;
                type$iv.add(initializeFocusState$isInitialized);
                if (type$iv != 0) {
                }
                node$iv$iv3 = arr;
                type$iv.add(diveDeeper$iv$iv);
                i4 = i12;
                $i$f$mutableVectorOf = 16;
                i8 = 0;
                type$iv2 = type$iv;
                i2 = arr;
                i3 = $i$f$mutableVectorOf;
                type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = initializeFocusState$isInitialized;
                type$iv2 = type$iv;
                i2 = arr;
                next$iv$iv = initializeFocusState$isInitialized;
                this_$iv$iv$iv = 1;
                count$iv$iv = 1;
                obj = 0;
                i7 = count$iv$iv;
                node$iv$iv$iv = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                type$iv2 = type$iv;
                i2 = arr;
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
            type$iv2 = type$iv;
            i2 = arr;
            if (kindSet$ui_release &= i15 != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
            type$iv2 = type$iv;
            i2 = arr;
            i = count$iv$iv2;
            node$iv$iv = node$iv$iv.getChild$ui_release();
            count$iv$iv2 = i;
            diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv = type$iv2;
            arr = i2;
            node$iv$iv3 = 0;
            i5 = 0;
            i9 = 0;
            i11 = 0;
            i21 = 0;
            node$iv$iv3 = node$iv$iv2;
            while (node$iv$iv3 != null) {
                obj = 0;
                if (kindSet$ui_release2 &= type$iv != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                type$iv2 = type$iv;
                i2 = arr;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i11);
                diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = type$iv2;
                arr = i2;
                count$iv$iv2 = 1;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                i7 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    initializeFocusState$isInitialized = node$iv$iv$iv;
                    i6 = 0;
                    i4 = 0;
                    if (kindSet$ui_release3 &= type$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                    type$iv2 = type$iv;
                    i2 = arr;
                    next$iv$iv = initializeFocusState$isInitialized;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                    type$iv = type$iv2;
                    arr = i2;
                    $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                    if (count$iv$iv++ == 1) {
                    } else {
                    }
                    if (i11 == 0) {
                    } else {
                    }
                    type$iv2 = type$iv;
                    i2 = arr;
                    type$iv = i11;
                    diveDeeper$iv$iv = node$iv$iv3;
                    if (diveDeeper$iv$iv != null && type$iv != 0) {
                    }
                    if (type$iv != 0) {
                    } else {
                    }
                    next$iv$iv = initializeFocusState$isInitialized;
                    i11 = type$iv;
                    type$iv.add(initializeFocusState$isInitialized);
                    if (type$iv != 0) {
                    }
                    node$iv$iv3 = arr;
                    type$iv.add(diveDeeper$iv$iv);
                    i4 = i12;
                    $i$f$mutableVectorOf = 16;
                    i8 = 0;
                    type$iv2 = type$iv;
                    i2 = arr;
                    i3 = $i$f$mutableVectorOf;
                    type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                    node$iv$iv3 = initializeFocusState$isInitialized;
                    type$iv2 = type$iv;
                    i2 = arr;
                    next$iv$iv = initializeFocusState$isInitialized;
                    this_$iv$iv$iv = 1;
                }
                if (count$iv$iv == 1) {
                } else {
                }
                diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = type$iv2;
                arr = i2;
                count$iv$iv2 = 1;
                initializeFocusState$isInitialized = node$iv$iv$iv;
                i6 = 0;
                i4 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                type$iv2 = type$iv;
                i2 = arr;
                next$iv$iv = initializeFocusState$isInitialized;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = type$iv2;
                arr = i2;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                if (count$iv$iv++ == 1) {
                } else {
                }
                if (i11 == 0) {
                } else {
                }
                type$iv2 = type$iv;
                i2 = arr;
                type$iv = i11;
                diveDeeper$iv$iv = node$iv$iv3;
                if (diveDeeper$iv$iv != null && type$iv != 0) {
                }
                if (type$iv != 0) {
                } else {
                }
                next$iv$iv = initializeFocusState$isInitialized;
                i11 = type$iv;
                type$iv.add(initializeFocusState$isInitialized);
                if (type$iv != 0) {
                }
                node$iv$iv3 = arr;
                type$iv.add(diveDeeper$iv$iv);
                i4 = i12;
                $i$f$mutableVectorOf = 16;
                i8 = 0;
                type$iv2 = type$iv;
                i2 = arr;
                i3 = $i$f$mutableVectorOf;
                type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = initializeFocusState$isInitialized;
                type$iv2 = type$iv;
                i2 = arr;
                next$iv$iv = initializeFocusState$isInitialized;
                this_$iv$iv$iv = 1;
                count$iv$iv = 1;
                obj = 0;
                i7 = count$iv$iv;
                node$iv$iv$iv = 0;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                type$iv2 = type$iv;
                i2 = arr;
            }
            if (1 != 0) {
            } else {
            }
            diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv = type$iv2;
            arr = i2;
            node$iv$iv3 = 0;
            obj = 0;
            if (kindSet$ui_release2 &= type$iv != 0) {
            } else {
            }
            count$iv$iv = 0;
            if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
            type$iv2 = type$iv;
            i2 = arr;
            node$iv$iv3 = DelegatableNodeKt.access$pop(i11);
            diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv = type$iv2;
            arr = i2;
            count$iv$iv2 = 1;
            if (node$iv$iv3 instanceof DelegatingNode) {
            } else {
            }
            count$iv$iv = 0;
            i7 = 0;
            node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
            while (node$iv$iv$iv != null) {
                initializeFocusState$isInitialized = node$iv$iv$iv;
                i6 = 0;
                i4 = 0;
                if (kindSet$ui_release3 &= type$iv != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                type$iv2 = type$iv;
                i2 = arr;
                next$iv$iv = initializeFocusState$isInitialized;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                type$iv = type$iv2;
                arr = i2;
                $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
                if (count$iv$iv++ == 1) {
                } else {
                }
                if (i11 == 0) {
                } else {
                }
                type$iv2 = type$iv;
                i2 = arr;
                type$iv = i11;
                diveDeeper$iv$iv = node$iv$iv3;
                if (diveDeeper$iv$iv != null && type$iv != 0) {
                }
                if (type$iv != 0) {
                } else {
                }
                next$iv$iv = initializeFocusState$isInitialized;
                i11 = type$iv;
                type$iv.add(initializeFocusState$isInitialized);
                if (type$iv != 0) {
                }
                node$iv$iv3 = arr;
                type$iv.add(diveDeeper$iv$iv);
                i4 = i12;
                $i$f$mutableVectorOf = 16;
                i8 = 0;
                type$iv2 = type$iv;
                i2 = arr;
                i3 = $i$f$mutableVectorOf;
                type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                node$iv$iv3 = initializeFocusState$isInitialized;
                type$iv2 = type$iv;
                i2 = arr;
                next$iv$iv = initializeFocusState$isInitialized;
                this_$iv$iv$iv = 1;
            }
            if (count$iv$iv == 1) {
            } else {
            }
            diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv = type$iv2;
            arr = i2;
            count$iv$iv2 = 1;
            initializeFocusState$isInitialized = node$iv$iv$iv;
            i6 = 0;
            i4 = 0;
            if (kindSet$ui_release3 &= type$iv != 0) {
            } else {
            }
            this_$iv$iv$iv = 0;
            if (this_$iv$iv$iv != 0) {
            } else {
            }
            $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
            type$iv2 = type$iv;
            i2 = arr;
            next$iv$iv = initializeFocusState$isInitialized;
            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
            diveDeeper$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv;
            type$iv = type$iv2;
            arr = i2;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
            if (count$iv$iv++ == 1) {
            } else {
            }
            if (i11 == 0) {
            } else {
            }
            type$iv2 = type$iv;
            i2 = arr;
            type$iv = i11;
            diveDeeper$iv$iv = node$iv$iv3;
            if (diveDeeper$iv$iv != null && type$iv != 0) {
            }
            if (type$iv != 0) {
            } else {
            }
            next$iv$iv = initializeFocusState$isInitialized;
            i11 = type$iv;
            type$iv.add(initializeFocusState$isInitialized);
            if (type$iv != 0) {
            }
            node$iv$iv3 = arr;
            type$iv.add(diveDeeper$iv$iv);
            i4 = i12;
            $i$f$mutableVectorOf = 16;
            i8 = 0;
            type$iv2 = type$iv;
            i2 = arr;
            i3 = $i$f$mutableVectorOf;
            type$iv = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
            node$iv$iv3 = initializeFocusState$isInitialized;
            type$iv2 = type$iv;
            i2 = arr;
            next$iv$iv = initializeFocusState$isInitialized;
            this_$iv$iv$iv = 1;
            count$iv$iv = 1;
            obj = 0;
            i7 = count$iv$iv;
            node$iv$iv$iv = 0;
            $this$visitSubtreeIf_u2d6rFNWt0$iv = diveDeeper$iv$iv;
            type$iv2 = type$iv;
            i2 = arr;
        }
        return 0;
    }

    private static final boolean initializeFocusState$isInActiveSubTree(androidx.compose.ui.focus.FocusTargetNode this$0) {
        DelegatableNode count$iv$iv2;
        boolean $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int tail$ui_release;
        int type$iv2;
        Modifier.Node type$iv;
        int $i$f$mutableVectorOf;
        int includeSelf$iv;
        Modifier.Node node$iv$iv;
        LayoutNode layout$iv$iv;
        Modifier.Node node$iv$iv3;
        Modifier.Node head$ui_release;
        int i3;
        void v;
        Modifier.Node node;
        int i8;
        int stack$iv$iv;
        Modifier.Node node$iv$iv2;
        int i5;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
        int this_$iv$iv$iv;
        Modifier.Node node2;
        int initializeFocusState$isInitialized;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node3;
        int i6;
        int type$iv3;
        int this_$iv$iv$iv2;
        int count$iv$iv;
        int i;
        int i7;
        int i4;
        int i2;
        count$iv$iv2 = this$0;
        int i9 = 0;
        type$iv2 = NodeKind.constructor-impl(1024);
        includeSelf$iv = 0;
        final int i12 = 0;
        final int i13 = type$iv2;
        final DelegatableNode delegatableNode = count$iv$iv2;
        final int i14 = 0;
        if (!delegatableNode.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode.getNode().getParent$ui_release();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i13 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                type$iv3 = type$iv2;
                i4 = includeSelf$iv;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                count$iv$iv2 = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && count$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv = tail$ui_release;
                count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv2 = type$iv3;
                includeSelf$iv = i4;
                count$iv$iv2 = layout$iv$iv.getNodes$ui_release();
                if (count$iv$iv2 != null) {
                } else {
                }
                tail$ui_release = count$iv$iv2.getTail$ui_release();
                while (node$iv$iv != null) {
                    if (kindSet$ui_release &= i13 == 0) {
                        break loop_4;
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv2 = type$iv3;
                    includeSelf$iv = i4;
                    v = 0;
                    i8 = 0;
                    stack$iv$iv = 0;
                    int i16 = 0;
                    node$iv$iv3 = node$iv$iv2;
                    while (node$iv$iv3 != null) {
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                        node2 = 0;
                        if (kindSet$ui_release2 &= type$iv2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        type$iv3 = type$iv2;
                        i4 = includeSelf$iv;
                        node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv);
                        count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        type$iv2 = type$iv3;
                        includeSelf$iv = i4;
                        if (node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = 0;
                        initializeFocusState$isInitialized = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node3 = node$iv$iv$iv;
                            i6 = 0;
                            count$iv$iv = 0;
                            if (kindSet$ui_release3 &= type$iv2 != 0) {
                            } else {
                            }
                            this_$iv$iv$iv2 = 0;
                            if (this_$iv$iv$iv2 != 0) {
                            } else {
                            }
                            type$iv3 = type$iv2;
                            i4 = includeSelf$iv;
                            type$iv = node3;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            type$iv2 = type$iv3;
                            includeSelf$iv = i4;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv++;
                            type$iv3 = type$iv2;
                            if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                            } else {
                            }
                            if (stack$iv$iv == 0) {
                            } else {
                            }
                            count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                            i4 = includeSelf$iv;
                            $i$f$mutableVectorOf = stack$iv$iv;
                            stack$iv$iv = $i$f$mutableVectorOf;
                            Modifier.Node node4 = node$iv$iv3;
                            if (node4 != null && stack$iv$iv != 0) {
                            }
                            if (stack$iv$iv != 0) {
                            } else {
                            }
                            type$iv = node3;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                            stack$iv$iv.add(node3);
                            if (stack$iv$iv != 0) {
                            }
                            node$iv$iv3 = $i$f$mutableVectorOf;
                            stack$iv$iv.add(node4);
                            count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                            int count$iv$iv3 = 16;
                            i = 0;
                            i7 = i10;
                            i4 = includeSelf$iv;
                            i2 = count$iv$iv3;
                            $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                            node$iv$iv3 = node3;
                            i4 = includeSelf$iv;
                            type$iv = node3;
                            this_$iv$iv$iv2 = 1;
                        }
                        if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                        } else {
                        }
                        count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                        type$iv2 = type$iv3;
                        includeSelf$iv = i4;
                        node3 = node$iv$iv$iv;
                        i6 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release3 &= type$iv2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        type$iv3 = type$iv2;
                        i4 = includeSelf$iv;
                        type$iv = node3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        type$iv2 = type$iv3;
                        includeSelf$iv = i4;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv++;
                        type$iv3 = type$iv2;
                        if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i4 = includeSelf$iv;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv3;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        type$iv = node3;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv3 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        count$iv$iv3 = 16;
                        i = 0;
                        i7 = i10;
                        i4 = includeSelf$iv;
                        i2 = count$iv$iv3;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                        node$iv$iv3 = node3;
                        i4 = includeSelf$iv;
                        type$iv = node3;
                        this_$iv$iv$iv2 = 1;
                        this_$iv$iv$iv = 1;
                        this_$iv$iv$iv = node$iv$iv3;
                        node2 = 0;
                        type$iv3 = type$iv2;
                        i4 = includeSelf$iv;
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                    node2 = 0;
                    if (kindSet$ui_release2 &= type$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv2 = type$iv3;
                    includeSelf$iv = i4;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = 0;
                    initializeFocusState$isInitialized = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i6 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release3 &= type$iv2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        type$iv3 = type$iv2;
                        i4 = includeSelf$iv;
                        type$iv = node3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        type$iv2 = type$iv3;
                        includeSelf$iv = i4;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv++;
                        type$iv3 = type$iv2;
                        if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i4 = includeSelf$iv;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv3;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        type$iv = node3;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv3 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        count$iv$iv3 = 16;
                        i = 0;
                        i7 = i10;
                        i4 = includeSelf$iv;
                        i2 = count$iv$iv3;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                        node$iv$iv3 = node3;
                        i4 = includeSelf$iv;
                        type$iv = node3;
                        this_$iv$iv$iv2 = 1;
                    }
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                    } else {
                    }
                    count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv2 = type$iv3;
                    includeSelf$iv = i4;
                    node3 = node$iv$iv$iv;
                    i6 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                    type$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv2 = type$iv3;
                    includeSelf$iv = i4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv++;
                    type$iv3 = type$iv2;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i4 = includeSelf$iv;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv3;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    type$iv = node3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv3 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    count$iv$iv3 = 16;
                    i = 0;
                    i7 = i10;
                    i4 = includeSelf$iv;
                    i2 = count$iv$iv3;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                    node$iv$iv3 = node3;
                    i4 = includeSelf$iv;
                    type$iv = node3;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv = node$iv$iv3;
                    node2 = 0;
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                type$iv3 = type$iv2;
                i4 = includeSelf$iv;
                if (kindSet$ui_release &= i13 != 0) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                type$iv3 = type$iv2;
                i4 = includeSelf$iv;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv2 = type$iv3;
                includeSelf$iv = i4;
                v = 0;
                i8 = 0;
                stack$iv$iv = 0;
                i16 = 0;
                node$iv$iv3 = node$iv$iv2;
                while (node$iv$iv3 != null) {
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                    node2 = 0;
                    if (kindSet$ui_release2 &= type$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv);
                    count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv2 = type$iv3;
                    includeSelf$iv = i4;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = 0;
                    initializeFocusState$isInitialized = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node3 = node$iv$iv$iv;
                        i6 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release3 &= type$iv2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        type$iv3 = type$iv2;
                        i4 = includeSelf$iv;
                        type$iv = node3;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        type$iv2 = type$iv3;
                        includeSelf$iv = i4;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv++;
                        type$iv3 = type$iv2;
                        if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                        } else {
                        }
                        if (stack$iv$iv == 0) {
                        } else {
                        }
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        i4 = includeSelf$iv;
                        $i$f$mutableVectorOf = stack$iv$iv;
                        stack$iv$iv = $i$f$mutableVectorOf;
                        node4 = node$iv$iv3;
                        if (node4 != null && stack$iv$iv != 0) {
                        }
                        if (stack$iv$iv != 0) {
                        } else {
                        }
                        type$iv = node3;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                        stack$iv$iv.add(node3);
                        if (stack$iv$iv != 0) {
                        }
                        node$iv$iv3 = $i$f$mutableVectorOf;
                        stack$iv$iv.add(node4);
                        count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                        count$iv$iv3 = 16;
                        i = 0;
                        i7 = i10;
                        i4 = includeSelf$iv;
                        i2 = count$iv$iv3;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                        node$iv$iv3 = node3;
                        i4 = includeSelf$iv;
                        type$iv = node3;
                        this_$iv$iv$iv2 = 1;
                    }
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                    } else {
                    }
                    count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv2 = type$iv3;
                    includeSelf$iv = i4;
                    node3 = node$iv$iv$iv;
                    i6 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                    type$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv2 = type$iv3;
                    includeSelf$iv = i4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv++;
                    type$iv3 = type$iv2;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i4 = includeSelf$iv;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv3;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    type$iv = node3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv3 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    count$iv$iv3 = 16;
                    i = 0;
                    i7 = i10;
                    i4 = includeSelf$iv;
                    i2 = count$iv$iv3;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                    node$iv$iv3 = node3;
                    i4 = includeSelf$iv;
                    type$iv = node3;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    this_$iv$iv$iv = node$iv$iv3;
                    node2 = 0;
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                type$iv3 = type$iv2;
                i4 = includeSelf$iv;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = count$iv$iv2;
                node2 = 0;
                if (kindSet$ui_release2 &= type$iv2 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                type$iv3 = type$iv2;
                i4 = includeSelf$iv;
                node$iv$iv3 = DelegatableNodeKt.access$pop(stack$iv$iv);
                count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv2 = type$iv3;
                includeSelf$iv = i4;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = 0;
                initializeFocusState$isInitialized = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node3 = node$iv$iv$iv;
                    i6 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= type$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    type$iv3 = type$iv2;
                    i4 = includeSelf$iv;
                    type$iv = node3;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    type$iv2 = type$iv3;
                    includeSelf$iv = i4;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv++;
                    type$iv3 = type$iv2;
                    if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                    } else {
                    }
                    if (stack$iv$iv == 0) {
                    } else {
                    }
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    i4 = includeSelf$iv;
                    $i$f$mutableVectorOf = stack$iv$iv;
                    stack$iv$iv = $i$f$mutableVectorOf;
                    node4 = node$iv$iv3;
                    if (node4 != null && stack$iv$iv != 0) {
                    }
                    if (stack$iv$iv != 0) {
                    } else {
                    }
                    type$iv = node3;
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                    stack$iv$iv.add(node3);
                    if (stack$iv$iv != 0) {
                    }
                    node$iv$iv3 = $i$f$mutableVectorOf;
                    stack$iv$iv.add(node4);
                    count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                    count$iv$iv3 = 16;
                    i = 0;
                    i7 = i10;
                    i4 = includeSelf$iv;
                    i2 = count$iv$iv3;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                    node$iv$iv3 = node3;
                    i4 = includeSelf$iv;
                    type$iv = node3;
                    this_$iv$iv$iv2 = 1;
                }
                if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                } else {
                }
                count$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv2 = type$iv3;
                includeSelf$iv = i4;
                node3 = node$iv$iv$iv;
                i6 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= type$iv2 != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                type$iv3 = type$iv2;
                i4 = includeSelf$iv;
                type$iv = node3;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                type$iv2 = type$iv3;
                includeSelf$iv = i4;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv++;
                type$iv3 = type$iv2;
                if ($this$visitAncestors_u2dY_u2dYKmho_u24default$iv == 1) {
                } else {
                }
                if (stack$iv$iv == 0) {
                } else {
                }
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                i4 = includeSelf$iv;
                $i$f$mutableVectorOf = stack$iv$iv;
                stack$iv$iv = $i$f$mutableVectorOf;
                node4 = node$iv$iv3;
                if (node4 != null && stack$iv$iv != 0) {
                }
                if (stack$iv$iv != 0) {
                } else {
                }
                type$iv = node3;
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = count$iv$iv;
                stack$iv$iv.add(node3);
                if (stack$iv$iv != 0) {
                }
                node$iv$iv3 = $i$f$mutableVectorOf;
                stack$iv$iv.add(node4);
                count$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
                count$iv$iv3 = 16;
                i = 0;
                i7 = i10;
                i4 = includeSelf$iv;
                i2 = count$iv$iv3;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                node$iv$iv3 = node3;
                i4 = includeSelf$iv;
                type$iv = node3;
                this_$iv$iv$iv2 = 1;
                this_$iv$iv$iv = 1;
                this_$iv$iv$iv = node$iv$iv3;
                node2 = 0;
                type$iv3 = type$iv2;
                i4 = includeSelf$iv;
            }
            return 0;
        }
        DelegatableNode delegatableNode2 = count$iv$iv2;
        int i18 = type$iv2;
        int $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw illegalStateException;
    }

    private static final boolean initializeFocusState$isInitialized(androidx.compose.ui.focus.FocusTargetNode $this$initializeFocusState_u24isInitialized) {
        int i;
        i = $this$initializeFocusState_u24isInitialized.committedFocusState != null ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void commitFocusState$ui_release() {
        final int i = 0;
        final androidx.compose.ui.focus.FocusStateImpl uncommittedFocusState = FocusTargetNodeKt.requireTransactionManager(this).getUncommittedFocusState(this);
        final int i2 = 0;
        if (uncommittedFocusState == null) {
        } else {
            this.committedFocusState = uncommittedFocusState;
        }
        int i3 = 0;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("committing a node that was not updated in the current transaction");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public final void fetchCustomEnter-aToIllA$ui_release(int focusDirection, Function1<? super androidx.compose.ui.focus.FocusRequester, Unit> block) {
        boolean z;
        Object invoke;
        int i;
        androidx.compose.ui.focus.FocusRequester default;
        final int i2 = 0;
        FocusTargetNode.access$setProcessingCustomEnter$p(this, true);
        invoke = fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.box-impl(focusDirection));
        i = 0;
        if (!FocusTargetNode.access$isProcessingCustomEnter$p(this) && (FocusRequester)invoke != FocusRequester.Companion.getDefault()) {
            FocusTargetNode.access$setProcessingCustomEnter$p(this, true);
            invoke = fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.box-impl(focusDirection));
            i = 0;
            if ((FocusRequester)(FocusRequester)invoke != FocusRequester.Companion.getDefault()) {
                block.invoke((FocusRequester)(FocusRequester)invoke);
            }
            FocusTargetNode.access$setProcessingCustomEnter$p(this, false);
        }
    }

    public final void fetchCustomExit-aToIllA$ui_release(int focusDirection, Function1<? super androidx.compose.ui.focus.FocusRequester, Unit> block) {
        boolean z;
        Object invoke;
        int i;
        androidx.compose.ui.focus.FocusRequester default;
        final int i2 = 0;
        FocusTargetNode.access$setProcessingCustomExit$p(this, true);
        invoke = fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.box-impl(focusDirection));
        i = 0;
        if (!FocusTargetNode.access$isProcessingCustomExit$p(this) && (FocusRequester)invoke != FocusRequester.Companion.getDefault()) {
            FocusTargetNode.access$setProcessingCustomExit$p(this, true);
            invoke = fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.box-impl(focusDirection));
            i = 0;
            if ((FocusRequester)(FocusRequester)invoke != FocusRequester.Companion.getDefault()) {
                block.invoke((FocusRequester)(FocusRequester)invoke);
            }
            FocusTargetNode.access$setProcessingCustomExit$p(this, false);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.ui.focus.FocusProperties fetchFocusProperties$ui_release() {
        androidx.compose.ui.focus.FocusPropertiesImpl count$iv$iv3;
        int count$iv$iv;
        int tail$ui_release;
        DelegatableNode delegatableNode;
        int this_$iv$iv$iv2;
        Modifier.Node this_$iv$iv$iv3;
        int type$iv3;
        Modifier.Node type$iv2;
        int constructor-impl;
        int untilType$iv2;
        int untilType$iv;
        Modifier.Node node$iv$iv;
        LayoutNode layout$iv$iv;
        Modifier.Node head$ui_release;
        Modifier.Node node;
        int i2;
        Modifier.Node node$iv$iv3;
        Modifier.Node this_$iv$iv;
        int i6;
        int i4;
        Modifier.Node node$iv$iv2;
        androidx.compose.ui.focus.FocusPropertiesImpl properties2;
        androidx.compose.ui.focus.FocusPropertiesImpl properties;
        int i;
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node2;
        int i3;
        Modifier.Node this_$iv$iv$iv4;
        int this_$iv$iv$iv;
        int count$iv$iv2;
        int i5;
        int i7;
        int type$iv;
        int i8;
        count$iv$iv3 = new FocusPropertiesImpl();
        delegatableNode = this;
        int i11 = 0;
        int i13 = 0;
        int i15 = 0;
        final int i16 = type$iv3 | constructor-impl;
        final int i17 = 1;
        final DelegatableNode delegatableNode2 = delegatableNode;
        final int i18 = 0;
        if (!delegatableNode2.getNode().isAttached()) {
        } else {
            node$iv$iv = delegatableNode2.getNode();
            layout$iv$iv = DelegatableNodeKt.requireLayoutNode(delegatableNode2);
            while (layout$iv$iv != null) {
                if (aggregateChildKindSet$ui_release &= i16 == 0) {
                    break;
                }
                properties2 = count$iv$iv3;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                type$iv = type$iv3;
                i8 = constructor-impl;
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                count$iv$iv3 = layout$iv$iv.getNodes$ui_release();
                if (layout$iv$iv != null && count$iv$iv3 != null) {
                } else {
                }
                tail$ui_release = 0;
                node$iv$iv = tail$ui_release;
                count$iv$iv3 = properties2;
                delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv3 = type$iv;
                constructor-impl = i8;
                count$iv$iv3 = layout$iv$iv.getNodes$ui_release();
                if (count$iv$iv3 != null) {
                } else {
                }
                tail$ui_release = count$iv$iv3.getTail$ui_release();
                while (node$iv$iv != null) {
                    properties2 = count$iv$iv3;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    node$iv$iv = node$iv$iv.getParent$ui_release();
                    count$iv$iv3 = properties2;
                    delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv;
                    constructor-impl = i8;
                    node = node$iv$iv;
                    i2 = 0;
                    i6 = 0;
                    if (kindSet$ui_release3 &= type$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    if (this_$iv$iv != 0) {
                    } else {
                    }
                    properties2 = count$iv$iv3;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    i6 = 0;
                    i4 = 0;
                    int i19 = 0;
                    node$iv$iv3 = node$iv$iv2;
                    while (node$iv$iv3 != null) {
                        properties2 = count$iv$iv3;
                        if (node$iv$iv3 instanceof FocusPropertiesModifierNode) {
                        } else {
                        }
                        int i9 = 0;
                        if (kindSet$ui_release4 &= type$iv3 != 0) {
                        } else {
                        }
                        count$iv$iv = 0;
                        if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        this_$iv$iv$iv2 = 1;
                        untilType$iv2 = 0;
                        node$iv$iv3 = DelegatableNodeKt.access$pop(i4);
                        count$iv$iv3 = properties2;
                        delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                        type$iv3 = type$iv;
                        constructor-impl = i8;
                        if (node$iv$iv3 instanceof DelegatingNode) {
                        } else {
                        }
                        count$iv$iv = 0;
                        i = 0;
                        node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                        while (node$iv$iv$iv != null) {
                            node2 = node$iv$iv$iv;
                            i3 = 0;
                            count$iv$iv2 = 0;
                            if (kindSet$ui_release5 &= type$iv3 != 0) {
                            } else {
                            }
                            this_$iv$iv$iv = 0;
                            if (this_$iv$iv$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv4 = this_$iv$iv$iv3;
                            type$iv = type$iv3;
                            i8 = constructor-impl;
                            type$iv2 = node2;
                            untilType$iv = 0;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            this_$iv$iv$iv3 = this_$iv$iv$iv4;
                            type$iv3 = type$iv;
                            constructor-impl = i8;
                            count$iv$iv++;
                            this_$iv$iv$iv4 = this_$iv$iv$iv3;
                            if (count$iv$iv == 1) {
                            } else {
                            }
                            if (i4 == 0) {
                            } else {
                            }
                            count$iv$iv2 = count$iv$iv;
                            type$iv = type$iv3;
                            i8 = constructor-impl;
                            untilType$iv = 0;
                            this_$iv$iv$iv3 = i4;
                            Modifier.Node node4 = node$iv$iv3;
                            if (node4 != null && this_$iv$iv$iv3 != 0) {
                            }
                            if (this_$iv$iv$iv3 != 0) {
                            } else {
                            }
                            type$iv2 = node2;
                            i4 = this_$iv$iv$iv3;
                            count$iv$iv = count$iv$iv2;
                            this_$iv$iv$iv3.add(node2);
                            if (this_$iv$iv$iv3 != 0) {
                            }
                            node$iv$iv3 = type$iv3;
                            this_$iv$iv$iv3.add(node4);
                            count$iv$iv2 = count$iv$iv;
                            i5 = 0;
                            i7 = i10;
                            type$iv = type$iv3;
                            i8 = constructor-impl;
                            this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                            node$iv$iv3 = node2;
                            type$iv = type$iv3;
                            i8 = constructor-impl;
                            type$iv2 = node2;
                            untilType$iv = 0;
                            this_$iv$iv$iv = 1;
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        untilType$iv2 = 0;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        count$iv$iv3 = properties2;
                        delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                        type$iv3 = type$iv;
                        constructor-impl = i8;
                        node2 = node$iv$iv$iv;
                        i3 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release5 &= type$iv3 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        type$iv2 = node2;
                        untilType$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv3 = this_$iv$iv$iv4;
                        type$iv3 = type$iv;
                        constructor-impl = i8;
                        count$iv$iv++;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i4 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        untilType$iv = 0;
                        this_$iv$iv$iv3 = i4;
                        node4 = node$iv$iv3;
                        if (node4 != null && this_$iv$iv$iv3 != 0) {
                        }
                        if (this_$iv$iv$iv3 != 0) {
                        } else {
                        }
                        type$iv2 = node2;
                        i4 = this_$iv$iv$iv3;
                        count$iv$iv = count$iv$iv2;
                        this_$iv$iv$iv3.add(node2);
                        if (this_$iv$iv$iv3 != 0) {
                        }
                        node$iv$iv3 = type$iv3;
                        this_$iv$iv$iv3.add(node4);
                        count$iv$iv2 = count$iv$iv;
                        i5 = 0;
                        i7 = i10;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv3 = node2;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        type$iv2 = node2;
                        untilType$iv = 0;
                        this_$iv$iv$iv = 1;
                        count$iv$iv = 1;
                        i = 0;
                        $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                        (FocusPropertiesModifierNode)node$iv$iv3.applyFocusProperties((FocusProperties)properties2);
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        this_$iv$iv$iv2 = 1;
                        untilType$iv2 = 0;
                    }
                    properties2 = count$iv$iv3;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    properties2 = count$iv$iv3;
                    if (node$iv$iv3 instanceof FocusPropertiesModifierNode) {
                    } else {
                    }
                    i9 = 0;
                    if (kindSet$ui_release4 &= type$iv3 != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    this_$iv$iv$iv2 = 1;
                    untilType$iv2 = 0;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i4);
                    count$iv$iv3 = properties2;
                    delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv;
                    constructor-impl = i8;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i3 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release5 &= type$iv3 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        type$iv2 = node2;
                        untilType$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv3 = this_$iv$iv$iv4;
                        type$iv3 = type$iv;
                        constructor-impl = i8;
                        count$iv$iv++;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i4 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        untilType$iv = 0;
                        this_$iv$iv$iv3 = i4;
                        node4 = node$iv$iv3;
                        if (node4 != null && this_$iv$iv$iv3 != 0) {
                        }
                        if (this_$iv$iv$iv3 != 0) {
                        } else {
                        }
                        type$iv2 = node2;
                        i4 = this_$iv$iv$iv3;
                        count$iv$iv = count$iv$iv2;
                        this_$iv$iv$iv3.add(node2);
                        if (this_$iv$iv$iv3 != 0) {
                        }
                        node$iv$iv3 = type$iv3;
                        this_$iv$iv$iv3.add(node4);
                        count$iv$iv2 = count$iv$iv;
                        i5 = 0;
                        i7 = i10;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv3 = node2;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        type$iv2 = node2;
                        untilType$iv = 0;
                        this_$iv$iv$iv = 1;
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    untilType$iv2 = 0;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    count$iv$iv3 = properties2;
                    delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv;
                    constructor-impl = i8;
                    node2 = node$iv$iv$iv;
                    i3 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release5 &= type$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    type$iv2 = node2;
                    untilType$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv3 = this_$iv$iv$iv4;
                    type$iv3 = type$iv;
                    constructor-impl = i8;
                    count$iv$iv++;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i4 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    untilType$iv = 0;
                    this_$iv$iv$iv3 = i4;
                    node4 = node$iv$iv3;
                    if (node4 != null && this_$iv$iv$iv3 != 0) {
                    }
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    type$iv2 = node2;
                    i4 = this_$iv$iv$iv3;
                    count$iv$iv = count$iv$iv2;
                    this_$iv$iv$iv3.add(node2);
                    if (this_$iv$iv$iv3 != 0) {
                    }
                    node$iv$iv3 = type$iv3;
                    this_$iv$iv$iv3.add(node4);
                    count$iv$iv2 = count$iv$iv;
                    i5 = 0;
                    i7 = i10;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv3 = node2;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    type$iv2 = node2;
                    untilType$iv = 0;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    i = 0;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                    (FocusPropertiesModifierNode)node$iv$iv3.applyFocusProperties((FocusProperties)properties2);
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    this_$iv$iv$iv2 = 1;
                    untilType$iv2 = 0;
                    this_$iv$iv = 1;
                    i6 = 0;
                    if (kindSet$ui_release2 &= constructor-impl != 0) {
                    } else {
                    }
                    this_$iv$iv = 0;
                    this_$iv$iv = 1;
                }
                properties2 = count$iv$iv3;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                type$iv = type$iv3;
                i8 = constructor-impl;
                properties2 = count$iv$iv3;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                type$iv = type$iv3;
                i8 = constructor-impl;
                node$iv$iv = node$iv$iv.getParent$ui_release();
                count$iv$iv3 = properties2;
                delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv3 = type$iv;
                constructor-impl = i8;
                node = node$iv$iv;
                i2 = 0;
                i6 = 0;
                if (kindSet$ui_release3 &= type$iv3 != 0) {
                } else {
                }
                this_$iv$iv = 0;
                if (this_$iv$iv != 0) {
                } else {
                }
                properties2 = count$iv$iv3;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                type$iv = type$iv3;
                i8 = constructor-impl;
                i6 = 0;
                i4 = 0;
                i19 = 0;
                node$iv$iv3 = node$iv$iv2;
                while (node$iv$iv3 != null) {
                    properties2 = count$iv$iv3;
                    if (node$iv$iv3 instanceof FocusPropertiesModifierNode) {
                    } else {
                    }
                    i9 = 0;
                    if (kindSet$ui_release4 &= type$iv3 != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    this_$iv$iv$iv2 = 1;
                    untilType$iv2 = 0;
                    node$iv$iv3 = DelegatableNodeKt.access$pop(i4);
                    count$iv$iv3 = properties2;
                    delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv;
                    constructor-impl = i8;
                    if (node$iv$iv3 instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    i = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node2 = node$iv$iv$iv;
                        i3 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release5 &= type$iv3 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        type$iv2 = node2;
                        untilType$iv = 0;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        this_$iv$iv$iv3 = this_$iv$iv$iv4;
                        type$iv3 = type$iv;
                        constructor-impl = i8;
                        count$iv$iv++;
                        this_$iv$iv$iv4 = this_$iv$iv$iv3;
                        if (count$iv$iv == 1) {
                        } else {
                        }
                        if (i4 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        untilType$iv = 0;
                        this_$iv$iv$iv3 = i4;
                        node4 = node$iv$iv3;
                        if (node4 != null && this_$iv$iv$iv3 != 0) {
                        }
                        if (this_$iv$iv$iv3 != 0) {
                        } else {
                        }
                        type$iv2 = node2;
                        i4 = this_$iv$iv$iv3;
                        count$iv$iv = count$iv$iv2;
                        this_$iv$iv$iv3.add(node2);
                        if (this_$iv$iv$iv3 != 0) {
                        }
                        node$iv$iv3 = type$iv3;
                        this_$iv$iv$iv3.add(node4);
                        count$iv$iv2 = count$iv$iv;
                        i5 = 0;
                        i7 = i10;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                        node$iv$iv3 = node2;
                        type$iv = type$iv3;
                        i8 = constructor-impl;
                        type$iv2 = node2;
                        untilType$iv = 0;
                        this_$iv$iv$iv = 1;
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    untilType$iv2 = 0;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    count$iv$iv3 = properties2;
                    delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                    type$iv3 = type$iv;
                    constructor-impl = i8;
                    node2 = node$iv$iv$iv;
                    i3 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release5 &= type$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    type$iv2 = node2;
                    untilType$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv3 = this_$iv$iv$iv4;
                    type$iv3 = type$iv;
                    constructor-impl = i8;
                    count$iv$iv++;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i4 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    untilType$iv = 0;
                    this_$iv$iv$iv3 = i4;
                    node4 = node$iv$iv3;
                    if (node4 != null && this_$iv$iv$iv3 != 0) {
                    }
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    type$iv2 = node2;
                    i4 = this_$iv$iv$iv3;
                    count$iv$iv = count$iv$iv2;
                    this_$iv$iv$iv3.add(node2);
                    if (this_$iv$iv$iv3 != 0) {
                    }
                    node$iv$iv3 = type$iv3;
                    this_$iv$iv$iv3.add(node4);
                    count$iv$iv2 = count$iv$iv;
                    i5 = 0;
                    i7 = i10;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv3 = node2;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    type$iv2 = node2;
                    untilType$iv = 0;
                    this_$iv$iv$iv = 1;
                    count$iv$iv = 1;
                    i = 0;
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                    (FocusPropertiesModifierNode)node$iv$iv3.applyFocusProperties((FocusProperties)properties2);
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    this_$iv$iv$iv2 = 1;
                    untilType$iv2 = 0;
                }
                properties2 = count$iv$iv3;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                type$iv = type$iv3;
                i8 = constructor-impl;
                properties2 = count$iv$iv3;
                if (node$iv$iv3 instanceof FocusPropertiesModifierNode) {
                } else {
                }
                i9 = 0;
                if (kindSet$ui_release4 &= type$iv3 != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                type$iv = type$iv3;
                i8 = constructor-impl;
                this_$iv$iv$iv2 = 1;
                untilType$iv2 = 0;
                node$iv$iv3 = DelegatableNodeKt.access$pop(i4);
                count$iv$iv3 = properties2;
                delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv3 = type$iv;
                constructor-impl = i8;
                if (node$iv$iv3 instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                i = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv3.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node2 = node$iv$iv$iv;
                    i3 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release5 &= type$iv3 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    type$iv2 = node2;
                    untilType$iv = 0;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv3 = this_$iv$iv$iv4;
                    type$iv3 = type$iv;
                    constructor-impl = i8;
                    count$iv$iv++;
                    this_$iv$iv$iv4 = this_$iv$iv$iv3;
                    if (count$iv$iv == 1) {
                    } else {
                    }
                    if (i4 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    untilType$iv = 0;
                    this_$iv$iv$iv3 = i4;
                    node4 = node$iv$iv3;
                    if (node4 != null && this_$iv$iv$iv3 != 0) {
                    }
                    if (this_$iv$iv$iv3 != 0) {
                    } else {
                    }
                    type$iv2 = node2;
                    i4 = this_$iv$iv$iv3;
                    count$iv$iv = count$iv$iv2;
                    this_$iv$iv$iv3.add(node2);
                    if (this_$iv$iv$iv3 != 0) {
                    }
                    node$iv$iv3 = type$iv3;
                    this_$iv$iv$iv3.add(node4);
                    count$iv$iv2 = count$iv$iv;
                    i5 = 0;
                    i7 = i10;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                    node$iv$iv3 = node2;
                    type$iv = type$iv3;
                    i8 = constructor-impl;
                    type$iv2 = node2;
                    untilType$iv = 0;
                    this_$iv$iv$iv = 1;
                }
                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                untilType$iv2 = 0;
                if (count$iv$iv == 1) {
                } else {
                }
                count$iv$iv3 = properties2;
                delegatableNode = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
                type$iv3 = type$iv;
                constructor-impl = i8;
                node2 = node$iv$iv$iv;
                i3 = 0;
                count$iv$iv2 = 0;
                if (kindSet$ui_release5 &= type$iv3 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                type$iv = type$iv3;
                i8 = constructor-impl;
                type$iv2 = node2;
                untilType$iv = 0;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                this_$iv$iv$iv3 = this_$iv$iv$iv4;
                type$iv3 = type$iv;
                constructor-impl = i8;
                count$iv$iv++;
                this_$iv$iv$iv4 = this_$iv$iv$iv3;
                if (count$iv$iv == 1) {
                } else {
                }
                if (i4 == 0) {
                } else {
                }
                count$iv$iv2 = count$iv$iv;
                type$iv = type$iv3;
                i8 = constructor-impl;
                untilType$iv = 0;
                this_$iv$iv$iv3 = i4;
                node4 = node$iv$iv3;
                if (node4 != null && this_$iv$iv$iv3 != 0) {
                }
                if (this_$iv$iv$iv3 != 0) {
                } else {
                }
                type$iv2 = node2;
                i4 = this_$iv$iv$iv3;
                count$iv$iv = count$iv$iv2;
                this_$iv$iv$iv3.add(node2);
                if (this_$iv$iv$iv3 != 0) {
                }
                node$iv$iv3 = type$iv3;
                this_$iv$iv$iv3.add(node4);
                count$iv$iv2 = count$iv$iv;
                i5 = 0;
                i7 = i10;
                type$iv = type$iv3;
                i8 = constructor-impl;
                this_$iv$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                node$iv$iv3 = node2;
                type$iv = type$iv3;
                i8 = constructor-impl;
                type$iv2 = node2;
                untilType$iv = 0;
                this_$iv$iv$iv = 1;
                count$iv$iv = 1;
                i = 0;
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
                (FocusPropertiesModifierNode)node$iv$iv3.applyFocusProperties((FocusProperties)properties2);
                type$iv = type$iv3;
                i8 = constructor-impl;
                this_$iv$iv$iv2 = 1;
                untilType$iv2 = 0;
                this_$iv$iv = 1;
                i6 = 0;
                if (kindSet$ui_release2 &= constructor-impl != 0) {
                } else {
                }
                this_$iv$iv = 0;
                this_$iv$iv = 1;
            }
            properties = count$iv$iv3;
            $this$visitSelfAndAncestors_u2d5BbP62I$iv = delegatableNode;
            type$iv = type$iv3;
            i8 = constructor-impl;
            return (FocusProperties)properties;
        }
        androidx.compose.ui.focus.FocusPropertiesImpl properties5 = count$iv$iv3;
        DelegatableNode delegatableNode3 = delegatableNode;
        int properties3 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitAncestors called on an unattached node".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout)getCurrent((ModifierLocal)BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public androidx.compose.ui.focus.FocusState getFocusState() {
        return (FocusState)getFocusState();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public androidx.compose.ui.focus.FocusStateImpl getFocusState() {
        androidx.compose.ui.focus.FocusStateImpl $this$_get_focusState__u24lambda_u240;
        int i;
        $this$_get_focusState__u24lambda_u240 = FocusTargetNodeKt.access$getFocusTransactionManager(this);
        if ($this$_get_focusState__u24lambda_u240 != null) {
            i = 0;
            if ($this$_get_focusState__u24lambda_u240.getUncommittedFocusState(this) == null && this.committedFocusState == null) {
                if (this.committedFocusState == null) {
                    $this$_get_focusState__u24lambda_u240 = FocusStateImpl.Inactive;
                }
            }
        } else {
        }
        return $this$_get_focusState__u24lambda_u240;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int getPreviouslyFocusedChildHash() {
        return this.previouslyFocusedChildHash;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void invalidateFocus$ui_release() {
        int objectRef;
        int[] focusOwner;
        Object element;
        androidx.compose.ui.focus.FocusTargetNode.invalidateFocus.1 anon;
        if (this.committedFocusState == null) {
            initializeFocusState();
        }
        if (/* condition */) {
            objectRef = new Ref.ObjectRef();
            anon = new FocusTargetNode.invalidateFocus.1(objectRef, this);
            ObserverModifierNodeKt.observeReads((Modifier.Node)this, (Function0)anon);
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
                element = 0;
            } else {
                element = objectRef.element;
            }
            if (!element.getCanFocus()) {
                DelegatableNodeKt.requireOwner((DelegatableNode)this).getFocusOwner().clearFocus(true);
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        int requireTransactionManager;
        int[] exit-dhqQ-8s;
        int i;
        Throwable iNSTANCE;
        androidx.compose.ui.focus.FocusStateImpl inactive;
        switch (requireTransactionManager) {
            case 1:
                i = 1;
                DelegatableNodeKt.requireOwner((DelegatableNode)this).getFocusOwner().clearFocus-I7lrPNg(i, i, false, FocusDirection.Companion.getExit-dhqQ-8s());
                FocusTargetNodeKt.invalidateFocusTarget(this);
                break;
            case 2:
                requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
                exit-dhqQ-8s = 0;
                i = 0;
                FocusTransactionManager.access$cancelTransaction(requireTransactionManager);
                FocusTransactionManager.access$beginTransaction(requireTransactionManager);
                int i3 = 0;
                setFocusState(FocusStateImpl.Inactive);
                iNSTANCE = Unit.INSTANCE;
                FocusTransactionManager.access$commitTransaction(requireTransactionManager);
                break;
            default:
        }
        this.committedFocusState = 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onObservedReadsChanged() {
        invalidateFocus$ui_release();
        if (getFocusState() != getFocusState()) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(this);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void setFocusState(androidx.compose.ui.focus.FocusStateImpl value) {
        final int i = 0;
        FocusTargetNodeKt.requireTransactionManager(this).setUncommittedFocusState(this, value);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setPreviouslyFocusedChildHash(int <set-?>) {
        this.previouslyFocusedChildHash = <set-?>;
    }
}
