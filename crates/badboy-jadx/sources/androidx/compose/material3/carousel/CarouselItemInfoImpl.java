package androidx.compose.material3.carousel;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0007\n\u0002\u0008\u0015\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R+\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\t\u0010\u0006\"\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R+\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0013\u0010\u0011\"\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0011R+\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001d\u0010\u0017\u001a\u0004\u0008\u001b\u0010\u0011\"\u0004\u0008\u001c\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0011R+\u0010 \u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008#\u0010\u0017\u001a\u0004\u0008!\u0010\u0011\"\u0004\u0008\"\u0010\u0015¨\u0006$", d2 = {"Landroidx/compose/material3/carousel/CarouselItemInfoImpl;", "Landroidx/compose/material3/carousel/CarouselItemInfo;", "()V", "maskRect", "Landroidx/compose/ui/geometry/Rect;", "getMaskRect", "()Landroidx/compose/ui/geometry/Rect;", "<set-?>", "maskRectState", "getMaskRectState", "setMaskRectState", "(Landroidx/compose/ui/geometry/Rect;)V", "maskRectState$delegate", "Landroidx/compose/runtime/MutableState;", "maxSize", "", "getMaxSize", "()F", "maxSizeState", "getMaxSizeState", "setMaxSizeState", "(F)V", "maxSizeState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "minSize", "getMinSize", "minSizeState", "getMinSizeState", "setMinSizeState", "minSizeState$delegate", "size", "getSize", "sizeState", "getSizeState", "setSizeState", "sizeState$delegate", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselItemInfoImpl implements androidx.compose.material3.carousel.CarouselItemInfo {

    public static final int $stable;
    private final MutableState maskRectState$delegate;
    private final MutableFloatState maxSizeState$delegate;
    private final MutableFloatState minSizeState$delegate;
    private final MutableFloatState sizeState$delegate;
    static {
    }

    public CarouselItemInfoImpl() {
        super();
        int i = 0;
        this.sizeState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        this.minSizeState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        this.maxSizeState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i);
        int i2 = 0;
        this.maskRectState$delegate = SnapshotStateKt.mutableStateOf$default(Rect.Companion.getZero(), i2, 2, i2);
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public Rect getMaskRect() {
        return getMaskRectState();
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public final Rect getMaskRectState() {
        final int i = 0;
        final int i2 = 0;
        return (Rect)(State)this.maskRectState$delegate.getValue();
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public float getMaxSize() {
        return getMaxSizeState();
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public final float getMaxSizeState() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.maxSizeState$delegate.getFloatValue();
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public float getMinSize() {
        return getMinSizeState();
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public final float getMinSizeState() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.minSizeState$delegate.getFloatValue();
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public float getSize() {
        return getSizeState();
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public final float getSizeState() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.sizeState$delegate.getFloatValue();
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public final void setMaskRectState(Rect <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.maskRectState$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public final void setMaxSizeState(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.maxSizeState$delegate.setFloatValue(<set-?>);
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public final void setMinSizeState(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.minSizeState$delegate.setFloatValue(<set-?>);
    }

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public final void setSizeState(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.sizeState$delegate.setFloatValue(<set-?>);
    }
}
