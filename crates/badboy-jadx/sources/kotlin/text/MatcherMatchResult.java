package kotlin.text;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001b¨\u0006\u001d", d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class MatcherMatchResult implements kotlin.text.MatchResult {

    private List<String> groupValues_;
    private final kotlin.text.MatchGroupCollection groups;
    private final java.lang.CharSequence input;
    private final Matcher matcher;
    public MatcherMatchResult(Matcher matcher, java.lang.CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        super();
        this.matcher = matcher;
        this.input = input;
        MatcherMatchResult.groups.1 anon = new MatcherMatchResult.groups.1(this);
        this.groups = (MatchGroupCollection)anon;
    }

    public static final MatchResult access$getMatchResult(kotlin.text.MatcherMatchResult $this) {
        return $this.getMatchResult();
    }

    private final MatchResult getMatchResult() {
        return (MatchResult)this.matcher;
    }

    @Override // kotlin.text.MatchResult
    public kotlin.text.MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    public List<String> getGroupValues() {
        List groupValues_;
        if (this.groupValues_ == null) {
            groupValues_ = new MatcherMatchResult.groupValues.1(this);
            this.groupValues_ = (List)groupValues_;
        }
        List groupValues_2 = this.groupValues_;
        Intrinsics.checkNotNull(groupValues_2);
        return groupValues_2;
    }

    @Override // kotlin.text.MatchResult
    public kotlin.text.MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override // kotlin.text.MatchResult
    public IntRange getRange() {
        return RegexKt.access$range(getMatchResult());
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String group = getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(group, "group(...)");
        return group;
    }

    @Override // kotlin.text.MatchResult
    public kotlin.text.MatchResult next() {
        int i;
        int i2;
        int start;
        i = getMatchResult().end() == getMatchResult().start() ? 1 : 0;
        i3 += i;
        if (i4 <= this.input.length()) {
            Matcher matcher2 = this.matcher.pattern().matcher(this.input);
            Intrinsics.checkNotNullExpressionValue(matcher2, "matcher(...)");
            i2 = RegexKt.access$findNext(matcher2, i4, this.input);
        } else {
            i2 = 0;
        }
        return i2;
    }
}
