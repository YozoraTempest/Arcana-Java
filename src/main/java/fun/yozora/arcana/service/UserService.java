package fun.yozora.arcana.service;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import fun.yozora.arcana.bo.UserBo;
import fun.yozora.arcana.common.PageRequest;
import fun.yozora.arcana.model.entity.User;

import java.util.Collection;
import java.util.List;

/**
 * 用户 服务层。
 *
 * @author <a href="https://github.com/YozoraTempest">YozoraTempest</a>
 */
public interface UserService extends IService<User> {
    /**
     * 新增用户
     */
    Boolean insertByBo(UserBo userBo);

    /**
     * 更新用户
     */
    Boolean updateByBo(UserBo userBo);

    /**
     * 删除用户
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    /**
     * 根据id查询用户
     */
    User queryById(Long id);

    /**
     * 查询用户列表
     */
    List<User> queryList(UserBo userBo);

    /**
     * 分页查询用户列表
     */
    Page<User> queryPageList(UserBo userBo, PageRequest pageRequest);
}
