package androidx.compose.material.ripple;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com")
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008g\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0015\u0010\u0002\u001a\u00020\u0003H'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010\u0008ø\u0001\u0002\u0082\u0002\u0011\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0001", d2 = {"Landroidx/compose/material/ripple/RippleTheme;", "", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "Companion", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RippleTheme {

    public static final androidx.compose.material.ripple.RippleTheme.Companion Companion;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nJ\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"Landroidx/compose/material/ripple/RippleTheme$Companion;", "", "()V", "defaultRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "lightTheme", "", "defaultRippleAlpha-DxMtmZc", "(JZ)Landroidx/compose/material/ripple/RippleAlpha;", "defaultRippleColor", "defaultRippleColor-5vOe2sY", "(JZ)J", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.material.ripple.RippleTheme.Companion $$INSTANCE;
        static {
            RippleTheme.Companion companion = new RippleTheme.Companion();
            RippleTheme.Companion.$$INSTANCE = companion;
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "The default ripple alpha varies between design system versions: this function technically implements the default used by the material library, but is not used by the material3 library. To remove confusion and link the defaults more strongly to the design system library, these default values have been moved to the material and material3 libraries. For material, use MaterialRippleThemeDefaults#rippleAlpha. For material3, use MaterialRippleThemeDefaults#RippleAlpha.")
        public final androidx.compose.material.ripple.RippleAlpha defaultRippleAlpha-DxMtmZc(long contentColor, boolean lightTheme) {
            androidx.compose.material.ripple.RippleAlpha rippleAlpha;
            long l;
            if (obj7 != null) {
                if (Double.compare(d, l) > 0) {
                    rippleAlpha = RippleThemeKt.access$getLightThemeHighContrastRippleAlpha$p();
                } else {
                    rippleAlpha = RippleThemeKt.access$getLightThemeLowContrastRippleAlpha$p();
                }
            } else {
                rippleAlpha = RippleThemeKt.access$getDarkThemeRippleAlpha$p();
            }
            return rippleAlpha;
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "The default ripple color varies between design system versions: this function technically implements the default used by the material library, but is not used by the material3 library. To remove confusion and link the defaults more strongly to the design system library, these default values have been moved to the material and material3 libraries. For material, use MaterialRippleThemeDefaults#rippleColor. For material3, use content color directly.")
        public final long defaultRippleColor-5vOe2sY(long contentColor, boolean lightTheme) {
            int cmp;
            long white-0d7_KjU;
            long l;
            if (obj8 == null && Double.compare(d, l) < 0) {
                if (Double.compare(d, l) < 0) {
                    white-0d7_KjU = Color.Companion.getWhite-0d7_KjU();
                } else {
                    white-0d7_KjU = contentColor;
                }
            } else {
            }
            return white-0d7_KjU;
        }
    }
    static {
        RippleTheme.Companion = RippleTheme.Companion.$$INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com")
    public abstract long defaultColor-WaAFU9c(Composer composer, int i2);

    @Deprecated(level = DeprecationLevel.ERROR, message = "RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com")
    public abstract androidx.compose.material.ripple.RippleAlpha rippleAlpha(Composer composer, int i2);
}
