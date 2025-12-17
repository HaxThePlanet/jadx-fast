package androidx.compose.ui.graphics;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0006\u0010\u0007\u001a\u00020\u0008\u001a\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u000c", d2 = {"DefaultCameraDistance", "", "DefaultShadowColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultShadowColor", "()J", "J", "GraphicsLayerScope", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "rememberGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GraphicsLayerScopeKt {

    public static final float DefaultCameraDistance = 8f;
    private static final long DefaultShadowColor;
    static {
        GraphicsLayerScopeKt.DefaultShadowColor = Color.Companion.getBlack-0d7_KjU();
    }

    public static final androidx.compose.ui.graphics.GraphicsLayerScope GraphicsLayerScope() {
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = new ReusableGraphicsLayerScope();
        return (GraphicsLayerScope)reusableGraphicsLayerScope;
    }

    public static final long getDefaultShadowColor() {
        return GraphicsLayerScopeKt.DefaultShadowColor;
    }

    public static final GraphicsLayer rememberGraphicsLayer(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int empty;
        Object graphicsContextObserver;
        int i = 158092365;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberGraphicsLayer)257@10239L7,258@10258L53:GraphicsLayerScope.kt#aiphks");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.ui.graphics.rememberGraphicsLayer (GraphicsLayerScope.kt:256)");
        }
        int i2 = 6;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1099487492, "CC(remember):GraphicsLayerScope.kt#9igjgp");
        int i4 = 0;
        Composer composer = $composer;
        int i7 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i8 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            graphicsContextObserver = new GraphicsContextObserver((GraphicsContext)$composer.consume((CompositionLocal)CompositionLocalsKt.getLocalGraphicsContext()));
            composer.updateRememberedValue(graphicsContextObserver);
        } else {
            graphicsContextObserver = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (GraphicsContextObserver)graphicsContextObserver.getGraphicsLayer();
    }
}
