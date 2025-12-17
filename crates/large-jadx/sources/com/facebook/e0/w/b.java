package com.facebook.e0.w;

import com.facebook.internal.g0.i.a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.q0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010%\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0008\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J+\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lcom/facebook/appevents/ml/Model;", "", "weights", "", "", "Lcom/facebook/appevents/ml/MTensor;", "(Ljava/util/Map;)V", "convs0Bias", "convs0Weight", "convs1Bias", "convs1Weight", "convs2Bias", "convs2Weight", "embedding", "fc1Bias", "fc1Weight", "fc2Bias", "fc2Weight", "finalWeights", "", "predictOnMTML", "dense", "texts", "", "task", "(Lcom/facebook/appevents/ml/MTensor;[Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/appevents/ml/MTensor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private static final Map<String, String> m;
    public static final com.facebook.e0.w.b.a n;
    private final com.facebook.e0.w.a a;
    private final com.facebook.e0.w.a b;
    private final com.facebook.e0.w.a c;
    private final com.facebook.e0.w.a d;
    private final com.facebook.e0.w.a e;
    private final com.facebook.e0.w.a f;
    private final com.facebook.e0.w.a g;
    private final com.facebook.e0.w.a h;
    private final com.facebook.e0.w.a i;
    private final com.facebook.e0.w.a j;
    private final com.facebook.e0.w.a k;
    private final Map<String, com.facebook.e0.w.a> l;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lcom/facebook/appevents/ml/Model$Companion;", "", "()V", "SEQ_LEN", "", "mapping", "", "", "build", "Lcom/facebook/appevents/ml/Model;", "file", "Ljava/io/File;", "parse", "Lcom/facebook/appevents/ml/MTensor;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final Map<String, com.facebook.e0.w.a> b(File file) {
            Object value;
            Object key2;
            boolean key;
            Map obj7 = g.c(file);
            final int i = 0;
            if (obj7 != null) {
                HashMap hashMap = new HashMap();
                final Map map = b.a();
                obj7 = obj7.entrySet().iterator();
                for (Map.Entry next2 : obj7) {
                    key2 = next2.getKey();
                    hashMap.put(key2, next2.getValue());
                }
                return hashMap;
            }
            return i;
        }

        public final com.facebook.e0.w.b a(File file) {
            n.f(file, "file");
            final Map obj3 = b(file);
            int i = 0;
            if (obj3 != null) {
                b bVar = new b(obj3, i);
                return bVar;
            }
            return i;
        }
    }
    static {
        b.a aVar = new b.a(0);
        b.n = aVar;
        kotlin.o[] arr = new o[7];
        b.m = j0.j(u.a("embedding.weight", "embed.weight"), u.a("dense1.weight", "fc1.weight"), u.a("dense2.weight", "fc2.weight"), u.a("dense3.weight", "fc3.weight"), u.a("dense1.bias", "fc1.bias"), u.a("dense2.bias", "fc2.bias"), u.a("dense3.bias", "fc3.bias"));
    }

    private b(Map<String, com.facebook.e0.w.a> map) {
        int string2;
        String string;
        Object obj2;
        Object obj;
        Map map2;
        super();
        Object obj3 = map.get("embed.weight");
        String str12 = "Required value was null.";
        if (obj3 == null) {
        } else {
            this.a = (a)obj3;
            Object obj4 = map.get("convs.0.weight");
            if (obj4 == null) {
            } else {
                this.b = f.l((a)obj4);
                Object obj5 = map.get("convs.1.weight");
                if (obj5 == null) {
                } else {
                    this.c = f.l((a)obj5);
                    Object obj6 = map.get("convs.2.weight");
                    if (obj6 == null) {
                    } else {
                        this.d = f.l((a)obj6);
                        Object obj7 = map.get("convs.0.bias");
                        if (obj7 == null) {
                        } else {
                            this.e = (a)obj7;
                            Object obj8 = map.get("convs.1.bias");
                            if (obj8 == null) {
                            } else {
                                this.f = (a)obj8;
                                Object obj9 = map.get("convs.2.bias");
                                if (obj9 == null) {
                                } else {
                                    this.g = (a)obj9;
                                    Object obj10 = map.get("fc1.weight");
                                    if (obj10 == null) {
                                    } else {
                                        this.h = f.k((a)obj10);
                                        Object obj11 = map.get("fc2.weight");
                                        if (obj11 == null) {
                                        } else {
                                            this.i = f.k((a)obj11);
                                            Object obj12 = map.get("fc1.bias");
                                            if (obj12 == null) {
                                            } else {
                                                this.j = (a)obj12;
                                                Object obj13 = map.get("fc2.bias");
                                                if (obj13 == null) {
                                                } else {
                                                    this.k = (a)obj13;
                                                    HashMap hashMap = new HashMap();
                                                    this.l = hashMap;
                                                    String[] strArr = new String[2];
                                                    Iterator iterator = q0.g(d.a.MTML_INTEGRITY_DETECT.toKey(), d.a.MTML_APP_EVENT_PREDICTION.toKey()).iterator();
                                                    while (iterator.hasNext()) {
                                                        Object next2 = iterator.next();
                                                        StringBuilder stringBuilder = new StringBuilder();
                                                        stringBuilder.append((String)next2);
                                                        stringBuilder.append(".weight");
                                                        string = stringBuilder.toString();
                                                        StringBuilder stringBuilder2 = new StringBuilder();
                                                        stringBuilder2.append(next2);
                                                        stringBuilder2.append(".bias");
                                                        string2 = stringBuilder2.toString();
                                                        obj2 = map.get(string);
                                                        obj = map.get(string2);
                                                        if ((a)obj2 != null) {
                                                        }
                                                        if ((a)obj != null) {
                                                        }
                                                        this.l.put(string2, (a)obj);
                                                        this.l.put(string, f.k((a)obj2));
                                                    }
                                                }
                                                obj7 = new IllegalStateException(str12.toString());
                                                throw obj7;
                                            }
                                            obj7 = new IllegalStateException(str12.toString());
                                            throw obj7;
                                        }
                                        obj7 = new IllegalStateException(str12.toString());
                                        throw obj7;
                                    }
                                    obj7 = new IllegalStateException(str12.toString());
                                    throw obj7;
                                }
                                obj7 = new IllegalStateException(str12.toString());
                                throw obj7;
                            }
                            obj7 = new IllegalStateException(str12.toString());
                            throw obj7;
                        }
                        obj7 = new IllegalStateException(str12.toString());
                        throw obj7;
                    }
                    obj7 = new IllegalStateException(str12.toString());
                    throw obj7;
                }
                obj7 = new IllegalStateException(str12.toString());
                throw obj7;
            }
            obj7 = new IllegalStateException(str12.toString());
            throw obj7;
        }
        obj7 = new IllegalStateException(str12.toString());
        throw obj7;
    }

    public b(Map map, g g2) {
        super(map);
    }

    public static final Map a() {
        if (a.d(b.class)) {
            return null;
        }
        return b.m;
    }

    public final com.facebook.e0.w.a b(com.facebook.e0.w.a a, String[] string2Arr2, String string3) {
        final int i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        n.f(a, "dense");
        n.f(string2Arr2, "texts");
        n.f(string3, "task");
        com.facebook.e0.w.a obj9 = f.c(f.e(string2Arr2, 128, this.a), this.b);
        f.a(obj9, this.e);
        f.i(obj9);
        com.facebook.e0.w.a aVar4 = f.c(obj9, this.c);
        f.a(aVar4, this.f);
        f.i(aVar4);
        int i3 = 2;
        com.facebook.e0.w.a aVar5 = f.g(aVar4, i3);
        com.facebook.e0.w.a aVar12 = f.c(aVar5, this.d);
        f.a(aVar12, this.g);
        f.i(aVar12);
        int i4 = 1;
        obj9 = f.g(obj9, obj9.b(i4));
        com.facebook.e0.w.a aVar6 = f.g(aVar5, aVar5.b(i4));
        com.facebook.e0.w.a aVar13 = f.g(aVar12, aVar12.b(i4));
        f.f(obj9, i4);
        f.f(aVar6, i4);
        f.f(aVar13, i4);
        com.facebook.e0.w.a[] arr = new a[4];
        arr[i4] = aVar6;
        arr[i3] = aVar13;
        arr[3] = a;
        com.facebook.e0.w.a obj8 = f.d(f.b(arr), this.h, this.j);
        f.i(obj8);
        obj8 = f.d(obj8, this.i, this.k);
        f.i(obj8);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(".weight");
        obj9 = this.l.get(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string3);
        stringBuilder2.append(".bias");
        Object obj10 = this.l.get(stringBuilder2.toString());
        if ((a)obj9 != null && (a)obj10 == null) {
            if ((a)obj10 == null) {
            }
            obj8 = f.d(obj8, (a)obj9, (a)obj10);
            f.j(obj8);
            return obj8;
        }
        return i2;
    }
}
