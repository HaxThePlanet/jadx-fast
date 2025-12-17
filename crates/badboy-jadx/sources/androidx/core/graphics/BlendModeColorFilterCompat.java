package androidx.core.graphics;

import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;

/* loaded from: classes5.dex */
public class BlendModeColorFilterCompat {

    static class Api29Impl {
        static ColorFilter createBlendModeColorFilter(int color, Object mode) {
            BlendModeColorFilter blendModeColorFilter = new BlendModeColorFilter(color, (BlendMode)mode);
            return blendModeColorFilter;
        }
    }
    public static ColorFilter createBlendModeColorFilterCompat(int color, androidx.core.graphics.BlendModeCompat blendModeCompat) {
        ColorFilter blendModeColorFilter;
        final Object blendModeFromCompat = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(blendModeCompat);
        if (blendModeFromCompat != null) {
            blendModeColorFilter = BlendModeColorFilterCompat.Api29Impl.createBlendModeColorFilter(color, blendModeFromCompat);
        } else {
            blendModeColorFilter = 0;
        }
        return blendModeColorFilter;
    }
}
