package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u000b\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u000b\u001a\u00020\u00042\u0008\u0008\u0001\u0010\u000c\u001a\u00020\u00042\u0008\u0008\u0001\u0010\r\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0006¨\u0006\u000f", d2 = {"Landroidx/compose/material/ContentAlpha;", "", "()V", "disabled", "", "getDisabled", "(Landroidx/compose/runtime/Composer;I)F", "high", "getHigh", "medium", "getMedium", "contentAlpha", "highContrastAlpha", "lowContrastAlpha", "(FFLandroidx/compose/runtime/Composer;I)F", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentAlpha {

    public static final int $stable;
    public static final androidx.compose.material.ContentAlpha INSTANCE;
    static {
        ContentAlpha contentAlpha = new ContentAlpha();
        ContentAlpha.INSTANCE = contentAlpha;
    }

    private final float contentAlpha(float highContrastAlpha, float lowContrastAlpha, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int cmp;
        Object obj;
        double d;
        int i = -1528360391;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(contentAlpha)77@2653L7,78@2700L6:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:76)");
        }
        int i2 = 6;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        long unbox-impl = (Color)$composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        long l = 4602678819172646912L;
        if (MaterialTheme.INSTANCE.getColors($composer, 6).isLight()) {
            if (Double.compare(d, l) > 0) {
                obj = highContrastAlpha;
            } else {
                obj = lowContrastAlpha;
            }
        } else {
            if (Double.compare(d, l) < 0) {
            } else {
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return obj;
    }

    public final float getDisabled(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 621183615;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C57@1843L154:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:57)");
        }
        int i5 = 1052938076;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return contentAlpha(i5, i5, $composer, i3 |= 54);
    }

    public final float getHigh(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 629162431;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C35@1145L146:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:35)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return contentAlpha(1065353216, 1063172178, $composer, i3 |= 54);
    }

    public final float getMedium(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1999054879;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C46@1496L150:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:46)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return contentAlpha(1060991140, 1058642330, $composer, i3 |= 54);
    }
}
