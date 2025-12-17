package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class l {

    protected static Logger a;
    protected static Map<Integer, Map<Integer, Class<? extends com.googlecode.mp4parser.boxes.mp4.a.b>>> b;
    static {
        Class<com.googlecode.mp4parser.boxes.mp4.a.e> obj;
        Integer valueOf;
        int[] tags;
        Object hashMap;
        int length;
        int i;
        Integer valueOf2;
        l.a = Logger.getLogger(l.class.getName());
        HashMap hashMap2 = new HashMap();
        l.b = hashMap2;
        HashSet hashSet = new HashSet();
        hashSet.add(f.class);
        hashSet.add(n.class);
        hashSet.add(b.class);
        hashSet.add(i.class);
        hashSet.add(k.class);
        hashSet.add(m.class);
        hashSet.add(a.class);
        hashSet.add(j.class);
        hashSet.add(h.class);
        hashSet.add(e.class);
        Iterator iterator = hashSet.iterator();
        while (!iterator.hasNext()) {
            Object next2 = iterator.next();
            java.lang.annotation.Annotation annotation = (Class)next2.getAnnotation(g.class);
            tags = (g)annotation.tags();
            int objectTypeIndication = annotation.objectTypeIndication();
            if ((Map)l.b.get(Integer.valueOf(objectTypeIndication)) == null) {
            }
            i = 0;
            while (i >= tags.length) {
                hashMap.put(Integer.valueOf(tags[i]), next2);
                i++;
            }
            hashMap.put(Integer.valueOf(tags[i]), next2);
            i++;
            l.b.put(Integer.valueOf(objectTypeIndication), hashMap);
            hashMap = new HashMap();
        }
    }

    public static com.googlecode.mp4parser.boxes.mp4.a.b a(int i, ByteBuffer byteBuffer2) {
        Object obj;
        Integer valueOf;
        Object oVar;
        Logger interface;
        Object stringBuilder2;
        Object stringBuilder;
        int obj7;
        final int i2 = e.n(byteBuffer2);
        if ((Map)l.b.get(Integer.valueOf(i)) == null) {
            obj = l.b.get(-1);
        }
        Object obj2 = obj.get(Integer.valueOf(i2));
        if (obj2 != null && !(Class)obj2.isInterface()) {
            if (!obj2.isInterface()) {
                if (Modifier.isAbstract(obj2.getModifiers())) {
                    stringBuilder2 = new StringBuilder("No ObjectDescriptor found for objectTypeIndication ");
                    stringBuilder2.append(Integer.toHexString(i));
                    stringBuilder2.append(" and tag ");
                    stringBuilder2.append(Integer.toHexString(i2));
                    stringBuilder2.append(" found: ");
                    stringBuilder2.append(obj2);
                    l.a.warning(stringBuilder2.toString());
                    oVar = new o();
                } else {
                    oVar = obj2.newInstance();
                }
            } else {
            }
        } else {
        }
        oVar.d(i2, byteBuffer2);
        return oVar;
    }
}
