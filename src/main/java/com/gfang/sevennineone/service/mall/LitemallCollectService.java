package com.gfang.sevennineone.service.mall;

import com.gfang.sevennineone.dao.mall.LitemallCollectMapper;
import com.gfang.sevennineone.model.po.mall.LitemallCollect;
import com.gfang.sevennineone.model.po.mall.LitemallCollectExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LitemallCollectService {
    @Resource
    private LitemallCollectMapper collectMapper;

    public int count(String uid, Integer gid) {
        LitemallCollectExample example = new LitemallCollectExample();
        example.or().andUserIdEqualTo(uid).andValueIdEqualTo(gid).andDeletedEqualTo(false);
        return (int) collectMapper.countByExample(example);
    }

    public List<LitemallCollect> queryByType(String userId, Byte type, Integer page, Integer limit, String sort, String order) {
        LitemallCollectExample example = new LitemallCollectExample();
        LitemallCollectExample.Criteria criteria = example.createCriteria();

        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        criteria.andUserIdEqualTo(userId);
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return collectMapper.selectByExample(example);
    }

    public int countByType(String userId, Byte type) {
        LitemallCollectExample example = new LitemallCollectExample();
        example.or().andUserIdEqualTo(userId).andTypeEqualTo(type).andDeletedEqualTo(false);
        return (int) collectMapper.countByExample(example);
    }

    public LitemallCollect queryByTypeAndValue(String userId, Byte type, Integer valueId) {
        LitemallCollectExample example = new LitemallCollectExample();
        example.or().andUserIdEqualTo(userId).andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        return collectMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        collectMapper.logicalDeleteByPrimaryKey(id);
    }

    public int add(LitemallCollect collect) {
        collect.setAddTime(LocalDateTime.now());
        collect.setUpdateTime(LocalDateTime.now());
        return collectMapper.insertSelective(collect);
    }

    public List<LitemallCollect> querySelective(String userId, String valueId, Integer page, Integer size, String sort, String order) {
        LitemallCollectExample example = new LitemallCollectExample();
        LitemallCollectExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(valueId)) {
            criteria.andValueIdEqualTo(Integer.valueOf(valueId));
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return collectMapper.selectByExample(example);
    }
}