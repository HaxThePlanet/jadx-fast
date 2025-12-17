package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class HandlerBox extends AbstractFullBox {

    public static final String TYPE = "hdlr";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
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
        int i = 0;
        int i2 = 1;
    }

    private static void ajc$preClinit() {
        b bVar7 = new b("HandlerBox.java", HandlerBox.class);
        final String str44 = "method-execution";
        HandlerBox.ajc$tjp_0 = bVar7.h(str44, bVar7.g("1", "getHandlerType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
        HandlerBox.ajc$tjp_1 = bVar7.h(str44, bVar7.g("1", "setName", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "name", "", "void"), 87);
        HandlerBox.ajc$tjp_2 = bVar7.h(str44, bVar7.g("1", "setHandlerType", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
        HandlerBox.ajc$tjp_3 = bVar7.h(str44, bVar7.g("1", "getName", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
        HandlerBox.ajc$tjp_4 = bVar7.h(str44, bVar7.g("1", "getHumanReadableTrackType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
        HandlerBox.ajc$tjp_5 = bVar7.h(str44, bVar7.g("1", "toString", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        String remaining;
        int i;
        boolean obj4;
        parseVersionAndFlags(byteBuffer);
        this.shouldBeZeroButAppleWritesHereSomeValue = e.k(byteBuffer);
        this.handlerType = e.b(byteBuffer);
        this.a = e.k(byteBuffer);
        this.b = e.k(byteBuffer);
        this.c = e.k(byteBuffer);
        final int i2 = 0;
        if (byteBuffer.remaining() > 0) {
            obj4 = e.h(byteBuffer, byteBuffer.remaining());
            this.name = obj4;
            if (obj4.endsWith("\u0000")) {
                obj4 = this.name;
                i = 1;
                this.name = obj4.substring(i2, length -= i);
                this.zeroTerm = i;
            } else {
                this.zeroTerm = i2;
            }
        } else {
            this.zeroTerm = i2;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        String name;
        boolean zeroTerm;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.shouldBeZeroButAppleWritesHereSomeValue);
        byteBuffer.put(d.e(this.handlerType));
        g.g(byteBuffer, this.a);
        g.g(byteBuffer, this.b);
        g.g(byteBuffer, this.c);
        name = this.name;
        if (name != null) {
            byteBuffer.put(j.b(name));
        }
        if (this.zeroTerm) {
            byteBuffer.put(0);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (this.zeroTerm) {
            i3 += 25;
        } else {
            i2 += 24;
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
        Object str;
        Object handlerType;
        d.b().c(b.c(HandlerBox.ajc$tjp_4, this, this));
        Map readableTypes = HandlerBox.readableTypes;
        if (readableTypes.get(this.handlerType) != null) {
            str = readableTypes.get(this.handlerType);
        } else {
            str = "Unknown Handler Type";
        }
        return str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getName() {
        d.b().c(b.c(HandlerBox.ajc$tjp_3, this, this));
        return this.name;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setHandlerType(String string) {
        d.b().c(b.d(HandlerBox.ajc$tjp_2, this, this, string));
        this.handlerType = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setName(String string) {
        d.b().c(b.d(HandlerBox.ajc$tjp_1, this, this, string));
        this.name = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(HandlerBox.ajc$tjp_5, this, this));
        StringBuilder stringBuilder = new StringBuilder("HandlerBox[handlerType=");
        stringBuilder.append(getHandlerType());
        stringBuilder.append(";name=");
        stringBuilder.append(getName());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
