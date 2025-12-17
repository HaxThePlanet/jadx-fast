package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0017\u0010\n\u001a\u00020\u000b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0017\u0010\u000e\u001a\u00020\u000b8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "PositionalThreshold", "getPositionalThreshold-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "indicatorColor", "getIndicatorColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "Indicator", "", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "threshold", "Indicator-2poqoh4", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;JJFLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PullToRefreshDefaults {

    public static final int $stable;
    private static final float Elevation;
    public static final androidx.compose.material3.pulltorefresh.PullToRefreshDefaults INSTANCE;
    private static final float PositionalThreshold;
    private static final Shape shape;
    static {
        PullToRefreshDefaults pullToRefreshDefaults = new PullToRefreshDefaults();
        PullToRefreshDefaults.INSTANCE = pullToRefreshDefaults;
        PullToRefreshDefaults.shape = (Shape)RoundedCornerShapeKt.getCircleShape();
        final int i2 = 0;
        PullToRefreshDefaults.PositionalThreshold = Dp.constructor-impl((float)i);
        PullToRefreshDefaults.Elevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
    }

    public final void Indicator-2poqoh4(androidx.compose.material3.pulltorefresh.PullToRefreshState state, boolean isRefreshing, Modifier modifier, long containerColor, long color, float threshold, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        Integer currentCompositionLocalMap;
        Object obj;
        int $dirty;
        boolean traceInProgress;
        int i17;
        boolean z;
        float f2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int i10;
        Object obj2;
        Object modifier2;
        Object obj3;
        long l5;
        long containerColor2;
        Composer composer;
        int i15;
        long l;
        long l2;
        long color2;
        int changed2;
        long l3;
        float f;
        int positionalThreshold;
        int i13;
        int changed3;
        float f3;
        int changed;
        Object obj4;
        int i16;
        int i;
        int skipping;
        int defaultsInvalid;
        int maybeCachedBoxMeasurePolicy;
        int i3;
        int i4;
        int i5;
        int i6;
        Modifier modifier4;
        int i2;
        int i8;
        Modifier modifier3;
        Composer composer2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        long l4;
        Boolean valueOf;
        int i7;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i14;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer3;
        int i11;
        int i18;
        int i12;
        Object obj40;
        Alignment obj41;
        BoxScopeInstance obj42;
        int obj43;
        float obj44;
        kotlin.jvm.functions.Function0 obj45;
        int obj46;
        obj = state;
        i13 = obj47;
        traceInProgress2 = -1076870256;
        final Composer restartGroup = i9.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Indicator)P(4,2,3,1:c#ui.graphics.Color,0:c#ui.graphics.Color,5:c#ui.unit.Dp)437@16566L14,438@16627L14,441@16704L1007:PullToRefresh.kt#djiw08");
        $dirty = obj47;
        if (obj48 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i13 & 6 == 0) {
                i17 = restartGroup.changed(obj) ? 4 : 2;
                $dirty |= i17;
            }
        }
        if (obj48 & 2 != 0) {
            $dirty |= 48;
            z = isRefreshing;
        } else {
            if (i13 & 48 == 0) {
                i10 = restartGroup.changed(isRefreshing) ? 32 : 16;
                $dirty |= i10;
            } else {
                z = isRefreshing;
            }
        }
        int i32 = obj48 & 4;
        if (i32 != 0) {
            $dirty |= 384;
            obj3 = modifier;
        } else {
            if (i13 & 384 == 0) {
                i15 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i15;
            } else {
                obj3 = modifier;
            }
        }
        if (i13 & 3072 == 0) {
            if (obj48 & 8 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                l = containerColor;
            }
            $dirty |= changed2;
        } else {
            l = containerColor;
        }
        if (i13 & 24576 == 0) {
            if (obj48 & 16 == 0) {
                changed3 = restartGroup.changed(threshold) ? 16384 : 8192;
            } else {
                l3 = threshold;
            }
            $dirty |= changed3;
        } else {
            l3 = threshold;
        }
        if (i55 &= i13 == 0) {
            if (obj48 & 32 == 0) {
                changed = restartGroup.changed($changed) ? 131072 : 65536;
            } else {
                f3 = $changed;
            }
            $dirty |= changed;
        } else {
            f3 = $changed;
        }
        i16 = 1572864;
        if (obj48 & 64 != 0) {
            $dirty |= i16;
            obj4 = this;
        } else {
            if (i13 & i16 == 0) {
                i16 = restartGroup.changed(this) ? 1048576 : 524288;
                $dirty |= i16;
            } else {
                obj4 = this;
            }
        }
        if (i60 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i62 = -57345;
                obj46 = -458753;
                int i61 = 6;
                if (i13 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj3;
                        }
                        if (obj48 & 8 != 0) {
                            containerColor2 = PullToRefreshDefaults.INSTANCE.getContainerColor(restartGroup, i61);
                            $dirty &= -7169;
                        } else {
                            containerColor2 = l;
                        }
                        if (obj48 & 16 != 0) {
                            color2 = PullToRefreshDefaults.INSTANCE.getIndicatorColor(restartGroup, i61);
                            $dirty &= i62;
                        } else {
                            color2 = l3;
                        }
                        if (obj48 & 32 != 0) {
                            f3 = $dirty;
                            f2 = positionalThreshold;
                        } else {
                            f2 = f3;
                            f3 = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj48 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (obj48 & 16 != 0) {
                            $dirty &= i62;
                        }
                        if (obj48 & 32 != 0) {
                            $dirty &= obj46;
                        }
                        modifier2 = obj3;
                        containerColor2 = l;
                        color2 = l3;
                        f2 = f3;
                        f3 = $dirty;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, f3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:440)");
                }
                Object obj5 = modifier2;
                i13 = l6;
                Modifier pullToRefreshIndicator-wUdLESc$default = PullToRefreshKt.pullToRefreshIndicator-wUdLESc$default(obj5, obj, isRefreshing, f2, 0, containerColor2, l, 0, 40);
                Alignment center = Alignment.Companion.getCenter();
                int i48 = 48;
                l3 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i4 = 0;
                obj41 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj43 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, pullToRefreshIndicator-wUdLESc$default);
                obj45 = constructor;
                i5 = 0;
                modifier4 = pullToRefreshIndicator-wUdLESc$default;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj45);
                } else {
                    factory$iv$iv$iv = obj45;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i64 = 0;
                obj45 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i65 = 0;
                Composer composer4 = constructor-impl;
                int i66 = 0;
                if (!composer4.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    l4 = containerColor2;
                    if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(obj43))) {
                        composer4.updateRememberedValue(Integer.valueOf(obj43));
                        constructor-impl.apply(Integer.valueOf(obj43), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer4;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    l4 = containerColor2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                z = restartGroup;
                ComposerKt.sourceInformationMarkerStart(z, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i44 |= 6;
                composer3 = z;
                i2 = 0;
                i8 = i21;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(z, 396611011, "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08");
                int i27 = 0;
                i12 = i33;
                obj42 = iNSTANCE2;
                PullToRefreshDefaults.Indicator.1.1 anon = new PullToRefreshDefaults.Indicator.1.1(i13, f3, obj);
                CrossfadeKt.Crossfade(Boolean.valueOf(isRefreshing), 0, (FiniteAnimationSpec)AnimationSpecKt.tween$default(100, 0, i27, i61, i27), 0, (Function3)ComposableLambdaKt.rememberComposableLambda(167807595, true, anon, z, 54), composer3, i24 |= 24960, 10);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(z);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj40;
                f = obj44;
                l2 = i13;
                l5 = l4;
            } else {
                restartGroup.skipToGroupEnd();
                i = $dirty;
                obj2 = obj3;
                l5 = l;
                l2 = l3;
                f = f3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new PullToRefreshDefaults.Indicator.2(obj4, obj, isRefreshing, obj2, l5, l, l2, l3, f, obj47, obj48);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1066257972;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C419@15907L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:419)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurfaceContainerHigh-0d7_KjU();
    }

    public final float getElevation-D9Ej5fM() {
        return PullToRefreshDefaults.Elevation;
    }

    public final long getIndicatorColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1441334156;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C423@16068L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorColor> (PullToRefresh.kt:423)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return MaterialTheme.INSTANCE.getColorScheme($composer, 6).getOnSurfaceVariant-0d7_KjU();
    }

    public final float getPositionalThreshold-D9Ej5fM() {
        return PullToRefreshDefaults.PositionalThreshold;
    }

    public final Shape getShape() {
        return PullToRefreshDefaults.shape;
    }
}
