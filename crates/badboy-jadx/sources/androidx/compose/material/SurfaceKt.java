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
        Object obj5;
        boolean traceInProgress;
        int $this$dp$iv;
        boolean traceInProgress2;
        int defaultsInvalid;
        int colors;
        int $dirty2;
        Object $dirty;
        Object obj8;
        int str;
        float f3;
        long l2;
        Object obj2;
        int i3;
        long l4;
        int i5;
        Object obj7;
        int i8;
        long surface-0d7_KjU;
        Object obj4;
        float f;
        int changed2;
        int i6;
        int changed;
        int i7;
        Object obj;
        long contentColorFor-ek8zF_U;
        int contentColor2;
        int i9;
        int i;
        int i2;
        int i4;
        androidx.compose.material.SurfaceKt.Surface.1 anon;
        Object obj9;
        Object obj3;
        long l;
        float constructor-impl;
        Object obj6;
        float f2;
        Object obj10;
        long l3;
        final int i30 = obj38;
        final Composer restartGroup = i10.startRestartGroup(1412203386);
        ComposerKt.sourceInformation(restartGroup, "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)103@5115L6,104@5157L22,*109@5332L7,113@5495L755,110@5356L894:Surface.kt#jmzs0o");
        $dirty2 = obj38;
        int i16 = obj39 & 1;
        if (i16 != 0) {
            $dirty2 |= 6;
            obj2 = modifier;
        } else {
            if (i30 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                obj2 = modifier;
            }
        }
        i5 = obj39 & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
            obj7 = shape;
        } else {
            if (i30 & 48 == 0) {
                i8 = restartGroup.changed(shape) ? 32 : 16;
                $dirty2 |= i8;
            } else {
                obj7 = shape;
            }
        }
        if (i30 & 384 == 0) {
            if (obj39 & 4 == 0) {
                changed2 = restartGroup.changed(color) ? 256 : 128;
            } else {
                surface-0d7_KjU = color;
            }
            $dirty2 |= changed2;
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
            obj = content;
        } else {
            if (i30 & 24576 == 0) {
                i9 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i9;
            } else {
                obj = content;
            }
        }
        int i32 = obj39 & 32;
        i = 196608;
        if (i32 != 0) {
            $dirty2 |= i;
            f3 = $composer;
        } else {
            if (i30 & i == 0) {
                i = restartGroup.changed($composer) ? 131072 : 65536;
                $dirty2 |= i;
            } else {
                f3 = $composer;
            }
        }
        i4 = 1572864;
        if (obj39 & 64 != 0) {
            $dirty2 |= i4;
            obj5 = $changed;
        } else {
            if (i30 & i4 == 0) {
                i4 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i4;
            } else {
                obj5 = $changed;
            }
        }
        if ($dirty2 & i33 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i30 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i5 != 0) {
                            obj7 = defaultsInvalid;
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
                            obj = $this$dp$iv;
                        }
                        if (i32 != 0) {
                            str = 0;
                            f2 = $this$dp$iv;
                            obj9 = obj2;
                            obj3 = obj7;
                            l = surface-0d7_KjU;
                            obj6 = obj;
                        } else {
                            f2 = f3;
                            obj9 = obj2;
                            obj3 = obj7;
                            l = surface-0d7_KjU;
                            obj6 = obj;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj39 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj39 & 8 != 0) {
                            $dirty2 = $this$dp$iv;
                            f2 = f3;
                            obj9 = obj2;
                            obj3 = obj7;
                            l = surface-0d7_KjU;
                            obj6 = obj;
                        } else {
                            f2 = f3;
                            obj9 = obj2;
                            obj3 = obj7;
                            l = surface-0d7_KjU;
                            obj6 = obj;
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
                constructor-impl = Dp.constructor-impl(unbox-impl + f2);
                ProvidedValue[] arr = new ProvidedValue[2];
                int i22 = 1;
                arr[i22] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(constructor-impl));
                anon = new SurfaceKt.Surface.1(obj9, obj3, l, obj21, constructor-impl, obj6, f2, $changed);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-1822160838, i22, anon, restartGroup, 54), restartGroup, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l4 = contentColorFor-ek8zF_U;
                obj8 = obj3;
                l2 = l;
                obj4 = obj6;
                f = f2;
                contentColor2 = $dirty2;
                $dirty = obj9;
            } else {
                restartGroup.skipToGroupEnd();
                obj8 = obj7;
                l4 = contentColorFor-ek8zF_U;
                contentColor2 = $dirty2;
                $dirty = obj2;
                f = f3;
                l2 = l3;
                obj4 = obj;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SurfaceKt.Surface.2($dirty, obj8, l2, obj2, l4, obj7, obj4, f, $changed, i30, obj39);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void Surface-LPr_se0(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj4;
        float f2;
        Object obj3;
        Object obj10;
        int traceInProgress;
        int border2;
        boolean traceInProgress2;
        int i8;
        int defaultsInvalid;
        int i5;
        int i10;
        Object endRestartGroup;
        int $dirty3;
        int $dirty2;
        float elevation2;
        Object obj8;
        Object obj5;
        long contentColorFor-ek8zF_U;
        boolean contentColor2;
        int i16;
        Object obj7;
        Object obj;
        long l;
        int i17;
        int str;
        boolean z;
        long l2;
        int i9;
        int consume;
        Object obj9;
        int i18;
        int i20;
        long surface-0d7_KjU;
        float f;
        int i14;
        boolean changed;
        int i15;
        Object $composer2;
        int changed2;
        androidx.compose.material.SurfaceKt.Surface.3 anon;
        int i2;
        int i;
        int i19;
        int i3;
        int i4;
        int i11;
        int i12;
        int $dirty;
        float constructor-impl;
        int i6;
        float f3;
        int i7;
        boolean z2;
        Object obj6;
        Object obj2;
        long l3;
        Composer obj42;
        final int i50 = obj43;
        final int i51 = obj44;
        $composer2 = i13.startRestartGroup(1560876237);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(8,7,5,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)212@10592L6,213@10634L22,*219@10866L7,223@11029L859,220@10890L998:Surface.kt#jmzs0o");
        $dirty3 = obj43;
        if (i51 & 1 != 0) {
            $dirty3 |= 6;
            obj8 = onClick;
        } else {
            if (i50 & 6 == 0) {
                i16 = $composer2.changedInstance(onClick) ? 4 : 2;
                $dirty3 |= i16;
            } else {
                obj8 = onClick;
            }
        }
        int i32 = i51 & 2;
        if (i32 != 0) {
            $dirty3 |= 48;
            obj = modifier;
        } else {
            if (i50 & 48 == 0) {
                i17 = $composer2.changed(modifier) ? 32 : 16;
                $dirty3 |= i17;
            } else {
                obj = modifier;
            }
        }
        str = i51 & 4;
        if (str != null) {
            $dirty3 |= 384;
            z = enabled;
        } else {
            if (i50 & 384 == 0) {
                i9 = $composer2.changed(enabled) ? 256 : 128;
                $dirty3 |= i9;
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
                i20 = $composer2.changed(shape) ? 2048 : 1024;
                $dirty3 |= i20;
            } else {
                obj9 = shape;
            }
        }
        if (i50 & 24576 == 0) {
            if (i51 & 16 == 0) {
                changed = $composer2.changed(color) ? 16384 : 8192;
            } else {
                surface-0d7_KjU = color;
            }
            $dirty3 |= changed;
        } else {
            surface-0d7_KjU = color;
        }
        if (i47 &= i50 == 0) {
            if (i51 & 32 == 0) {
                i15 = i32;
                changed2 = $composer2.changed(border) ? 131072 : 65536;
            } else {
                i15 = i32;
                contentColorFor-ek8zF_U = border;
            }
            $dirty3 |= changed2;
        } else {
            i15 = i32;
            contentColorFor-ek8zF_U = border;
        }
        anon = i51 & 64;
        i2 = 1572864;
        if (anon != 0) {
            $dirty3 |= i2;
            obj4 = interactionSource;
        } else {
            if (i50 & i2 == 0) {
                i = $composer2.changed(interactionSource) ? 1048576 : 524288;
                $dirty3 |= i;
            } else {
                obj4 = interactionSource;
            }
        }
        int i22 = i51 & 128;
        int i52 = 12582912;
        if (i22 != 0) {
            $dirty3 |= i52;
            i19 = i22;
            f2 = content;
        } else {
            if (i50 & i52 == 0) {
                i19 = i22;
                i3 = $composer2.changed(content) ? 8388608 : 4194304;
                $dirty3 |= i3;
            } else {
                i19 = i22;
                f2 = content;
            }
        }
        int i23 = i51 & 256;
        int i54 = 100663296;
        if (i23 != 0) {
            $dirty3 |= i54;
            i4 = i23;
            obj3 = $composer;
        } else {
            if (i50 & i54 == 0) {
                i4 = i23;
                i11 = $composer2.changed($composer) ? 67108864 : 33554432;
                $dirty3 |= i11;
            } else {
                i4 = i23;
                obj3 = $composer;
            }
        }
        i12 = 805306368;
        if (i51 & 512 != 0) {
            $dirty3 |= i12;
            obj10 = $changed;
        } else {
            if (i50 & i12 == 0) {
                i12 = $composer2.changedInstance($changed) ? 536870912 : 268435456;
                $dirty3 |= i12;
            } else {
                obj10 = $changed;
            }
        }
        $dirty = $dirty3;
        if ($dirty3 & i56 == 306783378) {
            if (!$composer2.getSkipping()) {
                $composer2.startDefaults();
                int i28 = -458753;
                int i57 = -57345;
                if (i50 & 1 != 0) {
                    if ($composer2.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (str != null) {
                            z = defaultsInvalid;
                        }
                        if (consume != 0) {
                            obj9 = defaultsInvalid;
                        }
                        if (i51 & 16 != 0) {
                            surface-0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, 6).getSurface-0d7_KjU();
                            $dirty = i5;
                        }
                        if (i51 & 32 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj11, $composer2);
                            $dirty &= i28;
                        }
                        border2 = anon != 0 ? 0 : interactionSource;
                        if (i19 != 0) {
                            str = 0;
                            elevation2 = Dp.constructor-impl((float)i29);
                        } else {
                            elevation2 = content;
                        }
                        if (i4 != 0) {
                            i6 = border2;
                            f3 = elevation2;
                            i7 = str;
                            z2 = z;
                            i19 = obj9;
                            $dirty2 = $dirty;
                            i4 = surface-0d7_KjU;
                        } else {
                            i7 = $composer;
                            i6 = border2;
                            f3 = elevation2;
                            z2 = z;
                            i19 = obj9;
                            $dirty2 = $dirty;
                            i4 = surface-0d7_KjU;
                        }
                    } else {
                        $composer2.skipToGroupEnd();
                        if (i51 & 16 != 0) {
                            $dirty = i8;
                        }
                        if (i51 & 32 != 0) {
                            i6 = interactionSource;
                            f3 = content;
                            i7 = $composer;
                            $dirty2 = border2;
                            z2 = z;
                            i19 = obj9;
                            i4 = surface-0d7_KjU;
                        } else {
                            i6 = interactionSource;
                            f3 = content;
                            i7 = $composer;
                            z2 = z;
                            i19 = obj9;
                            $dirty2 = $dirty;
                            i4 = surface-0d7_KjU;
                        }
                    }
                } else {
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560876237, $dirty2, -1, "androidx.compose.material.Surface (Surface.kt:218)");
                }
                int i36 = 6;
                int i38 = 0;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd($composer2);
                int i37 = 0;
                constructor-impl = Dp.constructor-impl(unbox-impl + f3);
                ProvidedValue[] arr = new ProvidedValue[2];
                int i41 = 1;
                arr[i41] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(constructor-impl));
                i2 = obj;
                anon = new SurfaceKt.Surface.3(i2, i19, i4, $dirty, constructor-impl, i6, f3, i7, z2, obj8, $changed);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(2031491085, i41, anon, $composer2, 54), $composer2, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l2 = contentColorFor-ek8zF_U;
                obj5 = i2;
                obj7 = i19;
                l = i4;
                i18 = i6;
                f = f3;
                i14 = i7;
                contentColor2 = z2;
                $dirty = $dirty2;
            } else {
                $composer2.skipToGroupEnd();
                contentColor2 = z;
                l2 = l3;
                obj5 = obj;
                obj7 = obj9;
                l = surface-0d7_KjU;
                i18 = interactionSource;
                f = content;
                i14 = $composer;
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            obj42 = $composer2;
            endRestartGroup = new SurfaceKt.Surface.4(onClick, obj5, contentColor2, obj7, l, str, l2, consume, i18, f, i14, $changed, i50, i51);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj42 = $composer2;
        }
    }

    public static final void Surface-Ny5ogXk(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        int $dirty13;
        Object obj4;
        float f2;
        Object obj7;
        Object obj5;
        int traceInProgress;
        Object modifier2;
        int defaultsInvalid;
        ScopeUpdateScope endRestartGroup;
        Object $composer2;
        int $dirty;
        long $dirty2;
        int i;
        int border3;
        int border2;
        Object $dirty3;
        int elevation3;
        int i11;
        float elevation2;
        boolean z4;
        boolean z2;
        Object obj;
        long surface-0d7_KjU;
        boolean traceInProgress2;
        int i17;
        int i18;
        Object obj2;
        long l;
        int i16;
        int enabled2;
        Object rectangleShape;
        long contentColor2;
        int colors;
        int contentColor3;
        int i19;
        int i3;
        float f;
        boolean z3;
        int i9;
        int i2;
        int i8;
        Object anon;
        int i14;
        int i6;
        int changed;
        int $dirty15;
        Object $dirty1;
        Composer $dirty14;
        int $dirty5;
        int $dirty6;
        long $dirty4;
        int changed2;
        int $dirty12;
        int constructor-impl;
        int i4;
        int i10;
        int i12;
        int i5;
        int i7;
        int i13;
        boolean z;
        Object obj3;
        Object obj6;
        ScopeUpdateScope scopeUpdateScope;
        final int i51 = i15;
        int i20 = obj45;
        $composer2 = $changed1.startRestartGroup(262027249);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)326@16318L6,327@16360L22,*333@16592L7,337@16755L901,334@16616L1040:Surface.kt#jmzs0o");
        $dirty = i15;
        int i32 = obj44;
        if (i20 & 1 != 0) {
            $dirty |= 6;
            z2 = selected;
        } else {
            if (i51 & 6 == 0) {
                i18 = $composer2.changed(selected) ? 4 : 2;
                $dirty |= i18;
            } else {
                z2 = selected;
            }
        }
        if (i20 & 2 != 0) {
            $dirty |= 48;
            obj2 = onClick;
        } else {
            if (i51 & 48 == 0) {
                i16 = $composer2.changedInstance(onClick) ? 32 : 16;
                $dirty |= i16;
            } else {
                obj2 = onClick;
            }
        }
        enabled2 = i20 & 4;
        if (enabled2 != 0) {
            $dirty |= 384;
            rectangleShape = modifier;
        } else {
            if (i51 & 384 == 0) {
                i19 = $composer2.changed(modifier) ? 256 : 128;
                $dirty |= i19;
            } else {
                rectangleShape = modifier;
            }
        }
        i3 = i20 & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z3 = enabled;
        } else {
            if (i51 & 3072 == 0) {
                i2 = $composer2.changed(enabled) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                z3 = enabled;
            }
        }
        i8 = i20 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            anon = shape;
        } else {
            if (i51 & 24576 == 0) {
                i14 = $composer2.changed(shape) ? 16384 : 8192;
                $dirty |= i14;
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
            $dirty |= changed;
        } else {
            surface-0d7_KjU = color;
        }
        if (i51 & i54 == 0) {
            if (i20 & 64 == 0) {
                $dirty5 = $dirty;
                $dirty15 = i32;
                changed2 = $composer2.changed(border) ? 1048576 : 524288;
            } else {
                $dirty5 = $dirty;
                $dirty15 = i32;
                $dirty2 = border;
            }
            $dirty5 |= changed2;
        } else {
            $dirty6 = $dirty;
            $dirty15 = i32;
            $dirty2 = border;
        }
        int i22 = i20 & 128;
        int i58 = 12582912;
        if (i22 != 0) {
            $dirty6 |= i58;
            constructor-impl = i22;
            obj4 = interactionSource;
        } else {
            if (i51 & i58 == 0) {
                constructor-impl = i22;
                i4 = $composer2.changed(interactionSource) ? 8388608 : 4194304;
                $dirty6 |= i4;
            } else {
                constructor-impl = i22;
                obj4 = interactionSource;
            }
        }
        int i23 = i20 & 256;
        int i60 = 100663296;
        if (i23 != 0) {
            $dirty6 |= i60;
            i10 = i23;
            f2 = content;
        } else {
            if (i51 & i60 == 0) {
                i10 = i23;
                i12 = $composer2.changed(content) ? 67108864 : 33554432;
                $dirty6 |= i12;
            } else {
                i10 = i23;
                f2 = content;
            }
        }
        int i24 = i20 & 512;
        int i62 = 805306368;
        if (i24 != 0) {
            $dirty6 |= i62;
            i5 = i24;
            obj7 = $composer;
        } else {
            if (i51 & i62 == 0) {
                i5 = i24;
                i7 = $composer2.changed($composer) ? 536870912 : 268435456;
                $dirty6 |= i7;
            } else {
                i5 = i24;
                obj7 = $composer;
            }
        }
        if (i20 & 1024 != 0) {
            $dirty13 = i26;
            obj5 = $changed;
        } else {
            if (obj44 & 6 == 0) {
                i7 = $composer2.changedInstance($changed) ? 4 : 2;
                $dirty15 |= i7;
            } else {
                obj5 = $changed;
            }
            $dirty13 = $dirty15;
        }
        if ($dirty6 & $dirty1 == 306783378 && $dirty13 & 3 == 2) {
            if ($dirty13 & 3 == 2) {
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
                            enabled2 = i3 != 0 ? 1 : z3;
                            if (i8 != 0) {
                                anon = rectangleShape;
                            }
                            if (obj45 & 32 != 0) {
                                surface-0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, 6).getSurface-0d7_KjU();
                                $dirty6 &= i33;
                            }
                            if (obj45 & 64 != 0) {
                                contentColor2 = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj7, $composer2);
                                $dirty6 &= i31;
                            } else {
                                contentColor2 = border;
                            }
                            border2 = constructor-impl != 0 ? 0 : interactionSource;
                            if (i10 != 0) {
                                z3 = 0;
                                elevation2 = Dp.constructor-impl((float)i36);
                            } else {
                                elevation2 = content;
                            }
                            if (i5 != 0) {
                                i10 = border2;
                                i5 = elevation2;
                                z = enabled2;
                                i13 = z3;
                                $dirty1 = anon;
                                border3 = $dirty6;
                                elevation3 = 262027249;
                                $dirty4 = surface-0d7_KjU;
                            } else {
                                i13 = $composer;
                                i10 = border2;
                                i5 = elevation2;
                                z = enabled2;
                                $dirty1 = anon;
                                border3 = $dirty6;
                                elevation3 = 262027249;
                                $dirty4 = surface-0d7_KjU;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj45 & 32 != 0) {
                                $dirty6 &= i33;
                            }
                            if (obj45 & 64 != 0) {
                                i10 = interactionSource;
                                i5 = content;
                                i13 = $composer;
                                border3 = i30;
                                $dirty4 = surface-0d7_KjU;
                                modifier2 = rectangleShape;
                                z = z3;
                                $dirty1 = anon;
                                elevation3 = 262027249;
                                contentColor2 = border;
                            } else {
                                i10 = interactionSource;
                                i5 = content;
                                i13 = $composer;
                                modifier2 = rectangleShape;
                                z = z3;
                                $dirty1 = anon;
                                border3 = $dirty6;
                                elevation3 = 262027249;
                                contentColor2 = border;
                                $dirty4 = surface-0d7_KjU;
                            }
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(elevation3, border3, $dirty13, "androidx.compose.material.Surface (Surface.kt:332)");
                    }
                    int i41 = 6;
                    int i43 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i42 = 0;
                    constructor-impl = Dp.constructor-impl(unbox-impl + i5);
                    ProvidedValue[] arr = new ProvidedValue[2];
                    i17 = 1;
                    arr[i17] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(constructor-impl));
                    i6 = modifier2;
                    anon = new SurfaceKt.Surface.5(i6, $dirty1, $dirty4, changed2, constructor-impl, i10, i5, z2, i13, z, obj2, $changed);
                    CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-1391199439, i17, anon, $composer2, 54), $composer2, $stable |= 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    l = contentColor2;
                    obj = $dirty1;
                    surface-0d7_KjU = $dirty4;
                    contentColor3 = i10;
                    f = i5;
                    i9 = i13;
                    z4 = z;
                    $dirty6 = border3;
                    $dirty3 = i6;
                } else {
                    $composer2.skipToGroupEnd();
                    l = border;
                    f = content;
                    $dirty3 = rectangleShape;
                    z4 = z3;
                    obj = anon;
                    contentColor3 = interactionSource;
                    i9 = $composer;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty12 = i57;
            $dirty14 = $composer2;
            $dirty13 = new SurfaceKt.Surface.6(selected, onClick, $dirty3, z4, obj, surface-0d7_KjU, i17, l, enabled2, contentColor3, f, i9, $changed, i51, obj44, obj45);
            endRestartGroup.updateScope((Function2)$dirty13);
        } else {
            $dirty12 = $dirty13;
            $dirty14 = $composer2;
        }
    }

    public static final void Surface-Ny5ogXk(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        int $dirty14;
        Object obj3;
        float f;
        Object obj6;
        Object obj4;
        int traceInProgress2;
        Object modifier2;
        int defaultsInvalid;
        ScopeUpdateScope endRestartGroup;
        Object $composer2;
        int $dirty5;
        long $dirty;
        int i6;
        int border3;
        int border2;
        Object $dirty6;
        int elevation3;
        int i14;
        float elevation2;
        boolean z2;
        boolean z;
        Object obj7;
        long surface-0d7_KjU;
        boolean traceInProgress;
        int i5;
        int i;
        Object obj5;
        long l;
        int i8;
        int enabled2;
        Object rectangleShape;
        long contentColor3;
        int colors;
        int contentColor2;
        int i3;
        int i13;
        float f2;
        boolean z3;
        int i17;
        int i7;
        int i2;
        Object anon;
        int i9;
        int i11;
        int changed2;
        int $dirty1;
        Object $dirty15;
        Composer $dirty13;
        int $dirty4;
        int $dirty3;
        long $dirty2;
        int changed;
        int $dirty12;
        int constructor-impl;
        int i10;
        int i4;
        int i18;
        int i12;
        int i19;
        int i16;
        boolean z4;
        Object obj;
        Object obj2;
        ScopeUpdateScope scopeUpdateScope;
        final int i51 = i15;
        int i20 = obj45;
        $composer2 = $changed1.startRestartGroup(1341569296);
        ComposerKt.sourceInformation($composer2, "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)441@22161L6,442@22203L22,*448@22435L7,452@22598L911,449@22459L1050:Surface.kt#jmzs0o");
        $dirty5 = i15;
        int i32 = obj44;
        if (i20 & 1 != 0) {
            $dirty5 |= 6;
            z = checked;
        } else {
            if (i51 & 6 == 0) {
                i = $composer2.changed(checked) ? 4 : 2;
                $dirty5 |= i;
            } else {
                z = checked;
            }
        }
        if (i20 & 2 != 0) {
            $dirty5 |= 48;
            obj5 = onCheckedChange;
        } else {
            if (i51 & 48 == 0) {
                i8 = $composer2.changedInstance(onCheckedChange) ? 32 : 16;
                $dirty5 |= i8;
            } else {
                obj5 = onCheckedChange;
            }
        }
        enabled2 = i20 & 4;
        if (enabled2 != 0) {
            $dirty5 |= 384;
            rectangleShape = modifier;
        } else {
            if (i51 & 384 == 0) {
                i3 = $composer2.changed(modifier) ? 256 : 128;
                $dirty5 |= i3;
            } else {
                rectangleShape = modifier;
            }
        }
        i13 = i20 & 8;
        if (i13 != 0) {
            $dirty5 |= 3072;
            z3 = enabled;
        } else {
            if (i51 & 3072 == 0) {
                i7 = $composer2.changed(enabled) ? 2048 : 1024;
                $dirty5 |= i7;
            } else {
                z3 = enabled;
            }
        }
        i2 = i20 & 16;
        if (i2 != 0) {
            $dirty5 |= 24576;
            anon = shape;
        } else {
            if (i51 & 24576 == 0) {
                i9 = $composer2.changed(shape) ? 16384 : 8192;
                $dirty5 |= i9;
            } else {
                anon = shape;
            }
        }
        if (i51 & i53 == 0) {
            if (i20 & 32 == 0) {
                changed2 = $composer2.changed(color) ? 131072 : 65536;
            } else {
                surface-0d7_KjU = color;
            }
            $dirty5 |= changed2;
        } else {
            surface-0d7_KjU = color;
        }
        if (i51 & i54 == 0) {
            if (i20 & 64 == 0) {
                $dirty4 = $dirty5;
                $dirty1 = i32;
                changed = $composer2.changed(border) ? 1048576 : 524288;
            } else {
                $dirty4 = $dirty5;
                $dirty1 = i32;
                $dirty = border;
            }
            $dirty4 |= changed;
        } else {
            $dirty3 = $dirty5;
            $dirty1 = i32;
            $dirty = border;
        }
        int i22 = i20 & 128;
        int i58 = 12582912;
        if (i22 != 0) {
            $dirty3 |= i58;
            constructor-impl = i22;
            obj3 = interactionSource;
        } else {
            if (i51 & i58 == 0) {
                constructor-impl = i22;
                i10 = $composer2.changed(interactionSource) ? 8388608 : 4194304;
                $dirty3 |= i10;
            } else {
                constructor-impl = i22;
                obj3 = interactionSource;
            }
        }
        int i23 = i20 & 256;
        int i60 = 100663296;
        if (i23 != 0) {
            $dirty3 |= i60;
            i4 = i23;
            f = content;
        } else {
            if (i51 & i60 == 0) {
                i4 = i23;
                i18 = $composer2.changed(content) ? 67108864 : 33554432;
                $dirty3 |= i18;
            } else {
                i4 = i23;
                f = content;
            }
        }
        int i24 = i20 & 512;
        int i62 = 805306368;
        if (i24 != 0) {
            $dirty3 |= i62;
            i12 = i24;
            obj6 = $composer;
        } else {
            if (i51 & i62 == 0) {
                i12 = i24;
                i19 = $composer2.changed($composer) ? 536870912 : 268435456;
                $dirty3 |= i19;
            } else {
                i12 = i24;
                obj6 = $composer;
            }
        }
        if (i20 & 1024 != 0) {
            $dirty14 = i26;
            obj4 = $changed;
        } else {
            if (obj44 & 6 == 0) {
                i19 = $composer2.changedInstance($changed) ? 4 : 2;
                $dirty1 |= i19;
            } else {
                obj4 = $changed;
            }
            $dirty14 = $dirty1;
        }
        if ($dirty3 & $dirty15 == 306783378 && $dirty14 & 3 == 2) {
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
                            enabled2 = i13 != 0 ? 1 : z3;
                            if (i2 != 0) {
                                anon = rectangleShape;
                            }
                            if (obj45 & 32 != 0) {
                                surface-0d7_KjU = MaterialTheme.INSTANCE.getColors($composer2, 6).getSurface-0d7_KjU();
                                $dirty3 &= i33;
                            }
                            if (obj45 & 64 != 0) {
                                contentColor3 = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj7, $composer2);
                                $dirty3 &= i31;
                            } else {
                                contentColor3 = border;
                            }
                            border2 = constructor-impl != 0 ? 0 : interactionSource;
                            if (i4 != 0) {
                                z3 = 0;
                                elevation2 = Dp.constructor-impl((float)i36);
                            } else {
                                elevation2 = content;
                            }
                            if (i12 != 0) {
                                i4 = border2;
                                i12 = elevation2;
                                z4 = enabled2;
                                i16 = z3;
                                $dirty15 = anon;
                                border3 = $dirty3;
                                elevation3 = 1341569296;
                                $dirty2 = surface-0d7_KjU;
                            } else {
                                i16 = $composer;
                                i4 = border2;
                                i12 = elevation2;
                                z4 = enabled2;
                                $dirty15 = anon;
                                border3 = $dirty3;
                                elevation3 = 1341569296;
                                $dirty2 = surface-0d7_KjU;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (obj45 & 32 != 0) {
                                $dirty3 &= i33;
                            }
                            if (obj45 & 64 != 0) {
                                i4 = interactionSource;
                                i12 = content;
                                i16 = $composer;
                                border3 = i30;
                                $dirty2 = surface-0d7_KjU;
                                modifier2 = rectangleShape;
                                z4 = z3;
                                $dirty15 = anon;
                                elevation3 = 1341569296;
                                contentColor3 = border;
                            } else {
                                i4 = interactionSource;
                                i12 = content;
                                i16 = $composer;
                                modifier2 = rectangleShape;
                                z4 = z3;
                                $dirty15 = anon;
                                border3 = $dirty3;
                                elevation3 = 1341569296;
                                contentColor3 = border;
                                $dirty2 = surface-0d7_KjU;
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
                    constructor-impl = Dp.constructor-impl(unbox-impl + i12);
                    ProvidedValue[] arr = new ProvidedValue[2];
                    i5 = 1;
                    arr[i5] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(constructor-impl));
                    i11 = modifier2;
                    anon = new SurfaceKt.Surface.7(i11, $dirty15, $dirty2, changed, constructor-impl, i4, i12, z, i16, z4, obj5, $changed);
                    CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-311657392, i5, anon, $composer2, 54), $composer2, $stable |= 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    l = contentColor3;
                    obj7 = $dirty15;
                    surface-0d7_KjU = $dirty2;
                    contentColor2 = i4;
                    f2 = i12;
                    i17 = i16;
                    z2 = z4;
                    $dirty3 = border3;
                    $dirty6 = i11;
                } else {
                    $composer2.skipToGroupEnd();
                    l = border;
                    f2 = content;
                    $dirty6 = rectangleShape;
                    z2 = z3;
                    obj7 = anon;
                    contentColor2 = interactionSource;
                    i17 = $composer;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty12 = i57;
            $dirty13 = $composer2;
            $dirty14 = new SurfaceKt.Surface.8(checked, onCheckedChange, $dirty6, z2, obj7, surface-0d7_KjU, i5, l, enabled2, contentColor2, f2, i17, $changed, i51, obj44, obj45);
            endRestartGroup.updateScope((Function2)$dirty14);
        } else {
            $dirty12 = $dirty14;
            $dirty13 = $composer2;
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
        int i2;
        String str;
        String obj;
        long color2;
        Composer composer;
        Composer composer2;
        int i;
        long obj8;
        int i3 = 1561611256;
        ComposerKt.sourceInformationMarkerStart($changed, i3, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp)496@24015L6:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, obj13, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:495)");
        }
        i2 = 6;
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
