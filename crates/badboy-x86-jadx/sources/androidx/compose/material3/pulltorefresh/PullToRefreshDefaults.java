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
        Object obj4;
        int $dirty;
        boolean traceInProgress;
        int i4;
        boolean z;
        float f;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int i11;
        Object obj3;
        Object modifier4;
        Object obj2;
        long l5;
        long containerColor2;
        Composer composer2;
        int i15;
        long l2;
        long l3;
        long color2;
        int changed2;
        long l4;
        float f3;
        int positionalThreshold;
        int i8;
        int changed;
        float f2;
        int changed3;
        Object obj;
        int i7;
        int i16;
        int skipping;
        int defaultsInvalid;
        int maybeCachedBoxMeasurePolicy;
        int i18;
        int i12;
        int i10;
        int i13;
        Modifier modifier3;
        int i2;
        int i14;
        Modifier modifier2;
        Composer composer3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        long l;
        Boolean valueOf;
        int i3;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i17;
        int i5;
        int i6;
        Object obj40;
        Alignment obj41;
        BoxScopeInstance obj42;
        int obj43;
        float obj44;
        kotlin.jvm.functions.Function0 obj45;
        int obj46;
        obj4 = state;
        i8 = obj47;
        traceInProgress2 = -1076870256;
        final Composer restartGroup = i9.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Indicator)P(4,2,3,1:c#ui.graphics.Color,0:c#ui.graphics.Color,5:c#ui.unit.Dp)437@16566L14,438@16627L14,441@16704L1007:PullToRefresh.kt#djiw08");
        $dirty = obj47;
        if (obj48 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i8 & 6 == 0) {
                i4 = restartGroup.changed(obj4) ? 4 : 2;
                $dirty |= i4;
            }
        }
        if (obj48 & 2 != 0) {
            $dirty |= 48;
            z = isRefreshing;
        } else {
            if (i8 & 48 == 0) {
                i11 = restartGroup.changed(isRefreshing) ? 32 : 16;
                $dirty |= i11;
            } else {
                z = isRefreshing;
            }
        }
        int i32 = obj48 & 4;
        if (i32 != 0) {
            $dirty |= 384;
            obj2 = modifier;
        } else {
            if (i8 & 384 == 0) {
                i15 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i15;
            } else {
                obj2 = modifier;
            }
        }
        if (i8 & 3072 == 0) {
            if (obj48 & 8 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                l2 = containerColor;
            }
            $dirty |= changed2;
        } else {
            l2 = containerColor;
        }
        if (i8 & 24576 == 0) {
            if (obj48 & 16 == 0) {
                changed = restartGroup.changed(threshold) ? 16384 : 8192;
            } else {
                l4 = threshold;
            }
            $dirty |= changed;
        } else {
            l4 = threshold;
        }
        if (i56 &= i8 == 0) {
            if (obj48 & 32 == 0) {
                changed3 = restartGroup.changed($changed) ? 131072 : 65536;
            } else {
                f2 = $changed;
            }
            $dirty |= changed3;
        } else {
            f2 = $changed;
        }
        i7 = 1572864;
        if (obj48 & 64 != 0) {
            $dirty |= i7;
            obj = this;
        } else {
            if (i8 & i7 == 0) {
                i7 = restartGroup.changed(this) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                obj = this;
            }
        }
        if (i61 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i63 = -57345;
                obj46 = -458753;
                int i62 = 6;
                if (i8 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = obj2;
                        }
                        if (obj48 & 8 != 0) {
                            containerColor2 = PullToRefreshDefaults.INSTANCE.getContainerColor(restartGroup, i62);
                            $dirty &= -7169;
                        } else {
                            containerColor2 = l2;
                        }
                        if (obj48 & 16 != 0) {
                            color2 = PullToRefreshDefaults.INSTANCE.getIndicatorColor(restartGroup, i62);
                            $dirty &= i63;
                        } else {
                            color2 = l4;
                        }
                        if (obj48 & 32 != 0) {
                            f2 = $dirty;
                            f = positionalThreshold;
                        } else {
                            f = f2;
                            f2 = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj48 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        if (obj48 & 16 != 0) {
                            $dirty &= i63;
                        }
                        if (obj48 & 32 != 0) {
                            $dirty &= obj46;
                        }
                        modifier4 = obj2;
                        containerColor2 = l2;
                        color2 = l4;
                        f = f2;
                        f2 = $dirty;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, f2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:440)");
                }
                Object obj5 = modifier4;
                i8 = l6;
                Modifier pullToRefreshIndicator-wUdLESc$default = PullToRefreshKt.pullToRefreshIndicator-wUdLESc$default(obj5, obj4, isRefreshing, f, 0, containerColor2, l2, 0, 40);
                Alignment center = Alignment.Companion.getCenter();
                int i49 = 48;
                l4 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i12 = 0;
                obj41 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj43 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, pullToRefreshIndicator-wUdLESc$default);
                obj45 = constructor;
                i10 = 0;
                modifier3 = pullToRefreshIndicator-wUdLESc$default;
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
                int i65 = 0;
                obj45 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i66 = 0;
                Composer composer4 = constructor-impl;
                int i67 = 0;
                if (!composer4.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    l = containerColor2;
                    if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(obj43))) {
                        composer4.updateRememberedValue(Integer.valueOf(obj43));
                        constructor-impl.apply(Integer.valueOf(obj43), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer4;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    l = containerColor2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                z = restartGroup;
                ComposerKt.sourceInformationMarkerStart(z, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i45 |= 6;
                composer = z;
                i2 = 0;
                i14 = i21;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(z, 396611011, "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08");
                int i27 = 0;
                i6 = i33;
                obj42 = iNSTANCE2;
                PullToRefreshDefaults.Indicator.1.1 anon = new PullToRefreshDefaults.Indicator.1.1(i8, f2, obj4);
                CrossfadeKt.Crossfade(Boolean.valueOf(isRefreshing), 0, (FiniteAnimationSpec)AnimationSpecKt.tween$default(100, 0, i27, i62, i27), 0, (Function3)ComposableLambdaKt.rememberComposableLambda(167807595, true, anon, z, 54), composer, i24 |= 24960, 10);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(z);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj40;
                f3 = obj44;
                l3 = i8;
                l5 = l;
            } else {
                restartGroup.skipToGroupEnd();
                i16 = $dirty;
                obj3 = obj2;
                l5 = l2;
                l3 = l4;
                f3 = f2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new PullToRefreshDefaults.Indicator.2(obj, obj4, isRefreshing, obj3, l5, l2, l3, l4, f3, obj47, obj48);
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
