package com.appsflyer.internal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class j {

    static enum a {

        NONE,
        FIRST,
        ALL;
    }

    static enum b {

        UNKNOWN("uk"),
        ACCELEROMETER("am"),
        MAGNETOMETER("mm"),
        RESERVED("rs"),
        GYROSCOPE("gs");

        String values;
    }

    static enum c {

        UNKNOWN,
        ACCELEROMETER,
        MAGNETOMETER,
        RESERVED,
        GYROSCOPE;
    }
    private static List<BigDecimal> valueOf(Object object) {
        Object obj2 = object.get(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(BigDecimal.valueOf(Double.parseDouble((Float)(ArrayList)object.get(0).toString())));
        arrayList.add(BigDecimal.valueOf(Double.parseDouble((Float)obj2.toString())));
        arrayList.add(BigDecimal.valueOf(Double.parseDouble((Float)object.get(2).toString())));
        return arrayList;
    }

    final Map AFInAppEventParameterName(List<Map<String, Object>> list) {
        HashMap hashMap2;
        Object iterator;
        Object aFInAppEventParameterName;
        Object valueOf2;
        ArrayList arrayList2;
        HashMap hashMap;
        int intValue;
        Object valueOf;
        int valueOf3;
        ArrayList arrayList;
        ArrayList aFInAppEventParameterName2;
        int i4;
        int decimalFormat2;
        int decimalFormat;
        RoundingMode dOWN;
        int dOWN2;
        Object aFKeystoreWrapper;
        int i;
        String str2;
        com.appsflyer.internal.j.a aVar;
        Object str3;
        ArrayList arrayList3;
        int i2;
        int i3;
        String str;
        hashMap2 = new HashMap();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            valueOf2 = iterator.next();
            hashMap = new HashMap();
            intValue = "sVS";
            decimalFormat = 1;
            dOWN = 0;
            if ((Map)valueOf2.get(intValue) != null) {
            } else {
            }
            i4 = dOWN;
            dOWN2 = "sVE";
            if (valueOf2.get(dOWN2) != null) {
            } else {
            }
            i = dOWN;
            if (i4 != 0 && i != 0) {
            } else {
            }
            if (i4 != 0) {
            } else {
            }
            aFInAppEventParameterName2 = j.a.AFKeystoreWrapper;
            str2 = "er";
            if (aFInAppEventParameterName2 == j.a.AFKeystoreWrapper) {
                break;
            } else {
            }
            aFKeystoreWrapper = valueOf2.get("sT");
            str3 = valueOf2.get("sN");
            String str7 = "n";
            if ((String)str3 != null) {
            } else {
            }
            hashMap.put(str7, "uk");
            arrayList3 = new ArrayList(j.valueOf(valueOf2.get(intValue)));
            if (aFInAppEventParameterName2 == j.a.valueOf) {
            }
            dOWN2 = 3;
            i3 = 5;
            str = "##.#";
            if (j.c.values()[(Integer)aFKeystoreWrapper.intValue()] == j.c.AFInAppEventType) {
            } else {
            }
            aVar = aFInAppEventParameterName2;
            arrayList2 = new ArrayList();
            if (arrayList3.size() > 5) {
            }
            ArrayList arrayList4 = new ArrayList();
            DecimalFormat decimalFormat10 = new DecimalFormat(str);
            dOWN2 = RoundingMode.DOWN;
            decimalFormat10.setRoundingMode(dOWN2);
            arrayList4.add(Double.valueOf(Double.parseDouble(decimalFormat10.format((BigDecimal)arrayList3.get(dOWN)))));
            DecimalFormat decimalFormat9 = new DecimalFormat(str);
            decimalFormat9.setRoundingMode(RoundingMode.DOWN);
            arrayList4.add(Double.valueOf(Double.parseDouble(decimalFormat9.format((BigDecimal)arrayList3.get(decimalFormat)))));
            decimalFormat = new DecimalFormat(str);
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            arrayList4.add(Double.valueOf(Double.parseDouble(decimalFormat.format((BigDecimal)arrayList3.get(2)))));
            aFInAppEventParameterName2 = new ArrayList();
            aFInAppEventParameterName2.add(arrayList4);
            aFInAppEventParameterName2.add(arrayList2);
            arrayList = aFInAppEventParameterName2;
            hashMap.put("v", arrayList);
            hashMap2.put(bVar.values, hashMap);
            if (aVar == j.a.AFInAppEventParameterName) {
            }
            hashMap2.put(str2, "no_svs");
            DecimalFormat decimalFormat4 = new DecimalFormat(str);
            decimalFormat4.setRoundingMode(RoundingMode.DOWN);
            arrayList2.add(Double.valueOf(Double.parseDouble(decimalFormat4.format((BigDecimal)arrayList3.get(dOWN2).subtract((BigDecimal)arrayList3.get(dOWN))))));
            DecimalFormat decimalFormat5 = new DecimalFormat(str);
            decimalFormat5.setRoundingMode(RoundingMode.DOWN);
            arrayList2.add(Double.valueOf(Double.parseDouble(decimalFormat5.format((BigDecimal)arrayList3.get(4).subtract((BigDecimal)arrayList3.get(decimalFormat))))));
            decimalFormat2 = new DecimalFormat(str);
            decimalFormat2.setRoundingMode(RoundingMode.DOWN);
            arrayList2.add(Double.valueOf(Double.parseDouble(decimalFormat2.format((BigDecimal)arrayList3.get(5).subtract((BigDecimal)arrayList3.get(2))))));
            arrayList2 = new ArrayList();
            Object obj17 = arrayList3.get(dOWN);
            aVar = aFInAppEventParameterName2;
            valueOf = BigDecimal.valueOf(atan2 *= l);
            DecimalFormat decimalFormat3 = new DecimalFormat(str);
            RoundingMode dOWN3 = RoundingMode.DOWN;
            decimalFormat3.setRoundingMode(dOWN3);
            arrayList2.add(Double.valueOf(Double.parseDouble(decimalFormat3.format(valueOf))));
            DecimalFormat decimalFormat6 = new DecimalFormat(str);
            decimalFormat6.setRoundingMode(RoundingMode.DOWN);
            arrayList2.add(Double.valueOf(Double.parseDouble(decimalFormat6.format((BigDecimal)arrayList3.get(2)))));
            aFInAppEventParameterName2 = new ArrayList();
            if (arrayList3.size() > i3) {
            }
            arrayList = new ArrayList();
            arrayList.add(arrayList2);
            arrayList.add(aFInAppEventParameterName2);
            Object obj18 = arrayList3.get(4);
            DecimalFormat decimalFormat7 = new DecimalFormat(str);
            RoundingMode dOWN4 = RoundingMode.DOWN;
            decimalFormat7.setRoundingMode(dOWN4);
            aFInAppEventParameterName2.add(Double.valueOf(Double.parseDouble(decimalFormat7.format(BigDecimal.valueOf(atan22 *= i2).subtract(valueOf)))));
            DecimalFormat decimalFormat8 = new DecimalFormat(str);
            dOWN = RoundingMode.DOWN;
            decimalFormat8.setRoundingMode(dOWN);
            aFInAppEventParameterName2.add(Double.valueOf(Double.parseDouble(decimalFormat8.format((BigDecimal)arrayList3.get(5).subtract((BigDecimal)arrayList3.get(2))))));
            arrayList3.addAll(j.valueOf(valueOf2.get(dOWN2)));
            hashMap.put(str7, (String)str3);
            aFInAppEventParameterName2 = j.a.AFInAppEventParameterName;
            if (i != 0) {
            } else {
            }
            aFInAppEventParameterName2 = j.a.valueOf;
            i = decimalFormat;
            i4 = decimalFormat;
        }
        return hashMap2;
    }
}
