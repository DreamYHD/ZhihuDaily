# 干货日报

MVP+Retrofit+OkHttp+RxJava+GreenDao

### 用到的依赖
```java
    compile 'com.android.support:recyclerview-v7:25.1.0'
    compile 'com.google.code.gson:gson:2.8.0'
    compile 'io.reactivex:rxjava:1.1.0'
    compile 'io.reactivex:rxandroid:1.1.0'
    compile 'com.github.bumptech.glide:glide:3.7.0'
    compile 'com.squareup.retrofit2:retrofit:2.0.0-beta4'
    compile 'com.squareup.retrofit2:converter-gson:2.0.0-beta4'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.0.0-beta4'
    compile 'com.squareup.okhttp3:okhttp:3.4.2'
    compile 'com.jakewharton:butterknife:8.5.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'
    compile 'com.stylingandroid.prism:prism:1.0.1'
    compile 'org.greenrobot:greendao:3.2.0'
    compile 'com.rom4ek:arcnavigationview:1.0.2'
    compile 'cn.hugeterry.coordinatortablayout:coordinatortablayout:1.0.5'
    compile 'com.android.support:cardview-v7:25.1.0'
    
```
## 感谢
#### https://inthecheesefactory.com/blog/retrofit-2.0/en
#### http://gank.io/post/56e80c2c677659311bed9841
#### http://gank.io/post/560e15be2dca930e00da1083#toc_4
#### http://songning.me/2016/11/03/google-rxjava-mvp/
#### https://futurestud.io/tutorials/retrofit-2-how-to-use-dynamic-urls-for-requests
## 知识点总结
#### 封装网络请求（Retrofit+OkHttp+RxJava）
```java
public class HttpMthodMeizhi extends BaseHttpData {

    private Retrofit mRetrofit;

    private GankApi mGankApi;

    private HttpMthodMeizhi() {



        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT_CONNECT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT_WRITE, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT_READ, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(Base_Meizhi_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mGankApi = mRetrofit.create(GankApi.class);

    }

    private static class SingletoHolder {

        private static final HttpMthodMeizhi INSTANCE = new HttpMthodMeizhi();
    }

    public static HttpMthodMeizhi getInstance() {

        return SingletoHolder.INSTANCE;
    }

    public void getGankMeizi(Subscriber<MeizhiBean> subscriber, int start, int count) {
        mGankApi.getGankMeizi(start, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}

```
#### 初始化GreenDao
```java
@Entity(nameInDb = "Collection")
public class Collection {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "time")
    private String time;
    @Property(nameInDb = "noteText")
    private String noteText;
    @Property(nameInDb = "picture")
    private String picture;
    @Property(nameInDb = "url")
    private String url;
    @Generated(hash = 216314665)
    public Collection(Long id, String time, String noteText, String picture,
            String url) {
        this.id = id;
        this.time = time;
        this.noteText = noteText;
        this.picture = picture;
        this.url = url;
    }
    @Generated(hash = 1149123052)
    public Collection() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getNoteText() {
        return this.noteText;
    }
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
    public String getPicture() {
        return this.picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


}
```
#### 封装数据库
```java
public class GreenDaoManager {

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static GreenDaoManager mInstance;

    private GreenDaoManager() {

        if (mDaoMaster == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster
                    .DevOpenHelper(MyApplication.getContext(), "note_db", null);
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();


        }


    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if ((mInstance) == null) {
                    mInstance = new GreenDaoManager();
                }
            }

        }
        return mInstance;

    }

    public DaoMaster getDaoMaster() {

        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public DaoSession getNewDaoSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;

    }

}

```
#### RecyclerView的点击事件
```java
 public  interface OnRecyclerViewItemClickListener{
         void onItemClick(View view,int position);
     }
  public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener){
     this.mOnRecyclerViewItemClickListener=onItemClickListener;
    }
     @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView, position); // 2
                }
            });
        }
     }
```
```
