package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u0001H\u0000\u001aE\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0008\u0000\u0010\u000c\"\u0004\u0008\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\u000c2\u0006\u0010\u0010\u001a\u0002H\rH\u0002¢\u0006\u0002\u0010\u0011\u001a)\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0013\u001a)\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0013\u001aA\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u000e\u0010\u0017\u001a\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0018H\u0002¢\u0006\u0002\u0010\u0019\u001aM\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0008\u0000\u0010\u000c\"\u0004\u0008\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\u000c2\u0006\u0010\u0010\u001a\u0002H\rH\u0002¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"ENTRY_SIZE", "", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "insertEntryAtIndex", "", "", "K", "V", "keyIndex", "key", "value", "([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "removeEntryAtIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "removeNodeAtIndex", "nodeIndex", "replaceEntryWithNode", "newNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)[Ljava/lang/Object;", "replaceNodeWithEntry", "([Ljava/lang/Object;IILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TrieNodeKt {

    public static final int ENTRY_SIZE = 2;
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;
    public static final Object[] access$insertEntryAtIndex(Object[] $receiver, int keyIndex, Object key, Object value) {
        return TrieNodeKt.insertEntryAtIndex($receiver, keyIndex, key, value);
    }

    public static final Object[] access$removeEntryAtIndex(Object[] $receiver, int keyIndex) {
        return TrieNodeKt.removeEntryAtIndex($receiver, keyIndex);
    }

    public static final Object[] access$removeNodeAtIndex(Object[] $receiver, int nodeIndex) {
        return TrieNodeKt.removeNodeAtIndex($receiver, nodeIndex);
    }

    public static final Object[] access$replaceEntryWithNode(Object[] $receiver, int keyIndex, int nodeIndex, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode newNode) {
        return TrieNodeKt.replaceEntryWithNode($receiver, keyIndex, nodeIndex, newNode);
    }

    public static final Object[] access$replaceNodeWithEntry(Object[] $receiver, int nodeIndex, int keyIndex, Object key, Object value) {
        return TrieNodeKt.replaceNodeWithEntry($receiver, nodeIndex, keyIndex, key, value);
    }

    public static final int indexSegment(int index, int shift) {
        return i &= 31;
    }

    private static final <K, V> Object[] insertEntryAtIndex(Object[] $this$insertEntryAtIndex, int keyIndex, K key, V value) {
        final Object[] arr = new Object[length += 2];
        final Object[] objArr = $this$insertEntryAtIndex;
        final int i4 = keyIndex;
        ArraysKt.copyInto$default(objArr, arr, 0, 0, i4, 6, 0);
        ArraysKt.copyInto(objArr, arr, i4 + 2, i4, objArr.length);
        arr[i4] = key;
        arr[i4 + 1] = value;
        return arr;
    }

    private static final Object[] removeEntryAtIndex(Object[] $this$removeEntryAtIndex, int keyIndex) {
        final Object[] arr = new Object[length += -2];
        final Object[] objArr = $this$removeEntryAtIndex;
        final int i4 = keyIndex;
        ArraysKt.copyInto$default(objArr, arr, 0, 0, i4, 6, 0);
        ArraysKt.copyInto(objArr, arr, i4, i4 + 2, objArr.length);
        return arr;
    }

    private static final Object[] removeNodeAtIndex(Object[] $this$removeNodeAtIndex, int nodeIndex) {
        final Object[] arr = new Object[length--];
        final Object[] objArr = $this$removeNodeAtIndex;
        final int i4 = nodeIndex;
        ArraysKt.copyInto$default(objArr, arr, 0, 0, i4, 6, 0);
        ArraysKt.copyInto(objArr, arr, i4, i4 + 1, objArr.length);
        return arr;
    }

    private static final Object[] replaceEntryWithNode(Object[] $this$replaceEntryWithNode, int keyIndex, int nodeIndex, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<?, ?> newNode) {
        final int i = nodeIndex + -2;
        final Object[] arr = new Object[i2++];
        final Object[] objArr = $this$replaceEntryWithNode;
        final int i6 = keyIndex;
        ArraysKt.copyInto$default(objArr, arr, 0, 0, i6, 6, 0);
        ArraysKt.copyInto(objArr, arr, i6, i6 + 2, nodeIndex);
        arr[i] = newNode;
        ArraysKt.copyInto(objArr, arr, i + 1, nodeIndex, objArr.length);
        return arr;
    }

    private static final <K, V> Object[] replaceNodeWithEntry(Object[] $this$replaceNodeWithEntry, int nodeIndex, int keyIndex, K key, V value) {
        Object[] copyOf = Arrays.copyOf($this$replaceNodeWithEntry, length++);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        ArraysKt.copyInto(copyOf, copyOf, nodeIndex + 2, nodeIndex + 1, $this$replaceNodeWithEntry.length);
        ArraysKt.copyInto(copyOf, copyOf, keyIndex + 2, keyIndex, nodeIndex);
        copyOf[keyIndex] = key;
        copyOf[keyIndex + 1] = value;
        return copyOf;
    }
}
