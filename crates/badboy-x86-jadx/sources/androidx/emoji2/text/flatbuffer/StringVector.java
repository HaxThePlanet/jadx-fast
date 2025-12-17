package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class StringVector extends androidx.emoji2.text.flatbuffer.BaseVector {

    private androidx.emoji2.text.flatbuffer.Utf8 utf8;
    public StringVector() {
        super();
        this.utf8 = Utf8.getDefault();
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public androidx.emoji2.text.flatbuffer.StringVector __assign(int _vector, int _element_size, ByteBuffer _bb) {
        __reset(_vector, _element_size, _bb);
        return this;
    }

    @Override // androidx.emoji2.text.flatbuffer.BaseVector
    public String get(int j) {
        return Table.__string(__element(j), this.bb, this.utf8);
    }
}
