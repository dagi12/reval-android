package pl.edu.amu.wmi.reval.common.services;

import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import static pl.edu.amu.wmi.reval.di.MyApplication.getContext;


public class PicassoCache {

    private static final String TAG = PicassoCache.class.getName();

    public PicassoCache() {
        Picasso.Builder builder = new Picasso.Builder(getContext());
        builder.downloader(new OkHttpDownloader(getContext(), Integer.MAX_VALUE));
        Picasso picasso = builder.build();
        Picasso.setSingletonInstance(picasso);
    }

    public void getImage(final ImageView imageView, final String url) {
        Picasso
                .with(getContext())
                .load(url)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.i(TAG, "Image fetched");
                    }

                    @Override
                    public void onError() {
                        Picasso
                                .with(getContext())
                                .load(url)
                                .into(imageView);
                    }
                });
    }


}

