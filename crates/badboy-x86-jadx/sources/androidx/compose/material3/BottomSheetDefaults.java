package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsetsSides.Companion;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u00082\u0008\u0008\u0002\u0010!\u001a\u00020\u00082\u0008\u0008\u0002\u0010\"\u001a\u00020\r2\u0008\u0008\u0002\u0010#\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000c\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0015\u0010\nR\u0019\u0010\u0016\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0017\u0010\nR\u0011\u0010\u0018\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/material3/BottomSheetDefaults;", "", "()V", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ExpandedShape", "Landroidx/compose/ui/graphics/Shape;", "getExpandedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "HiddenShape", "getHiddenShape", "ScrimColor", "getScrimColor", "SheetMaxWidth", "getSheetMaxWidth-D9Ej5fM", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "width", "height", "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BottomSheetDefaults {

    public static final int $stable;
    private static final float Elevation;
    public static final androidx.compose.material3.BottomSheetDefaults INSTANCE;
    private static final float SheetMaxWidth;
    private static final float SheetPeekHeight;
    static {
        BottomSheetDefaults bottomSheetDefaults = new BottomSheetDefaults();
        BottomSheetDefaults.INSTANCE = bottomSheetDefaults;
        BottomSheetDefaults.Elevation = SheetBottomTokens.INSTANCE.getDockedModalContainerElevation-D9Ej5fM();
        int i3 = 0;
        BottomSheetDefaults.SheetPeekHeight = Dp.constructor-impl((float)i);
        int i4 = 0;
        BottomSheetDefaults.SheetMaxWidth = Dp.constructor-impl((float)i2);
    }

    public final void DragHandle-lgZ2HuY(Modifier modifier, float width, float height, Shape shape, long color, Composer $composer, int $changed, int i8) {
        String string-2EP1pXo;
        boolean traceInProgress2;
        int $dirty3;
        float $dirty;
        Object height2;
        Object modifier3;
        float modifier2;
        Object dockedDragHandleWidth-D9Ej5fM;
        int extraLarge;
        int color2;
        float $dirty2;
        int i11;
        int i;
        boolean traceInProgress;
        Object obj;
        float f;
        long width2;
        int i4;
        int str;
        float semantics$default;
        int i5;
        Object obj2;
        int shape2;
        int changed;
        long l;
        int changed2;
        int skipping;
        int defaultsInvalid;
        Object empty;
        Object anon;
        int i3;
        int i9;
        int i6;
        int i2;
        Object companion;
        Composer composer;
        int i10;
        int i7;
        final int i27 = i8;
        string-2EP1pXo = -1364277227;
        traceInProgress2 = $changed.startRestartGroup(string-2EP1pXo);
        ComposerKt.sourceInformation(traceInProgress2, "C(DragHandle)P(2,4:c#ui.unit.Dp,1:c#ui.unit.Dp,3,0:c#ui.graphics.Color)324@12873L6,325@12955L5,327@13006L51,330@13179L82,335@13326L74,328@13066L334:SheetDefaults.kt#uh7d8r");
        $dirty3 = i8;
        int i12 = obj31 & 1;
        if (i12 != 0) {
            $dirty3 |= 6;
            dockedDragHandleWidth-D9Ej5fM = modifier;
        } else {
            if (i27 & 6 == 0) {
                i11 = traceInProgress2.changed(modifier) ? 4 : 2;
                $dirty3 |= i11;
            } else {
                dockedDragHandleWidth-D9Ej5fM = modifier;
            }
        }
        i = obj31 & 2;
        if (i != 0) {
            $dirty3 |= 48;
            f = width;
        } else {
            if (i27 & 48 == 0) {
                i4 = traceInProgress2.changed(width) ? 32 : 16;
                $dirty3 |= i4;
            } else {
                f = width;
            }
        }
        str = obj31 & 4;
        if (str != null) {
            $dirty3 |= 384;
            semantics$default = height;
        } else {
            if (i27 & 384 == 0) {
                i5 = traceInProgress2.changed(height) ? 256 : 128;
                $dirty3 |= i5;
            } else {
                semantics$default = height;
            }
        }
        if (i27 & 3072 == 0) {
            if (obj31 & 8 == 0) {
                changed = traceInProgress2.changed(shape) ? 2048 : 1024;
            } else {
                obj2 = shape;
            }
            $dirty3 |= changed;
        } else {
            obj2 = shape;
        }
        if (i27 & 24576 == 0) {
            if (obj31 & 16 == 0) {
                changed2 = traceInProgress2.changed(color) ? 16384 : 8192;
            } else {
                l = color;
            }
            $dirty3 |= changed2;
        } else {
            l = color;
        }
        if ($dirty3 & 9363 == 9362) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i36 = -57345;
                if (i27 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = dockedDragHandleWidth-D9Ej5fM;
                        }
                        if (i != 0) {
                            f = dockedDragHandleWidth-D9Ej5fM;
                        }
                        if (str != null) {
                            semantics$default = dockedDragHandleWidth-D9Ej5fM;
                        }
                        i = 6;
                        if (obj31 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj2 = extraLarge;
                        }
                        if (obj31 & 16 != 0) {
                            l = value;
                            color2 = $dirty4;
                            $dirty = semantics$default;
                        } else {
                            color2 = $dirty3;
                            $dirty = semantics$default;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (obj31 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (obj31 & 16 != 0) {
                            modifier3 = dockedDragHandleWidth-D9Ej5fM;
                            color2 = $dirty5;
                            $dirty = semantics$default;
                        } else {
                            modifier3 = dockedDragHandleWidth-D9Ej5fM;
                            color2 = $dirty3;
                            $dirty = semantics$default;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(string-2EP1pXo, color2, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:326)");
                }
                androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
                int i16 = 0;
                string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_bottom_sheet_drag_handle_description), traceInProgress2, 0);
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 1620989881, "CC(remember):SheetDefaults.kt#9igjgp");
                Composer composer2 = traceInProgress2;
                int i38 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i39 = 0;
                if (!traceInProgress2.changed(string-2EP1pXo)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new BottomSheetDefaults.DragHandle.1.1(string-2EP1pXo);
                        composer2.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                int i35 = 1;
                BottomSheetDefaults.DragHandle.2 anon2 = new BottomSheetDefaults.DragHandle.2(f, $dirty);
                i3 = -1039573072;
                SurfaceKt.Surface-T9BRK9s(SemanticsModifierKt.semantics$default(PaddingKt.padding-VpY3zN4$default(modifier3, 0, SheetDefaultsKt.access$getDragHandleVerticalPadding$p(), 1, 0), false, (Function1)anon, i35, 0), obj2, l, obj12, 0, i3, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(i3, i35, anon2, traceInProgress2, 54), traceInProgress2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj2;
                shape2 = color2;
                $dirty2 = $dirty;
                height2 = modifier3;
                modifier2 = f;
                width2 = l;
            } else {
                traceInProgress2.skipToGroupEnd();
                composer = traceInProgress2;
                obj = obj2;
                shape2 = $dirty3;
                height2 = dockedDragHandleWidth-D9Ej5fM;
                $dirty2 = semantics$default;
                modifier2 = f;
                width2 = l;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            string-2EP1pXo = new BottomSheetDefaults.DragHandle.3(this, height2, modifier2, $dirty2, obj, width2, str, i27, obj31);
            endRestartGroup.updateScope((Function2)string-2EP1pXo);
        }
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 433375448;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C299@11786L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:299)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerColor(), $composer, 6);
    }

    public final float getElevation-D9Ej5fM() {
        return BottomSheetDefaults.Elevation;
    }

    public final Shape getExpandedShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1683783414;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C295@11623L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:295)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerShape(), $composer, 6);
    }

    public final Shape getHiddenShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1971658024;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C291@11425L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:291)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), $composer, 6);
    }

    public final long getScrimColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2040719176;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C306@12070L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:306)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), $composer, 6), obj3, 1050924810, 0, 0, 0, 14);
    }

    public final float getSheetMaxWidth-D9Ej5fM() {
        return BottomSheetDefaults.SheetMaxWidth;
    }

    public final float getSheetPeekHeight-D9Ej5fM() {
        return BottomSheetDefaults.SheetPeekHeight;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -511309409;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C316@12492L11:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:316)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM());
    }
}
