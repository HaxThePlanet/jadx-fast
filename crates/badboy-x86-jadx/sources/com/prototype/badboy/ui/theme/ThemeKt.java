package com.prototype.badboy.ui.theme;

import android.os.Build.VERSION;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a4\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0011\u0010\u0008\u001a\r\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "BadboyTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ThemeKt {

    private static final ColorScheme DarkColorScheme;
    private static final ColorScheme LightColorScheme;
    public static Unit $r8$lambda$ZCp5Hc56gYfpz1LaZg9sEYeQNzA(boolean z, boolean z2, Function2 function23, int i4, int i5, Composer composer6, int i7) {
        return ThemeKt.BadboyTheme$lambda$0(z, z2, function23, i4, i5, composer6, i7);
    }

    static {
        final int i35 = 15;
        final int i36 = 0;
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        final int i6 = 0;
        final int i7 = 0;
        final int i8 = 0;
        final int i9 = 0;
        final int i10 = 0;
        final int i11 = 0;
        final int i12 = 0;
        final int i13 = 0;
        final int i14 = 0;
        final int i15 = 0;
        final int i16 = 0;
        final int i17 = 0;
        final int i18 = 0;
        final int i19 = 0;
        final int i20 = 0;
        final int i21 = 0;
        final int i22 = 0;
        final int i23 = 0;
        final int i24 = 0;
        final int i25 = 0;
        final int i26 = 0;
        final int i27 = 0;
        final int i28 = 0;
        final int i29 = 0;
        final int i30 = 0;
        final int i31 = 0;
        final int i32 = 0;
        final int i33 = 0;
        final int i34 = -546;
        ThemeKt.DarkColorScheme = ColorSchemeKt.darkColorScheme-C-Xl9yA$default(ColorKt.getPurple80(), obj2, i, obj4, i2, obj6, i3, obj8, i4, obj10, ColorKt.getPurpleGrey80(), obj12, i5, obj14, i6, obj16, i7, obj18, ColorKt.getPink80(), obj20, i8, obj22, i9, obj24, i10, obj26, i11, obj28, i12, obj30, i13, obj32, i14, obj34, i15, obj36, i16, obj38, i17);
        ThemeKt.LightColorScheme = ColorSchemeKt.lightColorScheme-C-Xl9yA$default(ColorKt.getPurple40(), obj2, i, obj4, i2, obj6, i3, obj8, i4, obj10, ColorKt.getPurpleGrey40(), obj12, i5, obj14, i6, obj16, i7, obj18, ColorKt.getPink40(), obj20, i8, obj22, i9, obj24, i10, obj26, i11, obj28, i12, obj30, i13, obj32, i14, obj34, i15, obj36, i16, obj38, i17);
    }

    public static final void BadboyTheme(boolean darkTheme, boolean dynamicColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        String sDK_INT;
        ColorScheme context;
        int $dirty;
        boolean traceInProgress;
        ColorScheme dynamicLightColorScheme;
        boolean $dirty2;
        int darkTheme2;
        boolean z;
        Object obj;
        Composer restartGroup;
        int changed;
        int consume;
        int str;
        Composer composer;
        int i3;
        int i4;
        int skipping;
        int defaultsInvalid;
        int i5;
        boolean i2;
        int i;
        Intrinsics.checkNotNullParameter(content, "content");
        context = -1137280325;
        restartGroup = $composer.startRestartGroup(context);
        ComposerKt.sourceInformation(restartGroup, "C(BadboyTheme)P(1,2)52@1578L114:Theme.kt#vc20f7");
        if ($changed & 6 == 0) {
            if (i6 & 1 == 0 && restartGroup.changed(darkTheme)) {
                changed = restartGroup.changed(darkTheme) ? 4 : 2;
            } else {
            }
            $dirty |= changed;
        }
        consume = i6 & 2;
        if (consume != 0) {
            $dirty |= 48;
        } else {
            if ($changed & 48 == 0) {
                i3 = restartGroup.changed(dynamicColor) ? 32 : 16;
                $dirty |= i3;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if ($changed & 384 == 0) {
                i4 = restartGroup.changedInstance(content) ? 256 : 128;
                $dirty |= i4;
            }
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                ComposerKt.sourceInformation(restartGroup, "37@1091L21");
                if ($changed & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i6 & 1 != 0) {
                            darkTheme2 = DarkThemeKt.isSystemInDarkTheme(restartGroup, 0);
                            $dirty &= -15;
                        } else {
                            darkTheme2 = darkTheme;
                        }
                        if (consume != 0) {
                            i = $dirty;
                            skipping = darkTheme2;
                            i2 = consume;
                        } else {
                            i2 = dynamicColor;
                            i = $dirty;
                            skipping = darkTheme2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i6 & 1 != 0) {
                            $dirty &= -15;
                        }
                        skipping = darkTheme;
                        i2 = dynamicColor;
                        i = $dirty;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(context, i, -1, "com.prototype.badboy.ui.theme.BadboyTheme (Theme.kt:41)");
                }
                restartGroup.startReplaceGroup(1196452234);
                ComposerKt.sourceInformation(restartGroup, "44@1381L7");
                if (i2 && Build.VERSION.SDK_INT >= 31) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i11 = 0;
                        darkTheme2 = 0;
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        Object obj2 = consume;
                        if (skipping) {
                            context = dynamicLightColorScheme;
                        } else {
                            context = dynamicLightColorScheme;
                        }
                    } else {
                        context = skipping ? dynamicLightColorScheme : dynamicLightColorScheme;
                    }
                } else {
                }
                restartGroup.endReplaceGroup();
                MaterialThemeKt.MaterialTheme(context, 0, TypeKt.getTypography(), content, restartGroup, i9 | 384, 2);
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = skipping;
                z = i2;
            } else {
                restartGroup.skipToGroupEnd();
                z = dynamicColor;
                i = $dirty;
                composer = restartGroup;
                $dirty2 = darkTheme;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            context = new ThemeKt$$ExternalSyntheticLambda0($dirty2, z, content, $changed, i6);
            endRestartGroup.updateScope(context);
        }
    }

    private static final Unit BadboyTheme$lambda$0(boolean z, boolean z2, Function2 function23, int i4, int i5, Composer composer6, int i7) {
        ThemeKt.BadboyTheme(z, z2, function23, composer6, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }
}
