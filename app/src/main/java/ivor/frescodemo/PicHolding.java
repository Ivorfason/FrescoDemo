package ivor.frescodemo;

import android.graphics.Bitmap;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;

/**
 * Created by Ivor on 2016/1/21.
 */
public class PicHolding {

    // 动态图片处理
    public void gifHolding(String uri, SimpleDraweeView v) {
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        v.setController(controller);
    }

    // 网格图片处理
    public void gridHolding(Uri uri, final int color, SimpleDraweeView v) {
        Postprocessor redMeshPostprocessor = new BasePostprocessor() {
            @Override
            public String getName() {
                return "redMeshPostprocessor";
            }
            @Override
            public void process(Bitmap bitmap) {
                for (int x = 0; x < bitmap.getWidth(); x += 2) {
                    for (int y = 0; y < bitmap.getHeight(); y += 2) {
                        bitmap.setPixel(x, y, color);
                    }
                }
            }
        };

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setPostprocessor(redMeshPostprocessor)
                .build();

        PipelineDraweeController pipeController = (PipelineDraweeController)
                Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(v.getController())
                        .build();
        v.setController(pipeController);
    }
}
