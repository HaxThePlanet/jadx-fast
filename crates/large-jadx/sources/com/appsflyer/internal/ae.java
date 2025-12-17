package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class ae {

    private static com.appsflyer.internal.ae valueOf;
    static {
        ae aeVar = new ae();
        ae.valueOf = aeVar;
    }

    static com.appsflyer.internal.ae AFInAppEventType() {
        return ae.valueOf;
    }

    static com.appsflyer.internal.f AFKeystoreWrapper(File file) {
        Throwable th2;
        String obj4;
        final int i = 0;
        FileReader fileReader = new FileReader(file);
        char[] cArr = new char[(int)length];
        fileReader.read(cArr);
        f fVar = new f(cArr);
        fVar.AFInAppEventParameterName = file.getName();
        fileReader.close();
        return fVar;
    }

    static File AFKeystoreWrapper(Context context) {
        File file = new File(context.getFilesDir(), "AFRequestCache");
        return file;
    }

    static List<com.appsflyer.internal.f> valueOf(Context context) {
        File length;
        String str;
        com.appsflyer.internal.f fVar;
        String string;
        String name;
        boolean obj6;
        ArrayList arrayList = new ArrayList();
        length = new File(context.getFilesDir(), "AFRequestCache");
        if (!length.exists()) {
            length.mkdir();
        } else {
            obj6 = length.listFiles();
            str = 0;
            while (str < obj6.length) {
                File file = obj6[str];
                StringBuilder stringBuilder = new StringBuilder("Found cached request");
                stringBuilder.append(file.getName());
                AFLogger.AFInAppEventType(stringBuilder.toString());
                arrayList.add(ae.AFKeystoreWrapper(file));
                str++;
            }
        }
        return arrayList;
    }

    static void values(String string, Context context2) {
        boolean exists;
        String str;
        String obj3;
        File obj4;
        File file = new File(context2.getFilesDir(), "AFRequestCache");
        obj4 = new File(file, string);
        StringBuilder stringBuilder2 = new StringBuilder("Deleting ");
        stringBuilder2.append(string);
        stringBuilder2.append(" from cache");
        AFLogger.AFInAppEventType(stringBuilder2.toString());
        if (obj4.exists()) {
            obj4.delete();
        }
    }
}
