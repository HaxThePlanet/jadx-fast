package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.f;
import f.b.a.h;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AppleVariableSignedIntegerBox.java */
/* loaded from: classes2.dex */
public abstract class AppleVariableSignedIntegerBox extends AppleDataBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    int intLength = 1;
    long value;
    static {
        AppleVariableSignedIntegerBox.ajc$preClinit();
    }

    protected AppleVariableSignedIntegerBox(String str) {
        super(str, 15);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("AppleVariableSignedIntegerBox.java", AppleVariableSignedIntegerBox.class);
        final String str30 = "method-execution";
        AppleVariableSignedIntegerBox.ajc$tjp_0 = bVar.h(str30, bVar.g("1", "getIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "int"), 19);
        AppleVariableSignedIntegerBox.ajc$tjp_1 = bVar.h(str30, bVar.g("1", "setIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "int", "intLength", "", "void"), 23);
        AppleVariableSignedIntegerBox.ajc$tjp_2 = bVar.h(str30, bVar.g("1", "getValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "long"), 27);
        AppleVariableSignedIntegerBox.ajc$tjp_3 = bVar.h(str30, bVar.g("1", "setValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "long", "value", "", "void"), 36);
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
    public void setValue(long j) {
        d dVar;
        d.b().c(b.d(AppleVariableSignedIntegerBox.ajc$tjp_3, this, this, a.f(j)));
        if (j <= 127) {
            if (j > -128) {
                int cmp2 = 1;
                this.intLength = cmp2;
            } else {
                if (j <= 32767) {
                    if (j > -32768) {
                        int i8 = 2;
                        if (this.intLength < i8) {
                            this.intLength = i8;
                        } else {
                            if (j <= 8388607) {
                                if (j > -8388608) {
                                    int i7 = 3;
                                    if (this.intLength < i7) {
                                        this.intLength = i7;
                                    } else {
                                        cmp2 = 4;
                                        this.intLength = cmp2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.value = j;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        int dataLength = getDataLength();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[dataLength]);
        h.a(this.value, wrap, dataLength);
        return wrap.array();
    }
}
