package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\u0008\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0008H\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\u000cH\u0086\u0008¨\u0006\r", d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannableStringKt {
    public static final void clearSpans(Spannable $this$clearSpans) {
        int i2;
        Class<Object> obj2;
        Class<Object> obj;
        int i;
        final int i3 = 0;
        Spanned spanned = $this$clearSpans;
        int i6 = 0;
        Object[] $this$getSpans_u24default$iv = spanned.getSpans(0, (Spanned)spanned.length(), Object.class);
        int i5 = 0;
        i2 = 0;
        while (i2 < $this$getSpans_u24default$iv.length) {
            i = 0;
            $this$clearSpans.removeSpan($this$getSpans_u24default$iv[i2]);
            i2++;
        }
    }

    public static final void set(Spannable $this$set, int start, int end, Object span) {
        final int i = 0;
        $this$set.setSpan(span, start, end, 17);
    }

    public static final void set(Spannable $this$set, IntRange range, Object span) {
        final int i = 0;
        $this$set.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }

    public static final Spannable toSpannable(java.lang.CharSequence $this$toSpannable) {
        final int i = 0;
        return (Spannable)SpannableString.valueOf($this$toSpannable);
    }
}
