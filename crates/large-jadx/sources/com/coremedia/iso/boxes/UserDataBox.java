package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: UserDataBox.java */
/* loaded from: classes.dex */
public class UserDataBox extends AbstractContainerBox {

    public static final String TYPE = "udta";
    public UserDataBox() {
        super("udta");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void getBox(WritableByteChannel writableByteChannel) {
        super.getBox(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar) {
        super.parse(aVar, byteBuffer, j, bVar);
    }
}
