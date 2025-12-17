package com.facebook.e0.r.g;

import android.util.Log;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000c\u001a\u00020\rH\u0007J\u000c\u0010\u000e\u001a\u0006\u0012\u0002\u0008\u00030\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\r2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0011\u001a\u00020\r2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lcom/facebook/appevents/codeless/internal/UnityReflection;", "", "()V", "CAPTURE_VIEW_HIERARCHY_METHOD", "", "EVENT_MAPPING_METHOD", "FB_UNITY_GAME_OBJECT", "TAG", "UNITY_PLAYER_CLASS", "UNITY_SEND_MESSAGE_METHOD", "unityPlayer", "Ljava/lang/Class;", "captureViewHierarchy", "", "getUnityPlayerClass", "sendEventMapping", "eventMapping", "sendMessage", "unityObject", "unityMethod", "message", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class e {

    private static final String a = "com.facebook.e0.r.g.e";
    private static Class<?> b;
    public static final com.facebook.e0.r.g.e c;
    static {
        e eVar = new e();
        e.c = eVar;
    }

    public static final void a() {
        e.d("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    private final Class<?> b() {
        Class forName = Class.forName("com.unity3d.player.UnityPlayer");
        n.e(forName, "Class.forName(UNITY_PLAYER_CLASS)");
        return forName;
    }

    public static final void c(String string) {
        e.d("UnityFacebookSDKPlugin", "OnReceiveMapping", string);
    }

    public static final void d(String string, String string2, String string3) {
        Class cls;
        Object obj10;
        Object obj11;
        Object obj12;
        Class<String> obj = String.class;
        if (e.b == null) {
            e.b = e.c.b();
        }
        try {
            Class cls2 = e.b;
            int i = 0;
            final String str2 = "unityPlayer";
            if (cls2 == null) {
            } else {
            }
            final int i2 = 3;
            final Class[] arr2 = new Class[i2];
            final int i3 = 0;
            arr2[i3] = obj;
            final int i4 = 1;
            arr2[i4] = obj;
            final int i5 = 2;
            arr2[i5] = obj;
            Method method = cls2.getMethod("UnitySendMessage", arr2);
            n.e(method, "unityPlayer.getMethod(\n …java, String::class.java)");
            Class cls3 = e.b;
            if (cls3 == null) {
            } else {
            }
            Object[] arr = new Object[i2];
            arr[i3] = string;
            arr[i4] = string2;
            arr[i5] = string3;
            method.invoke(cls3, arr);
            n.w(str2);
            throw i;
            n.w(str2);
            throw i;
            string2 = e.a;
            string3 = "Failed to send message to Unity";
            Log.e(string2, string3, string);
        }
    }
}
