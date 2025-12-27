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

/* compiled from: TextSampleEntry.java */
/* loaded from: classes.dex */
public class TextSampleEntry extends AbstractSampleEntry {

    public static final String TYPE1 = "tx3g";
    public static final String TYPE_ENCRYPTED = "enct";
    private int[] backgroundColorRgba;
    private TextSampleEntry.a boxRecord = new TextSampleEntry$a();
    private long displayFlags;
    private int horizontalJustification;
    private TextSampleEntry.b styleRecord = new TextSampleEntry$b();
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
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = TextSampleEntry.a.class;
                if (obj == object.getClass()) {
                    if (this.c != object.c) {
                        return false;
                    }
                    if (this.b != object.b) {
                        return false;
                    }
                    if (this.d != object.d) {
                        return false;
                    }
                    return this.a != object.a ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 31) + this.b * 31 + this.c * 31 + this.d;
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
            this.f = new int[] { 255, 255, 255, 255 };
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
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = TextSampleEntry.b.class;
                if (obj == object.getClass()) {
                    if (this.b != object.b) {
                        return false;
                    }
                    if (this.d != object.d) {
                        return false;
                    }
                    if (this.c != object.c) {
                        return false;
                    }
                    if (this.e != object.e) {
                        return false;
                    }
                    if (this.a != object.a) {
                        return false;
                    }
                    return !Arrays.equals(this.f, object.f) ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            if (this.f != null) {
                i = Arrays.hashCode(this.f);
            } else {
                i = 0;
            }
            return (this.a * 31) + this.b * 31 + this.c * 31 + this.d * 31 + this.e * 31 + i;
        }
    }
    public TextSampleEntry() {
        super("tx3g");
        this.backgroundColorRgba = new int[4];
        com.coremedia.iso.boxes.sampleentry.TextSampleEntry.a aVar = new TextSampleEntry.a();
        com.coremedia.iso.boxes.sampleentry.TextSampleEntry.b bVar = new TextSampleEntry.b();
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int[] getBackgroundColorRgba() {
        return this.backgroundColorRgba;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
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
    public TextSampleEntry.a getBoxRecord() {
        return this.boxRecord;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getHorizontalJustification() {
        return this.horizontalJustification;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        int i = 8;
        long l = getContainerSize() + 38L;
        if (!this.largeBox) {
            if (l >= 4294967296L) {
                i = 16;
            } else {
                i = 8;
            }
        }
        return l + (long)i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public TextSampleEntry.b getStyleRecord() {
        return this.styleRecord;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getVerticalJustification() {
        return this.verticalJustification;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isContinuousKaraoke() {
        final long l2 = 2048L;
        long l = this.displayFlags & l2;
        if (this.displayFlags == l2) {
            return true;
        }
        return false;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isFillTextRegion() {
        final long l2 = 262144L;
        long l = this.displayFlags & l2;
        if (this.displayFlags == l2) {
            return true;
        }
        return false;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isScrollDirection() {
        final long l2 = 384L;
        long l = this.displayFlags & l2;
        if (this.displayFlags == l2) {
            return true;
        }
        return false;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isScrollIn() {
        final long l2 = 32L;
        long l = this.displayFlags & l2;
        if (this.displayFlags == l2) {
            return true;
        }
        return false;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isScrollOut() {
        final long l2 = 64L;
        long l = this.displayFlags & l2;
        if (this.displayFlags == l2) {
            return true;
        }
        return false;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public boolean isWriteTextVertically() {
        final long l2 = 131072L;
        long l = this.displayFlags & l2;
        if (this.displayFlags == l2) {
            return true;
        }
        return false;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(38);
        aVar.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = e.i(allocate);
        this.displayFlags = e.k(allocate);
        this.horizontalJustification = e.n(allocate);
        this.verticalJustification = e.n(allocate);
        int[] iArr = new int[4];
        this.backgroundColorRgba = iArr;
        this.backgroundColorRgba[1] = e.n(allocate);
        this.backgroundColorRgba[2] = e.n(allocate);
        this.backgroundColorRgba[3] = e.n(allocate);
        com.coremedia.iso.boxes.sampleentry.TextSampleEntry.a aVar2 = new TextSampleEntry.a();
        this.boxRecord = aVar2;
        aVar2.b(allocate);
        bVar = new TextSampleEntry.b();
        this.styleRecord = bVar;
        bVar.b(allocate);
        initContainer(aVar, j - 38L, bVar);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBackgroundColorRgba(int[] iArr) {
        this.backgroundColorRgba = iArr;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBoxRecord(TextSampleEntry.a aVar) {
        this.boxRecord = aVar;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setContinuousKaraoke(boolean z) {
        if (z) {
            long l2 = 2048L;
            this.displayFlags |= l2;
        } else {
            l2 = -2049L;
            this.displayFlags &= l2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setFillTextRegion(boolean z) {
        if (z) {
            long l2 = 262144L;
            this.displayFlags |= l2;
        } else {
            l2 = -262145L;
            this.displayFlags &= l2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setHorizontalJustification(int i) {
        this.horizontalJustification = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setScrollDirection(boolean z) {
        if (z) {
            long l2 = 384L;
            this.displayFlags |= l2;
        } else {
            l2 = -385L;
            this.displayFlags &= l2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setScrollIn(boolean z) {
        if (z) {
            long l2 = 32L;
            this.displayFlags |= l2;
        } else {
            l2 = -33L;
            this.displayFlags &= l2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setScrollOut(boolean z) {
        if (z) {
            long l2 = 64L;
            this.displayFlags |= l2;
        } else {
            l2 = -65L;
            this.displayFlags &= l2;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setStyleRecord(TextSampleEntry.b bVar) {
        this.styleRecord = bVar;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setType(String str) {
        this.type = str;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setVerticalJustification(int i) {
        this.verticalJustification = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setWriteTextVertically(boolean z) {
        if (z) {
            long l2 = 131072L;
            this.displayFlags |= l2;
        } else {
            l2 = -131073L;
            this.displayFlags &= l2;
        }
    }

    public TextSampleEntry(String str) {
        super(str);
        this.backgroundColorRgba = new int[4];
        com.coremedia.iso.boxes.sampleentry.TextSampleEntry.a aVar = new TextSampleEntry.a();
        com.coremedia.iso.boxes.sampleentry.TextSampleEntry.b bVar = new TextSampleEntry.b();
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String toString() {
        return "TextSampleEntry";
    }
}
