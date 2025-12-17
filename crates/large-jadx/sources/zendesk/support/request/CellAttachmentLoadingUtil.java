package zendesk.support.request;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.e;
import com.squareup.picasso.t;
import com.squareup.picasso.x;
import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.d.c;
import f.g.d.d;
import f.g.e.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import zendesk.support.PicassoTransformations;

/* loaded from: classes3.dex */
class CellAttachmentLoadingUtil {

    private static final String LOG_TAG = "AttachmentLoadingUtil";
    private final zendesk.support.request.CellAttachmentLoadingUtil.ImageLoadingLogic imageLoadingLogic;
    private final zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic imageSizingLogic;

    static class ImageLoadingLogic {

        private static final int IMAGE_DOWNSCALE_FACTOR = 2;
        private final t picasso;
        ImageLoadingLogic(t t) {
            super();
            this.picasso = t;
        }

        static void access$500(ImageView imageView, x x2, zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions cellAttachmentLoadingUtil$ImageSizingLogic$ImageDimensions3, e e4) {
            CellAttachmentLoadingUtil.ImageLoadingLogic.loadImage(imageView, x2, imageDimensions3, e4);
        }

        private zendesk.support.request.CellAttachmentLoadingUtil.ImageLoadingLogic.LoadingStrategy getLoadingStrategy(zendesk.support.request.StateRequestAttachment stateRequestAttachment) {
            File localFile;
            boolean parse;
            boolean z;
            long length;
            int i;
            final int i3 = 0;
            if (stateRequestAttachment.getLocalFile() != null && stateRequestAttachment.getLocalFile().exists() != null && Long.compare(length, i) > 0) {
                if (stateRequestAttachment.getLocalFile().exists() != null) {
                    if (Long.compare(length, i) > 0) {
                        CellAttachmentLoadingUtil.ImageLoadingLogic.DisplayImageFromLocalSource displayImageFromLocalSource = new CellAttachmentLoadingUtil.ImageLoadingLogic.DisplayImageFromLocalSource(this.picasso.k(stateRequestAttachment.getLocalFile()), i3);
                        return displayImageFromLocalSource;
                    }
                }
            }
            if (g.c(stateRequestAttachment.getLocalUri()) && Uri.parse(stateRequestAttachment.getLocalUri()) != null) {
                if (Uri.parse(stateRequestAttachment.getLocalUri()) != null) {
                    CellAttachmentLoadingUtil.ImageLoadingLogic.DisplayImageFromLocalSource displayImageFromLocalSource2 = new CellAttachmentLoadingUtil.ImageLoadingLogic.DisplayImageFromLocalSource(this.picasso.j(stateRequestAttachment.getParsedLocalUri()), i3);
                    return displayImageFromLocalSource2;
                }
            }
            if (g.c(stateRequestAttachment.getUrl()) && g.c(stateRequestAttachment.getThumbnailUrl())) {
                if (g.c(stateRequestAttachment.getThumbnailUrl())) {
                    CellAttachmentLoadingUtil.ImageLoadingLogic.DisplayImageFromWeb displayImageFromWeb = new CellAttachmentLoadingUtil.ImageLoadingLogic.DisplayImageFromWeb(this.picasso, stateRequestAttachment.getUrl(), stateRequestAttachment.getThumbnailUrl(), i3);
                    return displayImageFromWeb;
                }
            }
            Object[] arr = new Object[1];
            a.b("RequestActivity", "Can't load image. Id: %s", Long.valueOf(stateRequestAttachment.getId()));
            CellAttachmentLoadingUtil.ImageLoadingLogic.DefaultDisplayStrategy obj7 = new CellAttachmentLoadingUtil.ImageLoadingLogic.DefaultDisplayStrategy(i3);
            return obj7;
        }

        private static void loadImage(ImageView imageView, x x2, zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions cellAttachmentLoadingUtil$ImageSizingLogic$ImageDimensions3, e e4) {
            x2.l(PicassoTransformations.getRoundedTransformation(dimensionPixelOffset /= 2));
            x2.k(imageWidth /= 2, obj5 /= 2);
            x2.a();
            x2.g(imageView, e4);
        }

        void initImageView(ImageView imageView) {
            this.picasso.b(imageView);
            imageView.setImageResource(c.v);
        }

        boolean isImageLoading(ImageView imageView, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
            boolean z;
            Object obj3;
            obj3 = imageView.getTag();
            if (obj3 instanceof StateRequestAttachment && Long.compare(z, obj3) == 0) {
                obj3 = Long.compare(z, obj3) == 0 ? 1 : 0;
            } else {
            }
            return obj3;
        }

        void loadAttachment(ImageView imageView, zendesk.support.request.StateRequestAttachment stateRequestAttachment2, zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions cellAttachmentLoadingUtil$ImageSizingLogic$ImageDimensions3) {
            getLoadingStrategy(stateRequestAttachment2).load(imageView, imageDimensions3);
        }

        void setImageViewLoading(ImageView imageView, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
            imageView.setTag(stateRequestAttachment2);
        }
    }

    static class ImageSizingLogic {

        private static final double ASPECT_RATIO = 1.7777777777777777d;
        private final Map<String, zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions> cachedDimensions;
        private final zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions maxSize;
        private final t picasso;
        ImageSizingLogic(t t, Context context2) {
            super();
            HashMap hashMap = new HashMap();
            this.cachedDimensions = hashMap;
            this.picasso = t;
            this.maxSize = getMaxSize(context2);
        }

        static Map access$600(zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic cellAttachmentLoadingUtil$ImageSizingLogic) {
            return imageSizingLogic.cachedDimensions;
        }

        private int calculateMaxWidth(Context context) {
            Resources obj4 = context.getResources();
            return i -= obj4;
        }

        static zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions determineTargetDimensions(int i, int i2, int i3, int i4) {
            int obj5;
            int obj6;
            CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions imageDimensions = new CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions();
            int i7 = (int)i8;
            if (i > i2) {
                if (i > i3) {
                    obj5 = i3;
                    obj6 = i7;
                }
            } else {
                if (i2 > i7) {
                    obj5 = Math.min(i3, i);
                }
            }
            imageDimensions.setDimensions(obj5, Math.max(Math.min(i4, obj6), 0));
            return imageDimensions;
        }

        private zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.DimensionStrategy getDimensionStrategy(zendesk.support.request.StateRequestAttachment stateRequestAttachment, zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions cellAttachmentLoadingUtil$ImageSizingLogic$ImageDimensions2) {
            int height;
            boolean key;
            File localFile;
            boolean parse;
            String localUri;
            int i;
            if (stateRequestAttachment.getHeight() > 0 && stateRequestAttachment.getWidth() > 0) {
                if (stateRequestAttachment.getWidth() > 0) {
                    CellAttachmentLoadingUtil.ImageSizingLogic.ExistingDimensions existingDimensions2 = new CellAttachmentLoadingUtil.ImageSizingLogic.ExistingDimensions(stateRequestAttachment.getWidth(), stateRequestAttachment.getHeight(), imageDimensions2);
                    return existingDimensions2;
                }
            }
            if (g.c(stateRequestAttachment.getLocalUri()) && this.cachedDimensions.containsKey(stateRequestAttachment.getLocalUri())) {
                if (this.cachedDimensions.containsKey(stateRequestAttachment.getLocalUri())) {
                    Object obj5 = this.cachedDimensions.get(stateRequestAttachment.getLocalUri());
                    CellAttachmentLoadingUtil.ImageSizingLogic.ExistingDimensions existingDimensions = new CellAttachmentLoadingUtil.ImageSizingLogic.ExistingDimensions((CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions)obj5.getImageWidth(), obj5.getImageHeight(), imageDimensions2);
                    return existingDimensions;
                }
            }
            if (stateRequestAttachment.getLocalFile() != null && stateRequestAttachment.getLocalFile().exists() != null && Long.compare(length, i) > 0) {
                if (stateRequestAttachment.getLocalFile().exists() != null) {
                    if (Long.compare(length, i) > 0) {
                        CellAttachmentLoadingUtil.ImageSizingLogic.ReadFromBitmap readFromBitmap = new CellAttachmentLoadingUtil.ImageSizingLogic.ReadFromBitmap(stateRequestAttachment.getLocalFile(), imageDimensions2);
                        return readFromBitmap;
                    }
                }
            }
            int i3 = 0;
            if (g.c(stateRequestAttachment.getLocalUri()) && Uri.parse(stateRequestAttachment.getLocalUri()) != null) {
                if (Uri.parse(stateRequestAttachment.getLocalUri()) != null) {
                    CellAttachmentLoadingUtil.ImageSizingLogic.ReadFromPicasso readFromPicasso = new CellAttachmentLoadingUtil.ImageSizingLogic.ReadFromPicasso(this.picasso.j(Uri.parse(stateRequestAttachment.getLocalUri())), imageDimensions2, i3);
                    return readFromPicasso;
                }
            }
            if (g.c(stateRequestAttachment.getUrl())) {
                CellAttachmentLoadingUtil.ImageSizingLogic.ReadFromPicasso readFromPicasso2 = new CellAttachmentLoadingUtil.ImageSizingLogic.ReadFromPicasso(this.picasso.l(stateRequestAttachment.getUrl()), imageDimensions2, i3);
                return readFromPicasso2;
            }
            Object[] obj6 = new Object[1];
            a.b("RequestActivity", "Can't load dimensions. Id: %s", Long.valueOf(stateRequestAttachment.getId()));
            obj5 = new CellAttachmentLoadingUtil.ImageSizingLogic.DefaultStrategy(i3);
            return obj5;
        }

        private zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions getMaxSize(Context context) {
            final int obj5 = calculateMaxWidth(context);
            CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions imageDimensions = new CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions(obj5, (int)i);
            return imageDimensions;
        }

        zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions getMaxSize() {
            return this.maxSize;
        }

        void loadDimensionsForAttachment(zendesk.support.request.StateRequestAttachment stateRequestAttachment, f<zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions> f2) {
            CellAttachmentLoadingUtil.ImageSizingLogic.1 anon = new CellAttachmentLoadingUtil.ImageSizingLogic.1(this, stateRequestAttachment, f2);
            getDimensionStrategy(stateRequestAttachment, this.maxSize).findDimensions(anon);
        }
    }
    CellAttachmentLoadingUtil(t t, Context context2) {
        super();
        CellAttachmentLoadingUtil.ImageSizingLogic imageSizingLogic = new CellAttachmentLoadingUtil.ImageSizingLogic(t, context2);
        this.imageSizingLogic = imageSizingLogic;
        CellAttachmentLoadingUtil.ImageLoadingLogic obj3 = new CellAttachmentLoadingUtil.ImageLoadingLogic(t);
        this.imageLoadingLogic = obj3;
    }

    static void access$000(zendesk.support.request.CellAttachmentLoadingUtil cellAttachmentLoadingUtil, ImageView imageView2, zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions cellAttachmentLoadingUtil$ImageSizingLogic$ImageDimensions3) {
        cellAttachmentLoadingUtil.adjustImageViewDimensions(imageView2, imageDimensions3);
    }

    static zendesk.support.request.CellAttachmentLoadingUtil.ImageLoadingLogic access$100(zendesk.support.request.CellAttachmentLoadingUtil cellAttachmentLoadingUtil) {
        return cellAttachmentLoadingUtil.imageLoadingLogic;
    }

    private void adjustImageViewDimensions(ImageView imageView, zendesk.support.request.CellAttachmentLoadingUtil.ImageSizingLogic.ImageDimensions cellAttachmentLoadingUtil$ImageSizingLogic$ImageDimensions2) {
        final android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = imageDimensions2.getImageWidth();
        layoutParams.height = imageDimensions2.getImageHeight();
        imageView.setLayoutParams(layoutParams);
    }

    void bindImage(ImageView imageView, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
        boolean imageSizingLogic;
        zendesk.support.request.CellAttachmentLoadingUtil.1 anon;
        if (!this.imageLoadingLogic.isImageLoading(imageView, stateRequestAttachment2)) {
            this.imageLoadingLogic.setImageViewLoading(imageView, stateRequestAttachment2);
            adjustImageViewDimensions(imageView, this.imageSizingLogic.getMaxSize());
            this.imageLoadingLogic.initImageView(imageView);
            anon = new CellAttachmentLoadingUtil.1(this, imageView, stateRequestAttachment2);
            this.imageSizingLogic.loadDimensionsForAttachment(stateRequestAttachment2, anon);
        }
    }
}
