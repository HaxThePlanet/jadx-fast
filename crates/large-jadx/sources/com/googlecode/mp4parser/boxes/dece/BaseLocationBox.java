package com.googlecode.mp4parser.boxes.dece;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class BaseLocationBox extends AbstractFullBox {

    public static final String TYPE = "bloc";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    String baseLocation;
    String purchaseLocation;
    static {
        BaseLocationBox.ajc$preClinit();
    }

    public BaseLocationBox() {
        super("bloc");
        String str2 = "";
        this.baseLocation = str2;
        this.purchaseLocation = str2;
    }

    public BaseLocationBox(String string, String string2) {
        super("bloc");
        String str2 = "";
        this.baseLocation = str2;
        this.purchaseLocation = str2;
        this.baseLocation = string;
        this.purchaseLocation = string2;
    }

    private static void ajc$preClinit() {
        b bVar8 = new b("BaseLocationBox.java", BaseLocationBox.class);
        final String str51 = "method-execution";
        BaseLocationBox.ajc$tjp_0 = bVar8.h(str51, bVar8.g("1", "getBaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 44);
        BaseLocationBox.ajc$tjp_1 = bVar8.h(str51, bVar8.g("1", "setBaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "baseLocation", "", "void"), 48);
        BaseLocationBox.ajc$tjp_2 = bVar8.h(str51, bVar8.g("1", "getPurchaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 52);
        BaseLocationBox.ajc$tjp_3 = bVar8.h(str51, bVar8.g("1", "setPurchaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "purchaseLocation", "", "void"), 56);
        BaseLocationBox.ajc$tjp_4 = bVar8.h(str51, bVar8.g("1", "equals", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.Object", "o", "", "boolean"), 86);
        BaseLocationBox.ajc$tjp_5 = bVar8.h(str51, bVar8.g("1", "hashCode", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "int"), 100);
        BaseLocationBox.ajc$tjp_6 = bVar8.h(str51, bVar8.g("1", "toString", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 107);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        String str = e.g(byteBuffer);
        this.baseLocation = str;
        byteBuffer.get(new byte[i2--]);
        String str2 = e.g(byteBuffer);
        this.purchaseLocation = str2;
        byteBuffer.get(new byte[i5--]);
        byteBuffer.get(new byte[512]);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean equals(Object object) {
        boolean baseLocation2;
        Class class;
        Object baseLocation;
        boolean obj5;
        d.b().c(b.d(BaseLocationBox.ajc$tjp_4, this, this, object));
        int i = 1;
        if (this == object) {
            return i;
        }
        int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                String baseLocation3 = this.baseLocation;
                if (baseLocation3 != null) {
                    if (!baseLocation3.equals(object.baseLocation)) {
                        return i2;
                    }
                } else {
                    if (object.baseLocation != null) {
                    }
                }
                String purchaseLocation = this.purchaseLocation;
                obj5 = object.purchaseLocation;
                if (purchaseLocation != null) {
                    if (!purchaseLocation.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getBaseLocation() {
        d.b().c(b.c(BaseLocationBox.ajc$tjp_0, this, this));
        return this.baseLocation;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(j.b(this.baseLocation));
        byteBuffer.put(new byte[i - 256]);
        byteBuffer.put(j.b(this.purchaseLocation));
        byteBuffer.put(new byte[i3 - 256]);
        byteBuffer.put(new byte[512]);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 1028;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getPurchaseLocation() {
        d.b().c(b.c(BaseLocationBox.ajc$tjp_2, this, this));
        return this.purchaseLocation;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int hashCode() {
        int i2;
        int i;
        d.b().c(b.c(BaseLocationBox.ajc$tjp_5, this, this));
        String baseLocation = this.baseLocation;
        if (baseLocation != null) {
            i2 = baseLocation.hashCode();
        } else {
            i2 = i;
        }
        final String purchaseLocation = this.purchaseLocation;
        if (purchaseLocation != null) {
            i = purchaseLocation.hashCode();
        }
        return i3 += i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setBaseLocation(String string) {
        d.b().c(b.d(BaseLocationBox.ajc$tjp_1, this, this, string));
        this.baseLocation = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setPurchaseLocation(String string) {
        d.b().c(b.d(BaseLocationBox.ajc$tjp_3, this, this, string));
        this.purchaseLocation = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(BaseLocationBox.ajc$tjp_6, this, this));
        StringBuilder stringBuilder = new StringBuilder("BaseLocationBox{baseLocation='");
        stringBuilder.append(this.baseLocation);
        int i = 39;
        stringBuilder.append(i);
        stringBuilder.append(", purchaseLocation='");
        stringBuilder.append(this.purchaseLocation);
        stringBuilder.append(i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
