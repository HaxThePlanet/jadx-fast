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

/* compiled from: XMLSubtitleSampleEntry.java */
/* loaded from: classes2.dex */
public class XMLSubtitleSampleEntry extends AbstractSampleEntry {

    public static final String TYPE = "stpp";
    private String auxiliaryMimeTypes = "";
    private String namespace = "";
    private String schemaLocation = "";
    public XMLSubtitleSampleEntry() {
        super("stpp");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String getAuxiliaryMimeTypes() {
        return this.auxiliaryMimeTypes;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate((this.namespace.length() + 8) + this.schemaLocation.length() + this.auxiliaryMimeTypes.length() + 3);
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
        boolean largeBox2;
        int i = 8;
        long l;
        long l2 = 4294967296L;
        i = 8;
        l = (long)(this.namespace.length() + i) + this.schemaLocation.length() + this.auxiliaryMimeTypes.length() + 3;
        long l3 = getContainerSize() + l;
        if (!this.largeBox) {
            l = 8L + l3;
            l2 = 4294967296L;
            if (this.auxiliaryMimeTypes >= l2) {
                i = 16;
            }
        }
        return l3 + (long)i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        aVar.read((ByteBuffer)allocate.rewind());
        int i3 = 6;
        allocate.position(i3);
        this.dataReferenceIndex = e.i(allocate);
        long l = aVar.w0();
        ByteBuffer allocate2 = ByteBuffer.allocate(1024);
        aVar.read((ByteBuffer)allocate2.rewind());
        String str2 = e.g((ByteBuffer)allocate2.rewind());
        this.namespace = str2;
        aVar.Z1((long)str2.length() + l + 1L);
        aVar.read((ByteBuffer)allocate2.rewind());
        this.schemaLocation = e.g((ByteBuffer)allocate2.rewind());
        aVar.Z1((long)this.namespace.length() + l + (long)this.schemaLocation.length() + 2L);
        aVar.read((ByteBuffer)allocate2.rewind());
        this.auxiliaryMimeTypes = e.g((ByteBuffer)allocate2.rewind());
        aVar.Z1((l + (long)this.namespace.length()) + (long)this.schemaLocation.length() + (long)this.auxiliaryMimeTypes.length() + 3L);
        initContainer(aVar, j - (long)(byteBuffer.remaining() + this.namespace.length()) + this.schemaLocation.length() + this.auxiliaryMimeTypes.length() + 3, bVar);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setAuxiliaryMimeTypes(String str) {
        this.auxiliaryMimeTypes = str;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setNamespace(String str) {
        this.namespace = str;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSchemaLocation(String str) {
        this.schemaLocation = str;
    }
}
