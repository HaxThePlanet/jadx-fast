package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

/* compiled from: QuicktimeTextSampleEntry.java */
/* loaded from: classes2.dex */
public class QuicktimeTextSampleEntry extends AbstractSampleEntry {

    public static final String TYPE = "text";
    int backgroundB;
    int backgroundG;
    int backgroundR;
    int dataReferenceIndex;
    long defaultTextBox;
    int displayFlags;
    short fontFace;
    String fontName = "";
    short fontNumber;
    int foregroundB = 65535;
    int foregroundG = 65535;
    int foregroundR = 65535;
    long reserved1;
    byte reserved2;
    short reserved3;
    int textJustification;
    public QuicktimeTextSampleEntry() {
        super("text");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void addBox(com.coremedia.iso.boxes.a aVar) {
        throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getBackgroundB() {
        return this.backgroundB;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getBackgroundG() {
        return this.backgroundG;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getBackgroundR() {
        return this.backgroundR;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.UnsupportedEncodingException, java.io.IOException {
        int length = 0;
        writableByteChannel.write(getHeader());
        if (this.fontName != null) {
            length = this.fontName.length();
        } else {
            length = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length + 52);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        allocate.putInt(this.displayFlags);
        allocate.putInt(this.textJustification);
        g.e(allocate, this.backgroundR);
        g.e(allocate, this.backgroundG);
        g.e(allocate, this.backgroundB);
        g.i(allocate, this.defaultTextBox);
        g.i(allocate, this.reserved1);
        allocate.putShort(this.fontNumber);
        allocate.putShort(this.fontFace);
        allocate.put(this.reserved2);
        allocate.putShort(this.reserved3);
        g.e(allocate, this.foregroundR);
        g.e(allocate, this.foregroundG);
        g.e(allocate, this.foregroundB);
        if (this.fontName != null) {
            g.j(allocate, this.fontName.length());
            allocate.put(this.fontName.getBytes());
        }
        writableByteChannel.write((ByteBuffer)allocate.rewind());
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getDefaultTextBox() {
        return this.defaultTextBox;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getDisplayFlags() {
        return this.displayFlags;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public short getFontFace() {
        return this.fontFace;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String getFontName() {
        return this.fontName;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public short getFontNumber() {
        return this.fontNumber;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getForegroundB() {
        return this.foregroundB;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getForegroundG() {
        return this.foregroundG;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getForegroundR() {
        return this.foregroundR;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getReserved1() {
        return this.reserved1;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public byte getReserved2() {
        return this.reserved2;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public short getReserved3() {
        return this.reserved3;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        int length = 0;
        int i = 16;
        long l = 4294967296L;
        if (this.fontName != null) {
            length = this.fontName.length();
        } else {
            length = 0;
        }
        long l3 = (getContainerSize() + 52L) + (long)length;
        if (!this.largeBox) {
            long l7 = 8L + l3;
            l = 4294967296L;
            if (this.largeBox >= l) {
                i = 16;
            } else {
                i = 8;
            }
        }
        return l3 + (long)i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getTextJustification() {
        return this.textJustification;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(com.googlecode.mp4parser.a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) throws java.io.UnsupportedEncodingException {
        ByteBuffer allocate = ByteBuffer.allocate(b.a(j));
        aVar.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = e.i(allocate);
        this.displayFlags = allocate.getInt();
        this.textJustification = allocate.getInt();
        this.backgroundR = e.i(allocate);
        this.backgroundG = e.i(allocate);
        this.backgroundB = e.i(allocate);
        this.defaultTextBox = e.m(allocate);
        this.reserved1 = e.m(allocate);
        this.fontNumber = allocate.getShort();
        this.fontFace = allocate.getShort();
        this.reserved2 = allocate.get();
        this.reserved3 = allocate.getShort();
        this.foregroundR = e.i(allocate);
        this.foregroundG = e.i(allocate);
        this.foregroundB = e.i(allocate);
        if (allocate.remaining() > 0) {
            byte[] bArr = new byte[e.n(allocate)];
            allocate.get(bArr);
            this.fontName = new String(bArr);
        } else {
            this.fontName = null;
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBackgroundB(int i) {
        this.backgroundB = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBackgroundG(int i) {
        this.backgroundG = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBackgroundR(int i) {
        this.backgroundR = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBoxes(List<com.coremedia.iso.boxes.a> list) {
        throw new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setDefaultTextBox(long j) {
        this.defaultTextBox = j;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setDisplayFlags(int i) {
        this.displayFlags = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setFontFace(short s) {
        this.fontFace = s;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setFontName(String str) {
        this.fontName = str;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setFontNumber(short s) {
        this.fontNumber = s;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setForegroundB(int i) {
        this.foregroundB = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setForegroundG(int i) {
        this.foregroundG = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setForegroundR(int i) {
        this.foregroundR = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setReserved1(long j) {
        this.reserved1 = j;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setReserved2(byte b) {
        this.reserved2 = b;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setReserved3(short s) {
        this.reserved3 = s;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setTextJustification(int i) {
        this.textJustification = i;
    }
}
