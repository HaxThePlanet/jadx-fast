package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class Struct {

    protected ByteBuffer bb;
    protected int bb_pos;
    public void __reset() {
        __reset(0, 0);
    }

    protected void __reset(int _i, ByteBuffer _bb) {
        ByteBuffer byteBuffer;
        this.bb = _bb;
        if (this.bb != null) {
            this.bb_pos = _i;
        } else {
            this.bb_pos = 0;
        }
    }
}
