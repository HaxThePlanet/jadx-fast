package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.view.View;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0008\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u000c*\u0008\u0012\u0004\u0012\u00020\u000c0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0012\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011*\u00020\u0013H\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0000\u001a\u000c\u0010\u0018\u001a\u00020\u0015*\u00020\u0019H\u0000\u001a\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"DefaultFakeNodeBounds", "Landroidx/compose/ui/geometry/Rect;", "getDefaultFakeNodeBounds", "()Landroidx/compose/ui/geometry/Rect;", "getScrollViewportLength", "", "configuration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Ljava/lang/Float;", "getTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "findById", "Landroidx/compose/ui/platform/ScrollObservationScope;", "", "id", "", "getAllUncoveredSemanticsNodesToIntObjectMap", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "isAncestorOf", "", "Landroidx/compose/ui/node/LayoutNode;", "node", "isImportantForAccessibility", "Landroidx/compose/ui/semantics/SemanticsNode;", "semanticsIdToView", "Landroid/view/View;", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "toLegacyClassName", "", "Landroidx/compose/ui/semantics/Role;", "toLegacyClassName-V4PA4sw", "(I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemanticsUtils_androidKt {

    private static final Rect DefaultFakeNodeBounds;
    static {
        final int i = 0;
        final int i2 = 1092616192;
        Rect rect = new Rect(i, i, i2, i2);
        SemanticsUtils_androidKt.DefaultFakeNodeBounds = rect;
    }

    public static final androidx.compose.ui.platform.ScrollObservationScope findById(List<androidx.compose.ui.platform.ScrollObservationScope> $this$findById, int id) {
        int index;
        int semanticsNodeId;
        index = 0;
        while (index < $this$findById.size()) {
            index++;
        }
        return null;
    }

    public static final IntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> getAllUncoveredSemanticsNodesToIntObjectMap(SemanticsOwner $this$getAllUncoveredSemanticsNodesToIntObjectMap) {
        boolean attached;
        final SemanticsNode unmergedRootSemanticsNode = $this$getAllUncoveredSemanticsNodesToIntObjectMap.getUnmergedRootSemanticsNode();
        final MutableIntObjectMap mutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        if (unmergedRootSemanticsNode.getLayoutNode$ui_release().isPlaced() && !unmergedRootSemanticsNode.getLayoutNode$ui_release().isAttached()) {
            if (!unmergedRootSemanticsNode.getLayoutNode$ui_release().isAttached()) {
            }
            Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
            final int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            final int i5 = 0;
            Region region2 = new Region(Math.round(boundsInRoot.getLeft()), Math.round(boundsInRoot.getTop()), Math.round(boundsInRoot.getRight()), Math.round(boundsInRoot.getBottom()));
            Region region = new Region();
            SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(region2, unmergedRootSemanticsNode, mutableIntObjectMapOf, unmergedRootSemanticsNode, region);
            return (IntObjectMap)mutableIntObjectMapOf;
        }
        return (IntObjectMap)mutableIntObjectMapOf;
    }

    private static final void getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(Region unaccountedSpace, SemanticsNode root, MutableIntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> nodes, SemanticsNode currentNode, Region region) {
        Region semanticsNodeWithAdjustedBounds2;
        int i5;
        int fake$ui_release;
        int $this$fastRoundToInt$iv;
        boolean attached;
        int importantForAccessibility;
        int i2;
        Rect defaultFakeNodeBounds;
        int semanticsNodeWithAdjustedBounds;
        int i4;
        int $this$fastRoundToInt$iv3;
        int $this$fastRoundToInt$iv4;
        int i;
        List replacedChildren$ui_release;
        int $this$fastRoundToInt$iv2;
        SemanticsNode semanticsNode;
        SemanticsNode semanticsNode3;
        float bottom;
        int i3;
        SemanticsNode semanticsNode2;
        int left;
        Rect rect;
        semanticsNodeWithAdjustedBounds2 = unaccountedSpace;
        final MutableIntObjectMap map = nodes;
        final SemanticsNode semanticsNode4 = currentNode;
        final Region region2 = region;
        semanticsNodeWithAdjustedBounds = 1;
        if (semanticsNode4.getLayoutNode$ui_release().isPlaced()) {
            if (!semanticsNode4.getLayoutNode$ui_release().isAttached()) {
                i5 = semanticsNodeWithAdjustedBounds;
            } else {
                i5 = importantForAccessibility;
            }
        } else {
        }
        if (semanticsNodeWithAdjustedBounds2.isEmpty()) {
            if (semanticsNode4.getId() == root.getId() && i5 != 0 && !semanticsNode4.isFake$ui_release()) {
                if (i5 != 0) {
                    if (!semanticsNode4.isFake$ui_release()) {
                    }
                }
            }
        } else {
        }
        final Rect touchBoundsInRoot = semanticsNode4.getTouchBoundsInRoot();
        int i6 = 0;
        $this$fastRoundToInt$iv = Math.round(touchBoundsInRoot.getLeft());
        int i7 = 0;
        $this$fastRoundToInt$iv3 = Math.round(touchBoundsInRoot.getTop());
        int i9 = 0;
        $this$fastRoundToInt$iv4 = Math.round(touchBoundsInRoot.getRight());
        int i10 = 0;
        int $this$fastRoundToInt$iv5 = Math.round(touchBoundsInRoot.getBottom());
        region2.set($this$fastRoundToInt$iv, $this$fastRoundToInt$iv3, $this$fastRoundToInt$iv4, $this$fastRoundToInt$iv5);
        $this$fastRoundToInt$iv2 = -1;
        if (semanticsNode4.getId() == root.getId()) {
            i = $this$fastRoundToInt$iv2;
        } else {
            i = semanticsNode4.getId();
        }
        if (region2.op(semanticsNodeWithAdjustedBounds2, Region.Op.INTERSECT)) {
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds3 = new SemanticsNodeWithAdjustedBounds(semanticsNode4, region2.getBounds());
            map.set(i, semanticsNodeWithAdjustedBounds3);
            replacedChildren$ui_release = semanticsNode4.getReplacedChildren$ui_release();
            size -= semanticsNodeWithAdjustedBounds;
            while ($this$fastRoundToInt$iv2 < i2) {
                SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap$findAllSemanticNodesRecursive(semanticsNodeWithAdjustedBounds2, root, map, (SemanticsNode)replacedChildren$ui_release.get(i2), region2);
                i2--;
            }
            semanticsNode = root;
            if (SemanticsUtils_androidKt.isImportantForAccessibility(semanticsNode4)) {
                semanticsNodeWithAdjustedBounds = $this$fastRoundToInt$iv4;
                importantForAccessibility = $this$fastRoundToInt$iv3;
                semanticsNodeWithAdjustedBounds2.op($this$fastRoundToInt$iv, importantForAccessibility, semanticsNodeWithAdjustedBounds, $this$fastRoundToInt$iv5, Region.Op.DIFFERENCE);
                $this$fastRoundToInt$iv4 = semanticsNodeWithAdjustedBounds;
                $this$fastRoundToInt$iv3 = importantForAccessibility;
                left = $this$fastRoundToInt$iv;
            } else {
                left = $this$fastRoundToInt$iv;
            }
        } else {
            semanticsNode = root;
            if (semanticsNode4.isFake$ui_release()) {
                SemanticsNode parent = semanticsNode4.getParent();
                replacedChildren$ui_release = parent.getLayoutInfo();
                if (parent != null && replacedChildren$ui_release != null && replacedChildren$ui_release.isPlaced() == semanticsNodeWithAdjustedBounds) {
                    replacedChildren$ui_release = parent.getLayoutInfo();
                    if (replacedChildren$ui_release != null) {
                        if (replacedChildren$ui_release.isPlaced() == semanticsNodeWithAdjustedBounds) {
                            importantForAccessibility = semanticsNodeWithAdjustedBounds;
                        }
                    }
                }
                if (importantForAccessibility != 0) {
                    defaultFakeNodeBounds = parent.getBoundsInRoot();
                } else {
                    defaultFakeNodeBounds = SemanticsUtils_androidKt.DefaultFakeNodeBounds;
                }
                int i11 = 0;
                int i12 = 0;
                semanticsNode2 = parent;
                int i13 = 0;
                left = $this$fastRoundToInt$iv;
                i3 = 0;
                rect = defaultFakeNodeBounds;
                replacedChildren$ui_release = new Rect(Math.round(defaultFakeNodeBounds.getLeft()), Math.round(defaultFakeNodeBounds.getTop()), Math.round(defaultFakeNodeBounds.getRight()), Math.round(defaultFakeNodeBounds.getBottom()));
                semanticsNodeWithAdjustedBounds = new SemanticsNodeWithAdjustedBounds(semanticsNode4, replacedChildren$ui_release);
                map.set(i, semanticsNodeWithAdjustedBounds);
            } else {
                left = $this$fastRoundToInt$iv;
                if (i == $this$fastRoundToInt$iv2) {
                    semanticsNodeWithAdjustedBounds2 = new SemanticsNodeWithAdjustedBounds(semanticsNode4, region2.getBounds());
                    map.set(i, semanticsNodeWithAdjustedBounds2);
                }
            }
        }
    }

    public static final Rect getDefaultFakeNodeBounds() {
        return SemanticsUtils_androidKt.DefaultFakeNodeBounds;
    }

    public static final Float getScrollViewportLength(SemanticsConfiguration configuration) {
        Object orNull;
        Object i;
        ArrayList arrayList = new ArrayList();
        orNull = SemanticsConfigurationKt.getOrNull(configuration, SemanticsActions.INSTANCE.getGetScrollViewportLength());
        orNull = (AccessibilityAction)orNull.getAction();
        if (orNull != null && (Function1)orNull != null) {
            orNull = orNull.getAction();
            if ((Function1)(Function1)orNull != null) {
                if ((Boolean)(Function1)(Function1)orNull.invoke((List)arrayList).booleanValue()) {
                    i = arrayList.get(0);
                } else {
                }
                return i;
            }
        }
        return null;
    }

    public static final TextLayoutResult getTextLayoutResult(SemanticsConfiguration configuration) {
        Object orNull;
        Object i;
        ArrayList arrayList = new ArrayList();
        orNull = SemanticsConfigurationKt.getOrNull(configuration, SemanticsActions.INSTANCE.getGetTextLayoutResult());
        orNull = (AccessibilityAction)orNull.getAction();
        if (orNull != null && (Function1)orNull != null) {
            orNull = orNull.getAction();
            if ((Function1)(Function1)orNull != null) {
                if ((Boolean)(Function1)(Function1)orNull.invoke((List)arrayList).booleanValue()) {
                    i = arrayList.get(0);
                } else {
                }
                return i;
            }
        }
        return null;
    }

    public static final boolean isAncestorOf(LayoutNode $this$isAncestorOf, LayoutNode node) {
        int i;
        boolean ancestorOf;
        final LayoutNode parent$ui_release = node.getParent$ui_release();
        if (parent$ui_release == null) {
            return 0;
        }
        if (!Intrinsics.areEqual(parent$ui_release, $this$isAncestorOf)) {
            if (SemanticsUtils_androidKt.isAncestorOf($this$isAncestorOf, parent$ui_release)) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    public static final boolean isImportantForAccessibility(SemanticsNode $this$isImportantForAccessibility) {
        int i;
        boolean mergingSemanticsOfDescendants;
        if (!$this$isImportantForAccessibility.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
            if ($this$isImportantForAccessibility.getUnmergedConfig$ui_release().containsImportantForAccessibility$ui_release()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final View semanticsIdToView(androidx.compose.ui.platform.AndroidViewsHandler $this$semanticsIdToView, int id) {
        Object entrySet;
        Object element$iv;
        int i2;
        Object obj;
        int i3;
        int i;
        final int i4 = 0;
        final Iterator iterator = (Iterable)$this$semanticsIdToView.getLayoutNodeToHolder().entrySet().iterator();
        while (iterator.hasNext()) {
            i3 = 0;
            if ((LayoutNode)(Map.Entry)iterator.next().getKey().getSemanticsId() == id) {
            } else {
            }
            i = 0;
            i = 1;
        }
        element$iv = i2;
        if ((Map.Entry)element$iv != 0) {
            i2 = entrySet;
        }
        return (View)i2;
    }

    public static final String toLegacyClassName-V4PA4sw(int $this$toLegacyClassName_u2dV4PA4sw) {
        String str;
        str = Role.equals-impl0($this$toLegacyClassName_u2dV4PA4sw, Role.Companion.getButton-o7Vup1c()) ? "android.widget.Button" : equals-impl02 ? "android.widget.CheckBox" : equals-impl03 ? "android.widget.RadioButton" : equals-impl04 ? "android.widget.ImageView" : equals-impl05 ? "android.widget.Spinner" : 0;
        return str;
    }
}
