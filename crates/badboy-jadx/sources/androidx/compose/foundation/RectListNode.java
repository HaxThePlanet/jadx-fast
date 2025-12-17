package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008 \u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u000e\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0014H&J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\u0008\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002J\u0016\u0010\u001b\u001a\u00020\u00162\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0014H&R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\u0007R\u0014\u0010\r\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Landroidx/compose/foundation/RectListNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "rect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function1;)V", "androidRect", "Landroid/graphics/Rect;", "getRect", "()Lkotlin/jvm/functions/Function1;", "setRect", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "calcBounds", "layoutCoordinates", "currentRects", "Landroidx/compose/runtime/collection/MutableVector;", "onDetach", "", "onGloballyPositioned", "coordinates", "replaceRect", "newRect", "updateRects", "rects", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RectListNode extends Modifier.Node implements GlobalPositionAwareModifierNode {

    public static final int $stable = 8;
    private Rect androidRect;
    private Function1<? super LayoutCoordinates, Rect> rect;
    static {
        final int i = 8;
    }

    public RectListNode(Function1<? super LayoutCoordinates, Rect> rect) {
        super();
        this.rect = rect;
    }

    private final Rect calcBounds(LayoutCoordinates layoutCoordinates, Rect rect) {
        LayoutCoordinates layoutCoordinates2 = layoutCoordinates;
        LayoutCoordinates rootCoordinates = LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates2);
        long localPositionOf-R5De75A = rootCoordinates.localPositionOf-R5De75A(layoutCoordinates2, rect.getTopLeft-F1C5BW0());
        long localPositionOf-R5De75A2 = rootCoordinates.localPositionOf-R5De75A(layoutCoordinates2, rect.getTopRight-F1C5BW0());
        long localPositionOf-R5De75A3 = rootCoordinates.localPositionOf-R5De75A(layoutCoordinates2, rect.getBottomLeft-F1C5BW0());
        long localPositionOf-R5De75A4 = rootCoordinates.localPositionOf-R5De75A(layoutCoordinates2, rect.getBottomRight-F1C5BW0());
        int i3 = 3;
        float[] fArr4 = new float[i3];
        int i4 = 0;
        fArr4[i4] = Offset.getX-impl(localPositionOf-R5De75A2);
        int i = 1;
        fArr4[i] = Offset.getX-impl(localPositionOf-R5De75A3);
        int i2 = 2;
        fArr4[i2] = Offset.getX-impl(localPositionOf-R5De75A4);
        final int i5 = i;
        float[] fArr = new float[i3];
        fArr[i4] = Offset.getY-impl(localPositionOf-R5De75A2);
        fArr[i5] = Offset.getY-impl(localPositionOf-R5De75A3);
        fArr[i2] = Offset.getY-impl(localPositionOf-R5De75A4);
        final int i6 = i2;
        float[] fArr2 = new float[i3];
        fArr2[i4] = Offset.getX-impl(localPositionOf-R5De75A2);
        fArr2[i5] = Offset.getX-impl(localPositionOf-R5De75A3);
        fArr2[i6] = Offset.getX-impl(localPositionOf-R5De75A4);
        float[] fArr3 = new float[i3];
        fArr3[i4] = Offset.getY-impl(localPositionOf-R5De75A2);
        fArr3[i5] = Offset.getY-impl(localPositionOf-R5De75A3);
        fArr3[i6] = Offset.getY-impl(localPositionOf-R5De75A4);
        LayoutCoordinates layoutCoordinates3 = rootCoordinates;
        long l = localPositionOf-R5De75A;
        Rect rect2 = new Rect(MathKt.roundToInt(ComparisonsKt.minOf(Offset.getX-impl(localPositionOf-R5De75A), fArr4)), MathKt.roundToInt(ComparisonsKt.minOf(Offset.getY-impl(localPositionOf-R5De75A), fArr)), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.getX-impl(localPositionOf-R5De75A), fArr2)), MathKt.roundToInt(ComparisonsKt.maxOf(Offset.getY-impl(localPositionOf-R5De75A), fArr3)));
        return rect2;
    }

    private final void replaceRect(Rect newRect) {
        int it;
        int empty;
        final MutableVector currentRects = currentRects();
        Rect androidRect = this.androidRect;
        if (androidRect != null) {
            empty = 0;
            currentRects.remove(androidRect);
        }
        it = 0;
        if (newRect != null && !newRect.isEmpty()) {
            if (!newRect.isEmpty()) {
                it = 1;
            }
        }
        if (it != 0) {
            empty = 0;
            currentRects.add(newRect);
        }
        updateRects(currentRects);
        this.androidRect = newRect;
    }

    public abstract MutableVector<Rect> currentRects();

    public Function1<LayoutCoordinates, Rect> getRect() {
        return this.rect;
    }

    @Override // androidx.compose.ui.Modifier$Node
    protected final View getView() {
        return DelegatableNode_androidKt.requireView((DelegatableNode)this);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        super.onDetach();
        replaceRect(0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Object boundsInRoot;
        Rect calcBounds;
        int roundToInt3;
        int roundToInt4;
        int roundToInt2;
        int roundToInt;
        if (getRect() == null) {
            boundsInRoot = LayoutCoordinatesKt.boundsInRoot(coordinates);
            calcBounds = new Rect(MathKt.roundToInt(boundsInRoot.getLeft()), MathKt.roundToInt(boundsInRoot.getTop()), MathKt.roundToInt(boundsInRoot.getRight()), MathKt.roundToInt(boundsInRoot.getBottom()));
        } else {
            Function1 rect2 = getRect();
            Intrinsics.checkNotNull(rect2);
            calcBounds = calcBounds(coordinates, (Rect)rect2.invoke(coordinates));
        }
        replaceRect(calcBounds);
    }

    public void setRect(Function1<? super LayoutCoordinates, Rect> <set-?>) {
        this.rect = <set-?>;
    }

    public abstract void updateRects(MutableVector<Rect> mutableVector);
}
