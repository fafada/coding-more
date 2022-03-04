package com.codingmore.service;

import com.codingmore.model.Menu;
import com.codingmore.model.Resource;
import com.codingmore.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author 石磊
 * @since 2022-03-03
 */
public interface IRoleService extends IService<Role> {

    /**
     * 分页获取角色列表
     */
    List<Role> queryList(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<Menu> getMenuList(Long userId);

    /**
     * 获取角色相关菜单
     */
    List<Menu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<Resource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);

    /**
     * 根据角色名称获取角色id
     * @param roleName
     * @return
     */
    Role getByName(String roleName);
}
