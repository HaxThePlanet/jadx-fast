package com.googlecode.mp4parser.boxes.piff;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.k;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.UUID;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: UuidBasedProtectionSystemSpecificHeaderBox.java */
/* loaded from: classes2.dex */
public class UuidBasedProtectionSystemSpecificHeaderBox extends AbstractFullBox {

    public static byte[] USER_TYPE;
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    a protectionSpecificHeader;
    UUID systemId;
    static {
        UuidBasedProtectionSystemSpecificHeaderBox.ajc$preClinit();
        UuidBasedProtectionSystemSpecificHeaderBox.USER_TYPE = new byte[] { -48, -118, 79, 24, 16, -13, 74, -126, -74, -56, 50, -40, -85, -95, -125, -45 };
    }

    public UuidBasedProtectionSystemSpecificHeaderBox() {
        super("uuid", UuidBasedProtectionSystemSpecificHeaderBox.USER_TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("UuidBasedProtectionSystemSpecificHeaderBox.java", UuidBasedProtectionSystemSpecificHeaderBox.class);
        final String str51 = "method-execution";
        UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_0 = bVar.h(str51, bVar.g("1", "getSystemId", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.util.UUID"), 67);
        UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_1 = bVar.h(str51, bVar.g("1", "setSystemId", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "java.util.UUID", "systemId", "", "void"), 71);
        UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_2 = bVar.h(str51, bVar.g("1", "getSystemIdString", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 75);
        UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_3 = bVar.h(str51, bVar.g("1", "getProtectionSpecificHeader", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader"), 79);
        UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_4 = bVar.h(str51, bVar.g("1", "getProtectionSpecificHeaderString", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 83);
        UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_5 = bVar.h(str51, bVar.g("1", "setProtectionSpecificHeader", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader", "protectionSpecificHeader", "", "void"), 87);
        UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_6 = bVar.h(str51, bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.piff.UuidBasedProtectionSystemSpecificHeaderBox", "", "", "", "java.lang.String"), 92);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        this.systemId = k.a(bArr);
        b.a(e.k(byteBuffer));
        this.protectionSpecificHeader = a.a(this.systemId, byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.i(byteBuffer, this.systemId.getMostSignificantBits());
        g.i(byteBuffer, this.systemId.getLeastSignificantBits());
        ByteBuffer byteBuffer2 = this.protectionSpecificHeader.b();
        byteBuffer2.rewind();
        g.g(byteBuffer, (long)byteBuffer2.limit());
        byteBuffer.put(byteBuffer2);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.protectionSpecificHeader.b().limit() + 24);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public a getProtectionSpecificHeader() {
        d.b().c(b.c(UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_3, this, this));
        return this.protectionSpecificHeader;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getProtectionSpecificHeaderString() {
        d.b().c(b.c(UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_4, this, this));
        return this.protectionSpecificHeader.toString();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public UUID getSystemId() {
        d.b().c(b.c(UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_0, this, this));
        return this.systemId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getSystemIdString() {
        d.b().c(b.c(UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_2, this, this));
        return this.systemId.toString();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public byte[] getUserType() {
        return UuidBasedProtectionSystemSpecificHeaderBox.USER_TYPE;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setProtectionSpecificHeader(a aVar) {
        d.b().c(b.d(UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_5, this, this, aVar));
        this.protectionSpecificHeader = aVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSystemId(UUID uuid) {
        d.b().c(b.d(UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_1, this, this, uuid));
        this.systemId = uuid;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(UuidBasedProtectionSystemSpecificHeaderBox.ajc$tjp_6, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UuidBasedProtectionSystemSpecificHeaderBox";
        String str3 = "{systemId=";
        String uuid = this.systemId.toString();
        String str4 = ", dataSize=";
        int limit = this.protectionSpecificHeader.b().limit();
        str = str2 + str3 + uuid + str4 + limit + 125;
        return str;
    }
}
