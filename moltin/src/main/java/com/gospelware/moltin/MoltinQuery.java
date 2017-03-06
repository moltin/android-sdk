package com.gospelware.moltin;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lewis on 28/02/2017.
 */

public class MoltinQuery {

    private Integer page_offset;
    private Integer page_limit;
    private String sort;
    private String filter;
    private String include;

    public MoltinQuery() {

    }

    public MoltinQuery(Integer page_offset, Integer page_limit, String sort, String filter, String include) {
        this.page_offset = page_offset;
        this.page_limit = page_limit;
        this.sort = sort;
        this.filter = filter;
        this.include = include;
    }

    public Integer getPage_offset() {
        return page_offset;
    }

    public void setPage_offset(Integer page_offset) {
        this.page_offset = page_offset;
    }

    public Integer getPage_limit() {
        return page_limit;
    }

    public void setPage_limit(Integer page_limit) {
        this.page_limit = page_limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public Map<String, String> getQueryMap(){

        TreeMap<String, String> result = new TreeMap<>();

        if(page_offset != null){
            result.put("page[offset]", Integer.toString(page_offset));
        }

        if(page_limit != null){
            result.put("page[limit]", Integer.toString(page_limit));
        }

        if(sort != null){
            result.put("sort", sort);
        }

        if(filter != null){
            result.put("filter", filter);
        }

        if(include != null){
            result.put("include", include);
        }

        return result;
    }
}
