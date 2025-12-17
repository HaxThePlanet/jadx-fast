package com.mp4parser.iso14496.part30;

import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.j;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class WebVTTSampleEntry extends AbstractSampleEntry {

    public static final String TYPE = "wvtt";
    public WebVTTSampleEntry() {
        super("wvtt");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(getHeader());
        writeContainer(writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public com.mp4parser.iso14496.part30.WebVTTConfigurationBox getConfig() {
        return (WebVTTConfigurationBox)j.c(this, "vttC");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public com.mp4parser.iso14496.part30.WebVTTSourceLabelBox getSourceLabel() {
        return (WebVTTSourceLabelBox)j.c(this, "vlab");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        initContainer(a, l3, b4);
    }
}
