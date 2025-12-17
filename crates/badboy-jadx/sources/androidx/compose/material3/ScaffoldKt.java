package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a±\u0001\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0013\u0008\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\t2\u0013\u0008\u0002\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\t2\u0013\u0008\u0002\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\t2\u0013\u0008\u0002\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\u0008\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a\u0087\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000e2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\t2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0002\u0008\t2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\tH\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001f", d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScaffoldKt {

    private static final float FabSpacing;
    static {
        final int i2 = 0;
        ScaffoldKt.FabSpacing = Dp.constructor-impl((float)i);
    }

    public static final void Scaffold-TvnljyQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> topBar, Function2<? super Composer, ? super Integer, Unit> bottomBar, Function2<? super Composer, ? super Integer, Unit> snackbarHost, Function2<? super Composer, ? super Integer, Unit> floatingActionButton, int floatingActionButtonPosition, long containerColor, long contentColor, WindowInsets contentWindowInsets, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int i21;
        int changed3;
        Object obj2;
        Object obj3;
        int traceInProgress;
        int defaultsInvalid;
        int $dirty2;
        Object floatingActionButtonPosition2;
        Object $composer2;
        int $dirty3;
        long $dirty7;
        long l;
        long l4;
        int containerColor2;
        int empty2;
        Object $i$a$CacheScaffoldKt$Scaffold$1;
        Object obj7;
        boolean traceInProgress2;
        int i4;
        int i15;
        int changed5;
        int changed;
        Object floatingActionButtonPosition3;
        Object obj;
        Object modifier2;
        int i20;
        int i16;
        int i5;
        Object $dirty4;
        Object obj5;
        int topBar2;
        int i18;
        Object contentWindowInsets3;
        long contentWindowInsets2;
        Object obj4;
        int i17;
        int i12;
        int iNSTANCE;
        Object empty;
        long l3;
        Object function3;
        int i3;
        int i11;
        int i14;
        int i10;
        WindowInsets windowInsets;
        Object obj6;
        int i7;
        Modifier onConsumedWindowInsetsChanged;
        int i6;
        int companion;
        int i2;
        int $dirty6;
        int $dirty;
        long $dirty5;
        int changed4;
        long i;
        int changed2;
        int i19;
        long contentColor3;
        int contentColor2;
        long background-0d7_KjU;
        Composer.Companion companion2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i9;
        int i8;
        long l2;
        int obj30;
        int obj31;
        int obj32;
        Function3 obj33;
        Object obj34;
        Object obj35;
        Object obj36;
        Object obj37;
        int obj38;
        int obj42;
        final int i60 = obj43;
        final int i61 = obj44;
        Composer restartGroup = i13.startRestartGroup(-1219521777);
        ComposerKt.sourceInformation(restartGroup, "C(Scaffold)P(7,9!1,8,5,6:c#material3.FabPosition,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4)90@4654L11,91@4704L31,92@4794L19,95@4889L74,98@5047L224,104@5347L314,96@4968L693:Scaffold.kt#uh7d8r");
        $dirty3 = obj43;
        int i39 = i61 & 1;
        if (i39 != 0) {
            $dirty3 |= 6;
            obj = modifier;
        } else {
            if (i60 & 6 == 0) {
                i20 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty3 |= i20;
            } else {
                obj = modifier;
            }
        }
        int i48 = i61 & 2;
        if (i48 != 0) {
            $dirty3 |= 48;
            obj5 = topBar;
        } else {
            if (i60 & 48 == 0) {
                i18 = restartGroup.changedInstance(topBar) ? 32 : 16;
                $dirty3 |= i18;
            } else {
                obj5 = topBar;
            }
        }
        int i51 = i61 & 4;
        if (i51 != 0) {
            $dirty3 |= 384;
            obj4 = bottomBar;
        } else {
            if (i60 & 384 == 0) {
                i17 = restartGroup.changedInstance(bottomBar) ? 256 : 128;
                $dirty3 |= i17;
            } else {
                obj4 = bottomBar;
            }
        }
        iNSTANCE = i61 & 8;
        if (iNSTANCE != null) {
            $dirty3 |= 3072;
            function3 = snackbarHost;
        } else {
            if (i60 & 3072 == 0) {
                i3 = restartGroup.changedInstance(snackbarHost) ? 2048 : 1024;
                $dirty3 |= i3;
            } else {
                function3 = snackbarHost;
            }
        }
        i11 = i61 & 16;
        if (i11 != 0) {
            $dirty3 |= 24576;
            obj6 = floatingActionButton;
        } else {
            if (i60 & 24576 == 0) {
                i7 = restartGroup.changedInstance(floatingActionButton) ? 16384 : 8192;
                $dirty3 |= i7;
            } else {
                obj6 = floatingActionButton;
            }
        }
        onConsumedWindowInsetsChanged = i61 & 32;
        i6 = 196608;
        if (onConsumedWindowInsetsChanged != 0) {
            $dirty3 |= i6;
            i21 = floatingActionButtonPosition;
        } else {
            if (i60 & i6 == 0) {
                i2 = restartGroup.changed(floatingActionButtonPosition) ? 131072 : 65536;
                $dirty3 |= i2;
            } else {
                i21 = floatingActionButtonPosition;
            }
        }
        if (i60 & i64 == 0) {
            if (i61 & 64 == 0) {
                $dirty6 = $dirty3;
                obj42 = i39;
                changed4 = restartGroup.changed(containerColor) ? 1048576 : 524288;
            } else {
                $dirty6 = $dirty3;
                obj42 = i39;
                $dirty7 = containerColor;
            }
            $dirty6 |= changed4;
        } else {
            $dirty = $dirty3;
            obj42 = i39;
            $dirty7 = containerColor;
        }
        int i67 = 12582912;
        if (i60 & i67 == 0) {
            if (i61 & 128 == 0) {
                i21 = restartGroup.changed(contentWindowInsets) ? 8388608 : 4194304;
            } else {
                l = contentWindowInsets;
            }
            $dirty |= i21;
        } else {
            l = contentWindowInsets;
        }
        int i23 = 100663296;
        final int i69 = i23;
        if (i60 & i23 == 0) {
            if (i61 & 256 == 0) {
                changed2 = restartGroup.changed($composer) ? 67108864 : 33554432;
            } else {
                obj2 = $composer;
            }
            $dirty |= changed2;
        } else {
            obj2 = $composer;
        }
        i19 = 805306368;
        if (i61 & 512 != 0) {
            $dirty |= i19;
            obj3 = $changed;
        } else {
            if (i60 & i19 == 0) {
                i19 = restartGroup.changedInstance($changed) ? 536870912 : 268435456;
                $dirty |= i19;
            } else {
                obj3 = $changed;
            }
        }
        if ($dirty & contentColor2 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i35 = -234881025;
                int i40 = -29360129;
                int i70 = -3670017;
                if (i60 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj42 != null) {
                            obj = defaultsInvalid;
                        }
                        if (i48 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (i51 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        if (iNSTANCE != null) {
                            function3 = defaultsInvalid;
                        }
                        if (i11 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        if (onConsumedWindowInsetsChanged != 0) {
                            $dirty2 = FabPosition.Companion.getEnd-ERTFSPs();
                        } else {
                            $dirty2 = floatingActionButtonPosition;
                        }
                        int i52 = 6;
                        if (i61 & 64 != 0) {
                            $dirty &= i70;
                            i16 = i35;
                            obj42 = i40;
                            l4 = background-0d7_KjU;
                        } else {
                            i16 = i35;
                            obj42 = i40;
                            l4 = containerColor;
                        }
                        if (i61 & 128 != 0) {
                            contentColor3 = ColorSchemeKt.contentColorFor-ek8zF_U(l4, i40, restartGroup);
                            $dirty &= obj42;
                        } else {
                            contentColor3 = contentWindowInsets;
                        }
                        if (i61 & 256 != 0) {
                            contentWindowInsets3 = ScaffoldDefaults.INSTANCE.getContentWindowInsets(restartGroup, i52);
                            i5 = $dirty & i16;
                            containerColor2 = i67;
                            $dirty5 = l2;
                        } else {
                            contentWindowInsets3 = $composer;
                            i5 = $dirty;
                            containerColor2 = i67;
                            $dirty5 = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i61 & 64 != 0) {
                            $dirty &= i70;
                        }
                        if (i61 & 128 != 0) {
                            $dirty &= i40;
                        }
                        if (i61 & 256 != 0) {
                            contentColor3 = contentWindowInsets;
                            contentWindowInsets3 = $composer;
                            i5 = i29;
                            containerColor2 = i67;
                            $dirty2 = floatingActionButtonPosition;
                            $dirty5 = containerColor;
                        } else {
                            $dirty2 = floatingActionButtonPosition;
                            contentColor3 = contentWindowInsets;
                            contentWindowInsets3 = $composer;
                            i5 = $dirty;
                            containerColor2 = i67;
                            $dirty5 = containerColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1219521777, i5, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:94)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1794939901, "CC(remember):Scaffold.kt#9igjgp");
                if (i43 ^= i69 > 67108864) {
                    if (!restartGroup.changed(contentWindowInsets3)) {
                        i4 = i5 & i69 == 67108864 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer3 = restartGroup;
                int i62 = 0;
                Object rememberedValue = composer3.rememberedValue();
                companion = 0;
                if (i4 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj31 = $dirty2;
                        floatingActionButtonPosition2 = new MutableWindowInsets(contentWindowInsets3);
                        composer3.updateRememberedValue(floatingActionButtonPosition2);
                    } else {
                        obj31 = $dirty2;
                        floatingActionButtonPosition2 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1794934695, "CC(remember):Scaffold.kt#9igjgp");
                if (i45 ^= i69 > 67108864) {
                    if (!restartGroup.changed(contentWindowInsets3)) {
                        i15 = i5 & i69 == 67108864 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                changed6 |= i15;
                Composer composer2 = restartGroup;
                int i55 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i63 = 0;
                if (empty2 == 0) {
                    obj30 = empty2;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        obj32 = invalid$iv;
                        $i$a$CacheScaffoldKt$Scaffold$1 = new ScaffoldKt.Scaffold.1.1(floatingActionButtonPosition2, contentWindowInsets3);
                        composer2.updateRememberedValue((Function1)$i$a$CacheScaffoldKt$Scaffold$1);
                    } else {
                        $i$a$CacheScaffoldKt$Scaffold$1 = rememberedValue2;
                    }
                } else {
                    obj30 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                super(obj31, obj5, $changed, function3, obj6, floatingActionButtonPosition2, obj4);
                i = contentColor3;
                SurfaceKt.Surface-T9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(obj, (Function1)$i$a$CacheScaffoldKt$Scaffold$1), 0, $dirty5, i67, i, i69, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1979205334, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj;
                obj7 = obj5;
                windowInsets = contentWindowInsets3;
                modifier2 = function3;
                l3 = i;
                topBar2 = i46;
                floatingActionButtonPosition3 = obj4;
                contentWindowInsets2 = $dirty5;
                $dirty = i5;
                $dirty4 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                windowInsets = $composer;
                composer = restartGroup;
                $composer2 = obj;
                obj7 = obj5;
                floatingActionButtonPosition3 = obj4;
                modifier2 = function3;
                topBar2 = floatingActionButtonPosition;
                contentWindowInsets2 = containerColor;
                l3 = contentWindowInsets;
                $dirty4 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ScaffoldKt.Scaffold.3($composer2, obj7, floatingActionButtonPosition3, modifier2, $dirty4, topBar2, contentWindowInsets2, obj4, l3, function3, windowInsets, $changed, i60, i61);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void ScaffoldLayout-FMILGgc(int fabPosition, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Function2<? super Composer, ? super Integer, Unit> snackbar, Function2<? super Composer, ? super Integer, Unit> fab, WindowInsets contentWindowInsets, Function2<? super Composer, ? super Integer, Unit> bottomBar, Composer $composer, int $changed) {
        int i10;
        int traceInProgress2;
        int $dirty2;
        int i16;
        int i17;
        Object obj3;
        int skipping;
        boolean traceInProgress;
        int i4;
        int i13;
        int i9;
        int i18;
        int i7;
        int i12;
        int i;
        Object obj2;
        int i14;
        int i11;
        int i8;
        Object obj4;
        int i15;
        int empty;
        Object obj;
        int $dirty;
        Object obj5;
        Object obj6;
        int i20;
        Object rememberedValue;
        int i5;
        Object companion;
        int i6;
        Object i19;
        int i2;
        int i3;
        final int i46 = $changed;
        traceInProgress2 = -975511942;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)139@6582L6951,139@6565L6968:Scaffold.kt#uh7d8r");
        if (i46 & 6 == 0) {
            i16 = restartGroup.changed(fabPosition) ? 4 : 2;
            $dirty2 |= i16;
        } else {
            i20 = fabPosition;
        }
        i = 32;
        if (i46 & 48 == 0) {
            i17 = restartGroup.changedInstance(topBar) ? i : 16;
            $dirty2 |= i17;
        } else {
            obj = topBar;
        }
        if (i46 & 384 == 0) {
            i14 = restartGroup.changedInstance(content) ? 256 : 128;
            $dirty2 |= i14;
        } else {
            obj3 = content;
        }
        i15 = 2048;
        if (i46 & 3072 == 0) {
            i11 = restartGroup.changedInstance(snackbar) ? i15 : 1024;
            $dirty2 |= i11;
        } else {
            obj5 = snackbar;
        }
        if (i46 & 24576 == 0) {
            i8 = restartGroup.changedInstance(fab) ? 16384 : 8192;
            $dirty2 |= i8;
        } else {
            obj6 = fab;
        }
        rememberedValue = 131072;
        if (i40 &= i46 == 0) {
            i5 = restartGroup.changed(contentWindowInsets) ? rememberedValue : 65536;
            $dirty2 |= i5;
        } else {
            obj4 = contentWindowInsets;
        }
        if (i46 & i47 == 0) {
            i6 = restartGroup.changedInstance(bottomBar) ? 1048576 : 524288;
            $dirty2 |= i6;
        } else {
            obj2 = bottomBar;
        }
        if ($dirty2 & i19 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:138)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1690368138, "CC(remember):Scaffold.kt#9igjgp");
                skipping = 1;
                i10 = $dirty2 & 112 == i ? skipping : 0;
                i4 = $dirty2 & 7168 == i15 ? skipping : 0;
                i13 = i32 &= $dirty2 == rememberedValue ? skipping : 0;
                i9 = i34 &= $dirty2 == 16384 ? skipping : 0;
                i18 = $dirty2 & 14 == 4 ? skipping : 0;
                i7 = i37 &= $dirty2 == 1048576 ? skipping : 0;
                i12 = $dirty2 & 896 == 256 ? skipping : 0;
                i = restartGroup;
                i15 = 0;
                rememberedValue = i.rememberedValue();
                i2 = 0;
                if (i27 |= i12 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i3 = 0;
                        obj3 = rememberedValue;
                        obj2 = 0;
                        empty = new ScaffoldKt.ScaffoldLayout.1.1(obj, obj5, obj6, i20, obj4, obj2, obj3);
                        i.updateRememberedValue((Function2)empty);
                    } else {
                        obj3 = rememberedValue;
                        obj2 = 0;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                SubcomposeLayoutKt.SubcomposeLayout(0, (Function2)rememberedValue, restartGroup, obj2, skipping);
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
            traceInProgress2 = new ScaffoldKt.ScaffoldLayout.2(fabPosition, topBar, content, snackbar, fab, contentWindowInsets, bottomBar, i46);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void access$ScaffoldLayout-FMILGgc(int fabPosition, Function2 topBar, Function3 content, Function2 snackbar, Function2 fab, WindowInsets contentWindowInsets, Function2 bottomBar, Composer $composer, int $changed) {
        ScaffoldKt.ScaffoldLayout-FMILGgc(fabPosition, topBar, content, snackbar, fab, contentWindowInsets, bottomBar, $composer, $changed);
    }

    public static final float access$getFabSpacing$p() {
        return ScaffoldKt.FabSpacing;
    }
}
