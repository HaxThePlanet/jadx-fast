package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.ProvisionRequest;
import android.text.TextUtils;
import com.google.android.exoplayer2.l2.u.h;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.w0;
import com.google.common.base.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class d0 implements com.google.android.exoplayer2.drm.b0 {

    public static final com.google.android.exoplayer2.drm.b0.c d;
    private final UUID a;
    private final MediaDrm b;
    private int c = 1;
    static {
        d0.d = n.a;
    }

    private d0(UUID uUID) {
        boolean obj4;
        super();
        g.e(uUID);
        g.b(equals ^= i2, "Use C.CLEARKEY_UUID instead");
        this.a = uUID;
        MediaDrm mediaDrm = new MediaDrm(d0.q(uUID));
        this.b = mediaDrm;
        if (w0.d.equals(uUID) && d0.y()) {
            if (d0.y()) {
                d0.s(mediaDrm);
            }
        }
    }

    private static byte[] m(byte[] bArr) {
        int str;
        d0 d0Var = new d0(bArr);
        final short s4 = d0Var.q();
        final short s5 = d0Var.q();
        String str5 = "FrameworkMediaDrm";
        int i7 = 1;
        if (s4 == i7) {
            if (s5 != i7) {
            } else {
                final java.nio.charset.Charset charset = d.d;
                String str2 = d0Var.v(d0Var.q(), charset);
                if (str2.contains("<LA_URL>")) {
                    return bArr;
                }
                int obj7 = str2.indexOf("</DATA>");
                if (obj7 == -1) {
                    v.h(str5, "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                }
            }
            String substring = str2.substring(0, obj7);
            obj7 = str2.substring(obj7);
            StringBuilder stringBuilder = new StringBuilder(i += length3);
            stringBuilder.append(substring);
            stringBuilder.append("<LA_URL>https://x</LA_URL>");
            stringBuilder.append(obj7);
            obj7 = stringBuilder.toString();
            i3 += 52;
            ByteBuffer allocate = ByteBuffer.allocate(i4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i4);
            allocate.putShort((short)s4);
            allocate.putShort((short)s5);
            allocate.putShort((short)i5);
            allocate.put(obj7.getBytes(charset));
            return allocate.array();
        }
        v.f(str5, "Unexpected record count or type. Skipping LA_URL workaround.");
        return bArr;
    }

    private static byte[] n(UUID uUID, byte[] b2Arr2) {
        if (w0.c.equals(uUID)) {
            return r.a(b2Arr2);
        }
        return b2Arr2;
    }

    private static byte[] o(UUID uUID, byte[] b2Arr2) {
        boolean equals2;
        boolean equals;
        int equals3;
        Object obj3;
        byte[] obj4;
        equals2 = w0.e;
        if (equals2.equals(uUID)) {
            equals = h.e(b2Arr2, uUID);
            if (equals == null) {
            } else {
                obj4 = equals;
            }
            obj4 = h.a(equals2, d0.m(obj4));
        }
        if (p0.a < 23) {
            if (!w0.d.equals(uUID)) {
                if (equals2.equals(uUID) && "Amazon".equals(p0.c)) {
                    if ("Amazon".equals(p0.c)) {
                        equals2 = p0.d;
                        if (!"AFTB".equals(equals2) && !"AFTS".equals(equals2) && !"AFTM".equals(equals2)) {
                            if (!"AFTS".equals(equals2)) {
                                if (!"AFTM".equals(equals2)) {
                                    obj3 = h.e(obj4, uUID);
                                    if ("AFTT".equals(equals2) && obj3 != null) {
                                        obj3 = h.e(obj4, uUID);
                                        if (obj3 != null) {
                                            return obj3;
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        } else {
        }
        return obj4;
    }

    private static String p(UUID uUID, String string2) {
        int i;
        boolean obj2;
        if (p0.a < 26 && w0.c.equals(uUID) && !"video/mp4".equals(string2) && "audio/mp4".equals(string2)) {
            if (w0.c.equals(uUID)) {
                if (!"video/mp4".equals(string2)) {
                    if ("audio/mp4".equals(string2)) {
                    }
                }
                return "cenc";
            }
        }
        return string2;
    }

    private static UUID q(UUID uUID) {
        int equals;
        Object obj2;
        if (p0.a < 27 && w0.c.equals(uUID)) {
            if (w0.c.equals(uUID)) {
                obj2 = w0.b;
            }
        }
        return obj2;
    }

    private static void s(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static com.google.android.exoplayer2.drm.t.b u(UUID uUID, List<com.google.android.exoplayer2.drm.t.b> list2) {
        int i2;
        int i4;
        int i5;
        int i3;
        int i;
        int length;
        byte[] length2;
        String str;
        String str2;
        int obj8;
        int i6 = 0;
        if (!w0.d.equals(uUID)) {
            return (t.b)list2.get(i6);
        }
        int i7 = 1;
        if (p0.a >= 28 && list2.size() > i7) {
            if (list2.size() > i7) {
                obj8 = list2.get(i6);
                i3 = i2;
                while (i2 < list2.size()) {
                    length = list2.get(i2);
                    length2 = length.w;
                    g.e(length2);
                    i3 += length;
                    i2++;
                }
                i4 = i7;
                if (i4 != 0) {
                    byte[] bArr = new byte[i3];
                    i = i5;
                    while (i5 < list2.size()) {
                        length = obj.w;
                        g.e(length);
                        length2 = length.length;
                        System.arraycopy((byte[])length, i6, bArr, i, length2);
                        i += length2;
                        i5++;
                    }
                    return (t.b)obj8.a(bArr);
                }
            }
        }
        obj8 = i6;
        while (obj8 < list2.size()) {
            i4 = list2.get(obj8);
            byte[] bArr2 = i4.w;
            g.e(bArr2);
            i3 = h.g((byte[])bArr2);
            length = p0.a;
            length2 = 23;
            obj8++;
        }
        return (t.b)list2.get(i6);
    }

    private void v(com.google.android.exoplayer2.drm.b0.b b0$b, MediaDrm mediaDrm2, byte[] b3Arr3, int i4, int i5, byte[] b6Arr6) {
        b.a(this, b3Arr3, i4, i5, b6Arr6);
    }

    static com.google.android.exoplayer2.drm.b0 x(UUID uUID) {
        try {
            return d0.z(uUID);
            uUID = String.valueOf(uUID);
            String str = String.valueOf(uUID);
            str = str.length();
            str += 53;
            StringBuilder stringBuilder = new StringBuilder(str);
            str = "Failed to instantiate a FrameworkMediaDrm for uuid: ";
            stringBuilder.append(str);
            stringBuilder.append(uUID);
            uUID = ".";
            stringBuilder.append(uUID);
            uUID = stringBuilder.toString();
            str = "FrameworkMediaDrm";
            v.c(str, uUID);
            uUID = new y();
            return uUID;
        }
    }

    private static boolean y() {
        return "ASUS_Z00AD".equals(p0.d);
    }

    public static com.google.android.exoplayer2.drm.d0 z(UUID uUID) {
        try {
            d0 d0Var = new d0(uUID);
            return d0Var;
            int i = 2;
            UnsupportedDrmException unsupportedDrmException = new UnsupportedDrmException(i, uUID);
            throw unsupportedDrmException;
            i = 1;
            unsupportedDrmException = new UnsupportedDrmException(i, uUID);
            throw unsupportedDrmException;
        }
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public void a() {
        int i;
        i2--;
        this.c = i;
        synchronized (this) {
            try {
                this.b.release();
                throw th;
            }
        }
    }

    public Class<com.google.android.exoplayer2.drm.c0> b() {
        return c0.class;
    }

    public Map<String, String> c(byte[] bArr) {
        return this.b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public com.google.android.exoplayer2.drm.a0 d(byte[] bArr) {
        return r(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public com.google.android.exoplayer2.drm.b0.d e() {
        MediaDrm.ProvisionRequest provisionRequest = this.b.getProvisionRequest();
        b0.d dVar = new b0.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
        return dVar;
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public byte[] f() {
        return this.b.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public void g(byte[] bArr, byte[] b2Arr2) {
        this.b.restoreKeys(bArr, b2Arr2);
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public void h(byte[] bArr) {
        this.b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public void i(com.google.android.exoplayer2.drm.b0.b b0$b) {
        com.google.android.exoplayer2.drm.o oVar;
        int obj3;
        if (b == null) {
            obj3 = 0;
        } else {
            oVar = new o(this, b);
            obj3 = oVar;
        }
        this.b.setOnEventListener(obj3);
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public byte[] j(byte[] bArr, byte[] b2Arr2) {
        byte[] obj4;
        if (w0.c.equals(this.a)) {
            obj4 = r.b(b2Arr2);
        }
        return this.b.provideKeyResponse(bArr, obj4);
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public void k(byte[] bArr) {
        this.b.provideProvisionResponse(bArr);
    }

    public com.google.android.exoplayer2.drm.b0.a l(byte[] bArr, List<com.google.android.exoplayer2.drm.t.b> list2, int i3, HashMap<String, String> hashMap4) {
        int i;
        String str2;
        String str;
        int i2;
        int i4;
        int obj9;
        List obj10;
        String obj11;
        boolean obj12;
        if (list2 != null) {
            i = d0.u(this.a, list2);
            byte[] bArr2 = i.w;
            g.e(bArr2);
            i2 = obj10;
            i4 = str2;
        } else {
            i4 = i2;
        }
        obj9 = this.b.getKeyRequest(bArr, i2, i4, i3, hashMap4);
        if ("https://x".equals(obj9.getDefaultUrl())) {
            obj11 = "";
        }
        if (TextUtils.isEmpty(obj11) && i != 0 && !TextUtils.isEmpty(i.c)) {
            if (i != 0) {
                if (!TextUtils.isEmpty(i.c)) {
                    obj11 = i.c;
                }
            }
        }
        if (p0.a >= 23) {
            obj9 = obj9.getRequestType();
        } else {
            obj9 = Integer.MIN_VALUE;
        }
        obj12 = new b0.a(d0.n(this.a, obj9.getData()), obj11, obj9);
        return obj12;
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public com.google.android.exoplayer2.drm.c0 r(byte[] bArr) {
        int i;
        int equals;
        String str;
        if (p0.a < 21 && w0.d.equals(this.a) && "L3".equals(t("securityLevel"))) {
            if (w0.d.equals(this.a)) {
                i = "L3".equals(t("securityLevel")) ? 1 : 0;
            } else {
            }
        } else {
        }
        c0 c0Var = new c0(d0.q(this.a), bArr, i);
        return c0Var;
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public String t(String string) {
        return this.b.getPropertyString(string);
    }

    @Override // com.google.android.exoplayer2.drm.b0
    public void w(com.google.android.exoplayer2.drm.b0.b b0$b, MediaDrm mediaDrm2, byte[] b3Arr3, int i4, int i5, byte[] b6Arr6) {
        v(b, mediaDrm2, b3Arr3, i4, i5, b6Arr6);
    }
}
