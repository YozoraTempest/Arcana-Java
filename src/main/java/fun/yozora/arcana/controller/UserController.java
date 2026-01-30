package fun.yozora.arcana.controller;

import com.mybatisflex.core.paginate.Page;
import fun.yozora.arcana.bo.UserBo;
import fun.yozora.arcana.common.BaseResponse;
import fun.yozora.arcana.common.PageRequest;
import fun.yozora.arcana.common.ResultUtils;
import fun.yozora.arcana.model.entity.User;
import fun.yozora.arcana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户 控制层。
 *
 * @author <a href="https://github.com/YozoraTempest">YozoraTempest</a>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 保存用户。
     *
     * @param userBo 用户
     */
    @PostMapping()
    public BaseResponse save(UserBo userBo) {
        return ResultUtils.ok(userService.insertByBo(userBo));
    }

    /**
     * 根据主键删除用户。
     *
     * @param ids 主键列表
     */
    @DeleteMapping("/{ids}")
    public BaseResponse remove(@PathVariable("ids") Long[] ids) {
        return ResultUtils.ok(userService.deleteWithValidByIds(List.of(ids), true));
    }

    /**
     * 根据主键更新用户。
     *
     * @param userBo 用户
     */
    @PutMapping()
    public BaseResponse update(UserBo userBo) {
        return ResultUtils.ok(userService.updateByBo(userBo));
    }

    /**
     * 查询所有用户。
     *
     * @param userBo 查询条件
     * @return 所有数据
     */
    @GetMapping("/list")
    public List<User> list(UserBo userBo) {
        return userService.queryList(userBo);
    }

    /**
     * 根据主键获取用户。
     *
     * @param id 用户主键
     * @return 用户详情
     */
    @GetMapping("/{id}")
    public User getInfo(@PathVariable Long id) {
        return userService.queryById(id);
    }

    /**
     * 分页查询用户。
     *
     * @param userBo      查询条件
     * @param pageRequest 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public Page<User> page(UserBo userBo, PageRequest pageRequest) {
        return userService.queryPageList(userBo, pageRequest);
    }

}
