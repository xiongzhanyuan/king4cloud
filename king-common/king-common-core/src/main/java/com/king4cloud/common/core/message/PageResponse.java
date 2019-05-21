package com.king4cloud.common.core.message;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PageResponse<T> extends BaseResponse {
    private PageData<T> data;

    public PageResponse(long current, long total, List<T> rows) {
        this.data = new PageData<>(current, total, rows);
    }

    @Getter
    @Setter
    class PageData<TT> {
        private long current;
        private long total;
        private List<TT> rows;

        public PageData(long current, long total, List<TT> rows) {
            this.total = total;
            this.current = current;
            this.rows = rows;
        }

    }
}
