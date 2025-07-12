package com.example.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MyBatis-Plus自动填充处理器
 */
@Slf4j
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时自动填充
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("开始执行插入自动填充");

        // 创建时间和更新时间自动填充
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        // 创建人和更新人自动填充
        // 这里需要从当前登录用户中获取用户ID，暂时使用默认值1L
        // 实际项目中应该从SecurityContextHolder或者其他用户上下文中获取
        Long currentUserId = getCurrentUserId();
        this.strictInsertFill(metaObject, "createBy", Long.class, currentUserId);
        this.strictInsertFill(metaObject, "updateBy", Long.class, currentUserId);

        // 逻辑删除字段初始化为0（未删除）
        this.strictInsertFill(metaObject, "isDeleted", Integer.class, 0);

        // 版本号初始化为1
        this.strictInsertFill(metaObject, "version", Integer.class, 1);
    }

    /**
     * 更新时自动填充
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("开始执行更新自动填充");

        // 更新时间自动填充
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        // 更新人自动填充
        // 这里需要从当前登录用户中获取用户ID，暂时使用默认值1L
        Long currentUserId = getCurrentUserId();
        this.strictUpdateFill(metaObject, "updateBy", Long.class, currentUserId);
    }

    /**
     * 获取当前登录用户ID
     * 实际项目中应该从SecurityContextHolder或者其他用户上下文中获取
     *
     * @return 当前登录用户ID
     */
    private Long getCurrentUserId() {
        // TODO: 从当前登录用户中获取用户ID
        // 暂时返回默认值1L，表示系统用户
        return 1L;
    }
}
