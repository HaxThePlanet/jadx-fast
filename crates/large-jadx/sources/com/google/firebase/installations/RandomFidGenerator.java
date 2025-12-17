package com.google.firebase.installations;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* loaded from: classes2.dex */
public class RandomFidGenerator {

    private static final byte FID_4BIT_PREFIX = (byte) 0;
    private static final int FID_LENGTH = 22;
    private static final byte REMOVE_PREFIX_MASK;
    static {
        final int i = 2;
        RandomFidGenerator.FID_4BIT_PREFIX = Byte.parseByte("01110000", i);
        RandomFidGenerator.REMOVE_PREFIX_MASK = Byte.parseByte("00001111", i);
    }

    private static String encodeFidBase64UrlSafe(byte[] bArr) {
        String string = new String(Base64.encode(bArr, 11), Charset.defaultCharset());
        return string.substring(0, 22);
    }

    private static byte[] getBytesFromUUID(UUID uUID, byte[] b2Arr2) {
        final ByteBuffer obj3 = ByteBuffer.wrap(b2Arr2);
        obj3.putLong(uUID.getMostSignificantBits());
        obj3.putLong(uUID.getLeastSignificantBits());
        return obj3.array();
    }

    public String createRandomFid() {
        byte[] bytesFromUUID = RandomFidGenerator.getBytesFromUUID(UUID.randomUUID(), new byte[17]);
        int i2 = 0;
        bytesFromUUID[16] = bytesFromUUID[i2];
        bytesFromUUID[i2] = (byte)i4;
        return RandomFidGenerator.encodeFidBase64UrlSafe(bytesFromUUID);
    }
}
