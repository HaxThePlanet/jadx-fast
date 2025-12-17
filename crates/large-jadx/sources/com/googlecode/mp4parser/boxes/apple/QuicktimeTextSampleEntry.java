package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.b;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

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
    String fontName;
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
        int i = 65535;
        this.fontName = "";
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void addBox(a a) {
        RuntimeException obj2 = new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
        throw obj2;
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
    public void getBox(WritableByteChannel writableByteChannel) {
        int length;
        String fontName;
        writableByteChannel.write(getHeader());
        String fontName2 = this.fontName;
        if (fontName2 != null) {
            length = fontName2.length();
        } else {
            length = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length += 52);
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
        fontName = this.fontName;
        if (fontName != null) {
            g.j(allocate, fontName.length());
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
        int length;
        boolean largeBox;
        int i;
        long l;
        String fontName = this.fontName;
        if (fontName != null) {
            length = fontName.length();
        } else {
            length = 0;
        }
        i2 += l2;
        if (!this.largeBox) {
            if (Long.compare(i7, l) >= 0) {
                i = 16;
            } else {
                i = 8;
            }
        } else {
        }
        return i3 += l3;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getTextJustification() {
        return this.textJustification;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        byte[] obj1;
        Object obj2;
        obj2 = ByteBuffer.allocate(b.a(l3));
        a.read(obj2);
        obj2.position(6);
        this.dataReferenceIndex = e.i(obj2);
        this.displayFlags = obj2.getInt();
        this.textJustification = obj2.getInt();
        this.backgroundR = e.i(obj2);
        this.backgroundG = e.i(obj2);
        this.backgroundB = e.i(obj2);
        this.defaultTextBox = e.m(obj2);
        this.reserved1 = e.m(obj2);
        this.fontNumber = obj2.getShort();
        this.fontFace = obj2.getShort();
        this.reserved2 = obj2.get();
        this.reserved3 = obj2.getShort();
        this.foregroundR = e.i(obj2);
        this.foregroundG = e.i(obj2);
        this.foregroundB = e.i(obj2);
        if (obj2.remaining() > 0) {
            obj1 = new byte[e.n(obj2)];
            obj2.get(obj1);
            obj2 = new String(obj1);
            this.fontName = obj2;
        } else {
            this.fontName = 0;
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

    public void setBoxes(List<a> list) {
        RuntimeException obj2 = new RuntimeException("QuicktimeTextSampleEntries may not have child boxes");
        throw obj2;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setDefaultTextBox(long l) {
        this.defaultTextBox = l;
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
    public void setFontName(String string) {
        this.fontName = string;
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
    public void setReserved1(long l) {
        this.reserved1 = l;
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
