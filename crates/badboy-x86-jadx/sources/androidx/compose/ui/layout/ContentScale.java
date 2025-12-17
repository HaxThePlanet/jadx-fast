package androidx.compose.ui.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008g\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/ContentScale;", "", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ContentScale {

    public static final androidx.compose.ui.layout.ContentScale.Companion Companion;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0002\u001a\u0004\u0008\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0012\u0010\u0002\u001a\u0004\u0008\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0015\u0010\u0002\u001a\u0004\u0008\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0019\u0010\u0002\u001a\u0004\u0008\u001a\u0010\u001b¨\u0006\u001c", d2 = {"Landroidx/compose/ui/layout/ContentScale$Companion;", "", "()V", "Crop", "Landroidx/compose/ui/layout/ContentScale;", "getCrop$annotations", "getCrop", "()Landroidx/compose/ui/layout/ContentScale;", "FillBounds", "getFillBounds$annotations", "getFillBounds", "FillHeight", "getFillHeight$annotations", "getFillHeight", "FillWidth", "getFillWidth$annotations", "getFillWidth", "Fit", "getFit$annotations", "getFit", "Inside", "getInside$annotations", "getInside", "None", "Landroidx/compose/ui/layout/FixedScale;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/layout/FixedScale;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.layout.ContentScale.Companion $$INSTANCE;
        private static final androidx.compose.ui.layout.ContentScale Crop;
        private static final androidx.compose.ui.layout.ContentScale FillBounds;
        private static final androidx.compose.ui.layout.ContentScale FillHeight;
        private static final androidx.compose.ui.layout.ContentScale FillWidth;
        private static final androidx.compose.ui.layout.ContentScale Fit;
        private static final androidx.compose.ui.layout.ContentScale Inside;
        private static final androidx.compose.ui.layout.FixedScale None;
        static {
            ContentScale.Companion companion = new ContentScale.Companion();
            ContentScale.Companion.$$INSTANCE = companion;
            ContentScale.Companion.Crop.1 anon = new ContentScale.Companion.Crop.1();
            ContentScale.Companion.Crop = (ContentScale)anon;
            ContentScale.Companion.Fit.1 anon2 = new ContentScale.Companion.Fit.1();
            ContentScale.Companion.Fit = (ContentScale)anon2;
            ContentScale.Companion.FillHeight.1 anon3 = new ContentScale.Companion.FillHeight.1();
            ContentScale.Companion.FillHeight = (ContentScale)anon3;
            ContentScale.Companion.FillWidth.1 anon4 = new ContentScale.Companion.FillWidth.1();
            ContentScale.Companion.FillWidth = (ContentScale)anon4;
            ContentScale.Companion.Inside.1 anon5 = new ContentScale.Companion.Inside.1();
            ContentScale.Companion.Inside = (ContentScale)anon5;
            FixedScale fixedScale = new FixedScale(1065353216);
            ContentScale.Companion.None = fixedScale;
            ContentScale.Companion.FillBounds.1 anon6 = new ContentScale.Companion.FillBounds.1();
            ContentScale.Companion.FillBounds = (ContentScale)anon6;
        }

        public static void getCrop$annotations() {
        }

        public static void getFillBounds$annotations() {
        }

        public static void getFillHeight$annotations() {
        }

        public static void getFillWidth$annotations() {
        }

        public static void getFit$annotations() {
        }

        public static void getInside$annotations() {
        }

        public static void getNone$annotations() {
        }

        public final androidx.compose.ui.layout.ContentScale getCrop() {
            return ContentScale.Companion.Crop;
        }

        public final androidx.compose.ui.layout.ContentScale getFillBounds() {
            return ContentScale.Companion.FillBounds;
        }

        public final androidx.compose.ui.layout.ContentScale getFillHeight() {
            return ContentScale.Companion.FillHeight;
        }

        public final androidx.compose.ui.layout.ContentScale getFillWidth() {
            return ContentScale.Companion.FillWidth;
        }

        public final androidx.compose.ui.layout.ContentScale getFit() {
            return ContentScale.Companion.Fit;
        }

        public final androidx.compose.ui.layout.ContentScale getInside() {
            return ContentScale.Companion.Inside;
        }

        public final androidx.compose.ui.layout.FixedScale getNone() {
            return ContentScale.Companion.None;
        }
    }
    static {
        ContentScale.Companion = ContentScale.Companion.$$INSTANCE;
    }

    public abstract long computeScaleFactor-H7hwNQA(long l, long l2);
}
