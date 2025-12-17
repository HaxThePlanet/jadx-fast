package com.googlecode.mp4parser.boxes.dece;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class AssetInformationBox extends AbstractFullBox {

    static final boolean $assertionsDisabled = false;
    public static final String TYPE = "ainf";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    String apid;
    String profileVersion;
    static {
        AssetInformationBox.ajc$preClinit();
    }

    public AssetInformationBox() {
        super("ainf");
        this.apid = "";
        this.profileVersion = "0000";
    }

    private static void ajc$preClinit() {
        b bVar5 = new b("AssetInformationBox.java", AssetInformationBox.class);
        final String str30 = "method-execution";
        AssetInformationBox.ajc$tjp_0 = bVar5.h(str30, bVar5.g("1", "getApid", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 131);
        AssetInformationBox.ajc$tjp_1 = bVar5.h(str30, bVar5.g("1", "setApid", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "apid", "", "void"), 135);
        AssetInformationBox.ajc$tjp_2 = bVar5.h(str30, bVar5.g("1", "getProfileVersion", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 139);
        AssetInformationBox.ajc$tjp_3 = bVar5.h(str30, bVar5.g("1", "setProfileVersion", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "profileVersion", "", "void"), 143);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.profileVersion = e.h(byteBuffer, 4);
        this.apid = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getApid() {
        d.b().c(b.c(AssetInformationBox.ajc$tjp_0, this, this));
        return this.apid;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() != 0) {
        } else {
            final int i2 = 0;
            byteBuffer.put(j.b(this.profileVersion), i2, 4);
            byteBuffer.put(j.b(this.apid));
            byteBuffer.put(i2);
        }
        StringBuilder stringBuilder = new StringBuilder("Unknown ainf version ");
        stringBuilder.append(getVersion());
        RuntimeException obj4 = new RuntimeException(stringBuilder.toString());
        throw obj4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getProfileVersion() {
        d.b().c(b.c(AssetInformationBox.ajc$tjp_2, this, this));
        return this.profileVersion;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isHidden() {
        final int i3 = 1;
        if (flags &= i3 == i3) {
            return i3;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setApid(String string) {
        d.b().c(b.d(AssetInformationBox.ajc$tjp_1, this, this, string));
        this.apid = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setHidden(boolean z) {
        int obj3;
        final int flags = getFlags();
        if (hidden ^= z != 0) {
            if (z != 0) {
                setFlags(flags | 1);
            } else {
                setFlags(obj3 &= flags);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setProfileVersion(String string) {
        d.b().c(b.d(AssetInformationBox.ajc$tjp_3, this, this, string));
        this.profileVersion = string;
    }
}
