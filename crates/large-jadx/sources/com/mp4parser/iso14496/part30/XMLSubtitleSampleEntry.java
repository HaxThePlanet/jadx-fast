package com.mp4parser.iso14496.part30;

import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class XMLSubtitleSampleEntry extends AbstractSampleEntry {

    public static final String TYPE = "stpp";
    private String auxiliaryMimeTypes;
    private String namespace;
    private String schemaLocation;
    public XMLSubtitleSampleEntry() {
        super("stpp");
        String str2 = "";
        this.namespace = str2;
        this.schemaLocation = str2;
        this.auxiliaryMimeTypes = str2;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String getAuxiliaryMimeTypes() {
        return this.auxiliaryMimeTypes;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(i3 += 3);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        g.l(allocate, this.namespace);
        g.l(allocate, this.schemaLocation);
        g.l(allocate, this.auxiliaryMimeTypes);
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writeContainer(writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String getNamespace() {
        return this.namespace;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String getSchemaLocation() {
        return this.schemaLocation;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        int largeBox;
        int i2;
        int i;
        long l;
        containerSize += i;
        if (!this.largeBox) {
            if (Long.compare(i, l) >= 0) {
                i2 = 16;
            }
        } else {
        }
        return i3 += l2;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        a.read((ByteBuffer)allocate.rewind());
        int i7 = 6;
        allocate.position(i7);
        this.dataReferenceIndex = e.i(allocate);
        long l = a.w0();
        ByteBuffer allocate2 = ByteBuffer.allocate(1024);
        a.read((ByteBuffer)allocate2.rewind());
        String str2 = e.g((ByteBuffer)allocate2.rewind());
        this.namespace = str2;
        a.Z1(i10 += i15);
        a.read((ByteBuffer)allocate2.rewind());
        this.schemaLocation = e.g((ByteBuffer)allocate2.rewind());
        a.Z1(i13 += i16);
        a.read((ByteBuffer)allocate2.rewind());
        this.auxiliaryMimeTypes = e.g((ByteBuffer)allocate2.rewind());
        a.Z1(i5 += i9);
        initContainer(a, l3 -= l2, b4);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setAuxiliaryMimeTypes(String string) {
        this.auxiliaryMimeTypes = string;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setNamespace(String string) {
        this.namespace = string;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSchemaLocation(String string) {
        this.schemaLocation = string;
    }
}
