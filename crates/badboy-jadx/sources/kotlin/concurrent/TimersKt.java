package kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001aM\u0010\u0000\u001a\u00020\u00012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001aO\u0010\u0000\u001a\u00020\u00012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001a\u001a\u0010\u0010\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001aM\u0010\u0010\u001a\u00020\u00012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001aO\u0010\u0010\u001a\u00020\u00012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001a'\u0010\u0011\u001a\u00020\u000c2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001a3\u0010\u0012\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001a;\u0010\u0012\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u001a;\u0010\u0015\u001a\u00020\u000c*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0087\u0008ø\u0001\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0016", d2 = {"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TimersKt {
    private static final Timer fixedRateTimer(String name, boolean daemon, long initialDelay, long period, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(obj13, "action");
        final Timer timer = TimersKt.timer(name, daemon);
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj13);
        timer.scheduleAtFixedRate((TimerTask)anon, initialDelay, obj4);
        return timer;
    }

    private static final Timer fixedRateTimer(String name, boolean daemon, Date startAt, long period, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(obj7, "action");
        Timer timer = TimersKt.timer(name, daemon);
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj7);
        timer.scheduleAtFixedRate((TimerTask)anon, startAt, period);
        return timer;
    }

    static Timer fixedRateTimer$default(String name, boolean daemon, long initialDelay, long period, Function1 action, int i6, Object object7) {
        int obj6;
        int obj7;
        int obj8;
        if (obj13 & 1 != 0) {
            obj6 = 0;
        }
        if (obj13 & 2 != 0) {
            obj7 = 0;
        }
        if (obj13 &= 4 != 0) {
            obj8 = 0;
        }
        Intrinsics.checkNotNullParameter(object7, "action");
        final Timer timer = TimersKt.timer(obj6, obj7);
        obj8 = new TimersKt.timerTask.1(object7);
        timer.scheduleAtFixedRate((TimerTask)obj8, obj8, obj3);
        return timer;
    }

    static Timer fixedRateTimer$default(String name, boolean daemon, Date startAt, long period, Function1 action, int i6, Object object7) {
        int obj0;
        int obj1;
        if (object7 & 1 != 0) {
            obj0 = 0;
        }
        if (object7 &= 2 != 0) {
            obj1 = 0;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(i6, "action");
        Timer obj6 = TimersKt.timer(obj0, obj1);
        TimersKt.timerTask.1 obj7 = new TimersKt.timerTask.1(i6);
        obj6.scheduleAtFixedRate((TimerTask)obj7, startAt, period);
        return obj6;
    }

    private static final TimerTask schedule(Timer $this$schedule, long delay, long period, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(obj12, "action");
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj12);
        final kotlin.concurrent.TimersKt.timerTask.1 time = anon;
        $this$schedule.schedule((TimerTask)time, delay, obj4);
        return time;
    }

    private static final TimerTask schedule(Timer $this$schedule, long delay, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(obj4, "action");
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj4);
        $this$schedule.schedule((TimerTask)anon, delay);
        return anon;
    }

    private static final TimerTask schedule(Timer $this$schedule, Date time, long period, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(obj5, "action");
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj5);
        $this$schedule.schedule((TimerTask)anon, time, period);
        return anon;
    }

    private static final TimerTask schedule(Timer $this$schedule, Date time, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(action, "action");
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(action);
        $this$schedule.schedule((TimerTask)anon, time);
        return anon;
    }

    private static final TimerTask scheduleAtFixedRate(Timer $this$scheduleAtFixedRate, long delay, long period, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter($this$scheduleAtFixedRate, "<this>");
        Intrinsics.checkNotNullParameter(obj12, "action");
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj12);
        final kotlin.concurrent.TimersKt.timerTask.1 time = anon;
        $this$scheduleAtFixedRate.scheduleAtFixedRate((TimerTask)time, delay, obj4);
        return time;
    }

    private static final TimerTask scheduleAtFixedRate(Timer $this$scheduleAtFixedRate, Date time, long period, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter($this$scheduleAtFixedRate, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(obj5, "action");
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj5);
        $this$scheduleAtFixedRate.scheduleAtFixedRate((TimerTask)anon, time, period);
        return anon;
    }

    public static final Timer timer(String name, boolean daemon) {
        if (name == null) {
            Timer timer = new Timer(daemon);
        } else {
            super(name, daemon);
        }
        return timer;
    }

    private static final Timer timer(String name, boolean daemon, long initialDelay, long period, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(obj13, "action");
        final Timer timer = TimersKt.timer(name, daemon);
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj13);
        timer.schedule((TimerTask)anon, initialDelay, obj4);
        return timer;
    }

    private static final Timer timer(String name, boolean daemon, Date startAt, long period, Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(obj7, "action");
        Timer timer = TimersKt.timer(name, daemon);
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(obj7);
        timer.schedule((TimerTask)anon, startAt, period);
        return timer;
    }

    static Timer timer$default(String name, boolean daemon, long initialDelay, long period, Function1 action, int i6, Object object7) {
        int obj6;
        int obj7;
        int obj8;
        if (obj13 & 1 != 0) {
            obj6 = 0;
        }
        if (obj13 & 2 != 0) {
            obj7 = 0;
        }
        if (obj13 &= 4 != 0) {
            obj8 = 0;
        }
        Intrinsics.checkNotNullParameter(object7, "action");
        final Timer timer = TimersKt.timer(obj6, obj7);
        obj8 = new TimersKt.timerTask.1(object7);
        timer.schedule((TimerTask)obj8, obj8, obj3);
        return timer;
    }

    static Timer timer$default(String name, boolean daemon, Date startAt, long period, Function1 action, int i6, Object object7) {
        int obj0;
        int obj1;
        if (object7 & 1 != 0) {
            obj0 = 0;
        }
        if (object7 &= 2 != 0) {
            obj1 = 0;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(i6, "action");
        Timer obj6 = TimersKt.timer(obj0, obj1);
        TimersKt.timerTask.1 obj7 = new TimersKt.timerTask.1(i6);
        obj6.schedule((TimerTask)obj7, startAt, period);
        return obj6;
    }

    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        TimersKt.timerTask.1 anon = new TimersKt.timerTask.1(action);
        return (TimerTask)anon;
    }
}
