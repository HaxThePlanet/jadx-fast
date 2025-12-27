package com.googlecode.mp4parser.boxes.piff;

import com.google.firebase.firestore.local.SQLitePersistence;
import com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox;
import com.googlecode.mp4parser.d;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: PiffTrackEncryptionBox.java */
/* loaded from: classes2.dex */
public class PiffTrackEncryptionBox extends AbstractTrackEncryptionBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    static {
        PiffTrackEncryptionBox.ajc$preClinit();
    }

    public PiffTrackEncryptionBox() {
        super("uuid");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("PiffTrackEncryptionBox.java", PiffTrackEncryptionBox.class);
        PiffTrackEncryptionBox.ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getFlags", "com.googlecode.mp4parser.boxes.piff.PiffTrackEncryptionBox", "", "", "", "int"), 29);
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox
    public int getFlags() {
        d.b().c(b.c(PiffTrackEncryptionBox.ajc$tjp_0, this, this));
        return 0;
    }

    @Override // com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox
    public byte[] getUserType() {
        return new byte[] { -119, 116, -37, -50, 123, -25, 76, 81, -124, -7, 113, 72, -7, -120, 37, 84 };
    }
}
