package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008`\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0008J\u001e\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "E", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "subList", "fromIndex", "", "toIndex", "SubList", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ImmutableList<E>  extends List<E>, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection<E>, KMappedMarker {

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u0016\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList$SubList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Lkotlin/collections/AbstractList;", "source", "fromIndex", "", "toIndex", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "subList", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SubList extends AbstractList<E> implements androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<E> {

        private int _size;
        private final int fromIndex;
        private final androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<E> source;
        private final int toIndex;
        public SubList(androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<? extends E> source, int fromIndex, int toIndex) {
            super();
            this.source = source;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            ListImplementation.checkRangeIndexes$runtime_release(this.fromIndex, this.toIndex, this.source.size());
            this._size = toIndex2 -= fromIndex3;
        }

        public E get(int index) {
            ListImplementation.checkElementIndex$runtime_release(index, this._size);
            return this.source.get(fromIndex += index);
        }

        @Override // kotlin.collections.AbstractList
        public int getSize() {
            return this._size;
        }

        public androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<E> subList(int fromIndex, int toIndex) {
            ListImplementation.checkRangeIndexes$runtime_release(fromIndex, toIndex, this._size);
            ImmutableList.SubList subList = new ImmutableList.SubList(this.source, fromIndex2 += fromIndex, fromIndex3 += toIndex);
            return (ImmutableList)subList;
        }

        @Override // kotlin.collections.AbstractList
        public List subList(int fromIndex, int toIndex) {
            return (List)subList(fromIndex, toIndex);
        }
    }
    public androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<E> subList(int fromIndex, int toIndex) {
        ImmutableList.SubList subList = new ImmutableList.SubList(this, fromIndex, toIndex);
        return (ImmutableList)subList;
    }

    @Override // java.util.List
    public List subList(int fromIndex, int toIndex) {
        return (List)subList(fromIndex, toIndex);
    }
}
