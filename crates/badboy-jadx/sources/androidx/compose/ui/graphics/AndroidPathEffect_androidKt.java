package androidx.compose.ui.graphics;

import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.PathDashPathEffect;
import android.graphics.PathDashPathEffect.Style;
import android.graphics.PathEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0001\u001a\u0016\u0010\u0015\u001a\u00020\u0016*\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u0014\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a", d2 = {"actualChainPathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "outer", "inner", "actualCornerPathEffect", "radius", "", "actualDashPathEffect", "intervals", "", "phase", "actualStampedPathEffect", "shape", "Landroidx/compose/ui/graphics/Path;", "advance", "style", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "actualStampedPathEffect-7aD1DOk", "(Landroidx/compose/ui/graphics/Path;FFI)Landroidx/compose/ui/graphics/PathEffect;", "asAndroidPathEffect", "Landroid/graphics/PathEffect;", "toAndroidPathDashPathEffectStyle", "Landroid/graphics/PathDashPathEffect$Style;", "toAndroidPathDashPathEffectStyle-oQv6xUo", "(I)Landroid/graphics/PathDashPathEffect$Style;", "toComposePathEffect", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidPathEffect_androidKt {
    public static final androidx.compose.ui.graphics.PathEffect actualChainPathEffect(androidx.compose.ui.graphics.PathEffect outer, androidx.compose.ui.graphics.PathEffect inner) {
        String str = "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect";
        Intrinsics.checkNotNull(outer, str);
        Intrinsics.checkNotNull(inner, str);
        ComposePathEffect composePathEffect = new ComposePathEffect((AndroidPathEffect)outer.getNativePathEffect(), (AndroidPathEffect)inner.getNativePathEffect());
        AndroidPathEffect androidPathEffect = new AndroidPathEffect((PathEffect)composePathEffect);
        return (PathEffect)androidPathEffect;
    }

    public static final androidx.compose.ui.graphics.PathEffect actualCornerPathEffect(float radius) {
        CornerPathEffect cornerPathEffect = new CornerPathEffect(radius);
        AndroidPathEffect androidPathEffect = new AndroidPathEffect((PathEffect)cornerPathEffect);
        return (PathEffect)androidPathEffect;
    }

    public static final androidx.compose.ui.graphics.PathEffect actualDashPathEffect(float[] intervals, float phase) {
        DashPathEffect dashPathEffect = new DashPathEffect(intervals, phase);
        AndroidPathEffect androidPathEffect = new AndroidPathEffect((PathEffect)dashPathEffect);
        return (PathEffect)androidPathEffect;
    }

    public static final androidx.compose.ui.graphics.PathEffect actualStampedPathEffect-7aD1DOk(androidx.compose.ui.graphics.Path shape, float advance, float phase, int style) {
        Object obj = shape;
        final int i = 0;
        if (obj instanceof AndroidPath == null) {
        } else {
            PathDashPathEffect pathDashPathEffect = new PathDashPathEffect((AndroidPath)obj.getInternalPath(), advance, phase, AndroidPathEffect_androidKt.toAndroidPathDashPathEffectStyle-oQv6xUo(style));
            AndroidPathEffect androidPathEffect = new AndroidPathEffect((PathEffect)pathDashPathEffect);
            return (PathEffect)androidPathEffect;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    public static final PathEffect asAndroidPathEffect(androidx.compose.ui.graphics.PathEffect $this$asAndroidPathEffect) {
        Intrinsics.checkNotNull($this$asAndroidPathEffect, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect");
        return (AndroidPathEffect)$this$asAndroidPathEffect.getNativePathEffect();
    }

    public static final PathDashPathEffect.Style toAndroidPathDashPathEffectStyle-oQv6xUo(int $this$toAndroidPathDashPathEffectStyle_u2doQv6xUo) {
        PathDashPathEffect.Style tRANSLATE;
        tRANSLATE = StampedPathEffectStyle.equals-impl0($this$toAndroidPathDashPathEffectStyle_u2doQv6xUo, StampedPathEffectStyle.Companion.getMorph-Ypspkwk()) ? PathDashPathEffect.Style.MORPH : equals-impl02 ? PathDashPathEffect.Style.ROTATE : equals-impl03 ? PathDashPathEffect.Style.TRANSLATE : PathDashPathEffect.Style.TRANSLATE;
        return tRANSLATE;
    }

    public static final androidx.compose.ui.graphics.PathEffect toComposePathEffect(PathEffect $this$toComposePathEffect) {
        AndroidPathEffect androidPathEffect = new AndroidPathEffect($this$toComposePathEffect);
        return (PathEffect)androidPathEffect;
    }
}
