package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010*\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J#\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010\u0019JG\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ5\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010 \u001a\u00020\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u0012\u001a\u00020\tH\u0016J?\u0010$\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010&J3\u0010'\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010)JC\u0010*\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010-J?\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0010\u0004\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\t2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010/J\"\u00100\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020302H\u0016J\u0016\u00104\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J=\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010&J;\u00106\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0002\u00107J\u0008\u0010(\u001a\u00020\tH\u0002J#\u00108\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J?\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0008\u0010:\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000cR\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000c¨\u0006<", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "root", "", "", "tail", "size", "", "rootShift", "([Ljava/lang/Object;[Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "bufferFor", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "get", "(I)Ljava/lang/Object;", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "insertIntoTail", "tailIndex", "([Ljava/lang/Object;ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "listIterator", "", "pullLastBuffer", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "rootSize", "([Ljava/lang/Object;II)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVector;", "pushTail", "([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "set", "setInRoot", "e", "([Ljava/lang/Object;IILjava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentVector<E>  extends androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList<E> implements PersistentList<E> {

    public static final int $stable = 8;
    private final Object[] root;
    private final int rootShift;
    private final int size;
    private final Object[] tail;
    static {
        final int i = 8;
    }

    public PersistentVector(Object[] root, Object[] tail, int size, int rootShift) {
        int i;
        int i2;
        String $i$a$RequirePreconditionPersistentVector$1;
        StringBuilder append;
        int size2;
        super();
        this.root = root;
        this.tail = tail;
        this.size = size;
        this.rootShift = rootShift;
        final int i4 = 0;
        int i5 = 32;
        i = size() > i5 ? i2 : i4;
        int i6 = 0;
        if (i == 0) {
            int i7 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalArgumentException(stringBuilder.append("Trie-based persistent vector should have at least 33 elements, got ").append(size()).toString());
        }
        if (size4 -= rootSize <= RangesKt.coerceAtMost(tail2.length, i5)) {
        } else {
            i2 = i4;
        }
        CommonFunctionsKt.assert(i2);
    }

    private final Object[] bufferFor(int index) {
        Object[] buffer;
        int shift;
        Object obj;
        String str;
        if (rootSize() <= index) {
            return this.tail;
        }
        buffer = this.root;
        shift = this.rootShift;
        while (shift > 0) {
            obj = buffer[UtilsKt.indexSegment(index, shift)];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            buffer = obj;
            shift += -5;
        }
        return buffer;
    }

    private final Object[] insertIntoRoot(Object[] root, int shift, int index, Object element, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef elementCarry) {
        int i2;
        Object[] arr;
        Object[] intoRoot2;
        Object[] copyOf;
        int intoRoot;
        String str;
        Object obj;
        int i;
        Object value;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef list;
        final Object[] objArr = root;
        final int i3 = shift;
        final int i6 = index;
        final int indexSegment = UtilsKt.indexSegment(i6, i3);
        String str2 = "copyOf(this, newSize)";
        final int i7 = 32;
        if (i3 == 0) {
            if (indexSegment == 0) {
                arr = new Object[i7];
            } else {
                copyOf = Arrays.copyOf(objArr, i7);
                Intrinsics.checkNotNullExpressionValue(copyOf, str2);
                arr = copyOf;
            }
            int i5 = 31;
            ArraysKt.copyInto(objArr, arr, indexSegment + 1, indexSegment, i5);
            elementCarry.setValue(objArr[i5]);
            arr[indexSegment] = element;
            return arr;
        }
        Object[] copyOf2 = Arrays.copyOf(objArr, i7);
        Intrinsics.checkNotNullExpressionValue(copyOf2, str2);
        final Object[] objArr2 = copyOf2;
        final int i8 = i3 + -5;
        Object obj2 = objArr[indexSegment];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArr2[indexSegment] = this.insertIntoRoot((Object[])obj2, i8, i6, element, elementCarry);
        i2 = indexSegment + 1;
        while (i2 < i7) {
            if (objArr2[i2] != null) {
            }
            Object obj5 = objArr[i2];
            Intrinsics.checkNotNull(obj5, str);
            objArr2[i2] = this.insertIntoRoot((Object[])obj5, i8, 0, elementCarry.getValue(), elementCarry);
            i2++;
            str = intoRoot2;
        }
        return objArr2;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVector<E> insertIntoTail(Object[] root, int tailIndex, Object element) {
        size -= rootSize;
        int i2 = 32;
        Object[] copyOf = Arrays.copyOf(this.tail, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (i < i2) {
            ArraysKt.copyInto(this.tail, copyOf, tailIndex + 1, tailIndex, i);
            copyOf[tailIndex] = element;
            PersistentVector persistentVector = new PersistentVector(root, copyOf, size2++, this.rootShift);
            return persistentVector;
        }
        ArraysKt.copyInto(this.tail, copyOf, tailIndex + 1, tailIndex, i + -1);
        copyOf[tailIndex] = element;
        return pushFilledTail(root, copyOf, UtilsKt.presizedBufferWith(this.tail[31]));
    }

    private final Object[] pullLastBuffer(Object[] root, int shift, int index, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef tailCarry) {
        int pullLastBuffer;
        int i;
        final int indexSegment = UtilsKt.indexSegment(index, shift);
        int i3 = 0;
        if (shift == 5) {
            tailCarry.setValue(root[indexSegment]);
            pullLastBuffer = i3;
        } else {
            Object obj2 = root[indexSegment];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            pullLastBuffer = pullLastBuffer((Object[])obj2, shift + -5, index, tailCarry);
        }
        if (pullLastBuffer == 0 && indexSegment == 0) {
            if (indexSegment == 0) {
                return i3;
            }
        }
        Object[] copyOf = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[indexSegment] = pullLastBuffer;
        return copyOf;
    }

    private final PersistentList<E> pullLastBufferFromRoot(Object[] root, int rootSize, int shift) {
        Object[] copyOf;
        int str;
        if (shift == 0) {
            if (root.length == 33) {
                Intrinsics.checkNotNullExpressionValue(Arrays.copyOf(root, 32), "copyOf(this, newSize)");
            } else {
                copyOf = root;
            }
            SmallPersistentVector smallPersistentVector = new SmallPersistentVector(copyOf);
            return (PersistentList)smallPersistentVector;
        }
        ObjectRef buffer = new ObjectRef(0);
        Object[] pullLastBuffer = pullLastBuffer(root, shift, rootSize + -1, buffer);
        Intrinsics.checkNotNull(pullLastBuffer);
        final Object value = buffer.getValue();
        String str2 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.checkNotNull(value, str2);
        if (pullLastBuffer[1] == null) {
            Object obj3 = pullLastBuffer[0];
            Intrinsics.checkNotNull(obj3, str2);
            PersistentVector persistentVector = new PersistentVector((Object[])obj3, (Object[])value, rootSize, shift + -5);
            return (PersistentList)persistentVector;
        }
        PersistentVector lowerLevelRoot = new PersistentVector(pullLastBuffer, value, rootSize, shift);
        return (PersistentList)lowerLevelRoot;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVector<E> pushFilledTail(Object[] root, Object[] filledTail, Object[] newTail) {
        int i4 = 1;
        if (size >>= 5 > i4 << rootShift) {
            rootShift2 += 5;
            PersistentVector persistentVector2 = new PersistentVector(pushTail(UtilsKt.presizedBufferWith(root), i3, filledTail), newTail, size3 += i4, i3);
            return persistentVector2;
        }
        PersistentVector persistentVector = new PersistentVector(pushTail(root, this.rootShift, filledTail), newTail, size2 += i4, this.rootShift);
        return persistentVector;
    }

    private final Object[] pushTail(Object[] root, int shift, Object[] tail) {
        Object[] pushTail;
        Object[] copyOf;
        String str;
        int indexSegment = UtilsKt.indexSegment(size--, shift);
        int i2 = 32;
        if (root != null) {
            copyOf = Arrays.copyOf(root, i2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            if (copyOf == null) {
                copyOf = new Object[i2];
            }
        } else {
        }
        if (shift == 5) {
            copyOf[indexSegment] = tail;
        } else {
            copyOf[indexSegment] = pushTail((Object[])copyOf[indexSegment], shift + -5, tail);
        }
        return copyOf;
    }

    private final Object[] removeFromRootAt(Object[] root, int shift, int index, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef tailCarry) {
        Object[] arr;
        int bufferLastIndex;
        Object[] copyOf;
        Object obj;
        int i;
        Object[] fromRootAt;
        int i2;
        final int indexSegment = UtilsKt.indexSegment(index, shift);
        String str = "copyOf(this, newSize)";
        int i4 = 32;
        if (shift == 0) {
            if (indexSegment == 0) {
                arr = new Object[i4];
            } else {
                copyOf = Arrays.copyOf(root, i4);
                Intrinsics.checkNotNullExpressionValue(copyOf, str);
                arr = copyOf;
            }
            ArraysKt.copyInto(root, arr, indexSegment, indexSegment + 1, i4);
            arr[31] = tailCarry.getValue();
            tailCarry.setValue(root[indexSegment]);
            return arr;
        }
        if (root[31] == null) {
            bufferLastIndex = UtilsKt.indexSegment(rootSize--, shift);
        }
        Object[] copyOf2 = Arrays.copyOf(root, i4);
        Intrinsics.checkNotNullExpressionValue(copyOf2, str);
        int i3 = shift + -5;
        final int i8 = indexSegment + 1;
        final String str2 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        if (i8 <= bufferLastIndex) {
        }
        Object i7 = copyOf2[indexSegment];
        Intrinsics.checkNotNull(i7, str2);
        copyOf2[indexSegment] = removeFromRootAt((Object[])i7, i3, index, tailCarry);
        return copyOf2;
    }

    private final PersistentList<E> removeFromTailAt(Object[] root, int rootSize, int shift, int index) {
        int i2;
        int tail;
        int i;
        size -= rootSize;
        int i4 = 1;
        i2 = index < i3 ? i4 : 0;
        CommonFunctionsKt.assert(i2);
        if (i3 == i4) {
            return pullLastBufferFromRoot(root, rootSize, shift);
        }
        Object[] copyOf = Arrays.copyOf(this.tail, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (index < i3 + -1) {
            ArraysKt.copyInto(this.tail, copyOf, index, index + 1, i3);
        }
        copyOf[i3 + -1] = 0;
        PersistentVector persistentVector = new PersistentVector(root, copyOf, i8 -= i4, shift);
        return (PersistentList)persistentVector;
    }

    private final int rootSize() {
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] root, int shift, int index, Object e) {
        String inRoot;
        int i;
        final int indexSegment = UtilsKt.indexSegment(index, shift);
        Object[] copyOf = Arrays.copyOf(root, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (shift == 0) {
            copyOf[indexSegment] = e;
        } else {
            Object obj = copyOf[indexSegment];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            copyOf[indexSegment] = setInRoot((Object[])obj, shift + -5, index, e);
        }
        return copyOf;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public PersistentCollection add(Object element) {
        return (PersistentCollection)add(element);
    }

    public PersistentList<E> add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            return add(element);
        }
        int rootSize = rootSize();
        if (index >= rootSize) {
            return (PersistentList)insertIntoTail(this.root, index - rootSize, element);
        }
        ObjectRef objectRef = new ObjectRef(0);
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef list2 = objectRef;
        return (PersistentList)insertIntoTail(this.insertIntoRoot(this.root, this.rootShift, index, element, list2), 0, list2.getValue());
    }

    public PersistentList<E> add(E element) {
        size -= rootSize;
        int i2 = 32;
        if (i < i2) {
            Object[] copyOf = Arrays.copyOf(this.tail, i2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[i] = element;
            PersistentVector persistentVector = new PersistentVector(this.root, copyOf, size2++, this.rootShift);
            return (PersistentList)persistentVector;
        }
        return (PersistentList)pushFilledTail(this.root, this.tail, UtilsKt.presizedBufferWith(element));
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public PersistentCollection.Builder builder() {
        return (PersistentCollection.Builder)builder();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public PersistentList.Builder builder() {
        return (PersistentList.Builder)builder();
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder<E> builder() {
        PersistentVectorBuilder persistentVectorBuilder = new PersistentVectorBuilder((PersistentList)this, this.root, this.tail, this.rootShift);
        return persistentVectorBuilder;
    }

    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return bufferFor(index)[index & 31];
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public int getSize() {
        return this.size;
    }

    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        PersistentVectorIterator persistentVectorIterator = new PersistentVectorIterator(this.root, this.tail, index, size(), i + 1);
        return (ListIterator)persistentVectorIterator;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public PersistentCollection removeAll(Function1 predicate) {
        return (PersistentCollection)removeAll(predicate);
    }

    public PersistentList<E> removeAll(Function1<? super E, Boolean> predicate) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder builder = builder();
        final int i = 0;
        builder.removeAllWithPredicate(predicate);
        return builder.build();
    }

    public PersistentList<E> removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        int rootSize = rootSize();
        if (index >= rootSize) {
            return removeFromTailAt(this.root, rootSize, this.rootShift, index - rootSize);
        }
        final int i2 = 0;
        ObjectRef objectRef = new ObjectRef(this.tail[i2]);
        return removeFromTailAt(removeFromRootAt(this.root, this.rootShift, index, objectRef), rootSize, this.rootShift, i2);
    }

    public PersistentList<E> set(int index, E element) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        if (rootSize() <= index) {
            Object[] copyOf = Arrays.copyOf(this.tail, 32);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[index & 31] = element;
            PersistentVector persistentVector = new PersistentVector(this.root, copyOf, size(), this.rootShift);
            return (PersistentList)persistentVector;
        }
        PersistentVector persistentVector2 = new PersistentVector(setInRoot(this.root, this.rootShift, index, element), this.tail, size(), this.rootShift);
        return (PersistentList)persistentVector2;
    }
}
