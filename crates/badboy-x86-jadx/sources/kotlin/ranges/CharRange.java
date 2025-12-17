package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 \u001a2\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0008\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001aB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u0012\u001a\u00020\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0010H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0008\u001a\u00020\u00038VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001b", d2 = {"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(CC)V", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "()Ljava/lang/Character;", "getEndInclusive", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CharRange extends kotlin.ranges.CharProgression implements kotlin.ranges.ClosedRange<Character>, kotlin.ranges.OpenEndRange<Character> {

    public static final kotlin.ranges.CharRange.Companion Companion;
    private static final kotlin.ranges.CharRange EMPTY;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/ranges/CharRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/CharRange;", "getEMPTY", "()Lkotlin/ranges/CharRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.CharRange getEMPTY() {
            return CharRange.access$getEMPTY$cp();
        }
    }
    static {
        CharRange.Companion companion = new CharRange.Companion(0);
        CharRange.Companion = companion;
        CharRange charRange = new CharRange(1, 0);
        CharRange.EMPTY = charRange;
    }

    public CharRange(char start, char endInclusive) {
        super(start, endInclusive, 1);
    }

    public static final kotlin.ranges.CharRange access$getEMPTY$cp() {
        return CharRange.EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Char type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static void getEndExclusive$annotations() {
    }

    @Override // kotlin.ranges.CharProgression
    public boolean contains(char value) {
        int compare;
        int i;
        if (Intrinsics.compare(getFirst(), value) <= 0 && Intrinsics.compare(value, getLast()) <= 0) {
            i = Intrinsics.compare(value, getLast()) <= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.CharProgression
    public boolean contains(Comparable value) {
        return contains((Character)value.charValue());
    }

    @Override // kotlin.ranges.CharProgression
    public boolean equals(Object other) {
        int i;
        boolean empty;
        char first;
        if (other instanceof CharRange) {
            if (isEmpty()) {
                if (!(CharRange)other.isEmpty()) {
                    if (getFirst() == (CharRange)other.getFirst() && getLast() == (CharRange)other.getLast()) {
                        i = getLast() == (CharRange)other.getLast() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.CharProgression
    public Character getEndExclusive() {
        if (getLast() == 65535) {
        } else {
            return Character.valueOf((char)i);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        throw illegalStateException;
    }

    @Override // kotlin.ranges.CharProgression
    public Comparable getEndExclusive() {
        return (Comparable)getEndExclusive();
    }

    @Override // kotlin.ranges.CharProgression
    public Character getEndInclusive() {
        return Character.valueOf(getLast());
    }

    @Override // kotlin.ranges.CharProgression
    public Comparable getEndInclusive() {
        return (Comparable)getEndInclusive();
    }

    @Override // kotlin.ranges.CharProgression
    public Character getStart() {
        return Character.valueOf(getFirst());
    }

    @Override // kotlin.ranges.CharProgression
    public Comparable getStart() {
        return (Comparable)getStart();
    }

    @Override // kotlin.ranges.CharProgression
    public int hashCode() {
        int i;
        char last;
        if (isEmpty()) {
            i = -1;
        } else {
            i2 += last;
        }
        return i;
    }

    @Override // kotlin.ranges.CharProgression
    public boolean isEmpty() {
        int i;
        i = Intrinsics.compare(getFirst(), getLast()) > 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.ranges.CharProgression
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getFirst()).append("..").append(getLast()).toString();
    }
}
