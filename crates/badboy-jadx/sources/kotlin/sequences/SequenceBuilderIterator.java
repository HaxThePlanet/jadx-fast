package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u0008\u0012\u0004\u0012\u00020\u00050\u0004B\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0096\u0002J\u000e\u0010\u001a\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001d\u001a\u00020\u00052\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u001fH\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010#J\u001c\u0010$\u001a\u00020\u00052\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@¢\u0006\u0002\u0010&R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0012\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "nextIterator", "nextStep", "getNextStep", "()Lkotlin/coroutines/Continuation;", "setNextStep", "(Lkotlin/coroutines/Continuation;)V", "nextValue", "Ljava/lang/Object;", "state", "", "Lkotlin/sequences/State;", "exceptionalState", "", "hasNext", "", "next", "()Ljava/lang/Object;", "nextNotReady", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "yield", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yieldAll", "iterator", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SequenceBuilderIterator<T>  extends kotlin.sequences.SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {

    private Iterator<? extends T> nextIterator;
    private Continuation<? super Unit> nextStep;
    private T nextValue;
    private int state;
    private final Throwable exceptionalState() {
        Object noSuchElementException;
        String string;
        int state;
        switch (state2) {
            case 4:
                noSuchElementException = new NoSuchElementException();
                break;
            case 5:
                noSuchElementException = new IllegalStateException("Iterator has failed.");
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                noSuchElementException = new IllegalStateException(stringBuilder.append("Unexpected state of the iterator: ").append(this.state).toString());
        }
        return noSuchElementException;
    }

    private final T nextNotReady() {
        if (!hasNext()) {
        } else {
            return next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // kotlin.sequences.SequenceScope
    public CoroutineContext getContext() {
        return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
    }

    public final Continuation<Unit> getNextStep() {
        return this.nextStep;
    }

    @Override // kotlin.sequences.SequenceScope
    public boolean hasNext() {
        Class<byte> nextStep;
        Object constructor-impl;
        int i;
        while (/* condition */) {
            Iterator nextIterator = this.nextIterator;
            Intrinsics.checkNotNull(nextIterator);
            this.nextIterator = i5;
            this.state = 5;
            nextStep = this.nextStep;
            Intrinsics.checkNotNull(nextStep);
            this.nextStep = i5;
            kotlin.Result.Companion companion = Result.Companion;
            nextStep.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            int i5 = 0;
            i = 1;
        }
        return i;
    }

    public T next() {
        switch (state) {
            case 0:
                return nextNotReady();
            case 1:
                this.state = 1;
                Iterator nextIterator = this.nextIterator;
                Intrinsics.checkNotNull(nextIterator);
                return nextIterator.next();
            case 2:
                this.state = 0;
                this.nextValue = 0;
                return this.nextValue;
            default:
                throw exceptionalState();
        }
    }

    @Override // kotlin.sequences.SequenceScope
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // kotlin.sequences.SequenceScope
    public void resumeWith(Object result) {
        ResultKt.throwOnFailure(result);
        this.state = 4;
    }

    public final void setNextStep(Continuation<? super Unit> <set-?>) {
        this.nextStep = <set-?>;
    }

    public Object yield(T value, Continuation<? super Unit> $completion) {
        this.nextValue = value;
        this.state = 3;
        int i2 = 0;
        this.nextStep = $completion;
        Object c = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (c == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (c == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return c;
        }
        return Unit.INSTANCE;
    }

    public Object yieldAll(Iterator<? extends T> iterator, Continuation<? super Unit> $completion) {
        if (!iterator.hasNext()) {
            return Unit.INSTANCE;
        }
        this.nextIterator = iterator;
        this.state = 2;
        int i2 = 0;
        this.nextStep = $completion;
        Object c = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (c == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (c == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return c;
        }
        return Unit.INSTANCE;
    }
}
