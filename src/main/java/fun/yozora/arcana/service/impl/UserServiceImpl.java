package fun.yozora.arcana.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import fun.yozora.arcana.bo.UserBo;
import fun.yozora.arcana.common.PageRequest;
import fun.yozora.arcana.mapper.UserMapper;
import fun.yozora.arcana.model.entity.User;
import fun.yozora.arcana.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 用户 服务层实现。
 *
 * @author <a href="https://github.com/YozoraTempest">YozoraTempest</a>
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Boolean insertByBo(UserBo userBo) {
        User add = objectMapper.convertValue(userBo, User.class);
        validEntityBeforeSave(add);
        boolean b = this.save(add);
        if (b) {
            userBo.setId(add.getId());
            log.info("新增用户成功，账号：{}", userBo.getUserAccount());
        } else {
            log.error("新增用户失败，账号：{}", userBo.getUserAccount());
        }
        return b;
    }

    @Override
    public Boolean updateByBo(UserBo userBo) {
        User add = objectMapper.convertValue(userBo, User.class);
        validEntityBeforeSave(add);
        boolean b = this.updateById(add);
        if (b) {
            userBo.setId(add.getId());
            log.info("更新用户成功，账号：{}", userBo.getUserAccount());
        } else {
            log.error("更新用户失败，账号：{}", userBo.getUserAccount());
        }
        return b;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if (isValid) {
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return this.removeByIds(ids);
    }

    @Override
    public User queryById(Long id) {
        return this.getById(id);
    }

    @Override
    public List<User> queryList(UserBo userBo) {
        QueryWrapper queryWrapper = buildQueryWrapper(userBo);
        return this.list(queryWrapper);
    }

    @Override
    public Page<User> queryPageList(UserBo userBo, PageRequest pageRequest) {
        QueryWrapper queryWrapper = buildQueryWrapper(userBo);
        return this.page(pageRequest.build(), queryWrapper);
    }

    private QueryWrapper buildQueryWrapper(UserBo userBo) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like(User::getUserAccount, userBo.getUserAccount(), StringUtils.isNotBlank(userBo.getUserAccount()));
        queryWrapper.like(User::getUserName, userBo.getUserName(), StringUtils.isNotBlank(userBo.getUserName()));
        queryWrapper.eq(User::getUserRole, userBo.getUserRole(), StringUtils.isNotBlank(userBo.getUserRole()));
        return queryWrapper;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(User entity) {
        //TODO 做一些数据校验,如唯一约束
    }

}
