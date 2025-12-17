package zendesk.belvedere;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
class y extends AsyncTask<Uri, Void, List<zendesk.belvedere.s>> {

    private final WeakReference<zendesk.belvedere.d<List<zendesk.belvedere.s>>> a;
    private final Context b;
    private final zendesk.belvedere.z c;
    private final String d;
    private y(Context context, zendesk.belvedere.z z2, zendesk.belvedere.d<List<zendesk.belvedere.s>> d3, String string4) {
        super();
        this.b = context;
        this.c = z2;
        this.d = string4;
        WeakReference obj1 = new WeakReference(d3);
        this.a = obj1;
    }

    static void c(Context context, zendesk.belvedere.z z2, zendesk.belvedere.d<List<zendesk.belvedere.s>> d3, List<Uri> list4) {
        y.d(context, z2, d3, list4, 0);
    }

    static void d(Context context, zendesk.belvedere.z z2, zendesk.belvedere.d<List<zendesk.belvedere.s>> d3, List<Uri> list4, String string5) {
        y yVar = new y(context, z2, d3, string5);
        yVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Uri[])list4.toArray(new Uri[list4.size()]));
    }

    protected List<zendesk.belvedere.s> a(Uri... uriArr) {
        int format2;
        String format;
        Throwable th;
        Object obj;
        int i3;
        Locale locale;
        Object[] objArr;
        Object uri;
        String fileOutputStream;
        int inputStream;
        String str;
        int i5;
        int i4;
        int i;
        Object valueOf;
        int i2;
        File file;
        Object obj4;
        Object obj2;
        String name;
        String str2;
        long l2;
        long l;
        long l3;
        Object obj3;
        obj = this;
        final String str3 = "Error closing FileOutputStream";
        final String str4 = "Error closing InputStream";
        final String str5 = "Belvedere";
        ArrayList arrayList = new ArrayList();
        final byte[] bArr = new byte[1048576];
        i5 = inputStream;
        i4 = 0;
        while (i4 < objArr.length) {
            Object obj5 = objArr[i4];
            inputStream = obj.b.getContentResolver().openInputStream(obj5);
            file = obj.c.f(obj.b, obj5, obj.d);
            int i7 = 2;
            if (inputStream != null && file != null) {
            } else {
            }
            obj3 = obj5;
            i3 = 1;
            Object[] arr2 = new Object[i7];
            if (inputStream == null) {
            } else {
            }
            i2 = 0;
            arr2[0] = Boolean.valueOf(i2);
            if (file == null) {
            } else {
            }
            file = 0;
            arr2[i3] = Boolean.valueOf(file);
            q.e(str5, String.format(Locale.US, "Unable to resolve uri. InputStream null = %s, File null = %s", arr2));
            if (inputStream != null) {
            }
            if (i5 != null) {
            }
            i = 0;
            i4++;
            obj = this;
            objArr = uriArr;
            i5.close();
            inputStream.close();
            file = i3;
            i2 = i3;
            if (file != null) {
            } else {
            }
            Object[] arr = new Object[i7];
            arr[0] = obj5;
            int i8 = 1;
            arr[i8] = file;
            q.a(str5, String.format(Locale.US, "Copying media file into private cache - Uri: %s - Dest: %s", arr));
            fileOutputStream = new FileOutputStream(file);
            format = inputStream.read(bArr);
            while (format > 0) {
                fileOutputStream.write(bArr, 0, format);
                format = inputStream.read(bArr);
            }
            format2 = z.j(obj.b, obj5);
            i3 = i8;
            super(file, obj.c.i(obj.b, file), obj5, file.getName(), format2.i(), format2.m(), obj20, format2.o(), obj22, format2.f(), obj24);
            arrayList.add(sVar);
            i5 = fileOutputStream;
            fileOutputStream.write(bArr, 0, format);
            str = fileOutputStream;
            str = fileOutputStream;
            obj3 = obj15;
            th = obj16;
            str = fileOutputStream;
            obj3 = obj15;
            th = obj16;
            str = fileOutputStream;
            obj3 = obj15;
            th = obj16;
            obj3 = obj15;
            th = obj16;
            th = th2;
            q.c(obj5, obj4, th);
            th = th2;
            obj3 = obj15;
            th = 1;
            locale = Locale.US;
            fileOutputStream = "IO Error copying file, uri: %s";
            th = new Object[th];
            i = 0;
            th[i] = obj3;
            th = String.format(locale, fileOutputStream, th);
            q.c(obj5, th, th2);
            if (obj10 != null) {
            }
            obj10.close();
            th = th2;
            q.c(obj5, obj4, th);
            if (str != null) {
            }
            str.close();
            th = th2;
            q.c(obj5, obj3, th);
            obj3 = obj15;
            th = 1;
            locale = Locale.US;
            fileOutputStream = "File not found error copying file, uri: %s";
            th = new Object[th];
            i = 0;
            th[i] = obj3;
            th = String.format(locale, fileOutputStream, th);
            q.c(obj5, th, th2);
            if (obj10 != null) {
            }
            obj10.close();
            th = th2;
            q.c(obj5, obj4, th);
            if (str != null) {
            }
            str.close();
            th = th2;
            q.c(obj5, obj3, th);
        }
        return arrayList;
    }

    protected void b(List<zendesk.belvedere.s> list) {
        Object str;
        Object obj2;
        super.onPostExecute(list);
        str = this.a.get();
        if ((d)str != null) {
            (d)str.internalSuccess(list);
        } else {
            q.e("Belvedere", "Callback null");
        }
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object[] objectArr) {
        return a((Uri[])objectArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object object) {
        b((List)object);
    }
}
