package com.mp4parser.iso23001.part7;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import com.googlecode.mp4parser.h.k;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class ProtectionSystemSpecificHeaderBox extends AbstractFullBox {

    static final boolean $assertionsDisabled = false;
    public static byte[] OMA2_SYSTEM_ID = null;
    public static byte[] PLAYREADY_SYSTEM_ID = null;
    public static final String TYPE = "pssh";
    public static byte[] WIDEVINE;
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    byte[] content;
    List<UUID> keyIds;
    byte[] systemId;
    static {
        ProtectionSystemSpecificHeaderBox.ajc$preClinit();
        ProtectionSystemSpecificHeaderBox.OMA2_SYSTEM_ID = k.b(UUID.fromString("A2B55680-6F43-11E0-9A3F-0002A5D5C51B"));
        ProtectionSystemSpecificHeaderBox.WIDEVINE = k.b(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"));
        ProtectionSystemSpecificHeaderBox.PLAYREADY_SYSTEM_ID = k.b(UUID.fromString("9A04F079-9840-4286-AB92-E65BE0885F95"));
    }

    public ProtectionSystemSpecificHeaderBox() {
        super("pssh");
        ArrayList arrayList = new ArrayList();
        this.keyIds = arrayList;
    }

    public ProtectionSystemSpecificHeaderBox(byte[] bArr, byte[] b2Arr2) {
        super("pssh");
        ArrayList arrayList = new ArrayList();
        this.keyIds = arrayList;
        this.content = b2Arr2;
        this.systemId = bArr;
    }

    private static void ajc$preClinit() {
        b bVar7 = new b("ProtectionSystemSpecificHeaderBox.java", ProtectionSystemSpecificHeaderBox.class);
        final String str44 = "method-execution";
        ProtectionSystemSpecificHeaderBox.ajc$tjp_0 = bVar7.h(str44, bVar7.g("1", "getKeyIds", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "java.util.List"), 50);
        ProtectionSystemSpecificHeaderBox.ajc$tjp_1 = bVar7.h(str44, bVar7.g("1", "setKeyIds", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "java.util.List", "keyIds", "", "void"), 54);
        ProtectionSystemSpecificHeaderBox.ajc$tjp_2 = bVar7.h(str44, bVar7.g("1", "getSystemId", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 61);
        ProtectionSystemSpecificHeaderBox.ajc$tjp_3 = bVar7.h(str44, bVar7.g("1", "setSystemId", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "[B", "systemId", "", "void"), 65);
        ProtectionSystemSpecificHeaderBox.ajc$tjp_4 = bVar7.h(str44, bVar7.g("1", "getContent", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "", "", "", "[B"), 70);
        ProtectionSystemSpecificHeaderBox.ajc$tjp_5 = bVar7.h(str44, bVar7.g("1", "setContent", "com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox", "[B", "content", "", "void"), 74);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        int version;
        long l;
        List keyIds;
        parseVersionAndFlags(byteBuffer);
        int i = 16;
        byte[] bArr2 = new byte[i];
        this.systemId = bArr2;
        byteBuffer.get(bArr2);
        if (getVersion() > 0) {
            version = b.a(e.k(byteBuffer));
            while (version <= 0) {
                byte[] bArr3 = new byte[i];
                byteBuffer.get(bArr3);
                this.keyIds.add(k.a(bArr3));
                version = l;
            }
        }
        e.k(byteBuffer);
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.content = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int iterator;
        int next;
        writeVersionAndFlags(byteBuffer);
        next = 0;
        byteBuffer.put(this.systemId, next, 16);
        if (getVersion() > 0) {
            g.g(byteBuffer, (long)size);
            iterator = this.keyIds.iterator();
            for (UUID next2 : iterator) {
                byteBuffer.put(k.b(next2));
            }
        }
        g.g(byteBuffer, (long)length);
        byteBuffer.put(this.content);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public byte[] getContent() {
        d.b().c(b.c(ProtectionSystemSpecificHeaderBox.ajc$tjp_4, this, this));
        return this.content;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        long l;
        int version;
        if (getVersion() > 0) {
            i2 += version;
        }
        return l;
    }

    public List<UUID> getKeyIds() {
        d.b().c(b.c(ProtectionSystemSpecificHeaderBox.ajc$tjp_0, this, this));
        return this.keyIds;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public byte[] getSystemId() {
        d.b().c(b.c(ProtectionSystemSpecificHeaderBox.ajc$tjp_2, this, this));
        return this.systemId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setContent(byte[] bArr) {
        d.b().c(b.d(ProtectionSystemSpecificHeaderBox.ajc$tjp_5, this, this, bArr));
        this.content = bArr;
    }

    public void setKeyIds(List<UUID> list) {
        d.b().c(b.d(ProtectionSystemSpecificHeaderBox.ajc$tjp_1, this, this, list));
        this.keyIds = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSystemId(byte[] bArr) {
        d.b().c(b.d(ProtectionSystemSpecificHeaderBox.ajc$tjp_3, this, this, bArr));
        this.systemId = bArr;
    }
}
