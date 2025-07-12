package com.example.common.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.model.PageQuery;
import com.example.common.model.PageResult;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基础服务接口
 *
 * @param <T> 实体类型
 */
public interface BaseService<T> extends IService<T> {

    /**
     * 根据ID查询实体
     *
     * @param id 主键ID
     * @return 实体
     */
    T getById(Serializable id);

    /**
     * 查询所有实体
     *
     * @return 实体列表
     */
    List<T> listAll();

    /**
     * 根据条件查询实体列表
     *
     * @param queryWrapper 查询条件
     * @return 实体列表
     */
    List<T> list(QueryWrapper<T> queryWrapper);

    /**
     * 根据条件查询单个实体
     *
     * @param queryWrapper 查询条件
     * @return 实体
     */
    T getOne(QueryWrapper<T> queryWrapper);

    /**
     * 根据条件查询数量
     *
     * @param queryWrapper 查询条件
     * @return 数量
     */
    long count(QueryWrapper<T> queryWrapper);

    /**
     * 分页查询
     *
     * @param pageQuery    分页参数
     * @param queryWrapper 查询条件
     * @return 分页结果
     */
    PageResult<T> page(PageQuery pageQuery, QueryWrapper<T> queryWrapper);

    /**
     * 保存实体
     *
     * @param entity 实体
     * @return 是否成功
     */
    boolean save(T entity);

    /**
     * 批量保存实体
     *
     * @param entityList 实体列表
     * @return 是否成功
     */
    boolean saveBatch(Collection<T> entityList);

    /**
     * 更新实体
     *
     * @param entity 实体
     * @return 是否成功
     */
    boolean updateById(T entity);

    /**
     * 批量更新实体
     *
     * @param entityList 实体列表
     * @return 是否成功
     */
    boolean updateBatchById(Collection<T> entityList);

    /**
     * 根据ID删除实体
     *
     * @param id 主键ID
     * @return 是否成功
     */
    boolean removeById(Serializable id);

    /**
     * 根据ID批量删除实体
     *
     * @param idList ID列表
     * @return 是否成功
     */
    boolean removeByIds(Collection<? extends Serializable> idList);

    /**
     * 根据条件删除实体
     *
     * @param queryWrapper 查询条件
     * @return 是否成功
     */
    boolean remove(QueryWrapper<T> queryWrapper);

    /**
     * 根据条件查询Map列表
     *
     * @param queryWrapper 查询条件
     * @return Map列表
     */
    List<Map<String, Object>> listMaps(QueryWrapper<T> queryWrapper);
}
