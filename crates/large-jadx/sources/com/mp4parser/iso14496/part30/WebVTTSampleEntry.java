package com.mp4parser.iso14496.part30;

import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.j;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: WebVTTSampleEntry.java */
/* loaded from: classes2.dex */
public class WebVTTSampleEntry extends AbstractSampleEntry {

    public static final String TYPE = "wvtt";
    public WebVTTSampleEntry() {
        super("wvtt");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        writableByteChannel.write(getHeader());
        writeContainer(writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public WebVTTConfigurationBox getConfig() {
        return (WebVTTConfigurationBox)j.c(this, "vttC");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public WebVTTSourceLabelBox getSourceLabel() {
        return (WebVTTSourceLabelBox)j.c(this, "vlab");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar) {
        initContainer(aVar, j, bVar);
    }
}
