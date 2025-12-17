package com.google.firebase.storage;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ListResult {

    private static final String ITEMS_KEY = "items";
    private static final String NAME_KEY = "name";
    private static final String PAGE_TOKEN_KEY = "nextPageToken";
    private static final String PREFIXES_KEY = "prefixes";
    private final List<com.google.firebase.storage.StorageReference> items;
    private final String pageToken;
    private final List<com.google.firebase.storage.StorageReference> prefixes;
    ListResult(List<com.google.firebase.storage.StorageReference> list, List<com.google.firebase.storage.StorageReference> list2, String string3) {
        super();
        this.prefixes = list;
        this.items = list2;
        this.pageToken = string3;
    }

    static com.google.firebase.storage.ListResult fromJSON(com.google.firebase.storage.FirebaseStorage firebaseStorage, JSONObject jSONObject2) {
        Object jSONArray;
        Object jSONArray2;
        boolean z;
        boolean reference;
        int i;
        int reference2;
        String substring;
        boolean endsWith;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jSONArray = "prefixes";
        i = 0;
        if (jSONObject2.has(jSONArray)) {
            jSONArray = jSONObject2.getJSONArray(jSONArray);
            z = i;
            while (z < jSONArray.length()) {
                substring = jSONArray.getString(z);
                if (substring.endsWith("/")) {
                }
                arrayList.add(firebaseStorage.getReference(substring));
                z++;
                substring = substring.substring(i, length--);
            }
        }
        jSONArray2 = "items";
        if (jSONObject2.has(jSONArray2)) {
            jSONArray2 = jSONObject2.getJSONArray(jSONArray2);
            while (i < jSONArray2.length()) {
                arrayList2.add(firebaseStorage.getReference(jSONArray2.getJSONObject(i).getString("name")));
                i++;
            }
        }
        ListResult obj8 = new ListResult(arrayList, arrayList2, jSONObject2.optString("nextPageToken", 0));
        return obj8;
    }

    public List<com.google.firebase.storage.StorageReference> getItems() {
        return this.items;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public List<com.google.firebase.storage.StorageReference> getPrefixes() {
        return this.prefixes;
    }
}
