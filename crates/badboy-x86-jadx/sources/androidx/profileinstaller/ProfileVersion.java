package androidx.profileinstaller;

import java.util.Arrays;

/* loaded from: classes5.dex */
public class ProfileVersion {

    static final byte[] METADATA_V001_N = null;
    static final byte[] METADATA_V002 = null;
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V001_N;
    static final byte[] V005_O;
    static final byte[] V009_O_MR1;
    static final byte[] V010_P;
    static final byte[] V015_S;
    static {
        int i = 4;
        byte[] bArr2 = new byte[i];
        bArr2 = new byte[]{48, 49, 53, 0};
        ProfileVersion.V015_S = bArr2;
        byte[] bArr3 = new byte[i];
        bArr3 = new byte[]{48, 49, 48, 0};
        ProfileVersion.V010_P = bArr3;
        byte[] bArr4 = new byte[i];
        bArr4 = new byte[]{48, 48, 57, 0};
        ProfileVersion.V009_O_MR1 = bArr4;
        byte[] bArr5 = new byte[i];
        bArr5 = new byte[]{48, 48, 53, 0};
        ProfileVersion.V005_O = bArr5;
        byte[] bArr6 = new byte[i];
        bArr6 = new byte[]{48, 48, 49, 0};
        ProfileVersion.V001_N = bArr6;
        byte[] bArr7 = new byte[i];
        bArr7 = new byte[]{48, 48, 49, 0};
        ProfileVersion.METADATA_V001_N = bArr7;
        byte[] bArr = new byte[i];
        bArr = new byte[]{48, 48, 50, 0};
        ProfileVersion.METADATA_V002 = bArr;
    }

    static String dexKeySeparator(byte[] version) {
        final String str2 = ":";
        if (Arrays.equals(version, ProfileVersion.V001_N) != null) {
            return str2;
        }
        if (Arrays.equals(version, ProfileVersion.V005_O) != null) {
            return str2;
        }
        return "!";
    }
}
