package androidx.compose.material;

import androidx.compose.foundation.IndicationKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\u0008\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\u000c", d2 = {"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MaterialThemeKt {
    public static final void MaterialTheme(androidx.compose.material.Colors colors, androidx.compose.material.Typography typography, androidx.compose.material.Shapes shapes, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        Object anon;
        int $dirty;
        Object $dirty2;
        Object typography2;
        Object colors3;
        Object colors2;
        Object shapes2;
        Object obj;
        int changed2;
        Object rippleOrFallbackImplementation-9IZ8Weo;
        int typography3;
        int changed;
        Object shapes3;
        boolean traceInProgress;
        int changed3;
        int i6;
        int rememberTextSelectionColors;
        int iNSTANCE2;
        int defaultsInvalid;
        int iNSTANCE;
        int iNSTANCE3;
        ProvidedValue[] arr;
        int i9;
        Object $i$a$CacheMaterialThemeKt$MaterialTheme$rememberedColors$1;
        int i17;
        int i16;
        Object obj2;
        int i13;
        int i8;
        int i18;
        int i20;
        int i3;
        int i5;
        int i10;
        int i;
        int i14;
        int i15;
        int i11;
        int i12;
        int i2;
        int i19;
        int i21;
        int i4;
        final Object obj4 = content;
        final int i27 = $changed;
        anon = -891417079;
        final Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(MaterialTheme)P(!1,3,2)55@2741L6,56@2792L10,57@2839L6,*60@2914L184,65@3161L32,66@3220L45,70@3426L4,77@3778L113,68@3305L586:MaterialTheme.kt#jmzs0o");
        int i26 = 4;
        final int i47 = 2;
        if (i27 & 6 == 0) {
            if (i7 & 1 == 0) {
                changed2 = restartGroup.changed(colors) ? i26 : i47;
            } else {
                colors3 = colors;
            }
            $dirty |= changed2;
        } else {
            colors3 = colors;
        }
        if (i27 & 48 == 0) {
            if (i7 & 2 == 0) {
                changed = restartGroup.changed(typography) ? 32 : 16;
            } else {
                rippleOrFallbackImplementation-9IZ8Weo = typography;
            }
            $dirty |= changed;
        } else {
            rippleOrFallbackImplementation-9IZ8Weo = typography;
        }
        if (i27 & 384 == 0) {
            if (i7 & 4 == 0) {
                changed3 = restartGroup.changed(shapes) ? 256 : 128;
            } else {
                shapes3 = shapes;
            }
            $dirty |= changed3;
        } else {
            shapes3 = shapes;
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i27 & 3072 == 0) {
                i6 = restartGroup.changedInstance(obj4) ? 2048 : 1024;
                $dirty |= i6;
            }
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i16 = 6;
                if (i27 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i7 & 1 != 0) {
                            colors3 = MaterialTheme.INSTANCE.getColors(restartGroup, i16);
                            $dirty &= -15;
                        }
                        if (i7 & 2 != 0) {
                            rippleOrFallbackImplementation-9IZ8Weo = MaterialTheme.INSTANCE.getTypography(restartGroup, i16);
                            $dirty &= -113;
                        }
                        if (i7 & 4 != 0) {
                            typography3 = $dirty4;
                            $dirty2 = obj7;
                            obj2 = colors3;
                            colors2 = shapes3;
                        } else {
                            typography3 = $dirty;
                            $dirty2 = obj8;
                            obj2 = colors3;
                            colors2 = shapes3;
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
                            typography3 = $dirty3;
                            $dirty2 = obj6;
                            obj2 = colors3;
                            colors2 = shapes3;
                        } else {
                            typography3 = $dirty;
                            $dirty2 = obj5;
                            obj2 = colors3;
                            colors2 = shapes3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, typography3, -1, "androidx.compose.material.MaterialTheme (MaterialTheme.kt:59)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 586107060, "CC(remember):MaterialTheme.kt#9igjgp");
                int i23 = 0;
                Composer composer = restartGroup;
                int i39 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i42 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i44 = 0;
                    composer.updateRememberedValue(Colors.copy-pvPzIIM$default(obj2, 0, obj17, 0, obj19, 0, obj21, 0, obj23, 0, obj25, 0, obj27, false, obj29, 0));
                } else {
                    $i$a$CacheMaterialThemeKt$MaterialTheme$rememberedColors$1 = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                anon = $i$a$CacheMaterialThemeKt$MaterialTheme$rememberedColors$1;
                int i31 = 0;
                ColorsKt.updateColorsFrom(anon, obj2);
                i8 = i45;
                int i33 = 0;
                arr = new ProvidedValue[7];
                arr[i33] = ColorsKt.getLocalColors().provides(anon);
                i9 = 1;
                arr[i9] = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(restartGroup, i16)));
                arr[i47] = IndicationKt.getLocalIndication().provides(RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, 0, 0, rememberedValue, restartGroup, 0));
                arr[3] = RippleThemeKt.getLocalRippleTheme().provides(CompatRippleTheme.INSTANCE);
                arr[i26] = ShapesKt.getLocalShapes().provides(colors2);
                arr[5] = TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(anon, restartGroup, i33));
                arr[i16] = TypographyKt.getLocalTypography().provides($dirty2);
                MaterialThemeKt.MaterialTheme.1 anon2 = new MaterialThemeKt.MaterialTheme.1($dirty2, obj4);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-1740102967, i9, anon2, restartGroup, 54), restartGroup, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = colors2;
                shapes2 = $dirty2;
                typography2 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                i8 = $dirty;
                typography2 = colors3;
                shapes2 = rippleOrFallbackImplementation-9IZ8Weo;
                obj = shapes3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new MaterialThemeKt.MaterialTheme.2(typography2, shapes2, obj, obj4, i27, i7);
            endRestartGroup.updateScope((Function2)anon);
        }
    }
}
