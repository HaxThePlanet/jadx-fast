package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class ShortcutXmlParser {

    private static final String ATTR_SHORTCUT_ID = "shortcutId";
    private static final Object GET_INSTANCE_LOCK = null;
    private static final String META_DATA_APP_SHORTCUTS = "android.app.shortcuts";
    private static final String TAG = "ShortcutXmlParser";
    private static final String TAG_SHORTCUT = "shortcut";
    private static volatile ArrayList<String> sShortcutIds;
    static {
        Object object = new Object();
        ShortcutXmlParser.GET_INSTANCE_LOCK = object;
    }

    private static String getAttributeValue(XmlPullParser parser, String attribute) {
        String value;
        int i;
        if (parser.getAttributeValue("http://schemas.android.com/apk/res/android", attribute) == null) {
            value = parser.getAttributeValue(0, attribute);
        }
        return value;
    }

    public static List<String> getShortcutIds(Context context) {
        Object gET_INSTANCE_LOCK;
        ArrayList sShortcutIds;
        Set shortcutIds;
        gET_INSTANCE_LOCK = ShortcutXmlParser.GET_INSTANCE_LOCK;
        if (ShortcutXmlParser.sShortcutIds == null && ShortcutXmlParser.sShortcutIds == null) {
            gET_INSTANCE_LOCK = ShortcutXmlParser.GET_INSTANCE_LOCK;
            synchronized (gET_INSTANCE_LOCK) {
                ArrayList arrayList = new ArrayList();
                ShortcutXmlParser.sShortcutIds = arrayList;
                ShortcutXmlParser.sShortcutIds.addAll(ShortcutXmlParser.parseShortcutIds(context));
            }
        }
        return ShortcutXmlParser.sShortcutIds;
    }

    private static XmlResourceParser getXmlResourceParser(Context context, ActivityInfo info) {
        XmlResourceParser xmlMetaData = info.loadXmlMetaData(context.getPackageManager(), "android.app.shortcuts");
        if (xmlMetaData == null) {
        } else {
            return xmlMetaData;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Failed to open android.app.shortcuts meta-data resource of ").append(info.name).toString());
        throw illegalArgumentException;
    }

    public static List<String> parseShortcutIds(XmlPullParser parser) throws IOException, XmlPullParserException {
        int depth;
        int depth2;
        int i;
        String name;
        int attributeValue;
        final int i2 = 1;
        ArrayList arrayList = new ArrayList(i2);
        depth2 = parser.next();
        i = depth2;
        while (depth2 != i2) {
            if (i == 3) {
            } else {
            }
            attributeValue = 2;
            if (i == attributeValue && parser.getDepth() == attributeValue && "shortcut".equals(parser.getName())) {
            } else {
            }
            depth2 = parser.next();
            i = depth2;
            if (parser.getDepth() == attributeValue) {
            } else {
            }
            if ("shortcut".equals(name)) {
            } else {
            }
            attributeValue = ShortcutXmlParser.getAttributeValue(parser, "shortcutId");
            if (attributeValue == null) {
            } else {
            }
            arrayList.add(attributeValue);
            if (parser.getDepth() > 0) {
            }
        }
        return arrayList;
    }

    private static Set<String> parseShortcutIds(Context context) {
        Throwable th;
        int size;
        Iterator iterator;
        Object next;
        boolean next2;
        Object activityInfo;
        Bundle metaData;
        boolean xmlResourceParser;
        Throwable shortcutIds;
        HashSet hashSet = new HashSet();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(context.getPackageName());
        List intentActivities = context.getPackageManager().queryIntentActivities(intent, 128);
        if (intentActivities != null) {
            if (intentActivities.size() == 0) {
            } else {
                iterator = intentActivities.iterator();
                while (iterator.hasNext()) {
                    activityInfo = next.activityInfo;
                    metaData = activityInfo.metaData;
                    xmlResourceParser = ShortcutXmlParser.getXmlResourceParser(context, activityInfo);
                    hashSet.addAll(ShortcutXmlParser.parseShortcutIds(xmlResourceParser));
                    if (metaData != null && metaData.containsKey("android.app.shortcuts") && xmlResourceParser != null) {
                    }
                    if (metaData.containsKey("android.app.shortcuts")) {
                    }
                    xmlResourceParser = ShortcutXmlParser.getXmlResourceParser(context, activityInfo);
                    hashSet.addAll(ShortcutXmlParser.parseShortcutIds(xmlResourceParser));
                    if (xmlResourceParser != null) {
                    }
                    xmlResourceParser.close();
                }
            }
            return hashSet;
        }
        return hashSet;
    }
}
