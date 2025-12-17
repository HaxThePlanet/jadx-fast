package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class FloatVector extends androidx.emoji2.text.flatbuffer.BaseVector {
    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public androidx.emoji2.text.flatbuffer.FloatVector __assign(int _vector, ByteBuffer _bb) {
        __reset(_vector, 4, _bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public float get(int j) {
        return this.bb.getFloat(__element(j));
    }
}
