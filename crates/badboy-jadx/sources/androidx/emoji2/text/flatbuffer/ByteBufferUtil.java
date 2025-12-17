package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class ByteBufferUtil {
    public static int getSizePrefix(ByteBuffer bb) {
        return bb.getInt(bb.position());
    }

    public static ByteBuffer removeSizePrefix(ByteBuffer bb) {
        final ByteBuffer duplicate = bb.duplicate();
        duplicate.position(position += 4);
        return duplicate;
    }
}
