package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000T\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001\u001a?\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u001d\u0010\u0008\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0008\u000bH\u0081\u0008ø\u0001\u0000\u001a7\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u001d\u0010\u0008\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0008\u000bH\u0081\u0008ø\u0001\u0000\u001a\u0011\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0081\u0008\u001a\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0081\u0008\u001a\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u0014H\u0081\u0008¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0011\"\u0004\u0008\u0000\u0010\u00162\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u00142\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0011H\u0081\u0008¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\u0008\u0000\u0010\u0002H\u0001\u001a\u001c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\u0008\u0000\u0010\u00162\u0006\u0010\u001b\u001a\u0002H\u0016¢\u0006\u0002\u0010\u001c\u001a/\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0011\"\u0004\u0008\u0000\u0010\u00162\u0006\u0010\u001e\u001a\u00020\u00072\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0011H\u0000¢\u0006\u0002\u0010\u001f\u001a1\u0010 \u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\u0008\u0000\u0010\u0016*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00160\u00112\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\u0010#\u001a\u001e\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\u0008\u0000\u0010\u0016*\u0008\u0012\u0004\u0012\u0002H\u00160%H\u0007\u001a&\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\u0008\u0000\u0010\u0016*\u0008\u0012\u0004\u0012\u0002H\u00160%2\u0006\u0010&\u001a\u00020'H\u0007\u001a\u001f\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H\u00160\u0001\"\u0004\u0008\u0000\u0010\u0016*\u0008\u0012\u0004\u0012\u0002H\u00160)H\u0087\u0008\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006*", d2 = {"build", "", "E", "builder", "", "buildListInternal", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "checkCountOverflow", "count", "checkIndexOverflow", "index", "collectionToArray", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "createListBuilder", "listOf", "element", "(Ljava/lang/Object;)Ljava/util/List;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "shuffled", "", "random", "Ljava/util/Random;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsJVMKt {
    public static final <E> List<E> build(List<E> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return (ListBuilder)builder.build();
    }

    private static final <E> List<E> buildListInternal(int capacity, Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List listBuilder = CollectionsKt.createListBuilder(capacity);
        builderAction.invoke(listBuilder);
        return CollectionsKt.build(listBuilder);
    }

    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List listBuilder = CollectionsKt.createListBuilder();
        builderAction.invoke(listBuilder);
        return CollectionsKt.build(listBuilder);
    }

    private static final int checkCountOverflow(int count) {
        boolean apiVersionIsAtLeast;
        int i2;
        int i;
        if (count < 0) {
            if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            } else {
                CollectionsKt.throwCountOverflow();
            }
            ArithmeticException arithmeticException = new ArithmeticException("Count overflow has happened.");
            throw arithmeticException;
        }
        return count;
    }

    private static final int checkIndexOverflow(int index) {
        boolean apiVersionIsAtLeast;
        int i;
        int i2;
        if (index < 0) {
            if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            } else {
                CollectionsKt.throwIndexOverflow();
            }
            ArithmeticException arithmeticException = new ArithmeticException("Index overflow has happened.");
            throw arithmeticException;
        }
        return index;
    }

    private static final Object[] collectionToArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        return CollectionToArray.toArray(collection);
    }

    private static final <T> T[] collectionToArray(Collection<?> collection, T[] array) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(collection, array);
    }

    public static final <T> Object[] copyToArrayOfAny(T[] $this$copyToArrayOfAny, boolean isVarargs) {
        String equal;
        Object[] copyOf;
        Class<Object[]> str;
        Intrinsics.checkNotNullParameter($this$copyToArrayOfAny, "<this>");
        if (isVarargs && Intrinsics.areEqual($this$copyToArrayOfAny.getClass(), Object[].class)) {
            if (Intrinsics.areEqual($this$copyToArrayOfAny.getClass(), Object[].class)) {
                copyOf = $this$copyToArrayOfAny;
            } else {
                Intrinsics.checkNotNullExpressionValue(Arrays.copyOf($this$copyToArrayOfAny, $this$copyToArrayOfAny.length, Object[].class), "copyOf(...)");
            }
        } else {
        }
        return copyOf;
    }

    public static final <E> List<E> createListBuilder() {
        ListBuilder listBuilder = new ListBuilder(0, 1, 0);
        return (List)listBuilder;
    }

    public static final <E> List<E> createListBuilder(int capacity) {
        ListBuilder listBuilder = new ListBuilder(capacity);
        return (List)listBuilder;
    }

    public static final <T> List<T> listOf(T element) {
        final List singletonList = Collections.singletonList(element);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> $this$shuffled) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        List mutableList = CollectionsKt.toMutableList($this$shuffled);
        final int i = 0;
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> $this$shuffled, Random random) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List mutableList = CollectionsKt.toMutableList($this$shuffled);
        final int i = 0;
        Collections.shuffle(mutableList, random);
        return mutableList;
    }

    public static final <T> T[] terminateCollectionToArray(int collectionSize, T[] array) {
        int length;
        Intrinsics.checkNotNullParameter(array, "array");
        if (collectionSize < array.length) {
            array[collectionSize] = 0;
        }
        return array;
    }

    private static final <T> List<T> toList(Enumeration<T> $this$toList) {
        Intrinsics.checkNotNullParameter($this$toList, "<this>");
        java.util.ArrayList list = Collections.list($this$toList);
        Intrinsics.checkNotNullExpressionValue(list, "list(...)");
        return (List)list;
    }
}
