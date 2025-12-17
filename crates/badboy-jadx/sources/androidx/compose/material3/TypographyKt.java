package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u000b", d2 = {"LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/Typography;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "value", "Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/TypographyKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "fromToken", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TypographyKt {

    private static final ProvidableCompositionLocal<androidx.compose.material3.Typography> LocalTypography;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal7;
            int ordinal6;
            int ordinal14;
            int ordinal5;
            int ordinal8;
            int ordinal9;
            int ordinal2;
            int ordinal13;
            int ordinal15;
            int ordinal11;
            int ordinal12;
            int ordinal;
            int ordinal3;
            int ordinal4;
            int ordinal10;
            int[] iArr = new int[values.length];
            iArr[TypographyKeyTokens.DisplayLarge.ordinal()] = 1;
            iArr[TypographyKeyTokens.DisplayMedium.ordinal()] = 2;
            iArr[TypographyKeyTokens.DisplaySmall.ordinal()] = 3;
            iArr[TypographyKeyTokens.HeadlineLarge.ordinal()] = 4;
            iArr[TypographyKeyTokens.HeadlineMedium.ordinal()] = 5;
            iArr[TypographyKeyTokens.HeadlineSmall.ordinal()] = 6;
            iArr[TypographyKeyTokens.TitleLarge.ordinal()] = 7;
            iArr[TypographyKeyTokens.TitleMedium.ordinal()] = 8;
            iArr[TypographyKeyTokens.TitleSmall.ordinal()] = 9;
            try {
                iArr[TypographyKeyTokens.BodyLarge.ordinal()] = 10;
                iArr[TypographyKeyTokens.BodyMedium.ordinal()] = 11;
                iArr[TypographyKeyTokens.BodySmall.ordinal()] = 12;
                iArr[TypographyKeyTokens.LabelLarge.ordinal()] = 13;
                iArr[TypographyKeyTokens.LabelMedium.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError e) {
            }
            iArr[TypographyKeyTokens.LabelSmall.ordinal()] = 15;
            TypographyKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        TypographyKt.LocalTypography = CompositionLocalKt.staticCompositionLocalOf((Function0)TypographyKt.LocalTypography.1.INSTANCE);
    }

    private static final TextStyle fromToken(androidx.compose.material3.Typography $this$fromToken, TypographyKeyTokens value) {
        TextStyle headlineMedium;
        switch (i2) {
            case 1:
                headlineMedium = $this$fromToken.getDisplayLarge();
                break;
            case 2:
                headlineMedium = $this$fromToken.getDisplayMedium();
                break;
            case 3:
                headlineMedium = $this$fromToken.getDisplaySmall();
                break;
            case 4:
                headlineMedium = $this$fromToken.getHeadlineLarge();
                break;
            case 5:
                headlineMedium = $this$fromToken.getHeadlineMedium();
                break;
            case 6:
                headlineMedium = $this$fromToken.getHeadlineSmall();
                break;
            case 7:
                headlineMedium = $this$fromToken.getTitleLarge();
                break;
            case 8:
                headlineMedium = $this$fromToken.getTitleMedium();
                break;
            case 9:
                headlineMedium = $this$fromToken.getTitleSmall();
                break;
            case 10:
                headlineMedium = $this$fromToken.getBodyLarge();
                break;
            case 11:
                headlineMedium = $this$fromToken.getBodyMedium();
                break;
            case 12:
                headlineMedium = $this$fromToken.getBodySmall();
                break;
            case 13:
                headlineMedium = $this$fromToken.getLabelLarge();
                break;
            case 14:
                headlineMedium = $this$fromToken.getLabelMedium();
                break;
            case 15:
                headlineMedium = $this$fromToken.getLabelSmall();
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return headlineMedium;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material3.Typography> getLocalTypography() {
        return TypographyKt.LocalTypography;
    }

    public static final TextStyle getValue(TypographyKeyTokens $this$value, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1049072145;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C209@10713L10:Typography.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.<get-value> (Typography.kt:209)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer, 6), $this$value);
    }
}
