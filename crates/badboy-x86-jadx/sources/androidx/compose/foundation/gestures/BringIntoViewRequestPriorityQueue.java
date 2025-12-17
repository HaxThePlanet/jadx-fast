package androidx.compose.foundation.gestures;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CancellableContinuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J9\u0010\u0011\u001a\u00020\u000b2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u000b0\u0013H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u000bJ9\u0010\u001a\u001a\u00020\u000b2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u000f0\u0013H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "", "()V", "requests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/gestures/ContentInViewNode$Request;", "size", "", "getSize", "()I", "cancelAndRemoveAll", "", "cause", "", "enqueue", "", "request", "forEachFromSmallest", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "bounds", "isEmpty", "resumeAndRemoveAll", "resumeAndRemoveWhile", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BringIntoViewRequestPriorityQueue {

    public static final int $stable;
    private final MutableVector<androidx.compose.foundation.gestures.ContentInViewNode.Request> requests;
    static {
        BringIntoViewRequestPriorityQueue.$stable = MutableVector.$stable;
    }

    public BringIntoViewRequestPriorityQueue() {
        super();
        final int i = 0;
        final int i3 = 0;
        MutableVector mutableVector = new MutableVector(new ContentInViewNode.Request[16], 0);
        this.requests = mutableVector;
    }

    public static final MutableVector access$getRequests$p(androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue $this) {
        return $this.requests;
    }

    public final void cancelAndRemoveAll(Throwable cause) {
        int size;
        int i3;
        int i;
        CancellableContinuation it;
        int i2;
        Object[] content;
        MutableVector requests = this.requests;
        int i6 = 0;
        size = requests.getSize();
        final CancellableContinuation[] arr = new CancellableContinuation[size];
        i = i3;
        while (i < size) {
            int i7 = 0;
            i2 = 0;
            arr[i] = (ContentInViewNode.Request)requests.getContent()[i].getContinuation();
            i++;
        }
        int i4 = 0;
        while (i3 < arr.length) {
            it = 0;
            arr[i3].cancel(cause);
            i3++;
        }
        if (!this.requests.isEmpty()) {
        } else {
        }
        int i5 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("uncancelled requests present".toString());
        throw illegalStateException;
    }

    public final boolean enqueue(androidx.compose.foundation.gestures.ContentInViewNode.Request request) {
        int i;
        IntRange this_$iv;
        int invoke;
        Rect intersect;
        boolean cancellationException;
        int j;
        CancellableContinuation continuation;
        CancellationException exc;
        Object[] content;
        Object invoke2 = request.getCurrentBounds().invoke();
        int i2 = 0;
        if ((Rect)invoke2 == null) {
            androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue queue = this;
            int i4 = 0;
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)request.getContinuation().resumeWith(Result.constructor-impl(Unit.INSTANCE));
            return i2;
        }
        BringIntoViewRequestPriorityQueue.enqueue.1 anon = new BringIntoViewRequestPriorityQueue.enqueue.1(this, request);
        request.getContinuation().invokeOnCancellation((Function1)anon);
        int i5 = 0;
        final int i7 = 1;
        this_$iv = new IntRange(i2, size -= i7);
        int first = this_$iv.getFirst();
        if (first <= this_$iv.getLast()) {
        }
        this.requests.add(i2, request);
        return i7;
    }

    public final void forEachFromSmallest(Function1<? super Rect, Unit> block) {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        Object invoke;
        final int i2 = 0;
        final MutableVector mutableVector = BringIntoViewRequestPriorityQueue.access$getRequests$p(this);
        final int i3 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv = size + -1;
            i = 0;
            block.invoke((ContentInViewNode.Request)mutableVector.getContent()[i$iv].getCurrentBounds().invoke());
            while (i$iv-- < 0) {
                i = 0;
                block.invoke((ContentInViewNode.Request)content[i$iv].getCurrentBounds().invoke());
            }
        }
    }

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        return this.requests.isEmpty();
    }

    public final void resumeAndRemoveAll() {
        int i;
        IntRange intRange;
        int constructor-impl;
        int companion;
        int i3 = 0;
        intRange = new IntRange(0, size--);
        int last = intRange.getLast();
        if (intRange.getFirst() <= last) {
        }
        this.requests.clear();
    }

    public final void resumeAndRemoveWhile(Function1<? super Rect, Boolean> block) {
        CancellableContinuation continuation;
        Object constructor-impl;
        kotlin.Result.Companion companion;
        int i;
        final int i2 = 0;
        while (BringIntoViewRequestPriorityQueue.access$getRequests$p(this).isNotEmpty()) {
            int i3 = 0;
            companion = Result.Companion;
            (Continuation)(ContentInViewNode.Request)BringIntoViewRequestPriorityQueue.access$getRequests$p(this).removeAt(size--).getContinuation().resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }
}
