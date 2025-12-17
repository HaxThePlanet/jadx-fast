package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class UnionVector extends androidx.emoji2.text.flatbuffer.BaseVector {
    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public androidx.emoji2.text.flatbuffer.UnionVector __assign(int _vector, int _element_size, ByteBuffer _bb) {
        __reset(_vector, _element_size, _bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public androidx.emoji2.text.flatbuffer.Table get(androidx.emoji2.text.flatbuffer.Table obj, int j) {
        return Table.__union(obj, __element(j), this.bb);
    }
}
