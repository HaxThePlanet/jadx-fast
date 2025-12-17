package zendesk.belvedere;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Pair;
import java.io.File;

/* loaded from: classes3.dex */
public class c {
    public static Pair<Integer, Integer> a(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return Pair.create(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
    }
}
