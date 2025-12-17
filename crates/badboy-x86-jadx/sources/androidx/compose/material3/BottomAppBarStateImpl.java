package androidx.compose.material3;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR+\u0010\r\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000e\u0010\u000b\"\u0004\u0008\u000f\u0010\u0010R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0015\u0010\u000b\"\u0004\u0008\u0016\u0010\u0010R+\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001a\u0010\u0012\u001a\u0004\u0008\u0018\u0010\u000b\"\u0004\u0008\u0019\u0010\u0010¨\u0006\u001b", d2 = {"Landroidx/compose/material3/BottomAppBarStateImpl;", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "(FFF)V", "_heightOffset", "Landroidx/compose/runtime/MutableFloatState;", "collapsedFraction", "getCollapsedFraction", "()F", "<set-?>", "contentOffset", "getContentOffset", "setContentOffset", "(F)V", "contentOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "heightOffset", "getHeightOffset", "setHeightOffset", "heightOffsetLimit", "getHeightOffsetLimit", "setHeightOffsetLimit", "heightOffsetLimit$delegate", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BottomAppBarStateImpl implements androidx.compose.material3.BottomAppBarState {

    private MutableFloatState _heightOffset;
    private final MutableFloatState contentOffset$delegate;
    private final MutableFloatState heightOffsetLimit$delegate;
    public BottomAppBarStateImpl(float initialHeightOffsetLimit, float initialHeightOffset, float initialContentOffset) {
        super();
        this.heightOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(initialHeightOffsetLimit);
        this.contentOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(initialContentOffset);
        this._heightOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(initialHeightOffset);
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public float getCollapsedFraction() {
        int heightOffset;
        int i;
        heightOffset = Float.compare(heightOffsetLimit, i) == 0 ? 1 : 0;
        if (heightOffset == null) {
            i = heightOffset / heightOffsetLimit2;
        } else {
        }
        return i;
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public float getContentOffset() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.contentOffset$delegate.getFloatValue();
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public float getHeightOffset() {
        return this._heightOffset.getFloatValue();
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public float getHeightOffsetLimit() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.heightOffsetLimit$delegate.getFloatValue();
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public void setContentOffset(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.contentOffset$delegate.setFloatValue(<set-?>);
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public void setHeightOffset(float newOffset) {
        this._heightOffset.setFloatValue(RangesKt.coerceIn(newOffset, getHeightOffsetLimit(), 0));
    }

    @Override // androidx.compose.material3.BottomAppBarState
    public void setHeightOffsetLimit(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.heightOffsetLimit$delegate.setFloatValue(<set-?>);
    }
}
