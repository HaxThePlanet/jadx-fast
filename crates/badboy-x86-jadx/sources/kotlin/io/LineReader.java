package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0008\u0010 \u001a\u00020!H\u0002J\u0008\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LineReader {

    private static final int BUFFER_SIZE = 32;
    public static final kotlin.io.LineReader INSTANCE;
    private static final ByteBuffer byteBuf;
    private static final byte[] bytes;
    private static final CharBuffer charBuf;
    private static final char[] chars;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    private static final StringBuilder sb;
    static {
        LineReader lineReader = new LineReader();
        LineReader.INSTANCE = lineReader;
        int i = 32;
        LineReader.bytes = new byte[i];
        LineReader.chars = new char[i];
        ByteBuffer wrap = ByteBuffer.wrap(LineReader.bytes);
        String str = "wrap(...)";
        Intrinsics.checkNotNullExpressionValue(wrap, str);
        LineReader.byteBuf = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(LineReader.chars);
        Intrinsics.checkNotNullExpressionValue(wrap2, str);
        LineReader.charBuf = wrap2;
        StringBuilder stringBuilder = new StringBuilder();
        LineReader.sb = stringBuilder;
    }

    private final int compactBytes() {
        final ByteBuffer byteBuf = LineReader.byteBuf;
        final int i = 0;
        byteBuf.compact();
        final int position = byteBuf.position();
        final int i2 = position;
        final int i3 = 0;
        byteBuf.position(0);
        return position;
    }

    private final int decode(boolean endOfInput) {
        CoderResult decode;
        CharsetDecoder decoder;
        int position;
        CharBuffer charBuf;
        char c;
        int i;
        int i2;
        while (LineReader.decoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            decoder = 0;
            decode = decoder.decode(LineReader.byteBuf, LineReader.charBuf, endOfInput);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
            if (decode.isError()) {
            }
            position = LineReader.charBuf.position();
            if (decode.isOverflow()) {
            }
            i2 = 0;
            LineReader.sb.append(LineReader.chars, i2, position + -1);
            LineReader.charBuf.position(i2);
            LineReader.charBuf.limit(32);
            LineReader.charBuf.put(LineReader.chars[position + -1]);
            resetAll();
            decode.throwException();
        }
        return position;
    }

    private final int decodeEndOfInput(int nBytes, int nChars) {
        CharsetDecoder decoder;
        LineReader.byteBuf.limit(nBytes);
        LineReader.charBuf.position(nChars);
        int decode = decode(true);
        final int i2 = decode;
        final int i3 = 0;
        if (LineReader.decoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            decoder = 0;
        }
        decoder.reset();
        LineReader.byteBuf.position(0);
        return decode;
    }

    private final void resetAll() {
        CharsetDecoder decoder;
        if (LineReader.decoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            decoder = 0;
        }
        decoder.reset();
        final int i = 0;
        LineReader.byteBuf.position(i);
        LineReader.sb.setLength(i);
    }

    private final void trimStringBuilder() {
        LineReader.sb.setLength(32);
        LineReader.sb.trimToSize();
    }

    private final void updateCharset(Charset charset) {
        CharsetDecoder decoder;
        int position;
        int i;
        CharsetDecoder decoder2 = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(decoder2, "newDecoder(...)");
        LineReader.decoder = decoder2;
        LineReader.byteBuf.clear();
        LineReader.charBuf.clear();
        int i2 = 10;
        LineReader.byteBuf.put(i2);
        LineReader.byteBuf.flip();
        if (LineReader.decoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            decoder = 0;
        }
        i = 0;
        decoder.decode(LineReader.byteBuf, LineReader.charBuf, i);
        int i3 = 1;
        if (LineReader.charBuf.position() == i3 && LineReader.charBuf.get(i) == i2) {
            if (LineReader.charBuf.get(i) == i2) {
                i = i3;
            }
        }
        LineReader.directEOL = i;
        resetAll();
    }

    public final String readLine(InputStream inputStream, Charset charset) {
        boolean decoder2;
        int compactBytes;
        int decode;
        CharsetDecoder decoder;
        int nChars;
        int nChars2;
        int read;
        int i3;
        int i4;
        byte[] bytes;
        int i5;
        int i2;
        int i;
        byte b;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        int i6 = 0;
        synchronized (this) {
            try {
                if (LineReader.decoder == null) {
                }
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                decoder = i6;
                if (!Intrinsics.areEqual(decoder.charset(), charset)) {
                }
                updateCharset(charset);
                compactBytes = 0;
                nChars2 = 0;
                read = inputStream.read();
                i3 = 32;
                i4 = 10;
                i2 = 0;
                while (read == -1) {
                    i = compactBytes + 1;
                    LineReader.bytes[compactBytes] = (byte)read;
                    LineReader.byteBuf.limit(i);
                    LineReader.charBuf.position(nChars2);
                    nChars2 = decode;
                    compactBytes = compactBytes();
                    read = inputStream.read();
                    i3 = 32;
                    i4 = 10;
                    i2 = 0;
                    compactBytes = i;
                }
                if ((CharSequence)LineReader.sb.length() == 0) {
                } else {
                }
                bytes = i5;
                bytes = i2;
                if (bytes != 0 && compactBytes == 0 && nChars2 == 0) {
                }
                if (compactBytes == 0) {
                }
                if (nChars2 == 0) {
                }
                return i6;
                nChars = decodeEndOfInput(compactBytes, nChars2);
                i = compactBytes + 1;
                LineReader.bytes[compactBytes] = (byte)read;
                if (read != i4) {
                } else {
                }
                if (i != i3) {
                } else {
                }
                if (!LineReader.directEOL) {
                } else {
                }
                compactBytes = i;
                LineReader.byteBuf.limit(i);
                LineReader.charBuf.position(nChars2);
                nChars2 = decode;
                if (nChars2 > 0) {
                } else {
                }
                if (LineReader.chars[nChars2 + -1] == i4) {
                } else {
                }
                LineReader.byteBuf.position(i2);
                nChars = nChars2;
                compactBytes = i;
                nChars--;
                if (nChars > 0 && LineReader.chars[nChars + -1] == i4 && nChars > 0 && LineReader.chars[nChars + -1] == 13) {
                }
                if (LineReader.chars[nChars + -1] == i4) {
                }
                nChars--;
                if (nChars > 0) {
                }
                if (LineReader.chars[nChars + -1] == 13) {
                }
                nChars--;
                if ((CharSequence)LineReader.sb.length() == 0) {
                } else {
                }
                i5 = i2;
                if (i5 != 0) {
                }
                String string2 = new String(LineReader.chars, i2, nChars);
                return string2;
                LineReader.sb.append(LineReader.chars, i2, nChars);
                String string = LineReader.sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                if (LineReader.sb.length() > i3) {
                }
                trimStringBuilder();
                LineReader.sb.setLength(i2);
                return string;
                compactBytes = compactBytes();
                throw inputStream;
            }
        }
    }
}
