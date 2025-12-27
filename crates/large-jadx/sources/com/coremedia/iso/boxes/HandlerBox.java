package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: HandlerBox.java */
/* loaded from: classes.dex */
public class HandlerBox extends AbstractFullBox {

    public static final String TYPE = "hdlr";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    public static final Map<String, String> readableTypes;
    private long a;
    private long b;
    private long c;
    private String handlerType;
    private String name = null;
    private long shouldBeZeroButAppleWritesHereSomeValue;
    private boolean zeroTerm = true;
    static {
        HandlerBox.ajc$preClinit();
        HashMap hashMap = new HashMap();
        hashMap.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        hashMap.put("mdir", "Apple Meta Data iTunes Reader");
        hashMap.put("mp7b", "MPEG-7 binary XML");
        hashMap.put("mp7t", "MPEG-7 XML");
        hashMap.put("vide", "Video Track");
        hashMap.put("soun", "Sound Track");
        hashMap.put("hint", "Hint Track");
        hashMap.put("appl", "Apple specific");
        hashMap.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        HandlerBox.readableTypes = Collections.unmodifiableMap(hashMap);
    }

    public HandlerBox() {
        super("hdlr");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("HandlerBox.java", HandlerBox.class);
        final String str44 = "method-execution";
        HandlerBox.ajc$tjp_0 = bVar.h(str44, bVar.g("1", "getHandlerType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
        HandlerBox.ajc$tjp_1 = bVar.h(str44, bVar.g("1", "setName", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "name", "", "void"), 87);
        HandlerBox.ajc$tjp_2 = bVar.h(str44, bVar.g("1", "setHandlerType", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
        HandlerBox.ajc$tjp_3 = bVar.h(str44, bVar.g("1", "getName", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
        HandlerBox.ajc$tjp_4 = bVar.h(str44, bVar.g("1", "getHumanReadableTrackType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
        HandlerBox.ajc$tjp_5 = bVar.h(str44, bVar.g("1", "toString", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.shouldBeZeroButAppleWritesHereSomeValue = e.k(byteBuffer);
        this.handlerType = e.b(byteBuffer);
        this.a = e.k(byteBuffer);
        this.b = e.k(byteBuffer);
        this.c = e.k(byteBuffer);
        final int i3 = 0;
        if (byteBuffer.remaining() <= 0) {
            this.zeroTerm = false;
        } else {
            String str3 = e.h(byteBuffer, byteBuffer.remaining());
            this.name = str3;
            str = "\u0000";
            if (str3.endsWith(str)) {
                int i = 1;
                this.name = this.name.substring(i3, this.name.length() - i);
                this.zeroTerm = true;
            } else {
                this.zeroTerm = false;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.shouldBeZeroButAppleWritesHereSomeValue);
        byteBuffer.put(d.e(this.handlerType));
        g.g(byteBuffer, this.a);
        g.g(byteBuffer, this.b);
        g.g(byteBuffer, this.c);
        if (this.name != null) {
            byteBuffer.put(j.b(this.name));
        }
        if (this.zeroTerm) {
            byteBuffer.put((byte) 0);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (this.zeroTerm) {
            i = j.c(this.name) + 25;
        } else {
            i = j.c(this.name) + 24;
        }
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getHandlerType() {
        d.b().c(b.c(HandlerBox.ajc$tjp_0, this, this));
        return this.handlerType;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getHumanReadableTrackType() {
        Object value;
        d.b().c(b.c(HandlerBox.ajc$tjp_4, this, this));
        Map readableTypes2 = HandlerBox.readableTypes;
        if (readableTypes2.get(this.handlerType) != null) {
            value = HandlerBox.readableTypes.get(this.handlerType);
        } else {
            String str = "Unknown Handler Type";
        }
        return value;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getName() {
        d.b().c(b.c(HandlerBox.ajc$tjp_3, this, this));
        return this.name;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setHandlerType(String str) {
        d.b().c(b.d(HandlerBox.ajc$tjp_2, this, this, str));
        this.handlerType = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setName(String str) {
        d.b().c(b.d(HandlerBox.ajc$tjp_1, this, this, str));
        this.name = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(HandlerBox.ajc$tjp_5, this, this));
        String str2 = "HandlerBox[handlerType=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String handlerType = getHandlerType();
        String str3 = ";name=";
        String name = getName();
        String str4 = "]";
        str = str2 + handlerType + str3 + name + str4;
        return str;
    }
}
