package app.dogo.com.dogo_android.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import androidx.core.content.FileProvider;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import com.google.common.collect.d0;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import com.theartofdev.edmodo.cropper.CropImageView.c;
import com.theartofdev.edmodo.cropper.CropImageView.d;
import com.theartofdev.edmodo.cropper.d;
import com.theartofdev.edmodo.cropper.d.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u0000 @2\u00020\u0001:\u0002@AB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020 2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020 0\"H\u0002J\u0016\u0010#\u001a\u0008\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010'\u001a\u0008\u0012\u0004\u0012\u00020 0\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010)\u001a\u0008\u0012\u0004\u0012\u00020 0\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010*\u001a\u0008\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&H\u0002J \u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0008\u0010.\u001a\u0004\u0018\u00010 J(\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0008\u0010.\u001a\u0004\u0018\u00010 2\u0006\u00100\u001a\u00020&J7\u00101\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0010\u00102\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u0001032\u0008\u00104\u001a\u0004\u0018\u0001052\u0006\u00100\u001a\u00020&¢\u0006\u0002\u00106J\u000e\u00107\u001a\u0002082\u0006\u0010\u0008\u001a\u00020\tJ\u0016\u00109\u001a\u0002082\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010<\u001a\u0002082\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020\u00172\u0006\u00100\u001a\u00020&J\u000e\u0010?\u001a\u0002082\u0006\u00100\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR.\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\u000e\u0010\u000b\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00198F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001e¨\u0006B", d2 = {"Lapp/dogo/com/dogo_android/util/ImageCropper;", "", "()V", "aspectRatioFixed", "", "aspectRatioX", "", "aspectRatioY", "cropShape", "Lapp/dogo/com/dogo_android/util/ImageCropper$CropperShape;", "guideLineVisible", "<set-?>", "isLaunched", "()Z", "Ljava/lang/Exception;", "Lkotlin/Exception;", "lastError", "getLastError", "()Ljava/lang/Exception;", "minimumX", "minimumY", "paddingRatio", "results", "Landroid/net/Uri;", "bundle", "Landroid/os/Bundle;", "settingsBundle", "getSettingsBundle", "()Landroid/os/Bundle;", "setSettingsBundle", "(Landroid/os/Bundle;)V", "createChooserIntentFromIntentList", "Landroid/content/Intent;", "intents", "", "getAllRequiredPermissions", "", "activity", "Landroid/app/Activity;", "getCameraIntents", "getGalleryAndCameraIntent", "getGalleryIntents", "getMissingPermissions", "onActivityResultsForImageCropper", "requestCode", "resultCode", "data", "onActivityResultsForImageSelection", "launcher", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[ILandroid/app/Activity;)Z", "setCropShape", "", "setMinimumCropSize", "shouldAskForPermissions", "shouldShowPermissionsExplanation", "startAnAppropriateImageSourceSelection", "startImageCropperActivity", "uri", "startImageSourceSelection", "Companion", "CropperShape", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q {

    public static final app.dogo.com.dogo_android.util.q.a Companion;
    private boolean a = true;
    private app.dogo.com.dogo_android.util.q.b b;
    private int c = 1;
    private int d = 1;
    private boolean e = true;
    private int f;
    private int g;
    private int h;
    private boolean i;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/util/ImageCropper$Companion;", "", "()V", "CROP_IMAGE_ACTIVITY_REQUEST_CODE", "", "CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE", "PERMISSIONS_REQUEST_CODE", "PICK_IMAGE_CHOOSER_REQUEST_CODE", "PICK_IMAGE_RESULTS_JPEG", "", "getCaptureImageOutputUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "getCaptureImageOutputUriCanhubMethod", "getCaptureImageOutputUriOldMethod", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final Uri a(Context context) {
            String str2;
            String str;
            Uri obj3;
            n.f(context, "context");
            obj3 = b(context);
            return obj3;
        }

        public final Uri b(Context context) {
            String str;
            int externalFilesDir;
            int file;
            String path;
            Uri obj6;
            n.f(context, "context");
            final String str5 = "pickImageResult.jpeg";
            if (Build.VERSION.SDK_INT >= 29) {
                externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                n.d(externalFilesDir);
                file = new File(externalFilesDir.getPath(), str5);
                n.e(FileProvider.e(context, "app.dogo.com.dogo_android.provider", file), "{\n                    FileProvider.getUriForFile(\n                        context,\n                        authority,\n                        File(getImage!!.path, PICK_IMAGE_RESULTS_JPEG)\n                    )\n                }");
            } else {
                obj6 = context.getExternalCacheDir();
                n.d(obj6);
                File file2 = new File(obj6.getPath(), str5);
                n.e(Uri.fromFile(file2), "fromFile(File(getImage!!.path, PICK_IMAGE_RESULTS_JPEG))");
            }
            return obj6;
        }

        public final Uri c(Context context) {
            n.f(context, "context");
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            if (externalFilesDir == null) {
            } else {
                externalFilesDir.mkdirs();
            }
            File file2 = new File(externalFilesDir, "pickImageResult.jpeg");
            File file = new File(file2.getPath());
            return i1.b(context, file);
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u0000 \r2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008j\u0002\u0008\u000bj\u0002\u0008\u000c¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/util/ImageCropper$CropperShape;", "", "shapeNumber", "", "(Ljava/lang/String;II)V", "getShapeNumber", "()I", "setShapeNumber", "(I)V", "convertToCrop", "Lcom/theartofdev/edmodo/cropper/CropImageView$CropShape;", "OVAL", "RECTANGLE", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum b {

        OVAL(false),
        RECTANGLE(false);

        private int shapeNumber;
        private static final app.dogo.com.dogo_android.util.q.b[] $values() {
            app.dogo.com.dogo_android.util.q.b[] arr = new q.b[2];
            return arr;
        }

        @Override // java.lang.Enum
        public final CropImageView.c convertToCrop() {
            CropImageView.c rECTANGLE;
            int i;
            int i2 = q.b.b.a[ordinal()];
            if (i2 != 1) {
                rECTANGLE = i2 != 2 ? CropImageView.c.RECTANGLE : CropImageView.c.RECTANGLE;
            } else {
                rECTANGLE = CropImageView.c.OVAL;
            }
            return rECTANGLE;
        }

        @Override // java.lang.Enum
        public final int getShapeNumber() {
            return this.shapeNumber;
        }

        @Override // java.lang.Enum
        public final void setShapeNumber(int i) {
            this.shapeNumber = i;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final Activity $launcher;
        final app.dogo.com.dogo_android.util.q this$0;
        c(app.dogo.com.dogo_android.util.q q, Activity activity2) {
            this.this$0 = q;
            this.$launcher = activity2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            q.c(this.this$0, this.$launcher);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final app.dogo.com.dogo_android.util.q this$0;
        d(app.dogo.com.dogo_android.util.q q) {
            this.this$0 = q;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            q.b(this.this$0, false);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<w> {

        final Activity $launcher;
        final app.dogo.com.dogo_android.util.q this$0;
        e(Activity activity, app.dogo.com.dogo_android.util.q q2) {
            this.$launcher = activity;
            this.this$0 = q2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            App.Companion.l().W0(true);
            Activity $launcher = this.$launcher;
            Object[] array = q.a(this.this$0, $launcher).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            $launcher.requestPermissions((String[])array, 2011);
        }
    }
    static {
        q.a aVar = new q.a(0);
        q.Companion = aVar;
    }

    public q() {
        super();
        final int i = 1;
        this.b = q.b.RECTANGLE;
    }

    public static final List a(app.dogo.com.dogo_android.util.q q, Activity activity2) {
        return q.e(activity2);
    }

    public static final void b(app.dogo.com.dogo_android.util.q q, boolean z2) {
        q.i = z2;
    }

    public static final void c(app.dogo.com.dogo_android.util.q q, Activity activity2) {
        q.t(activity2);
    }

    private final Intent d(List<? extends Intent> list) {
        int i;
        Object obj3;
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.isEmpty()) {
            obj3 = new Intent();
        } else {
            obj3 = arrayList.get(obj3--);
            arrayList.remove(size--);
        }
        obj3 = Intent.createChooser(obj3, "");
        Object[] array = arrayList.toArray(new Parcelable[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        obj3.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])array);
        n.e(obj3, "chooserIntent");
        return obj3;
    }

    private final List<String> e(Activity activity) {
        ArrayList obj2 = d0.j(/* result */);
        n.e(obj2, "newArrayList(Manifest.permission.CAMERA)");
        return obj2;
    }

    private final List<Intent> f(Activity activity) {
        String str;
        Intent intent;
        ComponentName componentName;
        String name;
        String packageName;
        ArrayList arrayList = new ArrayList();
        Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        List obj9 = activity.getPackageManager().queryIntentActivities(intent2, 0);
        n.e(obj9, "activity.packageManager.queryIntentActivities(captureIntent, 0)");
        obj9 = obj9.iterator();
        for (ResolveInfo next2 : obj9) {
            intent = new Intent(intent2);
            android.content.pm.ActivityInfo activityInfo2 = next2.activityInfo;
            componentName = new ComponentName(activityInfo2.packageName, activityInfo2.name);
            intent.setComponent(componentName);
            intent.setPackage(activityInfo.packageName);
            intent.putExtra("output", q.Companion.a(activity));
            arrayList.add(intent);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(intent2);
        }
        return arrayList;
    }

    private final Intent g(Activity activity) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f(activity));
        arrayList.addAll(h(activity));
        return d(arrayList);
    }

    private final List<Intent> h(Activity activity) {
        List list;
        PackageManager obj4;
        final int i = 0;
        if (d.e(activity.getPackageManager(), "android.intent.action.PICK", i).size() == 0) {
            list = d.e(activity.getPackageManager(), "android.intent.action.GET_CONTENT", i);
        }
        n.e(list, "galleryIntents");
        return list;
    }

    private final List<String> i(Activity activity) {
        return g1.k(activity, e(activity));
    }

    private final boolean r(Activity activity) {
        int size2;
        boolean size;
        int i;
        int obj4;
        size2 = i(activity);
        i = 1;
        if (!App.Companion.l().E() && size2.size() != 0) {
            if (size2.size() != 0) {
            } else {
                if (size2.size() == e(activity).size()) {
                } else {
                    i = 0;
                }
            }
        } else {
        }
        return i;
    }

    private final boolean s(Activity activity) {
        List obj2;
        if (!App.Companion.l().E() && i(activity).size() != 0) {
            obj2 = obj2.size() != 0 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private final void t(Activity activity) {
        Intent intent;
        ArrayList list3 = d0.j(/* result */);
        n.e(list3, "newArrayList(Manifest.permission.CAMERA)");
        int i = 200;
        if (i(activity).containsAll(list3)) {
            activity.startActivityForResult(d(h(activity)), i);
        } else {
            activity.startActivityForResult(g(activity), i);
        }
    }

    public final Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putInt("aspectRatioX", this.c);
        bundle.putInt("aspectRatioY", this.d);
        bundle.putBoolean("aspectRatioFixed", this.e);
        bundle.putInt("paddingRatio", this.f);
        bundle.putInt("minimumX", this.g);
        bundle.putInt("minimumY", this.h);
        bundle.putBoolean("guideLineVisible", this.a);
        bundle.putInt("cropShape", this.b.getShapeNumber());
        return bundle;
    }

    public final boolean k() {
        return this.i;
    }

    public final boolean l(int i, int i2, Intent intent3) {
        int obj3;
        final int i3 = 0;
        if (i == 203) {
            this.i = i3;
            if (i2 != -1) {
                if (i2 != 204) {
                } else {
                    d.b(intent3).c();
                }
            } else {
                d.b(intent3).g();
            }
            return 1;
        }
        return i3;
    }

    public final boolean m(int i, int i2, Intent intent3, Activity activity4) {
        int str;
        int i3;
        int i4;
        int obj5;
        Object obj6;
        n.f(activity4, "launcher");
        str = 200;
        i3 = 0;
        if (i == str && i2 == -1) {
            if (i2 == -1) {
                final int obj4 = 1;
                if (intent3 != null && intent3.getData() != null) {
                    if (intent3.getData() != null) {
                        obj5 = intent3.getAction();
                        if (obj5 != null && n.b(obj5, "android.media.action.IMAGE_CAPTURE")) {
                            if (n.b(obj5, "android.media.action.IMAGE_CAPTURE")) {
                                i3 = obj4;
                            }
                        }
                    } else {
                    }
                } else {
                }
                if (i3 == 0) {
                    n.d(intent3);
                    if (intent3.getData() == null) {
                        obj5 = q.Companion.a(activity4);
                    } else {
                        obj5 = intent3.getData();
                        n.d(obj5);
                        n.e(obj5, "data.data!!");
                    }
                } else {
                }
                u(obj5, activity4);
                return obj4;
            }
        }
        if (i == str) {
            this.i = i3;
        }
        return i3;
    }

    public final boolean n(int i, String[] string2Arr2, int[] i3Arr3, Activity activity4) {
        int obj1;
        int obj2;
        app.dogo.com.dogo_android.util.q.d obj3;
        n.f(activity4, "launcher");
        if (i == 2011) {
            if (!r(activity4)) {
                obj2 = new q.c(this, activity4);
                obj3 = new q.d(this);
                f1.j0(activity4, i(activity4), obj2, obj3);
            } else {
                t(activity4);
            }
        }
        return 0;
    }

    public final void o(app.dogo.com.dogo_android.util.q.b q$b) {
        n.f(b, "cropShape");
        this.b = b;
    }

    public final void p(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    public final void q(Bundle bundle) {
        app.dogo.com.dogo_android.util.q.b.a companion;
        int shapeNumber;
        String str;
        app.dogo.com.dogo_android.util.q.b obj4;
        if (bundle != null) {
            this.c = bundle.getInt("aspectRatioX", this.c);
            this.d = bundle.getInt("aspectRatioY", this.d);
            this.e = bundle.getBoolean("aspectRatioFixed", this.e);
            this.f = bundle.getInt("paddingRatio", this.f);
            this.g = bundle.getInt("minimumX", this.g);
            this.h = bundle.getInt("minimumY", this.h);
            this.a = bundle.getBoolean("guideLineVisible", this.a);
            this.b = q.b.Companion.a(bundle.getInt("cropShape", this.b.getShapeNumber()));
        }
    }

    public final void u(Uri uri, Activity activity2) {
        CropImageView.d oFF;
        n.f(uri, "uri");
        n.f(activity2, "launcher");
        d.b obj3 = d.a(uri);
        obj3.d(this.b.convertToCrop());
        obj3.c(this.c, this.d);
        obj3.e(this.e);
        oFF = this.a ? CropImageView.d.ON : CropImageView.d.OFF;
        obj3.f(oFF);
        obj3.g((float)i2);
        obj3.h(this.g, this.h);
        obj3.i(activity2);
        this.i = true;
    }

    public final void v(Activity activity) {
        Object[] array;
        int eVar;
        n.f(activity, "launcher");
        this.i = true;
        if (s(activity)) {
            eVar = new q.e(activity, this);
            f1.p0(activity, i(activity), eVar);
        } else {
            if (r(activity)) {
                array = e(activity).toArray(new String[0]);
                if (array == null) {
                } else {
                    activity.requestPermissions((String[])array, 2011);
                }
                NullPointerException obj4 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                throw obj4;
            }
            t(activity);
        }
        try {
            this.i = obj1;
            throw activity;
        }
    }
}
