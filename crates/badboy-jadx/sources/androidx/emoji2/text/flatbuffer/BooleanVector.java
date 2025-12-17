package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class BooleanVector extends androidx.emoji2.text.flatbuffer.BaseVector {
    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public androidx.emoji2.text.flatbuffer.BooleanVector __assign(int _vector, ByteBuffer _bb) {
        __reset(_vector, 1, _bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public boolean get(int j) {
        int i;
        i = this.bb.get(__element(j)) != 0 ? 1 : 0;
        return i;
    }
}
