package kotlin.io.encoding;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0003\n\u0002\u0010\u0012\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0001\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0003\"\u000e\u0010\u0008\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"base64DecodeMap", "", "getBase64DecodeMap$annotations", "()V", "base64EncodeMap", "", "base64UrlDecodeMap", "getBase64UrlDecodeMap$annotations", "base64UrlEncodeMap", "isInMimeAlphabet", "", "symbol", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class Base64Kt {

    private static final int[] base64DecodeMap;
    private static final byte[] base64EncodeMap;
    private static final int[] base64UrlDecodeMap;
    private static final byte[] base64UrlEncodeMap;
    static {
        int i5;
        int i;
        int i6;
        int i4;
        byte b;
        int i3;
        byte b2;
        int i2;
        byte[] bArr = new byte[64];
        bArr = new byte[]{
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
            75, 76, 77, 78, 79, 80, 81, 82, 83, 84,
            85, 86, 87, 88, 89, 90, 97, 98, 99, 100,
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120,
            121, 122, 48, 49, 50, 51, 52, 53, 54, 55,
            56, 57, 43, 47
        };
        Base64Kt.base64EncodeMap = bArr;
        int[] iArr = new int[256];
        int[] iArr3 = iArr;
        int i27 = 0;
        ArraysKt.fill$default(iArr3, -1, 0, 0, 6, 0);
        iArr3[61] = -2;
        byte[] base64EncodeMap = Base64Kt.base64EncodeMap;
        int i17 = 0;
        i5 = 0;
        i6 = 0;
        while (i6 < base64EncodeMap.length) {
            i2 = 0;
            iArr3[base64EncodeMap[i6]] = i5;
            i6++;
            i5 = i3;
        }
        Base64Kt.base64DecodeMap = iArr;
        byte[] bArr2 = new byte[64];
        bArr2 = new byte[]{
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
            75, 76, 77, 78, 79, 80, 81, 82, 83, 84,
            85, 86, 87, 88, 89, 90, 97, 98, 99, 100,
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120,
            121, 122, 48, 49, 50, 51, 52, 53, 54, 55,
            56, 57, 45, 95
        };
        Base64Kt.base64UrlEncodeMap = bArr2;
        int[] iArr2 = new int[256];
        int[] iArr4 = iArr2;
        int i28 = 0;
        ArraysKt.fill$default(iArr4, -1, 0, 0, 6, 0);
        iArr4[61] = -2;
        byte[] base64UrlEncodeMap = Base64Kt.base64UrlEncodeMap;
        int i20 = 0;
        i = 0;
        i4 = 0;
        while (i4 < base64UrlEncodeMap.length) {
            i2 = 0;
            iArr4[base64UrlEncodeMap[i4]] = i;
            i4++;
            i = i3;
        }
        Base64Kt.base64UrlDecodeMap = iArr2;
    }

    public static final int[] access$getBase64DecodeMap$p() {
        return Base64Kt.base64DecodeMap;
    }

    public static final byte[] access$getBase64EncodeMap$p() {
        return Base64Kt.base64EncodeMap;
    }

    public static final int[] access$getBase64UrlDecodeMap$p() {
        return Base64Kt.base64UrlDecodeMap;
    }

    public static final byte[] access$getBase64UrlEncodeMap$p() {
        return Base64Kt.base64UrlEncodeMap;
    }

    private static void getBase64DecodeMap$annotations() {
    }

    private static void getBase64UrlDecodeMap$annotations() {
    }

    public static final boolean isInMimeAlphabet(int symbol) {
        int i3;
        int length;
        int i2;
        int i;
        final int i4 = 0;
        if (symbol >= 0 && symbol < base64DecodeMap.length) {
            i2 = symbol < base64DecodeMap.length ? i3 : i4;
        } else {
        }
        if (i2 != 0 && Base64Kt.base64DecodeMap[symbol] != -1) {
            if (Base64Kt.base64DecodeMap[symbol] != -1) {
            } else {
                i3 = i4;
            }
        } else {
        }
        return i3;
    }
}
