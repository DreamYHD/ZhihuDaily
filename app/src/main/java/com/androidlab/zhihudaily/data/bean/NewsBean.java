package com.androidlab.zhihudaily.data.bean;

import java.util.List;

/**
 * Created by Haodong on 2017/2/6.
 */

public class NewsBean {

    /**
     * date : 20170210
     * stories : [{"images":["http://pic4.zhimg.com/d8bbedc51991b1a9da372bb1adc791db.jpg"],"type":0,"id":9200053,"ga_prefix":"021016","title":"身体里涌过一阵「暖流」，感觉好奇妙"},{"images":["http://pic2.zhimg.com/6ecda2cd82710ca9a65be31f1b490f61.jpg"],"type":0,"id":9034429,"ga_prefix":"021015","title":"用这个完美爱情的公式，来看看你的爱情是哪一种模式"},{"images":["http://pic2.zhimg.com/178c8a0f1759c3b45ff70b92baeb1321.jpg"],"type":0,"id":9208718,"ga_prefix":"021014","title":"未来十年，金融行业会被人工智能取代吗？"},{"images":["http://pic4.zhimg.com/25b92c5a96986c51664962a2f7550c3f.jpg"],"type":0,"id":9204413,"ga_prefix":"021013","title":"「做啥都不快乐」和「觉得自己做啥都不快乐」是不一样的"},{"images":["http://pic3.zhimg.com/0b3ec8b84519a6e6b1c448a59e4aa06e.jpg"],"type":0,"id":9209484,"ga_prefix":"021012","title":"大误 · 我当初学这些都是为了啥？"},{"images":["http://pic2.zhimg.com/8b4dad732f253f03632d752504f7d0bd.jpg"],"type":0,"id":9205630,"ga_prefix":"021011","title":"「书里夹片叶子后来都变臭了」，标本不是这么做的啊喂"},{"images":["http://pic4.zhimg.com/daba11c65ecbb6f1215e0184ac39b643.jpg"],"type":0,"id":9207959,"ga_prefix":"021010","title":"算算电价和油价，电动车并不一定就比汽油车省钱"},{"images":["http://pic3.zhimg.com/738e5fe13266c669429e04f06ed8bcd6.jpg"],"type":0,"id":9201111,"ga_prefix":"021009","title":"是个中国人就可以在美国教中文吗？当然不是"},{"images":["http://pic3.zhimg.com/0cad57735522122e144febe32556e15a.jpg"],"type":0,"id":9208952,"ga_prefix":"021008","title":"《英雄联盟》 2017 全球总决赛在中国举行会有哪些影响？"},{"images":["http://pic2.zhimg.com/375ee2a128d42d970d86c11a9c79ccd5.jpg"],"type":0,"id":9206449,"ga_prefix":"021007","title":"当我们聊玩具制造的时候，Made in China 就是世界一流"},{"title":"在国外开车和在国内开车有什么不一样的感受？","ga_prefix":"021007","images":["http://pic3.zhimg.com/e73402fcf5d39cae6260e6ef05c0218e.jpg"],"multipic":true,"type":0,"id":9204393},{"images":["http://pic4.zhimg.com/726b5d8c9f51e77e1e076c6558fc6853.jpg"],"type":0,"id":9200465,"ga_prefix":"021007","title":"「确定」和「取消」按钮哪个在左哪个在右，你注意过吗？"},{"images":["http://pic3.zhimg.com/88605dcc5eae27a9273d016961d0387a.jpg"],"type":0,"id":9203141,"ga_prefix":"021006","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/fe3cc01975fcb64842349a629deb039d.jpg","type":0,"id":9208952,"ga_prefix":"021008","title":"《英雄联盟》 2017 全球总决赛在中国举行会有哪些影响？"},{"image":"http://pic4.zhimg.com/b687c92faad94a0adfc708aea52700c7.jpg","type":0,"id":9208784,"ga_prefix":"020919","title":"每一个人都怀揣梦想前来，艺考早就不只是一次考试了"},{"image":"http://pic3.zhimg.com/c0ace161922ad0f01c027e2e4db27616.jpg","type":0,"id":9208345,"ga_prefix":"020914","title":"传情达意还是要靠好吃的，来做一份心形的林茨饼干吧"},{"image":"http://pic3.zhimg.com/63b553d85bee65c9f75b827de34a914a.jpg","type":0,"id":9208240,"ga_prefix":"020912","title":"《职人介绍所》第二季第四期：用爱好养活自己的这帮人"},{"image":"http://pic3.zhimg.com/12ff38de386051b3e5ad4d7a838c9816.jpg","type":0,"id":9207296,"ga_prefix":"020907","title":"化工厂爆炸时，怎样处理才能尽量减少影响？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic4.zhimg.com/d8bbedc51991b1a9da372bb1adc791db.jpg"]
         * type : 0
         * id : 9200053
         * ga_prefix : 021016
         * title : 身体里涌过一阵「暖流」，感觉好奇妙
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic2.zhimg.com/fe3cc01975fcb64842349a629deb039d.jpg
         * type : 0
         * id : 9208952
         * ga_prefix : 021008
         * title : 《英雄联盟》 2017 全球总决赛在中国举行会有哪些影响？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
