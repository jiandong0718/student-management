package com.example.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.model.PageQuery;
import com.example.common.model.PageResult;
import com.example.common.model.Result;
import com.example.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * 基础控制器
 *
 * @param <S> 服务类型
 * @param <T> 实体类型
 * @param <ID> ID类型
 */
public abstract class BaseController<S extends BaseService<T>, T, ID extends Serializable> {

    @Autowired
    protected S baseService;

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return 查询结果
     */
    @GetMapping("/{id}")
    public Result<T> getById(@PathVariable ID id) {
        T entity = baseService.getById(id);
        return Result.success(entity);
    }

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @GetMapping("/list")
    public Result<List<T>> list() {
        List<T> list = baseService.listAll();
        return Result.success(list);
    }

    /**
     * 分页查询
     *
     * @param pageQuery 分页参数
     * @return 分页结果
     */
    @GetMapping("/page")
    public Result<PageResult<T>> page(@Valid PageQuery pageQuery) {
        QueryWrapper<T> queryWrapper = getQueryWrapper(pageQuery);
        PageResult<T> pageResult = baseService.page(pageQuery, queryWrapper);
        return Result.success(pageResult);
    }

    /**
     * 新增
     *
     * @param entity 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<Boolean> save(@RequestBody @Valid T entity) {
        boolean success = baseService.save(entity);
        return Result.success(success);
    }

    /**
     * 修改
     *
     * @param entity 实体
     * @return 修改结果
     */
    @PutMapping
    public Result<Boolean> update(@RequestBody @Valid T entity) {
        boolean success = baseService.updateById(entity);
        return Result.success(success);
    }

    /**
     * 删除
     *
     * @param id ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> remove(@PathVariable ID id) {
        boolean success = baseService.removeById(id);
        return Result.success(success);
    }

    /**
     * 批量删除
     *
     * @param ids ID列表
     * @return 删除结果
     */
    @DeleteMapping("/batch")
    public Result<Boolean> removeBatch(@RequestBody List<ID> ids) {
        boolean success = baseService.removeByIds(ids);
        return Result.success(success);
    }

    /**
     * 获取查询条件包装器
     *
     * @param pageQuery 分页参数
     * @return 查询条件包装器
     */
    protected abstract QueryWrapper<T> getQueryWrapper(PageQuery pageQuery);
}
