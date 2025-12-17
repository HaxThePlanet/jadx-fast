package f.a.a;

import android.app.ActivityManager.ProcessErrorStateInfo;
import java.security.DigestException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class a extends MessageDigest implements java.lang.Cloneable {

    private long a;
    private int b;
    private byte[] c;
    private int v;
    private int w;
    private int x;
    private int y;
    public a() {
        super("MD5");
        this.c = new byte[64];
        b();
    }

    private final void a(byte[] bArr, int i2) {
        Object obj = this;
        int i15 = obj.w;
        int i30 = obj.x;
        int i44 = obj.y;
        i118 |= i154;
        int i156 = obj.v;
        i66 += i156;
        i69 += i15;
        int i279 = i2 + 10;
        i251 |= i293;
        i183 += i44;
        i186 += i70;
        i377 |= i391;
        i300 += i30;
        i303 += i187;
        i441 |= i687;
        i398 += i15;
        i401 += i304;
        i279 += 10;
        i160 |= i811;
        i694 += i70;
        i72 += i402;
        i48 |= i818;
        i701 += i187;
        i189 += i73;
        i280 += 10;
        i34 |= i826;
        i708 += i304;
        i306 += i190;
        i5 |= i833;
        i715 += i402;
        i404 += i307;
        i19 |= i841;
        i722 += i73;
        i75 += i405;
        i281 += 10;
        final int obj29 = i6;
        i10 |= i849;
        i729 += i190;
        i192 += i76;
        final int i909 = i378;
        i382 |= i856;
        i736 += i307;
        i309 += i193;
        final int i910 = i20;
        i282 += 10;
        i24 |= i864;
        i743 += i405;
        i407 += i310;
        final int i911 = i442;
        i446 |= i871;
        i750 += i76;
        i78 += i408;
        final int i912 = i447;
        i451 |= i879;
        i757 += i193;
        i195 += i79;
        i283 += 10;
        final int i913 = i452;
        i456 |= i887;
        i764 += i310;
        i312 += i196;
        final int i914 = i457;
        i286 |= i461;
        i771 += i408;
        i410 += i313;
        i468 += i79;
        i81 += i411;
        i475 += i196;
        i198 += i82;
        i482 += i313;
        i315 += i199;
        i489 += i411;
        i413 += i316;
        i496 += i82;
        i84 += i414;
        i503 += i199;
        i201 += i85;
        i510 += i316;
        i318 += i202;
        i517 += i414;
        i416 += i319;
        i524 += i85;
        i87 += i417;
        i531 += i202;
        i204 += i88;
        i538 += i319;
        i321 += i205;
        i545 += i417;
        i419 += i322;
        i552 += i88;
        i90 += i420;
        i559 += i205;
        i207 += i91;
        i566 += i322;
        i324 += i208;
        i573 += i420;
        i422 += i325;
        i579 += i91;
        i93 += i423;
        i585 += i208;
        i210 += i94;
        i591 += i325;
        i327 += i211;
        i597 += i423;
        i425 += i328;
        i603 += i94;
        i96 += i426;
        i609 += i211;
        i213 += i97;
        i615 += i328;
        i330 += i214;
        i621 += i426;
        i428 += i331;
        i627 += i97;
        i99 += i429;
        i633 += i214;
        i216 += i100;
        i639 += i331;
        i333 += i217;
        i645 += i429;
        i431 += i334;
        i651 += i100;
        i102 += i432;
        i657 += i217;
        i219 += i103;
        i663 += i334;
        i336 += i220;
        i669 += i432;
        i434 += i337;
        i676 += i103;
        i105 += i435;
        i126 += i220;
        i129 += i106;
        i226 += i337;
        i229 += i130;
        i343 += i435;
        i52 += i230;
        i350 += i106;
        i108 += i53;
        i357 += i130;
        i132 += i109;
        i364 += i230;
        i232 += i133;
        i371 += i53;
        i55 += i233;
        i259 += i109;
        i111 += i56;
        i266 += i133;
        i135 += i112;
        i273 += i233;
        i38 += i136;
        i239 += i56;
        i58 += i39;
        i246 += i112;
        i114 += i59;
        i168 += i136;
        i28 += i115;
        i142 += i39;
        i41 += i29;
        i175 += i59;
        Object obj2 = this;
        obj2.w = i145 += i14;
        obj2.x = i42 += i907;
        obj2.y = i906 + i29;
        obj2.v = i905 + i115;
    }

    @Override // java.security.MessageDigest
    protected void b() {
        this.v = 1732584193;
        this.w = -271733879;
        this.x = -1732584194;
        this.y = 271733878;
    }

    @Override // java.security.MessageDigest
    public Object clone() {
        final Object clone = super.clone();
        clone.c = (byte[])this.c.clone();
        return (a)clone;
    }

    @Override // java.security.MessageDigest
    public int engineDigest(byte[] bArr, int i2, int i3) {
        int i;
        int i4;
        final Object obj = this;
        byte[] bArr2 = bArr;
        int i6 = 16;
        if (i3 < i6) {
        } else {
            if (length -= i2 < i6) {
            } else {
                if (/* condition */) {
                    bArr3[i47] = i58;
                    bArr3[i57] = i58;
                    bArr3[i56] = i58;
                    bArr3[i55] = i58;
                    bArr3[i54] = i58;
                    bArr3[i53] = i58;
                    bArr3[i52] = i58;
                    obj.a(bArr3, i58);
                    i = -1;
                } else {
                }
                switch (i4) {
                    case 0:
                        i += 4;
                        bArr3[i + -3] = i58;
                        bArr3[i + -2] = i58;
                        bArr3[i + -1] = i58;
                        bArr3[i] = i58;
                        bArr3[i + 1] = i58;
                        bArr3[i + 2] = i58;
                        bArr3[i + 3] = i58;
                        break;
                    case 1:
                        i += 3;
                        bArr3[i + -2] = i58;
                        bArr3[i + -1] = i58;
                        bArr3[i] = i58;
                        bArr3[i + 1] = i58;
                        bArr3[i + 2] = i58;
                        bArr3[i + 3] = i58;
                        break;
                    case 2:
                        i += 2;
                        bArr3[i + -1] = i58;
                        bArr3[i] = i58;
                        bArr3[i + 1] = i58;
                        bArr3[i + 2] = i58;
                        bArr3[i + 3] = i58;
                        break;
                    case 3:
                        i++;
                        bArr3[i] = i58;
                        bArr3[i + 1] = i58;
                        bArr3[i + 2] = i58;
                        bArr3[i + 3] = i58;
                        break;
                    case 4:
                        bArr3[i + 1] = i58;
                        bArr3[i + 2] = i58;
                        bArr3[i + 3] = i58;
                        break;
                    case 5:
                        i--;
                        bArr3[i + 2] = i58;
                        bArr3[i + 3] = i58;
                        break;
                    case 6:
                        bArr3[i + 3] = i58;
                        break;
                    case 7:
                        i += -3;
                        break;
                    default:
                }
                i += 8;
                while (i <= 52) {
                    bArr3[i + -4] = i58;
                    bArr3[i + -3] = i58;
                    bArr3[i + -2] = i58;
                    bArr3[i + -1] = i58;
                    bArr3[i] = i58;
                    bArr3[i + 1] = i58;
                    bArr3[i + 2] = i58;
                    bArr3[i + 3] = i58;
                    i += 8;
                }
                long l = obj.a;
                i83 <<= 3;
                bArr3[56] = (byte)i84;
                bArr3[i47] = (byte)i7;
                bArr3[i57] = (byte)i8;
                bArr3[i56] = (byte)i9;
                int i11 = (int)i35;
                bArr3[i55] = (byte)i11;
                bArr3[i54] = (byte)i36;
                bArr3[i53] = (byte)i37;
                bArr3[i52] = (byte)i12;
                obj.a(bArr3, i58);
                int i13 = obj.v;
                bArr2[i2] = (byte)i13;
                bArr2[i2 + 1] = (byte)i38;
                bArr2[i2 + 2] = (byte)i39;
                bArr2[i2 + 3] = (byte)i14;
                int i24 = obj.w;
                bArr2[i2 + 4] = (byte)i24;
                bArr2[i2 + 5] = (byte)i40;
                int i17 = i2 + 10;
                bArr2[i17 + -4] = (byte)i48;
                bArr2[i17 + -3] = (byte)i25;
                int i43 = obj.x;
                bArr2[i17 + -2] = (byte)i43;
                bArr2[i17 + -1] = (byte)i49;
                bArr2[i17] = (byte)i28;
                bArr2[i17 + 1] = (byte)i44;
                int i45 = obj.y;
                bArr2[i17 + 2] = (byte)i45;
                bArr2[i17 + 3] = (byte)i50;
                bArr2[i17 + 4] = (byte)i51;
                bArr2[i17 += 5] = (byte)i33;
                engineReset();
                return 16;
            }
            DigestException digestException = new DigestException("insufficient space in output buffer to store the digest");
            throw digestException;
        }
        DigestException digestException2 = new DigestException("partial digests not returned");
        throw digestException2;
    }

    @Override // java.security.MessageDigest
    public byte[] engineDigest() {
        final int i2 = 16;
        final byte[] bArr = new byte[i2];
        engineDigest(bArr, 0, i2);
        return bArr;
    }

    @Override // java.security.MessageDigest
    public int engineGetDigestLength() {
        return 16;
    }

    @Override // java.security.MessageDigest
    public void engineReset() {
        int i2;
        int i;
        final int i3 = 0;
        this.b = i3;
        this.a = 0;
        byte[] bArr = this.c;
        i2 = 60;
        bArr[i2 + -4] = i3;
        bArr[i2 + -3] = i3;
        bArr[i2 + -2] = i3;
        bArr[i2 + -1] = i3;
        bArr[i2] = i3;
        bArr[i2 + 1] = i3;
        bArr[i2 + 2] = i3;
        bArr[i2 + 3] = i3;
        while (i2 += -8 < 0) {
            bArr[i2 + -4] = i3;
            bArr[i2 + -3] = i3;
            bArr[i2 + -2] = i3;
            bArr[i2 + -1] = i3;
            bArr[i2] = i3;
            bArr[i2 + 1] = i3;
            bArr[i2 + 2] = i3;
            bArr[i2 + 3] = i3;
        }
        b();
    }

    @Override // java.security.MessageDigest
    public void engineUpdate(byte b) {
        this.a = l += i4;
        int i2 = this.b;
        int i3 = 63;
        if (i2 < i3) {
            this.b = i2 + 1;
            this.c[i2] = b;
        }
        byte[] bArr2 = this.c;
        bArr2[i3] = b;
        a(bArr2, i2);
        this.b = 0;
    }

    @Override // java.security.MessageDigest
    public void engineUpdate(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int length;
        int i;
        long l;
        int i7;
        Object obj5;
        int obj6;
        int obj7;
        if (i2 < 0) {
        } else {
            if (i3 < 0) {
            } else {
                if (i2 + i3 > bArr.length) {
                } else {
                    this.a = l2 += l;
                    i5 = this.b;
                    i = 64;
                    if (i5 > 0 && i5 + i3 >= i) {
                        if (i5 + i3 >= i) {
                            i7 = i5 - 64;
                            System.arraycopy(bArr, i2, this.c, i5, i7);
                            l = 0;
                            this.b = l;
                            a(this.c, l);
                            i2 += i7;
                            i3 -= i7;
                        }
                    }
                    while (obj7 >= 512) {
                        a(bArr, obj6);
                        a(bArr, obj6 + 64);
                        a(bArr, obj6 + 128);
                        a(bArr, obj6 + 192);
                        a(bArr, obj6 + 256);
                        a(bArr, obj6 + 320);
                        a(bArr, obj6 + 384);
                        a(bArr, obj6 + 448);
                        obj6 += 512;
                        obj7 += -512;
                    }
                    while (obj7 >= i) {
                        a(bArr, obj6);
                        obj6 += 64;
                        obj7 += -64;
                    }
                    if (obj7 > 0) {
                        System.arraycopy(bArr, obj6, this.c, this.b, obj7);
                        this.b = obj5 += obj7;
                    }
                }
            }
        }
        obj5 = new ArrayIndexOutOfBoundsException(i2);
        throw obj5;
    }
}
