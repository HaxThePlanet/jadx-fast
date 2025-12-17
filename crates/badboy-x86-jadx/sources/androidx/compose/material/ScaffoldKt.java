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
        boolean z;
        Object obj9;
        boolean z2;
        Object obj7;
        float f;
        int i13;
        int $dirty15;
        int i14;
        long l4;
        long l;
        long l2;
        Object obj4;
        int traceInProgress2;
        int $dirty;
        int defaultsInvalid;
        int rememberScaffoldState;
        int isFloatingActionButtonDocked2;
        long l3;
        long backgroundColor2;
        Object endRestartGroup;
        int changed6;
        int i19;
        int i11;
        int $dirty14;
        int drawerContent3;
        Object $dirty16;
        int str;
        Object obj5;
        Object $composer2;
        int $dirty3;
        long $dirty4;
        long $dirty2;
        boolean traceInProgress;
        Object obj6;
        int $dirty1;
        Object drawerGesturesEnabled3;
        int drawerGesturesEnabled2;
        Object modifier2;
        Object drawerShape2;
        int i29;
        int i18;
        int i34;
        int i26;
        Object drawerShape3;
        Object scaffoldState2;
        Object obj;
        int topBar2;
        Object i16;
        int bottomBar2;
        Object obj8;
        Object modifier3;
        int snackbarHost3;
        int i40;
        Object i6;
        Object scaffoldState3;
        int floatingActionButton2;
        Object obj2;
        int snackbarHost2;
        androidx.compose.foundation.shape.CornerBasedShape floatingActionButtonPosition3;
        Object obj3;
        int floatingActionButton3;
        float isFloatingActionButtonDocked3;
        int changed5;
        int i21;
        int colors;
        int i24;
        int iNSTANCE;
        long drawerContent2;
        int floatingActionButtonPosition2;
        Object $dirty12;
        int $dirty13;
        long drawerShape4;
        int i17;
        float drawerElevation2;
        int i30;
        int $dirty17;
        long drawerContentColor3;
        long drawerContentColor4;
        long drawerBackgroundColor3;
        int changed4;
        int changed3;
        int i25;
        int i32;
        int i4;
        int changed7;
        int i28;
        int i37;
        long drawerBackgroundColor4;
        long drawerBackgroundColor2;
        long drawerContentColor2;
        int i39;
        int i5;
        long scrimColor;
        long drawerScrimColor2;
        int changed2;
        long contentColor2;
        int i10;
        int i27;
        long i2;
        int i15;
        int i35;
        int i3;
        Composer composer;
        int i38;
        int i20;
        int i7;
        int i36;
        int i33;
        int i31;
        int i8;
        int i12;
        int i9;
        int i;
        int i23;
        int changed;
        ScopeUpdateScope scopeUpdateScope;
        float obj38;
        int obj39;
        int obj40;
        int obj41;
        int obj42;
        int obj43;
        int obj61;
        int i41 = obj62;
        i19 = obj63;
        str = obj64;
        Composer restartGroup = obj61.startRestartGroup(1037492569);
        ComposerKt.sourceInformation(restartGroup, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)312@14799L23,321@15309L6,323@15424L6,324@15472L38,325@15557L10,326@15612L6,327@15657L32,330@15748L495:Scaffold.kt#jmzs0o");
        $dirty3 = obj62;
        i26 = str & 1;
        if (i26 != 0) {
            $dirty3 |= 6;
            obj8 = modifier;
        } else {
            if (i41 & 6 == 0) {
                i40 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty3 |= i40;
            } else {
                obj8 = modifier;
            }
        }
        if (i41 & 48 == 0) {
            if (str & 2 == 0) {
                changed5 = restartGroup.changed(scaffoldState) ? 32 : 16;
            } else {
                i6 = scaffoldState;
            }
            $dirty3 |= changed5;
        } else {
            i6 = scaffoldState;
        }
        int i121 = str & 4;
        if (i121 != 0) {
            $dirty3 |= 384;
            obj = topBar;
        } else {
            if (i41 & 384 == 0) {
                i17 = restartGroup.changedInstance(topBar) ? 256 : 128;
                $dirty3 |= i17;
            } else {
                obj = topBar;
            }
        }
        drawerElevation2 = str & 8;
        changed4 = 1024;
        if (drawerElevation2 != 0) {
            $dirty3 |= 3072;
            i16 = bottomBar;
        } else {
            if (i41 & 3072 == 0) {
                i39 = restartGroup.changedInstance(bottomBar) ? i30 : changed4;
                $dirty3 |= i39;
            } else {
                i16 = bottomBar;
            }
        }
        int i132 = str & 16;
        final int i133 = 8192;
        if (i132 != 0) {
            $dirty3 |= 24576;
            obj2 = snackbarHost;
        } else {
            if (i41 & 24576 == 0) {
                i10 = restartGroup.changedInstance(snackbarHost) ? i5 : i133;
                $dirty3 |= i10;
            } else {
                obj2 = snackbarHost;
            }
        }
        i27 = str & 32;
        i2 = 131072;
        i15 = 196608;
        int i134 = 65536;
        if (i27 != 0) {
            $dirty3 |= i15;
            obj3 = floatingActionButton;
        } else {
            if (i41 & i15 == 0) {
                i38 = restartGroup.changedInstance(floatingActionButton) ? i2 : i134;
                $dirty3 |= i38;
            } else {
                obj3 = floatingActionButton;
            }
        }
        i20 = str & 64;
        i7 = 1572864;
        if (i20 != 0) {
            $dirty3 |= i7;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else {
            if (i41 & i7 == 0) {
                i33 = restartGroup.changed(floatingActionButtonPosition) ? 1048576 : 524288;
                $dirty3 |= i33;
            } else {
                floatingActionButtonPosition2 = floatingActionButtonPosition;
            }
        }
        int i129 = str & 128;
        final int i150 = 12582912;
        if (i129 != 0) {
            $dirty3 |= i150;
            z = isFloatingActionButtonDocked;
        } else {
            if (i41 & i150 == 0) {
                i8 = restartGroup.changed(isFloatingActionButtonDocked) ? 8388608 : 4194304;
                $dirty3 |= i8;
            } else {
                z = isFloatingActionButtonDocked;
            }
        }
        int i42 = str & 256;
        int i151 = 100663296;
        if (i42 != 0) {
            $dirty3 |= i151;
            i12 = i42;
            obj9 = drawerContent;
        } else {
            if (obj62 & i151 == 0) {
                i12 = i42;
                i9 = restartGroup.changedInstance(drawerContent) ? 67108864 : 33554432;
                $dirty3 |= i9;
            } else {
                i12 = i42;
                obj9 = drawerContent;
            }
        }
        int i43 = str & 512;
        int i153 = 805306368;
        if (i43 != 0) {
            $dirty3 |= i153;
            i = i43;
            z2 = drawerGesturesEnabled;
        } else {
            if (obj62 & i153 == 0) {
                i = i43;
                i23 = restartGroup.changed(drawerGesturesEnabled) ? 536870912 : 268435456;
                $dirty3 |= i23;
            } else {
                i = i43;
                z2 = drawerGesturesEnabled;
            }
        }
        if (i19 & 6 == 0) {
            if (str & 1024 == 0) {
                i28 = restartGroup.changed(drawerShape) ? 4 : 2;
            } else {
                obj7 = drawerShape;
            }
            $dirty1 |= i28;
        } else {
            obj7 = drawerShape;
        }
        int i44 = str & 2048;
        if (i44 != 0) {
            $dirty1 |= 48;
            i37 = i44;
            f = drawerElevation;
        } else {
            if (i19 & 48 == 0) {
                i37 = i44;
                changed2 = restartGroup.changed(drawerElevation) ? 32 : 16;
                $dirty1 |= changed2;
            } else {
                i37 = i44;
                f = drawerElevation;
            }
        }
        if (i19 & 384 == 0) {
            if (str & 4096 == 0) {
                obj61 = $dirty3;
                i13 = $dirty1;
                i36 = restartGroup.changed(drawerBackgroundColor) ? 256 : 128;
            } else {
                obj61 = $dirty3;
                i13 = $dirty1;
                $dirty4 = drawerBackgroundColor;
            }
            i13 |= i36;
        } else {
            obj61 = $dirty3;
            $dirty15 = $dirty1;
            $dirty4 = drawerBackgroundColor;
        }
        contentColor2 = $dirty15;
        if (i19 & 3072 == 0) {
            if (str & 8192 == 0) {
                if (restartGroup.changed(drawerScrimColor)) {
                } else {
                    i30 = changed4;
                }
            } else {
                $dirty2 = drawerScrimColor;
            }
            i14 = contentColor2 | i30;
        } else {
            $dirty2 = drawerScrimColor;
            i14 = contentColor2;
        }
        if (i19 & 24576 == 0) {
            if (str & 16384 == 0) {
                if (restartGroup.changed(contentColor)) {
                } else {
                    i5 = i133;
                }
            } else {
                l4 = contentColor;
            }
            $dirty17 |= i5;
        } else {
            l4 = contentColor;
        }
        if (obj63 & i15 == 0) {
            if (str & i130 == 0) {
                i25 = restartGroup.changed($composer) ? i2 : i134;
            } else {
                l = $composer;
            }
            $dirty17 |= i25;
        } else {
            l = $composer;
        }
        if (obj63 & i7 == 0) {
            if (str & i134 == 0) {
                i32 = restartGroup.changed($changed1) ? 1048576 : 524288;
            } else {
                l2 = $changed1;
            }
            $dirty17 |= i32;
        } else {
            l2 = $changed1;
        }
        if (str & i2 != 0) {
            $dirty17 |= i150;
            obj4 = obj60;
        } else {
            if (obj63 & i150 == 0) {
                i19 = restartGroup.changedInstance(obj60) ? 8388608 : 4194304;
                $dirty17 |= i19;
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
                            if (i26 != 0) {
                                obj8 = defaultsInvalid;
                            }
                            if (str & 2 != 0) {
                                $dirty2 = obj61 & -113;
                                i6 = rememberScaffoldState;
                            } else {
                                $dirty2 = obj61;
                            }
                            if (i121 != 0) {
                                obj = rememberScaffoldState;
                            }
                            if (drawerElevation2 != 0) {
                                i16 = rememberScaffoldState;
                            }
                            if (i132 != 0) {
                                obj2 = rememberScaffoldState;
                            }
                            if (i27 != 0) {
                                obj3 = rememberScaffoldState;
                            }
                            if (i20 != 0) {
                                floatingActionButtonPosition2 = rememberScaffoldState;
                            }
                            isFloatingActionButtonDocked2 = i129 != 0 ? 0 : isFloatingActionButtonDocked;
                            drawerContent3 = i12 != 0 ? 0 : drawerContent;
                            drawerGesturesEnabled2 = i != 0 ? 1 : drawerGesturesEnabled;
                            if (str & 1024 != 0) {
                                drawerShape3 = MaterialTheme.INSTANCE.getShapes(restartGroup, 6).getLarge();
                                $dirty13 = $dirty17;
                            } else {
                                drawerShape3 = drawerShape;
                                $dirty13 = $dirty17;
                            }
                            if (i37 != 0) {
                                drawerElevation2 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                            } else {
                                drawerElevation2 = drawerElevation;
                            }
                            if (str & 4096 != 0) {
                                obj39 = isFloatingActionButtonDocked2;
                                $dirty13 &= -897;
                                obj40 = drawerContent3;
                                l3 = $dirty17;
                            } else {
                                obj39 = isFloatingActionButtonDocked2;
                                obj40 = drawerContent3;
                                l3 = drawerBackgroundColor;
                            }
                            if (str & 8192 != 0) {
                                drawerContentColor4 = ColorsKt.contentColorFor-ek8zF_U(l3, drawerContent3, restartGroup);
                                $dirty13 &= -7169;
                            } else {
                                drawerContentColor4 = drawerScrimColor;
                            }
                            if (str & 16384 != 0) {
                                drawerBackgroundColor2 = l3;
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, 6);
                                $dirty13 &= l3;
                            } else {
                                drawerBackgroundColor2 = l3;
                                scrimColor = contentColor;
                            }
                            if (i67 &= str != 0) {
                                backgroundColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getBackground-0d7_KjU();
                                $dirty13 &= iNSTANCE;
                            } else {
                                backgroundColor2 = $composer;
                            }
                            if (str & i134 != 0) {
                                floatingActionButtonPosition2 = drawerGesturesEnabled2;
                                drawerGesturesEnabled3 = obj8;
                                modifier3 = obj2;
                                snackbarHost2 = $dirty111;
                                drawerBackgroundColor4 = drawerContentColor4;
                                drawerContentColor3 = l6;
                                $dirty12 = drawerShape3;
                                drawerShape2 = i6;
                                scaffoldState3 = obj3;
                                i2 = contentColorFor-ek8zF_U;
                                floatingActionButton3 = obj39;
                                contentColor2 = backgroundColor2;
                                $dirty = $dirty2;
                                $dirty14 = i127;
                                i21 = obj40;
                            } else {
                                floatingActionButtonPosition2 = drawerGesturesEnabled2;
                                drawerGesturesEnabled3 = obj8;
                                modifier3 = obj2;
                                snackbarHost2 = $dirty110;
                                drawerBackgroundColor4 = drawerContentColor4;
                                drawerContentColor3 = l5;
                                i21 = obj40;
                                i2 = $changed1;
                                contentColor2 = backgroundColor2;
                                $dirty = $dirty2;
                                $dirty14 = $dirty13;
                                $dirty12 = drawerShape3;
                                drawerShape2 = i6;
                                scaffoldState3 = obj3;
                                floatingActionButton3 = obj39;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty = str & 2 != 0 ? obj61 & -113 : obj61;
                            if (str & 1024 != 0) {
                                $dirty17 &= -15;
                            }
                            if (str & 4096 != 0) {
                                $dirty14 &= -897;
                            }
                            if (str & 8192 != 0) {
                                $dirty14 &= -7169;
                            }
                            if (str & 16384 != 0) {
                                $dirty14 &= i29;
                            }
                            if (i113 &= str != 0) {
                                $dirty14 &= i18;
                            }
                            if (str & i134 != 0) {
                                $dirty14 &= i34;
                            }
                            i21 = drawerContent;
                            $dirty12 = drawerShape;
                            drawerElevation2 = drawerElevation;
                            drawerContentColor3 = drawerBackgroundColor;
                            scrimColor = contentColor;
                            contentColor2 = $composer;
                            i2 = $changed1;
                            drawerBackgroundColor4 = $dirty2;
                            drawerGesturesEnabled3 = obj8;
                            drawerShape2 = i6;
                            modifier3 = obj2;
                            scaffoldState3 = obj3;
                            snackbarHost2 = floatingActionButtonPosition2;
                            floatingActionButton3 = isFloatingActionButtonDocked;
                            floatingActionButtonPosition2 = drawerGesturesEnabled;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, $dirty, $dirty14, "androidx.compose.material.Scaffold (Scaffold.kt:329)");
                    }
                    int i108 = 0;
                    i31 = $dirty;
                    ScaffoldKt.Scaffold-u4IkXBM(WindowInsetsKt.WindowInsets-a9UjIt4$default(Dp.constructor-impl((float)i74), 0, 0, 0, 14, 0), drawerGesturesEnabled3, drawerShape2, obj, i16, modifier3, scaffoldState3, snackbarHost2, floatingActionButton3, i21, floatingActionButtonPosition2, $dirty12, drawerElevation2, drawerContentColor3, i4, drawerBackgroundColor4, i132, scrimColor, i133, contentColor2, i27, i2, i15);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i35 = $dirty14;
                    $dirty16 = drawerGesturesEnabled3;
                    obj5 = drawerShape2;
                    $composer2 = obj;
                    obj6 = i16;
                    modifier2 = modifier3;
                    scaffoldState2 = scaffoldState3;
                    topBar2 = snackbarHost2;
                    bottomBar2 = floatingActionButton3;
                    snackbarHost3 = i21;
                    floatingActionButton2 = floatingActionButtonPosition2;
                    floatingActionButtonPosition3 = $dirty12;
                    isFloatingActionButtonDocked3 = drawerElevation2;
                    drawerContent2 = drawerContentColor3;
                    drawerShape4 = drawerBackgroundColor4;
                    drawerBackgroundColor3 = scrimColor;
                    drawerContentColor2 = contentColor2;
                    drawerScrimColor2 = i2;
                } else {
                    restartGroup.skipToGroupEnd();
                    drawerContentColor2 = $composer;
                    drawerScrimColor2 = $changed1;
                    i31 = obj61;
                    composer = restartGroup;
                    drawerShape4 = $dirty2;
                    $composer2 = obj;
                    obj6 = i16;
                    $dirty16 = obj8;
                    obj5 = i6;
                    modifier2 = obj2;
                    scaffoldState2 = obj3;
                    topBar2 = floatingActionButtonPosition2;
                    i35 = $dirty17;
                    bottomBar2 = isFloatingActionButtonDocked;
                    snackbarHost3 = drawerContent;
                    floatingActionButton2 = drawerGesturesEnabled;
                    floatingActionButtonPosition3 = drawerShape;
                    isFloatingActionButtonDocked3 = drawerElevation;
                    drawerContent2 = drawerBackgroundColor;
                    drawerBackgroundColor3 = contentColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ScaffoldKt.Scaffold.3($dirty16, obj5, $composer2, obj6, modifier2, scaffoldState2, topBar2, bottomBar2, snackbarHost3, floatingActionButton2, floatingActionButtonPosition3, isFloatingActionButtonDocked3, drawerContent2, floatingActionButtonPosition2, drawerShape4, drawerElevation2, drawerBackgroundColor3, i4, drawerContentColor2, i132, drawerScrimColor2, i133, obj60, obj62, obj63, obj64);
            obj38 = $dirty16;
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj38 = $dirty16;
        }
    }

    public static final void Scaffold-u4IkXBM(WindowInsets contentWindowInsets, Modifier modifier, androidx.compose.material.ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> topBar, Function2<? super Composer, ? super Integer, Unit> bottomBar, Function3<? super androidx.compose.material.SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i23) {
        boolean z2;
        Object obj2;
        boolean z;
        Object obj;
        float f;
        int $dirty19;
        int $dirty15;
        Object $dirty17;
        boolean rememberComposableLambda;
        Object endRestartGroup;
        int defaultsInvalid;
        int rememberScaffoldState;
        int isFloatingActionButtonDocked3;
        int isFloatingActionButtonDocked2;
        int $dirty14;
        int i36;
        int i28;
        int $dirty18;
        Object it$iv;
        int changed4;
        int $dirty13;
        Composer composer;
        Object drawerContent2;
        int i24;
        int drawerContent3;
        long drawerContent4;
        int backgroundColor2;
        int invalid$iv;
        int drawerContent5;
        int i6;
        int i15;
        int i25;
        int i2;
        Object drawerGesturesEnabled4;
        int drawerGesturesEnabled2;
        int i35;
        Object $composer3;
        Object restartGroup;
        int $dirty3;
        Object $dirty2;
        long $dirty;
        int $dirty16;
        long $dirty1;
        long l4;
        long l2;
        long l3;
        long drawerGesturesEnabled3;
        Object obj8;
        int i10;
        Object drawerShape2;
        int i29;
        Object drawerShape3;
        Object i16;
        int topBar2;
        int i26;
        int floatingActionButtonPosition2;
        Object obj6;
        int bottomBar2;
        Object obj5;
        int snackbarHost2;
        Object obj9;
        Object modifier2;
        int i12;
        Object obj7;
        float scaffoldState2;
        Object obj3;
        long floatingActionButton2;
        int i37;
        int colors;
        int i3;
        int changed3;
        long drawerElevation2;
        float drawerElevation3;
        int i39;
        int $dirty12;
        int changed2;
        int i;
        int i11;
        int drawerContentColor2;
        int changed;
        int changed7;
        int i31;
        long l6;
        int i30;
        int scrimColor;
        int i20;
        long l;
        int contentColor2;
        int i14;
        int i22;
        long l5;
        int i7;
        int i4;
        int i41;
        int i18;
        int i34;
        int changed5;
        int i27;
        int i5;
        Composer.Companion companion;
        int i42;
        int i32;
        int i21;
        Composer $composer2;
        int i40;
        int i17;
        int i33;
        int i19;
        int i38;
        int i9;
        int i13;
        int i8;
        int changed6;
        int $dirty110;
        ScopeUpdateScope scopeUpdateScope;
        Object obj4;
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
        $dirty3 = obj65;
        $dirty16 = obj66;
        if (i82 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i43 & 6 == 0) {
                i10 = restartGroup.changed(obj10) ? 4 : 2;
                $dirty3 |= i10;
            }
        }
        i29 = i82 & 2;
        if (i29 != 0) {
            $dirty3 |= 48;
            obj9 = modifier;
        } else {
            if (i43 & 48 == 0) {
                i12 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i12;
            } else {
                obj9 = modifier;
            }
        }
        if (i43 & 384 == 0) {
            if (i82 & 4 == 0) {
                changed3 = restartGroup.changed(scaffoldState) ? 256 : 128;
            } else {
                obj7 = scaffoldState;
            }
            $dirty3 |= changed3;
        } else {
            obj7 = scaffoldState;
        }
        int i117 = i82 & 8;
        i31 = 2048;
        if (i117 != 0) {
            $dirty3 |= 3072;
            i16 = topBar;
        } else {
            if (i43 & 3072 == 0) {
                i30 = restartGroup.changedInstance(topBar) ? i31 : i39;
                $dirty3 |= i30;
            } else {
                i16 = topBar;
            }
        }
        scrimColor = i82 & 16;
        contentColor2 = 8192;
        if (scrimColor != 0) {
            $dirty3 |= 24576;
            obj6 = bottomBar;
        } else {
            if (i43 & 24576 == 0) {
                i7 = restartGroup.changedInstance(bottomBar) ? i20 : contentColor2;
                $dirty3 |= i7;
            } else {
                obj6 = bottomBar;
            }
        }
        i4 = i82 & 32;
        i41 = 196608;
        i18 = 131072;
        i34 = 65536;
        if (i4 != 0) {
            $dirty3 |= i41;
            obj5 = snackbarHost;
        } else {
            if (i43 & i41 == 0) {
                i27 = restartGroup.changedInstance(snackbarHost) ? i18 : i34;
                $dirty3 |= i27;
            } else {
                obj5 = snackbarHost;
            }
        }
        companion = i82 & 64;
        i42 = 1572864;
        if (companion != 0) {
            $dirty3 |= i42;
            obj3 = floatingActionButton;
        } else {
            if (i43 & i42 == 0) {
                i21 = restartGroup.changedInstance(floatingActionButton) ? 1048576 : 524288;
                $dirty3 |= i21;
            } else {
                obj3 = floatingActionButton;
            }
        }
        i37 = i82 & 128;
        i40 = 12582912;
        if (i37 != 0) {
            $dirty3 |= i40;
            i26 = floatingActionButtonPosition;
        } else {
            if (i43 & i40 == 0) {
                i17 = restartGroup.changed(floatingActionButtonPosition) ? 8388608 : 4194304;
                $dirty3 |= i17;
            } else {
                i26 = floatingActionButtonPosition;
            }
        }
        int i44 = i82 & 256;
        int i127 = 100663296;
        if (i44 != 0) {
            $dirty3 |= i127;
            i33 = i44;
            z2 = isFloatingActionButtonDocked;
        } else {
            if (obj65 & i127 == 0) {
                i33 = i44;
                i19 = restartGroup.changed(isFloatingActionButtonDocked) ? 67108864 : 33554432;
                $dirty3 |= i19;
            } else {
                i33 = i44;
                z2 = isFloatingActionButtonDocked;
            }
        }
        int i45 = i82 & 512;
        int i129 = 805306368;
        if (i45 != 0) {
            $dirty3 |= i129;
            i38 = i45;
            obj2 = drawerContent;
        } else {
            if (obj65 & i129 == 0) {
                i38 = i45;
                i9 = restartGroup.changedInstance(drawerContent) ? 536870912 : 268435456;
                $dirty3 |= i9;
            } else {
                i38 = i45;
                obj2 = drawerContent;
            }
        }
        int i46 = i82 & 1024;
        if (i46 != 0) {
            $dirty16 |= 6;
            i13 = i46;
            z = drawerGesturesEnabled;
        } else {
            if (i66 & 6 == 0) {
                i13 = i46;
                i8 = restartGroup.changed(drawerGesturesEnabled) ? 4 : 2;
                $dirty16 |= i8;
            } else {
                i13 = i46;
                z = drawerGesturesEnabled;
            }
        }
        if (i66 & 48 == 0) {
            if (i82 & 2048 == 0) {
                i14 = restartGroup.changed(drawerShape) ? 32 : 16;
            } else {
                obj = drawerShape;
            }
            $dirty16 |= i14;
        } else {
            obj = drawerShape;
        }
        int i47 = i82 & 4096;
        if (i47 != 0) {
            $dirty16 |= 384;
            i22 = i47;
            f = drawerElevation;
        } else {
            i22 = i47;
            if (i66 & 384 == 0) {
                i42 = restartGroup.changed(drawerElevation) ? 256 : 128;
                $dirty16 |= i42;
            } else {
                f = drawerElevation;
            }
        }
        if (i66 & 3072 == 0) {
            if (i82 & 8192 == 0) {
                $dirty13 = $dirty16;
                obj64 = i29;
                if (restartGroup.changed(drawerBackgroundColor)) {
                    i39 = i31;
                }
            } else {
                $dirty13 = $dirty16;
                obj64 = i29;
                $dirty1 = drawerBackgroundColor;
            }
            $dirty13 |= i39;
        } else {
            $dirty19 = $dirty16;
            obj64 = i29;
            $dirty1 = drawerBackgroundColor;
        }
        int i118 = $dirty19;
        if (i66 & 24576 == 0) {
            if (i82 & 16384 == 0) {
                if (restartGroup.changed(drawerScrimColor)) {
                } else {
                    i20 = contentColor2;
                }
            } else {
                l4 = drawerScrimColor;
            }
            $dirty15 = i118 | i20;
        } else {
            l4 = drawerScrimColor;
            $dirty15 = i118;
        }
        if (i66 & i41 == 0) {
            if (i82 & i119 == 0) {
                $dirty12 = restartGroup.changed(contentColor) ? i18 : i34;
            } else {
                l2 = contentColor;
            }
            $dirty15 |= $dirty12;
        } else {
            l2 = contentColor;
        }
        if (i66 & i120 == 0) {
            if (i82 & i34 == 0) {
                i = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                l3 = $composer;
            }
            $dirty15 |= i;
        } else {
            l3 = $composer;
        }
        if (i66 & i121 == 0) {
            if (i82 & i18 == 0) {
                i11 = restartGroup.changed($changed1) ? 8388608 : 4194304;
            } else {
                drawerGesturesEnabled3 = $changed1;
            }
            $dirty15 |= i11;
        } else {
            drawerGesturesEnabled3 = $changed1;
        }
        if (i82 & i122 != 0) {
            drawerContentColor2 = $dirty112;
            $dirty17 = obj63;
        } else {
            if (i66 & i127 == 0) {
                i31 = restartGroup.changedInstance(obj63) ? 67108864 : 33554432;
                i125 |= i31;
            } else {
                drawerContentColor2 = $dirty15;
                $dirty17 = obj63;
            }
        }
        if ($dirty3 & i126 == 306783378 && drawerContentColor2 & i50 == 38347922) {
            if (drawerContentColor2 & i50 == 38347922) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj65 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (obj64 != null) {
                                obj9 = defaultsInvalid;
                            }
                            if (i82 & 4 != 0) {
                                $dirty3 &= -897;
                                obj7 = rememberScaffoldState;
                            }
                            if (i117 != 0) {
                                i16 = rememberScaffoldState;
                            }
                            if (scrimColor != 0) {
                                obj6 = rememberScaffoldState;
                            }
                            if (i4 != 0) {
                                obj5 = rememberScaffoldState;
                            }
                            if (companion != 0) {
                                obj3 = rememberScaffoldState;
                            }
                            if (i37 != 0) {
                                i26 = rememberScaffoldState;
                            }
                            isFloatingActionButtonDocked3 = i33 != 0 ? 0 : isFloatingActionButtonDocked;
                            drawerContent3 = i38 != 0 ? 0 : drawerContent;
                            drawerGesturesEnabled3 = i13 != 0 ? 1 : drawerGesturesEnabled;
                            if (i82 & 2048 != 0) {
                                drawerShape3 = MaterialTheme.INSTANCE.getShapes(restartGroup, 6).getLarge();
                                $dirty110 = drawerContentColor2;
                            } else {
                                drawerShape3 = drawerShape;
                                $dirty110 = drawerContentColor2;
                            }
                            if (i22 != 0) {
                                drawerElevation3 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                            } else {
                                drawerElevation3 = drawerElevation;
                            }
                            if (i82 & 8192 != 0) {
                                obj42 = isFloatingActionButtonDocked3;
                                obj64 = $dirty3;
                                obj43 = drawerGesturesEnabled3;
                                $dirty = drawerContentColor2;
                                $dirty110 = isFloatingActionButtonDocked2;
                            } else {
                                obj42 = isFloatingActionButtonDocked3;
                                isFloatingActionButtonDocked2 = $dirty110;
                                obj64 = $dirty3;
                                obj43 = drawerGesturesEnabled3;
                                $dirty = drawerBackgroundColor;
                            }
                            if (i82 & 16384 != 0) {
                                drawerContentColor2 = ColorsKt.contentColorFor-ek8zF_U($dirty, drawerGesturesEnabled3, restartGroup);
                                $dirty110 &= $dirty14;
                            } else {
                                drawerContentColor2 = drawerScrimColor;
                            }
                            if (i52 &= i82 != 0) {
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, 6);
                                $dirty110 &= i36;
                            } else {
                                i3 = 6;
                                scrimColor = contentColor;
                            }
                            if (i82 & i34 != 0) {
                                $dirty110 &= i28;
                                obj41 = drawerContent3;
                                drawerContent4 = contentColor2;
                            } else {
                                obj41 = drawerContent3;
                                drawerContent4 = $composer;
                            }
                            if (obj67 & i18 != 0) {
                                $dirty18 = $dirty110 & i56;
                                obj48 = obj42;
                                i37 = obj64;
                                i4 = contentColorFor-ek8zF_U;
                                contentColor2 = drawerContent4;
                                backgroundColor2 = obj41;
                                drawerGesturesEnabled2 = obj43;
                            } else {
                                obj48 = obj42;
                                i4 = $changed1;
                                i37 = obj64;
                                contentColor2 = drawerContent4;
                                $dirty18 = $dirty110;
                                backgroundColor2 = obj41;
                                drawerGesturesEnabled2 = obj43;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i82 & 4 != 0) {
                                $dirty3 &= -897;
                            }
                            if (i82 & 2048 != 0) {
                                drawerContentColor2 &= -113;
                            }
                            if (i82 & 8192 != 0) {
                                $dirty18 &= -7169;
                            }
                            if (i82 & 16384 != 0) {
                                $dirty18 &= i6;
                            }
                            if (i81 &= i82 != 0) {
                                $dirty18 &= i15;
                            }
                            if (i82 & i34 != 0) {
                                $dirty18 &= i25;
                            }
                            if (i82 & i18 != 0) {
                                $dirty18 &= i2;
                            }
                            backgroundColor2 = drawerContent;
                            drawerGesturesEnabled2 = drawerGesturesEnabled;
                            drawerElevation3 = drawerElevation;
                            drawerContentColor2 = drawerScrimColor;
                            scrimColor = contentColor;
                            contentColor2 = $composer;
                            i37 = $dirty3;
                            i4 = drawerGesturesEnabled3;
                            drawerShape3 = drawerShape;
                            $dirty = drawerBackgroundColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj56 = backgroundColor2;
                        obj57 = drawerGesturesEnabled2;
                        ComposerKt.traceEventStart(-1288630565, i37, $dirty18, "androidx.compose.material.Scaffold (Scaffold.kt:201)");
                    } else {
                        obj56 = backgroundColor2;
                        obj57 = drawerGesturesEnabled2;
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1364493262, "CC(remember):Scaffold.kt#9igjgp");
                    invalid$iv = i37 & 14 == 4 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    i18 = 0;
                    i34 = $dirty18;
                    it$iv = composer2.rememberedValue();
                    changed5 = 0;
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
                    obj50 = i16;
                    obj52 = obj3;
                    super((MutableWindowInsets)it$iv, obj10, contentColor2, snackbarHost, i4, floatingActionButtonPosition, obj48, i26, obj50, obj63, obj52, obj6, obj5, obj7);
                    obj59 = it$iv;
                    rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-219833176, true, obj41, restartGroup, 54);
                    if (obj56 != null) {
                        restartGroup.startReplaceGroup(651481999);
                        ComposerKt.sourceInformation(restartGroup, "241@10884L19,231@10426L487");
                        ScaffoldKt.Scaffold.1 anon3 = new ScaffoldKt.Scaffold.1((Function3)rememberComposableLambda);
                        obj47 = $dirty;
                        obj41 = obj56;
                        obj44 = obj57;
                        obj54 = restartGroup;
                        DrawerKt.ModalDrawer-Gs3lGvM(obj41, obj9, obj7.getDrawerState(), obj44, drawerShape3, drawerElevation3, obj47, obj48, drawerContentColor2, obj50, scrimColor, obj52, (Function2)ComposableLambdaKt.rememberComposableLambda(-1409196448, true, anon3, restartGroup, 54));
                        drawerContent5 = obj41;
                        i35 = obj44;
                        $dirty = obj47;
                        obj54.endReplaceGroup();
                    } else {
                        drawerContent5 = obj56;
                        i35 = obj57;
                        composer = restartGroup;
                        composer.startReplaceGroup(651972295);
                        ComposerKt.sourceInformation(composer, "244@10935L15");
                        rememberComposableLambda.invoke(obj9, composer, Integer.valueOf(i103 |= 48));
                        composer.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3 = i16;
                    topBar2 = i26;
                    i5 = i37;
                    i32 = i34;
                    floatingActionButtonPosition2 = obj60;
                    bottomBar2 = drawerContent5;
                    drawerContent2 = obj9;
                    modifier2 = drawerShape3;
                    drawerShape2 = obj3;
                    floatingActionButton2 = $dirty;
                    $dirty2 = obj4;
                    obj8 = obj5;
                    snackbarHost2 = i35;
                    drawerGesturesEnabled4 = obj7;
                    scaffoldState2 = drawerElevation3;
                    drawerElevation2 = drawerContentColor2;
                    l6 = scrimColor;
                    l = contentColor2;
                    l5 = i4;
                } else {
                    restartGroup.skipToGroupEnd();
                    l6 = contentColor;
                    l = $composer;
                    composer = restartGroup;
                    i5 = $dirty3;
                    l5 = drawerGesturesEnabled3;
                    $composer3 = i16;
                    topBar2 = i26;
                    $dirty2 = obj6;
                    obj8 = obj5;
                    drawerContent2 = obj9;
                    drawerGesturesEnabled4 = obj7;
                    drawerShape2 = obj3;
                    i32 = drawerContentColor2;
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
            $composer2 = composer;
            endRestartGroup = new ScaffoldKt.Scaffold.2(contentWindowInsets, drawerContent2, drawerGesturesEnabled4, $composer3, $dirty2, obj8, drawerShape2, topBar2, floatingActionButtonPosition2, bottomBar2, snackbarHost2, modifier2, scaffoldState2, floatingActionButton2, i37, drawerElevation2, drawerContentColor2, l6, scrimColor, l, contentColor2, l5, i4, obj63, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = composer;
        }
    }

    private static final void ScaffoldLayout-i1QSOvI(boolean isFabDocked, int fabPosition, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Function2<? super Composer, ? super Integer, Unit> snackbar, Function2<? super Composer, ? super Integer, Unit> fab, WindowInsets contentWindowInsets, Function2<? super Composer, ? super Integer, Unit> bottomBar, Composer $composer, int $changed) {
        int traceInProgress2;
        int i2;
        int $dirty2;
        boolean z;
        Object obj;
        int i6;
        int i9;
        int i3;
        Object obj7;
        Object obj2;
        int i18;
        int i17;
        int i13;
        int i10;
        int i7;
        int i19;
        int i;
        int i11;
        boolean skipping;
        boolean traceInProgress;
        int i4;
        int i20;
        Object obj5;
        int it$iv;
        Object obj6;
        int $dirty;
        Object obj3;
        int it$iv2;
        int i21;
        int i12;
        int companion;
        int i23;
        int i16;
        Object obj4;
        int i14;
        int i15;
        int i5;
        int i22;
        int i8;
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
            i9 = restartGroup.changed(fabPosition) ? 32 : 16;
            $dirty2 |= i9;
        } else {
            i21 = fabPosition;
        }
        i18 = 256;
        if (i49 & 384 == 0) {
            i3 = restartGroup.changedInstance(topBar) ? i18 : 128;
            $dirty2 |= i3;
        } else {
            obj6 = topBar;
        }
        if (i49 & 3072 == 0) {
            i4 = restartGroup.changedInstance(content) ? 2048 : 1024;
            $dirty2 |= i4;
        } else {
            obj7 = content;
        }
        it$iv = 16384;
        if (i49 & 24576 == 0) {
            i20 = restartGroup.changedInstance(snackbar) ? it$iv : 8192;
            $dirty2 |= i20;
        } else {
            obj3 = snackbar;
        }
        if (i47 &= i49 == 0) {
            i12 = restartGroup.changedInstance(fab) ? 131072 : 65536;
            $dirty2 |= i12;
        } else {
            obj5 = fab;
        }
        if (i49 & i56 == 0) {
            i23 = restartGroup.changed(contentWindowInsets) ? 1048576 : 524288;
            $dirty2 |= i23;
        } else {
            obj = contentWindowInsets;
        }
        if (i49 & i57 == 0) {
            i14 = restartGroup.changedInstance(bottomBar) ? 8388608 : 4194304;
            $dirty2 |= i14;
        } else {
            obj2 = bottomBar;
        }
        if ($dirty2 & i15 == 4793490) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:389)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -771534373, "CC(remember):Scaffold.kt#9igjgp");
                skipping = 1;
                i2 = $dirty2 & 896 == i18 ? skipping : 0;
                i17 = i36 &= $dirty2 == it$iv ? skipping : 0;
                i13 = i38 &= $dirty2 == 1048576 ? skipping : 0;
                i10 = i40 &= $dirty2 == 131072 ? skipping : 0;
                i7 = $dirty2 & 112 == 32 ? skipping : 0;
                i19 = $dirty2 & 14 == 4 ? skipping : 0;
                i = i44 &= $dirty2 == 8388608 ? skipping : 0;
                i11 = $dirty2 & 7168 == 2048 ? skipping : 0;
                i18 = restartGroup;
                i5 = 0;
                it$iv = i18.rememberedValue();
                i22 = 0;
                if (i31 |= i11 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        i8 = 0;
                        z = obj9;
                        obj = 0;
                        it$iv = new ScaffoldKt.ScaffoldLayout.1.1(obj6, obj3, obj5, i21, z, obj, obj2, obj7);
                        i18.updateRememberedValue((Function2)it$iv);
                    } else {
                        z = it$iv;
                        obj = 0;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                SubcomposeLayoutKt.SubcomposeLayout(0, (Function2)it$iv, restartGroup, obj, skipping);
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
        int i2;
        int rememberedValue;
        Object empty;
        int i;
        Object scaffoldState;
        int empty2;
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
            i2 = 0;
            rememberedValue = str.rememberedValue();
            i = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty2 = 0;
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
            empty = 0;
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
