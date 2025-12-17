package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001c\n\u0000\u001a-\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0014\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\u0008\u001a\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0008*\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000cH\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\u0008*\u00020\t2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002\u001a\u000c\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0006*\u0008\u0012\u0004\u0012\u00020\u00030\u0013H\u0002¨\u0006\u0014", d2 = {"fromInt", "", "T", "Lkotlin/text/FlagEnum;", "", "value", "", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "toInt", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RegexKt {
    public static final kotlin.text.MatchResult access$findNext(Matcher $receiver, int from, java.lang.CharSequence input) {
        return RegexKt.findNext($receiver, from, input);
    }

    public static final kotlin.text.MatchResult access$matchEntire(Matcher $receiver, java.lang.CharSequence input) {
        return RegexKt.matchEntire($receiver, input);
    }

    public static final IntRange access$range(MatchResult $receiver) {
        return RegexKt.range($receiver);
    }

    public static final IntRange access$range(MatchResult $receiver, int groupIndex) {
        return RegexKt.range($receiver, groupIndex);
    }

    public static final int access$toInt(Iterable $receiver) {
        return RegexKt.toInt($receiver);
    }

    private static final kotlin.text.MatchResult findNext(Matcher $this$findNext, int from, java.lang.CharSequence input) {
        int matcherMatchResult;
        if (!$this$findNext.find(from)) {
            matcherMatchResult = 0;
        } else {
            matcherMatchResult = new MatcherMatchResult($this$findNext, input);
        }
        return matcherMatchResult;
    }

    private static final <T extends Enum<T> & kotlin.text.FlagEnum> Set<T> fromInt(int value) {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Enum> obj = Enum.class;
        Class<Enum> obj2 = obj;
        EnumSet allOf = EnumSet.allOf(obj);
        EnumSet set = allOf;
        final int i3 = 0;
        Intrinsics.checkNotNull((EnumSet)set);
        Intrinsics.needClassReification();
        RegexKt.fromInt.1.1 anon = new RegexKt.fromInt.1.1(value);
        CollectionsKt.retainAll((Iterable)set, (Function1)anon);
        Set unmodifiableSet = Collections.unmodifiableSet((Set)allOf);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(...)");
        Set set2 = unmodifiableSet;
        return unmodifiableSet;
    }

    private static final kotlin.text.MatchResult matchEntire(Matcher $this$matchEntire, java.lang.CharSequence input) {
        int matcherMatchResult;
        if (!$this$matchEntire.matches()) {
            matcherMatchResult = 0;
        } else {
            matcherMatchResult = new MatcherMatchResult($this$matchEntire, input);
        }
        return matcherMatchResult;
    }

    private static final IntRange range(MatchResult $this$range) {
        return RangesKt.until($this$range.start(), $this$range.end());
    }

    private static final IntRange range(MatchResult $this$range, int groupIndex) {
        return RangesKt.until($this$range.start(groupIndex), $this$range.end(groupIndex));
    }

    private static final int toInt(Iterable<? extends kotlin.text.FlagEnum> $this$toInt) {
        int accumulator$iv;
        Object next;
        int option;
        int i;
        int i2;
        int value;
        final int i4 = 0;
        accumulator$iv = i3;
        final Iterator iterator = $this$toInt.iterator();
        for (Object next : iterator) {
            i2 = 0;
            accumulator$iv = option;
        }
        return accumulator$iv;
    }
}
