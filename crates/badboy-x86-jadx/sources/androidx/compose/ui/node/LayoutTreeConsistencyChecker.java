package androidx.compose.ui.node;

import java.io.PrintStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u000c\u0010\u0012\u001a\u00020\r*\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "postponedMeasureRequests", "", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "logTree", "", "nodeToString", "consistentLayoutState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutTreeConsistencyChecker {

    public static final int $stable = 8;
    private final List<androidx.compose.ui.node.MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests;
    private final androidx.compose.ui.node.DepthSortedSetsForDifferentPasses relayoutNodes;
    private final androidx.compose.ui.node.LayoutNode root;
    static {
        final int i = 8;
    }

    public LayoutTreeConsistencyChecker(androidx.compose.ui.node.LayoutNode root, androidx.compose.ui.node.DepthSortedSetsForDifferentPasses relayoutNodes, List<androidx.compose.ui.node.MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests) {
        super();
        this.root = root;
        this.relayoutNodes = relayoutNodes;
        this.postponedMeasureRequests = postponedMeasureRequests;
    }

    private final boolean consistentLayoutState(androidx.compose.ui.node.LayoutNode $this$consistentLayoutState) {
        int layoutPending$ui_release;
        boolean lookahead;
        int layoutState$ui_release;
        boolean measurePending$ui_release;
        Object $this$fastFirstOrNull$iv;
        int lookaheadMeasurePending$ui_release;
        boolean lookaheadMeasurePending$ui_release2;
        boolean lookaheadLayoutPending$ui_release;
        int layoutState$ui_release2;
        int placeOrder$ui_release;
        Boolean valueOf;
        int i7;
        int i;
        int i6;
        boolean lookahead2;
        int i8;
        int i2;
        int i3;
        List list;
        int index$iv$iv2;
        int index$iv$iv;
        int size;
        Object obj3;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        final Object obj4 = this;
        final Object obj5 = $this$consistentLayoutState;
        final androidx.compose.ui.node.LayoutNode parent$ui_release = obj5.getParent$ui_release();
        if (parent$ui_release != null) {
            layoutState$ui_release2 = parent$ui_release.getLayoutState$ui_release();
        } else {
            layoutState$ui_release2 = 0;
        }
        final int i9 = 1;
        if (!obj5.isPlaced()) {
            if (obj5.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                if (parent$ui_release != null && parent$ui_release.isPlaced() == i9) {
                    placeOrder$ui_release = parent$ui_release.isPlaced() == i9 ? i9 : 0;
                } else {
                }
                if (placeOrder$ui_release != 0 && obj5.getMeasurePending$ui_release()) {
                    if (obj5.getMeasurePending$ui_release()) {
                        i3 = 0;
                        list = placeOrder$ui_release;
                        index$iv$iv2 = 0;
                        index$iv$iv = 0;
                        while (index$iv$iv < list.size()) {
                            i4 = 0;
                            obj2 = obj;
                            i5 = 0;
                            if (Intrinsics.areEqual((MeasureAndLayoutDelegate.PostponedRequest)obj2.getNode(), obj5) && !obj2.isLookahead()) {
                            } else {
                            }
                            layoutPending$ui_release = 0;
                            index$iv$iv++;
                            if (!obj2.isLookahead()) {
                            } else {
                            }
                            layoutPending$ui_release = i9;
                        }
                        obj = 0;
                        if (obj != null) {
                            return i9;
                        }
                    }
                    if (obj5.getMeasurePending$ui_release()) {
                        if (!obj4.relayoutNodes.contains(obj5) && obj5.getLayoutState$ui_release() != LayoutNode.LayoutState.LookaheadMeasuring) {
                            if (obj5.getLayoutState$ui_release() != LayoutNode.LayoutState.LookaheadMeasuring) {
                                if (parent$ui_release != null && parent$ui_release.getMeasurePending$ui_release() == i9) {
                                    layoutState$ui_release = parent$ui_release.getMeasurePending$ui_release() == i9 ? i9 : 0;
                                } else {
                                }
                                if (layoutState$ui_release == 0) {
                                    if (parent$ui_release != null && parent$ui_release.getLookaheadMeasurePending$ui_release() == i9) {
                                        layoutState$ui_release = parent$ui_release.getLookaheadMeasurePending$ui_release() == i9 ? i9 : 0;
                                    } else {
                                    }
                                    if (layoutState$ui_release == 0) {
                                        if (layoutState$ui_release2 == LayoutNode.LayoutState.Measuring) {
                                            i7 = i9;
                                        } else {
                                            i7 = 0;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                        return i7;
                    }
                    if (obj5.getLayoutPending$ui_release()) {
                        if (!obj4.relayoutNodes.contains(obj5) && parent$ui_release != null && !parent$ui_release.getMeasurePending$ui_release() && !parent$ui_release.getLayoutPending$ui_release() && layoutState$ui_release2 != LayoutNode.LayoutState.Measuring) {
                            if (parent$ui_release != null) {
                                if (!parent$ui_release.getMeasurePending$ui_release()) {
                                    if (!parent$ui_release.getLayoutPending$ui_release()) {
                                        if (layoutState$ui_release2 != LayoutNode.LayoutState.Measuring) {
                                            if (layoutState$ui_release2 == LayoutNode.LayoutState.LayingOut) {
                                                i = i9;
                                            } else {
                                                i = 0;
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                        return i;
                    }
                }
            }
        } else {
        }
        if (Intrinsics.areEqual(obj5.isPlacedInLookahead(), Boolean.valueOf(i9)) && obj5.getLookaheadMeasurePending$ui_release()) {
            if (obj5.getLookaheadMeasurePending$ui_release()) {
                valueOf = 0;
                i3 = postponedMeasureRequests;
                list = 0;
                index$iv$iv2 = 0;
                while (index$iv$iv2 < i3.size()) {
                    obj3 = size;
                    obj = 0;
                    i4 = obj3;
                    obj2 = null;
                    if (Intrinsics.areEqual((MeasureAndLayoutDelegate.PostponedRequest)i4.getNode(), obj5) && i4.isLookahead()) {
                    } else {
                    }
                    i6 = 0;
                    index$iv$iv2++;
                    if (i4.isLookahead()) {
                    } else {
                    }
                    i6 = i9;
                }
                $this$fastFirstOrNull$iv = 0;
                if ($this$fastFirstOrNull$iv != null) {
                    return i9;
                }
            }
            if (obj5.getLookaheadMeasurePending$ui_release()) {
                if (!obj4.relayoutNodes.contains(obj5, i9)) {
                    if (parent$ui_release != null && parent$ui_release.getLookaheadMeasurePending$ui_release() == i9) {
                        lookaheadMeasurePending$ui_release = parent$ui_release.getLookaheadMeasurePending$ui_release() == i9 ? i9 : 0;
                    } else {
                    }
                    if (lookaheadMeasurePending$ui_release == 0 && layoutState$ui_release2 != LayoutNode.LayoutState.LookaheadMeasuring) {
                        if (layoutState$ui_release2 != LayoutNode.LayoutState.LookaheadMeasuring) {
                            if (parent$ui_release != null && parent$ui_release.getMeasurePending$ui_release() == i9) {
                                lookaheadMeasurePending$ui_release = parent$ui_release.getMeasurePending$ui_release() == i9 ? i9 : 0;
                            } else {
                            }
                            if (lookaheadMeasurePending$ui_release != 0 && Intrinsics.areEqual(obj5.getLookaheadRoot$ui_release(), obj5)) {
                                if (Intrinsics.areEqual(obj5.getLookaheadRoot$ui_release(), obj5)) {
                                    i8 = i9;
                                } else {
                                    i8 = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                return i8;
            }
            if (obj5.getLookaheadLayoutPending$ui_release()) {
                if (!obj4.relayoutNodes.contains(obj5, i9) && parent$ui_release != null && !parent$ui_release.getLookaheadMeasurePending$ui_release() && !parent$ui_release.getLookaheadLayoutPending$ui_release() && layoutState$ui_release2 != LayoutNode.LayoutState.LookaheadMeasuring && layoutState$ui_release2 != LayoutNode.LayoutState.LookaheadLayingOut) {
                    if (parent$ui_release != null) {
                        if (!parent$ui_release.getLookaheadMeasurePending$ui_release()) {
                            if (!parent$ui_release.getLookaheadLayoutPending$ui_release()) {
                                if (layoutState$ui_release2 != LayoutNode.LayoutState.LookaheadMeasuring) {
                                    if (layoutState$ui_release2 != LayoutNode.LayoutState.LookaheadLayingOut) {
                                        if (parent$ui_release.getLayoutPending$ui_release() && Intrinsics.areEqual(obj5.getLookaheadRoot$ui_release(), obj5)) {
                                            if (Intrinsics.areEqual(obj5.getLookaheadRoot$ui_release(), obj5)) {
                                                i2 = i9;
                                            } else {
                                                i2 = 0;
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                return i2;
            }
        }
        return i9;
    }

    private final boolean isTreeConsistent(androidx.compose.ui.node.LayoutNode node) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        boolean treeConsistent;
        final int i2 = 0;
        if (!consistentLayoutState(node)) {
            return i2;
        }
        List children$ui_release = node.getChildren$ui_release();
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < children$ui_release.size()) {
            i = 0;
            index$iv++;
        }
        return 1;
    }

    private final String logTree() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
        LayoutTreeConsistencyChecker.logTree$printSubTree(this, stringBuilder, this.root, 0);
        return stringBuilder.toString();
    }

    private static final void logTree$printSubTree(androidx.compose.ui.node.LayoutTreeConsistencyChecker this$0, StringBuilder stringBuilder, androidx.compose.ui.node.LayoutNode node, int depth) {
        int childrenDepth;
        int append;
        int i;
        String str;
        int index$iv;
        Object obj2;
        Object obj;
        int i2;
        int i3 = 0;
        final String nodeToString = this$0.nodeToString(node);
        append = (CharSequence)nodeToString.length() > 0 ? 1 : 0;
        if (append != 0) {
            i = 0;
            while (i < depth) {
                stringBuilder.append("..");
                i++;
            }
            StringBuilder append2 = stringBuilder.append(nodeToString);
            Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append('\\n')");
            childrenDepth++;
        }
        List children$ui_release = node.getChildren$ui_release();
        int i4 = 0;
        index$iv = 0;
        while (index$iv < children$ui_release.size()) {
            i2 = 0;
            LayoutTreeConsistencyChecker.logTree$printSubTree(this$0, stringBuilder, (LayoutNode)children$ui_release.get(index$iv), childrenDepth);
            index$iv++;
        }
    }

    private final String nodeToString(androidx.compose.ui.node.LayoutNode node) {
        boolean placed;
        boolean consistentLayoutState;
        StringBuilder stringBuilder = new StringBuilder();
        final int i = 0;
        stringBuilder.append(node);
        StringBuilder stringBuilder2 = new StringBuilder();
        int i3 = 93;
        stringBuilder.append(stringBuilder2.append('[').append(node.getLayoutState$ui_release()).append(i3).toString());
        if (!node.isPlaced()) {
            stringBuilder.append("[!isPlaced]");
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder.append(stringBuilder3.append("[measuredByParent=").append(node.getMeasuredByParent$ui_release()).append(i3).toString());
        if (!consistentLayoutState(node)) {
            stringBuilder.append("[INCONSISTENT]");
        }
        return stringBuilder.toString();
    }

    public final void assertConsistent() {
        if (treeConsistent ^= 1 != 0) {
        } else {
        }
        System.out.println(logTree());
        IllegalStateException illegalStateException = new IllegalStateException("Inconsistency found!");
        throw illegalStateException;
    }
}
