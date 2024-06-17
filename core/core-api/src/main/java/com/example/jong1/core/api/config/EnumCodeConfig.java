package com.example.jong1.core.api.config;

import com.example.jong1.core.enums.common.DataStatus;
import com.example.jong1.core.enums.common.EnumMapper;
import com.example.jong1.core.enums.payments.CommissionCutting;
import com.example.jong1.core.enums.payments.CommissionType;
import com.example.jong1.core.enums.payments.PayGroup;
import com.example.jong1.core.enums.payments.PayType;
import com.example.jong1.core.enums.user.OAuthType;
import com.example.jong1.core.enums.user.SubscriptionStatus;
import com.example.jong1.core.enums.user.UserAccountType;
import com.example.jong1.core.enums.user.UserActiveStatus;
import com.example.jong1.core.enums.user.UserApprovalStatus;
import com.example.jong1.core.enums.user.UserLockStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EnumCodeConfig {

    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();

        enumMapper.put(DataStatus.class);

        enumMapper.put(CommissionCutting.class);
        enumMapper.put(CommissionType.class);
        enumMapper.put(PayGroup.class);
        enumMapper.put(PayType.class);

        enumMapper.put(OAuthType.class);
        enumMapper.put(SubscriptionStatus.class);
        enumMapper.put(UserAccountType.class);
        enumMapper.put(UserActiveStatus.class);
        enumMapper.put(UserApprovalStatus.class);
        enumMapper.put(UserLockStatus.class);

        return enumMapper;
    }
}
