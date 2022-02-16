package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Data
public class SearchImageRes {

    private String lastBuidlerDate;
    private int total;
    private int start;
    private int display;
    private List<SearchLocalItem> items;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchLocalItem{
        private String title;
        private String link;
        private String thumnail;
        private String sizeheight;
        private String sizewidth;
        private int mapx;
        private int mapy;
    }


}
