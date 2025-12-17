package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
class CLSUUID {

    private static String _clsId;
    private static final AtomicLong _sequenceNumber;
    static {
        AtomicLong atomicLong = new AtomicLong(0, obj2);
        CLSUUID._sequenceNumber = atomicLong;
    }

    CLSUUID(com.google.firebase.crashlytics.internal.common.IdManager idManager) {
        super();
        byte[] bArr = new byte[10];
        populateTime(bArr);
        populateSequenceNumber(bArr);
        populatePID(bArr);
        String hexify = CommonUtils.hexify(bArr);
        final Locale uS = Locale.US;
        Object[] arr = new Object[4];
        final int i4 = 0;
        final int i5 = 12;
        arr[i4] = hexify.substring(i4, i5);
        int i6 = 16;
        arr[1] = hexify.substring(i5, i6);
        arr[2] = hexify.subSequence(i6, 20);
        arr[3] = CommonUtils.sha1(idManager.getCrashlyticsInstallId()).substring(i4, i5);
        CLSUUID._clsId = String.format(uS, "%s%s%s%s", arr).toUpperCase(uS);
    }

    private static byte[] convertLongToFourByteBuffer(long l) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int)l);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] convertLongToTwoByteBuffer(long l) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short)obj1);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void populatePID(byte[] bArr) {
        byte[] convertLongToTwoByteBuffer = CLSUUID.convertLongToTwoByteBuffer((long)shortValue);
        bArr[8] = convertLongToTwoByteBuffer[0];
        bArr[9] = convertLongToTwoByteBuffer[1];
    }

    private void populateSequenceNumber(byte[] bArr) {
        byte[] convertLongToTwoByteBuffer = CLSUUID.convertLongToTwoByteBuffer(CLSUUID._sequenceNumber.incrementAndGet());
        bArr[6] = convertLongToTwoByteBuffer[0];
        bArr[7] = convertLongToTwoByteBuffer[1];
    }

    private void populateTime(byte[] bArr) {
        Date date = new Date();
        long time = date.getTime();
        int i3 = 1000;
        byte[] convertLongToFourByteBuffer = CLSUUID.convertLongToFourByteBuffer(time / i3);
        final int i5 = 0;
        bArr[i5] = convertLongToFourByteBuffer[i5];
        int i7 = 1;
        bArr[i7] = convertLongToFourByteBuffer[i7];
        int i8 = 2;
        bArr[i8] = convertLongToFourByteBuffer[i8];
        int i9 = 3;
        bArr[i9] = convertLongToFourByteBuffer[i9];
        byte[] convertLongToTwoByteBuffer = CLSUUID.convertLongToTwoByteBuffer(time %= i3);
        bArr[4] = convertLongToTwoByteBuffer[i5];
        bArr[5] = convertLongToTwoByteBuffer[i7];
    }

    public String toString() {
        return CLSUUID._clsId;
    }
}
