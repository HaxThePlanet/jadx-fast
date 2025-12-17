package androidx.collection;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u001e\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u0017\"\u0004\u0008\u0000\u0010\u0018\"\u0004\u0008\u0001\u0010\u0019\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u001b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0008H\u0080\u0008\u001a\u0011\u0010\u001e\u001a\u00020\u00082\u0006\u0010\u001f\u001a\u00020\u0008H\u0080\u0008\u001a\u0011\u0010 \u001a\u00020\u00082\u0006\u0010\u001f\u001a\u00020\u0008H\u0080\u0008\u001a\u0013\u0010\u001f\u001a\u00020\u00082\u0008\u0010!\u001a\u0004\u0018\u00010\u0010H\u0080\u0008\u001a\u0019\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0008H\u0080\u0008\u001a\u0019\u0010%\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0008H\u0080\u0008\u001a\u0011\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0001H\u0081\u0008\u001a\u0019\u0010&\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0008H\u0080\u0008\u001a\u0010\u0010(\u001a\u00020\u00082\u0006\u0010)\u001a\u00020\u0008H\u0000\u001a\u001e\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u000f\"\u0004\u0008\u0000\u0010\u0018\"\u0004\u0008\u0001\u0010\u0019\u001aO\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u000f\"\u0004\u0008\u0000\u0010\u0018\"\u0004\u0008\u0001\u0010\u00192*\u0010+\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190-0,\"\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190-¢\u0006\u0002\u0010.\u001a\u0010\u0010/\u001a\u00020\u00082\u0006\u0010)\u001a\u00020\u0008H\u0000\u001a\u0010\u00100\u001a\u00020\u00082\u0006\u00101\u001a\u00020\u0008H\u0000\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0008H\u0081\u0008\u001a\u0010\u00104\u001a\u00020\u00082\u0006\u0010)\u001a\u00020\u0008H\u0000\u001a!\u00105\u001a\u0002062\u0006\u00103\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00082\u0006\u0010'\u001a\u00020\u0001H\u0080\u0008\u001a\u0011\u00107\u001a\u00020\u0008*\u00060\u0001j\u0002`8H\u0080\u0008\u001a\u0011\u00109\u001a\u00020#*\u00060\u0001j\u0002`8H\u0080\u0008\u001a\u0011\u0010:\u001a\u00020\u0008*\u00060\u0001j\u0002`;H\u0081\u0008\u001a\u0015\u0010<\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001bH\u0080\u0008\u001a\u0015\u0010=\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001bH\u0081\u0008\u001a\u001d\u0010>\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001b2\u0006\u0010?\u001a\u00020\u0008H\u0081\u0008\u001a\u0011\u0010@\u001a\u00020\u0001*\u00060\u0001j\u0002`8H\u0080\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u00018\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0004\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0008X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000c\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0008X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0008X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001a\u00020\u00018\u0000X\u0081T¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0015\u0010\u0004*\u000c\u0008\u0000\u0010A\"\u00020\u00012\u00020\u0001*\u000c\u0008\u0000\u0010B\"\u00020\u00012\u00020\u0001*\u000c\u0008\u0000\u0010C\"\u00020\u00012\u00020\u0001¨\u0006D", d2 = {"AllEmpty", "", "BitmaskLsb", "getBitmaskLsb$annotations", "()V", "BitmaskMsb", "getBitmaskMsb$annotations", "ClonedMetadataCount", "", "DefaultScatterCapacity", "Deleted", "Empty", "EmptyGroup", "", "EmptyScatterMap", "Landroidx/collection/MutableScatterMap;", "", "", "GroupWidth", "MurmurHashC1", "Sentinel", "getSentinel$annotations", "emptyScatterMap", "Landroidx/collection/ScatterMap;", "K", "V", "group", "Landroidx/collection/Group;", "metadata", "offset", "h1", "hash", "h2", "k", "isDeleted", "", "index", "isEmpty", "isFull", "value", "loadedCapacity", "capacity", "mutableScatterMapOf", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/collection/MutableScatterMap;", "nextCapacity", "normalizeCapacity", "n", "readRawMetadata", "data", "unloadedCapacity", "writeRawMetadata", "", "get", "Landroidx/collection/Bitmask;", "hasNext", "lowestBitSet", "Landroidx/collection/StaticBitmask;", "maskEmpty", "maskEmptyOrDeleted", "match", "m", "next", "Bitmask", "Group", "StaticBitmask", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScatterMapKt {

    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254L;
    public static final long Empty = 128L;
    public static final long[] EmptyGroup = null;
    private static final androidx.collection.MutableScatterMap EmptyScatterMap = null;
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255L;
    static {
        long[] lArr = new long[2];
        lArr = new long[]{-9187201950435737345L, -1L};
        ScatterMapKt.EmptyGroup = lArr;
        MutableScatterMap mutableScatterMap = new MutableScatterMap(0);
        ScatterMapKt.EmptyScatterMap = mutableScatterMap;
    }

    public static final <K, V> androidx.collection.ScatterMap<K, V> emptyScatterMap() {
        final androidx.collection.MutableScatterMap emptyScatterMap = ScatterMapKt.EmptyScatterMap;
        Intrinsics.checkNotNull(emptyScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return (ScatterMap)emptyScatterMap;
    }

    public static final int get(long $this$get) {
        final int i = 0;
        final int i2 = 0;
        return numberOfTrailingZeros >> 3;
    }

    public static void getBitmaskLsb$annotations() {
    }

    public static void getBitmaskMsb$annotations() {
    }

    public static void getSentinel$annotations() {
    }

    public static final long group(long[] metadata, int offset) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        int i = 0;
        final int i2 = offset >> 3;
        i3 <<= 3;
        return i5 |= i9;
    }

    public static final int h1(int hash) {
        final int i = 0;
        return hash >>> 7;
    }

    public static final int h2(int hash) {
        final int i = 0;
        return hash & 127;
    }

    public static final boolean hasNext(long $this$hasNext) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$hasNext, i3) != 0 ? 1 : 0;
        return i;
    }

    public static final int hash(Object k) {
        int i;
        final int i2 = 0;
        if (k != null) {
            i = k.hashCode();
        } else {
            i = 0;
        }
        i *= i4;
        return i5 ^= i3;
    }

    public static final boolean isDeleted(long[] metadata, int index) {
        int i;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        int i2 = 0;
        int i3 = 0;
        i = Long.compare($i$f$readRawMetadata, i6) == 0 ? 1 : 0;
        return i;
    }

    public static final boolean isEmpty(long[] metadata, int index) {
        int i;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        int i2 = 0;
        int i3 = 0;
        i = Long.compare($i$f$readRawMetadata, i6) == 0 ? 1 : 0;
        return i;
    }

    public static final boolean isFull(long value) {
        int i;
        final int i2 = 0;
        i = Long.compare(value, i3) < 0 ? 1 : 0;
        return i;
    }

    public static final boolean isFull(long[] metadata, int index) {
        int i;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        int i2 = 0;
        int i3 = 0;
        i = Long.compare($i$f$readRawMetadata, i6) < 0 ? 1 : 0;
        return i;
    }

    public static final int loadedCapacity(int capacity) {
        if (capacity == 7) {
            return 6;
        }
        return capacity - i3;
    }

    public static final int lowestBitSet(long $this$lowestBitSet) {
        final int i = 0;
        return numberOfTrailingZeros >>= 3;
    }

    public static final long maskEmpty(long $this$maskEmpty) {
        final int i = 0;
        return i4 &= l;
    }

    public static final long maskEmptyOrDeleted(long $this$maskEmptyOrDeleted) {
        final int i = 0;
        return i4 &= l;
    }

    public static final long match(long $this$match, int m) {
        final int i = 0;
        long l2 = 72340172838076673L;
        i2 ^= $this$match;
        return i5 &= l3;
    }

    public static final <K, V> androidx.collection.MutableScatterMap<K, V> mutableScatterMapOf() {
        MutableScatterMap mutableScatterMap = new MutableScatterMap(0, 1, 0);
        return mutableScatterMap;
    }

    public static final <K, V> androidx.collection.MutableScatterMap<K, V> mutableScatterMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        MutableScatterMap mutableScatterMap = new MutableScatterMap(pairs.length);
        final int i = 0;
        mutableScatterMap.putAll(pairs);
        return mutableScatterMap;
    }

    public static final long next(long $this$next) {
        final int i = 0;
        return i3 &= $this$next;
    }

    public static final int nextCapacity(int capacity) {
        int i;
        i = capacity == 0 ? 6 : i2 + 1;
        return i;
    }

    public static final int normalizeCapacity(int n) {
        int i;
        int numberOfLeadingZeros;
        if (n > 0) {
            i2 >>>= numberOfLeadingZeros;
        } else {
            i = 0;
        }
        return i;
    }

    public static final long readRawMetadata(long[] data, int offset) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i = 0;
        return i3 &= i7;
    }

    public static final int unloadedCapacity(int capacity) {
        int i = 7;
        if (capacity == i) {
            return 8;
        }
        return i4 += capacity;
    }

    public static final void writeRawMetadata(long[] data, int offset, long value) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i = 0;
        final int i2 = offset >> 3;
        i3 <<= 3;
        data[i2] = i5 |= i10;
    }
}
