package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class SoundMediaHeaderBox extends com.coremedia.iso.boxes.AbstractMediaHeaderBox {

    public static final String TYPE = "smhd";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private float balance;
    static {
        SoundMediaHeaderBox.ajc$preClinit();
    }

    public SoundMediaHeaderBox() {
        super("smhd");
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("SoundMediaHeaderBox.java", SoundMediaHeaderBox.class);
        final String str16 = "method-execution";
        SoundMediaHeaderBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getBalance", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "float"), 36);
        SoundMediaHeaderBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "toString", "com.coremedia.iso.boxes.SoundMediaHeaderBox", "", "", "", "java.lang.String"), 58);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.balance = e.e(byteBuffer);
        e.i(byteBuffer);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public float getBalance() {
        d.b().c(b.c(SoundMediaHeaderBox.ajc$tjp_0, this, this));
        return this.balance;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.c(byteBuffer, (double)balance);
        g.e(byteBuffer, 0);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected long getContentSize() {
        return 8;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public String toString() {
        d.b().c(b.c(SoundMediaHeaderBox.ajc$tjp_1, this, this));
        StringBuilder stringBuilder = new StringBuilder("SoundMediaHeaderBox[balance=");
        stringBuilder.append(getBalance());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
