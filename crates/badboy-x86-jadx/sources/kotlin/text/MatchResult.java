package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008f\u0018\u00002\u00020\u0001:\u0001\u0017J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0000H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u000cX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0008X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006\u0018", d2 = {"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MatchResult {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static kotlin.text.MatchResult.Destructured getDestructured(kotlin.text.MatchResult $this) {
            MatchResult.Destructured destructured = new MatchResult.Destructured($this);
            return destructured;
        }
    }

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0008H\u0087\nJ\t\u0010\t\u001a\u00020\u0008H\u0087\nJ\t\u0010\n\u001a\u00020\u0008H\u0087\nJ\t\u0010\u000b\u001a\u00020\u0008H\u0087\nJ\t\u0010\u000c\u001a\u00020\u0008H\u0087\nJ\t\u0010\r\u001a\u00020\u0008H\u0087\nJ\t\u0010\u000e\u001a\u00020\u0008H\u0087\nJ\t\u0010\u000f\u001a\u00020\u0008H\u0087\nJ\t\u0010\u0010\u001a\u00020\u0008H\u0087\nJ\t\u0010\u0011\u001a\u00020\u0008H\u0087\nJ\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0014", d2 = {"Lkotlin/text/MatchResult$Destructured;", "", "match", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)V", "getMatch", "()Lkotlin/text/MatchResult;", "component1", "", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "toList", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Destructured {

        private final kotlin.text.MatchResult match;
        public Destructured(kotlin.text.MatchResult match) {
            Intrinsics.checkNotNullParameter(match, "match");
            super();
            this.match = match;
        }

        private final String component1() {
            return (String)getMatch().getGroupValues().get(1);
        }

        private final String component10() {
            return (String)getMatch().getGroupValues().get(10);
        }

        private final String component2() {
            return (String)getMatch().getGroupValues().get(2);
        }

        private final String component3() {
            return (String)getMatch().getGroupValues().get(3);
        }

        private final String component4() {
            return (String)getMatch().getGroupValues().get(4);
        }

        private final String component5() {
            return (String)getMatch().getGroupValues().get(5);
        }

        private final String component6() {
            return (String)getMatch().getGroupValues().get(6);
        }

        private final String component7() {
            return (String)getMatch().getGroupValues().get(7);
        }

        private final String component8() {
            return (String)getMatch().getGroupValues().get(8);
        }

        private final String component9() {
            return (String)getMatch().getGroupValues().get(9);
        }

        public final kotlin.text.MatchResult getMatch() {
            return this.match;
        }

        public final List<String> toList() {
            return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
        }
    }
    public abstract kotlin.text.MatchResult.Destructured getDestructured();

    public abstract List<String> getGroupValues();

    public abstract kotlin.text.MatchGroupCollection getGroups();

    public abstract IntRange getRange();

    public abstract String getValue();

    public abstract kotlin.text.MatchResult next();
}
