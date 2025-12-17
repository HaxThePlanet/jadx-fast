package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0010\u000b\n\u0002\u0008\u001f\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0018\u0008\u0000\u0018\u0000 _*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001_B\u001f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\u0010\u0007B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ)\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0008\u0010 \u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0016\u0010'\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u0004H\u0002J#\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020$2\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u0015\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020$2\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u00102\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0002\u00083JE\u00104\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0008\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010:J=\u0010;\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0008\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010?J3\u0010@\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010AJ5\u0010B\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\u0008\u00030D¢\u0006\u0002\u0010EJ6\u0010F\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\u0008\u00030DJ+\u0010I\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010JJ'\u0010K\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\u0008\u00030DH\u0002¢\u0006\u0002\u0010LJ,\u0010M\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J'\u0010N\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\u0008\u00030DH\u0002¢\u0006\u0002\u0010LJ(\u0010O\u001a\u0004\u0018\u00010\u00022\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J\u001e\u0010P\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J(\u0010Q\u001a\u0004\u0018\u00010\u00022\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J;\u0010R\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010?J5\u0010S\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\u0008\u00030D¢\u0006\u0002\u0010EJ2\u0010T\u001a\u0004\u0018\u00010\u00022\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\u0008\u00030DJ&\u0010U\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J2\u0010W\u001a\u0004\u0018\u00010\u00022\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\u0008\u00030DJ,\u0010X\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\u000c\u0010Z\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00109\u001a\u00020\tH\u0002J\u0016\u0010[\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002J)\u0010\\\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u001e\u0010]\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J$\u0010^\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\u000c\u0010Z\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001c\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017¨\u0006`", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "E", "", "bitmap", "", "buffer", "", "(I[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "add", "elementHash", "element", "shift", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "addElementAt", "positionMask", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "calculateSize", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionContainsElement", "", "(Ljava/lang/Object;)Z", "collisionRemove", "collisionRemoveElementAtIndex", "i", "contains", "(ILjava/lang/Object;I)Z", "containsAll", "otherNode", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "elementsIdentityEquals", "hasNoCellAt", "indexOfCellAt", "indexOfCellAt$runtime_release", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "owner", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddAll", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableAddElementAt", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAddAll", "mutableCollisionRemove", "mutableCollisionRemoveAll", "mutableCollisionRemoveElementAtIndex", "mutableCollisionRetainAll", "mutableMoveElementToNode", "mutableRemove", "mutableRemoveAll", "mutableRemoveCellAtIndex", "cellIndex", "mutableRetainAll", "mutableUpdateNodeAtIndex", "nodeIndex", "newNode", "nodeAtIndex", "remove", "removeCellAtIndex", "updateNodeAtIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrieNode<E>  {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.Companion Companion;
    private static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode EMPTY;
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode getEMPTY$runtime_release() {
            return TrieNode.access$getEMPTY$cp();
        }
    }
    static {
        TrieNode.Companion companion = new TrieNode.Companion(0);
        TrieNode.Companion = companion;
        int i = 8;
        int i3 = 0;
        final int i4 = 0;
        TrieNode trieNode = new TrieNode(i4, new Object[i4]);
        TrieNode.EMPTY = trieNode;
    }

    public TrieNode(int bitmap, Object[] buffer) {
        super(bitmap, buffer, 0);
    }

    public TrieNode(int bitmap, Object[] buffer, MutabilityOwnership ownedBy) {
        super();
        this.bitmap = bitmap;
        this.buffer = buffer;
        this.ownedBy = ownedBy;
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode access$getEMPTY$cp() {
        return TrieNode.EMPTY;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> addElementAt(int positionMask, E element) {
        TrieNode trieNode = new TrieNode(bitmap |= positionMask, TrieNodeKt.access$addElementAtIndex(this.buffer, indexOfCellAt$runtime_release(positionMask), element));
        return trieNode;
    }

    private final int calculateSize() {
        int result;
        int i;
        Object obj;
        int size;
        if (this.bitmap == null) {
            return buffer.length;
        }
        result = 0;
        final Object[] buffer2 = this.buffer;
        i = 0;
        while (i < buffer2.length) {
            obj = buffer2[i];
            if (obj instanceof TrieNode) {
            } else {
            }
            size = 1;
            result += size;
            i++;
            size = (TrieNode)obj.calculateSize();
        }
        return result;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> collisionAdd(E element) {
        if (collisionContainsElement(element)) {
            return this;
        }
        final int i = 0;
        TrieNode trieNode = new TrieNode(i, TrieNodeKt.access$addElementAtIndex(this.buffer, i, element));
        return trieNode;
    }

    private final boolean collisionContainsElement(E element) {
        return ArraysKt.contains(this.buffer, element);
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> collisionRemove(E element) {
        int indexOf = ArraysKt.indexOf(this.buffer, element);
        if (indexOf != -1) {
            return collisionRemoveElementAtIndex(indexOf);
        }
        return this;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> collisionRemoveElementAtIndex(int i) {
        TrieNode trieNode = new TrieNode(0, TrieNodeKt.access$removeCellAtIndex(this.buffer, i));
        return trieNode;
    }

    private final E elementAtIndex(int index) {
        return this.buffer[index];
    }

    private final boolean elementsIdentityEquals(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> otherNode) {
        int i;
        Object obj2;
        Object obj;
        final int i2 = 1;
        if (this == otherNode) {
            return i2;
        }
        final int i3 = 0;
        if (this.bitmap != otherNode.bitmap) {
            return i3;
        }
        i = 0;
        while (i < buffer.length) {
            i++;
        }
        return i2;
    }

    private final boolean hasNoCellAt(int positionMask) {
        int i;
        i = bitmap &= positionMask == 0 ? 1 : 0;
        return i;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> makeNode(int elementHash1, E element1, int elementHash2, E element2, int shift, MutabilityOwnership owner) {
        Object[] arr;
        final int i11 = shift;
        final MutabilityOwnership mutabilityOwnership = owner;
        int i3 = 0;
        if (i11 > 30) {
            TrieNode trieNode2 = new TrieNode(i3, /* result */, mutabilityOwnership);
            return trieNode2;
        }
        final int indexSegment = TrieNodeKt.indexSegment(elementHash1, i11);
        final int indexSegment2 = TrieNodeKt.indexSegment(elementHash2, i11);
        final int i12 = 1;
        if (indexSegment != indexSegment2) {
            int i2 = 2;
            if (indexSegment < indexSegment2) {
                arr = new Object[i2];
                arr[i3] = element1;
                arr[i12] = element2;
            } else {
                arr = new Object[i2];
                arr[i3] = element2;
                arr[i12] = element1;
            }
            TrieNode trieNode3 = new TrieNode(i6 |= i9, arr, mutabilityOwnership);
            return trieNode3;
        }
        TrieNode trieNode = new TrieNode(i12 << indexSegment, /* result */, mutabilityOwnership);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> makeNodeAtIndex(int elementIndex, int newElementHash, E newElement, int shift, MutabilityOwnership owner) {
        int i;
        final Object elementAtIndex = elementAtIndex(elementIndex);
        if (elementAtIndex != null) {
            i = elementAtIndex.hashCode();
        } else {
            i = 0;
        }
        return this.makeNode(i, elementAtIndex, newElementHash, newElement, shift + 5, owner);
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> moveElementToNode(int elementIndex, int newElementHash, E newElement, int shift) {
        Object[] buffer = this.buffer;
        Object[] copyOf = Arrays.copyOf(buffer, buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        Object obj = this;
        final int i = elementIndex;
        copyOf[i] = obj.makeNodeAtIndex(i, newElementHash, newElement, shift, 0);
        TrieNode obj8 = new TrieNode(obj.bitmap, copyOf);
        return obj8;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableAddElementAt(int positionMask, E element, MutabilityOwnership owner) {
        final int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(positionMask);
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.access$addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, element);
            this.bitmap = bitmap |= positionMask;
            return this;
        }
        TrieNode trieNode = new TrieNode(bitmap2 |= positionMask, TrieNodeKt.access$addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, element), owner);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableCollisionAdd(E element, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> mutator) {
        if (collisionContainsElement(element)) {
            return this;
        }
        mutator.setSize(size++);
        final int i2 = 0;
        if (this.ownedBy == mutator.getOwnership$runtime_release()) {
            this.buffer = TrieNodeKt.access$addElementAtIndex(this.buffer, i2, element);
            return this;
        }
        TrieNode trieNode = new TrieNode(i2, TrieNodeKt.access$addElementAtIndex(this.buffer, i2, element), mutator.getOwnership$runtime_release());
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableCollisionAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        Object trieNode;
        Object[] copyOf;
        int i$iv;
        int j$iv;
        int i2;
        int i3;
        Object obj;
        int i;
        Object obj2;
        int length;
        boolean collisionContainsElement;
        final Object obj3 = this;
        final Object obj4 = otherNode;
        final Object obj5 = intersectionSizeRef;
        final Object obj6 = owner;
        if (obj3 == obj4) {
            obj5.plusAssign(buffer.length);
            return obj3;
        }
        Object[] copyOf2 = Arrays.copyOf(obj3.buffer, length3 += length4);
        String str = "copyOf(this, newSize)";
        Intrinsics.checkNotNullExpressionValue(copyOf2, str);
        Object[] buffer5 = obj4.buffer;
        int length6 = buffer7.length;
        final int i7 = 0;
        i$iv = 0;
        j$iv = 0;
        i3 = 0;
        while (i$iv < buffer5.length) {
            i2 = 1;
            if (j$iv <= i$iv) {
            } else {
            }
            i = i3;
            CommonFunctionsKt.assert(i);
            length = 0;
            copyOf2[length6 + j$iv] = buffer5[i$iv];
            if (!obj3.collisionContainsElement(buffer5[i$iv]) && length6 + j$iv <= copyOf2.length) {
            }
            i$iv++;
            i3 = 0;
            copyOf2[length6 + j$iv] = buffer5[i$iv];
            if (length6 + j$iv <= copyOf2.length) {
            }
            CommonFunctionsKt.assert(i3);
            i3 = i2;
            i = i2;
        }
        length5 += j$iv;
        obj5.plusAssign(length7 -= i5);
        if (i5 == buffer8.length) {
            return obj3;
        }
        if (i5 == buffer9.length) {
            return obj4;
        }
        if (i5 == copyOf2.length) {
            copyOf = copyOf2;
        } else {
            Intrinsics.checkNotNullExpressionValue(Arrays.copyOf(copyOf2, i5), str);
        }
        if (Intrinsics.areEqual(obj3.ownedBy, obj6)) {
            obj3.buffer = copyOf;
            trieNode = obj3;
        } else {
            trieNode = new TrieNode(i3, copyOf, obj6);
        }
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableCollisionRemove(E element, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> mutator) {
        int indexOf = ArraysKt.indexOf(this.buffer, element);
        int i = -1;
        if (indexOf != i) {
            mutator.setSize(size += i);
            return mutableCollisionRemoveElementAtIndex(indexOf, mutator.getOwnership$runtime_release());
        }
        return this;
    }

    private final Object mutableCollisionRemoveAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        Object[] buffer;
        Object trieNode;
        int copyOf;
        int str;
        int i$iv;
        int j$iv;
        Object obj;
        int i3;
        int i;
        int i2;
        Object obj2;
        int length;
        boolean collisionContainsElement;
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(buffer2.length);
            return TrieNode.EMPTY;
        }
        if (Intrinsics.areEqual(owner, this.ownedBy)) {
            buffer = this.buffer;
        } else {
            buffer = new Object[buffer3.length];
        }
        Object[] buffer4 = this.buffer;
        copyOf = 0;
        str = 0;
        i$iv = 0;
        j$iv = 0;
        i = 0;
        i2 = 1;
        while (i$iv < buffer4.length) {
            if (j$iv <= i$iv) {
            } else {
            }
            i3 = i;
            CommonFunctionsKt.assert(i3);
            length = 0;
            buffer[copyOf + j$iv] = buffer4[i$iv];
            if (!otherNode.collisionContainsElement(buffer4[i$iv]) && copyOf + j$iv <= buffer.length) {
            }
            i$iv++;
            i = 0;
            i2 = 1;
            buffer[copyOf + j$iv] = buffer4[i$iv];
            if (copyOf + j$iv <= buffer.length) {
            }
            CommonFunctionsKt.assert(i);
            i = i2;
            i3 = i2;
        }
        intersectionSizeRef.plusAssign(length4 -= j$iv);
        if (j$iv == 0) {
            trieNode = TrieNode.EMPTY;
        } else {
            if (j$iv == i2) {
                trieNode = buffer[i];
            } else {
                if (j$iv == buffer6.length) {
                    trieNode = this;
                } else {
                    if (j$iv == buffer.length) {
                        trieNode = new TrieNode(i, buffer, owner);
                    } else {
                        copyOf = Arrays.copyOf(buffer, j$iv);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        trieNode = new TrieNode(i, copyOf, owner);
                    }
                }
            }
        }
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableCollisionRemoveElementAtIndex(int i, MutabilityOwnership owner) {
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.access$removeCellAtIndex(this.buffer, i);
            return this;
        }
        TrieNode trieNode = new TrieNode(0, TrieNodeKt.access$removeCellAtIndex(this.buffer, i), owner);
        return trieNode;
    }

    private final Object mutableCollisionRetainAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        Object[] buffer;
        int length2;
        Object trieNode;
        int copyOf;
        int str;
        int i$iv;
        int j$iv;
        Object obj;
        int i2;
        int i;
        int i3;
        boolean it;
        int length;
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(buffer2.length);
            return this;
        }
        if (Intrinsics.areEqual(owner, this.ownedBy)) {
            buffer = this.buffer;
        } else {
            buffer = new Object[Math.min(buffer3.length, buffer4.length)];
        }
        Object[] buffer5 = this.buffer;
        copyOf = 0;
        str = 0;
        i$iv = 0;
        j$iv = 0;
        i = 0;
        i3 = 1;
        while (i$iv < buffer5.length) {
            if (j$iv <= i$iv) {
            } else {
            }
            i2 = i;
            CommonFunctionsKt.assert(i2);
            length = 0;
            buffer[copyOf + j$iv] = buffer5[i$iv];
            if (otherNode.collisionContainsElement(buffer5[i$iv]) && copyOf + j$iv <= buffer.length) {
            }
            i$iv++;
            i = 0;
            i3 = 1;
            buffer[copyOf + j$iv] = buffer5[i$iv];
            if (copyOf + j$iv <= buffer.length) {
            }
            CommonFunctionsKt.assert(i);
            i = i3;
            i2 = i3;
        }
        intersectionSizeRef.plusAssign(j$iv);
        if (j$iv == 0) {
            trieNode = TrieNode.EMPTY;
        } else {
            if (j$iv == i3) {
                trieNode = buffer[i];
            } else {
                if (j$iv == buffer6.length) {
                    trieNode = this;
                } else {
                    if (j$iv == buffer7.length) {
                        trieNode = otherNode;
                    } else {
                        if (j$iv == buffer.length) {
                            trieNode = new TrieNode(i, buffer, owner);
                        } else {
                            copyOf = Arrays.copyOf(buffer, j$iv);
                            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                            trieNode = new TrieNode(i, copyOf, owner);
                        }
                    }
                }
            }
        }
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableMoveElementToNode(int elementIndex, int newElementHash, E newElement, int shift, MutabilityOwnership owner) {
        if (this.ownedBy == owner) {
            MutabilityOwnership mutabilityOwnership = owner;
            int obj9 = shift;
            Object obj8 = newElement;
            int obj7 = newElementHash;
            this.buffer[elementIndex] = makeNodeAtIndex(elementIndex, newElementHash, newElement, shift, owner);
            return this;
        }
        MutabilityOwnership owner2 = owner;
        Object[] buffer2 = obj5.buffer;
        Object[] copyOf = Arrays.copyOf(buffer2, buffer2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        int obj5 = obj6;
        int obj6 = obj7;
        obj7 = obj8;
        obj8 = obj9;
        obj9 = obj8;
        obj8 = obj7;
        obj7 = obj6;
        copyOf[obj5] = makeNodeAtIndex(obj5, obj6, obj7, obj8, owner2);
        TrieNode trieNode = new TrieNode(obj5.bitmap, copyOf, owner2);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableRemoveCellAtIndex(int cellIndex, int positionMask, MutabilityOwnership owner) {
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.access$removeCellAtIndex(this.buffer, cellIndex);
            this.bitmap = bitmap ^= positionMask;
            return this;
        }
        TrieNode trieNode = new TrieNode(bitmap2 ^= positionMask, TrieNodeKt.access$removeCellAtIndex(this.buffer, cellIndex), owner);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableUpdateNodeAtIndex(int nodeIndex, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> newNode, MutabilityOwnership owner) {
        Object cell;
        int length2;
        boolean length;
        int i = 0;
        final Object[] buffer = newNode.buffer;
        int i2 = 1;
        length2 = 0;
        if (buffer.length == i2 && !obj instanceof TrieNode) {
            length2 = 0;
            if (!obj instanceof TrieNode) {
                if (buffer4.length == i2) {
                    newNode.bitmap = this.bitmap;
                    return newNode;
                }
                cell = buffer[length2];
            } else {
                cell = newNode;
            }
        } else {
        }
        if (this.ownedBy == owner) {
            this.buffer[nodeIndex] = cell;
            return this;
        }
        Object[] buffer3 = this.buffer;
        Object[] copyOf = Arrays.copyOf(buffer3, buffer3.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[nodeIndex] = cell;
        TrieNode trieNode = new TrieNode(this.bitmap, copyOf, owner);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> nodeAtIndex(int index) {
        Object obj = this.buffer[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode)obj;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> removeCellAtIndex(int cellIndex, int positionMask) {
        TrieNode trieNode = new TrieNode(bitmap ^= positionMask, TrieNodeKt.access$removeCellAtIndex(this.buffer, cellIndex));
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> updateNodeAtIndex(int nodeIndex, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> newNode) {
        Object cell;
        int length2;
        boolean length;
        int i = 0;
        final Object[] buffer = newNode.buffer;
        int i2 = 1;
        length2 = 0;
        if (buffer.length == i2 && !obj instanceof TrieNode) {
            length2 = 0;
            if (!obj instanceof TrieNode) {
                if (buffer3.length == i2) {
                    newNode.bitmap = this.bitmap;
                    return newNode;
                }
                cell = buffer[length2];
            } else {
                cell = newNode;
            }
        } else {
        }
        Object[] buffer2 = this.buffer;
        Object[] copyOf = Arrays.copyOf(buffer2, buffer2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[nodeIndex] = cell;
        TrieNode trieNode = new TrieNode(this.bitmap, copyOf);
        return trieNode;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> add(int elementHash, E element, int shift) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode collisionAdd;
        i <<= indexSegment;
        if (hasNoCellAt(i2)) {
            return addElementAt(i2, element);
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i2);
        if (obj instanceof TrieNode) {
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (shift == 30) {
                collisionAdd = nodeAtIndex.collisionAdd(element);
            } else {
                collisionAdd = nodeAtIndex.add(elementHash, element, shift + 5);
            }
            if (nodeAtIndex == collisionAdd) {
                return this;
            }
            return updateNodeAtIndex(indexOfCellAt$runtime_release, collisionAdd);
        }
        if (Intrinsics.areEqual(element, this.buffer[indexOfCellAt$runtime_release])) {
            return this;
        }
        return moveElementToNode(indexOfCellAt$runtime_release, elementHash, element, shift);
    }

    public final boolean contains(int elementHash, E element, int shift) {
        i <<= indexSegment;
        if (hasNoCellAt(i2)) {
            return 0;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i2);
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        if (obj instanceof TrieNode && shift == 30) {
            nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (shift == 30) {
                return nodeAtIndex.collisionContainsElement(element);
            }
            return nodeAtIndex.contains(elementHash, element, shift + 5);
        }
        return Intrinsics.areEqual(element, this.buffer[indexOfCellAt$runtime_release]);
    }

    public final boolean containsAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> otherNode, int shift) {
        Object obj2;
        boolean contains;
        Object obj;
        int i4;
        int i2;
        int i3;
        int i;
        int mask$iv;
        Object obj5;
        int index$iv;
        boolean it;
        int i7;
        Object[] buffer;
        int indexOfCellAt$runtime_release;
        int indexOfCellAt$runtime_release2;
        Object obj3;
        int i6;
        int i5;
        boolean z;
        Object obj4;
        obj2 = this;
        obj = otherNode;
        if (obj2 == obj) {
            return 1;
        }
        i3 = 0;
        if (shift > 30) {
            Object[] buffer3 = obj.buffer;
            int i10 = 0;
            i = i3;
            while (i < buffer3.length) {
                i7 = 0;
                i++;
            }
            return i2;
        }
        bitmap &= bitmap2;
        if (i9 != obj.bitmap) {
            return i3;
        }
        int i12 = 0;
        mask$iv = i11;
        index$iv = 0;
        while (mask$iv != 0) {
            it = Integer.lowestOneBit(mask$iv);
            i7 = it;
            buffer = 0;
            obj3 = obj2.buffer[obj2.indexOfCellAt$runtime_release(i7)];
            Object obj10 = obj.buffer[obj.indexOfCellAt$runtime_release(i7)];
            i5 = i3;
            boolean z3 = obj3 instanceof TrieNode;
            z = z2;
            String otherIsNode = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>";
            index$iv++;
            mask$iv ^= it;
            obj2 = this;
            obj = otherNode;
            i4 = shift;
            i2 = i6;
            i3 = i5;
            Intrinsics.checkNotNull(obj3, otherIsNode);
            Object obj8 = obj3;
            if (obj10 != null) {
            } else {
            }
            obj = i5;
            obj = obj10.hashCode();
            Intrinsics.checkNotNull(obj3, otherIsNode);
            obj4 = obj3;
            Intrinsics.checkNotNull(obj10, otherIsNode);
            Object obj6 = obj10;
        }
        return i2;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final int indexOfCellAt$runtime_release(int positionMask) {
        return Integer.bitCount(bitmap &= i2);
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableAdd(int elementHash, E element, int shift, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> mutator) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode mutableCollisionAdd;
        int i2 = 1;
        int i = i2 << indexSegment;
        if (hasNoCellAt(i)) {
            mutator.setSize(size2 += i2);
            return mutableAddElementAt(i, element, mutator.getOwnership$runtime_release());
        }
        final int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i);
        if (obj instanceof TrieNode) {
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (shift == 30) {
                mutableCollisionAdd = nodeAtIndex.mutableCollisionAdd(element, mutator);
            } else {
                mutableCollisionAdd = nodeAtIndex.mutableAdd(elementHash, element, shift + 5, mutator);
            }
            if (nodeAtIndex == mutableCollisionAdd) {
                return this;
            }
            return mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, mutableCollisionAdd, mutator.getOwnership$runtime_release());
        }
        if (Intrinsics.areEqual(element, this.buffer[indexOfCellAt$runtime_release])) {
            return this;
        }
        mutator.setSize(size += i2);
        return this.mutableMoveElementToNode(indexOfCellAt$runtime_release, elementHash, element, shift, mutator.getOwnership$runtime_release());
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> otherNode, int shift, DeltaCounter intersectionSizeRef, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> mutator) {
        Object oldSize;
        int i3;
        Object trieNode;
        int positionMask;
        int positionMask2;
        int size;
        int size2;
        Object obj2;
        int bitmap;
        MutabilityOwnership ownership$runtime_release;
        int otherIsNode;
        MutabilityOwnership thisCell;
        Object obj;
        boolean z;
        boolean ownership$runtime_release2;
        int mask$iv;
        int index$iv;
        int lowestOneBit;
        int i2;
        int i;
        int indexOfCellAt$runtime_release2;
        int indexOfCellAt$runtime_release;
        int positionMask3;
        Object[] objArr;
        boolean thisIsNode;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode set;
        oldSize = this;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode set2 = otherNode;
        final int i7 = shift;
        final DeltaCounter deltaCounter = intersectionSizeRef;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder set3 = mutator;
        if (oldSize == set2) {
            deltaCounter.setCount(count3 += size5);
            return oldSize;
        }
        if (i7 > 30) {
            return oldSize.mutableCollisionAddAll(set2, deltaCounter, set3.getOwnership$runtime_release());
        }
        final int i8 = bitmap2 | ownership$runtime_release;
        if (i8 == oldSize.bitmap && Intrinsics.areEqual(oldSize.ownedBy, set3.getOwnership$runtime_release())) {
            if (Intrinsics.areEqual(oldSize.ownedBy, set3.getOwnership$runtime_release())) {
                trieNode = oldSize;
            } else {
                trieNode = new TrieNode(i8, new Object[Integer.bitCount(i8)], set3.getOwnership$runtime_release());
            }
        } else {
        }
        final Object obj10 = trieNode;
        final int i10 = 0;
        mask$iv = positionMask;
        index$iv = otherIsNode;
        while (mask$iv != 0) {
            lowestOneBit = Integer.lowestOneBit(mask$iv);
            positionMask = lowestOneBit;
            i = 0;
            indexOfCellAt$runtime_release2 = oldSize.indexOfCellAt$runtime_release(positionMask);
            indexOfCellAt$runtime_release = set2.indexOfCellAt$runtime_release(positionMask);
            otherIsNode = obj10.buffer;
            if (oldSize.hasNoCellAt(positionMask)) {
            } else {
            }
            if (set2.hasNoCellAt(positionMask)) {
            } else {
            }
            thisCell = oldSize.buffer[indexOfCellAt$runtime_release2];
            obj = set2.buffer[indexOfCellAt$runtime_release];
            z = thisCell instanceof TrieNode;
            ownership$runtime_release2 = obj instanceof TrieNode;
            String str = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>";
            if (z && ownership$runtime_release2) {
            } else {
            }
            positionMask3 = positionMask;
            objArr = otherIsNode;
            if (z) {
            } else {
            }
            thisIsNode = z;
            if (ownership$runtime_release2) {
            } else {
            }
            if (Intrinsics.areEqual(thisCell, obj)) {
            } else {
            }
            if (thisCell != null) {
            } else {
            }
            i3 = positionMask2;
            if (obj != null) {
            }
            set = z2;
            thisCell = this.makeNode(i3, thisCell, positionMask2, obj, i7 + 5, set3.getOwnership$runtime_release());
            objArr[index$iv] = thisCell;
            index$iv++;
            mask$iv ^= lowestOneBit;
            positionMask2 = obj.hashCode();
            i3 = thisCell.hashCode();
            Object obj7 = thisCell;
            positionMask = 0;
            deltaCounter.setCount(count4++);
            Unit it = Unit.INSTANCE;
            oldSize = this;
            Intrinsics.checkNotNull(obj, str);
            Object obj6 = obj;
            if (thisCell != null) {
            }
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode mutableAdd2 = (TrieNode)obj.mutableAdd(positionMask2, thisCell, i7 + 5, set3);
            otherIsNode = mutableAdd2;
            z = 0;
            if (set3.size() == set3.size()) {
            }
            positionMask = Unit.INSTANCE;
            oldSize = this;
            thisCell = set;
            deltaCounter.setCount(count2++);
            positionMask2 = thisCell.hashCode();
            Intrinsics.checkNotNull(thisCell, str);
            Object obj5 = thisCell;
            if (obj != null) {
            }
            thisIsNode = z;
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode mutableAdd = (TrieNode)thisCell.mutableAdd(positionMask2, obj, i7 + 5, set3);
            otherIsNode = mutableAdd;
            z = 0;
            if (set3.size() == set3.size()) {
            }
            positionMask = Unit.INSTANCE;
            oldSize = this;
            thisCell = set;
            deltaCounter.setCount(count++);
            positionMask2 = obj.hashCode();
            if (ownership$runtime_release2) {
            } else {
            }
            Intrinsics.checkNotNull(thisCell, str);
            Object obj11 = thisCell;
            Intrinsics.checkNotNull(obj, str);
            Object obj3 = obj;
            positionMask3 = positionMask;
            objArr = otherIsNode;
            thisCell = mutableAddAll;
            oldSize = this;
            thisCell = oldSize.buffer[indexOfCellAt$runtime_release2];
            positionMask3 = positionMask;
            objArr = otherIsNode;
            thisCell = set2.buffer[indexOfCellAt$runtime_release];
            positionMask3 = positionMask;
            objArr = otherIsNode;
        }
        obj2 = oldSize.elementsIdentityEquals(obj10) ? oldSize : elementsIdentityEquals2 ? set2 : obj10;
        return obj2;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableRemove(int elementHash, E element, int shift, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> mutator) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode mutableCollisionRemove;
        i <<= indexSegment;
        if (hasNoCellAt(i2)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i2);
        if (obj instanceof TrieNode) {
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (shift == 30) {
                mutableCollisionRemove = nodeAtIndex.mutableCollisionRemove(element, mutator);
            } else {
                mutableCollisionRemove = nodeAtIndex.mutableRemove(elementHash, element, shift + 5, mutator);
            }
            if (this.ownedBy != mutator.getOwnership$runtime_release() && nodeAtIndex != mutableCollisionRemove) {
                if (nodeAtIndex != mutableCollisionRemove) {
                }
                return this;
            }
            return mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, mutableCollisionRemove, mutator.getOwnership$runtime_release());
        }
        if (Intrinsics.areEqual(element, this.buffer[indexOfCellAt$runtime_release])) {
            mutator.setSize(size--);
            return mutableRemoveCellAtIndex(indexOfCellAt$runtime_release, i2, mutator.getOwnership$runtime_release());
        }
        return this;
    }

    public final Object mutableRemoveAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> otherNode, int shift, DeltaCounter intersectionSizeRef, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> mutator) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode set;
        Object oldSize;
        boolean contains;
        int i4;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode eMPTY;
        Object realBuffer;
        int removalBitmap;
        Object trieNode;
        int ownership$runtime_release;
        int realBitMap;
        Object[] copyOf;
        int ownership$runtime_release3;
        int $this$forEachOneBit$iv;
        int i3;
        int i6;
        MutabilityOwnership ownership$runtime_release2;
        int $i$f$forEachOneBit2;
        int mask$iv;
        int index$iv;
        int j$iv;
        int length;
        int i2;
        int lowestOneBit;
        int i;
        int companion;
        int indexOfCellAt$runtime_release;
        int indexOfCellAt$runtime_release2;
        Object obj;
        int i5;
        boolean z;
        boolean z2;
        int removalBitmap2;
        int i7;
        int $i$f$forEachOneBit;
        final Object obj2 = this;
        set = otherNode;
        final DeltaCounter deltaCounter = intersectionSizeRef;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder set2 = mutator;
        if (obj2 == set) {
            deltaCounter.plusAssign(obj2.calculateSize());
            return TrieNode.EMPTY;
        }
        if (shift > 30) {
            return obj2.mutableCollisionRemoveAll(set, deltaCounter, set2.getOwnership$runtime_release());
        }
        bitmap2 &= bitmap3;
        if (removalBitmap == null) {
            return obj2;
        }
        if (Intrinsics.areEqual(obj2.ownedBy, set2.getOwnership$runtime_release())) {
            trieNode = obj2;
        } else {
            Object[] buffer7 = obj2.buffer;
            copyOf = Arrays.copyOf(buffer7, buffer7.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            trieNode = new TrieNode(obj2.bitmap, copyOf, set2.getOwnership$runtime_release());
        }
        int i9 = 0;
        realBitMap = obj2.bitmap;
        $i$f$forEachOneBit2 = 0;
        mask$iv = ownership$runtime_release3;
        index$iv = 0;
        while (mask$iv != 0) {
            lowestOneBit = Integer.lowestOneBit(mask$iv);
            i = lowestOneBit;
            companion = 0;
            indexOfCellAt$runtime_release = obj2.indexOfCellAt$runtime_release(i);
            obj = 0;
            i5 = 0;
            length = j$iv.buffer[indexOfCellAt$runtime_release];
            Object obj8 = set.buffer[set.indexOfCellAt$runtime_release(i)];
            z = z3;
            z2 = thisIsNode;
            String otherIsNode = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>";
            if (z && z2) {
            } else {
            }
            removalBitmap2 = removalBitmap;
            i7 = ownership$runtime_release3;
            if (z) {
            } else {
            }
            $i$f$forEachOneBit = $i$f$forEachOneBit2;
            if (z2) {
            } else {
            }
            if (Intrinsics.areEqual(length, obj8)) {
            } else {
            }
            oldSize = length;
            if (oldSize == TrieNode.EMPTY) {
            }
            trieNode.buffer[indexOfCellAt$runtime_release] = oldSize;
            index$iv++;
            mask$iv ^= lowestOneBit;
            set = otherNode;
            i4 = shift;
            removalBitmap = removalBitmap2;
            ownership$runtime_release3 = i7;
            $i$f$forEachOneBit2 = $i$f$forEachOneBit;
            realBitMap = eMPTY;
            deltaCounter.plusAssign(1);
            oldSize = TrieNode.EMPTY;
            Intrinsics.checkNotNull(obj8, otherIsNode);
            Object obj5 = obj8;
            if (length != null) {
            } else {
            }
            removalBitmap = obj;
            if ((TrieNode)obj8.contains(removalBitmap, length, shift + 5)) {
            } else {
            }
            deltaCounter.plusAssign(1);
            oldSize = TrieNode.EMPTY;
            removalBitmap = length.hashCode();
            Intrinsics.checkNotNull(length, otherIsNode);
            Object obj7 = length;
            if (obj8 != null) {
            } else {
            }
            i3 = obj;
            $i$f$forEachOneBit = $i$f$forEachOneBit2;
            removalBitmap = (TrieNode)length.mutableRemove(i3, obj8, shift + 5, set2);
            if (set2.size() != set2.size()) {
            } else {
            }
            $this$forEachOneBit$iv = 1;
            deltaCounter.plusAssign($this$forEachOneBit$iv);
            if (buffer8.length == $this$forEachOneBit$iv && !obj10 instanceof TrieNode) {
            } else {
            }
            oldSize = removalBitmap;
            if (!obj10 instanceof TrieNode) {
            } else {
            }
            oldSize = $this$forEachOneBit$iv;
            i3 = obj8.hashCode();
            if (z2) {
            } else {
            }
            Intrinsics.checkNotNull(length, otherIsNode);
            obj = length;
            Intrinsics.checkNotNull(obj8, otherIsNode);
            Object obj3 = obj8;
            removalBitmap2 = removalBitmap;
            i7 = ownership$runtime_release3;
            oldSize = (TrieNode)length.mutableRemoveAll((TrieNode)obj8, shift + 5, deltaCounter, set2);
            $i$f$forEachOneBit = $i$f$forEachOneBit2;
        }
        int removalBitmap3 = removalBitmap;
        int i13 = ownership$runtime_release3;
        int i14 = $i$f$forEachOneBit2;
        int i12 = 0;
        int bitCount = Integer.bitCount(realBitMap);
        if (realBitMap == null) {
            realBuffer = TrieNode.EMPTY;
        } else {
            if (realBitMap == obj2.bitmap) {
                realBuffer = trieNode.elementsIdentityEquals(obj2) ? obj2 : trieNode;
            } else {
                if (bitCount == 1 && shift != 0) {
                    if (shift != 0) {
                        realBuffer = trieNode.buffer[trieNode.indexOfCellAt$runtime_release(realBitMap)];
                        if (realBuffer instanceof TrieNode) {
                            removalBitmap = new TrieNode(realBitMap, /* result */, set2.getOwnership$runtime_release());
                            realBuffer = removalBitmap;
                        } else {
                        }
                    } else {
                        Object[] arr = new Object[bitCount];
                        Object[] buffer4 = trieNode.buffer;
                        $i$f$forEachOneBit2 = 0;
                        mask$iv = 0;
                        index$iv = 0;
                        j$iv = 0;
                        while (index$iv < buffer4.length) {
                            if (j$iv <= index$iv) {
                            } else {
                            }
                            i2 = i12;
                            CommonFunctionsKt.assert(i2);
                            lowestOneBit = 0;
                            if (buffer4[index$iv] != TrieNode.Companion.getEMPTY$runtime_release()) {
                            } else {
                            }
                            i6 = i12;
                            if (i6 != 0) {
                            }
                            index$iv++;
                            ownership$runtime_release3 = 1;
                            arr[$i$f$forEachOneBit2 + j$iv] = buffer4[index$iv];
                            if ($i$f$forEachOneBit2 + j$iv <= arr.length) {
                            } else {
                            }
                            i6 = i12;
                            CommonFunctionsKt.assert(i6);
                            i6 = 1;
                            i6 = 1;
                            i2 = ownership$runtime_release3;
                        }
                        removalBitmap = new TrieNode(realBitMap, arr, set2.getOwnership$runtime_release());
                        realBuffer = removalBitmap;
                    }
                } else {
                }
            }
        }
        return realBuffer;
    }

    public final Object mutableRetainAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> otherNode, int shift, DeltaCounter intersectionSizeRef, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> mutator) {
        Object ownership$runtime_release4;
        Object obj2;
        int index$iv2;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode eMPTY;
        Object trieNode;
        boolean bitmap;
        Object[] ownership$runtime_release2;
        int realBitMap;
        MutabilityOwnership ownership$runtime_release3;
        int i3;
        int i10;
        Object it;
        Object single;
        int i11;
        int i6;
        int $i$f$forEachOneBit2;
        int mask$iv;
        int i5;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder index$iv;
        int ownership$runtime_release;
        int i4;
        int i$iv;
        int j$iv;
        int length;
        int i8;
        int i;
        int indexOfCellAt$runtime_release;
        int indexOfCellAt$runtime_release2;
        Object obj;
        int i12;
        int i9;
        boolean z;
        boolean z2;
        int $i$f$forEachOneBit;
        int i2;
        int i7;
        ownership$runtime_release4 = this;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode set = otherNode;
        final DeltaCounter deltaCounter = intersectionSizeRef;
        if (ownership$runtime_release4 == set) {
            deltaCounter.plusAssign(ownership$runtime_release4.calculateSize());
            return ownership$runtime_release4;
        }
        if (shift > 30) {
            return ownership$runtime_release4.mutableCollisionRetainAll(set, deltaCounter, mutator.getOwnership$runtime_release());
        }
        bitmap2 &= bitmap3;
        if (i16 == 0) {
            return TrieNode.EMPTY;
        }
        if (Intrinsics.areEqual(ownership$runtime_release4.ownedBy, mutator.getOwnership$runtime_release()) && i16 == ownership$runtime_release4.bitmap) {
            if (i16 == ownership$runtime_release4.bitmap) {
                trieNode = ownership$runtime_release4;
            } else {
                trieNode = new TrieNode(i16, new Object[Integer.bitCount(i16)], mutator.getOwnership$runtime_release());
            }
        } else {
        }
        realBitMap = 0;
        $i$f$forEachOneBit2 = 0;
        mask$iv = i3;
        i5 = 0;
        while (mask$iv != 0) {
            i$iv = Integer.lowestOneBit(mask$iv);
            j$iv = i$iv;
            i = 0;
            i12 = 0;
            i4 = ownership$runtime_release.buffer[ownership$runtime_release4.indexOfCellAt$runtime_release(j$iv)];
            Object obj3 = set.buffer[set.indexOfCellAt$runtime_release(j$iv)];
            z = $this$forEachOneBit$iv;
            z2 = thisIsNode;
            String otherIsNode = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>";
            if (z && z2) {
            } else {
            }
            $i$f$forEachOneBit = $i$f$forEachOneBit2;
            i2 = mask$iv;
            i7 = i5;
            index$iv = mutator;
            if (z) {
            } else {
            }
            if (z2) {
            } else {
            }
            if (Intrinsics.areEqual(i4, obj3)) {
            } else {
            }
            it = TrieNode.EMPTY;
            if (it != TrieNode.EMPTY) {
            }
            trieNode.buffer[i5] = it;
            mask$iv = i2 ^ i$iv;
            i5 = i14;
            i3 = i9;
            $i$f$forEachOneBit2 = $i$f$forEachOneBit;
            index$iv2 = shift;
            realBitMap = eMPTY;
            i10 = i4;
            $i$f$forEachOneBit2 = 0;
            deltaCounter.plusAssign(1);
            it = i4;
            Intrinsics.checkNotNull(obj3, otherIsNode);
            Object obj6 = obj3;
            if (i4 != null) {
            } else {
            }
            $i$f$forEachOneBit2 = 0;
            if ((TrieNode)obj3.contains($i$f$forEachOneBit2, i4, shift + 5)) {
            } else {
            }
            it = TrieNode.EMPTY;
            deltaCounter.plusAssign(1);
            $i$f$forEachOneBit2 = i4.hashCode();
            Intrinsics.checkNotNull(i4, otherIsNode);
            Object obj4 = i4;
            if (obj3 != null) {
            } else {
            }
            $i$f$forEachOneBit2 = 0;
            if ((TrieNode)i4.contains($i$f$forEachOneBit2, obj3, shift + 5)) {
            } else {
            }
            it = TrieNode.EMPTY;
            deltaCounter.plusAssign(1);
            it = obj3;
            $i$f$forEachOneBit2 = obj3.hashCode();
            if (z2) {
            } else {
            }
            Intrinsics.checkNotNull(i4, otherIsNode);
            obj = i4;
            Intrinsics.checkNotNull(obj3, otherIsNode);
            Object obj8 = obj3;
            $i$f$forEachOneBit = $i$f$forEachOneBit2;
            i2 = mask$iv;
            i7 = i5;
            it = (TrieNode)i4.mutableRetainAll((TrieNode)obj3, shift + 5, deltaCounter, mutator);
        }
        int $this$forEachOneBit$iv2 = i3;
        int i18 = $i$f$forEachOneBit2;
        int i19 = mask$iv;
        int i20 = i5;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder index$iv3 = mutator;
        int bitCount = Integer.bitCount(realBitMap);
        if (realBitMap == null) {
            single = TrieNode.EMPTY;
        } else {
            if (realBitMap == i16) {
                single = trieNode.elementsIdentityEquals(ownership$runtime_release4) ? ownership$runtime_release4 : elementsIdentityEquals2 ? set : trieNode;
            } else {
                if (bitCount == 1 && shift != 0) {
                    if (shift != 0) {
                        single = trieNode.buffer[trieNode.indexOfCellAt$runtime_release(realBitMap)];
                        if (single instanceof TrieNode) {
                            $i$f$forEachOneBit2 = new TrieNode(realBitMap, /* result */, index$iv3.getOwnership$runtime_release());
                            single = $i$f$forEachOneBit2;
                        } else {
                        }
                    } else {
                        $i$f$forEachOneBit2 = new Object[bitCount];
                        mask$iv = trieNode.buffer;
                        ownership$runtime_release = 0;
                        i4 = 0;
                        i$iv = 0;
                        j$iv = 0;
                        while (i$iv < mask$iv.length) {
                            if (j$iv <= i$iv) {
                            } else {
                            }
                            i8 = 0;
                            CommonFunctionsKt.assert(i8);
                            i = 0;
                            if (mask$iv[i$iv] != TrieNode.Companion.getEMPTY$runtime_release()) {
                            } else {
                            }
                            i6 = 0;
                            if (i6 != 0) {
                            }
                            i$iv++;
                            i11 = 1;
                            ownership$runtime_release4 = this;
                            $i$f$forEachOneBit2[ownership$runtime_release + j$iv] = mask$iv[i$iv];
                            if (ownership$runtime_release + j$iv <= $i$f$forEachOneBit2.length) {
                            } else {
                            }
                            i6 = 0;
                            CommonFunctionsKt.assert(i6);
                            i6 = 1;
                            i6 = 1;
                            i8 = i11;
                        }
                        single = new TrieNode(realBitMap, $i$f$forEachOneBit2, index$iv3.getOwnership$runtime_release());
                    }
                } else {
                }
            }
        }
        return single;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> remove(int elementHash, E element, int shift) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode collisionRemove;
        i <<= indexSegment;
        if (hasNoCellAt(i2)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i2);
        if (obj instanceof TrieNode) {
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (shift == 30) {
                collisionRemove = nodeAtIndex.collisionRemove(element);
            } else {
                collisionRemove = nodeAtIndex.remove(elementHash, element, shift + 5);
            }
            if (nodeAtIndex == collisionRemove) {
                return this;
            }
            return updateNodeAtIndex(indexOfCellAt$runtime_release, collisionRemove);
        }
        if (Intrinsics.areEqual(element, this.buffer[indexOfCellAt$runtime_release])) {
            return removeCellAtIndex(indexOfCellAt$runtime_release, i2);
        }
        return this;
    }

    public final void setBitmap(int <set-?>) {
        this.bitmap = <set-?>;
    }

    public final void setBuffer(Object[] <set-?>) {
        this.buffer = <set-?>;
    }

    public final void setOwnedBy(MutabilityOwnership <set-?>) {
        this.ownedBy = <set-?>;
    }
}
