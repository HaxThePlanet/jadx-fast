package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\u001a\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008¨\u0006\u0010", d2 = {"durationAssertionsEnabled", "", "getDurationAssertionsEnabled", "()Z", "precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "createFormatForDecimals", "decimals", "", "formatToExactDecimals", "", "value", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DurationJvmKt {

    private static final boolean durationAssertionsEnabled = false;
    private static final java.lang.ThreadLocal<DecimalFormat>[] precisionFormats;
    static {
        int i;
        java.lang.ThreadLocal threadLocal;
        Class<kotlin.time.Duration> obj = Duration.class;
        i = 0;
        final int i2 = 4;
        final java.lang.ThreadLocal[] arr = new ThreadLocal[i2];
        while (i < i2) {
            threadLocal = new ThreadLocal();
            arr[i] = threadLocal;
            i++;
        }
        DurationJvmKt.precisionFormats = arr;
    }

    private static final DecimalFormat createFormatForDecimals(int decimals) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        DecimalFormat decimalFormat2 = decimalFormat;
        final int i = 0;
        if (decimals > 0) {
            decimalFormat2.setMinimumFractionDigits(decimals);
        }
        decimalFormat2.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    public static final String formatToExactDecimals(double value, int decimals) {
        int length;
        Object $i$a$GetOrSetDurationJvmKt$formatToExactDecimals$format$1;
        if (obj5 < precisionFormats.length) {
            length = DurationJvmKt.precisionFormats[obj5];
            $i$a$GetOrSetDurationJvmKt$formatToExactDecimals$format$1 = length.get();
            if ($i$a$GetOrSetDurationJvmKt$formatToExactDecimals$format$1 == null) {
                int i = 0;
                length.set(DurationJvmKt.createFormatForDecimals(obj5));
            } else {
                Intrinsics.checkNotNull($i$a$GetOrSetDurationJvmKt$formatToExactDecimals$format$1);
            }
        } else {
            $i$a$GetOrSetDurationJvmKt$formatToExactDecimals$format$1 = DurationJvmKt.createFormatForDecimals(obj5);
        }
        String format = $i$a$GetOrSetDurationJvmKt$formatToExactDecimals$format$1.format(value);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final boolean getDurationAssertionsEnabled() {
        return DurationJvmKt.durationAssertionsEnabled;
    }
}
