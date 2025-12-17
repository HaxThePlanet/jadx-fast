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
        Object obj7;
        boolean z2;
        Object obj5;
        float f;
        int i3;
        int $dirty15;
        int i37;
        long l;
        long l4;
        long l2;
        Object obj9;
        int traceInProgress2;
        int $dirty4;
        int defaultsInvalid;
        int rememberScaffoldState;
        int isFloatingActionButtonDocked2;
        long l3;
        long backgroundColor2;
        Object endRestartGroup;
        int changed3;
        int i40;
        int i12;
        int $dirty1;
        int drawerContent2;
        Object $dirty14;
        int str;
        Object obj8;
        Object $composer2;
        int $dirty2;
        long $dirty3;
        long $dirty;
        boolean traceInProgress;
        Object obj3;
        int $dirty13;
        Object drawerGesturesEnabled3;
        int drawerGesturesEnabled2;
        Object modifier2;
        Object drawerShape4;
        int i4;
        int i19;
        int i11;
        int i21;
        Object drawerShape3;
        Object scaffoldState3;
        Object obj;
        int topBar2;
        Object i8;
        int bottomBar2;
        Object obj4;
        Object modifier3;
        int snackbarHost3;
        int i18;
        Object i38;
        Object scaffoldState2;
        int floatingActionButton3;
        Object obj6;
        int snackbarHost2;
        androidx.compose.foundation.shape.CornerBasedShape floatingActionButtonPosition3;
        Object obj2;
        int floatingActionButton2;
        float isFloatingActionButtonDocked3;
        int changed5;
        int i13;
        int colors;
        int i14;
        int iNSTANCE;
        long drawerContent3;
        int floatingActionButtonPosition2;
        Object $dirty16;
        int $dirty17;
        long drawerShape2;
        int i9;
        float drawerElevation2;
        int i31;
        int $dirty12;
        long drawerContentColor4;
        long drawerContentColor2;
        long drawerBackgroundColor4;
        int changed4;
        int changed2;
        int i27;
        int i15;
        int i30;
        int changed;
        int i24;
        int i32;
        long drawerBackgroundColor3;
        long drawerBackgroundColor2;
        long drawerContentColor3;
        int i16;
        int i7;
        long scrimColor;
        long drawerScrimColor2;
        int changed6;
        long contentColor2;
        int i;
        int i5;
        long i26;
        int i10;
        int i34;
        int i39;
        Composer composer;
        int i23;
        int i20;
        int i36;
        int i28;
        int i29;
        int i25;
        int i33;
        int i6;
        int i17;
        int i35;
        int i2;
        int changed7;
        ScopeUpdateScope scopeUpdateScope;
        float obj38;
        int obj39;
        int obj40;
        int obj41;
        int obj42;
        int obj43;
        int obj61;
        int i41 = obj62;
        i40 = obj63;
        str = obj64;
        Composer restartGroup = obj61.startRestartGroup(1037492569);
        ComposerKt.sourceInformation(restartGroup, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)312@14799L23,321@15309L6,323@15424L6,324@15472L38,325@15557L10,326@15612L6,327@15657L32,330@15748L495:Scaffold.kt#jmzs0o");
        $dirty2 = obj62;
        i21 = str & 1;
        if (i21 != 0) {
            $dirty2 |= 6;
            obj4 = modifier;
        } else {
            if (i41 & 6 == 0) {
                i18 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i18;
            } else {
                obj4 = modifier;
            }
        }
        if (i41 & 48 == 0) {
            if (str & 2 == 0) {
                changed5 = restartGroup.changed(scaffoldState) ? 32 : 16;
            } else {
                i38 = scaffoldState;
            }
            $dirty2 |= changed5;
        } else {
            i38 = scaffoldState;
        }
        int i121 = str & 4;
        if (i121 != 0) {
            $dirty2 |= 384;
            obj = topBar;
        } else {
            if (i41 & 384 == 0) {
                i9 = restartGroup.changedInstance(topBar) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj = topBar;
            }
        }
        drawerElevation2 = str & 8;
        changed4 = 1024;
        if (drawerElevation2 != 0) {
            $dirty2 |= 3072;
            i8 = bottomBar;
        } else {
            if (i41 & 3072 == 0) {
                i16 = restartGroup.changedInstance(bottomBar) ? i31 : changed4;
                $dirty2 |= i16;
            } else {
                i8 = bottomBar;
            }
        }
        int i132 = str & 16;
        final int i133 = 8192;
        if (i132 != 0) {
            $dirty2 |= 24576;
            obj6 = snackbarHost;
        } else {
            if (i41 & 24576 == 0) {
                i = restartGroup.changedInstance(snackbarHost) ? i7 : i133;
                $dirty2 |= i;
            } else {
                obj6 = snackbarHost;
            }
        }
        i5 = str & 32;
        i26 = 131072;
        i10 = 196608;
        int i134 = 65536;
        if (i5 != 0) {
            $dirty2 |= i10;
            obj2 = floatingActionButton;
        } else {
            if (i41 & i10 == 0) {
                i23 = restartGroup.changedInstance(floatingActionButton) ? i26 : i134;
                $dirty2 |= i23;
            } else {
                obj2 = floatingActionButton;
            }
        }
        i20 = str & 64;
        i36 = 1572864;
        if (i20 != 0) {
            $dirty2 |= i36;
            floatingActionButtonPosition2 = floatingActionButtonPosition;
        } else {
            if (i41 & i36 == 0) {
                i29 = restartGroup.changed(floatingActionButtonPosition) ? 1048576 : 524288;
                $dirty2 |= i29;
            } else {
                floatingActionButtonPosition2 = floatingActionButtonPosition;
            }
        }
        int i129 = str & 128;
        final int i150 = 12582912;
        if (i129 != 0) {
            $dirty2 |= i150;
            z = isFloatingActionButtonDocked;
        } else {
            if (i41 & i150 == 0) {
                i33 = restartGroup.changed(isFloatingActionButtonDocked) ? 8388608 : 4194304;
                $dirty2 |= i33;
            } else {
                z = isFloatingActionButtonDocked;
            }
        }
        int i42 = str & 256;
        int i151 = 100663296;
        if (i42 != 0) {
            $dirty2 |= i151;
            i6 = i42;
            obj7 = drawerContent;
        } else {
            if (obj62 & i151 == 0) {
                i6 = i42;
                i17 = restartGroup.changedInstance(drawerContent) ? 67108864 : 33554432;
                $dirty2 |= i17;
            } else {
                i6 = i42;
                obj7 = drawerContent;
            }
        }
        int i43 = str & 512;
        int i153 = 805306368;
        if (i43 != 0) {
            $dirty2 |= i153;
            i35 = i43;
            z2 = drawerGesturesEnabled;
        } else {
            if (obj62 & i153 == 0) {
                i35 = i43;
                i2 = restartGroup.changed(drawerGesturesEnabled) ? 536870912 : 268435456;
                $dirty2 |= i2;
            } else {
                i35 = i43;
                z2 = drawerGesturesEnabled;
            }
        }
        if (i40 & 6 == 0) {
            if (str & 1024 == 0) {
                i24 = restartGroup.changed(drawerShape) ? 4 : 2;
            } else {
                obj5 = drawerShape;
            }
            $dirty13 |= i24;
        } else {
            obj5 = drawerShape;
        }
        int i44 = str & 2048;
        if (i44 != 0) {
            $dirty13 |= 48;
            i32 = i44;
            f = drawerElevation;
        } else {
            if (i40 & 48 == 0) {
                i32 = i44;
                changed6 = restartGroup.changed(drawerElevation) ? 32 : 16;
                $dirty13 |= changed6;
            } else {
                i32 = i44;
                f = drawerElevation;
            }
        }
        if (i40 & 384 == 0) {
            if (str & 4096 == 0) {
                obj61 = $dirty2;
                i3 = $dirty13;
                i28 = restartGroup.changed(drawerBackgroundColor) ? 256 : 128;
            } else {
                obj61 = $dirty2;
                i3 = $dirty13;
                $dirty3 = drawerBackgroundColor;
            }
            i3 |= i28;
        } else {
            obj61 = $dirty2;
            $dirty15 = $dirty13;
            $dirty3 = drawerBackgroundColor;
        }
        contentColor2 = $dirty15;
        if (i40 & 3072 == 0) {
            if (str & 8192 == 0) {
                if (restartGroup.changed(drawerScrimColor)) {
                } else {
                    i31 = changed4;
                }
            } else {
                $dirty = drawerScrimColor;
            }
            i37 = contentColor2 | i31;
        } else {
            $dirty = drawerScrimColor;
            i37 = contentColor2;
        }
        if (i40 & 24576 == 0) {
            if (str & 16384 == 0) {
                if (restartGroup.changed(contentColor)) {
                } else {
                    i7 = i133;
                }
            } else {
                l = contentColor;
            }
            $dirty12 |= i7;
        } else {
            l = contentColor;
        }
        if (obj63 & i10 == 0) {
            if (str & i130 == 0) {
                i27 = restartGroup.changed($composer) ? i26 : i134;
            } else {
                l4 = $composer;
            }
            $dirty12 |= i27;
        } else {
            l4 = $composer;
        }
        if (obj63 & i36 == 0) {
            if (str & i134 == 0) {
                i15 = restartGroup.changed($changed1) ? 1048576 : 524288;
            } else {
                l2 = $changed1;
            }
            $dirty12 |= i15;
        } else {
            l2 = $changed1;
        }
        if (str & i26 != 0) {
            $dirty12 |= i150;
            obj9 = obj60;
        } else {
            if (obj63 & i150 == 0) {
                i40 = restartGroup.changedInstance(obj60) ? 8388608 : 4194304;
                $dirty12 |= i40;
            } else {
                obj9 = obj60;
            }
        }
        if (obj61 & i72 == 306783378 && $dirty12 & i70 == 4793490) {
            if ($dirty12 & i70 == 4793490) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj62 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i21 != 0) {
                                obj4 = defaultsInvalid;
                            }
                            if (str & 2 != 0) {
                                $dirty = obj61 & -113;
                                i38 = rememberScaffoldState;
                            } else {
                                $dirty = obj61;
                            }
                            if (i121 != 0) {
                                obj = rememberScaffoldState;
                            }
                            if (drawerElevation2 != 0) {
                                i8 = rememberScaffoldState;
                            }
                            if (i132 != 0) {
                                obj6 = rememberScaffoldState;
                            }
                            if (i5 != 0) {
                                obj2 = rememberScaffoldState;
                            }
                            if (i20 != 0) {
                                floatingActionButtonPosition2 = rememberScaffoldState;
                            }
                            isFloatingActionButtonDocked2 = i129 != 0 ? 0 : isFloatingActionButtonDocked;
                            drawerContent2 = i6 != 0 ? 0 : drawerContent;
                            drawerGesturesEnabled2 = i35 != 0 ? 1 : drawerGesturesEnabled;
                            if (str & 1024 != 0) {
                                drawerShape3 = MaterialTheme.INSTANCE.getShapes(restartGroup, 6).getLarge();
                                $dirty17 = $dirty12;
                            } else {
                                drawerShape3 = drawerShape;
                                $dirty17 = $dirty12;
                            }
                            if (i32 != 0) {
                                drawerElevation2 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                            } else {
                                drawerElevation2 = drawerElevation;
                            }
                            if (str & 4096 != 0) {
                                obj39 = isFloatingActionButtonDocked2;
                                $dirty17 &= -897;
                                obj40 = drawerContent2;
                                l3 = $dirty12;
                            } else {
                                obj39 = isFloatingActionButtonDocked2;
                                obj40 = drawerContent2;
                                l3 = drawerBackgroundColor;
                            }
                            if (str & 8192 != 0) {
                                drawerContentColor2 = ColorsKt.contentColorFor-ek8zF_U(l3, drawerContent2, restartGroup);
                                $dirty17 &= -7169;
                            } else {
                                drawerContentColor2 = drawerScrimColor;
                            }
                            if (str & 16384 != 0) {
                                drawerBackgroundColor2 = l3;
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, 6);
                                $dirty17 &= l3;
                            } else {
                                drawerBackgroundColor2 = l3;
                                scrimColor = contentColor;
                            }
                            if (i67 &= str != 0) {
                                backgroundColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getBackground-0d7_KjU();
                                $dirty17 &= iNSTANCE;
                            } else {
                                backgroundColor2 = $composer;
                            }
                            if (str & i134 != 0) {
                                floatingActionButtonPosition2 = drawerGesturesEnabled2;
                                drawerGesturesEnabled3 = obj4;
                                modifier3 = obj6;
                                snackbarHost2 = $dirty111;
                                drawerBackgroundColor3 = drawerContentColor2;
                                drawerContentColor4 = l6;
                                $dirty16 = drawerShape3;
                                drawerShape4 = i38;
                                scaffoldState2 = obj2;
                                i26 = contentColorFor-ek8zF_U;
                                floatingActionButton2 = obj39;
                                contentColor2 = backgroundColor2;
                                $dirty4 = $dirty;
                                $dirty1 = i127;
                                i13 = obj40;
                            } else {
                                floatingActionButtonPosition2 = drawerGesturesEnabled2;
                                drawerGesturesEnabled3 = obj4;
                                modifier3 = obj6;
                                snackbarHost2 = $dirty110;
                                drawerBackgroundColor3 = drawerContentColor2;
                                drawerContentColor4 = l5;
                                i13 = obj40;
                                i26 = $changed1;
                                contentColor2 = backgroundColor2;
                                $dirty4 = $dirty;
                                $dirty1 = $dirty17;
                                $dirty16 = drawerShape3;
                                drawerShape4 = i38;
                                scaffoldState2 = obj2;
                                floatingActionButton2 = obj39;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            $dirty4 = str & 2 != 0 ? obj61 & -113 : obj61;
                            if (str & 1024 != 0) {
                                $dirty12 &= -15;
                            }
                            if (str & 4096 != 0) {
                                $dirty1 &= -897;
                            }
                            if (str & 8192 != 0) {
                                $dirty1 &= -7169;
                            }
                            if (str & 16384 != 0) {
                                $dirty1 &= i4;
                            }
                            if (i113 &= str != 0) {
                                $dirty1 &= i19;
                            }
                            if (str & i134 != 0) {
                                $dirty1 &= i11;
                            }
                            i13 = drawerContent;
                            $dirty16 = drawerShape;
                            drawerElevation2 = drawerElevation;
                            drawerContentColor4 = drawerBackgroundColor;
                            scrimColor = contentColor;
                            contentColor2 = $composer;
                            i26 = $changed1;
                            drawerBackgroundColor3 = $dirty;
                            drawerGesturesEnabled3 = obj4;
                            drawerShape4 = i38;
                            modifier3 = obj6;
                            scaffoldState2 = obj2;
                            snackbarHost2 = floatingActionButtonPosition2;
                            floatingActionButton2 = isFloatingActionButtonDocked;
                            floatingActionButtonPosition2 = drawerGesturesEnabled;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1037492569, $dirty4, $dirty1, "androidx.compose.material.Scaffold (Scaffold.kt:329)");
                    }
                    int i108 = 0;
                    i25 = $dirty4;
                    ScaffoldKt.Scaffold-u4IkXBM(WindowInsetsKt.WindowInsets-a9UjIt4$default(Dp.constructor-impl((float)i74), 0, 0, 0, 14, 0), drawerGesturesEnabled3, drawerShape4, obj, i8, modifier3, scaffoldState2, snackbarHost2, floatingActionButton2, i13, floatingActionButtonPosition2, $dirty16, drawerElevation2, drawerContentColor4, i30, drawerBackgroundColor3, i132, scrimColor, i133, contentColor2, i5, i26, i10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i34 = $dirty1;
                    $dirty14 = drawerGesturesEnabled3;
                    obj8 = drawerShape4;
                    $composer2 = obj;
                    obj3 = i8;
                    modifier2 = modifier3;
                    scaffoldState3 = scaffoldState2;
                    topBar2 = snackbarHost2;
                    bottomBar2 = floatingActionButton2;
                    snackbarHost3 = i13;
                    floatingActionButton3 = floatingActionButtonPosition2;
                    floatingActionButtonPosition3 = $dirty16;
                    isFloatingActionButtonDocked3 = drawerElevation2;
                    drawerContent3 = drawerContentColor4;
                    drawerShape2 = drawerBackgroundColor3;
                    drawerBackgroundColor4 = scrimColor;
                    drawerContentColor3 = contentColor2;
                    drawerScrimColor2 = i26;
                } else {
                    restartGroup.skipToGroupEnd();
                    drawerContentColor3 = $composer;
                    drawerScrimColor2 = $changed1;
                    i25 = obj61;
                    composer = restartGroup;
                    drawerShape2 = $dirty;
                    $composer2 = obj;
                    obj3 = i8;
                    $dirty14 = obj4;
                    obj8 = i38;
                    modifier2 = obj6;
                    scaffoldState3 = obj2;
                    topBar2 = floatingActionButtonPosition2;
                    i34 = $dirty12;
                    bottomBar2 = isFloatingActionButtonDocked;
                    snackbarHost3 = drawerContent;
                    floatingActionButton3 = drawerGesturesEnabled;
                    floatingActionButtonPosition3 = drawerShape;
                    isFloatingActionButtonDocked3 = drawerElevation;
                    drawerContent3 = drawerBackgroundColor;
                    drawerBackgroundColor4 = contentColor;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new ScaffoldKt.Scaffold.3($dirty14, obj8, $composer2, obj3, modifier2, scaffoldState3, topBar2, bottomBar2, snackbarHost3, floatingActionButton3, floatingActionButtonPosition3, isFloatingActionButtonDocked3, drawerContent3, floatingActionButtonPosition2, drawerShape2, drawerElevation2, drawerBackgroundColor4, i30, drawerContentColor3, i132, drawerScrimColor2, i133, obj60, obj62, obj63, obj64);
            obj38 = $dirty14;
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj38 = $dirty14;
        }
    }

    public static final void Scaffold-u4IkXBM(WindowInsets contentWindowInsets, Modifier modifier, androidx.compose.material.ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> topBar, Function2<? super Composer, ? super Integer, Unit> bottomBar, Function3<? super androidx.compose.material.SnackbarHostState, ? super Composer, ? super Integer, Unit> snackbarHost, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, int floatingActionButtonPosition, boolean isFloatingActionButtonDocked, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> drawerContent, boolean drawerGesturesEnabled, Shape drawerShape, float drawerElevation, long drawerBackgroundColor, long drawerContentColor, long drawerScrimColor, long backgroundColor, long contentColor, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i23) {
        boolean z2;
        Object obj5;
        boolean z;
        Object obj8;
        float f;
        int $dirty18;
        int $dirty13;
        Object $dirty12;
        boolean rememberComposableLambda;
        Object endRestartGroup;
        int defaultsInvalid;
        int rememberScaffoldState;
        int isFloatingActionButtonDocked3;
        int isFloatingActionButtonDocked2;
        int $dirty19;
        int i36;
        int i25;
        int $dirty14;
        Object it$iv;
        int changed6;
        int $dirty110;
        Composer composer;
        Object drawerContent4;
        int i30;
        int drawerContent2;
        long drawerContent5;
        int backgroundColor2;
        int invalid$iv;
        int drawerContent3;
        int i;
        int i35;
        int i26;
        int i27;
        Object drawerGesturesEnabled3;
        int drawerGesturesEnabled4;
        int i32;
        Object $composer3;
        Object restartGroup;
        int $dirty3;
        Object $dirty2;
        long $dirty;
        int $dirty15;
        long $dirty16;
        long l;
        long l6;
        long l4;
        long drawerGesturesEnabled2;
        Object obj;
        int i28;
        Object drawerShape2;
        int i8;
        Object drawerShape3;
        Object i6;
        int topBar2;
        int i29;
        int floatingActionButtonPosition2;
        Object obj2;
        int bottomBar2;
        Object obj7;
        int snackbarHost2;
        Object obj3;
        Object modifier2;
        int i21;
        Object obj9;
        float scaffoldState2;
        Object obj4;
        long floatingActionButton2;
        int i4;
        int colors;
        int i12;
        int changed7;
        long drawerElevation2;
        float drawerElevation3;
        int i19;
        int $dirty1;
        int changed2;
        int i34;
        int i42;
        int drawerContentColor2;
        int changed4;
        int changed3;
        int i17;
        long l3;
        int i10;
        int scrimColor;
        int i5;
        long l5;
        int contentColor2;
        int i15;
        int i37;
        long l2;
        int i2;
        int i18;
        int i22;
        int i20;
        int i13;
        int changed5;
        int i11;
        int i24;
        Composer.Companion companion;
        int i40;
        int i14;
        int i41;
        Composer $composer2;
        int i38;
        int i3;
        int i39;
        int i7;
        int i33;
        int i9;
        int i16;
        int i31;
        int changed;
        int $dirty17;
        ScopeUpdateScope scopeUpdateScope;
        Object obj6;
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
        $dirty15 = obj66;
        if (i82 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i43 & 6 == 0) {
                i28 = restartGroup.changed(obj10) ? 4 : 2;
                $dirty3 |= i28;
            }
        }
        i8 = i82 & 2;
        if (i8 != 0) {
            $dirty3 |= 48;
            obj3 = modifier;
        } else {
            if (i43 & 48 == 0) {
                i21 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i21;
            } else {
                obj3 = modifier;
            }
        }
        if (i43 & 384 == 0) {
            if (i82 & 4 == 0) {
                changed7 = restartGroup.changed(scaffoldState) ? 256 : 128;
            } else {
                obj9 = scaffoldState;
            }
            $dirty3 |= changed7;
        } else {
            obj9 = scaffoldState;
        }
        int i117 = i82 & 8;
        i17 = 2048;
        if (i117 != 0) {
            $dirty3 |= 3072;
            i6 = topBar;
        } else {
            if (i43 & 3072 == 0) {
                i10 = restartGroup.changedInstance(topBar) ? i17 : i19;
                $dirty3 |= i10;
            } else {
                i6 = topBar;
            }
        }
        scrimColor = i82 & 16;
        contentColor2 = 8192;
        if (scrimColor != 0) {
            $dirty3 |= 24576;
            obj2 = bottomBar;
        } else {
            if (i43 & 24576 == 0) {
                i2 = restartGroup.changedInstance(bottomBar) ? i5 : contentColor2;
                $dirty3 |= i2;
            } else {
                obj2 = bottomBar;
            }
        }
        i18 = i82 & 32;
        i22 = 196608;
        i20 = 131072;
        i13 = 65536;
        if (i18 != 0) {
            $dirty3 |= i22;
            obj7 = snackbarHost;
        } else {
            if (i43 & i22 == 0) {
                i11 = restartGroup.changedInstance(snackbarHost) ? i20 : i13;
                $dirty3 |= i11;
            } else {
                obj7 = snackbarHost;
            }
        }
        companion = i82 & 64;
        i40 = 1572864;
        if (companion != 0) {
            $dirty3 |= i40;
            obj4 = floatingActionButton;
        } else {
            if (i43 & i40 == 0) {
                i41 = restartGroup.changedInstance(floatingActionButton) ? 1048576 : 524288;
                $dirty3 |= i41;
            } else {
                obj4 = floatingActionButton;
            }
        }
        i4 = i82 & 128;
        i38 = 12582912;
        if (i4 != 0) {
            $dirty3 |= i38;
            i29 = floatingActionButtonPosition;
        } else {
            if (i43 & i38 == 0) {
                i3 = restartGroup.changed(floatingActionButtonPosition) ? 8388608 : 4194304;
                $dirty3 |= i3;
            } else {
                i29 = floatingActionButtonPosition;
            }
        }
        int i44 = i82 & 256;
        int i127 = 100663296;
        if (i44 != 0) {
            $dirty3 |= i127;
            i39 = i44;
            z2 = isFloatingActionButtonDocked;
        } else {
            if (obj65 & i127 == 0) {
                i39 = i44;
                i7 = restartGroup.changed(isFloatingActionButtonDocked) ? 67108864 : 33554432;
                $dirty3 |= i7;
            } else {
                i39 = i44;
                z2 = isFloatingActionButtonDocked;
            }
        }
        int i45 = i82 & 512;
        int i129 = 805306368;
        if (i45 != 0) {
            $dirty3 |= i129;
            i33 = i45;
            obj5 = drawerContent;
        } else {
            if (obj65 & i129 == 0) {
                i33 = i45;
                i9 = restartGroup.changedInstance(drawerContent) ? 536870912 : 268435456;
                $dirty3 |= i9;
            } else {
                i33 = i45;
                obj5 = drawerContent;
            }
        }
        int i46 = i82 & 1024;
        if (i46 != 0) {
            $dirty15 |= 6;
            i16 = i46;
            z = drawerGesturesEnabled;
        } else {
            if (i66 & 6 == 0) {
                i16 = i46;
                i31 = restartGroup.changed(drawerGesturesEnabled) ? 4 : 2;
                $dirty15 |= i31;
            } else {
                i16 = i46;
                z = drawerGesturesEnabled;
            }
        }
        if (i66 & 48 == 0) {
            if (i82 & 2048 == 0) {
                i15 = restartGroup.changed(drawerShape) ? 32 : 16;
            } else {
                obj8 = drawerShape;
            }
            $dirty15 |= i15;
        } else {
            obj8 = drawerShape;
        }
        int i47 = i82 & 4096;
        if (i47 != 0) {
            $dirty15 |= 384;
            i37 = i47;
            f = drawerElevation;
        } else {
            i37 = i47;
            if (i66 & 384 == 0) {
                i40 = restartGroup.changed(drawerElevation) ? 256 : 128;
                $dirty15 |= i40;
            } else {
                f = drawerElevation;
            }
        }
        if (i66 & 3072 == 0) {
            if (i82 & 8192 == 0) {
                $dirty110 = $dirty15;
                obj64 = i8;
                if (restartGroup.changed(drawerBackgroundColor)) {
                    i19 = i17;
                }
            } else {
                $dirty110 = $dirty15;
                obj64 = i8;
                $dirty16 = drawerBackgroundColor;
            }
            $dirty110 |= i19;
        } else {
            $dirty18 = $dirty15;
            obj64 = i8;
            $dirty16 = drawerBackgroundColor;
        }
        int i118 = $dirty18;
        if (i66 & 24576 == 0) {
            if (i82 & 16384 == 0) {
                if (restartGroup.changed(drawerScrimColor)) {
                } else {
                    i5 = contentColor2;
                }
            } else {
                l = drawerScrimColor;
            }
            $dirty13 = i118 | i5;
        } else {
            l = drawerScrimColor;
            $dirty13 = i118;
        }
        if (i66 & i22 == 0) {
            if (i82 & i119 == 0) {
                $dirty1 = restartGroup.changed(contentColor) ? i20 : i13;
            } else {
                l6 = contentColor;
            }
            $dirty13 |= $dirty1;
        } else {
            l6 = contentColor;
        }
        if (i66 & i120 == 0) {
            if (i82 & i13 == 0) {
                i34 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                l4 = $composer;
            }
            $dirty13 |= i34;
        } else {
            l4 = $composer;
        }
        if (i66 & i121 == 0) {
            if (i82 & i20 == 0) {
                i42 = restartGroup.changed($changed1) ? 8388608 : 4194304;
            } else {
                drawerGesturesEnabled2 = $changed1;
            }
            $dirty13 |= i42;
        } else {
            drawerGesturesEnabled2 = $changed1;
        }
        if (i82 & i122 != 0) {
            drawerContentColor2 = $dirty112;
            $dirty12 = obj63;
        } else {
            if (i66 & i127 == 0) {
                i17 = restartGroup.changedInstance(obj63) ? 67108864 : 33554432;
                i125 |= i17;
            } else {
                drawerContentColor2 = $dirty13;
                $dirty12 = obj63;
            }
        }
        if ($dirty3 & i126 == 306783378 && drawerContentColor2 & i50 == 38347922) {
            if (drawerContentColor2 & i50 == 38347922) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (obj65 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (obj64 != null) {
                                obj3 = defaultsInvalid;
                            }
                            if (i82 & 4 != 0) {
                                $dirty3 &= -897;
                                obj9 = rememberScaffoldState;
                            }
                            if (i117 != 0) {
                                i6 = rememberScaffoldState;
                            }
                            if (scrimColor != 0) {
                                obj2 = rememberScaffoldState;
                            }
                            if (i18 != 0) {
                                obj7 = rememberScaffoldState;
                            }
                            if (companion != 0) {
                                obj4 = rememberScaffoldState;
                            }
                            if (i4 != 0) {
                                i29 = rememberScaffoldState;
                            }
                            isFloatingActionButtonDocked3 = i39 != 0 ? 0 : isFloatingActionButtonDocked;
                            drawerContent2 = i33 != 0 ? 0 : drawerContent;
                            drawerGesturesEnabled2 = i16 != 0 ? 1 : drawerGesturesEnabled;
                            if (i82 & 2048 != 0) {
                                drawerShape3 = MaterialTheme.INSTANCE.getShapes(restartGroup, 6).getLarge();
                                $dirty17 = drawerContentColor2;
                            } else {
                                drawerShape3 = drawerShape;
                                $dirty17 = drawerContentColor2;
                            }
                            if (i37 != 0) {
                                drawerElevation3 = DrawerDefaults.INSTANCE.getElevation-D9Ej5fM();
                            } else {
                                drawerElevation3 = drawerElevation;
                            }
                            if (i82 & 8192 != 0) {
                                obj42 = isFloatingActionButtonDocked3;
                                obj64 = $dirty3;
                                obj43 = drawerGesturesEnabled2;
                                $dirty = drawerContentColor2;
                                $dirty17 = isFloatingActionButtonDocked2;
                            } else {
                                obj42 = isFloatingActionButtonDocked3;
                                isFloatingActionButtonDocked2 = $dirty17;
                                obj64 = $dirty3;
                                obj43 = drawerGesturesEnabled2;
                                $dirty = drawerBackgroundColor;
                            }
                            if (i82 & 16384 != 0) {
                                drawerContentColor2 = ColorsKt.contentColorFor-ek8zF_U($dirty, drawerGesturesEnabled2, restartGroup);
                                $dirty17 &= $dirty19;
                            } else {
                                drawerContentColor2 = drawerScrimColor;
                            }
                            if (i52 &= i82 != 0) {
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(restartGroup, 6);
                                $dirty17 &= i36;
                            } else {
                                i12 = 6;
                                scrimColor = contentColor;
                            }
                            if (i82 & i13 != 0) {
                                $dirty17 &= i25;
                                obj41 = drawerContent2;
                                drawerContent5 = contentColor2;
                            } else {
                                obj41 = drawerContent2;
                                drawerContent5 = $composer;
                            }
                            if (obj67 & i20 != 0) {
                                $dirty14 = $dirty17 & i56;
                                obj48 = obj42;
                                i4 = obj64;
                                i18 = contentColorFor-ek8zF_U;
                                contentColor2 = drawerContent5;
                                backgroundColor2 = obj41;
                                drawerGesturesEnabled4 = obj43;
                            } else {
                                obj48 = obj42;
                                i18 = $changed1;
                                i4 = obj64;
                                contentColor2 = drawerContent5;
                                $dirty14 = $dirty17;
                                backgroundColor2 = obj41;
                                drawerGesturesEnabled4 = obj43;
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
                                $dirty14 &= -7169;
                            }
                            if (i82 & 16384 != 0) {
                                $dirty14 &= i;
                            }
                            if (i81 &= i82 != 0) {
                                $dirty14 &= i35;
                            }
                            if (i82 & i13 != 0) {
                                $dirty14 &= i26;
                            }
                            if (i82 & i20 != 0) {
                                $dirty14 &= i27;
                            }
                            backgroundColor2 = drawerContent;
                            drawerGesturesEnabled4 = drawerGesturesEnabled;
                            drawerElevation3 = drawerElevation;
                            drawerContentColor2 = drawerScrimColor;
                            scrimColor = contentColor;
                            contentColor2 = $composer;
                            i4 = $dirty3;
                            i18 = drawerGesturesEnabled2;
                            drawerShape3 = drawerShape;
                            $dirty = drawerBackgroundColor;
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj56 = backgroundColor2;
                        obj57 = drawerGesturesEnabled4;
                        ComposerKt.traceEventStart(-1288630565, i4, $dirty14, "androidx.compose.material.Scaffold (Scaffold.kt:201)");
                    } else {
                        obj56 = backgroundColor2;
                        obj57 = drawerGesturesEnabled4;
                    }
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1364493262, "CC(remember):Scaffold.kt#9igjgp");
                    invalid$iv = i4 & 14 == 4 ? 1 : 0;
                    Composer composer2 = restartGroup;
                    i20 = 0;
                    i13 = $dirty14;
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
                    obj50 = i6;
                    obj52 = obj4;
                    super((MutableWindowInsets)it$iv, obj10, contentColor2, snackbarHost, i18, floatingActionButtonPosition, obj48, i29, obj50, obj63, obj52, obj2, obj7, obj9);
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
                        DrawerKt.ModalDrawer-Gs3lGvM(obj41, obj3, obj9.getDrawerState(), obj44, drawerShape3, drawerElevation3, obj47, obj48, drawerContentColor2, obj50, scrimColor, obj52, (Function2)ComposableLambdaKt.rememberComposableLambda(-1409196448, true, anon3, restartGroup, 54));
                        drawerContent3 = obj41;
                        i32 = obj44;
                        $dirty = obj47;
                        obj54.endReplaceGroup();
                    } else {
                        drawerContent3 = obj56;
                        i32 = obj57;
                        composer = restartGroup;
                        composer.startReplaceGroup(651972295);
                        ComposerKt.sourceInformation(composer, "244@10935L15");
                        rememberComposableLambda.invoke(obj3, composer, Integer.valueOf(i103 |= 48));
                        composer.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3 = i6;
                    topBar2 = i29;
                    i24 = i4;
                    i14 = i13;
                    floatingActionButtonPosition2 = obj60;
                    bottomBar2 = drawerContent3;
                    drawerContent4 = obj3;
                    modifier2 = drawerShape3;
                    drawerShape2 = obj4;
                    floatingActionButton2 = $dirty;
                    $dirty2 = obj6;
                    obj = obj7;
                    snackbarHost2 = i32;
                    drawerGesturesEnabled3 = obj9;
                    scaffoldState2 = drawerElevation3;
                    drawerElevation2 = drawerContentColor2;
                    l3 = scrimColor;
                    l5 = contentColor2;
                    l2 = i18;
                } else {
                    restartGroup.skipToGroupEnd();
                    l3 = contentColor;
                    l5 = $composer;
                    composer = restartGroup;
                    i24 = $dirty3;
                    l2 = drawerGesturesEnabled2;
                    $composer3 = i6;
                    topBar2 = i29;
                    $dirty2 = obj2;
                    obj = obj7;
                    drawerContent4 = obj3;
                    drawerGesturesEnabled3 = obj9;
                    drawerShape2 = obj4;
                    i14 = drawerContentColor2;
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
            endRestartGroup = new ScaffoldKt.Scaffold.2(contentWindowInsets, drawerContent4, drawerGesturesEnabled3, $composer3, $dirty2, obj, drawerShape2, topBar2, floatingActionButtonPosition2, bottomBar2, snackbarHost2, modifier2, scaffoldState2, floatingActionButton2, i4, drawerElevation2, drawerContentColor2, l3, scrimColor, l5, contentColor2, l2, i18, obj63, obj65, obj66, obj67);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = composer;
        }
    }

    private static final void ScaffoldLayout-i1QSOvI(boolean isFabDocked, int fabPosition, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Function2<? super Composer, ? super Integer, Unit> snackbar, Function2<? super Composer, ? super Integer, Unit> fab, WindowInsets contentWindowInsets, Function2<? super Composer, ? super Integer, Unit> bottomBar, Composer $composer, int $changed) {
        int traceInProgress2;
        int i6;
        int $dirty2;
        boolean z;
        Object obj5;
        int i11;
        int i17;
        int i21;
        Object obj6;
        Object obj2;
        int i23;
        int i13;
        int i15;
        int i5;
        int i10;
        int i2;
        int i9;
        int i20;
        boolean skipping;
        boolean traceInProgress;
        int i14;
        int i;
        Object obj7;
        int it$iv;
        Object obj3;
        int $dirty;
        Object obj4;
        int it$iv2;
        int i18;
        int i3;
        int companion;
        int i19;
        int i7;
        Object obj;
        int i4;
        int i22;
        int i16;
        int i12;
        int i8;
        final int i49 = $changed;
        traceInProgress2 = -468424875;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2)390@17673L6677,390@17656L6694:Scaffold.kt#jmzs0o");
        if (i49 & 6 == 0) {
            i11 = restartGroup.changed(isFabDocked) ? 4 : 2;
            $dirty2 |= i11;
        } else {
            z = isFabDocked;
        }
        if (i49 & 48 == 0) {
            i17 = restartGroup.changed(fabPosition) ? 32 : 16;
            $dirty2 |= i17;
        } else {
            i18 = fabPosition;
        }
        i23 = 256;
        if (i49 & 384 == 0) {
            i21 = restartGroup.changedInstance(topBar) ? i23 : 128;
            $dirty2 |= i21;
        } else {
            obj3 = topBar;
        }
        if (i49 & 3072 == 0) {
            i14 = restartGroup.changedInstance(content) ? 2048 : 1024;
            $dirty2 |= i14;
        } else {
            obj6 = content;
        }
        it$iv = 16384;
        if (i49 & 24576 == 0) {
            i = restartGroup.changedInstance(snackbar) ? it$iv : 8192;
            $dirty2 |= i;
        } else {
            obj4 = snackbar;
        }
        if (i47 &= i49 == 0) {
            i3 = restartGroup.changedInstance(fab) ? 131072 : 65536;
            $dirty2 |= i3;
        } else {
            obj7 = fab;
        }
        if (i49 & i56 == 0) {
            i19 = restartGroup.changed(contentWindowInsets) ? 1048576 : 524288;
            $dirty2 |= i19;
        } else {
            obj5 = contentWindowInsets;
        }
        if (i49 & i57 == 0) {
            i4 = restartGroup.changedInstance(bottomBar) ? 8388608 : 4194304;
            $dirty2 |= i4;
        } else {
            obj2 = bottomBar;
        }
        if ($dirty2 & i22 == 4793490) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:389)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -771534373, "CC(remember):Scaffold.kt#9igjgp");
                skipping = 1;
                i6 = $dirty2 & 896 == i23 ? skipping : 0;
                i13 = i36 &= $dirty2 == it$iv ? skipping : 0;
                i15 = i38 &= $dirty2 == 1048576 ? skipping : 0;
                i5 = i40 &= $dirty2 == 131072 ? skipping : 0;
                i10 = $dirty2 & 112 == 32 ? skipping : 0;
                i2 = $dirty2 & 14 == 4 ? skipping : 0;
                i9 = i44 &= $dirty2 == 8388608 ? skipping : 0;
                i20 = $dirty2 & 7168 == 2048 ? skipping : 0;
                i23 = restartGroup;
                i16 = 0;
                it$iv = i23.rememberedValue();
                i12 = 0;
                if (i31 |= i20 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        i8 = 0;
                        z = obj9;
                        obj5 = 0;
                        it$iv = new ScaffoldKt.ScaffoldLayout.1.1(obj3, obj4, obj7, i18, z, obj5, obj2, obj6);
                        i23.updateRememberedValue((Function2)it$iv);
                    } else {
                        z = it$iv;
                        obj5 = 0;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                SubcomposeLayoutKt.SubcomposeLayout(0, (Function2)it$iv, restartGroup, obj5, skipping);
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
