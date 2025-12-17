package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class ByteVector extends androidx.emoji2.text.flatbuffer.BaseVector {
    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public androidx.emoji2.text.flatbuffer.ByteVector __assign(int vector, ByteBuffer bb) {
        __reset(vector, 1, bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public byte get(int j) {
        return this.bb.get(__element(j));
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public int getAsUnsigned(int j) {
        return b &= 255;
    }
}
