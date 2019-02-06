package com.lyft.data.gateway.router;

import java.util.List;

import lombok.Data;

public interface QueryHistoryManager {
  void submitQueryDetail(QueryDetail queryDetail);

  List<QueryDetail> fetchQueryHistory();

  @Data
  class QueryDetail implements Comparable<QueryDetail> {
    String queryId;
    String queryText;
    String user;
    String source;
    String backendUrl;
    long captureTime;

    @Override
    public int compareTo(QueryDetail o) {
      if (o == null) {
        return 1;
      }
      return o.captureTime > this.captureTime ? 1 : -1;
    }
  }
}