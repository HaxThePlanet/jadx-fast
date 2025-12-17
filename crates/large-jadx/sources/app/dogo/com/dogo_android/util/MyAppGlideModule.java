package app.dogo.com.dogo_android.util;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import androidx.swiperefreshlayout.widget.b;
import com.bumptech.glide.d;
import com.bumptech.glide.j;
import com.bumptech.glide.load.engine.a0.f;
import com.bumptech.glide.p.a;
import com.bumptech.glide.r.g;
import com.bumptech.glide.s.d;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public final class MyAppGlideModule extends a {
    public static b d(Context context) {
        b bVar = new b(context);
        bVar.l(1084227584);
        int[] obj3 = new int[1];
        bVar.g(2131099697);
        bVar.f(1106247680);
        bVar.start();
        return bVar;
    }

    public static void e(Uri uri, ImageView imageView2) {
        File file;
        try {
            URI uri2 = new URI(uri.toString());
            file = new File(uri2);
            th.printStackTrace();
            d dVar = new d(Long.valueOf(file.lastModified()));
            m.a(imageView2.getContext()).A(uri).p1(MyAppGlideModule.d(imageView2.getContext())).t1(dVar).R0(g.q0()).C0(imageView2);
        }
    }

    @Override // com.bumptech.glide.p.a
    public void b(Context context, d d2) {
        f fVar = new f(context, (long)i, obj2);
        d2.b(fVar);
    }
}
