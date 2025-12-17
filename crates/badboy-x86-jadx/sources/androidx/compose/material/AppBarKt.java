package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aj\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00072\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000c0\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001av\u0010\u001e\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000c0\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\u001an\u0010\u001e\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000c0\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001a\u008c\u0001\u0010$\u001a\u00020\u000c2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u000c0&¢\u0006\u0002\u0008\u001a2\u0006\u0010\u0015\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00072\u0015\u0008\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u000c\u0018\u00010&¢\u0006\u0002\u0008\u001a2\u001e\u0008\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000c0\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a\u0084\u0001\u0010$\u001a\u00020\u000c2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u000c0&¢\u0006\u0002\u0008\u001a2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00072\u0015\u0008\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u000c\u0018\u00010&¢\u0006\u0002\u0008\u001a2\u001e\u0008\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000c0\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,\u001aj\u0010$\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000c0\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001ab\u0010$\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000c0\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008/\u00100\u001a\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202H\u0080\u0008\u001a,\u00105\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202062\u0006\u00107\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u00108\u001a\u000202H\u0000\u001a\u0011\u00109\u001a\u0002022\u0006\u0010:\u001a\u000202H\u0082\u0008\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006;", d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "windowInsets", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-HkEspTQ", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-DanWW-k", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-Rx1qByU", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", "x", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AppBarKt {

    private static final float AppBarHeight;
    private static final float AppBarHorizontalPadding;
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;
    private static final WindowInsets ZeroInsets;
    static {
        int i6 = 0;
        AppBarKt.AppBarHeight = Dp.constructor-impl((float)i);
        int i7 = 0;
        AppBarKt.AppBarHorizontalPadding = Dp.constructor-impl((float)i2);
        int i14 = 0;
        int i17 = 0;
        AppBarKt.TitleInsetWithoutIcon = SizeKt.width-3ABfNKs((Modifier)Modifier.Companion, Dp.constructor-impl($this$dp$iv5 - $i$f$getDp));
        int i16 = 0;
        int i19 = 0;
        AppBarKt.TitleIconModifier = SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default((Modifier)Modifier.Companion, 0, 1, 0), Dp.constructor-impl($this$dp$iv6 - $i$f$getDp2));
        int i11 = 0;
        AppBarKt.BottomAppBarCutoutOffset = Dp.constructor-impl((float)i3);
        int i12 = 0;
        AppBarKt.BottomAppBarRoundedEdgeRadius = Dp.constructor-impl((float)i4);
        int i13 = 0;
        AppBarKt.ZeroInsets = WindowInsetsKt.WindowInsets-a9UjIt4$default(Dp.constructor-impl((float)i5), 0, 0, 0, 14, 0);
    }

    private static final void AppBar-HkEspTQ(long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, Shape shape, WindowInsets windowInsets, Modifier modifier, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        int i2;
        int $dirty2;
        Composer traceInProgress;
        int $dirty3;
        boolean companion;
        boolean traceInProgress2;
        long l;
        int str;
        int i9;
        int i13;
        int i8;
        float f2;
        int i4;
        int i7;
        Object obj;
        int i14;
        int i3;
        Object obj3;
        long l2;
        Object obj2;
        int $dirty;
        Object modifier2;
        int i;
        int i6;
        int i10;
        float f;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i12;
        int i5;
        int obj35;
        final Object obj5 = windowInsets;
        final Object obj6 = content;
        final Object obj7 = $changed;
        final int i38 = obj36;
        final int i39 = obj37;
        traceInProgress = i11.startRestartGroup(-712505634);
        ComposerKt.sourceInformation(traceInProgress, "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,7,5)726@31738L492,720@31571L659:AppBar.kt#jmzs0o");
        $dirty3 = obj36;
        if (i39 & 1 != 0) {
            $dirty3 |= 6;
            l = backgroundColor;
        } else {
            if (i38 & 6 == 0) {
                i13 = traceInProgress.changed(backgroundColor) ? 4 : 2;
                $dirty3 |= i13;
            } else {
                l = backgroundColor;
            }
        }
        if (i39 & 2 != 0) {
            $dirty3 |= 48;
            l2 = elevation;
        } else {
            if (i38 & 48 == 0) {
                i8 = traceInProgress.changed(elevation) ? 32 : 16;
                $dirty3 |= i8;
            } else {
                l2 = elevation;
            }
        }
        if (i39 & 4 != 0) {
            $dirty3 |= 384;
            f2 = shape;
        } else {
            if (i38 & 384 == 0) {
                i4 = traceInProgress.changed(shape) ? 256 : 128;
                $dirty3 |= i4;
            } else {
                f2 = shape;
            }
        }
        if (i39 & 8 != 0) {
            $dirty3 |= 3072;
        } else {
            if (i38 & 3072 == 0) {
                i7 = traceInProgress.changed(obj5) ? 2048 : 1024;
                $dirty3 |= i7;
            }
        }
        if (i39 & 16 != 0) {
            $dirty3 |= 24576;
            obj = modifier;
        } else {
            if (i38 & 24576 == 0) {
                i14 = traceInProgress.changed(modifier) ? 16384 : 8192;
                $dirty3 |= i14;
            } else {
                obj = modifier;
            }
        }
        int i40 = 196608;
        if (i39 & 32 != 0) {
            $dirty3 |= i40;
        } else {
            if (i38 & i40 == 0) {
                i3 = traceInProgress.changed(obj6) ? 131072 : 65536;
                $dirty3 |= i3;
            }
        }
        int i36 = i39 & 64;
        int i41 = 1572864;
        if (i36 != 0) {
            $dirty3 |= i41;
            obj35 = i41;
            modifier2 = $composer;
        } else {
            if (i38 & i41 == 0) {
                obj35 = i41;
                i = traceInProgress.changed($composer) ? 1048576 : 524288;
                $dirty3 |= i;
            } else {
                obj35 = i41;
                modifier2 = $composer;
            }
        }
        i6 = 12582912;
        if (i39 & 128 != 0) {
            $dirty3 |= i6;
        } else {
            if (i38 & i6 == 0) {
                i2 = traceInProgress.changedInstance(obj7) ? 8388608 : 4194304;
                $dirty3 |= i2;
            }
        }
        $dirty2 = $dirty3;
        if ($dirty4 &= $dirty2 == 4793490) {
            if (!traceInProgress.getSkipping()) {
                if (i36 != 0) {
                    modifier2 = companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-712505634, $dirty2, -1, "androidx.compose.material.AppBar (AppBar.kt:719)");
                }
                AppBarKt.AppBar.1 anon = new AppBarKt.AppBar.1(obj6, obj5, obj7);
                l2 = modifier2;
                SurfaceKt.Surface-F-jzlyU(l2, obj, backgroundColor, i, l2, obj18, 0, f2, (Function2)ComposableLambdaKt.rememberComposableLambda(213273114, true, anon, traceInProgress, 54), traceInProgress);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = l2;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                obj3 = modifier2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            companion = $dirty2;
            $dirty = companion;
            $dirty2 = new AppBarKt.AppBar.2(backgroundColor, companion, elevation, i9, shape, obj5, modifier, obj6, obj3, obj7, i38, i39);
            endRestartGroup.updateScope((Function2)$dirty2);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void BottomAppBar-DanWW-k(WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, Shape cutoutShape, float elevation, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj5;
        Object obj4;
        int skipping;
        int defaultsInvalid;
        int colors;
        int bottomAppBarElevation-D9Ej5fM;
        boolean traceInProgress2;
        int $dirty;
        Object $dirty2;
        Object obj;
        int backgroundColor2;
        long backgroundColor4;
        long l3;
        int i14;
        boolean traceInProgress;
        int i10;
        Shape bottomAppBarCutoutShape2;
        int i9;
        Object str;
        int docked;
        long l;
        int i13;
        long contentColor2;
        Object consume;
        Object obj6;
        int changed2;
        long l2;
        float f;
        PaddingValues paddingValues;
        int changed;
        int i6;
        Object obj2;
        long cutoutShape2;
        int backgroundColor3;
        int i7;
        float elevation2;
        int i;
        int i5;
        int i8;
        int i2;
        Object i12;
        Shape bottomAppBarCutoutShape;
        Modifier modifier2;
        Object obj3;
        Composer composer2;
        Composer composer;
        int i3;
        int i4;
        final int i51 = obj37;
        final int i52 = obj38;
        traceInProgress2 = i11.startRestartGroup(382658343);
        ComposerKt.sourceInformation(traceInProgress2, "C(BottomAppBar)P(7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)335@15300L6,336@15349L32,342@15630L7,348@15820L174:AppBar.kt#jmzs0o");
        $dirty = obj37;
        if (i52 & 1 != 0) {
            $dirty |= 6;
            obj = windowInsets;
        } else {
            if (i51 & 6 == 0) {
                i14 = traceInProgress2.changed(windowInsets) ? 4 : 2;
                $dirty |= i14;
            } else {
                obj = windowInsets;
            }
        }
        i9 = i52 & 2;
        if (i9 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i51 & 48 == 0) {
                i13 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty |= i13;
            } else {
                str = modifier;
            }
        }
        if (i51 & 384 == 0) {
            if (i52 & 4 == 0) {
                changed2 = traceInProgress2.changed(backgroundColor) ? 256 : 128;
            } else {
                contentColor2 = backgroundColor;
            }
            $dirty |= changed2;
        } else {
            contentColor2 = backgroundColor;
        }
        if (i51 & 3072 == 0) {
            if (i52 & 8 == 0) {
                changed = traceInProgress2.changed(cutoutShape) ? 2048 : 1024;
            } else {
                l2 = cutoutShape;
            }
            $dirty |= changed;
        } else {
            l2 = cutoutShape;
        }
        i6 = i52 & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            obj2 = contentPadding;
        } else {
            if (i51 & 24576 == 0) {
                i7 = traceInProgress2.changed(contentPadding) ? 16384 : 8192;
                $dirty |= i7;
            } else {
                obj2 = contentPadding;
            }
        }
        int i54 = i52 & 32;
        int i55 = 196608;
        if (i54 != 0) {
            $dirty |= i55;
            elevation2 = content;
        } else {
            if (i55 &= i51 == 0) {
                i = traceInProgress2.changed(content) ? 131072 : 65536;
                $dirty |= i;
            } else {
                elevation2 = content;
            }
        }
        int i57 = i52 & 64;
        i5 = 1572864;
        if (i57 != 0) {
            $dirty |= i5;
            obj5 = $composer;
        } else {
            if (i51 & i5 == 0) {
                i8 = traceInProgress2.changed($composer) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                obj5 = $composer;
            }
        }
        i2 = 12582912;
        if (i52 & 128 != 0) {
            $dirty |= i2;
            obj4 = $changed;
        } else {
            if (i51 & i2 == 0) {
                i2 = traceInProgress2.changedInstance($changed) ? 8388608 : 4194304;
                $dirty |= i2;
            } else {
                obj4 = $changed;
            }
        }
        if ($dirty & i12 == 4793490) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                if (i51 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i52 & 4 != 0) {
                            backgroundColor4 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(traceInProgress2, 6));
                            $dirty &= -897;
                        } else {
                            backgroundColor4 = contentColor2;
                        }
                        if (i52 & 8 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(backgroundColor4, i9, traceInProgress2);
                            $dirty &= -7169;
                        } else {
                            contentColor2 = l2;
                        }
                        if (i6 != 0) {
                            obj2 = bottomAppBarElevation-D9Ej5fM;
                        }
                        if (i54 != 0) {
                            elevation2 = bottomAppBarElevation-D9Ej5fM;
                        }
                        if (i57 != 0) {
                            i12 = contentPadding2;
                            obj3 = str;
                            skipping = obj2;
                            i5 = elevation2;
                            cutoutShape2 = backgroundColor4;
                            elevation2 = contentColor2;
                            backgroundColor2 = 382658343;
                        } else {
                            i12 = $composer;
                            obj3 = str;
                            skipping = obj2;
                            i5 = elevation2;
                            cutoutShape2 = backgroundColor4;
                            elevation2 = contentColor2;
                            backgroundColor2 = 382658343;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i52 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i52 & 8 != 0) {
                            i12 = $composer;
                            $dirty = i20;
                            obj3 = str;
                            skipping = obj2;
                            i5 = elevation2;
                            backgroundColor2 = 382658343;
                            cutoutShape2 = contentColor2;
                            elevation2 = l2;
                        } else {
                            i12 = $composer;
                            obj3 = str;
                            skipping = obj2;
                            i5 = elevation2;
                            backgroundColor2 = 382658343;
                            cutoutShape2 = contentColor2;
                            elevation2 = l2;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(backgroundColor2, $dirty, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:341)");
                }
                i10 = 6;
                docked = 0;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                Object this_$iv = consume;
                if (skipping != null) {
                    i10 = 0;
                    consume = 1;
                    if (this_$iv != null && (FabPlacement)this_$iv.isDocked() == consume) {
                        consume = 1;
                        if (this_$iv.isDocked() == consume) {
                            i10 = consume;
                        }
                    }
                    if (i10 != 0) {
                        bottomAppBarCutoutShape2 = new BottomAppBarCutoutShape(skipping, this_$iv);
                        bottomAppBarCutoutShape = bottomAppBarCutoutShape2;
                    } else {
                        bottomAppBarCutoutShape = bottomAppBarCutoutShape2;
                    }
                } else {
                }
                AppBarKt.AppBar-HkEspTQ(cutoutShape2, i54, elevation2, i57, i5, i12, bottomAppBarCutoutShape, windowInsets, obj3, $changed, traceInProgress2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = skipping;
                l3 = cutoutShape2;
                l = elevation2;
                f = i5;
                paddingValues = i12;
                backgroundColor3 = $dirty;
                $dirty2 = obj3;
            } else {
                traceInProgress2.skipToGroupEnd();
                composer = traceInProgress2;
                l3 = contentColor2;
                obj6 = obj2;
                backgroundColor3 = $dirty;
                $dirty2 = str;
                l = l2;
                f = elevation2;
                paddingValues = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new AppBarKt.BottomAppBar.1(windowInsets, $dirty2, l3, i9, l, contentColor2, obj6, f, paddingValues, $changed, i51, i52);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void BottomAppBar-Y1yfwus(Modifier modifier, long backgroundColor, long contentColor, Shape cutoutShape, float elevation, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        Object obj5;
        int skipping;
        int defaultsInvalid;
        int i12;
        int bottomAppBarElevation-D9Ej5fM;
        Object $composer2;
        int $dirty2;
        int $dirty;
        long $dirty3;
        int i8;
        Object this_$iv;
        Object obj;
        boolean traceInProgress;
        int i5;
        Shape bottomAppBarCutoutShape;
        long l;
        int i4;
        long str;
        int docked;
        Object consume;
        Object obj4;
        int changed;
        long contentColorFor-ek8zF_U;
        float f;
        Object paddingValues;
        int changed2;
        int i14;
        Object cutoutShape2;
        int i3;
        float elevation2;
        int i;
        Object obj2;
        int i7;
        int i6;
        int i11;
        Shape bottomAppBarCutoutShape2;
        int i2;
        WindowInsets zeroInsets;
        Object obj3;
        Composer composer2;
        Composer composer;
        int i13;
        int i9;
        int obj33;
        final int i45 = obj34;
        Composer restartGroup = i10.startRestartGroup(-1651948973);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)403@18483L6,404@18532L32,410@18813L7,416@19003L172:AppBar.kt#jmzs0o");
        $dirty2 = obj34;
        this_$iv = obj35 & 1;
        if (this_$iv != 0) {
            $dirty2 |= 6;
            obj = modifier;
        } else {
            if (i45 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i4;
            } else {
                obj = modifier;
            }
        }
        if (i45 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed = restartGroup.changed(backgroundColor) ? 32 : 16;
            } else {
                str = backgroundColor;
            }
            $dirty2 |= changed;
        } else {
            str = backgroundColor;
        }
        if (i45 & 384 == 0) {
            if (obj35 & 4 == 0) {
                changed2 = restartGroup.changed(cutoutShape) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = cutoutShape;
            }
            $dirty2 |= changed2;
        } else {
            contentColorFor-ek8zF_U = cutoutShape;
        }
        i14 = obj35 & 8;
        if (i14 != 0) {
            $dirty2 |= 3072;
            cutoutShape2 = contentPadding;
        } else {
            if (i45 & 3072 == 0) {
                i3 = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                cutoutShape2 = contentPadding;
            }
        }
        int i47 = obj35 & 16;
        if (i47 != 0) {
            $dirty2 |= 24576;
            elevation2 = content;
        } else {
            if (i45 & 24576 == 0) {
                i = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i;
            } else {
                elevation2 = content;
            }
        }
        int i49 = obj35 & 32;
        int i50 = 196608;
        if (i49 != 0) {
            $dirty2 |= i50;
            obj33 = i50;
            obj2 = $composer;
        } else {
            if (i45 & i50 == 0) {
                obj33 = i50;
                i7 = restartGroup.changed($composer) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                obj33 = i50;
                obj2 = $composer;
            }
        }
        i11 = 1572864;
        if (obj35 & 64 != 0) {
            $dirty2 |= i11;
            obj5 = $changed;
        } else {
            if (i45 & i11 == 0) {
                i11 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i11;
            } else {
                obj5 = $changed;
            }
        }
        i2 = $dirty2;
        if ($dirty2 & i51 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i45 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (this_$iv != 0) {
                            obj = defaultsInvalid;
                        }
                        if (obj35 & 2 != 0) {
                            str = primarySurface;
                            $dirty = i12;
                        } else {
                            $dirty = i2;
                        }
                        if (obj35 & 4 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(str, obj6, restartGroup);
                            $dirty &= -897;
                        }
                        if (i14 != 0) {
                            cutoutShape2 = bottomAppBarElevation-D9Ej5fM;
                        }
                        if (i47 != 0) {
                            elevation2 = bottomAppBarElevation-D9Ej5fM;
                        }
                        if (i49 != 0) {
                            i6 = contentPadding2;
                            obj3 = obj;
                            skipping = cutoutShape2;
                            obj2 = elevation2;
                            i8 = -1651948973;
                            cutoutShape2 = str;
                            elevation2 = contentColorFor-ek8zF_U;
                        } else {
                            obj3 = obj;
                            skipping = cutoutShape2;
                            i6 = obj2;
                            i8 = -1651948973;
                            cutoutShape2 = str;
                            obj2 = elevation2;
                            elevation2 = contentColorFor-ek8zF_U;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty = obj35 & 2 != 0 ? i2 & -113 : i2;
                        if (obj35 & 4 != 0) {
                            $dirty = i19;
                            obj3 = obj;
                            skipping = cutoutShape2;
                            i6 = obj2;
                            i8 = -1651948973;
                            cutoutShape2 = str;
                            obj2 = elevation2;
                            elevation2 = contentColorFor-ek8zF_U;
                        } else {
                            obj3 = obj;
                            skipping = cutoutShape2;
                            i6 = obj2;
                            i8 = -1651948973;
                            cutoutShape2 = str;
                            obj2 = elevation2;
                            elevation2 = contentColorFor-ek8zF_U;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, $dirty, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:409)");
                }
                i5 = 6;
                docked = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                this_$iv = consume;
                if (skipping != null) {
                    i5 = 0;
                    consume = 1;
                    if (this_$iv != null && (FabPlacement)this_$iv.isDocked() == consume) {
                        consume = 1;
                        if (this_$iv.isDocked() == consume) {
                            i5 = consume;
                        }
                    }
                    if (i5 != 0) {
                        bottomAppBarCutoutShape = new BottomAppBarCutoutShape(skipping, this_$iv);
                        bottomAppBarCutoutShape2 = bottomAppBarCutoutShape;
                    } else {
                        bottomAppBarCutoutShape2 = bottomAppBarCutoutShape;
                    }
                } else {
                }
                AppBarKt.AppBar-HkEspTQ(cutoutShape2, i47, elevation2, i49, obj2, i6, bottomAppBarCutoutShape2, AppBarKt.ZeroInsets, obj3, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = skipping;
                i2 = $dirty;
                $dirty3 = cutoutShape2;
                l = elevation2;
                f = obj2;
                paddingValues = i6;
                $composer2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj;
                $dirty3 = str;
                l = contentColorFor-ek8zF_U;
                obj4 = cutoutShape2;
                f = elevation2;
                paddingValues = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new AppBarKt.BottomAppBar.2($composer2, $dirty3, this_$iv, l, str, obj4, f, paddingValues, $changed, i45, obj35);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void TopAppBar-HsRjFd4(Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier2;
        boolean traceInProgress;
        Object $composer2;
        int $dirty;
        long $dirty2;
        int primarySurface;
        int backgroundColor2;
        Object obj;
        long l3;
        int i;
        long l;
        float f;
        int changed2;
        long l2;
        Object obj4;
        int i8;
        int changed;
        long i10;
        float f2;
        int i5;
        int i2;
        long i7;
        Object obj5;
        int i11;
        Object obj3;
        int i6;
        Object i4;
        Shape rectangleShape;
        WindowInsets zeroInsets;
        Object obj2;
        Composer composer2;
        Composer composer;
        int i12;
        int i3;
        final int i41 = obj32;
        Composer restartGroup = i9.startRestartGroup(1897058582);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)269@12098L6,270@12147L32,275@12356L202:AppBar.kt#jmzs0o");
        $dirty = obj32;
        backgroundColor2 = obj33 & 1;
        if (backgroundColor2 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i41 & 6 == 0) {
                i = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i;
            } else {
                obj = modifier;
            }
        }
        if (i41 & 48 == 0) {
            if (obj33 & 2 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 32 : 16;
            } else {
                l = backgroundColor;
            }
            $dirty |= changed2;
        } else {
            l = backgroundColor;
        }
        if (i41 & 384 == 0) {
            if (obj33 & 4 == 0) {
                changed = restartGroup.changed(elevation) ? 256 : 128;
            } else {
                l2 = elevation;
            }
            $dirty |= changed;
        } else {
            l2 = elevation;
        }
        i10 = obj33 & 8;
        if (i10 != 0) {
            $dirty |= 3072;
            f2 = content;
        } else {
            if (i41 & 3072 == 0) {
                i2 = restartGroup.changed(content) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                f2 = content;
            }
        }
        i7 = obj33 & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            obj5 = $composer;
        } else {
            if (i41 & 24576 == 0) {
                i11 = restartGroup.changed($composer) ? 16384 : 8192;
                $dirty |= i11;
            } else {
                obj5 = $composer;
            }
        }
        i6 = 196608;
        if (obj33 & 32 != 0) {
            $dirty |= i6;
            obj3 = $changed;
        } else {
            if (i41 & i6 == 0) {
                i6 = restartGroup.changedInstance($changed) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                obj3 = $changed;
            }
        }
        if (i46 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i41 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (backgroundColor2 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (obj33 & 2 != 0) {
                            $dirty &= -113;
                            l = primarySurface;
                        }
                        if (obj33 & 4 != 0) {
                            $dirty &= -897;
                            l2 = backgroundColor2;
                        }
                        if (i10 != 0) {
                            f2 = backgroundColor2;
                        }
                        if (i7 != 0) {
                            obj2 = modifier2;
                            i4 = backgroundColor2;
                            i7 = l2;
                            obj3 = f2;
                            i10 = l;
                        } else {
                            obj2 = modifier2;
                            obj3 = f2;
                            i4 = obj5;
                            i10 = l;
                            i7 = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj33 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj33 & 4 != 0) {
                            $dirty = modifier2;
                            obj2 = obj;
                            obj3 = f2;
                            i4 = obj5;
                            i10 = l;
                            i7 = l2;
                        } else {
                            obj2 = obj;
                            obj3 = f2;
                            i4 = obj5;
                            i10 = l;
                            i7 = l2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, $dirty, -1, "androidx.compose.material.TopAppBar (AppBar.kt:274)");
                }
                AppBarKt.AppBar-HkEspTQ(i10, f2, i7, obj5, obj3, i4, RectangleShapeKt.getRectangleShape(), AppBarKt.ZeroInsets, obj2, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i5 = $dirty;
                $dirty2 = l4;
                l3 = i7;
                f = obj3;
                obj4 = i4;
                $composer2 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                i5 = $dirty;
                $dirty2 = l;
                f = f3;
                composer = restartGroup;
                $composer2 = obj;
                l3 = l2;
                obj4 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.TopAppBar.5($composer2, $dirty2, backgroundColor2, l3, l, f, obj4, $changed, i41, obj33);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void TopAppBar-Rx1qByU(Function2<? super Composer, ? super Integer, Unit> title, WindowInsets windowInsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, long backgroundColor, long contentColor, float elevation, Composer $composer, int $changed, int i11) {
        long l;
        float f;
        boolean traceInProgress;
        int lambda-1$material_release;
        int colors;
        int topAppBarElevation-D9Ej5fM;
        boolean traceInProgress2;
        int obj8;
        Function2 function2;
        int str;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i8;
        Object obj9;
        Object obj5;
        int i3;
        Object obj;
        int i4;
        Object obj3;
        long l2;
        int i2;
        int i7;
        Object obj2;
        long navigationIcon2;
        int i9;
        Object obj4;
        float actions2;
        int i;
        long primarySurface;
        int backgroundColor2;
        int changed2;
        int i10;
        long i5;
        int changed;
        int contentColor2;
        float f2;
        PaddingValues contentPadding;
        Shape rectangleShape;
        Object obj7;
        Object obj6;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i12;
        int i6;
        obj8 = title;
        final int i43 = obj37;
        final int i44 = obj38;
        restartGroup = i11.startRestartGroup(-763778507);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(6,7,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)90@4376L6,91@4425L32,102@4704L1128,94@4522L1310:AppBar.kt#jmzs0o");
        $dirty2 = obj37;
        if (i44 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i43 & 6 == 0) {
                i8 = restartGroup.changedInstance(obj8) ? 4 : 2;
                $dirty2 |= i8;
            }
        }
        if (i44 & 2 != 0) {
            $dirty2 |= 48;
            obj9 = windowInsets;
        } else {
            if (i43 & 48 == 0) {
                i3 = restartGroup.changed(windowInsets) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                obj9 = windowInsets;
            }
        }
        i4 = i44 & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            obj3 = modifier;
        } else {
            if (i43 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i2;
            } else {
                obj3 = modifier;
            }
        }
        i7 = i44 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            obj2 = navigationIcon;
        } else {
            if (i43 & 3072 == 0) {
                i9 = restartGroup.changedInstance(navigationIcon) ? 2048 : 1024;
                $dirty2 |= i9;
            } else {
                obj2 = navigationIcon;
            }
        }
        int i41 = i44 & 16;
        if (i41 != 0) {
            $dirty2 |= 24576;
            obj4 = actions;
        } else {
            if (i43 & 24576 == 0) {
                i = restartGroup.changedInstance(actions) ? 16384 : 8192;
                $dirty2 |= i;
            } else {
                obj4 = actions;
            }
        }
        if (i45 &= i43 == 0) {
            if (i44 & 32 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 131072 : 65536;
            } else {
                primarySurface = backgroundColor;
            }
            $dirty2 |= changed2;
        } else {
            primarySurface = backgroundColor;
        }
        if (i48 &= i43 == 0) {
            if (i44 & 64 == 0) {
                changed = restartGroup.changed(elevation) ? 1048576 : 524288;
            } else {
                l = elevation;
            }
            $dirty2 |= changed;
        } else {
            l = elevation;
        }
        i5 = i44 & 128;
        contentColor2 = 12582912;
        if (i5 != 0) {
            $dirty2 |= contentColor2;
            f = $changed;
        } else {
            if (i43 & contentColor2 == 0) {
                obj8 = restartGroup.changed($changed) ? 8388608 : 4194304;
                $dirty2 |= obj8;
            } else {
                f = $changed;
            }
        }
        if (i22 &= $dirty2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -3670017;
                contentColor2 = -458753;
                if (i43 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i4 != 0) {
                            obj3 = lambda-1$material_release;
                        }
                        if (i7 != 0) {
                            obj2 = lambda-1$material_release;
                        }
                        if (i41 != 0) {
                            obj4 = lambda-1$material_release;
                        }
                        if (i44 & 32 != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(restartGroup, 6));
                            $dirty2 &= contentColor2;
                        }
                        if (i44 & 64 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(primarySurface, obj14, restartGroup);
                            $dirty2 &= str;
                        } else {
                            contentColor2 = elevation;
                        }
                        if (i5 != 0) {
                            obj6 = obj3;
                            i5 = contentColor2;
                            f2 = topAppBarElevation-D9Ej5fM;
                        } else {
                            obj6 = obj3;
                            i5 = contentColor2;
                            f2 = $changed;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i44 & 32 != 0) {
                            $dirty2 &= contentColor2;
                        }
                        if (i44 & 64 != 0) {
                            i5 = elevation;
                            f2 = $changed;
                            $dirty2 = topAppBarElevation-D9Ej5fM;
                            obj6 = obj3;
                        } else {
                            i5 = elevation;
                            f2 = $changed;
                            obj6 = obj3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-763778507, $dirty2, -1, "androidx.compose.material.TopAppBar (AppBar.kt:93)");
                }
                AppBarKt.TopAppBar.1 anon = new AppBarKt.TopAppBar.1(obj2, title, obj4);
                AppBarKt.AppBar-HkEspTQ(primarySurface, obj14, i5, contentColor2, f2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), obj9, obj6, (Function3)ComposableLambdaKt.rememberComposableLambda(1849684359, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj2;
                obj = obj4;
                l2 = primarySurface;
                navigationIcon2 = i5;
                actions2 = f2;
                backgroundColor2 = $dirty2;
                $dirty = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                backgroundColor2 = $dirty2;
                $dirty = obj3;
                l2 = l3;
                function2 = title;
                composer = restartGroup;
                obj5 = obj2;
                obj = obj4;
                navigationIcon2 = elevation;
                actions2 = $changed;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.TopAppBar.2(function2, windowInsets, $dirty, obj5, obj, l2, i7, navigationIcon2, i41, actions2, i43, i44);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void TopAppBar-afqeVBk(WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress;
        int defaultsInvalid;
        int colors;
        int topAppBarElevation-D9Ej5fM;
        boolean traceInProgress2;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        Object obj3;
        int contentColorFor-ek8zF_U;
        long l3;
        int i14;
        int i5;
        Object obj2;
        long l2;
        int i2;
        long l;
        float f2;
        int changed;
        long l4;
        Object obj;
        int i12;
        int changed2;
        long i7;
        float f;
        int i;
        int i9;
        long i8;
        Object obj6;
        int i13;
        Object obj4;
        int i3;
        Object i11;
        Shape rectangleShape;
        Modifier modifier2;
        Object obj5;
        Composer composer;
        Composer composer2;
        int i6;
        int i4;
        final int i48 = obj34;
        restartGroup = i10.startRestartGroup(883764366);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(6,5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)222@9964L6,223@10013L32,228@10222L204:AppBar.kt#jmzs0o");
        $dirty2 = obj34;
        if (obj35 & 1 != 0) {
            $dirty2 |= 6;
            obj3 = windowInsets;
        } else {
            if (i48 & 6 == 0) {
                i14 = restartGroup.changed(windowInsets) ? 4 : 2;
                $dirty2 |= i14;
            } else {
                obj3 = windowInsets;
            }
        }
        i5 = obj35 & 2;
        if (i5 != 0) {
            $dirty2 |= 48;
            obj2 = modifier;
        } else {
            if (i48 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i2;
            } else {
                obj2 = modifier;
            }
        }
        if (i48 & 384 == 0) {
            if (obj35 & 4 == 0) {
                changed = restartGroup.changed(backgroundColor) ? 256 : 128;
            } else {
                l = backgroundColor;
            }
            $dirty2 |= changed;
        } else {
            l = backgroundColor;
        }
        if (i48 & 3072 == 0) {
            if (obj35 & 8 == 0) {
                changed2 = restartGroup.changed(elevation) ? 2048 : 1024;
            } else {
                l4 = elevation;
            }
            $dirty2 |= changed2;
        } else {
            l4 = elevation;
        }
        i7 = obj35 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            f = content;
        } else {
            if (i48 & 24576 == 0) {
                i9 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i9;
            } else {
                f = content;
            }
        }
        i8 = obj35 & 32;
        int i50 = 196608;
        if (i8 != 0) {
            $dirty2 |= i50;
            obj6 = $composer;
        } else {
            if (i50 &= i48 == 0) {
                i13 = restartGroup.changed($composer) ? 131072 : 65536;
                $dirty2 |= i13;
            } else {
                obj6 = $composer;
            }
        }
        i3 = 1572864;
        if (obj35 & 64 != 0) {
            $dirty2 |= i3;
            obj4 = $changed;
        } else {
            if (i48 & i3 == 0) {
                i3 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i3;
            } else {
                obj4 = $changed;
            }
        }
        if ($dirty2 & i11 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i48 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i5 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (obj35 & 4 != 0) {
                            $dirty2 &= -897;
                            l = contentColorFor-ek8zF_U;
                        }
                        if (obj35 & 8 != 0) {
                            $dirty2 &= -7169;
                            l4 = contentColorFor-ek8zF_U;
                        }
                        if (i7 != 0) {
                            f = topAppBarElevation-D9Ej5fM;
                        }
                        if (i8 != 0) {
                            i11 = topAppBarElevation-D9Ej5fM;
                            obj5 = obj2;
                            i8 = l4;
                            obj4 = f;
                            i7 = l;
                        } else {
                            obj5 = obj2;
                            obj4 = f;
                            i11 = obj6;
                            i7 = l;
                            i8 = l4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj35 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj35 & 8 != 0) {
                            $dirty2 = topAppBarElevation-D9Ej5fM;
                            obj5 = obj2;
                            obj4 = f;
                            i11 = obj6;
                            i7 = l;
                            i8 = l4;
                        } else {
                            obj5 = obj2;
                            obj4 = f;
                            i11 = obj6;
                            i7 = l;
                            i8 = l4;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(883764366, $dirty2, -1, "androidx.compose.material.TopAppBar (AppBar.kt:227)");
                }
                AppBarKt.AppBar-HkEspTQ(i7, f, i8, obj6, obj4, i11, RectangleShapeKt.getRectangleShape(), windowInsets, obj5, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l3 = i7;
                l2 = i8;
                f2 = obj4;
                obj = i11;
                i = $dirty2;
                $dirty = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                l3 = l;
                f2 = f;
                i = $dirty2;
                $dirty = obj2;
                l2 = l4;
                obj = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.TopAppBar.4(windowInsets, $dirty, l3, i5, l2, l, f2, obj, $changed, i48, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void TopAppBar-xWeB9-s(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, long backgroundColor, long contentColor, float elevation, Composer $composer, int $changed, int i10) {
        float f;
        boolean traceInProgress2;
        int lambda-2$material_release;
        int $dirty2;
        int $dirty4;
        int $dirty5;
        Object restartGroup;
        int $dirty3;
        Object $dirty;
        int i2;
        int i;
        Object obj5;
        int i15;
        int i9;
        boolean traceInProgress;
        Object str;
        Object obj3;
        int i3;
        long l2;
        Object obj7;
        int i7;
        long l3;
        Object obj4;
        int i16;
        int i13;
        int i8;
        float f3;
        int changed2;
        int changed;
        Object obj;
        long primarySurface;
        int i12;
        Object obj6;
        long contentColor2;
        Object obj2;
        int i4;
        int i14;
        int i11;
        long l;
        float f2;
        Composer composer;
        int i5;
        int i6;
        final int i52 = obj34;
        restartGroup = i10.startRestartGroup(-2087748139);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)172@7722L6,173@7771L32,176@7867L175:AppBar.kt#jmzs0o");
        $dirty3 = obj34;
        if (obj35 & 1 != 0) {
            $dirty3 |= 6;
            obj = title;
        } else {
            if (i52 & 6 == 0) {
                i = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty3 |= i;
            } else {
                obj = title;
            }
        }
        i15 = obj35 & 2;
        if (i15 != 0) {
            $dirty3 |= 48;
            str = modifier;
        } else {
            if (i52 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i3;
            } else {
                str = modifier;
            }
        }
        int i46 = obj35 & 4;
        if (i46 != 0) {
            $dirty3 |= 384;
            obj7 = navigationIcon;
        } else {
            if (i52 & 384 == 0) {
                i7 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty3 |= i7;
            } else {
                obj7 = navigationIcon;
            }
        }
        int i48 = obj35 & 8;
        if (i48 != 0) {
            $dirty3 |= 3072;
            obj4 = actions;
        } else {
            if (i52 & 3072 == 0) {
                i16 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty3 |= i16;
            } else {
                obj4 = actions;
            }
        }
        if (i52 & 24576 == 0) {
            if (obj35 & 16 == 0) {
                i13 = restartGroup.changed(backgroundColor) ? 16384 : 8192;
            } else {
                primarySurface = backgroundColor;
            }
            $dirty3 |= i13;
        } else {
            primarySurface = backgroundColor;
        }
        if (i50 &= i52 == 0) {
            if (obj35 & 32 == 0) {
                i8 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                contentColor2 = elevation;
            }
            $dirty3 |= i8;
        } else {
            contentColor2 = elevation;
        }
        int i51 = obj35 & 64;
        i4 = 1572864;
        if (i51 != 0) {
            $dirty3 |= i4;
            f = $changed;
        } else {
            if (i52 & i4 == 0) {
                i14 = restartGroup.changed($changed) ? 1048576 : 524288;
                $dirty3 |= i14;
            } else {
                f = $changed;
            }
        }
        final int obj33 = $dirty3;
        if ($dirty3 & i11 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i27 = -458753;
                i11 = -57345;
                if (i52 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            str = lambda-2$material_release;
                        }
                        if (i46 != 0) {
                            obj7 = lambda-2$material_release;
                        }
                        if (i48 != 0) {
                            obj4 = lambda-2$material_release;
                        }
                        if (obj35 & 16 != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(restartGroup, 6));
                            $dirty2 = obj33 & i11;
                        } else {
                            $dirty2 = obj33;
                        }
                        if (obj35 & 32 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(primarySurface, obj13, restartGroup);
                            $dirty2 &= i27;
                        }
                        if (i51 != 0) {
                            f2 = topAppBarElevation-D9Ej5fM;
                            i4 = primarySurface;
                            l = contentColor2;
                            i2 = $dirty2;
                            obj6 = str;
                            contentColor2 = obj7;
                            obj2 = obj4;
                            $dirty5 = -2087748139;
                        } else {
                            f2 = $changed;
                            i2 = $dirty2;
                            i4 = primarySurface;
                            l = contentColor2;
                            $dirty5 = -2087748139;
                            obj6 = str;
                            contentColor2 = obj7;
                            obj2 = obj4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty4 = obj35 & 16 != 0 ? obj33 & i11 : obj33;
                        if (obj35 & 32 != 0) {
                            $dirty4 &= i27;
                        }
                        f2 = $changed;
                        i2 = $dirty4;
                        i4 = primarySurface;
                        l = contentColor2;
                        $dirty5 = -2087748139;
                        obj6 = str;
                        contentColor2 = obj7;
                        obj2 = obj4;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart($dirty5, i2, -1, "androidx.compose.material.TopAppBar (AppBar.kt:175)");
                }
                AppBarKt.TopAppBar-Rx1qByU(obj, AppBarKt.ZeroInsets, obj6, contentColor2, obj2, i4, i11, l, obj19, f2, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i12 = i2;
                $dirty = obj6;
                obj5 = contentColor2;
                obj3 = obj2;
                l2 = i4;
                l3 = l;
                f3 = f2;
            } else {
                restartGroup.skipToGroupEnd();
                f3 = $changed;
                composer = restartGroup;
                $dirty = str;
                obj5 = obj7;
                obj3 = obj4;
                l2 = primarySurface;
                l3 = contentColor2;
                i12 = obj33;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.TopAppBar.3(title, $dirty, obj5, obj3, l2, obj7, l3, obj4, f3, i52, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$AppBar-HkEspTQ(long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, Shape shape, WindowInsets windowInsets, Modifier modifier, Function3 content, Composer $composer, int $changed, int $default) {
        AppBarKt.AppBar-HkEspTQ(backgroundColor, contentColor, elevation, contentPadding, shape, windowInsets, modifier, content, $composer, $changed, $default);
    }

    public static final float access$getAppBarHeight$p() {
        return AppBarKt.AppBarHeight;
    }

    public static final float access$getAppBarHorizontalPadding$p() {
        return AppBarKt.AppBarHorizontalPadding;
    }

    public static final float access$getBottomAppBarCutoutOffset$p() {
        return AppBarKt.BottomAppBarCutoutOffset;
    }

    public static final float access$getBottomAppBarRoundedEdgeRadius$p() {
        return AppBarKt.BottomAppBarRoundedEdgeRadius;
    }

    public static final Modifier access$getTitleIconModifier$p() {
        return AppBarKt.TitleIconModifier;
    }

    public static final Modifier access$getTitleInsetWithoutIcon$p() {
        return AppBarKt.TitleInsetWithoutIcon;
    }

    public static final float calculateCutoutCircleYIntercept(float cutoutRadius, float verticalOffset) {
        final int i = 0;
        int i2 = 0;
        int i5 = 0;
        int $i$f$square2 = verticalOffset * verticalOffset;
        return -f;
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float controlPointX, float verticalOffset, float radius) {
        Pair pair;
        Float valueOf2;
        Float valueOf3;
        Float valueOf;
        float f;
        final int i = controlPointX;
        final int i2 = verticalOffset;
        final int i3 = radius;
        int i4 = 0;
        int i7 = 0;
        int i8 = 0;
        int i13 = 0;
        int i14 = 0;
        i5 *= i10;
        int i11 = 0;
        int i15 = 0;
        $i$f$square4 += $i$f$square7;
        int i16 = 0;
        $i$f$square8 *= i;
        i17 /= i12;
        i19 /= i12;
        int i21 = 0;
        int i23 = 0;
        int $i$f$square11 = i18 * i18;
        float f4 = (float)sqrt3;
        int i24 = 0;
        int i26 = 0;
        int $i$f$square13 = i20 * i20;
        float f5 = (float)sqrt4;
        if (Float.compare(i2, i27) > 0) {
            if (Float.compare(f4, f5) > 0) {
                valueOf3 = Float.valueOf(i18);
                valueOf = Float.valueOf(f4);
            } else {
                valueOf3 = Float.valueOf(i20);
                valueOf = Float.valueOf(f5);
            }
            pair = TuplesKt.to(valueOf3, valueOf);
        } else {
            if (Float.compare(f4, f5) < 0) {
                valueOf2 = Float.valueOf(i18);
                valueOf = Float.valueOf(f4);
            } else {
                valueOf2 = Float.valueOf(i20);
                valueOf = Float.valueOf(f5);
            }
            pair = TuplesKt.to(valueOf2, valueOf);
        }
        float floatValue2 = (Number)pair.component1().floatValue();
        float floatValue = (Number)pair.component2().floatValue();
        f = Float.compare(floatValue2, controlPointX) < 0 ? -floatValue : floatValue;
        return TuplesKt.to(Float.valueOf(floatValue2), Float.valueOf(f));
    }

    private static final float square(float x) {
        final int i = 0;
        return x * x;
    }
}
