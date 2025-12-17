package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000+\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\t\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0008\"\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\n\u0010\u000b\"\u001c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u000e\"\u001e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011¨\u0006\u0012", d2 = {"", "Ljava/util/Date;", "toHttpDateOrNull", "(Ljava/lang/String;)Ljava/util/Date;", "toHttpDateString", "(Ljava/util/Date;)Ljava/lang/String;", "", "MAX_DATE", "J", "okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "STANDARD_DATE_FORMAT", "Lokhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1;", "", "BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS", "[Ljava/lang/String;", "Ljava/text/DateFormat;", "BROWSER_COMPATIBLE_DATE_FORMATS", "[Ljava/text/DateFormat;", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class DatesKt {

    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = null;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = null;
    public static final long MAX_DATE = 253402300799999L;
    private static final okhttp3.internal.http.DatesKt.STANDARD_DATE_FORMAT.1 STANDARD_DATE_FORMAT;
    static {
        DatesKt.STANDARD_DATE_FORMAT.1 anon = new DatesKt.STANDARD_DATE_FORMAT.1();
        DatesKt.STANDARD_DATE_FORMAT = anon;
        void strArr = /* result */;
        DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = strArr;
        DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[strArr.length];
    }

    public static final Date toHttpDateOrNull(String string) {
        int i2;
        int i;
        Date parse;
        int index;
        Object simpleDateFormat;
        java.util.TimeZone uTC;
        Locale locale;
        n.f(string, "$this$toHttpDateOrNull");
        final int i3 = 0;
        i2 = string.length() == 0 ? 1 : i3;
        final int i4 = 0;
        if (i2 != 0) {
            return i4;
        }
        ParsePosition parsePosition = new ParsePosition(i3);
        if (parsePosition.getIndex() == string.length()) {
            return (DateFormat)DatesKt.STANDARD_DATE_FORMAT.get().parse(string, parsePosition);
        }
        String[] bROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        i = i3;
        synchronized (bROWSER_COMPATIBLE_DATE_FORMAT_STRINGS) {
            while (i < bROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length) {
                DateFormat[] bROWSER_COMPATIBLE_DATE_FORMATS = DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS;
                if (bROWSER_COMPATIBLE_DATE_FORMATS[i] == null) {
                }
                parsePosition.setIndex(i3);
                i++;
                simpleDateFormat = new SimpleDateFormat(DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
                simpleDateFormat.setTimeZone(Util.UTC);
                bROWSER_COMPATIBLE_DATE_FORMATS[i] = simpleDateFormat;
            }
            final w obj10 = w.a;
            return i4;
        }
    }

    public static final String toHttpDateString(Date date) {
        n.f(date, "$this$toHttpDateString");
        final String obj1 = (DateFormat)DatesKt.STANDARD_DATE_FORMAT.get().format(date);
        n.e(obj1, "STANDARD_DATE_FORMAT.get().format(this)");
        return obj1;
    }
}
