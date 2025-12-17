package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class IntVector extends androidx.emoji2.text.flatbuffer.BaseVector {
    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public androidx.emoji2.text.flatbuffer.IntVector __assign(int _vector, ByteBuffer _bb) {
        __reset(_vector, 4, _bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public int get(int j) {
        return this.bb.getInt(__element(j));
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public long getAsUnsigned(int j) {
        return l &= l2;
    }
}
