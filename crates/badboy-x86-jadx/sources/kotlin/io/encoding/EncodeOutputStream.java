package kotlin.io.encoding;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\r\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u000e\u001a\u00020\u000fH\u0002J\u0008\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0008\u0010\u0015\u001a\u00020\u000fH\u0002J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0008\u0010\u0017\u001a\u00020\u000fH\u0016J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lkotlin/io/encoding/EncodeOutputStream;", "Ljava/io/OutputStream;", "output", "base64", "Lkotlin/io/encoding/Base64;", "(Ljava/io/OutputStream;Lkotlin/io/encoding/Base64;)V", "byteBuffer", "", "byteBufferLength", "", "isClosed", "", "lineLength", "symbolBuffer", "checkOpen", "", "close", "copyIntoByteBuffer", "source", "startIndex", "endIndex", "encodeByteBufferIntoOutput", "encodeIntoOutput", "flush", "write", "offset", "length", "b", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class EncodeOutputStream extends OutputStream {

    private final kotlin.io.encoding.Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferLength;
    private boolean isClosed;
    private int lineLength = -1;
    private final OutputStream output;
    private final byte[] symbolBuffer;
    public EncodeOutputStream(OutputStream output, kotlin.io.encoding.Base64 base64) {
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(base64, "base64");
        super();
        this.output = output;
        this.base64 = base64;
        int i = this.base64.isMimeScheme$kotlin_stdlib() ? 76 : i;
        int i2 = -1;
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[3];
    }

    private final void checkOpen() {
        if (this.isClosed) {
        } else {
        }
        IOException iOException = new IOException("The output stream is closed.");
        throw iOException;
    }

    private final int copyIntoByteBuffer(byte[] source, int startIndex, int endIndex) {
        int i2 = Math.min(byteBufferLength - 3, endIndex - startIndex);
        ArraysKt.copyInto(source, this.byteBuffer, this.byteBufferLength, startIndex, startIndex + i2);
        this.byteBufferLength = byteBufferLength2 += i2;
        if (this.byteBufferLength == 3) {
            encodeByteBufferIntoOutput();
        }
        return i2;
    }

    private final void encodeByteBufferIntoOutput() {
        int i;
        int i3 = 0;
        i = encodeIntoOutput(this.byteBuffer, i3, this.byteBufferLength) == 4 ? 1 : i3;
        if (i == 0) {
        } else {
            this.byteBufferLength = i3;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
        throw illegalStateException;
    }

    private final int encodeIntoOutput(byte[] source, int startIndex, int endIndex) {
        kotlin.io.encoding.Base64 mimeLineSeparatorSymbols$kotlin_stdlib;
        int obj8;
        final int obj7 = this.base64.encodeIntoByteArray(source, this.symbolBuffer, 0, startIndex, endIndex);
        int obj9 = 0;
        if (this.lineLength == 0) {
            this.output.write(Base64.Default.getMimeLineSeparatorSymbols$kotlin_stdlib());
            obj8 = 76;
            this.lineLength = obj8;
            obj8 = obj7 <= obj8 ? 1 : obj9;
            if (obj8 == null) {
            } else {
            }
            obj8 = new IllegalStateException("Check failed.".toString());
            throw obj8;
        }
        this.output.write(this.symbolBuffer, obj9, obj7);
        this.lineLength = obj8 -= obj7;
        return obj7;
    }

    @Override // java.io.OutputStream
    public void close() {
        boolean isClosed;
        this.isClosed = true;
        if (!this.isClosed && this.byteBufferLength != 0) {
            this.isClosed = true;
            if (this.byteBufferLength != 0) {
                encodeByteBufferIntoOutput();
            }
            this.output.close();
        }
    }

    @Override // java.io.OutputStream
    public void flush() {
        checkOpen();
        this.output.flush();
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        checkOpen();
        int byteBufferLength2 = this.byteBufferLength;
        this.byteBufferLength = byteBufferLength2 + 1;
        this.byteBuffer[byteBufferLength2] = (byte)b;
        if (this.byteBufferLength == 3) {
            encodeByteBufferIntoOutput();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] source, int offset, int length) {
        int i4;
        int startIndex;
        String str;
        int length2;
        int byteBufferLength;
        int lineLength;
        int i;
        int i2;
        int encodeIntoOutput;
        int i3;
        Intrinsics.checkNotNullParameter(source, "source");
        checkOpen();
        if (offset < 0) {
        } else {
            if (length < 0) {
            } else {
                if (offset + length > source.length) {
                } else {
                    if (length == 0) {
                    }
                    int i5 = 1;
                    int i7 = 0;
                    final int i8 = 3;
                    i4 = this.byteBufferLength < i8 ? i5 : i7;
                    final String str5 = "Check failed.";
                    if (i4 == 0) {
                    } else {
                        startIndex = offset;
                        final int i9 = startIndex + length;
                        startIndex += copyIntoByteBuffer;
                        if (this.byteBufferLength != 0 && this.byteBufferLength != 0) {
                            startIndex += copyIntoByteBuffer;
                            if (this.byteBufferLength != 0) {
                            }
                        }
                        while (startIndex + 3 <= i9) {
                            if (this.base64.isMimeScheme$kotlin_stdlib()) {
                            } else {
                            }
                            lineLength = symbolBuffer.length;
                            i = Math.min(lineLength /= 4, i11 /= i8);
                            i2 = i * 3;
                            if (encodeIntoOutput(source, startIndex, startIndex + i2) == i * 4) {
                            } else {
                            }
                            i3 = i7;
                            startIndex += i2;
                            i3 = i5;
                            lineLength = this.lineLength;
                        }
                        ArraysKt.copyInto(source, this.byteBuffer, i7, startIndex, i9);
                        this.byteBufferLength = i9 - startIndex;
                    }
                    IllegalStateException startIndex2 = new IllegalStateException(str5.toString());
                    throw startIndex2;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("offset: ").append(offset).append(", length: ").append(length).append(", source size: ").append(source.length).toString());
        throw indexOutOfBoundsException;
    }
}
