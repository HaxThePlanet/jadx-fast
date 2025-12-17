package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0008\u001a\u00020\tJ\u001d\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000cH\u0083\u0008J!\u0010\u000e\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000cH\u0000¢\u0006\u0002\u0008\u000fJ\r\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\u0008\u0011J\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0008\u0010\u0015\u001a\u00020\tH\u0007J\u0008\u0010\u0016\u001a\u00020\tH\u0007R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Landroidx/compose/ui/focus/FocusRequester;", "", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "captureFocus", "", "findFocusTarget", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "findFocusTargetNode", "findFocusTargetNode$ui_release", "focus", "focus$ui_release", "freeFocus", "requestFocus", "", "restoreFocusedChild", "saveFocusedChild", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusRequester {

    public static final int $stable;
    private static final androidx.compose.ui.focus.FocusRequester Cancel;
    public static final androidx.compose.ui.focus.FocusRequester.Companion Companion;
    private static final androidx.compose.ui.focus.FocusRequester Default;
    private final MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> focusRequesterNodes;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000cB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0007¨\u0006\r", d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "()V", "Cancel", "Landroidx/compose/ui/focus/FocusRequester;", "getCancel$annotations", "getCancel", "()Landroidx/compose/ui/focus/FocusRequester;", "Default", "getDefault", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCancel$annotations() {
        }

        public final androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory createRefs() {
            return FocusRequester.Companion.FocusRequesterFactory.INSTANCE;
        }

        public final androidx.compose.ui.focus.FocusRequester getCancel() {
            return FocusRequester.access$getCancel$cp();
        }

        public final androidx.compose.ui.focus.FocusRequester getDefault() {
            return FocusRequester.access$getDefault$cp();
        }
    }
    static {
        FocusRequester.Companion companion = new FocusRequester.Companion(0);
        FocusRequester.Companion = companion;
        FocusRequester focusRequester = new FocusRequester();
        FocusRequester.Default = focusRequester;
        FocusRequester focusRequester2 = new FocusRequester();
        FocusRequester.Cancel = focusRequester2;
    }

    public FocusRequester() {
        super();
        final int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new FocusRequesterModifierNode[16], 0);
        this.focusRequesterNodes = mutableVector;
    }

    public static final androidx.compose.ui.focus.FocusRequester access$getCancel$cp() {
        return FocusRequester.Cancel;
    }

    public static final androidx.compose.ui.focus.FocusRequester access$getDefault$cp() {
        return FocusRequester.Default;
    }

    private final boolean findFocusTarget(Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        Object count$iv$iv;
        int child$iv$iv3;
        Modifier.Node child$iv$iv2;
        int i2;
        int child$iv$iv;
        int i12;
        int i7;
        int success3;
        Object success;
        int node$iv$iv;
        Object node$iv$iv2;
        Modifier.Node node$iv$iv3;
        int node$iv$iv5;
        Object notEmpty;
        int i$iv;
        Object[] content;
        Object obj2;
        int i15;
        Object obj5;
        int constructor-impl;
        int i9;
        int i5;
        Object obj3;
        int i13;
        Object node$iv$iv4;
        int i10;
        Object size;
        int $i$f$findFocusTarget;
        int i8;
        Object obj;
        int i4;
        int i6;
        Object node$iv$iv6;
        MutableVector branches$iv$iv;
        int i;
        Modifier.Node child$iv$iv4;
        boolean booleanValue;
        Modifier.Node node$iv$iv$iv;
        Modifier.Node node;
        int i11;
        int count$iv$iv2;
        int i3;
        int i14;
        int success2;
        Object obj4;
        count$iv$iv = this;
        child$iv$iv3 = 0;
        node$iv$iv = 0;
        i12 = count$iv$iv != FocusRequester.Companion.getDefault() ? 1 : node$iv$iv;
        String str3 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
        if (i12 == 0) {
        } else {
            i7 = count$iv$iv != FocusRequester.Companion.getCancel() ? 1 : node$iv$iv;
            if (i7 == 0) {
            } else {
                if (!count$iv$iv.focusRequesterNodes.isNotEmpty()) {
                } else {
                    success3 = 0;
                    MutableVector focusRequesterNodes2 = count$iv$iv.focusRequesterNodes;
                    final int i21 = 0;
                    final int size2 = focusRequesterNodes2.getSize();
                    if (size2 > 0) {
                        i$iv = 0;
                        i15 = 0;
                        int i22 = 0;
                        constructor-impl = NodeKind.constructor-impl(1024);
                        i9 = 0;
                        i5 = constructor-impl;
                        obj3 = obj5;
                        i13 = 0;
                        while (obj3.getNode().isAttached()) {
                            node$iv$iv4 = 0;
                            i10 = 1;
                            size = 0;
                            count$iv$iv = new MutableVector(new Modifier.Node[16], node$iv$iv);
                            child$iv$iv2 = obj3.getNode().getChild$ui_release();
                            if (child$iv$iv2 == null) {
                            } else {
                            }
                            count$iv$iv.add(child$iv$iv2);
                            while (count$iv$iv.isNotEmpty()) {
                                int i24 = 0;
                                notEmpty = count$iv$iv.removeAt(size + -1);
                                if (aggregateChildKindSet$ui_release &= i5 == 0) {
                                    break loop_15;
                                } else {
                                }
                                node$iv$iv4 = notEmpty;
                                while (node$iv$iv4 != null) {
                                    branches$iv$iv = count$iv$iv;
                                    success2 = success3;
                                    int child$iv$iv6 = i10;
                                    node$iv$iv4 = node$iv$iv4.getChild$ui_release();
                                    child$iv$iv2 = child$iv$iv4;
                                    node$iv$iv = 0;
                                }
                                branches$iv$iv = count$iv$iv;
                                success2 = success3;
                                int child$iv$iv5 = i10;
                                child$iv$iv2 = child$iv$iv4;
                                node$iv$iv = 0;
                                if (kindSet$ui_release &= i5 == 0) {
                                    break loop_15;
                                } else {
                                }
                                branches$iv$iv = count$iv$iv;
                                success2 = success3;
                                child$iv$iv6 = i10;
                                node$iv$iv4 = node$iv$iv4.getChild$ui_release();
                                child$iv$iv2 = child$iv$iv4;
                                node$iv$iv = 0;
                                i8 = 0;
                                i4 = 0;
                                i6 = 0;
                                int i25 = 0;
                                node$iv$iv = node$iv$iv6;
                                while (node$iv$iv != null) {
                                    branches$iv$iv = count$iv$iv;
                                    child$iv$iv = onFound;
                                    i = 0;
                                    if (kindSet$ui_release2 &= constructor-impl != 0) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    success2 = success3;
                                    obj4 = node$iv$iv;
                                    i2 = i10;
                                    node$iv$iv2 = obj4;
                                    node$iv$iv = DelegatableNodeKt.access$pop(i6);
                                    i10 = i2;
                                    count$iv$iv = branches$iv$iv;
                                    child$iv$iv2 = child$iv$iv4;
                                    success3 = success2;
                                    if (node$iv$iv instanceof DelegatingNode) {
                                    } else {
                                    }
                                    count$iv$iv = 0;
                                    booleanValue = 0;
                                    node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                    while (node$iv$iv$iv != null) {
                                        node = node$iv$iv$iv;
                                        i11 = 0;
                                        i3 = 0;
                                        if (kindSet$ui_release3 &= constructor-impl != 0) {
                                        } else {
                                        }
                                        count$iv$iv2 = 0;
                                        if (count$iv$iv2 != 0) {
                                        } else {
                                        }
                                        success2 = success3;
                                        node$iv$iv3 = node;
                                        success = obj4;
                                        node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                        child$iv$iv = onFound;
                                        node$iv$iv = success;
                                        success3 = success2;
                                        i10 = 1;
                                        count$iv$iv++;
                                        if (count$iv$iv == i10) {
                                        } else {
                                        }
                                        if (i6 == 0) {
                                        } else {
                                        }
                                        count$iv$iv2 = count$iv$iv;
                                        success2 = success3;
                                        obj4 = node$iv$iv;
                                        node$iv$iv5 = 0;
                                        child$iv$iv = i6;
                                        Object obj7 = obj4;
                                        if (obj7 != null) {
                                        } else {
                                        }
                                        success = obj4;
                                        if (child$iv$iv != 0) {
                                        } else {
                                        }
                                        node$iv$iv3 = node;
                                        i6 = child$iv$iv;
                                        count$iv$iv = count$iv$iv2;
                                        child$iv$iv.add(node);
                                        if (child$iv$iv != 0) {
                                        }
                                        success = 0;
                                        child$iv$iv.add(obj7);
                                        count$iv$iv2 = count$iv$iv;
                                        i3 = 0;
                                        i14 = i20;
                                        success2 = success3;
                                        obj4 = node$iv$iv;
                                        child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                        success2 = success3;
                                        success = node$iv$iv3;
                                        count$iv$iv2 = i10;
                                    }
                                    obj4 = node$iv$iv;
                                    i2 = 1;
                                    if (count$iv$iv == i2) {
                                    } else {
                                    }
                                    node$iv$iv2 = obj4;
                                    i10 = i2;
                                    count$iv$iv = branches$iv$iv;
                                    child$iv$iv2 = child$iv$iv4;
                                    success3 = success2;
                                    node$iv$iv = obj4;
                                    node = node$iv$iv$iv;
                                    i11 = 0;
                                    i3 = 0;
                                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = 0;
                                    if (count$iv$iv2 != 0) {
                                    } else {
                                    }
                                    success2 = success3;
                                    node$iv$iv3 = node;
                                    success = obj4;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv = success;
                                    success3 = success2;
                                    i10 = 1;
                                    count$iv$iv++;
                                    if (count$iv$iv == i10) {
                                    } else {
                                    }
                                    if (i6 == 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = count$iv$iv;
                                    success2 = success3;
                                    obj4 = node$iv$iv;
                                    node$iv$iv5 = 0;
                                    child$iv$iv = i6;
                                    obj7 = obj4;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success = obj4;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv3 = node;
                                    i6 = child$iv$iv;
                                    count$iv$iv = count$iv$iv2;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv2 = count$iv$iv;
                                    i3 = 0;
                                    i14 = i20;
                                    success2 = success3;
                                    obj4 = node$iv$iv;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success2 = success3;
                                    success = node$iv$iv3;
                                    count$iv$iv2 = i10;
                                    count$iv$iv = i10;
                                    i = 0;
                                    child$iv$iv4 = child$iv$iv2;
                                    success2 = success3;
                                    obj4 = node$iv$iv;
                                    i2 = i10;
                                }
                                branches$iv$iv = count$iv$iv;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                int child$iv$iv8 = i10;
                                child$iv$iv2 = child$iv$iv4;
                                node$iv$iv = 0;
                                branches$iv$iv = count$iv$iv;
                                child$iv$iv = onFound;
                                i = 0;
                                if (kindSet$ui_release2 &= constructor-impl != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                success2 = success3;
                                obj4 = node$iv$iv;
                                i2 = i10;
                                node$iv$iv2 = obj4;
                                node$iv$iv = DelegatableNodeKt.access$pop(i6);
                                i10 = i2;
                                count$iv$iv = branches$iv$iv;
                                child$iv$iv2 = child$iv$iv4;
                                success3 = success2;
                                if (node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv = 0;
                                booleanValue = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    node = node$iv$iv$iv;
                                    i11 = 0;
                                    i3 = 0;
                                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = 0;
                                    if (count$iv$iv2 != 0) {
                                    } else {
                                    }
                                    success2 = success3;
                                    node$iv$iv3 = node;
                                    success = obj4;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv = success;
                                    success3 = success2;
                                    i10 = 1;
                                    count$iv$iv++;
                                    if (count$iv$iv == i10) {
                                    } else {
                                    }
                                    if (i6 == 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = count$iv$iv;
                                    success2 = success3;
                                    obj4 = node$iv$iv;
                                    node$iv$iv5 = 0;
                                    child$iv$iv = i6;
                                    obj7 = obj4;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success = obj4;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv3 = node;
                                    i6 = child$iv$iv;
                                    count$iv$iv = count$iv$iv2;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv2 = count$iv$iv;
                                    i3 = 0;
                                    i14 = i20;
                                    success2 = success3;
                                    obj4 = node$iv$iv;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success2 = success3;
                                    success = node$iv$iv3;
                                    count$iv$iv2 = i10;
                                }
                                obj4 = node$iv$iv;
                                i2 = 1;
                                if (count$iv$iv == i2) {
                                } else {
                                }
                                node$iv$iv2 = obj4;
                                i10 = i2;
                                count$iv$iv = branches$iv$iv;
                                child$iv$iv2 = child$iv$iv4;
                                success3 = success2;
                                node$iv$iv = obj4;
                                node = node$iv$iv$iv;
                                i11 = 0;
                                i3 = 0;
                                if (kindSet$ui_release3 &= constructor-impl != 0) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                if (count$iv$iv2 != 0) {
                                } else {
                                }
                                success2 = success3;
                                node$iv$iv3 = node;
                                success = obj4;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv = success;
                                success3 = success2;
                                i10 = 1;
                                count$iv$iv++;
                                if (count$iv$iv == i10) {
                                } else {
                                }
                                if (i6 == 0) {
                                } else {
                                }
                                count$iv$iv2 = count$iv$iv;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                node$iv$iv5 = 0;
                                child$iv$iv = i6;
                                obj7 = obj4;
                                if (obj7 != null) {
                                } else {
                                }
                                success = obj4;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv3 = node;
                                i6 = child$iv$iv;
                                count$iv$iv = count$iv$iv2;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv2 = count$iv$iv;
                                i3 = 0;
                                i14 = i20;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success2 = success3;
                                success = node$iv$iv3;
                                count$iv$iv2 = i10;
                                count$iv$iv = i10;
                                i = 0;
                                child$iv$iv4 = child$iv$iv2;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                i2 = i10;
                                DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv, notEmpty);
                            }
                            branches$iv$iv = count$iv$iv;
                            child$iv$iv4 = child$iv$iv2;
                            success2 = success3;
                            child$iv$iv3 = i10;
                            node$iv$iv = 0;
                            count$iv$iv = this;
                            child$iv$iv3 = $i$f$findFocusTarget;
                            i15 = 0;
                            i22 = 0;
                            constructor-impl = NodeKind.constructor-impl(1024);
                            i9 = 0;
                            i5 = constructor-impl;
                            obj3 = obj5;
                            i13 = 0;
                            i24 = 0;
                            notEmpty = count$iv$iv.removeAt(size + -1);
                            if (aggregateChildKindSet$ui_release &= i5 == 0) {
                            } else {
                            }
                            node$iv$iv4 = notEmpty;
                            while (node$iv$iv4 != null) {
                                branches$iv$iv = count$iv$iv;
                                success2 = success3;
                                child$iv$iv6 = i10;
                                node$iv$iv4 = node$iv$iv4.getChild$ui_release();
                                child$iv$iv2 = child$iv$iv4;
                                node$iv$iv = 0;
                            }
                            branches$iv$iv = count$iv$iv;
                            success2 = success3;
                            child$iv$iv5 = i10;
                            child$iv$iv2 = child$iv$iv4;
                            node$iv$iv = 0;
                            if (kindSet$ui_release &= i5 != 0) {
                            } else {
                            }
                            branches$iv$iv = count$iv$iv;
                            success2 = success3;
                            child$iv$iv6 = i10;
                            node$iv$iv4 = node$iv$iv4.getChild$ui_release();
                            child$iv$iv2 = child$iv$iv4;
                            node$iv$iv = 0;
                            i8 = 0;
                            i4 = 0;
                            i6 = 0;
                            i25 = 0;
                            node$iv$iv = node$iv$iv6;
                            while (node$iv$iv != null) {
                                branches$iv$iv = count$iv$iv;
                                child$iv$iv = onFound;
                                i = 0;
                                if (kindSet$ui_release2 &= constructor-impl != 0) {
                                } else {
                                }
                                count$iv$iv = 0;
                                if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                success2 = success3;
                                obj4 = node$iv$iv;
                                i2 = i10;
                                node$iv$iv2 = obj4;
                                node$iv$iv = DelegatableNodeKt.access$pop(i6);
                                i10 = i2;
                                count$iv$iv = branches$iv$iv;
                                child$iv$iv2 = child$iv$iv4;
                                success3 = success2;
                                if (node$iv$iv instanceof DelegatingNode) {
                                } else {
                                }
                                count$iv$iv = 0;
                                booleanValue = 0;
                                node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                                while (node$iv$iv$iv != null) {
                                    node = node$iv$iv$iv;
                                    i11 = 0;
                                    i3 = 0;
                                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = 0;
                                    if (count$iv$iv2 != 0) {
                                    } else {
                                    }
                                    success2 = success3;
                                    node$iv$iv3 = node;
                                    success = obj4;
                                    node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                    child$iv$iv = onFound;
                                    node$iv$iv = success;
                                    success3 = success2;
                                    i10 = 1;
                                    count$iv$iv++;
                                    if (count$iv$iv == i10) {
                                    } else {
                                    }
                                    if (i6 == 0) {
                                    } else {
                                    }
                                    count$iv$iv2 = count$iv$iv;
                                    success2 = success3;
                                    obj4 = node$iv$iv;
                                    node$iv$iv5 = 0;
                                    child$iv$iv = i6;
                                    obj7 = obj4;
                                    if (obj7 != null) {
                                    } else {
                                    }
                                    success = obj4;
                                    if (child$iv$iv != 0) {
                                    } else {
                                    }
                                    node$iv$iv3 = node;
                                    i6 = child$iv$iv;
                                    count$iv$iv = count$iv$iv2;
                                    child$iv$iv.add(node);
                                    if (child$iv$iv != 0) {
                                    }
                                    success = 0;
                                    child$iv$iv.add(obj7);
                                    count$iv$iv2 = count$iv$iv;
                                    i3 = 0;
                                    i14 = i20;
                                    success2 = success3;
                                    obj4 = node$iv$iv;
                                    child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                    success2 = success3;
                                    success = node$iv$iv3;
                                    count$iv$iv2 = i10;
                                }
                                obj4 = node$iv$iv;
                                i2 = 1;
                                if (count$iv$iv == i2) {
                                } else {
                                }
                                node$iv$iv2 = obj4;
                                i10 = i2;
                                count$iv$iv = branches$iv$iv;
                                child$iv$iv2 = child$iv$iv4;
                                success3 = success2;
                                node$iv$iv = obj4;
                                node = node$iv$iv$iv;
                                i11 = 0;
                                i3 = 0;
                                if (kindSet$ui_release3 &= constructor-impl != 0) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                if (count$iv$iv2 != 0) {
                                } else {
                                }
                                success2 = success3;
                                node$iv$iv3 = node;
                                success = obj4;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv = success;
                                success3 = success2;
                                i10 = 1;
                                count$iv$iv++;
                                if (count$iv$iv == i10) {
                                } else {
                                }
                                if (i6 == 0) {
                                } else {
                                }
                                count$iv$iv2 = count$iv$iv;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                node$iv$iv5 = 0;
                                child$iv$iv = i6;
                                obj7 = obj4;
                                if (obj7 != null) {
                                } else {
                                }
                                success = obj4;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv3 = node;
                                i6 = child$iv$iv;
                                count$iv$iv = count$iv$iv2;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv2 = count$iv$iv;
                                i3 = 0;
                                i14 = i20;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success2 = success3;
                                success = node$iv$iv3;
                                count$iv$iv2 = i10;
                                count$iv$iv = i10;
                                i = 0;
                                child$iv$iv4 = child$iv$iv2;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                i2 = i10;
                            }
                            branches$iv$iv = count$iv$iv;
                            success2 = success3;
                            obj4 = node$iv$iv;
                            child$iv$iv8 = i10;
                            child$iv$iv2 = child$iv$iv4;
                            node$iv$iv = 0;
                            branches$iv$iv = count$iv$iv;
                            if (node$iv$iv instanceof FocusTargetNode) {
                            } else {
                            }
                            child$iv$iv = onFound;
                            i = 0;
                            if (kindSet$ui_release2 &= constructor-impl != 0) {
                            } else {
                            }
                            count$iv$iv = 0;
                            if (count$iv$iv != 0 && node$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            success2 = success3;
                            obj4 = node$iv$iv;
                            i2 = i10;
                            node$iv$iv2 = obj4;
                            node$iv$iv = DelegatableNodeKt.access$pop(i6);
                            i10 = i2;
                            count$iv$iv = branches$iv$iv;
                            child$iv$iv2 = child$iv$iv4;
                            success3 = success2;
                            if (node$iv$iv instanceof DelegatingNode) {
                            } else {
                            }
                            count$iv$iv = 0;
                            booleanValue = 0;
                            node$iv$iv$iv = (DelegatingNode)node$iv$iv.getDelegate$ui_release();
                            while (node$iv$iv$iv != null) {
                                node = node$iv$iv$iv;
                                i11 = 0;
                                i3 = 0;
                                if (kindSet$ui_release3 &= constructor-impl != 0) {
                                } else {
                                }
                                count$iv$iv2 = 0;
                                if (count$iv$iv2 != 0) {
                                } else {
                                }
                                success2 = success3;
                                node$iv$iv3 = node;
                                success = obj4;
                                node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                                child$iv$iv = onFound;
                                node$iv$iv = success;
                                success3 = success2;
                                i10 = 1;
                                count$iv$iv++;
                                if (count$iv$iv == i10) {
                                } else {
                                }
                                if (i6 == 0) {
                                } else {
                                }
                                count$iv$iv2 = count$iv$iv;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                node$iv$iv5 = 0;
                                child$iv$iv = i6;
                                obj7 = obj4;
                                if (obj7 != null) {
                                } else {
                                }
                                success = obj4;
                                if (child$iv$iv != 0) {
                                } else {
                                }
                                node$iv$iv3 = node;
                                i6 = child$iv$iv;
                                count$iv$iv = count$iv$iv2;
                                child$iv$iv.add(node);
                                if (child$iv$iv != 0) {
                                }
                                success = 0;
                                child$iv$iv.add(obj7);
                                count$iv$iv2 = count$iv$iv;
                                i3 = 0;
                                i14 = i20;
                                success2 = success3;
                                obj4 = node$iv$iv;
                                child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                                success2 = success3;
                                success = node$iv$iv3;
                                count$iv$iv2 = i10;
                            }
                            obj4 = node$iv$iv;
                            i2 = 1;
                            if (count$iv$iv == i2) {
                            } else {
                            }
                            node$iv$iv2 = obj4;
                            i10 = i2;
                            count$iv$iv = branches$iv$iv;
                            child$iv$iv2 = child$iv$iv4;
                            success3 = success2;
                            node$iv$iv = obj4;
                            node = node$iv$iv$iv;
                            i11 = 0;
                            i3 = 0;
                            if (kindSet$ui_release3 &= constructor-impl != 0) {
                            } else {
                            }
                            count$iv$iv2 = 0;
                            if (count$iv$iv2 != 0) {
                            } else {
                            }
                            success2 = success3;
                            node$iv$iv3 = node;
                            success = obj4;
                            node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release();
                            child$iv$iv = onFound;
                            node$iv$iv = success;
                            success3 = success2;
                            i10 = 1;
                            count$iv$iv++;
                            if (count$iv$iv == i10) {
                            } else {
                            }
                            if (i6 == 0) {
                            } else {
                            }
                            count$iv$iv2 = count$iv$iv;
                            success2 = success3;
                            obj4 = node$iv$iv;
                            node$iv$iv5 = 0;
                            child$iv$iv = i6;
                            obj7 = obj4;
                            if (obj7 != null) {
                            } else {
                            }
                            success = obj4;
                            if (child$iv$iv != 0) {
                            } else {
                            }
                            node$iv$iv3 = node;
                            i6 = child$iv$iv;
                            count$iv$iv = count$iv$iv2;
                            child$iv$iv.add(node);
                            if (child$iv$iv != 0) {
                            }
                            success = 0;
                            child$iv$iv.add(obj7);
                            count$iv$iv2 = count$iv$iv;
                            i3 = 0;
                            i14 = i20;
                            success2 = success3;
                            obj4 = node$iv$iv;
                            child$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                            success2 = success3;
                            success = node$iv$iv3;
                            count$iv$iv2 = i10;
                            count$iv$iv = i10;
                            i = 0;
                            child$iv$iv4 = child$iv$iv2;
                            if ((Boolean)onFound.invoke((FocusTargetNode)node$iv$iv).booleanValue()) {
                            } else {
                            }
                            success2 = success3;
                            obj4 = node$iv$iv;
                            i2 = i10;
                            success3 = 1;
                            child$iv$iv3 = i10;
                            DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv, notEmpty);
                            DelegatableNodeKt.access$addLayoutNodeChildren(count$iv$iv, obj3.getNode());
                        }
                        int $i$f$findFocusTarget4 = child$iv$iv3;
                        int i17 = 0;
                        IllegalStateException illegalStateException2 = new IllegalStateException("visitChildren called on an unattached node".toString());
                        throw illegalStateException2;
                    }
                    $i$f$findFocusTarget = child$iv$iv3;
                    return success3;
                }
                int $i$f$findFocusTarget5 = child$iv$iv3;
                int i18 = 0;
                IllegalStateException illegalStateException3 = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
                throw illegalStateException3;
            }
            int $i$f$findFocusTarget3 = child$iv$iv3;
            int i16 = 0;
            IllegalStateException illegalStateException = new IllegalStateException(str3.toString());
            throw illegalStateException;
        }
        int $i$f$findFocusTarget6 = child$iv$iv3;
        int i19 = 0;
        IllegalStateException illegalStateException4 = new IllegalStateException(str3.toString());
        throw illegalStateException4;
    }

    public final boolean captureFocus() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean captureFocus;
        if (!this.focusRequesterNodes.isNotEmpty()) {
        } else {
            MutableVector focusRequesterNodes2 = this.focusRequesterNodes;
            int i3 = 0;
            final int size = focusRequesterNodes2.getSize();
            if (size > 0) {
                i$iv = 0;
                i = 0;
                while (FocusRequesterModifierNodeKt.captureFocus((FocusRequesterModifierNode)focusRequesterNodes2.getContent()[i$iv])) {
                    i = 0;
                }
                return 1;
            }
            return 0;
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        throw illegalStateException;
    }

    public final boolean findFocusTargetNode$ui_release(Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> onFound) {
        int function1;
        Modifier.Node next$iv$iv$iv;
        int capacity$iv$iv$iv$iv$iv;
        int i8;
        androidx.compose.ui.focus.FocusRequester this_$iv2;
        Object it$iv;
        MutableVector count$iv$iv$iv2;
        int this_$iv$iv$iv$iv2;
        int i7;
        int i13;
        int success$iv;
        int node$iv$iv$iv2;
        Object notEmpty;
        int i$iv$iv;
        Object[] content;
        Object obj4;
        int i15;
        Object obj3;
        int constructor-impl;
        int i9;
        int i3;
        Object obj;
        int i;
        Object node$iv$iv$iv3;
        int i14;
        Object size;
        androidx.compose.ui.focus.FocusRequester this_$iv;
        int i4;
        int i11;
        Object obj2;
        int i2;
        int i10;
        Object node$iv$iv$iv;
        MutableVector branches$iv$iv$iv;
        int i12;
        boolean node$iv$iv$iv$iv;
        int i16;
        Object it$iv2;
        Modifier.Node child$iv$iv$iv;
        int this_$iv$iv$iv$iv;
        int i5;
        int count$iv$iv$iv;
        Object this_$iv$iv$iv$iv3;
        int i6;
        function1 = onFound;
        this_$iv2 = this;
        node$iv$iv$iv2 = 0;
        i7 = this_$iv2 != FocusRequester.Companion.getDefault() ? 1 : node$iv$iv$iv2;
        String str3 = "\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n";
        if (i7 == 0) {
        } else {
            i13 = this_$iv2 != FocusRequester.Companion.getCancel() ? 1 : node$iv$iv$iv2;
            if (i13 == 0) {
            } else {
                if (!this_$iv2.focusRequesterNodes.isNotEmpty()) {
                } else {
                    success$iv = 0;
                    MutableVector focusRequesterNodes2 = this_$iv2.focusRequesterNodes;
                    final int i26 = 0;
                    final int size2 = focusRequesterNodes2.getSize();
                    if (size2 > 0) {
                        i$iv$iv = 0;
                        i15 = 0;
                        int i27 = 0;
                        constructor-impl = NodeKind.constructor-impl(1024);
                        i9 = 0;
                        i3 = constructor-impl;
                        obj = obj3;
                        i = 0;
                        while (obj.getNode().isAttached()) {
                            node$iv$iv$iv3 = 0;
                            i14 = 1;
                            size = 0;
                            this_$iv2 = new MutableVector(new Modifier.Node[16], node$iv$iv$iv2);
                            this_$iv$iv$iv$iv2 = obj.getNode().getChild$ui_release();
                            if (this_$iv$iv$iv$iv2 == null) {
                            } else {
                            }
                            this_$iv2.add(this_$iv$iv$iv$iv2);
                            while (this_$iv2.isNotEmpty()) {
                                int i29 = 0;
                                notEmpty = this_$iv2.removeAt(size + -1);
                                if (aggregateChildKindSet$ui_release &= i3 == 0) {
                                    break loop_15;
                                } else {
                                }
                                node$iv$iv$iv3 = notEmpty;
                                while (node$iv$iv$iv3 != null) {
                                    branches$iv$iv$iv = this_$iv2;
                                    child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    int i19 = i14;
                                    node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                    node$iv$iv$iv2 = 0;
                                    function1 = onFound;
                                }
                                branches$iv$iv$iv = this_$iv2;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                int i18 = i14;
                                node$iv$iv$iv2 = 0;
                                function1 = onFound;
                                if (kindSet$ui_release &= i3 == 0) {
                                    break loop_15;
                                } else {
                                }
                                branches$iv$iv$iv = this_$iv2;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i19 = i14;
                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                node$iv$iv$iv2 = 0;
                                function1 = onFound;
                                i11 = 0;
                                i2 = 0;
                                i10 = 0;
                                int i30 = 0;
                                node$iv$iv$iv2 = node$iv$iv$iv;
                                while (node$iv$iv$iv2 != null) {
                                    branches$iv$iv$iv = this_$iv2;
                                    this_$iv$iv$iv$iv2 = 0;
                                    if (kindSet$ui_release2 &= constructor-impl != 0) {
                                    } else {
                                    }
                                    it$iv = 0;
                                    if (it$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    i8 = i14;
                                    node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                                    i14 = i8;
                                    this_$iv2 = branches$iv$iv$iv;
                                    this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                    function1 = onFound;
                                    if (node$iv$iv$iv2 instanceof DelegatingNode) {
                                    } else {
                                    }
                                    it$iv = 0;
                                    i12 = 0;
                                    node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                                    while (node$iv$iv$iv$iv != null) {
                                        i16 = node$iv$iv$iv$iv;
                                        it$iv2 = 0;
                                        i5 = 0;
                                        if (kindSet$ui_release3 &= constructor-impl != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv = 0;
                                        if (this_$iv$iv$iv$iv != 0) {
                                        } else {
                                        }
                                        this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                        next$iv$iv$iv = i16;
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                        function1 = onFound;
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                        i14 = 1;
                                        it$iv++;
                                        if (it$iv == i14) {
                                        } else {
                                        }
                                        if (i10 == 0) {
                                        } else {
                                        }
                                        count$iv$iv$iv = it$iv;
                                        this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                        capacity$iv$iv$iv$iv$iv = 0;
                                        count$iv$iv$iv2 = i10;
                                        this_$iv$iv$iv$iv2 = node$iv$iv$iv2;
                                        if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                        }
                                        if (count$iv$iv$iv2 != null) {
                                        } else {
                                        }
                                        next$iv$iv$iv = i16;
                                        i10 = count$iv$iv$iv2;
                                        it$iv = count$iv$iv$iv;
                                        count$iv$iv$iv2.add(i16);
                                        if (count$iv$iv$iv2 != null) {
                                        }
                                        node$iv$iv$iv2 = 0;
                                        count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                        this_$iv$iv$iv$iv = i21;
                                        int $i$f$mutableVectorOf = 16;
                                        i5 = 0;
                                        count$iv$iv$iv = it$iv;
                                        this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                        i6 = $i$f$mutableVectorOf;
                                        count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                        node$iv$iv$iv2 = i16;
                                        this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                        next$iv$iv$iv = i16;
                                        this_$iv$iv$iv$iv = i14;
                                    }
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    i8 = 1;
                                    if (it$iv == i8) {
                                    } else {
                                    }
                                    i14 = i8;
                                    this_$iv2 = branches$iv$iv$iv;
                                    this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                    function1 = onFound;
                                    i16 = node$iv$iv$iv$iv;
                                    it$iv2 = 0;
                                    i5 = 0;
                                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i16;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    i14 = 1;
                                    it$iv++;
                                    if (it$iv == i14) {
                                    } else {
                                    }
                                    if (i10 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i10;
                                    this_$iv$iv$iv$iv2 = node$iv$iv$iv2;
                                    if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i16;
                                    i10 = count$iv$iv$iv2;
                                    it$iv = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i16);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv2 = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                    this_$iv$iv$iv$iv = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i5 = 0;
                                    count$iv$iv$iv = it$iv;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    i6 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv2 = i16;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i16;
                                    this_$iv$iv$iv$iv = i14;
                                    it$iv = i14;
                                    Object obj5 = node$iv$iv$iv2;
                                    i12 = 0;
                                    Object obj7 = obj5;
                                    i16 = 0;
                                    if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                    } else {
                                    }
                                    it$iv2 = obj5;
                                    child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                    node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                    i8 = i14;
                                    it$iv2 = obj5;
                                    node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                    child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                }
                                branches$iv$iv$iv = this_$iv2;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                int i22 = i14;
                                node$iv$iv$iv2 = 0;
                                function1 = onFound;
                                branches$iv$iv$iv = this_$iv2;
                                this_$iv$iv$iv$iv2 = 0;
                                if (kindSet$ui_release2 &= constructor-impl != 0) {
                                } else {
                                }
                                it$iv = 0;
                                if (it$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                i8 = i14;
                                node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                                i14 = i8;
                                this_$iv2 = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                function1 = onFound;
                                if (node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                it$iv = 0;
                                i12 = 0;
                                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv != null) {
                                    i16 = node$iv$iv$iv$iv;
                                    it$iv2 = 0;
                                    i5 = 0;
                                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i16;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    i14 = 1;
                                    it$iv++;
                                    if (it$iv == i14) {
                                    } else {
                                    }
                                    if (i10 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i10;
                                    this_$iv$iv$iv$iv2 = node$iv$iv$iv2;
                                    if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i16;
                                    i10 = count$iv$iv$iv2;
                                    it$iv = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i16);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv2 = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                    this_$iv$iv$iv$iv = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i5 = 0;
                                    count$iv$iv$iv = it$iv;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    i6 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv2 = i16;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i16;
                                    this_$iv$iv$iv$iv = i14;
                                }
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                i8 = 1;
                                if (it$iv == i8) {
                                } else {
                                }
                                i14 = i8;
                                this_$iv2 = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                function1 = onFound;
                                i16 = node$iv$iv$iv$iv;
                                it$iv2 = 0;
                                i5 = 0;
                                if (kindSet$ui_release3 &= constructor-impl != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = 0;
                                if (this_$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i16;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                i14 = 1;
                                it$iv++;
                                if (it$iv == i14) {
                                } else {
                                }
                                if (i10 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i10;
                                this_$iv$iv$iv$iv2 = node$iv$iv$iv2;
                                if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i16;
                                i10 = count$iv$iv$iv2;
                                it$iv = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i16);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv2 = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                this_$iv$iv$iv$iv = i21;
                                $i$f$mutableVectorOf = 16;
                                i5 = 0;
                                count$iv$iv$iv = it$iv;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                i6 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv2 = i16;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i16;
                                this_$iv$iv$iv$iv = i14;
                                it$iv = i14;
                                obj5 = node$iv$iv$iv2;
                                i12 = 0;
                                obj7 = obj5;
                                i16 = 0;
                                if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                } else {
                                }
                                it$iv2 = obj5;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                i8 = i14;
                                it$iv2 = obj5;
                                node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv2, notEmpty);
                            }
                            branches$iv$iv$iv = this_$iv2;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            function1 = i14;
                            function1 = onFound;
                            this_$iv2 = this_$iv;
                            this_$iv$iv$iv$iv2 = i4;
                            node$iv$iv$iv2 = 0;
                            i15 = 0;
                            i27 = 0;
                            constructor-impl = NodeKind.constructor-impl(1024);
                            i9 = 0;
                            i3 = constructor-impl;
                            obj = obj3;
                            i = 0;
                            i29 = 0;
                            notEmpty = this_$iv2.removeAt(size + -1);
                            if (aggregateChildKindSet$ui_release &= i3 == 0) {
                            } else {
                            }
                            node$iv$iv$iv3 = notEmpty;
                            while (node$iv$iv$iv3 != null) {
                                branches$iv$iv$iv = this_$iv2;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                i19 = i14;
                                node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                                node$iv$iv$iv2 = 0;
                                function1 = onFound;
                            }
                            branches$iv$iv$iv = this_$iv2;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            i18 = i14;
                            node$iv$iv$iv2 = 0;
                            function1 = onFound;
                            if (kindSet$ui_release &= i3 != 0) {
                            } else {
                            }
                            branches$iv$iv$iv = this_$iv2;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            i19 = i14;
                            node$iv$iv$iv3 = node$iv$iv$iv3.getChild$ui_release();
                            node$iv$iv$iv2 = 0;
                            function1 = onFound;
                            i11 = 0;
                            i2 = 0;
                            i10 = 0;
                            i30 = 0;
                            node$iv$iv$iv2 = node$iv$iv$iv;
                            while (node$iv$iv$iv2 != null) {
                                branches$iv$iv$iv = this_$iv2;
                                this_$iv$iv$iv$iv2 = 0;
                                if (kindSet$ui_release2 &= constructor-impl != 0) {
                                } else {
                                }
                                it$iv = 0;
                                if (it$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                i8 = i14;
                                node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                                i14 = i8;
                                this_$iv2 = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                function1 = onFound;
                                if (node$iv$iv$iv2 instanceof DelegatingNode) {
                                } else {
                                }
                                it$iv = 0;
                                i12 = 0;
                                node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                                while (node$iv$iv$iv$iv != null) {
                                    i16 = node$iv$iv$iv$iv;
                                    it$iv2 = 0;
                                    i5 = 0;
                                    if (kindSet$ui_release3 &= constructor-impl != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv = 0;
                                    if (this_$iv$iv$iv$iv != 0) {
                                    } else {
                                    }
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i16;
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                    function1 = onFound;
                                    this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                    i14 = 1;
                                    it$iv++;
                                    if (it$iv == i14) {
                                    } else {
                                    }
                                    if (i10 == 0) {
                                    } else {
                                    }
                                    count$iv$iv$iv = it$iv;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    capacity$iv$iv$iv$iv$iv = 0;
                                    count$iv$iv$iv2 = i10;
                                    this_$iv$iv$iv$iv2 = node$iv$iv$iv2;
                                    if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                    }
                                    if (count$iv$iv$iv2 != null) {
                                    } else {
                                    }
                                    next$iv$iv$iv = i16;
                                    i10 = count$iv$iv$iv2;
                                    it$iv = count$iv$iv$iv;
                                    count$iv$iv$iv2.add(i16);
                                    if (count$iv$iv$iv2 != null) {
                                    }
                                    node$iv$iv$iv2 = 0;
                                    count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                    this_$iv$iv$iv$iv = i21;
                                    $i$f$mutableVectorOf = 16;
                                    i5 = 0;
                                    count$iv$iv$iv = it$iv;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    i6 = $i$f$mutableVectorOf;
                                    count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                    node$iv$iv$iv2 = i16;
                                    this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                    next$iv$iv$iv = i16;
                                    this_$iv$iv$iv$iv = i14;
                                }
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                i8 = 1;
                                if (it$iv == i8) {
                                } else {
                                }
                                i14 = i8;
                                this_$iv2 = branches$iv$iv$iv;
                                this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                                function1 = onFound;
                                i16 = node$iv$iv$iv$iv;
                                it$iv2 = 0;
                                i5 = 0;
                                if (kindSet$ui_release3 &= constructor-impl != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = 0;
                                if (this_$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i16;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                i14 = 1;
                                it$iv++;
                                if (it$iv == i14) {
                                } else {
                                }
                                if (i10 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i10;
                                this_$iv$iv$iv$iv2 = node$iv$iv$iv2;
                                if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i16;
                                i10 = count$iv$iv$iv2;
                                it$iv = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i16);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv2 = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                this_$iv$iv$iv$iv = i21;
                                $i$f$mutableVectorOf = 16;
                                i5 = 0;
                                count$iv$iv$iv = it$iv;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                i6 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv2 = i16;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i16;
                                this_$iv$iv$iv$iv = i14;
                                it$iv = i14;
                                obj5 = node$iv$iv$iv2;
                                i12 = 0;
                                obj7 = obj5;
                                i16 = 0;
                                if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                                } else {
                                }
                                it$iv2 = obj5;
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                                node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                                i8 = i14;
                                it$iv2 = obj5;
                                node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                                child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            }
                            branches$iv$iv$iv = this_$iv2;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            i22 = i14;
                            node$iv$iv$iv2 = 0;
                            function1 = onFound;
                            branches$iv$iv$iv = this_$iv2;
                            if (node$iv$iv$iv2 instanceof FocusTargetNode) {
                            } else {
                            }
                            this_$iv$iv$iv$iv2 = 0;
                            if (kindSet$ui_release2 &= constructor-impl != 0) {
                            } else {
                            }
                            it$iv = 0;
                            if (it$iv != 0 && node$iv$iv$iv2 instanceof DelegatingNode) {
                            } else {
                            }
                            i8 = i14;
                            node$iv$iv$iv2 = DelegatableNodeKt.access$pop(i10);
                            i14 = i8;
                            this_$iv2 = branches$iv$iv$iv;
                            this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                            function1 = onFound;
                            if (node$iv$iv$iv2 instanceof DelegatingNode) {
                            } else {
                            }
                            it$iv = 0;
                            i12 = 0;
                            node$iv$iv$iv$iv = (DelegatingNode)node$iv$iv$iv2.getDelegate$ui_release();
                            while (node$iv$iv$iv$iv != null) {
                                i16 = node$iv$iv$iv$iv;
                                it$iv2 = 0;
                                i5 = 0;
                                if (kindSet$ui_release3 &= constructor-impl != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv = 0;
                                if (this_$iv$iv$iv$iv != 0) {
                                } else {
                                }
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i16;
                                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                                function1 = onFound;
                                this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                i14 = 1;
                                it$iv++;
                                if (it$iv == i14) {
                                } else {
                                }
                                if (i10 == 0) {
                                } else {
                                }
                                count$iv$iv$iv = it$iv;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                capacity$iv$iv$iv$iv$iv = 0;
                                count$iv$iv$iv2 = i10;
                                this_$iv$iv$iv$iv2 = node$iv$iv$iv2;
                                if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                                }
                                if (count$iv$iv$iv2 != null) {
                                } else {
                                }
                                next$iv$iv$iv = i16;
                                i10 = count$iv$iv$iv2;
                                it$iv = count$iv$iv$iv;
                                count$iv$iv$iv2.add(i16);
                                if (count$iv$iv$iv2 != null) {
                                }
                                node$iv$iv$iv2 = 0;
                                count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                                this_$iv$iv$iv$iv = i21;
                                $i$f$mutableVectorOf = 16;
                                i5 = 0;
                                count$iv$iv$iv = it$iv;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                i6 = $i$f$mutableVectorOf;
                                count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                                node$iv$iv$iv2 = i16;
                                this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                next$iv$iv$iv = i16;
                                this_$iv$iv$iv$iv = i14;
                            }
                            this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                            i8 = 1;
                            if (it$iv == i8) {
                            } else {
                            }
                            i14 = i8;
                            this_$iv2 = branches$iv$iv$iv;
                            this_$iv$iv$iv$iv2 = child$iv$iv$iv;
                            function1 = onFound;
                            i16 = node$iv$iv$iv$iv;
                            it$iv2 = 0;
                            i5 = 0;
                            if (kindSet$ui_release3 &= constructor-impl != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv = 0;
                            if (this_$iv$iv$iv$iv != 0) {
                            } else {
                            }
                            this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                            next$iv$iv$iv = i16;
                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                            function1 = onFound;
                            this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                            i14 = 1;
                            it$iv++;
                            if (it$iv == i14) {
                            } else {
                            }
                            if (i10 == 0) {
                            } else {
                            }
                            count$iv$iv$iv = it$iv;
                            this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                            capacity$iv$iv$iv$iv$iv = 0;
                            count$iv$iv$iv2 = i10;
                            this_$iv$iv$iv$iv2 = node$iv$iv$iv2;
                            if (this_$iv$iv$iv$iv2 != null && count$iv$iv$iv2 != null) {
                            }
                            if (count$iv$iv$iv2 != null) {
                            } else {
                            }
                            next$iv$iv$iv = i16;
                            i10 = count$iv$iv$iv2;
                            it$iv = count$iv$iv$iv;
                            count$iv$iv$iv2.add(i16);
                            if (count$iv$iv$iv2 != null) {
                            }
                            node$iv$iv$iv2 = 0;
                            count$iv$iv$iv2.add(this_$iv$iv$iv$iv2);
                            this_$iv$iv$iv$iv = i21;
                            $i$f$mutableVectorOf = 16;
                            i5 = 0;
                            count$iv$iv$iv = it$iv;
                            this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                            i6 = $i$f$mutableVectorOf;
                            count$iv$iv$iv2 = new MutableVector(new Modifier.Node[$i$f$mutableVectorOf], 0);
                            node$iv$iv$iv2 = i16;
                            this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                            next$iv$iv$iv = i16;
                            this_$iv$iv$iv$iv = i14;
                            it$iv = i14;
                            obj5 = node$iv$iv$iv2;
                            i12 = 0;
                            obj7 = obj5;
                            i16 = 0;
                            if (obj7.fetchFocusProperties$ui_release().getCanFocus()) {
                            } else {
                            }
                            it$iv2 = obj5;
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            node$iv$iv$iv$iv = TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(obj7, FocusDirection.Companion.getEnter-dhqQ-8s(), function1);
                            if (node$iv$iv$iv$iv) {
                            } else {
                            }
                            i8 = i14;
                            success$iv = this_$iv2;
                            function1 = i14;
                            it$iv2 = obj5;
                            node$iv$iv$iv$iv = (Boolean)function1.invoke(obj7).booleanValue();
                            child$iv$iv$iv = this_$iv$iv$iv$iv2;
                            DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv2, notEmpty);
                            DelegatableNodeKt.access$addLayoutNodeChildren(this_$iv2, obj.getNode());
                        }
                        androidx.compose.ui.focus.FocusRequester this_$iv4 = this_$iv2;
                        int i23 = 0;
                        IllegalStateException illegalStateException2 = new IllegalStateException("visitChildren called on an unattached node".toString());
                        throw illegalStateException2;
                    }
                    this_$iv = this_$iv2;
                    i4 = this_$iv$iv$iv$iv2;
                    return success$iv;
                }
                androidx.compose.ui.focus.FocusRequester request = this_$iv2;
                int i24 = 0;
                IllegalStateException illegalStateException3 = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
                throw illegalStateException3;
            }
            androidx.compose.ui.focus.FocusRequester this_$iv3 = this_$iv2;
            int i17 = 0;
            IllegalStateException illegalStateException = new IllegalStateException(str3.toString());
            throw illegalStateException;
        }
        androidx.compose.ui.focus.FocusRequester this_$iv5 = this_$iv2;
        int i25 = 0;
        IllegalStateException illegalStateException4 = new IllegalStateException(str3.toString());
        throw illegalStateException4;
    }

    public final boolean focus$ui_release() {
        return findFocusTargetNode$ui_release((Function1)FocusRequester.focus.1.INSTANCE);
    }

    public final boolean freeFocus() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean freeFocus;
        if (!this.focusRequesterNodes.isNotEmpty()) {
        } else {
            MutableVector focusRequesterNodes2 = this.focusRequesterNodes;
            int i3 = 0;
            final int size = focusRequesterNodes2.getSize();
            if (size > 0) {
                i$iv = 0;
                i = 0;
                while (FocusRequesterModifierNodeKt.freeFocus((FocusRequesterModifierNode)focusRequesterNodes2.getContent()[i$iv])) {
                    i = 0;
                }
                return 1;
            }
            return 0;
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        throw illegalStateException;
    }

    public final MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        focus$ui_release();
    }

    public final boolean restoreFocusedChild() {
        int success;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        int i2;
        if (!this.focusRequesterNodes.isNotEmpty()) {
        } else {
            success = 0;
            MutableVector focusRequesterNodes2 = this.focusRequesterNodes;
            final int i3 = 0;
            final int size = focusRequesterNodes2.getSize();
            if (size > 0) {
                i$iv = 0;
                i = 0;
                do {
                    i = 0;
                    i2 = 1;
                    success = i2;
                    if (i$iv++ < size) {
                    }
                    if (success != 0) {
                    } else {
                    }
                    i2 = 0;
                } while (!FocusRequesterModifierNodeKt.restoreFocusedChild((FocusRequesterModifierNode)focusRequesterNodes2.getContent()[i$iv]));
            }
            return success;
        }
        int success2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        throw illegalStateException;
    }

    public final boolean saveFocusedChild() {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean focusedChild;
        if (!this.focusRequesterNodes.isNotEmpty()) {
        } else {
            MutableVector focusRequesterNodes2 = this.focusRequesterNodes;
            int i3 = 0;
            final int size = focusRequesterNodes2.getSize();
            if (size > 0) {
                i$iv = 0;
                i = 0;
                while (FocusRequesterModifierNodeKt.saveFocusedChild((FocusRequesterModifierNode)focusRequesterNodes2.getContent()[i$iv])) {
                    i = 0;
                }
                return 1;
            }
            return 0;
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        throw illegalStateException;
    }
}
