package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.a;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends a {

    private static androidx.core.app.a.d d;

    class a implements Runnable {

        final String[] a;
        final Activity b;
        final int c;
        a(String[] stringArr, Activity activity2, int i3) {
            this.a = stringArr;
            this.b = activity2;
            this.c = i3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int checkPermission;
            int[] iArr = new int[strArr.length];
            i = 0;
            while (i < strArr2.length) {
                iArr[i] = this.b.getPackageManager().checkPermission(this.a[i], this.b.getPackageName());
                i++;
            }
            (a.c)this.b.onRequestPermissionsResult(this.c, this.a, iArr);
        }
    }

    class b implements Runnable {

        final Activity a;
        b(Activity activity) {
            this.a = activity;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean finishing;
            if (!this.a.isFinishing() && !c.i(this.a)) {
                if (!c.i(this.a)) {
                    this.a.recreate();
                }
            }
        }
    }

    public interface c {
        public abstract void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3);
    }

    public interface d {
        public abstract boolean a(Activity activity, String[] string2Arr2, int i3);
    }

    public interface e {
        public abstract void validateRequestPermissionsRequestCode(int i);
    }

    private static class f extends SharedElementCallback {

        private final androidx.core.app.p a;
        f(androidx.core.app.p p) {
            super();
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix2, RectF rectF3) {
            return this.a.a(view, matrix2, rectF3);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable2) {
            return this.a.b(context, parcelable2);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map2) {
            this.a.c(list, map2);
        }

        public void onRejectSharedElements(List<View> list) {
            this.a.d(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.a.e(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.a.f(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener sharedElementCallback$OnSharedElementsReadyListener3) {
            a.f.a aVar = new a.f.a(this, onSharedElementsReadyListener3);
            this.a.g(list, list2, aVar);
        }
    }
    public static void o(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void p(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void q(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void r(Activity activity) {
        int sDK_INT;
        int bVar;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 28) {
            activity.recreate();
        } else {
            if (sDK_INT <= 23) {
                sDK_INT = new Handler(activity.getMainLooper());
                bVar = new a.b(activity);
                sDK_INT.post(bVar);
            } else {
                if (!c.i(activity)) {
                    activity.recreate();
                }
            }
        }
    }

    public static void s(Activity activity, String[] string2Arr2, int i3) {
        androidx.core.app.a.d dVar;
        boolean handler;
        int i;
        int aVar;
        boolean empty;
        dVar = a.d;
        if (dVar != null && dVar.a(activity, string2Arr2, i3)) {
            if (dVar.a(activity, string2Arr2, i3)) {
            }
        }
        i = 0;
        while (i < string2Arr2.length) {
            i++;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof a.e) {
                (a.e)activity.validateRequestPermissionsRequestCode(i3);
            }
            activity.requestPermissions(string2Arr2, i3);
        } else {
            if (activity instanceof a.c) {
                handler = new Handler(Looper.getMainLooper());
                aVar = new a.a(string2Arr2, activity, i3);
                handler.post(aVar);
            }
        }
    }

    public static void t(Activity activity, androidx.core.app.p p2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            if (p2 != null) {
                sDK_INT = new a.f(p2);
            } else {
                sDK_INT = 0;
            }
            activity.setEnterSharedElementCallback(sDK_INT);
        }
    }

    public static void u(Activity activity, androidx.core.app.p p2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            if (p2 != null) {
                sDK_INT = new a.f(p2);
            } else {
                sDK_INT = 0;
            }
            activity.setExitSharedElementCallback(sDK_INT);
        }
    }

    public static boolean v(Activity activity, String string2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(string2);
        }
        return 0;
    }

    public static void w(Activity activity, Intent intent2, int i3, Bundle bundle4) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent2, i3, bundle4);
        } else {
            activity.startActivityForResult(intent2, i3);
        }
    }

    public static void x(Activity activity, IntentSender intentSender2, int i3, Intent intent4, int i5, int i6, int i7, Bundle bundle8) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender2, i3, intent4, i5, i6, i7, bundle8);
        } else {
            activity.startIntentSenderForResult(intentSender2, i3, intent4, i5, i6, i7);
        }
    }

    public static void y(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }
}
