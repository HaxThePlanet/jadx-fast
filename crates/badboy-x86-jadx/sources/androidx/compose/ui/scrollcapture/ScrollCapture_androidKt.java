package androidx.compose.ui.scrollcapture;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\u001a.\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u0018H\u0002\u001a\u0012\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001b*\u00020\u0002H\u0002\u001a!\u0010\u001c\u001a\u00020\u0013*\u00020\u00022\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0018H\u0082\u0008\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u000c\u0012\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0004\"E\u0010\u0008\u001a/\u0008\u0001\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001e", d2 = {"canScrollVertically", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "getCanScrollVertically", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "isVisible", "isVisible$annotations", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "scrollCaptureScrollByAction", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "offset", "Lkotlin/coroutines/Continuation;", "", "getScrollCaptureScrollByAction", "(Landroidx/compose/ui/semantics/SemanticsNode;)Lkotlin/jvm/functions/Function2;", "visitScrollCaptureCandidates", "", "fromNode", "depth", "", "onCandidate", "Lkotlin/Function1;", "Landroidx/compose/ui/scrollcapture/ScrollCaptureCandidate;", "getChildrenForSearch", "", "visitDescendants", "onNode", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScrollCapture_androidKt {
    private static final boolean getCanScrollVertically(SemanticsNode $this$canScrollVertically) {
        int i2;
        androidx.compose.ui.semantics.SemanticsPropertyKey verticalScrollAxisRange;
        int i;
        Object orNull = SemanticsConfigurationKt.getOrNull($this$canScrollVertically.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (ScrollCapture_androidKt.getScrollCaptureScrollByAction($this$canScrollVertically) != null && orNull != null && Float.compare(floatValue, i) > 0) {
            if (orNull != null) {
                i2 = Float.compare(floatValue, i) > 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i2;
    }

    private static final List<SemanticsNode> getChildrenForSearch(SemanticsNode $this$getChildrenForSearch) {
        int i = 0;
        return $this$getChildrenForSearch.getChildren$ui_release(i, i, i);
    }

    public static final Function2<Offset, Continuation<? super Offset>, Object> getScrollCaptureScrollByAction(SemanticsNode $this$scrollCaptureScrollByAction) {
        return (Function2)SemanticsConfigurationKt.getOrNull($this$scrollCaptureScrollByAction.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getScrollByOffset());
    }

    private static final boolean isVisible(SemanticsNode $this$isVisible) {
        boolean transparent$ui_release;
        int i;
        androidx.compose.ui.semantics.SemanticsPropertyKey invisibleToUser;
        if (!$this$isVisible.isTransparent$ui_release() && !$this$isVisible.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) {
            i = !$this$isVisible.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser()) ? 1 : 0;
        } else {
        }
        return i;
    }

    private static void isVisible$annotations(SemanticsNode semanticsNode) {
    }

    private static final void visitDescendants(SemanticsNode $this$visitDescendants, Function1<? super SemanticsNode, Boolean> onNode) {
        List childrenForSearch;
        MutableVector booleanValue;
        int childrenForSearch2;
        int size2;
        int i;
        int size;
        final int i2 = 0;
        int i3 = 0;
        int i6 = 0;
        MutableVector mutableVector2 = new MutableVector(new SemanticsNode[16], 0);
        booleanValue = mutableVector2;
        childrenForSearch2 = 0;
        booleanValue.addAll(booleanValue.getSize(), ScrollCapture_androidKt.getChildrenForSearch($this$visitDescendants));
        while (mutableVector2.isNotEmpty()) {
            int i5 = 0;
            childrenForSearch = mutableVector2.removeAt(size3--);
            if ((Boolean)onNode.invoke((SemanticsNode)childrenForSearch).booleanValue() != null) {
            }
            size2 = mutableVector2;
            i = 0;
            size2.addAll(size2.getSize(), ScrollCapture_androidKt.getChildrenForSearch(childrenForSearch));
        }
    }

    private static final void visitScrollCaptureCandidates(SemanticsNode fromNode, int depth, Function1<? super androidx.compose.ui.scrollcapture.ScrollCaptureCandidate, Unit> onCandidate) {
        List childrenForSearch2;
        MutableVector childrenForSearch;
        int i;
        int candidateDepth;
        androidx.compose.ui.layout.LayoutCoordinates coordinates;
        IntRect roundToIntRect;
        boolean scrollCaptureCandidate;
        final int i2 = 0;
        int i3 = 0;
        int i6 = 0;
        final int i9 = 0;
        MutableVector mutableVector2 = new MutableVector(new SemanticsNode[16], i9);
        childrenForSearch = mutableVector2;
        i = 0;
        childrenForSearch.addAll(childrenForSearch.getSize(), ScrollCapture_androidKt.getChildrenForSearch(fromNode));
        while (mutableVector2.isNotEmpty()) {
            int i5 = 0;
            childrenForSearch2 = mutableVector2.removeAt(size -= candidateDepth);
            childrenForSearch = childrenForSearch2;
            i = 0;
            candidateDepth = i9;
            if (candidateDepth != 0) {
            }
            i = mutableVector2;
            coordinates = 0;
            i.addAll(i.getSize(), ScrollCapture_androidKt.getChildrenForSearch((SemanticsNode)childrenForSearch2));
            NodeCoordinator coordinatorToGetBounds$ui_release = childrenForSearch.findCoordinatorToGetBounds$ui_release();
            int i10 = 0;
            coordinates = coordinatorToGetBounds$ui_release.getCoordinates();
            roundToIntRect = IntRectKt.roundToIntRect(LayoutCoordinatesKt.boundsInWindow(coordinates));
            if (roundToIntRect.isEmpty()) {
            } else {
            }
            if (!ScrollCapture_androidKt.getCanScrollVertically(childrenForSearch)) {
            } else {
            }
            int i8 = depth + 1;
            scrollCaptureCandidate = new ScrollCaptureCandidate(childrenForSearch, i8, roundToIntRect, coordinates);
            onCandidate.invoke(scrollCaptureCandidate);
            ScrollCapture_androidKt.visitScrollCaptureCandidates(childrenForSearch, i8, onCandidate);
            candidateDepth = i9;
            candidateDepth = i9;
        }
    }

    static void visitScrollCaptureCandidates$default(SemanticsNode semanticsNode, int i2, Function1 function13, int i4, Object object5) {
        int obj1;
        if (i4 &= 2 != 0) {
            obj1 = 0;
        }
        ScrollCapture_androidKt.visitScrollCaptureCandidates(semanticsNode, obj1, function13);
    }
}
