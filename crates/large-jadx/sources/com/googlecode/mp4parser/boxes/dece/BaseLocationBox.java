package com.googlecode.mp4parser.boxes.dece;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: BaseLocationBox.java */
/* loaded from: classes2.dex */
public class BaseLocationBox extends AbstractFullBox {

    public static final String TYPE = "bloc";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    String baseLocation = "";
    String purchaseLocation = "";
    static {
        BaseLocationBox.ajc$preClinit();
    }

    public BaseLocationBox() {
        super("bloc");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("BaseLocationBox.java", BaseLocationBox.class);
        final String str51 = "method-execution";
        BaseLocationBox.ajc$tjp_0 = bVar.h(str51, bVar.g("1", "getBaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 44);
        BaseLocationBox.ajc$tjp_1 = bVar.h(str51, bVar.g("1", "setBaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "baseLocation", "", "void"), 48);
        BaseLocationBox.ajc$tjp_2 = bVar.h(str51, bVar.g("1", "getPurchaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 52);
        BaseLocationBox.ajc$tjp_3 = bVar.h(str51, bVar.g("1", "setPurchaseLocation", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.String", "purchaseLocation", "", "void"), 56);
        BaseLocationBox.ajc$tjp_4 = bVar.h(str51, bVar.g("1", "equals", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "java.lang.Object", "o", "", "boolean"), 86);
        BaseLocationBox.ajc$tjp_5 = bVar.h(str51, bVar.g("1", "hashCode", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "int"), 100);
        BaseLocationBox.ajc$tjp_6 = bVar.h(str51, bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.dece.BaseLocationBox", "", "", "", "java.lang.String"), 107);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        String str = e.g(byteBuffer);
        this.baseLocation = str;
        byteBuffer.get(new byte[(j.c(str) - 256) - 1]);
        String str2 = e.g(byteBuffer);
        this.purchaseLocation = str2;
        byteBuffer.get(new byte[(j.c(str2) - 256) - 1]);
        byteBuffer.get(new byte[512]);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean equals(Object object) {
        d.b().c(b.d(BaseLocationBox.ajc$tjp_4, this, this, object));
        boolean z = true;
        if (this == object) {
            return true;
        }
        boolean z2 = false;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.baseLocation != null) {
                    if (!this.baseLocation.equals(object.baseLocation)) {
                        return false;
                    }
                }
                if (this.purchaseLocation != null) {
                    if (!this.purchaseLocation.equals(object.purchaseLocation)) {
                        return false;
                    }
                } else {
                    return object.purchaseLocation != null ? z2 : z;
                }
            }
        }
        return false;
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
        byteBuffer.put(new byte[j.c(this.baseLocation) - 256]);
        byteBuffer.put(j.b(this.purchaseLocation));
        byteBuffer.put(new byte[j.c(this.purchaseLocation) - 256]);
        byteBuffer.put(new byte[512]);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getPurchaseLocation() {
        d.b().c(b.c(BaseLocationBox.ajc$tjp_2, this, this));
        return this.purchaseLocation;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int hashCode() {
        int i;
        d.b().c(b.c(BaseLocationBox.ajc$tjp_5, this, this));
        i = 0;
        if (this.baseLocation != null) {
            i = this.baseLocation.hashCode();
        } else {
        }
        if (this.purchaseLocation != null) {
            i = this.purchaseLocation.hashCode();
        }
        return (i * 31) + i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setBaseLocation(String str) {
        d.b().c(b.d(BaseLocationBox.ajc$tjp_1, this, this, str));
        this.baseLocation = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setPurchaseLocation(String str) {
        d.b().c(b.d(BaseLocationBox.ajc$tjp_3, this, this, str));
        this.purchaseLocation = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(BaseLocationBox.ajc$tjp_6, this, this));
        String str2 = "BaseLocationBox{baseLocation='";
        StringBuilder stringBuilder = new StringBuilder(str2);
        char c = '\'';
        String str3 = ", purchaseLocation='";
        str = str2 + this.baseLocation + c + str3 + this.purchaseLocation + c + 125;
        return str;
    }

    public BaseLocationBox(String str, String str2) {
        super("bloc");
        this.baseLocation = str;
        this.purchaseLocation = str2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 1028;
    }
}
