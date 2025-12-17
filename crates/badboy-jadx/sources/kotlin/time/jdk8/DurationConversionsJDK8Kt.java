package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\u0008¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0007", d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, pn = "kotlin.time", xi = 48)
public final class DurationConversionsJDK8Kt {
    private static final Duration toJavaDuration-LRDsOJo(long $this$toJavaDuration_u2dLRDsOJo) {
        int i = 0;
        final int i2 = 0;
        Duration seconds = Duration.ofSeconds(Duration.getInWholeSeconds-impl($this$toJavaDuration_u2dLRDsOJo), obj2);
        Intrinsics.checkNotNullExpressionValue(seconds, "toComponents-impl(...)");
        return seconds;
    }

    private static final long toKotlinDuration(Duration $this$toKotlinDuration) {
        Intrinsics.checkNotNullParameter($this$toKotlinDuration, "<this>");
        final DurationUnit nANOSECONDS = DurationUnit.NANOSECONDS;
        return Duration.plus-LRDsOJo(DurationKt.toDuration($this$toKotlinDuration.getSeconds(), obj1), obj1);
    }
}
