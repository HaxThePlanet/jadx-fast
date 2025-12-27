package app.dogo.com.dogo_android.util;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import androidx.swiperefreshlayout.widget.b;
import com.bumptech.glide.j;
import com.bumptech.glide.load.engine.a0.f;
import com.bumptech.glide.p.a;
import com.bumptech.glide.r.g;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: MyAppGlideModule.java */
/* loaded from: classes.dex */
public final class MyAppGlideModule extends a {
    public static b d(Context context) {
        final b bVar = new b(context);
        bVar.l(5f);
        int[] iArr = new int[1];
        bVar.g(R.color.black);
        bVar.f(30f);
        bVar.start();
        return bVar;
    }

    public static void e(Uri uri, ImageView imageView) {
        File file;
        try {
            file = new File(new URI(uri.toString()));
        } catch (java.net.URISyntaxException uRISyntax) {
            uRISyntax.printStackTrace();
        }
        m.a(imageView.getContext()).A(uri).p1(MyAppGlideModule.d(imageView.getContext())).t1(new d(Long.valueOf(file.lastModified()))).R0(g.q0()).C0(imageView);
    }

    @Override // com.bumptech.glide.p.a
    public void b(Context context, com.bumptech.glide.d dVar) {
        dVar.b(new f(context, (long)157286400, r2));
    }
}
