package zendesk.support.request;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import o.b.a;
import o.b.e;
import o.b.f;
import o.b.j;
import o.b.m;

/* loaded from: classes3.dex */
class AsyncMiddleware implements m {

    private static final String ACTION_TYPE = "async_action";
    private static final String LOG_TAG = "AsyncMiddleware";
    private final zendesk.support.request.AsyncMiddleware.Queue queue;

    interface AsyncAction {
        public abstract void actionQueued(f f, j j2);

        public abstract void execute(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3);
    }

    interface Callback {
        public abstract void done();
    }

    interface Item {
        public abstract void execute(zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback);
    }

    static class Queue {

        private final zendesk.support.request.AsyncMiddleware.Callback dispatchCallback;
        private final AtomicBoolean isRunning;
        private final Queue<zendesk.support.request.AsyncMiddleware.Item> items;
        Queue() {
            super();
            LinkedList linkedList = new LinkedList();
            this.items = linkedList;
            AtomicBoolean atomicBoolean = new AtomicBoolean(0);
            this.isRunning = atomicBoolean;
            AsyncMiddleware.Queue.QueueCallback queueCallback = new AsyncMiddleware.Queue.QueueCallback(this, 0);
            this.dispatchCallback = queueCallback;
        }

        Queue(LinkedList<zendesk.support.request.AsyncMiddleware.Item> linkedList) {
            super();
            this.items = linkedList;
            AtomicBoolean obj2 = new AtomicBoolean(0);
            this.isRunning = obj2;
            obj2 = new AsyncMiddleware.Queue.QueueCallback(this, 0);
            this.dispatchCallback = obj2;
        }

        static Queue access$200(zendesk.support.request.AsyncMiddleware.Queue asyncMiddleware$Queue) {
            return queue.items;
        }

        static void access$300(zendesk.support.request.AsyncMiddleware.Queue asyncMiddleware$Queue) {
            queue.dispatchInternal();
        }

        private void dispatchInternal() {
            Object dispatchCallback;
            Object peek;
            int i;
            dispatchCallback = this.items;
            synchronized (dispatchCallback) {
                peek = this.items.peek();
                try {
                    if (peek != null) {
                    }
                    peek.execute(this.dispatchCallback);
                    throw th;
                }
            }
        }

        void dispatch(zendesk.support.request.AsyncMiddleware.Item asyncMiddleware$Item) {
            if (item == null) {
            }
            Queue items = this.items;
            this.items.add(item);
            synchronized (items) {
                items = this.items;
                this.items.add(item);
            }
            dispatchInternal();
        }

        boolean isRunning() {
            return this.isRunning.get();
        }
    }

    private static class QueueItem implements zendesk.support.request.AsyncMiddleware.Item {

        private final zendesk.support.request.AsyncMiddleware.AsyncAction asyncAction;
        private final f dispatcher;
        private final j getState;
        private QueueItem(zendesk.support.request.AsyncMiddleware.AsyncAction asyncMiddleware$AsyncAction, j j2, f f3) {
            super();
            this.asyncAction = asyncAction;
            this.getState = j2;
            this.dispatcher = f3;
        }

        QueueItem(zendesk.support.request.AsyncMiddleware.AsyncAction asyncMiddleware$AsyncAction, j j2, f f3, zendesk.support.request.AsyncMiddleware.1 asyncMiddleware$14) {
            super(asyncAction, j2, f3);
        }

        @Override // zendesk.support.request.AsyncMiddleware$Item
        public void execute(zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback) {
            this.asyncAction.execute(this.dispatcher, this.getState, callback);
        }
    }
    AsyncMiddleware(zendesk.support.request.AsyncMiddleware.Queue asyncMiddleware$Queue) {
        super();
        this.queue = queue;
    }

    static a createAction(zendesk.support.request.AsyncMiddleware.AsyncAction asyncMiddleware$AsyncAction) {
        a aVar = new a("async_action", asyncAction);
        return aVar;
    }

    public void onAction(a<?> a, j j2, f f3, e e4) {
        int i;
        Object obj3;
        zendesk.support.request.AsyncMiddleware.QueueItem obj6;
        Object data = a.getData(AsyncMiddleware.AsyncAction.class);
        if ((AsyncMiddleware.AsyncAction)data != null) {
            (AsyncMiddleware.AsyncAction)data.actionQueued(f3, j2);
            obj6 = new AsyncMiddleware.QueueItem(data, j2, f3, 0);
            this.queue.dispatch(obj6);
        } else {
            e4.a(a);
        }
    }
}
