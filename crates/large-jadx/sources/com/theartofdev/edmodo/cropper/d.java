package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Images.Media;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class d {

    static class a {
    }

    public static final class b {

        private final Uri a;
        private final com.theartofdev.edmodo.cropper.f b;
        private b(Uri uri) {
            super();
            this.a = uri;
            f obj1 = new f();
            this.b = obj1;
        }

        b(Uri uri, com.theartofdev.edmodo.cropper.d.a d$a2) {
            super(uri);
        }

        public Intent a(Context context) {
            return b(context, CropImageActivity.class);
        }

        public Intent b(Context context, Class<?> class2) {
            this.b.a();
            Intent intent = new Intent();
            intent.setClass(context, class2);
            Bundle obj3 = new Bundle();
            obj3.putParcelable("CROP_IMAGE_EXTRA_SOURCE", this.a);
            obj3.putParcelable("CROP_IMAGE_EXTRA_OPTIONS", this.b);
            intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", obj3);
            return intent;
        }

        public com.theartofdev.edmodo.cropper.d.b c(int i, int i2) {
            final com.theartofdev.edmodo.cropper.f fVar = this.b;
            fVar.E = i;
            fVar.F = i2;
            fVar.D = true;
            return this;
        }

        public com.theartofdev.edmodo.cropper.d.b d(com.theartofdev.edmodo.cropper.CropImageView.c cropImageView$c) {
            fVar.a = c;
            return this;
        }

        public com.theartofdev.edmodo.cropper.d.b e(boolean z) {
            fVar.D = z;
            return this;
        }

        public com.theartofdev.edmodo.cropper.d.b f(com.theartofdev.edmodo.cropper.CropImageView.d cropImageView$d) {
            fVar.v = d;
            return this;
        }

        public com.theartofdev.edmodo.cropper.d.b g(float f) {
            fVar.C = f;
            return this;
        }

        public com.theartofdev.edmodo.cropper.d.b h(int i, int i2) {
            final com.theartofdev.edmodo.cropper.f fVar = this.b;
            fVar.R = i;
            fVar.S = i2;
            return this;
        }

        public void i(Activity activity) {
            this.b.a();
            activity.startActivityForResult(a(activity), 203);
        }
    }

    public static final class c extends com.theartofdev.edmodo.cropper.CropImageView.b implements Parcelable {

        public static final Parcelable.Creator<com.theartofdev.edmodo.cropper.d.c> CREATOR;
        static {
            d.c.a aVar = new d.c.a();
            d.c.CREATOR = aVar;
        }

        public c(Uri uri, Uri uri2, Exception exception3, float[] f4Arr4, Rect rect5, int i6, Rect rect7, int i8) {
            super(0, uri, 0, uri2, exception3, f4Arr4, rect5, rect7, i6, i8);
        }

        protected c(Parcel parcel) {
            super(0, (Uri)parcel.readParcelable(Uri.class.getClassLoader()), 0, (Uri)parcel.readParcelable(Uri.class.getClassLoader()), (Exception)parcel.readSerializable(), parcel.createFloatArray(), (Rect)parcel.readParcelable(Rect.class.getClassLoader()), (Rect)parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        @Override // com.theartofdev.edmodo.cropper.CropImageView$b
        public int describeContents() {
            return 0;
        }

        @Override // com.theartofdev.edmodo.cropper.CropImageView$b
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(d(), i2);
            parcel.writeParcelable(g(), i2);
            parcel.writeSerializable(c());
            parcel.writeFloatArray(a());
            parcel.writeParcelable(b(), i2);
            parcel.writeParcelable(h(), i2);
            parcel.writeInt(e());
            parcel.writeInt(f());
        }
    }
    public static com.theartofdev.edmodo.cropper.d.b a(Uri uri) {
        d.b bVar = new d.b(uri, 0);
        return bVar;
    }

    public static com.theartofdev.edmodo.cropper.d.c b(Intent intent) {
        String str;
        Parcelable obj1;
        if (intent != null) {
            obj1 = intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT");
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static List<Intent> c(Context context, PackageManager packageManager2) {
        int packageName;
        Intent intent;
        ComponentName componentName;
        String name;
        String packageName2;
        ArrayList arrayList = new ArrayList();
        final Uri obj7 = d.d(context);
        Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        Iterator obj8 = packageManager2.queryIntentActivities(intent2, 0).iterator();
        while (obj8.hasNext()) {
            Object next2 = obj8.next();
            intent = new Intent(intent2);
            android.content.pm.ActivityInfo activityInfo2 = next2.activityInfo;
            componentName = new ComponentName(activityInfo2.packageName, activityInfo2.name);
            intent.setComponent(componentName);
            intent.setPackage(activityInfo.packageName);
            if (obj7 != null) {
            }
            arrayList.add(intent);
            intent.putExtra("output", obj7);
        }
        return arrayList;
    }

    public static Uri d(Context context) {
        File file;
        String str;
        Uri obj2;
        obj2 = context.getExternalCacheDir();
        if (obj2 != null) {
            file = new File(obj2.getPath(), "pickImageResult.jpeg");
            obj2 = Uri.fromFile(file);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public static List<Intent> e(PackageManager packageManager, String string2, boolean z3) {
        Intent intent;
        Uri eXTERNAL_CONTENT_URI;
        ComponentName componentName;
        String name;
        String packageName;
        Iterator obj6;
        int obj7;
        boolean obj8;
        ArrayList arrayList = new ArrayList();
        if (string2 == "android.intent.action.GET_CONTENT") {
            intent = new Intent(string2);
        } else {
            intent = new Intent(string2, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        intent.setType("image/*");
        obj6 = packageManager.queryIntentActivities(intent, 0).iterator();
        for (ResolveInfo obj7 : obj6) {
            eXTERNAL_CONTENT_URI = new Intent(intent);
            android.content.pm.ActivityInfo activityInfo = obj7.activityInfo;
            componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            eXTERNAL_CONTENT_URI.setComponent(componentName);
            eXTERNAL_CONTENT_URI.setPackage(obj7.packageName);
            arrayList.add(eXTERNAL_CONTENT_URI);
        }
        if (!z3) {
            obj6 = arrayList.iterator();
            while (obj6.hasNext()) {
                obj7 = obj6.next();
                if ((Intent)obj7.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                    break;
                } else {
                }
            }
        }
        return arrayList;
    }

    public static Intent f(Context context) {
        return d.g(context, context.getString(l.c), false, true);
    }

    public static Intent g(Context context, java.lang.CharSequence charSequence2, boolean z3, boolean z4) {
        Object obj3;
        int obj5;
        ArrayList arrayList = new ArrayList();
        final PackageManager packageManager = context.getPackageManager();
        if (!d.j(context) && z4) {
            if (z4) {
                arrayList.addAll(d.c(context, packageManager));
            }
        }
        if (d.e(packageManager, "android.intent.action.GET_CONTENT", z3).size() == 0) {
            obj3 = d.e(packageManager, "android.intent.action.PICK", z3);
        }
        arrayList.addAll(obj3);
        if (arrayList.isEmpty()) {
            obj3 = new Intent();
        } else {
            obj3 = arrayList.get(obj3--);
            arrayList.remove(obj5--);
        }
        obj3 = Intent.createChooser(obj3, charSequence2);
        obj3.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])arrayList.toArray(new Parcelable[arrayList.size()]));
        return obj3;
    }

    public static Uri h(Context context, Intent intent2) {
        int data;
        Uri action;
        String str;
        Uri obj3;
        data = 1;
        if (intent2 != null && intent2.getData() != null) {
            if (intent2.getData() != null) {
                action = intent2.getAction();
                if (action != null && action.equals("android.media.action.IMAGE_CAPTURE")) {
                    if (action.equals("android.media.action.IMAGE_CAPTURE")) {
                    } else {
                        data = 0;
                    }
                } else {
                }
            }
        }
        if (data == null) {
            if (intent2.getData() == null) {
                obj3 = d.d(context);
            } else {
                obj3 = intent2.getData();
            }
        } else {
        }
        return obj3;
    }

    public static boolean i(Context context, String string2) {
        String packageName;
        int i;
        boolean equalsIgnoreCase;
        final int i2 = 0;
        String[] obj4 = obj4.requestedPermissions;
        if (obj4 != null && obj4.length > 0) {
            if (obj4.length > 0) {
                i = i2;
                while (i < obj4.length) {
                    i++;
                }
            }
        }
        return i2;
    }

    public static boolean j(Context context) {
        String sDK_INT;
        boolean i;
        int obj2;
        sDK_INT = "android.permission.CAMERA";
        if (Build.VERSION.SDK_INT >= 23 && d.i(context, sDK_INT) && context.checkSelfPermission(sDK_INT) != 0) {
            sDK_INT = "android.permission.CAMERA";
            if (d.i(context, sDK_INT)) {
                obj2 = context.checkSelfPermission(sDK_INT) != 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public static boolean k(Context context, Uri uri2) {
        int checkSelfPermission;
        int obj2;
        if (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != null && d.l(context, uri2)) {
            if (context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != null) {
                obj2 = d.l(context, uri2) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public static boolean l(Context context, Uri uri2) {
        try {
            InputStream obj0 = context.getContentResolver().openInputStream(uri2);
            if (obj0 != null) {
            }
            obj0.close();
            return 0;
            context = 1;
            return context;
        }
    }

    public static void m(Activity activity) {
        activity.startActivityForResult(d.f(activity), 200);
    }
}
