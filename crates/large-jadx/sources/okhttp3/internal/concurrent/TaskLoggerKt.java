package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.f0;
import kotlin.d0.d.l;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\u0004\u001a1\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001a7\u0010\u000c\u001a\u00028\u0000\"\u0004\u0008\u0000\u0010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004H\u0080\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u001a'\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0015", d2 = {"Lokhttp3/internal/concurrent/Task;", "task", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "Lkotlin/Function0;", "", "messageBlock", "Lkotlin/w;", "taskLog", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/d0/c/a;)V", "T", "block", "logElapsed", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/d0/c/a;)Ljava/lang/Object;", "message", "log", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Ljava/lang/String;)V", "", "ns", "formatDuration", "(J)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class TaskLoggerKt {
    public static final void access$log(okhttp3.internal.concurrent.Task task, okhttp3.internal.concurrent.TaskQueue taskQueue2, String string3) {
        TaskLoggerKt.log(task, taskQueue2, string3);
    }

    public static final String formatDuration(long l) {
        StringBuilder stringBuilder;
        long str;
        int i6;
        int i4;
        String str2;
        int i2;
        int i3;
        String str3;
        int i5;
        int i;
        long l2;
        String obj12;
        str = " s ";
        i6 = 1000000000;
        i4 = 500000000;
        if (Long.compare(l, l3) <= 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj12 /= i6);
            stringBuilder.append(str);
            obj12 = stringBuilder.toString();
        } else {
            str2 = " ms";
            i2 = 1000000;
            i3 = 500000;
            if (Long.compare(l, l8) <= 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(obj12 /= str);
                stringBuilder.append(str2);
                obj12 = stringBuilder.toString();
            } else {
                str3 = " µs";
                i5 = 1000;
                i = 500;
                if (Long.compare(l, i12) <= 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(obj12 /= str);
                    stringBuilder.append(str3);
                    obj12 = stringBuilder.toString();
                } else {
                    if (Long.compare(l, l2) < 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(obj12 /= str);
                        stringBuilder.append(str3);
                        obj12 = stringBuilder.toString();
                    } else {
                        if (Long.compare(l, str3) < 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(obj12 /= str);
                            stringBuilder.append(str2);
                            obj12 = stringBuilder.toString();
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(obj12 /= i6);
                            stringBuilder.append(str);
                            obj12 = stringBuilder.toString();
                        }
                    }
                }
            }
        }
        f0 obj13 = f0.a;
        obj13 = 1;
        Object[] arr = new Object[obj13];
        arr[0] = obj12;
        obj12 = String.format("%6s", Arrays.copyOf(arr, obj13));
        n.e(obj12, "java.lang.String.format(format, *args)");
        return obj12;
    }

    private static final void log(okhttp3.internal.concurrent.Task task, okhttp3.internal.concurrent.TaskQueue taskQueue2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(taskQueue2.getName$okhttp());
        stringBuilder.append(' ');
        f0 obj5 = f0.a;
        obj5 = 1;
        final Object[] arr = new Object[obj5];
        arr[0] = string3;
        obj5 = String.format("%-22s", Arrays.copyOf(arr, obj5));
        n.e(obj5, "java.lang.String.format(format, *args)");
        stringBuilder.append(obj5);
        stringBuilder.append(": ");
        stringBuilder.append(task.getName());
        TaskRunner.Companion.getLogger().fine(stringBuilder.toString());
    }

    public static final <T> T logElapsed(okhttp3.internal.concurrent.Task task, okhttp3.internal.concurrent.TaskQueue taskQueue2, a<? extends T> a3) {
        boolean loggable;
        long formatDuration;
        long formatDuration2;
        String str;
        long l;
        n.f(task, "task");
        n.f(taskQueue2, "queue");
        n.f(a3, "block");
        loggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (loggable) {
            formatDuration2 = taskQueue2.getTaskRunner$okhttp().getBackend().nanoTime();
            TaskLoggerKt.access$log(task, taskQueue2, "starting");
        } else {
            formatDuration2 = -1;
        }
        int i = 1;
        l.b(i);
        if (loggable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("finished run in ");
            stringBuilder.append(TaskLoggerKt.formatDuration(nanoTime -= formatDuration2));
            TaskLoggerKt.access$log(task, taskQueue2, stringBuilder.toString());
        }
        l.a(i);
        return a3.invoke();
    }

    public static final void taskLog(okhttp3.internal.concurrent.Task task, okhttp3.internal.concurrent.TaskQueue taskQueue2, a<String> a3) {
        Object obj4;
        n.f(task, "task");
        n.f(taskQueue2, "queue");
        n.f(a3, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            TaskLoggerKt.access$log(task, taskQueue2, (String)a3.invoke());
        }
    }
}
