package kotlin.y.u0;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.j0.d;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.y.i;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001f\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0010&\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u0000 v*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0006vwxyz{B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0004B\u000f\u0008\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007BE\u0008\u0002\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000c\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0000¢\u0006\u0004\u00080\u00101J\u0013\u00102\u001a\u0008\u0012\u0004\u0012\u00028\u00010\tH\u0002¢\u0006\u0002\u00103J\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105J\r\u00106\u001a\u000207H\u0000¢\u0006\u0002\u00088J\u0008\u00109\u001a\u000207H\u0016J\u0008\u0010:\u001a\u000207H\u0002J\u0019\u0010;\u001a\u00020\u001f2\n\u0010<\u001a\u0006\u0012\u0002\u0008\u00030=H\u0000¢\u0006\u0002\u0008>J!\u0010?\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000¢\u0006\u0002\u0008BJ\u0015\u0010C\u001a\u00020\u001f2\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010DJ\u0018\u0010G\u001a\u00020\u001f2\u000e\u0010H\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u000305H\u0002J\u0010\u0010I\u001a\u0002072\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0019\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010MH\u0000¢\u0006\u0002\u0008NJ\u0013\u0010O\u001a\u00020\u001f2\u0008\u0010H\u001a\u0004\u0018\u00010PH\u0096\u0002J\u0015\u0010Q\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\u0015\u0010R\u001a\u00020\u00062\u0006\u0010F\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00101J\u0018\u0010S\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010TJ\u0015\u0010U\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\u0008\u0010V\u001a\u00020\u0006H\u0016J\u0008\u0010W\u001a\u00020\u001fH\u0016J\u0019\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010YH\u0000¢\u0006\u0002\u0008ZJ\u001f\u0010[\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u00002\u0006\u0010F\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\\J\u001e\u0010]\u001a\u0002072\u0014\u0010^\u001a\u0010\u0012\u0006\u0008\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105H\u0016J\"\u0010_\u001a\u00020\u001f2\u0018\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010A0=H\u0002J\u001c\u0010`\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0002J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020\u0006H\u0002J\u0010\u0010c\u001a\u0002072\u0006\u0010d\u001a\u00020\u0006H\u0002J\u0017\u0010e\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010TJ!\u0010f\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000¢\u0006\u0002\u0008gJ\u0010\u0010h\u001a\u0002072\u0006\u0010i\u001a\u00020\u0006H\u0002J\u0017\u0010j\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0000¢\u0006\u0004\u0008k\u00101J\u0010\u0010l\u001a\u0002072\u0006\u0010m\u001a\u00020\u0006H\u0002J\u0017\u0010n\u001a\u00020\u001f2\u0006\u0010o\u001a\u00028\u0001H\u0000¢\u0006\u0004\u0008p\u0010DJ\u0008\u0010q\u001a\u00020rH\u0016J\u0019\u0010s\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010tH\u0000¢\u0006\u0002\u0008uR\u0014\u0010\u0011\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0013R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\u0018R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u0013R\u001a\u0010(\u001a\u0008\u0012\u0004\u0012\u00028\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010+R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006|", d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "isReadOnly", "", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "<set-?>", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class c<K, V>  implements Map<K, V>, d {

    private static final kotlin.y.u0.c.a E;
    private int[] A;
    private int[] B;
    private int C;
    private int D;
    private int a;
    private int b;
    private kotlin.y.u0.e<K> c;
    private kotlin.y.u0.f<V> v;
    private kotlin.y.u0.d<K, V> w;
    private boolean x;
    private K[] y;
    private V[] z;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    private static final class a {
        public a(g g) {
            super();
        }

        public static final int a(kotlin.y.u0.c.a c$a, int i2) {
            return a.c(i2);
        }

        public static final int b(kotlin.y.u0.c.a c$a, int i2) {
            return a.d(i2);
        }

        private final int c(int i) {
            return Integer.highestOneBit(obj2 *= 3);
        }

        private final int d(int i) {
            return obj1++;
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0010\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008\u0016J\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0007\u001a\u00020\u0008X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u00020\u0008X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\n\"\u0004\u0008\u000f\u0010\u000cR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u0018", d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", "", "initNext", "", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static class d {

        private int a;
        private int b = -1;
        private final kotlin.y.u0.c<K, V> c;
        public d(kotlin.y.u0.c<K, V> c) {
            n.f(c, "map");
            super();
            this.c = c;
            final int obj2 = -1;
            f();
        }

        public final int c() {
            return this.a;
        }

        public final int d() {
            return this.b;
        }

        public final kotlin.y.u0.c<K, V> e() {
            return this.c;
        }

        public final void f() {
            int i;
            int i2;
            while (this.a < c.d(this.c)) {
                i2 = this.a;
                if (c.e(this.c)[i2] < 0) {
                }
                this.a = i2++;
            }
        }

        public final void g(int i) {
            this.a = i;
        }

        public final void h(int i) {
            this.b = i;
        }

        public final boolean hasNext() {
            int i;
            i = this.a < c.d(this.c) ? 1 : 0;
            return i;
        }

        public final void remove() {
            int i;
            int i3 = -1;
            i = this.b != i3 ? 1 : 0;
            if (i == 0) {
            } else {
                this.c.k();
                c.g(this.c, this.b);
                this.b = i3;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Call next() before removing element from the iterator.".toString());
            throw illegalStateException;
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0008\u0012¨\u0006\u0013", d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class b extends kotlin.y.u0.c.d<K, V> implements Iterator<Map.Entry<K, V>>, a {
        public b(kotlin.y.u0.c<K, V> c) {
            n.f(c, "map");
            super(c);
        }

        public kotlin.y.u0.c.c<K, V> i() {
            if (c() >= c.d(e())) {
            } else {
                int i2 = c();
                g(i2 + 1);
                h(i2);
                c.c cVar = new c.c(e(), d());
                f();
                return cVar;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // kotlin.y.u0.c$d
        public final void j(StringBuilder stringBuilder) {
            n.f(stringBuilder, "sb");
            if (c() >= c.d(e())) {
            } else {
                int i2 = c();
                g(i2 + 1);
                h(i2);
                Object obj = c.c(e())[d()];
                final String str2 = "(this Map)";
                if (n.b(obj, e())) {
                    stringBuilder.append(str2);
                } else {
                    stringBuilder.append(obj);
                }
                stringBuilder.append('=');
                Object[] objArr2 = c.f(e());
                n.d(objArr2);
                Object obj2 = objArr2[d()];
                if (n.b(obj2, e())) {
                    stringBuilder.append(str2);
                } else {
                    stringBuilder.append(obj2);
                }
                f();
            }
            NoSuchElementException obj4 = new NoSuchElementException();
            throw obj4;
        }

        @Override // kotlin.y.u0.c$d
        public final int k() {
            int i;
            int i2;
            if (c() >= c.d(e())) {
            } else {
                int i4 = c();
                g(i4 + 1);
                h(i4);
                Object obj = c.c(e())[d()];
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = i2;
                }
                Object[] objArr2 = c.f(e());
                n.d(objArr2);
                Object obj2 = objArr2[d()];
                if (obj2 != null) {
                    i2 = obj2.hashCode();
                }
                f();
                return i ^= i2;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // kotlin.y.u0.c$d
        public Object next() {
            return i();
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000b¨\u0006\u0018", d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class c implements Map.Entry<K, V>, a {

        private final kotlin.y.u0.c<K, V> a;
        private final int b;
        public c(kotlin.y.u0.c<K, V> c, int i2) {
            n.f(c, "map");
            super();
            this.a = c;
            this.b = i2;
        }

        @Override // java.util.Map$Entry
        public boolean equals(Object object) {
            Object value;
            Object key;
            int obj3;
            if (object instanceof Map.Entry && n.b((Map.Entry)object.getKey(), getKey()) && n.b(object.getValue(), getValue())) {
                if (n.b((Map.Entry)object.getKey(), getKey())) {
                    obj3 = n.b(object.getValue(), getValue()) ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj3;
        }

        public K getKey() {
            return c.c(this.a)[this.b];
        }

        public V getValue() {
            Object[] objArr = c.f(this.a);
            n.d(objArr);
            return objArr[this.b];
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

        public V setValue(V v) {
            this.a.k();
            Object[] objArr = c.a(this.a);
            final int i = this.b;
            objArr[i] = v;
            return objArr[i];
        }

        @Override // java.util.Map$Entry
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getKey());
            stringBuilder.append('=');
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0008\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class e extends kotlin.y.u0.c.d<K, V> implements Iterator<K>, a {
        public e(kotlin.y.u0.c<K, V> c) {
            n.f(c, "map");
            super(c);
        }

        public K next() {
            if (c() >= c.d(e())) {
            } else {
                int i2 = c();
                g(i2 + 1);
                h(i2);
                f();
                return c.c(e())[d()];
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0008\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class f extends kotlin.y.u0.c.d<K, V> implements Iterator<V>, a {
        public f(kotlin.y.u0.c<K, V> c) {
            n.f(c, "map");
            super(c);
        }

        public V next() {
            if (c() >= c.d(e())) {
            } else {
                int i2 = c();
                g(i2 + 1);
                h(i2);
                Object[] objArr = c.f(e());
                n.d(objArr);
                f();
                return objArr[d()];
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.E = aVar;
    }

    public c() {
        super(8);
    }

    public c(int i) {
        super(b.a(i), 0, new int[i], new int[c.a.a(c.E, i)], 2, 0);
    }

    private c(K[] kArr, V[] v2Arr2, int[] i3Arr3, int[] i4Arr4, int i5, int i6) {
        super();
        this.y = kArr;
        this.z = v2Arr2;
        this.A = i3Arr3;
        this.B = i4Arr4;
        this.C = i5;
        this.D = i6;
        this.a = c.a.b(c.E, x());
    }

    private final int B(K k) {
        int obj2;
        if (k != 0) {
            obj2 = k.hashCode();
        } else {
            obj2 = 0;
        }
        return obj2 >>>= i2;
    }

    private final boolean D(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        int size;
        int i;
        if (collection.isEmpty()) {
            return 0;
        }
        r(collection.size());
        final Iterator obj3 = collection.iterator();
        while (obj3.hasNext()) {
            if (E((Map.Entry)obj3.next()) != 0) {
            }
            i = size;
        }
        return i;
    }

    private final boolean E(Map.Entry<? extends K, ? extends V> map$Entry) {
        int i = h(entry.getKey());
        final Object[] objArr = i();
        final int i4 = 1;
        if (i >= 0) {
            objArr[i] = entry.getValue();
            return i4;
        }
        i2 -= i4;
        if (z ^= i4 != 0) {
            objArr[i3] = entry.getValue();
            return i4;
        }
        return 0;
    }

    private final boolean F(int i) {
        int i2;
        int i3;
        int i6;
        int i4;
        int i5;
        i2 = B(this.y[i]);
        i3 = this.C;
        int[] iArr2 = this.B;
        i5 = 1;
        while (iArr2[i2] == 0) {
            if (i2 == 0) {
            } else {
            }
            i2 = i6;
            iArr2 = this.B;
            i5 = 1;
            i7 -= i5;
        }
        iArr2[i2] = i + 1;
        this.A[i] = i2;
        return i5;
    }

    private final void G(int i) {
        kotlin.y.u0.c.a aVar;
        int i2;
        int obj3;
        if (this.D > size()) {
            l();
        }
        i2 = 0;
        if (i != x()) {
            this.B = new int[i];
            this.a = c.a.b(c.E, i);
        } else {
            i.k(this.B, i2, i2, x());
        }
        while (i2 < this.D) {
            i2 = obj3;
        }
    }

    private final void I(int i) {
        int i7;
        int i2;
        int i3;
        int i6;
        int i5;
        int i9;
        int i4;
        int i8;
        int obj10;
        int i15 = 0;
        i2 = i12;
        i3 = i15;
        i7 = i;
        while (obj10 == null) {
            obj10--;
            i3++;
            i6 = this.B;
            i5 = i6[obj10];
            i9 = -1;
            if (i5 < 0) {
            } else {
            }
            i4 = i5 + -1;
            if (i19 &= i8 >= i3) {
            }
            obj10 = i16;
            this.B[i7] = i5;
            this.A[i4] = i7;
            i7 = obj10;
            i3 = i15;
            i6[i7] = i9;
        }
        this.B[i7] = i15;
    }

    private final void K(int i) {
        b.c(this.y, i);
        I(this.A[i]);
        final int i3 = -1;
        this.A[i] = i3;
        this.b = obj3 += i3;
    }

    public static final Object[] a(kotlin.y.u0.c c) {
        return c.i();
    }

    public static final Object[] c(kotlin.y.u0.c c) {
        return c.y;
    }

    public static final int d(kotlin.y.u0.c c) {
        return c.D;
    }

    public static final int[] e(kotlin.y.u0.c c) {
        return c.A;
    }

    public static final Object[] f(kotlin.y.u0.c c) {
        return c.z;
    }

    public static final void g(kotlin.y.u0.c c, int i2) {
        c.K(i2);
    }

    private final V[] i() {
        Object[] objArr = this.z;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = b.a(v());
        this.z = objArr2;
        return objArr2;
    }

    private final void l() {
        int i3;
        Object[] objArr;
        int i;
        int i2;
        Object obj;
        final Object[] objArr2 = this.z;
        i = i3;
        int i4 = this.D;
        while (i3 < i4) {
            i2 = this.y;
            i2[i] = i2[i3];
            if (this.A[i3] >= 0 && objArr2 != null) {
            }
            i3++;
            i4 = this.D;
            i2 = this.y;
            i2[i] = i2[i3];
            if (objArr2 != null) {
            }
            i++;
            objArr2[i] = objArr2[i3];
        }
        b.d(this.y, i, i4);
        if (objArr2 != null) {
            b.d(objArr2, i, this.D);
        }
        this.D = i;
    }

    private final boolean p(Map<?, ?> map) {
        boolean obj3;
        if (size() == map.size() && m(map.entrySet())) {
            obj3 = m(map.entrySet()) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    private final void q(int i) {
        int i3;
        int i2;
        String str;
        int obj3;
        if (i > v()) {
            i8 /= 2;
            if (i > i9) {
            } else {
                obj3 = i9;
            }
            this.y = b.b(this.y, obj3);
            Object[] objArr3 = this.z;
            if (objArr3 != null) {
                i2 = b.b(objArr3, obj3);
            } else {
                i2 = 0;
            }
            this.z = i2;
            int[] copyOf = Arrays.copyOf(this.A, obj3);
            n.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.A = copyOf;
            obj3 = c.a.a(c.E, obj3);
            if (obj3 > x()) {
                G(obj3);
            }
        } else {
            if (i6 -= obj3 > v()) {
                G(x());
            }
        }
    }

    private final void r(int i) {
        q(i2 += i);
    }

    private final int t(K k) {
        int i2;
        int i;
        int i3;
        int i4;
        int i5;
        boolean z;
        i2 = B(k);
        i = this.C;
        i4 = this.B[i2];
        i5 = -1;
        while (i4 == 0) {
            if (i2 == 0) {
            } else {
            }
            i2 = i3;
            i4 = this.B[i2];
            i5 = -1;
            i6--;
            i4--;
        }
        return i5;
    }

    private final int u(V v) {
        int i;
        int i2;
        i = this.D;
        int i3 = -1;
        i += i3;
        while (i >= 0) {
            i3 = -1;
            i += i3;
            Object[] objArr = this.z;
            n.d(objArr);
        }
        return i3;
    }

    private final int v() {
        return objArr.length;
    }

    private final int x() {
        return iArr.length;
    }

    public Collection<V> A() {
        kotlin.y.u0.f fVar;
        if (this.v == null) {
            fVar = new f(this);
            this.v = fVar;
        }
        return fVar;
    }

    public final kotlin.y.u0.c.e<K, V> C() {
        c.e eVar = new c.e(this);
        return eVar;
    }

    public final boolean H(Map.Entry<? extends K, ? extends V> map$Entry) {
        n.f(entry, "entry");
        k();
        int i = t(entry.getKey());
        final int i2 = 0;
        if (i < 0) {
            return i2;
        }
        Object[] objArr = this.z;
        n.d(objArr);
        int i3 = 1;
        if (obj4 ^= i3 != 0) {
            return i2;
        }
        K(i);
        return i3;
    }

    public final int J(K k) {
        k();
        int obj1 = t(k);
        if (obj1 < 0) {
            return -1;
        }
        K(obj1);
        return obj1;
    }

    public final boolean L(V v) {
        k();
        int obj1 = u(v);
        if (obj1 < 0) {
            return 0;
        }
        K(obj1);
        return 1;
    }

    public final kotlin.y.u0.c.f<K, V> M() {
        c.f fVar = new c.f(this);
        return fVar;
    }

    @Override // java.util.Map
    public void clear() {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int[] iArr2;
        k();
        i4--;
        final int i6 = 0;
        if (i5 >= 0) {
            i = i6;
            iArr = this.A;
            i3 = iArr[i];
            while (i3 >= 0) {
                this.B[i3] = i6;
                iArr[i] = -1;
                if (i != i5) {
                }
                i++;
                iArr = this.A;
                i3 = iArr[i];
            }
        }
        b.d(this.y, i6, this.D);
        Object[] objArr2 = this.z;
        if (objArr2 != null) {
            b.d(objArr2, i6, this.D);
        }
        this.b = i6;
        this.D = i6;
    }

    @Override // java.util.Map
    public boolean containsKey(Object object) {
        int obj1;
        obj1 = t(object) >= 0 ? 1 : 0;
        return obj1;
    }

    @Override // java.util.Map
    public boolean containsValue(Object object) {
        int obj1;
        obj1 = u(object) >= 0 ? 1 : 0;
        return obj1;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return w();
    }

    @Override // java.util.Map
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object != this) {
            if (object instanceof Map != null && p((Map)object)) {
                if (p((Map)object)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public V get(Object object) {
        int obj2 = t(object);
        if (obj2 < 0) {
            return 0;
        }
        final Object[] objArr = this.z;
        n.d(objArr);
        return objArr[obj2];
    }

    public final int h(K k) {
        int i2;
        int i4;
        int i3;
        int i5;
        int i6;
        boolean z;
        int i;
        k();
        while (/* condition */) {
            i5 = this.B[i2];
            i6 = 1;
            while (i5 <= 0) {
                if (i3++ > i4) {
                    break loop_2;
                } else {
                }
                if (i2 == 0) {
                } else {
                }
                i2 = i5;
                i5 = this.B[i2];
                i6 = 1;
                i8 -= i6;
            }
            if (i3++ > i4) {
            } else {
            }
            if (i2 == 0) {
            } else {
            }
            i2 = i5;
            i8 -= i6;
            G(i7 *= 2);
            i2 = B(k);
            i3 = 0;
            if (this.D < v()) {
                break;
            } else {
            }
            r(i6);
        }
        int i11 = this.D;
        int i14 = i11 + 1;
        this.D = i14;
        this.y[i11] = k;
        this.A[i11] = i2;
        this.B[i2] = i14;
        this.b = obj8 += i6;
        if (i3 > this.C) {
            this.C = i3;
        }
        return i11;
    }

    @Override // java.util.Map
    public int hashCode() {
        int i;
        int i2;
        final kotlin.y.u0.c.b bVar = s();
        i = 0;
        while (bVar.hasNext()) {
            i += i2;
        }
        return i;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    public final Map<K, V> j() {
        k();
        this.x = true;
        return this;
    }

    @Override // java.util.Map
    public final void k() {
        if (this.x) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final Set<K> keySet() {
        return y();
    }

    public final boolean m(Collection<?> collection) {
        String next;
        int i;
        n.f(collection, "m");
        Iterator obj3 = collection.iterator();
        for (Object next : obj3) {
        }
        return 1;
    }

    public final boolean n(Map.Entry<? extends K, ? extends V> map$Entry) {
        n.f(entry, "entry");
        int i = t(entry.getKey());
        if (i < 0) {
            return 0;
        }
        final Object[] objArr = this.z;
        n.d(objArr);
        return n.b(objArr[i], entry.getValue());
    }

    public V put(K k, V v2) {
        k();
        int obj3 = h(k);
        final Object[] objArr = i();
        if (obj3 < 0) {
            obj3--;
            objArr[obj3] = v2;
            return objArr[obj3];
        }
        objArr[obj3] = v2;
        return 0;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        n.f(map, "from");
        k();
        D(map.entrySet());
    }

    public V remove(Object object) {
        int obj3 = J(object);
        if (obj3 < 0) {
            return 0;
        }
        final Object[] objArr = this.z;
        n.d(objArr);
        b.c(objArr, obj3);
        return objArr[obj3];
    }

    public final kotlin.y.u0.c.b<K, V> s() {
        c.b bVar = new c.b(this);
        return bVar;
    }

    @Override // java.util.Map
    public final int size() {
        return z();
    }

    @Override // java.util.Map
    public String toString() {
        int i;
        boolean next;
        StringBuilder stringBuilder = new StringBuilder(i2 += 2);
        stringBuilder.append("{");
        kotlin.y.u0.c.b bVar = s();
        i = 0;
        while (bVar.hasNext()) {
            if (i > 0) {
            }
            bVar.j(stringBuilder);
            i++;
            stringBuilder.append(", ");
        }
        stringBuilder.append("}");
        String string = stringBuilder.toString();
        n.e(string, "sb.toString()");
        return string;
    }

    public final Collection<V> values() {
        return A();
    }

    public Set<Map.Entry<K, V>> w() {
        kotlin.y.u0.d dVar;
        if (this.w == null) {
            dVar = new d(this);
            this.w = dVar;
        }
        return dVar;
    }

    public Set<K> y() {
        kotlin.y.u0.e eVar;
        if (this.c == null) {
            eVar = new e(this);
            this.c = eVar;
        }
        return eVar;
    }

    @Override // java.util.Map
    public int z() {
        return this.b;
    }
}
