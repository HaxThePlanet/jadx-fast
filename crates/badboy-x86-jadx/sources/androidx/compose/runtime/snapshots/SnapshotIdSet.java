package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000 $2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B)\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u000c\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J:\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002'\u0010\u0011\u001a#\u0012\u0013\u0012\u00110\u0000¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0012H\u0086\u0008J\u001d\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001dH\u0096\u0002J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\u0008\u0010\"\u001a\u00020#H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {

    public static final int $stable;
    public static final androidx.compose.runtime.snapshots.SnapshotIdSet.Companion Companion;
    private static final androidx.compose.runtime.snapshots.SnapshotIdSet EMPTY;
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.runtime.snapshots.SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.access$getEMPTY$cp();
        }
    }
    static {
        SnapshotIdSet.Companion companion = new SnapshotIdSet.Companion(0);
        SnapshotIdSet.Companion = companion;
        SnapshotIdSet snapshotIdSet = new SnapshotIdSet(0, obj4, 0, obj6, 0, 0);
        SnapshotIdSet.EMPTY = snapshotIdSet;
    }

    private SnapshotIdSet(long upperSet, long lowerSet, int lowerBound, int[] belowBound) {
        super();
        this.upperSet = upperSet;
        this.lowerSet = lowerBound;
        this.lowerBound = obj5;
        this.belowBound = obj6;
    }

    public static final int[] access$getBelowBound$p(androidx.compose.runtime.snapshots.SnapshotIdSet $this) {
        return $this.belowBound;
    }

    public static final androidx.compose.runtime.snapshots.SnapshotIdSet access$getEMPTY$cp() {
        return SnapshotIdSet.EMPTY;
    }

    public static final int access$getLowerBound$p(androidx.compose.runtime.snapshots.SnapshotIdSet $this) {
        return $this.lowerBound;
    }

    public static final long access$getLowerSet$p(androidx.compose.runtime.snapshots.SnapshotIdSet $this) {
        return $this.lowerSet;
    }

    public static final long access$getUpperSet$p(androidx.compose.runtime.snapshots.SnapshotIdSet $this) {
        return $this.upperSet;
    }

    @Override // java.lang.Iterable
    public final androidx.compose.runtime.snapshots.SnapshotIdSet and(androidx.compose.runtime.snapshots.SnapshotIdSet bits) {
        int lowerBound;
        int eMPTY;
        int index$iv$iv2;
        int i6;
        int index$iv$iv;
        int index$iv$iv3;
        int belowBound2;
        androidx.compose.runtime.snapshots.SnapshotIdSet this_$iv;
        androidx.compose.runtime.snapshots.SnapshotIdSet previous;
        int previous5;
        boolean z;
        int snapshotIdSet;
        int i;
        long i2;
        androidx.compose.runtime.snapshots.SnapshotIdSet accumulator$iv;
        long l;
        int[] previous3;
        int previous4;
        int[] belowBound;
        int previous2;
        int i7;
        int i5;
        int i3;
        androidx.compose.runtime.snapshots.SnapshotIdSet set;
        int i8;
        int i4;
        int i9;
        final Object obj = this;
        final Object obj2 = bits;
        if (Intrinsics.areEqual(obj2, SnapshotIdSet.EMPTY)) {
            return SnapshotIdSet.EMPTY;
        }
        if (Intrinsics.areEqual(obj, SnapshotIdSet.EMPTY)) {
            return SnapshotIdSet.EMPTY;
        }
        belowBound2 = 0;
        if (obj2.lowerBound == obj.lowerBound && obj2.belowBound == obj.belowBound) {
            if (obj2.belowBound == obj.belowBound) {
                if (Long.compare(eMPTY, belowBound2) == 0 && Long.compare(previous5, belowBound2) == 0 && obj.belowBound == null) {
                    if (Long.compare(previous5, belowBound2) == 0) {
                        if (obj.belowBound == null) {
                            this_$iv = SnapshotIdSet.EMPTY;
                        } else {
                            snapshotIdSet = new SnapshotIdSet(upperSet4 &= upperSet2, obj10, lowerSet4 &= lowerSet, obj12, obj.lowerBound, obj.belowBound);
                            this_$iv = snapshotIdSet;
                        }
                    } else {
                    }
                } else {
                }
            } else {
                i6 = 0;
                previous5 = 1;
                snapshotIdSet = 64;
                if (obj.belowBound == null) {
                    i2 = 0;
                    int i18 = 0;
                    accumulator$iv = eMPTY;
                    previous3 = i;
                    previous4 = 0;
                    belowBound = SnapshotIdSet.access$getBelowBound$p(previous3);
                    if (belowBound != null) {
                        while (i6 < belowBound.length) {
                            i3 = 0;
                            set = accumulator$iv;
                            i4 = 0;
                            int i14 = i8;
                            if (obj2.get(i14)) {
                            } else {
                            }
                            previous = set;
                            accumulator$iv = set;
                            i6++;
                            belowBound2 = i9;
                            set = set.set(i14);
                        }
                        i9 = belowBound2;
                    } else {
                        i9 = belowBound2;
                    }
                    if (Long.compare(l2, i9) != 0) {
                        index$iv$iv = 0;
                        while (index$iv$iv < snapshotIdSet) {
                            if (Long.compare(i10, i9) != 0) {
                            } else {
                            }
                            i3 = previous5;
                            index$iv$iv++;
                            previous5 = i3;
                            previous = 0;
                            i5 = 0;
                            i3 = previous5;
                            previous5 = i7;
                            if (obj2.get(previous5)) {
                            }
                            accumulator$iv = previous2;
                            previous2 = z;
                        }
                        i3 = previous5;
                    } else {
                        i3 = previous5;
                    }
                    if (Long.compare(l3, i9) != 0) {
                        index$iv$iv2 = 0;
                        while (index$iv$iv2 < snapshotIdSet) {
                            previous = 0;
                            z = belowBound2;
                            previous2 = 0;
                            if (Long.compare(i12, i9) != 0 && obj2.get(z)) {
                            }
                            index$iv$iv2++;
                            previous = 0;
                            z = belowBound2;
                            previous2 = 0;
                            if (obj2.get(z)) {
                            }
                            accumulator$iv = previous5;
                            previous5 = i7;
                        }
                        this_$iv = accumulator$iv;
                    } else {
                        this_$iv = accumulator$iv;
                    }
                } else {
                    i9 = belowBound2;
                    i3 = previous5;
                    previous = 0;
                    int i16 = 0;
                    previous5 = eMPTY;
                    z = obj3;
                    i = 0;
                    i2 = SnapshotIdSet.access$getBelowBound$p(z);
                    if (i2 != null) {
                        while (i6 < i2.length) {
                            belowBound = 0;
                            i5 = 0;
                            int[] iArr = iArr2;
                            if (obj.get(iArr)) {
                            }
                            previous5 = previous2;
                            i6++;
                            snapshotIdSet = 64;
                            previous2 = i7;
                        }
                    }
                    if (Long.compare(l, i9) != 0) {
                        index$iv$iv3 = 0;
                        while (index$iv$iv3 < 64) {
                            l = 0;
                            previous4 = snapshotIdSet;
                            belowBound = 0;
                            if (Long.compare(l, i9) != 0 && obj.get(previous4)) {
                            }
                            index$iv$iv3++;
                            l = 0;
                            previous4 = snapshotIdSet;
                            belowBound = 0;
                            if (obj.get(previous4)) {
                            }
                            previous5 = previous3;
                            previous3 = previous2;
                        }
                    }
                    if (Long.compare(accumulator$iv, i9) != 0) {
                        index$iv$iv2 = 0;
                        while (index$iv$iv2 < 64) {
                            previous3 = 0;
                            belowBound = accumulator$iv;
                            previous2 = 0;
                            if (Long.compare(i19, i9) != 0 && obj.get(belowBound)) {
                            }
                            index$iv$iv2++;
                            previous3 = 0;
                            belowBound = accumulator$iv;
                            previous2 = 0;
                            if (obj.get(belowBound)) {
                            }
                            previous5 = previous4;
                            previous4 = i7;
                        }
                    }
                    this_$iv = previous5;
                }
            }
        } else {
        }
        return this_$iv;
    }

    @Override // java.lang.Iterable
    public final androidx.compose.runtime.snapshots.SnapshotIdSet andNot(androidx.compose.runtime.snapshots.SnapshotIdSet bits) {
        int lowerBound2;
        long lowerSet;
        int lowerBound;
        androidx.compose.runtime.snapshots.SnapshotIdSet accumulator$iv2;
        androidx.compose.runtime.snapshots.SnapshotIdSet accumulator$iv;
        androidx.compose.runtime.snapshots.SnapshotIdSet this_$iv$iv;
        int i2;
        int[] iArr;
        int[] index$iv$iv;
        int index$iv$iv2;
        int i4;
        int lowerBound3;
        int i7;
        int previous3;
        long belowBound;
        int i6;
        int i8;
        androidx.compose.runtime.snapshots.SnapshotIdSet previous;
        int previous2;
        int i5;
        int i3;
        int i;
        final androidx.compose.runtime.snapshots.SnapshotIdSet set = this;
        final androidx.compose.runtime.snapshots.SnapshotIdSet set2 = bits;
        if (set2 == SnapshotIdSet.EMPTY) {
            return set;
        }
        if (set == SnapshotIdSet.EMPTY) {
            return SnapshotIdSet.EMPTY;
        }
        if (set2.lowerBound == set.lowerBound && set2.belowBound == set.belowBound) {
            if (set2.belowBound == set.belowBound) {
                accumulator$iv = new SnapshotIdSet(i10 &= upperSet, obj6, i11 &= lowerSet, obj8, set.lowerBound, set.belowBound);
            } else {
                lowerBound = 0;
                int i9 = 0;
                accumulator$iv2 = this;
                androidx.compose.runtime.snapshots.SnapshotIdSet set3 = lowerSet;
                i2 = 0;
                iArr = SnapshotIdSet.access$getBelowBound$p(set3);
                if (iArr != null) {
                    i4 = 0;
                    while (i4 < iArr.length) {
                        i8 = 0;
                        i5 = 0;
                        accumulator$iv2 = previous;
                        i4++;
                    }
                }
                previous3 = 0;
                i8 = 1;
                lowerBound3 = 64;
                if (Long.compare(l, previous3) != 0) {
                    index$iv$iv2 = 0;
                    while (index$iv$iv2 < lowerBound3) {
                        if (Long.compare(i15, previous3) != 0) {
                        } else {
                        }
                        i3 = previous3;
                        index$iv$iv2++;
                        previous3 = i3;
                        i5 = 0;
                        i3 = previous3;
                        i = 0;
                        accumulator$iv2 = previous3;
                    }
                    i3 = previous3;
                } else {
                    i3 = previous3;
                }
                if (Long.compare(belowBound, i3) != 0) {
                    index$iv$iv = 0;
                    while (index$iv$iv < lowerBound3) {
                        if (Long.compare(i12, i3) != 0) {
                        }
                        index$iv$iv++;
                        i6 = 0;
                        i = 0;
                        accumulator$iv2 = previous2;
                    }
                }
                accumulator$iv = this_$iv$iv;
            }
        } else {
        }
        return accumulator$iv;
    }

    @Override // java.lang.Iterable
    public final androidx.compose.runtime.snapshots.SnapshotIdSet clear(int bit) {
        int belowBound;
        int binarySearch;
        int i2;
        int i3;
        int i;
        int i4 = bit - lowerBound;
        belowBound = 0;
        i2 = 1;
        i = 64;
        if (i4 >= 0 && i4 < i) {
            if (i4 < i) {
                i2 <<= i4;
                if (Long.compare(i, belowBound) != 0) {
                    SnapshotIdSet snapshotIdSet2 = new SnapshotIdSet(this.upperSet, obj7, i9 &= lowerSet, obj9, this.lowerBound, this.belowBound);
                    return snapshotIdSet2;
                }
            } else {
                if (i4 >= i && i4 < 128) {
                    if (i4 < 128) {
                        i2 <<= i6;
                        if (Long.compare(i, belowBound) != 0) {
                            SnapshotIdSet snapshotIdSet3 = new SnapshotIdSet(i7 &= upperSet, obj7, this.lowerSet, obj9, this.lowerBound, this.belowBound);
                            return snapshotIdSet3;
                        }
                    } else {
                        belowBound = this.belowBound;
                        binarySearch = SnapshotIdSetKt.binarySearch(belowBound, bit);
                        length--;
                        if (i4 < 0 && belowBound != null && binarySearch >= 0 && i5 == 0) {
                            belowBound = this.belowBound;
                            if (belowBound != null) {
                                binarySearch = SnapshotIdSetKt.binarySearch(belowBound, bit);
                                if (binarySearch >= 0) {
                                    length--;
                                    if (i5 == 0) {
                                        SnapshotIdSet snapshotIdSet = new SnapshotIdSet(this.upperSet, obj6, this.lowerSet, obj8, this.lowerBound, 0);
                                        return snapshotIdSet;
                                    }
                                    int[] iArr = new int[i5];
                                    if (binarySearch > 0) {
                                        i3 = 0;
                                        ArraysKt.copyInto(belowBound, iArr, i3, i3, binarySearch);
                                    }
                                    if (binarySearch < i5) {
                                        ArraysKt.copyInto(belowBound, iArr, binarySearch, binarySearch + 1, i5 + 1);
                                    }
                                    SnapshotIdSet snapshotIdSet4 = new SnapshotIdSet(this.upperSet, obj7, this.lowerSet, obj9, this.lowerBound, iArr);
                                    return snapshotIdSet4;
                                }
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return this;
    }

    public final androidx.compose.runtime.snapshots.SnapshotIdSet fastFold(androidx.compose.runtime.snapshots.SnapshotIdSet initial, Function2<? super androidx.compose.runtime.snapshots.SnapshotIdSet, ? super Integer, androidx.compose.runtime.snapshots.SnapshotIdSet> operation) {
        Object accumulator;
        int length;
        int index$iv;
        int index$iv2;
        int i3;
        int i2;
        int i5;
        int i;
        Integer valueOf;
        int cmp2;
        long cmp;
        int i4;
        int valueOf2;
        final Object obj = operation;
        final int i6 = 0;
        int i7 = 0;
        accumulator = initial;
        androidx.compose.runtime.snapshots.SnapshotIdSet set = this;
        final int i8 = 0;
        final int[] iArr = SnapshotIdSet.access$getBelowBound$p(set);
        if (iArr != null) {
            i3 = 0;
            while (i3 < iArr.length) {
                i = 0;
                accumulator = obj.invoke(accumulator, Integer.valueOf(iArr[i3]));
                i3++;
            }
        }
        int i10 = 0;
        int i11 = 1;
        int i9 = 64;
        if (Long.compare(l, i10) != 0) {
            index$iv = 0;
            while (index$iv < i9) {
                if (Long.compare(i14, i10) != 0) {
                }
                index$iv++;
                i4 = 0;
                accumulator = obj.invoke(accumulator, Integer.valueOf(i15 += index$iv));
            }
        }
        if (Long.compare(cmp, i10) != 0) {
            index$iv2 = 0;
            while (index$iv2 < i9) {
                if (Long.compare(i12, i10) != 0) {
                }
                index$iv2++;
                i4 = 0;
                accumulator = obj.invoke(accumulator, Integer.valueOf(i13 += i16));
            }
        }
        return (SnapshotIdSet)accumulator;
    }

    public final void fastForEach(Function1<? super Integer, Unit> block) {
        int length;
        int index2;
        int index;
        int i2;
        int i;
        Integer valueOf2;
        int valueOf;
        long valueOf3;
        int i3;
        int i4;
        final int i5 = 0;
        final int[] iArr = SnapshotIdSet.access$getBelowBound$p(this);
        if (iArr != null) {
            i2 = 0;
            while (i2 < iArr.length) {
                block.invoke(Integer.valueOf(iArr[i2]));
                i2++;
            }
        }
        int i7 = 0;
        final int i8 = 1;
        int i6 = 64;
        if (Long.compare(l, i7) != 0) {
            index2 = 0;
            while (index2 < i6) {
                if (Long.compare(i12, i7) != 0) {
                }
                index2++;
                block.invoke(Integer.valueOf(i13 += index2));
            }
        }
        if (Long.compare(valueOf3, i7) != 0) {
            index = 0;
            while (index < i6) {
                if (Long.compare(i9, i7) != 0) {
                }
                index++;
                block.invoke(Integer.valueOf(i10 += i3));
            }
        }
    }

    @Override // java.lang.Iterable
    public final boolean get(int bit) {
        int i4;
        int binarySearch;
        int i3;
        int i2;
        int i;
        int i5 = bit - lowerBound;
        int i6 = 0;
        binarySearch = 1;
        i3 = 1;
        i2 = 64;
        i = 0;
        if (i5 >= 0 && i5 < i2) {
            if (i5 < i2) {
                if (Long.compare(i10, i6) != 0) {
                } else {
                    i3 = i;
                }
                return i3;
            }
        }
        if (i5 >= i2 && i5 < 128) {
            if (i5 < 128) {
                if (Long.compare(i8, i6) != 0) {
                } else {
                    i3 = i;
                }
                return i3;
            }
        }
        if (i5 > 0) {
            return i;
        }
        int[] belowBound = this.belowBound;
        if (belowBound != null) {
            i4 = 0;
            if (SnapshotIdSetKt.binarySearch(belowBound, bit) >= 0) {
            } else {
                i3 = i;
            }
            i = i3;
        } else {
        }
        return i;
    }

    public Iterator<Integer> iterator() {
        SnapshotIdSet.iterator.1 anon = new SnapshotIdSet.iterator.1(this, 0);
        return SequencesKt.sequence((Function2)anon).iterator();
    }

    @Override // java.lang.Iterable
    public final int lowest(int default) {
        final int[] belowBound = this.belowBound;
        if (belowBound != null) {
            return belowBound[0];
        }
        final int i6 = 0;
        if (Long.compare(lowerSet, i6) != 0) {
            return lowerBound += numberOfTrailingZeros;
        }
        if (Long.compare(upperSet, i6) != 0) {
            return i4 += numberOfTrailingZeros2;
        }
        return default;
    }

    @Override // java.lang.Iterable
    public final androidx.compose.runtime.snapshots.SnapshotIdSet or(androidx.compose.runtime.snapshots.SnapshotIdSet bits) {
        long lowerSet;
        int lowerBound;
        int[] index$iv$iv4;
        int i2;
        int index$iv$iv2;
        int index$iv$iv;
        int index$iv$iv3;
        androidx.compose.runtime.snapshots.SnapshotIdSet $i$f$fastFold;
        androidx.compose.runtime.snapshots.SnapshotIdSet previous;
        int accumulator$iv;
        long l;
        int cmp2;
        long cmp;
        int[] iArr;
        int lowerBound2;
        int[] accumulator$iv2;
        androidx.compose.runtime.snapshots.SnapshotIdSet set;
        int previous2;
        int[] iArr2;
        int previous3;
        int i7;
        int i8;
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        final androidx.compose.runtime.snapshots.SnapshotIdSet set2 = this;
        final androidx.compose.runtime.snapshots.SnapshotIdSet set3 = bits;
        if (set3 == SnapshotIdSet.EMPTY) {
            return set2;
        }
        if (set2 == SnapshotIdSet.EMPTY) {
            return set3;
        }
        if (set3.lowerBound == set2.lowerBound && set3.belowBound == set2.belowBound) {
            if (set3.belowBound == set2.belowBound) {
                $i$f$fastFold = new SnapshotIdSet(upperSet2 |= upperSet, obj6, lowerSet2 |= lowerSet, obj8, set2.lowerBound, set2.belowBound);
            } else {
                i2 = 0;
                l = 64;
                cmp2 = 0;
                if (set2.belowBound == null) {
                    lowerBound2 = 0;
                    int i21 = 0;
                    accumulator$iv2 = bits;
                    set = lowerSet;
                    previous2 = 0;
                    iArr2 = SnapshotIdSet.access$getBelowBound$p(set);
                    if (iArr2 != null) {
                        while (i2 < iArr2.length) {
                            i = 0;
                            i5 = 0;
                            i6 = 1;
                            accumulator$iv2 = previous;
                            i2++;
                        }
                        i6 = 1;
                    } else {
                        i6 = 1;
                    }
                    if (Long.compare(l2, cmp2) != 0) {
                        index$iv$iv2 = 0;
                        while (index$iv$iv2 < l) {
                            if (Long.compare(i9, cmp2) != 0) {
                            }
                            index$iv$iv2++;
                            accumulator$iv = 0;
                            i8 = 0;
                            accumulator$iv2 = previous3;
                        }
                    }
                    if (Long.compare(l3, cmp2) != 0) {
                        index$iv$iv4 = 0;
                        while (index$iv$iv4 < l) {
                            if (Long.compare(i11, cmp2) != 0) {
                            }
                            index$iv$iv4++;
                            accumulator$iv = 0;
                            i8 = 0;
                            accumulator$iv2 = previous3;
                        }
                        $i$f$fastFold = accumulator$iv2;
                    } else {
                        $i$f$fastFold = accumulator$iv2;
                    }
                } else {
                    i6 = 1;
                    int i13 = 0;
                    int i15 = 0;
                    accumulator$iv = this;
                    lowerBound2 = lowerSet;
                    accumulator$iv2 = 0;
                    set = SnapshotIdSet.access$getBelowBound$p(lowerBound2);
                    if (set != null) {
                        while (i2 < set.length) {
                            i7 = 0;
                            i3 = 0;
                            accumulator$iv = previous4;
                            i2++;
                            cmp2 = i8;
                        }
                        i8 = cmp2;
                    } else {
                        i8 = cmp2;
                    }
                    if (Long.compare(cmp, i8) != 0) {
                        index$iv$iv = 0;
                        while (index$iv$iv < l) {
                            if (Long.compare(i16, i8) != 0) {
                            }
                            index$iv$iv++;
                            iArr = 0;
                            previous3 = 0;
                            accumulator$iv = previous2;
                        }
                    }
                    if (Long.compare(cmp2, i8) != 0) {
                        index$iv$iv3 = 0;
                        while (index$iv$iv3 < l) {
                            if (Long.compare(i18, i8) != 0) {
                            }
                            index$iv$iv3++;
                            iArr = 0;
                            previous3 = 0;
                            accumulator$iv = previous2;
                        }
                    }
                    $i$f$fastFold = index$iv$iv4;
                }
            }
        } else {
        }
        return $i$f$fastFold;
    }

    @Override // java.lang.Iterable
    public final androidx.compose.runtime.snapshots.SnapshotIdSet set(int bit) {
        int belowBound;
        int binarySearch;
        int cmp;
        int length;
        int valueOf;
        long l2;
        int newLowerBound;
        int i5;
        long arrayList;
        int[] iArr;
        long newLowerSet;
        int newBelowBound;
        int i9;
        long newUpperSet;
        int i2;
        long l;
        int[] iArr2;
        int i6;
        int i7;
        int i3;
        int i8;
        int i;
        int i4;
        final Object obj = this;
        final int i10 = bit;
        int i11 = i10 - lowerBound;
        belowBound = 1;
        cmp = 0;
        valueOf = 64;
        if (i11 >= 0 && i11 < valueOf) {
            if (i11 < valueOf) {
                belowBound <<= i11;
                if (Long.compare(valueOf, cmp) == 0) {
                    SnapshotIdSet snapshotIdSet2 = new SnapshotIdSet(obj.upperSet, obj8, lowerSet3 |= belowBound, obj10, obj.lowerBound, obj.belowBound);
                    return snapshotIdSet2;
                }
            } else {
                l2 = 128;
                if (i11 >= valueOf && i11 < l2) {
                    if (i11 < l2) {
                        belowBound <<= i16;
                        if (Long.compare(valueOf, cmp) == 0) {
                            SnapshotIdSet snapshotIdSet3 = new SnapshotIdSet(upperSet4 |= belowBound, l2, obj.lowerSet, obj10, obj.lowerBound, obj.belowBound);
                            return snapshotIdSet3;
                        }
                    } else {
                        if (i11 >= l2) {
                            if (!get(bit)) {
                                int i25 = 0;
                                newLowerSet = obj.lowerSet;
                                int i21 = 0;
                                newLowerBound = obj.lowerBound;
                                newBelowBound = 0;
                                i27 *= valueOf;
                                newUpperSet = arrayList;
                                while (newLowerBound < i28) {
                                    if (Long.compare(newLowerSet, cmp) != 0) {
                                    } else {
                                    }
                                    i2 = belowBound;
                                    i3 = cmp;
                                    binarySearch = valueOf;
                                    newLowerSet = newUpperSet;
                                    newUpperSet = 0L;
                                    newLowerBound += 64;
                                    valueOf = binarySearch;
                                    belowBound = i2;
                                    cmp = i3;
                                    if (newBelowBound == 0) {
                                    } else {
                                    }
                                    i2 = belowBound;
                                    i3 = cmp;
                                    belowBound = 0;
                                    while (belowBound < 64) {
                                        cmp = belowBound;
                                        length = 0;
                                        if (Long.compare(i5, i3) != 0) {
                                        }
                                        belowBound++;
                                        newBelowBound.add(Integer.valueOf(cmp + newLowerBound));
                                    }
                                    cmp = belowBound;
                                    length = 0;
                                    if (Long.compare(i5, i3) != 0) {
                                    }
                                    belowBound++;
                                    newBelowBound.add(Integer.valueOf(cmp + newLowerBound));
                                    arrayList = new ArrayList();
                                    i9 = 0;
                                    i2 = belowBound;
                                    belowBound = obj.belowBound;
                                    if (belowBound != null) {
                                    } else {
                                    }
                                    i3 = cmp;
                                    newBelowBound = arrayList;
                                    binarySearch = 0;
                                    i7 = 0;
                                    i3 = cmp;
                                    cmp = iArr2;
                                    i5 = 0;
                                    while (i5 < cmp.length) {
                                        i4 = 0;
                                        (List)arrayList.add(Integer.valueOf(cmp[i5]));
                                        i5++;
                                        valueOf = 64;
                                    }
                                    i4 = 0;
                                    iArr.add(Integer.valueOf(cmp[i5]));
                                    i5++;
                                    valueOf = 64;
                                }
                                i6 = newLowerBound;
                                l = newLowerSet;
                                if (newBelowBound != 0) {
                                    if (CollectionsKt.toIntArray((Collection)newBelowBound) == null) {
                                        belowBound = obj.belowBound;
                                    }
                                } else {
                                }
                                SnapshotIdSet snapshotIdSet5 = new SnapshotIdSet(newUpperSet, obj18, l, obj20, i6, belowBound);
                                return snapshotIdSet5.set(i10);
                            }
                        } else {
                            belowBound = obj.belowBound;
                            if (belowBound == null) {
                                SnapshotIdSet snapshotIdSet = new SnapshotIdSet(obj.upperSet, obj6, obj.lowerSet, l2, obj.lowerBound, /* result */);
                                return snapshotIdSet;
                            }
                            binarySearch = SnapshotIdSetKt.binarySearch(belowBound, i10);
                            if (binarySearch < 0) {
                                int i14 = -i13;
                                length2++;
                                final int[] iArr4 = new int[i15];
                                int i19 = 0;
                                ArraysKt.copyInto(belowBound, iArr4, i19, i19, i14);
                                ArraysKt.copyInto(belowBound, iArr4, i14 + 1, i14, i15 + -1);
                                iArr4[i14] = i10;
                                SnapshotIdSet snapshotIdSet4 = new SnapshotIdSet(obj.upperSet, obj9, obj.lowerSet, obj11, obj.lowerBound, iArr4);
                                return snapshotIdSet4;
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return obj;
    }

    @Override // java.lang.Iterable
    public String toString() {
        Object next;
        String it;
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        Iterable iterable = this;
        final int i3 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, 10));
        final int i5 = 0;
        final Iterator iterator = iterable.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)arrayList.add(String.valueOf((Number)next.intValue()));
        }
        return stringBuilder.append(super.toString()).append(" [").append(ListUtilsKt.fastJoinToString$default((List)arrayList, 0, 0, 0, 0, 0, 0, 63, 0)).append(']').toString();
    }
}
