package cn.losemen.ucenter.service;

import cn.losemen.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-04
 */
public interface MemberService extends IService<Member> {
    Integer countRegisterByDay(String day);

}
