package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0014", d2 = {"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MatchGroup {

    private final IntRange range;
    private final String value;
    public MatchGroup(String value, IntRange range) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(range, "range");
        super();
        this.value = value;
        this.range = range;
    }

    public static kotlin.text.MatchGroup copy$default(kotlin.text.MatchGroup matchGroup, String string2, IntRange intRange3, int i4, Object object5) {
        String obj1;
        IntRange obj2;
        if (i4 & 1 != 0) {
            obj1 = matchGroup.value;
        }
        if (i4 &= 2 != 0) {
            obj2 = matchGroup.range;
        }
        return matchGroup.copy(obj1, obj2);
    }

    public final String component1() {
        return this.value;
    }

    public final IntRange component2() {
        return this.range;
    }

    public final kotlin.text.MatchGroup copy(String string, IntRange intRange2) {
        Intrinsics.checkNotNullParameter(string, "value");
        Intrinsics.checkNotNullParameter(intRange2, "range");
        MatchGroup matchGroup = new MatchGroup(string, intRange2);
        return matchGroup;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof MatchGroup) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.value, obj.value)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.range, obj.range)) {
            return i2;
        }
        return i;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MatchGroup(value=").append(this.value).append(", range=").append(this.range).append(')').toString();
    }
}
