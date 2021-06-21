package com.rebuild.qo;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import lombok.Data;

@Data
public class SysTopicQo {

    private Page page;

    private String tpId;
}
