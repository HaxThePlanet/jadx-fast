package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0008\u001a3\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\tH\u0087\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002\u001a2\u0010\n\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\rH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aK\u0010\u000f\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u0010\"\u0004\u0008\u0001\u0010\u000b2\u0006\u0010\u0011\u001a\u0002H\u00102\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\t¢\u0006\u0002\u0008\u0012H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0013\u001a<\u0010\u0014\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00050\tH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aA\u0010\u0015\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0010*\u0002H\u00102\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0008\u0012H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aB\u0010\u0016\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u0010\"\u0004\u0008\u0001\u0010\u000b*\u0002H\u00102\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\tH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aG\u0010\n\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u0010\"\u0004\u0008\u0001\u0010\u000b*\u0002H\u00102\u0017\u0010\u000c\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\t¢\u0006\u0002\u0008\u0012H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001a>\u0010\u0017\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00190\tH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001a>\u0010\u001a\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00190\tH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u001b", d2 = {"TODO", "", "reason", "", "repeat", "", "times", "", "action", "Lkotlin/Function1;", "run", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "with", "T", "receiver", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "also", "apply", "let", "takeIf", "predicate", "", "takeUnless", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/StandardKt")
class StandardKt__StandardKt {
    private static final Void TODO() {
        final int i = 0;
        NotImplementedError notImplementedError = new NotImplementedError(i, 1, i);
        throw notImplementedError;
    }

    private static final Void TODO(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        StringBuilder stringBuilder = new StringBuilder();
        NotImplementedError notImplementedError = new NotImplementedError(stringBuilder.append("An operation is not implemented: ").append(reason).toString());
        throw notImplementedError;
    }

    private static final <T> T also(T $this$also, Function1<? super T, kotlin.Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke($this$also);
        return $this$also;
    }

    private static final <T> T apply(T $this$apply, Function1<? super T, kotlin.Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke($this$apply);
        return $this$apply;
    }

    private static final <T, R> R let(T $this$let, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke($this$let);
    }

    private static final void repeat(int times, Function1<? super Integer, kotlin.Unit> action) {
        int index;
        Integer valueOf;
        Intrinsics.checkNotNullParameter(action, "action");
        index = 0;
        while (index < times) {
            action.invoke(Integer.valueOf(index));
            index++;
        }
    }

    private static final <T, R> R run(T $this$run, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke($this$run);
    }

    private static final <R> R run(Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke();
    }

    private static final <T> T takeIf(T $this$takeIf, Function1<? super T, Boolean> predicate) {
        Object obj;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        obj = (Boolean)predicate.invoke($this$takeIf).booleanValue() ? $this$takeIf : 0;
        return obj;
    }

    private static final <T> T takeUnless(T $this$takeUnless, Function1<? super T, Boolean> predicate) {
        Object obj;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        obj = !(Boolean)predicate.invoke($this$takeUnless).booleanValue() ? $this$takeUnless : 0;
        return obj;
    }

    private static final <T, R> R with(T receiver, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(receiver);
    }
}
