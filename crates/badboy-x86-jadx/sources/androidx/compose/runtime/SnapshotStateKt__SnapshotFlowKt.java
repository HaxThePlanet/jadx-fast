package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u001a?\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0008\u0008\u0000\u0010\u0002*\u0002H\u0007\"\u0004\u0008\u0001\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0008\u001a\u0002H\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0008\u0008\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001a%\u0010\u000e\u001a\u00020\u000f*\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0013H\u0002¢\u0006\u0002\u0008\u0014¨\u0006\u0015", d2 = {"snapshotFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function0;", "collectAsState", "Landroidx/compose/runtime/State;", "R", "initial", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intersects", "", "Landroidx/collection/MutableScatterSet;", "", "set", "", "intersects$SnapshotStateKt__SnapshotFlowKt", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
final class SnapshotStateKt__SnapshotFlowKt {
    public static final boolean access$intersects(MutableScatterSet $receiver, Set set) {
        return SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt($receiver, set);
    }

    public static final <T extends R, R> androidx.compose.runtime.State<R> collectAsState(Flow<? extends T> $this$collectAsState, R initial, CoroutineContext context, androidx.compose.runtime.Composer $composer, int $changed, int i6) {
        EmptyCoroutineContext context2;
        Object empty;
        Object anon;
        int i;
        EmptyCoroutineContext obj9;
        int obj12;
        int i2 = -606625098;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(collectAsState)P(1)65@2578L149,65@2541L186:SnapshotFlow.kt#9igjgp");
        if (i6 &= 2 != 0) {
            context2 = obj9;
        } else {
            context2 = context;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:65)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -498556383, "CC(remember):SnapshotFlow.kt#9igjgp");
        obj12 = $composer;
        int i3 = 0;
        Object rememberedValue = obj12.rememberedValue();
        int i4 = 0;
        if (obj9 |= obj12 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SnapshotStateKt__SnapshotFlowKt.collectAsState.1.1(context2, $this$collectAsState, 0);
                obj12.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        androidx.compose.runtime.Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SnapshotStateKt.produceState(initial, $this$collectAsState, context2, (Function2)anon, composer, obj9 | obj12);
    }

    public static final <T> androidx.compose.runtime.State<T> collectAsState(StateFlow<? extends T> $this$collectAsState, CoroutineContext context, androidx.compose.runtime.Composer $composer, int $changed, int i5) {
        EmptyCoroutineContext context2;
        EmptyCoroutineContext obj8;
        int obj11;
        final int i = -1439883919;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(collectAsState)49@1909L30:SnapshotFlow.kt#9igjgp");
        if (i5 &= 1 != 0) {
            context2 = obj8;
        } else {
            context2 = context;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:49)");
        }
        final androidx.compose.runtime.Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SnapshotStateKt.collectAsState((Flow)$this$collectAsState, $this$collectAsState.getValue(), context2, composer, obj8 | obj11, 0);
    }

    private static final boolean intersects$SnapshotStateKt__SnapshotFlowKt(MutableScatterSet<Object> $this$intersects, Set<? extends Object> set) {
        int it;
        int i$iv$iv$iv;
        int cmp;
        int bitCount$iv$iv$iv;
        Object obj3;
        int i5;
        int j$iv$iv$iv;
        long value$iv$iv$iv$iv;
        int i4;
        int i3;
        long slot$iv$iv$iv;
        long cmp2;
        int i7;
        int i;
        int this_$iv;
        int i2;
        int i6;
        it = $this$intersects;
        final int i8 = 0;
        final Object obj = it;
        final int i9 = 0;
        final int i10 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i11) {
        } else {
            obj3 = set;
            this_$iv = it;
            bitCount$iv$iv$iv = 0;
        }
        return bitCount$iv$iv$iv;
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> block) {
        SnapshotStateKt__SnapshotFlowKt.snapshotFlow.1 anon = new SnapshotStateKt__SnapshotFlowKt.snapshotFlow.1(block, 0);
        return FlowKt.flow((Function2)anon);
    }
}
