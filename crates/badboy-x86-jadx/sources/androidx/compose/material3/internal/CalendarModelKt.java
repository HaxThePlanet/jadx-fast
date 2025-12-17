package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"DaysInWeek", "", "MillisecondsIn24Hours", "", "datePatternAsInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "localeFormat", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CalendarModelKt {

    public static final int DaysInWeek = 7;
    public static final long MillisecondsIn24Hours = 86400000L;
    public static final androidx.compose.material3.internal.DateInputFormat datePatternAsInputFormat(String localeFormat) {
        Regex regex = new Regex("[^dMy/\\-.]");
        Regex regex2 = new Regex("d{1,2}");
        Regex regex3 = new Regex("M{1,2}");
        Regex regex4 = new Regex("y{1,4}");
        String suffix = StringsKt.removeSuffix(StringsKt.replace$default(regex4.replace((CharSequence)regex3.replace((CharSequence)regex2.replace((CharSequence)regex.replace((CharSequence)localeFormat, ""), "dd"), "MM"), "yyyy"), "My", "M/y", false, 4, 0), (CharSequence)".");
        Regex regex5 = new Regex("[/\\-.]");
        int i4 = 0;
        MatchResult find$default = Regex.find$default(regex5, (CharSequence)suffix, i4, 2, 0);
        Intrinsics.checkNotNull(find$default);
        MatchGroup matchGroup = find$default.getGroups().get(i4);
        Intrinsics.checkNotNull(matchGroup);
        int first = matchGroup.getRange().getFirst();
        String substring = suffix.substring(first, first + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        DateInputFormat dateInputFormat = new DateInputFormat(suffix, substring.charAt(i4));
        return dateInputFormat;
    }
}
