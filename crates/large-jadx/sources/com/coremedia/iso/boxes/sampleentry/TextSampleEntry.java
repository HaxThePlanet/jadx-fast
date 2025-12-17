package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

/* loaded from: classes.dex */
public class TextSampleEntry extends com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry {

    public static final String TYPE1 = "tx3g";
    public static final String TYPE_ENCRYPTED = "enct";
    private int[] backgroundColorRgba;
    private com.coremedia.iso.boxes.sampleentry.TextSampleEntry.a boxRecord;
    private long displayFlags;
    private int horizontalJustification;
    private com.coremedia.iso.boxes.sampleentry.TextSampleEntry.b styleRecord;
    private int verticalJustification;

    public static class a {

        int a;
        int b;
        int c;
        int d;
        public void a(ByteBuffer byteBuffer) {
            g.e(byteBuffer, this.a);
            g.e(byteBuffer, this.b);
            g.e(byteBuffer, this.c);
            g.e(byteBuffer, this.d);
        }

        public void b(ByteBuffer byteBuffer) {
            this.a = e.i(byteBuffer);
            this.b = e.i(byteBuffer);
            this.c = e.i(byteBuffer);
            this.d = e.i(byteBuffer);
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.sampleentry.TextSampleEntry.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (TextSampleEntry.a.class != object.getClass()) {
                } else {
                    if (this.c != object.c) {
                        return i2;
                    }
                    if (this.b != object.b) {
                        return i2;
                    }
                    if (this.d != object.d) {
                        return i2;
                    }
                    if (this.a != object.a) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            return i6 += i10;
        }
    }

    public static class b {

        int a;
        int b;
        int c;
        int d;
        int e;
        int[] f;
        public b() {
            super();
            int[] iArr = new int[4];
            iArr = new int[]{255, 255, 255, 255};
            this.f = iArr;
        }

        public void a(ByteBuffer byteBuffer) {
            g.e(byteBuffer, this.a);
            g.e(byteBuffer, this.b);
            g.e(byteBuffer, this.c);
            g.j(byteBuffer, this.d);
            g.j(byteBuffer, this.e);
            g.j(byteBuffer, this.f[0]);
            g.j(byteBuffer, this.f[1]);
            g.j(byteBuffer, this.f[2]);
            g.j(byteBuffer, this.f[3]);
        }

        public void b(ByteBuffer byteBuffer) {
            this.a = e.i(byteBuffer);
            this.b = e.i(byteBuffer);
            this.c = e.i(byteBuffer);
            this.d = e.n(byteBuffer);
            this.e = e.n(byteBuffer);
            int[] iArr = new int[4];
            this.f = iArr;
            this.f[1] = e.n(byteBuffer);
            this.f[2] = e.n(byteBuffer);
            this.f[3] = e.n(byteBuffer);
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.sampleentry.TextSampleEntry.b> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (TextSampleEntry.b.class != object.getClass()) {
                } else {
                    if (this.b != object.b) {
                        return i2;
                    }
                    if (this.d != object.d) {
                        return i2;
                    }
                    if (this.c != object.c) {
                        return i2;
                    }
                    if (this.e != object.e) {
                        return i2;
                    }
                    if (this.a != object.a) {
                        return i2;
                    }
                    if (!Arrays.equals(this.f, object.f)) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            int i;
            int[] iArr = this.f;
            if (iArr != null) {
                i = Arrays.hashCode(iArr);
            } else {
                i = 0;
            }
            return i11 += i;
        }
    }
    public TextSampleEntry() {
        super("tx3g");
        this.backgroundColorRgba = new int[4];
        TextSampleEntry.a aVar = new TextSampleEntry.a();
        this.boxRecord = aVar;
        TextSampleEntry.b bVar = new TextSampleEntry.b();
        this.styleRecord = bVar;
    }

    public TextSampleEntry(String string) {
        super(string);
        this.backgroundColorRgba = new int[4];
        TextSampleEntry.a obj1 = new TextSampleEntry.a();
        this.boxRecord = obj1;
        obj1 = new TextSampleEntry.b();
        this.styleRecord = obj1;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int[] getBackgroundColorRgba() {
        return this.backgroundColorRgba;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(38);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        g.g(allocate, this.displayFlags);
        g.j(allocate, this.horizontalJustification);
        g.j(allocate, this.verticalJustification);
        g.j(allocate, this.backgroundColorRgba[0]);
        g.j(allocate, this.backgroundColorRgba[1]);
        g.j(allocate, this.backgroundColorRgba[2]);
        g.j(allocate, this.backgroundColorRgba[3]);
        this.boxRecord.a(allocate);
        this.styleRecord.a(allocate);
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writeContainer(writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public com.coremedia.iso.boxes.sampleentry.TextSampleEntry.a getBoxRecord() {
        return this.boxRecord;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getHorizontalJustification() {
        return this.horizontalJustification;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        int i;
        boolean largeBox;
        containerSize += i4;
        if (!this.largeBox) {
            if (Long.compare(i2, l) >= 0) {
                i = 16;
            } else {
                i = 8;
            }
        } else {
        }
        return i2 += l2;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public com.coremedia.iso.boxes.sampleentry.TextSampleEntry.b getStyleRecord() {
        return this.styleRecord;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getVerticalJustification() {
        return this.verticalJustification;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isContinuousKaraoke() {
        final int i4 = 2048;
        if (Long.compare(i, i4) == 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isFillTextRegion() {
        final int i4 = 262144;
        if (Long.compare(i, i4) == 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isScrollDirection() {
        final int i4 = 384;
        if (Long.compare(i, i4) == 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isScrollIn() {
        final int i4 = 32;
        if (Long.compare(i, i4) == 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isScrollOut() {
        final int i4 = 64;
        if (Long.compare(i, i4) == 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isWriteTextVertically() {
        final int i4 = 131072;
        if (Long.compare(i, i4) == 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        ByteBuffer obj5 = ByteBuffer.allocate(38);
        a.read(obj5);
        obj5.position(6);
        this.dataReferenceIndex = e.i(obj5);
        this.displayFlags = e.k(obj5);
        this.horizontalJustification = e.n(obj5);
        this.verticalJustification = e.n(obj5);
        int[] iArr = new int[4];
        this.backgroundColorRgba = iArr;
        this.backgroundColorRgba[1] = e.n(obj5);
        this.backgroundColorRgba[2] = e.n(obj5);
        this.backgroundColorRgba[3] = e.n(obj5);
        TextSampleEntry.a aVar = new TextSampleEntry.a();
        this.boxRecord = aVar;
        aVar.b(obj5);
        TextSampleEntry.b bVar = new TextSampleEntry.b();
        this.styleRecord = bVar;
        bVar.b(obj5);
        initContainer(a, l3 -= i6, b4);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBackgroundColorRgba(int[] iArr) {
        this.backgroundColorRgba = iArr;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBoxRecord(com.coremedia.iso.boxes.sampleentry.TextSampleEntry.a textSampleEntry$a) {
        this.boxRecord = a;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setContinuousKaraoke(boolean z) {
        int i;
        int i2;
        if (z) {
            this.displayFlags = displayFlags |= i2;
        } else {
            this.displayFlags = displayFlags2 &= i2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setFillTextRegion(boolean z) {
        int i;
        int i2;
        if (z) {
            this.displayFlags = displayFlags |= i2;
        } else {
            this.displayFlags = displayFlags2 &= i2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setHorizontalJustification(int i) {
        this.horizontalJustification = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setScrollDirection(boolean z) {
        int i;
        int i2;
        if (z) {
            this.displayFlags = displayFlags |= i2;
        } else {
            this.displayFlags = displayFlags2 &= i2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setScrollIn(boolean z) {
        int i2;
        int i;
        if (z) {
            this.displayFlags = displayFlags |= i;
        } else {
            this.displayFlags = displayFlags2 &= i;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setScrollOut(boolean z) {
        int i2;
        int i;
        if (z) {
            this.displayFlags = displayFlags |= i;
        } else {
            this.displayFlags = displayFlags2 &= i;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setStyleRecord(com.coremedia.iso.boxes.sampleentry.TextSampleEntry.b textSampleEntry$b) {
        this.styleRecord = b;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setType(String string) {
        this.type = string;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setVerticalJustification(int i) {
        this.verticalJustification = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setWriteTextVertically(boolean z) {
        int i;
        int i2;
        if (z) {
            this.displayFlags = displayFlags |= i2;
        } else {
            this.displayFlags = displayFlags2 &= i2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String toString() {
        return "TextSampleEntry";
    }
}
