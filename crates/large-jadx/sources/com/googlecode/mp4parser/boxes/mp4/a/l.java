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

/* compiled from: ObjectDescriptorFactory.java */
/* loaded from: classes2.dex */
public class l {

    protected static Logger a;
    protected static Map<Integer, Map<Integer, Class<? extends b>>> b;
    static {
        Object value;
        int i = 0;
        Integer num2;
        l.a = Logger.getLogger(l.class.getName());
        l.b = new HashMap();
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
        obj = e.class;
        hashSet.add(obj);
        Iterator it = hashSet.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            java.lang.annotation.Annotation annotation = item.getAnnotation(g.class);
            int[] tags = annotation.tags();
            int objectTypeIndication = annotation.objectTypeIndication();
            for (int i2 : tags) {
                value.put(Integer.valueOf(i2), item);
            }
            l.b.put(Integer.valueOf(objectTypeIndication), value);
            value.put(Integer.valueOf(tags[i]), item);
            i = i + 1;
        }
    }

    public static b a(int i, ByteBuffer byteBuffer) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        Object value;
        Object obj;
        final int i3 = e.n(byteBuffer);
        if ((Map)l.b.get(Integer.valueOf(i)) == null) {
            value = l.b.get(-1);
        }
        Object value2 = value.get(Integer.valueOf(i3));
        String str5 = " and tag ";
        if (value2 != null && !value2.isInterface()) {
            if (Modifier.isAbstract(value2.getModifiers())) {
                str = "No ObjectDescriptor found for objectTypeIndication ";
                StringBuilder stringBuilder = new StringBuilder(str);
                String str7 = Integer.toHexString(i);
                String str8 = Integer.toHexString(i3);
                String str9 = " found: ";
                str2 = str + str7 + str5 + str8 + str9 + value2;
                l.a.warning(str2);
                com.googlecode.mp4parser.boxes.mp4.a.o oVar = new o();
            } else {
                try {
                    obj = value2.newInstance();
                } catch (Exception e) {
                    String str6 = "Couldn't instantiate BaseDescriptor class ";
                    StringBuilder stringBuilder2 = new StringBuilder(str6);
                    String str3 = " for objectTypeIndication ";
                    i = str6 + str3 + str3 + i + str4 + i2;
                    l.a.log(Level.SEVERE, i, e);
                    i = new RuntimeException(e);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                }
            }
        }
        obj.d(i3, e);
        return obj;
    }
}
