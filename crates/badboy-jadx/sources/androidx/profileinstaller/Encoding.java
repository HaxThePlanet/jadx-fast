package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* loaded from: classes5.dex */
class Encoding {

    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;
    static int bitsToBytes(int numberOfBits) {
        return i3 /= 8;
    }

    static byte[] compress(byte[] data) throws IOException {
        Throwable th2;
        Throwable th;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
        deflaterOutputStream.write(data);
        deflaterOutputStream.close();
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    static RuntimeException error(String message) {
        IllegalStateException illegalStateException = new IllegalStateException(message);
        return illegalStateException;
    }

    static byte[] read(InputStream is, int length) throws IOException {
        int offset;
        int read;
        final byte[] bArr = new byte[length];
        offset = 0;
        while (offset < length) {
            read = is.read(bArr, offset, length - offset);
            offset += read;
        }
        return bArr;
    }

    static byte[] readCompressed(InputStream is, int compressedDataSize, int uncompressedDataSize) throws IOException {
        int totalBytesRead;
        int totalBytesInflated;
        int read;
        boolean needsDictionary;
        Throwable inflate;
        Inflater inflater = new Inflater();
        final byte[] bArr = new byte[uncompressedDataSize];
        totalBytesRead = 0;
        totalBytesInflated = 0;
        byte[] bArr2 = new byte[2048];
        while (!inflater.finished()) {
            read = is.read(bArr2);
            inflater.setInput(bArr2, 0, read);
            totalBytesInflated += inflate;
            totalBytesRead += read;
        }
        if (totalBytesRead != compressedDataSize) {
        } else {
            if (!inflater.finished()) {
            } else {
                inflater.end();
                return bArr;
            }
            throw Encoding.error("Inflater did not finish");
        }
        StringBuilder stringBuilder = new StringBuilder();
        throw Encoding.error(stringBuilder.append("Didn't read enough bytes during decompression. expected=").append(compressedDataSize).append(" actual=").append(totalBytesRead).toString());
    }

    static String readString(InputStream is, int size) throws IOException {
        String string = new String(Encoding.read(is, size), StandardCharsets.UTF_8);
        return string;
    }

    static long readUInt(InputStream is, int numberOfBytes) throws IOException {
        int value;
        int i;
        long l;
        int i2;
        value = 0;
        i = 0;
        while (i < numberOfBytes) {
            value += i2;
            i++;
        }
        return value;
    }

    static int readUInt16(InputStream is) throws IOException {
        return (int)uInt;
    }

    static long readUInt32(InputStream is) throws IOException {
        return Encoding.readUInt(is, 4);
    }

    static int readUInt8(InputStream is) throws IOException {
        return (int)uInt;
    }

    static int utf8Length(String s) {
        return bytes.length;
    }

    static void writeAll(InputStream is, OutputStream os, FileLock lock) throws IOException {
        boolean valid;
        int i;
        int read;
        int i2;
        int i3 = 0;
        if (lock != null && lock.isValid()) {
            i = lock.isValid() ? 1 : i3;
        } else {
        }
        if (i == 0) {
        } else {
            byte[] bArr = new byte[512];
            read = is.read(bArr);
            while (read > 0) {
                os.write(bArr, i3, read);
                read = is.read(bArr);
            }
        }
        IOException iOException = new IOException("Unable to acquire a lock on the underlying file channel.");
        throw iOException;
    }

    static void writeCompressed(OutputStream os, byte[] data) throws IOException {
        Encoding.writeUInt32(os, (long)length);
        byte[] compress = Encoding.compress(data);
        Encoding.writeUInt32(os, (long)length2);
        os.write(compress);
    }

    static void writeString(OutputStream os, String s) throws IOException {
        os.write(s.getBytes(StandardCharsets.UTF_8));
    }

    static void writeUInt(OutputStream os, long value, int numberOfBytes) throws IOException {
        int i;
        byte b;
        int i2;
        final byte[] bArr = new byte[obj9];
        i = 0;
        while (i < obj9) {
            bArr[i] = (byte)i6;
            i++;
        }
        os.write(bArr);
    }

    static void writeUInt16(OutputStream os, int value) throws IOException {
        Encoding.writeUInt(os, (long)value, obj1);
    }

    static void writeUInt32(OutputStream os, long value) throws IOException {
        Encoding.writeUInt(os, value, obj3);
    }

    static void writeUInt8(OutputStream os, int value) throws IOException {
        Encoding.writeUInt(os, (long)value, obj1);
    }
}
