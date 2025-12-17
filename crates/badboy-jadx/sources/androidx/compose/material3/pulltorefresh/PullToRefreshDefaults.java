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
        int i13;
        boolean z;
        float f;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int i3;
        Object obj;
        Object modifier3;
        Object obj3;
        long l2;
        long containerColor2;
        Composer composer3;
        int i2;
        long l5;
        long l;
        long color2;
        int changed2;
        long l3;
        float f3;
        int positionalThreshold;
        int i11;
        int changed;
        float f2;
        int changed3;
        Object obj2;
        int i12;
        int i14;
        int skipping;
        int defaultsInvalid;
        int maybeCachedBoxMeasurePolicy;
        int i10;
        int i16;
        int i6;
        int i4;
        Modifier modifier2;
        int i;
        int i5;
        Modifier modifier4;
        Composer composer2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        long l4;
        Boolean valueOf;
        int i8;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i15;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i17;
        int i18;
        int i7;
        Object obj40;
        Alignment obj41;
        BoxScopeInstance obj42;
        int obj43;
        float obj44;
        kotlin.jvm.functions.Function0 obj45;
        int obj46;
        obj4 = state;
        i11 = obj47;
        traceInProgress2 = -1076870256;
        final Composer restartGroup = i9.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Indicator)P(4,2,3,1:c#ui.graphics.Color,0:c#ui.graphics.Color,5:c#ui.unit.Dp)437@16566L14,438@16627L14,441@16704L1007:PullToRefresh.kt#djiw08");
        $dirty = obj47;
        if (obj48 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i11 & 6 == 0) {
                i13 = restartGroup.changed(obj4) ? 4 : 2;
                $dirty |= i13;
            }
        }
        if (obj48 & 2 != 0) {
            $dirty |= 48;
            z = isRefreshing;
        } else {
            if (i11 & 48 == 0) {
                i3 = restartGroup.changed(isRefreshing) ? 32 : 16;
                $dirty |= i3;
            } else {
                z = isRefreshing;
            }
        }
        int i32 = obj48 & 4;
        if (i32 != 0) {
            $dirty |= 384;
            obj3 = modifier;
        } else {
            if (i11 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj3 = modifier;
            }
        }
        if (i11 & 3072 == 0) {
            if (obj48 & 8 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 2048 : 1024;
            } else {
                l5 = containerColor;
            }
            $dirty |= changed2;
        } else {
            l5 = containerColor;
        }
        if (i11 & 24576 == 0) {
            if (obj48 & 16 == 0) {
                changed = restartGroup.changed(threshold) ? 16384 : 8192;
            } else {
                l3 = threshold;
            }
            $dirty |= changed;
        } else {
            l3 = threshold;
        }
        if (i55 &= i11 == 0) {
            if (obj48 & 32 == 0) {
                changed3 = restartGroup.changed($changed) ? 131072 : 65536;
            } else {
                f2 = $changed;
            }
            $dirty |= changed3;
        } else {
            f2 = $changed;
        }
        i12 = 1572864;
        if (obj48 & 64 != 0) {
            $dirty |= i12;
            obj2 = this;
        } else {
            if (i11 & i12 == 0) {
                i12 = restartGroup.changed(this) ? 1048576 : 524288;
                $dirty |= i12;
            } else {
                obj2 = this;
            }
        }
        if (i60 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i62 = -57345;
                obj46 = -458753;
                int i61 = 6;
                if (i11 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj3;
                        }
                        if (obj48 & 8 != 0) {
                            containerColor2 = PullToRefreshDefaults.INSTANCE.getContainerColor(restartGroup, i61);
                            $dirty &= -7169;
                        } else {
                            containerColor2 = l5;
                        }
                        if (obj48 & 16 != 0) {
                            color2 = PullToRefreshDefaults.INSTANCE.getIndicatorColor(restartGroup, i61);
                            $dirty &= i62;
                        } else {
                            color2 = l3;
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
                            $dirty &= i62;
                        }
                        if (obj48 & 32 != 0) {
                            $dirty &= obj46;
                        }
                        modifier3 = obj3;
                        containerColor2 = l5;
                        color2 = l3;
                        f = f2;
                        f2 = $dirty;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, f2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:440)");
                }
                Object obj5 = modifier3;
                i11 = l6;
                Modifier pullToRefreshIndicator-wUdLESc$default = PullToRefreshKt.pullToRefreshIndicator-wUdLESc$default(obj5, obj4, isRefreshing, f, 0, containerColor2, l5, 0, 40);
                Alignment center = Alignment.Companion.getCenter();
                int i48 = 48;
                l3 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i16 = 0;
                obj41 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj43 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, pullToRefreshIndicator-wUdLESc$default);
                obj45 = constructor;
                i6 = 0;
                modifier2 = pullToRefreshIndicator-wUdLESc$default;
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
                        composer3 = composer4;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    l4 = containerColor2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                z = restartGroup;
                ComposerKt.sourceInformationMarkerStart(z, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i44 |= 6;
                composer = z;
                i = 0;
                i5 = i21;
                modifier4 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(z, 396611011, "C454@17197L504,451@17052L649:PullToRefresh.kt#djiw08");
                int i27 = 0;
                i7 = i33;
                obj42 = iNSTANCE2;
                PullToRefreshDefaults.Indicator.1.1 anon = new PullToRefreshDefaults.Indicator.1.1(i11, f2, obj4);
                CrossfadeKt.Crossfade(Boolean.valueOf(isRefreshing), 0, (FiniteAnimationSpec)AnimationSpecKt.tween$default(100, 0, i27, i61, i27), 0, (Function3)ComposableLambdaKt.rememberComposableLambda(167807595, true, anon, z, 54), composer, i24 |= 24960, 10);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(z);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj40;
                f3 = obj44;
                l = i11;
                l2 = l4;
            } else {
                restartGroup.skipToGroupEnd();
                i14 = $dirty;
                obj = obj3;
                l2 = l5;
                l = l3;
                f3 = f2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new PullToRefreshDefaults.Indicator.2(obj2, obj4, isRefreshing, obj, l2, l5, l, l3, f3, obj47, obj48);
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
