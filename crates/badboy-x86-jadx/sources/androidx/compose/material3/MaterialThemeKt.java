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
        int $dirty2;
        Object obj;
        int $dirty;
        boolean traceInProgress2;
        Object colorScheme2;
        Object rememberComposableLambda;
        Object obj2;
        int str;
        int typography2;
        Object obj3;
        Object obj4;
        Composer restartGroup;
        int i2;
        int i5;
        Object iNSTANCE;
        int i6;
        int str2;
        int i3;
        int i4;
        int i;
        Composer $composer2;
        Object obj11;
        Object obj12;
        final int i18 = $changed;
        traceInProgress = -1399457222;
        Object obj5 = $composer;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(MaterialExpressiveTheme)P(!1,2,3)134@5791L7:MaterialTheme.kt#uh7d8r");
        $dirty2 = $changed;
        str = i7 & 1;
        if (str != null) {
            $dirty2 |= 6;
        } else {
            if (i18 & 6 == 0) {
                i2 = restartGroup.changed(colorScheme) ? 4 : 2;
                $dirty2 |= i2;
            }
        }
        i5 = i7 & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
        } else {
            if (i18 & 48 == 0) {
                i6 = restartGroup.changed(shapes) ? 32 : 16;
                $dirty2 |= i6;
            }
        }
        str2 = i7 & 4;
        if (str2 != null) {
            $dirty2 |= 384;
        } else {
            if (i18 & 384 == 0) {
                i4 = restartGroup.changed(typography) ? 256 : 128;
                $dirty2 |= i4;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (i18 & 3072 == 0) {
                i = restartGroup.changedInstance(content) ? 2048 : 1024;
                $dirty2 |= i;
            }
        }
        int i19 = $dirty2;
        if (i19 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    obj11 = 0;
                }
                if (i5 != 0) {
                    obj12 = 0;
                }
                i3 = str2 != null ? $dirty : typography;
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
                    if (i3 == 0) {
                        typography2 = MaterialTheme.INSTANCE.getTypography(restartGroup, i10);
                    } else {
                        typography2 = i3;
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
                    MaterialThemeKt.MaterialExpressiveTheme.1 anon = new MaterialThemeKt.MaterialExpressiveTheme.1(obj11, obj12, i3, content);
                    CompositionLocalKt.CompositionLocalProvider(MaterialThemeKt.LocalUsingExpressiveTheme.provides(Boolean.valueOf(i13)), (Function2)ComposableLambdaKt.rememberComposableLambda(2050809758, i13, anon, $composer2, 54), $composer2, $stable |= 48);
                    $composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = i3;
                obj = obj11;
                obj2 = obj12;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = typography;
                $composer2 = restartGroup;
                obj = colorScheme;
                obj2 = shapes;
            }
        } else {
        }
        obj11 = $composer2.endRestartGroup();
        if (obj11 != null) {
            traceInProgress = new MaterialThemeKt.MaterialExpressiveTheme.2(obj, obj2, obj3, content, i18, i7);
            obj11.updateScope((Function2)traceInProgress);
        }
    }

    public static final void MaterialTheme(androidx.compose.material3.ColorScheme colorScheme, androidx.compose.material3.Shapes shapes, androidx.compose.material3.Typography typography, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int anon;
        int $dirty2;
        Object $dirty;
        Object shapes2;
        Object colorScheme3;
        Object colorScheme2;
        Object obj;
        int changed;
        Object rippleOrFallbackImplementation-9IZ8Weo;
        int shapes3;
        int changed3;
        Object typography2;
        boolean traceInProgress;
        int i;
        int changed2;
        int i6;
        int skipping;
        int iNSTANCE3;
        int defaultsInvalid;
        int iNSTANCE;
        int iNSTANCE2;
        int i5;
        int i2;
        int i3;
        int i4;
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
                changed = restartGroup.changed(colorScheme) ? i10 : i26;
            } else {
                colorScheme3 = colorScheme;
            }
            $dirty2 |= changed;
        } else {
            colorScheme3 = colorScheme;
        }
        if (i11 & 48 == 0) {
            if (i7 & 2 == 0) {
                changed3 = restartGroup.changed(shapes) ? 32 : 16;
            } else {
                rippleOrFallbackImplementation-9IZ8Weo = shapes;
            }
            $dirty2 |= changed3;
        } else {
            rippleOrFallbackImplementation-9IZ8Weo = shapes;
        }
        if (i11 & 384 == 0) {
            if (i7 & 4 == 0) {
                changed2 = restartGroup.changed(typography) ? 256 : 128;
            } else {
                typography2 = typography;
            }
            $dirty2 |= changed2;
        } else {
            typography2 = typography;
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (i11 & 3072 == 0) {
                i6 = restartGroup.changedInstance(obj5) ? 2048 : 1024;
                $dirty2 |= i6;
            }
        }
        i5 = 1170;
        if ($dirty2 & 1171 == i5) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i4 = 6;
                if (i11 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i7 & 1 != 0) {
                            colorScheme3 = MaterialTheme.INSTANCE.getColorScheme(restartGroup, i4);
                            $dirty2 &= -15;
                        }
                        if (i7 & 2 != 0) {
                            rippleOrFallbackImplementation-9IZ8Weo = MaterialTheme.INSTANCE.getShapes(restartGroup, i4);
                            $dirty2 &= -113;
                        }
                        if (i7 & 4 != 0) {
                            shapes3 = $dirty4;
                            $dirty = obj8;
                            obj2 = typography2;
                        } else {
                            shapes3 = $dirty2;
                            $dirty = obj9;
                            obj2 = typography2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 1 != 0) {
                            $dirty2 &= -15;
                        }
                        if (i7 & 2 != 0) {
                            $dirty2 &= -113;
                        }
                        if (i7 & 4 != 0) {
                            shapes3 = $dirty3;
                            $dirty = obj7;
                            obj2 = typography2;
                        } else {
                            shapes3 = $dirty2;
                            $dirty = obj6;
                            obj2 = typography2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, shapes3, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:55)");
                }
                anon = shapes3;
                int i23 = 0;
                skipping = new ProvidedValue[i4];
                skipping[i23] = ColorSchemeKt.getLocalColorScheme().provides(colorScheme3);
                i2 = 1;
                skipping[i2] = IndicationKt.getLocalIndication().provides(RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, 0, 0, i5, restartGroup, i23));
                skipping[i26] = RippleThemeKt.getLocalRippleTheme().provides(CompatRippleTheme.INSTANCE);
                skipping[3] = ShapesKt.getLocalShapes().provides($dirty);
                skipping[i10] = TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialThemeKt.rememberTextSelectionColors(colorScheme3, restartGroup, anon & 14));
                skipping[5] = TypographyKt.getLocalTypography().provides(obj2);
                MaterialThemeKt.MaterialTheme.1 anon2 = new MaterialThemeKt.MaterialTheme.1(obj2, obj5);
                CompositionLocalKt.CompositionLocalProvider(skipping, (Function2)ComposableLambdaKt.rememberComposableLambda(-1066563262, i2, anon2, restartGroup, 54), restartGroup, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                colorScheme2 = $dirty;
                shapes2 = obj4;
                i = anon;
                obj = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                obj = typography2;
                i = $dirty2;
                shapes2 = colorScheme3;
                colorScheme2 = rippleOrFallbackImplementation-9IZ8Weo;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new MaterialThemeKt.MaterialTheme.2(shapes2, colorScheme2, obj, obj5, i11, i7);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return MaterialThemeKt.LocalUsingExpressiveTheme;
    }

    public static final TextSelectionColors rememberTextSelectionColors(androidx.compose.material3.ColorScheme colorScheme, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i5;
        long primary-0d7_KjU;
        long l;
        Object empty;
        Object textSelectionColors2;
        long copy-wmQWz5c$default;
        int i4;
        int i3;
        int i;
        int i6;
        int i2;
        TextSelectionColors textSelectionColors;
        long l2;
        final Composer composer = $composer;
        int i7 = 1866455512;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(rememberTextSelectionColors)161@6816L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, $changed, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:159)");
        } else {
            i5 = $changed;
        }
        primary-0d7_KjU = colorScheme.getPrimary-0d7_KjU();
        ComposerKt.sourceInformationMarkerStart(composer, -1160063291, "CC(remember):MaterialTheme.kt#9igjgp");
        Composer composer2 = $composer;
        int i9 = 0;
        final Object rememberedValue = composer2.rememberedValue();
        final int i13 = 0;
        if (!composer.changed(primary-0d7_KjU)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i2 = 0;
                int i10 = 1053609165;
                i4 = 0;
                l = primary-0d7_KjU;
                TextSelectionColors primaryColor = textSelectionColors;
                super(l, i10, Color.copy-wmQWz5c$default(primary-0d7_KjU, obj6, i10, 0, i4, 0, 14), i4, 0);
                primary-0d7_KjU = l2;
                composer2.updateRememberedValue(primaryColor);
            } else {
                textSelectionColors2 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (TextSelectionColors)textSelectionColors2;
    }
}
