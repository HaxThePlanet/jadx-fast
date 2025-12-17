package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a©\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000123\u0008\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u000c\u0008\u0014\u0012\u0008\u0008\u0015\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u00182\u0018\u0008\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a\u009f\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r23\u0008\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u000c\u0008\u0014\u0012\u0008\u0008\u0015\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u00182\u0018\u0008\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0008\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 \"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006!", d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TabRowKt {

    private static final float ScrollableTabRowMinimumTabWidth;
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec;
    static {
        int i2 = 0;
        TabRowKt.ScrollableTabRowMinimumTabWidth = Dp.constructor-impl((float)i);
        TabRowKt.ScrollableTabRowScrollSpec = (AnimationSpec)AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, 0);
    }

    public static final void ScrollableTabRow-sKfQg0A(int selectedTabIndex, Modifier modifier, long backgroundColor, long contentColor, float edgePadding, Function3<? super List<androidx.compose.material.TabPosition>, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i11) {
        Object obj;
        Object obj2;
        boolean traceInProgress2;
        float f2;
        int defaultsInvalid;
        int colors;
        int rememberComposableLambda;
        float i8;
        Object $composer2;
        int $dirty3;
        long indicator3;
        Object $dirty2;
        int i17;
        Function2 i14;
        Object obj4;
        long $dirty;
        int modifier3;
        int i15;
        long primarySurface;
        int backgroundColor2;
        float f3;
        int i12;
        int changed2;
        long contentColorFor-ek8zF_U;
        Object obj3;
        boolean traceInProgress;
        Function2 function2;
        String str;
        int changed;
        int i7;
        float f;
        int modifier2;
        Object edgePadding2;
        int i18;
        int i6;
        Object indicator2;
        int i4;
        long i5;
        int i3;
        int i;
        int i9;
        int i2;
        int i13;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i10;
        int i16;
        androidx.compose.material.TabRowKt.ScrollableTabRow.2 obj26;
        float obj27;
        Function2 obj28;
        Function2 obj29;
        Object obj30;
        int obj31;
        i8 = selectedTabIndex;
        final int i38 = obj36;
        final int i39 = obj37;
        Composer restartGroup = i11.startRestartGroup(-1473476840);
        ComposerKt.sourceInformation(restartGroup, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)230@11351L6,231@11400L32,234@11601L139,249@12032L2913,245@11919L3026:TabRow.kt#jmzs0o");
        $dirty3 = obj36;
        if (i39 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i38 & 6 == 0) {
                i17 = restartGroup.changed(i8) ? 4 : 2;
                $dirty3 |= i17;
            }
        }
        int i30 = i39 & 2;
        if (i30 != 0) {
            $dirty3 |= 48;
            obj4 = modifier;
        } else {
            if (i38 & 48 == 0) {
                i15 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i15;
            } else {
                obj4 = modifier;
            }
        }
        if (i38 & 384 == 0) {
            if (i39 & 4 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 256 : 128;
            } else {
                primarySurface = backgroundColor;
            }
            $dirty3 |= changed2;
        } else {
            primarySurface = backgroundColor;
        }
        if (i38 & 3072 == 0) {
            if (i39 & 8 == 0) {
                changed = restartGroup.changed(edgePadding) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = edgePadding;
            }
            $dirty3 |= changed;
        } else {
            contentColorFor-ek8zF_U = edgePadding;
        }
        i7 = i39 & 16;
        if (i7 != 0) {
            $dirty3 |= 24576;
            f = divider;
        } else {
            if (i38 & 24576 == 0) {
                i18 = restartGroup.changed(divider) ? 16384 : 8192;
                $dirty3 |= i18;
            } else {
                f = divider;
            }
        }
        i6 = i39 & 32;
        int i42 = 196608;
        if (i6 != 0) {
            $dirty3 |= i42;
            indicator2 = tabs;
        } else {
            if (i42 &= i38 == 0) {
                i4 = restartGroup.changedInstance(tabs) ? 131072 : 65536;
                $dirty3 |= i4;
            } else {
                indicator2 = tabs;
            }
        }
        int i44 = i39 & 64;
        i5 = 1572864;
        if (i44 != 0) {
            $dirty3 |= i5;
            obj = $composer;
        } else {
            if (i38 & i5 == 0) {
                i = restartGroup.changedInstance($composer) ? 1048576 : 524288;
                $dirty3 |= i;
            } else {
                obj = $composer;
            }
        }
        i9 = 12582912;
        if (i39 & 128 != 0) {
            $dirty3 |= i9;
            obj2 = $changed;
        } else {
            if (i38 & i9 == 0) {
                i9 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty3 |= i9;
            } else {
                obj2 = $changed;
            }
        }
        if ($dirty3 & i2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i38 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        if (i39 & 4 != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(restartGroup, 6));
                            $dirty3 &= -897;
                        }
                        if (i39 & 8 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(primarySurface, obj7, restartGroup);
                            $dirty3 &= -7169;
                        }
                        if (i7 != 0) {
                            f = rememberComposableLambda;
                        }
                        if (i6 != 0) {
                            TabRowKt.ScrollableTabRow.1 anon2 = new TabRowKt.ScrollableTabRow.1(i8);
                            indicator2 = rememberComposableLambda;
                        }
                        if (i44 != 0) {
                            i14 = lambda-2$material_release;
                            f2 = f;
                            edgePadding2 = obj4;
                            modifier3 = $dirty3;
                            $dirty2 = indicator2;
                            indicator2 = primarySurface;
                            backgroundColor2 = i5;
                            i12 = -1473476840;
                            i5 = contentColorFor-ek8zF_U;
                        } else {
                            i14 = $composer;
                            f2 = f;
                            edgePadding2 = obj4;
                            modifier3 = $dirty3;
                            $dirty2 = indicator2;
                            indicator2 = primarySurface;
                            backgroundColor2 = i5;
                            i12 = -1473476840;
                            i5 = contentColorFor-ek8zF_U;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i39 & 4 != 0) {
                            $dirty3 &= -897;
                        }
                        if (i39 & 8 != 0) {
                            modifier3 = i29;
                            f2 = f;
                            edgePadding2 = $dirty4;
                            i14 = $composer;
                            $dirty2 = indicator2;
                            indicator2 = primarySurface;
                            backgroundColor2 = i5;
                            i12 = -1473476840;
                            i5 = contentColorFor-ek8zF_U;
                        } else {
                            i14 = $composer;
                            f2 = f;
                            edgePadding2 = obj4;
                            modifier3 = $dirty3;
                            $dirty2 = indicator2;
                            indicator2 = primarySurface;
                            backgroundColor2 = i5;
                            i12 = -1473476840;
                            i5 = contentColorFor-ek8zF_U;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i12, modifier3, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:244)");
                }
                obj27 = f2;
                obj26 = anon3;
                super(obj27, $changed, i14, $dirty2, i8);
                SurfaceKt.Surface-F-jzlyU(edgePadding2, 0, indicator2, i44, i5, i3, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1455860572, true, obj26, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = i8;
                obj3 = $dirty2;
                function2 = i14;
                $composer2 = edgePadding2;
                indicator3 = indicator2;
                modifier2 = modifier3;
                $dirty = i5;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = $dirty3;
                indicator3 = primarySurface;
                f3 = f4;
                composer = restartGroup;
                $composer2 = obj4;
                $dirty = contentColorFor-ek8zF_U;
                obj3 = indicator2;
                function2 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowKt.ScrollableTabRow.3(selectedTabIndex, $composer2, indicator3, i14, $dirty, primarySurface, f3, obj3, function2, $changed, i38, i39);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void TabRow-pAZo6Ak(int selectedTabIndex, Modifier modifier, long backgroundColor, long contentColor, Function3<? super List<androidx.compose.material.TabPosition>, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i10) {
        int divider2;
        int defaultsInvalid;
        int colors;
        int rememberComposableLambda;
        int i7;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int i2;
        int i14;
        boolean traceInProgress;
        Object obj;
        long modifier2;
        int i15;
        long primarySurface;
        long l;
        Object obj3;
        int changed2;
        int i;
        int i3;
        int i16;
        Object obj4;
        boolean changed;
        long contentColorFor-ek8zF_U;
        int i11;
        Object indicator2;
        int i8;
        Object obj2;
        int i13;
        int i6;
        int i9;
        int i4;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i12;
        int i5;
        long l2;
        i7 = selectedTabIndex;
        final Object obj6 = $changed;
        final int i29 = obj35;
        Composer restartGroup = i10.startRestartGroup(-249175289);
        ComposerKt.sourceInformation(restartGroup, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)136@6719L6,137@6768L32,139@6907L139,154@7356L1387,150@7225L1518:TabRow.kt#jmzs0o");
        $dirty2 = obj35;
        if (obj36 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i29 & 6 == 0) {
                i2 = restartGroup.changed(i7) ? 4 : 2;
                $dirty2 |= i2;
            }
        }
        int i22 = obj36 & 2;
        if (i22 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i29 & 48 == 0) {
                i15 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i15;
            } else {
                obj = modifier;
            }
        }
        if (i29 & 384 == 0) {
            if (obj36 & 4 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 256 : 128;
            } else {
                primarySurface = backgroundColor;
            }
            $dirty2 |= changed2;
        } else {
            primarySurface = backgroundColor;
        }
        if (i29 & 3072 == 0) {
            if (obj36 & 8 == 0) {
                i = restartGroup.changed(indicator) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = indicator;
            }
            $dirty2 |= i;
        } else {
            contentColorFor-ek8zF_U = indicator;
        }
        i3 = obj36 & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            indicator2 = tabs;
        } else {
            if (i29 & 24576 == 0) {
                i8 = restartGroup.changedInstance(tabs) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                indicator2 = tabs;
            }
        }
        int i32 = obj36 & 32;
        int i33 = 196608;
        if (i32 != 0) {
            $dirty2 |= i33;
            obj2 = $composer;
        } else {
            if (i33 &= i29 == 0) {
                i13 = restartGroup.changedInstance($composer) ? 131072 : 65536;
                $dirty2 |= i13;
            } else {
                obj2 = $composer;
            }
        }
        i9 = 1572864;
        if (obj36 & 64 != 0) {
            $dirty2 |= i9;
        } else {
            if (i29 & i9 == 0) {
                i6 = restartGroup.changedInstance(obj6) ? 1048576 : 524288;
                $dirty2 |= i6;
            }
        }
        int i35 = 599187;
        if ($dirty2 & i35 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i29 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i22 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (obj36 & 4 != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(restartGroup, 6));
                            $dirty2 &= -897;
                        }
                        if (obj36 & 8 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(primarySurface, obj7, restartGroup);
                            $dirty2 &= -7169;
                        }
                        if (i3 != 0) {
                            TabRowKt.TabRow.1 anon = new TabRowKt.TabRow.1(i7);
                            indicator2 = rememberComposableLambda;
                        }
                        if (i32 != 0) {
                            i7 = lambda-1$material_release;
                            obj2 = contentColorFor-ek8zF_U;
                            divider2 = indicator2;
                            i16 = 54;
                            indicator2 = primarySurface;
                        } else {
                            divider2 = indicator2;
                            i7 = obj2;
                            i16 = 54;
                            indicator2 = primarySurface;
                            obj2 = contentColorFor-ek8zF_U;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj36 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj36 & 8 != 0) {
                            $dirty2 = i21;
                            divider2 = indicator2;
                            i7 = obj2;
                            i16 = 54;
                            indicator2 = primarySurface;
                            obj2 = contentColorFor-ek8zF_U;
                        } else {
                            divider2 = indicator2;
                            i7 = obj2;
                            i16 = 54;
                            indicator2 = primarySurface;
                            obj2 = contentColorFor-ek8zF_U;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-249175289, $dirty2, -1, "androidx.compose.material.TabRow (TabRow.kt:149)");
                }
                TabRowKt.TabRow.2 anon2 = new TabRowKt.TabRow.2(obj6, i7, divider2);
                SurfaceKt.Surface-F-jzlyU(SelectableGroupKt.selectableGroup(obj), 0, indicator2, i32, obj2, i35, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1961746365, true, anon2, restartGroup, i16), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = divider2;
                obj4 = i7;
                i11 = $dirty2;
                $composer2 = obj;
                $dirty = indicator2;
                modifier2 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj;
                obj4 = obj2;
                i11 = $dirty2;
                $dirty = primarySurface;
                modifier2 = l2;
                obj3 = indicator2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            divider2 = new TabRowKt.TabRow.3(selectedTabIndex, $composer2, $dirty, i14, modifier2, primarySurface, obj3, obj4, obj6, i29, obj36);
            endRestartGroup.updateScope((Function2)divider2);
        }
    }

    public static final float access$getScrollableTabRowMinimumTabWidth$p() {
        return TabRowKt.ScrollableTabRowMinimumTabWidth;
    }

    public static final AnimationSpec access$getScrollableTabRowScrollSpec$p() {
        return TabRowKt.ScrollableTabRowScrollSpec;
    }
}
