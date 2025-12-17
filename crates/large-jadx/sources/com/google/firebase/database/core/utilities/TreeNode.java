package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class TreeNode<T>  {

    public Map<ChildKey, com.google.firebase.database.core.utilities.TreeNode<T>> children;
    public T value;
    public TreeNode() {
        super();
        HashMap hashMap = new HashMap();
        this.children = hashMap;
    }

    String toString(String string) {
        String string3;
        String string2;
        StringBuilder stringBuilder;
        String str;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string);
        stringBuilder2.append("<value>: ");
        stringBuilder2.append(this.value);
        String str4 = "\n";
        stringBuilder2.append(str4);
        if (this.children.isEmpty()) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(stringBuilder2.toString());
            stringBuilder3.append(string);
            stringBuilder3.append("<empty>");
            return stringBuilder3.toString();
        }
        Iterator iterator = this.children.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string);
            stringBuilder.append(next2.getKey());
            stringBuilder.append(":\n");
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(string);
            stringBuilder4.append("\t");
            stringBuilder.append((TreeNode)next2.getValue().toString(stringBuilder4.toString()));
            stringBuilder.append(str4);
            string3 = stringBuilder.toString();
        }
        return string3;
    }
}
