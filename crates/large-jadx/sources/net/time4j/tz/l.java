package net.time4j.tz;

import android.util.TimeUtils;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.a;
import net.time4j.f1.d;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* compiled from: Timezone.java */
/* loaded from: classes3.dex */
public abstract class l implements Serializable {

    private static volatile boolean A;
    private static int B;
    private static final Map<String, k> C;
    private static final Map<String, k> D;
    private static final r E = new l$d(0);
    private static final r F;
    private static final ConcurrentMap<String, l.c> G = new ConcurrentHashMap<>();
    private static final ReferenceQueue<l> H = new ReferenceQueue<>();
    private static final LinkedList<l> I = new LinkedList<>();
    private static final ConcurrentMap<String, r> J = new ConcurrentHashMap<>();
    static final s K;
    private static final l L;
    private static final String a;
    private static final Comparator<k> b = new l$a<>();
    public static final o c;
    public static final o v;
    private static final boolean w = false;
    private static final boolean x = true;
    private static volatile l.e y;
    private static volatile l z;

    static class a implements Comparator<k> {
        a() {
            super();
        }

        public int a(k kVar, k kVar2) {
            return kVar.a().compareTo(kVar2.a());
        }
    }

    public static class b {
        public static void a() {
            Class<net.time4j.tz.l> obj2 = l.class;
            synchronized (obj2) {
                while (l.H.poll() != null) {
                    try {
                        while (l.H.poll() != null) {
                            try {
                                while (l.H.poll() != null) {
                                    try {
                                        while (l.H.poll() != null) {
                                            try {
                                                while (l.H.poll() != null) {
                                                    try {
                                                        while (l.H.poll() != null) {
                                                            try {
                                                                while (l.H.poll() != null) {
                                                                    try {
                                                                        while (l.H.poll() != null) {
                                                                            try {
                                                                                while (l.H.poll() != null) {
                                                                                    try {
                                                                                        while (l.H.poll() != null) {
                                                                                            try {
                                                                                                while (l.H.poll() != null) {
                                                                                                    try {
                                                                                                        while (l.H.poll() != null) {
                                                                                                            try {
                                                                                                                while (l.H.poll() != null) {
                                                                                                                    try {
                                                                                                                        while (l.H.poll() != null) {
                                                                                                                            try {
                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                    try {
                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                            try {
                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                    try {
                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                            try {
                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                    try {
                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                            try {
                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                    try {
                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                            try {
                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                                                                while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                                                                                        while (l.H.poll() != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                                                                                /* DEPTH_LIMIT_EXCEEDED: Region nesting too deep */
                                                                                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                                                /* DEPTH_LIMIT_EXCEEDED: Region nesting too deep */
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                                l.I.clear();
                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                        l.I.clear();
                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                                l.I.clear();
                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                        l.I.clear();
                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                l.I.clear();
                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        l.I.clear();
                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                l.I.clear();
                                                                                                                                            } catch (Throwable th) {
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        l.I.clear();
                                                                                                                                    } catch (Throwable th) {
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                l.I.clear();
                                                                                                                            } catch (Throwable th) {
                                                                                                                            }
                                                                                                                        }
                                                                                                                        l.I.clear();
                                                                                                                    } catch (Throwable th) {
                                                                                                                    }
                                                                                                                }
                                                                                                                l.I.clear();
                                                                                                            } catch (Throwable th) {
                                                                                                            }
                                                                                                        }
                                                                                                        l.I.clear();
                                                                                                    } catch (Throwable th) {
                                                                                                    }
                                                                                                }
                                                                                                l.I.clear();
                                                                                            } catch (Throwable th) {
                                                                                            }
                                                                                        }
                                                                                        l.I.clear();
                                                                                    } catch (Throwable th) {
                                                                                    }
                                                                                }
                                                                                l.I.clear();
                                                                            } catch (Throwable th) {
                                                                            }
                                                                        }
                                                                        l.I.clear();
                                                                    } catch (Throwable th) {
                                                                    }
                                                                }
                                                                l.I.clear();
                                                            } catch (Throwable th) {
                                                            }
                                                        }
                                                        l.I.clear();
                                                    } catch (Throwable th) {
                                                    }
                                                }
                                                l.I.clear();
                                            } catch (Throwable th) {
                                            }
                                        }
                                        l.I.clear();
                                    } catch (Throwable th) {
                                    }
                                }
                                l.I.clear();
                            } catch (Throwable th) {
                            }
                        }
                        l.I.clear();
                    } catch (Throwable th) {
                    }
                }
            }
            l.y = new l.e();
            l.G.clear();
            if (l.x) {
                l.z = l.v();
            }
        }
    }

    private static class c extends SoftReference<l> {

        private final String a;
        c(ReferenceQueue<l> referenceQueue) {
            super(lVar, referenceQueue);
            this.a = lVar.z().a();
        }

        static /* synthetic */ String a(l.c cVar) {
            return cVar.a;
        }
    }

    private static class e {

        private final List<k> a;
        private final List<k> b;
        e() {
            net.time4j.tz.r rVar2;
            boolean contains;
            super();
            int i = 1024;
            ArrayList arrayList = new ArrayList(i);
            final ArrayList arrayList2 = new ArrayList(i);
            arrayList.add(p.C);
            Iterator it2 = l.J.entrySet().iterator();
            while (it2.hasNext()) {
                Object value = (Map.Entry)it2.next().getValue();
            }
            Collections.sort(arrayList, l.b);
            Collections.sort(arrayList2, l.b);
            this.a = Collections.unmodifiableList(arrayList);
            this.b = Collections.unmodifiableList(arrayList2);
        }

        static /* synthetic */ List a(l.e eVar) {
            return eVar.a;
        }

        static /* synthetic */ List b(l.e eVar) {
            return eVar.b;
        }
    }

    private static class d implements r, s {
        private d() {
            super();
        }

        public String a(String str, d dVar, Locale locale) {
            Objects.requireNonNull(locale, "Missing locale.");
            final String str3 = "";
            if (str.isEmpty()) {
                return str3;
            }
            TimeZone timeZone = h.R(str);
            if (timeZone.getID().equals(str)) {
                return timeZone.getDisplayName(dVar.isDaylightSaving(), !dVar.isAbbreviation(), locale);
            }
            return str3;
        }

        public Set<String> b() {
            final HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(TimeZone.getAvailableIDs()));
            return hashSet;
        }

        public Map<String, String> e() {
            return Collections.emptyMap();
        }

        public Set<String> f(Locale locale, boolean z) {
            return Collections.emptySet();
        }

        public String getVersion() {
            return TimeUtils.getTimeZoneDatabaseVersion();
        }

        /* synthetic */ d(l.a aVar) {
            this();
        }

        public String c() {
            return "";
        }

        public s d() {
            return this;
        }

        public String g(boolean z, Locale locale) {
            String str;
            z = z ? "GMT" : "GMT±hh:mm";
            return (z ? "GMT" : "GMT±hh:mm");
        }

        public String getLocation() {
            return "";
        }

        public String getName() {
            return "java.util.TimeZone";
        }

        public m h(String str) {
            return null;
        }
    }
    static {
        List property3;
        List list;
        Object obj4;
        Object obj;
        net.time4j.tz.s sVar;
        String length;
        String name;
        String str;
        String str2;
        System.getProperty("line.separator");
        l.a = System.getProperty("net.time4j.tz.repository.version");
        net.time4j.tz.g lATER_OFFSET2 = g.LATER_OFFSET;
        l.c = b.PUSH_FORWARD.and(lATER_OFFSET2);
        l.v = b.ABORT.and(lATER_OFFSET2);
        boolean equalsIgnoreCase = "Dalvik".equalsIgnoreCase(System.getProperty("java.vm.name"));
        l.w = equalsIgnoreCase;
        if (!equalsIgnoreCase) {
            if (Boolean.getBoolean("net.time4j.allow.system.tz.override")) {
                net.time4j.tz.l.e item = null;
                l.y = item;
                l.z = item;
                l.A = true;
                l.B = 11;
                try {
                    name = "AMERICA$NORTH_DAKOTA";
                    str = "ANTARCTICA";
                    str2 = "ASIA";
                    list = l.L(l.class.getClassLoader(), "AFRICA", "AMERICA", "AMERICA$ARGENTINA", "AMERICA$INDIANA", "AMERICA$KENTUCKY", name, str, str2, "ATLANTIC", "AUSTRALIA", "EUROPE", "INDIAN", "PACIFIC");
                } catch (java.lang.SecurityException unused) {
                }
                HashMap hashMap2 = new HashMap();
                pVar = p.C;
                hashMap2.put("Z", pVar);
                hashMap2.put("UT", pVar);
                hashMap2.put("UTC", pVar);
                hashMap2.put("GMT", pVar);
                hashMap2.put("UTC0", pVar);
                length = "GMT0";
                hashMap2.put(length, pVar);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object[] enumConstants = (Class)it.next().getEnumConstants();
                    length = enumConstants.length;
                    int i4 = 0;
                    for (String str : enumConstants) {
                        hashMap2.put(str.a(), str);
                    }
                    str = enumConstants[name];
                    hashMap2.put(str.a(), str);
                    name = name + 1;
                }
                l.C = Collections.unmodifiableMap(hashMap2);
                HashMap hashMap = new HashMap();
                l.s(hashMap);
                l.D = Collections.unmodifiableMap(hashMap);
                Iterator it2 = d.c().g(r.class).iterator();
                while (it2.hasNext()) {
                    Object item2 = it2.next();
                    name = item2.getName();
                }
                Iterator it3 = d.c().g(s.class).iterator();
                while (true) {
                    item = it3.next();
                }
            }
        }
    }

    l() {
        super();
    }

    public static Set<k> C(Locale locale, boolean z, String str) {
        net.time4j.tz.s sVar;
        net.time4j.tz.r rVar = l.D(str);
        if (rVar == null) {
            return Collections.emptySet();
        }
        if (rVar.d() == null) {
            sVar = l.K;
        }
        final HashSet hashSet = new HashSet();
        Iterator it = sVar.f(locale, z).iterator();
        while (it.hasNext()) {
            hashSet.add(l.P((String)it.next()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static r D(String str) {
        Object value;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Missing zone model provider.");
        } else {
            if (str.equals("DEFAULT")) {
                net.time4j.tz.r rVar = l.F;
            } else {
                value = l.J.get(str);
            }
            return value;
        }
    }

    private static l F(k kVar, String str, boolean z) {
        String substring;
        net.time4j.tz.h hVar;
        String substring2;
        int i;
        int i2 = 0;
        net.time4j.tz.r rVar;
        char charAt;
        boolean equals;
        char c = 126;
        net.time4j.tz.e eVar;
        boolean startsWith;
        ConcurrentMap concurrentMap = l.G;
        Object value = concurrentMap.get(str);
        i = 0;
        if (value == null) {
        } else {
            if ((l)value.get() == null) {
                l.G.remove(value.a);
            }
        }
        if (i != 0) {
            return i;
        }
        substring = "";
        i2 = 0;
        i2 = 1;
        while (i2 < str.length()) {
            c = '~';
            if (str.charAt(i2) == '~') {
                break;
            }
        }
        Object str22 = str;
        if (substring2.isEmpty()) {
            if (z) {
                throw new IllegalArgumentException("Timezone key is empty.");
            } else {
                return null;
            }
        }
        rVar = l.F;
        if (!substring.isEmpty()) {
            if (substring.equals("DEFAULT")) {
            }
        }
        if (i2 == 0 && l.J.get(l.G) == null) {
            if (z) {
                kVar = substring.equals("TZDB") ? "TZDB provider not available: " : "Timezone model provider not registered: ";
                StringBuilder stringBuilder = new StringBuilder();
                kVar = kVar + str;
                throw new IllegalArgumentException((substring.equals("TZDB") ? "TZDB provider not available: " : "Timezone model provider not registered: ") + str);
            }
            return i;
        }
        if (kVar == null) {
            if (i2 != 0) {
                net.time4j.tz.k kVar3 = l.P(substring2);
                if (kVar3 instanceof p) {
                    return kVar3.p();
                }
            } else {
                eVar = new e(str);
            }
        }
        if (l.J == l.E) {
            hVar = new h(eVar, substring2);
            if (hVar.T()) {
                if (!substring2.equals("GMT")) {
                    if (!substring2.startsWith("UT")) {
                        if (substring2.equals("Z")) {
                        }
                    }
                }
            }
        } else {
            net.time4j.tz.m mVar = rVar.h(substring2);
            if (mVar == null) {
                net.time4j.tz.l lVar = l.H(rVar, eVar, substring2);
            } else {
                net.time4j.tz.c cVar2 = new c(eVar, mVar);
            }
        }
        if (hVar == null && !z) {
            return i;
        }
        if (l.A) {
            Object ifAbsent = l.G.putIfAbsent(str, new l.c(hVar, l.H));
            if (ifAbsent == null) {
                obj = l.class;
                synchronized (obj) {
                    try {
                        l.I.addFirst(hVar);
                        LinkedList list = l.I;
                        while (list.size() >= l.B) {
                            l.I.removeLast();
                            list = l.I;
                        }
                    } catch (Throwable th) {
                    }
                }
            } else {
                Object kVar2 = ifAbsent.get();
                if (kVar2 != null) {
                }
            }
        }
        return hVar;
    }

    private static l G(k kVar, boolean z) {
        if (kVar instanceof p) {
            return kVar.p();
        }
        return l.F(kVar, kVar.a(), z);
    }

    private static l H(r rVar, k kVar, String str) {
        net.time4j.tz.m mVar;
        String str32;
        int i = 0;
        str32 = str;
        while (mVar == null) {
            str32 = rVar.e().get(str32);
        }
        if (mVar == null) {
            str = rVar.c();
            if (str.isEmpty()) {
                return i;
            }
            if (str.equals(rVar.getName())) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str2 = "Circular zone model provider fallback: ";
                String name2 = rVar.getName();
                rVar = str2 + name2;
                throw new IllegalArgumentException(rVar);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "~";
                str5 = str + str4 + str;
                return new a(kVar, l.M(str5));
            }
        }
        return new c(kVar, mVar);
    }

    private static List<Class<? extends k>> L(java.lang.ClassLoader classLoader, String... strArr) throws java.lang.ClassNotFoundException {
        int i = 0;
        final ArrayList arrayList = new ArrayList();
        i = 0;
        for (Object obj : strArr) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "net.time4j.tz.olson.";
            str2 = str + obj;
            Class cls = Class.forName(str2, true, classLoader);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static l M(String str) {
        return l.F(null, str, true);
    }

    public static l N(k kVar) {
        return l.G(kVar, true);
    }

    public static l O() {
        if (l.x && l.z != null) {
            return l.z;
        }
        return l.L;
    }

    private static k P(String str) {
        Object value;
        int i = 3;
        String str2;
        if ((k)l.C.get(str) == null) {
            if (str.startsWith("GMT")) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "UTC";
                i = 3;
                String substring = str.substring(i);
                str2 = str4 + substring;
            }
            if (p.x(str2, false) == null) {
                net.time4j.tz.e eVar = new e(str2);
            }
        }
        return value;
    }

    static /* synthetic */ l f() {
        return l.v();
    }

    static /* synthetic */ ConcurrentMap g() {
        return l.J;
    }

    static /* synthetic */ r h() {
        return l.E;
    }

    static /* synthetic */ r i() {
        return l.F;
    }

    static /* synthetic */ k j(String str) {
        return l.P(str);
    }

    static /* synthetic */ Comparator k() {
        return l.b;
    }

    static /* synthetic */ ReferenceQueue l() {
        return l.H;
    }

    static /* synthetic */ LinkedList m() {
        return l.I;
    }

    static /* synthetic */ l.e n(l.e eVar) {
        l.y = eVar;
        return eVar;
    }

    static /* synthetic */ ConcurrentMap o() {
        return l.G;
    }

    static /* synthetic */ boolean p() {
        return l.x;
    }

    static /* synthetic */ l q(l lVar) {
        l.z = lVar;
        return lVar;
    }

    private static r r(r rVar, r rVar2) {
        String version;
        boolean empty;
        boolean equals;
        Object obj;
        version = rVar.getVersion();
        if (!version.isEmpty()) {
            String str = l.a;
            if (!(version.equals(str))) {
                if (l.a != null || rVar2 != null) {
                    obj = rVar2;
                }
            }
        }
        return obj;
    }

    private static void s(Map<String, k> map) {
        net.time4j.tz.p pVar = p.C;
        map.put("Etc/GMT", pVar);
        map.put("Etc/Greenwich", pVar);
        map.put("Etc/Universal", pVar);
        map.put("Etc/Zulu", pVar);
        map.put("Etc/GMT+0", pVar);
        map.put("Etc/GMT-0", pVar);
        map.put("Etc/GMT0", pVar);
        map.put("Etc/UTC", pVar);
        map.put("Etc/UCT", pVar);
        map.put("Etc/GMT-14", p.u(50400));
        map.put("Etc/GMT-13", p.u(46800));
        map.put("Etc/GMT-12", p.u(43200));
        map.put("Etc/GMT-11", p.u(39600));
        map.put("Etc/GMT-10", p.u(36000));
        map.put("Etc/GMT-9", p.u(32400));
        map.put("Etc/GMT-8", p.u(28800));
        map.put("Etc/GMT-7", p.u(25200));
        map.put("Etc/GMT-6", p.u(21600));
        map.put("Etc/GMT-5", p.u(18000));
        map.put("Etc/GMT-4", p.u(14400));
        map.put("Etc/GMT-3", p.u(10800));
        map.put("Etc/GMT-2", p.u(7200));
        map.put("Etc/GMT-1", p.u(3600));
        map.put("Etc/GMT+1", p.u(-3600));
        map.put("Etc/GMT+2", p.u(-7200));
        map.put("Etc/GMT+3", p.u(-10800));
        map.put("Etc/GMT+4", p.u(-14400));
        map.put("Etc/GMT+5", p.u(-18000));
        map.put("Etc/GMT+6", p.u(-21600));
        map.put("Etc/GMT+7", p.u(-25200));
        map.put("Etc/GMT+8", p.u(-28800));
        map.put("Etc/GMT+9", p.u(-32400));
        map.put("Etc/GMT+10", p.u(-36000));
        map.put("Etc/GMT+11", p.u(-39600));
        map.put("Etc/GMT+12", p.u(-43200));
    }

    public static List<k> t() {
        return l.y.a;
    }

    public static List<k> u(String str) {
        if (str.equals("INCLUDE_ALIAS")) {
            return l.y.b;
        }
        net.time4j.tz.r rVar = l.D(str);
        if (rVar == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = rVar.b().iterator();
        while (it.hasNext()) {
            arrayList.add(l.P((String)it.next()));
        }
        Collections.sort(arrayList, l.b);
        return Collections.unmodifiableList(arrayList);
    }

    private static l v() {
        net.time4j.tz.l lVar;
        String iD = TimeZone.getDefault().getID();
        boolean z = false;
        if (l.F(null, iD, z) == null) {
            net.time4j.tz.h hVar = new h(new e(iD));
        }
        return lVar;
    }

    public static String x(k kVar, d dVar, Locale locale) {
        String kVar2;
        net.time4j.tz.r rVar;
        net.time4j.tz.s sVar;
        kVar2 = kVar.a();
        int indexOf = kVar2.indexOf(126);
        rVar = l.F;
        if (indexOf >= 0) {
            String substring = kVar2.substring(0, indexOf);
            if (!substring.equals("DEFAULT") && l.J.get(substring) == null) {
                return kVar2;
            }
            kVar2 = kVar2.substring(indexOf + 1);
        } else {
        }
        if (rVar.d() == null) {
            sVar = l.K;
        }
        if (sVar.a(kVar2, dVar, locale).isEmpty() && l.F != l.K) {
            kVar2 = l.K.a(kVar2, dVar, locale);
            if (!(kVar2.isEmpty())) {
            }
        }
        return kVar2;
    }

    public String w(d dVar, Locale locale) {
        return l.x(z(), dVar, locale);
    }

    public abstract p A(a aVar, g gVar);

    public abstract p B(f fVar);

    public abstract o E();

    public abstract boolean I(f fVar);

    public abstract boolean J();

    public abstract boolean K(a aVar, g gVar);

    public abstract l Q(o oVar);

    public abstract m y();

    public abstract k z();
}
