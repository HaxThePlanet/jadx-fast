@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 1 extends kotlin.d0.d.p implements kotlin.d0.c.l<String, java.lang.CharSequence> {
    @Override // kotlin.d0.d.p
    public final java.lang.CharSequence invoke(String str) {
        String str2 = null;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append('=');
        android.os.Bundle extras = DogoIntent.this.getIntent().getExtras();
        if (extras == null) {
            int i2 = 0;
        } else {
            Object obj = extras.get(str);
        }
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    1(DogoIntent dogoIntent) {
        super(1);
    }
}
