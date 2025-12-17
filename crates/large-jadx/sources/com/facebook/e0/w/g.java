package com.facebook.e0.w;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.d;
import kotlin.k0.h;
import kotlin.y.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000c\u001a\u00020\u0006H\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lcom/facebook/appevents/ml/Utils;", "", "()V", "DIR_NAME", "", "getMlDir", "Ljava/io/File;", "normalizeString", "str", "parseModelWeights", "", "Lcom/facebook/appevents/ml/MTensor;", "file", "vectorize", "", "texts", "maxLen", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class g {

    public static final com.facebook.e0.w.g a;
    static {
        g gVar = new g();
        g.a = gVar;
    }

    public static final File a() {
        boolean mkdirs;
        int i;
        if (a.d(g.class)) {
            return null;
        }
        File file = new File(o.f().getFilesDir(), "facebook_ml/");
        if (file.exists() == null) {
            if (file.mkdirs() != null) {
                i = file;
            }
        } else {
        }
        return i;
    }

    public static final Map<String, com.facebook.e0.w.a> c(File file) {
        int floatBuffer;
        int i;
        int i4;
        int i6;
        String string;
        int i7;
        float[] fArr;
        int i3;
        int i5;
        int i2;
        Object obj = file;
        final int i8 = 0;
        if (a.d(g.class)) {
            return i8;
        }
        n.f(obj, "file");
        FileInputStream fileInputStream = new FileInputStream(obj);
        int available = fileInputStream.available();
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        byte[] bArr = new byte[available];
        dataInputStream.readFully(bArr);
        dataInputStream.close();
        int i9 = 4;
        if (available < i9) {
            return i8;
        }
        floatBuffer = 0;
        ByteBuffer wrap2 = ByteBuffer.wrap(bArr, floatBuffer, i9);
        wrap2.order(ByteOrder.LITTLE_ENDIAN);
        n.e(wrap2, "bb");
        int int = wrap2.getInt();
        if (available < int + 4) {
            return i8;
        }
        String string2 = new String(bArr, i9, int, d.a);
        JSONObject jSONObject = new JSONObject(string2);
        JSONArray names = jSONObject.names();
        int length = names.length();
        String[] strArr = new String[length];
        i4 = floatBuffer;
        while (i4 < length) {
            strArr[i4] = names.getString(i4);
            i4++;
        }
        i.o(strArr);
        HashMap hashMap = new HashMap();
        i6 = floatBuffer;
        while (i6 < length) {
            string = strArr[i6];
            if (string == null) {
            } else {
            }
            JSONArray jSONArray = jSONObject.getJSONArray(string);
            int length2 = jSONArray.length();
            int[] iArr = new int[length2];
            i5 = 1;
            while (floatBuffer < length2) {
                iArr[floatBuffer] = jSONArray.getInt(floatBuffer);
                i5 *= i2;
                floatBuffer++;
            }
            int i10 = i5 * 4;
            i7 = i + i10;
            ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i10);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            a aVar = new a(iArr);
            wrap.asFloatBuffer().get(aVar.a(), 0, i5);
            hashMap.put(string, aVar);
            i = i7;
            i6++;
            floatBuffer = i3;
            iArr[floatBuffer] = jSONArray.getInt(floatBuffer);
            i5 *= i2;
            floatBuffer++;
            i3 = floatBuffer;
        }
        return hashMap;
    }

    public final String b(String string) {
        int i;
        int i3;
        int i5;
        int i2;
        int i4;
        int i6;
        if (a.d(this)) {
            return null;
        }
        n.f(string, "str");
        int i9 = 1;
        length -= i9;
        final int i10 = 0;
        i5 = i3;
        while (i3 <= i) {
            if (i5 == 0) {
            } else {
            }
            i4 = i;
            if (n.h(string.charAt(i4), 32) <= 0) {
            } else {
            }
            i2 = i10;
            if (i5 != 0) {
                break;
            } else {
            }
            if (i2 == 0) {
                break;
            } else {
            }
            i--;
            if (i2 == 0) {
            } else {
            }
            i3++;
            i5 = i9;
            i2 = i9;
            i4 = i3;
        }
        h hVar = new h("\\s+");
        Object[] obj9 = hVar.f(string.subSequence(i3, i += i9).toString(), i10).toArray(new String[i10]);
        if (obj9 == null) {
        } else {
            obj9 = TextUtils.join(" ", (String[])obj9);
            n.e(obj9, "TextUtils.join(\" \", strArray)");
            return obj9;
        }
        obj9 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj9;
    }

    public final int[] d(String string, int i2) {
        int i;
        int length;
        if (a.d(this)) {
            return null;
        }
        n.f(string, "texts");
        int[] iArr = new int[i2];
        String obj6 = b(string);
        Charset forName = Charset.forName("UTF-8");
        n.e(forName, "Charset.forName(\"UTF-8\")");
        if (obj6 == null) {
        } else {
            obj6 = obj6.getBytes(forName);
            n.e(obj6, "(this as java.lang.String).getBytes(charset)");
            int i4 = 0;
            i = i4;
            while (i < i2) {
                if (i < obj6.length) {
                } else {
                }
                iArr[i] = i4;
                i++;
                iArr[i] = b &= 255;
            }
            return iArr;
        }
        obj6 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        throw obj6;
    }
}
