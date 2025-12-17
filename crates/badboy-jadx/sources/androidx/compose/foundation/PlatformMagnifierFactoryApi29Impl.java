package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import android.widget.Magnifier.Builder;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008Á\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl;", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "()V", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "view", "Landroid/view/View;", "useTextDefault", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "create-nHHXs2Y", "(Landroid/view/View;ZJFFZLandroidx/compose/ui/unit/Density;F)Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "PlatformMagnifierImpl", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformMagnifierFactoryApi29Impl implements androidx.compose.foundation.PlatformMagnifierFactory {

    public static final int $stable;
    public static final androidx.compose.foundation.PlatformMagnifierFactoryApi29Impl INSTANCE;
    private static final boolean canUpdateZoom = true;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl;", "Landroidx/compose/foundation/PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl;", "magnifier", "Landroid/widget/Magnifier;", "(Landroid/widget/Magnifier;)V", "update", "", "sourceCenter", "Landroidx/compose/ui/geometry/Offset;", "magnifierCenter", "zoom", "", "update-Wko1d7g", "(JJF)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PlatformMagnifierImpl extends androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {

        public static final int $stable;
        static {
        }

        public PlatformMagnifierImpl(Magnifier magnifier) {
            super(magnifier);
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl$PlatformMagnifierImpl
        public void update-Wko1d7g(long sourceCenter, long magnifierCenter, float zoom) {
            boolean magnifier;
            Magnifier magnifier2;
            float x-impl;
            float y-impl2;
            float x-impl2;
            float y-impl;
            if (!Float.isNaN(obj10)) {
                getMagnifier().setZoom(obj10);
            }
            if (OffsetKt.isSpecified-k-4lQ0M(zoom)) {
                getMagnifier().show(Offset.getX-impl(sourceCenter), Offset.getY-impl(sourceCenter), Offset.getX-impl(zoom), Offset.getY-impl(zoom));
            } else {
                getMagnifier().show(Offset.getX-impl(sourceCenter), Offset.getY-impl(sourceCenter));
            }
        }
    }
    static {
        PlatformMagnifierFactoryApi29Impl platformMagnifierFactoryApi29Impl = new PlatformMagnifierFactoryApi29Impl();
        PlatformMagnifierFactoryApi29Impl.INSTANCE = platformMagnifierFactoryApi29Impl;
        int i = 1;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public androidx.compose.foundation.PlatformMagnifier create-nHHXs2Y(View view, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, Density density, float initialZoom) {
        return (PlatformMagnifier)create-nHHXs2Y(view, useTextDefault, size, cornerRadius, elevation, clippingEnabled, density, initialZoom);
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public androidx.compose.foundation.PlatformMagnifierFactoryApi29Impl.PlatformMagnifierImpl create-nHHXs2Y(View view, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, Density density, float initialZoom) {
        long roundToInt2;
        float f;
        int roundToInt;
        int i;
        final View view2 = view;
        final Object obj = initialZoom;
        final int i2 = 0;
        if (useTextDefault) {
            Magnifier magnifier = new Magnifier(view2);
            PlatformMagnifierFactoryApi29Impl.PlatformMagnifierImpl platformMagnifierImpl = new PlatformMagnifierFactoryApi29Impl.PlatformMagnifierImpl(magnifier);
            return platformMagnifierImpl;
        }
        final long size-XkaWNTQ = obj.toSize-XkaWNTQ(size);
        final float px-0680j_4 = obj.toPx-0680j_4(elevation);
        final float px-0680j_42 = obj.toPx-0680j_4(clippingEnabled);
        Magnifier.Builder builder = new Magnifier.Builder(view2);
        int i3 = 0;
        final int i4 = 0;
        i = Long.compare(roundToInt2, l2) != 0 ? 1 : 0;
        if (i != 0) {
            builder.setSize(MathKt.roundToInt(Size.getWidth-impl(size-XkaWNTQ)), MathKt.roundToInt(Size.getHeight-impl(size-XkaWNTQ)));
        }
        if (!Float.isNaN(px-0680j_4)) {
            builder.setCornerRadius(px-0680j_4);
        }
        if (!Float.isNaN(px-0680j_42)) {
            builder.setElevation(px-0680j_42);
        }
        if (!Float.isNaN(obj27)) {
            builder.setInitialZoom(obj27);
        } else {
            f = obj27;
        }
        builder.setClippingEnabled(density);
        PlatformMagnifierFactoryApi29Impl.PlatformMagnifierImpl platformMagnifierImpl2 = new PlatformMagnifierFactoryApi29Impl.PlatformMagnifierImpl(builder.build());
        return platformMagnifierImpl2;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return PlatformMagnifierFactoryApi29Impl.canUpdateZoom;
    }
}
