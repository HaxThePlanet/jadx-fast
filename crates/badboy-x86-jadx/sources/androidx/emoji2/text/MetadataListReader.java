package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
class MetadataListReader {

    private static final int EMJI_TAG = 1164798569;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 1835365473;

    private interface OpenTypeReader {

        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;
        public abstract long getPosition();

        public abstract int readTag() throws IOException;

        public abstract long readUnsignedInt() throws IOException;

        public abstract int readUnsignedShort() throws IOException;

        public abstract void skip(int i) throws IOException;
    }

    private static class ByteBufferReader implements androidx.emoji2.text.MetadataListReader.OpenTypeReader {

        private final ByteBuffer mByteBuffer;
        ByteBufferReader(ByteBuffer byteBuffer) {
            super();
            this.mByteBuffer = byteBuffer;
            this.mByteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader$OpenTypeReader
        public long getPosition() {
            return (long)position;
        }

        public int readTag() throws IOException {
            return this.mByteBuffer.getInt();
        }

        public long readUnsignedInt() throws IOException {
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        public int readUnsignedShort() throws IOException {
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        public void skip(int numOfBytes) throws IOException {
            this.mByteBuffer.position(position += numOfBytes);
        }
    }

    private static class InputStreamOpenTypeReader implements androidx.emoji2.text.MetadataListReader.OpenTypeReader {

        private final byte[] mByteArray;
        private final ByteBuffer mByteBuffer;
        private final InputStream mInputStream;
        private long mPosition = 0;
        InputStreamOpenTypeReader(InputStream inputStream) {
            super();
            int i = 0;
            this.mInputStream = inputStream;
            this.mByteArray = new byte[4];
            this.mByteBuffer = ByteBuffer.wrap(this.mByteArray);
            this.mByteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        private void read(int numOfBytes) throws IOException {
            if (this.mInputStream.read(this.mByteArray, 0, numOfBytes) != numOfBytes) {
            } else {
                this.mPosition = mPosition += l;
            }
            IOException iOException = new IOException("read failed");
            throw iOException;
        }

        @Override // androidx.emoji2.text.MetadataListReader$OpenTypeReader
        public long getPosition() {
            return this.mPosition;
        }

        public int readTag() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return this.mByteBuffer.getInt();
        }

        public long readUnsignedInt() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        public int readUnsignedShort() throws IOException {
            this.mByteBuffer.position(0);
            read(2);
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        public void skip(int numOfBytes) throws IOException {
            int i;
            int i2;
            long l;
            int obj6;
            while (obj6 > 0) {
                i = (int)skip;
                obj6 -= i;
                this.mPosition = mPosition += l;
            }
        }
    }

    private static class OffsetInfo {

        private final long mLength;
        private final long mStartOffset;
        OffsetInfo(long startOffset, long length) {
            super();
            this.mStartOffset = startOffset;
            this.mLength = obj3;
        }

        long getLength() {
            return this.mLength;
        }

        long getStartOffset() {
            return this.mStartOffset;
        }
    }
    private static androidx.emoji2.text.MetadataListReader.OffsetInfo findOffsetInfo(androidx.emoji2.text.MetadataListReader.OpenTypeReader reader) throws IOException {
        int i2;
        int i3;
        int metaOffset;
        int tag;
        int unsignedInt2;
        long unsignedInt;
        long unsignedInt3;
        int i4;
        long unsignedInt4;
        int i;
        int i5 = 4;
        reader.skip(i5);
        final int unsignedShort = reader.readUnsignedShort();
        String str = "Cannot read metadata.";
        if (unsignedShort > 100) {
        } else {
            reader.skip(6);
            metaOffset = -1;
            i3 = 0;
            while (i3 < unsignedShort) {
                reader.skip(i5);
                reader.skip(i5);
                if (1835365473 == reader.readTag()) {
                    break;
                } else {
                }
                i3++;
            }
            if (Long.compare(metaOffset, unsignedInt2) == 0) {
            } else {
                reader.skip((int)i11);
                reader.skip(12);
                i2 = 0;
                while (Long.compare(unsignedInt3, unsignedInt2) < 0) {
                    i3 = reader.readTag();
                    i2++;
                }
            }
            IOException i6 = new IOException(str);
            throw i6;
        }
        IOException iOException = new IOException(str);
        throw iOException;
    }

    static MetadataList read(AssetManager assetManager, String assetPath) throws IOException {
        Throwable th2;
        Throwable th;
        final InputStream open = assetManager.open(assetPath);
        if (open != null) {
            open.close();
        }
        return MetadataListReader.read(open);
    }

    static MetadataList read(InputStream inputStream) throws IOException {
        MetadataListReader.InputStreamOpenTypeReader inputStreamOpenTypeReader = new MetadataListReader.InputStreamOpenTypeReader(inputStream);
        final androidx.emoji2.text.MetadataListReader.OffsetInfo offsetInfo = MetadataListReader.findOffsetInfo(inputStreamOpenTypeReader);
        inputStreamOpenTypeReader.skip((int)i);
        ByteBuffer allocate = ByteBuffer.allocate((int)length);
        int read = inputStream.read(allocate.array());
        if (Long.compare(l, length2) != 0) {
        } else {
            return MetadataList.getRootAsMetadataList(allocate);
        }
        StringBuilder stringBuilder = new StringBuilder();
        IOException iOException = new IOException(stringBuilder.append("Needed ").append(offsetInfo.getLength()).append(" bytes, got ").append(read).toString());
        throw iOException;
    }

    static MetadataList read(ByteBuffer byteBuffer) throws IOException {
        final ByteBuffer duplicate = byteBuffer.duplicate();
        MetadataListReader.ByteBufferReader byteBufferReader = new MetadataListReader.ByteBufferReader(duplicate);
        duplicate.position((int)startOffset);
        return MetadataList.getRootAsMetadataList(duplicate);
    }

    static long toUnsignedInt(int value) {
        return l &= l2;
    }

    static int toUnsignedShort(short value) {
        return i &= value;
    }
}
