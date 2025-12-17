package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0010+\n\u0002\u0008\u0016\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 Q*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\u0008\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003PQRB\u000f\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\t2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0016\u0010\u001a\u001a\u00020\u000f2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J&\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u001d\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00028\u00000\"J\u0008\u0010#\u001a\u00020\u0017H\u0002J\u0008\u0010$\u001a\u00020\u0017H\u0016J\u0014\u0010%\u001a\u00020\u000f2\n\u0010&\u001a\u0006\u0012\u0002\u0008\u00030\"H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0013\u0010*\u001a\u00020\u000f2\u0008\u0010&\u001a\u0004\u0018\u00010+H\u0096\u0002J\u0016\u0010,\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010-J\u0008\u0010.\u001a\u00020\tH\u0016J\u0015\u0010/\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u0018\u00101\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0008\u00102\u001a\u00020\u000fH\u0016J\u000f\u00103\u001a\u0008\u0012\u0004\u0012\u00028\u000004H\u0096\u0002J\u0015\u00105\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00100J\u000e\u00106\u001a\u0008\u0012\u0004\u0012\u00028\u000007H\u0016J\u0016\u00106\u001a\u0008\u0012\u0004\u0012\u00028\u0000072\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0008\u00108\u001a\u00020\u0017H\u0002J\u0015\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010:\u001a\u00020\u000f2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0015\u0010;\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0002\u0010-J\u0015\u0010<\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0002\u0010-J\u0018\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0002J\u0016\u0010@\u001a\u00020\u000f2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J.\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010B\u001a\u00020\u000fH\u0002J\u001e\u0010C\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u000cH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\u0008\u0012\u0004\u0012\u0002HJ0\u000c\"\u0004\u0008\u0001\u0010J2\u000c\u0010K\u001a\u0008\u0012\u0004\u0012\u0002HJ0\u000cH\u0016¢\u0006\u0002\u0010LJ\u0008\u0010M\u001a\u00020NH\u0016J\u0008\u0010O\u001a\u00020+H\u0002R\u0016\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006S", d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initialCapacity", "", "(I)V", "backing", "", "[Ljava/lang/Object;", "isReadOnly", "", "length", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "build", "", "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacityInternal", "minCapacity", "ensureExtraCapacity", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "BuilderSubList", "Companion", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListBuilder<E>  extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {

    private static final kotlin.collections.builders.ListBuilder.Companion Companion;
    private static final kotlin.collections.builders.ListBuilder Empty;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    @Metadata(d1 = "\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0010+\n\u0002\u0008\u0016\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\u0008\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001PBA\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001e\u001a\u00020\u00132\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 H\u0016J&\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u001d\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u001dJ\u0008\u0010%\u001a\u00020\u001bH\u0002J\u0008\u0010&\u001a\u00020\u001bH\u0002J\u0008\u0010'\u001a\u00020\u001bH\u0016J\u0014\u0010(\u001a\u00020\u00132\n\u0010)\u001a\u0006\u0012\u0002\u0008\u00030*H\u0002J\u0013\u0010+\u001a\u00020\u00132\u0008\u0010)\u001a\u0004\u0018\u00010,H\u0096\u0002J\u0016\u0010-\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010.J\u0008\u0010/\u001a\u00020\u000bH\u0016J\u0015\u00100\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\u0008\u00102\u001a\u00020\u0013H\u0016J\u000f\u00103\u001a\u0008\u0012\u0004\u0012\u00028\u000104H\u0096\u0002J\u0015\u00105\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00101J\u000e\u00106\u001a\u0008\u0012\u0004\u0012\u00028\u000107H\u0016J\u0016\u00106\u001a\u0008\u0012\u0004\u0012\u00028\u0001072\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0008\u00108\u001a\u00020\u001bH\u0002J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0016\u0010:\u001a\u00020\u00132\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0015\u0010;\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010.J\u0015\u0010<\u001a\u00028\u00012\u0006\u0010\"\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010.J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0016\u0010@\u001a\u00020\u00132\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 H\u0016J.\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010B\u001a\u00020\u0013H\u0002J\u001e\u0010C\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0015\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\tH\u0016¢\u0006\u0002\u0010IJ'\u0010H\u001a\u0008\u0012\u0004\u0012\u0002HJ0\t\"\u0004\u0008\u0002\u0010J2\u000c\u0010K\u001a\u0008\u0012\u0004\u0012\u0002HJ0\tH\u0016¢\u0006\u0002\u0010LJ\u0008\u0010M\u001a\u00020NH\u0016J\u0008\u0010O\u001a\u00020,H\u0002R\u0016\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0014R\u000e\u0010\u000c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006Q", d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "", "offset", "", "length", "parent", "root", "Lkotlin/collections/builders/ListBuilder;", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isReadOnly", "", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "addAllInternal", "i", "n", "addAtInternal", "checkForComodification", "checkIsMutable", "clear", "contentEquals", "other", "", "equals", "", "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "registerModification", "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BuilderSubList extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {

        private E[] backing;
        private int length;
        private final int offset;
        private final kotlin.collections.builders.ListBuilder.BuilderSubList<E> parent;
        private final kotlin.collections.builders.ListBuilder<E> root;
        public BuilderSubList(E[] backing, int offset, int length, kotlin.collections.builders.ListBuilder.BuilderSubList<E> parent, kotlin.collections.builders.ListBuilder<E> root) {
            Intrinsics.checkNotNullParameter(backing, "backing");
            Intrinsics.checkNotNullParameter(root, "root");
            super();
            this.backing = backing;
            this.offset = offset;
            this.length = length;
            this.parent = parent;
            this.root = root;
            this.modCount = ListBuilder.access$getModCount$p$s-2084097795(this.root);
        }

        public static final Object[] access$getBacking$p(kotlin.collections.builders.ListBuilder.BuilderSubList $this) {
            return $this.backing;
        }

        public static final int access$getLength$p(kotlin.collections.builders.ListBuilder.BuilderSubList $this) {
            return $this.length;
        }

        public static final int access$getModCount$p$s1462993667(kotlin.collections.builders.ListBuilder.BuilderSubList $this) {
            return $this.modCount;
        }

        public static final int access$getOffset$p(kotlin.collections.builders.ListBuilder.BuilderSubList $this) {
            return $this.offset;
        }

        public static final kotlin.collections.builders.ListBuilder access$getRoot$p(kotlin.collections.builders.ListBuilder.BuilderSubList $this) {
            return $this.root;
        }

        private final void addAllInternal(int i, Collection<? extends E> elements, int n) {
            AbstractMutableList parent;
            registerModification();
            if (this.parent != null) {
                this.parent.addAllInternal(i, elements, n);
            } else {
                ListBuilder.access$addAllInternal(this.root, i, elements, n);
            }
            this.backing = ListBuilder.access$getBacking$p(this.root);
            this.length = length += n;
        }

        private final void addAtInternal(int i, E element) {
            AbstractMutableList parent;
            registerModification();
            if (this.parent != null) {
                this.parent.addAtInternal(i, element);
            } else {
                ListBuilder.access$addAtInternal(this.root, i, element);
            }
            this.backing = ListBuilder.access$getBacking$p(this.root);
            this.length = length++;
        }

        private final void checkForComodification() {
            if (ListBuilder.access$getModCount$p$s-2084097795(this.root) != this.modCount) {
            } else {
            }
            ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
            throw concurrentModificationException;
        }

        private final void checkIsMutable() {
            if (isReadOnly()) {
            } else {
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        private final boolean contentEquals(List<?> other) {
            return ListBuilderKt.access$subarrayContentEquals(this.backing, this.offset, this.length, other);
        }

        private final boolean isReadOnly() {
            return ListBuilder.access$isReadOnly$p(this.root);
        }

        private final void registerModification() {
            this.modCount = modCount++;
        }

        private final E removeAtInternal(int i) {
            Object atInternal;
            registerModification();
            if (this.parent != null) {
                atInternal = this.parent.removeAtInternal(i);
            } else {
                atInternal = ListBuilder.access$removeAtInternal(this.root, i);
            }
            this.length = length--;
            return atInternal;
        }

        private final void removeRangeInternal(int rangeOffset, int rangeLength) {
            AbstractMutableList parent;
            if (rangeLength > 0) {
                registerModification();
            }
            if (this.parent != null) {
                this.parent.removeRangeInternal(rangeOffset, rangeLength);
            } else {
                ListBuilder.access$removeRangeInternal(this.root, rangeOffset, rangeLength);
            }
            this.length = length -= rangeLength;
        }

        private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
            int retainOrRemoveAllInternal;
            if (this.parent != null) {
                retainOrRemoveAllInternal = this.parent.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
            } else {
                retainOrRemoveAllInternal = ListBuilder.access$retainOrRemoveAllInternal(this.root, rangeOffset, rangeLength, elements, retain);
            }
            if (retainOrRemoveAllInternal > 0) {
                registerModification();
            }
            this.length = length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }

        private final Object writeReplace() {
            if (!isReadOnly()) {
            } else {
                SerializedCollection serializedCollection = new SerializedCollection((Collection)this, 0);
                return serializedCollection;
            }
            NotSerializableException notSerializableException = new NotSerializableException("The list cannot be serialized while it is being built.");
            throw notSerializableException;
        }

        public void add(int index, E element) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            addAtInternal(offset += index, element);
        }

        public boolean add(E element) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(offset += length, element);
            return 1;
        }

        public boolean addAll(int index, Collection<? extends E> elements) {
            int i;
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            int size = elements.size();
            addAllInternal(offset += index, elements, size);
            i = size > 0 ? 1 : 0;
            return i;
        }

        public boolean addAll(Collection<? extends E> elements) {
            int i;
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            int size = elements.size();
            addAllInternal(offset += length, elements, size);
            i = size > 0 ? 1 : 0;
            return i;
        }

        @Override // kotlin.collections.AbstractMutableList
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // kotlin.collections.AbstractMutableList
        public boolean equals(Object other) {
            boolean contentEquals;
            int i;
            checkForComodification();
            if (other != this) {
                if (other instanceof List != null && contentEquals((List)other)) {
                    if (contentEquals((List)other)) {
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

        public E get(int index) {
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            return this.backing[offset += index];
        }

        @Override // kotlin.collections.AbstractMutableList
        public int getSize() {
            checkForComodification();
            return this.length;
        }

        @Override // kotlin.collections.AbstractMutableList
        public int hashCode() {
            checkForComodification();
            return ListBuilderKt.access$subarrayContentHashCode(this.backing, this.offset, this.length);
        }

        @Override // kotlin.collections.AbstractMutableList
        public int indexOf(Object element) {
            int i;
            boolean equal;
            int i2;
            checkForComodification();
            i = 0;
            while (i < this.length) {
                i++;
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractMutableList
        public boolean isEmpty() {
            int i;
            checkForComodification();
            i = this.length == 0 ? 1 : 0;
            return i;
        }

        public Iterator<E> iterator() {
            return (Iterator)listIterator(0);
        }

        @Override // kotlin.collections.AbstractMutableList
        public int lastIndexOf(Object element) {
            int i;
            boolean equal;
            int i2;
            checkForComodification();
            length--;
            while (i >= 0) {
                i--;
            }
            return -1;
        }

        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        public ListIterator<E> listIterator(int index) {
            checkForComodification();
            AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
            ListBuilder.BuilderSubList.Itr itr = new ListBuilder.BuilderSubList.Itr(this, index);
            return (ListIterator)itr;
        }

        @Override // kotlin.collections.AbstractMutableList
        public boolean remove(Object element) {
            int i;
            checkIsMutable();
            checkForComodification();
            final int indexOf = indexOf(element);
            if (indexOf >= 0) {
                remove(indexOf);
            }
            i = indexOf >= 0 ? 1 : 0;
            return i;
        }

        public boolean removeAll(Collection<? extends Object> elements) {
            int i;
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0) {
                i = 1;
            }
            return i;
        }

        public E removeAt(int index) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            return removeAtInternal(offset += index);
        }

        public boolean retainAll(Collection<? extends Object> elements) {
            int i;
            Intrinsics.checkNotNullParameter(elements, "elements");
            checkIsMutable();
            checkForComodification();
            if (retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0) {
            } else {
                i = 0;
            }
            return i;
        }

        public E set(int index, E element) {
            checkIsMutable();
            checkForComodification();
            AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
            this.backing[offset2 += index] = element;
            return this.backing[offset += index];
        }

        public List<E> subList(int fromIndex, int toIndex) {
            AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
            ListBuilder.BuilderSubList builderSubList = new ListBuilder.BuilderSubList(this.backing, offset + fromIndex, toIndex - fromIndex, this, this.root);
            return (List)builderSubList;
        }

        @Override // kotlin.collections.AbstractMutableList
        public Object[] toArray() {
            checkForComodification();
            return ArraysKt.copyOfRange(this.backing, this.offset, offset2 += length);
        }

        public <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            checkForComodification();
            if (array.length < this.length) {
                Object[] copyOfRange = Arrays.copyOfRange(this.backing, this.offset, offset3 += length4, array.getClass());
                Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
                return copyOfRange;
            }
            ArraysKt.copyInto(this.backing, array, 0, this.offset, offset4 += length5);
            return CollectionsKt.terminateCollectionToArray(this.length, array);
        }

        @Override // kotlin.collections.AbstractMutableList
        public String toString() {
            checkForComodification();
            return ListBuilderKt.access$subarrayContentToString(this.backing, this.offset, this.length, (Collection)this);
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0008\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0013J\u0008\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013J\u0008\u0010\u0016\u001a\u00020\u0006H\u0016J\u0008\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Itr implements ListIterator<E>, KMutableListIterator {

        private int expectedModCount;
        private int index;
        private int lastIndex = -1;
        private final kotlin.collections.builders.ListBuilder<E> list;
        public Itr(kotlin.collections.builders.ListBuilder<E> list, int index) {
            Intrinsics.checkNotNullParameter(list, "list");
            super();
            this.list = list;
            this.index = index;
            int i = -1;
            this.expectedModCount = ListBuilder.access$getModCount$p$s-2084097795(this.list);
        }

        private final void checkForComodification() {
            if (ListBuilder.access$getModCount$p$s-2084097795(this.list) != this.expectedModCount) {
            } else {
            }
            ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
            throw concurrentModificationException;
        }

        public void add(E element) {
            checkForComodification();
            final int index = this.index;
            this.index = index + 1;
            this.list.add(index, element);
            this.lastIndex = -1;
            this.expectedModCount = ListBuilder.access$getModCount$p$s-2084097795(this.list);
        }

        @Override // java.util.ListIterator
        public boolean hasNext() {
            int i;
            i = this.index < ListBuilder.access$getLength$p(this.list) ? 1 : 0;
            return i;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            int i;
            i = this.index > 0 ? 1 : 0;
            return i;
        }

        public E next() {
            checkForComodification();
            if (this.index >= ListBuilder.access$getLength$p(this.list)) {
            } else {
                int index2 = this.index;
                this.index = index2 + 1;
                this.lastIndex = index2;
                return ListBuilder.access$getBacking$p(this.list)[this.lastIndex];
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        public E previous() {
            checkForComodification();
            if (this.index <= 0) {
            } else {
                this.index = index2--;
                this.lastIndex = this.index;
                return ListBuilder.access$getBacking$p(this.list)[this.lastIndex];
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return index--;
        }

        @Override // java.util.ListIterator
        public void remove() {
            int i;
            checkForComodification();
            int i4 = -1;
            i = this.lastIndex != i4 ? 1 : 0;
            if (i == 0) {
            } else {
                this.list.remove(this.lastIndex);
                this.index = this.lastIndex;
                this.lastIndex = i4;
                this.expectedModCount = ListBuilder.access$getModCount$p$s-2084097795(this.list);
            }
            int i2 = 0;
            IllegalStateException $i$a$CheckListBuilder$Itr$remove$1 = new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            throw $i$a$CheckListBuilder$Itr$remove$1;
        }

        public void set(E element) {
            int i;
            checkForComodification();
            i = this.lastIndex != -1 ? 1 : 0;
            if (i == 0) {
            } else {
                this.list.set(this.lastIndex, element);
            }
            int i2 = 0;
            IllegalStateException $i$a$CheckListBuilder$Itr$set$1 = new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            throw $i$a$CheckListBuilder$Itr$set$1;
        }
    }
    static {
        ListBuilder.Companion companion = new ListBuilder.Companion(0);
        ListBuilder.Companion = companion;
        ListBuilder listBuilder = new ListBuilder(0);
        final int i3 = 0;
        list.isReadOnly = true;
        ListBuilder.Empty = listBuilder;
    }

    public ListBuilder() {
        super(0, 1, 0);
    }

    public ListBuilder(int initialCapacity) {
        super();
        this.backing = ListBuilderKt.arrayOfUninitializedElements(initialCapacity);
    }

    public ListBuilder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 10 : obj1;
        super(obj1);
    }

    public static final void access$addAllInternal(kotlin.collections.builders.ListBuilder $this, int i, Collection elements, int n) {
        $this.addAllInternal(i, elements, n);
    }

    public static final void access$addAtInternal(kotlin.collections.builders.ListBuilder $this, int i, Object element) {
        $this.addAtInternal(i, element);
    }

    public static final Object[] access$getBacking$p(kotlin.collections.builders.ListBuilder $this) {
        return $this.backing;
    }

    public static final int access$getLength$p(kotlin.collections.builders.ListBuilder $this) {
        return $this.length;
    }

    public static final int access$getModCount$p$s-2084097795(kotlin.collections.builders.ListBuilder $this) {
        return $this.modCount;
    }

    public static final boolean access$isReadOnly$p(kotlin.collections.builders.ListBuilder $this) {
        return $this.isReadOnly;
    }

    public static final Object access$removeAtInternal(kotlin.collections.builders.ListBuilder $this, int i) {
        return $this.removeAtInternal(i);
    }

    public static final void access$removeRangeInternal(kotlin.collections.builders.ListBuilder $this, int rangeOffset, int rangeLength) {
        $this.removeRangeInternal(rangeOffset, rangeLength);
    }

    public static final int access$retainOrRemoveAllInternal(kotlin.collections.builders.ListBuilder $this, int rangeOffset, int rangeLength, Collection elements, boolean retain) {
        return $this.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
    }

    private final void addAllInternal(int i, Collection<? extends E> elements, int n) {
        int j;
        Object[] backing;
        int i2;
        Object next;
        registerModification();
        insertAtInternal(i, n);
        j = 0;
        while (j < n) {
            this.backing[i + j] = elements.iterator().next();
            j++;
        }
    }

    private final void addAtInternal(int i, E element) {
        registerModification();
        insertAtInternal(i, 1);
        this.backing[i] = element;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly) {
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    private final boolean contentEquals(List<?> other) {
        return ListBuilderKt.access$subarrayContentEquals(this.backing, 0, this.length, other);
    }

    private final void ensureCapacityInternal(int minCapacity) {
        int capacity$kotlin_stdlib;
        Object[] copyOfUninitializedElements;
        if (minCapacity < 0) {
        } else {
            if (minCapacity > backing.length) {
                this.backing = ListBuilderKt.copyOfUninitializedElements(this.backing, AbstractList.Companion.newCapacity$kotlin_stdlib(backing2.length, minCapacity));
            }
        }
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
        throw outOfMemoryError;
    }

    private final void ensureExtraCapacity(int n) {
        ensureCapacityInternal(length += n);
    }

    private final void insertAtInternal(int i, int n) {
        ensureExtraCapacity(n);
        ArraysKt.copyInto(this.backing, this.backing, i + n, i, this.length);
        this.length = length += n;
    }

    private final void registerModification() {
        this.modCount = modCount++;
    }

    private final E removeAtInternal(int i) {
        registerModification();
        ArraysKt.copyInto(this.backing, this.backing, i, i + 1, this.length);
        ListBuilderKt.resetAt(this.backing, length2--);
        this.length = length--;
        return this.backing[i];
    }

    private final void removeRangeInternal(int rangeOffset, int rangeLength) {
        if (rangeLength > 0) {
            registerModification();
        }
        ArraysKt.copyInto(this.backing, this.backing, rangeOffset, rangeOffset + rangeLength, this.length);
        ListBuilderKt.resetRange(this.backing, length2 -= rangeLength, this.length);
        this.length = length -= rangeLength;
    }

    private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        int i2;
        int i3;
        Object[] contains;
        int i4;
        Object[] backing;
        int i;
        i2 = 0;
        i3 = 0;
        while (i2 < rangeLength) {
            if (elements.contains(this.backing[rangeOffset + i2]) == retain) {
            } else {
            }
            i2++;
            this.backing[i3 += rangeOffset] = this.backing[i2 += rangeOffset];
            i3 = i4;
            i2 = i;
        }
        int i6 = rangeLength - i3;
        ArraysKt.copyInto(this.backing, this.backing, rangeOffset + i3, rangeOffset + rangeLength, this.length);
        ListBuilderKt.resetRange(this.backing, length2 -= i6, this.length);
        if (i6 > 0) {
            registerModification();
        }
        this.length = length -= i6;
        return i6;
    }

    private final Object writeReplace() {
        if (!this.isReadOnly) {
        } else {
            SerializedCollection serializedCollection = new SerializedCollection((Collection)this, 0);
            return serializedCollection;
        }
        NotSerializableException notSerializableException = new NotSerializableException("The list cannot be serialized while it is being built.");
        throw notSerializableException;
    }

    public void add(int index, E element) {
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        addAtInternal(index, element);
    }

    public boolean add(E element) {
        checkIsMutable();
        addAtInternal(this.length, element);
        return 1;
    }

    public boolean addAll(int index, Collection<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        int size = elements.size();
        addAllInternal(index, elements, size);
        i = size > 0 ? 1 : 0;
        return i;
    }

    public boolean addAll(Collection<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.length, elements, size);
        i = size > 0 ? 1 : 0;
        return i;
    }

    public final List<E> build() {
        Object empty;
        checkIsMutable();
        this.isReadOnly = true;
        if (this.length > 0) {
            empty = this;
        } else {
            empty = ListBuilder.Empty;
        }
        return empty;
    }

    @Override // kotlin.collections.AbstractMutableList
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public boolean equals(Object other) {
        boolean contentEquals;
        int i;
        if (other != this) {
            if (other instanceof List != null && contentEquals((List)other)) {
                if (contentEquals((List)other)) {
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

    public E get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.backing[index];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.length;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.backing, 0, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int indexOf(Object element) {
        int i;
        boolean equal;
        i = 0;
        while (i < this.length) {
            i++;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractMutableList
    public boolean isEmpty() {
        int i;
        i = this.length == 0 ? 1 : 0;
        return i;
    }

    public Iterator<E> iterator() {
        return (Iterator)listIterator(0);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int lastIndexOf(Object element) {
        int i;
        boolean equal;
        length--;
        while (i >= 0) {
            i--;
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, this.length);
        ListBuilder.Itr itr = new ListBuilder.Itr(this, index);
        return (ListIterator)itr;
    }

    @Override // kotlin.collections.AbstractMutableList
    public boolean remove(Object element) {
        int i;
        checkIsMutable();
        final int indexOf = indexOf(element);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        i = indexOf >= 0 ? 1 : 0;
        return i;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        i = 0;
        if (retainOrRemoveAllInternal(i, this.length, elements, i) > 0) {
            i = 1;
        }
        return i;
    }

    public E removeAt(int index) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        return removeAtInternal(index);
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        final int i2 = 1;
        if (retainOrRemoveAllInternal(0, this.length, elements, i2) > 0) {
            i = i2;
        }
        return i;
    }

    public E set(int index, E element) {
        checkIsMutable();
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, this.length);
        this.backing[index] = element;
        return this.backing[index];
    }

    public List<E> subList(int fromIndex, int toIndex) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        ListBuilder.BuilderSubList builderSubList = new ListBuilder.BuilderSubList(this.backing, fromIndex, toIndex - fromIndex, 0, this);
        return (List)builderSubList;
    }

    @Override // kotlin.collections.AbstractMutableList
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }

    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        final int i = 0;
        if (array.length < this.length) {
            Object[] copyOfRange = Arrays.copyOfRange(this.backing, i, this.length, array.getClass());
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        ArraysKt.copyInto(this.backing, array, i, i, this.length);
        return CollectionsKt.terminateCollectionToArray(this.length, array);
    }

    @Override // kotlin.collections.AbstractMutableList
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.backing, 0, this.length, (Collection)this);
    }
}
