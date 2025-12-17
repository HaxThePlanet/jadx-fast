package com.google.firebase.crashlytics.internal.log;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
class QueueFile implements Closeable {

    static final int HEADER_LENGTH = 16;
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER;
    private final byte[] buffer;
    private int elementCount;
    int fileLength;
    private com.google.firebase.crashlytics.internal.log.QueueFile.Element first;
    private com.google.firebase.crashlytics.internal.log.QueueFile.Element last;
    private final RandomAccessFile raf;

    static class Element {

        static final int HEADER_LENGTH = 4;
        static final com.google.firebase.crashlytics.internal.log.QueueFile.Element NULL;
        final int length;
        final int position;
        static {
            final int i = 0;
            QueueFile.Element element = new QueueFile.Element(i, i);
            QueueFile.Element.NULL = element;
        }

        Element(int i, int i2) {
            super();
            this.position = i;
            this.length = i2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append("[position = ");
            stringBuilder.append(this.position);
            stringBuilder.append(", length = ");
            stringBuilder.append(this.length);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private final class ElementInputStream extends InputStream {

        private int position;
        private int remaining;
        final com.google.firebase.crashlytics.internal.log.QueueFile this$0;
        private ElementInputStream(com.google.firebase.crashlytics.internal.log.QueueFile queueFile, com.google.firebase.crashlytics.internal.log.QueueFile.Element queueFile$Element2) {
            this.this$0 = queueFile;
            super();
            this.position = QueueFile.access$100(queueFile, position += 4);
            this.remaining = element2.length;
        }

        ElementInputStream(com.google.firebase.crashlytics.internal.log.QueueFile queueFile, com.google.firebase.crashlytics.internal.log.QueueFile.Element queueFile$Element2, com.google.firebase.crashlytics.internal.log.QueueFile.1 queueFile$13) {
            super(queueFile, element2);
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile.access$400(this.this$0).seek((long)position);
            this.position = QueueFile.access$100(this.this$0, position2++);
            this.remaining = remaining2--;
            return QueueFile.access$400(this.this$0).read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int i;
            int obj5;
            QueueFile.access$200(bArr, "buffer");
            if (i2 | i3 < 0) {
            } else {
                if (i3 > length -= i2) {
                } else {
                    int remaining = this.remaining;
                    if (remaining > 0 && i3 > remaining) {
                        if (i3 > remaining) {
                            obj5 = remaining;
                        }
                        QueueFile.access$300(this.this$0, this.position, bArr, i2, obj5);
                        this.position = QueueFile.access$100(this.this$0, obj4 += obj5);
                        this.remaining = obj3 -= obj5;
                        return obj5;
                    }
                    return -1;
                }
            }
            ArrayIndexOutOfBoundsException obj3 = new ArrayIndexOutOfBoundsException();
            throw obj3;
        }
    }

    public interface ElementReader {
        public abstract void read(InputStream inputStream, int i2);
    }
    static {
        QueueFile.LOGGER = Logger.getLogger(QueueFile.class.getName());
    }

    public QueueFile(File file) {
        super();
        this.buffer = new byte[16];
        if (file.exists() == null) {
            QueueFile.initialize(file);
        }
        this.raf = QueueFile.open(file);
        readHeader();
    }

    QueueFile(RandomAccessFile randomAccessFile) {
        super();
        this.buffer = new byte[16];
        this.raf = randomAccessFile;
        readHeader();
    }

    static int access$100(com.google.firebase.crashlytics.internal.log.QueueFile queueFile, int i2) {
        return queueFile.wrapPosition(i2);
    }

    static Object access$200(Object object, String string2) {
        return QueueFile.nonNull(object, string2);
    }

    static void access$300(com.google.firebase.crashlytics.internal.log.QueueFile queueFile, int i2, byte[] b3Arr3, int i4, int i5) {
        queueFile.ringRead(i2, b3Arr3, i4, i5);
    }

    static RandomAccessFile access$400(com.google.firebase.crashlytics.internal.log.QueueFile queueFile) {
        return queueFile.raf;
    }

    private void expandIfNecessary(int i) {
        int remainingBytes;
        int fileLength;
        int position;
        int fileLength2;
        long transferTo;
        int elementCount;
        int i2;
        long l2;
        FileChannel channel;
        long l;
        int obj11;
        i += 4;
        if (remainingBytes() >= obj11) {
        }
        fileLength2 = this.fileLength;
        fileLength2 <<= 1;
        while (remainingBytes += fileLength2 >= obj11) {
            fileLength2 <<= 1;
        }
        setLength(fileLength2);
        obj11 = this.last;
        obj11 = wrapPosition(i3 += obj11);
        if (obj11 < first.position) {
            channel = this.raf.getChannel();
            channel.position((long)fileLength);
            l = (long)obj11;
            if (Long.compare(transferTo, l) != 0) {
            } else {
            }
            obj11 = new AssertionError("Copied insufficient number of bytes!");
            throw obj11;
        }
        obj11 = obj11.position;
        position = first2.position;
        if (obj11 < position) {
            i5 += -16;
            writeHeader(fileLength2, this.elementCount, position, elementCount);
            obj11 = new QueueFile.Element(elementCount, last.length);
            this.last = obj11;
        } else {
            writeHeader(fileLength2, this.elementCount, position, obj11);
        }
        this.fileLength = fileLength2;
    }

    private static void initialize(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".tmp");
        File file2 = new File(stringBuilder.toString());
        RandomAccessFile open = QueueFile.open(file2);
        open.setLength(4096);
        open.seek(0);
        byte[] bArr = new byte[16];
        int[] iArr = new int[4];
        final int i9 = 0;
        iArr[i9] = 4096;
        iArr[1] = i9;
        iArr[2] = i9;
        iArr[3] = i9;
        QueueFile.writeInts(bArr, iArr);
        open.write(bArr);
        open.close();
        if (file2.renameTo(file) == null) {
        } else {
        }
        IOException obj6 = new IOException("Rename failed!");
        throw obj6;
    }

    private static <T> T nonNull(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }

    private static RandomAccessFile open(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        return randomAccessFile;
    }

    private com.google.firebase.crashlytics.internal.log.QueueFile.Element readElement(int i) {
        if (i == 0) {
            return QueueFile.Element.NULL;
        }
        this.raf.seek((long)i);
        QueueFile.Element element = new QueueFile.Element(i, this.raf.readInt());
        return element;
    }

    private void readHeader() {
        this.raf.seek(0);
        this.raf.readFully(this.buffer);
        int int = QueueFile.readInt(this.buffer, 0);
        this.fileLength = int;
        if (Long.compare(l, length) > 0) {
        } else {
            this.elementCount = QueueFile.readInt(this.buffer, 4);
            this.first = readElement(QueueFile.readInt(this.buffer, 8));
            this.last = readElement(QueueFile.readInt(this.buffer, 12));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File is truncated. Expected length: ");
        stringBuilder.append(this.fileLength);
        stringBuilder.append(", Actual length: ");
        stringBuilder.append(this.raf.length());
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    private static int readInt(byte[] bArr, int i2) {
        return i5 += obj2;
    }

    private int remainingBytes() {
        return fileLength -= usedBytes;
    }

    private void ringRead(int i, byte[] b2Arr2, int i3, int i4) {
        RandomAccessFile raf;
        long l;
        int i2;
        RandomAccessFile obj5;
        int obj7;
        int obj8;
        obj5 = wrapPosition(i);
        int fileLength = this.fileLength;
        if (obj5 + i4 <= fileLength) {
            this.raf.seek((long)obj5);
            this.raf.readFully(b2Arr2, i3, i4);
        } else {
            fileLength -= obj5;
            this.raf.seek((long)obj5);
            this.raf.readFully(b2Arr2, i3, l);
            this.raf.seek(16);
            this.raf.readFully(b2Arr2, i3 += l, i4 -= l);
        }
    }

    private void ringWrite(int i, byte[] b2Arr2, int i3, int i4) {
        RandomAccessFile raf;
        long l;
        int i2;
        RandomAccessFile obj5;
        int obj7;
        int obj8;
        obj5 = wrapPosition(i);
        int fileLength = this.fileLength;
        if (obj5 + i4 <= fileLength) {
            this.raf.seek((long)obj5);
            this.raf.write(b2Arr2, i3, i4);
        } else {
            fileLength -= obj5;
            this.raf.seek((long)obj5);
            this.raf.write(b2Arr2, i3, l);
            this.raf.seek(16);
            this.raf.write(b2Arr2, i3 += l, i4 -= l);
        }
    }

    private void setLength(int i) {
        this.raf.setLength((long)i);
        this.raf.getChannel().force(true);
    }

    private int wrapPosition(int i) {
        int obj2;
        final int fileLength = this.fileLength;
        if (i < fileLength) {
        } else {
            obj2 -= fileLength;
        }
        return obj2;
    }

    private void writeHeader(int i, int i2, int i3, int i4) {
        int[] iArr = new int[4];
        QueueFile.writeInts(this.buffer, i, i2, i3, i4);
        this.raf.seek(0);
        this.raf.write(this.buffer);
    }

    private static void writeInt(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte)i;
        bArr[i2 + 1] = (byte)i6;
        bArr[i2 + 2] = (byte)i7;
        bArr[i2 += 3] = (byte)i3;
    }

    private static void writeInts(byte[] bArr, int... i2Arr2) {
        int i3;
        int i;
        int i2;
        i = i3;
        while (i3 < i2Arr2.length) {
            QueueFile.writeInt(bArr, i, i2Arr2[i3]);
            i += 4;
            i3++;
        }
    }

    @Override // java.io.Closeable
    public void add(byte[] bArr) {
        add(bArr, 0, bArr.length);
    }

    @Override // java.io.Closeable
    public void add(byte[] bArr, int i2, int i3) {
        int i4;
        int wrapPosition;
        int i;
        int obj7;
        QueueFile.nonNull(bArr, "buffer");
        synchronized (this) {
            try {
                if (i3 > length -= i2) {
                } else {
                }
                expandIfNecessary(i3);
                boolean empty = isEmpty();
                int i5 = 4;
                if (empty) {
                } else {
                }
                wrapPosition = 16;
                com.google.firebase.crashlytics.internal.log.QueueFile.Element last = this.last;
                wrapPosition = wrapPosition(i7 += length2);
                QueueFile.Element element = new QueueFile.Element(wrapPosition, i3);
                final int i8 = 0;
                QueueFile.writeInt(this.buffer, i8, i3);
                ringWrite(element.position, this.buffer, i8, i5);
                ringWrite(position3 += i5, bArr, i2, i3);
                if (empty) {
                } else {
                }
                obj7 = element.position;
                obj7 = obj7.position;
                writeHeader(this.fileLength, obj9++, obj7, element.position);
                this.last = element;
                this.elementCount = obj7++;
                if (empty) {
                }
                this.first = element;
                obj7 = new IndexOutOfBoundsException();
                throw obj7;
                throw bArr;
            }
        }
    }

    @Override // java.io.Closeable
    public void clear() {
        int i = 0;
        final int i2 = 4096;
        writeHeader(i2, i, i, i);
        this.elementCount = i;
        com.google.firebase.crashlytics.internal.log.QueueFile.Element nULL = QueueFile.Element.NULL;
        this.first = nULL;
        this.last = nULL;
        synchronized (this) {
            setLength(i2);
            this.fileLength = i2;
        }
    }

    @Override // java.io.Closeable
    public void close() {
        this.raf.close();
        return;
        synchronized (this) {
            this.raf.close();
        }
    }

    @Override // java.io.Closeable
    public void forEach(com.google.firebase.crashlytics.internal.log.QueueFile.ElementReader queueFile$ElementReader) {
        int wrapPosition;
        int i;
        int i2;
        int length;
        wrapPosition = first.position;
        i = 0;
        synchronized (this) {
            try {
                while (i < this.elementCount) {
                    com.google.firebase.crashlytics.internal.log.QueueFile.Element element = readElement(wrapPosition);
                    QueueFile.ElementInputStream elementInputStream = new QueueFile.ElementInputStream(this, element, 0);
                    elementReader.read(elementInputStream, element.length);
                    wrapPosition = wrapPosition(i3 += length2);
                    i++;
                }
                element = readElement(wrapPosition);
                elementInputStream = new QueueFile.ElementInputStream(this, element, 0);
                elementReader.read(elementInputStream, element.length);
                wrapPosition = wrapPosition(i3 += length2);
                i++;
                throw elementReader;
            }
        }
    }

    @Override // java.io.Closeable
    public boolean hasSpaceFor(int i, int i2) {
        int obj2;
        obj2 = i3 += i <= i2 ? 1 : 0;
        return obj2;
    }

    @Override // java.io.Closeable
    public boolean isEmpty() {
        int i;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
            }
            return i;
        }
    }

    @Override // java.io.Closeable
    public void peek(com.google.firebase.crashlytics.internal.log.QueueFile.ElementReader queueFile$ElementReader) {
        int elementInputStream;
        int length;
        int i;
        synchronized (this) {
            try {
                elementInputStream = new QueueFile.ElementInputStream(this, this.first, 0);
                elementReader.read(elementInputStream, first2.length);
                throw elementReader;
            }
        }
    }

    @Override // java.io.Closeable
    public byte[] peek() {
        synchronized (this) {
            try {
                return null;
                com.google.firebase.crashlytics.internal.log.QueueFile.Element first = this.first;
                final int length = first.length;
                final byte[] bArr = new byte[length];
                ringRead(position += 4, bArr, 0, length);
                return bArr;
                throw th;
            }
        }
    }

    @Override // java.io.Closeable
    public void remove() {
        int elementCount;
        com.google.firebase.crashlytics.internal.log.QueueFile.Element element;
        int int;
        int i2;
        int i;
        int position;
        synchronized (this) {
            try {
                element = 1;
                if (this.elementCount == element) {
                } else {
                }
                clear();
                com.google.firebase.crashlytics.internal.log.QueueFile.Element first = this.first;
                int i5 = 4;
                elementCount = wrapPosition(i3 += length);
                int i6 = 0;
                ringRead(elementCount, this.buffer, i6, i5);
                writeHeader(this.fileLength, elementCount3 -= element, elementCount, last.position);
                this.elementCount = elementCount2 -= element;
                element = new QueueFile.Element(elementCount, QueueFile.readInt(this.buffer, i6));
                this.first = element;
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                throw noSuchElementException;
                throw th;
            }
        }
    }

    @Override // java.io.Closeable
    public int size() {
        return this.elementCount;
        synchronized (this) {
            return this.elementCount;
        }
    }

    @Override // java.io.Closeable
    public String toString() {
        com.google.firebase.crashlytics.internal.log.QueueFile.1 anon;
        Logger lOGGER;
        Level wARNING;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append('[');
        stringBuilder.append("fileLength=");
        stringBuilder.append(this.fileLength);
        stringBuilder.append(", size=");
        stringBuilder.append(this.elementCount);
        stringBuilder.append(", first=");
        stringBuilder.append(this.first);
        stringBuilder.append(", last=");
        stringBuilder.append(this.last);
        stringBuilder.append(", element lengths=[");
        anon = new QueueFile.1(this, stringBuilder);
        forEach(anon);
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    @Override // java.io.Closeable
    public int usedBytes() {
        final int i = 16;
        if (this.elementCount == 0) {
            return i;
        }
        com.google.firebase.crashlytics.internal.log.QueueFile.Element last = this.last;
        int position = last.position;
        int position2 = first.position;
        if (position >= position2) {
            return i4 += i;
        }
        return i8 -= position2;
    }
}
