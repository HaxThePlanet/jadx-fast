package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0013\u0008&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\u0008\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u000c\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0006\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\tR\"\u0010\u0017\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u0004\"\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u001e\u0010\r¨\u0006!", d2 = {"Lokhttp3/internal/concurrent/Task;", "", "", "runOnce", "()J", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "Lkotlin/w;", "initQueue$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "initQueue", "", "toString", "()Ljava/lang/String;", "", "cancelable", "Z", "getCancelable", "()Z", "Lokhttp3/internal/concurrent/TaskQueue;", "getQueue$okhttp", "()Lokhttp3/internal/concurrent/TaskQueue;", "setQueue$okhttp", "nextExecuteNanoTime", "J", "getNextExecuteNanoTime$okhttp", "setNextExecuteNanoTime$okhttp", "(J)V", "name", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class Task {

    private final boolean cancelable;
    private final String name;
    private long nextExecuteNanoTime;
    private okhttp3.internal.concurrent.TaskQueue queue;
    public Task(String string, boolean z2) {
        n.f(string, "name");
        super();
        this.name = string;
        this.cancelable = z2;
        this.nextExecuteNanoTime = -1;
    }

    public Task(String string, boolean z2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 1 : obj2;
        super(string, obj2);
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    public final okhttp3.internal.concurrent.TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(okhttp3.internal.concurrent.TaskQueue taskQueue) {
        int i;
        n.f(taskQueue, "queue");
        okhttp3.internal.concurrent.TaskQueue queue = this.queue;
        if (queue == taskQueue) {
        }
        i = queue == null ? 1 : 0;
        if (i == 0) {
        } else {
            this.queue = taskQueue;
        }
        IllegalStateException obj2 = new IllegalStateException("task is in multiple queues".toString());
        throw obj2;
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long l) {
        this.nextExecuteNanoTime = l;
    }

    public final void setQueue$okhttp(okhttp3.internal.concurrent.TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    public String toString() {
        return this.name;
    }
}
