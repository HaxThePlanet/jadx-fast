package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.DpSize.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001ao\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\u0008\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0015\u0008\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\u0008\u00112\u0015\u0008\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\u0008\u00112\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\u0008\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001aH\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0003ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"PlainTooltip", "", "Landroidx/compose/material3/TooltipScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip-7QI4Sbk", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-yDvdmqw", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawCaretWithPath", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "caretType", "Landroidx/compose/material3/CaretType;", "density", "Landroidx/compose/ui/unit/Density;", "configuration", "Landroid/content/res/Configuration;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "drawCaretWithPath-JKu-mZY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/material3/CaretType;Landroidx/compose/ui/unit/Density;Landroid/content/res/Configuration;JJLandroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/draw/DrawResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Tooltip_androidKt {
    public static final void PlainTooltip-7QI4Sbk(androidx.compose.material3.TooltipScope $this$PlainTooltip_u2d7QI4Sbk, Modifier modifier, long caretSize, Shape shape, long contentColor, long containerColor, float tonalElevation, float shadowElevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i12) {
        float f3;
        int i7;
        boolean traceInProgress2;
        Object endRestartGroup;
        int $this$dp$iv2;
        int defaultsInvalid;
        int companion3;
        int plainTooltipContainerShape;
        int shape3;
        int $this$dp$iv;
        Object $composer2;
        int $dirty3;
        long $dirty;
        long $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1;
        int i20;
        int i13;
        int i5;
        boolean changedInstance;
        Object anon;
        Object modifier2;
        int i3;
        int i;
        int changed3;
        Object shape2;
        long l;
        int $i$f$isSpecifiedEaSLcWc;
        int i8;
        boolean density;
        long containerColor2;
        long obj;
        long l2;
        int changed;
        int this_$iv;
        boolean traceInProgress;
        int changed2;
        long plainTooltipContentColor;
        float contentColor2;
        float f2;
        int companion2;
        int i14;
        int changed4;
        int changed5;
        float str;
        int $dirty2;
        int i15;
        int i17;
        int i4;
        Object modifier3;
        int i6;
        int companion;
        int i10;
        int i9;
        int i11;
        int i19;
        int i21;
        int i18;
        float f;
        int caretSize2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i2;
        int i16;
        androidx.compose.material3.Tooltip_androidKt.PlainTooltip.drawCaretModifier.1.1 obj29;
        Object obj30;
        Object obj31;
        long obj32;
        long obj34;
        Object obj36;
        int obj38;
        final Object obj2 = $this$PlainTooltip_u2d7QI4Sbk;
        final Object obj4 = i12;
        companion2 = obj41;
        i14 = obj42;
        Composer restartGroup = obj40.startRestartGroup(1407069716);
        ComposerKt.sourceInformation(restartGroup, "C(PlainTooltip)P(4,0:c#ui.unit.DpSize,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)208@8412L26,209@8482L24,211@8552L26,96@3876L606,90@3685L797:Tooltip.android.kt#uh7d8r");
        $dirty3 = obj41;
        if (i42 &= i14 != 0) {
            $dirty3 |= 6;
        } else {
            if (companion2 & 6 == 0) {
                if (companion2 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj2);
                } else {
                    changedInstance = restartGroup.changedInstance(obj2);
                }
                i20 = changedInstance != null ? 4 : 2;
                $dirty3 |= i20;
            }
        }
        int i43 = i14 & 1;
        if (i43 != 0) {
            $dirty3 |= 48;
            anon = modifier;
        } else {
            if (companion2 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i3;
            } else {
                anon = modifier;
            }
        }
        if (companion2 & 384 == 0) {
            if (i14 & 2 == 0) {
                i = restartGroup.changed(caretSize) ? 256 : 128;
            } else {
                obj = caretSize;
            }
            $dirty3 |= i;
        } else {
            obj = caretSize;
        }
        if (companion2 & 3072 == 0) {
            if (i14 & 4 == 0) {
                changed2 = restartGroup.changed(contentColor) ? 2048 : 1024;
            } else {
                shape2 = contentColor;
            }
            $dirty3 |= changed2;
        } else {
            shape2 = contentColor;
        }
        if (companion2 & 24576 == 0) {
            if (i14 & 8 == 0) {
                changed5 = restartGroup.changed(containerColor) ? 16384 : 8192;
            } else {
                plainTooltipContentColor = containerColor;
            }
            $dirty3 |= changed5;
        } else {
            plainTooltipContentColor = containerColor;
        }
        int i60 = 196608;
        final int obj40 = i60;
        if (companion2 & i60 == 0) {
            if (i14 & 16 == 0) {
                changed = restartGroup.changed(shadowElevation) ? 131072 : 65536;
            } else {
                containerColor2 = shadowElevation;
            }
            $dirty3 |= changed;
        } else {
            containerColor2 = shadowElevation;
        }
        this_$iv = i14 & 32;
        companion = 1572864;
        if (this_$iv != 0) {
            $dirty3 |= companion;
            str = $composer;
        } else {
            if (companion2 & companion == 0) {
                i10 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty3 |= i10;
            } else {
                str = $composer;
            }
        }
        i9 = i14 & 64;
        i11 = 12582912;
        if (i9 != 0) {
            $dirty3 |= i11;
            f3 = $changed;
        } else {
            if (companion2 & i11 == 0) {
                i21 = restartGroup.changed($changed) ? 8388608 : 4194304;
                $dirty3 |= i21;
            } else {
                f3 = $changed;
            }
        }
        int i67 = 100663296;
        if (i14 & 128 != 0) {
            $dirty3 |= i67;
        } else {
            if (companion2 & i67 == 0) {
                i7 = restartGroup.changedInstance(obj4) ? 67108864 : 33554432;
                $dirty3 |= i7;
            }
        }
        if (i23 &= $dirty3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i5 = -458753;
                int i69 = -57345;
                if (companion2 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i43 != 0) {
                            anon = defaultsInvalid;
                        }
                        if (i14 & 2 != 0) {
                            caretSize2 = DpSize.Companion.getUnspecified-MYxV2XQ();
                            $dirty3 &= -897;
                        } else {
                            caretSize2 = caretSize;
                        }
                        i5 = 6;
                        if (i14 & 4 != 0) {
                            $dirty3 &= -7169;
                            shape2 = plainTooltipContainerShape;
                        }
                        if (i14 & 8 != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(restartGroup, i5);
                            $dirty3 &= i69;
                        }
                        if (i14 & 16 != 0) {
                            containerColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(restartGroup, i5);
                            $dirty3 &= i68;
                        }
                        if (this_$iv != 0) {
                            i5 = 0;
                            str = $this$dp$iv;
                        }
                        if (i9 != 0) {
                            i5 = 0;
                            f = $this$dp$iv3;
                            $this$dp$iv2 = $dirty3;
                            i18 = str;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = caretSize2;
                        } else {
                            f = $changed;
                            $this$dp$iv2 = $dirty3;
                            i18 = str;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = caretSize2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i14 & 2 != 0) {
                            $dirty3 &= -897;
                        }
                        if (i14 & 4 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i14 & 8 != 0) {
                            $dirty3 &= i69;
                        }
                        if (i14 & 16 != 0) {
                            $this$dp$iv2 = $dirty3 & i5;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = caretSize;
                            f = $changed;
                            i18 = str;
                        } else {
                            f = $changed;
                            $this$dp$iv2 = $dirty3;
                            i18 = str;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = caretSize;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    obj36 = shape2;
                    ComposerKt.traceEventStart(1407069716, $this$dp$iv2, -1, "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:73)");
                } else {
                    obj36 = shape2;
                }
                restartGroup.startReplaceGroup(-333850415);
                ComposerKt.sourceInformation(restartGroup, "76@3183L7,77@3242L7,78@3281L343");
                int i49 = 0;
                $i$f$isSpecifiedEaSLcWc = Long.compare(l3, l4) != 0 ? 1 : 0;
                if ($i$f$isSpecifiedEaSLcWc != 0) {
                    int i66 = 0;
                    obj30 = i53;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv2 = consume;
                    int i62 = 0;
                    i9 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    this_$iv = consume2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -333845325, "CC(remember):Tooltip.android.kt#9igjgp");
                    obj30 = this_$iv2;
                    if (i64 ^= obj40 > 131072) {
                        if (!restartGroup.changed(containerColor2)) {
                            i8 = $this$dp$iv2 & obj40 == 131072 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    if (i59 ^= 384 > 256) {
                        if (!restartGroup.changed($i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1)) {
                            i17 = $this$dp$iv2 & 384 == 256 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    i14 = restartGroup;
                    int i65 = 0;
                    obj38 = $this$dp$iv2;
                    Object rememberedValue = i14.rememberedValue();
                    i6 = 0;
                    if (i50 |= i17 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int caretSize3 = 0;
                            obj29 = anon3;
                            obj32 = containerColor2;
                            super(obj30, this_$iv, obj32, containerColor, obj34, shadowElevation);
                            i5 = obj30;
                            companion = obj32;
                            containerColor2 = obj34;
                            i14.updateRememberedValue((Function2)obj29);
                        } else {
                            i5 = obj30;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = rememberedValue;
                            companion = containerColor2;
                            containerColor2 = obj34;
                        }
                    } else {
                        obj34 = $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    modifier3 = $this$dp$iv2;
                } else {
                    obj38 = $this$dp$iv2;
                    companion = containerColor2;
                    containerColor2 = $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1;
                    modifier3 = anon;
                }
                restartGroup.endReplaceGroup();
                Tooltip_androidKt.PlainTooltip.1 anon2 = new Tooltip_androidKt.PlainTooltip.1(plainTooltipContentColor, obj11, obj4);
                i6 = obj36;
                SurfaceKt.Surface-T9BRK9s(modifier3, i6, companion, i9, 0, i19, i18, f, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1430116975, true, anon2, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = obj38;
                $composer2 = anon;
                $dirty = containerColor2;
                l = plainTooltipContentColor;
                modifier2 = i6;
                l2 = companion;
                contentColor2 = i18;
                f2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = anon;
                modifier2 = shape2;
                l2 = containerColor2;
                l = plainTooltipContentColor;
                contentColor2 = str;
                f2 = $changed;
                $dirty2 = $dirty3;
                $dirty = caretSize;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            obj29 = $dirty2;
            endRestartGroup = new Tooltip_androidKt.PlainTooltip.2(obj2, $composer2, $dirty, i13, modifier2, l, containerColor2, l2, this_$iv, contentColor2, f2, obj4, obj41, obj42);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj29 = $dirty2;
        }
    }

    public static final void RichTooltip-yDvdmqw(androidx.compose.material3.TooltipScope $this$RichTooltip_u2dyDvdmqw, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> action, long caretSize, Shape shape, androidx.compose.material3.RichTooltipColors colors, float tonalElevation, float shadowElevation, Function2<? super Composer, ? super Integer, Unit> text, Composer $composer, int $changed, int i13) {
        Object obj4;
        float f6;
        float f4;
        int i14;
        Modifier colors2;
        int i6;
        int defaultsInvalid;
        int i15;
        int richTooltipContainerShape;
        androidx.compose.material3.RichTooltipColors $dirty5;
        int i17;
        int changed4;
        Object $composer2;
        androidx.compose.material3.Tooltip_androidKt.RichTooltip.drawCaretModifier.1.1 $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1;
        int $dirty;
        Object colors4;
        int i18;
        Object colorScheme;
        int i16;
        Object $dirty2;
        int i3;
        float tonalElevation3;
        int tonalElevation2;
        boolean changedInstance;
        Object modifier2;
        long modifier3;
        int i;
        Composer containerElevation-D9Ej5fM;
        boolean traceInProgress;
        Object f3;
        Object title2;
        int i2;
        androidx.compose.material3.RichTooltipColors richTooltipColors;
        int str;
        Object $i$f$getCurrent;
        Object obj3;
        float action2;
        int i21;
        int i8;
        boolean changed2;
        Object obj;
        float f5;
        androidx.compose.material3.Tooltip_androidKt.RichTooltip.drawCaretModifier.1.1 this_$iv;
        int companion;
        int i19;
        int i4;
        long sizeIn-qDBjuR0$default;
        Object obj2;
        int changed3;
        int containerColor-0d7_KjU;
        int l;
        int changed;
        int i7;
        int i9;
        int i5;
        int companion2;
        int i11;
        int $dirty3;
        float $dirty4;
        float f;
        int i10;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i20;
        int i12;
        float f2;
        androidx.compose.material3.RichTooltipColors colors3;
        long l2;
        long l3;
        Modifier obj34;
        float obj35;
        float obj36;
        float obj37;
        int obj38;
        int obj39;
        int obj40;
        Object obj41;
        int obj44;
        final Object obj5 = $this$RichTooltip_u2dyDvdmqw;
        final Object obj6 = $composer;
        companion = i13;
        i19 = obj46;
        Composer restartGroup = $changed.startRestartGroup(1867454921);
        ComposerKt.sourceInformation(restartGroup, "C(RichTooltip)P(3,7!1,1:c#ui.unit.DpSize,5!1,8:c#ui.unit.Dp,4:c#ui.unit.Dp)255@9959L25,257@10034L19,*148@5873L7,150@5944L11,150@5956L61,178@6991L1595,167@6622L1964:Tooltip.android.kt#uh7d8r");
        $dirty = i13;
        if (i37 &= i19 != 0) {
            $dirty |= 6;
        } else {
            if (companion & 6 == 0) {
                if (companion & 8 == 0) {
                    changedInstance = restartGroup.changed(obj5);
                } else {
                    changedInstance = restartGroup.changedInstance(obj5);
                }
                i16 = changedInstance != null ? 4 : 2;
                $dirty |= i16;
            }
        }
        i3 = i19 & 1;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else {
            if (companion & 48 == 0) {
                i = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i;
            } else {
                modifier2 = modifier;
            }
        }
        containerElevation-D9Ej5fM = i19 & 2;
        if (containerElevation-D9Ej5fM != 0) {
            $dirty |= 384;
            f3 = title;
        } else {
            if (companion & 384 == 0) {
                i2 = restartGroup.changedInstance(title) ? 256 : 128;
                $dirty |= i2;
            } else {
                f3 = title;
            }
        }
        str = i19 & 4;
        if (str != null) {
            $dirty |= 3072;
            obj3 = action;
        } else {
            if (companion & 3072 == 0) {
                i21 = restartGroup.changedInstance(action) ? 2048 : 1024;
                $dirty |= i21;
            } else {
                obj3 = action;
            }
        }
        if (companion & 24576 == 0) {
            if (i19 & 8 == 0) {
                i8 = restartGroup.changed(caretSize) ? 16384 : 8192;
            } else {
                sizeIn-qDBjuR0$default = caretSize;
            }
            $dirty |= i8;
        } else {
            sizeIn-qDBjuR0$default = caretSize;
        }
        if (i50 &= companion == 0) {
            if (i19 & 16 == 0) {
                changed3 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                obj = colors;
            }
            $dirty |= changed3;
        } else {
            obj = colors;
        }
        if (companion & i63 == 0) {
            if (i19 & 32 == 0) {
                changed = restartGroup.changed(tonalElevation) ? 1048576 : 524288;
            } else {
                obj4 = tonalElevation;
            }
            $dirty |= changed;
        } else {
            obj4 = tonalElevation;
        }
        i7 = i19 & 64;
        i9 = 12582912;
        if (i7 != 0) {
            $dirty |= i9;
            f6 = shadowElevation;
        } else {
            if (companion & i9 == 0) {
                i5 = restartGroup.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                f6 = shadowElevation;
            }
        }
        int i23 = i19 & 128;
        int i69 = 100663296;
        if (i23 != 0) {
            $dirty |= i69;
            companion2 = i23;
            f4 = text;
        } else {
            if (companion & i69 == 0) {
                companion2 = i23;
                i11 = restartGroup.changed(text) ? 67108864 : 33554432;
                $dirty |= i11;
            } else {
                companion2 = i23;
                f4 = text;
            }
        }
        int i72 = 805306368;
        if (i19 & 256 != 0) {
            $dirty |= i72;
        } else {
            if (companion & i72 == 0) {
                i14 = restartGroup.changedInstance(obj6) ? 536870912 : 268435456;
                $dirty |= i14;
            }
        }
        $dirty3 = $dirty;
        if (i24 &= $dirty == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i73 = -57345;
                int i76 = -458753;
                i18 = 6;
                if (companion & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i3 != 0) {
                            modifier2 = defaultsInvalid;
                        }
                        if (containerElevation-D9Ej5fM != 0) {
                            f3 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj3 = defaultsInvalid;
                        }
                        if (i19 & 8 != 0) {
                            sizeIn-qDBjuR0$default = DpSize.Companion.getUnspecified-MYxV2XQ();
                            $dirty3 = i15;
                        }
                        if (i19 & 16 != 0) {
                            $dirty3 &= i76;
                            obj = richTooltipContainerShape;
                        }
                        if (i19 & 32 != 0) {
                            $dirty5 = TooltipDefaults.INSTANCE.richTooltipColors(restartGroup, i18);
                            $dirty3 &= i3;
                        } else {
                            $dirty5 = tonalElevation;
                        }
                        if (i7 != 0) {
                            tonalElevation3 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
                        } else {
                            tonalElevation3 = shadowElevation;
                        }
                        if (companion2 != 0) {
                            $dirty4 = tonalElevation3;
                            tonalElevation2 = i75;
                            f = containerElevation-D9Ej5fM;
                        } else {
                            $dirty4 = tonalElevation3;
                            tonalElevation2 = i74;
                            f = text;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i19 & 8 != 0) {
                            $dirty3 = i6;
                        }
                        if (i19 & 16 != 0) {
                            $dirty3 &= i76;
                        }
                        if (i19 & 32 != 0) {
                            $dirty4 = shadowElevation;
                            f = text;
                            tonalElevation2 = i28;
                            $dirty5 = tonalElevation;
                        } else {
                            $dirty5 = tonalElevation;
                            f = text;
                            tonalElevation2 = $dirty3;
                            $dirty4 = shadowElevation;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1867454921, tonalElevation2, -1, "androidx.compose.material3.RichTooltip (Tooltip.android.kt:147)");
                }
                obj34 = i40;
                obj35 = i43;
                $i$f$getCurrent = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, $i$f$getCurrent);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i64 = 0;
                obj37 = arg0$iv;
                colorScheme = MaterialTheme.INSTANCE.getColorScheme(restartGroup, 6);
                obj38 = restartGroup;
                $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1 = ColorSchemeKt.applyTonalElevation-RFCenO8(colorScheme, $dirty5.getContainerColor-0d7_KjU(), action, obj37, obj38);
                f2 = obj37;
                containerElevation-D9Ej5fM = obj38;
                containerElevation-D9Ej5fM.startReplaceGroup(1472746423);
                ComposerKt.sourceInformation(containerElevation-D9Ej5fM, "153@6122L7,154@6181L7,155@6220L341");
                obj34 = this_$iv;
                companion2 = Long.compare(l, l4) != 0 ? 1 : 0;
                if (companion2 != 0) {
                    int i65 = 0;
                    int i67 = 0;
                    ComposerKt.sourceInformationMarkerStart(containerElevation-D9Ej5fM, 2023513938, $i$f$getCurrent);
                    ComposerKt.sourceInformationMarkerEnd(containerElevation-D9Ej5fM);
                    this_$iv = consume;
                    int i66 = 0;
                    int i68 = 0;
                    ComposerKt.sourceInformationMarkerStart(containerElevation-D9Ej5fM, 2023513938, $i$f$getCurrent);
                    $i$f$getCurrent = containerElevation-D9Ej5fM.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalConfiguration());
                    ComposerKt.sourceInformationMarkerEnd(containerElevation-D9Ej5fM);
                    colors3 = $dirty5;
                    ComposerKt.sourceInformationMarkerStart(containerElevation-D9Ej5fM, 1472751513, "CC(remember):Tooltip.android.kt#9igjgp");
                    if (i62 ^= 24576 > 16384) {
                        if (!containerElevation-D9Ej5fM.changed(sizeIn-qDBjuR0$default)) {
                            i17 = tonalElevation2 & 24576 == 16384 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    i19 = containerElevation-D9Ej5fM;
                    l = 0;
                    Object rememberedValue = i19.rememberedValue();
                    i7 = 0;
                    if (obj34 | i17 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int elevatedColor = 0;
                            obj34 = anon2;
                            obj35 = this_$iv;
                            obj39 = sizeIn-qDBjuR0$default;
                            super(obj35, $i$f$getCurrent, obj37, obj38, obj39, tonalElevation);
                            colorScheme = obj35;
                            l2 = obj37;
                            l3 = obj39;
                            i19.updateRememberedValue((Function2)obj34);
                        } else {
                            l2 = obj37;
                            $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1 = rememberedValue;
                            colorScheme = this_$iv;
                            l3 = sizeIn-qDBjuR0$default;
                        }
                    } else {
                        obj37 = $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1;
                    }
                    ComposerKt.sourceInformationMarkerEnd(containerElevation-D9Ej5fM);
                    colors2 = obj5.drawCaret((Modifier)Modifier.Companion, (Function2)$i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1).then(modifier2);
                } else {
                    colors3 = $dirty5;
                    l2 = $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1;
                    l3 = sizeIn-qDBjuR0$default;
                    colors2 = modifier2;
                }
                containerElevation-D9Ej5fM.endReplaceGroup();
                androidx.compose.material3.RichTooltipColors richTooltipColors2 = colors3;
                Tooltip_androidKt.RichTooltip.1 anon = new Tooltip_androidKt.RichTooltip.1(f3, obj3, richTooltipColors2, obj6);
                obj2 = obj41;
                SurfaceKt.Surface-T9BRK9s(SizeKt.sizeIn-qDBjuR0$default(colors2, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0, 8, 0), obj2, colors3.getContainerColor-0d7_KjU(), i7, 0, companion2, $dirty4, f, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(317290958, true, anon, containerElevation-D9Ej5fM, 54), containerElevation-D9Ej5fM);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty3 = tonalElevation2;
                $dirty2 = obj3;
                action2 = f7;
                richTooltipColors = richTooltipColors2;
                $composer2 = modifier2;
                colors4 = f3;
                title2 = obj2;
                f5 = f;
                modifier3 = l3;
            } else {
                restartGroup.skipToGroupEnd();
                richTooltipColors = tonalElevation;
                composer = restartGroup;
                $composer2 = modifier2;
                colors4 = f3;
                $dirty2 = obj3;
                title2 = obj;
                modifier3 = sizeIn-qDBjuR0$default;
                action2 = shadowElevation;
                f5 = text;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            colors2 = new Tooltip_androidKt.RichTooltip.2(obj5, $composer2, colors4, $dirty2, modifier3, containerElevation-D9Ej5fM, title2, richTooltipColors, action2, f5, obj6, i13, obj46);
            endRestartGroup.updateScope((Function2)colors2);
        }
    }

    public static final DrawResult access$drawCaretWithPath-JKu-mZY(CacheDrawScope $receiver, androidx.compose.material3.CaretType caretType, Density density, Configuration configuration, long containerColor, long caretSize, LayoutCoordinates anchorLayoutCoordinates) {
        return Tooltip_androidKt.drawCaretWithPath-JKu-mZY($receiver, caretType, density, configuration, containerColor, caretSize, anchorLayoutCoordinates);
    }

    private static final DrawResult drawCaretWithPath-JKu-mZY(CacheDrawScope $this$drawCaretWithPath_u2dJKu_u2dmZY, androidx.compose.material3.CaretType caretType, Density density, Configuration configuration, long containerColor, long caretSize, LayoutCoordinates anchorLayoutCoordinates) {
        int caretHeightPx;
        float caretY3;
        Path caretY2;
        int y-impl;
        int tooltipAnchorSpacing;
        float y-impl2;
        Rect boundsInWindow;
        float left;
        Object obj;
        float right;
        float top;
        int i4;
        float f;
        int i8;
        int i;
        float width-impl;
        float height-impl;
        int i2;
        int i3;
        float f3;
        long anchorMidFromRightScreenEdge;
        int f2;
        float caretY;
        int i5;
        int i6;
        long preferredPosition;
        int i7;
        final LayoutCoordinates layoutCoordinates = obj33;
        final Path path = AndroidPath_androidKt.Path();
        if (layoutCoordinates != null) {
            int i9 = 0;
            int i10 = 0;
            int i16 = 0;
            int i21 = 0;
            Rect obj3 = density;
            int i36 = 0;
            caretHeightPx = obj3.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(anchorLayoutCoordinates));
            int i37 = 0;
            int screenWidthPx = obj3.roundToPx-0680j_4(Dp.constructor-impl((float)screenWidthDp));
            int tooltipAnchorSpacing2 = obj3.roundToPx-0680j_4(TooltipKt.getSpacingBetweenTooltipAndAnchor());
            boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
            left = boundsInWindow.getLeft();
            right = boundsInWindow.getRight();
            f = (float)i39;
            i38 /= f;
            i = right - left;
            width-impl = Size.getWidth-impl($this$drawCaretWithPath_u2dJKu_u2dmZY.getSize-NH-jbRc());
            height-impl = Size.getHeight-impl($this$drawCaretWithPath_u2dJKu_u2dmZY.getSize-NH-jbRc());
            i3 = caretWidthPx;
            int i11 = 0;
            i2 = Float.compare(i43, i11) < 0 ? 1 : 0;
            f3 = i2 != 0 ? i11 : height-impl;
            f2 = f3;
            int i47 = 0;
            i6 = tooltipAnchorSpacing2;
            if (caretType == CaretType.Plain) {
                if (Float.compare(preferredPosition, f4) > 0) {
                    f5 -= i4;
                    int i45 = i15;
                    anchorMidFromRightScreenEdge = OffsetKt.Offset(width-impl - i15, f2);
                } else {
                    anchorMidFromRightScreenEdge = OffsetKt.Offset(i4 - f13, f2);
                }
            } else {
                caretY3 = f2;
                preferredPosition = OffsetKt.Offset(i4 - left, caretY3);
                preferredPosition = OffsetKt.Offset(i4 - i26, caretY3);
                f3 = 0;
                if (Float.compare(f2, f10) > 0 && Float.compare(i28, f3) < 0) {
                    preferredPosition = OffsetKt.Offset(i4 - i26, caretY3);
                    f3 = 0;
                    if (Float.compare(i28, f3) < 0) {
                        if (Float.compare(i31, f3) <= 0) {
                            preferredPosition = OffsetKt.Offset(i4, caretY3);
                        } else {
                            if (Float.compare(f3, f11) >= 0) {
                                preferredPosition = OffsetKt.Offset(width-impl - tooltipAnchorSpacing, caretY3);
                            } else {
                                preferredPosition = OffsetKt.Offset(width-impl / f, caretY3);
                            }
                        }
                    }
                }
                anchorMidFromRightScreenEdge = preferredPosition;
            }
            if (i2 != 0) {
                y-impl2 = path;
                i8 = 0;
                caretY = caretY3;
                i5 = screenWidthPx;
                y-impl2.moveTo(Offset.getX-impl(anchorMidFromRightScreenEdge), Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl2.lineTo(x-impl2 += f6, Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl2.lineTo(Offset.getX-impl(anchorMidFromRightScreenEdge), i7 - f7);
                y-impl2.lineTo(x-impl4 -= f8, Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl2.close();
            } else {
                caretY = caretY3;
                i5 = screenWidthPx;
                caretY2 = path;
                caretY2.moveTo(Offset.getX-impl(anchorMidFromRightScreenEdge), Offset.getY-impl(anchorMidFromRightScreenEdge));
                caretY2.lineTo(x-impl7 += f15, Offset.getY-impl(anchorMidFromRightScreenEdge));
                i7 = i17;
                caretY2.lineTo(Offset.getX-impl(anchorMidFromRightScreenEdge), y-impl8 += $i$a$ApplyTooltip_androidKt$drawCaretWithPath$3);
                caretY2.lineTo(x-impl5 -= f9, Offset.getY-impl(anchorMidFromRightScreenEdge));
                caretY2.close();
            }
        } else {
            obj = configuration;
        }
        Tooltip_androidKt.drawCaretWithPath.4 anon = new Tooltip_androidKt.drawCaretWithPath.4(layoutCoordinates, path, containerColor, y-impl);
        return $this$drawCaretWithPath_u2dJKu_u2dmZY.onDrawWithContent((Function1)anon);
    }
}
