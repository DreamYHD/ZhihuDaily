package com.androidlab.zhihudaily.data.getdata;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.androidlab.zhihudaily.MyApplication;
import com.androidlab.zhihudaily.data.api.ImageApi;
import com.androidlab.zhihudaily.utils.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Haodong on 2017/2/25.
 */

public class HttpMethodDown extends BaseHttpData{

    private Retrofit mRetrofit;

    private ImageApi mImageApi;

    private static final String PATH=Environment.getExternalStorageDirectory()+"/ZhihuDaily/";




    private HttpMethodDown(){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.readTimeout(DEFAULT_TIMEOUT_CONNECT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT_WRITE,TimeUnit.SECONDS);
        builder.connectTimeout(DEFAULT_TIMEOUT_CONNECT,TimeUnit.SECONDS);

        mRetrofit=new Retrofit.Builder()
                .baseUrl("https://your.api.url/")
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mImageApi=mRetrofit.create(ImageApi.class);





    }
    private static class SingleHolder{
        private static final HttpMethodDown INSTANCE=new HttpMethodDown();
    }
    public static HttpMethodDown getInstance(){
        return SingleHolder.INSTANCE;
    }

    public void downloadImage(Subscriber<String>subscriber, String url){
            mImageApi.downloadImage(url)
                    .subscribeOn(Schedulers.io())
                    .map(new Func1<ResponseBody, String>() {
                        @Override
                        public String call(ResponseBody responseBody) {
                            if(writeResponseBodyToDisk(responseBody)!=null){
                                return writeResponseBodyToDisk(responseBody);

                            }
                            return null;
                        }
                    })
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
    }

    private String writeResponseBodyToDisk(ResponseBody responseBody) {

        File file=new File(PATH);
        if (!file.exists()) {

          file.mkdir();

        }

        try {
            File myCaptureFile = new File(PATH,System.currentTimeMillis()+".jpg" );
            if(!myCaptureFile.exists()){
                myCaptureFile.createNewFile();
            }

            InputStream is=null;
            OutputStream os=null;

            byte[]fileRead=new byte[4096];
            long fileSize=responseBody.contentLength();
            long fileSizeDownloaded=0;


            is=responseBody.byteStream();
            os=new FileOutputStream(myCaptureFile);
            while (true) {
                int read = is.read(fileRead);

                if (read == -1) {
                    break;
                }

                os.write(fileRead, 0, read);

                fileSizeDownloaded += read;

                Log.d("download", "file download: " + fileSizeDownloaded + " of " + fileSize);
            }
            Logger.error("downloadscuuess",myCaptureFile.toString());

            os.flush();
            return myCaptureFile.toString();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
