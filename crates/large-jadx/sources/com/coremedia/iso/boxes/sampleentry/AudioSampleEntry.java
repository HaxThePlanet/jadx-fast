package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import f.b.a.e;
import f.b.a.g;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: AudioSampleEntry.java */
/* loaded from: classes.dex */
public final class AudioSampleEntry extends AbstractSampleEntry {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE1 = "samr";
    public static final String TYPE10 = "mlpa";
    public static final String TYPE11 = "dtsl";
    public static final String TYPE12 = "dtsh";
    public static final String TYPE13 = "dtse";
    public static final String TYPE2 = "sawb";
    public static final String TYPE3 = "mp4a";
    public static final String TYPE4 = "drms";
    public static final String TYPE5 = "alac";
    public static final String TYPE7 = "owma";
    public static final String TYPE8 = "ac-3";
    public static final String TYPE9 = "ec-3";
    public static final String TYPE_ENCRYPTED = "enca";
    private long bytesPerFrame;
    private long bytesPerPacket;
    private long bytesPerSample;
    private int channelCount;
    private int compressionId;
    private int packetSize;
    private int reserved1;
    private long reserved2;
    private long sampleRate;
    private int sampleSize;
    private long samplesPerPacket;
    private int soundVersion;
    private byte[] soundVersion2Data;

    public AudioSampleEntry(String str) {
        super(str);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        int i = 0;
        writableByteChannel.write(getHeader());
        i = 16;
        i = 0;
        final int i3 = 1;
        int r4 = this.soundVersion == i3 ? i : 0;
        final int i6 = 2;
        if (this.soundVersion == i6) {
            i = 36;
        }
        ByteBuffer allocate = ByteBuffer.allocate((this.soundVersion == i3 ? i : 0) + 28 + i);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        g.e(allocate, this.soundVersion);
        g.e(allocate, this.reserved1);
        g.g(allocate, this.reserved2);
        g.e(allocate, this.channelCount);
        g.e(allocate, this.sampleSize);
        g.e(allocate, this.compressionId);
        g.e(allocate, this.packetSize);
        boolean equals = this.type.equals("mlpa");
        if (equals) {
            g.g(allocate, getSampleRate());
        } else {
            sampleRate = getSampleRate() << 16L;
            g.g(allocate, sampleRate);
        }
        if (this.soundVersion == i3) {
            g.g(allocate, this.samplesPerPacket);
            g.g(allocate, this.bytesPerPacket);
            g.g(allocate, this.bytesPerFrame);
            g.g(allocate, this.bytesPerSample);
        }
        if (this.soundVersion == i6) {
            g.g(allocate, this.samplesPerPacket);
            g.g(allocate, this.bytesPerPacket);
            g.g(allocate, this.bytesPerFrame);
            g.g(allocate, this.bytesPerSample);
            allocate.put(this.soundVersion2Data);
        }
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writeContainer(writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getBytesPerFrame() {
        return this.bytesPerFrame;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getBytesPerPacket() {
        return this.bytesPerPacket;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getBytesPerSample() {
        return this.bytesPerSample;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getCompressionId() {
        return this.compressionId;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getPacketSize() {
        return this.packetSize;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getReserved1() {
        return this.reserved1;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getReserved2() {
        return this.reserved2;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSampleRate() {
        return this.sampleRate;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getSampleSize() {
        return this.sampleSize;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSamplesPerPacket() {
        return this.samplesPerPacket;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        int i = 16;
        i = 16;
        i = 0;
        int r3 = this.soundVersion == 1 ? 16 : 0;
        if (this.soundVersion == 2) {
            i = 36;
        }
        long l4 = (long)(this.soundVersion == 1 ? 16 : 0) + 28 + i + getContainerSize();
        if (!this.largeBox) {
            containerSize = 8L + l4;
            long l = 4294967296L;
            if (containerSize < l) {
                i = 8;
            }
        }
        return l4 + (long)i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public int getSoundVersion() {
        return this.soundVersion;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public byte[] getSoundVersion2Data() {
        return this.soundVersion2Data;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(com.googlecode.mp4parser.a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        int i = 16;
        ByteBuffer allocate = ByteBuffer.allocate(28);
        aVar.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = e.i(allocate);
        this.soundVersion = e.i(allocate);
        this.reserved1 = e.i(allocate);
        this.reserved2 = e.k(allocate);
        this.channelCount = e.i(allocate);
        this.sampleSize = e.i(allocate);
        this.compressionId = e.i(allocate);
        this.packetSize = e.i(allocate);
        this.sampleRate = e.k(allocate);
        i = 16;
        if (!this.type.equals("mlpa")) {
            this.sampleRate >>>= i;
        }
        int i10 = 1;
        if (this.soundVersion == i10) {
            ByteBuffer allocate2 = ByteBuffer.allocate(i);
            aVar.read(allocate2);
            allocate2.rewind();
            this.samplesPerPacket = e.k(allocate2);
            this.bytesPerPacket = e.k(allocate2);
            this.bytesPerFrame = e.k(allocate2);
            this.bytesPerSample = e.k(allocate2);
        }
        i = 36;
        final int i11 = 2;
        if (this.soundVersion == i11) {
            ByteBuffer allocate4 = ByteBuffer.allocate(36);
            aVar.read(allocate4);
            allocate4.rewind();
            this.samplesPerPacket = e.k(allocate4);
            this.bytesPerPacket = e.k(allocate4);
            this.bytesPerFrame = e.k(allocate4);
            this.bytesPerSample = e.k(allocate4);
            byte[] bArr = new byte[20];
            this.soundVersion2Data = bArr;
            allocate4.get(bArr);
        }
        String str2 = "owma";
        final long l16 = 28L;
        i = 0;
        if (str2.equals(this.type)) {
            System.err.println(str2);
            if (this.soundVersion != i10) {
            }
            if (this.soundVersion != i11) {
            }
            l = (long)i;
            l4 = (j - 28L) - (long)i - l;
            ByteBuffer allocate3 = ByteBuffer.allocate(b.a(l4));
            aVar.read(allocate3);
            addBox(new AudioSampleEntry.AnonymousClass1(this, l4, r12, allocate3));
        } else {
            if (this.soundVersion != i10) {
            }
            if (this.soundVersion != i11) {
            }
            l = (long)i;
            l4 = (j - 28L) - (long)i - l;
            initContainer(aVar, l4, bVar);
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBytesPerFrame(long j) {
        this.bytesPerFrame = j;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBytesPerPacket(long j) {
        this.bytesPerPacket = j;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBytesPerSample(long j) {
        this.bytesPerSample = j;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setCompressionId(int i) {
        this.compressionId = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setPacketSize(int i) {
        this.packetSize = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setReserved1(int i) {
        this.reserved1 = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setReserved2(long j) {
        this.reserved2 = j;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSampleRate(long j) {
        this.sampleRate = j;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSampleSize(int i) {
        this.sampleSize = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSamplesPerPacket(long j) {
        this.samplesPerPacket = j;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSoundVersion(int i) {
        this.soundVersion = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSoundVersion2Data(byte[] bArr) {
        this.soundVersion2Data = bArr;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setType(String str) {
        this.type = str;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String toString() {
        String str2 = "AudioSampleEntry{bytesPerSample=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", bytesPerFrame=";
        String str4 = ", bytesPerPacket=";
        String str5 = ", samplesPerPacket=";
        String str6 = ", packetSize=";
        String str7 = ", compressionId=";
        String str8 = ", soundVersion=";
        String str9 = ", sampleRate=";
        String str10 = ", sampleSize=";
        String str11 = ", channelCount=";
        String str12 = ", boxes=";
        java.util.List boxes = getBoxes();
        str = str2 + this.bytesPerSample + str3 + this.bytesPerFrame + str4 + this.bytesPerPacket + str5 + this.samplesPerPacket + str6 + this.packetSize + str7 + this.compressionId + str8 + this.soundVersion + str9 + this.sampleRate + str10 + this.sampleSize + str11 + this.channelCount + str12 + boxes + 125;
        return str;
    }
}
