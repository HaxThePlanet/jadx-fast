package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: RecordingYearBox.java */
/* loaded from: classes.dex */
public class RecordingYearBox extends AbstractFullBox {

    public static final String TYPE = "yrrc";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    int recordingYear;
    static {
        RecordingYearBox.ajc$preClinit();
    }

    public RecordingYearBox() {
        super("yrrc");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("RecordingYearBox.java", RecordingYearBox.class);
        final String str16 = "method-execution";
        RecordingYearBox.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getRecordingYear", "com.coremedia.iso.boxes.RecordingYearBox", "", "", "", "int"), 42);
        RecordingYearBox.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "setRecordingYear", "com.coremedia.iso.boxes.RecordingYearBox", "int", "recordingYear", "", "void"), 46);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.recordingYear = e.i(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.e(byteBuffer, this.recordingYear);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getRecordingYear() {
        d.b().c(b.c(RecordingYearBox.ajc$tjp_0, this, this));
        return this.recordingYear;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setRecordingYear(int i) {
        d.b().c(b.d(RecordingYearBox.ajc$tjp_1, this, this, a.e(i)));
        this.recordingYear = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 6;
    }
}
