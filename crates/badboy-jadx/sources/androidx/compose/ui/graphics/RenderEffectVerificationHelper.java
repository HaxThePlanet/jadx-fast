package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ$\u0010\u000e\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"Landroidx/compose/ui/graphics/RenderEffectVerificationHelper;", "", "()V", "createBlurEffect", "Landroid/graphics/RenderEffect;", "inputRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "createBlurEffect-8A-3gB4", "(Landroidx/compose/ui/graphics/RenderEffect;FFI)Landroid/graphics/RenderEffect;", "createOffsetEffect", "offset", "Landroidx/compose/ui/geometry/Offset;", "createOffsetEffect-Uv8p0NA", "(Landroidx/compose/ui/graphics/RenderEffect;J)Landroid/graphics/RenderEffect;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RenderEffectVerificationHelper {

    public static final androidx.compose.ui.graphics.RenderEffectVerificationHelper INSTANCE;
    static {
        RenderEffectVerificationHelper renderEffectVerificationHelper = new RenderEffectVerificationHelper();
        RenderEffectVerificationHelper.INSTANCE = renderEffectVerificationHelper;
    }

    public final RenderEffect createBlurEffect-8A-3gB4(androidx.compose.ui.graphics.RenderEffect inputRenderEffect, float radiusX, float radiusY, int edgeTreatment) {
        RenderEffect blurEffect;
        android.graphics.Shader.TileMode androidTileMode-0vamqd0;
        if (inputRenderEffect == null) {
            blurEffect = RenderEffect.createBlurEffect(radiusX, radiusY, AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(edgeTreatment));
        } else {
            blurEffect = RenderEffect.createBlurEffect(radiusX, radiusY, inputRenderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(edgeTreatment));
        }
        return blurEffect;
    }

    public final RenderEffect createOffsetEffect-Uv8p0NA(androidx.compose.ui.graphics.RenderEffect inputRenderEffect, long offset) {
        RenderEffect offsetEffect;
        float y-impl;
        RenderEffect androidRenderEffect;
        if (inputRenderEffect == null) {
            offsetEffect = RenderEffect.createOffsetEffect(Offset.getX-impl(offset), Offset.getY-impl(offset));
        } else {
            offsetEffect = RenderEffect.createOffsetEffect(Offset.getX-impl(offset), Offset.getY-impl(offset), inputRenderEffect.asAndroidRenderEffect());
        }
        return offsetEffect;
    }
}
