package app.dogo.com.dogo_android.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: ImageCropper.kt */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0018\u0000 @2\u00020\u0001:\u0002@AB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020 2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020 0\"H\u0002J\u0016\u0010#\u001a\u0008\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010'\u001a\u0008\u0012\u0004\u0012\u00020 0\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010)\u001a\u0008\u0012\u0004\u0012\u00020 0\"2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010*\u001a\u0008\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&H\u0002J \u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0008\u0010.\u001a\u0004\u0018\u00010 J(\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0008\u0010.\u001a\u0004\u0018\u00010 2\u0006\u00100\u001a\u00020&J7\u00101\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00062\u0010\u00102\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u0001032\u0008\u00104\u001a\u0004\u0018\u0001052\u0006\u00100\u001a\u00020&¢\u0006\u0002\u00106J\u000e\u00107\u001a\u0002082\u0006\u0010\u0008\u001a\u00020\tJ\u0016\u00109\u001a\u0002082\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010<\u001a\u0002082\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020\u00172\u0006\u00100\u001a\u00020&J\u000e\u0010?\u001a\u0002082\u0006\u00100\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR.\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\u000e\u0010\u000b\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00198F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001e¨\u0006B", d2 = {"Lapp/dogo/com/dogo_android/util/ImageCropper;", "", "()V", "aspectRatioFixed", "", "aspectRatioX", "", "aspectRatioY", "cropShape", "Lapp/dogo/com/dogo_android/util/ImageCropper$CropperShape;", "guideLineVisible", "<set-?>", "isLaunched", "()Z", "Ljava/lang/Exception;", "Lkotlin/Exception;", "lastError", "getLastError", "()Ljava/lang/Exception;", "minimumX", "minimumY", "paddingRatio", "results", "Landroid/net/Uri;", "bundle", "Landroid/os/Bundle;", "settingsBundle", "getSettingsBundle", "()Landroid/os/Bundle;", "setSettingsBundle", "(Landroid/os/Bundle;)V", "createChooserIntentFromIntentList", "Landroid/content/Intent;", "intents", "", "getAllRequiredPermissions", "", "activity", "Landroid/app/Activity;", "getCameraIntents", "getGalleryAndCameraIntent", "getGalleryIntents", "getMissingPermissions", "onActivityResultsForImageCropper", "requestCode", "resultCode", "data", "onActivityResultsForImageSelection", "launcher", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[ILandroid/app/Activity;)Z", "setCropShape", "", "setMinimumCropSize", "shouldAskForPermissions", "shouldShowPermissionsExplanation", "startAnAppropriateImageSourceSelection", "startImageCropperActivity", "uri", "startImageSourceSelection", "Companion", "CropperShape", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q, reason: from kotlin metadata */
public final class ImageCropper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final q.a INSTANCE = new q$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private boolean aspectRatioFixed = true;
    /* renamed from: b, reason: from kotlin metadata */
    private q.b aspectRatioX;
    /* renamed from: c, reason: from kotlin metadata */
    private int aspectRatioY = 1;
    /* renamed from: d, reason: from kotlin metadata */
    private int cropShape = 1;
    /* renamed from: e, reason: from kotlin metadata */
    private boolean guideLineVisible = true;
    private int f;
    private int g;
    /* renamed from: h, reason: from kotlin metadata */
    private int minimumX;
    /* renamed from: i, reason: from kotlin metadata */
    private boolean minimumY;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/util/ImageCropper$Companion;", "", "()V", "CROP_IMAGE_ACTIVITY_REQUEST_CODE", "", "CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE", "PERMISSIONS_REQUEST_CODE", "PICK_IMAGE_CHOOSER_REQUEST_CODE", "PICK_IMAGE_RESULTS_JPEG", "", "getCaptureImageOutputUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "getCaptureImageOutputUriCanhubMethod", "getCaptureImageOutputUriOldMethod", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final Uri getCaptureImageOutputUri(Context context) {
            Uri captureImageOutputUriCanhubMethod;
            str = "context";
            n.f(context, str);
            try {
                captureImageOutputUriCanhubMethod = getCaptureImageOutputUriCanhubMethod(context);
            } catch (Exception unused) {
                int arr = 0;
                arr = new Object[arr];
                a.c("Canhub CaptureImageOutput failed, trying the original fix", arr);
                context = getCaptureImageOutputUriOldMethod(context);
            }
            return captureImageOutputUriCanhubMethod;
        }

        /* renamed from: b, reason: from kotlin metadata */
        public final Uri getCaptureImageOutputUriCanhubMethod(Context context) throws java.io.IOException {
            Uri file;
            n.f(context, "context");
            final String str5 = "pickImageResult.jpeg";
            int i = 29;
            if (Build.VERSION.SDK_INT >= 29) {
                File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                try {
                    n.d(externalFilesDir);
                    str = "{\n                    FileProvider.getUriForFile(\n                        context,\n                        authority,\n                        File(getImage!!.path, PICK_IMAGE_RESULTS_JPEG)\n                    )\n                }";
                    n.e(FileProvider.e(context, "app.dogo.com.dogo_android.provider", new File(externalFilesDir.getPath(), str5)), str);
                } catch (Exception unused) {
                    n.d(obj);
                    String str2 = obj.getPath();
                    context = new File(str2, r2);
                    context = Uri.fromFile(context);
                    str2 = "{\n                    Uri.fromFile(File(getImage!!.path, PICK_IMAGE_RESULTS_JPEG))\n                }";
                    n.e(context, str2);
                }
            } else {
                File externalCacheDir = context.getExternalCacheDir();
                n.d(externalCacheDir);
                str = "fromFile(File(getImage!!.path, PICK_IMAGE_RESULTS_JPEG))";
                n.e(Uri.fromFile(new File(externalCacheDir.getPath(), str5)), str);
            }
            return file;
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final Uri getCaptureImageOutputUriOldMethod(Context context) throws java.io.IOException {
            n.f(context, "context");
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            if (externalFilesDir != null) {
                externalFilesDir.mkdirs();
            }
            return app.dogo.com.dogo_android.util.extensionfunction.i1.b(context, new File(new File(externalFilesDir, "pickImageResult.jpeg").getPath()));
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u0000 \r2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008j\u0002\u0008\u000bj\u0002\u0008\u000c¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/util/ImageCropper$CropperShape;", "", "shapeNumber", "", "(Ljava/lang/String;II)V", "getShapeNumber", "()I", "setShapeNumber", "(I)V", "convertToCrop", "Lcom/theartofdev/edmodo/cropper/CropImageView$CropShape;", "OVAL", "RECTANGLE", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum b {

        OVAL,
        RECTANGLE;

        private int shapeNumber;
        @Override // java.lang.Enum
        public final CropImageView.c convertToCrop() {
            CropImageView.c rECTANGLE2;
            int i2 = q.b.b.a[ordinal()];
            int i = 1;
            if (q.b.b.a != 1) {
                i = 2;
                CropImageView.c r0 = CropImageView.c.RECTANGLE;
            } else {
                r0 = CropImageView.c.OVAL;
            }
            return CropImageView.c.RECTANGLE;
        }

        @Override // java.lang.Enum
        public final int getShapeNumber() {
            return this.shapeNumber;
        }

        @Override // java.lang.Enum
        public final void setShapeNumber(int i) {
            this.shapeNumber = i;
        }

        private static final /* synthetic */ q.b[] $values() {
            app.dogo.com.dogo_android.util.q.b[] arr = new q.b[2];
            return new q.b[] { ImageCropper_CropperShape.OVAL, ImageCropper_CropperShape.RECTANGLE };
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {

        final /* synthetic */ Activity $launcher;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            q.this.shouldShowPermissionsExplanation(this.$launcher);
        }

        c(Activity activity) {
            this.$launcher = activity;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            q.this.minimumY = 0;
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<w> {

        final /* synthetic */ Activity $launcher;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            App.INSTANCE.l().W0(true);
            Object[] array = q.this.getAllRequiredPermissions(this.$launcher).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            this.$launcher.requestPermissions(array, 2011);
        }

        e(Activity activity, q qVar) {
            this.$launcher = activity;
            super(0);
        }
    }
    public q() {
        super();
        this.aspectRatioX = ImageCropper_CropperShape.RECTANGLE;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ List setMinimumCropSize(q minimumX, Activity minimumY) {
        return minimumX.getAllRequiredPermissions(minimumY);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final /* synthetic */ void startImageCropperActivity(q uri, boolean launcher) {
        uri.minimumY = launcher;
    }

    public static final /* synthetic */ void c(q qVar, Activity activity) {
        qVar.shouldShowPermissionsExplanation(activity);
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final Intent createChooserIntentFromIntentList(List<? extends Intent> intents) {
        Intent intent;
        ArrayList arrayList = new ArrayList(intents);
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            Object item = arrayList.get(arrayList.size() - 1);
            i = arrayList.size() - 1;
            arrayList.remove(i);
        }
        Intent chooser = Intent.createChooser(intent, "");
        Object[] array = arrayList.toArray(new Parcelable[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        chooser.putExtra("android.intent.extra.INITIAL_INTENTS", array);
        n.e(chooser, "chooserIntent");
        return chooser;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final List<String> getAllRequiredPermissions(Activity activity) {
        ArrayList list = d0.j(new String[] { "android.permission.CAMERA" });
        n.e(list, "newArrayList(Manifest.permission.CAMERA)");
        return list;
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final List<Intent> getCameraIntents(Activity activity) {
        final ArrayList arrayList = new ArrayList();
        final Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        List intentActivities = activity.getPackageManager().queryIntentActivities(intent2, 0);
        str = "activity.packageManager.queryIntentActivities(captureIntent, 0)";
        n.e(intentActivities, str);
        Iterator it = intentActivities.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Intent intent = new Intent(intent2);
            intent.setComponent(new ComponentName(activityInfo22.packageName, activityInfo22.name));
            intent.setPackage(item.activityInfo.packageName);
            str = "output";
            intent.putExtra(str, ImageCropper.INSTANCE.getCaptureImageOutputUri(activity));
            arrayList.add(intent);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(intent2);
        }
        return arrayList;
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final Intent getGalleryAndCameraIntent(Activity activity) {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(getCameraIntents(activity));
        arrayList.addAll(getGalleryIntents(activity));
        return createChooserIntentFromIntentList(arrayList);
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final List<Intent> getGalleryIntents(Activity activity) {
        List list;
        final boolean z = false;
        if (d.e(activity.getPackageManager(), "android.intent.action.PICK", z).size() == 0) {
            list = d.e(activity.getPackageManager(), "android.intent.action.GET_CONTENT", z);
        }
        n.e(list, "galleryIntents");
        return list;
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final List<String> getMissingPermissions(Activity activity) {
        return app.dogo.com.dogo_android.util.extensionfunction.g1.k(activity, getAllRequiredPermissions(activity));
    }

    /* renamed from: r, reason: from kotlin metadata */
    private final boolean setCropShape(Activity cropShape) {
        boolean z;
        boolean z2 = false;
        List missingPermissions = getMissingPermissions(cropShape);
        int i = 1;
        if (App.INSTANCE.l().E() || missingPermissions.size() == 0) {
            if (missingPermissions.size() != getAllRequiredPermissions(cropShape).size()) {
                int i2 = 0;
            }
        }
        return z2;
    }

    /* renamed from: s, reason: from kotlin metadata */
    private final boolean shouldAskForPermissions(Activity activity) {
        boolean z2 = false;
        activity = !App.INSTANCE.l().E() && getMissingPermissions(activity).size() != 0 ? 1 : 0;
        return (!App.INSTANCE.l().E() && getMissingPermissions(activity).size() != 0 ? 1 : 0);
    }

    /* renamed from: t, reason: from kotlin metadata */
    private final void shouldShowPermissionsExplanation(Activity activity) throws android.content.ActivityNotFoundException {
        ArrayList list = d0.j(new String[] { "android.permission.CAMERA" });
        n.e(list, "newArrayList(Manifest.permission.CAMERA)");
        int i = 200;
        if (getMissingPermissions(activity).containsAll(list)) {
            activity.startActivityForResult(createChooserIntentFromIntentList(getGalleryIntents(activity)), i);
        } else {
            activity.startActivityForResult(getGalleryAndCameraIntent(activity), i);
        }
    }

    public final Bundle j() {
        final Bundle bundle = new Bundle();
        bundle.putInt("aspectRatioX", this.aspectRatioY);
        bundle.putInt("aspectRatioY", this.cropShape);
        bundle.putBoolean("aspectRatioFixed", this.guideLineVisible);
        bundle.putInt("paddingRatio", this.f);
        bundle.putInt("minimumX", this.g);
        bundle.putInt("minimumY", this.minimumX);
        bundle.putBoolean("guideLineVisible", this.aspectRatioFixed);
        bundle.putInt("cropShape", this.aspectRatioX.getShapeNumber());
        return bundle;
    }

    public final boolean k() {
        return this.minimumY;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public final boolean onActivityResultsForImageCropper(int requestCode, int resultCode, Intent data) {
        final boolean z = false;
        if (requestCode == 203) {
            this.minimumY = z;
            if (resultCode == -1) {
                d.b(data).g();
            } else {
                int i = 204;
                if (resultCode == 204) {
                    d.b(data).c();
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: m, reason: from kotlin metadata */
    public final boolean onActivityResultsForImageSelection(int requestCode, int resultCode, Intent data, Activity launcher) {
        int i = 200;
        int requestCode2 = 0;
        Uri data2;
        String action;
        Uri captureImageOutputUri;
        n.f(launcher, "launcher");
        i = 200;
        requestCode2 = 0;
        if (requestCode == i && resultCode == -1) {
            requestCode2 = 1;
            if (data == null || !(data.getData() == null && action == null)) {
            }
            if (requestCode2 == 0) {
                n.d(data);
                if (data.getData() == null) {
                    captureImageOutputUri = ImageCropper.INSTANCE.getCaptureImageOutputUri(launcher);
                } else {
                    captureImageOutputUri = data.getData();
                    n.d(captureImageOutputUri);
                    str = "data.data!!";
                    n.e(captureImageOutputUri, str);
                }
            }
            u(captureImageOutputUri, launcher);
            return true;
        }
        if (requestCode == i) {
            this.minimumY = false;
        }
        return false;
    }

    /* renamed from: n, reason: from kotlin metadata */
    public final boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults, Activity launcher) {
        n.f(launcher, "launcher");
        int i = 2011;
        if (requestCode == 2011 && !this.setCropShape(launcher)) {
            app.dogo.com.dogo_android.util.extensionfunction.f1.j0(launcher, getMissingPermissions(launcher), new q.c(this, launcher), new q.d(this));
        }
        return false;
    }

    /* renamed from: o, reason: from kotlin metadata */
    public final void startAnAppropriateImageSourceSelection(q.b activity) {
        n.f(activity, "cropShape");
        this.aspectRatioX = activity;
    }

    public final void p(int i, int i2) {
        this.g = i;
        this.minimumX = i2;
    }

    /* renamed from: q, reason: from kotlin metadata */
    public final void startImageSourceSelection(Bundle launcher) {
        if (launcher != null) {
            this.aspectRatioY = launcher.getInt("aspectRatioX", this.aspectRatioY);
            this.cropShape = launcher.getInt("aspectRatioY", this.cropShape);
            this.guideLineVisible = launcher.getBoolean("aspectRatioFixed", this.guideLineVisible);
            this.f = launcher.getInt("paddingRatio", this.f);
            this.g = launcher.getInt("minimumX", this.g);
            this.minimumX = launcher.getInt("minimumY", this.minimumX);
            this.aspectRatioFixed = launcher.getBoolean("guideLineVisible", this.aspectRatioFixed);
            str = "cropShape";
            this.aspectRatioX = ImageCropper_CropperShape.INSTANCE.a(launcher.getInt(str, this.aspectRatioX.getShapeNumber()));
        }
    }

    public final void u(Uri uri, Activity activity) {
        CropImageView.d oN2;
        n.f(uri, "uri");
        n.f(activity, "launcher");
        d.b bVar = d.a(uri);
        bVar.d(this.aspectRatioX.convertToCrop());
        bVar.c(this.aspectRatioY, this.cropShape);
        bVar.e(this.guideLineVisible);
        CropImageView.d r0 = this.aspectRatioFixed ? CropImageView.d.ON : CropImageView.d.OFF;
        bVar.f((this.aspectRatioFixed ? CropImageView.d.ON : CropImageView.d.OFF));
        bVar.g((this.aspectRatioFixed ? CropImageView.d.ON : CropImageView.d.OFF));
        bVar.h((this.aspectRatioFixed ? CropImageView.d.ON : CropImageView.d.OFF), this.minimumX);
        bVar.i(activity);
        this.minimumY = true;
    }

    public final void v(Activity activity) {
        n.f(activity, "launcher");
        try {
            this.minimumY = true;
            if (!shouldAskForPermissions(activity)) {
                if (setCropShape(activity)) {
                    Object[] array = getAllRequiredPermissions(activity).toArray(new String[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } else {
                        int i = 2011;
                        activity.requestPermissions(array, i);
                    }
                }
                shouldShowPermissionsExplanation(activity);
            } else {
                app.dogo.com.dogo_android.util.extensionfunction.f1.p0(activity, getMissingPermissions(activity), new q.e(activity, this));
            }
        } catch (Exception e) {
            this.minimumY = z;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) e;
        }
    }

}
