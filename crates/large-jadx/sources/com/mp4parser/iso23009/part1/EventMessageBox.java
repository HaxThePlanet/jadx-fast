package com.mp4parser.iso23009.part1;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: EventMessageBox.java */
/* loaded from: classes2.dex */
public class EventMessageBox extends AbstractFullBox {

    public static final String TYPE = "emsg";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_10;
    private static final /* synthetic */ a.a ajc$tjp_11;
    private static final /* synthetic */ a.a ajc$tjp_12;
    private static final /* synthetic */ a.a ajc$tjp_13;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    long eventDuration;
    long id;
    byte[] messageData;
    long presentationTimeDelta;
    String schemeIdUri;
    long timescale;
    String value;
    static {
        EventMessageBox.ajc$preClinit();
    }

    public EventMessageBox() {
        super("emsg");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("EventMessageBox.java", EventMessageBox.class);
        final String str100 = "method-execution";
        EventMessageBox.ajc$tjp_0 = bVar.h(str100, bVar.g("1", "getSchemeIdUri", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 59);
        EventMessageBox.ajc$tjp_1 = bVar.h(str100, bVar.g("1", "setSchemeIdUri", "com.mp4parser.iso23009.part1.EventMessageBox", "java.lang.String", "schemeIdUri", "", "void"), 63);
        EventMessageBox.ajc$tjp_10 = bVar.h(str100, bVar.g("1", "getId", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 99);
        EventMessageBox.ajc$tjp_11 = bVar.h(str100, bVar.g("1", "setId", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "id", "", "void"), 103);
        EventMessageBox.ajc$tjp_12 = bVar.h(str100, bVar.g("1", "getMessageData", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "[B"), 107);
        EventMessageBox.ajc$tjp_13 = bVar.h(str100, bVar.g("1", "setMessageData", "com.mp4parser.iso23009.part1.EventMessageBox", "[B", "messageData", "", "void"), 111);
        EventMessageBox.ajc$tjp_2 = bVar.h(str100, bVar.g("1", "getValue", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 67);
        EventMessageBox.ajc$tjp_3 = bVar.h(str100, bVar.g("1", "setValue", "com.mp4parser.iso23009.part1.EventMessageBox", "java.lang.String", "value", "", "void"), 71);
        EventMessageBox.ajc$tjp_4 = bVar.h(str100, bVar.g("1", "getTimescale", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 75);
        EventMessageBox.ajc$tjp_5 = bVar.h(str100, bVar.g("1", "setTimescale", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "timescale", "", "void"), 79);
        EventMessageBox.ajc$tjp_6 = bVar.h(str100, bVar.g("1", "getPresentationTimeDelta", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 83);
        EventMessageBox.ajc$tjp_7 = bVar.h(str100, bVar.g("1", "setPresentationTimeDelta", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "presentationTimeDelta", "", "void"), 87);
        EventMessageBox.ajc$tjp_8 = bVar.h(str100, bVar.g("1", "getEventDuration", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 91);
        EventMessageBox.ajc$tjp_9 = bVar.h(str100, bVar.g("1", "setEventDuration", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "eventDuration", "", "void"), 95);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.schemeIdUri = e.g(byteBuffer);
        this.value = e.g(byteBuffer);
        this.timescale = e.k(byteBuffer);
        this.presentationTimeDelta = e.k(byteBuffer);
        this.eventDuration = e.k(byteBuffer);
        this.id = e.k(byteBuffer);
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.messageData = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.k(byteBuffer, this.schemeIdUri);
        g.k(byteBuffer, this.value);
        g.g(byteBuffer, this.timescale);
        g.g(byteBuffer, this.presentationTimeDelta);
        g.g(byteBuffer, this.eventDuration);
        g.g(byteBuffer, this.id);
        byteBuffer.put(this.messageData);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.schemeIdUri) + 22) + j.c(this.value) + this.messageData.length;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getEventDuration() {
        d.b().c(b.c(EventMessageBox.ajc$tjp_8, this, this));
        return this.eventDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getId() {
        d.b().c(b.c(EventMessageBox.ajc$tjp_10, this, this));
        return this.id;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public byte[] getMessageData() {
        d.b().c(b.c(EventMessageBox.ajc$tjp_12, this, this));
        return this.messageData;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getPresentationTimeDelta() {
        d.b().c(b.c(EventMessageBox.ajc$tjp_6, this, this));
        return this.presentationTimeDelta;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getSchemeIdUri() {
        d.b().c(b.c(EventMessageBox.ajc$tjp_0, this, this));
        return this.schemeIdUri;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTimescale() {
        d.b().c(b.c(EventMessageBox.ajc$tjp_4, this, this));
        return this.timescale;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getValue() {
        d.b().c(b.c(EventMessageBox.ajc$tjp_2, this, this));
        return this.value;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEventDuration(long j) {
        d.b().c(b.d(EventMessageBox.ajc$tjp_9, this, this, a.f(j)));
        this.eventDuration = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setId(long j) {
        d.b().c(b.d(EventMessageBox.ajc$tjp_11, this, this, a.f(j)));
        this.id = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setMessageData(byte[] bArr) {
        d.b().c(b.d(EventMessageBox.ajc$tjp_13, this, this, bArr));
        this.messageData = bArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setPresentationTimeDelta(long j) {
        d.b().c(b.d(EventMessageBox.ajc$tjp_7, this, this, a.f(j)));
        this.presentationTimeDelta = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSchemeIdUri(String str) {
        d.b().c(b.d(EventMessageBox.ajc$tjp_1, this, this, str));
        this.schemeIdUri = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTimescale(long j) {
        d.b().c(b.d(EventMessageBox.ajc$tjp_5, this, this, a.f(j)));
        this.timescale = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setValue(String str) {
        d.b().c(b.d(EventMessageBox.ajc$tjp_3, this, this, str));
        this.value = str;
    }
}
