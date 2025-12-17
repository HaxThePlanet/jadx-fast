package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class b {
    public static com.google.android.play.core.assetpacks.b c(Bundle bundle, com.google.android.play.core.assetpacks.k1 k12, com.google.android.play.core.assetpacks.u2 u23) {
        ArrayList arrayList = new ArrayList();
        return b.d(bundle, k12, u23, arrayList, d0.a);
    }

    private static com.google.android.play.core.assetpacks.b d(Bundle bundle, com.google.android.play.core.assetpacks.k1 k12, com.google.android.play.core.assetpacks.u2 u23, List<String> list4, com.google.android.play.core.assetpacks.c0 c05) {
        int size;
        int i;
        Object obj;
        com.google.android.play.core.assetpacks.k1 k1Var;
        com.google.android.play.core.assetpacks.u2 u2Var;
        long l;
        com.google.android.play.core.assetpacks.AssetPackState assetPackState;
        int i2;
        int i3;
        String str;
        String str2;
        Bundle bundle2 = bundle;
        ArrayList stringArrayList = bundle2.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        i = 0;
        while (i < stringArrayList.size()) {
            obj = stringArrayList.get(i);
            hashMap.put(obj, AssetPackState.i(bundle2, (String)obj, k12, u23, c05));
            i++;
        }
        Iterator iterator = list4.iterator();
        for (String size : iterator) {
            hashMap.put(size, AssetPackState.h(size, 4, 0, 0, l, 0, obj10, 0, obj12));
        }
        String str4 = "total_bytes_to_download";
        l0 l0Var = new l0(bundle2.getLong(str4), str4, hashMap);
        return l0Var;
    }

    public abstract Map<String, com.google.android.play.core.assetpacks.AssetPackState> a();

    public abstract long b();
}
