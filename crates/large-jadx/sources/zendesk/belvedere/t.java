package zendesk.belvedere;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import d.h.k.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
class t {

    private final zendesk.belvedere.z a;
    private final zendesk.belvedere.o b;
    private final Context c;
    t(Context context, zendesk.belvedere.z z2, zendesk.belvedere.o o3) {
        super();
        this.c = context;
        this.a = z2;
        this.b = o3;
    }

    private boolean a(Context context) {
        return g(context);
    }

    private List<Uri> b(Intent intent) {
        int clipData;
        Uri data;
        int itemCount;
        ClipData.Item itemAt;
        Uri uri;
        Object obj6;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 16 && intent.getClipData() != null) {
            if (intent.getClipData() != null) {
                obj6 = intent.getClipData();
                data = 0;
                while (data < obj6.getItemCount()) {
                    itemAt = obj6.getItemAt(data);
                    if (itemAt.getUri() != null) {
                    }
                    data++;
                    arrayList.add(itemAt.getUri());
                }
            } else {
                if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
            }
        } else {
        }
        return arrayList;
    }

    private Intent d(String string, boolean z2, List<String> list3) {
        Intent intent;
        String str;
        int obj4;
        boolean obj5;
        final int sDK_INT = Build.VERSION.SDK_INT;
        String str2 = "Belvedere";
        if (sDK_INT >= 19) {
            q.a(str2, "Gallery Intent, using 'ACTION_OPEN_DOCUMENT'");
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        } else {
            q.a(str2, "Gallery Intent, using 'ACTION_GET_CONTENT'");
            intent = new Intent("android.intent.action.GET_CONTENT");
        }
        intent.setType(string);
        intent.addCategory("android.intent.category.OPENABLE");
        if (sDK_INT >= 18) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z2);
        }
        if (list3 != null && !list3.isEmpty()) {
            if (!list3.isEmpty()) {
                intent.putExtra("android.intent.extra.MIME_TYPES", (String[])list3.toArray(new String[0]));
            }
        }
        return intent;
    }

    private boolean g(Context context) {
        int i2;
        PackageManager packageManager;
        String systemFeature;
        int i;
        Intent intent = new Intent();
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        packageManager = context.getPackageManager();
        i = 0;
        final int i4 = 1;
        if (!packageManager.hasSystemFeature("android.hardware.camera")) {
            if (packageManager.hasSystemFeature("android.hardware.camera.front")) {
                i2 = i4;
            } else {
                i2 = i;
            }
        } else {
        }
        final boolean obj7 = i(intent, context);
        Object[] arr = new Object[2];
        arr[i] = Boolean.valueOf(i2);
        arr[i4] = Boolean.valueOf(obj7);
        q.a("Belvedere", String.format(Locale.US, "Camera present: %b, Camera App present: %b", arr));
        if (i2 != 0 && obj7 != null) {
            if (obj7 != null) {
                i = i4;
            }
        }
        return i;
    }

    private boolean h(Context context) {
        ArrayList arrayList = new ArrayList();
        return i(d("*/*", false, arrayList), context);
    }

    private boolean i(Intent intent, Context context2) {
        android.content.ComponentName obj1;
        PackageManager obj2;
        if (intent != null && intent.resolveActivity(context2.getPackageManager()) != null) {
            obj1 = intent.resolveActivity(context2.getPackageManager()) != null ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private d<zendesk.belvedere.r, zendesk.belvedere.s> j(Context context, int i2) {
        boolean z;
        int i;
        int i3;
        final Object obj = this;
        Context context2 = context;
        final File file = obj.a.e(context2);
        int i4 = 0;
        String str3 = "Belvedere";
        if (file == null) {
            q.e(str3, "Camera Intent: Image path is null. There's something wrong with the storage.");
            return i4;
        }
        final Uri uri2 = obj.a.i(context2, file);
        if (uri2 == null) {
            q.e(str3, "Camera Intent: Uri to file is null. There's something wrong with the storage or FileProvider configuration.");
            return i4;
        }
        int i6 = 3;
        Object[] arr = new Object[i6];
        final int i8 = 0;
        arr[i8] = Integer.valueOf(i2);
        int i7 = 1;
        arr[i7] = file;
        arr[2] = uri2;
        q.a(str3, String.format(Locale.US, "Camera Intent: Request Id: %s - File: %s - Uri: %s", arr));
        Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        intent2.putExtra("output", uri2);
        obj.a.l(context2, intent2, uri2, i6);
        String str8 = "android.permission.CAMERA";
        if (w.a(context2, str8) && !w.b(context2, str8)) {
            i3 = !w.b(context2, str8) ? i7 : i8;
        } else {
        }
        zendesk.belvedere.s sVar = z.j(context2, uri2);
        super(file, uri2, uri2, file.getName(), sVar.i(), sVar.m(), i8, sVar.o(), obj12, sVar.f(), sVar4);
        i = i3 != 0 ? str9 : i4;
        super(i2, intent2, i, 1, 2);
        d dVar = new d(rVar, sVar4);
        return dVar;
    }

    d<zendesk.belvedere.r, zendesk.belvedere.s> c(int i) {
        if (a(this.c)) {
            return j(this.c, i);
        }
        d obj3 = new d(r.e(), 0);
        return obj3;
    }

    void e(Context context, int i2, int i3, Intent intent4, zendesk.belvedere.d<List<zendesk.belvedere.s>> d5, boolean z6) {
        Object format2;
        int iterator;
        List list;
        int next;
        Object format;
        Object file;
        int i6;
        Object str;
        int i;
        int i8;
        int i5;
        String str2;
        int i7;
        int i4;
        Object zVar;
        Uri uri2;
        Uri uri;
        String str3;
        String str4;
        long l2;
        long l;
        long l3;
        final Object obj = this;
        format2 = context;
        iterator = i2;
        next = i3;
        final zendesk.belvedere.d dVar = d5;
        ArrayList arrayList = new ArrayList();
        format = obj.b.b(iterator);
        if (format != null) {
            i = -1;
            i8 = 0;
            i5 = 1;
            str2 = "Belvedere";
            if (format.e() != null) {
                if (format.n() == null) {
                    iterator = Locale.US;
                    Object[] arr2 = new Object[i5];
                    i6 = next == i ? i5 : i8;
                    arr2[i8] = Boolean.valueOf(i6);
                    q.a(str2, String.format(iterator, "Parsing activity result - Gallery - Ok: %s", arr2));
                    list = obj.b(intent4);
                    format = new Object[i5];
                    format[i8] = Integer.valueOf(list.size());
                    q.a(str2, String.format(iterator, "Number of items received from gallery: %s", format));
                    if (next == i && z6) {
                        list = obj.b(intent4);
                        format = new Object[i5];
                        format[i8] = Integer.valueOf(list.size());
                        q.a(str2, String.format(iterator, "Number of items received from gallery: %s", format));
                        if (z6) {
                            q.a(str2, "Resolving items");
                            y.c(format2, obj.a, dVar, list);
                        }
                        q.a(str2, "Resolving items turned off");
                        iterator = list.iterator();
                        for (Uri next2 : iterator) {
                            arrayList.add(z.j(format2, next2));
                        }
                    }
                } else {
                    str = Locale.US;
                    Object[] arr3 = new Object[i5];
                    i4 = next == i ? i5 : i8;
                    arr3[i8] = Boolean.valueOf(i4);
                    q.a(str2, String.format(str, "Parsing activity result - Camera - Ok: %s", arr3));
                    obj.a.m(format2, format.n(), 3);
                    if (next == i) {
                        zendesk.belvedere.s sVar = z.j(format2, format.n());
                        super(format.e(), format.n(), format.k(), format.j(), sVar.i(), sVar.m(), obj19, sVar.o(), obj21, sVar.f(), obj23);
                        arrayList.add(sVar2);
                        Object[] arr = new Object[i5];
                        arr[i8] = format.e();
                        q.a(str2, String.format(str, "Image from camera: %s", arr));
                    }
                    obj.b.a(iterator);
                }
            } else {
            }
        }
        if (dVar != null) {
            dVar.internalSuccess(arrayList);
        }
    }

    zendesk.belvedere.r f(int i, String string2, boolean z3, List<String> list4) {
        if (h(this.c)) {
            super(i, d(string2, z3, list4), 0, 1, 1);
            return rVar;
        }
        return r.e();
    }
}
