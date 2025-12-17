package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

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
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        super.parse(a, byteBuffer2, l3, b4);
    }
}
