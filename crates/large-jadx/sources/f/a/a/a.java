package f.a.a;

import android.app.ActivityManager.ProcessErrorStateInfo;
import java.security.DigestException;
import java.security.MessageDigest;

/* compiled from: MD5.java */
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

    private final void a(byte[] bArr, int i) {
        Object bArr2 = this;
        int i125 = (bArr[i] & 255) | (bArr[i + 1]) & 255 << 8 | (bArr[i + 2]) & 255 << 16 | (bArr[i + 3]) << 24;
        int i73 = (i5 ^ i6) & i3 ^ i6 + i125 - 680876936 + i7;
        int i76 = (i73 >>> 25) | (i73 << 7) + i3;
        int i284 = i + 10;
        int i257 = (bArr[i + 4]) & 255 | (bArr[i + 5]) & 255 << 8 | (bArr[i284 - 4]) & 255 << 16 | (bArr[i284 - 3]) << 24;
        int i189 = (i3 ^ i5) & i76 ^ i5 + i257 - 389564586 + i6;
        int i192 = (i189 >>> 20) | (i189 << 12) + i76;
        int i8 = (bArr[i284 - 2]) & 255 | (bArr[i284 - 1]) & 255 << 8 | (bArr[i284] & 255) << 16 | (bArr[i284 + 1]) << 24;
        int i306 = (i76 ^ i3) & i192 ^ i3 + i8 + 606105819 + i5;
        int i309 = (i306 >>> 15) | (i306 << 17) + i192;
        int i9 = (bArr[i284 + 2]) & 255 | (bArr[i284 + 3]) & 255 << 8 | (bArr[i284 + 4]) & 255 << 16 | (bArr[i284 + 5]) << 24;
        int i403 = (i192 ^ i76) & i309 ^ i76 + i9 - 1044525330 + i3;
        int i406 = (i403 >>> 10) | (i403 << 22) + i309;
        i284 += 10;
        int i166 = (bArr[i285 - 3]) & 255 << 8 | (bArr[i285 - 4]) & 255 | (bArr[i285 - 2]) & 255 << 16 | (bArr[i285 - 1]) << 24;
        int i695 = (i309 ^ i192) & i406 ^ i192 + i166 - 176418897 + i76;
        int i79 = (i695 << 7) | (i695 >>> 25) + i406;
        int i55 = (bArr[i285 + 1]) & 255 << 8 | (bArr[i285] & 255) | (bArr[i285 + 2]) & 255 << 16 | (bArr[i285 + 3]) << 24;
        int i702 = (i406 ^ i309) & i79 ^ i309 + i55 + 1200080426 + i192;
        int i195 = (i702 << 12) | (i702 >>> 20) + i79;
        int i286 = i285 + 10;
        int i42 = (bArr[i285 + 5]) & 255 << 8 | (bArr[i285 + 4]) & 255 | (bArr[i286 - 4]) & 255 << 16 | (bArr[i286 - 3]) << 24;
        int i709 = (i79 ^ i406) & i195 ^ i406 + i42 - 1473231341 + i309;
        int i312 = (i709 << 17) | (i709 >>> 15) + i195;
        i = (bArr[i286 - 1]) & 255 << 8 | (bArr[i286 - 2]) & 255 | (bArr[i286] & 255) << 16 | (bArr[i286 + 1]) << 24;
        int i716 = (i195 ^ i79) & i312 ^ i79 + i - 45705983 + i406;
        int i409 = (i716 << 22) | (i716 >>> 10) + i312;
        int i4 = (bArr[i286 + 3]) & 255 << 8 | (bArr[i286 + 2]) & 255 | (bArr[i286 + 4]) & 255 << 16 | (bArr[i286 + 5]) << 24;
        int i723 = (i312 ^ i195) & i409 ^ i195 + i4 + 1770035416 + i79;
        int i82 = (i723 << 7) | (i723 >>> 25) + i409;
        i286 += 10;
        int i21 = (bArr[i287 - 3]) & 255 << 8 | (bArr[i287 - 4]) & 255 | (bArr[i287 - 2]) & 255 << 16 | (bArr[i287 - 1]) << 24;
        int i730 = (i409 ^ i312) & i82 ^ i312 + i21 - 1958414417 + i195;
        int i198 = (i730 << 12) | (i730 >>> 20) + i82;
        int i387 = (bArr[i287 + 1]) & 255 << 8 | (bArr[i287] & 255) | (bArr[i287 + 2]) & 255 << 16 | (bArr[i287 + 3]) << 24;
        int i737 = (i82 ^ i409) & i198 ^ i409 + i387 - 42063 + i312;
        int i315 = (i737 << 17) | (i737 >>> 15) + i198;
        int i288 = i287 + 10;
        int i33 = (bArr[i287 + 5]) & 255 << 8 | (bArr[i287 + 4]) & 255 | (bArr[i288 - 4]) & 255 << 16 | (bArr[i288 - 3]) << 24;
        int i744 = (i198 ^ i82) & i315 ^ i82 + i33 - 1990404162 + i409;
        int i412 = (i744 << 22) | (i744 >>> 10) + i315;
        int i10 = (bArr[i288 - 1]) & 255 << 8 | (bArr[i288 - 2]) & 255 | (bArr[i288] & 255) << 16 | (bArr[i288 + 1]) << 24;
        int i751 = (i315 ^ i198) & i412 ^ i198 + i10 + 1804603682 + i82;
        int i85 = (i751 << 7) | (i751 >>> 25) + i412;
        int i11 = (bArr[i288 + 3]) & 255 << 8 | (bArr[i288 + 2]) & 255 | (bArr[i288 + 4]) & 255 << 16 | (bArr[i288 + 5]) << 24;
        int i758 = (i412 ^ i315) & i85 ^ i315 + i11 - 40341101 + i198;
        int i201 = (i758 << 12) | (i758 >>> 20) + i85;
        i288 += 10;
        int i12 = (bArr[i289 - 3]) & 255 << 8 | (bArr[i289 - 4]) & 255 | (bArr[i289 - 2]) & 255 << 16 | (bArr[i289 - 1]) << 24;
        int i765 = (i85 ^ i412) & i201 ^ i412 + i12 - 1502002290 + i315;
        int i318 = (i765 << 17) | (i765 >>> 15) + i201;
        int i292 = (bArr[i289 + 3]) << 24 | (bArr[i289 + 1]) & 255 << 8 | (bArr[i289] & 255) | (bArr[i289 + 2]) & 255 << 16;
        int i772 = (i201 ^ i85) & i318 ^ i85 + i292 + 1236535329 + i412;
        int i415 = (i772 << 22) | (i772 >>> 10) + i318;
        int i469 = (i318 ^ i415) & i201 ^ i318 + i257 - 165796510 + i85;
        int i88 = (i469 << 5) | (i469 >>> 27) + i415;
        int i476 = (i415 ^ i88) & i318 ^ i415 + i42 - 1069501632 + i201;
        int i204 = (i476 << 9) | (i476 >>> 23) + i88;
        int i483 = (i88 ^ i204) & i415 ^ i88 + i33 + 643717713 + i318;
        int i321 = (i483 << 14) | (i483 >>> 18) + i204;
        int i490 = (i204 ^ i321) & i88 ^ i204 + i125 - 373897302 + i415;
        int i418 = (i490 << 20) | (i490 >>> 12) + i321;
        int i497 = (i321 ^ i418) & i204 ^ i321 + i55 - 701558691 + i88;
        int i91 = (i497 << 5) | (i497 >>> 27) + i418;
        int i504 = (i418 ^ i91) & i321 ^ i418 + i387 + 38016083 + i204;
        int i207 = (i504 << 9) | (i504 >>> 23) + i91;
        int i511 = (i91 ^ i207) & i418 ^ i91 + i292 - 660478335 + i321;
        int i324 = (i511 << 14) | (i511 >>> 18) + i207;
        int i518 = (i207 ^ i324) & i91 ^ i207 + i166 - 405537848 + i418;
        int i421 = (i518 << 20) | (i518 >>> 12) + i324;
        int i525 = (i324 ^ i421) & i207 ^ i324 + i21 + 568446438 + i91;
        int i94 = (i525 << 5) | (i525 >>> 27) + i421;
        int i532 = (i421 ^ i94) & i324 ^ i421 + i12 - 1019803690 + i207;
        int i210 = (i532 << 9) | (i532 >>> 23) + i94;
        int i539 = (i94 ^ i210) & i421 ^ i94 + i9 - 187363961 + i324;
        int i327 = (i539 << 14) | (i539 >>> 18) + i210;
        int i546 = (i210 ^ i327) & i94 ^ i210 + i4 + 1163531501 + i421;
        int i424 = (i546 << 20) | (i546 >>> 12) + i327;
        int i553 = (i327 ^ i424) & i210 ^ i327 + i11 - 1444681467 + i94;
        int i97 = (i553 << 5) | (i553 >>> 27) + i424;
        int i560 = (i424 ^ i97) & i327 ^ i424 + i8 - 51403784 + i210;
        int i213 = (i560 << 9) | (i560 >>> 23) + i97;
        int i567 = (i97 ^ i213) & i424 ^ i97 + i + 1735328473 + i327;
        int i330 = (i567 << 14) | (i567 >>> 18) + i213;
        int i574 = (i213 ^ i330) & i97 ^ i213 + i10 - 1926607734 + i424;
        int i427 = (i574 << 20) | (i574 >>> 12) + i330;
        int i580 = (i330 ^ i427) ^ i213 + i55 - 378558 + i97;
        int i100 = (i580 << 4) | (i580 >>> 28) + i427;
        int i586 = (i427 ^ i100) ^ i330 + i4 - 2022574463 + i213;
        int i216 = (i586 << 11) | (i586 >>> 21) + i100;
        int i592 = (i100 ^ i216) ^ i427 + i33 + 1839030562 + i330;
        int i333 = (i592 << 16) | (i592 >>> 16) + i216;
        int i598 = (i216 ^ i333) ^ i100 + i12 - 35309556 + i427;
        int i430 = (i598 << 23) | (i598 >>> 9) + i333;
        int i604 = (i333 ^ i430) ^ i216 + i257 - 1530992060 + i100;
        int i103 = (i604 << 4) | (i604 >>> 28) + i430;
        int i610 = (i430 ^ i103) ^ i333 + i166 + 1272893353 + i216;
        int i219 = (i610 << 11) | (i610 >>> 21) + i103;
        int i616 = (i103 ^ i219) ^ i430 + i - 155497632 + i333;
        int i336 = (i616 << 16) | (i616 >>> 16) + i219;
        int i622 = (i219 ^ i336) ^ i103 + i387 - 1094730640 + i430;
        int i433 = (i622 << 23) | (i622 >>> 9) + i336;
        int i628 = (i336 ^ i433) ^ i219 + i11 + 681279174 + i103;
        int i106 = (i628 << 4) | (i628 >>> 28) + i433;
        int i634 = (i433 ^ i106) ^ i336 + i125 - 358537222 + i219;
        int i222 = (i634 << 11) | (i634 >>> 21) + i106;
        int i640 = (i106 ^ i222) ^ i433 + i9 - 722521979 + i336;
        int i339 = (i640 << 16) | (i640 >>> 16) + i222;
        int i646 = (i222 ^ i339) ^ i106 + i42 + 76029189 + i433;
        int i436 = (i646 << 23) | (i646 >>> 9) + i339;
        int i652 = (i339 ^ i436) ^ i222 + i21 - 640364487 + i106;
        int i109 = (i652 << 4) | (i652 >>> 28) + i436;
        int i658 = (i436 ^ i109) ^ i339 + i10 - 421815835 + i222;
        int i225 = (i658 << 11) | (i658 >>> 21) + i109;
        int i664 = (i109 ^ i225) ^ i436 + i292 + 530742520 + i339;
        int i342 = (i664 << 16) | (i664 >>> 16) + i225;
        int i670 = (i225 ^ i342) ^ i109 + i8 - 995338651 + i436;
        int i439 = (i670 << 23) | (i670 >>> 9) + i342;
        int i677 = (~i225 | i439) ^ i342 + i125 - 198630844 + i109;
        int i112 = (i677 << 6) | (i677 >>> 26) + i439;
        int i133 = (~i342 | i112) ^ i439 + i + 1126891415 + i225;
        int i136 = (i133 >>> 22) | (i133 << 10) + i112;
        int i232 = (~i439 | i136) ^ i112 + i12 - 1416354905 + i342;
        int i235 = (i232 >>> 17) | (i232 << 15) + i136;
        int i349 = (~i112 | i235) ^ i136 + i55 - 57434055 + i439;
        int i59 = (i349 << 21) | (i349 >>> 11) + i235;
        int i356 = (~i136 | i59) ^ i235 + i10 + 1700485571 + i112;
        int i115 = (i356 << 6) | (i356 >>> 26) + i59;
        int i363 = (~i235 | i115) ^ i59 + i9 - 1894986606 + i136;
        int i139 = (i363 << 10) | (i363 >>> 22) + i115;
        int i370 = (~i59 | i139) ^ i115 + i387 - 1051523 + i235;
        int i238 = (i370 << 15) | (i370 >>> 17) + i139;
        int i377 = (~i115 | i238) ^ i139 + i257 - 2054922799 + i59;
        int i62 = (i377 << 21) | (i377 >>> 11) + i238;
        int i265 = (~i139 | i62) ^ i238 + i4 + 1873313359 + i115;
        int i118 = (i265 << 6) | (i265 >>> 26) + i62;
        int i272 = (~i238 | i118) ^ i62 + i292 - (0x01d31920 /* Unknown resource */) + i139;
        int i142 = (i272 << 10) | (i272 >>> 22) + i118;
        int i279 = (~i62 | i142) ^ i118 + i42 - 1560198380 + i238;
        int i46 = (i279 << 15) | (i279 >>> 17) + i142;
        int i245 = (~i118 | i46) ^ i142 + i11 + 1309151649 + i62;
        int i65 = (i245 << 21) | (i245 >>> 11) + i46;
        int i252 = (~i142 | i65) ^ i46 + i166 - 145523070 + i118;
        int i121 = (i252 << 6) | (i252 >>> 26) + i65;
        int i174 = (~i46 | i121) ^ i65 + i33 - 1120210379 + i142;
        int i37 = (i174 << 10) | (i174 >>> 22) + i121;
        int i149 = (~i65 | i37) ^ i121 + i8 + 718787259 + i46;
        int i49 = (i149 << 15) | (i149 >>> 17) + i37;
        int i181 = (~i121 | i49) ^ i37 + i21 - 343485551 + i65;
        bArr2 = this;
        bArr2.w = (i3 + i49) + (i181 << 21) | (i181 >>> 11);
        bArr2.x = i5 + i49;
        bArr2.y = i6 + i37;
        bArr2.v = i7 + i121;
    }

    @Override // java.security.MessageDigest
    protected void b() {
        this.v = 1732584193;
        this.w = -271733879;
        this.x = -1732584194;
        this.y = 271733878;
    }

    @Override // java.security.MessageDigest
    public Object clone() throws java.lang.CloneNotSupportedException {
        final Object clone = super.clone();
        clone.c = (byte[])this.c.clone();
        return clone;
    }

    @Override // java.security.MessageDigest
    public byte[] engineDigest() {
        final int i2 = 16;
        try {
            final byte[] bArr = new byte[i2];
            engineDigest(bArr, 0, i2);
        } catch (java.security.DigestException unused) {
            return null;
        }
        return bArr;
    }

    @Override // java.security.MessageDigest
    public void engineReset() {
        int i = 60;
        final int i3 = 0;
        this.b = i3;
        this.a = 0L;
        i = 60;
        this.c[i - 4] = i3;
        this.c[i - 3] = i3;
        this.c[i - 2] = i3;
        this.c[i - 1] = i3;
        this.c[i] = i3;
        this.c[i + 1] = i3;
        this.c[i + 2] = i3;
        i2 = i + 3;
        this.c[i2] = i3;
        i = i - 8;
        while (i - 8 < 0) {
            this.c[i - 4] = i3;
            this.c[i - 3] = i3;
            this.c[i - 2] = i3;
            this.c[i - 1] = i3;
            this.c[i] = i3;
            this.c[i + 1] = i3;
            this.c[i + 2] = i3;
            i2 = i + 3;
            this.c[i + 3] = i3;
            i = i - 8;
        }
        b();
    }

    @Override // java.security.MessageDigest
    public void engineUpdate(byte b) {
        this.a++;
        int i2 = 63;
        if (this.b < i2) {
            this.b++;
            this.c[this.b] = b;
            return;
        }
        this.c[i2] = b;
        a(this.c, this.b);
        this.b = 0;
    }

    @Override // java.security.MessageDigest
    public int engineDigest(byte[] bArr, int i, int i2) throws DigestException {
        final Object bArr3 = this;
        byte[] bArr2 = bArr;
        int i6 = 16;
        if (i2 < i6) {
            throw new DigestException("partial digests not returned");
        } else {
            if (bArr2.length - i < i6) {
                throw new DigestException("insufficient space in output buffer to store the digest");
            } else {
                if (/* condition */) {
                    bArr4[i46] = b25;
                    bArr4[i56] = b25;
                    bArr4[i55] = b25;
                    bArr4[i54] = b25;
                    bArr4[i53] = b25;
                    bArr4[i52] = b25;
                    bArr4[i51] = b25;
                    bArr3.a(bArr4, b25);
                    i = -1;
                }
                i4 = i & 7;
                switch (i4) {
                    case 0:
                        i = i + 4;
                        bArr4[i - 3] = b25;
                        bArr4[i - 2] = b25;
                        bArr4[i - 1] = b25;
                        bArr4[i] = b25;
                        bArr4[i + 1] = b25;
                        bArr4[i + 2] = b25;
                        i4 = i + 3;
                        bArr4[i + 3] = b25;
                        break;
                    case 1:
                        i = i + 3;
                        bArr4[i - 2] = b25;
                        bArr4[i - 1] = b25;
                        bArr4[i] = b25;
                        bArr4[i + 1] = b25;
                        bArr4[i + 2] = b25;
                        i4 = i + 3;
                        bArr4[i + 3] = b25;
                        break;
                    case 2:
                        i = i + 2;
                        bArr4[i - 1] = b25;
                        bArr4[i] = b25;
                        bArr4[i + 1] = b25;
                        bArr4[i + 2] = b25;
                        i4 = i + 3;
                        bArr4[i + 3] = b25;
                        break;
                    case 3:
                        i = i + 1;
                        bArr4[i] = b25;
                        bArr4[i + 1] = b25;
                        bArr4[i + 2] = b25;
                        i4 = i + 3;
                        bArr4[i + 3] = b25;
                        break;
                    case 4:
                        bArr4[i + 1] = b25;
                        bArr4[i + 2] = b25;
                        i4 = i + 3;
                        bArr4[i + 3] = b25;
                        break;
                    case 5:
                        i = i - 1;
                        bArr4[i + 2] = b25;
                        i4 = i + 3;
                        bArr4[i + 3] = b25;
                        break;
                    case 6:
                        i = i - 2;
                        i4 = (i - 2) + 3;
                        bArr4[i - 2 + 3] = b25;
                        break;
                    case 7:
                        i = i - 3;
                        break;
                    default:
                }
                i = i + 8;
                while (i <= 52) {
                    bArr4[i - 4] = b25;
                    bArr4[i - 3] = b25;
                    bArr4[i - 2] = b25;
                    bArr4[i - 1] = b25;
                    bArr4[i] = b25;
                    bArr4[i + 1] = b25;
                    bArr4[i + 2] = b25;
                    i4 = i + 3;
                    bArr4[i4] = b25;
                    i = i + 8;
                }
                int i82 = (int)l2 << 3;
                bArr4[56] = (byte)i82;
                bArr4[i46] = (byte)(i82 >>> 8);
                bArr4[i56] = (byte)(i82 >>> 16);
                bArr4[i55] = (byte)(i82 >>> 24);
                int i11 = (int)(l2 >>> 29L);
                bArr4[i54] = (byte)i11;
                bArr4[i53] = (byte)(i11 >>> 8);
                bArr4[i52] = (byte)(i11 >>> 16);
                bArr4[i51] = (byte)(i11 >>> 24);
                bArr3.a(bArr4, b25);
                bArr2[i] = (byte)i13;
                bArr2[i + 1] = (byte)(i13 >>> 8);
                bArr2[i + 2] = (byte)(i13 >>> 16);
                bArr2[i + 3] = (byte)(i13 >>> 24);
                bArr2[i + 4] = (byte)i23;
                bArr2[i + 5] = (byte)(i23 >>> 8);
                int i17 = i + 10;
                bArr2[i17 - 4] = (byte)(i23 >>> 16);
                bArr2[i17 - 3] = (byte)(i23 >>> 24);
                bArr2[i17 - 2] = (byte)i42;
                bArr2[i17 - 1] = (byte)(i42 >>> 8);
                bArr2[i17] = (byte)(i42 >>> 16);
                bArr2[i17 + 1] = (byte)(i42 >>> 24);
                bArr2[i17 + 2] = (byte)i44;
                bArr2[i17 + 3] = (byte)(i44 >>> 8);
                bArr2[i17 + 4] = (byte)(i44 >>> 16);
                bArr2[i17 + 5] = (byte)(i44 >>> 24);
                engineReset();
                return 16;
            }
        }
    }

    @Override // java.security.MessageDigest
    public void engineUpdate(byte[] bArr, int i, int i2) {
        long l = 0;
        int i7;
        int i9;
        int i10;
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(i);
        } else {
            if (i2 >= 0) {
                i = i + i2;
                length = bArr.length;
                if (i + i2 <= bArr.length) {
                    l = (long)i2;
                    this.a += l;
                    int i6 = 64;
                    if (this.b > 0) {
                        if (i4 + i2 >= i6) {
                            i7 = i4 - 64;
                            System.arraycopy(bArr, i, this.c, this.b, i7);
                            int i18 = 0;
                            this.b = i18;
                            a(this.c, i18);
                            i9 = i + i7;
                            i10 = i2 - i7;
                        }
                    }
                    int i5 = 512;
                    while (i10 >= 512) {
                        a(bArr, i9);
                        a(bArr, i9 + 64);
                        a(bArr, i9 + 128);
                        a(bArr, i9 + 192);
                        a(bArr, i9 + 256);
                        a(bArr, i9 + 320);
                        a(bArr, i9 + 384);
                        i4 = i9 + 448;
                        a(bArr, i4);
                        i9 = i9 + 512;
                        i10 = i10 - 512;
                        i5 = 512;
                    }
                    while (i10 >= i6) {
                        a(bArr, i9);
                        i9 = i9 + 64;
                        i10 = i10 - 64;
                    }
                    if (i10 > 0) {
                        System.arraycopy(bArr, i9, this.c, this.b, i10);
                        this.b += i10;
                    }
                    return;
                }
            }
        }
    }

    @Override // java.security.MessageDigest
    public int engineGetDigestLength() {
        return 16;
    }
}
