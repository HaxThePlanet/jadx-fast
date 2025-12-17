package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aA\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a?\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\r\u001aI\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u00022\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0010\u001aG\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012", d2 = {"collectAsStateWithLifecycle", "Landroidx/compose/runtime/State;", "T", "Lkotlinx/coroutines/flow/StateFlow;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/StateFlow;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lkotlinx/coroutines/flow/StateFlow;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/Flow;", "initialValue", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "lifecycle-runtime-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FlowExtKt {
    public static final <T> State<T> collectAsStateWithLifecycle(Flow<? extends T> $this$collectAsStateWithLifecycle, T initialValue, Lifecycle lifecycle, Lifecycle.State minActiveState, CoroutineContext context, Composer $composer, int $changed, int i8) {
        int empty;
        Object anon;
        Lifecycle.State minActiveState2;
        EmptyCoroutineContext context2;
        boolean traceInProgress;
        boolean changed;
        int i2;
        boolean changedInstance;
        String str;
        int i;
        int i3;
        Object obj = lifecycle;
        final Composer composer = $composer;
        final int i16 = $changed;
        int i4 = 1977777920;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(collectAsStateWithLifecycle)P(1,2,3)175@7714L383,175@7645L452:FlowExt.kt#2vxrgp");
        minActiveState2 = i8 & 4 != 0 ? Lifecycle.State.STARTED : minActiveState;
        if (i8 & 8 != 0) {
            context2 = EmptyCoroutineContext.INSTANCE;
        } else {
            context2 = context;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i16, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:174)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2025920321, "CC(remember):FlowExt.kt#9igjgp");
        i = 2048;
        if (i13 ^= 3072 > i) {
            if (!composer.changed((Enum)minActiveState2.ordinal())) {
                i2 = i16 & 3072 == i ? 1 : 0;
            } else {
            }
        } else {
        }
        final Composer composer2 = $composer;
        final int i18 = 0;
        final Object rememberedValue = composer2.rememberedValue();
        final int i19 = 0;
        if (empty | changedInstance == null) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i3 = 0;
                anon = new FlowExtKt.collectAsStateWithLifecycle.1.1(obj, minActiveState2, context2, $this$collectAsStateWithLifecycle, 0);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SnapshotStateKt.produceState(initialValue, /* result */, (Function2)anon, composer, i9 |= i15);
    }

    public static final <T> State<T> collectAsStateWithLifecycle(Flow<? extends T> $this$collectAsStateWithLifecycle, T initialValue, LifecycleOwner lifecycleOwner, Lifecycle.State minActiveState, CoroutineContext context, Composer $composer, int $changed, int i8) {
        int localLifecycleOwner;
        int i;
        int i2;
        Object consume;
        Lifecycle.State state;
        String str;
        EmptyCoroutineContext context2;
        Object obj12;
        Lifecycle.State obj13;
        EmptyCoroutineContext obj14;
        final int i3 = $changed;
        final int i4 = -1485997211;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(collectAsStateWithLifecycle)P(1,2,3)134@5911L7,138@6055L184:FlowExt.kt#2vxrgp");
        if (i8 & 2 != 0) {
            i = 6;
            i2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($composer);
            obj12 = consume;
        }
        state = i8 & 4 != 0 ? obj13 : minActiveState;
        if (i8 & 8 != 0) {
            context2 = obj14;
        } else {
            context2 = context;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i3, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:138)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return FlowExtKt.collectAsStateWithLifecycle($this$collectAsStateWithLifecycle, initialValue, obj12.getLifecycle(), state, context2, $composer, obj13 | obj14, 0);
    }

    public static final <T> State<T> collectAsStateWithLifecycle(StateFlow<? extends T> $this$collectAsStateWithLifecycle, Lifecycle lifecycle, Lifecycle.State minActiveState, CoroutineContext context, Composer $composer, int $changed, int i7) {
        Lifecycle.State state;
        EmptyCoroutineContext context2;
        Lifecycle.State obj11;
        EmptyCoroutineContext obj12;
        final int i = -1858162195;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(collectAsStateWithLifecycle)P(1,2)99@4351L167:FlowExt.kt#2vxrgp");
        state = i7 & 2 != 0 ? obj11 : minActiveState;
        if (i7 & 4 != 0) {
            context2 = obj12;
        } else {
            context2 = context;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:99)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return FlowExtKt.collectAsStateWithLifecycle((Flow)$this$collectAsStateWithLifecycle, $this$collectAsStateWithLifecycle.getValue(), lifecycle, state, context2, composer, obj11 | obj12, 0);
    }

    public static final <T> State<T> collectAsStateWithLifecycle(StateFlow<? extends T> $this$collectAsStateWithLifecycle, LifecycleOwner lifecycleOwner, Lifecycle.State minActiveState, CoroutineContext context, Composer $composer, int $changed, int i7) {
        int localLifecycleOwner;
        int i2;
        int i;
        Object consume;
        Lifecycle.State state;
        String str;
        EmptyCoroutineContext context2;
        Object obj10;
        Lifecycle.State obj11;
        EmptyCoroutineContext obj12;
        final int i3 = 743249048;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(collectAsStateWithLifecycle)P(1,2)58@2561L7,62@2705L182:FlowExt.kt#2vxrgp");
        if (i7 & 1 != 0) {
            i2 = 6;
            i = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($composer);
            obj10 = consume;
        }
        state = i7 & 2 != 0 ? obj11 : minActiveState;
        if (i7 & 4 != 0) {
            context2 = obj12;
        } else {
            context2 = context;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:62)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return FlowExtKt.collectAsStateWithLifecycle((Flow)$this$collectAsStateWithLifecycle, $this$collectAsStateWithLifecycle.getValue(), obj10.getLifecycle(), state, context2, composer, obj11 | obj12, 0);
    }
}
