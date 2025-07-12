package com.example.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.model.PageQuery;
import com.example.common.model.PageResult;
import com.example.common.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基础服务实现类
 *
 * @param <M> Mapper类型
 * @param <T> 实体类型
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    @Override
    public T getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public List<T> listAll() {
        return super.list();
    }

    @Override
    public List<T> list(QueryWrapper<T> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Override
    public T getOne(QueryWrapper<T> queryWrapper) {
        return super.getOne(queryWrapper, false);
    }

    @Override
    public long count(QueryWrapper<T> queryWrapper) {
        return super.count(queryWrapper);
    }

    @Override
    public PageResult<T> page(PageQuery pageQuery, QueryWrapper<T> queryWrapper) {
        // 构建分页对象
        Page<T> page = new Page<>(pageQuery.getCurrent(), pageQuery.getSize());

        // 添加排序
        if (pageQuery.needOrder()) {
            if ("desc".equalsIgnoreCase(pageQuery.getOrderType())) {
                queryWrapper.orderByDesc(pageQuery.getOrderField());
            } else {
                queryWrapper.orderByAsc(pageQuery.getOrderField());
            }
        }

        // 执行分页查询
        IPage<T> resultPage = super.page(page, queryWrapper);

        // 转换为自定义分页结果
        return PageResult.of(
                resultPage.getCurrent(),
                resultPage.getSize(),
                resultPage.getTotal(),
                resultPage.getRecords()
        );
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(T entity) {
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(T entity) {
        return super.updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(Collection<T> entityList) {
        return super.updateBatchById(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(QueryWrapper<T> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps(QueryWrapper<T> queryWrapper) {
        return super.listMaps(queryWrapper);
    }
}
