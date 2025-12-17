package androidx.compose.ui.graphics;

import android.graphics.BlendModeColorFilter;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0004H\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"Landroidx/compose/ui/graphics/BlendModeColorFilterHelper;", "", "()V", "BlendModeColorFilter", "Landroid/graphics/BlendModeColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "BlendModeColorFilter-xETnrds", "(JI)Landroid/graphics/BlendModeColorFilter;", "createBlendModeColorFilter", "Landroidx/compose/ui/graphics/BlendModeColorFilter;", "androidBlendModeColorFilter", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BlendModeColorFilterHelper {

    public static final androidx.compose.ui.graphics.BlendModeColorFilterHelper INSTANCE;
    static {
        BlendModeColorFilterHelper blendModeColorFilterHelper = new BlendModeColorFilterHelper();
        BlendModeColorFilterHelper.INSTANCE = blendModeColorFilterHelper;
    }

    public final BlendModeColorFilter BlendModeColorFilter-xETnrds(long color, int blendMode) {
        BlendModeColorFilter blendModeColorFilter = new BlendModeColorFilter(ColorKt.toArgb-8_81llA(color), AndroidBlendMode_androidKt.toAndroidBlendMode-s9anfk8(obj6));
        return blendModeColorFilter;
    }

    public final androidx.compose.ui.graphics.BlendModeColorFilter createBlendModeColorFilter(BlendModeColorFilter androidBlendModeColorFilter) {
        BlendModeColorFilter blendModeColorFilter = new BlendModeColorFilter(ColorKt.Color(androidBlendModeColorFilter.getColor()), obj2, AndroidBlendMode_androidKt.toComposeBlendMode(androidBlendModeColorFilter.getMode()), (ColorFilter)androidBlendModeColorFilter, 0);
        return blendModeColorFilter;
    }
}
