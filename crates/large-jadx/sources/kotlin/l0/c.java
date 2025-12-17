package kotlin.l0;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000c\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0003ø\u0001\u0000¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\u0008\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\u0008\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00082\u0006\u0010?\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008@\u0010A\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008B\u0010C\u001a \u0010D\u001a\u00020\u0007*\u00020\u00082\n\u0010E\u001a\u00060Fj\u0002`GH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a \u0010D\u001a\u00020\u0007*\u00020\u00052\n\u0010E\u001a\u00060Fj\u0002`GH\u0007ø\u0001\u0000¢\u0006\u0002\u0010I\u001a \u0010D\u001a\u00020\u0007*\u00020\u00012\n\u0010E\u001a\u00060Fj\u0002`GH\u0007ø\u0001\u0000¢\u0006\u0002\u0010J\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000c\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\t\u0010\r\u001a\u0004\u0008\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u000f\u001a\u0004\u0008\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\n\u001a\u0004\u0008\u0013\u0010\u000c\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\r\u001a\u0004\u0008\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\u000f\u001a\u0004\u0008\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\n\u001a\u0004\u0008\u0016\u0010\u000c\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\r\u001a\u0004\u0008\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\u000f\u001a\u0004\u0008\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\n\u001a\u0004\u0008\u0019\u0010\u000c\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\r\u001a\u0004\u0008\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\u000f\u001a\u0004\u0008\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\n\u001a\u0004\u0008\u001c\u0010\u000c\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\r\u001a\u0004\u0008\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\u000f\u001a\u0004\u0008\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001e\u0010\n\u001a\u0004\u0008\u001f\u0010\u000c\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001e\u0010\r\u001a\u0004\u0008\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008\u001e\u0010\u000f\u001a\u0004\u0008\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008!\u0010\n\u001a\u0004\u0008\"\u0010\u000c\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008!\u0010\r\u001a\u0004\u0008\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008!\u0010\u000f\u001a\u0004\u0008\"\u0010\u0010\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006K", d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(DLjava/util/concurrent/TimeUnit;)J", "(ILjava/util/concurrent/TimeUnit;)J", "(JLjava/util/concurrent/TimeUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class c {
    public static final long a(long l, int i2) {
        return c.h(l, i2);
    }

    public static final long b(long l) {
        return c.i(l);
    }

    public static final long c(long l) {
        return c.j(l);
    }

    public static final long d(long l) {
        return c.k(l);
    }

    public static final long e(long l) {
        return c.l(l);
    }

    public static final long f(long l) {
        return c.m(l);
    }

    public static final long g(long l) {
        return c.n(l);
    }

    private static final long h(long l, int i2) {
        obj2 += l2;
        b.f(obj2);
        return obj2;
    }

    private static final long i(long l) {
        obj2 += i2;
        b.f(obj2);
        return obj2;
    }

    private static final long j(long l) {
        long cmp;
        long l2;
        long l3;
        long obj6;
        if (Long.compare(l4, l) > 0) {
            obj6 = c.i(g.h(l, obj1, -4611686018427387903L));
        } else {
            if (Long.compare(l5, l) >= 0) {
                obj6 = c.k(c.m(l));
            } else {
            }
        }
        return obj6;
    }

    private static final long k(long l) {
        l <<= i;
        b.f(obj1);
        return obj1;
    }

    private static final long l(long l) {
        int cmp;
        long obj2;
        if (Long.compare(l2, l) > 0) {
            obj2 = c.i(c.n(l));
        } else {
            if (Long.compare(l3, l) >= 0) {
                obj2 = c.k(l);
            } else {
            }
        }
        return obj2;
    }

    private static final long m(long l) {
        return l *= l2;
    }

    private static final long n(long l) {
        return l /= l2;
    }

    public static final long o(long l, TimeUnit timeUnit2) {
        long cmp;
        n.f(obj9, "unit");
        TimeUnit nANOSECONDS = TimeUnit.NANOSECONDS;
        cmp = d.c(4611686018426999999L, obj2, nANOSECONDS);
        if (Long.compare(i, l) > 0) {
        } else {
            if (Long.compare(cmp, l) >= 0) {
                return c.k(d.c(l, timeUnit2, obj9));
            }
        }
        return c.i(g.h(d.b(l, timeUnit2, obj9), obj2, -4611686018427387903L));
    }
}
