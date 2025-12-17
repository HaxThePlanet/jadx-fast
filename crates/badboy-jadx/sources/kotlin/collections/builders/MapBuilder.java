package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.markers.KMutableMap.Entry;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001f\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0010&\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u0000 \u0081\u0001*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\u000c\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0006B\u000f\u0008\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tBE\u0008\u0002\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u000e\u0010\u000c\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0008\u0012\u0006\u0010\u0011\u001a\u00020\u0008¢\u0006\u0002\u0010\u0012J\u0017\u00103\u001a\u00020\u00082\u0006\u00104\u001a\u00028\u0000H\u0000¢\u0006\u0004\u00085\u00106J\u0013\u00107\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0002\u00108J\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:J\r\u0010;\u001a\u00020<H\u0000¢\u0006\u0002\u0008=J\u0008\u0010>\u001a\u00020<H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020!H\u0002J\u0019\u0010A\u001a\u00020!2\n\u0010B\u001a\u0006\u0012\u0002\u0008\u00030CH\u0000¢\u0006\u0002\u0008DJ!\u0010E\u001a\u00020!2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010GH\u0000¢\u0006\u0002\u0008HJ\u0015\u0010I\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010JJ\u0015\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010JJ\u0018\u0010M\u001a\u00020!2\u000e\u0010N\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030:H\u0002J\u0010\u0010O\u001a\u00020<2\u0006\u0010P\u001a\u00020\u0008H\u0002J\u0010\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\u0008H\u0002J\u0019\u0010S\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010TH\u0000¢\u0006\u0002\u0008UJ\u0013\u0010V\u001a\u00020!2\u0008\u0010N\u001a\u0004\u0018\u00010WH\u0096\u0002J\u0015\u0010X\u001a\u00020\u00082\u0006\u00104\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u0015\u0010Y\u001a\u00020\u00082\u0006\u0010L\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00106J\u0018\u0010Z\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010[J\u0015\u0010\\\u001a\u00020\u00082\u0006\u00104\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u0008\u0010]\u001a\u00020\u0008H\u0016J\u0008\u0010^\u001a\u00020!H\u0016J\u0019\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010`H\u0000¢\u0006\u0002\u0008aJ\u001f\u0010b\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u00002\u0006\u0010L\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010cJ\u001e\u0010d\u001a\u00020<2\u0014\u0010e\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:H\u0016J\"\u0010f\u001a\u00020!2\u0018\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G0CH\u0002J\u001c\u0010g\u001a\u00020!2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010GH\u0002J\u0010\u0010h\u001a\u00020!2\u0006\u0010i\u001a\u00020\u0008H\u0002J\u0008\u0010j\u001a\u00020<H\u0002J\u0010\u0010k\u001a\u00020<2\u0006\u0010l\u001a\u00020\u0008H\u0002J\u0017\u0010m\u001a\u0004\u0018\u00018\u00012\u0006\u00104\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010[J!\u0010n\u001a\u00020!2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010GH\u0000¢\u0006\u0002\u0008oJ\u0010\u0010p\u001a\u00020<2\u0006\u0010q\u001a\u00020\u0008H\u0002J\u0010\u0010r\u001a\u00020<2\u0006\u0010s\u001a\u00020\u0008H\u0002J\u0017\u0010t\u001a\u00020!2\u0006\u00104\u001a\u00028\u0000H\u0000¢\u0006\u0004\u0008u\u0010JJ\u0017\u0010v\u001a\u00020!2\u0006\u0010w\u001a\u00028\u0001H\u0000¢\u0006\u0004\u0008x\u0010JJ\u0010\u0010y\u001a\u00020!2\u0006\u0010z\u001a\u00020\u0008H\u0002J\u0008\u0010{\u001a\u00020|H\u0016J\u0019\u0010}\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010~H\u0000¢\u0006\u0002\u0008\u007fJ\t\u0010\u0080\u0001\u001a\u00020WH\u0002R\u0014\u0010\u0013\u001a\u00020\u00088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0015R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u001a\u0010%\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008&\u0010\u001aR\u0016\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\u00082\u0006\u0010 \u001a\u00020\u0008@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u0015R\u001a\u0010-\u001a\u0008\u0012\u0004\u0012\u00028\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008/\u00100R\u0018\u0010\u000c\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u00101\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001", d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity$kotlin_stdlib", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "<set-?>", "", "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "modCount", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "updateHashArray", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "registerModification", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeEntryAt", "index", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeValue", "element", "removeValue$kotlin_stdlib", "shouldCompact", "extraCapacity", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "writeReplace", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MapBuilder<K, V>  implements Map<K, V>, Serializable, KMutableMap {

    public static final kotlin.collections.builders.MapBuilder.Companion Companion = null;
    private static final kotlin.collections.builders.MapBuilder Empty = null;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;
    private kotlin.collections.builders.MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private kotlin.collections.builders.MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private kotlin.collections.builders.MapBuilderValues<V> valuesView;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/MapBuilder;", "", "getEmpty$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final int access$computeHashSize(kotlin.collections.builders.MapBuilder.Companion $this, int capacity) {
            return $this.computeHashSize(capacity);
        }

        public static final int access$computeShift(kotlin.collections.builders.MapBuilder.Companion $this, int hashSize) {
            return $this.computeShift(hashSize);
        }

        private final int computeHashSize(int capacity) {
            return Integer.highestOneBit(coerceAtLeast *= 3);
        }

        private final int computeShift(int hashSize) {
            return numberOfLeadingZeros++;
        }

        public final kotlin.collections.builders.MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.access$getEmpty$cp();
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0010\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0008\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0008\u0019J\u0006\u0010\u001a\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0008X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0008X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u000b\"\u0004\u0008\u0010\u0010\rR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001b", d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "expectedModCount", "", "index", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "checkForComodification", "", "checkForComodification$kotlin_stdlib", "hasNext", "", "initNext", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class Itr {

        private int expectedModCount;
        private int index;
        private int lastIndex = -1;
        private final kotlin.collections.builders.MapBuilder<K, V> map;
        public Itr(kotlin.collections.builders.MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super();
            this.map = map;
            int i = -1;
            this.expectedModCount = MapBuilder.access$getModCount$p(this.map);
            initNext$kotlin_stdlib();
        }

        public final void checkForComodification$kotlin_stdlib() {
            if (MapBuilder.access$getModCount$p(this.map) != this.expectedModCount) {
            } else {
            }
            ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
            throw concurrentModificationException;
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final kotlin.collections.builders.MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final boolean hasNext() {
            int i;
            i = this.index < MapBuilder.access$getLength$p(this.map) ? 1 : 0;
            return i;
        }

        public final void initNext$kotlin_stdlib() {
            int i;
            int index;
            int index2;
            while (this.index < MapBuilder.access$getLength$p(this.map)) {
                if (MapBuilder.access$getPresenceArray$p(this.map)[this.index] < 0) {
                }
                this.index = index3++;
            }
        }

        public final void remove() {
            int i;
            checkForComodification$kotlin_stdlib();
            int i4 = -1;
            i = this.lastIndex != i4 ? 1 : 0;
            if (i == 0) {
            } else {
                this.map.checkIsMutable$kotlin_stdlib();
                MapBuilder.access$removeEntryAt(this.map, this.lastIndex);
                this.lastIndex = i4;
                this.expectedModCount = MapBuilder.access$getModCount$p(this.map);
            }
            int i2 = 0;
            IllegalStateException $i$a$CheckMapBuilder$Itr$remove$1 = new IllegalStateException("Call next() before removing element from the iterator.".toString());
            throw $i$a$CheckMapBuilder$Itr$remove$1;
        }

        public final void setIndex$kotlin_stdlib(int <set-?>) {
            this.index = <set-?>;
        }

        public final void setLastIndex$kotlin_stdlib(int <set-?>) {
            this.lastIndex = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0008\u0012¨\u0006\u0013", d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntriesItr extends kotlin.collections.builders.MapBuilder.Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        public EntriesItr(kotlin.collections.builders.MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }

        @Override // kotlin.collections.builders.MapBuilder$Itr
        public Object next() {
            return next();
        }

        public kotlin.collections.builders.MapBuilder.EntryRef<K, V> next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) {
            } else {
                int index$kotlin_stdlib2 = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib2 + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib2);
                MapBuilder.EntryRef entryRef = new MapBuilder.EntryRef(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
                initNext$kotlin_stdlib();
                return entryRef;
            }
            NoSuchElementException result = new NoSuchElementException();
            throw result;
        }

        @Override // kotlin.collections.builders.MapBuilder$Itr
        public final void nextAppendString(StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) {
            } else {
                int index$kotlin_stdlib2 = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib2 + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib2);
                Object obj = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
                final String str2 = "(this Map)";
                if (obj == getMap$kotlin_stdlib()) {
                    sb.append(str2);
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr2 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
                Intrinsics.checkNotNull(objArr2);
                Object obj2 = objArr2[getLastIndex$kotlin_stdlib()];
                if (obj2 == getMap$kotlin_stdlib()) {
                    sb.append(str2);
                } else {
                    sb.append(obj2);
                }
                initNext$kotlin_stdlib();
            }
            NoSuchElementException key = new NoSuchElementException();
            throw key;
        }

        @Override // kotlin.collections.builders.MapBuilder$Itr
        public final int nextHashCode$kotlin_stdlib() {
            int i2;
            int i;
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) {
            } else {
                int index$kotlin_stdlib2 = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib2 + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib2);
                Object obj = MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
                if (obj != null) {
                    i2 = obj.hashCode();
                } else {
                    i2 = i;
                }
                Object[] objArr2 = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
                Intrinsics.checkNotNull(objArr2);
                Object obj2 = objArr2[getLastIndex$kotlin_stdlib()];
                if (obj2 != null) {
                    i = obj2.hashCode();
                }
                initNext$kotlin_stdlib();
                return i2 ^= i;
            }
            NoSuchElementException result = new NoSuchElementException();
            throw result;
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000b¨\u0006\u0018", d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EntryRef implements Map.Entry<K, V>, KMutableMap.Entry {

        private final int index;
        private final kotlin.collections.builders.MapBuilder<K, V> map;
        public EntryRef(kotlin.collections.builders.MapBuilder<K, V> map, int index) {
            Intrinsics.checkNotNullParameter(map, "map");
            super();
            this.map = map;
            this.index = index;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object other) {
            int i;
            boolean equal;
            Object value;
            if (other instanceof Map.Entry && Intrinsics.areEqual((Map.Entry)other.getKey(), getKey()) && Intrinsics.areEqual((Map.Entry)other.getValue(), getValue())) {
                if (Intrinsics.areEqual((Map.Entry)other.getKey(), getKey())) {
                    i = Intrinsics.areEqual((Map.Entry)other.getValue(), getValue()) ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }

        public K getKey() {
            return MapBuilder.access$getKeysArray$p(this.map)[this.index];
        }

        public V getValue() {
            Object[] objArr = MapBuilder.access$getValuesArray$p(this.map);
            Intrinsics.checkNotNull(objArr);
            return objArr[this.index];
        }

        @Override // java.util.Map$Entry
        public int hashCode() {
            int i2;
            int i;
            Object key = getKey();
            if (key != null) {
                i2 = key.hashCode();
            } else {
                i2 = i;
            }
            final Object value = getValue();
            if (value != null) {
                i = value.hashCode();
            }
            return i2 ^= i;
        }

        public V setValue(V newValue) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] objArr = MapBuilder.access$allocateValuesArray(this.map);
            objArr[this.index] = newValue;
            return objArr[this.index];
        }

        @Override // java.util.Map$Entry
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(getKey()).append('=').append(getValue()).toString();
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0008\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KeysItr extends kotlin.collections.builders.MapBuilder.Itr<K, V> implements Iterator<K>, KMutableIterator {
        public KeysItr(kotlin.collections.builders.MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }

        public K next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) {
            } else {
                int index$kotlin_stdlib2 = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib2 + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib2);
                initNext$kotlin_stdlib();
                return MapBuilder.access$getKeysArray$p(getMap$kotlin_stdlib())[getLastIndex$kotlin_stdlib()];
            }
            NoSuchElementException result = new NoSuchElementException();
            throw result;
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0008\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ValuesItr extends kotlin.collections.builders.MapBuilder.Itr<K, V> implements Iterator<V>, KMutableIterator {
        public ValuesItr(kotlin.collections.builders.MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            super(map);
        }

        public V next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= MapBuilder.access$getLength$p(getMap$kotlin_stdlib())) {
            } else {
                int index$kotlin_stdlib2 = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib2 + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib2);
                Object[] objArr = MapBuilder.access$getValuesArray$p(getMap$kotlin_stdlib());
                Intrinsics.checkNotNull(objArr);
                initNext$kotlin_stdlib();
                return objArr[getLastIndex$kotlin_stdlib()];
            }
            NoSuchElementException result = new NoSuchElementException();
            throw result;
        }
    }
    static {
        MapBuilder.Companion companion = new MapBuilder.Companion(0);
        MapBuilder.Companion = companion;
        MapBuilder mapBuilder = new MapBuilder(0);
        final int i3 = 0;
        map.isReadOnly = true;
        MapBuilder.Empty = mapBuilder;
    }

    public MapBuilder() {
        super(8);
    }

    public MapBuilder(int initialCapacity) {
        super(ListBuilderKt.arrayOfUninitializedElements(initialCapacity), 0, new int[initialCapacity], new int[MapBuilder.Companion.access$computeHashSize(MapBuilder.Companion, initialCapacity)], 2, 0);
    }

    private MapBuilder(K[] keysArray, V[] valuesArray, int[] presenceArray, int[] hashArray, int maxProbeDistance, int length) {
        super();
        this.keysArray = keysArray;
        this.valuesArray = valuesArray;
        this.presenceArray = presenceArray;
        this.hashArray = hashArray;
        this.maxProbeDistance = maxProbeDistance;
        this.length = length;
        this.hashShift = MapBuilder.Companion.access$computeShift(MapBuilder.Companion, getHashSize());
    }

    public static final Object[] access$allocateValuesArray(kotlin.collections.builders.MapBuilder $this) {
        return $this.allocateValuesArray();
    }

    public static final kotlin.collections.builders.MapBuilder access$getEmpty$cp() {
        return MapBuilder.Empty;
    }

    public static final Object[] access$getKeysArray$p(kotlin.collections.builders.MapBuilder $this) {
        return $this.keysArray;
    }

    public static final int access$getLength$p(kotlin.collections.builders.MapBuilder $this) {
        return $this.length;
    }

    public static final int access$getModCount$p(kotlin.collections.builders.MapBuilder $this) {
        return $this.modCount;
    }

    public static final int[] access$getPresenceArray$p(kotlin.collections.builders.MapBuilder $this) {
        return $this.presenceArray;
    }

    public static final Object[] access$getValuesArray$p(kotlin.collections.builders.MapBuilder $this) {
        return $this.valuesArray;
    }

    public static final void access$removeEntryAt(kotlin.collections.builders.MapBuilder $this, int index) {
        $this.removeEntryAt(index);
    }

    private final V[] allocateValuesArray() {
        final Object[] valuesArray = this.valuesArray;
        if (valuesArray != null) {
            return valuesArray;
        }
        Object[] arrayOfUninitializedElements = ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
        this.valuesArray = arrayOfUninitializedElements;
        return arrayOfUninitializedElements;
    }

    private final void compact(boolean updateHashArray) {
        int i;
        int j;
        int i2;
        Object[] keysArray;
        Object[] keysArray2;
        Object obj;
        i = 0;
        j = 0;
        final Object[] valuesArray = this.valuesArray;
        while (i < this.length) {
            i2 = this.presenceArray[i];
            this.keysArray[j] = this.keysArray[i];
            if (i2 >= 0 && valuesArray != null) {
            }
            i++;
            this.keysArray[j] = this.keysArray[i];
            if (valuesArray != null) {
            }
            if (updateHashArray != null) {
            }
            j++;
            this.presenceArray[j] = i2;
            this.hashArray[i2] = j + 1;
            valuesArray[j] = valuesArray[i];
        }
        ListBuilderKt.resetRange(this.keysArray, j, this.length);
        if (valuesArray != null) {
            ListBuilderKt.resetRange(valuesArray, j, this.length);
        }
        this.length = j;
    }

    private final boolean contentEquals(Map<?, ?> other) {
        int allEntries$kotlin_stdlib;
        int i;
        if (size() == other.size() && containsAllEntries$kotlin_stdlib((Collection)other.entrySet())) {
            i = containsAllEntries$kotlin_stdlib((Collection)other.entrySet()) ? 1 : 0;
        } else {
        }
        return i;
    }

    private final void ensureCapacity(int minCapacity) {
        int capacity$kotlin_stdlib;
        int i;
        Object[] copyOfUninitializedElements;
        int hashSize;
        if (minCapacity < 0) {
        } else {
            if (minCapacity > getCapacity$kotlin_stdlib()) {
                capacity$kotlin_stdlib = AbstractList.Companion.newCapacity$kotlin_stdlib(getCapacity$kotlin_stdlib(), minCapacity);
                this.keysArray = ListBuilderKt.copyOfUninitializedElements(this.keysArray, capacity$kotlin_stdlib);
                Object[] valuesArray = this.valuesArray;
                if (valuesArray != null) {
                    copyOfUninitializedElements = ListBuilderKt.copyOfUninitializedElements(valuesArray, capacity$kotlin_stdlib);
                } else {
                    copyOfUninitializedElements = 0;
                }
                this.valuesArray = copyOfUninitializedElements;
                int[] copyOf = Arrays.copyOf(this.presenceArray, capacity$kotlin_stdlib);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.presenceArray = copyOf;
                i = MapBuilder.Companion.access$computeHashSize(MapBuilder.Companion, capacity$kotlin_stdlib);
                if (i > getHashSize()) {
                    rehash(i);
                }
            }
        }
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
        throw outOfMemoryError;
    }

    private final void ensureExtraCapacity(int n) {
        int i;
        if (shouldCompact(n)) {
            compact(true);
        } else {
            ensureCapacity(length += n);
        }
    }

    private final int findKey(K key) {
        int hash;
        int probesLeft;
        int i2;
        int i3;
        boolean equal;
        int i;
        hash = hash(key);
        probesLeft = this.maxProbeDistance;
        i2 = this.hashArray[hash];
        int i4 = -1;
        while (i2 == 0) {
            if (hash == 0) {
            } else {
            }
            hash = i3;
            i2 = this.hashArray[hash];
            i4 = -1;
            hashSize--;
        }
        return i4;
    }

    private final int findValue(V value) {
        int i;
        int equal;
        i = this.length;
        int i2 = -1;
        i += i2;
        while (i >= 0) {
            i2 = -1;
            i += i2;
            Object[] valuesArray = this.valuesArray;
            Intrinsics.checkNotNull(valuesArray);
        }
        return i2;
    }

    private final int getHashSize() {
        return hashArray.length;
    }

    private final int hash(K key) {
        int i;
        if (key != 0) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        return i2 >>>= hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> from) {
        int updated;
        boolean entry;
        if (from.isEmpty()) {
            return 0;
        }
        ensureExtraCapacity(from.size());
        Iterator iterator = from.iterator();
        updated = 0;
        while (iterator.hasNext()) {
            if (putEntry((Map.Entry)iterator.next())) {
            }
            updated = 1;
        }
        return updated;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int key$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        final Object[] allocateValuesArray = allocateValuesArray();
        int i = 1;
        if (key$kotlin_stdlib >= 0) {
            allocateValuesArray[key$kotlin_stdlib] = entry.getValue();
            return i;
        }
        if (!Intrinsics.areEqual(entry.getValue(), allocateValuesArray[i3 -= i])) {
            allocateValuesArray[i5 -= i] = entry.getValue();
            return i;
        }
        return 0;
    }

    private final boolean putRehash(int i) {
        int hash;
        int probesLeft;
        int i4;
        int i3;
        int i2;
        hash = hash(this.keysArray[i]);
        probesLeft = this.maxProbeDistance;
        i3 = 1;
        while (this.hashArray[hash] == 0) {
            if (hash == 0) {
            } else {
            }
            hash = i2;
            i3 = 1;
            hashSize -= i3;
        }
        this.hashArray[hash] = i + 1;
        this.presenceArray[i] = hash;
        return i3;
    }

    private final void registerModification() {
        this.modCount = modCount++;
    }

    private final void rehash(int newHashSize) {
        int length;
        int i;
        int size;
        registerModification();
        if (this.length > size()) {
            compact(false);
        }
        this.hashArray = new int[newHashSize];
        this.hashShift = MapBuilder.Companion.access$computeShift(MapBuilder.Companion, newHashSize);
        i = 0;
        while (i < this.length) {
            i = size;
        }
    }

    private final void removeEntryAt(int index) {
        ListBuilderKt.resetAt(this.keysArray, index);
        Object[] valuesArray = this.valuesArray;
        if (valuesArray != null) {
            ListBuilderKt.resetAt(valuesArray, index);
        }
        removeHashAt(this.presenceArray[index]);
        final int i3 = -1;
        this.presenceArray[index] = i3;
        this.size = size += i3;
        registerModification();
    }

    private final void removeHashAt(int removedHash) {
        int hash;
        int hole;
        int probeDistance;
        int patchAttemptsLeft;
        int i3;
        int i;
        int hashArray;
        int presenceArray;
        int i2;
        hash = removedHash;
        hole = removedHash;
        probeDistance = 0;
        patchAttemptsLeft = RangesKt.coerceAtMost(maxProbeDistance *= 2, hashSize2 /= 2);
        while (hash == 0) {
            hashSize--;
            probeDistance++;
            int i6 = 0;
            i3 = this.hashArray[hash];
            i = -1;
            if (i3 < 0) {
            } else {
            }
            if (i8 &= i2 >= probeDistance) {
            }
            hash = i5;
            this.hashArray[hole] = i3;
            this.presenceArray[i3 + -1] = hole;
            hole = hash;
            probeDistance = 0;
            this.hashArray[hole] = i;
            hole = hash;
            probeDistance = 0;
        }
        this.hashArray[hole] = i6;
    }

    private final boolean shouldCompact(int extraCapacity) {
        int i;
        int size;
        capacity$kotlin_stdlib -= length;
        length2 -= size;
        if (i2 < extraCapacity && i3 + i2 >= extraCapacity && i3 >= capacity$kotlin_stdlib2 /= 4) {
            if (i3 + i2 >= extraCapacity) {
                i = i3 >= capacity$kotlin_stdlib2 /= 4 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private final Object writeReplace() {
        if (!this.isReadOnly) {
        } else {
            SerializedMap serializedMap = new SerializedMap((Map)this);
            return serializedMap;
        }
        NotSerializableException notSerializableException = new NotSerializableException("The map cannot be serialized while it is being built.");
        throw notSerializableException;
    }

    public final int addKey$kotlin_stdlib(K key) {
        int hash;
        int coerceAtMost;
        int probeDistance;
        int i;
        int i2;
        int length;
        int capacity$kotlin_stdlib;
        checkIsMutable$kotlin_stdlib();
        while (/* condition */) {
            i = this.hashArray[hash];
            i2 = 1;
            while (i <= 0) {
                if (probeDistance++ > coerceAtMost) {
                    break loop_2;
                } else {
                }
                if (hash == 0) {
                } else {
                }
                hash = length;
                i = this.hashArray[hash];
                i2 = 1;
                hashSize -= i2;
            }
            if (probeDistance++ > coerceAtMost) {
            } else {
            }
            if (hash == 0) {
            } else {
            }
            hash = length;
            hashSize -= i2;
            rehash(hashSize3 *= 2);
            hash = hash(key);
            probeDistance = 0;
            if (this.length < getCapacity$kotlin_stdlib()) {
                break;
            } else {
            }
            ensureExtraCapacity(i2);
        }
        int length2 = this.length;
        this.length = length2 + 1;
        this.keysArray[length2] = key;
        this.presenceArray[length2] = hash;
        this.hashArray[hash] = length2 + 1;
        this.size = size += i2;
        registerModification();
        if (probeDistance > this.maxProbeDistance) {
            this.maxProbeDistance = probeDistance;
        }
        return length2;
    }

    public final Map<K, V> build() {
        Object empty;
        String str;
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            empty = this;
        } else {
            Intrinsics.checkNotNull(MapBuilder.Empty, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        }
        return empty;
    }

    @Override // java.util.Map
    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // java.util.Map
    public void clear() {
        int i2;
        int length;
        int i;
        int[] presenceArray;
        int i3;
        checkIsMutable$kotlin_stdlib();
        length2--;
        final int i6 = 0;
        if (0 <= i5) {
        }
        ListBuilderKt.resetRange(this.keysArray, i6, this.length);
        Object[] valuesArray = this.valuesArray;
        if (valuesArray != null) {
            ListBuilderKt.resetRange(valuesArray, i6, this.length);
        }
        this.size = i6;
        this.length = i6;
        registerModification();
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m) {
        Object next;
        int i;
        Throwable entry$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(m, "m");
        Iterator iterator = m.iterator();
        for (Object next : iterator) {
        }
        return 1;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int key2 = findKey(entry.getKey());
        if (key2 < 0) {
            return 0;
        }
        Object[] valuesArray = this.valuesArray;
        Intrinsics.checkNotNull(valuesArray);
        return Intrinsics.areEqual(valuesArray[key2], entry.getValue());
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        int i;
        i = findKey(key) >= 0 ? 1 : 0;
        return i;
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        int i;
        i = findValue(value) >= 0 ? 1 : 0;
        return i;
    }

    public final kotlin.collections.builders.MapBuilder.EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        MapBuilder.EntriesItr entriesItr = new MapBuilder.EntriesItr(this);
        return entriesItr;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        boolean contentEquals;
        int i;
        if (other != this) {
            if (other instanceof Map != null && contentEquals((Map)other)) {
                if (contentEquals((Map)other)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public V get(Object key) {
        final int key2 = findKey(key);
        if (key2 < 0) {
            return 0;
        }
        Object[] valuesArray = this.valuesArray;
        Intrinsics.checkNotNull(valuesArray);
        return valuesArray[key2];
    }

    @Override // java.util.Map
    public final int getCapacity$kotlin_stdlib() {
        return keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        final kotlin.collections.builders.MapBuilderEntries entriesView = this.entriesView;
        if (entriesView == null) {
            MapBuilderEntries mapBuilderEntries = new MapBuilderEntries(this);
            this.entriesView = mapBuilderEntries;
            return (Set)mapBuilderEntries;
        }
        return (Set)entriesView;
    }

    public Set<K> getKeys() {
        kotlin.collections.builders.MapBuilderKeys mapBuilderKeys;
        final kotlin.collections.builders.MapBuilderKeys keysView = this.keysView;
        if (keysView == null) {
            mapBuilderKeys = new MapBuilderKeys(this);
            this.keysView = mapBuilderKeys;
        } else {
            mapBuilderKeys = keysView;
        }
        return mapBuilderKeys;
    }

    @Override // java.util.Map
    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        kotlin.collections.builders.MapBuilderValues mapBuilderValues;
        final kotlin.collections.builders.MapBuilderValues valuesView = this.valuesView;
        if (valuesView == null) {
            mapBuilderValues = new MapBuilderValues(this);
            this.valuesView = mapBuilderValues;
        } else {
            mapBuilderValues = valuesView;
        }
        return mapBuilderValues;
    }

    @Override // java.util.Map
    public int hashCode() {
        int result;
        int nextHashCode$kotlin_stdlib;
        result = 0;
        final kotlin.collections.builders.MapBuilder.EntriesItr entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            result += nextHashCode$kotlin_stdlib;
        }
        return result;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    @Override // java.util.Map
    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public final Set<K> keySet() {
        return getKeys();
    }

    public final kotlin.collections.builders.MapBuilder.KeysItr<K, V> keysIterator$kotlin_stdlib() {
        MapBuilder.KeysItr keysItr = new MapBuilder.KeysItr(this);
        return keysItr;
    }

    public V put(K key, V value) {
        checkIsMutable$kotlin_stdlib();
        final int key$kotlin_stdlib = addKey$kotlin_stdlib(key);
        final Object[] allocateValuesArray = allocateValuesArray();
        if (key$kotlin_stdlib < 0) {
            allocateValuesArray[i4--] = value;
            return allocateValuesArray[i--];
        }
        allocateValuesArray[key$kotlin_stdlib] = value;
        return 0;
    }

    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries((Collection)from.entrySet());
    }

    public V remove(Object key) {
        checkIsMutable$kotlin_stdlib();
        final int key2 = findKey(key);
        if (key2 < 0) {
            return 0;
        }
        Object[] valuesArray = this.valuesArray;
        Intrinsics.checkNotNull(valuesArray);
        removeEntryAt(key2);
        return valuesArray[key2];
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int key2 = findKey(entry.getKey());
        int i = 0;
        if (key2 < 0) {
            return i;
        }
        Object[] valuesArray = this.valuesArray;
        Intrinsics.checkNotNull(valuesArray);
        if (!Intrinsics.areEqual(valuesArray[key2], entry.getValue())) {
            return i;
        }
        removeEntryAt(key2);
        return 1;
    }

    public final boolean removeKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        final int key2 = findKey(key);
        if (key2 < 0) {
            return 0;
        }
        removeEntryAt(key2);
        return 1;
    }

    public final boolean removeValue$kotlin_stdlib(V element) {
        checkIsMutable$kotlin_stdlib();
        final int value = findValue(element);
        if (value < 0) {
            return 0;
        }
        removeEntryAt(value);
        return 1;
    }

    @Override // java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.Map
    public String toString() {
        int i;
        boolean next;
        StringBuilder stringBuilder = new StringBuilder(i2 += 2);
        stringBuilder.append("{");
        i = 0;
        final kotlin.collections.builders.MapBuilder.EntriesItr entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
            }
            entriesIterator$kotlin_stdlib.nextAppendString(stringBuilder);
            i++;
            stringBuilder.append(", ");
        }
        stringBuilder.append("}");
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final Collection<V> values() {
        return getValues();
    }

    public final kotlin.collections.builders.MapBuilder.ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        MapBuilder.ValuesItr valuesItr = new MapBuilder.ValuesItr(this);
        return valuesItr;
    }
}
