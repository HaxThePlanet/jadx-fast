package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.f;
import f.b.a.h;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public abstract class AppleVariableSignedIntegerBox extends com.googlecode.mp4parser.boxes.apple.AppleDataBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    int intLength = 1;
    long value;
    static {
        AppleVariableSignedIntegerBox.ajc$preClinit();
    }

    protected AppleVariableSignedIntegerBox(String string) {
        super(string, 15);
        final int obj2 = 1;
    }

    private static void ajc$preClinit() {
        b bVar5 = new b("AppleVariableSignedIntegerBox.java", AppleVariableSignedIntegerBox.class);
        final String str30 = "method-execution";
        AppleVariableSignedIntegerBox.ajc$tjp_0 = bVar5.h(str30, bVar5.g("1", "getIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "int"), 19);
        AppleVariableSignedIntegerBox.ajc$tjp_1 = bVar5.h(str30, bVar5.g("1", "setIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "int", "intLength", "", "void"), 23);
        AppleVariableSignedIntegerBox.ajc$tjp_2 = bVar5.h(str30, bVar5.g("1", "getValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "long"), 27);
        AppleVariableSignedIntegerBox.ajc$tjp_3 = bVar5.h(str30, bVar5.g("1", "setValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "long", "value", "", "void"), 36);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return this.intLength;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public int getIntLength() {
        d.b().c(b.c(AppleVariableSignedIntegerBox.ajc$tjp_0, this, this));
        return this.intLength;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public long getValue() {
        d.b().c(b.c(AppleVariableSignedIntegerBox.ajc$tjp_2, this, this));
        if (!isParsed()) {
            parseDetails();
        }
        return this.value;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        final int remaining = byteBuffer.remaining();
        this.value = f.a(byteBuffer, remaining);
        this.intLength = remaining;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setIntLength(int i) {
        d.b().c(b.d(AppleVariableSignedIntegerBox.ajc$tjp_1, this, this, a.e(i)));
        this.intLength = i;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setValue(long l) {
        int cmp;
        int intLength;
        d dVar;
        d.b().c(b.d(AppleVariableSignedIntegerBox.ajc$tjp_3, this, this, a.f(l)));
        if (Long.compare(l, i) <= 0 && Long.compare(l, i6) > 0) {
            if (Long.compare(l, i6) > 0) {
                this.intLength = 1;
            } else {
                dVar = 2;
                if (Long.compare(l, i2) <= 0 && Long.compare(l, i5) > 0 && this.intLength < dVar) {
                    if (Long.compare(l, i5) > 0) {
                        dVar = 2;
                        if (this.intLength < dVar) {
                            this.intLength = dVar;
                        } else {
                            dVar = 3;
                            if (Long.compare(l, i3) <= 0 && Long.compare(l, i4) > 0 && this.intLength < dVar) {
                                if (Long.compare(l, i4) > 0) {
                                    dVar = 3;
                                    if (this.intLength < dVar) {
                                        this.intLength = dVar;
                                    } else {
                                        this.intLength = 4;
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        } else {
        }
        this.value = l;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        int dataLength = getDataLength();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[dataLength]);
        h.a(this.value, obj3, wrap);
        return wrap.array();
    }
}
