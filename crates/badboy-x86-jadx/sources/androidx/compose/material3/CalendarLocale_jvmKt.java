package androidx.compose.material3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0002\u001a*\u0010\n\u001a\u00020\u0002*\u00020\u00062\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\n\u0010\u000b\"\u00020\u000c2\u00020\u000c¨\u0006\r", d2 = {"cachedFormatters", "Ljava/util/WeakHashMap;", "", "Ljava/text/NumberFormat;", "getCachedDateTimeFormatter", "minDigits", "", "maxDigits", "isGroupingUsed", "", "toLocalString", "CalendarLocale", "Ljava/util/Locale;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CalendarLocale_jvmKt {

    private static final WeakHashMap<String, NumberFormat> cachedFormatters;
    static {
        WeakHashMap weakHashMap = new WeakHashMap();
        CalendarLocale_jvmKt.cachedFormatters = weakHashMap;
    }

    private static final NumberFormat getCachedDateTimeFormatter(int minDigits, int maxDigits, boolean isGroupingUsed) {
        int i;
        Object integerInstance;
        NumberFormat num;
        int i2;
        StringBuilder stringBuilder = new StringBuilder();
        int i3 = 46;
        String string = stringBuilder.append(minDigits).append(i3).append(maxDigits).append(i3).append(isGroupingUsed).append(i3).append(Locale.getDefault().toLanguageTag()).toString();
        WeakHashMap cachedFormatters = CalendarLocale_jvmKt.cachedFormatters;
        final int i4 = 0;
        final Object obj = (Map)cachedFormatters.get(string);
        if (obj == null) {
            i = 0;
            integerInstance = NumberFormat.getIntegerInstance();
            num = integerInstance;
            i2 = 0;
            num.setGroupingUsed(isGroupingUsed);
            num.setMinimumIntegerDigits(minDigits);
            num.setMaximumIntegerDigits(maxDigits);
            cachedFormatters.put(string, integerInstance);
        } else {
            integerInstance = obj;
        }
        return (NumberFormat)integerInstance;
    }

    public static final String toLocalString(int $this$toLocalString, int minDigits, int maxDigits, boolean isGroupingUsed) {
        return CalendarLocale_jvmKt.getCachedDateTimeFormatter(minDigits, maxDigits, isGroupingUsed).format(Integer.valueOf($this$toLocalString));
    }

    public static String toLocalString$default(int i, int i2, int i3, boolean z4, int i5, Object object6) {
        int obj1;
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = 1;
        }
        if (i5 & 2 != 0) {
            obj2 = 40;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        return CalendarLocale_jvmKt.toLocalString(i, obj1, obj2, obj3);
    }
}
