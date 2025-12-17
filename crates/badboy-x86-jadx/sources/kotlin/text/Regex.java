package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008B\u001d\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\u0008\u0001\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\u0008\u0010-\u001a\u00020\u0004H\u0016J\u0008\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u00062", d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Regex implements Serializable {

    public static final kotlin.text.Regex.Companion Companion;
    private Set<? extends kotlin.text.RegexOption> _options;
    private final Pattern nativePattern;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\u0007¨\u0006\u000c", d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final int access$ensureUnicodeCase(kotlin.text.Regex.Companion $this, int flags) {
            return $this.ensureUnicodeCase(flags);
        }

        private final int ensureUnicodeCase(int flags) {
            int i;
            i = flags & 2 != 0 ? flags | 64 : flags;
            return i;
        }

        public final String escape(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String quote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
            return quote;
        }

        public final String escapeReplacement(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            String quoteReplacement = Matcher.quoteReplacement(literal);
            Intrinsics.checkNotNullExpressionValue(quoteReplacement, "quoteReplacement(...)");
            return quoteReplacement;
        }

        public final kotlin.text.Regex fromLiteral(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            Regex regex = new Regex(literal, RegexOption.LITERAL);
            return regex;
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000f", d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Serialized implements Serializable {

        public static final kotlin.text.Regex.Serialized.Companion Companion;
        private static final long serialVersionUID;
        private final int flags;
        private final String pattern;
        static {
            Regex.Serialized.Companion companion = new Regex.Serialized.Companion(0);
            Regex.Serialized.Companion = companion;
        }

        public Serialized(String pattern, int flags) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            super();
            this.pattern = pattern;
            this.flags = flags;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
            Regex regex = new Regex(compile);
            return regex;
        }

        @Override // java.io.Serializable
        public final int getFlags() {
            return this.flags;
        }

        @Override // java.io.Serializable
        public final String getPattern() {
            return this.pattern;
        }
    }
    static {
        Regex.Companion companion = new Regex.Companion(0);
        Regex.Companion = companion;
    }

    public Regex(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern compile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        super(compile);
    }

    public Regex(String pattern, Set<? extends kotlin.text.RegexOption> options) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(options, "options");
        Pattern compile = Pattern.compile(pattern, Regex.Companion.access$ensureUnicodeCase(Regex.Companion, RegexKt.access$toInt((Iterable)options)));
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        super(compile);
    }

    public Regex(String pattern, kotlin.text.RegexOption option) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(option, "option");
        Pattern compile = Pattern.compile(pattern, Regex.Companion.access$ensureUnicodeCase(Regex.Companion, option.getValue()));
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        super(compile);
    }

    public Regex(Pattern nativePattern) {
        Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        super();
        this.nativePattern = nativePattern;
    }

    public static final Pattern access$getNativePattern$p(kotlin.text.Regex $this) {
        return $this.nativePattern;
    }

    public static kotlin.text.MatchResult find$default(kotlin.text.Regex regex, java.lang.CharSequence charSequence2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return regex.find(charSequence2, obj2);
    }

    public static Sequence findAll$default(kotlin.text.Regex regex, java.lang.CharSequence charSequence2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return regex.findAll(charSequence2, obj2);
    }

    public static List split$default(kotlin.text.Regex regex, java.lang.CharSequence charSequence2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return regex.split(charSequence2, obj2);
    }

    public static Sequence splitToSequence$default(kotlin.text.Regex regex, java.lang.CharSequence charSequence2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return regex.splitToSequence(charSequence2, obj2);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "pattern(...)");
        Regex.Serialized serialized = new Regex.Serialized(pattern, this.nativePattern.flags());
        return serialized;
    }

    @Override // java.io.Serializable
    public final boolean containsMatchIn(java.lang.CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    @Override // java.io.Serializable
    public final kotlin.text.MatchResult find(java.lang.CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.access$findNext(matcher, startIndex, input);
    }

    public final Sequence<kotlin.text.MatchResult> findAll(java.lang.CharSequence input, int startIndex) {
        String length;
        Intrinsics.checkNotNullParameter(input, "input");
        if (startIndex < 0) {
        } else {
            if (startIndex > input.length()) {
            } else {
                Regex.findAll.1 anon = new Regex.findAll.1(this, input, startIndex);
                return SequencesKt.generateSequence((Function0)anon, (Function1)Regex.findAll.2.INSTANCE);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Start index out of bounds: ").append(startIndex).append(", input length: ").append(input.length()).toString());
        throw indexOutOfBoundsException;
    }

    public final Set<kotlin.text.RegexOption> getOptions() {
        Set value$iv;
        int i2;
        Set unmodifiableSet;
        String str;
        int i;
        EnumSet set;
        kotlin.text.Regex.special$$inlined.fromInt.1 anon;
        if (this._options == null) {
            int i3 = 0;
            EnumSet allOf = EnumSet.allOf(RegexOption.class);
            EnumSet set2 = allOf;
            i = 0;
            Intrinsics.checkNotNull(set2);
            anon = new Regex.special$$inlined.fromInt.1(this.nativePattern.flags());
            CollectionsKt.retainAll((Iterable)set2, (Function1)anon);
            unmodifiableSet = Collections.unmodifiableSet((Set)allOf);
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(...)");
            i2 = 0;
            this._options = unmodifiableSet;
        }
        return value$iv;
    }

    @Override // java.io.Serializable
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "pattern(...)");
        return pattern;
    }

    @Override // java.io.Serializable
    public final kotlin.text.MatchResult matchAt(java.lang.CharSequence input, int index) {
        kotlin.text.MatcherMatchResult matcherMatchResult;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length());
        int i3 = 0;
        if (region.lookingAt()) {
            Intrinsics.checkNotNull(region);
            matcherMatchResult = new MatcherMatchResult(region, input);
        } else {
            matcherMatchResult = 0;
        }
        return (MatchResult)matcherMatchResult;
    }

    @Override // java.io.Serializable
    public final kotlin.text.MatchResult matchEntire(java.lang.CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.access$matchEntire(matcher, input);
    }

    @Override // java.io.Serializable
    public final boolean matches(java.lang.CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    @Override // java.io.Serializable
    public final boolean matchesAt(java.lang.CharSequence input, int index) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length()).lookingAt();
    }

    @Override // java.io.Serializable
    public final String replace(java.lang.CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public final String replace(java.lang.CharSequence input, Function1<? super kotlin.text.MatchResult, ? extends java.lang.CharSequence> transform) {
        kotlin.text.MatchResult match;
        int lastStart;
        kotlin.text.MatchResult matchResult;
        int intValue;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (Regex.find$default(this, input, 0, 2, 0) == null) {
            return input.toString();
        }
        lastStart = 0;
        int length = input.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        matchResult = match;
        stringBuilder.append(input, lastStart, matchResult.getRange().getStart().intValue());
        stringBuilder.append((CharSequence)transform.invoke(matchResult));
        lastStart = intValue + 1;
        while (lastStart < length) {
            if (matchResult.next() != null) {
            }
            matchResult = match;
            stringBuilder.append(input, lastStart, matchResult.getRange().getStart().intValue());
            stringBuilder.append((CharSequence)transform.invoke(matchResult));
            lastStart = intValue + 1;
        }
        if (lastStart < length) {
            stringBuilder.append(input, lastStart, length);
        }
        String string2 = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    @Override // java.io.Serializable
    public final String replaceFirst(java.lang.CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceFirst, "replaceFirst(...)");
        return replaceFirst;
    }

    public final List<String> split(java.lang.CharSequence input, int limit) {
        int find;
        int coerceAtMost;
        int lastStart;
        boolean string;
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt.requireNonNegativeLimit(limit);
        Matcher matcher = this.nativePattern.matcher(input);
        if (limit != 1) {
            if (!matcher.find()) {
            } else {
                if (limit > 0) {
                    coerceAtMost = RangesKt.coerceAtMost(limit, 10);
                }
                ArrayList arrayList = new ArrayList(coerceAtMost);
                lastStart = 0;
                final int i = limit + -1;
                arrayList.add(input.subSequence(lastStart, matcher.start()).toString());
                while (i >= 0) {
                    if (arrayList.size() != i) {
                    }
                    if (matcher.find()) {
                    }
                    arrayList.add(input.subSequence(lastStart, matcher.start()).toString());
                }
            }
            arrayList.add(input.subSequence(matcher.end(), input.length()).toString());
            return (List)arrayList;
        }
        return CollectionsKt.listOf(input.toString());
    }

    public final Sequence<String> splitToSequence(java.lang.CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt.requireNonNegativeLimit(limit);
        Regex.splitToSequence.1 anon = new Regex.splitToSequence.1(this, input, limit, 0);
        return SequencesKt.sequence((Function2)anon);
    }

    @Override // java.io.Serializable
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @Override // java.io.Serializable
    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
