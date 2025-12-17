package okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.io.b;
import kotlin.j0.i;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.p;
import l.h;
import l.n;
import l.q;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0012\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\u0008\u001c\u0010\u000cJ\u001d\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J#\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00042\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\u0008\r\u0010\u000cJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u001b¨\u0006\u001e", d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "", "domain", "", "splitDomain", "(Ljava/lang/String;)Ljava/util/List;", "domainLabels", "findMatchingRule", "(Ljava/util/List;)Ljava/util/List;", "Lkotlin/w;", "readTheListUninterruptibly", "()V", "readTheList", "getEffectiveTldPlusOne", "(Ljava/lang/String;)Ljava/lang/String;", "", "publicSuffixListBytes", "publicSuffixExceptionListBytes", "setListBytes", "([B[B)V", "[B", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class PublicSuffixDatabase {

    public static final okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion Companion = null;
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE = null;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final byte[] WILDCARD_LABEL;
    private static final okhttp3.internal.publicsuffix.PublicSuffixDatabase instance;
    private final AtomicBoolean listRead;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private final CountDownLatch readCompleteLatch;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0019\u0010\u001aJ+\u0010\u0008\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0018¨\u0006\u001b", d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "", "", "labels", "", "labelIndex", "", "binarySearch", "([B[[BI)Ljava/lang/String;", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "()Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "EXCEPTION_MARKER", "C", "", "PREVAILING_RULE", "Ljava/util/List;", "PUBLIC_SUFFIX_RESOURCE", "Ljava/lang/String;", "WILDCARD_LABEL", "[B", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static final String access$binarySearch(okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion publicSuffixDatabase$Companion, byte[] b2Arr2, byte[][] b3Arr3Arr3, int i4) {
            return companion.binarySearch(b2Arr2, b3Arr3Arr3, i4);
        }

        private final String binarySearch(byte[] bArr, byte[][] b2Arr2Arr2, int i3) {
            java.nio.charset.Charset uTF_8;
            int length;
            String string;
            int length4;
            int i14;
            int i12;
            int i15;
            int i13;
            int i7;
            int length2;
            int length3;
            int i8;
            int i6;
            int i16;
            int i;
            int i10;
            int i9;
            int i2;
            int i11;
            int i17;
            int i4;
            int i5;
            final byte[] bArr2 = bArr;
            uTF_8 = b2Arr2Arr2;
            length = bArr2.length;
            i14 = 0;
            while (i14 < length) {
                i18 /= 2;
                i13 = 10;
                i7 = -1;
                while (i15 > i7) {
                    if (bArr2[i15] != (byte)i13) {
                    }
                    i15--;
                    i13 = 10;
                    i7 = -1;
                }
                i15++;
                length2 = 1;
                i8 = length2;
                i = i12 + i8;
                while (bArr2[i] != (byte)i13) {
                    i8++;
                    i = i12 + i8;
                }
                i13 = i - i12;
                i10 = i3;
                i6 = 0;
                i9 = 0;
                i2 = 0;
                i11 = 255;
                while (i6 != 0) {
                    i16 = 46;
                    i17 = 0;
                    i16 -= length4;
                    i6 = i17;
                    i11 = 255;
                    i17 = i6;
                    i16 = i5;
                    if (i10 != length5 -= length2) {
                        break loop_10;
                    }
                    i10++;
                    i9 = i7;
                    i6 = length2;
                }
                i17 = i6;
                i16 = i5;
                i16 -= length4;
                if (length3 != 0) {
                } else {
                }
                if (i2++ == i13) {
                } else {
                }
                if (obj.length == i9++) {
                } else {
                }
                i6 = i17;
                if (i10 != length5 -= length2) {
                }
                i10++;
                i9 = i7;
                i6 = length2;
                if (length3 > 0) {
                    break;
                } else {
                }
                length4 = i13 - i2;
                length6 -= i9;
                i10++;
                while (i10 < uTF_8.length) {
                    i7 += length3;
                    i10++;
                }
                i14 = i + 1;
                length = i12;
                i7 += length3;
                i10++;
                i16 = 46;
                i17 = 0;
                i8++;
                if (bArr2[i15] != (byte)i13) {
                }
                i15--;
            }
            string = 0;
            return string;
        }

        public final okhttp3.internal.publicsuffix.PublicSuffixDatabase get() {
            return PublicSuffixDatabase.access$getInstance$cp();
        }
    }
    static {
        PublicSuffixDatabase.Companion companion = new PublicSuffixDatabase.Companion(0);
        PublicSuffixDatabase.Companion = companion;
        byte[] bArr = new byte[1];
        PublicSuffixDatabase.WILDCARD_LABEL = bArr;
        PublicSuffixDatabase.PREVAILING_RULE = p.b("*");
        PublicSuffixDatabase publicSuffixDatabase = new PublicSuffixDatabase();
        PublicSuffixDatabase.instance = publicSuffixDatabase;
    }

    public PublicSuffixDatabase() {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.listRead = atomicBoolean;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.readCompleteLatch = countDownLatch;
    }

    public static final okhttp3.internal.publicsuffix.PublicSuffixDatabase access$getInstance$cp() {
        return PublicSuffixDatabase.instance;
    }

    public static final byte[] access$getPublicSuffixListBytes$p(okhttp3.internal.publicsuffix.PublicSuffixDatabase publicSuffixDatabase) {
        byte[] obj0 = publicSuffixDatabase.publicSuffixListBytes;
        if (obj0 == null) {
        } else {
            return obj0;
        }
        n.w("publicSuffixListBytes");
        throw 0;
    }

    public static final void access$setPublicSuffixListBytes$p(okhttp3.internal.publicsuffix.PublicSuffixDatabase publicSuffixDatabase, byte[] b2Arr2) {
        publicSuffixDatabase.publicSuffixListBytes = b2Arr2;
    }

    private final List<String> findMatchingRule(List<String> list) {
        boolean readCompleteLatch;
        int i7;
        int size;
        List i8;
        List bArr;
        int i5;
        int clone;
        int i;
        String str2;
        byte[] cArr;
        String str;
        String publicSuffixListBytes2;
        int publicSuffixExceptionListBytes;
        String str3;
        byte[] publicSuffixListBytes;
        int i6;
        int i4;
        int i3;
        int i2;
        final Object obj = this;
        int i9 = 0;
        int i10 = 1;
        if (!obj.listRead.get() && obj.listRead.compareAndSet(i9, i10)) {
            if (obj.listRead.compareAndSet(i9, i10)) {
                readTheListUninterruptibly();
            } else {
                obj.readCompleteLatch.await();
            }
        } else {
        }
        i7 = obj.publicSuffixListBytes != null ? i10 : i9;
        if (i7 == 0) {
        } else {
            size = list.size();
            bArr = new byte[size];
            i5 = i9;
            while (i5 < size) {
                Object obj2 = list.get(i5);
                java.nio.charset.Charset uTF_8 = StandardCharsets.UTF_8;
                n.e(uTF_8, "UTF_8");
                Objects.requireNonNull((String)obj2, "null cannot be cast to non-null type java.lang.String");
                cArr = obj2.getBytes(uTF_8);
                n.e(cArr, "(this as java.lang.String).getBytes(charset)");
                bArr[i5] = cArr;
                i5++;
            }
            clone = i9;
            str2 = "publicSuffixListBytes";
            cArr = 0;
            while (clone < size) {
                publicSuffixListBytes2 = obj.publicSuffixListBytes;
                clone++;
                str2 = "publicSuffixListBytes";
                cArr = 0;
            }
            str = cArr;
            if (size > i10) {
                clone = bArr.clone();
                publicSuffixExceptionListBytes = i9;
                while (publicSuffixExceptionListBytes < length -= i10) {
                    (byte[][])clone[publicSuffixExceptionListBytes] = PublicSuffixDatabase.WILDCARD_LABEL;
                    publicSuffixListBytes = obj.publicSuffixListBytes;
                    str3 = PublicSuffixDatabase.Companion.access$binarySearch(PublicSuffixDatabase.Companion, publicSuffixListBytes, clone, publicSuffixExceptionListBytes);
                    publicSuffixExceptionListBytes++;
                }
            }
            i = cArr;
            if (i != 0) {
                str2 = i9;
                while (str2 < size -= i10) {
                    publicSuffixExceptionListBytes = obj.publicSuffixExceptionListBytes;
                    publicSuffixListBytes2 = PublicSuffixDatabase.Companion.access$binarySearch(PublicSuffixDatabase.Companion, publicSuffixExceptionListBytes, bArr, str2);
                    str2++;
                }
            }
            i8 = 46;
            if (cArr != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('!');
                stringBuilder.append(cArr);
                char[] cArr2 = new char[i10];
                cArr2[i9] = i8;
                return l.D0(stringBuilder.toString(), cArr2, false, 0, 6, 0);
            }
            if (str == null && i == 0) {
                if (i == 0) {
                    return PublicSuffixDatabase.PREVAILING_RULE;
                }
            }
            cArr = new char[i10];
            cArr[i9] = i8;
            if (str != null && l.D0(str, cArr, false, 0, 6, 0) != null) {
                cArr = new char[i10];
                cArr[i9] = i8;
                if (l.D0(str, cArr, false, 0, 6, 0) != null) {
                } else {
                    bArr = p.g();
                }
            } else {
            }
            publicSuffixListBytes = new char[i10];
            publicSuffixListBytes[i9] = i8;
            if (i != 0 && l.D0(i, publicSuffixListBytes, false, 0, 6, 0) != null) {
                publicSuffixListBytes = new char[i10];
                publicSuffixListBytes[i9] = i8;
                if (l.D0(i, publicSuffixListBytes, false, 0, 6, 0) != null) {
                } else {
                    i8 = p.g();
                }
            } else {
            }
            if (bArr.size() > i8.size()) {
            } else {
                bArr = i8;
            }
            return bArr;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        throw illegalStateException;
    }

    private final void readTheList() {
        java.io.InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            n nVar = new n(q.l(resourceAsStream));
            h hVar = q.d(nVar);
            byte[] bArr = hVar.p1((long)int);
            byte[] bArr2 = hVar.p1((long)int2);
            final w wVar = w.a;
            b.a(hVar, 0);
            n.d(bArr);
            this.publicSuffixListBytes = bArr;
            n.d(bArr2);
            this.publicSuffixExceptionListBytes = bArr2;
            this.readCompleteLatch.countDown();
            return;
            synchronized (this) {
                nVar = new n(q.l(resourceAsStream));
                hVar = q.d(nVar);
                bArr = hVar.p1((long)int);
                bArr2 = hVar.p1((long)int2);
                wVar = w.a;
                b.a(hVar, 0);
                n.d(bArr);
                this.publicSuffixListBytes = bArr;
                n.d(bArr2);
                this.publicSuffixExceptionListBytes = bArr2;
                this.readCompleteLatch.countDown();
            }
        }
    }

    private final void readTheListUninterruptibly() {
        int currentThread;
        Throwable th;
        Platform.Companion companion;
        String str;
        int i;
        currentThread = 0;
        try {
            readTheList();
            if (currentThread != 0) {
            }
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
        }
    }

    private final List<String> splitDomain(String string) {
        List obj8;
        final int i = 1;
        char[] cArr = new char[i];
        cArr[0] = 46;
        obj8 = l.D0(string, cArr, false, 0, 6, 0);
        if (n.b((String)p.j0(obj8), "")) {
            obj8 = p.Q(obj8, i);
        }
        return obj8;
    }

    public final String getEffectiveTldPlusOne(String string) {
        int size;
        int size2;
        int charAt;
        n.f(string, "domain");
        String unicode = IDN.toUnicode(string);
        n.e(unicode, "unicodeDomain");
        List splitDomain = splitDomain(unicode);
        List matchingRule = findMatchingRule(splitDomain);
        int i3 = 33;
        int i5 = 0;
        if (splitDomain.size() == matchingRule.size() && (String)matchingRule.get(i5).charAt(i5) != i3) {
            if ((String)matchingRule.get(i5).charAt(i5) != i3) {
                return null;
            }
        }
        if ((String)matchingRule.get(i5).charAt(i5) == i3) {
            size = splitDomain.size();
            size2 = matchingRule.size();
        } else {
            size = splitDomain.size();
            size3++;
        }
        return i.s(i.k(p.M(splitDomain(string)), size -= size2), ".", 0, 0, 0, 0, 0, 62, 0);
    }

    public final void setListBytes(byte[] bArr, byte[] b2Arr2) {
        n.f(bArr, "publicSuffixListBytes");
        n.f(b2Arr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = b2Arr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
