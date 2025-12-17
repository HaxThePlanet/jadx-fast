package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001ac\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00072\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a\u0095\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00072\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001e2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001f\u001a,\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%\u001a8\u0010&\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u000b2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006*", d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SurfaceKt {
    public static final void Surface-F-jzlyU(Modifier modifier, Shape shape, long color, long contentColor, BorderStroke border, float elevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        Object obj10;
        boolean traceInProgress;
        int $this$dp$iv;
        boolean traceInProgress2;
        int defaultsInvalid;
        int colors;
        int $dirty2;
        Object $dirty;
        Object obj5;
        int str;
        float f3;
        long l4;
        Object obj3;
        int i5;
        long l;
        int i8;
        Object obj4;
        int i;
        long surface-0d7_KjU;
        Object obj6;
        float f2;
        int changed;
        int i6;
        int changed2;
        int i7;
        Object obj8;
        long contentColorFor-ek8zF_U;
        int contentColor2;
        int i2;
        int i3;
        int i9;
        int i4;
        androidx.compose.material.SurfaceKt.Surface.1 anon;
        Object obj2;
        Object obj;
        long l2;
        float constructor-impl;
        Object obj9;
        float f;
        Object obj7;
        long l3;
        final int i30 = obj38;
        final Composer restartGroup = i10.startRestartGroup(1412203386);
        ComposerKt.sourceInformation(restartGroup, "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)103@5115L6,104@5157L22,*109@5332L7,113@5495L755,110@5356L894:Surface.kt#jmzs0o");
        $dirty2 = obj38;
        int i16 = obj39 & 1;
        if (i16 != 0) {
            $dirty2 |= 6;
            obj3 = modifier;
        } else {
            if (i30 & 6 == 0) {
                i5 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                obj3 = modifier;
            }
        }
        i8 = obj39 & 2;
        if (i8 != 0) {
            $dirty2 |= 48;
            obj4 = shape;
        } else {
            if (i30 & 48 == 0) {
                i = restartGroup.changed(shape) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj4 = shape;
            }
        }
        if (i30 & 384 == 0) {
            if (obj39 & 4 == 0) {
                changed = restartGroup.changed(color) ? 256 : 128;
            } else {
                surface-0d7_KjU = color;
            }
            $dirty2 |= changed;
        } else {
            surface-0d7_KjU = color;
        }
        if (i30 & 3072 == 0) {
            if (obj39 & 8 == 0) {
                i6 = restartGroup.changed(border) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = border;
            }
            $dirty2 |= i6;
        } else {
            contentColorFor-ek8zF_U = border;
        }
        i7 = obj39 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            obj8 = content;
        } else {
            if (i30 & 24576 == 0) {
                i2 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                obj8 = content;
            }
        }
        int i32 = obj39 & 32;
        i3 = 196608;
        if (i32 != 0) {
            $dirty2 |= i3;
            f3 = $composer;
        } else {
            if (i30 & i3 == 0) {
                i3 = restartGroup.changed($composer) ? 131072 : 65536;
                $dirty2 |= i3;
            } else {
                f3 = $composer;
            }
        }
        i4 = 1572864;
        if (obj39 & 64 != 0) {
            $dirty2 |= i4;
            obj10 = $changed;
        } else {
            if (i30 & i4 == 0) {
                i4 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                obj10 = $changed;
            }
        }
        if ($dirty2 & i33 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i30 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (i8 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        if (obj39 & 4 != 0) {
                            surface-0d7_KjU = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getSurface-0d7_KjU();
                            $dirty2 &= -897;
                        }
                        if (obj39 & 8 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj8, restartGroup);
                            $dirty2 &= -7169;
                        }
                        if (i7 != 0) {
                            obj8 = $this$dp$iv;
                        }
                        if (i32 != 0) {
                            str = 0;
                            f = $this$dp$iv;
                            obj2 = obj3;
                            obj = obj4;
                            l2 = surface-0d7_KjU;
                            obj9 = obj8;
                        } else {
                            f = f3;
                            obj2 = obj3;
                            obj = obj4;
                            l2 = surface-0d7_KjU;
                            obj9 = obj8;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj39 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj39 & 8 != 0) {
                            $dirty2 = $this$dp$iv;
                            f = f3;
                            obj2 = obj3;
                            obj = obj4;
                            l2 = surface-0d7_KjU;
                            obj9 = obj8;
                        } else {
                            f = f3;
                            obj2 = obj3;
                            obj = obj4;
                            l2 = surface-0d7_KjU;
                            obj9 = obj8;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1412203386, $dirty2, -1, "androidx.compose.material.Surface (Surface.kt:108)");
                }
                int i17 = 6;
                int i19 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i18 = 0;
                constructor-impl = Dp.constructor-impl(unbox-impl + f);
                ProvidedValue[] arr = new ProvidedValue[2];
                int i22 = 1;
                arr[i22] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(constructor-impl));
                anon = new SurfaceKt.Surface.1(obj2, obj, l2, obj21, constructor-impl, obj9, f, $changed);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-1822160838, i22, anon, restartGroup, 54), restartGroup, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l = contentColorFor-ek8zF_U;
                obj5 = obj;
                l4 = l2;
                obj6 = obj9;
                f2 = f;
                contentColor2 = $dirty2;
                $dirty = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = obj4;
                l = contentColorFor-ek8zF_U;
                contentColor2 = $dirty2;
                $dirty = obj3;
                f2 = f3;
                l4 = l3;
                obj6 = obj8;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SurfaceKt.Surface.2($dirty, obj5, l4, obj3, l, obj4, obj6, f2, $changed, i30, obj39);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void Surface-LPr_se0(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj2;
        float f3;
        Object obj;
        Object obj7;
        int traceInProgress2;
        int border2;
        boolean traceInProgress;
        int i14;
        int defaultsInvalid;
        int i15;
        int i18;
        Object endRestartGroup;
        int $dirty3;
        int $dirty;
        float elevation2;
        Object obj5;
        Object obj4;
        long contentColorFor-ek8zF_U;
        boolean contentColor2;
        int i6;
        Object obj3;
        Object obj10;
        long l;
        int i;
        int str;
        boolean z;
        long l3;
        int i16;
        int consume;
        Object obj9;
        int i3;
        int i11;
        long surface-0d7_KjU;
        float f2;
        int i5;
        boolean changed2;
        int i20;
        Object $composer2;
        int changed;
        androidx.compose.material.SurfaceKt.Surface.3 anon;
        int i8;
        int i10;
        int i12;
        int i2;
        int i9;
        int i4;
        int i17;
        int $dirty2;
        float constructor-impl;
        int i19;
        float f;
        int i7;
        boolean z2;
        Object obj6;
        Object obj8;
        long l2;
        Composer obj42;
        final int i50 = obj43;
        final int i51 = obj44;
        $composer2 = i13.startRestartGroup(1560876237);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(8,7,5,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)212@10592L6,213@10634L22,*219@10866L7,223@11029L859,220@10890L998:Surface.kt#jmzs0o");
        $dirty3 = obj43;
        if (i51 & 1 != 0) {
            $dirty3 |= 6;
            obj5 = onClick;
        } else {
            if (i50 & 6 == 0) {
                i6 = $composer2.changedInstance(onClick) ? 4 : 2;
                $dirty3 |= i6;
            } else {
                obj5 = onClick;
            }
        }
        int i32 = i51 & 2;
        if (i32 != 0) {
            $dirty3 |= 48;
            obj10 = modifier;
        } else {
            if (i50 & 48 == 0) {
                i = $composer2.changed(modifier) ? 32 : 16;
                $dirty3 |= i;
            } else {
                obj10 = modifier;
            }
        }
        str = i51 & 4;
        if (str != null) {
            $dirty3 |= 384;
            z = enabled;
        } else {
            if (i50 & 384 == 0) {
                i16 = $composer2.changed(enabled) ? 256 : 128;
                $dirty3 |= i16;
            } else {
                z = enabled;
            }
        }
        consume = i51 & 8;
        if (consume != 0) {
            $dirty3 |= 3072;
            obj9 = shape;
        } else {
            if (i50 & 3072 == 0) {
                i11 = $composer2.changed(shape) ? 2048 : 1024;
                $dirty3 |= i11;
            } else {
                obj9 = shape;
            }
        }
        if (i50 & 24576 == 0) {
            if (i51 & 16 == 0) {
                changed2 = $composer2.changed(color) ? 16384 : 8192;
            } else {
                surface-0d7_KjU = color;
            }
            $dirty3 |= changed2;
        } else {
            surface-0d7_KjU = color;
        }
        if (i47 &= i50 == 0) {
            if (i51 & 32 == 0) {
                i20 = i32;
                changed = $composer2.changed(border) ? 131072 : 65536;
            } else {
                i20 = i32;
                contentColorFor-ek8zF_U = border;
            }
            $dirty3 |= changed;
        } else {
            i20 = i32;
            contentColorFor-ek8zF_U = border;
        }
        anon = i51 & 64;
        i8 = 1572864;
        if (anon != 0) {
            $dirty3 |= i8;
            obj2 = interactionSource;
        } else {
            if (i50 & i8 == 0) {
                i10 = $composer2.changed(interactionSource) ? 1048576 : 524288;
                $dirty3 |= i10;
            } else {
                obj2 = interactionSource;
            }
        }
        int i22 = i51 & 128;
        int i52 = 12582912;
        if (i22 != 0) {
            $dirty3 |= i52;
            i12 = i22;
            f3 = content;
        } else {
            if (i50 & i52 == 0) {
                i12 = i22;
                i2 = $composer2.changed(content) ? 8388608 : 4194304;
                $dirty3 |= i2;
            } else {
                i12 = i22;
                f3 = content;
            }
        }
        int i23 = i51 & 256;
        int i54 = 100663296;
        if (i23 != 0) {
            $dirty3 |= i54;
            i9 = i23;
            obj = $composer;
        } else {
            if (i50 & i54 == 0) {
                i9 = i23;
                i4 = $composer2.changed($composer) ? 67108864 : 33554432;
                $dirty3 |= i4;
            } else {
                i9 = i23;
                obj = $composer;
            }
        }
        i17 = 805306368;
        if (i51 & 512 != 0) {
            $dirty3 |= i17;
            obj7 = $changed;
        } else {
            if (i50 & i17 == 0) {
                i17 = $composer2.changedInstance($changed) ? 536870912 : 268435456;
                $dirty3 |= i17;
            } else {
                obj7 = $changed;
            }
        }
        $dirty2 = $dirty3;
        if ($dirty3 & i56 == 306783378) {
            if (!$composer2.getSkipping()) {
                $composer2.startDefaults();
                int i28 = -458753;
                int i57 = -57345;
                if (i50 & 1 != 0) {
                    if ($composer2.getDefaultsInvalid()) {
                        if (i20 != 0) {
                            obj10 = defaultsInvalid;
                        }
                        if (str != null) {
                            z = defaultsInvalid;
                        }
                        if (consume != 0) {
                            obj9 = defaultsInvalid;
                        }
                        if (i51 & 16 != 0) {
                            surface-0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, 6).getSurface-0d7_KjU();
                            $dirty2 = i15;
                        }
                        if (i51 & 32 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj11, $composer2);
                            $dirty2 &= i28;
                        }
                        border2 = anon != 0 ? 0 : interactionSource;
                        if (i12 != 0) {
                            str = 0;
                            elevation2 = Dp.constructor-impl((float)i29);
                        } else {
                            elevation2 = content;
                        }
                        if (i9 != 0) {
                            i19 = border2;
                            f = elevation2;
                            i7 = str;
                            z2 = z;
                            i12 = obj9;
                            $dirty = $dirty2;
                            i9 = surface-0d7_KjU;
                        } else {
                            i7 = $composer;
                            i19 = border2;
                            f = elevation2;
                            z2 = z;
                            i12 = obj9;
                            $dirty = $dirty2;
                            i9 = surface-0d7_KjU;
                        }
                    } else {
                        $composer2.skipToGroupEnd();
                        if (i51 & 16 != 0) {
                            $dirty2 = i14;
                        }
                        if (i51 & 32 != 0) {
                            i19 = interactionSource;
                            f = content;
                            i7 = $composer;
                            $dirty = border2;
                            z2 = z;
                            i12 = obj9;
                            i9 = surface-0d7_KjU;
                        } else {
                            i19 = interactionSource;
                            f = content;
                            i7 = $composer;
                            z2 = z;
                            i12 = obj9;
                            $dirty = $dirty2;
                            i9 = surface-0d7_KjU;
                        }
                    }
                } else {
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, $dirty, -1, "androidx.compose.material.Surface (Surface.kt:218)");
                }
                int i36 = 6;
                int i38 = 0;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd($composer2);
                int i37 = 0;
                constructor-impl = Dp.constructor-impl(unbox-impl + f);
                ProvidedValue[] arr = new ProvidedValue[2];
                int i41 = 1;
                arr[i41] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(constructor-impl));
                i8 = obj10;
                anon = new SurfaceKt.Surface.3(i8, i12, i9, $dirty2, constructor-impl, i19, f, i7, z2, obj5, $changed);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(2031491085, i41, anon, $composer2, 54), $composer2, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l3 = contentColorFor-ek8zF_U;
                obj4 = i8;
                obj3 = i12;
                l = i9;
                i3 = i19;
                f2 = f;
                i5 = i7;
                contentColor2 = z2;
                $dirty2 = $dirty;
            } else {
                $composer2.skipToGroupEnd();
                contentColor2 = z;
                l3 = l2;
                obj4 = obj10;
                obj3 = obj9;
                l = surface-0d7_KjU;
                i3 = interactionSource;
                f2 = content;
                i5 = $composer;
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            obj42 = $composer2;
            endRestartGroup = new SurfaceKt.Surface.4(onClick, obj4, contentColor2, obj3, l, str, l3, consume, i3, f2, i5, $changed, i50, i51);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj42 = $composer2;
        }
    }

    public static final void Surface-Ny5ogXk(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        int $dirty12;
        Object obj7;
        float f2;
        Object obj3;
        Object obj6;
        int traceInProgress2;
        Object modifier2;
        int defaultsInvalid;
        ScopeUpdateScope endRestartGroup;
        Object $composer2;
        int $dirty2;
        long $dirty4;
        int i14;
        int border3;
        int border2;
        Object $dirty3;
        int elevation3;
        int i18;
        float elevation2;
        boolean z4;
        boolean z3;
        Object obj;
        long surface-0d7_KjU;
        boolean traceInProgress;
        int i17;
        int i7;
        Object obj5;
        long l;
        int i16;
        int enabled2;
        Object rectangleShape;
        long contentColor3;
        int colors;
        int contentColor2;
        int i8;
        int i6;
        float f;
        boolean z2;
        int i11;
        int i9;
        int i19;
        Object anon;
        int i;
        int i12;
        int changed;
        int $dirty15;
        Object $dirty13;
        Composer $dirty1;
        int $dirty;
        int $dirty5;
        long $dirty6;
        int changed2;
        int $dirty14;
        int constructor-impl;
        int i5;
        int i10;
        int i2;
        int i4;
        int i13;
        int i3;
        boolean z;
        Object obj2;
        Object obj4;
        ScopeUpdateScope scopeUpdateScope;
        final int i51 = i15;
        int i20 = obj45;
        $composer2 = $changed1.startRestartGroup(262027249);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)326@16318L6,327@16360L22,*333@16592L7,337@16755L901,334@16616L1040:Surface.kt#jmzs0o");
        $dirty2 = i15;
        int i32 = obj44;
        if (i20 & 1 != 0) {
            $dirty2 |= 6;
            z3 = selected;
        } else {
            if (i51 & 6 == 0) {
                i7 = $composer2.changed(selected) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                z3 = selected;
            }
        }
        if (i20 & 2 != 0) {
            $dirty2 |= 48;
            obj5 = onClick;
        } else {
            if (i51 & 48 == 0) {
                i16 = $composer2.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i16;
            } else {
                obj5 = onClick;
            }
        }
        enabled2 = i20 & 4;
        if (enabled2 != 0) {
            $dirty2 |= 384;
            rectangleShape = modifier;
        } else {
            if (i51 & 384 == 0) {
                i8 = $composer2.changed(modifier) ? 256 : 128;
                $dirty2 |= i8;
            } else {
                rectangleShape = modifier;
            }
        }
        i6 = i20 & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (i51 & 3072 == 0) {
                i9 = $composer2.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i9;
            } else {
                z2 = enabled;
            }
        }
        i19 = i20 & 16;
        if (i19 != 0) {
            $dirty2 |= 24576;
            anon = shape;
        } else {
            if (i51 & 24576 == 0) {
                i = $composer2.changed(shape) ? 16384 : 8192;
                $dirty2 |= i;
            } else {
                anon = shape;
            }
        }
        if (i51 & i53 == 0) {
            if (i20 & 32 == 0) {
                changed = $composer2.changed(color) ? 131072 : 65536;
            } else {
                surface-0d7_KjU = color;
            }
            $dirty2 |= changed;
        } else {
            surface-0d7_KjU = color;
        }
        if (i51 & i54 == 0) {
            if (i20 & 64 == 0) {
                $dirty = $dirty2;
                $dirty15 = i32;
                changed2 = $composer2.changed(border) ? 1048576 : 524288;
            } else {
                $dirty = $dirty2;
                $dirty15 = i32;
                $dirty4 = border;
            }
            $dirty |= changed2;
        } else {
            $dirty5 = $dirty2;
            $dirty15 = i32;
            $dirty4 = border;
        }
        int i22 = i20 & 128;
        int i58 = 12582912;
        if (i22 != 0) {
            $dirty5 |= i58;
            constructor-impl = i22;
            obj7 = interactionSource;
        } else {
            if (i51 & i58 == 0) {
                constructor-impl = i22;
                i5 = $composer2.changed(interactionSource) ? 8388608 : 4194304;
                $dirty5 |= i5;
            } else {
                constructor-impl = i22;
                obj7 = interactionSource;
            }
        }
        int i23 = i20 & 256;
        int i60 = 100663296;
        if (i23 != 0) {
            $dirty5 |= i60;
            i10 = i23;
            f2 = content;
        } else {
            if (i51 & i60 == 0) {
                i10 = i23;
                i2 = $composer2.changed(content) ? 67108864 : 33554432;
                $dirty5 |= i2;
            } else {
                i10 = i23;
                f2 = content;
            }
        }
        int i24 = i20 & 512;
        int i62 = 805306368;
        if (i24 != 0) {
            $dirty5 |= i62;
            i4 = i24;
            obj3 = $composer;
        } else {
            if (i51 & i62 == 0) {
                i4 = i24;
                i13 = $composer2.changed($composer) ? 536870912 : 268435456;
                $dirty5 |= i13;
            } else {
                i4 = i24;
                obj3 = $composer;
            }
        }
        if (i20 & 1024 != 0) {
            $dirty12 = i26;
            obj6 = $changed;
        } else {
            if (obj44 & 6 == 0) {
                i13 = $composer2.changedInstance($changed) ? 4 : 2;
                $dirty15 |= i13;
            } else {
                obj6 = $changed;
            }
            $dirty12 = $dirty15;
        }
        if ($dirty5 & $dirty13 == 306783378 && $dirty12 & 3 == 2) {
            if ($dirty12 & 3 == 2) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    int i31 = -3670017;
                    int i33 = -458753;
                    if (i51 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (enabled2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = rectangleShape;
                            }
                            enabled2 = i6 != 0 ? 1 : z2;
                            if (i19 != 0) {
                                anon = rectangleShape;
                            }
                            if (obj45 & 32 != 0) {
                                surface-0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, 6).getSurface-0d7_KjU();
                                $dirty5 &= i33;
                            }
                            if (obj45 & 64 != 0) {
                                contentColor3 = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj7, $composer2);
                                $dirty5 &= i31;
                            } else {
                                contentColor3 = border;
                            }
                            border2 = constructor-impl != 0 ? 0 : interactionSource;
                            if (i10 != 0) {
                                z2 = 0;
                                elevation2 = Dp.constructor-impl((float)i36);
                            } else {
                                elevation2 = content;
                            }
                            if (i4 != 0) {
                                i10 = border2;
                                i4 = elevation2;
                                z = enabled2;
                                i3 = z2;
                                $dirty13 = anon;
                                border3 = $dirty5;
                                elevation3 = 262027249;
                                $dirty6 = surface-0d7_KjU;
                            } else {
                                i3 = $composer;
                                i10 = border2;
                                i4 = elevation2;
                                z = enabled2;
                                $dirty13 = anon;
                                border3 = $dirty5;
                                elevation3 = 262027249;
                                $dirty6 = surface-0d7_KjU;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj45 & 32 != 0) {
                                $dirty5 &= i33;
                            }
                            if (obj45 & 64 != 0) {
                                i10 = interactionSource;
                                i4 = content;
                                i3 = $composer;
                                border3 = i30;
                                $dirty6 = surface-0d7_KjU;
                                modifier2 = rectangleShape;
                                z = z2;
                                $dirty13 = anon;
                                elevation3 = 262027249;
                                contentColor3 = border;
                            } else {
                                i10 = interactionSource;
                                i4 = content;
                                i3 = $composer;
                                modifier2 = rectangleShape;
                                z = z2;
                                $dirty13 = anon;
                                border3 = $dirty5;
                                elevation3 = 262027249;
                                contentColor3 = border;
                                $dirty6 = surface-0d7_KjU;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(elevation3, border3, $dirty12, "androidx.compose.material.Surface (Surface.kt:332)");
                    }
                    int i41 = 6;
                    int i43 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i42 = 0;
                    constructor-impl = Dp.constructor-impl(unbox-impl + i4);
                    ProvidedValue[] arr = new ProvidedValue[2];
                    i17 = 1;
                    arr[i17] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(constructor-impl));
                    i12 = modifier2;
                    anon = new SurfaceKt.Surface.5(i12, $dirty13, $dirty6, changed2, constructor-impl, i10, i4, z3, i3, z, obj5, $changed);
                    CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-1391199439, i17, anon, $composer2, 54), $composer2, $stable |= 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    l = contentColor3;
                    obj = $dirty13;
                    surface-0d7_KjU = $dirty6;
                    contentColor2 = i10;
                    f = i4;
                    i11 = i3;
                    z4 = z;
                    $dirty5 = border3;
                    $dirty3 = i12;
                } else {
                    $composer2.skipToGroupEnd();
                    l = border;
                    f = content;
                    $dirty3 = rectangleShape;
                    z4 = z2;
                    obj = anon;
                    contentColor2 = interactionSource;
                    i11 = $composer;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty14 = i57;
            $dirty1 = $composer2;
            $dirty12 = new SurfaceKt.Surface.6(selected, onClick, $dirty3, z4, obj, surface-0d7_KjU, i17, l, enabled2, contentColor2, f, i11, $changed, i51, obj44, obj45);
            endRestartGroup.updateScope((Function2)$dirty12);
        } else {
            $dirty14 = $dirty12;
            $dirty1 = $composer2;
        }
    }

    public static final void Surface-Ny5ogXk(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        int $dirty14;
        Object obj5;
        float f;
        Object obj4;
        Object obj7;
        int traceInProgress;
        Object modifier2;
        int defaultsInvalid;
        ScopeUpdateScope endRestartGroup;
        Object $composer2;
        int $dirty3;
        long $dirty6;
        int i5;
        int border3;
        int border2;
        Object $dirty5;
        int elevation3;
        int i4;
        float elevation2;
        boolean z;
        boolean z4;
        Object obj2;
        long surface-0d7_KjU;
        boolean traceInProgress2;
        int i17;
        int i8;
        Object obj;
        long l;
        int i12;
        int enabled2;
        Object rectangleShape;
        long contentColor3;
        int colors;
        int contentColor2;
        int i2;
        int i10;
        float f2;
        boolean z2;
        int i7;
        int i14;
        int i18;
        Object anon;
        int i;
        int i13;
        int changed;
        int $dirty15;
        Object $dirty13;
        Composer $dirty12;
        int $dirty2;
        int $dirty;
        long $dirty4;
        int changed2;
        int $dirty1;
        int constructor-impl;
        int i11;
        int i19;
        int i9;
        int i6;
        int i16;
        int i3;
        boolean z3;
        Object obj6;
        Object obj3;
        ScopeUpdateScope scopeUpdateScope;
        final int i51 = i15;
        int i20 = obj45;
        $composer2 = $changed1.startRestartGroup(1341569296);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)441@22161L6,442@22203L22,*448@22435L7,452@22598L911,449@22459L1050:Surface.kt#jmzs0o");
        $dirty3 = i15;
        int i32 = obj44;
        if (i20 & 1 != 0) {
            $dirty3 |= 6;
            z4 = checked;
        } else {
            if (i51 & 6 == 0) {
                i8 = $composer2.changed(checked) ? 4 : 2;
                $dirty3 |= i8;
            } else {
                z4 = checked;
            }
        }
        if (i20 & 2 != 0) {
            $dirty3 |= 48;
            obj = onCheckedChange;
        } else {
            if (i51 & 48 == 0) {
                i12 = $composer2.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty3 |= i12;
            } else {
                obj = onCheckedChange;
            }
        }
        enabled2 = i20 & 4;
        if (enabled2 != 0) {
            $dirty3 |= 384;
            rectangleShape = modifier;
        } else {
            if (i51 & 384 == 0) {
                i2 = $composer2.changed(modifier) ? 256 : 128;
                $dirty3 |= i2;
            } else {
                rectangleShape = modifier;
            }
        }
        i10 = i20 & 8;
        if (i10 != 0) {
            $dirty3 |= 3072;
            z2 = enabled;
        } else {
            if (i51 & 3072 == 0) {
                i14 = $composer2.changed(enabled) ? 2048 : 1024;
                $dirty3 |= i14;
            } else {
                z2 = enabled;
            }
        }
        i18 = i20 & 16;
        if (i18 != 0) {
            $dirty3 |= 24576;
            anon = shape;
        } else {
            if (i51 & 24576 == 0) {
                i = $composer2.changed(shape) ? 16384 : 8192;
                $dirty3 |= i;
            } else {
                anon = shape;
            }
        }
        if (i51 & i53 == 0) {
            if (i20 & 32 == 0) {
                changed = $composer2.changed(color) ? 131072 : 65536;
            } else {
                surface-0d7_KjU = color;
            }
            $dirty3 |= changed;
        } else {
            surface-0d7_KjU = color;
        }
        if (i51 & i54 == 0) {
            if (i20 & 64 == 0) {
                $dirty2 = $dirty3;
                $dirty15 = i32;
                changed2 = $composer2.changed(border) ? 1048576 : 524288;
            } else {
                $dirty2 = $dirty3;
                $dirty15 = i32;
                $dirty6 = border;
            }
            $dirty2 |= changed2;
        } else {
            $dirty = $dirty3;
            $dirty15 = i32;
            $dirty6 = border;
        }
        int i22 = i20 & 128;
        int i58 = 12582912;
        if (i22 != 0) {
            $dirty |= i58;
            constructor-impl = i22;
            obj5 = interactionSource;
        } else {
            if (i51 & i58 == 0) {
                constructor-impl = i22;
                i11 = $composer2.changed(interactionSource) ? 8388608 : 4194304;
                $dirty |= i11;
            } else {
                constructor-impl = i22;
                obj5 = interactionSource;
            }
        }
        int i23 = i20 & 256;
        int i60 = 100663296;
        if (i23 != 0) {
            $dirty |= i60;
            i19 = i23;
            f = content;
        } else {
            if (i51 & i60 == 0) {
                i19 = i23;
                i9 = $composer2.changed(content) ? 67108864 : 33554432;
                $dirty |= i9;
            } else {
                i19 = i23;
                f = content;
            }
        }
        int i24 = i20 & 512;
        int i62 = 805306368;
        if (i24 != 0) {
            $dirty |= i62;
            i6 = i24;
            obj4 = $composer;
        } else {
            if (i51 & i62 == 0) {
                i6 = i24;
                i16 = $composer2.changed($composer) ? 536870912 : 268435456;
                $dirty |= i16;
            } else {
                i6 = i24;
                obj4 = $composer;
            }
        }
        if (i20 & 1024 != 0) {
            $dirty14 = i26;
            obj7 = $changed;
        } else {
            if (obj44 & 6 == 0) {
                i16 = $composer2.changedInstance($changed) ? 4 : 2;
                $dirty15 |= i16;
            } else {
                obj7 = $changed;
            }
            $dirty14 = $dirty15;
        }
        if ($dirty & $dirty13 == 306783378 && $dirty14 & 3 == 2) {
            if ($dirty14 & 3 == 2) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    int i31 = -3670017;
                    int i33 = -458753;
                    if (i51 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (enabled2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = rectangleShape;
                            }
                            enabled2 = i10 != 0 ? 1 : z2;
                            if (i18 != 0) {
                                anon = rectangleShape;
                            }
                            if (obj45 & 32 != 0) {
                                surface-0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, 6).getSurface-0d7_KjU();
                                $dirty &= i33;
                            }
                            if (obj45 & 64 != 0) {
                                contentColor3 = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj7, $composer2);
                                $dirty &= i31;
                            } else {
                                contentColor3 = border;
                            }
                            border2 = constructor-impl != 0 ? 0 : interactionSource;
                            if (i19 != 0) {
                                z2 = 0;
                                elevation2 = Dp.constructor-impl((float)i36);
                            } else {
                                elevation2 = content;
                            }
                            if (i6 != 0) {
                                i19 = border2;
                                i6 = elevation2;
                                z3 = enabled2;
                                i3 = z2;
                                $dirty13 = anon;
                                border3 = $dirty;
                                elevation3 = 1341569296;
                                $dirty4 = surface-0d7_KjU;
                            } else {
                                i3 = $composer;
                                i19 = border2;
                                i6 = elevation2;
                                z3 = enabled2;
                                $dirty13 = anon;
                                border3 = $dirty;
                                elevation3 = 1341569296;
                                $dirty4 = surface-0d7_KjU;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj45 & 32 != 0) {
                                $dirty &= i33;
                            }
                            if (obj45 & 64 != 0) {
                                i19 = interactionSource;
                                i6 = content;
                                i3 = $composer;
                                border3 = i30;
                                $dirty4 = surface-0d7_KjU;
                                modifier2 = rectangleShape;
                                z3 = z2;
                                $dirty13 = anon;
                                elevation3 = 1341569296;
                                contentColor3 = border;
                            } else {
                                i19 = interactionSource;
                                i6 = content;
                                i3 = $composer;
                                modifier2 = rectangleShape;
                                z3 = z2;
                                $dirty13 = anon;
                                border3 = $dirty;
                                elevation3 = 1341569296;
                                contentColor3 = border;
                                $dirty4 = surface-0d7_KjU;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(elevation3, border3, $dirty14, "androidx.compose.material.Surface (Surface.kt:447)");
                    }
                    int i41 = 6;
                    int i43 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i42 = 0;
                    constructor-impl = Dp.constructor-impl(unbox-impl + i6);
                    ProvidedValue[] arr = new ProvidedValue[2];
                    i17 = 1;
                    arr[i17] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(constructor-impl));
                    i13 = modifier2;
                    anon = new SurfaceKt.Surface.7(i13, $dirty13, $dirty4, changed2, constructor-impl, i19, i6, z4, i3, z3, obj, $changed);
                    CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-311657392, i17, anon, $composer2, 54), $composer2, $stable |= 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    l = contentColor3;
                    obj2 = $dirty13;
                    surface-0d7_KjU = $dirty4;
                    contentColor2 = i19;
                    f2 = i6;
                    i7 = i3;
                    z = z3;
                    $dirty = border3;
                    $dirty5 = i13;
                } else {
                    $composer2.skipToGroupEnd();
                    l = border;
                    f2 = content;
                    $dirty5 = rectangleShape;
                    z = z2;
                    obj2 = anon;
                    contentColor2 = interactionSource;
                    i7 = $composer;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty1 = i57;
            $dirty12 = $composer2;
            $dirty14 = new SurfaceKt.Surface.8(checked, onCheckedChange, $dirty5, z, obj2, surface-0d7_KjU, i17, l, enabled2, contentColor2, f2, i7, $changed, i51, obj44, obj45);
            endRestartGroup.updateScope((Function2)$dirty14);
        } else {
            $dirty1 = $dirty14;
            $dirty12 = $composer2;
        }
    }

    public static final Modifier access$surface-8ww4TTg(Modifier $receiver, Shape shape, long backgroundColor, BorderStroke border, float elevation) {
        return SurfaceKt.surface-8ww4TTg($receiver, shape, backgroundColor, border, elevation);
    }

    public static final long access$surfaceColorAtElevation-cq6XJ1M(long color, androidx.compose.material.ElevationOverlay elevationOverlay, float absoluteElevation, Composer $composer, int $changed) {
        return SurfaceKt.surfaceColorAtElevation-cq6XJ1M(color, elevationOverlay, absoluteElevation, $composer, $changed);
    }

    private static final Modifier surface-8ww4TTg(Modifier $this$surface_u2d8ww4TTg, Shape shape, long backgroundColor, BorderStroke border, float elevation) {
        Modifier obj11;
        final float f = shape;
        if (elevation != null) {
            obj11 = BorderKt.border((Modifier)Modifier.Companion, elevation, f);
        }
        return ClipKt.clip(BackgroundKt.background-bw27NRU(ShadowKt.shadow-s4CzXII$default($this$surface_u2d8ww4TTg, obj15, f, false, 0, obj5, 0, obj7).then(obj11), backgroundColor, border), f);
    }

    private static final long surfaceColorAtElevation-cq6XJ1M(long color, androidx.compose.material.ElevationOverlay elevationOverlay, float absoluteElevation, Composer $composer, int $changed) {
        int equals-impl0;
        boolean traceInProgress;
        int i;
        String str;
        String obj;
        long color2;
        Composer composer;
        Composer composer2;
        int i2;
        long obj8;
        int i3 = 1561611256;
        ComposerKt.sourceInformationMarkerStart($changed, i3, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp)496@24015L6:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, obj13, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:495)");
        }
        i = 6;
        if (Color.equals-impl0(color, elevationOverlay) && absoluteElevation != 0) {
            if (absoluteElevation != 0) {
                $changed.startReplaceGroup(1082171732);
                ComposerKt.sourceInformation($changed, "497@24086L31");
                composer2 = $changed;
                obj8 = absoluteElevation.apply-7g2Lkgo(color, obj4, $composer, composer2);
                composer2.endReplaceGroup();
            } else {
                obj = absoluteElevation;
                composer = $composer;
                composer2 = $changed;
                composer2.startReplaceGroup(1082239839);
                composer2.endReplaceGroup();
                obj8 = color2;
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return obj8;
    }
}
