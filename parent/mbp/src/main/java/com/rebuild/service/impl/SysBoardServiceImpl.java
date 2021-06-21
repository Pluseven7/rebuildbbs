package com.rebuild.service.impl;

import com.rebuild.model.SysBoard;
import com.rebuild.mapper.SysBoardMapper;
import com.rebuild.model.SysLabel;
import com.rebuild.service.ISysBoardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rebuild.service.ISysModifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjq
 * @since 2021-06-09
 */
@Service
public class SysBoardServiceImpl extends ServiceImpl<SysBoardMapper, SysBoard> implements ISysBoardService {


    @Override
    public SysBoard newBoard(SysBoard sysBoard) {
        baseMapper.insertAndID(sysBoard);
        return sysBoard;
    }

    @Override
    public void updateTopicnum(Integer id){
        SysBoard sysBoard = baseMapper.selectById(id);
        sysBoard.setBdTopicnum(sysBoard.getBdTopicnum() +1);
        baseMapper.updateById(sysBoard);
    }

}
