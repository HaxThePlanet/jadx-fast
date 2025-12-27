package com.googlecode.mp4parser.boxes.piff;

import com.google.android.gms.internal.firebase-auth-api.g9;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox;
import com.googlecode.mp4parser.d;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: PiffSampleEncryptionBox.java */
/* loaded from: classes2.dex */
public class PiffSampleEncryptionBox extends AbstractSampleEncryptionBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    static {
        PiffSampleEncryptionBox.ajc$preClinit();
    }

    public PiffSampleEncryptionBox() {
        super("uuid");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("PiffSampleEncryptionBox.java", PiffSampleEncryptionBox.class);
        final String str44 = "method-execution";
        PiffSampleEncryptionBox.ajc$tjp_0 = bVar.h(str44, bVar.g("1", "getAlgorithmId", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "int"), 46);
        PiffSampleEncryptionBox.ajc$tjp_1 = bVar.h(str44, bVar.g("1", "setAlgorithmId", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "int", "algorithmId", "", "void"), 50);
        PiffSampleEncryptionBox.ajc$tjp_2 = bVar.h(str44, bVar.g("1", "getIvSize", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "int"), 54);
        PiffSampleEncryptionBox.ajc$tjp_3 = bVar.h(str44, bVar.g("1", "setIvSize", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "int", "ivSize", "", "void"), 58);
        PiffSampleEncryptionBox.ajc$tjp_4 = bVar.h(str44, bVar.g("1", "getKid", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "", "", "", "[B"), 62);
        PiffSampleEncryptionBox.ajc$tjp_5 = bVar.h(str44, bVar.g("1", "setKid", "com.googlecode.mp4parser.boxes.piff.PiffSampleEncryptionBox", "[B", "kid", "", "void"), 66);
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
        return new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox
    public boolean isOverrideTrackEncryptionBoxParameters() {
        final boolean z = true;
        if (getFlags() & z > 0) {
            return true;
        }
        return false;
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
        if (z) {
            i2 = getFlags() | 1;
            setFlags(i2);
        } else {
            int i = 16777214;
            i2 = getFlags() & i;
            setFlags(i2);
        }
    }
}
