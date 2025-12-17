package com.prototype.badboy.ui.theme;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a \u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"BlackColorScheme", "Landroidx/compose/material3/ColorScheme;", "BadboyTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ThemeKt {

    private static final ColorScheme BlackColorScheme;
    public static Unit $r8$lambda$9RvCGCs7BZ4x1615sMGM85TB1W4(Function2 function2, int i2, Composer composer3, int i4) {
        return ThemeKt.BadboyTheme$lambda$0(function2, i2, composer3, i4);
    }

    static {
        ThemeKt.BlackColorScheme = ColorSchemeKt.darkColorScheme-C-Xl9yA$default(ColorKt.getPurple80(), obj2, 0, obj4, 0, obj6, 0, obj8, 0, obj10, ColorKt.getPurpleGrey80(), obj12, 0, obj14, 0, obj16, 0, obj18, ColorKt.getPink80(), obj20, 0, obj22, 0, obj24, 0, obj26, Color.Companion.getBlack-0d7_KjU(), obj28, Color.Companion.getWhite-0d7_KjU(), obj30, Color.Companion.getBlack-0d7_KjU(), obj32, Color.Companion.getWhite-0d7_KjU(), obj34, 0, obj36, 0, obj38, 0);
    }

    public static final void BadboyTheme(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int externalSyntheticLambda0;
        int i;
        int blackColorScheme;
        boolean traceInProgress;
        int str;
        androidx.compose.material3.Typography typography;
        Object obj;
        int i2;
        int i3;
        Object obj8;
        int obj9;
        Intrinsics.checkNotNullParameter(content, "content");
        externalSyntheticLambda0 = -1652697997;
        final Composer restartGroup = $composer.startRestartGroup(externalSyntheticLambda0);
        ComposerKt.sourceInformation(restartGroup, "C(BadboyTheme)21@541L119:Theme.kt#vc20f7");
        str = 2;
        if ($changed & 6 == 0) {
            i = restartGroup.changedInstance(content) ? 4 : str;
            obj9 |= i;
        }
        if (obj9 & 3 == str) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(externalSyntheticLambda0, obj9, -1, "com.prototype.badboy.ui.theme.BadboyTheme (Theme.kt:20)");
                }
                MaterialThemeKt.MaterialTheme(ThemeKt.BlackColorScheme, 0, TypeKt.getTypography(), content, restartGroup, externalSyntheticLambda0 | 390, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj = content;
            }
        } else {
        }
        obj8 = restartGroup.endRestartGroup();
        if (obj8 != null) {
            externalSyntheticLambda0 = new ThemeKt$$ExternalSyntheticLambda0(obj, $changed);
            obj8.updateScope(externalSyntheticLambda0);
        }
    }

    private static final Unit BadboyTheme$lambda$0(Function2 function2, int i2, Composer composer3, int i4) {
        ThemeKt.BadboyTheme(function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }
}
