package com.androidlab.zhihudaily.data.bean;

import java.util.List;

/**
 * Created by Haodong on 2017/2/6.
 */

public class MeizhiBean {

    /**
     * error : false
     * results : [{"_id":"56cc6d29421aa95caa708259","createdAt":"2016-02-01T13:46:26.71Z","desc":"2.2","publishedAt":"2016-02-02T03:57:06.977Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1f0k66sk2qbj20rs130wqf.jpg","used":true,"who":"张涵宇"},{"_id":"582cf408421aa95002741a8f","createdAt":"2016-11-17T08:04:24.781Z","desc":"11-17","publishedAt":"2016-11-17T11:32:04.807Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f9us52puzsj20u00u0jtd.jpg","used":true,"who":"daimajia "},{"_id":"56cc6d23421aa95caa707b6a","createdAt":"2015-06-05T01:05:34.72Z","desc":"6.5\u2014\u2014（2）","publishedAt":"2015-06-05T03:54:29.404Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bgw1essxtqxs6jj20mj0tzdhl.jpg","used":true,"who":"张涵宇"},{"_id":"5729794967765974fca830e7","createdAt":"2016-05-04T12:23:37.334Z","desc":"5.4","publishedAt":"2016-05-04T12:26:03.894Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1f3j8jt6qn8j20vr15owvk.jpg","used":true,"who":"张涵宇"},{"_id":"5743cde9677659453b01369a","createdAt":"2016-05-24T11:43:37.996Z","desc":"5.24","publishedAt":"2016-05-24T11:56:12.924Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f46bsdcls2j20sg0izac0.jpg","used":true,"who":"daimajia"},{"_id":"56cc6d29421aa95caa708205","createdAt":"2016-01-25T09:14:17.609Z","desc":"1.26","publishedAt":"2016-01-26T04:02:34.316Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1f0buzmnacoj20f00liwi2.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d1d421aa95caa7077d9","createdAt":"2015-08-24T01:34:58.737Z","desc":"8.24","publishedAt":"2015-08-24T04:06:07.594Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1evdga4dimoj20qo0hsmzf.jpg","used":true,"who":"张涵宇"},{"_id":"585331db421aa9723d29b95c","createdAt":"2016-12-16T08:14:19.281Z","desc":"12-17","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg","used":true,"who":"代码家"},{"_id":"57edba71421aa95dd78e8d93","createdAt":"2016-09-30T09:05:53.26Z","desc":"出发去旅行","publishedAt":"2016-09-30T11:46:31.941Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f8bc5c5n4nj20u00irgn8.jpg","used":true,"who":"嗲马甲"},{"_id":"570eff956776590f57c4e0f9","createdAt":"2016-04-14T10:25:25.991Z","desc":"4.14","publishedAt":"2016-04-14T11:43:31.514Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1f2w0qujoecj20f00kzjtt.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d26421aa95caa707de6","createdAt":"2015-12-08T23:34:31.370Z","desc":"12-9","publishedAt":"2015-12-09T04:24:10.409Z","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1eyt23vp9mdj20ex0miq65.jpg","used":true,"who":"daimajia"},{"_id":"57315e5d67765974fca83139","createdAt":"2016-05-10T12:06:53.983Z","desc":"510","publishedAt":"2016-05-10T12:14:26.447Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f3q5semm0wj20qo0hsacv.jpg","used":true,"who":"daimajia"},{"_id":"5747be9c67765923298b5c8b","createdAt":"2016-05-27T11:27:24.288Z","desc":"夏天来了宝宝们","publishedAt":"2016-05-27T11:56:22.790Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f49s6i5pg7j20go0p043b.jpg","used":true,"who":"代码家"},{"_id":"56cc6d23421aa95caa707b36","createdAt":"2015-07-01T02:40:29.253Z","desc":"7.2","publishedAt":"2015-07-01T03:59:28.731Z","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1etn2pltc7mj20f90mwmye.jpg","used":true,"who":"代码家"},{"_id":"56cc6d23421aa95caa707b4f","createdAt":"2015-05-22T01:35:03.761Z","desc":"5.22","publishedAt":"2015-05-22T04:21:37.578Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bgw1escs1cl4f5j20qo0jsn3m.jpg","used":true,"who":"张涵宇"},{"_id":"579ab0a8421aa90d36e960b4","createdAt":"2016-07-29T09:26:00.838Z","desc":"7.29","publishedAt":"2016-07-29T09:37:39.219Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f6aipo68yvj20qo0qoaee.jpg","used":true,"who":"代码家"},{"_id":"57b10a9b421aa96004f4ba37","createdAt":"2016-08-15T08:19:39.899Z","desc":"8.15","publishedAt":"2016-08-15T11:27:22.462Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f6u4boc0k2j20u00u0gni.jpg","used":true,"who":"代码家"},{"_id":"56cfcaba421aa909db4d6ab0","createdAt":"2016-02-26T03:37:44.552Z","desc":"2.26","publishedAt":"2016-02-26T11:58:08.172Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1f1cl3c7rfgj20dw0ku76t.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d26421aa95caa707f41","createdAt":"2015-12-02T02:39:07.763Z","desc":"12.2","publishedAt":"2015-12-02T04:39:38.456Z","type":"福利","url":"http://ww2.sinaimg.cn/large/7a8aed7bjw1eyl43vfbndj20dw0ijmye.jpg","used":true,"who":"张涵宇"},{"_id":"5750f8a7421aa95653f1b92f","createdAt":"2016-06-03T11:25:27.781Z","desc":"周五啦！","publishedAt":"2016-06-03T11:42:44.370Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1f4hvgpjjapj20ia0ur0vr.jpg","used":true,"who":"代码家"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 56cc6d29421aa95caa708259
         * createdAt : 2016-02-01T13:46:26.71Z
         * desc : 2.2
         * publishedAt : 2016-02-02T03:57:06.977Z
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/7a8aed7bgw1f0k66sk2qbj20rs130wqf.jpg
         * used : true
         * who : 杨浩东
         * source : chrome
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private String source;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
