package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class BaseVector {

    protected ByteBuffer bb;
    private int element_size;
    private int length;
    private int vector;
    protected int __element(int j) {
        return vector += i2;
    }

    protected void __reset(int _vector, int _element_size, ByteBuffer _bb) {
        int int;
        int i;
        this.bb = _bb;
        if (this.bb != null) {
            this.vector = _vector;
            this.length = this.bb.getInt(_vector + -4);
            this.element_size = _element_size;
        } else {
            int = 0;
            this.vector = int;
            this.length = int;
            this.element_size = int;
        }
    }

    protected int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        final int i = 0;
        __reset(i, i, 0);
    }
}
