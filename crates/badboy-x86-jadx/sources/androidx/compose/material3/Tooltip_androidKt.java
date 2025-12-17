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
        float f2;
        int i9;
        boolean traceInProgress2;
        Object endRestartGroup;
        int $this$dp$iv;
        int defaultsInvalid;
        int companion3;
        int plainTooltipContainerShape;
        int shape2;
        int $this$dp$iv2;
        Object $composer2;
        int $dirty2;
        long $dirty3;
        long $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1;
        int i13;
        int i4;
        int i3;
        boolean changedInstance;
        Object anon;
        Object modifier3;
        int i15;
        int i16;
        int changed;
        Object shape3;
        long l2;
        int $i$f$isSpecifiedEaSLcWc;
        int i18;
        boolean density;
        long containerColor2;
        long obj;
        long l;
        int changed5;
        int this_$iv;
        boolean traceInProgress;
        int changed4;
        long plainTooltipContentColor;
        float contentColor2;
        float f3;
        int companion2;
        int i6;
        int changed3;
        int changed2;
        float str;
        int $dirty;
        int i;
        int i19;
        int i7;
        Object modifier2;
        int i17;
        int companion;
        int i20;
        int i14;
        int i2;
        int i8;
        int i10;
        int i5;
        float f;
        int caretSize2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i21;
        int i11;
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
        i6 = obj42;
        Composer restartGroup = obj40.startRestartGroup(1407069716);
        ComposerKt.sourceInformation(restartGroup, "C(PlainTooltip)P(4,0:c#ui.unit.DpSize,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)208@8412L26,209@8482L24,211@8552L26,96@3876L606,90@3685L797:Tooltip.android.kt#uh7d8r");
        $dirty2 = obj41;
        if (i42 &= i6 != 0) {
            $dirty2 |= 6;
        } else {
            if (companion2 & 6 == 0) {
                if (companion2 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj2);
                } else {
                    changedInstance = restartGroup.changedInstance(obj2);
                }
                i13 = changedInstance != null ? 4 : 2;
                $dirty2 |= i13;
            }
        }
        int i43 = i6 & 1;
        if (i43 != 0) {
            $dirty2 |= 48;
            anon = modifier;
        } else {
            if (companion2 & 48 == 0) {
                i15 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i15;
            } else {
                anon = modifier;
            }
        }
        if (companion2 & 384 == 0) {
            if (i6 & 2 == 0) {
                i16 = restartGroup.changed(caretSize) ? 256 : 128;
            } else {
                obj = caretSize;
            }
            $dirty2 |= i16;
        } else {
            obj = caretSize;
        }
        if (companion2 & 3072 == 0) {
            if (i6 & 4 == 0) {
                changed4 = restartGroup.changed(contentColor) ? 2048 : 1024;
            } else {
                shape3 = contentColor;
            }
            $dirty2 |= changed4;
        } else {
            shape3 = contentColor;
        }
        if (companion2 & 24576 == 0) {
            if (i6 & 8 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 16384 : 8192;
            } else {
                plainTooltipContentColor = containerColor;
            }
            $dirty2 |= changed2;
        } else {
            plainTooltipContentColor = containerColor;
        }
        int i60 = 196608;
        final int obj40 = i60;
        if (companion2 & i60 == 0) {
            if (i6 & 16 == 0) {
                changed5 = restartGroup.changed(shadowElevation) ? 131072 : 65536;
            } else {
                containerColor2 = shadowElevation;
            }
            $dirty2 |= changed5;
        } else {
            containerColor2 = shadowElevation;
        }
        this_$iv = i6 & 32;
        companion = 1572864;
        if (this_$iv != 0) {
            $dirty2 |= companion;
            str = $composer;
        } else {
            if (companion2 & companion == 0) {
                i20 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty2 |= i20;
            } else {
                str = $composer;
            }
        }
        i14 = i6 & 64;
        i2 = 12582912;
        if (i14 != 0) {
            $dirty2 |= i2;
            f2 = $changed;
        } else {
            if (companion2 & i2 == 0) {
                i10 = restartGroup.changed($changed) ? 8388608 : 4194304;
                $dirty2 |= i10;
            } else {
                f2 = $changed;
            }
        }
        int i67 = 100663296;
        if (i6 & 128 != 0) {
            $dirty2 |= i67;
        } else {
            if (companion2 & i67 == 0) {
                i9 = restartGroup.changedInstance(obj4) ? 67108864 : 33554432;
                $dirty2 |= i9;
            }
        }
        if (i23 &= $dirty2 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i3 = -458753;
                int i69 = -57345;
                if (companion2 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i43 != 0) {
                            anon = defaultsInvalid;
                        }
                        if (i6 & 2 != 0) {
                            caretSize2 = DpSize.Companion.getUnspecified-MYxV2XQ();
                            $dirty2 &= -897;
                        } else {
                            caretSize2 = caretSize;
                        }
                        i3 = 6;
                        if (i6 & 4 != 0) {
                            $dirty2 &= -7169;
                            shape3 = plainTooltipContainerShape;
                        }
                        if (i6 & 8 != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(restartGroup, i3);
                            $dirty2 &= i69;
                        }
                        if (i6 & 16 != 0) {
                            containerColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(restartGroup, i3);
                            $dirty2 &= i68;
                        }
                        if (this_$iv != 0) {
                            i3 = 0;
                            str = $this$dp$iv2;
                        }
                        if (i14 != 0) {
                            i3 = 0;
                            f = $this$dp$iv3;
                            $this$dp$iv = $dirty2;
                            i5 = str;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = caretSize2;
                        } else {
                            f = $changed;
                            $this$dp$iv = $dirty2;
                            i5 = str;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = caretSize2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i6 & 2 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i6 & 4 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i6 & 8 != 0) {
                            $dirty2 &= i69;
                        }
                        if (i6 & 16 != 0) {
                            $this$dp$iv = $dirty2 & i3;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = caretSize;
                            f = $changed;
                            i5 = str;
                        } else {
                            f = $changed;
                            $this$dp$iv = $dirty2;
                            i5 = str;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = caretSize;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    obj36 = shape3;
                    ComposerKt.traceEventStart(1407069716, $this$dp$iv, -1, "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:73)");
                } else {
                    obj36 = shape3;
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
                    i14 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    this_$iv = consume2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -333845325, "CC(remember):Tooltip.android.kt#9igjgp");
                    obj30 = this_$iv2;
                    if (i64 ^= obj40 > 131072) {
                        if (!restartGroup.changed(containerColor2)) {
                            i18 = $this$dp$iv & obj40 == 131072 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    if (i59 ^= 384 > 256) {
                        if (!restartGroup.changed($i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1)) {
                            i19 = $this$dp$iv & 384 == 256 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    i6 = restartGroup;
                    int i65 = 0;
                    obj38 = $this$dp$iv;
                    Object rememberedValue = i6.rememberedValue();
                    i17 = 0;
                    if (i50 |= i19 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int caretSize3 = 0;
                            obj29 = anon3;
                            obj32 = containerColor2;
                            super(obj30, this_$iv, obj32, containerColor, obj34, shadowElevation);
                            i3 = obj30;
                            companion = obj32;
                            containerColor2 = obj34;
                            i6.updateRememberedValue((Function2)obj29);
                        } else {
                            i3 = obj30;
                            $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1 = rememberedValue;
                            companion = containerColor2;
                            containerColor2 = obj34;
                        }
                    } else {
                        obj34 = $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    modifier2 = $this$dp$iv;
                } else {
                    obj38 = $this$dp$iv;
                    companion = containerColor2;
                    containerColor2 = $i$a$CacheTooltip_androidKt$PlainTooltip$drawCaretModifier$1;
                    modifier2 = anon;
                }
                restartGroup.endReplaceGroup();
                Tooltip_androidKt.PlainTooltip.1 anon2 = new Tooltip_androidKt.PlainTooltip.1(plainTooltipContentColor, obj11, obj4);
                i17 = obj36;
                SurfaceKt.Surface-T9BRK9s(modifier2, i17, companion, i14, 0, i8, i5, f, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1430116975, true, anon2, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj38;
                $composer2 = anon;
                $dirty3 = containerColor2;
                l2 = plainTooltipContentColor;
                modifier3 = i17;
                l = companion;
                contentColor2 = i5;
                f3 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = anon;
                modifier3 = shape3;
                l = containerColor2;
                l2 = plainTooltipContentColor;
                contentColor2 = str;
                f3 = $changed;
                $dirty = $dirty2;
                $dirty3 = caretSize;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            obj29 = $dirty;
            endRestartGroup = new Tooltip_androidKt.PlainTooltip.2(obj2, $composer2, $dirty3, i4, modifier3, l2, containerColor2, l, this_$iv, contentColor2, f3, obj4, obj41, obj42);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj29 = $dirty;
        }
    }

    public static final void RichTooltip-yDvdmqw(androidx.compose.material3.TooltipScope $this$RichTooltip_u2dyDvdmqw, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> action, long caretSize, Shape shape, androidx.compose.material3.RichTooltipColors colors, float tonalElevation, float shadowElevation, Function2<? super Composer, ? super Integer, Unit> text, Composer $composer, int $changed, int i13) {
        Object obj4;
        float f4;
        float f5;
        int i10;
        Modifier colors2;
        int i2;
        int defaultsInvalid;
        int i17;
        int richTooltipContainerShape;
        androidx.compose.material3.RichTooltipColors $dirty;
        int i21;
        int changed2;
        Object $composer2;
        androidx.compose.material3.Tooltip_androidKt.RichTooltip.drawCaretModifier.1.1 $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1;
        int $dirty3;
        Object colors3;
        int i6;
        Object colorScheme;
        int i;
        Object $dirty5;
        int i15;
        float tonalElevation3;
        int tonalElevation2;
        boolean changedInstance;
        Object modifier3;
        long modifier2;
        int i14;
        Composer containerElevation-D9Ej5fM;
        boolean traceInProgress;
        Object f2;
        Object title2;
        int i9;
        androidx.compose.material3.RichTooltipColors richTooltipColors;
        int str;
        Object $i$f$getCurrent;
        Object obj2;
        float action2;
        int i11;
        int i5;
        boolean changed;
        Object obj;
        float f;
        androidx.compose.material3.Tooltip_androidKt.RichTooltip.drawCaretModifier.1.1 this_$iv;
        int companion;
        int i20;
        int i7;
        long sizeIn-qDBjuR0$default;
        Object obj3;
        int changed3;
        int containerColor-0d7_KjU;
        int l2;
        int changed4;
        int i16;
        int i8;
        int i12;
        int companion2;
        int i4;
        int $dirty2;
        float $dirty4;
        float f3;
        int i3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i19;
        int i18;
        float f6;
        androidx.compose.material3.RichTooltipColors colors4;
        long l3;
        long l;
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
        i20 = obj46;
        Composer restartGroup = $changed.startRestartGroup(1867454921);
        ComposerKt.sourceInformation(restartGroup, "C(RichTooltip)P(3,7!1,1:c#ui.unit.DpSize,5!1,8:c#ui.unit.Dp,4:c#ui.unit.Dp)255@9959L25,257@10034L19,*148@5873L7,150@5944L11,150@5956L61,178@6991L1595,167@6622L1964:Tooltip.android.kt#uh7d8r");
        $dirty3 = i13;
        if (i37 &= i20 != 0) {
            $dirty3 |= 6;
        } else {
            if (companion & 6 == 0) {
                if (companion & 8 == 0) {
                    changedInstance = restartGroup.changed(obj5);
                } else {
                    changedInstance = restartGroup.changedInstance(obj5);
                }
                i = changedInstance != null ? 4 : 2;
                $dirty3 |= i;
            }
        }
        i15 = i20 & 1;
        if (i15 != 0) {
            $dirty3 |= 48;
            modifier3 = modifier;
        } else {
            if (companion & 48 == 0) {
                i14 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i14;
            } else {
                modifier3 = modifier;
            }
        }
        containerElevation-D9Ej5fM = i20 & 2;
        if (containerElevation-D9Ej5fM != 0) {
            $dirty3 |= 384;
            f2 = title;
        } else {
            if (companion & 384 == 0) {
                i9 = restartGroup.changedInstance(title) ? 256 : 128;
                $dirty3 |= i9;
            } else {
                f2 = title;
            }
        }
        str = i20 & 4;
        if (str != null) {
            $dirty3 |= 3072;
            obj2 = action;
        } else {
            if (companion & 3072 == 0) {
                i11 = restartGroup.changedInstance(action) ? 2048 : 1024;
                $dirty3 |= i11;
            } else {
                obj2 = action;
            }
        }
        if (companion & 24576 == 0) {
            if (i20 & 8 == 0) {
                i5 = restartGroup.changed(caretSize) ? 16384 : 8192;
            } else {
                sizeIn-qDBjuR0$default = caretSize;
            }
            $dirty3 |= i5;
        } else {
            sizeIn-qDBjuR0$default = caretSize;
        }
        if (i50 &= companion == 0) {
            if (i20 & 16 == 0) {
                changed3 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                obj = colors;
            }
            $dirty3 |= changed3;
        } else {
            obj = colors;
        }
        if (companion & i63 == 0) {
            if (i20 & 32 == 0) {
                changed4 = restartGroup.changed(tonalElevation) ? 1048576 : 524288;
            } else {
                obj4 = tonalElevation;
            }
            $dirty3 |= changed4;
        } else {
            obj4 = tonalElevation;
        }
        i16 = i20 & 64;
        i8 = 12582912;
        if (i16 != 0) {
            $dirty3 |= i8;
            f4 = shadowElevation;
        } else {
            if (companion & i8 == 0) {
                i12 = restartGroup.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty3 |= i12;
            } else {
                f4 = shadowElevation;
            }
        }
        int i23 = i20 & 128;
        int i69 = 100663296;
        if (i23 != 0) {
            $dirty3 |= i69;
            companion2 = i23;
            f5 = text;
        } else {
            if (companion & i69 == 0) {
                companion2 = i23;
                i4 = restartGroup.changed(text) ? 67108864 : 33554432;
                $dirty3 |= i4;
            } else {
                companion2 = i23;
                f5 = text;
            }
        }
        int i72 = 805306368;
        if (i20 & 256 != 0) {
            $dirty3 |= i72;
        } else {
            if (companion & i72 == 0) {
                i10 = restartGroup.changedInstance(obj6) ? 536870912 : 268435456;
                $dirty3 |= i10;
            }
        }
        $dirty2 = $dirty3;
        if (i24 &= $dirty3 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i73 = -57345;
                int i76 = -458753;
                i6 = 6;
                if (companion & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier3 = defaultsInvalid;
                        }
                        if (containerElevation-D9Ej5fM != 0) {
                            f2 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj2 = defaultsInvalid;
                        }
                        if (i20 & 8 != 0) {
                            sizeIn-qDBjuR0$default = DpSize.Companion.getUnspecified-MYxV2XQ();
                            $dirty2 = i17;
                        }
                        if (i20 & 16 != 0) {
                            $dirty2 &= i76;
                            obj = richTooltipContainerShape;
                        }
                        if (i20 & 32 != 0) {
                            $dirty = TooltipDefaults.INSTANCE.richTooltipColors(restartGroup, i6);
                            $dirty2 &= i15;
                        } else {
                            $dirty = tonalElevation;
                        }
                        if (i16 != 0) {
                            tonalElevation3 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
                        } else {
                            tonalElevation3 = shadowElevation;
                        }
                        if (companion2 != 0) {
                            $dirty4 = tonalElevation3;
                            tonalElevation2 = i75;
                            f3 = containerElevation-D9Ej5fM;
                        } else {
                            $dirty4 = tonalElevation3;
                            tonalElevation2 = i74;
                            f3 = text;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i20 & 8 != 0) {
                            $dirty2 = i2;
                        }
                        if (i20 & 16 != 0) {
                            $dirty2 &= i76;
                        }
                        if (i20 & 32 != 0) {
                            $dirty4 = shadowElevation;
                            f3 = text;
                            tonalElevation2 = i28;
                            $dirty = tonalElevation;
                        } else {
                            $dirty = tonalElevation;
                            f3 = text;
                            tonalElevation2 = $dirty2;
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
                $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1 = ColorSchemeKt.applyTonalElevation-RFCenO8(colorScheme, $dirty.getContainerColor-0d7_KjU(), action, obj37, obj38);
                f6 = obj37;
                containerElevation-D9Ej5fM = obj38;
                containerElevation-D9Ej5fM.startReplaceGroup(1472746423);
                ComposerKt.sourceInformation(containerElevation-D9Ej5fM, "153@6122L7,154@6181L7,155@6220L341");
                obj34 = this_$iv;
                companion2 = Long.compare(l2, l4) != 0 ? 1 : 0;
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
                    colors4 = $dirty;
                    ComposerKt.sourceInformationMarkerStart(containerElevation-D9Ej5fM, 1472751513, "CC(remember):Tooltip.android.kt#9igjgp");
                    if (i62 ^= 24576 > 16384) {
                        if (!containerElevation-D9Ej5fM.changed(sizeIn-qDBjuR0$default)) {
                            i21 = tonalElevation2 & 24576 == 16384 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    i20 = containerElevation-D9Ej5fM;
                    l2 = 0;
                    Object rememberedValue = i20.rememberedValue();
                    i16 = 0;
                    if (obj34 | i21 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int elevatedColor = 0;
                            obj34 = anon2;
                            obj35 = this_$iv;
                            obj39 = sizeIn-qDBjuR0$default;
                            super(obj35, $i$f$getCurrent, obj37, obj38, obj39, tonalElevation);
                            colorScheme = obj35;
                            l3 = obj37;
                            l = obj39;
                            i20.updateRememberedValue((Function2)obj34);
                        } else {
                            l3 = obj37;
                            $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1 = rememberedValue;
                            colorScheme = this_$iv;
                            l = sizeIn-qDBjuR0$default;
                        }
                    } else {
                        obj37 = $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1;
                    }
                    ComposerKt.sourceInformationMarkerEnd(containerElevation-D9Ej5fM);
                    colors2 = obj5.drawCaret((Modifier)Modifier.Companion, (Function2)$i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1).then(modifier3);
                } else {
                    colors4 = $dirty;
                    l3 = $i$a$CacheTooltip_androidKt$RichTooltip$drawCaretModifier$1;
                    l = sizeIn-qDBjuR0$default;
                    colors2 = modifier3;
                }
                containerElevation-D9Ej5fM.endReplaceGroup();
                androidx.compose.material3.RichTooltipColors richTooltipColors2 = colors4;
                Tooltip_androidKt.RichTooltip.1 anon = new Tooltip_androidKt.RichTooltip.1(f2, obj2, richTooltipColors2, obj6);
                obj3 = obj41;
                SurfaceKt.Surface-T9BRK9s(SizeKt.sizeIn-qDBjuR0$default(colors2, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0, 8, 0), obj3, colors4.getContainerColor-0d7_KjU(), i16, 0, companion2, $dirty4, f3, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(317290958, true, anon, containerElevation-D9Ej5fM, 54), containerElevation-D9Ej5fM);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = tonalElevation2;
                $dirty5 = obj2;
                action2 = f7;
                richTooltipColors = richTooltipColors2;
                $composer2 = modifier3;
                colors3 = f2;
                title2 = obj3;
                f = f3;
                modifier2 = l;
            } else {
                restartGroup.skipToGroupEnd();
                richTooltipColors = tonalElevation;
                composer = restartGroup;
                $composer2 = modifier3;
                colors3 = f2;
                $dirty5 = obj2;
                title2 = obj;
                modifier2 = sizeIn-qDBjuR0$default;
                action2 = shadowElevation;
                f = text;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            colors2 = new Tooltip_androidKt.RichTooltip.2(obj5, $composer2, colors3, $dirty5, modifier2, containerElevation-D9Ej5fM, title2, richTooltipColors, action2, f, obj6, i13, obj46);
            endRestartGroup.updateScope((Function2)colors2);
        }
    }

    public static final DrawResult access$drawCaretWithPath-JKu-mZY(CacheDrawScope $receiver, androidx.compose.material3.CaretType caretType, Density density, Configuration configuration, long containerColor, long caretSize, LayoutCoordinates anchorLayoutCoordinates) {
        return Tooltip_androidKt.drawCaretWithPath-JKu-mZY($receiver, caretType, density, configuration, containerColor, caretSize, anchorLayoutCoordinates);
    }

    private static final DrawResult drawCaretWithPath-JKu-mZY(CacheDrawScope $this$drawCaretWithPath_u2dJKu_u2dmZY, androidx.compose.material3.CaretType caretType, Density density, Configuration configuration, long containerColor, long caretSize, LayoutCoordinates anchorLayoutCoordinates) {
        int caretHeightPx;
        float caretY;
        Path caretY2;
        int y-impl2;
        int tooltipAnchorSpacing;
        float y-impl;
        Rect boundsInWindow;
        float left;
        Object obj;
        float right;
        float top;
        int i3;
        float f2;
        int i7;
        int i4;
        float width-impl;
        float height-impl;
        int i;
        int i2;
        float f3;
        long anchorMidFromRightScreenEdge;
        int f;
        float caretY3;
        int i5;
        int i6;
        long preferredPosition;
        int i8;
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
            f2 = (float)i39;
            i38 /= f2;
            i4 = right - left;
            width-impl = Size.getWidth-impl($this$drawCaretWithPath_u2dJKu_u2dmZY.getSize-NH-jbRc());
            height-impl = Size.getHeight-impl($this$drawCaretWithPath_u2dJKu_u2dmZY.getSize-NH-jbRc());
            i2 = caretWidthPx;
            int i11 = 0;
            i = Float.compare(i43, i11) < 0 ? 1 : 0;
            f3 = i != 0 ? i11 : height-impl;
            f = f3;
            int i47 = 0;
            i6 = tooltipAnchorSpacing2;
            if (caretType == CaretType.Plain) {
                if (Float.compare(preferredPosition, f4) > 0) {
                    f5 -= i3;
                    int i45 = i15;
                    anchorMidFromRightScreenEdge = OffsetKt.Offset(width-impl - i15, f);
                } else {
                    anchorMidFromRightScreenEdge = OffsetKt.Offset(i3 - f13, f);
                }
            } else {
                caretY = f;
                preferredPosition = OffsetKt.Offset(i3 - left, caretY);
                preferredPosition = OffsetKt.Offset(i3 - i26, caretY);
                f3 = 0;
                if (Float.compare(f, f10) > 0 && Float.compare(i28, f3) < 0) {
                    preferredPosition = OffsetKt.Offset(i3 - i26, caretY);
                    f3 = 0;
                    if (Float.compare(i28, f3) < 0) {
                        if (Float.compare(i31, f3) <= 0) {
                            preferredPosition = OffsetKt.Offset(i3, caretY);
                        } else {
                            if (Float.compare(f3, f11) >= 0) {
                                preferredPosition = OffsetKt.Offset(width-impl - tooltipAnchorSpacing, caretY);
                            } else {
                                preferredPosition = OffsetKt.Offset(width-impl / f2, caretY);
                            }
                        }
                    }
                }
                anchorMidFromRightScreenEdge = preferredPosition;
            }
            if (i != 0) {
                y-impl = path;
                i7 = 0;
                caretY3 = caretY;
                i5 = screenWidthPx;
                y-impl.moveTo(Offset.getX-impl(anchorMidFromRightScreenEdge), Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl.lineTo(x-impl2 += f6, Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl.lineTo(Offset.getX-impl(anchorMidFromRightScreenEdge), i8 - f7);
                y-impl.lineTo(x-impl4 -= f8, Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl.close();
            } else {
                caretY3 = caretY;
                i5 = screenWidthPx;
                caretY2 = path;
                caretY2.moveTo(Offset.getX-impl(anchorMidFromRightScreenEdge), Offset.getY-impl(anchorMidFromRightScreenEdge));
                caretY2.lineTo(x-impl7 += f15, Offset.getY-impl(anchorMidFromRightScreenEdge));
                i8 = i17;
                caretY2.lineTo(Offset.getX-impl(anchorMidFromRightScreenEdge), y-impl8 += $i$a$ApplyTooltip_androidKt$drawCaretWithPath$3);
                caretY2.lineTo(x-impl5 -= f9, Offset.getY-impl(anchorMidFromRightScreenEdge));
                caretY2.close();
            }
        } else {
            obj = configuration;
        }
        Tooltip_androidKt.drawCaretWithPath.4 anon = new Tooltip_androidKt.drawCaretWithPath.4(layoutCoordinates, path, containerColor, y-impl2);
        return $this$drawCaretWithPath_u2dJKu_u2dmZY.onDrawWithContent((Function1)anon);
    }
}
