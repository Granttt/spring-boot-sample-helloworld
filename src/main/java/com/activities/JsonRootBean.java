package com.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author GXY
 * @Package com.activities
 * @date 2020/5/26 14:18
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
@Data
public class JsonRootBean {
    @JsonProperty("aweme_id")
    private String aweme_id;
    private List<String> big_kol_data;
    private String big_kol_today;
    private String brand_name;
    private String commission_rate;
    private String coupon_amount;
    private Date coupon_end_time;
    private String coupon_id;
    private String coupon_start_free;
    private Date coupon_start_timee;
    private String cover_uri;
    private String d_pic;
    private String d_title;
    private String dtk_sample_id;
    private String dtk_video_idd;
    private String dx_commission;
    private String goods_score_today;
    private String goodsid;
    private String is_flagship_shop;
    private String is_gold_seller;
    private String is_tmall;
    private String kol_today;
    private String pic;
    private String platform;
    private String price;
    private int quanhou;
    private String sales_todayy;
    private String seller_id;
    private String team_link;
    private String title;
    private String use_quan;
    private String video_score_today;
}
