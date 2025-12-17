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
        int i13;
        boolean traceInProgress;
        Object endRestartGroup;
        int $this$dp$iv2;
        int defaultsInvalid;
        int companion2;
        int plainTooltipContainerShape;
        int shape2;
        int $this$dp$iv;
        Object $composer2;
        int $dirty4;
        long $dirty;
        long $dirty2;
        int i8;
        int i21;
        int i2;
        boolean changedInstance;
        Object anon;
        Object modifier2;
        int i16;
        int i7;
        int changed3;
        Object shape3;
        long l2;
        int i11;
        int i20;
        boolean density;
        long containerColor2;
        long obj;
        long l;
        int changed2;
        int this_$iv;
        boolean traceInProgress2;
        int changed4;
        long plainTooltipContentColor;
        float contentColor2;
        float f2;
        int companion;
        int i;
        int changed;
        int changed5;
        float str;
        int $dirty3;
        int i17;
        int i4;
        int i10;
        Object modifier3;
        int i15;
        int companion3;
        int i22;
        int i14;
        int i18;
        int i19;
        int i5;
        int i9;
        float f;
        int caretSize2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i3;
        int i6;
        androidx.compose.material3.Tooltip_androidKt.PlainTooltip.drawCaretModifier.1.1 obj29;
        Object obj30;
        Object obj31;
        long obj32;
        long obj34;
        Object obj36;
        int obj38;
        final Object obj2 = $this$PlainTooltip_u2d7QI4Sbk;
        final Object obj4 = i12;
        companion = obj41;
        i = obj42;
        Composer restartGroup = obj40.startRestartGroup(1407069716);
        ComposerKt.sourceInformation(restartGroup, "C(PlainTooltip)P(4,0:c#ui.unit.DpSize,6,3:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)208@8412L26,209@8482L24,211@8552L26,96@3876L606,90@3685L797:Tooltip.android.kt#uh7d8r");
        $dirty4 = obj41;
        if (i43 &= i != 0) {
            $dirty4 |= 6;
        } else {
            if (companion & 6 == 0) {
                if (companion & 8 == 0) {
                    changedInstance = restartGroup.changed(obj2);
                } else {
                    changedInstance = restartGroup.changedInstance(obj2);
                }
                i8 = changedInstance != null ? 4 : 2;
                $dirty4 |= i8;
            }
        }
        int i44 = i & 1;
        if (i44 != 0) {
            $dirty4 |= 48;
            anon = modifier;
        } else {
            if (companion & 48 == 0) {
                i16 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty4 |= i16;
            } else {
                anon = modifier;
            }
        }
        if (companion & 384 == 0) {
            if (i & 2 == 0) {
                i7 = restartGroup.changed(caretSize) ? 256 : 128;
            } else {
                obj = caretSize;
            }
            $dirty4 |= i7;
        } else {
            obj = caretSize;
        }
        if (companion & 3072 == 0) {
            if (i & 4 == 0) {
                changed4 = restartGroup.changed(contentColor) ? 2048 : 1024;
            } else {
                shape3 = contentColor;
            }
            $dirty4 |= changed4;
        } else {
            shape3 = contentColor;
        }
        if (companion & 24576 == 0) {
            if (i & 8 == 0) {
                changed5 = restartGroup.changed(containerColor) ? 16384 : 8192;
            } else {
                plainTooltipContentColor = containerColor;
            }
            $dirty4 |= changed5;
        } else {
            plainTooltipContentColor = containerColor;
        }
        int i61 = 196608;
        final int obj40 = i61;
        if (companion & i61 == 0) {
            if (i & 16 == 0) {
                changed2 = restartGroup.changed(shadowElevation) ? 131072 : 65536;
            } else {
                containerColor2 = shadowElevation;
            }
            $dirty4 |= changed2;
        } else {
            containerColor2 = shadowElevation;
        }
        this_$iv = i & 32;
        companion3 = 1572864;
        if (this_$iv != 0) {
            $dirty4 |= companion3;
            str = $composer;
        } else {
            if (companion & companion3 == 0) {
                i22 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty4 |= i22;
            } else {
                str = $composer;
            }
        }
        i14 = i & 64;
        i18 = 12582912;
        if (i14 != 0) {
            $dirty4 |= i18;
            f3 = $changed;
        } else {
            if (companion & i18 == 0) {
                i5 = restartGroup.changed($changed) ? 8388608 : 4194304;
                $dirty4 |= i5;
            } else {
                f3 = $changed;
            }
        }
        int i68 = 100663296;
        if (i & 128 != 0) {
            $dirty4 |= i68;
        } else {
            if (companion & i68 == 0) {
                i13 = restartGroup.changedInstance(obj4) ? 67108864 : 33554432;
                $dirty4 |= i13;
            }
        }
        if (i24 &= $dirty4 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i2 = -458753;
                int i70 = -57345;
                if (companion & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i44 != 0) {
                            anon = defaultsInvalid;
                        }
                        if (i & 2 != 0) {
                            caretSize2 = DpSize.Companion.getUnspecified-MYxV2XQ();
                            $dirty4 &= -897;
                        } else {
                            caretSize2 = caretSize;
                        }
                        i2 = 6;
                        if (i & 4 != 0) {
                            $dirty4 &= -7169;
                            shape3 = plainTooltipContainerShape;
                        }
                        if (i & 8 != 0) {
                            plainTooltipContentColor = TooltipDefaults.INSTANCE.getPlainTooltipContentColor(restartGroup, i2);
                            $dirty4 &= i70;
                        }
                        if (i & 16 != 0) {
                            containerColor2 = TooltipDefaults.INSTANCE.getPlainTooltipContainerColor(restartGroup, i2);
                            $dirty4 &= i69;
                        }
                        if (this_$iv != 0) {
                            i2 = 0;
                            str = $this$dp$iv;
                        }
                        if (i14 != 0) {
                            i2 = 0;
                            f = $this$dp$iv3;
                            $this$dp$iv2 = $dirty4;
                            i9 = str;
                            $dirty2 = caretSize2;
                        } else {
                            f = $changed;
                            $this$dp$iv2 = $dirty4;
                            i9 = str;
                            $dirty2 = caretSize2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i & 2 != 0) {
                            $dirty4 &= -897;
                        }
                        if (i & 4 != 0) {
                            $dirty4 &= -7169;
                        }
                        if (i & 8 != 0) {
                            $dirty4 &= i70;
                        }
                        if (i & 16 != 0) {
                            $this$dp$iv2 = $dirty4 & i2;
                            $dirty2 = caretSize;
                            f = $changed;
                            i9 = str;
                        } else {
                            f = $changed;
                            $this$dp$iv2 = $dirty4;
                            i9 = str;
                            $dirty2 = caretSize;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    obj36 = shape3;
                    ComposerKt.traceEventStart(1407069716, $this$dp$iv2, -1, "androidx.compose.material3.PlainTooltip (Tooltip.android.kt:73)");
                } else {
                    obj36 = shape3;
                }
                restartGroup.startReplaceGroup(-333850415);
                ComposerKt.sourceInformation(restartGroup, "76@3183L7,77@3242L7,78@3281L343");
                int i50 = 0;
                i11 = Long.compare(l3, l4) != 0 ? 1 : 0;
                if (i11 != 0) {
                    int i67 = 0;
                    obj30 = i54;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv2 = consume;
                    int i63 = 0;
                    i14 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    this_$iv = consume2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -333845325, "CC(remember):Tooltip.android.kt#9igjgp");
                    obj30 = this_$iv2;
                    if (i65 ^= obj40 > 131072) {
                        if (!restartGroup.changed(containerColor2)) {
                            i20 = $this$dp$iv2 & obj40 == 131072 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    if (i60 ^= 384 > 256) {
                        if (!restartGroup.changed($dirty2)) {
                            i4 = $this$dp$iv2 & 384 == 256 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    i = restartGroup;
                    int i66 = 0;
                    obj38 = $this$dp$iv2;
                    Object rememberedValue = i.rememberedValue();
                    i15 = 0;
                    if (i51 |= i4 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int caretSize3 = 0;
                            obj29 = anon3;
                            obj32 = containerColor2;
                            super(obj30, this_$iv, obj32, containerColor, obj34, shadowElevation);
                            i2 = obj30;
                            companion3 = obj32;
                            containerColor2 = obj34;
                            i.updateRememberedValue((Function2)obj29);
                        } else {
                            i2 = obj30;
                            $dirty2 = rememberedValue;
                            companion3 = containerColor2;
                            containerColor2 = obj34;
                        }
                    } else {
                        obj34 = $dirty2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    modifier3 = $this$dp$iv2;
                } else {
                    obj38 = $this$dp$iv2;
                    companion3 = containerColor2;
                    containerColor2 = $dirty2;
                    modifier3 = anon;
                }
                restartGroup.endReplaceGroup();
                Tooltip_androidKt.PlainTooltip.1 anon2 = new Tooltip_androidKt.PlainTooltip.1(plainTooltipContentColor, obj11, obj4);
                i15 = obj36;
                SurfaceKt.Surface-T9BRK9s(modifier3, i15, companion3, i14, 0, i19, i9, f, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1430116975, true, anon2, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty3 = obj38;
                $composer2 = anon;
                $dirty = containerColor2;
                l2 = plainTooltipContentColor;
                modifier2 = i15;
                l = companion3;
                contentColor2 = i9;
                f2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = anon;
                modifier2 = shape3;
                l = containerColor2;
                l2 = plainTooltipContentColor;
                contentColor2 = str;
                f2 = $changed;
                $dirty3 = $dirty4;
                $dirty = caretSize;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            obj29 = $dirty3;
            endRestartGroup = new Tooltip_androidKt.PlainTooltip.2(obj2, $composer2, $dirty, i21, modifier2, l2, containerColor2, l, this_$iv, contentColor2, f2, obj4, obj41, obj42);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj29 = $dirty3;
        }
    }

    public static final void RichTooltip-yDvdmqw(androidx.compose.material3.TooltipScope $this$RichTooltip_u2dyDvdmqw, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> action, long caretSize, Shape shape, androidx.compose.material3.RichTooltipColors colors, float tonalElevation, float shadowElevation, Function2<? super Composer, ? super Integer, Unit> text, Composer $composer, int $changed, int i13) {
        Object obj2;
        float f3;
        float f5;
        int i17;
        Modifier colors4;
        int i16;
        int defaultsInvalid;
        int i4;
        int richTooltipContainerShape;
        androidx.compose.material3.RichTooltipColors $dirty5;
        int i9;
        int changed3;
        Object $composer2;
        androidx.compose.material3.Tooltip_androidKt.RichTooltip.drawCaretModifier.1.1 empty;
        int $dirty;
        Object colors3;
        int i10;
        Object colorScheme;
        int i12;
        Object $dirty2;
        int i18;
        float tonalElevation2;
        int tonalElevation3;
        boolean changedInstance;
        Object modifier2;
        long modifier3;
        int i3;
        Composer containerElevation-D9Ej5fM;
        boolean traceInProgress;
        Object f2;
        Object title2;
        int i;
        androidx.compose.material3.RichTooltipColors richTooltipColors;
        int str;
        Object $i$f$getCurrent;
        Object obj;
        float action2;
        int i8;
        int i2;
        boolean changed2;
        Object obj3;
        float f;
        androidx.compose.material3.Tooltip_androidKt.RichTooltip.drawCaretModifier.1.1 this_$iv;
        int companion2;
        int i11;
        int i5;
        long sizeIn-qDBjuR0$default;
        Object obj4;
        int changed4;
        int containerColor-0d7_KjU;
        int l3;
        int changed;
        int i15;
        int i14;
        int i20;
        int companion;
        int i6;
        int $dirty3;
        float $dirty4;
        float f4;
        int i7;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i19;
        int i21;
        float f6;
        androidx.compose.material3.RichTooltipColors colors2;
        long l2;
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
        companion2 = i13;
        i11 = obj46;
        Composer restartGroup = $changed.startRestartGroup(1867454921);
        ComposerKt.sourceInformation(restartGroup, "C(RichTooltip)P(3,7!1,1:c#ui.unit.DpSize,5!1,8:c#ui.unit.Dp,4:c#ui.unit.Dp)255@9959L25,257@10034L19,*148@5873L7,150@5944L11,150@5956L61,178@6991L1595,167@6622L1964:Tooltip.android.kt#uh7d8r");
        $dirty = i13;
        if (i37 &= i11 != 0) {
            $dirty |= 6;
        } else {
            if (companion2 & 6 == 0) {
                if (companion2 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj5);
                } else {
                    changedInstance = restartGroup.changedInstance(obj5);
                }
                i12 = changedInstance != null ? 4 : 2;
                $dirty |= i12;
            }
        }
        i18 = i11 & 1;
        if (i18 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else {
            if (companion2 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                modifier2 = modifier;
            }
        }
        containerElevation-D9Ej5fM = i11 & 2;
        if (containerElevation-D9Ej5fM != 0) {
            $dirty |= 384;
            f2 = title;
        } else {
            if (companion2 & 384 == 0) {
                i = restartGroup.changedInstance(title) ? 256 : 128;
                $dirty |= i;
            } else {
                f2 = title;
            }
        }
        str = i11 & 4;
        if (str != null) {
            $dirty |= 3072;
            obj = action;
        } else {
            if (companion2 & 3072 == 0) {
                i8 = restartGroup.changedInstance(action) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                obj = action;
            }
        }
        if (companion2 & 24576 == 0) {
            if (i11 & 8 == 0) {
                i2 = restartGroup.changed(caretSize) ? 16384 : 8192;
            } else {
                sizeIn-qDBjuR0$default = caretSize;
            }
            $dirty |= i2;
        } else {
            sizeIn-qDBjuR0$default = caretSize;
        }
        if (i50 &= companion2 == 0) {
            if (i11 & 16 == 0) {
                changed4 = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                obj3 = colors;
            }
            $dirty |= changed4;
        } else {
            obj3 = colors;
        }
        if (companion2 & i63 == 0) {
            if (i11 & 32 == 0) {
                changed = restartGroup.changed(tonalElevation) ? 1048576 : 524288;
            } else {
                obj2 = tonalElevation;
            }
            $dirty |= changed;
        } else {
            obj2 = tonalElevation;
        }
        i15 = i11 & 64;
        i14 = 12582912;
        if (i15 != 0) {
            $dirty |= i14;
            f3 = shadowElevation;
        } else {
            if (companion2 & i14 == 0) {
                i20 = restartGroup.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty |= i20;
            } else {
                f3 = shadowElevation;
            }
        }
        int i23 = i11 & 128;
        int i69 = 100663296;
        if (i23 != 0) {
            $dirty |= i69;
            companion = i23;
            f5 = text;
        } else {
            if (companion2 & i69 == 0) {
                companion = i23;
                i6 = restartGroup.changed(text) ? 67108864 : 33554432;
                $dirty |= i6;
            } else {
                companion = i23;
                f5 = text;
            }
        }
        int i72 = 805306368;
        if (i11 & 256 != 0) {
            $dirty |= i72;
        } else {
            if (companion2 & i72 == 0) {
                i17 = restartGroup.changedInstance(obj6) ? 536870912 : 268435456;
                $dirty |= i17;
            }
        }
        $dirty3 = $dirty;
        if (i24 &= $dirty == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i73 = -57345;
                int i76 = -458753;
                i10 = 6;
                if (companion2 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i18 != 0) {
                            modifier2 = defaultsInvalid;
                        }
                        if (containerElevation-D9Ej5fM != 0) {
                            f2 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj = defaultsInvalid;
                        }
                        if (i11 & 8 != 0) {
                            sizeIn-qDBjuR0$default = DpSize.Companion.getUnspecified-MYxV2XQ();
                            $dirty3 = i4;
                        }
                        if (i11 & 16 != 0) {
                            $dirty3 &= i76;
                            obj3 = richTooltipContainerShape;
                        }
                        if (i11 & 32 != 0) {
                            $dirty5 = TooltipDefaults.INSTANCE.richTooltipColors(restartGroup, i10);
                            $dirty3 &= i18;
                        } else {
                            $dirty5 = tonalElevation;
                        }
                        if (i15 != 0) {
                            tonalElevation2 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
                        } else {
                            tonalElevation2 = shadowElevation;
                        }
                        if (companion != 0) {
                            $dirty4 = tonalElevation2;
                            tonalElevation3 = i75;
                            f4 = containerElevation-D9Ej5fM;
                        } else {
                            $dirty4 = tonalElevation2;
                            tonalElevation3 = i74;
                            f4 = text;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i11 & 8 != 0) {
                            $dirty3 = i16;
                        }
                        if (i11 & 16 != 0) {
                            $dirty3 &= i76;
                        }
                        if (i11 & 32 != 0) {
                            $dirty4 = shadowElevation;
                            f4 = text;
                            tonalElevation3 = i28;
                            $dirty5 = tonalElevation;
                        } else {
                            $dirty5 = tonalElevation;
                            f4 = text;
                            tonalElevation3 = $dirty3;
                            $dirty4 = shadowElevation;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1867454921, tonalElevation3, -1, "androidx.compose.material3.RichTooltip (Tooltip.android.kt:147)");
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
                empty = ColorSchemeKt.applyTonalElevation-RFCenO8(colorScheme, $dirty5.getContainerColor-0d7_KjU(), action, obj37, obj38);
                f6 = obj37;
                containerElevation-D9Ej5fM = obj38;
                containerElevation-D9Ej5fM.startReplaceGroup(1472746423);
                ComposerKt.sourceInformation(containerElevation-D9Ej5fM, "153@6122L7,154@6181L7,155@6220L341");
                obj34 = this_$iv;
                companion = Long.compare(l3, l4) != 0 ? 1 : 0;
                if (companion != 0) {
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
                    colors2 = $dirty5;
                    ComposerKt.sourceInformationMarkerStart(containerElevation-D9Ej5fM, 1472751513, "CC(remember):Tooltip.android.kt#9igjgp");
                    if (i62 ^= 24576 > 16384) {
                        if (!containerElevation-D9Ej5fM.changed(sizeIn-qDBjuR0$default)) {
                            i9 = tonalElevation3 & 24576 == 16384 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    i11 = containerElevation-D9Ej5fM;
                    l3 = 0;
                    Object rememberedValue = i11.rememberedValue();
                    i15 = 0;
                    if (obj34 | i9 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int elevatedColor = 0;
                            obj34 = anon2;
                            obj35 = this_$iv;
                            obj39 = sizeIn-qDBjuR0$default;
                            super(obj35, $i$f$getCurrent, obj37, obj38, obj39, tonalElevation);
                            colorScheme = obj35;
                            l2 = obj37;
                            l = obj39;
                            i11.updateRememberedValue((Function2)obj34);
                        } else {
                            l2 = obj37;
                            empty = rememberedValue;
                            colorScheme = this_$iv;
                            l = sizeIn-qDBjuR0$default;
                        }
                    } else {
                        obj37 = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(containerElevation-D9Ej5fM);
                    colors4 = obj5.drawCaret((Modifier)Modifier.Companion, (Function2)empty).then(modifier2);
                } else {
                    colors2 = $dirty5;
                    l2 = empty;
                    l = sizeIn-qDBjuR0$default;
                    colors4 = modifier2;
                }
                containerElevation-D9Ej5fM.endReplaceGroup();
                androidx.compose.material3.RichTooltipColors richTooltipColors2 = colors2;
                Tooltip_androidKt.RichTooltip.1 anon = new Tooltip_androidKt.RichTooltip.1(f2, obj, richTooltipColors2, obj6);
                obj4 = obj41;
                SurfaceKt.Surface-T9BRK9s(SizeKt.sizeIn-qDBjuR0$default(colors4, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), TooltipKt.getRichTooltipMaxWidth(), 0, 8, 0), obj4, colors2.getContainerColor-0d7_KjU(), i15, 0, companion, $dirty4, f4, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(317290958, true, anon, containerElevation-D9Ej5fM, 54), containerElevation-D9Ej5fM);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty3 = tonalElevation3;
                $dirty2 = obj;
                action2 = f7;
                richTooltipColors = richTooltipColors2;
                $composer2 = modifier2;
                colors3 = f2;
                title2 = obj4;
                f = f4;
                modifier3 = l;
            } else {
                restartGroup.skipToGroupEnd();
                richTooltipColors = tonalElevation;
                composer = restartGroup;
                $composer2 = modifier2;
                colors3 = f2;
                $dirty2 = obj;
                title2 = obj3;
                modifier3 = sizeIn-qDBjuR0$default;
                action2 = shadowElevation;
                f = text;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            colors4 = new Tooltip_androidKt.RichTooltip.2(obj5, $composer2, colors3, $dirty2, modifier3, containerElevation-D9Ej5fM, title2, richTooltipColors, action2, f, obj6, i13, obj46);
            endRestartGroup.updateScope((Function2)colors4);
        }
    }

    public static final DrawResult access$drawCaretWithPath-JKu-mZY(CacheDrawScope $receiver, androidx.compose.material3.CaretType caretType, Density density, Configuration configuration, long containerColor, long caretSize, LayoutCoordinates anchorLayoutCoordinates) {
        return Tooltip_androidKt.drawCaretWithPath-JKu-mZY($receiver, caretType, density, configuration, containerColor, caretSize, anchorLayoutCoordinates);
    }

    private static final DrawResult drawCaretWithPath-JKu-mZY(CacheDrawScope $this$drawCaretWithPath_u2dJKu_u2dmZY, androidx.compose.material3.CaretType caretType, Density density, Configuration configuration, long containerColor, long caretSize, LayoutCoordinates anchorLayoutCoordinates) {
        int caretHeightPx;
        float caretY;
        Path caretY3;
        int y-impl2;
        int tooltipAnchorSpacing;
        float y-impl;
        Rect boundsInWindow;
        float left;
        Object obj;
        float right;
        float top;
        int i3;
        float f;
        int i6;
        int i2;
        float width-impl;
        float height-impl;
        int i;
        int i4;
        float f3;
        long anchorMidFromRightScreenEdge;
        int f2;
        float caretY2;
        int i5;
        int i7;
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
            f = (float)i39;
            i38 /= f;
            i2 = right - left;
            width-impl = Size.getWidth-impl($this$drawCaretWithPath_u2dJKu_u2dmZY.getSize-NH-jbRc());
            height-impl = Size.getHeight-impl($this$drawCaretWithPath_u2dJKu_u2dmZY.getSize-NH-jbRc());
            i4 = caretWidthPx;
            int i11 = 0;
            i = Float.compare(i43, i11) < 0 ? 1 : 0;
            f3 = i != 0 ? i11 : height-impl;
            f2 = f3;
            int i47 = 0;
            i7 = tooltipAnchorSpacing2;
            if (caretType == CaretType.Plain) {
                if (Float.compare(preferredPosition, f4) > 0) {
                    f5 -= i3;
                    int i45 = i15;
                    anchorMidFromRightScreenEdge = OffsetKt.Offset(width-impl - i15, f2);
                } else {
                    anchorMidFromRightScreenEdge = OffsetKt.Offset(i3 - f14, f2);
                }
            } else {
                caretY = f2;
                preferredPosition = OffsetKt.Offset(i3 - left, caretY);
                preferredPosition = OffsetKt.Offset(i3 - i26, caretY);
                f3 = 0;
                if (Float.compare(f2, f11) > 0 && Float.compare(i28, f3) < 0) {
                    preferredPosition = OffsetKt.Offset(i3 - i26, caretY);
                    f3 = 0;
                    if (Float.compare(i28, f3) < 0) {
                        if (Float.compare(i31, f3) <= 0) {
                            preferredPosition = OffsetKt.Offset(i3, caretY);
                        } else {
                            if (Float.compare(f3, f12) >= 0) {
                                preferredPosition = OffsetKt.Offset(width-impl - tooltipAnchorSpacing, caretY);
                            } else {
                                preferredPosition = OffsetKt.Offset(width-impl / f, caretY);
                            }
                        }
                    }
                }
                anchorMidFromRightScreenEdge = preferredPosition;
            }
            if (i != 0) {
                y-impl = path;
                i6 = 0;
                caretY2 = caretY;
                i5 = screenWidthPx;
                y-impl.moveTo(Offset.getX-impl(anchorMidFromRightScreenEdge), Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl.lineTo(x-impl2 += f7, Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl.lineTo(Offset.getX-impl(anchorMidFromRightScreenEdge), i8 - f8);
                y-impl.lineTo(x-impl4 -= f9, Offset.getY-impl(anchorMidFromRightScreenEdge));
                y-impl.close();
            } else {
                caretY2 = caretY;
                i5 = screenWidthPx;
                caretY3 = path;
                caretY3.moveTo(Offset.getX-impl(anchorMidFromRightScreenEdge), Offset.getY-impl(anchorMidFromRightScreenEdge));
                caretY3.lineTo(x-impl7 += f16, Offset.getY-impl(anchorMidFromRightScreenEdge));
                i8 = i17;
                caretY3.lineTo(Offset.getX-impl(anchorMidFromRightScreenEdge), y-impl8 += f6);
                caretY3.lineTo(x-impl5 -= f10, Offset.getY-impl(anchorMidFromRightScreenEdge));
                caretY3.close();
            }
        } else {
            obj = configuration;
        }
        Tooltip_androidKt.drawCaretWithPath.4 anon = new Tooltip_androidKt.drawCaretWithPath.4(layoutCoordinates, path, containerColor, y-impl2);
        return $this$drawCaretWithPath_u2dJKu_u2dmZY.onDrawWithContent((Function1)anon);
    }
}
