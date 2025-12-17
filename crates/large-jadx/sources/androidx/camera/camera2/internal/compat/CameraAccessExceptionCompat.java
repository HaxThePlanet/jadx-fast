package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class CameraAccessExceptionCompat extends Exception {

    static final Set<Integer> a;
    private final CameraAccessException mCameraAccessException;
    private final int mReason;
    static {
        int i = 5;
        Integer[] arr2 = new Integer[i];
        final int i4 = 4;
        final int i6 = 0;
        arr2[i6] = Integer.valueOf(i4);
        int i5 = 1;
        arr2[i5] = Integer.valueOf(i);
        final int i7 = 2;
        arr2[i7] = Integer.valueOf(i5);
        final int i8 = 3;
        arr2[i8] = Integer.valueOf(i7);
        arr2[i4] = Integer.valueOf(i8);
        HashSet hashSet = new HashSet(Arrays.asList(arr2));
        CameraAccessExceptionCompat.a = Collections.unmodifiableSet(hashSet);
        Integer[] arr = new Integer[i7];
        arr[i6] = 10001;
        arr[i5] = 10002;
        HashSet hashSet2 = new HashSet(Arrays.asList(arr));
        Collections.unmodifiableSet(hashSet2);
    }
}
