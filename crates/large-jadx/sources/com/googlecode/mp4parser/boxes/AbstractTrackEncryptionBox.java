package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.UUID;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public abstract class AbstractTrackEncryptionBox extends AbstractFullBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    int defaultAlgorithmId;
    int defaultIvSize;
    byte[] default_KID;
    static {
        AbstractTrackEncryptionBox.ajc$preClinit();
    }

    protected AbstractTrackEncryptionBox(String string) {
        super(string);
    }

    private static void ajc$preClinit() {
        b bVar9 = new b("AbstractTrackEncryptionBox.java", AbstractTrackEncryptionBox.class);
        final String str58 = "method-execution";
        AbstractTrackEncryptionBox.ajc$tjp_0 = bVar9.h(str58, bVar9.g("1", "getDefaultAlgorithmId", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 24);
        AbstractTrackEncryptionBox.ajc$tjp_1 = bVar9.h(str58, bVar9.g("1", "setDefaultAlgorithmId", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "int", "defaultAlgorithmId", "", "void"), 28);
        AbstractTrackEncryptionBox.ajc$tjp_2 = bVar9.h(str58, bVar9.g("1", "getDefaultIvSize", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 32);
        AbstractTrackEncryptionBox.ajc$tjp_3 = bVar9.h(str58, bVar9.g("1", "setDefaultIvSize", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "int", "defaultIvSize", "", "void"), 36);
        AbstractTrackEncryptionBox.ajc$tjp_4 = bVar9.h(str58, bVar9.g("1", "getDefault_KID", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "java.util.UUID"), 40);
        AbstractTrackEncryptionBox.ajc$tjp_5 = bVar9.h(str58, bVar9.g("1", "setDefault_KID", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "java.util.UUID", "uuid", "", "void"), 46);
        AbstractTrackEncryptionBox.ajc$tjp_6 = bVar9.h(str58, bVar9.g("1", "equals", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "java.lang.Object", "o", "", "boolean"), 76);
        AbstractTrackEncryptionBox.ajc$tjp_7 = bVar9.h(str58, bVar9.g("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox", "", "", "", "int"), 90);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.defaultAlgorithmId = e.j(byteBuffer);
        this.defaultIvSize = e.n(byteBuffer);
        byte[] bArr = new byte[16];
        this.default_KID = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean equals(Object object) {
        Class class;
        Class class2;
        d.b().c(b.d(AbstractTrackEncryptionBox.ajc$tjp_6, this, this, object));
        int i = 1;
        if (this == object) {
            return i;
        }
        int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.defaultAlgorithmId != object.defaultAlgorithmId) {
                    return i2;
                }
                if (this.defaultIvSize != object.defaultIvSize) {
                    return i2;
                }
                if (!Arrays.equals(this.default_KID, object.default_KID)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.f(byteBuffer, this.defaultAlgorithmId);
        g.j(byteBuffer, this.defaultIvSize);
        byteBuffer.put(this.default_KID);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 24;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDefaultAlgorithmId() {
        d.b().c(b.c(AbstractTrackEncryptionBox.ajc$tjp_0, this, this));
        return this.defaultAlgorithmId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDefaultIvSize() {
        d.b().c(b.c(AbstractTrackEncryptionBox.ajc$tjp_2, this, this));
        return this.defaultIvSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public UUID getDefault_KID() {
        d.b().c(b.c(AbstractTrackEncryptionBox.ajc$tjp_4, this, this));
        ByteBuffer wrap = ByteBuffer.wrap(this.default_KID);
        wrap.order(ByteOrder.BIG_ENDIAN);
        UUID uuid = new UUID(wrap.getLong(), obj3, wrap.getLong(), obj5);
        return uuid;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int hashCode() {
        int i;
        d.b().c(b.c(AbstractTrackEncryptionBox.ajc$tjp_7, this, this));
        byte[] default_KID = this.default_KID;
        if (default_KID != null) {
            i = Arrays.hashCode(default_KID);
        } else {
            i = 0;
        }
        return i4 += i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultAlgorithmId(int i) {
        d.b().c(b.d(AbstractTrackEncryptionBox.ajc$tjp_1, this, this, a.e(i)));
        this.defaultAlgorithmId = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultIvSize(int i) {
        d.b().c(b.d(AbstractTrackEncryptionBox.ajc$tjp_3, this, this, a.e(i)));
        this.defaultIvSize = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefault_KID(UUID uUID) {
        d.b().c(b.d(AbstractTrackEncryptionBox.ajc$tjp_5, this, this, uUID));
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uUID.getMostSignificantBits());
        wrap.putLong(uUID.getLeastSignificantBits());
        this.default_KID = wrap.array();
    }
}
