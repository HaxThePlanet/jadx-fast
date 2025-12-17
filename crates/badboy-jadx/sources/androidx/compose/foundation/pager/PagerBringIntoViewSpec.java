package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\t\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J \u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u000c2\u0006\u0010\u0012\u001a\u00020\u000cH\u0016J\u0010\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u000cH\u0002R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/pager/PagerBringIntoViewSpec;", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "defaultBringIntoViewSpec", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "getDefaultBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "scrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getScrollAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "calculateScrollDistance", "offset", "size", "containerSize", "overrideProposedOffsetMove", "proposedOffsetMove", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PagerBringIntoViewSpec implements BringIntoViewSpec {

    private final BringIntoViewSpec defaultBringIntoViewSpec;
    private final androidx.compose.foundation.pager.PagerState pagerState;
    private final AnimationSpec<Float> scrollAnimationSpec;
    public PagerBringIntoViewSpec(androidx.compose.foundation.pager.PagerState pagerState, BringIntoViewSpec defaultBringIntoViewSpec) {
        super();
        this.pagerState = pagerState;
        this.defaultBringIntoViewSpec = defaultBringIntoViewSpec;
        this.scrollAnimationSpec = this.defaultBringIntoViewSpec.getScrollAnimationSpec();
    }

    private final float overrideProposedOffsetMove(float proposedOffsetMove) {
        int correctedOffset;
        float f;
        int cmp;
        int cmp2;
        f2 *= f;
        int i2 = 0;
        while (Float.compare(proposedOffsetMove, i2) > 0) {
            if (Float.compare(correctedOffset, proposedOffsetMove) < 0) {
            }
            correctedOffset += f;
            i2 = 0;
        }
        while (Float.compare(proposedOffsetMove, i2) < 0) {
            if (Float.compare(correctedOffset, proposedOffsetMove) > 0) {
            }
            correctedOffset -= cmp;
        }
        return correctedOffset;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public float calculateScrollDistance(float offset, float size, float containerSize) {
        float reversedFirstPageScroll;
        int firstVisiblePageOffset$foundation_release;
        int i;
        int i2;
        float scrollDistance = this.defaultBringIntoViewSpec.calculateScrollDistance(offset, size, containerSize);
        firstVisiblePageOffset$foundation_release = Float.compare(scrollDistance, reversedFirstPageScroll) == 0 ? 1 : 0;
        if (firstVisiblePageOffset$foundation_release == 0) {
            reversedFirstPageScroll = overrideProposedOffsetMove(scrollDistance);
        } else {
            if (this.pagerState.getFirstVisiblePageOffset$foundation_release() == 0) {
            } else {
                f *= i4;
                if (this.pagerState.getLastScrolledForward()) {
                    f2 += i3;
                } else {
                    i = i3;
                }
                reversedFirstPageScroll = firstVisiblePageOffset$foundation_release;
            }
        }
        return reversedFirstPageScroll;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public final BringIntoViewSpec getDefaultBringIntoViewSpec() {
        return this.defaultBringIntoViewSpec;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public final androidx.compose.foundation.pager.PagerState getPagerState() {
        return this.pagerState;
    }

    public AnimationSpec<Float> getScrollAnimationSpec() {
        return this.scrollAnimationSpec;
    }
}
