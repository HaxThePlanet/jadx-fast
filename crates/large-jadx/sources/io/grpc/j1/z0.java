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

/* loaded from: classes3.dex */
final class z0 implements io.grpc.j1.c0.g {

    private static final Throwable a;

    interface c {
        public abstract List<String> a(String string, String string2);
    }

    static final class a implements io.grpc.j1.z0.c {
        static {
        }

        private static void b() {
            if (z0.c() != null) {
            } else {
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("JNDI is not currently available", z0.c());
            throw unsupportedOperationException;
        }

        private static void c(NamingEnumeration<?> namingEnumeration, NamingException namingException2) {
            try {
                namingEnumeration.close();
                throw namingException2;
            }
        }

        private static void d(DirContext dirContext, NamingException namingException2) {
            try {
                dirContext.close();
                throw namingException2;
            }
        }

        public List<String> a(String string, String string2) {
            String[] strArr;
            String valueOf;
            z0.a.b();
            strArr = new String[1];
            ArrayList obj5 = new ArrayList();
            Hashtable hashtable = new Hashtable();
            valueOf = "5000";
            hashtable.put("com.sun.jndi.ldap.connect.timeout", valueOf);
            hashtable.put("com.sun.jndi.ldap.read.timeout", valueOf);
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            int i3 = 0;
            NamingEnumeration obj6 = initialDirContext.getAttributes(string2, string).getAll();
            while (obj6.hasMore()) {
                strArr = (Attribute)obj6.next().getAll();
                while (strArr.hasMore() != null) {
                    obj5.add(String.valueOf(strArr.next()));
                }
                strArr.close();
                obj5.add(String.valueOf(strArr.next()));
            }
            obj6.close();
            initialDirContext.close();
            return obj5;
        }
    }

    static final class b implements io.grpc.j1.c0.f {

        private static final Logger b;
        private final io.grpc.j1.z0.c a;
        static {
            z0.b.b = Logger.getLogger(z0.b.class.getName());
            Pattern.compile("\\s+");
        }

        public b(io.grpc.j1.z0.c z0$c) {
            super();
            this.a = c;
        }

        static String b(String string) {
            int i3;
            int i;
            char charAt;
            int i2;
            int i5;
            int i4;
            StringBuilder stringBuilder = new StringBuilder(string.length());
            int i6 = 0;
            i = i3;
            while (i3 < string.length()) {
                charAt = string.charAt(i3);
                i2 = 34;
                i5 = 1;
                if (i == 0) {
                } else {
                }
                if (charAt == i2) {
                } else {
                }
                if (charAt == 92) {
                }
                stringBuilder.append(charAt);
                i3 += i5;
                charAt = string.charAt(i3++);
                i = i6;
                if (charAt == 32) {
                } else {
                }
                if (charAt == i2) {
                } else {
                }
                i = i5;
            }
            return stringBuilder.toString();
        }

        public List<String> a(String string) {
            int size;
            boolean loggable2;
            boolean loggable;
            int str2;
            int valueOf;
            String str;
            Logger logger = z0.b.b;
            Level fINER = Level.FINER;
            str2 = 0;
            valueOf = 1;
            if (logger.isLoggable(fINER)) {
                loggable2 = new Object[valueOf];
                loggable2[str2] = string;
                logger.log(fINER, "About to query TXT records for {0}", loggable2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("dns:///");
            stringBuilder.append(string);
            List obj8 = this.a.a("TXT", stringBuilder.toString());
            if (logger.isLoggable(fINER)) {
                loggable = new Object[valueOf];
                loggable[str2] = Integer.valueOf(obj8.size());
                logger.log(fINER, "Found {0} TXT records", loggable);
            }
            ArrayList arrayList = new ArrayList(obj8.size());
            obj8 = obj8.iterator();
            for (String next2 : obj8) {
                arrayList.add(z0.b.b(next2));
            }
            return Collections.unmodifiableList(arrayList);
        }
    }
    static {
        z0.a = z0.d();
    }

    static Throwable c() {
        return z0.a;
    }

    private static Throwable d() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
            return th;
            return th;
            return th;
        }
    }

    @Override // io.grpc.j1.c0$g
    public io.grpc.j1.c0.f a() {
        if (b() != null) {
            return null;
        }
        z0.a aVar = new z0.a();
        z0.b bVar = new z0.b(aVar);
        return bVar;
    }

    @Override // io.grpc.j1.c0$g
    public Throwable b() {
        return z0.a;
    }
}
