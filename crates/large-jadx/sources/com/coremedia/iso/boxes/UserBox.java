package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: UserBox.java */
/* loaded from: classes.dex */
public class UserBox extends AbstractBox {

    public static final String TYPE = "uuid";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    byte[] data;
    static {
        UserBox.ajc$preClinit();
    }

    public UserBox(byte[] bArr) {
        super("uuid", bArr);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("UserBox.java", UserBox.class);
        final String str23 = "method-execution";
        UserBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.UserBox", "", "", "", "java.lang.String"), 40);
        UserBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "getData", "com.coremedia.iso.boxes.UserBox", "", "", "", "[B"), 47);
        UserBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "setData", "com.coremedia.iso.boxes.UserBox", "[B", "data", "", "void"), 51);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.data = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)this.data.length;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public byte[] getData() {
        d.b().c(b.c(UserBox.ajc$tjp_1, this, this));
        return this.data;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setData(byte[] bArr) {
        d.b().c(b.d(UserBox.ajc$tjp_2, this, this, bArr));
        this.data = bArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() throws java.io.UnsupportedEncodingException {
        d.b().c(b.c(UserBox.ajc$tjp_0, this, this));
        String str2 = "UserBox[type=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String type = getType();
        String str3 = ";userType=";
        String string = new String(getUserType());
        String str4 = ";contentLength=";
        int length = this.data.length;
        String str5 = "]";
        str = str2 + type + str3 + string + str4 + length + str5;
        return str;
    }
}
