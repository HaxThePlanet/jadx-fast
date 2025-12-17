package zendesk.messaging;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
class ObservableCounter {

    private final AtomicInteger counter;
    private final zendesk.messaging.ObservableCounter.OnCountCompletedListener onCountCompletedListener;

    interface OnCountCompletedListener {
        public abstract void onCountCompleted();
    }
    ObservableCounter(zendesk.messaging.ObservableCounter.OnCountCompletedListener observableCounter$OnCountCompletedListener) {
        super();
        AtomicInteger atomicInteger = new AtomicInteger();
        this.counter = atomicInteger;
        this.onCountCompletedListener = onCountCompletedListener;
    }

    void decrement() {
        int onCountCompletedListener;
        if (this.counter.decrementAndGet() == 0) {
            this.onCountCompletedListener.onCountCompleted();
        }
    }

    void increment(int i) {
        this.counter.addAndGet(i);
    }
}
