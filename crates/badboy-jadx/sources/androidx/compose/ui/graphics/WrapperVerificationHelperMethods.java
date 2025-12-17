package androidx.compose.ui.graphics;

import android.graphics.Paint;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"Landroidx/compose/ui/graphics/WrapperVerificationHelperMethods;", "", "()V", "setBlendMode", "", "paint", "Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WrapperVerificationHelperMethods {

    public static final androidx.compose.ui.graphics.WrapperVerificationHelperMethods INSTANCE;
    static {
        WrapperVerificationHelperMethods wrapperVerificationHelperMethods = new WrapperVerificationHelperMethods();
        WrapperVerificationHelperMethods.INSTANCE = wrapperVerificationHelperMethods;
    }

    public final void setBlendMode-GB0RdKg(Paint paint, int mode) {
        paint.setBlendMode(AndroidBlendMode_androidKt.toAndroidBlendMode-s9anfk8(mode));
    }
}
