package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.b;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public final class AudioSampleEntry extends com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry {

    static final boolean $assertionsDisabled = false;
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
    static {
        final Class<com.coremedia.iso.boxes.sampleentry.AudioSampleEntry> obj = AudioSampleEntry.class;
    }

    public AudioSampleEntry(String string) {
        super(string);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) {
        int sampleRate2;
        int bytesPerSample;
        int soundVersion2Data;
        int i;
        int i2;
        long sampleRate;
        writableByteChannel.write(getHeader());
        int soundVersion = this.soundVersion;
        int i3 = 16;
        final int i5 = 1;
        i2 = soundVersion == i5 ? i3 : i;
        final int i8 = 2;
        if (soundVersion == i8) {
            i = 36;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i6 += i);
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
            g.g(allocate, sampleRate << i3);
        }
        if (this.soundVersion == i5) {
            g.g(allocate, this.samplesPerPacket);
            g.g(allocate, this.bytesPerPacket);
            g.g(allocate, this.bytesPerFrame);
            g.g(allocate, this.bytesPerSample);
        }
        if (this.soundVersion == i8) {
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
        boolean largeBox;
        int i3;
        int i2;
        int i;
        long containerSize;
        long l;
        int soundVersion = this.soundVersion;
        i = soundVersion == 1 ? i3 : i2;
        if (soundVersion == 2) {
            i2 = 36;
        }
        l3 += containerSize;
        if (!this.largeBox) {
            if (Long.compare(containerSize, l) >= 0) {
            } else {
                i3 = 8;
            }
        }
        return i4 += l2;
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
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        int i2;
        long l;
        int i;
        long l2;
        int i3;
        byte[] bArr;
        Object obj9;
        int obj10;
        int obj11;
        obj10 = ByteBuffer.allocate(28);
        a.read(obj10);
        obj10.position(6);
        this.dataReferenceIndex = e.i(obj10);
        this.soundVersion = e.i(obj10);
        this.reserved1 = e.i(obj10);
        this.reserved2 = e.k(obj10);
        this.channelCount = e.i(obj10);
        this.sampleSize = e.i(obj10);
        this.compressionId = e.i(obj10);
        this.packetSize = e.i(obj10);
        this.sampleRate = e.k(obj10);
        i2 = 16;
        if (!this.type.equals("mlpa")) {
            this.sampleRate = sampleRate >>>= i2;
        }
        int i12 = 1;
        if (this.soundVersion == i12) {
            obj10 = ByteBuffer.allocate(i2);
            a.read(obj10);
            obj10.rewind();
            this.samplesPerPacket = e.k(obj10);
            this.bytesPerPacket = e.k(obj10);
            this.bytesPerFrame = e.k(obj10);
            this.bytesPerSample = e.k(obj10);
        }
        final int i13 = 2;
        if (this.soundVersion == i13) {
            obj10 = ByteBuffer.allocate(36);
            a.read(obj10);
            obj10.rewind();
            this.samplesPerPacket = e.k(obj10);
            this.bytesPerPacket = e.k(obj10);
            this.bytesPerFrame = e.k(obj10);
            this.bytesPerSample = e.k(obj10);
            bArr = new byte[20];
            this.soundVersion2Data = bArr;
            obj10.get(bArr);
        }
        String str2 = "owma";
        final int i15 = 28;
        final int i16 = 0;
        if (str2.equals(this.type)) {
            System.err.println(str2);
            obj10 = this.soundVersion;
            if (obj10 == i12) {
            } else {
                i2 = i16;
            }
            if (obj10 == i13) {
            } else {
                i3 = i16;
            }
            obj11 -= l;
            obj10 = ByteBuffer.allocate(b.a(obj11));
            a.read(obj10);
            obj9 = new AudioSampleEntry.1(this, obj11, b4, obj10);
            addBox(obj9);
        } else {
            obj10 = this.soundVersion;
            if (obj10 == i12) {
            } else {
                i2 = i16;
            }
            if (obj10 == i13) {
            } else {
                i3 = i16;
            }
            initContainer(a, obj11 -= l, b4);
        }
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBytesPerFrame(long l) {
        this.bytesPerFrame = l;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBytesPerPacket(long l) {
        this.bytesPerPacket = l;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setBytesPerSample(long l) {
        this.bytesPerSample = l;
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
    public void setReserved2(long l) {
        this.reserved2 = l;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSampleRate(long l) {
        this.sampleRate = l;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSampleSize(int i) {
        this.sampleSize = i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setSamplesPerPacket(long l) {
        this.samplesPerPacket = l;
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
    public void setType(String string) {
        this.type = string;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AudioSampleEntry{bytesPerSample=");
        stringBuilder.append(this.bytesPerSample);
        stringBuilder.append(", bytesPerFrame=");
        stringBuilder.append(this.bytesPerFrame);
        stringBuilder.append(", bytesPerPacket=");
        stringBuilder.append(this.bytesPerPacket);
        stringBuilder.append(", samplesPerPacket=");
        stringBuilder.append(this.samplesPerPacket);
        stringBuilder.append(", packetSize=");
        stringBuilder.append(this.packetSize);
        stringBuilder.append(", compressionId=");
        stringBuilder.append(this.compressionId);
        stringBuilder.append(", soundVersion=");
        stringBuilder.append(this.soundVersion);
        stringBuilder.append(", sampleRate=");
        stringBuilder.append(this.sampleRate);
        stringBuilder.append(", sampleSize=");
        stringBuilder.append(this.sampleSize);
        stringBuilder.append(", channelCount=");
        stringBuilder.append(this.channelCount);
        stringBuilder.append(", boxes=");
        stringBuilder.append(getBoxes());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
