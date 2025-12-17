package androidx.compose.material3;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0016\u0008\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR+\u0010\r\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000e\u0010\u000b\"\u0004\u0008\u000f\u0010\u0010R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0015\u0010\u000b\"\u0004\u0008\u0016\u0010\u0010R+\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001a\u0010\u0012\u001a\u0004\u0008\u0018\u0010\u000b\"\u0004\u0008\u0019\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u000b¨\u0006\u001e", d2 = {"Landroidx/compose/material3/TopAppBarState;", "", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "(FFF)V", "_heightOffset", "Landroidx/compose/runtime/MutableFloatState;", "collapsedFraction", "getCollapsedFraction", "()F", "<set-?>", "contentOffset", "getContentOffset", "setContentOffset", "(F)V", "contentOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "heightOffset", "getHeightOffset", "setHeightOffset", "heightOffsetLimit", "getHeightOffsetLimit", "setHeightOffsetLimit", "heightOffsetLimit$delegate", "overlappedFraction", "getOverlappedFraction", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopAppBarState {

    public static final int $stable;
    public static final androidx.compose.material3.TopAppBarState.Companion Companion;
    private static final Saver<androidx.compose.material3.TopAppBarState, ?> Saver;
    private MutableFloatState _heightOffset;
    private final MutableFloatState contentOffset$delegate;
    private final MutableFloatState heightOffsetLimit$delegate;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/material3/TopAppBarState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TopAppBarState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material3.TopAppBarState, ?> getSaver() {
            return TopAppBarState.access$getSaver$cp();
        }
    }
    static {
        TopAppBarState.Companion companion = new TopAppBarState.Companion(0);
        TopAppBarState.Companion = companion;
        TopAppBarState.Saver = ListSaverKt.listSaver((Function2)TopAppBarState.Companion.Saver.1.INSTANCE, (Function1)TopAppBarState.Companion.Saver.2.INSTANCE);
    }

    public TopAppBarState(float initialHeightOffsetLimit, float initialHeightOffset, float initialContentOffset) {
        super();
        this.heightOffsetLimit$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(initialHeightOffsetLimit);
        this.contentOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(initialContentOffset);
        this._heightOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(initialHeightOffset);
    }

    public static final Saver access$getSaver$cp() {
        return TopAppBarState.Saver;
    }

    public final float getCollapsedFraction() {
        int heightOffset;
        int i;
        heightOffset = Float.compare(heightOffsetLimit, i) == 0 ? 1 : 0;
        if (heightOffset == null) {
            i = heightOffset / heightOffsetLimit2;
        } else {
        }
        return i;
    }

    public final float getContentOffset() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.contentOffset$delegate.getFloatValue();
    }

    public final float getHeightOffset() {
        return this._heightOffset.getFloatValue();
    }

    public final float getHeightOffsetLimit() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.heightOffsetLimit$delegate.getFloatValue();
    }

    public final float getOverlappedFraction() {
        int i;
        int i2;
        int heightOffsetLimit;
        float heightOffsetLimit2;
        i2 = 0;
        heightOffsetLimit = 1;
        i = Float.compare(heightOffsetLimit3, i2) == 0 ? heightOffsetLimit : 0;
        if (i == 0) {
            i2 = i - i3;
        } else {
        }
        return i2;
    }

    public final void setContentOffset(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.contentOffset$delegate.setFloatValue(<set-?>);
    }

    public final void setHeightOffset(float newOffset) {
        this._heightOffset.setFloatValue(RangesKt.coerceIn(newOffset, getHeightOffsetLimit(), 0));
    }

    public final void setHeightOffsetLimit(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.heightOffsetLimit$delegate.setFloatValue(<set-?>);
    }
}
