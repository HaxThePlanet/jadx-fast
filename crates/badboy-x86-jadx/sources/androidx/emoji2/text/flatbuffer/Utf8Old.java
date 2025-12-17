package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

/* loaded from: classes5.dex */
public class Utf8Old extends androidx.emoji2.text.flatbuffer.Utf8 {

    private static final java.lang.ThreadLocal<androidx.emoji2.text.flatbuffer.Utf8Old.Cache> CACHE;

    private static class Cache {

        final CharsetDecoder decoder;
        final CharsetEncoder encoder;
        java.lang.CharSequence lastInput = null;
        ByteBuffer lastOutput = null;
        Cache() {
            super();
            int i = 0;
            this.encoder = StandardCharsets.UTF_8.newEncoder();
            this.decoder = StandardCharsets.UTF_8.newDecoder();
        }
    }
    static {
        Utf8Old$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new Utf8Old$$ExternalSyntheticLambda0();
        Utf8Old.CACHE = ThreadLocal.withInitial(externalSyntheticLambda0);
    }

    static androidx.emoji2.text.flatbuffer.Utf8Old.Cache lambda$static$0() {
        Utf8Old.Cache cache = new Utf8Old.Cache();
        return cache;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer buffer, int offset, int length) {
        CharsetDecoder decoder = obj.decoder;
        decoder.reset();
        final ByteBuffer obj5 = buffer.duplicate();
        obj5.position(offset);
        obj5.limit(offset + length);
        return decoder.decode(obj5).toString();
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(java.lang.CharSequence in, ByteBuffer out) {
        Object obj = Utf8Old.CACHE.get();
        if (obj.lastInput != in) {
            encodedLength(in);
        }
        out.put(obj.lastOutput);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(java.lang.CharSequence in) {
        ByteBuffer lastOutput;
        Object wrap;
        Object obj = Utf8Old.CACHE.get();
        int i2 = (int)i;
        if (obj.lastOutput != null) {
            if (obj.lastOutput.capacity() < i2) {
                obj.lastOutput = ByteBuffer.allocate(Math.max(128, i2));
            }
        } else {
        }
        obj.lastOutput.clear();
        obj.lastInput = in;
        if (in instanceof CharBuffer) {
            wrap = in;
        } else {
            wrap = CharBuffer.wrap(in);
        }
        CoderResult encode = obj.encoder.encode(wrap, obj.lastOutput, true);
        if (encode.isError()) {
            encode.throwException();
        }
        obj.lastOutput.flip();
        return obj.lastOutput.remaining();
    }
}
