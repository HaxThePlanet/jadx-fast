package com.googlecode.mp4parser.boxes.piff;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox;
import com.googlecode.mp4parser.d;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class PiffSampleEncryptionBox extends AbstractSampleEncryptionBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    static {
        PiffSampleEncryptionBox.ajc$preClinit();
    }

    public PiffSampleEncryptionBox() {
        super("uuid");
    }

    private static void ajc$preClinit() {
        b bVar7 = new b("PiffSampleEncryptionBox.java", PiffSampleEncryptionBox.class);
        final String str44 = "method-execution";
        PiffSampleEncryptionBox.ajc$tjp_0 = bVar7.h(str44, bVar7.g("1", "getAlgorithmId", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "int"), 46);
        PiffSampleEncryptionBox.ajc$tjp_1 = bVar7.h(str44, bVar7.g("1", "setAlgorithmId", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "int", "algorithmId", "", "void"), 50);
        PiffSampleEncryptionBox.ajc$tjp_2 = bVar7.h(str44, bVar7.g("1", "getIvSize", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "int"), 54);
        PiffSampleEncryptionBox.ajc$tjp_3 = bVar7.h(str44, bVar7.g("1", "setIvSize", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "int", "ivSize", "", "void"), 58);
        PiffSampleEncryptionBox.ajc$tjp_4 = bVar7.h(str44, bVar7.g("1", "getKid", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "[B"), 62);
        PiffSampleEncryptionBox.ajc$tjp_5 = bVar7.h(str44, bVar7.g("1", "setKid", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "[B", "kid", "", "void"), 66);
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public int getAlgorithmId() {
        d.b().c(b.c(PiffSampleEncryptionBox.ajc$tjp_0, this, this));
        return this.algorithmId;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public int getIvSize() {
        d.b().c(b.c(PiffSampleEncryptionBox.ajc$tjp_2, this, this));
        return this.ivSize;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public byte[] getKid() {
        d.b().c(b.c(PiffSampleEncryptionBox.ajc$tjp_4, this, this));
        return this.kid;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public byte[] getUserType() {
        byte[] bArr = new byte[16];
        bArr = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
        return bArr;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public boolean isOverrideTrackEncryptionBoxParameters() {
        final int i3 = 1;
        if (flags &= i3 > 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public void setAlgorithmId(int i) {
        d.b().c(b.d(PiffSampleEncryptionBox.ajc$tjp_1, this, this, a.e(i)));
        this.algorithmId = i;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public void setIvSize(int i) {
        d.b().c(b.d(PiffSampleEncryptionBox.ajc$tjp_3, this, this, a.e(i)));
        this.ivSize = i;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public void setKid(byte[] bArr) {
        d.b().c(b.d(PiffSampleEncryptionBox.ajc$tjp_5, this, this, bArr));
        this.kid = bArr;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public void setOverrideTrackEncryptionBoxParameters(boolean z) {
        int i;
        int obj2;
        if (z) {
            setFlags(obj2 |= 1);
        } else {
            setFlags(obj2 &= i);
        }
    }
}
