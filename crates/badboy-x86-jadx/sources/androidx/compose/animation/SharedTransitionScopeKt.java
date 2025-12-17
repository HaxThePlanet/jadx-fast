package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale.Companion;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001cH\u0003\u001a5\u0010&\u001a\u00020'2\u0008\u0008\u0002\u0010(\u001a\u00020)2\u001c\u0010*\u001a\u0018\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'0+¢\u0006\u0002\u0008-¢\u0006\u0002\u0008.H\u0007¢\u0006\u0002\u0010/\u001a1\u00100\u001a\u00020'2\"\u0010*\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020'0\u0005¢\u0006\u0002\u0008-¢\u0006\u0002\u0008.H\u0007¢\u0006\u0002\u00101\u001a\"\u00102\u001a\u00020)*\u00020)2\u0006\u00103\u001a\u00020\u001d2\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\"\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0011\u0010\u0003\"\u001b\u0010\u0012\u001a\u00020\u00138@X\u0080\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015\"\u000e\u0010\u0018\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000\".\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a0\u001a8\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u001e\u0010\u0003\"\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!\"\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010\"¨\u00065", d2 = {"DefaultBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getDefaultBoundsTransform$annotations", "()V", "DefaultClipInOverlayDuringTransition", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "DefaultEnabled", "Lkotlin/Function0;", "", "DefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "ParentClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "getParentClip$annotations", "SharedTransitionObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSharedTransitionObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SharedTransitionObserver$delegate", "Lkotlin/Lazy;", "VisualDebugging", "cachedScaleToBoundsImplMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/ContentScale;", "Landroidx/compose/ui/Alignment;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "getCachedScaleToBoundsImplMap$annotations", "shouldCache", "getShouldCache", "(Landroidx/compose/ui/Alignment;)Z", "(Landroidx/compose/ui/layout/ContentScale;)Z", "ScaleToBoundsCached", "contentScale", "alignment", "SharedTransitionLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SharedTransitionScope", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "createContentScaleModifier", "scaleToBounds", "isEnabled", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SharedTransitionScopeKt {

    private static final androidx.compose.animation.BoundsTransform DefaultBoundsTransform = null;
    private static final Function2<LayoutDirection, Density, Path> DefaultClipInOverlayDuringTransition = null;
    private static final Function0<Boolean> DefaultEnabled = null;
    private static final SpringSpec<Rect> DefaultSpring = null;
    private static final androidx.compose.animation.SharedTransitionScope.OverlayClip ParentClip = null;
    private static final Lazy SharedTransitionObserver$delegate = null;
    public static final boolean VisualDebugging = false;
    private static final MutableScatterMap<ContentScale, MutableScatterMap<Alignment, androidx.compose.animation.ScaleToBoundsImpl>> cachedScaleToBoundsImplMap;
    public static FiniteAnimationSpec $r8$lambda$X-h2M7dI1ZfJFWUnZAfDmKErRWg(Rect rect, Rect rect2) {
        return SharedTransitionScopeKt.DefaultBoundsTransform$lambda$0(rect, rect2);
    }

    static {
        SharedTransitionScopeKt.DefaultEnabled = (Function0)SharedTransitionScopeKt.DefaultEnabled.1.INSTANCE;
        final int i4 = 1;
        final int i5 = 0;
        SharedTransitionScopeKt.DefaultSpring = AnimationSpecKt.spring$default(0, 1137180672, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), i4, i5);
        SharedTransitionScopeKt.ParentClip.1 anon = new SharedTransitionScopeKt.ParentClip.1();
        SharedTransitionScopeKt.ParentClip = (SharedTransitionScope.OverlayClip)anon;
        SharedTransitionScopeKt.DefaultClipInOverlayDuringTransition = (Function2)SharedTransitionScopeKt.DefaultClipInOverlayDuringTransition.1.INSTANCE;
        SharedTransitionScopeKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SharedTransitionScopeKt$$ExternalSyntheticLambda0();
        SharedTransitionScopeKt.DefaultBoundsTransform = externalSyntheticLambda0;
        SharedTransitionScopeKt.SharedTransitionObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0)SharedTransitionScopeKt.SharedTransitionObserver.2.INSTANCE);
        MutableScatterMap mutableScatterMap = new MutableScatterMap(0, i4, i5);
        SharedTransitionScopeKt.cachedScaleToBoundsImplMap = mutableScatterMap;
    }

    private static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect rect, Rect rect2) {
        return (FiniteAnimationSpec)SharedTransitionScopeKt.DefaultSpring;
    }

    private static final androidx.compose.animation.ScaleToBoundsImpl ScaleToBoundsCached(ContentScale contentScale, Alignment alignment) {
        boolean shouldCache;
        Object obj2;
        MutableScatterMap mutableScatterMap;
        Object obj;
        int scaleToBoundsImpl;
        int i;
        int i2;
        MutableScatterMap cachedScaleToBoundsImplMap = SharedTransitionScopeKt.cachedScaleToBoundsImplMap;
        int i3 = 0;
        if (SharedTransitionScopeKt.getShouldCache(contentScale) && SharedTransitionScopeKt.getShouldCache(alignment) && cachedScaleToBoundsImplMap.get(contentScale) == null) {
            if (SharedTransitionScopeKt.getShouldCache(alignment)) {
                cachedScaleToBoundsImplMap = SharedTransitionScopeKt.cachedScaleToBoundsImplMap;
                i3 = 0;
                if (cachedScaleToBoundsImplMap.get(contentScale) == null) {
                    int i4 = 0;
                    mutableScatterMap = new MutableScatterMap(0, 1, 0);
                    scaleToBoundsImpl = 0;
                    cachedScaleToBoundsImplMap.set(contentScale, mutableScatterMap);
                }
                Object obj3 = this_$iv;
                int i5 = 0;
                if (obj3.get(alignment) == null) {
                    int i6 = 0;
                    scaleToBoundsImpl = new ScaleToBoundsImpl(contentScale, alignment);
                    i = 0;
                    obj3.set(alignment, scaleToBoundsImpl);
                }
                return (ScaleToBoundsImpl)obj;
            }
        }
        ScaleToBoundsImpl map = new ScaleToBoundsImpl(contentScale, alignment);
        return map;
    }

    public static final void SharedTransitionLayout(Modifier modifier, Function3<? super androidx.compose.animation.SharedTransitionScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i5) {
        int traceInProgress2;
        int $dirty;
        int companion;
        boolean traceInProgress;
        int i;
        int i2;
        int skipping;
        int i3;
        Object obj5;
        traceInProgress2 = 2043053727;
        final Composer obj7 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj7, "C(SharedTransitionLayout)P(1)112@5418L299,112@5396L321:SharedTransitionScope.kt#xbi5r1");
        $dirty = $changed;
        companion = i5 & 1;
        if (companion != 0) {
            $dirty |= 6;
        } else {
            if ($changed & 6 == 0) {
                i = obj7.changed(modifier) ? 4 : 2;
                $dirty |= i;
            }
        }
        if (i5 & 2 != 0) {
            $dirty |= 48;
        } else {
            if ($changed & 48 == 0) {
                i2 = obj7.changedInstance(content) ? 32 : 16;
                $dirty |= i2;
            }
        }
        if ($dirty & 19 == 18) {
            if (!obj7.getSkipping()) {
                if (companion != 0) {
                    obj5 = companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:111)");
                }
                SharedTransitionScopeKt.SharedTransitionLayout.1 anon = new SharedTransitionScopeKt.SharedTransitionLayout.1(obj5, content);
                SharedTransitionScopeKt.SharedTransitionScope((Function4)ComposableLambdaKt.rememberComposableLambda(-130587847, true, anon, obj7, 54), obj7, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj7.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj7.endRestartGroup();
        if (endRestartGroup != null) {
            companion = new SharedTransitionScopeKt.SharedTransitionLayout.2(obj5, content, $changed, i5);
            endRestartGroup.updateScope((Function2)companion);
        }
    }

    public static final void SharedTransitionScope(Function4<? super androidx.compose.animation.SharedTransitionScope, ? super Modifier, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i;
        int skipping;
        boolean traceInProgress;
        int str;
        int i2;
        traceInProgress2 = -2093217917;
        final Composer obj6 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj6, "C(SharedTransitionScope)139@6613L1099,139@6598L1114:SharedTransitionScope.kt#xbi5r1");
        str = 2;
        if ($changed & 6 == 0) {
            i = obj6.changedInstance(content) ? 4 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj6.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:138)");
                }
                SharedTransitionScopeKt.SharedTransitionScope.1 anon = new SharedTransitionScopeKt.SharedTransitionScope.1(content);
                LookaheadScopeKt.LookaheadScope((Function3)ComposableLambdaKt.rememberComposableLambda(-863967934, true, anon, obj6, 54), obj6, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj6.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj6.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new SharedTransitionScopeKt.SharedTransitionScope.2(content, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final androidx.compose.animation.ScaleToBoundsImpl access$ScaleToBoundsCached(ContentScale contentScale, Alignment alignment) {
        return SharedTransitionScopeKt.ScaleToBoundsCached(contentScale, alignment);
    }

    public static final Modifier access$createContentScaleModifier(Modifier $receiver, androidx.compose.animation.ScaleToBoundsImpl scaleToBounds, Function0 isEnabled) {
        return SharedTransitionScopeKt.createContentScaleModifier($receiver, scaleToBounds, isEnabled);
    }

    public static final androidx.compose.animation.BoundsTransform access$getDefaultBoundsTransform$p() {
        return SharedTransitionScopeKt.DefaultBoundsTransform;
    }

    public static final Function2 access$getDefaultClipInOverlayDuringTransition$p() {
        return SharedTransitionScopeKt.DefaultClipInOverlayDuringTransition;
    }

    public static final Function0 access$getDefaultEnabled$p() {
        return SharedTransitionScopeKt.DefaultEnabled;
    }

    public static final androidx.compose.animation.SharedTransitionScope.OverlayClip access$getParentClip$p() {
        return SharedTransitionScopeKt.ParentClip;
    }

    private static final Modifier createContentScaleModifier(Modifier $this$createContentScaleModifier, androidx.compose.animation.ScaleToBoundsImpl scaleToBounds, Function0<Boolean> isEnabled) {
        Modifier graphicsLayer;
        Object crop;
        if (Intrinsics.areEqual(scaleToBounds.getContentScale(), ContentScale.Companion.getCrop())) {
            crop = new SharedTransitionScopeKt.createContentScaleModifier.1(isEnabled);
            graphicsLayer = GraphicsLayerModifierKt.graphicsLayer((Modifier)Modifier.Companion, (Function1)crop);
        } else {
            graphicsLayer = Modifier.Companion;
        }
        SkipToLookaheadElement skipToLookaheadElement = new SkipToLookaheadElement(scaleToBounds, isEnabled);
        return $this$createContentScaleModifier.then(graphicsLayer).then((Modifier)skipToLookaheadElement);
    }

    private static void getCachedScaleToBoundsImplMap$annotations() {
    }

    private static void getDefaultBoundsTransform$annotations() {
    }

    private static void getParentClip$annotations() {
    }

    public static final SnapshotStateObserver getSharedTransitionObserver() {
        return (SnapshotStateObserver)SharedTransitionScopeKt.SharedTransitionObserver$delegate.getValue();
    }

    private static final boolean getShouldCache(Alignment $this$shouldCache) {
        Alignment bottomCenter;
        int i;
        if ($this$shouldCache != Alignment.Companion.getTopStart() && $this$shouldCache != Alignment.Companion.getTopCenter() && $this$shouldCache != Alignment.Companion.getTopEnd() && $this$shouldCache != Alignment.Companion.getCenterStart() && $this$shouldCache != Alignment.Companion.getCenter() && $this$shouldCache != Alignment.Companion.getCenterEnd() && $this$shouldCache != Alignment.Companion.getBottomStart() && $this$shouldCache != Alignment.Companion.getBottomCenter()) {
            if ($this$shouldCache != Alignment.Companion.getTopCenter()) {
                if ($this$shouldCache != Alignment.Companion.getTopEnd()) {
                    if ($this$shouldCache != Alignment.Companion.getCenterStart()) {
                        if ($this$shouldCache != Alignment.Companion.getCenter()) {
                            if ($this$shouldCache != Alignment.Companion.getCenterEnd()) {
                                if ($this$shouldCache != Alignment.Companion.getBottomStart()) {
                                    if ($this$shouldCache != Alignment.Companion.getBottomCenter()) {
                                        if ($this$shouldCache == Alignment.Companion.getBottomEnd()) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final boolean getShouldCache(ContentScale $this$shouldCache) {
        int i;
        ContentScale fillHeight;
        if ($this$shouldCache != ContentScale.Companion.getFillWidth() && $this$shouldCache != ContentScale.Companion.getFillHeight() && $this$shouldCache != ContentScale.Companion.getFillBounds() && $this$shouldCache != ContentScale.Companion.getFit() && $this$shouldCache != ContentScale.Companion.getCrop() && $this$shouldCache != ContentScale.Companion.getNone()) {
            if ($this$shouldCache != ContentScale.Companion.getFillHeight()) {
                if ($this$shouldCache != ContentScale.Companion.getFillBounds()) {
                    if ($this$shouldCache != ContentScale.Companion.getFit()) {
                        if ($this$shouldCache != ContentScale.Companion.getCrop()) {
                            if ($this$shouldCache != ContentScale.Companion.getNone()) {
                                if ($this$shouldCache == ContentScale.Companion.getInside()) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
