package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000c\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0016\u0018\u0000 \u00192\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0006H\u0016J\u0008\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0008\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CharProgression implements Iterable<Character>, KMappedMarker {

    public static final kotlin.ranges.CharProgression.Companion Companion;
    private final char first;
    private final char last;
    private final int step;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t¨\u0006\n", d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/CharProgression;", "rangeStart", "", "rangeEnd", "step", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.ranges.CharProgression fromClosedRange(char rangeStart, char rangeEnd, int step) {
            CharProgression charProgression = new CharProgression(rangeStart, rangeEnd, step);
            return charProgression;
        }
    }
    static {
        CharProgression.Companion companion = new CharProgression.Companion(0);
        CharProgression.Companion = companion;
    }

    public CharProgression(char start, char endInclusive, int step) {
        super();
        if (step == 0) {
        } else {
            if (step == Integer.MIN_VALUE) {
            } else {
                this.first = start;
                this.last = (char)progressionLastElement;
                this.step = step;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException2;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object other) {
        boolean empty;
        int i;
        int first;
        if (other instanceof CharProgression) {
            if (isEmpty()) {
                if (!(CharProgression)other.isEmpty()) {
                    if (this.first == obj2.first && this.last == obj3.last && this.step == obj4.step) {
                        if (this.last == obj3.last) {
                            i = this.step == obj4.step ? 1 : 0;
                        } else {
                        }
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

    @Override // java.lang.Iterable
    public final char getFirst() {
        return this.first;
    }

    @Override // java.lang.Iterable
    public final char getLast() {
        return this.last;
    }

    @Override // java.lang.Iterable
    public final int getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int i;
        int step;
        if (isEmpty()) {
            i = -1;
        } else {
            i4 += step;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        int compare;
        int i;
        char last;
        i = 1;
        if (this.step > 0) {
            if (Intrinsics.compare(this.first, this.last) > 0) {
            } else {
                i = i2;
            }
        } else {
            if (Intrinsics.compare(this.first, this.last) < 0) {
            } else {
            }
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return (Iterator)iterator();
    }

    @Override // java.lang.Iterable
    public CharIterator iterator() {
        CharProgressionIterator charProgressionIterator = new CharProgressionIterator(this.first, this.last, this.step);
        return (CharIterator)charProgressionIterator;
    }

    @Override // java.lang.Iterable
    public String toString() {
        StringBuilder append;
        int step;
        char last;
        String str = " step ";
        if (this.step > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            append = stringBuilder.append(this.first).append("..").append(this.last).append(str);
            step = this.step;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            append = stringBuilder2.append(this.first).append(" downTo ").append(this.last).append(str);
            step = -step3;
        }
        return append.append(step).toString();
    }
}
