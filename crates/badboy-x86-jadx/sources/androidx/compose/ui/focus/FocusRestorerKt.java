package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainer.PinnedHandle;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0010\u0008\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0008*\u00020\tH\u0000\u001a\u000c\u0010\n\u001a\u00020\u000b*\u00020\tH\u0001\u001a\u000c\u0010\u000c\u001a\u00020\u000b*\u00020\tH\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"PrevFocusedChild", "", "focusRestorer", "Landroidx/compose/ui/Modifier;", "onRestoreFailed", "Lkotlin/Function0;", "Landroidx/compose/ui/focus/FocusRequester;", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "Landroidx/compose/ui/focus/FocusTargetNode;", "restoreFocusedChild", "", "saveFocusedChild", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusRestorerKt {

    private static final String PrevFocusedChild = "previouslyFocusedChildHash";
    public static final Modifier focusRestorer(Modifier $this$focusRestorer, Function0<androidx.compose.ui.focus.FocusRequester> onRestoreFailed) {
        FocusRestorerElement focusRestorerElement = new FocusRestorerElement(onRestoreFailed);
        return $this$focusRestorer.then((Modifier)focusRestorerElement);
    }

    public static Modifier focusRestorer$default(Modifier modifier, Function0 function02, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return FocusRestorerKt.focusRestorer(modifier, obj1);
    }

    public static final PinnableContainer.PinnedHandle pinFocusedChild(androidx.compose.ui.focus.FocusTargetNode $this$pinFocusedChild) {
        Object activeFocusNode;
        int i;
        androidx.compose.runtime.ProvidableCompositionLocal localPinnableContainer;
        activeFocusNode = FocusTraversalKt.findActiveFocusNode($this$pinFocusedChild);
        activeFocusNode = CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)activeFocusNode, (CompositionLocal)PinnableContainerKt.getLocalPinnableContainer());
        if (activeFocusNode != null && (PinnableContainer)activeFocusNode != null) {
            activeFocusNode = CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)activeFocusNode, (CompositionLocal)PinnableContainerKt.getLocalPinnableContainer());
            if ((PinnableContainer)(PinnableContainer)activeFocusNode != null) {
                i = (PinnableContainer)(PinnableContainer)activeFocusNode.pin();
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final boolean restoreFocusedChild(androidx.compose.ui.focus.FocusTargetNode $this$restoreFocusedChild) {
        androidx.compose.ui.node.CompositionLocalConsumerModifierNode this_$iv$iv$iv;
        boolean restoreFocusedChild;
        int previouslyFocusedChildHash2;
        androidx.compose.ui.node.CompositionLocalConsumerModifierNode previouslyFocusedChildHash;
        Object stack$iv$iv2;
        int this_$iv$iv$iv5;
        int this_$iv$iv$iv3;
        Object localSaveableStateRegistry;
        int i9;
        Object node$iv$iv6;
        Modifier.Node node$iv$iv3;
        Object node$iv$iv4;
        int i11;
        int intValue;
        int node2;
        int node$iv$iv;
        Modifier.Node[] arr;
        int i3;
        int i5;
        int i10;
        Object obj;
        int i6;
        int node$iv$iv2;
        Object stack$iv$iv;
        Object node$iv$iv5;
        int i;
        Modifier.Node node$iv$iv$iv;
        androidx.compose.ui.node.CompositionLocalConsumerModifierNode $this$visitChildren_u2d6rFNWt0$iv;
        Modifier.Node node;
        int i7;
        Object this_$iv$iv$iv4;
        int this_$iv$iv$iv2;
        int count$iv$iv;
        int i8;
        int i2;
        Object obj2;
        int i4;
        this_$iv$iv$iv = $this$restoreFocusedChild;
        previouslyFocusedChildHash2 = CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this_$iv$iv$iv, (CompositionLocal)SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        localSaveableStateRegistry = (SaveableStateRegistry)previouslyFocusedChildHash2.consumeRestored("previouslyFocusedChildHash");
        if (this_$iv$iv$iv.getPreviouslyFocusedChildHash() == 0 && previouslyFocusedChildHash2 != null && localSaveableStateRegistry != null) {
            previouslyFocusedChildHash2 = CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this_$iv$iv$iv, (CompositionLocal)SaveableStateRegistryKt.getLocalSaveableStateRegistry());
            if ((SaveableStateRegistry)previouslyFocusedChildHash2 != null) {
                localSaveableStateRegistry = (SaveableStateRegistry)previouslyFocusedChildHash2.consumeRestored("previouslyFocusedChildHash");
                if (localSaveableStateRegistry != null) {
                    i11 = 0;
                    this_$iv$iv$iv.setPreviouslyFocusedChildHash((Integer)localSaveableStateRegistry.intValue());
                }
            }
        }
        i9 = 0;
        if (this_$iv$iv$iv.getPreviouslyFocusedChildHash() == 0) {
            return i9;
        }
        previouslyFocusedChildHash = this_$iv$iv$iv;
        int i15 = 0;
        int constructor-impl = NodeKind.constructor-impl(1024);
        int i17 = 0;
        final int i18 = constructor-impl;
        final androidx.compose.ui.node.CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode2 = previouslyFocusedChildHash;
        final int i19 = 0;
        if (!compositionLocalConsumerModifierNode2.getNode().isAttached()) {
        } else {
            int i20 = 0;
            node$iv$iv = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], i9);
            Modifier.Node child$ui_release = compositionLocalConsumerModifierNode2.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, compositionLocalConsumerModifierNode2.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i21 = 0;
                i3 = 1;
                node2 = mutableVector2.removeAt(size -= i3);
                if (aggregateChildKindSet$ui_release &= i18 == 0) {
                } else {
                }
                node$iv$iv = node2;
                while (node$iv$iv != null) {
                    int $this$visitChildren_u2d6rFNWt0$iv2 = i3;
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                    this_$iv$iv$iv = $this$restoreFocusedChild;
                    previouslyFocusedChildHash = $this$visitChildren_u2d6rFNWt0$iv;
                    i9 = 0;
                }
                $this$visitChildren_u2d6rFNWt0$iv = previouslyFocusedChildHash;
                this_$iv$iv$iv = $this$restoreFocusedChild;
                i9 = 0;
                if (kindSet$ui_release &= i18 != 0) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = i3;
                node$iv$iv = node$iv$iv.getChild$ui_release();
                this_$iv$iv$iv = $this$restoreFocusedChild;
                previouslyFocusedChildHash = $this$visitChildren_u2d6rFNWt0$iv;
                i9 = 0;
                i10 = 0;
                i6 = 0;
                node$iv$iv2 = 0;
                int i22 = 0;
                node$iv$iv6 = node$iv$iv5;
                while (node$iv$iv6 != null) {
                    int i13 = 0;
                    if (kindSet$ui_release2 &= constructor-impl != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0 && node$iv$iv6 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv3 = 1;
                    node$iv$iv6 = DelegatableNodeKt.access$pop(node$iv$iv2);
                    this_$iv$iv$iv = $this$restoreFocusedChild;
                    i3 = this_$iv$iv$iv3;
                    previouslyFocusedChildHash = $this$visitChildren_u2d6rFNWt0$iv;
                    if (node$iv$iv6 instanceof DelegatingNode) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    i5 = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv6.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        node = node$iv$iv$iv;
                        i7 = 0;
                        count$iv$iv = 0;
                        if (kindSet$ui_release3 &= constructor-impl != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = 0;
                        if (this_$iv$iv$iv2 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv4 = stack$iv$iv2;
                        node$iv$iv3 = node;
                        this_$iv$iv$iv5 = node$iv$iv2;
                        stack$iv$iv = obj2;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        node$iv$iv6 = stack$iv$iv;
                        node$iv$iv2 = this_$iv$iv$iv5;
                        stack$iv$iv2 = this_$iv$iv$iv4;
                        this_$iv$iv$iv++;
                        this_$iv$iv$iv4 = stack$iv$iv2;
                        if (this_$iv$iv$iv == 1) {
                        } else {
                        }
                        if (node$iv$iv2 == 0) {
                        } else {
                        }
                        count$iv$iv = this_$iv$iv$iv;
                        obj2 = node$iv$iv6;
                        this_$iv$iv$iv5 = node$iv$iv2;
                        Object obj4 = obj2;
                        if (obj4 != null) {
                        } else {
                        }
                        node$iv$iv4 = obj2;
                        if (this_$iv$iv$iv5 != null) {
                        } else {
                        }
                        stack$iv$iv = node$iv$iv4;
                        node$iv$iv3 = node;
                        this_$iv$iv$iv = count$iv$iv;
                        stack$iv$iv = node$iv$iv4;
                        this_$iv$iv$iv5.add(node);
                        if (this_$iv$iv$iv5 != null) {
                        }
                        node$iv$iv4 = 0;
                        this_$iv$iv$iv5.add(obj4);
                        count$iv$iv = this_$iv$iv$iv;
                        int count$iv$iv2 = 16;
                        i8 = 0;
                        i2 = i14;
                        obj2 = node$iv$iv6;
                        i4 = count$iv$iv2;
                        this_$iv$iv$iv5 = new MutableVector(new Modifier.Node[count$iv$iv2], 0);
                        this_$iv$iv$iv5 = node$iv$iv2;
                        stack$iv$iv = node$iv$iv3;
                        this_$iv$iv$iv2 = 1;
                    }
                    this_$iv$iv$iv4 = stack$iv$iv2;
                    obj2 = node$iv$iv6;
                    this_$iv$iv$iv3 = 1;
                    if (this_$iv$iv$iv == this_$iv$iv$iv3) {
                    } else {
                    }
                    node$iv$iv6 = obj2;
                    this_$iv$iv$iv = $this$restoreFocusedChild;
                    i3 = this_$iv$iv$iv3;
                    previouslyFocusedChildHash = $this$visitChildren_u2d6rFNWt0$iv;
                    node$iv$iv6 = obj2;
                    node = node$iv$iv$iv;
                    i7 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = stack$iv$iv2;
                    node$iv$iv3 = node;
                    this_$iv$iv$iv5 = node$iv$iv2;
                    stack$iv$iv = obj2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv6 = stack$iv$iv;
                    node$iv$iv2 = this_$iv$iv$iv5;
                    stack$iv$iv2 = this_$iv$iv$iv4;
                    this_$iv$iv$iv++;
                    this_$iv$iv$iv4 = stack$iv$iv2;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    if (node$iv$iv2 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv;
                    obj2 = node$iv$iv6;
                    this_$iv$iv$iv5 = node$iv$iv2;
                    obj4 = obj2;
                    if (obj4 != null) {
                    } else {
                    }
                    node$iv$iv4 = obj2;
                    if (this_$iv$iv$iv5 != null) {
                    } else {
                    }
                    stack$iv$iv = node$iv$iv4;
                    node$iv$iv3 = node;
                    this_$iv$iv$iv = count$iv$iv;
                    stack$iv$iv = node$iv$iv4;
                    this_$iv$iv$iv5.add(node);
                    if (this_$iv$iv$iv5 != null) {
                    }
                    node$iv$iv4 = 0;
                    this_$iv$iv$iv5.add(obj4);
                    count$iv$iv = this_$iv$iv$iv;
                    count$iv$iv2 = 16;
                    i8 = 0;
                    i2 = i14;
                    obj2 = node$iv$iv6;
                    i4 = count$iv$iv2;
                    this_$iv$iv$iv5 = new MutableVector(new Modifier.Node[count$iv$iv2], 0);
                    this_$iv$iv$iv5 = node$iv$iv2;
                    stack$iv$iv = node$iv$iv3;
                    this_$iv$iv$iv2 = 1;
                    this_$iv$iv$iv = 1;
                    i5 = node$iv$iv6;
                    node$iv$iv$iv = 0;
                    $this$visitChildren_u2d6rFNWt0$iv = previouslyFocusedChildHash;
                    this_$iv$iv$iv3 = 1;
                    $this$visitChildren_u2d6rFNWt0$iv = previouslyFocusedChildHash;
                }
                $this$visitChildren_u2d6rFNWt0$iv = previouslyFocusedChildHash;
                this_$iv$iv$iv = $this$restoreFocusedChild;
                i9 = 0;
                i13 = 0;
                if (kindSet$ui_release2 &= constructor-impl != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0 && node$iv$iv6 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv3 = 1;
                node$iv$iv6 = DelegatableNodeKt.access$pop(node$iv$iv2);
                this_$iv$iv$iv = $this$restoreFocusedChild;
                i3 = this_$iv$iv$iv3;
                previouslyFocusedChildHash = $this$visitChildren_u2d6rFNWt0$iv;
                if (node$iv$iv6 instanceof DelegatingNode) {
                } else {
                }
                this_$iv$iv$iv = 0;
                i5 = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv6.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    node = node$iv$iv$iv;
                    i7 = 0;
                    count$iv$iv = 0;
                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = 0;
                    if (this_$iv$iv$iv2 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv4 = stack$iv$iv2;
                    node$iv$iv3 = node;
                    this_$iv$iv$iv5 = node$iv$iv2;
                    stack$iv$iv = obj2;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv6 = stack$iv$iv;
                    node$iv$iv2 = this_$iv$iv$iv5;
                    stack$iv$iv2 = this_$iv$iv$iv4;
                    this_$iv$iv$iv++;
                    this_$iv$iv$iv4 = stack$iv$iv2;
                    if (this_$iv$iv$iv == 1) {
                    } else {
                    }
                    if (node$iv$iv2 == 0) {
                    } else {
                    }
                    count$iv$iv = this_$iv$iv$iv;
                    obj2 = node$iv$iv6;
                    this_$iv$iv$iv5 = node$iv$iv2;
                    obj4 = obj2;
                    if (obj4 != null) {
                    } else {
                    }
                    node$iv$iv4 = obj2;
                    if (this_$iv$iv$iv5 != null) {
                    } else {
                    }
                    stack$iv$iv = node$iv$iv4;
                    node$iv$iv3 = node;
                    this_$iv$iv$iv = count$iv$iv;
                    stack$iv$iv = node$iv$iv4;
                    this_$iv$iv$iv5.add(node);
                    if (this_$iv$iv$iv5 != null) {
                    }
                    node$iv$iv4 = 0;
                    this_$iv$iv$iv5.add(obj4);
                    count$iv$iv = this_$iv$iv$iv;
                    count$iv$iv2 = 16;
                    i8 = 0;
                    i2 = i14;
                    obj2 = node$iv$iv6;
                    i4 = count$iv$iv2;
                    this_$iv$iv$iv5 = new MutableVector(new Modifier.Node[count$iv$iv2], 0);
                    this_$iv$iv$iv5 = node$iv$iv2;
                    stack$iv$iv = node$iv$iv3;
                    this_$iv$iv$iv2 = 1;
                }
                this_$iv$iv$iv4 = stack$iv$iv2;
                obj2 = node$iv$iv6;
                this_$iv$iv$iv3 = 1;
                if (this_$iv$iv$iv == this_$iv$iv$iv3) {
                } else {
                }
                node$iv$iv6 = obj2;
                this_$iv$iv$iv = $this$restoreFocusedChild;
                i3 = this_$iv$iv$iv3;
                previouslyFocusedChildHash = $this$visitChildren_u2d6rFNWt0$iv;
                node$iv$iv6 = obj2;
                node = node$iv$iv$iv;
                i7 = 0;
                count$iv$iv = 0;
                if (kindSet$ui_release3 &= constructor-impl != 0) {
                } else {
                }
                this_$iv$iv$iv2 = 0;
                if (this_$iv$iv$iv2 != 0) {
                } else {
                }
                this_$iv$iv$iv4 = stack$iv$iv2;
                node$iv$iv3 = node;
                this_$iv$iv$iv5 = node$iv$iv2;
                stack$iv$iv = obj2;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                node$iv$iv6 = stack$iv$iv;
                node$iv$iv2 = this_$iv$iv$iv5;
                stack$iv$iv2 = this_$iv$iv$iv4;
                this_$iv$iv$iv++;
                this_$iv$iv$iv4 = stack$iv$iv2;
                if (this_$iv$iv$iv == 1) {
                } else {
                }
                if (node$iv$iv2 == 0) {
                } else {
                }
                count$iv$iv = this_$iv$iv$iv;
                obj2 = node$iv$iv6;
                this_$iv$iv$iv5 = node$iv$iv2;
                obj4 = obj2;
                if (obj4 != null) {
                } else {
                }
                node$iv$iv4 = obj2;
                if (this_$iv$iv$iv5 != null) {
                } else {
                }
                stack$iv$iv = node$iv$iv4;
                node$iv$iv3 = node;
                this_$iv$iv$iv = count$iv$iv;
                stack$iv$iv = node$iv$iv4;
                this_$iv$iv$iv5.add(node);
                if (this_$iv$iv$iv5 != null) {
                }
                node$iv$iv4 = 0;
                this_$iv$iv$iv5.add(obj4);
                count$iv$iv = this_$iv$iv$iv;
                count$iv$iv2 = 16;
                i8 = 0;
                i2 = i14;
                obj2 = node$iv$iv6;
                i4 = count$iv$iv2;
                this_$iv$iv$iv5 = new MutableVector(new Modifier.Node[count$iv$iv2], 0);
                this_$iv$iv$iv5 = node$iv$iv2;
                stack$iv$iv = node$iv$iv3;
                this_$iv$iv$iv2 = 1;
                this_$iv$iv$iv = 1;
                i5 = node$iv$iv6;
                node$iv$iv$iv = 0;
                $this$visitChildren_u2d6rFNWt0$iv = previouslyFocusedChildHash;
                this_$iv$iv$iv3 = 1;
                $this$visitChildren_u2d6rFNWt0$iv = previouslyFocusedChildHash;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
            }
            return 0;
        }
        androidx.compose.ui.node.CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode3 = previouslyFocusedChildHash;
        int i12 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw illegalStateException;
    }

    public static final boolean saveFocusedChild(androidx.compose.ui.focus.FocusTargetNode $this$saveFocusedChild) {
        androidx.compose.ui.focus.FocusTargetNode count$iv$iv;
        androidx.compose.ui.focus.FocusTargetNode focusTargetNode;
        Object stack$iv$iv;
        int $i$f$mutableVectorOf;
        int $this$visitChildren_u2d6rFNWt0$iv;
        int i4;
        Object node$iv$iv;
        int node$iv$iv3;
        Modifier.Node node$iv$iv2;
        int constructor-impl;
        Object type$iv;
        int node;
        int node$iv$iv4;
        Modifier.Node[] arr;
        int i6;
        Modifier.Node node$iv$iv$iv;
        int i10;
        Object obj2;
        int i5;
        int node$iv$iv7;
        int node$iv$iv6;
        Object node$iv$iv5;
        int i2;
        int i;
        androidx.compose.ui.focus.FocusTargetNode $this$visitChildren_u2d6rFNWt0$iv2;
        int i8;
        int i7;
        Object this_$iv$iv$iv2;
        int this_$iv$iv$iv;
        int count$iv$iv2;
        int i11;
        int i3;
        Object obj;
        int i9;
        count$iv$iv = $this$saveFocusedChild;
        i4 = 0;
        if (!count$iv$iv.getFocusState().getHasFocus()) {
            return i4;
        }
        focusTargetNode = count$iv$iv;
        int i15 = 0;
        int i17 = 0;
        final int i18 = constructor-impl;
        final androidx.compose.ui.focus.FocusTargetNode focusTargetNode2 = focusTargetNode;
        final int i19 = 0;
        if (!focusTargetNode2.getNode().isAttached()) {
        } else {
            int i20 = 0;
            node$iv$iv4 = 0;
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], i4);
            Modifier.Node child$ui_release = focusTargetNode2.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusTargetNode2.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                int i21 = 0;
                i6 = 1;
                node = mutableVector2.removeAt(size -= i6);
                if (aggregateChildKindSet$ui_release &= i18 == 0) {
                } else {
                }
                node$iv$iv4 = node;
                while (node$iv$iv4 != null) {
                    i8 = constructor-impl;
                    int $this$visitChildren_u2d6rFNWt0$iv3 = i6;
                    node$iv$iv4 = node$iv$iv4.getChild$ui_release();
                    count$iv$iv = $this$saveFocusedChild;
                    focusTargetNode = $this$visitChildren_u2d6rFNWt0$iv2;
                    i4 = 0;
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = focusTargetNode;
                i8 = constructor-impl;
                count$iv$iv = $this$saveFocusedChild;
                i4 = 0;
                if (kindSet$ui_release2 &= i18 != 0) {
                } else {
                }
                i8 = constructor-impl;
                $this$visitChildren_u2d6rFNWt0$iv3 = i6;
                node$iv$iv4 = node$iv$iv4.getChild$ui_release();
                count$iv$iv = $this$saveFocusedChild;
                focusTargetNode = $this$visitChildren_u2d6rFNWt0$iv2;
                i4 = 0;
                i10 = 0;
                i5 = 0;
                node$iv$iv7 = 0;
                int i23 = 0;
                node$iv$iv = node$iv$iv5;
                while (node$iv$iv != null) {
                    i2 = i6;
                    i8 = constructor-impl;
                    int i13 = 0;
                    if (kindSet$ui_release &= i8 != 0) {
                    } else {
                    }
                    count$iv$iv = 0;
                    if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    $this$visitChildren_u2d6rFNWt0$iv = i2;
                    node$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv7);
                    count$iv$iv = $this$saveFocusedChild;
                    i6 = $this$visitChildren_u2d6rFNWt0$iv;
                    focusTargetNode = $this$visitChildren_u2d6rFNWt0$iv2;
                    constructor-impl = i8;
                    if (node$iv$iv instanceof DelegatingNode) {
                    } else {
                    }
                    count$iv$iv = 0;
                    constructor-impl = 0;
                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                    while (node$iv$iv$iv != null) {
                        i = node$iv$iv$iv;
                        i7 = 0;
                        count$iv$iv2 = 0;
                        if (kindSet$ui_release3 &= i8 != 0) {
                        } else {
                        }
                        this_$iv$iv$iv = 0;
                        if (this_$iv$iv$iv != 0) {
                        } else {
                        }
                        this_$iv$iv$iv2 = stack$iv$iv;
                        node$iv$iv2 = i;
                        $i$f$mutableVectorOf = node$iv$iv7;
                        node$iv$iv6 = obj;
                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                        node$iv$iv = node$iv$iv6;
                        i2 = 1;
                        node$iv$iv7 = $i$f$mutableVectorOf;
                        stack$iv$iv = this_$iv$iv$iv2;
                        count$iv$iv++;
                        this_$iv$iv$iv2 = stack$iv$iv;
                        if (count$iv$iv == i2) {
                        } else {
                        }
                        if (node$iv$iv7 == 0) {
                        } else {
                        }
                        count$iv$iv2 = count$iv$iv;
                        obj = node$iv$iv;
                        $i$f$mutableVectorOf = node$iv$iv7;
                        Object obj4 = obj;
                        if (obj4 != null) {
                        } else {
                        }
                        node$iv$iv3 = obj;
                        if ($i$f$mutableVectorOf != 0) {
                        } else {
                        }
                        node$iv$iv6 = node$iv$iv3;
                        node$iv$iv2 = i;
                        count$iv$iv = count$iv$iv2;
                        node$iv$iv6 = node$iv$iv3;
                        $i$f$mutableVectorOf.add(i);
                        if ($i$f$mutableVectorOf != 0) {
                        }
                        node$iv$iv3 = 0;
                        $i$f$mutableVectorOf.add(obj4);
                        count$iv$iv2 = count$iv$iv;
                        int count$iv$iv3 = 16;
                        i11 = 0;
                        i3 = i14;
                        obj = node$iv$iv;
                        i9 = count$iv$iv3;
                        $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                        $i$f$mutableVectorOf = node$iv$iv7;
                        node$iv$iv6 = node$iv$iv2;
                        this_$iv$iv$iv = i2;
                    }
                    this_$iv$iv$iv2 = stack$iv$iv;
                    obj = node$iv$iv;
                    $this$visitChildren_u2d6rFNWt0$iv = 1;
                    if (count$iv$iv == $this$visitChildren_u2d6rFNWt0$iv) {
                    } else {
                    }
                    node$iv$iv = obj;
                    count$iv$iv = $this$saveFocusedChild;
                    i6 = $this$visitChildren_u2d6rFNWt0$iv;
                    focusTargetNode = $this$visitChildren_u2d6rFNWt0$iv2;
                    constructor-impl = i8;
                    node$iv$iv = obj;
                    i = node$iv$iv$iv;
                    i7 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= i8 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = stack$iv$iv;
                    node$iv$iv2 = i;
                    $i$f$mutableVectorOf = node$iv$iv7;
                    node$iv$iv6 = obj;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv = node$iv$iv6;
                    i2 = 1;
                    node$iv$iv7 = $i$f$mutableVectorOf;
                    stack$iv$iv = this_$iv$iv$iv2;
                    count$iv$iv++;
                    this_$iv$iv$iv2 = stack$iv$iv;
                    if (count$iv$iv == i2) {
                    } else {
                    }
                    if (node$iv$iv7 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    obj = node$iv$iv;
                    $i$f$mutableVectorOf = node$iv$iv7;
                    obj4 = obj;
                    if (obj4 != null) {
                    } else {
                    }
                    node$iv$iv3 = obj;
                    if ($i$f$mutableVectorOf != 0) {
                    } else {
                    }
                    node$iv$iv6 = node$iv$iv3;
                    node$iv$iv2 = i;
                    count$iv$iv = count$iv$iv2;
                    node$iv$iv6 = node$iv$iv3;
                    $i$f$mutableVectorOf.add(i);
                    if ($i$f$mutableVectorOf != 0) {
                    }
                    node$iv$iv3 = 0;
                    $i$f$mutableVectorOf.add(obj4);
                    count$iv$iv2 = count$iv$iv;
                    count$iv$iv3 = 16;
                    i11 = 0;
                    i3 = i14;
                    obj = node$iv$iv;
                    i9 = count$iv$iv3;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                    $i$f$mutableVectorOf = node$iv$iv7;
                    node$iv$iv6 = node$iv$iv2;
                    this_$iv$iv$iv = i2;
                    count$iv$iv = i2;
                    node$iv$iv$iv = node$iv$iv;
                    i = 0;
                    $this$visitChildren_u2d6rFNWt0$iv2 = focusTargetNode;
                    i8 = constructor-impl;
                    $this$visitChildren_u2d6rFNWt0$iv = i2;
                }
                $this$visitChildren_u2d6rFNWt0$iv2 = focusTargetNode;
                i8 = constructor-impl;
                count$iv$iv = $this$saveFocusedChild;
                i4 = 0;
                i2 = i6;
                i8 = constructor-impl;
                i13 = 0;
                if (kindSet$ui_release &= i8 != 0) {
                } else {
                }
                count$iv$iv = 0;
                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                $this$visitChildren_u2d6rFNWt0$iv = i2;
                node$iv$iv = DelegatableNodeKt.access$pop(node$iv$iv7);
                count$iv$iv = $this$saveFocusedChild;
                i6 = $this$visitChildren_u2d6rFNWt0$iv;
                focusTargetNode = $this$visitChildren_u2d6rFNWt0$iv2;
                constructor-impl = i8;
                if (node$iv$iv instanceof DelegatingNode) {
                } else {
                }
                count$iv$iv = 0;
                constructor-impl = 0;
                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                while (node$iv$iv$iv != null) {
                    i = node$iv$iv$iv;
                    i7 = 0;
                    count$iv$iv2 = 0;
                    if (kindSet$ui_release3 &= i8 != 0) {
                    } else {
                    }
                    this_$iv$iv$iv = 0;
                    if (this_$iv$iv$iv != 0) {
                    } else {
                    }
                    this_$iv$iv$iv2 = stack$iv$iv;
                    node$iv$iv2 = i;
                    $i$f$mutableVectorOf = node$iv$iv7;
                    node$iv$iv6 = obj;
                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                    node$iv$iv = node$iv$iv6;
                    i2 = 1;
                    node$iv$iv7 = $i$f$mutableVectorOf;
                    stack$iv$iv = this_$iv$iv$iv2;
                    count$iv$iv++;
                    this_$iv$iv$iv2 = stack$iv$iv;
                    if (count$iv$iv == i2) {
                    } else {
                    }
                    if (node$iv$iv7 == 0) {
                    } else {
                    }
                    count$iv$iv2 = count$iv$iv;
                    obj = node$iv$iv;
                    $i$f$mutableVectorOf = node$iv$iv7;
                    obj4 = obj;
                    if (obj4 != null) {
                    } else {
                    }
                    node$iv$iv3 = obj;
                    if ($i$f$mutableVectorOf != 0) {
                    } else {
                    }
                    node$iv$iv6 = node$iv$iv3;
                    node$iv$iv2 = i;
                    count$iv$iv = count$iv$iv2;
                    node$iv$iv6 = node$iv$iv3;
                    $i$f$mutableVectorOf.add(i);
                    if ($i$f$mutableVectorOf != 0) {
                    }
                    node$iv$iv3 = 0;
                    $i$f$mutableVectorOf.add(obj4);
                    count$iv$iv2 = count$iv$iv;
                    count$iv$iv3 = 16;
                    i11 = 0;
                    i3 = i14;
                    obj = node$iv$iv;
                    i9 = count$iv$iv3;
                    $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                    $i$f$mutableVectorOf = node$iv$iv7;
                    node$iv$iv6 = node$iv$iv2;
                    this_$iv$iv$iv = i2;
                }
                this_$iv$iv$iv2 = stack$iv$iv;
                obj = node$iv$iv;
                $this$visitChildren_u2d6rFNWt0$iv = 1;
                if (count$iv$iv == $this$visitChildren_u2d6rFNWt0$iv) {
                } else {
                }
                node$iv$iv = obj;
                count$iv$iv = $this$saveFocusedChild;
                i6 = $this$visitChildren_u2d6rFNWt0$iv;
                focusTargetNode = $this$visitChildren_u2d6rFNWt0$iv2;
                constructor-impl = i8;
                node$iv$iv = obj;
                i = node$iv$iv$iv;
                i7 = 0;
                count$iv$iv2 = 0;
                if (kindSet$ui_release3 &= i8 != 0) {
                } else {
                }
                this_$iv$iv$iv = 0;
                if (this_$iv$iv$iv != 0) {
                } else {
                }
                this_$iv$iv$iv2 = stack$iv$iv;
                node$iv$iv2 = i;
                $i$f$mutableVectorOf = node$iv$iv7;
                node$iv$iv6 = obj;
                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                node$iv$iv = node$iv$iv6;
                i2 = 1;
                node$iv$iv7 = $i$f$mutableVectorOf;
                stack$iv$iv = this_$iv$iv$iv2;
                count$iv$iv++;
                this_$iv$iv$iv2 = stack$iv$iv;
                if (count$iv$iv == i2) {
                } else {
                }
                if (node$iv$iv7 == 0) {
                } else {
                }
                count$iv$iv2 = count$iv$iv;
                obj = node$iv$iv;
                $i$f$mutableVectorOf = node$iv$iv7;
                obj4 = obj;
                if (obj4 != null) {
                } else {
                }
                node$iv$iv3 = obj;
                if ($i$f$mutableVectorOf != 0) {
                } else {
                }
                node$iv$iv6 = node$iv$iv3;
                node$iv$iv2 = i;
                count$iv$iv = count$iv$iv2;
                node$iv$iv6 = node$iv$iv3;
                $i$f$mutableVectorOf.add(i);
                if ($i$f$mutableVectorOf != 0) {
                }
                node$iv$iv3 = 0;
                $i$f$mutableVectorOf.add(obj4);
                count$iv$iv2 = count$iv$iv;
                count$iv$iv3 = 16;
                i11 = 0;
                i3 = i14;
                obj = node$iv$iv;
                i9 = count$iv$iv3;
                $i$f$mutableVectorOf = new MutableVector(new Modifier.Node[count$iv$iv3], 0);
                $i$f$mutableVectorOf = node$iv$iv7;
                node$iv$iv6 = node$iv$iv2;
                this_$iv$iv$iv = i2;
                count$iv$iv = i2;
                node$iv$iv$iv = node$iv$iv;
                i = 0;
                $this$visitChildren_u2d6rFNWt0$iv2 = focusTargetNode;
                i8 = constructor-impl;
                $this$visitChildren_u2d6rFNWt0$iv = i2;
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
            }
            return 0;
        }
        androidx.compose.ui.focus.FocusTargetNode focusTargetNode3 = focusTargetNode;
        int i12 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("visitChildren called on an unattached node".toString());
        throw illegalStateException;
    }
}
