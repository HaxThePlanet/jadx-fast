package kotlin.k0;

import java.util.regex.Matcher;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\u0008\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0008*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000cH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\u0008*\u00020\t2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002\u001a\u000c\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\u0008\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014", d2 = {"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class i {
    public static final kotlin.k0.f a(Matcher matcher, int i2, java.lang.CharSequence charSequence3) {
        return i.c(matcher, i2, charSequence3);
    }

    public static final kotlin.k0.f b(Matcher matcher, java.lang.CharSequence charSequence2) {
        return i.d(matcher, charSequence2);
    }

    private static final kotlin.k0.f c(Matcher matcher, int i2, java.lang.CharSequence charSequence3) {
        int obj0;
        boolean obj1;
        if (!matcher.find(i2)) {
            obj0 = 0;
        } else {
            obj1 = new g(matcher, charSequence3);
            obj0 = obj1;
        }
        return obj0;
    }

    private static final kotlin.k0.f d(Matcher matcher, java.lang.CharSequence charSequence2) {
        boolean gVar;
        int obj1;
        if (!matcher.matches()) {
            obj1 = 0;
        } else {
            gVar = new g(matcher, charSequence2);
            obj1 = gVar;
        }
        return obj1;
    }
}
