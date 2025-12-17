package com.google.android.exoplayer2.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* loaded from: classes2.dex */
public final class r {
    private static void a(int i, String string2, int i3) {
        int str;
        int i2;
        int stringBuilder;
        String obj5;
        final int obj4 = GLES20.glCreateShader(i);
        GLES20.glShaderSource(obj4, string2);
        GLES20.glCompileShader(obj4);
        str = 1;
        int[] iArr = new int[str];
        stringBuilder = 0;
        iArr[stringBuilder] = stringBuilder;
        GLES20.glGetShaderiv(obj4, 35713, iArr, stringBuilder);
        if (iArr[stringBuilder] != str) {
            String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(obj4);
            stringBuilder = new StringBuilder(i4 += length2);
            stringBuilder.append(glGetShaderInfoLog);
            stringBuilder.append(", source: ");
            stringBuilder.append(string2);
            r.j(stringBuilder.toString());
        }
        GLES20.glAttachShader(i3, obj4);
        GLES20.glDeleteShader(obj4);
        r.b();
    }

    public static void b() {
        String string;
        int glGetError = GLES20.glGetError();
        while (glGetError != null) {
            String str = "glError ";
            String valueOf = String.valueOf(GLU.gluErrorString(glGetError));
            if (valueOf.length() != 0) {
            } else {
            }
            string = new String(str);
            v.c("GlUtil", string);
            glGetError = GLES20.glGetError();
            string = str.concat(valueOf);
        }
    }

    public static int c(String string, String string2) {
        int length;
        String obj3;
        String obj4;
        final int glCreateProgram = GLES20.glCreateProgram();
        r.b();
        r.a(35633, string, glCreateProgram);
        r.a(35632, string2, glCreateProgram);
        GLES20.glLinkProgram(glCreateProgram);
        obj3 = 1;
        obj4 = new int[obj3];
        length = 0;
        obj4[length] = length;
        GLES20.glGetProgramiv(glCreateProgram, 35714, obj4, length);
        if (obj4[length] != obj3) {
            obj3 = "Unable to link shader program: \n";
            obj4 = String.valueOf(GLES20.glGetProgramInfoLog(glCreateProgram));
            if (obj4.length() != 0) {
                obj3 = obj3.concat(obj4);
            } else {
                obj4 = new String(obj3);
                obj3 = obj4;
            }
            r.j(obj3);
        }
        r.b();
        return glCreateProgram;
    }

    public static int d(String[] stringArr, String[] string2Arr2) {
        final String str = "\n";
        return r.c(TextUtils.join(str, stringArr), TextUtils.join(str, string2Arr2));
    }

    public static FloatBuffer e(int i) {
        return ByteBuffer.allocateDirect(i *= 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer f(float[] fArr) {
        return (FloatBuffer)r.e(fArr.length).put(fArr).flip();
    }

    public static int g() {
        int i = 1;
        final int[] iArr = new int[i];
        GLES20.glGenTextures(i, IntBuffer.wrap(iArr));
        int i2 = 0;
        final int i9 = 36197;
        GLES20.glBindTexture(i9, iArr[i2]);
        int i10 = 9729;
        GLES20.glTexParameteri(i9, 10241, i10);
        GLES20.glTexParameteri(i9, 10240, i10);
        int i11 = 33071;
        GLES20.glTexParameteri(i9, 10242, i11);
        GLES20.glTexParameteri(i9, 10243, i11);
        r.b();
        return iArr[i2];
    }

    public static boolean h(Context context) {
        int str2;
        int str3;
        int i;
        boolean equals;
        String str;
        boolean obj5;
        str2 = p0.a;
        i = 0;
        if (str2 < 24) {
            return i;
        }
        int i3 = 26;
        if (str2 < i3 && !"samsung".equals(p0.c) && "XT1650".equals(p0.d)) {
            if (!"samsung".equals(p0.c)) {
                if ("XT1650".equals(p0.d)) {
                }
            }
            return i;
        }
        if (str2 < i3 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            if (!context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                return i;
            }
        }
        obj5 = EGL14.eglQueryString(EGL14.eglGetDisplay(i), 12373);
        if (obj5 != null && obj5.contains("EGL_EXT_protected_content")) {
            if (obj5.contains("EGL_EXT_protected_content")) {
                i = 1;
            }
        }
        return i;
    }

    public static boolean i() {
        String eglQueryString;
        int i;
        int str;
        i = 0;
        if (p0.a < 17) {
            return i;
        }
        eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(i), 12373);
        if (eglQueryString != null && eglQueryString.contains("EGL_KHR_surfaceless_context")) {
            if (eglQueryString.contains("EGL_KHR_surfaceless_context")) {
                i = 1;
            }
        }
        return i;
    }

    private static void j(String string) {
        v.c("GlUtil", string);
    }
}
