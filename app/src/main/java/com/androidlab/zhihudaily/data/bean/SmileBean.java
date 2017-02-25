package com.androidlab.zhihudaily.data.bean;

import java.util.List;

/**
 * Created by Haodong on 2017/2/24.
 */

public class SmileBean {


    /**
     * error_code : 0
     * reason : 成功
     * result : [{"title":"再不走就赶不上了","content":"跟一女的朋友逛街。\r\n　　大热天的，女的说：不如找个地方洗个澡吧，心里想着：也好！于是开了个钟点房，过一会，女的洗完澡了，跟着到我了\u2026\r\n　　我从浴室出来看见那女的躺在床上，我说：睡你麻痹吖，快把鞋子穿好，走了！票都买好了，哆啦A梦快开始了，再不走就赶不上了，快快快\u2026\u2026","type":"现代笑话","updatetime":"2016-04-13 04:29"},{"title":"我看的是你儿子的饭碗","content":"办公室女神问我：您为啥有事没事总盯着我看？\r\n　　我说：自作多情，看您干啥，我看的是你儿子的饭碗！","type":"现代笑话","updatetime":"2016-04-13 03:28"},{"title":"对不起，咱家没这菜","content":"本人厨师一枚，由于酒店生意较忙，服务员打电话到厨房催菜。\r\n　　你好，鲁菜。\r\n　　你好，322的爆炒龙须加急。\r\n　　对不起，咱家没这菜。\r\n　　就是酸辣土豆丝！","type":"现代笑话","updatetime":"2016-04-13 02:28"},{"title":"这特么分明是不想随份子钱","content":"昨天我婚礼，但是曾经在学校一起疯一起闹的兄弟们却一个都没有来。\r\n　　婚礼结束送走宾客，我强忍着怒火坐在沙发上打电话一个一个问，刚开始各种理由，后面终于有人吱吱呜呜地说：五年前，你搂着xxx说，要是自己将来的老婆不是她，兄弟们就不要来。\r\n　　我听后沉默了，这特么分明是不想随份子钱！","type":"现代笑话","updatetime":"2016-04-13 01:27"},{"title":"给老子滚远点","content":"正排队买电影票，一长相甜美的妹妹一下就插队到我前面，我笑嘻嘻的问她：你有男朋友吗？\r\n　　没有。\r\n　　真的没有？\r\n　　真的没有啊！\r\n　　我高兴得大吼一声：给老子滚远点，还敢插队。","type":"现代笑话","updatetime":"2016-04-13 00:26"},{"title":"没想到帅哥这么爽快","content":"今天早上跑步的时候，看到一个帅哥坐在公园椅子上，没忍住遂过去问微信号。\r\n　　没想到帅哥这么爽快！直接就给我了，我回到家输了号码\u2026\u2026\r\n　　尼玛果断拉黑，这tm中看不中用啊，取个什么昵称不好，非要叫瞬奸。","type":"现代笑话","updatetime":"2016-04-12 22:26"},{"title":"她感觉心好像被针扎了一样","content":"他对她说一起去公园玩，她欣然答应。他又对她说:明天我的女朋友也一起来。她感觉心好像被针扎了一样，但还是强忍着痛答应。\r\n　　第二天，她先到公园门口，看到他只是一个人来，心里小鹿乱撞，他按捺住激动的心情问道：你女朋友呢？\r\n　　男孩对女孩温柔的笑了笑，然后伸出了右手。","type":"现代笑话","updatetime":"2016-04-12 21:25"},{"title":"小明，你的梦想是什么","content":"老师:小明，你的梦想是什么？\r\n　　小明沉思片刻道:有房有铺，自己当老板，妻子貌美如花，还有当官的兄弟。\r\n　　老师:北宋有个人和你一样，他姓武！","type":"现代笑话","updatetime":"2016-04-12 19:25"},{"title":"撑了伞能跑得快吗","content":"今天下雨，跑回家时不小心撞了前面美女一下。\r\n　　美女：跑那么快，赶着去投胎啊？\r\n　　我：没看到下这么大雨，能不跑吗？\r\n　　美女：你手上不是拿着伞吗？怎么不撑？\r\n　　我：你傻啊？撑了伞能跑得快吗？","type":"现代笑话","updatetime":"2016-04-12 18:24"},{"title":"不妙！背后一股杀气","content":"姨妹在我家过夜，早起姨妹穿着老婆的睡衣在阳台观景，我走上去从背后一把抱住。\r\n　　姨妹转身道：姐夫你干啥？\r\n　　我：呀，你穿你姐的睡衣，我以为是你姐呢！\r\n　　姨妹嗔笑道：姐夫你真逗！我姐腰围至少三尺二，我腰围一尺九，这都能看错？\r\n　　不妙！背后一股杀气！","type":"现代笑话","updatetime":"2016-04-12 17:23"}]
     */

    private int error_code;
    private String reason;
    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * title : 再不走就赶不上了
         * content : 跟一女的朋友逛街。
         　　大热天的，女的说：不如找个地方洗个澡吧，心里想着：也好！于是开了个钟点房，过一会，女的洗完澡了，跟着到我了…
         　　我从浴室出来看见那女的躺在床上，我说：睡你麻痹吖，快把鞋子穿好，走了！票都买好了，哆啦A梦快开始了，再不走就赶不上了，快快快……
         * type : 现代笑话
         * updatetime : 2016-04-13 04:29
         */

        private String title;
        private String content;
        private String type;
        private String updatetime;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }
}
