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
        int i10;
        int $dirty3;
        Composer traceInProgress;
        int $dirty;
        boolean companion;
        boolean traceInProgress2;
        long l;
        int str;
        int i;
        int i2;
        int i5;
        float f;
        int i13;
        int i7;
        Object obj;
        int i4;
        int i14;
        Object obj2;
        long l2;
        Object obj3;
        int $dirty2;
        Object modifier2;
        int i6;
        int i8;
        int i12;
        float f2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i9;
        int i3;
        int obj35;
        final Object obj5 = windowInsets;
        final Object obj6 = content;
        final Object obj7 = $changed;
        final int i38 = obj36;
        final int i39 = obj37;
        traceInProgress = i11.startRestartGroup(-712505634);
        ComposerKt.sourceInformation(traceInProgress, "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,7,5)726@31738L492,720@31571L659:AppBar.kt#jmzs0o");
        $dirty = obj36;
        if (i39 & 1 != 0) {
            $dirty |= 6;
            l = backgroundColor;
        } else {
            if (i38 & 6 == 0) {
                i2 = traceInProgress.changed(backgroundColor) ? 4 : 2;
                $dirty |= i2;
            } else {
                l = backgroundColor;
            }
        }
        if (i39 & 2 != 0) {
            $dirty |= 48;
            l2 = elevation;
        } else {
            if (i38 & 48 == 0) {
                i5 = traceInProgress.changed(elevation) ? 32 : 16;
                $dirty |= i5;
            } else {
                l2 = elevation;
            }
        }
        if (i39 & 4 != 0) {
            $dirty |= 384;
            f = shape;
        } else {
            if (i38 & 384 == 0) {
                i13 = traceInProgress.changed(shape) ? 256 : 128;
                $dirty |= i13;
            } else {
                f = shape;
            }
        }
        if (i39 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i38 & 3072 == 0) {
                i7 = traceInProgress.changed(obj5) ? 2048 : 1024;
                $dirty |= i7;
            }
        }
        if (i39 & 16 != 0) {
            $dirty |= 24576;
            obj = modifier;
        } else {
            if (i38 & 24576 == 0) {
                i4 = traceInProgress.changed(modifier) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                obj = modifier;
            }
        }
        int i40 = 196608;
        if (i39 & 32 != 0) {
            $dirty |= i40;
        } else {
            if (i38 & i40 == 0) {
                i14 = traceInProgress.changed(obj6) ? 131072 : 65536;
                $dirty |= i14;
            }
        }
        int i36 = i39 & 64;
        int i41 = 1572864;
        if (i36 != 0) {
            $dirty |= i41;
            obj35 = i41;
            modifier2 = $composer;
        } else {
            if (i38 & i41 == 0) {
                obj35 = i41;
                i6 = traceInProgress.changed($composer) ? 1048576 : 524288;
                $dirty |= i6;
            } else {
                obj35 = i41;
                modifier2 = $composer;
            }
        }
        i8 = 12582912;
        if (i39 & 128 != 0) {
            $dirty |= i8;
        } else {
            if (i38 & i8 == 0) {
                i10 = traceInProgress.changedInstance(obj7) ? 8388608 : 4194304;
                $dirty |= i10;
            }
        }
        $dirty3 = $dirty;
        if ($dirty4 &= $dirty3 == 4793490) {
            if (!traceInProgress.getSkipping()) {
                if (i36 != 0) {
                    modifier2 = companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-712505634, $dirty3, -1, "androidx.compose.material.AppBar (AppBar.kt:719)");
                }
                AppBarKt.AppBar.1 anon = new AppBarKt.AppBar.1(obj6, obj5, obj7);
                l2 = modifier2;
                SurfaceKt.Surface-F-jzlyU(l2, obj, backgroundColor, i6, l2, obj18, 0, f, (Function2)ComposableLambdaKt.rememberComposableLambda(213273114, true, anon, traceInProgress, 54), traceInProgress);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = l2;
            } else {
                traceInProgress.skipToGroupEnd();
                composer = traceInProgress;
                obj2 = modifier2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            companion = $dirty3;
            $dirty2 = companion;
            $dirty3 = new AppBarKt.AppBar.2(backgroundColor, companion, elevation, i, shape, obj5, modifier, obj6, obj2, obj7, i38, i39);
            endRestartGroup.updateScope((Function2)$dirty3);
        } else {
            $dirty2 = $dirty3;
        }
    }

    public static final void BottomAppBar-DanWW-k(WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, Shape cutoutShape, float elevation, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj4;
        Object obj5;
        int skipping;
        int defaultsInvalid;
        int colors;
        int bottomAppBarElevation-D9Ej5fM;
        boolean traceInProgress2;
        int $dirty2;
        Object $dirty;
        Object obj3;
        int backgroundColor3;
        long backgroundColor2;
        long l3;
        int i12;
        boolean traceInProgress;
        int i9;
        Shape bottomAppBarCutoutShape;
        int i3;
        Object str;
        int docked;
        long l;
        int i13;
        long contentColor2;
        Object consume;
        Object obj;
        int changed;
        long l2;
        float f;
        PaddingValues paddingValues;
        int changed2;
        int i14;
        Object obj6;
        long cutoutShape2;
        int backgroundColor4;
        int i7;
        float elevation2;
        int i8;
        int i4;
        int i5;
        int i10;
        Object i6;
        Shape bottomAppBarCutoutShape2;
        Modifier modifier2;
        Object obj2;
        Composer composer;
        Composer composer2;
        int i2;
        int i;
        final int i51 = obj37;
        final int i52 = obj38;
        traceInProgress2 = i11.startRestartGroup(382658343);
        ComposerKt.sourceInformation(traceInProgress2, "C(BottomAppBar)P(7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)335@15300L6,336@15349L32,342@15630L7,348@15820L174:AppBar.kt#jmzs0o");
        $dirty2 = obj37;
        if (i52 & 1 != 0) {
            $dirty2 |= 6;
            obj3 = windowInsets;
        } else {
            if (i51 & 6 == 0) {
                i12 = traceInProgress2.changed(windowInsets) ? 4 : 2;
                $dirty2 |= i12;
            } else {
                obj3 = windowInsets;
            }
        }
        i3 = i52 & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i51 & 48 == 0) {
                i13 = traceInProgress2.changed(modifier) ? 32 : 16;
                $dirty2 |= i13;
            } else {
                str = modifier;
            }
        }
        if (i51 & 384 == 0) {
            if (i52 & 4 == 0) {
                changed = traceInProgress2.changed(backgroundColor) ? 256 : 128;
            } else {
                contentColor2 = backgroundColor;
            }
            $dirty2 |= changed;
        } else {
            contentColor2 = backgroundColor;
        }
        if (i51 & 3072 == 0) {
            if (i52 & 8 == 0) {
                changed2 = traceInProgress2.changed(cutoutShape) ? 2048 : 1024;
            } else {
                l2 = cutoutShape;
            }
            $dirty2 |= changed2;
        } else {
            l2 = cutoutShape;
        }
        i14 = i52 & 16;
        if (i14 != 0) {
            $dirty2 |= 24576;
            obj6 = contentPadding;
        } else {
            if (i51 & 24576 == 0) {
                i7 = traceInProgress2.changed(contentPadding) ? 16384 : 8192;
                $dirty2 |= i7;
            } else {
                obj6 = contentPadding;
            }
        }
        int i54 = i52 & 32;
        int i55 = 196608;
        if (i54 != 0) {
            $dirty2 |= i55;
            elevation2 = content;
        } else {
            if (i55 &= i51 == 0) {
                i8 = traceInProgress2.changed(content) ? 131072 : 65536;
                $dirty2 |= i8;
            } else {
                elevation2 = content;
            }
        }
        int i57 = i52 & 64;
        i4 = 1572864;
        if (i57 != 0) {
            $dirty2 |= i4;
            obj4 = $composer;
        } else {
            if (i51 & i4 == 0) {
                i5 = traceInProgress2.changed($composer) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                obj4 = $composer;
            }
        }
        i10 = 12582912;
        if (i52 & 128 != 0) {
            $dirty2 |= i10;
            obj5 = $changed;
        } else {
            if (i51 & i10 == 0) {
                i10 = traceInProgress2.changedInstance($changed) ? 8388608 : 4194304;
                $dirty2 |= i10;
            } else {
                obj5 = $changed;
            }
        }
        if ($dirty2 & i6 == 4793490) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                if (i51 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (i3 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i52 & 4 != 0) {
                            backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(traceInProgress2, 6));
                            $dirty2 &= -897;
                        } else {
                            backgroundColor2 = contentColor2;
                        }
                        if (i52 & 8 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(backgroundColor2, i3, traceInProgress2);
                            $dirty2 &= -7169;
                        } else {
                            contentColor2 = l2;
                        }
                        if (i14 != 0) {
                            obj6 = bottomAppBarElevation-D9Ej5fM;
                        }
                        if (i54 != 0) {
                            elevation2 = bottomAppBarElevation-D9Ej5fM;
                        }
                        if (i57 != 0) {
                            i6 = contentPadding2;
                            obj2 = str;
                            skipping = obj6;
                            i4 = elevation2;
                            cutoutShape2 = backgroundColor2;
                            elevation2 = contentColor2;
                            backgroundColor3 = 382658343;
                        } else {
                            i6 = $composer;
                            obj2 = str;
                            skipping = obj6;
                            i4 = elevation2;
                            cutoutShape2 = backgroundColor2;
                            elevation2 = contentColor2;
                            backgroundColor3 = 382658343;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i52 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i52 & 8 != 0) {
                            i6 = $composer;
                            $dirty2 = i20;
                            obj2 = str;
                            skipping = obj6;
                            i4 = elevation2;
                            backgroundColor3 = 382658343;
                            cutoutShape2 = contentColor2;
                            elevation2 = l2;
                        } else {
                            i6 = $composer;
                            obj2 = str;
                            skipping = obj6;
                            i4 = elevation2;
                            backgroundColor3 = 382658343;
                            cutoutShape2 = contentColor2;
                            elevation2 = l2;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(backgroundColor3, $dirty2, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:341)");
                }
                i9 = 6;
                docked = 0;
                ComposerKt.sourceInformationMarkerStart(traceInProgress2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                Object this_$iv = consume;
                if (skipping != null) {
                    i9 = 0;
                    consume = 1;
                    if (this_$iv != null && (FabPlacement)this_$iv.isDocked() == consume) {
                        consume = 1;
                        if (this_$iv.isDocked() == consume) {
                            i9 = consume;
                        }
                    }
                    if (i9 != 0) {
                        bottomAppBarCutoutShape = new BottomAppBarCutoutShape(skipping, this_$iv);
                        bottomAppBarCutoutShape2 = bottomAppBarCutoutShape;
                    } else {
                        bottomAppBarCutoutShape2 = bottomAppBarCutoutShape;
                    }
                } else {
                }
                AppBarKt.AppBar-HkEspTQ(cutoutShape2, i54, elevation2, i57, i4, i6, bottomAppBarCutoutShape2, windowInsets, obj2, $changed, traceInProgress2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = skipping;
                l3 = cutoutShape2;
                l = elevation2;
                f = i4;
                paddingValues = i6;
                backgroundColor4 = $dirty2;
                $dirty = obj2;
            } else {
                traceInProgress2.skipToGroupEnd();
                composer2 = traceInProgress2;
                l3 = contentColor2;
                obj = obj6;
                backgroundColor4 = $dirty2;
                $dirty = str;
                l = l2;
                f = elevation2;
                paddingValues = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new AppBarKt.BottomAppBar.1(windowInsets, $dirty, l3, i3, l, contentColor2, obj, f, paddingValues, $changed, i51, i52);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void BottomAppBar-Y1yfwus(Modifier modifier, long backgroundColor, long contentColor, Shape cutoutShape, float elevation, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        Object obj5;
        int skipping;
        int defaultsInvalid;
        int i4;
        int bottomAppBarElevation-D9Ej5fM;
        Object $composer2;
        int $dirty2;
        int $dirty3;
        long $dirty;
        int i8;
        Object this_$iv;
        Object obj3;
        boolean traceInProgress;
        int i7;
        Shape bottomAppBarCutoutShape;
        long l;
        int i9;
        long str;
        int docked;
        Object consume;
        Object obj4;
        int changed2;
        long contentColorFor-ek8zF_U;
        float f;
        Object paddingValues;
        int changed;
        int i13;
        Object cutoutShape2;
        int i14;
        float elevation2;
        int i12;
        Object obj;
        int i6;
        int i3;
        int i;
        Shape bottomAppBarCutoutShape2;
        int i2;
        WindowInsets zeroInsets;
        Object obj2;
        Composer composer2;
        Composer composer;
        int i11;
        int i5;
        int obj33;
        final int i45 = obj34;
        Composer restartGroup = i10.startRestartGroup(-1651948973);
        ComposerKt.sourceInformation(restartGroup, "C(BottomAppBar)P(6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)403@18483L6,404@18532L32,410@18813L7,416@19003L172:AppBar.kt#jmzs0o");
        $dirty2 = obj34;
        this_$iv = obj35 & 1;
        if (this_$iv != 0) {
            $dirty2 |= 6;
            obj3 = modifier;
        } else {
            if (i45 & 6 == 0) {
                i9 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i9;
            } else {
                obj3 = modifier;
            }
        }
        if (i45 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 32 : 16;
            } else {
                str = backgroundColor;
            }
            $dirty2 |= changed2;
        } else {
            str = backgroundColor;
        }
        if (i45 & 384 == 0) {
            if (obj35 & 4 == 0) {
                changed = restartGroup.changed(cutoutShape) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = cutoutShape;
            }
            $dirty2 |= changed;
        } else {
            contentColorFor-ek8zF_U = cutoutShape;
        }
        i13 = obj35 & 8;
        if (i13 != 0) {
            $dirty2 |= 3072;
            cutoutShape2 = contentPadding;
        } else {
            if (i45 & 3072 == 0) {
                i14 = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty2 |= i14;
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
                i12 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i12;
            } else {
                elevation2 = content;
            }
        }
        int i49 = obj35 & 32;
        int i50 = 196608;
        if (i49 != 0) {
            $dirty2 |= i50;
            obj33 = i50;
            obj = $composer;
        } else {
            if (i45 & i50 == 0) {
                obj33 = i50;
                i6 = restartGroup.changed($composer) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                obj33 = i50;
                obj = $composer;
            }
        }
        i = 1572864;
        if (obj35 & 64 != 0) {
            $dirty2 |= i;
            obj5 = $changed;
        } else {
            if (i45 & i == 0) {
                i = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i;
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
                            obj3 = defaultsInvalid;
                        }
                        if (obj35 & 2 != 0) {
                            str = primarySurface;
                            $dirty3 = i4;
                        } else {
                            $dirty3 = i2;
                        }
                        if (obj35 & 4 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(str, obj6, restartGroup);
                            $dirty3 &= -897;
                        }
                        if (i13 != 0) {
                            cutoutShape2 = bottomAppBarElevation-D9Ej5fM;
                        }
                        if (i47 != 0) {
                            elevation2 = bottomAppBarElevation-D9Ej5fM;
                        }
                        if (i49 != 0) {
                            i3 = contentPadding2;
                            obj2 = obj3;
                            skipping = cutoutShape2;
                            obj = elevation2;
                            i8 = -1651948973;
                            cutoutShape2 = str;
                            elevation2 = contentColorFor-ek8zF_U;
                        } else {
                            obj2 = obj3;
                            skipping = cutoutShape2;
                            i3 = obj;
                            i8 = -1651948973;
                            cutoutShape2 = str;
                            obj = elevation2;
                            elevation2 = contentColorFor-ek8zF_U;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty3 = obj35 & 2 != 0 ? i2 & -113 : i2;
                        if (obj35 & 4 != 0) {
                            $dirty3 = i19;
                            obj2 = obj3;
                            skipping = cutoutShape2;
                            i3 = obj;
                            i8 = -1651948973;
                            cutoutShape2 = str;
                            obj = elevation2;
                            elevation2 = contentColorFor-ek8zF_U;
                        } else {
                            obj2 = obj3;
                            skipping = cutoutShape2;
                            i3 = obj;
                            i8 = -1651948973;
                            cutoutShape2 = str;
                            obj = elevation2;
                            elevation2 = contentColorFor-ek8zF_U;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, $dirty3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:409)");
                }
                i7 = 6;
                docked = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                this_$iv = consume;
                if (skipping != null) {
                    i7 = 0;
                    consume = 1;
                    if (this_$iv != null && (FabPlacement)this_$iv.isDocked() == consume) {
                        consume = 1;
                        if (this_$iv.isDocked() == consume) {
                            i7 = consume;
                        }
                    }
                    if (i7 != 0) {
                        bottomAppBarCutoutShape = new BottomAppBarCutoutShape(skipping, this_$iv);
                        bottomAppBarCutoutShape2 = bottomAppBarCutoutShape;
                    } else {
                        bottomAppBarCutoutShape2 = bottomAppBarCutoutShape;
                    }
                } else {
                }
                AppBarKt.AppBar-HkEspTQ(cutoutShape2, i47, elevation2, i49, obj, i3, bottomAppBarCutoutShape2, AppBarKt.ZeroInsets, obj2, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = skipping;
                i2 = $dirty3;
                $dirty = cutoutShape2;
                l = elevation2;
                f = obj;
                paddingValues = i3;
                $composer2 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj3;
                $dirty = str;
                l = contentColorFor-ek8zF_U;
                obj4 = cutoutShape2;
                f = elevation2;
                paddingValues = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new AppBarKt.BottomAppBar.2($composer2, $dirty, this_$iv, l, str, obj4, f, paddingValues, $changed, i45, obj35);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void TopAppBar-HsRjFd4(Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        int defaultsInvalid;
        Object modifier2;
        boolean traceInProgress2;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int primarySurface;
        int backgroundColor2;
        Object obj3;
        long l;
        int i11;
        long l2;
        float f2;
        int changed;
        long l3;
        Object obj;
        int i5;
        int changed2;
        long i7;
        float f;
        int i4;
        int i10;
        long i;
        Object obj2;
        int i8;
        Object obj5;
        int i2;
        Object i3;
        Shape rectangleShape;
        WindowInsets zeroInsets;
        Object obj4;
        Composer composer2;
        Composer composer;
        int i6;
        int i12;
        final int i41 = obj32;
        Composer restartGroup = i9.startRestartGroup(1897058582);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)269@12098L6,270@12147L32,275@12356L202:AppBar.kt#jmzs0o");
        $dirty2 = obj32;
        backgroundColor2 = obj33 & 1;
        if (backgroundColor2 != 0) {
            $dirty2 |= 6;
            obj3 = modifier;
        } else {
            if (i41 & 6 == 0) {
                i11 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i11;
            } else {
                obj3 = modifier;
            }
        }
        if (i41 & 48 == 0) {
            if (obj33 & 2 == 0) {
                changed = restartGroup.changed(backgroundColor) ? 32 : 16;
            } else {
                l2 = backgroundColor;
            }
            $dirty2 |= changed;
        } else {
            l2 = backgroundColor;
        }
        if (i41 & 384 == 0) {
            if (obj33 & 4 == 0) {
                changed2 = restartGroup.changed(elevation) ? 256 : 128;
            } else {
                l3 = elevation;
            }
            $dirty2 |= changed2;
        } else {
            l3 = elevation;
        }
        i7 = obj33 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            f = content;
        } else {
            if (i41 & 3072 == 0) {
                i10 = restartGroup.changed(content) ? 2048 : 1024;
                $dirty2 |= i10;
            } else {
                f = content;
            }
        }
        i = obj33 & 16;
        if (i != 0) {
            $dirty2 |= 24576;
            obj2 = $composer;
        } else {
            if (i41 & 24576 == 0) {
                i8 = restartGroup.changed($composer) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                obj2 = $composer;
            }
        }
        i2 = 196608;
        if (obj33 & 32 != 0) {
            $dirty2 |= i2;
            obj5 = $changed;
        } else {
            if (i41 & i2 == 0) {
                i2 = restartGroup.changedInstance($changed) ? 131072 : 65536;
                $dirty2 |= i2;
            } else {
                obj5 = $changed;
            }
        }
        if (i46 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i41 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (backgroundColor2 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj3;
                        }
                        if (obj33 & 2 != 0) {
                            $dirty2 &= -113;
                            l2 = primarySurface;
                        }
                        if (obj33 & 4 != 0) {
                            $dirty2 &= -897;
                            l3 = backgroundColor2;
                        }
                        if (i7 != 0) {
                            f = backgroundColor2;
                        }
                        if (i != 0) {
                            obj4 = modifier2;
                            i3 = backgroundColor2;
                            i = l3;
                            obj5 = f;
                            i7 = l2;
                        } else {
                            obj4 = modifier2;
                            obj5 = f;
                            i3 = obj2;
                            i7 = l2;
                            i = l3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj33 & 2 != 0) {
                            $dirty2 &= -113;
                        }
                        if (obj33 & 4 != 0) {
                            $dirty2 = modifier2;
                            obj4 = obj3;
                            obj5 = f;
                            i3 = obj2;
                            i7 = l2;
                            i = l3;
                        } else {
                            obj4 = obj3;
                            obj5 = f;
                            i3 = obj2;
                            i7 = l2;
                            i = l3;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1897058582, $dirty2, -1, "androidx.compose.material.TopAppBar (AppBar.kt:274)");
                }
                AppBarKt.AppBar-HkEspTQ(i7, f, i, obj2, obj5, i3, RectangleShapeKt.getRectangleShape(), AppBarKt.ZeroInsets, obj4, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = $dirty2;
                $dirty = l4;
                l = i;
                f2 = obj5;
                obj = i3;
                $composer2 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                i4 = $dirty2;
                $dirty = l2;
                f2 = f3;
                composer = restartGroup;
                $composer2 = obj3;
                l = l3;
                obj = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.TopAppBar.5($composer2, $dirty, backgroundColor2, l, l2, f2, obj, $changed, i41, obj33);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void TopAppBar-Rx1qByU(Function2<? super Composer, ? super Integer, Unit> title, WindowInsets windowInsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, long backgroundColor, long contentColor, float elevation, Composer $composer, int $changed, int i11) {
        long l2;
        float f2;
        boolean traceInProgress;
        int lambda-1$material_release;
        int colors;
        int topAppBarElevation-D9Ej5fM;
        boolean traceInProgress2;
        int obj9;
        Function2 function2;
        int str;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int i2;
        Object obj;
        Object obj5;
        int i10;
        Object obj8;
        int i8;
        Object obj6;
        long l;
        int i5;
        int i4;
        Object obj4;
        long navigationIcon2;
        int i6;
        Object obj7;
        float actions2;
        int i3;
        long primarySurface;
        int backgroundColor2;
        int changed;
        int i7;
        long i12;
        int changed2;
        int contentColor2;
        float f;
        PaddingValues contentPadding;
        Shape rectangleShape;
        Object obj3;
        Object obj2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i;
        int i9;
        obj9 = title;
        final int i43 = obj37;
        final int i44 = obj38;
        restartGroup = i11.startRestartGroup(-763778507);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(6,7,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)90@4376L6,91@4425L32,102@4704L1128,94@4522L1310:AppBar.kt#jmzs0o");
        $dirty2 = obj37;
        if (i44 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i43 & 6 == 0) {
                i2 = restartGroup.changedInstance(obj9) ? 4 : 2;
                $dirty2 |= i2;
            }
        }
        if (i44 & 2 != 0) {
            $dirty2 |= 48;
            obj = windowInsets;
        } else {
            if (i43 & 48 == 0) {
                i10 = restartGroup.changed(windowInsets) ? 32 : 16;
                $dirty2 |= i10;
            } else {
                obj = windowInsets;
            }
        }
        i8 = i44 & 4;
        if (i8 != 0) {
            $dirty2 |= 384;
            obj6 = modifier;
        } else {
            if (i43 & 384 == 0) {
                i5 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i5;
            } else {
                obj6 = modifier;
            }
        }
        i4 = i44 & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            obj4 = navigationIcon;
        } else {
            if (i43 & 3072 == 0) {
                i6 = restartGroup.changedInstance(navigationIcon) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                obj4 = navigationIcon;
            }
        }
        int i41 = i44 & 16;
        if (i41 != 0) {
            $dirty2 |= 24576;
            obj7 = actions;
        } else {
            if (i43 & 24576 == 0) {
                i3 = restartGroup.changedInstance(actions) ? 16384 : 8192;
                $dirty2 |= i3;
            } else {
                obj7 = actions;
            }
        }
        if (i45 &= i43 == 0) {
            if (i44 & 32 == 0) {
                changed = restartGroup.changed(backgroundColor) ? 131072 : 65536;
            } else {
                primarySurface = backgroundColor;
            }
            $dirty2 |= changed;
        } else {
            primarySurface = backgroundColor;
        }
        if (i48 &= i43 == 0) {
            if (i44 & 64 == 0) {
                changed2 = restartGroup.changed(elevation) ? 1048576 : 524288;
            } else {
                l2 = elevation;
            }
            $dirty2 |= changed2;
        } else {
            l2 = elevation;
        }
        i12 = i44 & 128;
        contentColor2 = 12582912;
        if (i12 != 0) {
            $dirty2 |= contentColor2;
            f2 = $changed;
        } else {
            if (i43 & contentColor2 == 0) {
                obj9 = restartGroup.changed($changed) ? 8388608 : 4194304;
                $dirty2 |= obj9;
            } else {
                f2 = $changed;
            }
        }
        if (i22 &= $dirty2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                str = -3670017;
                contentColor2 = -458753;
                if (i43 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            obj6 = lambda-1$material_release;
                        }
                        if (i4 != 0) {
                            obj4 = lambda-1$material_release;
                        }
                        if (i41 != 0) {
                            obj7 = lambda-1$material_release;
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
                        if (i12 != 0) {
                            obj2 = obj6;
                            i12 = contentColor2;
                            f = topAppBarElevation-D9Ej5fM;
                        } else {
                            obj2 = obj6;
                            i12 = contentColor2;
                            f = $changed;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i44 & 32 != 0) {
                            $dirty2 &= contentColor2;
                        }
                        if (i44 & 64 != 0) {
                            i12 = elevation;
                            f = $changed;
                            $dirty2 = topAppBarElevation-D9Ej5fM;
                            obj2 = obj6;
                        } else {
                            i12 = elevation;
                            f = $changed;
                            obj2 = obj6;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-763778507, $dirty2, -1, "androidx.compose.material.TopAppBar (AppBar.kt:93)");
                }
                AppBarKt.TopAppBar.1 anon = new AppBarKt.TopAppBar.1(obj4, title, obj7);
                AppBarKt.AppBar-HkEspTQ(primarySurface, obj14, i12, contentColor2, f, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), obj, obj2, (Function3)ComposableLambdaKt.rememberComposableLambda(1849684359, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj4;
                obj8 = obj7;
                l = primarySurface;
                navigationIcon2 = i12;
                actions2 = f;
                backgroundColor2 = $dirty2;
                $dirty = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                backgroundColor2 = $dirty2;
                $dirty = obj6;
                l = l3;
                function2 = title;
                composer = restartGroup;
                obj5 = obj4;
                obj8 = obj7;
                navigationIcon2 = elevation;
                actions2 = $changed;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AppBarKt.TopAppBar.2(function2, windowInsets, $dirty, obj5, obj8, l, i4, navigationIcon2, i41, actions2, i43, i44);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void TopAppBar-afqeVBk(WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, float elevation, PaddingValues contentPadding, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        int defaultsInvalid;
        int colors;
        int topAppBarElevation-D9Ej5fM;
        boolean traceInProgress;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        Object obj3;
        int contentColorFor-ek8zF_U;
        long l2;
        int i7;
        int i11;
        Object obj4;
        long l3;
        int i13;
        long l;
        float f;
        int changed;
        long l4;
        Object obj6;
        int i5;
        int changed2;
        long i3;
        float f2;
        int i6;
        int i4;
        long i2;
        Object obj;
        int i14;
        Object obj5;
        int i12;
        Object i;
        Shape rectangleShape;
        Modifier modifier2;
        Object obj2;
        Composer composer2;
        Composer composer;
        int i8;
        int i9;
        final int i48 = obj34;
        restartGroup = i10.startRestartGroup(883764366);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(6,5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)222@9964L6,223@10013L32,228@10222L204:AppBar.kt#jmzs0o");
        $dirty2 = obj34;
        if (obj35 & 1 != 0) {
            $dirty2 |= 6;
            obj3 = windowInsets;
        } else {
            if (i48 & 6 == 0) {
                i7 = restartGroup.changed(windowInsets) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                obj3 = windowInsets;
            }
        }
        i11 = obj35 & 2;
        if (i11 != 0) {
            $dirty2 |= 48;
            obj4 = modifier;
        } else {
            if (i48 & 48 == 0) {
                i13 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i13;
            } else {
                obj4 = modifier;
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
        i3 = obj35 & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            f2 = content;
        } else {
            if (i48 & 24576 == 0) {
                i4 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                f2 = content;
            }
        }
        i2 = obj35 & 32;
        int i50 = 196608;
        if (i2 != 0) {
            $dirty2 |= i50;
            obj = $composer;
        } else {
            if (i50 &= i48 == 0) {
                i14 = restartGroup.changed($composer) ? 131072 : 65536;
                $dirty2 |= i14;
            } else {
                obj = $composer;
            }
        }
        i12 = 1572864;
        if (obj35 & 64 != 0) {
            $dirty2 |= i12;
            obj5 = $changed;
        } else {
            if (i48 & i12 == 0) {
                i12 = restartGroup.changedInstance($changed) ? 1048576 : 524288;
                $dirty2 |= i12;
            } else {
                obj5 = $changed;
            }
        }
        if ($dirty2 & i == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i48 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        if (obj35 & 4 != 0) {
                            $dirty2 &= -897;
                            l = contentColorFor-ek8zF_U;
                        }
                        if (obj35 & 8 != 0) {
                            $dirty2 &= -7169;
                            l4 = contentColorFor-ek8zF_U;
                        }
                        if (i3 != 0) {
                            f2 = topAppBarElevation-D9Ej5fM;
                        }
                        if (i2 != 0) {
                            i = topAppBarElevation-D9Ej5fM;
                            obj2 = obj4;
                            i2 = l4;
                            obj5 = f2;
                            i3 = l;
                        } else {
                            obj2 = obj4;
                            obj5 = f2;
                            i = obj;
                            i3 = l;
                            i2 = l4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj35 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj35 & 8 != 0) {
                            $dirty2 = topAppBarElevation-D9Ej5fM;
                            obj2 = obj4;
                            obj5 = f2;
                            i = obj;
                            i3 = l;
                            i2 = l4;
                        } else {
                            obj2 = obj4;
                            obj5 = f2;
                            i = obj;
                            i3 = l;
                            i2 = l4;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(883764366, $dirty2, -1, "androidx.compose.material.TopAppBar (AppBar.kt:227)");
                }
                AppBarKt.AppBar-HkEspTQ(i3, f2, i2, obj, obj5, i, RectangleShapeKt.getRectangleShape(), windowInsets, obj2, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l2 = i3;
                l3 = i2;
                f = obj5;
                obj6 = i;
                i6 = $dirty2;
                $dirty = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                l2 = l;
                f = f2;
                i6 = $dirty2;
                $dirty = obj4;
                l3 = l4;
                obj6 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.TopAppBar.4(windowInsets, $dirty, l2, i11, l3, l, f, obj6, $changed, i48, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void TopAppBar-xWeB9-s(Function2<? super Composer, ? super Integer, Unit> title, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> navigationIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> actions, long backgroundColor, long contentColor, float elevation, Composer $composer, int $changed, int i10) {
        float f2;
        boolean traceInProgress2;
        int lambda-2$material_release;
        int $dirty5;
        int $dirty4;
        int $dirty2;
        Object restartGroup;
        int $dirty3;
        Object $dirty;
        int i8;
        int i3;
        Object obj7;
        int i13;
        int i16;
        boolean traceInProgress;
        Object str;
        Object obj6;
        int i5;
        long l3;
        Object obj4;
        int i7;
        long l2;
        Object obj;
        int i14;
        int i2;
        int i12;
        float f3;
        int changed2;
        int changed;
        Object obj5;
        long primarySurface;
        int i4;
        Object obj2;
        long contentColor2;
        Object obj3;
        int i;
        int i11;
        int i15;
        long l;
        float f;
        Composer composer;
        int i9;
        int i6;
        final int i52 = obj34;
        restartGroup = i10.startRestartGroup(-2087748139);
        ComposerKt.sourceInformation(restartGroup, "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)172@7722L6,173@7771L32,176@7867L175:AppBar.kt#jmzs0o");
        $dirty3 = obj34;
        if (obj35 & 1 != 0) {
            $dirty3 |= 6;
            obj5 = title;
        } else {
            if (i52 & 6 == 0) {
                i3 = restartGroup.changedInstance(title) ? 4 : 2;
                $dirty3 |= i3;
            } else {
                obj5 = title;
            }
        }
        i13 = obj35 & 2;
        if (i13 != 0) {
            $dirty3 |= 48;
            str = modifier;
        } else {
            if (i52 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i5;
            } else {
                str = modifier;
            }
        }
        int i46 = obj35 & 4;
        if (i46 != 0) {
            $dirty3 |= 384;
            obj4 = navigationIcon;
        } else {
            if (i52 & 384 == 0) {
                i7 = restartGroup.changedInstance(navigationIcon) ? 256 : 128;
                $dirty3 |= i7;
            } else {
                obj4 = navigationIcon;
            }
        }
        int i48 = obj35 & 8;
        if (i48 != 0) {
            $dirty3 |= 3072;
            obj = actions;
        } else {
            if (i52 & 3072 == 0) {
                i14 = restartGroup.changedInstance(actions) ? 2048 : 1024;
                $dirty3 |= i14;
            } else {
                obj = actions;
            }
        }
        if (i52 & 24576 == 0) {
            if (obj35 & 16 == 0) {
                i2 = restartGroup.changed(backgroundColor) ? 16384 : 8192;
            } else {
                primarySurface = backgroundColor;
            }
            $dirty3 |= i2;
        } else {
            primarySurface = backgroundColor;
        }
        if (i50 &= i52 == 0) {
            if (obj35 & 32 == 0) {
                i12 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                contentColor2 = elevation;
            }
            $dirty3 |= i12;
        } else {
            contentColor2 = elevation;
        }
        int i51 = obj35 & 64;
        i = 1572864;
        if (i51 != 0) {
            $dirty3 |= i;
            f2 = $changed;
        } else {
            if (i52 & i == 0) {
                i11 = restartGroup.changed($changed) ? 1048576 : 524288;
                $dirty3 |= i11;
            } else {
                f2 = $changed;
            }
        }
        final int obj33 = $dirty3;
        if ($dirty3 & i15 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i27 = -458753;
                i15 = -57345;
                if (i52 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            str = lambda-2$material_release;
                        }
                        if (i46 != 0) {
                            obj4 = lambda-2$material_release;
                        }
                        if (i48 != 0) {
                            obj = lambda-2$material_release;
                        }
                        if (obj35 & 16 != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(restartGroup, 6));
                            $dirty5 = obj33 & i15;
                        } else {
                            $dirty5 = obj33;
                        }
                        if (obj35 & 32 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(primarySurface, obj13, restartGroup);
                            $dirty5 &= i27;
                        }
                        if (i51 != 0) {
                            f = topAppBarElevation-D9Ej5fM;
                            i = primarySurface;
                            l = contentColor2;
                            i8 = $dirty5;
                            obj2 = str;
                            contentColor2 = obj4;
                            obj3 = obj;
                            $dirty2 = -2087748139;
                        } else {
                            f = $changed;
                            i8 = $dirty5;
                            i = primarySurface;
                            l = contentColor2;
                            $dirty2 = -2087748139;
                            obj2 = str;
                            contentColor2 = obj4;
                            obj3 = obj;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty4 = obj35 & 16 != 0 ? obj33 & i15 : obj33;
                        if (obj35 & 32 != 0) {
                            $dirty4 &= i27;
                        }
                        f = $changed;
                        i8 = $dirty4;
                        i = primarySurface;
                        l = contentColor2;
                        $dirty2 = -2087748139;
                        obj2 = str;
                        contentColor2 = obj4;
                        obj3 = obj;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart($dirty2, i8, -1, "androidx.compose.material.TopAppBar (AppBar.kt:175)");
                }
                AppBarKt.TopAppBar-Rx1qByU(obj5, AppBarKt.ZeroInsets, obj2, contentColor2, obj3, i, i15, l, obj19, f, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = i8;
                $dirty = obj2;
                obj7 = contentColor2;
                obj6 = obj3;
                l3 = i;
                l2 = l;
                f3 = f;
            } else {
                restartGroup.skipToGroupEnd();
                f3 = $changed;
                composer = restartGroup;
                $dirty = str;
                obj7 = obj4;
                obj6 = obj;
                l3 = primarySurface;
                l2 = contentColor2;
                i4 = obj33;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AppBarKt.TopAppBar.3(title, $dirty, obj7, obj6, l3, obj4, l2, obj, f3, i52, obj35);
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
        Float valueOf3;
        Float valueOf;
        Float valueOf2;
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
                valueOf = Float.valueOf(i18);
                valueOf2 = Float.valueOf(f4);
            } else {
                valueOf = Float.valueOf(i20);
                valueOf2 = Float.valueOf(f5);
            }
            pair = TuplesKt.to(valueOf, valueOf2);
        } else {
            if (Float.compare(f4, f5) < 0) {
                valueOf3 = Float.valueOf(i18);
                valueOf2 = Float.valueOf(f4);
            } else {
                valueOf3 = Float.valueOf(i20);
                valueOf2 = Float.valueOf(f5);
            }
            pair = TuplesKt.to(valueOf3, valueOf2);
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
