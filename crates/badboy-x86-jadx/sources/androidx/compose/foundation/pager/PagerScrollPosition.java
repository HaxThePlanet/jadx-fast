package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B!\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003J\u0016\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003J\u0016\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0005H\u0002J\u000e\u0010*\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006.", d2 = {"Landroidx/compose/foundation/pager/PagerScrollPosition;", "", "currentPage", "", "currentPageOffsetFraction", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "(IFLandroidx/compose/foundation/pager/PagerState;)V", "<set-?>", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "currentPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "currentPageOffsetFraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "hadFirstNotEmptyLayout", "", "lastKnownCurrentPageKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "applyScrollDelta", "", "delta", "matchPageWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "index", "requestPositionAndForgetLastKnownKey", "offsetFraction", "update", "page", "updateCurrentPageOffsetFraction", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagerScrollPosition {

    public static final int $stable = 8;
    private final MutableIntState currentPage$delegate;
    private final MutableFloatState currentPageOffsetFraction$delegate;
    private boolean hadFirstNotEmptyLayout;
    private Object lastKnownCurrentPageKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final androidx.compose.foundation.pager.PagerState state;
    static {
        final int i = 8;
    }

    public PagerScrollPosition(int currentPage, float currentPageOffsetFraction, androidx.compose.foundation.pager.PagerState state) {
        super();
        this.state = state;
        this.currentPage$delegate = SnapshotIntStateKt.mutableIntStateOf(currentPage);
        this.currentPageOffsetFraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(currentPageOffsetFraction);
        LazyLayoutNearestRangeState lazyLayoutNearestRangeState = new LazyLayoutNearestRangeState(currentPage, 30, 100);
        this.nearestRangeState = lazyLayoutNearestRangeState;
    }

    public PagerScrollPosition(int i, float f2, androidx.compose.foundation.pager.PagerState pagerState3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj1;
        int obj2;
        obj1 = i4 & 1 != 0 ? 0 : obj1;
        obj2 = i4 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2, pagerState3);
    }

    private final void setCurrentPage(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentPage$delegate.setIntValue(<set-?>);
    }

    private final void setCurrentPageOffsetFraction(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentPageOffsetFraction$delegate.setFloatValue(<set-?>);
    }

    private final void update(int page, float offsetFraction) {
        setCurrentPage(page);
        this.nearestRangeState.update(page);
        setCurrentPageOffsetFraction(offsetFraction);
    }

    public final void applyScrollDelta(int delta) {
        int i;
        float f;
        int i2 = 0;
        if (this.state.getPageSizeWithSpacing$foundation_release() == 0) {
            i = 0;
        } else {
            f2 /= f;
        }
        setCurrentPageOffsetFraction(currentPageOffsetFraction += i);
    }

    public final int getCurrentPage() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.currentPage$delegate.getIntValue();
    }

    public final float getCurrentPageOffsetFraction() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.currentPageOffsetFraction$delegate.getFloatValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final androidx.compose.foundation.pager.PagerState getState() {
        return this.state;
    }

    public final int matchPageWithKey(androidx.compose.foundation.pager.PagerLazyLayoutItemProvider itemProvider, int index) {
        Object lastKnownCurrentPageKey;
        int indexByKey = LazyLayoutItemProviderKt.findIndexByKey((LazyLayoutItemProvider)itemProvider, this.lastKnownCurrentPageKey, index);
        if (index != indexByKey) {
            setCurrentPage(indexByKey);
            this.nearestRangeState.update(index);
        }
        return indexByKey;
    }

    public final void requestPositionAndForgetLastKnownKey(int index, float offsetFraction) {
        update(index, offsetFraction);
        this.lastKnownCurrentPageKey = 0;
    }

    public final void updateCurrentPageOffsetFraction(float offsetFraction) {
        setCurrentPageOffsetFraction(offsetFraction);
    }

    public final void updateFromMeasureResult(androidx.compose.foundation.pager.PagerMeasureResult measureResult) {
        int key;
        int hadFirstNotEmptyLayout;
        float currentPageOffsetFraction;
        androidx.compose.foundation.pager.MeasuredPage currentPage = measureResult.getCurrentPage();
        if (currentPage != null) {
            key = currentPage.getKey();
        } else {
            key = 0;
        }
        this.lastKnownCurrentPageKey = key;
        if (!this.hadFirstNotEmptyLayout) {
            if (!(Collection)measureResult.getVisiblePagesInfo().isEmpty()) {
                this.hadFirstNotEmptyLayout = true;
                androidx.compose.foundation.pager.MeasuredPage currentPage2 = measureResult.getCurrentPage();
                if (currentPage2 != null) {
                    hadFirstNotEmptyLayout = currentPage2.getIndex();
                } else {
                    hadFirstNotEmptyLayout = 0;
                }
                update(hadFirstNotEmptyLayout, measureResult.getCurrentPageOffsetFraction());
            }
        } else {
        }
    }
}
