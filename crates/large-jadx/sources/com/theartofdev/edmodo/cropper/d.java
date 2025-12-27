package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
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

/* compiled from: CropImage.java */
/* loaded from: classes2.dex */
public final class d {

    static class a {
    }

    public static final class b {

        private final Uri a;
        private final f b;
        /* synthetic */ b(Uri uri, d.a aVar) {
            this(uri);
        }

        public Intent a(Context context) {
            return b(context, CropImageActivity.class);
        }

        public Intent b(Context context, Class<?> cls) {
            this.b.a();
            Intent intent = new Intent();
            intent.setClass(context, cls);
            final Bundle bundle = new Bundle();
            bundle.putParcelable("CROP_IMAGE_EXTRA_SOURCE", this.a);
            bundle.putParcelable("CROP_IMAGE_EXTRA_OPTIONS", this.b);
            intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", bundle);
            return intent;
        }

        public d.b c(int i, int i2) {
            this.b.E = i;
            this.b.F = i2;
            this.b.D = true;
            return this;
        }

        public d.b d(CropImageView.c cVar) {
            this.b.a = cVar;
            return this;
        }

        public d.b e(boolean z) {
            this.b.D = z;
            return this;
        }

        public d.b f(CropImageView.d dVar) {
            this.b.v = dVar;
            return this;
        }

        public d.b g(float f) {
            this.b.C = f;
            return this;
        }

        public d.b h(int i, int i2) {
            this.b.R = i;
            this.b.S = i2;
            return this;
        }

        public void i(Activity activity) throws android.content.ActivityNotFoundException {
            this.b.a();
            activity.startActivityForResult(a(activity), 203);
        }

        private b(Uri uri) {
            super();
            this.a = uri;
            this.b = new f();
        }
    }

    public static final class c extends CropImageView.b implements Parcelable {

        public static final Parcelable.Creator<d.c> CREATOR = new d$c$a<>();

        public c(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, int i, Rect rect2, int i2) {
            super(null, uri, null, uri2, exc, fArr, rect, rect2, i, i2);
        }

        @Override // com.theartofdev.edmodo.cropper.CropImageView$b
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(d(), i);
            parcel.writeParcelable(g(), i);
            parcel.writeSerializable(c());
            parcel.writeFloatArray(a());
            parcel.writeParcelable(b(), i);
            parcel.writeParcelable(h(), i);
            parcel.writeInt(e());
            parcel.writeInt(f());
        }

        protected c(Parcel parcel) {
            super(null, (Uri)parcel.readParcelable(Uri.class.getClassLoader()), null, (Uri)parcel.readParcelable(Uri.class.getClassLoader()), (Exception)parcel.readSerializable(), parcel.createFloatArray(), (Rect)parcel.readParcelable(Rect.class.getClassLoader()), (Rect)parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
        }

        @Override // com.theartofdev.edmodo.cropper.CropImageView$b
        public int describeContents() {
            return 0;
        }
    }
    public static d.b a(Uri uri) {
        return new d.b(uri, null);
    }

    public static d.c b(Intent intent) {
        Parcelable parcelableExtra = null;
        if (intent != null) {
            str = "CROP_IMAGE_EXTRA_RESULT";
            parcelableExtra = intent.getParcelableExtra(str);
        } else {
            int i = 0;
        }
        return parcelableExtra;
    }

    public static List<Intent> c(Context context, PackageManager packageManager) {
        int i;
        final ArrayList arrayList = new ArrayList();
        final Uri uri = d.d(context);
        final Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        i = 0;
        Iterator it = packageManager.queryIntentActivities(intent2, i).iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Intent intent = new Intent(intent2);
            intent.setComponent(new ComponentName(activityInfo22.packageName, activityInfo22.name));
            intent.setPackage(item.activityInfo.packageName);
            arrayList.add(intent);
        }
        return arrayList;
    }

    public static Uri d(Context context) {
        Uri file2 = null;
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            str = "pickImageResult.jpeg";
            file2 = Uri.fromFile(new File(externalCacheDir.getPath(), str));
        } else {
            int i = 0;
        }
        return file2;
    }

    public static List<Intent> e(PackageManager packageManager, String str, boolean z) {
        Intent intent;
        Uri eXTERNAL_CONTENT_URI2;
        boolean equals;
        final ArrayList arrayList = new ArrayList();
        if (str == "android.intent.action.GET_CONTENT") {
            intent = new Intent(str);
        } else {
            intent = new Intent(str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        intent.setType("image/*");
        int i = 0;
        Iterator it = packageManager.queryIntentActivities(intent, i).iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            Object intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(activityInfo2.packageName, activityInfo2.name));
            intent2.setPackage(item2.activityInfo.packageName);
            arrayList.add(intent2);
        }
        if (!z) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                intent = "com.android.documentsui.DocumentsActivity";
                if (item.getComponent().getClassName().equals(intent)) {
                    arrayList.remove(item);
                }
            }
        }
        return arrayList;
    }

    public static Intent f(Context context) {
        return d.g(context, context.getString(l.c), false, true);
    }

    public static Intent g(Context context, java.lang.CharSequence charSequence, boolean z, boolean z2) {
        List list2;
        Intent intent;
        final ArrayList arrayList = new ArrayList();
        final PackageManager packageManager = context.getPackageManager();
        if (!d.j(context) && z2) {
            arrayList.addAll(d.c(context, packageManager));
        }
        if (d.e(packageManager, "android.intent.action.GET_CONTENT", z).size() == 0) {
            list2 = d.e(packageManager, "android.intent.action.PICK", z);
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            Object item = arrayList.get(arrayList.size() - 1);
            i = arrayList.size() - 1;
            arrayList.remove(i);
        }
        Intent chooser = Intent.createChooser(intent, charSequence);
        chooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])arrayList.toArray(new Parcelable[arrayList.size()]));
        return chooser;
    }

    public static Uri h(Context context, Intent intent) {
        int i = 1;
        String action;
        String str;
        Uri data3;
        i = 1;
        if (intent != null && intent.getData() != null) {
            action = intent.getAction();
            if (action != null) {
                str = "android.media.action.IMAGE_CAPTURE";
                if (!(action.equals(str))) {
                    i = 0;
                }
            }
        }
        if (i != 0 || intent.getData() == null) {
            data3 = d.d(context);
        }
        return data3;
    }

    public static boolean i(Context context, String str) {
        int i;
        boolean equalsIgnoreCase;
        i = 0;
        try {
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
        if (requestedPermissions2[i].equalsIgnoreCase(str)) {
            return true;
        } else {
            i = i + 1;
        }
    }

    public static boolean j(Context context) {
        int sDK_INT2;
        int i = 23;
        boolean z2 = true;
        i = 23;
        if (Build.VERSION.SDK_INT >= 23) {
            str = "android.permission.CAMERA";
            context = d.i(context, str) && context.checkSelfPermission("android.permission.CAMERA") != 0 ? 1 : 0;
        }
        return (d.i(context, str) && context.checkSelfPermission("android.permission.CAMERA") != 0 ? 1 : 0);
    }

    public static boolean k(Context context, Uri uri) {
        int checkSelfPermission;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 23) {
            context = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != null && d.l(context, uri) ? 1 : 0;
        }
        return (context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != null && d.l(context, uri) ? 1 : 0);
    }

    public static boolean l(Context context, Uri uri) throws java.io.FileNotFoundException, java.io.IOException {
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            inputStream.close();
        } catch (Exception unused) {
            context = true;
            return true;
        }
        return false;
    }

    public static void m(Activity activity) throws android.content.ActivityNotFoundException {
        activity.startActivityForResult(d.f(activity), 200);
    }
}
