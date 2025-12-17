package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class ShortVector extends androidx.emoji2.text.flatbuffer.BaseVector {
    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public androidx.emoji2.text.flatbuffer.ShortVector __assign(int _vector, ByteBuffer _bb) {
        __reset(_vector, 2, _bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public short get(int j) {
        return this.bb.getShort(__element(j));
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public int getAsUnsigned(int j) {
        return s &= i2;
    }
}
