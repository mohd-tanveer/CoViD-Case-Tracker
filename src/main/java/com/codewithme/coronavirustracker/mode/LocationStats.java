package com.codewithme.coronavirustracker.mode;


import lombok.Data;

@Data
public class LocationStats {
    private String state;
    private String country;
    private String latestTotalCount;
}
