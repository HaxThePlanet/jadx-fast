package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u000c\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0007¨\u0006\u0004", d2 = {"toAndroidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "toComposeColorSpace", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidColorSpace_androidKt {
    public static final ColorSpace toAndroidColorSpace(ColorSpace $this$toAndroidColorSpace) {
        androidx.compose.ui.graphics.ColorSpaceVerificationHelper iNSTANCE = ColorSpaceVerificationHelper.INSTANCE;
        final int i = 0;
        return ColorSpaceVerificationHelper.androidColorSpace($this$toAndroidColorSpace);
    }

    public static final ColorSpace toComposeColorSpace(ColorSpace $this$toComposeColorSpace) {
        androidx.compose.ui.graphics.ColorSpaceVerificationHelper iNSTANCE = ColorSpaceVerificationHelper.INSTANCE;
        final int i = 0;
        return ColorSpaceVerificationHelper.composeColorSpace($this$toComposeColorSpace);
    }
}
