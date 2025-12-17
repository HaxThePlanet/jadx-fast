package zendesk.belvedere;

import android.util.Log;

/* loaded from: classes3.dex */
class q {

    private static zendesk.belvedere.q.b a;

    public interface b {
        public abstract void a(String string, String string2);

        public abstract void b(String string, String string2);

        public abstract void c(String string, String string2, Throwable throwable3);

        public abstract void d(String string, String string2);

        public abstract void e(boolean z);
    }

    static class a implements zendesk.belvedere.q.b {

        private boolean a = false;
        a() {
            super();
            final int i = 0;
        }

        @Override // zendesk.belvedere.q$b
        public void a(String string, String string2) {
            if (this.a) {
                Log.w(string, string2);
            }
        }

        @Override // zendesk.belvedere.q$b
        public void b(String string, String string2) {
            if (this.a) {
                Log.e(string, string2);
            }
        }

        @Override // zendesk.belvedere.q$b
        public void c(String string, String string2, Throwable throwable3) {
            if (this.a) {
                Log.e(string, string2, throwable3);
            }
        }

        @Override // zendesk.belvedere.q$b
        public void d(String string, String string2) {
            if (this.a) {
                Log.d(string, string2);
            }
        }

        @Override // zendesk.belvedere.q$b
        public void e(boolean z) {
            this.a = z;
        }
    }
    static {
        q.a aVar = new q.a();
        q.a = aVar;
    }

    static void a(String string, String string2) {
        q.a.d(string, string2);
    }

    static void b(String string, String string2) {
        q.a.b(string, string2);
    }

    static void c(String string, String string2, Throwable throwable3) {
        q.a.c(string, string2, throwable3);
    }

    static void d(zendesk.belvedere.q.b q$b) {
        q.a = b;
    }

    static void e(String string, String string2) {
        q.a.a(string, string2);
    }
}
