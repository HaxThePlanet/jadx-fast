package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* loaded from: classes5.dex */
public class UriMatcherCompat {
    public static Predicate<Uri> asPredicate(UriMatcher matcher) {
        UriMatcherCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new UriMatcherCompat$$ExternalSyntheticLambda0(matcher);
        return externalSyntheticLambda0;
    }

    static boolean lambda$asPredicate$0(UriMatcher matcher, Uri v) {
        int i;
        i = matcher.match(v) != -1 ? 1 : 0;
        return i;
    }
}
