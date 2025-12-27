package io.grpc.j1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/* compiled from: JndiResourceResolverFactory.java */
/* loaded from: classes3.dex */
final class z0 implements c0.g {

    private static final Throwable a;

    interface c {
        List<String> a(String str, String str2);
    }

    static final class a implements z0.c {
        a() {
            super();
        }

        private static void b() {
            if (z0.a != null) {
                throw new UnsupportedOperationException("JNDI is not currently available", z0.a);
            }
        }

        private static void c(NamingEnumeration<?> namingEnumeration, NamingException exc) {
            try {
                namingEnumeration.close();
            } catch (javax.naming.NamingException unused) {
                throw exc;
            }
        }

        private static void d(DirContext dirContext, NamingException exc) {
            try {
                dirContext.close();
            } catch (javax.naming.NamingException unused) {
                throw exc;
            }
        }

        public List<String> a(String str, String str2) throws Hashtable {
            String str3;
            z0.a.b();
            String[] strArr = new String[1];
            final ArrayList arrayList = new ArrayList();
            Hashtable hashtable = new Hashtable();
            str3 = "5000";
            hashtable.put("com.sun.jndi.ldap.connect.timeout", str3);
            hashtable.put("com.sun.jndi.ldap.read.timeout", str3);
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            try {
                NamingEnumeration all2 = initialDirContext.getAttributes(str2, new String[] { str }).getAll();
            } catch (javax.naming.NamingException naming) {
            }
            while (all2.hasMore()) {
                NamingEnumeration all = (Attribute)all2.next().getAll();
                while (all.hasMore()) {
                    arrayList.add(String.valueOf(all.next()));
                    try {
                        arrayList.add(String.valueOf(all.next()));
                    } catch (javax.naming.NamingException unused) {
                    }
                }
                try {
                    all.close();
                    z0.a.c(namingEnumeration, naming);
                } catch (javax.naming.NamingException naming) {
                }
                try {
                    all = (Attribute)all2.next().getAll();
                } catch (javax.naming.NamingException naming) {
                }
                arrayList.add(String.valueOf(all.next()));
            }
            try {
                all2.close();
            } catch (javax.naming.NamingException naming) {
            }
            initialDirContext.close();
            return arrayList;
        }

    }

    static final class b implements c0.f {

        private static final Logger b;
        private final z0.c a;
        static {
            z0.b.b = Logger.getLogger(z0.b.class.getName());
            Pattern.compile("\\s+");
        }

        public b(z0.c cVar) {
            super();
            this.a = cVar;
        }

        static String b(String str) {
            int i;
            char charAt;
            char c = 92;
            char c2;
            final StringBuilder stringBuilder = new StringBuilder(str.length());
            i = 0;
            while (i < str.length()) {
                charAt = str.charAt(i);
                c = '"';
                i = 1;
                i = i + i;
            }
            return stringBuilder.toString();
        }

        public List<String> a(String str) {
            Logger logger = z0.b.b;
            Level fINER2 = Level.FINER;
            int i = 0;
            int i2 = 1;
            if (logger.isLoggable(fINER2)) {
                Object[] arr2 = new Object[i2];
                str2 = "About to query TXT records for {0}";
                z0.b.b.log(Level.FINER, str2, new Object[] { str });
            }
            StringBuilder stringBuilder = new StringBuilder();
            final String str6 = "dns:///";
            str7 = str6 + str;
            List list = this.a.a("TXT", str7);
            if (z0.b.b.isLoggable(Level.FINER)) {
                Object[] arr = new Object[i2];
                z0.b.b.log(Level.FINER, "Found {0} TXT records", new Object[] { Integer.valueOf(list.size()) });
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(z0.b.b((String)it.next()));
            }
            return Collections.unmodifiableList(arrayList);
        }
    }
    static {
        z0.a = z0.d();
    }

    static /* synthetic */ Throwable c() {
        return z0.a;
    }

    private static Throwable d() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
        } catch (Error e) {
            return e;
        } catch (RuntimeException e1) {
            return e1;
        } catch (java.lang.ClassNotFoundException classNotFound2) {
            return classNotFound2;
        }
        return null;
    }

    public c0.f a() {
        if (b() != null) {
            return null;
        }
        return new z0.b(new z0.a());
    }

    public Throwable b() {
        return z0.a;
    }
}
