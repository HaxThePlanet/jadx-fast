package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aD\u0010\u0007\u001a\u00020\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00080\u0010¢\u0006\u0002\u0008\u0011H\u0001¢\u0006\u0002\u0010\u0012\u001a>\u0010\u0013\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00080\u0010¢\u0006\u0002\u0008\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0016\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "TextSelectionBackgroundOpacity", "", "MaterialExpressiveTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialTheme", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MaterialThemeKt {

    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = null;
    public static final float TextSelectionBackgroundOpacity = 0.4f;
    static {
        MaterialThemeKt.LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf((Function0)MaterialThemeKt.LocalUsingExpressiveTheme.1.INSTANCE);
    }

    public static final void MaterialExpressiveTheme(androidx.compose.material3.ColorScheme colorScheme, androidx.compose.material3.Shapes shapes, androidx.compose.material3.Typography typography, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int traceInProgress;
        Object shapes2;
        Object provides;
        int $dirty;
        Object obj3;
        int $dirty2;
        boolean traceInProgress2;
        Object colorScheme2;
        Object rememberComposableLambda;
        Object obj4;
        int str2;
        int typography2;
        Object obj;
        Object obj2;
        Composer restartGroup;
        int i5;
        int i;
        Object iNSTANCE;
        int i6;
        int str;
        int i2;
        int i3;
        int i4;
        Composer $composer2;
        Object obj11;
        Object obj12;
        final int i18 = $changed;
        traceInProgress = -1399457222;
        Object obj5 = $composer;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(MaterialExpressiveTheme)P(!1,2,3)134@5791L7:MaterialTheme.kt#uh7d8r");
        $dirty = $changed;
        str2 = i7 & 1;
        if (str2 != null) {
            $dirty |= 6;
        } else {
            if (i18 & 6 == 0) {
                i5 = restartGroup.changed(colorScheme) ? 4 : 2;
                $dirty |= i5;
            }
        }
        i = i7 & 2;
        if (i != 0) {
            $dirty |= 48;
        } else {
            if (i18 & 48 == 0) {
                i6 = restartGroup.changed(shapes) ? 32 : 16;
                $dirty |= i6;
            }
        }
        str = i7 & 4;
        if (str != null) {
            $dirty |= 384;
        } else {
            if (i18 & 384 == 0) {
                i3 = restartGroup.changed(typography) ? 256 : 128;
                $dirty |= i3;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i18 & 3072 == 0) {
                i4 = restartGroup.changedInstance(content) ? 2048 : 1024;
                $dirty |= i4;
            }
        }
        int i19 = $dirty;
        if (i19 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (str2 != null) {
                    obj11 = 0;
                }
                if (i != 0) {
                    obj12 = 0;
                }
                i2 = str != null ? $dirty2 : typography;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i19, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:133)");
                }
                int i12 = 6;
                int i14 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if ((Boolean)restartGroup.consume((CompositionLocal)MaterialThemeKt.LocalUsingExpressiveTheme).booleanValue()) {
                    restartGroup.startReplaceGroup(547059915);
                    ComposerKt.sourceInformation(restartGroup, "135@5810L240");
                    restartGroup.startReplaceGroup(1126027167);
                    ComposerKt.sourceInformation(restartGroup, "136@5880L11");
                    int i10 = 6;
                    if (obj11 == null) {
                        colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(restartGroup, i10);
                    } else {
                        colorScheme2 = obj11;
                    }
                    restartGroup.endReplaceGroup();
                    restartGroup.startReplaceGroup(1126029309);
                    ComposerKt.sourceInformation(restartGroup, "137@5946L10");
                    if (i2 == 0) {
                        typography2 = MaterialTheme.INSTANCE.getTypography(restartGroup, i10);
                    } else {
                        typography2 = i2;
                    }
                    restartGroup.endReplaceGroup();
                    restartGroup.startReplaceGroup(1126031253);
                    ComposerKt.sourceInformation(restartGroup, "138@6003L6");
                    if (obj12 == null) {
                        shapes2 = MaterialTheme.INSTANCE.getShapes(restartGroup, i10);
                    } else {
                        shapes2 = obj12;
                    }
                    restartGroup.endReplaceGroup();
                    MaterialThemeKt.MaterialTheme(colorScheme2, shapes2, typography2, content, restartGroup, i19 & 7168, 0);
                    restartGroup.endReplaceGroup();
                } else {
                    $composer2 = restartGroup;
                    $composer2.startReplaceGroup(547327197);
                    ComposerKt.sourceInformation($composer2, "142@6138L412,142@6072L478");
                    int i13 = 1;
                    MaterialThemeKt.MaterialExpressiveTheme.1 anon = new MaterialThemeKt.MaterialExpressiveTheme.1(obj11, obj12, i2, content);
                    CompositionLocalKt.CompositionLocalProvider(MaterialThemeKt.LocalUsingExpressiveTheme.provides(Boolean.valueOf(i13)), (Function2)ComposableLambdaKt.rememberComposableLambda(2050809758, i13, anon, $composer2, 54), $composer2, $stable |= 48);
                    $composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = i2;
                obj3 = obj11;
                obj4 = obj12;
            } else {
                restartGroup.skipToGroupEnd();
                obj = typography;
                $composer2 = restartGroup;
                obj3 = colorScheme;
                obj4 = shapes;
            }
        } else {
        }
        obj11 = $composer2.endRestartGroup();
        if (obj11 != null) {
            traceInProgress = new MaterialThemeKt.MaterialExpressiveTheme.2(obj3, obj4, obj, content, i18, i7);
            obj11.updateScope((Function2)traceInProgress);
        }
    }

    public static final void MaterialTheme(androidx.compose.material3.ColorScheme colorScheme, androidx.compose.material3.Shapes shapes, androidx.compose.material3.Typography typography, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int anon;
        int $dirty;
        Object $dirty2;
        Object shapes3;
        Object colorScheme3;
        Object colorScheme2;
        Object obj;
        int changed2;
        Object rippleOrFallbackImplementation-9IZ8Weo;
        int shapes2;
        int changed3;
        Object typography2;
        boolean traceInProgress;
        int i3;
        int changed;
        int i;
        int skipping;
        int iNSTANCE;
        int defaultsInvalid;
        int iNSTANCE2;
        int iNSTANCE3;
        int i4;
        int i6;
        int i5;
        int i2;
        Object obj2;
        final Object obj5 = content;
        final int i11 = $changed;
        anon = -2127166334;
        final Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(MaterialTheme)P(!1,2,3)51@2364L11,52@2412L6,53@2463L10,56@2542L32,57@2601L40,67@3101L81,59@2681L501:MaterialTheme.kt#uh7d8r");
        int i10 = 4;
        final int i26 = 2;
        if (i11 & 6 == 0) {
            if (i7 & 1 == 0) {
                changed2 = restartGroup.changed(colorScheme) ? i10 : i26;
            } else {
                colorScheme3 = colorScheme;
            }
            $dirty |= changed2;
        } else {
            colorScheme3 = colorScheme;
        }
        if (i11 & 48 == 0) {
            if (i7 & 2 == 0) {
                changed3 = restartGroup.changed(shapes) ? 32 : 16;
            } else {
                rippleOrFallbackImplementation-9IZ8Weo = shapes;
            }
            $dirty |= changed3;
        } else {
            rippleOrFallbackImplementation-9IZ8Weo = shapes;
        }
        if (i11 & 384 == 0) {
            if (i7 & 4 == 0) {
                changed = restartGroup.changed(typography) ? 256 : 128;
            } else {
                typography2 = typography;
            }
            $dirty |= changed;
        } else {
            typography2 = typography;
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i11 & 3072 == 0) {
                i = restartGroup.changedInstance(obj5) ? 2048 : 1024;
                $dirty |= i;
            }
        }
        i4 = 1170;
        if ($dirty & 1171 == i4) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i2 = 6;
                if (i11 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i7 & 1 != 0) {
                            colorScheme3 = MaterialTheme.INSTANCE.getColorScheme(restartGroup, i2);
                            $dirty &= -15;
                        }
                        if (i7 & 2 != 0) {
                            rippleOrFallbackImplementation-9IZ8Weo = MaterialTheme.INSTANCE.getShapes(restartGroup, i2);
                            $dirty &= -113;
                        }
                        if (i7 & 4 != 0) {
                            shapes2 = $dirty4;
                            $dirty2 = obj8;
                            obj2 = typography2;
                        } else {
                            shapes2 = $dirty;
                            $dirty2 = obj9;
                            obj2 = typography2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 1 != 0) {
                            $dirty &= -15;
                        }
                        if (i7 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (i7 & 4 != 0) {
                            shapes2 = $dirty3;
                            $dirty2 = obj7;
                            obj2 = typography2;
                        } else {
                            shapes2 = $dirty;
                            $dirty2 = obj6;
                            obj2 = typography2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, shapes2, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:55)");
                }
                anon = shapes2;
                int i23 = 0;
                skipping = new ProvidedValue[i2];
                skipping[i23] = ColorSchemeKt.getLocalColorScheme().provides(colorScheme3);
                i6 = 1;
                skipping[i6] = IndicationKt.getLocalIndication().provides(RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, 0, 0, i4, restartGroup, i23));
                skipping[i26] = RippleThemeKt.getLocalRippleTheme().provides(CompatRippleTheme.INSTANCE);
                skipping[3] = ShapesKt.getLocalShapes().provides($dirty2);
                skipping[i10] = TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialThemeKt.rememberTextSelectionColors(colorScheme3, restartGroup, anon & 14));
                skipping[5] = TypographyKt.getLocalTypography().provides(obj2);
                MaterialThemeKt.MaterialTheme.1 anon2 = new MaterialThemeKt.MaterialTheme.1(obj2, obj5);
                CompositionLocalKt.CompositionLocalProvider(skipping, (Function2)ComposableLambdaKt.rememberComposableLambda(-1066563262, i6, anon2, restartGroup, 54), restartGroup, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorScheme2 = $dirty2;
                shapes3 = obj4;
                i3 = anon;
                obj = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                obj = typography2;
                i3 = $dirty;
                shapes3 = colorScheme3;
                colorScheme2 = rippleOrFallbackImplementation-9IZ8Weo;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new MaterialThemeKt.MaterialTheme.2(shapes3, colorScheme2, obj, obj5, i11, i7);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return MaterialThemeKt.LocalUsingExpressiveTheme;
    }

    public static final TextSelectionColors rememberTextSelectionColors(androidx.compose.material3.ColorScheme colorScheme, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i6;
        long primary-0d7_KjU;
        long l;
        Object empty;
        Object textSelectionColors;
        long copy-wmQWz5c$default;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TextSelectionColors textSelectionColors2;
        long l2;
        final Composer composer = $composer;
        int i7 = 1866455512;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(rememberTextSelectionColors)161@6816L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, $changed, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:159)");
        } else {
            i6 = $changed;
        }
        primary-0d7_KjU = colorScheme.getPrimary-0d7_KjU();
        ComposerKt.sourceInformationMarkerStart(composer, -1160063291, "CC(remember):MaterialTheme.kt#9igjgp");
        Composer composer2 = $composer;
        int i9 = 0;
        final Object rememberedValue = composer2.rememberedValue();
        final int i13 = 0;
        if (!composer.changed(primary-0d7_KjU)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i5 = 0;
                int i10 = 1053609165;
                i = 0;
                l = primary-0d7_KjU;
                TextSelectionColors primaryColor = textSelectionColors2;
                super(l, i10, Color.copy-wmQWz5c$default(primary-0d7_KjU, obj6, i10, 0, i, 0, 14), i, 0);
                primary-0d7_KjU = l2;
                composer2.updateRememberedValue(primaryColor);
            } else {
                textSelectionColors = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (TextSelectionColors)textSelectionColors;
    }
}
