package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R.id;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u00085\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0000\u001a\u000c\u0010V\u001a\u00020W*\u00020SH\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\u0004\u001a\u0004\u0008\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0004\u001a\u0004\u0008\u000c\u0010\u0006\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\u0004\u001a\u0004\u0008\u0013\u0010\u0010\"(\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a\".\u0010\u0015\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u0017\u0010\u001e\"\u0004\u0008\u0019\u0010\u001f\"\u0015\u0010 \u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008!\u0010\u0010\"\u0015\u0010\"\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008#\u0010\u0010\"\u001e\u0010$\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008%\u0010\u0004\u001a\u0004\u0008&\u0010\u0010\"\u001e\u0010'\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008(\u0010\u0004\u001a\u0004\u0008)\u0010\u0010\"\u001e\u0010*\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008+\u0010\u0004\u001a\u0004\u0008*\u0010\u0006\"\u001e\u0010,\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008-\u0010\u0004\u001a\u0004\u0008,\u0010\u0006\"\u001e\u0010.\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008/\u0010\u0004\u001a\u0004\u0008.\u0010\u0006\"\u0015\u00100\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u00081\u0010\u0010\"\u0015\u00102\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u00083\u0010\u0010\"\u001e\u00104\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00085\u0010\u0004\u001a\u0004\u00086\u0010\u0010\"\u0015\u00107\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u00088\u0010\u0010\"\u0015\u00109\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008:\u0010\u0010\"\u0015\u0010;\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008<\u0010\u0010\"\u0015\u0010=\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008>\u0010\u0010\"\u001e\u0010?\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008@\u0010\u0004\u001a\u0004\u0008A\u0010\u0010\"\u0015\u0010B\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008C\u0010\u0010\"\u001e\u0010D\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008E\u0010\u0004\u001a\u0004\u0008F\u0010\u0010\"\u0015\u0010G\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008H\u0010\u0010\"\u0015\u0010I\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008J\u0010\u0010\"\u001e\u0010K\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008L\u0010\u0004\u001a\u0004\u0008M\u0010\u0010\"\u0015\u0010N\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\u0008O\u0010\u0010¨\u0006X", d2 = {"areNavigationBarsVisible", "", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "getAreNavigationBarsVisible$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;)V", "getAreNavigationBarsVisible", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Z", "areStatusBarsVisible", "getAreStatusBarsVisible$annotations", "getAreStatusBarsVisible", "areSystemBarsVisible", "getAreSystemBarsVisible$annotations", "getAreSystemBarsVisible", "captionBar", "Landroidx/compose/foundation/layout/WindowInsets;", "getCaptionBar", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility$annotations", "getCaptionBarIgnoringVisibility", "value", "consumeWindowInsets", "Landroidx/compose/ui/platform/AbstractComposeView;", "getConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;)Z", "setConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;Z)V", "Landroidx/compose/ui/platform/ComposeView;", "getConsumeWindowInsets$annotations", "(Landroidx/compose/ui/platform/ComposeView;)V", "(Landroidx/compose/ui/platform/ComposeView;)Z", "(Landroidx/compose/ui/platform/ComposeView;Z)V", "displayCutout", "getDisplayCutout", "ime", "getIme", "imeAnimationSource", "getImeAnimationSource$annotations", "getImeAnimationSource", "imeAnimationTarget", "getImeAnimationTarget$annotations", "getImeAnimationTarget", "isCaptionBarVisible", "isCaptionBarVisible$annotations", "isImeVisible", "isImeVisible$annotations", "isTappableElementVisible", "isTappableElementVisible$annotations", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility$annotations", "getNavigationBarsIgnoringVisibility", "safeContent", "getSafeContent", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "statusBars", "getStatusBars", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility$annotations", "getStatusBarsIgnoringVisibility", "systemBars", "getSystemBars", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility$annotations", "getSystemBarsIgnoringVisibility", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility$annotations", "getTappableElementIgnoringVisibility", "waterfall", "getWaterfall", "ValueInsets", "Landroidx/compose/foundation/layout/ValueInsets;", "insets", "Landroidx/core/graphics/Insets;", "name", "", "toInsetsValues", "Landroidx/compose/foundation/layout/InsetsValues;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowInsets_androidKt {
    public static final androidx.compose.foundation.layout.ValueInsets ValueInsets(Insets insets, String name) {
        ValueInsets valueInsets = new ValueInsets(WindowInsets_androidKt.toInsetsValues(insets), name);
        return valueInsets;
    }

    public static final boolean getAreNavigationBarsVisible(androidx.compose.foundation.layout.WindowInsets.Companion $this$areNavigationBarsVisible, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 710310464;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C366@12711L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-areNavigationBarsVisible> (WindowInsets.android.kt:366)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getNavigationBars().isVisible();
    }

    public static void getAreNavigationBarsVisible$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final boolean getAreStatusBarsVisible(androidx.compose.foundation.layout.WindowInsets.Companion $this$areStatusBarsVisible, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1613283456;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C354@12319L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-areStatusBarsVisible> (WindowInsets.android.kt:354)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getStatusBars().isVisible();
    }

    public static void getAreStatusBarsVisible$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final boolean getAreSystemBarsVisible(androidx.compose.foundation.layout.WindowInsets.Companion $this$areSystemBarsVisible, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1985490720;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C378@13099L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-areSystemBarsVisible> (WindowInsets.android.kt:378)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getSystemBars().isVisible();
    }

    public static void getAreSystemBarsVisible$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final androidx.compose.foundation.layout.WindowInsets getCaptionBar(androidx.compose.foundation.layout.WindowInsets.Companion $this$captionBar, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1832025528;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C142@4955L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-captionBar> (WindowInsets.android.kt:142)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getCaptionBar();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getCaptionBarIgnoringVisibility(androidx.compose.foundation.layout.WindowInsets.Companion $this$captionBarIgnoringVisibility, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1731251574;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C266@9266L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-captionBarIgnoringVisibility> (WindowInsets.android.kt:266)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getCaptionBarIgnoringVisibility();
    }

    public static void getCaptionBarIgnoringVisibility$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final boolean getConsumeWindowInsets(AbstractComposeView $this$consumeWindowInsets) {
        Object tag;
        int booleanValue;
        if (tag instanceof Boolean) {
        } else {
            tag = 0;
        }
        if (tag != null) {
            booleanValue = tag.booleanValue();
        } else {
            booleanValue = 1;
        }
        return booleanValue;
    }

    public static final boolean getConsumeWindowInsets(ComposeView $this$consumeWindowInsets) {
        Object tag;
        int booleanValue;
        if (tag instanceof Boolean) {
        } else {
            tag = 0;
        }
        if (tag != null) {
            booleanValue = tag.booleanValue();
        } else {
            booleanValue = 1;
        }
        return booleanValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use AbstractComposeView.consumeWindowInsets")
    public static void getConsumeWindowInsets$annotations(ComposeView composeView) {
    }

    public static final androidx.compose.foundation.layout.WindowInsets getDisplayCutout(androidx.compose.foundation.layout.WindowInsets.Companion $this$displayCutout, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1324817724;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C151@5303L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-displayCutout> (WindowInsets.android.kt:151)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getDisplayCutout();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getIme(androidx.compose.foundation.layout.WindowInsets.Companion $this$ime, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1466917860;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C165@5937L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-ime> (WindowInsets.android.kt:165)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getIme();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getImeAnimationSource(androidx.compose.foundation.layout.WindowInsets.Companion $this$imeAnimationSource, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1126064918;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C404@14002L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-imeAnimationSource> (WindowInsets.android.kt:404)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getImeAnimationSource();
    }

    public static void getImeAnimationSource$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final androidx.compose.foundation.layout.WindowInsets getImeAnimationTarget(androidx.compose.foundation.layout.WindowInsets.Companion $this$imeAnimationTarget, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -466319786;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C419@14543L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-imeAnimationTarget> (WindowInsets.android.kt:419)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getImeAnimationTarget();
    }

    public static void getImeAnimationTarget$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final androidx.compose.foundation.layout.WindowInsets getMandatorySystemGestures(androidx.compose.foundation.layout.WindowInsets.Companion $this$mandatorySystemGestures, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1369492988;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C174@6271L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-mandatorySystemGestures> (WindowInsets.android.kt:174)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getMandatorySystemGestures();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getNavigationBars(androidx.compose.foundation.layout.WindowInsets.Companion $this$navigationBars, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1596175702;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C184@6630L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-navigationBars> (WindowInsets.android.kt:184)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getNavigationBars();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getNavigationBarsIgnoringVisibility(androidx.compose.foundation.layout.WindowInsets.Companion $this$navigationBarsIgnoringVisibility, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1990981160;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C280@9832L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-navigationBarsIgnoringVisibility> (WindowInsets.android.kt:280)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getNavigationBarsIgnoringVisibility();
    }

    public static void getNavigationBarsIgnoringVisibility$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final androidx.compose.foundation.layout.WindowInsets getSafeContent(androidx.compose.foundation.layout.WindowInsets.Companion $this$safeContent, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2026663876;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C254@8858L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-safeContent> (WindowInsets.android.kt:254)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getSafeContent();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getSafeDrawing(androidx.compose.foundation.layout.WindowInsets.Companion $this$safeDrawing, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -49441252;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C234@8107L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-safeDrawing> (WindowInsets.android.kt:234)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getSafeDrawing();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getSafeGestures(androidx.compose.foundation.layout.WindowInsets.Companion $this$safeGestures, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1594247780;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C245@8541L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-safeGestures> (WindowInsets.android.kt:245)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getSafeGestures();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getStatusBars(androidx.compose.foundation.layout.WindowInsets.Companion $this$statusBars, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -675090670;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C192@6849L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-statusBars> (WindowInsets.android.kt:192)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getStatusBars();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getStatusBarsIgnoringVisibility(androidx.compose.foundation.layout.WindowInsets.Companion $this$statusBarsIgnoringVisibility, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 594020756;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C292@10273L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-statusBarsIgnoringVisibility> (WindowInsets.android.kt:292)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getStatusBarsIgnoringVisibility();
    }

    public static void getStatusBarsIgnoringVisibility$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final androidx.compose.foundation.layout.WindowInsets getSystemBars(androidx.compose.foundation.layout.WindowInsets.Companion $this$systemBars, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -282936756;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C200@7064L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:200)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getSystemBars();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getSystemBarsIgnoringVisibility(androidx.compose.foundation.layout.WindowInsets.Companion $this$systemBarsIgnoringVisibility, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1564566798;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C305@10710L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-systemBarsIgnoringVisibility> (WindowInsets.android.kt:305)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getSystemBarsIgnoringVisibility();
    }

    public static void getSystemBarsIgnoringVisibility$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final androidx.compose.foundation.layout.WindowInsets getSystemGestures(androidx.compose.foundation.layout.WindowInsets.Companion $this$systemGestures, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 989216224;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C208@7287L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-systemGestures> (WindowInsets.android.kt:208)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getSystemGestures();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getTappableElement(androidx.compose.foundation.layout.WindowInsets.Companion $this$tappableElement, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1994205284;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C216@7516L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-tappableElement> (WindowInsets.android.kt:216)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getTappableElement();
    }

    public static final androidx.compose.foundation.layout.WindowInsets getTappableElementIgnoringVisibility(androidx.compose.foundation.layout.WindowInsets.Companion $this$tappableElementIgnoringVisibility, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1488788292;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C318@11155L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-tappableElementIgnoringVisibility> (WindowInsets.android.kt:318)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getTappableElementIgnoringVisibility();
    }

    public static void getTappableElementIgnoringVisibility$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final androidx.compose.foundation.layout.WindowInsets getWaterfall(androidx.compose.foundation.layout.WindowInsets.Companion $this$waterfall, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1943241020;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C224@7745L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-waterfall> (WindowInsets.android.kt:224)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (WindowInsets)WindowInsetsHolder.Companion.current($composer, 6).getWaterfall();
    }

    public static final boolean isCaptionBarVisible(androidx.compose.foundation.layout.WindowInsets.Companion $this$isCaptionBarVisible, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -501076620;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C330@11561L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-isCaptionBarVisible> (WindowInsets.android.kt:330)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getCaptionBar().isVisible();
    }

    public static void isCaptionBarVisible$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final boolean isImeVisible(androidx.compose.foundation.layout.WindowInsets.Companion $this$isImeVisible, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1873571424;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C342@11942L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-isImeVisible> (WindowInsets.android.kt:342)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getIme().isVisible();
    }

    public static void isImeVisible$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final boolean isTappableElementVisible(androidx.compose.foundation.layout.WindowInsets.Companion $this$isTappableElementVisible, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1737201120;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C389@13490L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.layout.<get-isTappableElementVisible> (WindowInsets.android.kt:389)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsHolder.Companion.current($composer, 6).getTappableElement().isVisible();
    }

    public static void isTappableElementVisible$annotations(androidx.compose.foundation.layout.WindowInsets.Companion windowInsets$Companion) {
    }

    public static final void setConsumeWindowInsets(AbstractComposeView $this$consumeWindowInsets, boolean value) {
        $this$consumeWindowInsets.setTag(R.id.consume_window_insets_tag, Boolean.valueOf(value));
    }

    public static final void setConsumeWindowInsets(ComposeView $this$consumeWindowInsets, boolean value) {
        $this$consumeWindowInsets.setTag(R.id.consume_window_insets_tag, Boolean.valueOf(value));
    }

    public static final androidx.compose.foundation.layout.InsetsValues toInsetsValues(Insets $this$toInsetsValues) {
        InsetsValues insetsValues = new InsetsValues($this$toInsetsValues.left, $this$toInsetsValues.top, $this$toInsetsValues.right, $this$toInsetsValues.bottom);
        return insetsValues;
    }
}
