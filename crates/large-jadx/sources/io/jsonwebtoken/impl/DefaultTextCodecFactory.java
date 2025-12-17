package io.jsonwebtoken.impl;

/* loaded from: classes3.dex */
@Deprecated
public class DefaultTextCodecFactory implements io.jsonwebtoken.impl.TextCodecFactory {
    @Override // io.jsonwebtoken.impl.TextCodecFactory
    protected String getSystemProperty(String string) {
        return System.getProperty(string);
    }

    @Override // io.jsonwebtoken.impl.TextCodecFactory
    public io.jsonwebtoken.impl.TextCodec getTextCodec() {
        if (isAndroid()) {
            AndroidBase64Codec androidBase64Codec = new AndroidBase64Codec();
            return androidBase64Codec;
        }
        Base64Codec base64Codec = new Base64Codec();
        return base64Codec;
    }

    @Override // io.jsonwebtoken.impl.TextCodecFactory
    protected boolean isAndroid() {
        String systemProperty = getSystemProperty("java.vm.name");
        if (systemProperty != null) {
            return systemProperty.toLowerCase().contains("dalvik");
        }
        String systemProperty2 = getSystemProperty("java.vm.vendor");
        if (systemProperty2 != null) {
            return systemProperty2.toLowerCase().contains("android");
        }
        return 0;
    }
}
