package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DefaultsXmlParser {

    private static final String XML_TAG_ENTRY = "entry";
    private static final String XML_TAG_KEY = "key";
    private static final String XML_TAG_VALUE = "value";
    public static Map<String, String> getDefaultsFromXml(Context context, int i2) {
        int name;
        int text2;
        int text;
        int i;
        int equals;
        int i3;
        XmlResourceParser obj9;
        int obj10;
        final String str = "FirebaseRemoteConfig";
        HashMap hashMap = new HashMap();
        obj9 = context.getResources();
        if (obj9 == null) {
            Log.e(str, "Could not find the resources of the current context while trying to set defaults from an XML.");
            return hashMap;
        }
        obj9 = obj9.getXml(i2);
        obj10 = obj9.getEventType();
        final int i4 = 0;
        text = text2;
        i = 1;
        while (obj10 != i) {
            if (obj10 == 2) {
            } else {
            }
            if (obj10 == 3) {
            } else {
            }
            if (obj10 == 4 && name != null) {
            }
            obj10 = obj9.next();
            i = 1;
            if (name != null) {
            }
            obj10 = -1;
            equals = name.hashCode();
            if (equals != 106079) {
            } else {
            }
            if (name.equals("key")) {
            }
            if (obj10 != null) {
            } else {
            }
            text2 = obj9.getText();
            if (obj10 != i) {
            } else {
            }
            text = obj9.getText();
            Log.w(str, "Encountered an unexpected tag while parsing the defaults XML.");
            obj10 = 0;
            if (equals != 111972721) {
            } else {
            }
            if (name.equals("value")) {
            }
            obj10 = i;
            if (obj9.getName().equals("entry")) {
            }
            name = i4;
            if (text2 != null && text != null) {
            } else {
            }
            Log.w(str, "An entry in the defaults XML has an invalid key and/or value tag.");
            text = text2;
            if (text != null) {
            } else {
            }
            hashMap.put(text2, text);
            name = obj9.getName();
        }
        return hashMap;
    }
}
