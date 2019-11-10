package com.nettooe.swapi.repository.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PagePersonResponse {
    private long count;
    private String next;
    private Object previous;
    private List<PersonResponse> results;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("next")
    public String getNext() { return next; }
    @JsonProperty("next")
    public void setNext(String value) { this.next = value; }

    @JsonProperty("previous")
    public Object getPrevious() { return previous; }
    @JsonProperty("previous")
    public void setPrevious(Object value) { this.previous = value; }

    @JsonProperty("results")
    public List<PersonResponse> getResults() { return results; }
    @JsonProperty("results")
    public void setResults(List<PersonResponse> value) { this.results = value; }
}
