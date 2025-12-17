package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a§\u0002\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\u0008\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u00122\u0013\u0008\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u00122\u0019\u0008\u0002\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\u0008\u00122\u0013\u0008\u0002\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u00122\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2 \u0008\u0002\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u0008\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001b2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020\u00012\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020$2\u0008\u0008\u0002\u0010&\u001a\u00020$2\u0008\u0008\u0002\u0010'\u001a\u00020$2\u0008\u0008\u0002\u0010(\u001a\u00020$2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\u0008\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,\u001a\u009f\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0013\u0008\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u00122\u0013\u0008\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u00122\u0019\u0008\u0002\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\u0008\u00122\u0013\u0008\u0002\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u00122\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2 \u0008\u0002\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u0008\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001b2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020\u00012\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020$2\u0008\u0008\u0002\u0010&\u001a\u00020$2\u0008\u0008\u0002\u0010'\u001a\u00020$2\u0008\u0008\u0002\u0010(\u001a\u00020$2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\u0008\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001a¨\u0001\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00192\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u000822\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u000822\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u000822\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u000822\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u00082H\u0003ø\u0001\u0000¢\u0006\u0004\u00085\u00106\u001a!\u00107\u001a\u00020\u000f2\u0008\u0008\u0002\u00108\u001a\u0002092\u0008\u0008\u0002\u0010:\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010;\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006<", d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScaffoldKt {

    private static final float FabSpacing;
    private static final ProvidableCompositionLocal<androidx.compose.material.FabPlacement> LocalFabPlacement;
    static {
        ScaffoldKt.LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf((Function0)ScaffoldKt.LocalFabPlacement.1.INSTANCE);
        final int i2 = 0;
        ScaffoldKt.FabSpacing = Dp.constructor-impl((float)i);
    }

    public static final void Scaffold-27mzLpw(Modifier modifier, androidx.compose.material.ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> topBar, Function2<? super Composer, ? super Integer, Unit> bottomBar, Function3<? super androidx.compose.material.SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i22) {
        boolean z2;
        Object obj6;
        boolean z;
        Object obj7;
        float f;
        int i30;
        int $dirty14;
        int i20;
        long l3;
        long l;
        long l2;
        Object obj4;
        int traceInProgress;
        int $dirty4;
        int defaultsInvalid;
        int rememberScaffoldState;
        int isFloatingActionButtonDocked3;
        long l4;
        long backgroundColor2;
        Object endRestartGroup;
        int changed7;
        int i8;
        int i15;
        int $dirty16;
        int drawerContent3;
        Object $dirty1;
        int str;
        Object obj2;
        Object $composer2;
        int $dirty;
        long $dirty3;
        long $dirty2;
        boolean traceInProgress2;
        Object obj5;
        int $dirty15;
        Object drawerGesturesEnabled3;
        int drawerGesturesEnabled2;
        Object modifier3;
        Object drawerShape3;
        int i40;
        int i24;
        int i37;
        int i2;
        Object drawerShape4;
        Object scaffoldState3;
        Object obj8;
        int topBar2;
        Object i32;
        int bottomBar2;
        Object obj;
        Object modifier2;
        int snackbarHost3;
        int i38;
        Object i33;
        Object scaffoldState2;
        int floatingActionButton2;
        Object obj3;
        int snackbarHost2;
        androidx.compose.foundation.shape.CornerBasedShape floatingActionButtonPosition2;
        Object obj9;
        int floatingActionButton3;
        float isFloatingActionButtonDocked2;
        int changed3;
        int i29;
        int colors;
        int i13;
        int iNSTANCE;
        long drawerContent2;
        int floatingActionButtonPosition3;
        Object $dirty13;
        int $dirty12;
        long drawerShape2;
        int i9;
        float drawerElevation2;
        int i39;
        int $dirty17;
        long drawerContentColor2;
        long drawerContentColor3;
        long drawerBackgroundColor2;
        int changed4;
        int changed6;
        int i36;
        int i3;
        int i26;
        int changed;
        int i19;
        int i10;
        long drawerBackgroundColor4;
        long drawerBackgroundColor3;
        long drawerContentColor4;
        int i28;
        int i;
        long scrimColor;
        long drawerScrimColor2;
        int changed5;
        long contentColor2;
        int i14;
        int i4;
        long i17;
        int i31;
        int i11;
        int i35;
        Composer composer;
        int i27;
        int i23;
        int i16;
        int i7;
        int i34;
        int i18;
        int i5;
        int i6;
        int i12;
        int i25;
        int i21;
        int changed2;
        ScopeUpdateScope scopeUpdateScope;
        float obj38;
        int obj39;
        int obj40;
        int obj41;
        int obj42;
        int obj43;
        int obj61;
        int i41 = obj62;
        i8 = obj63;
        str = obj64;
        Composer restartGroup = obj61.startRestartGroup(1037492569);
        ComposerKt.sourceInformation(restartGroup, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)312@14799L23,321@15309L6,323@15424L6,324@15472L38,325@15557L10,326@15612L6,327@15657L32,330@15748L495:Scaffold.kt#jmzs0o");
        $dirty = obj62;
        i2 = str & 1;
        if (i2 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i41 & 6 == 0) {
                i38 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i38;
            } else {
                obj = modifier;
            }
        }
        if (i41 & 48 == 0) {
            if (str & 2 == 0) {
                changed3 = restartGroup.changed(scaffoldState) ? 32 : 16;
            } else {
                i33 = scaffoldState;
            }
            $dirty |= changed3;
        } else {
            i33 = scaffoldState;
        }
        int i121 = str & 4;
        if (i121 != 0) {
            $dirty |= 384;
            obj8 = topBar;
        } else {
            if (i41 & 384 == 0) {
                i9 = restartGroup.changedInstance(topBar) ? 256 : 128;
                $dirty |= i9;
            } else {
                obj8 = topBar;
            }
        }
        drawerElevation2 = str & 8;
        changed4 = 1024;
        if (drawerElevation2 != 0) {
            $dirty |= 3072;
            i32 = bottomBar;
        } else {
            if (i41 & 3072 == 0) {
                i28 = restartGroup.changedInstance(bottomBar) ? i39 : changed4;
                $dirty |= i28;
            } else {
                i32 = bottomBar;
            }
        }
        int i132 = str & 16;
        final int i133 = 8192;
        if (i132 != 0) {
            $dirty |= 24576;
            obj3 = snackbarHost;
        } else {
            if (i41 & 24576 == 0) {
                i14 = restartGroup.changedInstance(snackbarHost) ? i : i133;
                $dirty |= i14;
            } else {
                obj3 = snackbarHost;
            }
        }
        i4 = str & 32;
        i17 = 131072;
        i31 = 196608;
        int i134 = 65536;
        if (i4 != 0) {
            $dirty |= i31;
            obj9 = floatingActionButton;
        } else {
            if (i41 & i31 == 0) {
                i27 = restartGroup.changedInstance(floatingActionButton) ? i17 : i134;
                $dirty |= i27;
            } else {
                obj9 = floatingActionButton;
            }
        }
        i23 = str & 64;
        i16 = 1572864;
        if (i23 != 0) {
            $dirty |= i16;
            floatingActionButtonPosition3 = floatingActionButtonPosition;
        } else {
            if (i41 & i16 == 0) {
                i34 = restartGroup.changed(floatingActionButtonPosition) ? 1048576 : 524288;
                $dirty |= i34;
            } else {
                floatingActionButtonPosition3 = floatingActionButtonPosition;
            }
        }
        int i129 = str & 128;
        final int i150 = 12582912;
        if (i129 != 0) {
            $dirty |= i150;
            z2 = isFloatingActionButtonDocked;
        } else {
            if (i41 & i150 == 0) {
                i5 = restartGroup.changed(isFloatingActionButtonDocked) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                z2 = isFloatingActionButtonDocked;
            }
        }
        int i42 = str & 256;
        int i151 = 100663296;
        if (i42 != 0) {
            $dirty |= i151;
            i6 = i42;
            obj6 = drawerContent;
        } else {
            if (obj62 & i151 == 0) {
                i6 = i42;
                i12 = restartGroup.changedInstance(drawerContent) ? 67108864 : 33554432;
                $dirty |= i12;
            } else {
                i6 = i42;
                obj6 = drawerContent;
            }
        }
        int i43 = str & 512;
        int i153 = 805306368;
        if (i43 != 0) {
            $dirty |= i153;
            i25 = i43;
            z = drawerGesturesEnabled;
        } else {
            if (obj62 & i153 == 0) {
                i25 = i43;
                i21 = restartGroup.changed(drawerGesturesEnabled) ? 536870912 : 268435456;
                $dirty |= i21;
            } else {
                i25 = i43;
                z = drawerGesturesEnabled;
            }
        }
        if (i8 & 6 == 0) {
            if (str & 1024 == 0) {
                i19 = restartGroup.changed(drawerShape) ? 4 : 2;
            } else {
                obj7 = drawerShape;
            }
            $dirty15 |= i19;
        } else {
            obj7 = drawerShape;
        }
        int i44 = str & 2048;
        if (i44 != 0) {
            $dirty15 |= 48;
            i10 = i44;
            f = drawerElevation;
        } else {
            if (i8 & 48 == 0) {
                i10 = i44;
                changed5 = restartGroup.changed(drawerElevation) ? 32 : 16;
                $dirty15 |= changed5;
            } else {
                i10 = i44;
                f = drawerElevation;
            }
        }
        if (i8 & 384 == 0) {
            if (str & 4096 == 0) {
                obj61 = $dirty;
                i30 = $dirty15;
                i7 = restartGroup.changed(drawerBackgroundColor) ? 256 : 128;
            } else {
                obj61 = $dirty;
                i30 = $dirty15;
                $dirty3 = drawerBackgroundColor;
            }
            i30 |= i7;
        } else {
            obj61 = $dirty;
            $dirty14 = $dirty15;
            $dirty3 = drawerBackgroundColor;
        }
        contentColor2 = $dirty14;
        if (i8 & 3072 == 0) {
            if (str & 8192 == 0) {
                if (restartGroup.changed(drawerScrimColor)) {
                } else {
                    i39 = changed4;
                }
            } else {
                $dirty2 = drawerScrimColor;
            }
            i20 = contentColor2 | i39;
        } else {
            $dirty2 = drawerScrimColor;
            i20 = contentColor2;
        }
        if (i8 & 24576 == 0) {
            if (str & 16384 == 0) {
                if (restartGroup.changed(contentColor)) {
                } else {
                    i = i133;
                }
            } else {
                l3 = contentColor;
            }
            $dirty17 |= i;
        } else {
            l3 = contentColor;
        }
        if (obj63 & i31 == 0) {
            if (str & i130 == 0) {
                i36 = restartGroup.changed($composer) ? i17 : i134;
            } else {
                l = $composer;
            }
            $dirty17 |= i36;
        } else {
            l = $composer;
        }
        if (obj63 & i16 == 0) {
            if (str & i134 == 0) {
                i3 = restartGroup.changed($changed1) ? 1048576 : 524288;
            } else {
                l2 = $changed1;
            }
            $dirty17 |= i3;
        } else {
            l2 = $changed1;
        }
        if (str & i17 != 0) {
            $dirty17 |= i150;
            obj4 = obj60;
        } else {
            if (obj63 & i150 == 0) {
                i8 = restartGroup.changedInstance(obj60) ? 8388608 : 4194304;
                $dirty17 |= i8;
            } else {
                obj4 = obj60;
            }
        }
        if (obj61 & i72 == 306783378 && $dirty17 & i70 == 4793490) {
            if ($dirty17 & i70 == 4793490) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj62 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i2 != 0) {
                                obj = defaultsInvalid;
                            }
                            if (str & 2 != 0) {
                                $dirty2 = obj61 & -113;
                                i33 = rememberScaffoldState;
                            } else {
                                $dirty2 = obj61;
                            }
                            if (i121 != 0) {
                                obj8 = rememberScaffoldState;
                            }
                            if (drawerElevation2 != 0) {
                                i32 = rememberScaffoldState;
                            }
                            if (i132 != 0) {
                                obj3 = rememberScaffoldState;
                            }
                            if (i4 != 0) {
                                obj9 = rememberScaffoldState;
                            }
                            if (i23 != 0) {
                                floatingActionButtonPosition3 = rememberScaffoldState;
                            }
                            isFloatingActionButtonDocked3 = i129 != 0 ? 0 : isFloatingActionButtonDocked;
                            drawerContent3 = i6 != 0 ? 0 : drawerContent;
                            drawerGesturesEnabled2 = i25 != 0 ? 1 : drawerGesturesEnabled;
                            if (str & 1024 != 0) {
                                drawerShape4 = MaterialTheme.INSTANCE.getShapes(restartGroup, 6).getLarge();
                                $dirty12 = $dirty17;
                            } else {
                                drawerShape4 = drawerShape;
                                $dirty12 = $dirty17;
                            }
                            if (i10 != 0) {
                                drawerElevation2 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                            } else {
                                drawerElevation2 = drawerElevation;
                            }
                            if (str & 4096 != 0) {
                                obj39 = isFloatingActionButtonDocked3;
                                $dirty12 &= -897;
                                obj40 = drawerContent3;
                                l4 = $dirty17;
                            } else {
                                obj39 = isFloatingActionButtonDocked3;
                                obj40 = drawerContent3;
                                l4 = drawerBackgroundColor;
                            }
                            if (str & 8192 != 0) {
                                drawerContentColor3 = ColorsKt.contentColorFor-ek8zF_U(l4, drawerContent3, restartGroup);
                                $dirty12 &= -7169;
                            } else {
                                drawerContentColor3 = drawerScrimColor;
                            }
                            if (str & 16384 != 0) {
                                drawerBackgroundColor3 = l4;
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, 6);
                                $dirty12 &= l4;
                            } else {
                                drawerBackgroundColor3 = l4;
                                scrimColor = contentColor;
                            }
                            if (i67 &= str != 0) {
                                backgroundColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getBackground-0d7_KjU();
                                $dirty12 &= iNSTANCE;
                            } else {
                                backgroundColor2 = $composer;
                            }
                            if (str & i134 != 0) {
                                floatingActionButtonPosition3 = drawerGesturesEnabled2;
                                drawerGesturesEnabled3 = obj;
                                modifier2 = obj3;
                                snackbarHost2 = $dirty111;
                                drawerBackgroundColor4 = drawerContentColor3;
                                drawerContentColor2 = l6;
                                $dirty13 = drawerShape4;
                                drawerShape3 = i33;
                                scaffoldState2 = obj9;
                                i17 = contentColorFor-ek8zF_U;
                                floatingActionButton3 = obj39;
                                contentColor2 = backgroundColor2;
                                $dirty4 = $dirty2;
                                $dirty16 = i127;
                                i29 = obj40;
                            } else {
                                floatingActionButtonPosition3 = drawerGesturesEnabled2;
                                drawerGesturesEnabled3 = obj;
                                modifier2 = obj3;
                                snackbarHost2 = $dirty110;
                                drawerBackgroundColor4 = drawerContentColor3;
                                drawerContentColor2 = l5;
                                i29 = obj40;
                                i17 = $changed1;
                                contentColor2 = backgroundColor2;
                                $dirty4 = $dirty2;
                                $dirty16 = $dirty12;
                                $dirty13 = drawerShape4;
                                drawerShape3 = i33;
                                scaffoldState2 = obj9;
                                floatingActionButton3 = obj39;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = str & 2 != 0 ? obj61 & -113 : obj61;
                            if (str & 1024 != 0) {
                                $dirty17 &= -15;
                            }
                            if (str & 4096 != 0) {
                                $dirty16 &= -897;
                            }
                            if (str & 8192 != 0) {
                                $dirty16 &= -7169;
                            }
                            if (str & 16384 != 0) {
                                $dirty16 &= i40;
                            }
                            if (i113 &= str != 0) {
                                $dirty16 &= i24;
                            }
                            if (str & i134 != 0) {
                                $dirty16 &= i37;
                            }
                            i29 = drawerContent;
                            $dirty13 = drawerShape;
                            drawerElevation2 = drawerElevation;
                            drawerContentColor2 = drawerBackgroundColor;
                            scrimColor = contentColor;
                            contentColor2 = $composer;
                            i17 = $changed1;
                            drawerBackgroundColor4 = $dirty2;
                            drawerGesturesEnabled3 = obj;
                            drawerShape3 = i33;
                            modifier2 = obj3;
                            scaffoldState2 = obj9;
                            snackbarHost2 = floatingActionButtonPosition3;
                            floatingActionButton3 = isFloatingActionButtonDocked;
                            floatingActionButtonPosition3 = drawerGesturesEnabled;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, $dirty4, $dirty16, "androidx.compose.material.Scaffold (Scaffold.kt:329)");
                    }
                    int i108 = 0;
                    i18 = $dirty4;
                    ScaffoldKt.Scaffold-u4IkXBM(WindowInsetsKt.WindowInsets-a9UjIt4$default(Dp.constructor-impl((float)i74), 0, 0, 0, 14, 0), drawerGesturesEnabled3, drawerShape3, obj8, i32, modifier2, scaffoldState2, snackbarHost2, floatingActionButton3, i29, floatingActionButtonPosition3, $dirty13, drawerElevation2, drawerContentColor2, i26, drawerBackgroundColor4, i132, scrimColor, i133, contentColor2, i4, i17, i31);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i11 = $dirty16;
                    $dirty1 = drawerGesturesEnabled3;
                    obj2 = drawerShape3;
                    $composer2 = obj8;
                    obj5 = i32;
                    modifier3 = modifier2;
                    scaffoldState3 = scaffoldState2;
                    topBar2 = snackbarHost2;
                    bottomBar2 = floatingActionButton3;
                    snackbarHost3 = i29;
                    floatingActionButton2 = floatingActionButtonPosition3;
                    floatingActionButtonPosition2 = $dirty13;
                    isFloatingActionButtonDocked2 = drawerElevation2;
                    drawerContent2 = drawerContentColor2;
                    drawerShape2 = drawerBackgroundColor4;
                    drawerBackgroundColor2 = scrimColor;
                    drawerContentColor4 = contentColor2;
                    drawerScrimColor2 = i17;
                } else {
                    restartGroup.skipToGroupEnd();
                    drawerContentColor4 = $composer;
                    drawerScrimColor2 = $changed1;
                    i18 = obj61;
                    composer = restartGroup;
                    drawerShape2 = $dirty2;
                    $composer2 = obj8;
                    obj5 = i32;
                    $dirty1 = obj;
                    obj2 = i33;
                    modifier3 = obj3;
                    scaffoldState3 = obj9;
                    topBar2 = floatingActionButtonPosition3;
                    i11 = $dirty17;
                    bottomBar2 = isFloatingActionButtonDocked;
                    snackbarHost3 = drawerContent;
                    floatingActionButton2 = drawerGesturesEnabled;
                    floatingActionButtonPosition2 = drawerShape;
                    isFloatingActionButtonDocked2 = drawerElevation;
                    drawerContent2 = drawerBackgroundColor;
                    drawerBackgroundColor2 = contentColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ScaffoldKt.Scaffold.3($dirty1, obj2, $composer2, obj5, modifier3, scaffoldState3, topBar2, bottomBar2, snackbarHost3, floatingActionButton2, floatingActionButtonPosition2, isFloatingActionButtonDocked2, drawerContent2, floatingActionButtonPosition3, drawerShape2, drawerElevation2, drawerBackgroundColor2, i26, drawerContentColor4, i132, drawerScrimColor2, i133, obj60, obj62, obj63, obj64);
            obj38 = $dirty1;
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj38 = $dirty1;
        }
    }

    public static final void Scaffold-u4IkXBM(WindowInsets contentWindowInsets, Modifier modifier, androidx.compose.material.ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> topBar, Function2<? super Composer, ? super Integer, Unit> bottomBar, Function3<? super androidx.compose.material.SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i23) {
        boolean z;
        Object obj5;
        boolean z2;
        Object obj;
        float f;
        int $dirty15;
        int $dirty1;
        Object $dirty12;
        boolean rememberComposableLambda;
        Object endRestartGroup;
        int defaultsInvalid;
        int rememberScaffoldState;
        int isFloatingActionButtonDocked2;
        int isFloatingActionButtonDocked3;
        int $dirty13;
        int i30;
        int i41;
        int $dirty19;
        Object it$iv;
        int changed6;
        int $dirty110;
        Composer composer;
        Object drawerContent4;
        int i28;
        int drawerContent2;
        long drawerContent3;
        int backgroundColor2;
        int invalid$iv;
        int drawerContent5;
        int i35;
        int i33;
        int i15;
        int i18;
        Object drawerGesturesEnabled3;
        int drawerGesturesEnabled4;
        int i26;
        Object $composer2;
        Object restartGroup;
        int $dirty;
        Object $dirty3;
        long $dirty2;
        int $dirty17;
        long $dirty16;
        long l5;
        long l;
        long l2;
        long drawerGesturesEnabled2;
        Object obj7;
        int i22;
        Object drawerShape3;
        int i36;
        Object drawerShape2;
        Object i34;
        int topBar2;
        int i17;
        int floatingActionButtonPosition2;
        Object obj2;
        int bottomBar2;
        Object obj6;
        int snackbarHost2;
        Object obj4;
        Object modifier2;
        int i8;
        Object obj3;
        float scaffoldState2;
        Object obj9;
        long floatingActionButton2;
        int i38;
        int colors;
        int i19;
        int changed7;
        long drawerElevation2;
        float drawerElevation3;
        int i29;
        int $dirty14;
        int changed5;
        int i24;
        int i21;
        int drawerContentColor2;
        int changed2;
        int changed3;
        int i3;
        long l6;
        int i6;
        int scrimColor;
        int i37;
        long l3;
        int contentColor2;
        int i10;
        int i32;
        long l4;
        int i39;
        int i27;
        int i4;
        int i13;
        int i;
        int changed4;
        int i2;
        int i5;
        Composer.Companion companion;
        int i14;
        int i11;
        int i40;
        Composer $composer3;
        int i20;
        int i42;
        int i25;
        int i9;
        int i16;
        int i12;
        int i7;
        int i31;
        int changed;
        int $dirty18;
        ScopeUpdateScope scopeUpdateScope;
        Object obj8;
        int obj41;
        int obj42;
        int obj43;
        long obj44;
        long obj45;
        long obj46;
        int obj47;
        int obj48;
        int obj49;
        Object obj50;
        Object obj51;
        Object obj52;
        Object obj53;
        Object obj54;
        Object obj55;
        int obj56;
        int obj57;
        Object obj59;
        int obj60;
        int obj64;
        Object obj10 = contentWindowInsets;
        int i43 = obj65;
        int i66 = obj66;
        int i82 = obj67;
        restartGroup = obj64.startRestartGroup(-1288630565);
        ComposerKt.sourceInformation(restartGroup, "C(Scaffold)P(4,15,16,18,1,17,12,13:c#material.FabPosition,14,6,9,11,8:c#ui.unit.Dp,5:c#ui.graphics.Color,7:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)184@8354L23,193@8864L6,195@8979L6,196@9027L38,197@9112L10,198@9167L6,199@9212L32,202@9320L86,205@9435L948:Scaffold.kt#jmzs0o");
        $dirty = obj65;
        $dirty17 = obj66;
        if (i82 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i43 & 6 == 0) {
                i22 = restartGroup.changed(obj10) ? 4 : 2;
                $dirty |= i22;
            }
        }
        i36 = i82 & 2;
        if (i36 != 0) {
            $dirty |= 48;
            obj4 = modifier;
        } else {
            if (i43 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i8;
            } else {
                obj4 = modifier;
            }
        }
        if (i43 & 384 == 0) {
            if (i82 & 4 == 0) {
                changed7 = restartGroup.changed(scaffoldState) ? 256 : 128;
            } else {
                obj3 = scaffoldState;
            }
            $dirty |= changed7;
        } else {
            obj3 = scaffoldState;
        }
        int i117 = i82 & 8;
        i3 = 2048;
        if (i117 != 0) {
            $dirty |= 3072;
            i34 = topBar;
        } else {
            if (i43 & 3072 == 0) {
                i6 = restartGroup.changedInstance(topBar) ? i3 : i29;
                $dirty |= i6;
            } else {
                i34 = topBar;
            }
        }
        scrimColor = i82 & 16;
        contentColor2 = 8192;
        if (scrimColor != 0) {
            $dirty |= 24576;
            obj2 = bottomBar;
        } else {
            if (i43 & 24576 == 0) {
                i39 = restartGroup.changedInstance(bottomBar) ? i37 : contentColor2;
                $dirty |= i39;
            } else {
                obj2 = bottomBar;
            }
        }
        i27 = i82 & 32;
        i4 = 196608;
        i13 = 131072;
        i = 65536;
        if (i27 != 0) {
            $dirty |= i4;
            obj6 = snackbarHost;
        } else {
            if (i43 & i4 == 0) {
                i2 = restartGroup.changedInstance(snackbarHost) ? i13 : i;
                $dirty |= i2;
            } else {
                obj6 = snackbarHost;
            }
        }
        companion = i82 & 64;
        i14 = 1572864;
        if (companion != 0) {
            $dirty |= i14;
            obj9 = floatingActionButton;
        } else {
            if (i43 & i14 == 0) {
                i40 = restartGroup.changedInstance(floatingActionButton) ? 1048576 : 524288;
                $dirty |= i40;
            } else {
                obj9 = floatingActionButton;
            }
        }
        i38 = i82 & 128;
        i20 = 12582912;
        if (i38 != 0) {
            $dirty |= i20;
            i17 = floatingActionButtonPosition;
        } else {
            if (i43 & i20 == 0) {
                i42 = restartGroup.changed(floatingActionButtonPosition) ? 8388608 : 4194304;
                $dirty |= i42;
            } else {
                i17 = floatingActionButtonPosition;
            }
        }
        int i44 = i82 & 256;
        int i127 = 100663296;
        if (i44 != 0) {
            $dirty |= i127;
            i25 = i44;
            z = isFloatingActionButtonDocked;
        } else {
            if (obj65 & i127 == 0) {
                i25 = i44;
                i9 = restartGroup.changed(isFloatingActionButtonDocked) ? 67108864 : 33554432;
                $dirty |= i9;
            } else {
                i25 = i44;
                z = isFloatingActionButtonDocked;
            }
        }
        int i45 = i82 & 512;
        int i129 = 805306368;
        if (i45 != 0) {
            $dirty |= i129;
            i16 = i45;
            obj5 = drawerContent;
        } else {
            if (obj65 & i129 == 0) {
                i16 = i45;
                i12 = restartGroup.changedInstance(drawerContent) ? 536870912 : 268435456;
                $dirty |= i12;
            } else {
                i16 = i45;
                obj5 = drawerContent;
            }
        }
        int i46 = i82 & 1024;
        if (i46 != 0) {
            $dirty17 |= 6;
            i7 = i46;
            z2 = drawerGesturesEnabled;
        } else {
            if (i66 & 6 == 0) {
                i7 = i46;
                i31 = restartGroup.changed(drawerGesturesEnabled) ? 4 : 2;
                $dirty17 |= i31;
            } else {
                i7 = i46;
                z2 = drawerGesturesEnabled;
            }
        }
        if (i66 & 48 == 0) {
            if (i82 & 2048 == 0) {
                i10 = restartGroup.changed(drawerShape) ? 32 : 16;
            } else {
                obj = drawerShape;
            }
            $dirty17 |= i10;
        } else {
            obj = drawerShape;
        }
        int i47 = i82 & 4096;
        if (i47 != 0) {
            $dirty17 |= 384;
            i32 = i47;
            f = drawerElevation;
        } else {
            i32 = i47;
            if (i66 & 384 == 0) {
                i14 = restartGroup.changed(drawerElevation) ? 256 : 128;
                $dirty17 |= i14;
            } else {
                f = drawerElevation;
            }
        }
        if (i66 & 3072 == 0) {
            if (i82 & 8192 == 0) {
                $dirty110 = $dirty17;
                obj64 = i36;
                if (restartGroup.changed(drawerBackgroundColor)) {
                    i29 = i3;
                }
            } else {
                $dirty110 = $dirty17;
                obj64 = i36;
                $dirty16 = drawerBackgroundColor;
            }
            $dirty110 |= i29;
        } else {
            $dirty15 = $dirty17;
            obj64 = i36;
            $dirty16 = drawerBackgroundColor;
        }
        int i118 = $dirty15;
        if (i66 & 24576 == 0) {
            if (i82 & 16384 == 0) {
                if (restartGroup.changed(drawerScrimColor)) {
                } else {
                    i37 = contentColor2;
                }
            } else {
                l5 = drawerScrimColor;
            }
            $dirty1 = i118 | i37;
        } else {
            l5 = drawerScrimColor;
            $dirty1 = i118;
        }
        if (i66 & i4 == 0) {
            if (i82 & i119 == 0) {
                $dirty14 = restartGroup.changed(contentColor) ? i13 : i;
            } else {
                l = contentColor;
            }
            $dirty1 |= $dirty14;
        } else {
            l = contentColor;
        }
        if (i66 & i120 == 0) {
            if (i82 & i == 0) {
                i24 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                l2 = $composer;
            }
            $dirty1 |= i24;
        } else {
            l2 = $composer;
        }
        if (i66 & i121 == 0) {
            if (i82 & i13 == 0) {
                i21 = restartGroup.changed($changed1) ? 8388608 : 4194304;
            } else {
                drawerGesturesEnabled2 = $changed1;
            }
            $dirty1 |= i21;
        } else {
            drawerGesturesEnabled2 = $changed1;
        }
        if (i82 & i122 != 0) {
            drawerContentColor2 = $dirty112;
            $dirty12 = obj63;
        } else {
            if (i66 & i127 == 0) {
                i3 = restartGroup.changedInstance(obj63) ? 67108864 : 33554432;
                i125 |= i3;
            } else {
                drawerContentColor2 = $dirty1;
                $dirty12 = obj63;
            }
        }
        if ($dirty & i126 == 306783378 && drawerContentColor2 & i50 == 38347922) {
            if (drawerContentColor2 & i50 == 38347922) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj65 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (obj64 != null) {
                                obj4 = defaultsInvalid;
                            }
                            if (i82 & 4 != 0) {
                                $dirty &= -897;
                                obj3 = rememberScaffoldState;
                            }
                            if (i117 != 0) {
                                i34 = rememberScaffoldState;
                            }
                            if (scrimColor != 0) {
                                obj2 = rememberScaffoldState;
                            }
                            if (i27 != 0) {
                                obj6 = rememberScaffoldState;
                            }
                            if (companion != 0) {
                                obj9 = rememberScaffoldState;
                            }
                            if (i38 != 0) {
                                i17 = rememberScaffoldState;
                            }
                            isFloatingActionButtonDocked2 = i25 != 0 ? 0 : isFloatingActionButtonDocked;
                            drawerContent2 = i16 != 0 ? 0 : drawerContent;
                            drawerGesturesEnabled2 = i7 != 0 ? 1 : drawerGesturesEnabled;
                            if (i82 & 2048 != 0) {
                                drawerShape2 = MaterialTheme.INSTANCE.getShapes(restartGroup, 6).getLarge();
                                $dirty18 = drawerContentColor2;
                            } else {
                                drawerShape2 = drawerShape;
                                $dirty18 = drawerContentColor2;
                            }
                            if (i32 != 0) {
                                drawerElevation3 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                            } else {
                                drawerElevation3 = drawerElevation;
                            }
                            if (i82 & 8192 != 0) {
                                obj42 = isFloatingActionButtonDocked2;
                                obj64 = $dirty;
                                obj43 = drawerGesturesEnabled2;
                                $dirty2 = drawerContentColor2;
                                $dirty18 = isFloatingActionButtonDocked3;
                            } else {
                                obj42 = isFloatingActionButtonDocked2;
                                isFloatingActionButtonDocked3 = $dirty18;
                                obj64 = $dirty;
                                obj43 = drawerGesturesEnabled2;
                                $dirty2 = drawerBackgroundColor;
                            }
                            if (i82 & 16384 != 0) {
                                drawerContentColor2 = ColorsKt.contentColorFor-ek8zF_U($dirty2, drawerGesturesEnabled2, restartGroup);
                                $dirty18 &= $dirty13;
                            } else {
                                drawerContentColor2 = drawerScrimColor;
                            }
                            if (i52 &= i82 != 0) {
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, 6);
                                $dirty18 &= i30;
                            } else {
                                i19 = 6;
                                scrimColor = contentColor;
                            }
                            if (i82 & i != 0) {
                                $dirty18 &= i41;
                                obj41 = drawerContent2;
                                drawerContent3 = contentColor2;
                            } else {
                                obj41 = drawerContent2;
                                drawerContent3 = $composer;
                            }
                            if (obj67 & i13 != 0) {
                                $dirty19 = $dirty18 & i56;
                                obj48 = obj42;
                                i38 = obj64;
                                i27 = contentColorFor-ek8zF_U;
                                contentColor2 = drawerContent3;
                                backgroundColor2 = obj41;
                                drawerGesturesEnabled4 = obj43;
                            } else {
                                obj48 = obj42;
                                i27 = $changed1;
                                i38 = obj64;
                                contentColor2 = drawerContent3;
                                $dirty19 = $dirty18;
                                backgroundColor2 = obj41;
                                drawerGesturesEnabled4 = obj43;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i82 & 4 != 0) {
                                $dirty &= -897;
                            }
                            if (i82 & 2048 != 0) {
                                drawerContentColor2 &= -113;
                            }
                            if (i82 & 8192 != 0) {
                                $dirty19 &= -7169;
                            }
                            if (i82 & 16384 != 0) {
                                $dirty19 &= i35;
                            }
                            if (i81 &= i82 != 0) {
                                $dirty19 &= i33;
                            }
                            if (i82 & i != 0) {
                                $dirty19 &= i15;
                            }
                            if (i82 & i13 != 0) {
                                $dirty19 &= i18;
                            }
                            backgroundColor2 = drawerContent;
                            drawerGesturesEnabled4 = drawerGesturesEnabled;
                            drawerElevation3 = drawerElevation;
                            drawerContentColor2 = drawerScrimColor;
                            scrimColor = contentColor;
                            contentColor2 = $composer;
                            i38 = $dirty;
                            i27 = drawerGesturesEnabled2;
                            drawerShape2 = drawerShape;
                            $dirty2 = drawerBackgroundColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj56 = backgroundColor2;
                        obj57 = drawerGesturesEnabled4;
                        ComposerKt.traceEventStart(-1288630565, i38, $dirty19, "androidx.compose.material.Scaffold (Scaffold.kt:201)");
                    } else {
                        obj56 = backgroundColor2;
                        obj57 = drawerGesturesEnabled4;
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1364493262, "CC(remember):Scaffold.kt#9igjgp");
                    invalid$iv = i38 & 14 == 4 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    i13 = 0;
                    i = $dirty19;
                    it$iv = composer2.rememberedValue();
                    changed4 = 0;
                    if (invalid$iv == 0) {
                        obj41 = invalid$iv;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            invalid$iv = 0;
                            obj42 = it$iv;
                            it$iv = new MutableWindowInsets(obj10);
                            composer2.updateRememberedValue(it$iv);
                        } else {
                            obj42 = it$iv;
                        }
                    } else {
                        obj41 = invalid$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj41 = anon2;
                    obj50 = i34;
                    obj52 = obj9;
                    super((MutableWindowInsets)it$iv, obj10, contentColor2, snackbarHost, i27, floatingActionButtonPosition, obj48, i17, obj50, obj63, obj52, obj2, obj6, obj3);
                    obj59 = it$iv;
                    rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-219833176, true, obj41, restartGroup, 54);
                    if (obj56 != null) {
                        restartGroup.startReplaceGroup(651481999);
                        ComposerKt.sourceInformation(restartGroup, "241@10884L19,231@10426L487");
                        ScaffoldKt.Scaffold.1 anon3 = new ScaffoldKt.Scaffold.1((Function3)rememberComposableLambda);
                        obj47 = $dirty2;
                        obj41 = obj56;
                        obj44 = obj57;
                        obj54 = restartGroup;
                        DrawerKt.ModalDrawer-Gs3lGvM(obj41, obj4, obj3.getDrawerState(), obj44, drawerShape2, drawerElevation3, obj47, obj48, drawerContentColor2, obj50, scrimColor, obj52, (Function2)ComposableLambdaKt.rememberComposableLambda(-1409196448, true, anon3, restartGroup, 54));
                        drawerContent5 = obj41;
                        i26 = obj44;
                        $dirty2 = obj47;
                        obj54.endReplaceGroup();
                    } else {
                        drawerContent5 = obj56;
                        i26 = obj57;
                        composer = restartGroup;
                        composer.startReplaceGroup(651972295);
                        ComposerKt.sourceInformation(composer, "244@10935L15");
                        rememberComposableLambda.invoke(obj4, composer, Integer.valueOf(i103 |= 48));
                        composer.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2 = i34;
                    topBar2 = i17;
                    i5 = i38;
                    i11 = i;
                    floatingActionButtonPosition2 = obj60;
                    bottomBar2 = drawerContent5;
                    drawerContent4 = obj4;
                    modifier2 = drawerShape2;
                    drawerShape3 = obj9;
                    floatingActionButton2 = $dirty2;
                    $dirty3 = obj8;
                    obj7 = obj6;
                    snackbarHost2 = i26;
                    drawerGesturesEnabled3 = obj3;
                    scaffoldState2 = drawerElevation3;
                    drawerElevation2 = drawerContentColor2;
                    l6 = scrimColor;
                    l3 = contentColor2;
                    l4 = i27;
                } else {
                    restartGroup.skipToGroupEnd();
                    l6 = contentColor;
                    l3 = $composer;
                    composer = restartGroup;
                    i5 = $dirty;
                    l4 = drawerGesturesEnabled2;
                    $composer2 = i34;
                    topBar2 = i17;
                    $dirty3 = obj2;
                    obj7 = obj6;
                    drawerContent4 = obj4;
                    drawerGesturesEnabled3 = obj3;
                    drawerShape3 = obj9;
                    i11 = drawerContentColor2;
                    floatingActionButtonPosition2 = isFloatingActionButtonDocked;
                    bottomBar2 = drawerContent;
                    snackbarHost2 = drawerGesturesEnabled;
                    modifier2 = drawerShape;
                    scaffoldState2 = drawerElevation;
                    floatingActionButton2 = drawerBackgroundColor;
                    drawerElevation2 = drawerScrimColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = composer;
            endRestartGroup = new ScaffoldKt.Scaffold.2(contentWindowInsets, drawerContent4, drawerGesturesEnabled3, $composer2, $dirty3, obj7, drawerShape3, topBar2, floatingActionButtonPosition2, bottomBar2, snackbarHost2, modifier2, scaffoldState2, floatingActionButton2, i38, drawerElevation2, drawerContentColor2, l6, scrimColor, l3, contentColor2, l4, i27, obj63, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer3 = composer;
        }
    }

    private static final void ScaffoldLayout-i1QSOvI(boolean isFabDocked, int fabPosition, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Function2<? super Composer, ? super Integer, Unit> snackbar, Function2<? super Composer, ? super Integer, Unit> fab, WindowInsets contentWindowInsets, Function2<? super Composer, ? super Integer, Unit> bottomBar, Composer $composer, int $changed) {
        int traceInProgress2;
        int i16;
        int $dirty2;
        boolean z;
        Object obj4;
        int i6;
        int i;
        int i14;
        Object obj5;
        Object obj2;
        int i4;
        int i3;
        int i2;
        int i10;
        int i9;
        int i15;
        int i11;
        int i5;
        boolean skipping;
        boolean traceInProgress;
        int i23;
        int i13;
        Object obj6;
        int it$iv;
        Object obj3;
        int $dirty;
        Object obj7;
        int it$iv2;
        int i17;
        int i20;
        int companion;
        int i7;
        int i18;
        Object obj;
        int i22;
        int i19;
        int i12;
        int i8;
        int i21;
        final int i49 = $changed;
        traceInProgress2 = -468424875;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2)390@17673L6677,390@17656L6694:Scaffold.kt#jmzs0o");
        if (i49 & 6 == 0) {
            i6 = restartGroup.changed(isFabDocked) ? 4 : 2;
            $dirty2 |= i6;
        } else {
            z = isFabDocked;
        }
        if (i49 & 48 == 0) {
            i = restartGroup.changed(fabPosition) ? 32 : 16;
            $dirty2 |= i;
        } else {
            i17 = fabPosition;
        }
        i4 = 256;
        if (i49 & 384 == 0) {
            i14 = restartGroup.changedInstance(topBar) ? i4 : 128;
            $dirty2 |= i14;
        } else {
            obj3 = topBar;
        }
        if (i49 & 3072 == 0) {
            i23 = restartGroup.changedInstance(content) ? 2048 : 1024;
            $dirty2 |= i23;
        } else {
            obj5 = content;
        }
        it$iv = 16384;
        if (i49 & 24576 == 0) {
            i13 = restartGroup.changedInstance(snackbar) ? it$iv : 8192;
            $dirty2 |= i13;
        } else {
            obj7 = snackbar;
        }
        if (i47 &= i49 == 0) {
            i20 = restartGroup.changedInstance(fab) ? 131072 : 65536;
            $dirty2 |= i20;
        } else {
            obj6 = fab;
        }
        if (i49 & i56 == 0) {
            i7 = restartGroup.changed(contentWindowInsets) ? 1048576 : 524288;
            $dirty2 |= i7;
        } else {
            obj4 = contentWindowInsets;
        }
        if (i49 & i57 == 0) {
            i22 = restartGroup.changedInstance(bottomBar) ? 8388608 : 4194304;
            $dirty2 |= i22;
        } else {
            obj2 = bottomBar;
        }
        if ($dirty2 & i19 == 4793490) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:389)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -771534373, "CC(remember):Scaffold.kt#9igjgp");
                skipping = 1;
                i16 = $dirty2 & 896 == i4 ? skipping : 0;
                i3 = i36 &= $dirty2 == it$iv ? skipping : 0;
                i2 = i38 &= $dirty2 == 1048576 ? skipping : 0;
                i10 = i40 &= $dirty2 == 131072 ? skipping : 0;
                i9 = $dirty2 & 112 == 32 ? skipping : 0;
                i15 = $dirty2 & 14 == 4 ? skipping : 0;
                i11 = i44 &= $dirty2 == 8388608 ? skipping : 0;
                i5 = $dirty2 & 7168 == 2048 ? skipping : 0;
                i4 = restartGroup;
                i12 = 0;
                it$iv = i4.rememberedValue();
                i8 = 0;
                if (i31 |= i5 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        i21 = 0;
                        z = obj9;
                        obj4 = 0;
                        it$iv = new ScaffoldKt.ScaffoldLayout.1.1(obj3, obj7, obj6, i17, z, obj4, obj2, obj5);
                        i4.updateRememberedValue((Function2)it$iv);
                    } else {
                        z = it$iv;
                        obj4 = 0;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                SubcomposeLayoutKt.SubcomposeLayout(0, (Function2)it$iv, restartGroup, obj4, skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            traceInProgress2 = new ScaffoldKt.ScaffoldLayout.2(isFabDocked, fabPosition, topBar, content, snackbar, fab, contentWindowInsets, bottomBar, i49);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void access$ScaffoldLayout-i1QSOvI(boolean isFabDocked, int fabPosition, Function2 topBar, Function3 content, Function2 snackbar, Function2 fab, WindowInsets contentWindowInsets, Function2 bottomBar, Composer $composer, int $changed) {
        ScaffoldKt.ScaffoldLayout-i1QSOvI(isFabDocked, fabPosition, topBar, content, snackbar, fab, contentWindowInsets, bottomBar, $composer, $changed);
    }

    public static final float access$getFabSpacing$p() {
        return ScaffoldKt.FabSpacing;
    }

    public static final ProvidableCompositionLocal<androidx.compose.material.FabPlacement> getLocalFabPlacement() {
        return ScaffoldKt.LocalFabPlacement;
    }

    public static final androidx.compose.material.ScaffoldState rememberScaffoldState(androidx.compose.material.DrawerState drawerState, androidx.compose.material.SnackbarHostState snackbarHostState, Composer $composer, int $changed, int i5) {
        int closed;
        int str;
        int i;
        int rememberedValue;
        Object empty2;
        int i2;
        Object scaffoldState;
        int empty;
        Object snackbarHostState2;
        androidx.compose.material.DrawerState obj8;
        androidx.compose.material.SnackbarHostState obj9;
        int obj12;
        int i3 = 1569641925;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberScaffoldState)71@2725L39,72@2809L32,73@2861L62:Scaffold.kt#jmzs0o");
        str = 2;
        if (i5 & 1 != 0) {
            obj8 = DrawerKt.rememberDrawerState(DrawerValue.Closed, 0, $composer, 6, str);
        }
        String str3 = "CC(remember):Scaffold.kt#9igjgp";
        if (i5 &= str != 0) {
            ComposerKt.sourceInformationMarkerStart($composer, -694662680, str3);
            obj12 = 0;
            str = $composer;
            i = 0;
            rememberedValue = str.rememberedValue();
            i2 = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                snackbarHostState2 = new SnackbarHostState();
                str.updateRememberedValue(snackbarHostState2);
            } else {
                snackbarHostState2 = rememberedValue;
            }
            obj9 = snackbarHostState2;
            ComposerKt.sourceInformationMarkerEnd($composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:73)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -694660986, str3);
        obj12 = 0;
        Composer composer = $composer;
        int i4 = 0;
        Object rememberedValue2 = composer.rememberedValue();
        int i6 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            empty2 = 0;
            scaffoldState = new ScaffoldState(obj8, obj9);
            composer.updateRememberedValue(scaffoldState);
        } else {
            scaffoldState = rememberedValue2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (ScaffoldState)scaffoldState;
    }
}
