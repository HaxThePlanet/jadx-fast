package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes5.dex */
public class AppLocalesStorageHelper {

    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync;
    static {
        Object object = new Object();
        AppLocalesStorageHelper.sAppLocaleStorageSync = object;
    }

    public static void persistLocales(Context context, String locales) {
        int i;
        String arr;
        String str;
        Boolean valueOf;
        final Object sAppLocaleStorageSync = AppLocalesStorageHelper.sAppLocaleStorageSync;
        synchronized (sAppLocaleStorageSync) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        }
    }

    public static String readLocales(Context context) {
        String appLocales;
        XmlPullParser pullParser;
        boolean empty;
        String str;
        int depth;
        String next;
        int i2;
        int attributeValue;
        int i;
        final Object sAppLocaleStorageSync = AppLocalesStorageHelper.sAppLocaleStorageSync;
        appLocales = "";
        FileInputStream fileInput = context.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
        pullParser = Xml.newPullParser();
        pullParser.setInput(fileInput, "UTF-8");
        synchronized (sAppLocaleStorageSync) {
            next = pullParser.next();
            i2 = next;
            while (next != 1) {
                next = 3;
                if (i2 != next) {
                    break;
                } else {
                }
                next = pullParser.next();
                i2 = next;
                if (i2 != 4) {
                    break;
                } else {
                }
                if (pullParser.getName().equals("locales")) {
                    break;
                } else {
                }
                if (pullParser.getDepth() > pullParser.getDepth()) {
                    break;
                }
            }
            if (fileInput != null) {
                fileInput.close();
                try {
                    Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    if (fis != null) {
                    }
                    fis.close();
                    if (!appLocales.isEmpty()) {
                    } else {
                    }
                    context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    return appLocales;
                    if (fis == null) {
                    } else {
                    }
                    fis.close();
                    throw th;
                    return appLocales2;
                    throw appLocales2;
                }
            }
        }
    }
}
