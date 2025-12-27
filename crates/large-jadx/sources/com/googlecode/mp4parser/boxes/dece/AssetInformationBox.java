package com.googlecode.mp4parser.boxes.dece;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AssetInformationBox.java */
/* loaded from: classes2.dex */
public class AssetInformationBox extends AbstractFullBox {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "ainf";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    String apid = "";
    String profileVersion = "0000";
    public AssetInformationBox() {
        super("ainf");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("AssetInformationBox.java", AssetInformationBox.class);
        final String str30 = "method-execution";
        AssetInformationBox.ajc$tjp_0 = bVar.h(str30, bVar.g("1", "getApid", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 131);
        AssetInformationBox.ajc$tjp_1 = bVar.h(str30, bVar.g("1", "setApid", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "apid", "", "void"), 135);
        AssetInformationBox.ajc$tjp_2 = bVar.h(str30, bVar.g("1", "getProfileVersion", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "", "", "", "java.lang.String"), 139);
        AssetInformationBox.ajc$tjp_3 = bVar.h(str30, bVar.g("1", "setProfileVersion", "com.googlecode.mp4parser.boxes.dece.AssetInformationBox", "java.lang.String", "profileVersion", "", "void"), 143);
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
            String str = "Unknown ainf version ";
            int version2 = getVersion();
            r0 = str + version2;
            throw new RuntimeException(r0);
        } else {
            final int i2 = 0;
            byteBuffer.put(j.b(this.profileVersion), i2, 4);
            byteBuffer.put(j.b(this.apid));
            byteBuffer.put(i2);
            return;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.apid) + 9);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getProfileVersion() {
        d.b().c(b.c(AssetInformationBox.ajc$tjp_2, this, this));
        return this.profileVersion;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isHidden() {
        final int i3 = 1;
        if ((getFlags() & i3) == i3) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setApid(String str) {
        d.b().c(b.d(AssetInformationBox.ajc$tjp_1, this, this, str));
        this.apid = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setHidden(boolean z) {
        final int flags = getFlags();
        if (isHidden() ^ z && z) {
            i = flags | 1;
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setProfileVersion(String str) {
        d.b().c(b.d(AssetInformationBox.ajc$tjp_3, this, this, str));
        this.profileVersion = str;
    }

    static {
        AssetInformationBox.ajc$preClinit();
    }
}
